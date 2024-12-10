package ca.griis.mmec.test.unit.api;

import ca.griis.mmec.api.MMecFacadeServiceBase;
import ca.griis.mmec.controller.ontop.OntoRelTableMappingController;
import ca.griis.mmec.model.mapped.MappedClassTable;
import ca.griis.mmec.model.mapped.MappedDataPropertyTable;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTable;
import ca.griis.mmec.model.ontorel.ClassTable;
import ca.griis.mmec.model.ontorel.DataPropertyTable;
import ca.griis.mmec.model.ontorel.ObjectPropertyTable;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.repository.OntoRelCatRepository;
import ca.griis.mmec.repository.ProjectInfoRepository;
import ca.griis.mmec.view.MappedOntoRelTableView;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.google.inject.Injector;
import it.unibz.inf.ontop.answering.OntopQueryEngine;
import it.unibz.inf.ontop.answering.connection.OntopConnection;
import it.unibz.inf.ontop.exception.OBDASpecificationException;
import it.unibz.inf.ontop.exception.OntopConnectionException;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.injection.impl.MMecConfiguration;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.slf4j.LoggerFactory;

public class MMecFacadeServiceBaseTest {

  private MMecConfiguration mMecConfiguration;
  private MappingProperties mappingProperties;
  private MappedOntoRelTableView mappedOntoRelTableView;
  private OntoRelTableMappingController ontoRelTableMappingController;
  private OntoRelCatRepository ontoRelCatRepository;
  private ProjectInfoRepository projectInfoRepository;
  private OntopQueryEngine ontopQueryEngine;
  private OntopConnection connection;
  private ListAppender<ILoggingEvent> loggerListAppender;

  @BeforeEach
  public void setup() {
    mMecConfiguration = Mockito.mock(MMecConfiguration.class);
    mappingProperties = Mockito.mock(MappingProperties.class);
    mappedOntoRelTableView = Mockito.mock(MappedOntoRelTableView.class);
    ontoRelTableMappingController = Mockito.mock(OntoRelTableMappingController.class);
    ontoRelCatRepository = Mockito.mock(OntoRelCatRepository.class);
    projectInfoRepository = Mockito.mock(ProjectInfoRepository.class);
    ontopQueryEngine = Mockito.mock(OntopQueryEngine.class);
    connection = Mockito.mock(OntopConnection.class);

    Injector injector = Mockito.mock(Injector.class);
    Mockito.when(mMecConfiguration.getInjector()).thenReturn(injector);
    Mockito.when(injector.getInstance(MappedOntoRelTableView.class))
        .thenReturn(mappedOntoRelTableView);
    Mockito.when(injector.getInstance(OntoRelTableMappingController.class))
        .thenReturn(ontoRelTableMappingController);
    Mockito.when(injector.getInstance(OntoRelCatRepository.class)).thenReturn(ontoRelCatRepository);
    Mockito.when(injector.getInstance(ProjectInfoRepository.class))
        .thenReturn(projectInfoRepository);
    Mockito.when(mMecConfiguration.getMappingProperties()).thenReturn(mappingProperties);

    loggerListAppender = new ListAppender<>();
    loggerListAppender.start();
    Logger griisLogger = (Logger) LoggerFactory.getLogger(MMecFacadeServiceBase.class);
    griisLogger.addAppender(loggerListAppender);
    griisLogger.setLevel(Level.TRACE);
  }

  @Test
  public void createFacadeCannotLoadInfoRepositoryTest() throws Exception {
    IOException ioException = new IOException("Cannot load info repository");

    Mockito.doThrow(ioException).when(projectInfoRepository).loadInfoRepository();
    Mockito.when(mMecConfiguration.loadQueryEngine()).thenReturn(ontopQueryEngine);
    Mockito.when(ontopQueryEngine.getConnection()).thenReturn(connection);
    Mockito.when(ontoRelCatRepository.getClassTables(Mockito.any())).thenReturn(List.of());
    Mockito.when(ontoRelCatRepository.getObjectPropertyTables(Mockito.any())).thenReturn(List.of());
    Mockito.when(ontoRelCatRepository.getDataPropertyTables(Mockito.any())).thenReturn(List.of());

    MMecFacadeServiceBase mmecFacadeServiceBase = new MMecFacadeServiceBase();
    mmecFacadeServiceBase.createFacade(mMecConfiguration);

    Assertions.assertTrue(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage().contains("Error loading project info repository")));
    Assertions.assertTrue(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage()
            .contains("Creating facade with an unknown version of mMec")));
  }

  @Test
  public void createFacadeUnknownMMecVersionTest() throws Exception {
    Mockito.when(projectInfoRepository.getVersion()).thenReturn(Optional.empty());
    Mockito.when(mMecConfiguration.loadQueryEngine()).thenReturn(ontopQueryEngine);
    Mockito.when(ontopQueryEngine.getConnection()).thenReturn(connection);
    Mockito.when(ontoRelCatRepository.getClassTables(Mockito.any())).thenReturn(List.of());
    Mockito.when(ontoRelCatRepository.getObjectPropertyTables(Mockito.any())).thenReturn(List.of());
    Mockito.when(ontoRelCatRepository.getDataPropertyTables(Mockito.any())).thenReturn(List.of());

    MMecFacadeServiceBase mmecFacadeServiceBase = new MMecFacadeServiceBase();
    mmecFacadeServiceBase.createFacade(mMecConfiguration);

    Assertions.assertFalse(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage().contains("Error loading project info repository")));
    Assertions.assertTrue(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage()
            .contains("Creating facade with an unknown version of mMec")));
  }

  @Test
  public void createFacadeCannotLoadQueryEngineThrowsTest() throws Exception {
    OBDASpecificationException ontopConnectionException =
        new OBDASpecificationExceptionT("Cannot load query engine");

    Mockito.when(projectInfoRepository.getVersion()).thenReturn(Optional.of("1.0"));
    Mockito.when(mMecConfiguration.loadQueryEngine()).thenThrow(ontopConnectionException);

    MMecFacadeServiceBase mmecFacadeServiceBase = new MMecFacadeServiceBase();
    Assertions.assertThrows(OBDASpecificationException.class,
        () -> mmecFacadeServiceBase.createFacade(mMecConfiguration));

    Assertions.assertTrue(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage()
            .contains("Creating facade using mMec version 1.0")));
  }

  @Test
  public void createFacadeCannotConnectToOntopThrowsTest() throws Exception {
    OntopConnectionException ontopConnectionException =
        new OntopConnectionException("Cannot connect to ontop");

    Mockito.when(projectInfoRepository.getVersion()).thenReturn(Optional.of("1.0"));
    Mockito.when(mMecConfiguration.loadQueryEngine()).thenReturn(ontopQueryEngine);
    Mockito.when(ontopQueryEngine.getConnection()).thenThrow(ontopConnectionException);

    MMecFacadeServiceBase mmecFacadeServiceBase = new MMecFacadeServiceBase();
    Assertions.assertThrows(OntopConnectionException.class,
        () -> mmecFacadeServiceBase.createFacade(mMecConfiguration));

    Assertions.assertTrue(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage()
            .contains("Creating facade using mMec version 1.0")));
  }

  private static Stream<Arguments> ontopExceptionProvider() {
    return Stream.of(Arguments.of(new OntopConnectionException("Cannot connect to ontop")),
        Arguments.of(new OntopReformulationException(new Exception("Cannot reformulate ontop"))));
  }

  @ParameterizedTest
  @MethodSource("ontopExceptionProvider")
  public void createFacadeClassTableOntopExceptionShouldThrowTest(Exception ontopException)
      throws Exception {
    ClassTable classTable = Mockito.mock(ClassTable.class);

    Mockito.when(projectInfoRepository.getVersion()).thenReturn(Optional.of("1.0"));
    Mockito.when(mMecConfiguration.loadQueryEngine()).thenReturn(ontopQueryEngine);
    Mockito.when(ontopQueryEngine.getConnection()).thenReturn(connection);
    Mockito.when(ontoRelCatRepository.getClassTables(Mockito.any()))
        .thenReturn(List.of(classTable));
    Mockito.when(ontoRelTableMappingController.map(connection, classTable))
        .thenThrow(ontopException);
    MMecFacadeServiceBase mmecFacadeServiceBase = new MMecFacadeServiceBase();
    Assertions.assertThrows(ontopException.getClass(),
        () -> mmecFacadeServiceBase.createFacade(mMecConfiguration));

    Assertions.assertTrue(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage()
            .contains("Creating facade using mMec version 1.0")));
  }

  @ParameterizedTest
  @MethodSource("ontopExceptionProvider")
  public void createFacadeOpTableOntopExceptionShouldThrowTest(Exception ontopException)
      throws Exception {
    ObjectPropertyTable opTable = Mockito.mock(ObjectPropertyTable.class);

    Mockito.when(projectInfoRepository.getVersion()).thenReturn(Optional.of("1.0"));
    Mockito.when(mMecConfiguration.loadQueryEngine()).thenReturn(ontopQueryEngine);
    Mockito.when(ontopQueryEngine.getConnection()).thenReturn(connection);
    Mockito.when(ontoRelCatRepository.getClassTables(Mockito.any()))
        .thenReturn(List.of());
    Mockito.when(ontoRelCatRepository.getObjectPropertyTables(Mockito.any()))
        .thenReturn(List.of(opTable));
    Mockito.when(ontoRelTableMappingController.map(connection, opTable))
        .thenThrow(ontopException);
    MMecFacadeServiceBase mmecFacadeServiceBase = new MMecFacadeServiceBase();
    Assertions.assertThrows(ontopException.getClass(),
        () -> mmecFacadeServiceBase.createFacade(mMecConfiguration));

    Assertions.assertTrue(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage()
            .contains("Creating facade using mMec version 1.0")));
  }

  @ParameterizedTest
  @MethodSource("ontopExceptionProvider")
  public void createFacadeDpTableOntopExceptionShouldThrowTest(Exception ontopException)
      throws Exception {
    DataPropertyTable dpTable = Mockito.mock(DataPropertyTable.class);

    Mockito.when(projectInfoRepository.getVersion()).thenReturn(Optional.of("1.0"));
    Mockito.when(mMecConfiguration.loadQueryEngine()).thenReturn(ontopQueryEngine);
    Mockito.when(ontopQueryEngine.getConnection()).thenReturn(connection);
    Mockito.when(ontoRelCatRepository.getClassTables(Mockito.any()))
        .thenReturn(List.of());
    Mockito.when(ontoRelCatRepository.getObjectPropertyTables(Mockito.any()))
        .thenReturn(List.of());
    Mockito.when(ontoRelCatRepository.getDataPropertyTables(Mockito.any()))
        .thenReturn(List.of(dpTable));
    Mockito.when(ontoRelTableMappingController.map(connection, dpTable))
        .thenThrow(ontopException);

    MMecFacadeServiceBase mmecFacadeServiceBase = new MMecFacadeServiceBase();
    Assertions.assertThrows(ontopException.getClass(),
        () -> mmecFacadeServiceBase.createFacade(mMecConfiguration));

    Assertions.assertTrue(loggerListAppender.list.stream().anyMatch(
        event -> event.getFormattedMessage()
            .contains("Creating facade using mMec version 1.0")));
  }

  @Test
  public void createFacadeSuccessTest() throws Exception {
    String classTableId = "createFacadeSuccessTestClassTable";
    String opTableId = "createFacadeSuccessTestOpTable";
    String dpTableId = "createFacadeSuccessTestDataPropertyTable";

    ClassTable classTable = Mockito.mock(ClassTable.class);
    ObjectPropertyTable opTable = Mockito.mock(ObjectPropertyTable.class);
    DataPropertyTable dpTable = Mockito.mock(DataPropertyTable.class);
    MappedClassTable mappedClassTable = Mockito.mock(MappedClassTable.class);
    MappedObjectPropertyTable mappedOpTable = Mockito.mock(MappedObjectPropertyTable.class);
    MappedDataPropertyTable mappedDpTable = Mockito.mock(MappedDataPropertyTable.class);

    Mockito.when(projectInfoRepository.getVersion()).thenReturn(Optional.of("1.0"));
    Mockito.when(mMecConfiguration.loadQueryEngine()).thenReturn(ontopQueryEngine);
    Mockito.when(ontopQueryEngine.getConnection()).thenReturn(connection);
    Mockito.when(ontoRelCatRepository.getClassTables(Mockito.any()))
        .thenReturn(List.of(classTable));
    Mockito.when(ontoRelCatRepository.getObjectPropertyTables(Mockito.any()))
        .thenReturn(List.of(opTable));
    Mockito.when(ontoRelCatRepository.getDataPropertyTables(Mockito.any()))
        .thenReturn(List.of(dpTable));
    Mockito.when(ontoRelTableMappingController.map(connection, classTable))
        .thenReturn(mappedClassTable);
    Mockito.when(ontoRelTableMappingController.map(connection, opTable))
        .thenReturn(mappedOpTable);
    Mockito.when(ontoRelTableMappingController.map(connection, dpTable))
        .thenReturn(mappedDpTable);
    Mockito.when(mappedOntoRelTableView.getExpression(mappedClassTable))
        .thenReturn(classTableId);
    Mockito.when(mappedOntoRelTableView.getExpression(mappedOpTable))
        .thenReturn(opTableId);
    Mockito.when(mappedOntoRelTableView.getExpression(mappedDpTable))
        .thenReturn(dpTableId);

    MMecFacadeServiceBase mmecFacadeServiceBase = new MMecFacadeServiceBase();
    String facade = mmecFacadeServiceBase.createFacade(mMecConfiguration);

    Assertions.assertTrue(facade.contains(classTableId));
    Assertions.assertTrue(facade.contains(opTableId));
    Assertions.assertTrue(facade.contains(dpTableId));
  }

  private static class OBDASpecificationExceptionT extends OBDASpecificationException {
    public OBDASpecificationExceptionT(String message) {
      super(message);
    }
  }
}

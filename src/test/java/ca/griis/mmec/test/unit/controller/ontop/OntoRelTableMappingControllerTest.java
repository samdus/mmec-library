package ca.griis.mmec.test.unit.controller.ontop;

import ca.griis.mmec.controller.ontop.OntoRelTableMappingController;
import ca.griis.mmec.model.mapped.*;
import ca.griis.mmec.model.ontorel.*;
import ca.griis.mmec.properties.MappingProperties;
import com.google.common.collect.ImmutableMultimap;
import it.unibz.inf.ontop.answering.connection.OntopConnection;
import it.unibz.inf.ontop.answering.connection.OntopStatement;
import it.unibz.inf.ontop.exception.OntopConnectionException;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.node.NativeNode;
import it.unibz.inf.ontop.query.RDF4JQueryFactory;
import it.unibz.inf.ontop.query.RDF4JSelectQuery;
import java.util.Optional;
import org.eclipse.rdf4j.query.impl.MapBindingSet;
import org.eclipse.rdf4j.query.parser.ParsedTupleQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class OntoRelTableMappingControllerTest {
  private MappingProperties mappingProperties;
  private RDF4JQueryFactory factrdf4JQueryFactory;
  private OntopConnection connection;

  @BeforeEach
  public void setUp() {
    mappingProperties = Mockito.mock(MappingProperties.class);
    factrdf4JQueryFactory = Mockito.mock(RDF4JQueryFactory.class);
    connection = Mockito.mock(OntopConnection.class);
  }

  @Test
  public void mapClassTableOntopConnectionExceptionTest() throws Exception {
    OntopConnectionException ontopConnectionException = new OntopConnectionException("Test");
    ClassTable classTable = Mockito.mock(ClassTable.class);
    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);

    Mockito.when(connection.createStatement()).thenThrow(ontopConnectionException);

    Assertions.assertThrows(OntopConnectionException.class, () -> {
      ontoRelTableMappingController.map(connection, classTable);
    });
  }

  @Test
  public void mapClassTableOntopReformulationExceptionTest() throws Exception {
    OntopReformulationException ontopReformulationException =
        new OntopReformulationException(new Exception());
    ClassTable classTable = Mockito.mock(ClassTable.class);
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenThrow(ontopReformulationException);
    Mockito.when(classTable.iri()).thenReturn("http://test.com/iri");

    Assertions.assertThrows(OntopReformulationException.class, () -> {
      ontoRelTableMappingController.map(connection, classTable);
    });
  }

  @Test
  public void mapClassTableEmptyTest() throws Exception {
    OntopReformulationException ontopReformulationException =
        new OntopReformulationException(new Exception("IQ: EMPTY"));
    ClassTable classTable = new ClassTableRecord("test_table", "test_label", "http://test.com/iri",
        "test_column_id", "test_column_type");
    MappedClassTable expected =
        new MappedClassTableRecord(classTable, "schema", Optional.empty(),
            classTable.ontorelColumnId());
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenThrow(ontopReformulationException);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedClassTable actual = ontoRelTableMappingController.map(connection, classTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue().toString(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(parsedTupleQueryArgumentCaptor.getValue().toString(),
        """
            QueryRoot
               StatementPattern
                  Var (name=test_column_id)
                  Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                  Var (name=uid_uri, value=http://test.com/iri, anonymous)
            """);
  }

  @Test
  public void mapClassTableNotNativeShouldReturnEmptyTest() throws Exception {
    ClassTable classTable = new ClassTableRecord("test_table", "test_label", "http://test.com/iri",
        "test_column_id", "test_column_type");
    MappedClassTable expected =
        new MappedClassTableRecord(classTable, "schema", Optional.empty(),
            classTable.ontorelColumnId());
    IQ executableQuery = Mockito.mock(IQ.class);
    IQTree executableQueryTree = Mockito.mock(IQTree.class);
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenReturn(executableQuery);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());
    Mockito.when(executableQuery.getTree()).thenReturn(executableQueryTree);

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedClassTable actual = ontoRelTableMappingController.map(connection, classTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(
        """
            QueryRoot
               StatementPattern
                  Var (name=test_column_id)
                  Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                  Var (name=uid_uri, value=http://test.com/iri, anonymous)
            """,
        parsedTupleQueryArgumentCaptor.getValue().toString());
  }

  @Test
  public void mapClassTableTest() throws Exception {
    ClassTable classTable = new ClassTableRecord("test_table", "test_label", "http://test.com/iri",
        "test_column_id", "test_column_type");
    String executableQueryString = "executableQueryString";
    MappedClassTable expected =
        new MappedClassTableRecord(classTable, "schema", Optional.of(executableQueryString),
            classTable.ontorelColumnId());
    IQ executableQuery = Mockito.mock(IQ.class);
    NativeNode executableQueryTree = Mockito.mock(NativeNode.class);
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenReturn(executableQuery);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());
    Mockito.when(executableQuery.getTree()).thenReturn(executableQueryTree);
    Mockito.when(executableQueryTree.getNativeQueryString()).thenReturn(executableQueryString);

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedClassTable actual = ontoRelTableMappingController.map(connection, classTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(
        """
            QueryRoot
               StatementPattern
                  Var (name=test_column_id)
                  Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                  Var (name=uid_uri, value=http://test.com/iri, anonymous)
            """,
        parsedTupleQueryArgumentCaptor.getValue().toString());
  }

  @Test
  public void mapDpTableOntopConnectionExceptionTest() throws Exception {
    OntopConnectionException ontopConnectionException = new OntopConnectionException("Test");
    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);

    Mockito.when(connection.createStatement()).thenThrow(ontopConnectionException);

    Assertions.assertThrows(OntopConnectionException.class, () -> {
      ontoRelTableMappingController.map(connection, Mockito.mock(DataPropertyTable.class));
    });
  }

  @Test
  public void mapDpTableOntopReformulationExceptionTest() throws Exception {
    OntopReformulationException ontopReformulationException =
        new OntopReformulationException(new Exception());
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);
    DataPropertyTable dataPropertyTable = new DataPropertyTableRecord("test_table", "test_label",
        "http://test.com/iri", "http://test.com/iripredicate", "http://test.com/irivalue",
        "ontorel_subject_column_id", "ontorel_subject_column_type",
        "ontorel_value_column_id", "ontorel_value_column_type");

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenThrow(ontopReformulationException);

    Assertions.assertThrows(OntopReformulationException.class, () -> {
      ontoRelTableMappingController.map(connection, dataPropertyTable);
    });
  }

  @Test
  public void mapDpTableEmptyTest() throws Exception {
    OntopReformulationException ontopReformulationException =
        new OntopReformulationException(new Exception("IQ: EMPTY"));
    DataPropertyTable dataPropertyTable = new DataPropertyTableRecord("test_table", "test_label",
        "http://test.com/iri", "http://test.com/iripredicate", "http://test.com/irivalue",
        "ontorel_subject_column_id", "ontorel_subject_column_type",
        "ontorel_value_column_id", "ontorel_value_column_type");
    MappedDataPropertyTable expected =
        new MappedDataPropertyTableRecord(dataPropertyTable, "schema", Optional.empty(),
            dataPropertyTable.ontorelSubjectColumnId(), dataPropertyTable.ontorelValueColumnId());
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenThrow(ontopReformulationException);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedDataPropertyTable actual =
        ontoRelTableMappingController.map(connection, dataPropertyTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(
        """
            QueryRoot
               Projection
                  ProjectionElemList
                     ProjectionElem "ontorel_subject_column_id"
                     ProjectionElem "ontorel_value_column_id"
                  Filter
                     Compare (=)
                        Datatype
                           Var (name=ontorel_value_column_id)
                        ValueConstant (value=http://test.com/irivalue)
                     Join
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=sub_uri, value=http://test.com/iri, anonymous)
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=dp_uri, value=http://test.com/iripredicate, anonymous)
                           Var (name=ontorel_value_column_id)
            """,
        parsedTupleQueryArgumentCaptor.getValue().toString());
  }

  @Test
  public void mapDpTableNotNativeShouldReturnEmptyTest() throws Exception {
    DataPropertyTable dataPropertyTable = new DataPropertyTableRecord("test_table", "test_label",
        "http://test.com/iri", "http://test.com/iripredicate", "http://test.com/irivalue",
        "ontorel_subject_column_id", "ontorel_subject_column_type",
        "ontorel_value_column_id", "ontorel_value_column_type");
    MappedDataPropertyTable expected =
        new MappedDataPropertyTableRecord(dataPropertyTable, "schema", Optional.empty(),
            dataPropertyTable.ontorelSubjectColumnId(), dataPropertyTable.ontorelValueColumnId());
    IQ executableQuery = Mockito.mock(IQ.class);
    IQTree executableQueryTree = Mockito.mock(IQTree.class);
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenReturn(executableQuery);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());
    Mockito.when(executableQuery.getTree()).thenReturn(executableQueryTree);

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedDataPropertyTable actual =
        ontoRelTableMappingController.map(connection, dataPropertyTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(
        """
            QueryRoot
               Projection
                  ProjectionElemList
                     ProjectionElem "ontorel_subject_column_id"
                     ProjectionElem "ontorel_value_column_id"
                  Filter
                     Compare (=)
                        Datatype
                           Var (name=ontorel_value_column_id)
                        ValueConstant (value=http://test.com/irivalue)
                     Join
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=sub_uri, value=http://test.com/iri, anonymous)
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=dp_uri, value=http://test.com/iripredicate, anonymous)
                           Var (name=ontorel_value_column_id)
            """,
        parsedTupleQueryArgumentCaptor.getValue().toString());
  }

  @Test
  public void mapDpTableTest() throws Exception {
    DataPropertyTable dataPropertyTable = new DataPropertyTableRecord("test_table", "test_label",
        "http://test.com/iri", "http://test.com/iripredicate", "http://test.com/irivalue",
        "ontorel_subject_column_id", "ontorel_subject_column_type",
        "ontorel_value_column_id", "ontorel_value_column_type");
    String executableQueryString = "executableQueryString";
    MappedDataPropertyTable expected =
        new MappedDataPropertyTableRecord(dataPropertyTable, "schema",
            Optional.of(executableQueryString),
            dataPropertyTable.ontorelSubjectColumnId(), dataPropertyTable.ontorelValueColumnId());
    IQ executableQuery = Mockito.mock(IQ.class);
    NativeNode executableQueryTree = Mockito.mock(NativeNode.class);
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenReturn(executableQuery);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());
    Mockito.when(executableQuery.getTree()).thenReturn(executableQueryTree);
    Mockito.when(executableQueryTree.getNativeQueryString()).thenReturn(executableQueryString);

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedDataPropertyTable actual =
        ontoRelTableMappingController.map(connection, dataPropertyTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(
        """
            QueryRoot
               Projection
                  ProjectionElemList
                     ProjectionElem "ontorel_subject_column_id"
                     ProjectionElem "ontorel_value_column_id"
                  Filter
                     Compare (=)
                        Datatype
                           Var (name=ontorel_value_column_id)
                        ValueConstant (value=http://test.com/irivalue)
                     Join
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=sub_uri, value=http://test.com/iri, anonymous)
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=dp_uri, value=http://test.com/iripredicate, anonymous)
                           Var (name=ontorel_value_column_id)
            """,
        parsedTupleQueryArgumentCaptor.getValue().toString());
  }

  @Test
  public void mapOpTableOntopConnectionExceptionTest() throws Exception {
    OntopConnectionException ontopConnectionException = new OntopConnectionException("Test");
    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);

    Mockito.when(connection.createStatement()).thenThrow(ontopConnectionException);

    Assertions.assertThrows(OntopConnectionException.class, () -> {
      ontoRelTableMappingController.map(connection, Mockito.mock(ObjectPropertyTable.class));
    });
  }

  @Test
  public void mapOpTableOntopReformulationExceptionTest() throws Exception {
    OntopReformulationException ontopReformulationException =
        new OntopReformulationException(new Exception());
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);
    ObjectPropertyTable objectPropertyTable = new ObjectPropertyTableRecord("test_table",
        "test_label", "http://test.com/iri", "http://test.com/iripredicate",
        "http://test.com/irivalue", "ontorel_subject_column_id",
        "ontorel_subject_column_type", "ontorel_value_column_id",
        "ontorel_value_column_type");

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenThrow(ontopReformulationException);

    Assertions.assertThrows(OntopReformulationException.class, () -> {
      ontoRelTableMappingController.map(connection, objectPropertyTable);
    });
  }

  @Test
  public void mapOpTableEmptyTest() throws Exception {
    OntopReformulationException ontopReformulationException =
        new OntopReformulationException(new Exception("IQ: EMPTY"));
    ObjectPropertyTable objectPropertyTable = new ObjectPropertyTableRecord("test_table",
        "test_label", "http://test.com/iri", "http://test.com/iripredicate",
        "http://test.com/irivalue", "ontorel_subject_column_id",
        "ontorel_subject_column_type", "ontorel_value_column_id",
        "ontorel_value_column_type");
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);
    MappedObjectPropertyTable expected =
        new MappedObjectPropertyTableRecord(objectPropertyTable, "schema", Optional.empty(),
            objectPropertyTable.ontorelSubjectColumnId(),
            objectPropertyTable.ontorelObjectColumnId());

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenThrow(ontopReformulationException);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedObjectPropertyTable actual =
        ontoRelTableMappingController.map(connection, objectPropertyTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(
        """
            QueryRoot
               Projection
                  ProjectionElemList
                     ProjectionElem "ontorel_subject_column_id"
                     ProjectionElem "ontorel_value_column_id"
                  Join
                     Join
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=sub_uri, value=http://test.com/iri, anonymous)
                        StatementPattern
                           Var (name=ontorel_value_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=obj_uri, value=http://test.com/irivalue, anonymous)
                     StatementPattern
                        Var (name=ontorel_subject_column_id)
                        Var (name=op_uri, value=http://test.com/iripredicate, anonymous)
                        Var (name=ontorel_value_column_id)
            """,
        parsedTupleQueryArgumentCaptor.getValue().toString());
  }

  @Test
  public void mapOpTableNotNativeShouldReturnEmptyTest() throws Exception {
    ObjectPropertyTable objectPropertyTable = new ObjectPropertyTableRecord("test_table",
        "test_label", "http://test.com/iri", "http://test.com/iripredicate",
        "http://test.com/irivalue", "ontorel_subject_column_id",
        "ontorel_subject_column_type", "ontorel_value_column_id",
        "ontorel_value_column_type");
    MappedObjectPropertyTable expected =
        new MappedObjectPropertyTableRecord(objectPropertyTable, "schema", Optional.empty(),
            objectPropertyTable.ontorelSubjectColumnId(),
            objectPropertyTable.ontorelObjectColumnId());
    IQ executableQuery = Mockito.mock(IQ.class);
    IQTree executableQueryTree = Mockito.mock(IQTree.class);
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenReturn(executableQuery);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());
    Mockito.when(executableQuery.getTree()).thenReturn(executableQueryTree);

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedObjectPropertyTable actual =
        ontoRelTableMappingController.map(connection, objectPropertyTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(
        """
            QueryRoot
               Projection
                  ProjectionElemList
                     ProjectionElem "ontorel_subject_column_id"
                     ProjectionElem "ontorel_value_column_id"
                  Join
                     Join
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=sub_uri, value=http://test.com/iri, anonymous)
                        StatementPattern
                           Var (name=ontorel_value_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=obj_uri, value=http://test.com/irivalue, anonymous)
                     StatementPattern
                        Var (name=ontorel_subject_column_id)
                        Var (name=op_uri, value=http://test.com/iripredicate, anonymous)
                        Var (name=ontorel_value_column_id)
            """,
        parsedTupleQueryArgumentCaptor.getValue().toString());
  }

  @Test
  public void mapOpTableTest() throws Exception {
    ObjectPropertyTable objectPropertyTable = new ObjectPropertyTableRecord("test_table",
        "test_label", "http://test.com/iri", "http://test.com/iripredicate",
        "http://test.com/irivalue", "ontorel_subject_column_id",
        "ontorel_subject_column_type", "ontorel_value_column_id",
        "ontorel_value_column_type");
    String executableQueryString = "executableQueryString";
    MappedObjectPropertyTable expected =
        new MappedObjectPropertyTableRecord(objectPropertyTable, "schema",
            Optional.of(executableQueryString),
            objectPropertyTable.ontorelSubjectColumnId(),
            objectPropertyTable.ontorelObjectColumnId());
    IQ executableQuery = Mockito.mock(IQ.class);
    NativeNode executableQueryTree = Mockito.mock(NativeNode.class);
    OntopStatement statement = Mockito.mock(OntopStatement.class);
    RDF4JSelectQuery rdf4JSelectQuery = Mockito.mock(RDF4JSelectQuery.class);

    ArgumentCaptor<String> queryRootArgumentCaptor = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ParsedTupleQuery> parsedTupleQueryArgumentCaptor =
        ArgumentCaptor.forClass(ParsedTupleQuery.class);
    ArgumentCaptor<MapBindingSet> mapBindingSetArgumentCaptor =
        ArgumentCaptor.forClass(MapBindingSet.class);

    Mockito.when(connection.createStatement()).thenReturn(statement);
    Mockito.when(
        factrdf4JQueryFactory.createSelectQuery(queryRootArgumentCaptor.capture(),
            parsedTupleQueryArgumentCaptor.capture(), mapBindingSetArgumentCaptor.capture()))
        .thenReturn(rdf4JSelectQuery);
    Mockito.when(statement.getExecutableQuery(rdf4JSelectQuery, ImmutableMultimap.of()))
        .thenReturn(executableQuery);
    Mockito.when(mappingProperties.getMappingSchema()).thenReturn(expected.schema());
    Mockito.when(executableQuery.getTree()).thenReturn(executableQueryTree);
    Mockito.when(executableQueryTree.getNativeQueryString()).thenReturn(executableQueryString);

    OntoRelTableMappingController ontoRelTableMappingController =
        new OntoRelTableMappingController(mappingProperties, factrdf4JQueryFactory);
    MappedObjectPropertyTable actual =
        ontoRelTableMappingController.map(connection, objectPropertyTable);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(queryRootArgumentCaptor.getValue(),
        parsedTupleQueryArgumentCaptor.getValue().toString());
    Assertions.assertEquals(
        """
            QueryRoot
               Projection
                  ProjectionElemList
                     ProjectionElem "ontorel_subject_column_id"
                     ProjectionElem "ontorel_value_column_id"
                  Join
                     Join
                        StatementPattern
                           Var (name=ontorel_subject_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=sub_uri, value=http://test.com/iri, anonymous)
                        StatementPattern
                           Var (name=ontorel_value_column_id)
                           Var (name=rdf_type_uri, value=http://www.w3.org/1999/02/22-rdf-syntax-ns#type, anonymous)
                           Var (name=obj_uri, value=http://test.com/irivalue, anonymous)
                     StatementPattern
                        Var (name=ontorel_subject_column_id)
                        Var (name=op_uri, value=http://test.com/iripredicate, anonymous)
                        Var (name=ontorel_value_column_id)
            """,
        parsedTupleQueryArgumentCaptor.getValue().toString());
  }
}

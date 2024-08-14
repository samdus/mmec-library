/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecFacadeServiceBase.
 * @brief @~english MMecFacadeServiceBase class implementation.
 */

package ca.griis.mmec.api;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.mmec.api.exception.ConnectionException;
import ca.griis.mmec.api.exception.DefaultOntopConfigurationNotFound;
import ca.griis.mmec.controller.ontop.OntoRelTableMappingController;
import ca.griis.mmec.model.mapped.MappedClassTable;
import ca.griis.mmec.model.mapped.MappedDataPropertyTable;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTable;
import ca.griis.mmec.model.ontorel.ClassTable;
import ca.griis.mmec.model.ontorel.DataPropertyTable;
import ca.griis.mmec.model.ontorel.ObjectPropertyTable;
import ca.griis.mmec.properties.ConnectionProperties;
import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.repository.OntoRelCatRepository;
import ca.griis.mmec.repository.ProjectInfoRepository;
import ca.griis.mmec.view.MappedOntoRelTableView;
import it.unibz.inf.ontop.answering.OntopQueryEngine;
import it.unibz.inf.ontop.answering.connection.OntopConnection;
import it.unibz.inf.ontop.exception.OBDASpecificationException;
import it.unibz.inf.ontop.exception.OntopConnectionException;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.injection.impl.MMecConfiguration;
import java.io.IOException;
import java.sql.SQLException;

public class MMecFacadeServiceBase implements MMecFacadeService {
  private static final GriisLogger logger = GriisLoggerFactory.getLogger(
      MMecFacadeServiceBase.class);

  @Override
  public String createFacade(ConnectionProperties connectionProperties,
      MappingProperties mappingProperties, FacadeProperties mmecFacadeProperties)
      throws DefaultOntopConfigurationNotFound, OntopConnectionException,
      OBDASpecificationException, OntopReformulationException, ConnectionException {

    MMecConfiguration configuration = buildMMecConfiguration(
        connectionProperties, mappingProperties, mmecFacadeProperties);

    MappedOntoRelTableView mappedOntoRelTableView = configuration.getInjector().getInstance(
        MappedOntoRelTableView.class);
    OntoRelTableMappingController ontoRelTableMappingController =
        configuration.getInjector().getInstance(
            OntoRelTableMappingController.class);
    OntoRelCatRepository ontoRelCatRepository = configuration.getInjector().getInstance(
        OntoRelCatRepository.class);
    ProjectInfoRepository projectInfoRepository = configuration.getInjector().getInstance(
        ProjectInfoRepository.class);

    if (projectInfoRepository.getVersion().isPresent()) {
      logger.warn("Creating facade using mMec version {}",
          projectInfoRepository.getVersion().get());
    } else {
      logger.warn("Creating facade with an unknown version of mMec");
    }

    try (OntopQueryEngine ontopQueryEngine = configuration.loadQueryEngine()) {
      ontopQueryEngine.connect();
      try (OntopConnection connection = ontopQueryEngine.getConnection()) {
        return getAllDefinitions(mappingProperties, ontoRelCatRepository,
            ontoRelTableMappingController, connection, mappedOntoRelTableView);
      }
    }
  }

  private static String getAllDefinitions(MappingProperties mappingProperties,
      OntoRelCatRepository ontoRelCatRepository,
      OntoRelTableMappingController ontoRelTableMappingController, OntopConnection connection,
      MappedOntoRelTableView mappedOntoRelTableView)
      throws OntopReformulationException, OntopConnectionException {
    StringBuilder builder = new StringBuilder();

    getClassesDefinition(mappingProperties, ontoRelCatRepository, ontoRelTableMappingController,
        connection, mappedOntoRelTableView, builder);

    getObjectPropertiesDefinition(mappingProperties, ontoRelCatRepository,
        ontoRelTableMappingController, connection,
        mappedOntoRelTableView, builder);

    getDataPropertiesDefinition(mappingProperties, ontoRelCatRepository,
        ontoRelTableMappingController, connection,
        mappedOntoRelTableView, builder);

    return builder.toString();
  }

  private static void getClassesDefinition(MappingProperties mappingProperties,
      OntoRelCatRepository ontoRelCatRepository,
      OntoRelTableMappingController ontoRelTableMappingController, OntopConnection connection,
      MappedOntoRelTableView mappedOntoRelTableView, StringBuilder builder)
      throws OntopReformulationException, OntopConnectionException {
    builder.append("-- ========================================================\n");
    builder.append("-- Classes\n");
    builder.append("-- ========================================================\n");

    for (ClassTable classTable : ontoRelCatRepository.getClassTables(
        mappingProperties.getOntoRelId())) {
      MappedClassTable mappedClassTable = ontoRelTableMappingController.map(connection, classTable);
      builder.append(mappedOntoRelTableView.getExpression(mappedClassTable));
      builder.append("\n");
    }
  }

  private static void getObjectPropertiesDefinition(MappingProperties mappingProperties,
      OntoRelCatRepository ontoRelCatRepository,
      OntoRelTableMappingController ontoRelTableMappingController, OntopConnection connection,
      MappedOntoRelTableView mappedOntoRelTableView, StringBuilder builder)
      throws OntopReformulationException, OntopConnectionException {
    builder.append("-- ========================================================\n");
    builder.append("-- ObjectProperties\n");
    builder.append("-- ========================================================\n");

    for (ObjectPropertyTable objectPropertyTable : ontoRelCatRepository.getObjectPropertyTables(
        mappingProperties.getOntoRelId())) {
      MappedObjectPropertyTable mappedObjectPropertyTable =
          ontoRelTableMappingController.map(connection, objectPropertyTable);
      builder.append(mappedOntoRelTableView.getExpression(mappedObjectPropertyTable));
      builder.append("\n");
    }
  }

  private static void getDataPropertiesDefinition(MappingProperties mappingProperties,
      OntoRelCatRepository ontoRelCatRepository,
      OntoRelTableMappingController ontoRelTableMappingController, OntopConnection connection,
      MappedOntoRelTableView mappedOntoRelTableView, StringBuilder builder)
      throws OntopReformulationException, OntopConnectionException {
    builder.append("-- ========================================================\n");
    builder.append("-- DataProperties\n");
    builder.append("-- ========================================================\n");

    for (DataPropertyTable dataPropertyTable : ontoRelCatRepository.getDataPropertyTables(
        mappingProperties.getOntoRelId())) {
      MappedDataPropertyTable mappedDataPropertyTable =
          ontoRelTableMappingController.map(connection, dataPropertyTable);
      builder.append(mappedOntoRelTableView.getExpression(mappedDataPropertyTable));
      builder.append("\n");
    }
  }

  private static MMecConfiguration buildMMecConfiguration(ConnectionProperties connectionProperties,
      MappingProperties mappingProperties, FacadeProperties mmecFacadeProperties)
      throws DefaultOntopConfigurationNotFound, ConnectionException {
    MMecConfiguration configuration;

    try {
      configuration = new MMecConfiguration.MMecConfigurationBuilder()
          .properties(connectionProperties.getPropertiesForOntop())
          .r2rmlMappingFile(mappingProperties.getR2rmlMappingFilePath())
          .ontologyFile(mappingProperties.getOntologyFilePath())
          .mappingProperties(mappingProperties)
          .facadeProperties(mmecFacadeProperties)
          .build();
    } catch (IOException e) {
      throw new DefaultOntopConfigurationNotFound(e);
    } catch (RuntimeException e) {
      if (e.getCause() instanceof SQLException sqlE) {
        throw new ConnectionException(sqlE);
      } else {
        throw e;
      }
    }
    return configuration;
  }
}

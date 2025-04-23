/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe MMecFacadeServiceBase.
 * @brief @~english MMecFacadeServiceBase class implementation.
 */

package ca.griis.mmec.api;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
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
import it.unibz.inf.ontop.answering.OntopQueryEngine;
import it.unibz.inf.ontop.answering.connection.OntopConnection;
import it.unibz.inf.ontop.exception.OBDASpecificationException;
import it.unibz.inf.ontop.exception.OntopConnectionException;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.injection.impl.MMecConfiguration;
import java.io.IOException;

public class MMecFacadeServiceBase implements MMecFacadeService {
  private static final GriisLogger logger = GriisLoggerFactory.getLogger(
      MMecFacadeServiceBase.class);

  @Override
  public String createFacade(MMecConfiguration configuration)
      throws OntopConnectionException, OBDASpecificationException, OntopReformulationException {
    logger.trace(Trace.ENTER_METHOD_1, configuration);

    MappedOntoRelTableView mappedOntoRelTableView = configuration.getInjector().getInstance(
        MappedOntoRelTableView.class);
    OntoRelTableMappingController ontoRelTableMappingController =
        configuration.getInjector().getInstance(
            OntoRelTableMappingController.class);
    OntoRelCatRepository ontoRelCatRepository = configuration.getInjector().getInstance(
        OntoRelCatRepository.class);
    ProjectInfoRepository projectInfoRepository = configuration.getInjector().getInstance(
        ProjectInfoRepository.class);

    logMMecVersion(projectInfoRepository);

    try (OntopQueryEngine ontopQueryEngine = configuration.loadQueryEngine()) {
      try (OntopConnection connection = ontopQueryEngine.getConnection()) {
        return getAllDefinitions(configuration.getMappingProperties(), ontoRelCatRepository,
            ontoRelTableMappingController, connection, mappedOntoRelTableView);
      }
    }
  }

  private static void logMMecVersion(ProjectInfoRepository projectInfoRepository) {
    try {
      projectInfoRepository.loadInfoRepository();
    } catch (IOException e) {
      logger.error("Error loading project info repository", e);
    }

    if (projectInfoRepository.getVersion().isPresent()) {
      logger.info("Creating facade using mMec version {}",
          projectInfoRepository.getVersion().get());
    } else {
      logger.info("Creating facade with an unknown version of mMec");
    }
  }

  private static String getAllDefinitions(MappingProperties mappingProperties,
      OntoRelCatRepository ontoRelCatRepository,
      OntoRelTableMappingController ontoRelTableMappingController, OntopConnection connection,
      MappedOntoRelTableView mappedOntoRelTableView)
      throws OntopReformulationException, OntopConnectionException {
    logger.trace(Trace.ENTER_METHOD_5, mappingProperties, ontoRelCatRepository,
        ontoRelTableMappingController, connection, mappedOntoRelTableView);
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
    logger.trace(Trace.ENTER_METHOD_5, mappingProperties, ontoRelCatRepository,
        ontoRelTableMappingController, connection, mappedOntoRelTableView);

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
    logger.trace(Trace.ENTER_METHOD_5, mappingProperties, ontoRelCatRepository,
        ontoRelTableMappingController, connection, mappedOntoRelTableView);
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

    logger.trace(Trace.EXIT_METHOD_0);
  }

  private static void getDataPropertiesDefinition(MappingProperties mappingProperties,
      OntoRelCatRepository ontoRelCatRepository,
      OntoRelTableMappingController ontoRelTableMappingController, OntopConnection connection,
      MappedOntoRelTableView mappedOntoRelTableView, StringBuilder builder)
      throws OntopReformulationException, OntopConnectionException {
    logger.trace(Trace.ENTER_METHOD_5, mappingProperties, ontoRelCatRepository,
        ontoRelTableMappingController, connection, mappedOntoRelTableView);

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

    logger.trace(Trace.EXIT_METHOD_0);
  }
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe OntoRelTableMappingControllerTest.
 * @brief @~english OntoRelTableMappingControllerTest class implementation.
 */

package ca.griis.mmec.test.integration.controller.ontop;

import ca.griis.mmec.controller.ontop.OntoRelTableMappingController;
import ca.griis.mmec.model.MappedOntoRelTable;
import ca.griis.mmec.model.mapped.MappedClassTable;
import ca.griis.mmec.model.mapped.MappedDataPropertyTable;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTable;
import ca.griis.mmec.model.ontorel.ClassTable;
import ca.griis.mmec.model.ontorel.ClassTableRecord;
import ca.griis.mmec.model.ontorel.DataPropertyTable;
import ca.griis.mmec.model.ontorel.DataPropertyTableRecord;
import ca.griis.mmec.model.ontorel.ObjectPropertyTable;
import ca.griis.mmec.model.ontorel.ObjectPropertyTableRecord;
import ca.griis.mmec.test.integration.util.OntopTester;
import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import it.unibz.inf.ontop.answering.OntopQueryEngine;
import it.unibz.inf.ontop.answering.connection.OntopConnection;
import it.unibz.inf.ontop.exception.OBDASpecificationException;
import it.unibz.inf.ontop.exception.OntopConnectionException;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.query.RDF4JQueryFactory;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OntoRelTableMappingControllerTest {
  private static OntopQueryEngine ontopQueryEngine;
  private static OntopConnection connection;
  private static final OntopTester ontopTester = new OntopTester(
      PostgresContainerWrapper.getInstance(),
      "coverage",
      Paths.get("src", "test", "resources", "testset", "coverage", "ontology.ttl").toFile(),
      Paths.get("src", "test", "resources", "testset", "coverage", "mapping.ttl").toFile());

  private OntoRelTableMappingController controller;

  @BeforeAll
  public static void init() throws OBDASpecificationException, OntopConnectionException {
    ontopQueryEngine = ontopTester.configuration.loadQueryEngine();
    ontopQueryEngine.connect();

    connection = ontopQueryEngine.getConnection();
  }

  @AfterAll
  public static void close() throws OntopConnectionException {
    if (connection != null && !connection.isClosed()) {
      connection.close();
    }

    if (ontopQueryEngine != null) {
      ontopQueryEngine.close();
    }
  }

  @BeforeEach
  public void setUp() {
    controller = new OntoRelTableMappingController(ontopTester.configuration.getMappingProperties(),
        ontopTester.configuration.getInjector().getInstance(RDF4JQueryFactory.class));
  }

  @Test
  public void testMapEmptyClassTable()
      throws OntopReformulationException, OntopConnectionException {
    ClassTable classTable = new ClassTableRecord("tableName", "label", "https://exemple.com#iri",
        "ontorelColumnId", "ontorelColumnType");
    MappedClassTable mappedClassTable = controller.map(connection, classTable);

    Assertions.assertTrue(mappedClassTable.mmecQuery().isEmpty(),
        String.format("Query %s is not empty", mappedClassTable.mmecQuery()));
  }

  @Test
  public void testMapEmptyDataPropertyTable()
      throws OntopReformulationException, OntopConnectionException {
    DataPropertyTable dpTable = new DataPropertyTableRecord("tableName", "label",
        "https://exemple.com#iriSubject", "https://exemple.com#iriPredicate",
        "https://exemple.com#iriValue", "subjectColumnId", "subjectColumnType", "valueColumnId",
        "valueColumnType");
    MappedDataPropertyTable mappedDataPropertyTable = controller.map(connection, dpTable);

    Assertions.assertTrue(mappedDataPropertyTable.mmecQuery().isEmpty(),
        String.format("Query %s is not empty", mappedDataPropertyTable.mmecQuery()));
  }

  @Test
  public void testMapEmptyObjectPropertyTable()
      throws OntopReformulationException, OntopConnectionException {
    ObjectPropertyTable dpTable = new ObjectPropertyTableRecord("tableName", "label",
        "https://exemple.com#iriSubject", "https://exemple.com#iriPredicate",
        "https://exemple.com#iriObject", "subjectColumnId", "subjectColumnType", "valueObjectId",
        "objectColumnType");
    MappedOntoRelTable mappedDataPropertyTable = controller.map(connection, dpTable);

    Assertions.assertTrue(mappedDataPropertyTable.mmecQuery().isEmpty(),
        String.format("Query %s is not empty", mappedDataPropertyTable.mmecQuery()));
  }

  @Test
  public void testMapClassTable() throws OntopReformulationException, OntopConnectionException {
    String expected =
        """
            SELECT DISTINCT individuation('http://www.griis.ca/projects#IAO_0020015/{}', v1."PRENOM") AS "uid"
            FROM "EXP"."PERSONNE" v1""";
    ClassTable classTable = new ClassTableRecord("IAO_0020015", "\"IAO_0020017\"@family name",
        "http://purl.obolibrary.org/obo/IAO_0020015", "uid", "\"BW\".\"uid_domain\"");
    MappedClassTable mappedClassTable = controller.map(connection, classTable);

    Assertions.assertFalse(mappedClassTable.mmecQuery().isEmpty(),
        String.format("MappedClassTable %s is empty", mappedClassTable));
    Assertions.assertEquals(expected, mappedClassTable.mmecQuery().get());
  }

  @Test
  public void testMapDataPropertyTable()
      throws OntopReformulationException, OntopConnectionException {
    // Note: Column order is not guaranteed, it is not an issue
    String expected =
        """
            SELECT DISTINCT CAST(v1."PRENOM" AS "BW"."string_domain") AS "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100", individuation('http://www.griis.ca/projects#IAO_0020015/{}', v1."PRENOM") AS "uid"
            FROM "EXP"."PERSONNE" v1""";
    DataPropertyTable dpTable = new DataPropertyTableRecord("IAO_0020017_PHYSIO_0000100_string",
        "\"IAO_0020015\"@personal name \"has value\"@PHYSIO_0000100 string",
        "http://purl.obolibrary.org/obo/IAO_0020015",
        "http://purl.obolibrary.org/obo/PHYSIO_0000100",
        "http://www.w3.org/2001/XMLSchema#string", "uid", "\"BW\".\"uid_domain\"",
        "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100",
        "\"BW\".\"string\"");
    MappedDataPropertyTable mappedDataPropertyTable = controller.map(connection, dpTable);

    Assertions.assertFalse(mappedDataPropertyTable.mmecQuery().isEmpty(),
        String.format("MappedDataPropertyTable %s is empty", mappedDataPropertyTable));
    // FIXME: Investiguer pourquoi est-ce que le type est converti en majuscule et retirer le lower
    Assertions.assertEquals(expected.toLowerCase(),
        mappedDataPropertyTable.mmecQuery().get().toLowerCase());
  }

  @Test
  public void testMapObjectPropertyTable()
      throws OntopReformulationException, OntopConnectionException {
    // Note: Column order is not guaranteed, it is not an issue
    String expected =
        """
            SELECT DISTINCT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v1."PRENOM", v1."NOM") AS "HBW_0000022_uid", individuation('http://www.griis.ca/projects#IAO_0020015/{}', v1."PRENOM") AS "IAO_0020015_uid"
            FROM "EXP"."PERSONNE" v1""";
    ObjectPropertyTable opTable = new ObjectPropertyTableRecord(
        "HBW_0000022_BFO_0000051_IAO_0020015",
        "\"HBW_0000022\"@human name BFO_0000051@'has part' \"IAO_0020015\"@personal name",
        "http://purl.obolibrary.org/obo/HBW_0000022",
        "http://purl.obolibrary.org/obo/BFO_0000051",
        "http://purl.obolibrary.org/obo/IAO_0020015", "HBW_0000022_uid", "\"BW\".\"uid_domain\"",
        "IAO_0020015_uid", "\"BW\".\"uid_domain\"");

    MappedObjectPropertyTable objectPropertyTable = controller.map(connection, opTable);

    Assertions.assertFalse(objectPropertyTable.mmecQuery().isEmpty(),
        String.format("MappedObjectPropertyTable %s is empty", objectPropertyTable));
    Assertions.assertEquals(expected, objectPropertyTable.mmecQuery().get());
  }
}

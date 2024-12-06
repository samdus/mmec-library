/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecParserRefSubjectMapExtensionTest.
 * @brief @~english MMecParserRefSubjectMapExtensionTest class implementation.
 */

package ca.griis.mmec.test.unit.controller.ontop.mapping.parser.extension.before;

import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before.MMecParserRefSubjectMapExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.*;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableMap;
import eu.optique.r2rml.api.model.R2RMLVocabulary;
import java.util.List;
import org.apache.commons.rdf.api.*;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.apache.commons.rdf.rdf4j.RDF4JBlankNode;
import org.apache.commons.rdf.rdf4j.RDF4JIRI;
import org.apache.commons.rdf.rdf4j.RDF4JLiteral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecParserRefSubjectMapExtensionTest {
  public static final String nsTypeIri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
  private final RDF4J rdf;
  private Graph testGraph;
  private MMecParserRefSubjectMapExtensionTestImpl mappingParser;

  public MMecParserRefSubjectMapExtensionTest() {
    rdf = new RDF4J();
  }

  @BeforeEach
  public void setUp() {
    testGraph = rdf.createGraph();
    mappingParser = new MMecParserRefSubjectMapExtensionTestImpl(rdf);
  }

  // Test de l'exception RefSubjectMapWithoutParentTriplesMapException

  @Test
  public void testRefSubjectMapWithoutParentTriplesMapException() {
    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    Assertions.assertThrows(RefSubjectMapWithoutParentTriplesMapException.class,
        () -> mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap));
  }

  @Test
  public void testSignatureWithoutSubjectMapException() {
    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);
    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    Assertions.assertThrows(SignatureWithoutSubjectMapException.class,
        () -> mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap));
  }

  @Test
  public void testParentSignatureWithoutLogicalTableException() {
    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");
    String childTable = "childTable";
    String parentColumn1 = "parentColumn1";
    String childColumn1 = "childColumn1";

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTable));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    Assertions.assertThrows(SignatureWithoutLogicalTableException.class,
        () -> mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap));
  }

  @Test
  public void testChildSignatureWithoutLogicalTableException() {
    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");
    String parentTable = "parentTable";
    String parentColumn1 = "parentColumn1";
    String childColumn1 = "childColumn1";

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTable));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    Assertions.assertThrows(SignatureWithoutLogicalTableException.class,
        () -> mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap));
  }

  @Test
  public void testParentLogicalTableWithoutSqlQueryNorTableNameException() {
    String childTable = "childTable";
    String parentColumn1 = "parentColumn1";
    String childColumn1 = "parentColumn1";

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTable));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    Assertions.assertThrows(LogicalTableWithoutSqlQueryNorTableNameException.class,
        () -> mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap));
  }

  @Test
  public void testChildLogicalTableWithoutSqlQueryNorTableNameException() {
    String parentTable = "parentTable";
    String parentColumn1 = "parentColumn1";
    String childColumn1 = "parentColumn1";

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTable));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    Assertions.assertThrows(LogicalTableWithoutSqlQueryNorTableNameException.class,
        () -> mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap));
  }

  @Test
  public void testJoinConditionWithoutParentColumnException() {
    String parentTable = "parentTable";
    String childQuery = "SELECT anything, childColumn1 FROM anyTable WHERE anyCondition";
    String childColumn1 = "parentColumn1";

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTable));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY),
        rdf.createLiteral(childQuery));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    Assertions.assertThrows(JoinConditionWithoutParentColumnException.class,
        () -> mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap));
  }

  @Test
  public void testJoinConditionWithoutChildColumnException() {
    String parentTable = "parentTable";
    String childQuery = "SELECT anything, childColumn1 FROM anyTable WHERE anyCondition";
    String parentColumn1 = "parentColumn1";

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTable));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY),
        rdf.createLiteral(childQuery));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    Assertions.assertThrows(JoinConditionWithoutChildColumnException.class,
        () -> mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap));
  }

  @Test
  public void testWithParentTableAndChildQuery() {
    String parentTable = "parentTable";
    String childQuery = "SELECT anything, childColumn1 FROM anyTable WHERE anyCondition";
    String childColumn1 = "childColumn1";
    String parentColumn1 = "parentColumn1";

    String expectedQuery = String.format(
        """
            SELECT *
            FROM (%s) AS child
            JOIN (SELECT * FROM %s) AS parent
              ON child.%s = parent.%s""",
        childQuery, parentTable, childColumn1, parentColumn1);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTable));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY),
        rdf.createLiteral(childQuery));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());

    Assertions.assertTrue(testGraph.stream(newLogicalTable.get(0), rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW)).findAny().isPresent(),
        "Logical table should be a R2RML view.");
    testGraph.stream(childMapping, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void testWithParentTableAndChildTable() {
    String parentTable = "parentTable";
    String childTable = "childTable";
    String childColumn1 = "childColumn1";
    String parentColumn1 = "parentColumn1";

    String expectedQuery = String.format(
        """
            SELECT *
            FROM (SELECT * FROM %s) AS child
            JOIN (SELECT * FROM %s) AS parent
              ON child.%s = parent.%s""",
        childTable, parentTable, childColumn1, parentColumn1);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTable));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTable));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());
    Assertions.assertTrue(testGraph.stream(newLogicalTable.get(0), rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW)).findAny().isPresent(),
        "Logical table should be a R2RML view.");
    testGraph.stream(childMapping, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void testWithParentQueryAndChildQuery() {
    String parentQuery = "SELECT anything, parentColumn1 FROM anyTable WHERE anyCondition";
    String childQuery = "SELECT anything, childColumn1 FROM anyTable WHERE anyCondition";
    String childColumn1 = "childColumn1";
    String parentColumn1 = "parentColumn1";

    String expectedQuery = String.format(
        """
            SELECT *
            FROM (%s) AS child
            JOIN (%s) AS parent
              ON child.%s = parent.%s""",
        childQuery, parentQuery, childColumn1, parentColumn1);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY),
        rdf.createLiteral(parentQuery));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY),
        rdf.createLiteral(childQuery));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());
    Assertions.assertTrue(testGraph.stream(newLogicalTable.get(0), rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW)).findAny().isPresent(),
        "Logical table should be a R2RML view.");
    testGraph.stream(childMapping, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void testWithParentQueryAndChildTable() {
    String parentQuery = "SELECT anything, parentColumn1 FROM anyTable WHERE anyCondition";
    String childTableName = "childTableName";
    String childColumn1 = "childColumn1";
    String parentColumn1 = "parentColumn1";

    String expectedQuery = String.format(
        """
            SELECT *
            FROM (SELECT * FROM %s) AS child
            JOIN (%s) AS parent
              ON child.%s = parent.%s""",
        childTableName, parentQuery, childColumn1, parentColumn1);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY),
        rdf.createLiteral(parentQuery));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTableName));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition = rdf.createBlankNode("joinCondition");
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());
    Assertions.assertTrue(testGraph.stream(newLogicalTable.get(0), rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW)).findAny().isPresent(),
        "Logical table should be a R2RML view.");
    testGraph.stream(childMapping, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void testWithMultipleJoinConditions() {
    String parentTableName = "parentTableName";
    String childTableName = "childTableName";
    String childColumn1 = "childColumn1";
    String childColumn2 = "childColumn2";
    String childColumn3 = "childColumn3";
    String parentColumn1 = "parentColumn1";
    String parentColumn2 = "parentColumn2";
    String parentColumn3 = "parentColumn3";

    String expectedQuery = String.format(
        """
            SELECT *
            FROM (SELECT * FROM %s) AS child
            JOIN (SELECT * FROM %s) AS parent
              ON child.%s = parent.%s
                AND child.%s = parent.%s
                AND child.%s = parent.%s""",
        childTableName, parentTableName, childColumn1, parentColumn1, childColumn2, parentColumn2,
        childColumn3, parentColumn3);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTableName));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTableName));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition1 = rdf.createBlankNode("joinCondition1");
    RDF4JBlankNode joinCondition2 = rdf.createBlankNode("joinCondition2");
    RDF4JBlankNode joinCondition3 = rdf.createBlankNode("joinCondition3");
    testGraph.add(joinCondition1, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition1, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(joinCondition2, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn2));
    testGraph.add(joinCondition2, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn2));
    testGraph.add(joinCondition3, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn3));
    testGraph.add(joinCondition3, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn3));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition1);
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition2);
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition3);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());
    Assertions.assertTrue(testGraph.stream(newLogicalTable.get(0), rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW)).findAny().isPresent(),
        "Logical table should be a R2RML view.");
    testGraph.stream(childMapping, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void testWithoutJoinConditionsAndChildTable() {
    String parentTableName = "parentTableName";
    String childTableName = "childTableName";

    String expectedQuery = String.format("SELECT * FROM (SELECT * FROM %s) AS tmp",
        childTableName);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTableName));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTableName));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);
    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());
    Assertions.assertTrue(testGraph.stream(newLogicalTable.get(0), rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW)).findAny().isPresent(),
        "Logical table should be a R2RML view.");
    testGraph.stream(childMapping, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void testWithoutJoinConditionsAndChildQuery() {
    String parentTableName = "parentTableName";
    String childQuery = "SELECT anyThing FROM anyTable WHERE anyCondition";

    String expectedQuery = String.format("SELECT * FROM (%s) AS tmp", childQuery);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTableName));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY),
        rdf.createLiteral(childQuery));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);
    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());
    Assertions.assertTrue(testGraph.stream(newLogicalTable.get(0), rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW)).findAny().isPresent(),
        "Logical table should be a R2RML view.");
    testGraph.stream(childMapping, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void testChildIsDefinedAsParentSubset() {
    String parentTableName = "parentTableName";
    String childTableName = "childTableName";

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTableName));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTableName));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);
    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    testGraph.stream(childMapping,
        rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS), parentMapping)
        .findAny()
        .ifPresentOrElse(
            subset -> {
              // Test is successful
            },
            () -> Assertions.fail("processRefSubjectMap must assert <Child subsets Parent>."));
  }

  @Test
  public void testAddParentSubsets() {
    String parentTableName = "parentTableName";
    String childTableName = "childTableName";

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTableName));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);
    BlankNodeOrIRI parentSubsets = rdf.createBlankNode("parentSubsets");
    testGraph.add(parentMapping,
        rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS),
        parentSubsets);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTableName));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);
    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    testGraph.stream(childMapping,
        rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS), parentSubsets)
        .findAny()
        .ifPresentOrElse(
            subset -> {
              // Test is successful
            },
            () -> Assertions.fail("Child mapping should have a reference to the parent subsets."));
  }

  @Test
  public void testUsesUsingWhenJoinWithSameColumnName() {
    String parentTableName = "parentTableName";
    String childTableName = "childTableName";
    String childColumn1 = "childColumn1";
    String parentColumn1 = childColumn1;

    String expectedQuery = String.format(
        """
            SELECT *
            FROM (SELECT * FROM %s) AS child
            JOIN (SELECT * FROM %s) AS parent
              USING (%s)""",
        childTableName, parentTableName, childColumn1);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTableName));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTableName));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition1 = rdf.createBlankNode("joinCondition1");
    testGraph.add(joinCondition1, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition1, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition1);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void testUsesUsingWhenJoinWithSameColumnNameMultiple() {
    String parentTableName = "parentTableName";
    String childTableName = "childTableName";
    String childColumn1 = "childColumn1";
    String childColumn2 = "childColumn2";
    String childColumn3 = "childColumn3";
    String parentColumn1 = childColumn1;
    String parentColumn2 = childColumn2;
    String parentColumn3 = childColumn3;

    String expectedQuery = String.format(
        """
            SELECT *
            FROM (SELECT * FROM %s) AS child
            JOIN (SELECT * FROM %s) AS parent
              USING (%s, %s, %s)""",
        childTableName, parentTableName, childColumn1, childColumn2, childColumn3);

    RDF4JIRI parentMapping = rdf.createIRI("http://parentMapping");

    testGraph.add(parentMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI parentLogicalTable = rdf.createBlankNode("parentLogicalTable");
    testGraph.add(parentLogicalTable,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    testGraph.add(parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(parentTableName));
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        parentLogicalTable);
    BlankNodeOrIRI parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JIRI childMapping = rdf.createIRI("http://childMapping");
    testGraph.add(childMapping,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    BlankNodeOrIRI childLogicalTable = rdf.createBlankNode("childLogicalTable");
    testGraph.add(childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME),
        rdf.createLiteral(childTableName));
    testGraph.add(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    BlankNodeOrIRI childRefSubjectMap = rdf.createBlankNode("childRefSubjectMap");
    testGraph.add(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP),
        parentMapping);

    RDF4JBlankNode joinCondition1 = rdf.createBlankNode("joinCondition1");
    RDF4JBlankNode joinCondition2 = rdf.createBlankNode("joinCondition2");
    RDF4JBlankNode joinCondition3 = rdf.createBlankNode("joinCondition3");
    testGraph.add(joinCondition1, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn1));
    testGraph.add(joinCondition1, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn1));
    testGraph.add(joinCondition2, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn2));
    testGraph.add(joinCondition2, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn2));
    testGraph.add(joinCondition3, rdf.createIRI(R2RMLVocabulary.PROP_CHILD),
        rdf.createLiteral(childColumn3));
    testGraph.add(joinCondition3, rdf.createIRI(R2RMLVocabulary.PROP_PARENT),
        rdf.createLiteral(parentColumn3));
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition1);
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition2);
    testGraph.add(childRefSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION),
        joinCondition3);

    testGraph.add(childMapping,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP),
        childRefSubjectMap);

    mappingParser.processRefSubjectMap_pub(testGraph, childMapping, childRefSubjectMap);

    List<BlankNodeOrIRI> newLogicalTable = testGraph.stream(childMapping,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), null)
        .map(Triple::getObject)
        .map(BlankNodeOrIRI.class::cast)
        .toList();

    Assertions.assertEquals(1, newLogicalTable.size());

    testGraph.stream(newLogicalTable.get(0), rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY), null)
        .map(Triple::getObject)
        .filter(RDF4JLiteral.class::isInstance)
        .map(RDF4JLiteral.class::cast)
        .map(RDF4JLiteral::getLexicalForm)
        .findAny()
        .ifPresentOrElse(
            actualQuery -> Assertions.assertEquals(expectedQuery, actualQuery),
            () -> Assertions.fail(String.format("Logical table %s should have a SQL query.",
                newLogicalTable.get(0))));
  }

  @Test
  public void updateGraphWithInvalidRefSubjectMapThrowsTest() {
    IRI subject = rdf.createIRI("http://subject");
    Literal object = rdf.createLiteral("object");
    ImmutableMap<String, String> prefixes = ImmutableMap.of();

    testGraph.add(subject, rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP), object);

    Assertions.assertThrows(InvalidRefSubjectMapException.class,
        () -> mappingParser.updateGraph(testGraph, prefixes));
  }

  @Test
  public void updateGraphWithValidRefSubjectMapTest() {
    MMecParserRefSubjectMapExtensionTestImpl mappingParserSpy = Mockito.spy(mappingParser);
    IRI subject = rdf.createIRI("http://subject");
    BlankNodeOrIRI object = rdf.createBlankNode("object");
    ImmutableMap<String, String> prefixes = ImmutableMap.of();

    testGraph.add(subject, rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP), object);

    Mockito.doNothing().when(mappingParserSpy)
        .processRefSubjectMap_pub(Mockito.any(), Mockito.any(), Mockito.any());

    mappingParserSpy.updateGraph(testGraph, prefixes);

    Mockito.verify(mappingParserSpy, Mockito.times(1))
        .processRefSubjectMap_pub(testGraph, subject, object);
  }

  private static class MMecParserRefSubjectMapExtensionTestImpl
      extends MMecParserRefSubjectMapExtension {
    public MMecParserRefSubjectMapExtensionTestImpl(RDF4J rdf) {
      super(rdf);
    }

    @Override
    protected void processRefSubjectMap(Graph mappingGraph, BlankNodeOrIRI child,
        BlankNodeOrIRI childRefSubjectMap) {
      processRefSubjectMap_pub(mappingGraph, child, childRefSubjectMap);
    }

    public void processRefSubjectMap_pub(Graph mappingGraph, BlankNodeOrIRI child,
        BlankNodeOrIRI childRefSubjectMap) {
      super.processRefSubjectMap(mappingGraph, child, childRefSubjectMap);
    }
  }
}

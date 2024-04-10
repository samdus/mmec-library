/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecParserTemplatesExtensionTest.
 * @brief @~english MMecParserTemplatesExtensionTest class implementation.
 */
package ca.griis.mmec.test.unit.controller.ontop.mapping.parser.extension.before;

import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before.MMecParserTemplatesExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SignatureComponentMismatchException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SignatureComponentMissingException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SubsetHasTemplateException;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableList;
import eu.optique.r2rml.api.model.R2RMLVocabulary;
import java.util.stream.Collectors;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.Literal;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.apache.commons.rdf.rdf4j.RDF4JBlankNode;
import org.apache.commons.rdf.rdf4j.RDF4JIRI;
import org.apache.commons.rdf.rdf4j.RDF4JLiteral;
import org.apache.commons.rdf.rdf4j.RDF4JTriple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MMecParserTemplatesExtensionTest {
  public static final String nsTypeIri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
  private final RDF4J rdf;
  private Graph testGraph;
  private MMecParserTemplatesExtensionTestImpl mappingParser;

  public MMecParserTemplatesExtensionTest() {
    rdf = new RDF4J();
  }

  @BeforeEach
  public void setUp() {
    testGraph = rdf.createGraph();
    mappingParser = new MMecParserTemplatesExtensionTestImpl(rdf);
  }

  @Test
  public void generateTemplateTestPreserveTemplateWhenDefinedWithoutMMec() {
    MMecParserTemplatesExtensionTestImpl mappingParser =
        new MMecParserTemplatesExtensionTestImpl(rdf);

    // The mapping doesn't use any mmec extension and is not referenced by any other mapping using
    // mmec extensions
    RDF4JBlankNode notExtendedMappingExpression = rdf.createBlankNode(
        "notExtendedMappingExpression");
    RDF4JBlankNode subjectMap = rdf.createBlankNode("subjectMap");
    testGraph.add(notExtendedMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    RDF4JTriple templateTriple = rdf.createTriple(subjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        rdf.createLiteral("http://www.example.com/anyTemplate"));
    testGraph.add(templateTriple);

    testGraph.add(notExtendedMappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    mappingParser.generateTemplates_pub(testGraph, notExtendedMappingExpression);

    // The original template should still be present and be the only one
    Assertions.assertEquals(
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .collect(Collectors.toList()),
        ImmutableList.of(templateTriple));
  }

  @Test
  public void generateTemplateThrowsWhenDefinedWithoutMMEcButHasSuperset() {
    // The mapping doesn't use any mmec extensions
    RDF4JBlankNode notExtendedMappingExpression = rdf.createBlankNode(
        "notExtendedMappingExpression");
    RDF4JBlankNode subjectMap = rdf.createBlankNode("subjectMap");
    testGraph.add(notExtendedMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    RDF4JTriple templateTriple = rdf.createTriple(subjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        rdf.createLiteral("http://www.example.com/anyTemplate"));
    testGraph.add(templateTriple);

    testGraph.add(notExtendedMappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    // The mapping is referenced by another mapping using an mmec extension
    RDF4JBlankNode mappingDefinedAsSubset = rdf.createBlankNode(
        "mappingDefinedAsSubset");
    testGraph.add(mappingDefinedAsSubset,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));
    testGraph.add(mappingDefinedAsSubset, rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS),
        notExtendedMappingExpression);

    Assertions.assertThrows(SubsetHasTemplateException.class,
        () -> mappingParser.generateTemplates_pub(testGraph, notExtendedMappingExpression));
  }

  @Test
  public void generateTemplateThrowsWhenTheNumberOfSignatureComponentsIsNotEqualWithSupersets() {
    // The parent mapping has one component
    RDF4JBlankNode parentMappingExpression = rdf.createBlankNode(
        "parentMappingExpression");
    RDF4JBlankNode parentSubjectMap = rdf.createBlankNode("parentSubjectMap");
    testGraph.add(parentMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(parentSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(parentSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));
    testGraph.add(parentSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral("ParentComponent1"));
    testGraph.add(parentMappingExpression, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    // The child mapping has two component
    RDF4JBlankNode childMappingExpression = rdf.createBlankNode(
        "notExtendedMappingExpression");
    RDF4JBlankNode childSubjectMap = rdf.createBlankNode("childSubjectMap");
    testGraph.add(childMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(childSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(childSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));
    testGraph.add(childSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral("ChildComponent1"));
    testGraph.add(childSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral("ChildComponent2"));
    testGraph.add(childMappingExpression, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        childSubjectMap);

    testGraph.add(childMappingExpression, rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS),
        parentMappingExpression);

    Assertions.assertThrows(SignatureComponentMismatchException.class,
        () -> mappingParser.generateTemplates_pub(testGraph, childMappingExpression));
  }

  @Test
  public void generateTemplateThrowsWhenDefinedWithoutSignatureComponents() {
    RDF4JBlankNode mappingExpression = rdf.createBlankNode(
        "parentMappingExpression");
    RDF4JBlankNode subjectMap = rdf.createBlankNode("subjectMap");
    testGraph.add(mappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));
    testGraph.add(mappingExpression, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    Assertions.assertThrows(SignatureComponentMissingException.class,
        () -> mappingParser.generateTemplates_pub(testGraph, mappingExpression));
  }

  @Test
  public void generateTemplateReplaceExistingTemplatesWhenDefinedUsingExtensionComponent() {
    // The mapping has a template and a signatureComponent
    RDF4JBlankNode mappingExpression = rdf.createBlankNode(
        "mappingExpression");
    RDF4JBlankNode subjectMap = rdf.createBlankNode("subjectMap");
    testGraph.add(mappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    RDF4JLiteral originalTemplateLiteral = rdf.createLiteral("http://www.example.com/anyTemplate");
    testGraph.add(subjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        originalTemplateLiteral);

    testGraph.add(subjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral("signComponent"));
    testGraph.add(mappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    mappingParser.generateTemplates_pub(testGraph, mappingExpression);

    // The original template has been replaced
    Assertions.assertTrue(testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        originalTemplateLiteral).findAny().isEmpty());
    Assertions.assertTrue(testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        null).findAny().isPresent());
  }

  @Test
  public void generateTemplateWithoutSupersetUsesSignatureIriAsSignatureScope() {
    String signatureIRI = "https://www.example.com/signature/sign1";
    String signComponent = "signComponent";
    String expectedTemplate = String.format("%s/{%s}", signatureIRI, signComponent);
    RDF4JIRI mappingExpression = rdf.createIRI(signatureIRI);
    RDF4JBlankNode subjectMap = rdf.createBlankNode("subjectMap");
    testGraph.add(mappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    testGraph.add(subjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(signComponent));
    testGraph.add(mappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    mappingParser.generateTemplates_pub(testGraph, mappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateUsesSupersetIRIAsSignatureScope() {
    String parentSignatureIri = "https://www.example.com/signature/parent";
    String parentSignComponent = "parentSignComponent";
    String childSignComponent = "childSignComponent";
    String expectedTemplate = String.format("%s/{%s}", parentSignatureIri, childSignComponent);
    RDF4JIRI parentMappingExpression = rdf.createIRI(parentSignatureIri);
    RDF4JBlankNode parentSubjectMap = rdf.createBlankNode();
    testGraph.add(parentMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(parentSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(parentSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    testGraph.add(parentSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(parentSignComponent));
    testGraph.add(parentMappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        parentSubjectMap);

    RDF4JBlankNode childMappingExpression = rdf.createBlankNode(
        "childMappingExpression");
    RDF4JBlankNode childSubjectMap = rdf.createBlankNode("childSubjectMap");
    testGraph.add(childMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(childSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(childSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    testGraph.add(childSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(childSignComponent));
    testGraph.add(childMappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        childSubjectMap);
    testGraph.add(childMappingExpression,
        rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS),
        parentMappingExpression);

    mappingParser.generateTemplates_pub(testGraph, childMappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(childSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateWorksWithBlankNode() {
    String blankNodeName = "signature";
    String signatureIri = String.format("_:%s", blankNodeName);
    String signComponent = "signComponent";
    String expectedTemplate = String.format("%s/{%s}", signatureIri, signComponent);
    RDF4JBlankNode mappingExpression = rdf.createBlankNode(blankNodeName);
    RDF4JBlankNode subjectMap = rdf.createBlankNode();
    testGraph.add(mappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    testGraph.add(subjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(signComponent));
    testGraph.add(mappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    mappingParser.generateTemplates_pub(testGraph, mappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateWorksWithSingleAttributeSignatureComponent() {
    String signatureIri = "https://www.example.com/signature";
    String signComponent = "signComponent";
    String expectedTemplate = String.format("%s/{%s}", signatureIri, signComponent);
    RDF4JIRI mappingExpression = rdf.createIRI(signatureIri);
    RDF4JBlankNode subjectMap = rdf.createBlankNode();
    testGraph.add(mappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    testGraph.add(subjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(signComponent));
    testGraph.add(mappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    mappingParser.generateTemplates_pub(testGraph, mappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateWorksWithMultipleAttributeSignatureComponent() {
    String signatureIri = "https://www.example.com/signature";
    String signComponent1 = "signComponent1";
    String signComponent2 = "signComponent2";
    String signComponent3 = "signComponent3";
    String signComponent4 = "signComponent4";
    String expectedTemplate = String.format("%s/{%s}/{%s}/{%s}/{%s}", signatureIri,
        signComponent1, signComponent2, signComponent3, signComponent4);
    RDF4JIRI mappingExpression = rdf.createIRI(signatureIri);
    RDF4JBlankNode subjectMap = rdf.createBlankNode();
    testGraph.add(mappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(subjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    testGraph.add(subjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(signComponent1));
    testGraph.add(subjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(signComponent2));
    testGraph.add(subjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(signComponent3));
    testGraph.add(subjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(signComponent4));
    testGraph.add(mappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    mappingParser.generateTemplates_pub(testGraph, mappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateGeneratesCompatibleSignatureWithSignatureSuperSets() {
    String superSetMappingIri = "https://www.example.com/superSetMapping";
    String firstSignComponent1 = "firstSignComponent1";
    String firstSignComponent2 = "firstSignComponent2";
    String firstExpectedTemplate = String.format("%s/{%s}/{%s}", superSetMappingIri,
        firstSignComponent1, firstSignComponent2);
    String secondSignComponent1 = "firstSignComponent1";
    String secondSignComponent2 = "firstSignComponent2";
    String secondExpectedTemplate = String.format("%s/{%s}/{%s}", superSetMappingIri,
        secondSignComponent1, secondSignComponent2);

    RDF4JIRI superSetMappingExpression = rdf.createIRI(
        superSetMappingIri);
    testGraph.add(superSetMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(MMecVocabulary.C_SIGNATURE_SUPERSET));

    RDF4JBlankNode firstMappingExpression = rdf.createBlankNode(
        "firstMappingExpression");
    RDF4JBlankNode firstSubjectMap = rdf.createBlankNode("firstSubjectMap");
    testGraph.add(firstMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(firstSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(firstSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    testGraph.add(firstSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(firstSignComponent1));
    testGraph.add(firstSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(firstSignComponent2));
    testGraph.add(firstMappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        firstSubjectMap);

    testGraph.add(firstMappingExpression, rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS),
        superSetMappingExpression);

    RDF4JIRI secondMappingExpression = rdf.createIRI(
        "http://www.example.com/secondMappingExpression");
    RDF4JBlankNode secondSubjectMap = rdf.createBlankNode("secondSubjectMap");
    testGraph.add(secondMappingExpression,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    testGraph.add(secondSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    testGraph.add(secondSubjectMap,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    testGraph.add(secondSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(secondSignComponent1));
    testGraph.add(secondSubjectMap, rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT),
        rdf.createLiteral(secondSignComponent2));
    testGraph.add(secondMappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        secondSubjectMap);

    testGraph.add(secondMappingExpression, rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS),
        superSetMappingExpression);

    mappingParser.generateTemplates_pub(testGraph, firstMappingExpression);
    mappingParser.generateTemplates_pub(testGraph, secondMappingExpression);

    Assertions.assertEquals(firstExpectedTemplate,
        testGraph.stream(firstSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
    Assertions.assertEquals(secondExpectedTemplate,
        testGraph.stream(firstSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  // A class that expose protected methods of MappingParserExtension for the tests
  private static class MMecParserTemplatesExtensionTestImpl extends MMecParserTemplatesExtension {
    public MMecParserTemplatesExtensionTestImpl(RDF4J rdf) {
      super(rdf);
    }

    public void generateTemplates_pub(Graph mappingGraph,
        BlankNodeOrIRI current) {
      super.generateTemplates(mappingGraph, current);
    }
  }
}

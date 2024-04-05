/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MappingParserExtensionTest.
 * @brief @~english MappingParserExtensionTest class implementation.
 */
package ca.griis.mmec.test.unit.controller.ontop.mapping.parser.extension;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecPostgreSqlDbFunctionSymbolFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.MappingParserExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableList;
import eu.optique.r2rml.api.model.R2RMLVocabulary;
import eu.optique.r2rml.api.model.TriplesMap;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.model.type.TypeFactory;
import java.util.Collection;
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
import org.mockito.Mockito;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details
 *      «Detailed description of the component (optional)»
 * @par Model
 *      «Model (Abstract, automation, etc.) (optional)»
 * @par Conception
 *      «Conception description (criteria and constraints) (optional)»
 * @par Limits
 *      «Limits description (optional)»
 *
 * @brief @~french Tests pour la classe MappingParserExtension.
 * @par Détails
 *      S.O.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2024-01-31 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 * @todo 2024-03-22 [SD] - Écrire les tests pour le traîtement des conversions.
 * @todo 2024-03-22 [SD] - Écrire les tests pour le traîtement des subsets.
 */
public class MappingParserExtensionTest {
  public static final String nsTypeIri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
  private final MMecMappingExtension mappingExtension;
  private final SQLPPMappingFactory ppMappingFactory;
  private final RDF4J rdf;
  private final TypeFactory typeFactory;
  private final MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory;
  private Graph testGraph;

  public MappingParserExtensionTest() {
    mappingExtension = Mockito.mock(MMecMappingExtension.class);
    ppMappingFactory = Mockito.mock(SQLPPMappingFactory.class);
    typeFactory = Mockito.mock(TypeFactory.class);
    sqlDbFunctionSymbolFactory = Mockito.mock(MMecPostgreSqlDbFunctionSymbolFactory.class);
    // Not mocking rdf should not be a problem and it simplifies the tests
    rdf = new RDF4J();
  }

  @BeforeEach
  public void setUp() {
    testGraph = rdf.createGraph();
  }

  @Test
  public void generateTemplateTestPreserveTemplateWhenDefinedWithoutMMec() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    mappingParser.generateTemplate_pub(testGraph, notExtendedMappingExpression);

    // The original template should still be present and be the only one
    Assertions.assertEquals(
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .collect(Collectors.toList()),
        ImmutableList.of(templateTriple));
  }

  @Test
  public void generateTemplateThrowsWhenDefinedWithoutMMEcButHasSuperset() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    Assertions.assertThrows(MappingParserExtension.SubsetHasTemplateException.class,
        () -> mappingParser.generateTemplate_pub(testGraph, notExtendedMappingExpression));
  }

  @Test
  public void generateTemplateThrowsWhenTheNumberOfSignatureComponentsIsNotEqualWithSupersets() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    Assertions.assertThrows(MappingParserExtension.SignatureComponentMismatchException.class,
        () -> mappingParser.generateTemplate_pub(testGraph, childMappingExpression));
  }

  @Test
  public void generateTemplateThrowsWhenDefinedWithoutSignatureComponents() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    Assertions.assertThrows(MappingParserExtension.SignatureComponentMissingException.class,
        () -> mappingParser.generateTemplate_pub(testGraph, mappingExpression));
  }

  @Test
  public void generateTemplateReplaceExistingTemplatesWhenDefinedUsingExtensionComponent() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    mappingParser.generateTemplate_pub(testGraph, mappingExpression);

    // The original template has been replaced
    Assertions.assertTrue(testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        originalTemplateLiteral).findAny().isEmpty());
    Assertions.assertTrue(testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        null).findAny().isPresent());
  }

  @Test
  public void generateTemplateWithoutSupersetUsesSignatureIriAsSignatureScope() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    mappingParser.generateTemplate_pub(testGraph, mappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateUsesSupersetIRIAsSignatureScope() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    mappingParser.generateTemplate_pub(testGraph, childMappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(childSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateWorksWithBlankNode() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    mappingParser.generateTemplate_pub(testGraph, mappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateWorksWithSingleAttributeSignatureComponent() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    mappingParser.generateTemplate_pub(testGraph, mappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateWorksWithMultipleAttributeSignatureComponent() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    mappingParser.generateTemplate_pub(testGraph, mappingExpression);

    Assertions.assertEquals(expectedTemplate,
        testGraph.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .findAny().map(triple -> ((Literal) triple.getObject()).getLexicalForm())
            .orElseThrow());
  }

  @Test
  public void generateTemplateGeneratesCompatibleSignatureWithSignatureSuperSets() {
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

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

    RDF4JIRI secondMappingExpression = rdf.createIRI("http://www.example.com/secondMappingExpression");
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

    mappingParser.generateTemplate_pub(testGraph, firstMappingExpression);
    mappingParser.generateTemplate_pub(testGraph, secondMappingExpression);

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
  private static class MappingParserExtensionTestImpl extends MappingParserExtension {
    public MappingParserExtensionTestImpl(TypeFactory typeFactory,
        MMecMappingExtension mappingExtension,
        SQLPPMappingFactory ppMappingFactory, RDF4J rdf,
        MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory) {
      super(typeFactory, mappingExtension, ppMappingFactory, rdf, sqlDbFunctionSymbolFactory);
    }

    public void generateTemplate_pub(Graph mappingGraph,
        BlankNodeOrIRI current) {
      super.generateTemplate(mappingGraph, current);
    }

    public void processSubSetExpressions_pub(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
        ImmutableList<MMecTriplesMap> sourceMappings) {
      super.processSubSetExpressions(mappingGraph, tripleMaps, sourceMappings);
    }

    public void processConversionExpressions_pub(Graph mappingGraph) {
      super.processConversionExpressions(mappingGraph);
    }
  }
}

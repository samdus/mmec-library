/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MappingParserExtensionTest.
 * @brief @~english MappingParserExtensionTest class implementation.
 */
package ca.griis.mmec.test.unit.controller.ontop.extension;

import ca.griis.mmec.controller.ontop.extension.MappingParserExtension;
import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecPostgreSqlDbFunctionSymbolFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.model.MMecTriplesMap;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import eu.optique.r2rml.api.model.R2RMLVocabulary;
import eu.optique.r2rml.api.model.TriplesMap;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.model.type.TypeFactory;
import java.util.Collection;
import java.util.stream.Collectors;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.apache.commons.rdf.rdf4j.RDF4JBlankNode;
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

  private final MMecMappingExtension mappingExtension;
  private final SQLPPMappingFactory ppMappingFactory;
  private final RDF4J rdf;
  private final TypeFactory typeFactory;
  private final MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory;
  private Graph mappingGraphUnderTest;

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
    mappingGraphUnderTest = rdf.createGraph();
    RDF4JBlankNode mappingDefinitionNode = rdf.createBlankNode();

    mappingGraphUnderTest.add(mappingDefinitionNode,
        rdf.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
        rdf.createIRI(MMecVocabulary.MAPPING_DEFINITION));
    mappingGraphUnderTest.add(mappingDefinitionNode,
        rdf.createIRI(MMecVocabulary.MAPPING_ONTOREL),
        rdf.createIRI("http://www.example.com/ontorel"));
    mappingGraphUnderTest.add(mappingDefinitionNode,
        rdf.createIRI(MMecVocabulary.MAPPING_SOURCE),
        rdf.createIRI("http://www.example.com/source"));
    mappingGraphUnderTest.add(mappingDefinitionNode,
        rdf.createIRI(MMecVocabulary.MAPPING_TEMPLATE_PREFIX),
        rdf.createLiteral("http://www.example.com/templatePrefix"));
  }

  @Test
  public void generateTemplatesTestIgnoredTemplateWhenDefinedWithoutMMec() {
    // Given
    MappingParserExtensionTestImpl mappingParser =
        new MappingParserExtensionTestImpl(typeFactory, mappingExtension, ppMappingFactory, rdf,
            sqlDbFunctionSymbolFactory);

    // The mapping doesn't use any mmec extension and is not referenced by any other mapping using
    // mmec extensions
    RDF4JBlankNode notExtendedMappingExpression = rdf.createBlankNode(
        "notExtendedMappingExpression");
    RDF4JBlankNode subjectMap = rdf.createBlankNode("subjectMap");
    mappingGraphUnderTest.add(notExtendedMappingExpression,
        rdf.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP));

    mappingGraphUnderTest.add(subjectMap,
        rdf.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
        rdf.createIRI(R2RMLVocabulary.TYPE_SUBJECT_MAP));
    mappingGraphUnderTest.add(subjectMap,
        rdf.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
        rdf.createIRI(R2RMLVocabulary.TYPE_TERM_MAP));

    RDF4JTriple templateTriple = rdf.createTriple(subjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        rdf.createLiteral("http://www.example.com/anyTemplate"));
    mappingGraphUnderTest.add(templateTriple);

    mappingGraphUnderTest.add(notExtendedMappingExpression,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP),
        subjectMap);

    // When
    mappingParser.generateTemplates_pub(mappingGraphUnderTest, ImmutableMap.of());

    // Then
    // The original template should be present and be the only one
    Assertions.assertEquals(
        mappingGraphUnderTest.stream(subjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE), null)
            .collect(Collectors.toList()),
        ImmutableList.of(templateTriple));
  }

  @Test
  public void generateTemplatesThrowsWhenDefinedWithoutMMEcButIsSuperset() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesThrowsWhenDefinedWithoutMMEcButIsSuperset");
  }

  @Test
  public void generateTemplatesThrowsWhenSignatureScopeIsDefinedButInConflict() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesThrowsWhenSignatureScopeIsDefinedButInConflict");
  }

  @Test
  public void generateTemplatesThrowsWhenTheNumberOfSignatureComponentsIsNotEqualWithSupersets() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesThrowsWhenTheNumberOfSignatureComponentsIsNotEqualWithSupersets");
  }

  @Test
  public void generateTemplatesThrowsWhenDefinedWithoutSignatureComponents() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesThrowsWhenDefinedWithoutSignatureComponents");
  }

  @Test
  public void generateTemplatesReplaceExistingTemplatesWhenDefinedUsingExtension() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesReplaceExistingTemplatesWhenDefinedUsingExtension");
  }

  @Test
  public void generateTemplatesWithoutSupersetUsesDefinedSignatureScope() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesWithoutSupersetUsesDefinedSignatureScope");
  }

  @Test
  public void generateTemplatesUsesSupersetSignatureScope() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesUsesSupersetSignatureScope");
  }

  @Test
  public void generateTemplatesWorksWithSingleAttributeSignatureComponent() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesWorksWithSingleAttributeSignatureComponent");
  }

  @Test
  public void generateTemplatesWorksWithMultipleAttributeSignatureComponent() {
    Assertions.fail("Not implemented test: " +
        "generateTemplatesWorksWithMultipleAttributeSignatureComponent");
  }

  // A class that expose protected methods of MappingParserExtension for the tests
  private static class MappingParserExtensionTestImpl extends MappingParserExtension {
    public MappingParserExtensionTestImpl(TypeFactory typeFactory,
        MMecMappingExtension mappingExtension,
        SQLPPMappingFactory ppMappingFactory, RDF4J rdf,
        MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory) {
      super(typeFactory, mappingExtension, ppMappingFactory, rdf, sqlDbFunctionSymbolFactory);
    }

    public void generateTemplates_pub(Graph mappingGraph,
        ImmutableMap<String, String> prefixes) {
      super.generateTemplates(mappingGraph, prefixes);
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

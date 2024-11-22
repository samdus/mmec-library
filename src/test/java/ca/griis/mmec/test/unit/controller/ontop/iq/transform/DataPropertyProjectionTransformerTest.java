package ca.griis.mmec.test.unit.controller.ontop.iq.transform;

import ca.griis.mmec.controller.ontop.iq.transform.DataPropertyProjectionTransformer;
import ca.griis.mmec.controller.ontop.model.term.MMecTermFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.repository.OntoRelCatRepository;
import ca.griis.mmec.repository.jooq.JooqOntoRelCatRepository;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.node.UnaryOperatorNode;
import it.unibz.inf.ontop.iq.type.impl.BasicSingleTermTypeExtractor;
import it.unibz.inf.ontop.model.term.*;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.RDFTermType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.impl.SimpleRDFDatatype;
import it.unibz.inf.ontop.substitution.Substitution;

import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.semanticweb.owlapi.model.IRI;

/**
 * Descriptions des cas de tests
 * -------------------------------
 * Cas: Pas de substitution, ni d'enfant implique que l'arbre est inchangé
 * Test: transformConstructionWithoutSubstitutionAndWithoutRecursionIsIdempotentTest
 * <br />
 * Cas: Pas de substitution, mais enfant
 * Test: transformConstructionWithoutSubstitutionDoesRecurseTest
 * <br />
 * Cas: Substitution, mais pas de propriété de données
 * Test: transformConstructionWithSingleSubstitutionNotDPTest
 * <br />
 * Cas: Substitution, mais propriété de données comportant un terme sans variables
 * Test: transformConstructionWithSingleInvalidSubstitutionShouldThrowTest
 * <br />
 * Cas: Substitution, mais propriété de données comportant un terme sans type
 * Test: transformConstructionWithSingleSubstitutionOfEmptyTermTypeShouldThrowTest
 * <br />
 * Cas: Substitution, mais propriété de données comportant un terme avec un type non DB
 * Test: transformConstructionWithSingleSubstitutionOfNonDbTermTypeShouldThrowTest
 * <br />
 * Cas: Substitution simple et conforme
 * Test: transformConstructionSingleTest
 * <br />
 * Cas: L'opération se répète pour chaque substitution
 * Test: transformConstructionLoopTest
 * <br />
 * Cas: Les types ont le même nom (incluant les déclinsaisons de guilemets), donc conversion simple
 * Test: calculateAndAddConversionSameNameTest
 * <br />
 * Cas: Les types n'ont pas le même nom, mais la conversion dn'existe pas, donc exception
 * Test:
 * <br />
 * Cas: Les types n'ont pas le même nom, dans une case différente, avec guillemets, donc MappingConversion
 *      sans fonction de conversion, ni de validation
 * Test:
 * <br />
 * Cas: MMecMappingConversion, avec fonction de conversion
 * Test:
 * <br />
 * Cas: MMecMappingConversion, avec fonction de validation
 * Test:
 */
@SuppressWarnings("unchecked")
public class DataPropertyProjectionTransformerTest {
  private IntermediateQueryFactory iqFactory;
  private MMecTermFactory termFactory;
  private BasicSingleTermTypeExtractor typeExtractor;
  private JooqOntoRelCatRepository ontoRelCatRepository;
  private MappingProperties mappingProperties;
  private MMecMappingExtension mappingExtension;

  @BeforeEach
  public void init() {
    iqFactory = Mockito.mock(IntermediateQueryFactory.class);
    termFactory = Mockito.mock(MMecTermFactory.class);
    typeExtractor = Mockito.mock(BasicSingleTermTypeExtractor.class);
    ontoRelCatRepository = Mockito.mock(JooqOntoRelCatRepository.class);
    mappingProperties = Mockito.mock(MappingProperties.class);
    mappingExtension = Mockito.mock(MMecMappingExtension.class);
  }

  @Test
  public void transformConstructionWithoutSubstitutionAndWithoutRecursionIsIdempotentTest() {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(
        mappingExtension,
        iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);

    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    Map<Variable, ImmutableTerm> substitutionMap = ImmutableMap.of();
    IQTree expected = iqTree;

    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(substitution.isEmpty()).thenReturn(true);
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(iqTree.getRootNode()).thenReturn(constructionNode);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void transformConstructionWithoutSubstitutionDoesRecurseTest() {
    DataPropertyProjectionTransformerTester innerTransformer =
        new DataPropertyProjectionTransformerTester(
            mappingExtension,
            iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    DataPropertyProjectionTransformerTester transformer = Mockito.spy(innerTransformer);

    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);

    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(substitution.isEmpty()).thenReturn(true);
    Mockito.doReturn(expected).when(transformer)
        .transformUnaryNode_p(iqTree, constructionNode, childTree);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void transformConstructionWithSingleSubstitutionNotDPTest() {
    DataPropertyProjectionTransformerTester innerTransformer =
        new DataPropertyProjectionTransformerTester(
            mappingExtension,
            iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    DataPropertyProjectionTransformerTester transformer = Mockito.spy(innerTransformer);

    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    ConstructionNode newConstructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    Variable variable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> constructionNodeVariable = ImmutableSet.of(variable);
    NonGroundFunctionalTerm term = Mockito.mock(NonGroundFunctionalTerm.class);
    RDFTermFunctionSymbol functionSymbol = Mockito.mock(RDFTermFunctionSymbol.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    RDFTermType notSimpleRDFDatatype = Mockito.mock(RDFTermType.class);
    Map<Variable, ImmutableTerm> substitutionMap = ImmutableMap.of(variable, term);
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);

    ArgumentCaptor<ImmutableSet<Variable>> constructionNodeArgumentCaptor =
        ArgumentCaptor.forClass(ImmutableSet.class);
    ArgumentCaptor<Substitution<ImmutableTerm>> substitutionArgumentCaptor =
        ArgumentCaptor.forClass(Substitution.class);

    Mockito.when(substitution.isEmpty()).thenReturn(false);
    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(term.getFunctionSymbol()).thenReturn(functionSymbol);
    Mockito.when(term.getTerm(1)).thenReturn(rdfTermTypeConstant);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(notSimpleRDFDatatype);
    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariable);
    Mockito.when(iqFactory.createConstructionNode(constructionNodeArgumentCaptor.capture(),
        substitutionArgumentCaptor.capture())).thenReturn(newConstructionNode);
    Mockito.doReturn(expected).when(transformer)
        .transformUnaryNode_p(iqTree, newConstructionNode, childTree);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(constructionNodeVariable, constructionNodeArgumentCaptor.getValue());
    Assertions.assertEquals(substitutionMap.get(variable),
        substitutionArgumentCaptor.getValue().get(variable));
  }

  @Test
  public void transformConstructionWithSingleInvalidSubstitutionShouldThrowTest() {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(
        mappingExtension,
        iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);

    String ontoRelId = "ontoRelId";
    String datatypeIriString = "datatypeIri";
    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    ConstructionNode newConstructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    Variable constructionNodeVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> constructionNodeVariableSet = ImmutableSet.of(constructionNodeVariable);
    NonGroundFunctionalTerm term = Mockito.mock(NonGroundFunctionalTerm.class);
    RDFTermFunctionSymbol functionSymbol = Mockito.mock(RDFTermFunctionSymbol.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    SimpleRDFDatatype simpleRDFDatatype = Mockito.mock(SimpleRDFDatatype.class);
    Map<Variable, ImmutableTerm> substitutionMap = ImmutableMap.of(constructionNodeVariable, term);
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);
    IRI datatypeIri = Mockito.mock(IRI.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable originalVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> emptyThereforeInvalidSubstitutionTerm = ImmutableSet.of();

    ArgumentCaptor<ImmutableSet<Variable>> constructionNodeArgumentCaptor =
        ArgumentCaptor.forClass(ImmutableSet.class);
    ArgumentCaptor<Substitution<ImmutableTerm>> substitutionArgumentCaptor =
        ArgumentCaptor.forClass(Substitution.class);

    Mockito.when(substitution.isEmpty()).thenReturn(false);
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(term.getFunctionSymbol()).thenReturn(functionSymbol);
    Mockito.when(term.getTerm(1)).thenReturn(rdfTermTypeConstant);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(simpleRDFDatatype);
    Mockito.when(mappingProperties.getOntoRelId()).thenReturn(ontoRelId);
    Mockito.when(datatypeIri.getIRIString()).thenReturn(datatypeIriString);
    Mockito.when(simpleRDFDatatype.getIRI()).thenReturn(datatypeIri);
    Mockito.when(typeExtractor.extractSingleTermType(originalVariable, iqTree)).thenReturn(
        Optional.of(targetType));
    Mockito.when(ontoRelCatRepository.getSqlType(ontoRelId, datatypeIriString)).thenReturn(
        Optional.of(targetType));
    Mockito.when(term.getVariables()).thenReturn(emptyThereforeInvalidSubstitutionTerm);
    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariableSet);
    Mockito.when(iqFactory.createConstructionNode(constructionNodeArgumentCaptor.capture(),
        substitutionArgumentCaptor.capture())).thenReturn(newConstructionNode);
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(iqTree.getRootNode()).thenReturn(constructionNode);
    Mockito.when(iqFactory.createUnaryIQTree(newConstructionNode, childTree)).thenReturn(expected);

    Assertions.assertThrows(
        DataPropertyProjectionTransformer.DataPropertyProjectionTransformerException.class,
        () -> transformer.transformConstruction(iqTree, constructionNode, childTree));
  }

  @Test
  public void transformConstructionWithSingleSubstitutionOfEmptyTermTypeShouldThrowTest() {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(
        mappingExtension,
        iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    String ontoRelId = "ontoRelId";
    String datatypeIriString = "datatypeIri";
    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    ConstructionNode newConstructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    Variable constructionNodeVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> constructionNodeVariableSet = ImmutableSet.of(constructionNodeVariable);
    NonGroundFunctionalTerm term = Mockito.mock(NonGroundFunctionalTerm.class);
    RDFTermFunctionSymbol functionSymbol = Mockito.mock(RDFTermFunctionSymbol.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    SimpleRDFDatatype simpleRDFDatatype = Mockito.mock(SimpleRDFDatatype.class);
    Map<Variable, ImmutableTerm> substitutionMap = ImmutableMap.of(constructionNodeVariable, term);
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);
    IRI datatypeIri = Mockito.mock(IRI.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable originalVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> substitutionTermVariables = ImmutableSet.of(originalVariable);
    Optional<TermType> emptyThereforeInvalidTermType = Optional.empty();

    ArgumentCaptor<ImmutableSet<Variable>> constructionNodeArgumentCaptor =
        ArgumentCaptor.forClass(ImmutableSet.class);
    ArgumentCaptor<Substitution<ImmutableTerm>> substitutionArgumentCaptor =
        ArgumentCaptor.forClass(Substitution.class);

    Mockito.when(substitution.isEmpty()).thenReturn(false);
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(term.getFunctionSymbol()).thenReturn(functionSymbol);
    Mockito.when(term.getTerm(1)).thenReturn(rdfTermTypeConstant);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(simpleRDFDatatype);
    Mockito.when(mappingProperties.getOntoRelId()).thenReturn(ontoRelId);
    Mockito.when(datatypeIri.getIRIString()).thenReturn(datatypeIriString);
    Mockito.when(simpleRDFDatatype.getIRI()).thenReturn(datatypeIri);
    Mockito.when(ontoRelCatRepository.getSqlType(ontoRelId, datatypeIriString)).thenReturn(
        Optional.of(targetType));
    Mockito.when(term.getVariables()).thenReturn(substitutionTermVariables);
    Mockito.when(typeExtractor.extractSingleTermType(originalVariable, iqTree)).thenReturn(
        emptyThereforeInvalidTermType);
    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariableSet);
    Mockito.when(iqFactory.createConstructionNode(constructionNodeArgumentCaptor.capture(),
        substitutionArgumentCaptor.capture())).thenReturn(newConstructionNode);
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(iqTree.getRootNode()).thenReturn(constructionNode);
    Mockito.when(iqFactory.createUnaryIQTree(newConstructionNode, childTree)).thenReturn(expected);

    Assertions.assertThrows(
        DataPropertyProjectionTransformer.DataPropertyProjectionTransformerException.class,
        () -> transformer.transformConstruction(iqTree, constructionNode, childTree));
  }

  @Test
  public void transformConstructionWithSingleSubstitutionOfNonDbTermTypeShouldThrowTest() {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(
        mappingExtension,
        iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    String ontoRelId = "ontoRelId";
    String datatypeIriString = "datatypeIri";
    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    ConstructionNode newConstructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    Variable constructionNodeVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> constructionNodeVariableSet = ImmutableSet.of(constructionNodeVariable);
    NonGroundFunctionalTerm term = Mockito.mock(NonGroundFunctionalTerm.class);
    RDFTermFunctionSymbol functionSymbol = Mockito.mock(RDFTermFunctionSymbol.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    SimpleRDFDatatype simpleRDFDatatype = Mockito.mock(SimpleRDFDatatype.class);
    Map<Variable, ImmutableTerm> substitutionMap = ImmutableMap.of(constructionNodeVariable, term);
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);
    IRI datatypeIri = Mockito.mock(IRI.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable originalVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> substitutionTermVariables = ImmutableSet.of(originalVariable);
    TermType nonDbTermTypeThereforeInvalidVariableType = Mockito.mock(TermType.class);

    ArgumentCaptor<ImmutableSet<Variable>> constructionNodeArgumentCaptor =
        ArgumentCaptor.forClass(ImmutableSet.class);
    ArgumentCaptor<Substitution<ImmutableTerm>> substitutionArgumentCaptor =
        ArgumentCaptor.forClass(Substitution.class);

    Mockito.when(substitution.isEmpty()).thenReturn(false);
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(term.getFunctionSymbol()).thenReturn(functionSymbol);
    Mockito.when(term.getTerm(1)).thenReturn(rdfTermTypeConstant);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(simpleRDFDatatype);
    Mockito.when(mappingProperties.getOntoRelId()).thenReturn(ontoRelId);
    Mockito.when(datatypeIri.getIRIString()).thenReturn(datatypeIriString);
    Mockito.when(simpleRDFDatatype.getIRI()).thenReturn(datatypeIri);
    Mockito.when(ontoRelCatRepository.getSqlType(ontoRelId, datatypeIriString)).thenReturn(
        Optional.of(targetType));
    Mockito.when(term.getVariables()).thenReturn(substitutionTermVariables);
    Mockito.when(typeExtractor.extractSingleTermType(originalVariable, iqTree)).thenReturn(
        Optional.of(nonDbTermTypeThereforeInvalidVariableType));
    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariableSet);
    Mockito.when(iqFactory.createConstructionNode(constructionNodeArgumentCaptor.capture(),
        substitutionArgumentCaptor.capture())).thenReturn(newConstructionNode);
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(iqTree.getRootNode()).thenReturn(constructionNode);
    Mockito.when(iqFactory.createUnaryIQTree(newConstructionNode, childTree)).thenReturn(expected);

    Assertions.assertThrows(
        DataPropertyProjectionTransformer.DataPropertyProjectionTransformerException.class,
        () -> transformer.transformConstruction(iqTree, constructionNode, childTree));
  }

  @Test
  public void transformConstructionSingleTest() {
    DataPropertyProjectionTransformerTester innerTransformer =
        new DataPropertyProjectionTransformerTester(
            mappingExtension,
            iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    DataPropertyProjectionTransformerTester transformer = Mockito.spy(innerTransformer);

    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    ConstructionNode newConstructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    Variable constructionNodeVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> constructionNodeVariableSet = ImmutableSet.of(constructionNodeVariable);
    NonGroundFunctionalTerm term = Mockito.mock(NonGroundFunctionalTerm.class);
    RDFTermFunctionSymbol functionSymbol = Mockito.mock(RDFTermFunctionSymbol.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    SimpleRDFDatatype simpleRDFDatatype = Mockito.mock(SimpleRDFDatatype.class);
    Map<Variable, ImmutableTerm> substitutionMap = ImmutableMap.of(constructionNodeVariable, term);
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);
    DBTermType variableType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable originalVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> substitutionTermVariables = ImmutableSet.of(originalVariable);

    ArgumentCaptor<Substitution<ImmutableTerm>> substitutionArgumentCaptor =
        ArgumentCaptor.forClass(Substitution.class);
    ArgumentCaptor<ImmutableSet<Variable>> constructionNodeArgumentCaptor =
        ArgumentCaptor.forClass(ImmutableSet.class);

    Mockito.when(substitution.isEmpty()).thenReturn(false);
    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(term.getFunctionSymbol()).thenReturn(functionSymbol);
    Mockito.when(term.getTerm(1)).thenReturn(rdfTermTypeConstant);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(simpleRDFDatatype);
    Mockito.doReturn(targetType).when(transformer).getTargetSqlType_p(iqTree, simpleRDFDatatype);
    Mockito.when(term.getVariables()).thenReturn(substitutionTermVariables);
    Mockito.when(typeExtractor.extractSingleTermType(originalVariable, childTree)).thenReturn(
        Optional.of(variableType));
    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariableSet);
    Mockito.doReturn(childTree).when(transformer)
        .calculateAndAddConversion(Mockito.any(), Mockito.eq(constructionNodeVariable),
            Mockito.eq(rdfTermTypeConstant), Mockito.eq(targetType), Mockito.eq(originalVariable),
            Mockito.eq(variableType), Mockito.eq(childTree), Mockito.eq(iqTree));
    Mockito.when(iqFactory.createConstructionNode(constructionNodeArgumentCaptor.capture(),
        substitutionArgumentCaptor.capture())).thenReturn(newConstructionNode);
    Mockito.doReturn(expected).when(transformer)
        .transformUnaryNode_p(iqTree, newConstructionNode, childTree);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(constructionNodeVariableSet, constructionNodeArgumentCaptor.getValue());
    Assertions.assertEquals(null,
        substitutionArgumentCaptor.getValue().get(constructionNodeVariable),
        "The substitution should be updated by the calculateAndAddConversion method.");
  }

  @Test
  public void transformConstructionLoopTest() {
    DataPropertyProjectionTransformerTester innerTransformer =
        new DataPropertyProjectionTransformerTester(
            mappingExtension,
            iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    DataPropertyProjectionTransformerTester transformer = Mockito.spy(innerTransformer);

    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    ConstructionNode newConstructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    Variable constructionNodeVariable1 = Mockito.mock(Variable.class);
    Variable constructionNodeVariable2 = Mockito.mock(Variable.class);
    NonGroundFunctionalTerm term = Mockito.mock(NonGroundFunctionalTerm.class);
    RDFTermFunctionSymbol functionSymbol = Mockito.mock(RDFTermFunctionSymbol.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    SimpleRDFDatatype simpleRDFDatatype = Mockito.mock(SimpleRDFDatatype.class);
    Map<Variable, ImmutableTerm> substitutionMap =
        ImmutableMap.of(constructionNodeVariable1, term, constructionNodeVariable2, term);
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);
    DBTermType variableType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable originalVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> substitutionTermVariables = ImmutableSet.of(originalVariable);

    ArgumentCaptor<Variable> variableArgumentCaptor = ArgumentCaptor.forClass(Variable.class);

    Mockito.when(substitution.isEmpty()).thenReturn(false);
    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(term.getFunctionSymbol()).thenReturn(functionSymbol);
    Mockito.when(term.getTerm(1)).thenReturn(rdfTermTypeConstant);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(simpleRDFDatatype);
    Mockito.doReturn(targetType).when(transformer).getTargetSqlType_p(iqTree, simpleRDFDatatype);
    Mockito.when(term.getVariables()).thenReturn(substitutionTermVariables);
    Mockito.when(typeExtractor.extractSingleTermType(originalVariable, childTree)).thenReturn(
        Optional.of(variableType));
    Mockito.doReturn(childTree).when(transformer)
        .calculateAndAddConversion(Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(),
            Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any());
    Mockito.when(iqFactory.createConstructionNode(Mockito.any(), Mockito.any()))
        .thenReturn(newConstructionNode);
    Mockito.doReturn(expected).when(transformer)
        .transformUnaryNode_p(iqTree, newConstructionNode, childTree);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);

    Mockito.verify(transformer, Mockito.times(2))
        .calculateAndAddConversion(Mockito.any(), variableArgumentCaptor.capture(),
            Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(), Mockito.any(),
            Mockito.any());
    Assertions.assertEquals(constructionNodeVariable1,
        variableArgumentCaptor.getAllValues().get(0));
    Assertions.assertEquals(constructionNodeVariable2,
        variableArgumentCaptor.getAllValues().get(1));
  }

  @ParameterizedTest
  @CsvSource(
      value = {"tname; tname", "tname; TNAME", "\"tname\"; \"tname\"", "\"TNAME\"; \"TNAME\""},
      delimiter = ';')
  public void calculateAndAddConversionSameTypeNameTest(String name1, String name2) {
    DataPropertyProjectionTransformerTester innerTransformer =
        new DataPropertyProjectionTransformerTester(
            mappingExtension,
            iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    DataPropertyProjectionTransformerTester transformer = Mockito.spy(innerTransformer);

    Map<Variable, ImmutableTerm> newSubstitutionMap = Mockito.mock(Map.class);
    Variable substituedVariable = Mockito.mock(Variable.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable variable = Mockito.mock(Variable.class);
    DBTermType variableType = Mockito.mock(DBTermType.class);
    IQTree child = Mockito.mock(IQTree.class);
    IQTree tree = Mockito.mock(IQTree.class);
    NonGroundFunctionalTerm valueTerm = Mockito.mock(NonGroundFunctionalTerm.class);
    NonGroundFunctionalTerm valueFunction = Mockito.mock(NonGroundFunctionalTerm.class);

    Mockito.when(targetType.getName()).thenReturn(name1);
    Mockito.when(variableType.getName()).thenReturn(name2);
    Mockito.when(termFactory.getMMecSimpleCastFunctionalTerm(variableType, targetType, variable))
        .thenReturn(valueTerm);
    Mockito.when(termFactory.getMMecValueFunction(valueTerm, targetType, rdfTermTypeConstant))
        .thenReturn(valueFunction);

    IQTree actual = transformer.calculateAndAddConversion_p(newSubstitutionMap, substituedVariable,
        rdfTermTypeConstant, targetType, variable, variableType, child, tree);

    Assertions.assertEquals(child, actual);
    Mockito.verify(newSubstitutionMap).put(substituedVariable, valueFunction);
  }

  @ParameterizedTest
  @CsvSource(
      value = {"tname; TNAME2", "\"tname\"; tname", "\"TNAME\"; tname", "\"TNAME\"; tname"},
      delimiter = ';')
  public void calculateAndAddConversionDifferentTypeNameConversionNotFoundShouldThrow(
      String name1, String name2) {
    DataPropertyProjectionTransformerTester innerTransformer =
        new DataPropertyProjectionTransformerTester(
            mappingExtension,
            iqFactory, termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    DataPropertyProjectionTransformerTester transformer = Mockito.spy(innerTransformer);

    Map<Variable, ImmutableTerm> newSubstitutionMap = Mockito.mock(Map.class);
    Variable substituedVariable = Mockito.mock(Variable.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable variable = Mockito.mock(Variable.class);
    DBTermType variableType = Mockito.mock(DBTermType.class);
    IQTree child = Mockito.mock(IQTree.class);
    IQTree tree = Mockito.mock(IQTree.class);
    NonGroundFunctionalTerm valueTerm = Mockito.mock(NonGroundFunctionalTerm.class);
    NonGroundFunctionalTerm valueFunction = Mockito.mock(NonGroundFunctionalTerm.class);

    Mockito.when(targetType.getName()).thenReturn(name1);
    Mockito.when(variableType.getName()).thenReturn(name2);
    Mockito.when(mappingExtension.getMappingConversion(variableType, targetType))
        .thenReturn(Optional.empty());

    Assertions.assertThrows(
        DataPropertyProjectionTransformer.DataPropertyProjectionTransformerException.class,
        () -> transformer.calculateAndAddConversion_p(newSubstitutionMap, substituedVariable,
            rdfTermTypeConstant, targetType, variable, variableType, child, tree));
  }



  /**
   * Classe interne permettant de mocker les méthodes protégées de la classe à tester
   */
  static class DataPropertyProjectionTransformerTester extends DataPropertyProjectionTransformer {
    public DataPropertyProjectionTransformerTester(
        MMecMappingExtension mappingExtension,
        IntermediateQueryFactory iqFactory,
        TermFactory termFactory,
        BasicSingleTermTypeExtractor typeExtractor,
        OntoRelCatRepository ontoRelCatRepository,
        MappingProperties mappingProperties) {
      super(mappingExtension, iqFactory, termFactory, typeExtractor, ontoRelCatRepository,
          mappingProperties);
    }

    @Override
    protected IQTree calculateAndAddConversion(Map<Variable, ImmutableTerm> newSubstitutionMap,
        Variable substituedVariable, RDFTermTypeConstant rdfTermTypeConstant, DBTermType targetType,
        Variable variable,
        DBTermType variableType, IQTree child, IQTree tree) {
      return calculateAndAddConversion_p(newSubstitutionMap, substituedVariable,
          rdfTermTypeConstant, targetType, variable, variableType, child, tree);
    }

    @Override
    protected DBTermType getTargetSqlType(IQTree iqTree, SimpleRDFDatatype rdfDatatype) {
      return getTargetSqlType_p(iqTree, rdfDatatype);
    }

    @Override
    protected IQTree transformUnaryNode(IQTree tree, UnaryOperatorNode rootNode, IQTree child) {
      return transformUnaryNode_p(tree, rootNode, child);
    }

    public IQTree calculateAndAddConversion_p(Map<Variable, ImmutableTerm> newSubstitutionMap,
        Variable substituedVariable, RDFTermTypeConstant rdfTermTypeConstant, DBTermType targetType,
        Variable variable,
        DBTermType variableType, IQTree child, IQTree tree) {
      return super.calculateAndAddConversion(newSubstitutionMap, substituedVariable,
          rdfTermTypeConstant, targetType, variable, variableType, child, tree);
    }

    public DBTermType getTargetSqlType_p(IQTree iqTree, SimpleRDFDatatype rdfDatatype) {
      return super.getTargetSqlType(iqTree, rdfDatatype);
    }

    public IQTree transformUnaryNode_p(IQTree tree, UnaryOperatorNode rootNode, IQTree child) {
      return super.transformUnaryNode(tree, rootNode, child);
    }
  }

}

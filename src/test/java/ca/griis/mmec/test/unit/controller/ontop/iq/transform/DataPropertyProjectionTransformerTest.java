package ca.griis.mmec.test.unit.controller.ontop.iq.transform;

import ca.griis.mmec.controller.ontop.iq.transform.DataPropertyProjectionTransformer;
import ca.griis.mmec.controller.ontop.model.term.MMecTermFactory;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.repository.jooq.JooqOntoRelCatRepository;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.type.impl.BasicSingleTermTypeExtractor;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.NonGroundFunctionalTerm;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.RDFTermType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.impl.SimpleRDFDatatype;
import it.unibz.inf.ontop.substitution.Substitution;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.semanticweb.owlapi.model.IRI;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details «Detailed description of the component (optional)»
 * @par Model «Model (Abstract, automation, etc.) (optional)»
 * @par Conception «Conception description (criteria and constraints) (optional)»
 * @par Limits «Limits description (optional)»
 * @brief @~french Tests pour la classe DataPropertyProjectionTransformer
 * @par Détails S.O.
 * @par Modèle S.O.
 * @par Conception S.O.
 * @par Limites S.O.
 * @par Historique 2024-02-01 [SD] - Implémentation initiale<br>
 * @par Tâches S.O.
 */
@SuppressWarnings("unchecked")
public class DataPropertyProjectionTransformerTest {
  private IntermediateQueryFactory iqFactory;
  private MMecTermFactory termFactory;
  private BasicSingleTermTypeExtractor typeExtractor;
  private JooqOntoRelCatRepository ontoRelCatRepository;
  private MappingProperties mappingProperties;

  @BeforeEach
  public void init() {
    iqFactory = Mockito.mock(IntermediateQueryFactory.class);
    termFactory = Mockito.mock(MMecTermFactory.class);
    typeExtractor = Mockito.mock(BasicSingleTermTypeExtractor.class);
    ontoRelCatRepository = Mockito.mock(JooqOntoRelCatRepository.class);
    mappingProperties = Mockito.mock(MappingProperties.class);
  }

  @Test
  public void transformConstructionWithoutSubstitutionAndWithoutRecursionIsIdempotentTest() {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);

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
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);

    IQTree iqTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    IQTree newChildAfterRecurse = Mockito.mock(IQTree.class);
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    Map<Variable, ImmutableTerm> substitutionMap = ImmutableMap.of();
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);

    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(substitution.isEmpty()).thenReturn(true);
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(newChildAfterRecurse);
    Mockito.when(iqTree.getRootNode()).thenReturn(constructionNode);
    Mockito.when(iqFactory.createUnaryIQTree(constructionNode, newChildAfterRecurse))
        .thenReturn(expected);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void transformConstructionWithSingleSubstitutionNotDPTest() {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);

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
    Mockito.when(substitution.stream()).thenReturn(substitutionMap.entrySet().stream());
    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(term.getFunctionSymbol()).thenReturn(functionSymbol);
    Mockito.when(term.getTerm(1)).thenReturn(rdfTermTypeConstant);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(notSimpleRDFDatatype);
    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariable);
    Mockito.when(iqFactory.createConstructionNode(constructionNodeArgumentCaptor.capture(),
        substitutionArgumentCaptor.capture())).thenReturn(newConstructionNode);
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(iqTree.getRootNode()).thenReturn(constructionNode);
    Mockito.when(iqFactory.createUnaryIQTree(newConstructionNode, childTree)).thenReturn(expected);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(constructionNodeVariable, constructionNodeArgumentCaptor.getValue());
    Assertions.assertEquals(substitutionMap.get(variable),
        substitutionArgumentCaptor.getValue().get(variable));
  }

  @Test
  public void transformConstructionWithSingleInvalidDatatypeShouldThrowTest() throws SQLException {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
    String ontoRelId = "ontoRelId";
    String datatypeIriString = "datatypeIri";
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
    SimpleRDFDatatype simpleRDFDatatype = Mockito.mock(SimpleRDFDatatype.class);
    Map<Variable, ImmutableTerm> substitutionMap = ImmutableMap.of(variable, term);
    UnaryIQTree expected = Mockito.mock(UnaryIQTree.class);
    IRI datatypeIri = Mockito.mock(IRI.class);

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
    Mockito.when(ontoRelCatRepository.getSqlType(ontoRelId, datatypeIriString)).thenThrow(
        new SQLException("transformConstructionWithSingleInvalidDatatypeShouldThrowTest thrown"));

    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariable);
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
  public void transformConstructionWithSingleInvalidSubstitutionShouldThrowTest()
      throws SQLException {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);

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
        targetType);
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
  public void transformConstructionWithSingleSubstitutionOfEmptyTermTypeShouldThrowTest()
      throws SQLException {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
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
        targetType);
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
  public void transformConstructionWithSingleSubstitutionOfNonDbTermTypeShouldThrowTest()
      throws SQLException {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
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
        targetType);
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
  public void transformConstructionWithSameTypeNameTest() throws SQLException {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
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
    DBTermType variableType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable originalVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> substitutionTermVariables = ImmutableSet.of(originalVariable);
    String variableTypeName = "variableTypeName";
    String targetTypeName = variableTypeName;

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
        targetType);
    Mockito.when(term.getVariables()).thenReturn(substitutionTermVariables);
    Mockito.when(typeExtractor.extractSingleTermType(originalVariable, iqTree)).thenReturn(
        Optional.of(variableType));
    Mockito.when(variableType.getName()).thenReturn(variableTypeName);
    Mockito.when(targetType.getName()).thenReturn(targetTypeName);
    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariableSet);
    Mockito.when(iqFactory.createConstructionNode(constructionNodeArgumentCaptor.capture(),
        substitutionArgumentCaptor.capture())).thenReturn(newConstructionNode);
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(iqTree.getRootNode()).thenReturn(constructionNode);
    Mockito.when(iqFactory.createUnaryIQTree(newConstructionNode, childTree)).thenReturn(expected);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(constructionNodeVariableSet, constructionNodeArgumentCaptor.getValue());
    Assertions.assertEquals(substitutionMap.get(originalVariable),
        substitutionArgumentCaptor.getValue().get(originalVariable));
  }

  private static Stream<Arguments> transformConstructionWithTrivialCastTestProvider() {
    return Stream.of(
        // Everything can be trivially cast to a type of the string category
        Arguments.of(DBTermType.Category.INTEGER, DBTermType.Category.STRING),
        Arguments.of(DBTermType.Category.DECIMAL, DBTermType.Category.STRING),

        // Every category can be trivially cast to another type of the same category
        Arguments.of(DBTermType.Category.STRING, DBTermType.Category.STRING),
        Arguments.of(DBTermType.Category.INTEGER, DBTermType.Category.INTEGER),
        Arguments.of(DBTermType.Category.DECIMAL, DBTermType.Category.DECIMAL),
        Arguments.of(DBTermType.Category.FLOAT_DOUBLE, DBTermType.Category.FLOAT_DOUBLE),
        Arguments.of(DBTermType.Category.BOOLEAN, DBTermType.Category.BOOLEAN),
        Arguments.of(DBTermType.Category.DATE, DBTermType.Category.DATE),
        Arguments.of(DBTermType.Category.DATETIME, DBTermType.Category.DATETIME),
        Arguments.of(DBTermType.Category.UUID, DBTermType.Category.UUID),
        Arguments.of(DBTermType.Category.JSON, DBTermType.Category.JSON),
        Arguments.of(DBTermType.Category.ARRAY, DBTermType.Category.ARRAY),

        // Other trivial casts
        Arguments.of(DBTermType.Category.INTEGER, DBTermType.Category.DECIMAL),
        Arguments.of(DBTermType.Category.DATE, DBTermType.Category.DATETIME)
    );
  }

  @ParameterizedTest
  @MethodSource("transformConstructionWithTrivialCastTestProvider")
  public void transformConstructionWithTrivialCastTest(DBTermType.Category variableTypeCategory,
      DBTermType.Category targetTypeCategory) throws SQLException {
    DataPropertyProjectionTransformer transformer = new DataPropertyProjectionTransformer(iqFactory,
        termFactory, typeExtractor, ontoRelCatRepository, mappingProperties);
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
    DBTermType variableType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    Variable originalVariable = Mockito.mock(Variable.class);
    ImmutableSet<Variable> substitutionTermVariables = ImmutableSet.of(originalVariable);
    String variableTypeName = String.format("Variable%s", variableTypeCategory.name());
    String targetTypeName = String.format("Target%s",targetTypeCategory.name());
    ImmutableFunctionalTerm expectedTerm = Mockito.mock(ImmutableFunctionalTerm.class);

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
        targetType);
    Mockito.when(term.getVariables()).thenReturn(substitutionTermVariables);
    Mockito.when(typeExtractor.extractSingleTermType(originalVariable, iqTree)).thenReturn(
        Optional.of(variableType));
    Mockito.when(variableType.getName()).thenReturn(variableTypeName);
    Mockito.when(targetType.getName()).thenReturn(targetTypeName);
    Mockito.when(constructionNode.getVariables()).thenReturn(constructionNodeVariableSet);
    Mockito.when(iqFactory.createConstructionNode(constructionNodeArgumentCaptor.capture(),
        substitutionArgumentCaptor.capture())).thenReturn(newConstructionNode);
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(iqTree.getRootNode()).thenReturn(constructionNode);
    Mockito.when(iqFactory.createUnaryIQTree(newConstructionNode, childTree)).thenReturn(expected);
    Mockito.when(variableType.getCategory()).thenReturn(variableTypeCategory);
    Mockito.when(targetType.getCategory()).thenReturn(targetTypeCategory);
    Mockito.when(termFactory.getDBCastFunctionalTerm(variableType, targetType, originalVariable))
        .thenReturn(expectedTerm);

    IQTree actual = transformer.transformConstruction(iqTree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(constructionNodeVariableSet, constructionNodeArgumentCaptor.getValue());
    Assertions.assertEquals(expectedTerm,
        substitutionArgumentCaptor.getValue().get(constructionNodeVariable));
  }

}

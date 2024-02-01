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
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.NonGroundFunctionalTerm;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.RDFTermType;
import it.unibz.inf.ontop.model.type.impl.SimpleRDFDatatype;
import it.unibz.inf.ontop.substitution.Substitution;
import java.sql.SQLException;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.semanticweb.owlapi.model.IRI;

@SuppressWarnings("unchecked")
public class DataPropertyProjectionTransformerTest {
  private IntermediateQueryFactory iqFactory;
  private MMecTermFactory termFactory;
  private BasicSingleTermTypeExtractor typeExtractor;
  private JooqOntoRelCatRepository ontoRelCatRepository;
  private MappingProperties mappingProperties;

  @BeforeEach
  public void initialisation() {
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
  public void transformConstructionWithSingleInvalidDatatypeTest() throws SQLException {
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
        SQLException.class);

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
  public void transformConstructionWithSingleInvalidSubstitutionTest() throws SQLException {
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
    DBTermType dbTermType = Mockito.mock(DBTermType.class);
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
    Mockito.when(ontoRelCatRepository.getSqlType(ontoRelId, datatypeIriString)).thenReturn(
        dbTermType);
    Mockito.when(term.getVariables()).thenReturn(emptyThereforeInvalidSubstitutionTerm);

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

}

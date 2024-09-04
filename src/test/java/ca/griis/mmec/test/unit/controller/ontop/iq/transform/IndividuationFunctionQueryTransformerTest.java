package ca.griis.mmec.test.unit.controller.ontop.iq.transform;

import ca.griis.mmec.controller.ontop.iq.transform.IndividuationFunctionQueryTransformer;
import ca.griis.mmec.controller.ontop.model.term.MMecTermFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.type.impl.BasicSingleTermTypeExtractor;
import it.unibz.inf.ontop.model.term.*;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.IRIStringTemplateFunctionSymbol;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.impl.IRITermType;
import it.unibz.inf.ontop.substitution.Substitution;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class IndividuationFunctionQueryTransformerTest {

  @Mock
  private IntermediateQueryFactory iqFactory;
  @Mock
  private MMecTermFactory termFactory;
  @Mock
  private BasicSingleTermTypeExtractor typeExtractor;

  @InjectMocks
  private IndividuationFunctionQueryTransformer transformer;

  @Test
  public void transformConstructionWithoutIndividuationIsIdempotentTest() {
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    IQTree tree = Mockito.mock(IQTree.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    Variable substituedVariable = Mockito.mock(Variable.class);
    ImmutableTerm term = Mockito.mock(NonGroundFunctionalTerm.class);

    ArgumentCaptor<Substitution<ImmutableTerm>> substitutionCaptor =
        ArgumentCaptor.forClass(Substitution.class);

    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(substitution.stream())
        .thenReturn(ImmutableSet.of(Map.entry(substituedVariable, term)).stream());
    Mockito.when(constructionNode.getVariables()).thenReturn(ImmutableSet.of(substituedVariable));
    Mockito.when(iqFactory.createConstructionNode(Mockito.any(), substitutionCaptor.capture()))
        .thenReturn(constructionNode);
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(tree.getRootNode()).thenReturn(constructionNode);

    IQTree expected = tree;
    IQTree actual = transformer.transformConstruction(tree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(substitutionCaptor.getValue().get(substituedVariable), term);
  }

  @Test
  public void transformConstructionWithIndividuationTest() {
    Substitution<ImmutableTerm> substitution = Mockito.mock(Substitution.class);
    IQTree tree = Mockito.mock(IQTree.class);
    IQTree childTree = Mockito.mock(IQTree.class);
    ConstructionNode constructionNode = Mockito.mock(ConstructionNode.class);
    Variable substituedVariable = Mockito.mock(Variable.class);
    NonGroundFunctionalTerm term = Mockito.mock(NonGroundFunctionalTerm.class);
    NonGroundFunctionalTerm iriFunctionTerm = Mockito.mock(NonGroundFunctionalTerm.class);
    RDFTermFunctionSymbol rdfTermFunctionSymbol = Mockito.mock(RDFTermFunctionSymbol.class);
    IRIStringTemplateFunctionSymbol iriStringTemplateFunctionSymbol =
        Mockito.mock(IRIStringTemplateFunctionSymbol.class);
    String iriStringTemplateFunctionSymbolName = "signatureIdentifier";
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    IRITermType iriTermType = Mockito.mock(IRITermType.class);
    DBConstant identifierForSignatureGroup = Mockito.mock(DBConstant.class);
    Variable signComponent = Mockito.mock(Variable.class);
    TermType signComponentType = Mockito.mock(TermType.class);
    TermType identifierType = Mockito.mock(TermType.class);
    NonGroundFunctionalTerm signatureFunction = Mockito.mock(NonGroundFunctionalTerm.class);

    ArgumentCaptor<Substitution<ImmutableTerm>> substitutionCaptor =
        ArgumentCaptor.forClass(Substitution.class);
    ArgumentCaptor<ImmutableList<ImmutableTerm>> signComponentListCaptor =
        ArgumentCaptor.forClass(ImmutableList.class);
    ArgumentCaptor<ImmutableList<TermType>> signComponentTypeListCaptor =
        ArgumentCaptor.forClass(ImmutableList.class);

    Mockito.when(constructionNode.getSubstitution()).thenReturn(substitution);
    Mockito.when(substitution.stream())
        .thenReturn(ImmutableSet.of(Map.entry(substituedVariable, (ImmutableTerm) term)).stream());
    Mockito.when(term.getFunctionSymbol()).thenReturn(rdfTermFunctionSymbol);
    Mockito.when(term.getTerm(1)).thenReturn(rdfTermTypeConstant);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(iriTermType);
    Mockito.when(term.getTerm(0)).thenReturn(iriFunctionTerm);
    Mockito.when(iriFunctionTerm.getFunctionSymbol()).thenReturn(iriStringTemplateFunctionSymbol);
    Mockito.when(iriStringTemplateFunctionSymbol.getName())
        .thenReturn(iriStringTemplateFunctionSymbolName);
    Mockito.when(termFactory.getDBStringConstant(iriStringTemplateFunctionSymbolName))
        .thenReturn(identifierForSignatureGroup);
    Mockito.when(iriFunctionTerm.getVariables()).thenReturn(ImmutableSet.of(signComponent));
    Mockito.when(termFactory.getMMecSignatureFunction(signComponentTypeListCaptor.capture(),
        signComponentListCaptor.capture())).thenReturn(signatureFunction);

    Mockito.when(typeExtractor.extractSingleTermType(identifierForSignatureGroup, tree))
        .thenReturn(Optional.of(identifierType));
    Mockito.when(typeExtractor.extractSingleTermType(signComponent, tree))
        .thenReturn(Optional.of(signComponentType));

    // Mocking the call for createConstructionNode and transformUnaryNode
    Mockito.when(constructionNode.getVariables()).thenReturn(ImmutableSet.of(substituedVariable));
    Mockito.when(iqFactory.createConstructionNode(Mockito.any(), substitutionCaptor.capture()))
        .thenReturn(constructionNode);
    Mockito.when(childTree.acceptTransformer(transformer)).thenReturn(childTree);
    Mockito.when(tree.getRootNode()).thenReturn(constructionNode);

    IQTree expected = tree;
    IQTree actual = transformer.transformConstruction(tree, constructionNode, childTree);

    Assertions.assertEquals(expected, actual);
    Assertions.assertEquals(substitutionCaptor.getValue().get(substituedVariable),
        signatureFunction);
    Assertions.assertTrue(signComponentListCaptor.getValue().contains(identifierForSignatureGroup));
    Assertions.assertTrue(signComponentListCaptor.getValue().contains(signComponent));
    Assertions.assertTrue(signComponentTypeListCaptor.getValue().contains(identifierType));
    Assertions.assertTrue(signComponentTypeListCaptor.getValue().contains(signComponentType));
  }

}

package ca.griis.mmec.test.unit.controller.ontop.model.term.functionsymbol.db;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecIndividuationFunctionSymbol;
import ca.griis.mmec.controller.ontop.model.type.MMecIndividuationTermType;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.iq.node.VariableNullability;
import it.unibz.inf.ontop.model.term.*;
import it.unibz.inf.ontop.model.term.functionsymbol.FunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.impl.FunctionSymbolImpl;
import it.unibz.inf.ontop.model.type.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MMecIndividuationFunctionSymbolTest {

  @Test
  public void nameContainsNumberOfArgsTest() {
    TermType termTypeId = Mockito.mock(TermType.class);
    TermType termType1 = Mockito.mock(TermType.class);
    TermType termType2 = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termTypeId, termType1, termType2);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);

    MMecIndividuationFunctionSymbol mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbol(argTypes, iriTermType, returnType,
            functionCallTemplate);

    String expected = "Individuation_2";
    String actual = mmecIndividuationFunctionSymbol.getName();

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTermsTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    boolean isInjectiveWithInputType = mmecIndividuationFunctionSymbol
        .isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();

    Assertions.assertTrue(isInjectiveWithInputType);
  }

  @Test
  public void canBePostProcessedTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    boolean canBePostProcessed =
        mmecIndividuationFunctionSymbol.canBePostProcessed(ImmutableList.of());

    Assertions.assertFalse(canBePostProcessed);
  }

  @Test
  public void tolerateNullsTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    boolean tolerateNulls = mmecIndividuationFunctionSymbol.tolerateNulls();

    Assertions.assertFalse(tolerateNulls);
  }

  @Test
  public void getNativeDBStringTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName(%s)";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    String expected = "functionName(firstTerm, secondTerm)";
    ImmutableTerm firstTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableTerm secondTerm = Mockito.mock(ImmutableTerm.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(firstTerm, secondTerm);
    Function<ImmutableTerm, String> termConverter = Mockito.mock(Function.class);

    Mockito.when(termConverter.apply(firstTerm)).thenReturn("firstTerm");
    Mockito.when(termConverter.apply(secondTerm)).thenReturn("secondTerm");

    String actual = mmecIndividuationFunctionSymbol.getNativeDBString(terms, termConverter,
        termFactory);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void inferTypeTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);
    MMecIndividuationTermType expected =
        new MMecIndividuationTermType(termTypeAncestry, returnType);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(expected.getName()).thenReturn("name");

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of();
    var termTypeInference = mmecIndividuationFunctionSymbol.inferType(terms);

    Assertions.assertTrue(termTypeInference.isPresent());
    Assertions.assertTrue(termTypeInference.get().getTermType().isPresent());
    Assertions.assertEquals(expected, termTypeInference.get().getTermType().get());
  }

  @Test
  public void evaluateStrictEqMMecAndSameNumberOfArgTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    ImmutableTerm argTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(argTerm);
    ImmutableFunctionalTerm otherTerm = Mockito.mock(ImmutableFunctionalTerm.class);
    MMecIndividuationFunctionSymbol otherTermFunctionSymbol =
        Mockito.mock(MMecIndividuationFunctionSymbol.class);
    ImmutableTerm otherArgTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> otherTerms = ImmutableList.of(otherArgTerm);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    VariableNullability variableNullability = Mockito.mock(VariableNullability.class);
    ImmutableExpression conjonctionTerm = Mockito.mock(ImmutableExpression.class);
    ArgumentCaptor<ImmutableList<ImmutableExpression>> conjonctionTermsCaptor =
        ArgumentCaptor.forClass(ImmutableList.class);
    ImmutableExpression conjonctionExpression = Mockito.mock(ImmutableExpression.class);
    IncrementalEvaluation expected = Mockito.mock(IncrementalEvaluation.class);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(otherTerm.getFunctionSymbol()).thenReturn(otherTermFunctionSymbol);
    Mockito.when(otherTerm.getTerms()).thenReturn((ImmutableList) otherTerms);
    Mockito.when(termFactory.getStrictEquality(argTerm, otherArgTerm)).thenReturn(conjonctionTerm);
    Mockito.when(termFactory.getConjunction(conjonctionTermsCaptor.capture()))
        .thenReturn(conjonctionExpression);
    Mockito.when(conjonctionExpression.evaluate(variableNullability, true))
        .thenReturn(expected);

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    IncrementalEvaluation actual =
        mmecIndividuationFunctionSymbol.evaluateStrictEq(terms, otherTerm,
            termFactory, variableNullability);

    Assertions.assertSame(expected, actual);
    Assertions.assertSame(conjonctionTerm, conjonctionTermsCaptor.getValue().get(0));
  }

  @Test
  public void evaluateStrictEqMMecAndDifferentNumberOfArgTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    ImmutableTerm argTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(argTerm);
    ImmutableFunctionalTerm otherTerm = Mockito.mock(ImmutableFunctionalTerm.class);
    MMecIndividuationFunctionSymbol otherTermFunctionSymbol =
        Mockito.mock(MMecIndividuationFunctionSymbol.class);
    ImmutableList<? extends ImmutableTerm> otherTerms = ImmutableList.of();
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    VariableNullability variableNullability = Mockito.mock(VariableNullability.class);
    IncrementalEvaluation expected = IncrementalEvaluation.declareIsFalse();

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(otherTerm.getFunctionSymbol()).thenReturn(otherTermFunctionSymbol);
    Mockito.when(otherTerm.getTerms()).thenReturn((ImmutableList) otherTerms);

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    IncrementalEvaluation actual =
        mmecIndividuationFunctionSymbol.evaluateStrictEq(terms, otherTerm,
            termFactory, variableNullability);

    Assertions.assertSame(expected, actual);
  }

  @Test
  public void evaluateStrictEqNotImmutableFunctionalTermAndIncompatibleTypes() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    ImmutableTerm argTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(argTerm);
    ImmutableTerm otherTerm = Mockito.mock(ImmutableTerm.class);
    TermTypeInference otherTermTypeInference = Mockito.mock(TermTypeInference.class);
    TermType otherTermType = Mockito.mock(TermType.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    VariableNullability variableNullability = Mockito.mock(VariableNullability.class);
    IncrementalEvaluation expected = IncrementalEvaluation.declareIsFalse();

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(otherTerm.inferType()).thenReturn(Optional.of(otherTermTypeInference));
    Mockito.when(otherTermTypeInference.getTermType()).thenReturn(Optional.of(otherTermType));

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    IncrementalEvaluation actual =
        mmecIndividuationFunctionSymbol.evaluateStrictEq(terms, otherTerm,
            termFactory, variableNullability);

    Assertions.assertSame(expected, actual);
  }

  @Test
  public void evaluateStrictEqNotImmutableFunctionalTermAndImmutableFunctionalTerm() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    ImmutableTerm argTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(argTerm);
    ImmutableTerm otherTerm = Mockito.mock(ImmutableFunctionalTerm.class);
    TermTypeInference otherTermTypeInference = Mockito.mock(TermTypeInference.class);
    TermType otherTermType = Mockito.mock(DBTermType.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    VariableNullability variableNullability = Mockito.mock(VariableNullability.class);
    IncrementalEvaluation expected =
        MMecIndividuationFunctionSymbolTester.evaluateStrictEqWithFunctionalTermEvaluation;

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(otherTerm.inferType()).thenReturn(Optional.of(otherTermTypeInference));
    Mockito.when(otherTermTypeInference.getTermType()).thenReturn(Optional.of(otherTermType));

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    IncrementalEvaluation actual =
        mmecIndividuationFunctionSymbol.evaluateStrictEq(terms, otherTerm,
            termFactory, variableNullability);

    Assertions.assertSame(expected, actual);
  }

  @Test
  public void evaluateStrictEqNotImmutableFunctionalTermAndNonNullConstant() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    ImmutableTerm argTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(argTerm);
    ImmutableTerm otherTerm = Mockito.mock(NonNullConstant.class);
    TermTypeInference otherTermTypeInference = Mockito.mock(TermTypeInference.class);
    TermType otherTermType = Mockito.mock(DBTermType.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    VariableNullability variableNullability = Mockito.mock(VariableNullability.class);
    IncrementalEvaluation expected = IncrementalEvaluation.declareSameExpression();

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(otherTerm.inferType()).thenReturn(Optional.of(otherTermTypeInference));
    Mockito.when(otherTermTypeInference.getTermType()).thenReturn(Optional.of(otherTermType));

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    IncrementalEvaluation actual =
        mmecIndividuationFunctionSymbol.evaluateStrictEq(terms, otherTerm,
            termFactory, variableNullability);

    Assertions.assertSame(expected, actual);
  }

  @Test
  public void evaluateStrictEqNotImmutableFunctionalTermAndOtherTermIsNull() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    ImmutableTerm argTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(argTerm);
    ImmutableTerm otherTerm = Mockito.mock(ImmutableTerm.class);
    TermTypeInference otherTermTypeInference = Mockito.mock(TermTypeInference.class);
    TermType otherTermType = Mockito.mock(DBTermType.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    VariableNullability variableNullability = Mockito.mock(VariableNullability.class);
    IncrementalEvaluation expected = IncrementalEvaluation.declareIsNull();

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(otherTerm.inferType()).thenReturn(Optional.of(otherTermTypeInference));
    Mockito.when(otherTermTypeInference.getTermType()).thenReturn(Optional.of(otherTermType));
    Mockito.when(otherTerm.isNull()).thenReturn(true);

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    IncrementalEvaluation actual =
        mmecIndividuationFunctionSymbol.evaluateStrictEq(terms, otherTerm,
            termFactory, variableNullability);

    Assertions.assertSame(expected, actual);
  }

  @Test
  public void evaluateStrictEqNotImmutableFunctionalTermAndOtherTermIsNotNull() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    ImmutableTerm argTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(argTerm);
    ImmutableTerm otherTerm = Mockito.mock(ImmutableTerm.class);
    TermTypeInference otherTermTypeInference = Mockito.mock(TermTypeInference.class);
    TermType otherTermType = Mockito.mock(DBTermType.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    VariableNullability variableNullability = Mockito.mock(VariableNullability.class);
    IncrementalEvaluation expected = IncrementalEvaluation.declareSameExpression();

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(otherTerm.inferType()).thenReturn(Optional.of(otherTermTypeInference));
    Mockito.when(otherTermTypeInference.getTermType()).thenReturn(Optional.of(otherTermType));
    Mockito.when(otherTerm.isNull()).thenReturn(false);

    MMecIndividuationFunctionSymbolTester mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);

    IncrementalEvaluation actual =
        mmecIndividuationFunctionSymbol.evaluateStrictEq(terms, otherTerm,
            termFactory, variableNullability);

    Assertions.assertSame(expected, actual);
  }

  @Test
  public void decomposabilityIntoConjunctionTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    ImmutableTerm argTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(argTerm);
    VariableNullability variableNullability = Mockito.mock(VariableNullability.class);
    ImmutableList<? extends ImmutableTerm> otherTerms = ImmutableList.of(argTerm);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);

    MMecIndividuationFunctionSymbolTester symbol =
        new MMecIndividuationFunctionSymbolTester(argTypes, iriTermType, returnType,
            functionCallTemplate);
    Boolean actual = symbol.noWrappingNeeded(terms, variableNullability, otherTerms);

    Assertions.assertTrue(actual);
  }

  @Test
  public void equalsNullTest() {
    TermType termType = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(termType);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType = Mockito.mock(DBTermType.class);
    String functionCallTemplate = "functionName";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);
    FunctionSymbol otherFunctionSymbol = Mockito.mock(FunctionSymbol.class);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);

    MMecIndividuationFunctionSymbol mmecIndividuationFunctionSymbol =
        new MMecIndividuationFunctionSymbol(argTypes, iriTermType, returnType,
            functionCallTemplate);

    boolean actual = mmecIndividuationFunctionSymbol.equals(otherFunctionSymbol);

    Assertions.assertFalse(actual);
  }

  //  @Test
  //  Tests avec tout les cas de noms différentes et les types
  private static Stream<Arguments> equalsTestProvider() {
    TermType termType1 = Mockito.mock(TermType.class);
    TermType termType2 = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes1 = ImmutableList.of(termType1);
    ImmutableList<TermType> argTypes2 = ImmutableList.of(termType2);
    ObjectRDFType iriTermType = Mockito.mock(ObjectRDFType.class);
    DBTermType returnType1 = Mockito.mock(DBTermType.class);
    DBTermType returnType2 = Mockito.mock(DBTermType.class);
    String functionCallTemplate1 = "functionName1";
    String functionCallTemplate2 = "functionName2";
    TermTypeAncestry termTypeAncestry = Mockito.mock(TermTypeAncestry.class);

    Mockito.when(iriTermType.getAncestry()).thenReturn(termTypeAncestry);
    Mockito.when(returnType1.getName()).thenReturn("returnType1");
    Mockito.when(returnType2.getName()).thenReturn("returnType2");

    MMecIndividuationFunctionSymbol base =
        new MMecIndividuationFunctionSymbol(argTypes1, iriTermType, returnType1,
            functionCallTemplate1);

    return Stream.of(
        Arguments.of(base, base, true),
        Arguments.of(base, null, false),
        Arguments.of(base, Mockito.mock(RDFTermFunctionSymbol.class), false),
        Arguments.of(base, new MMecIndividuationFunctionSymbol(argTypes1, iriTermType, returnType1,
            functionCallTemplate1), true),
        Arguments.of(base, new MMecIndividuationFunctionSymbol(argTypes1, iriTermType, returnType1,
            functionCallTemplate1.toLowerCase()), true),
        Arguments.of(base, new MMecIndividuationFunctionSymbol(argTypes1, iriTermType, returnType1,
            functionCallTemplate1.toUpperCase()), true),
        Arguments.of(base, new MMecIndividuationFunctionSymbol(argTypes1, iriTermType, returnType1,
            functionCallTemplate2), false),
        Arguments.of(base, new MMecIndividuationFunctionSymbol(argTypes1, iriTermType, returnType2,
            functionCallTemplate1), false),
        Arguments.of(base, new MMecIndividuationFunctionSymbol(argTypes2, iriTermType, returnType1,
            functionCallTemplate1), false));
  }

  @ParameterizedTest
  @MethodSource("equalsTestProvider")
  public void equalsAndHashCodeTest(MMecIndividuationFunctionSymbol base,
      RDFTermFunctionSymbol other, boolean expected) {
    Assertions.assertEquals(expected, base.equals(other));
    if(other != null) {
      Assertions.assertEquals(expected, base.hashCode() == other.hashCode());
    }
  }

  private static class MMecIndividuationFunctionSymbolTester extends
      MMecIndividuationFunctionSymbol {
    protected static IncrementalEvaluation evaluateStrictEqWithFunctionalTermEvaluation =
        Mockito.mock(IncrementalEvaluation.class);

    public MMecIndividuationFunctionSymbolTester(ImmutableList<TermType> argTypes,
        ObjectRDFType iriTermType, DBTermType returnType, String functionCallTemplate) {
      super(argTypes, iriTermType, returnType, functionCallTemplate);
    }

    public Boolean noWrappingNeeded(ImmutableList<? extends ImmutableTerm> terms,
        VariableNullability variableNullability,
        ImmutableList<? extends ImmutableTerm> otherTerms) {
      return testDecomposabilityIntoConjunction(terms, variableNullability, otherTerms)
          .equals(Decomposability.NO_WRAPPING_NEEDED);
    }

    @Override
    protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
      return super.isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();
    }

    @Override
    protected Decomposability testDecomposabilityIntoConjunction(
        ImmutableList<? extends ImmutableTerm> terms,
        VariableNullability variableNullability,
        ImmutableList<? extends ImmutableTerm> otherTerms) {
      return super.testDecomposabilityIntoConjunction(terms, variableNullability, otherTerms);
    }

    @Override
    protected IncrementalEvaluation evaluateStrictEqWithFunctionalTerm(
        ImmutableList<? extends ImmutableTerm> terms, ImmutableFunctionalTerm otherTerm,
        TermFactory termFactory, VariableNullability variableNullability) {
      return evaluateStrictEqWithFunctionalTermEvaluation;
    }
  }
}

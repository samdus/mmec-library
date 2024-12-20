package ca.griis.mmec.test.unit.controller.ontop.model.term.functionsymbol.db;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecConversionFunctionSymbol;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.DBConstant;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class MMecConversionFunctionSymbolTest {
  @Test
  public void getNativeDBStringTest() {
    String expected = "functionName(firstTermConverted, secondTermConverted)";
    String functionName = "functionName";
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    ImmutableTerm firstTerm = Mockito.mock(ImmutableTerm.class);
    ImmutableTerm secondTerm = Mockito.mock(ImmutableTerm.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(firstTerm, secondTerm);
    Function<ImmutableTerm, String> termConverter = Mockito.mock(Function.class);

    MMecConversionFunctionSymbol mmecConversionFunctionSymbol =
        new MMecConversionFunctionSymbol(functionName, inputType, targetType);

    Mockito.when(termConverter.apply(firstTerm)).thenReturn("firstTermConverted");
    Mockito.when(termConverter.apply(secondTerm)).thenReturn("secondTermConverted");

    String actual = mmecConversionFunctionSymbol.getNativeDBString(terms, termConverter,
        termFactory);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTermsTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionFunctionSymbolTester mmecConversionFunctionSymbol =
        new MMecConversionFunctionSymbolTester("functionName", inputType, targetType);

    boolean isInjectiveWithInputType = mmecConversionFunctionSymbol
        .isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();

    Assertions.assertTrue(isInjectiveWithInputType);
  }

  @Test
  public void tolerateNullsTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionFunctionSymbolTester mmecConversionFunctionSymbol =
        new MMecConversionFunctionSymbolTester("functionName", inputType, targetType);

    boolean tolerateNulls = mmecConversionFunctionSymbol.tolerateNulls();

    Assertions.assertTrue(tolerateNulls);
  }

  @Test
  public void canBePostProcessedTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionFunctionSymbolTester mmecConversionFunctionSymbol =
        new MMecConversionFunctionSymbolTester("functionName", inputType, targetType);
    ImmutableList<? extends ImmutableTerm> immutableList = Mockito.mock(ImmutableList.class);

    boolean canBePostProcessed = mmecConversionFunctionSymbol.canBePostProcessed(immutableList);

    Assertions.assertFalse(canBePostProcessed);
  }

  @Test
  public void convertDBConstantTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionFunctionSymbolTester mmecConversionFunctionSymbol =
        new MMecConversionFunctionSymbolTester("functionName", inputType, targetType);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    DBConstant constant = Mockito.mock(DBConstant.class);
    ImmutableFunctionalTerm expected = Mockito.mock(ImmutableFunctionalTerm.class);

    Mockito.when(termFactory.getImmutableFunctionalTerm(mmecConversionFunctionSymbol, constant))
        .thenReturn(expected);

    ImmutableTerm actual = mmecConversionFunctionSymbol.convertDBConstant(constant,
        termFactory);

    Assertions.assertSame(expected, actual);
  }

  @Test
  public void getInputTypeTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionFunctionSymbol mmecConversionFunctionSymbol =
        new MMecConversionFunctionSymbol("functionName", inputType, targetType);

    Optional<DBTermType> actual = mmecConversionFunctionSymbol.getInputType();

    Assertions.assertTrue(actual.isPresent());
    Assertions.assertSame(inputType, actual.get());
  }

  @Test
  public void isTemporaryTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionFunctionSymbol mmecConversionFunctionSymbol =
        new MMecConversionFunctionSymbol("functionName", inputType, targetType);

    boolean isTemporary = mmecConversionFunctionSymbol.isTemporary();

    Assertions.assertFalse(isTemporary);
  }

  @Test
  public void isSimpleTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionFunctionSymbol mmecConversionFunctionSymbol =
        new MMecConversionFunctionSymbol("functionName", inputType, targetType);

    boolean isSimple = mmecConversionFunctionSymbol.isSimple();

    Assertions.assertFalse(isSimple);
  }

  private static Stream<Arguments> equalsTestProvider() {
    DBTermType type1 = Mockito.mock(DBTermType.class);
    DBTermType type2 = Mockito.mock(DBTermType.class);
    return Stream.of(
        Arguments.of("fn1", type1, "fn2", type2, false),
        Arguments.of("fn1", type1, "fn2", type1, false),
        Arguments.of("fn1", type1, "fn1", type2, false),
        Arguments.of("fn1", type1, "fn1", type1, true));
  }

  @ParameterizedTest
  @MethodSource("equalsTestProvider")
  public void equalsTest(String fnName1, DBTermType inputType1, String fnName2,
      DBTermType inputType2, boolean expected) {
    MMecConversionFunctionSymbol symbol1 = new MMecConversionFunctionSymbol(fnName1, inputType1,
        Mockito.mock(DBTermType.class));
    MMecConversionFunctionSymbol symbol2 = new MMecConversionFunctionSymbol(fnName2, inputType2,
        Mockito.mock(DBTermType.class));

    boolean actual = symbol1.equals(symbol2);

    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("equalsTestProvider")
  public void hashCodeTest(String fnName1, DBTermType inputType1, String fnName2,
      DBTermType inputType2, boolean expected) {
    MMecConversionFunctionSymbol symbol1 = new MMecConversionFunctionSymbol(fnName1, inputType1,
        Mockito.mock(DBTermType.class));
    MMecConversionFunctionSymbol symbol2 = new MMecConversionFunctionSymbol(fnName2, inputType2,
        Mockito.mock(DBTermType.class));

    int hash1 = symbol1.hashCode();
    int hash2 = symbol2.hashCode();

    if (expected) {
      Assertions.assertEquals(hash1, hash2);
    } else {
      Assertions.assertNotEquals(hash1, hash2);
    }
  }

  private static class MMecConversionFunctionSymbolTester extends MMecConversionFunctionSymbol {
    public MMecConversionFunctionSymbolTester(String functionName, DBTermType inputType,
        DBTermType targetType) {
      super(functionName, inputType, targetType);
    }

    @Override
    protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
      return super.isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();
    }

    @Override
    protected boolean tolerateNulls() {
      return super.tolerateNulls();
    }

    @Override
    protected ImmutableTerm convertDBConstant(DBConstant constant, TermFactory termFactory)
        throws DBTypeConversionException {
      return super.convertDBConstant(constant, termFactory);
    }
  }

}

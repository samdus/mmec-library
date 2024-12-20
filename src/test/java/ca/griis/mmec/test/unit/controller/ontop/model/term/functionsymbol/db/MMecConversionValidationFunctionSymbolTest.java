package ca.griis.mmec.test.unit.controller.ontop.model.term.functionsymbol.db;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecConversionValidationFunctionSymbol;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TermType;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

@SuppressWarnings("unchecked")
public class MMecConversionValidationFunctionSymbolTest {

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

    MMecConversionValidationFunctionSymbol mmecConversionValidationFunctionSymbol =
        new MMecConversionValidationFunctionSymbol(functionName, inputType, targetType);

    Mockito.when(termConverter.apply(firstTerm)).thenReturn("firstTermConverted");
    Mockito.when(termConverter.apply(secondTerm)).thenReturn("secondTermConverted");

    String actual = mmecConversionValidationFunctionSymbol.getNativeDBString(terms, termConverter,
        termFactory);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTermsTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionValidationFunctionSymbolTester mmecConversionValidationFunctionSymbol =
        new MMecConversionValidationFunctionSymbolTester("functionName", inputType, targetType);

    boolean isInjectiveWithInputType = mmecConversionValidationFunctionSymbol
        .isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();

    Assertions.assertFalse(isInjectiveWithInputType);
  }

  @Test
  public void tolerateNullsTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionValidationFunctionSymbolTester mmecConversionValidationFunctionSymbol =
        new MMecConversionValidationFunctionSymbolTester("functionName", inputType, targetType);

    boolean tolerateNulls = mmecConversionValidationFunctionSymbol
        .tolerateNulls();

    Assertions.assertTrue(tolerateNulls);
  }

  @Test
  public void canBePostProcessedTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionValidationFunctionSymbol mmecConversionValidationFunctionSymbol =
        new MMecConversionValidationFunctionSymbol("functionName", inputType, targetType);
    ImmutableList<? extends ImmutableTerm> immutableList =
        ImmutableList.of(Mockito.mock(ImmutableTerm.class));

    boolean canBePostProcessed =
        mmecConversionValidationFunctionSymbol.canBePostProcessed(immutableList);

    Assertions.assertTrue(canBePostProcessed);
  }

  @Test
  public void blocksNegationTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionValidationFunctionSymbol mmecConversionValidationFunctionSymbol =
        new MMecConversionValidationFunctionSymbol("functionName", inputType, targetType);

    boolean blocksNegation = mmecConversionValidationFunctionSymbol.blocksNegation();

    Assertions.assertTrue(blocksNegation);
  }

  @Test
  public void negateTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecConversionValidationFunctionSymbol mmecConversionValidationFunctionSymbol =
        new MMecConversionValidationFunctionSymbol("functionName", inputType, targetType);
    ImmutableList<? extends ImmutableTerm> subTerms =
        ImmutableList.of(Mockito.mock(ImmutableTerm.class));
    TermFactory termFactory = Mockito.mock(TermFactory.class);

    Assertions.assertThrows(UnsupportedOperationException.class, () -> {
      mmecConversionValidationFunctionSymbol.negate(subTerms, termFactory);
    });
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
    MMecConversionValidationFunctionSymbol symbol1 =
        new MMecConversionValidationFunctionSymbol(fnName1, inputType1,
            Mockito.mock(DBTermType.class));
    MMecConversionValidationFunctionSymbol symbol2 =
        new MMecConversionValidationFunctionSymbol(fnName2, inputType2,
            Mockito.mock(DBTermType.class));

    boolean actual = symbol1.equals(symbol2);

    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("equalsTestProvider")
  public void hashCodeTest(String fnName1, DBTermType inputType1, String fnName2,
      DBTermType inputType2, boolean expected) {
    MMecConversionValidationFunctionSymbol symbol1 =
        new MMecConversionValidationFunctionSymbol(fnName1, inputType1,
            Mockito.mock(DBTermType.class));
    MMecConversionValidationFunctionSymbol symbol2 =
        new MMecConversionValidationFunctionSymbol(fnName2, inputType2,
            Mockito.mock(DBTermType.class));

    int hash1 = symbol1.hashCode();
    int hash2 = symbol2.hashCode();

    if (expected) {
      Assertions.assertEquals(hash1, hash2);
    } else {
      Assertions.assertNotEquals(hash1, hash2);
    }
  }

  private static class MMecConversionValidationFunctionSymbolTester extends
      MMecConversionValidationFunctionSymbol {
    public MMecConversionValidationFunctionSymbolTester(String functionName, TermType argType,
        DBTermType dbBooleanType) {
      super(functionName, argType, dbBooleanType);
    }

    @Override
    protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
      return super.isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();
    }

    @Override
    protected boolean tolerateNulls() {
      return super.tolerateNulls();
    }
  }
}

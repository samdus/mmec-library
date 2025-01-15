package ca.griis.mmec.test.unit.controller.ontop.model.term.functionsymbol.db;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecSimpleConversionFunctionSymbol;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.DBConstant;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBFunctionSymbolSerializer;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.Serializers;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

@SuppressWarnings({"unchecked", "rawtypes"})
public class MMecSimpleConversionFunctionSymbolTest {

  @Test
  public void getNativeDBStringTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    DBFunctionSymbolSerializer serializer = Mockito.mock(DBFunctionSymbolSerializer.class);
    ImmutableTerm term = Mockito.mock(ImmutableTerm.class);
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of(term);
    Function<ImmutableTerm, String> termConverter = Mockito.mock(Function.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);

    try (MockedStatic<Serializers> mocked = Mockito.mockStatic(Serializers.class)) {
      String expected = "expected";

      mocked.when(() -> Serializers.getCastSerializer(targetType)).thenReturn(serializer);
      Mockito.when(serializer.getNativeDBString(terms, termConverter, termFactory))
          .thenReturn(expected);

      MMecSimpleConversionFunctionSymbol mmecSimpleConversionFunctionSymbol =
          new MMecSimpleConversionFunctionSymbol(inputType, targetType);
      String actual =
          mmecSimpleConversionFunctionSymbol.getNativeDBString(terms, termConverter, termFactory);

      Assertions.assertSame(expected, actual);
    }
  }

  @Test
  public void isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTermsTrueTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(inputType, targetType);

    boolean actual =
        mmecSimpleConversionFunctionSymbol
            .isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();

    Assertions.assertTrue(actual);
  }

  @Test
  public void isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTermsFalseTest() {
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(null, targetType);

    boolean actual =
        mmecSimpleConversionFunctionSymbol
            .isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();

    Assertions.assertFalse(actual);
  }

  @Test
  public void tolerateNullsTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(inputType, targetType);

    boolean actual = mmecSimpleConversionFunctionSymbol.tolerateNulls();

    Assertions.assertTrue(actual);
  }

  @Test
  public void canBePostProcessedTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(inputType, targetType);
    ImmutableList<? extends ImmutableTerm> immutableList = Mockito.mock(ImmutableList.class);

    boolean actual = mmecSimpleConversionFunctionSymbol.canBePostProcessed(immutableList);

    Assertions.assertFalse(actual);
  }

  @Test
  public void convertDBConstantTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(inputType, targetType);
    DBFunctionSymbolSerializer serializer = Mockito.mock(DBFunctionSymbolSerializer.class);
    DBConstant constant = Mockito.mock(DBConstant.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    ImmutableFunctionalTerm expected = Mockito.mock(ImmutableFunctionalTerm.class);

    try (MockedStatic<Serializers> mocked = Mockito.mockStatic(Serializers.class)) {
      mocked.when(() -> Serializers.getCastSerializer(targetType)).thenReturn(serializer);
      Mockito.when(
          termFactory.getImmutableFunctionalTerm(mmecSimpleConversionFunctionSymbol, constant))
          .thenReturn(expected);

      ImmutableTerm actual =
          mmecSimpleConversionFunctionSymbol.convertDBConstant(constant, termFactory);

      Assertions.assertSame(expected, actual);
    }
  }

  @Test
  public void getInputTypeTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(inputType, targetType);

    Optional<DBTermType> actual = mmecSimpleConversionFunctionSymbol.getInputType();

    Assertions.assertTrue(actual.isPresent());
    Assertions.assertSame(inputType, actual.get());
  }

  @Test
  public void getInputTypeNullTest() {
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(null, targetType);

    Optional<DBTermType> actual = mmecSimpleConversionFunctionSymbol.getInputType();

    Assertions.assertFalse(actual.isPresent());
  }

  @Test
  public void isTemporaryTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(inputType, targetType);

    boolean actual = mmecSimpleConversionFunctionSymbol.isTemporary();

    Assertions.assertFalse(actual);
  }

  @Test
  public void isSimpleTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);
    MMecSimpleConversionFunctionSymbolTester mmecSimpleConversionFunctionSymbol =
        new MMecSimpleConversionFunctionSymbolTester(inputType, targetType);

    boolean actual = mmecSimpleConversionFunctionSymbol.isSimple();

    Assertions.assertFalse(actual);
  }

  private static Stream<Arguments> equalsTestProvider() {
    DBTermType inputType1 = Mockito.mock(DBTermType.class);
    DBTermType inputType2 = Mockito.mock(DBTermType.class);
    DBTermType targetType1 = Mockito.mock(DBTermType.class);
    DBTermType targetType2 = Mockito.mock(DBTermType.class);

    Mockito.when(targetType1.getName()).thenReturn("targetType1");
    Mockito.when(targetType2.getName()).thenReturn("targetType2");

    return Stream.of(
        Arguments.of(new MMecSimpleConversionFunctionSymbol(inputType1, targetType1), null, false),
        Arguments.of(new MMecSimpleConversionFunctionSymbol(inputType1, targetType1), "", false),
        Arguments.of(new MMecSimpleConversionFunctionSymbol(inputType1, targetType1), new Object(),
            false),
        Arguments.of(new MMecSimpleConversionFunctionSymbol(inputType1, targetType1),
            new MMecSimpleConversionFunctionSymbol(inputType1, targetType1), true),
        Arguments.of(new MMecSimpleConversionFunctionSymbol(inputType1, targetType1),
            new MMecSimpleConversionFunctionSymbol(inputType2, targetType1), false),
        Arguments.of(new MMecSimpleConversionFunctionSymbol(inputType1, targetType1),
            new MMecSimpleConversionFunctionSymbol(null, targetType1), false),
        Arguments.of(new MMecSimpleConversionFunctionSymbol(inputType1, targetType1),
            new MMecSimpleConversionFunctionSymbol(inputType1, targetType2), false));
  }

  @ParameterizedTest
  @MethodSource("equalsTestProvider")
  public void equalsTest(MMecSimpleConversionFunctionSymbol symbol, Object other,
      boolean expected) {
    boolean actual = symbol.equals(other);
    Assertions.assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("equalsTestProvider")
  public void hasCodeTest(MMecSimpleConversionFunctionSymbol symbol, Object other,
      boolean expectedEquals) {
    if (expectedEquals) {
      Assertions.assertEquals(symbol.hashCode(), other.hashCode());
    } else {
      Assertions.assertNotEquals(symbol.hashCode(),
          Optional.ofNullable(other).orElse(new Object()).hashCode());
    }
  }

  private static class MMecSimpleConversionFunctionSymbolTester
      extends MMecSimpleConversionFunctionSymbol {

    public MMecSimpleConversionFunctionSymbolTester(DBTermType inputType, DBTermType targetType) {
      super(inputType, targetType);
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

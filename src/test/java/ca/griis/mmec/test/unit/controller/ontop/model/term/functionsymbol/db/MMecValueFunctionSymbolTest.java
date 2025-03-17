package ca.griis.mmec.test.unit.controller.ontop.model.term.functionsymbol.db;

import static org.junit.jupiter.api.Assertions.assertThrows;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecValueFunctionSymbol;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.type.*;
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

@SuppressWarnings({"unchecked"})
public class MMecValueFunctionSymbolTest {

  @Test
  public void isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTermsTest() {
    DBTermType valueType = Mockito.mock(DBTermType.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    MetaRDFTermType typeTermType = Mockito.mock(MetaRDFTermType.class);
    RDFDatatype rdfDatatype = Mockito.mock(RDFDatatype.class);

    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(rdfDatatype);

    MMecValueFunctionSymbolTester mmecValueFunctionSymbol =
        new MMecValueFunctionSymbolTester(valueType, rdfTermTypeConstant, typeTermType);

    Assertions.assertTrue(
        mmecValueFunctionSymbol.isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms());
  }

  @Test
  public void canBePostProcessedTest() {
    DBTermType valueType = Mockito.mock(DBTermType.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    MetaRDFTermType typeTermType = Mockito.mock(MetaRDFTermType.class);
    RDFDatatype rdfDatatype = Mockito.mock(RDFDatatype.class);
    ImmutableList<? extends ImmutableTerm> immutableList = Mockito.mock(ImmutableList.class);

    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(rdfDatatype);

    MMecValueFunctionSymbolTester mmecValueFunctionSymbol =
        new MMecValueFunctionSymbolTester(valueType, rdfTermTypeConstant, typeTermType);

    Assertions.assertFalse(mmecValueFunctionSymbol.canBePostProcessed(immutableList));
  }

  @Test
  public void tolerateNullsTest() {
    DBTermType valueType = Mockito.mock(DBTermType.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    MetaRDFTermType typeTermType = Mockito.mock(MetaRDFTermType.class);
    RDFDatatype rdfDatatype = Mockito.mock(RDFDatatype.class);

    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(rdfDatatype);

    MMecValueFunctionSymbolTester mmecValueFunctionSymbol =
        new MMecValueFunctionSymbolTester(valueType, rdfTermTypeConstant, typeTermType);

    Assertions.assertFalse(mmecValueFunctionSymbol.tolerateNulls());
  }

  @Test
  public void getNativeDbStringWrongArityThrowsTest() {
    DBTermType valueType = Mockito.mock(DBTermType.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    MetaRDFTermType typeTermType = Mockito.mock(MetaRDFTermType.class);
    RDFDatatype rdfDatatype = Mockito.mock(RDFDatatype.class);
    ImmutableList<? extends ImmutableTerm> terms = Mockito.mock(ImmutableList.class);
    Function<ImmutableTerm, String> termConverter = Mockito.mock(Function.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);

    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(rdfDatatype);
    Mockito.when(terms.size()).thenReturn(1);

    MMecValueFunctionSymbolTester mmecValueFunctionSymbol =
        new MMecValueFunctionSymbolTester(valueType, rdfTermTypeConstant, typeTermType);

    assertThrows(IllegalArgumentException.class,
        () -> mmecValueFunctionSymbol.getNativeDBString(terms, termConverter, termFactory));
  }

  @Test
  public void getNativeDbStringTest() {
    DBTermType valueType = Mockito.mock(DBTermType.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    MetaRDFTermType typeTermType = Mockito.mock(MetaRDFTermType.class);
    RDFDatatype rdfDatatype = Mockito.mock(RDFDatatype.class);
    ImmutableList<ImmutableTerm> terms = Mockito.mock(ImmutableList.class);
    Function<ImmutableTerm, String> termConverter = Mockito.mock(Function.class);
    TermFactory termFactory = Mockito.mock(TermFactory.class);
    ImmutableTerm term = Mockito.mock(ImmutableTerm.class);
    String termString = "termString";

    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(rdfDatatype);
    Mockito.when(terms.size()).thenReturn(2);
    Mockito.when(terms.get(0)).thenReturn(term);
    Mockito.when(termConverter.apply(term)).thenReturn(termString);

    MMecValueFunctionSymbolTester mmecValueFunctionSymbol =
        new MMecValueFunctionSymbolTester(valueType, rdfTermTypeConstant, typeTermType);

    Assertions.assertEquals(termString,
        mmecValueFunctionSymbol.getNativeDBString(terms, termConverter, termFactory));
  }

  @Test
  public void inferTypeTest() {
    DBTermType valueType = Mockito.mock(DBTermType.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    MetaRDFTermType typeTermType = Mockito.mock(MetaRDFTermType.class);
    RDFDatatype rdfDatatype = Mockito.mock(RDFDatatype.class);
    ImmutableList<ImmutableTerm> terms = Mockito.mock(ImmutableList.class);
    TermTypeInference expected = Mockito.mock(TermTypeInference.class);

    try (MockedStatic<TermTypeInference> mocked = Mockito.mockStatic(TermTypeInference.class)) {
      Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(rdfDatatype);
      mocked.when(() -> TermTypeInference.declareTermType(Mockito.any())).thenReturn(expected);

      MMecValueFunctionSymbolTester mmecValueFunctionSymbol =
          new MMecValueFunctionSymbolTester(valueType, rdfTermTypeConstant, typeTermType);
      Optional<TermTypeInference> actual = mmecValueFunctionSymbol.inferType(terms);

      Assertions.assertTrue(actual.isPresent());
      Assertions.assertEquals(expected, actual.get());
    }
  }

  private static Stream<Arguments> equalsTestProvider() {
    DBTermType valueType1 = Mockito.mock(DBTermType.class);
    DBTermType valueType2 = Mockito.mock(DBTermType.class);
    RDFTermTypeConstant rdfTermTypeConstant1 = Mockito.mock(RDFTermTypeConstant.class);
    RDFTermTypeConstant rdfTermTypeConstant2 = Mockito.mock(RDFTermTypeConstant.class);
    RDFDatatype rdfDatatype1 = Mockito.mock(RDFDatatype.class);
    RDFDatatype rdfDatatype2 = Mockito.mock(RDFDatatype.class);
    MetaRDFTermType typeTermType1 = Mockito.mock(MetaRDFTermType.class);
    MetaRDFTermType typeTermType2 = Mockito.mock(MetaRDFTermType.class);

    Mockito.when(valueType1.getName()).thenReturn("valueType1");
    Mockito.when(valueType2.getName()).thenReturn("valueType2");
    Mockito.when(rdfTermTypeConstant1.getRDFTermType()).thenReturn(rdfDatatype1);
    Mockito.when(rdfTermTypeConstant2.getRDFTermType()).thenReturn(rdfDatatype2);

    return Stream.of(
        Arguments.of(
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType1),
            null, false),
        Arguments.of(
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType1),
            "", false),
        Arguments.of(
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType1),
            new Object(), false),
        Arguments.of(
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType1),
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType1), true),
        Arguments.of(
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType1),
            new MMecValueFunctionSymbol(valueType2, rdfTermTypeConstant1, typeTermType1), false),
        Arguments.of(
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType1),
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant2, typeTermType1), false),
        Arguments.of(
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType1),
            new MMecValueFunctionSymbol(valueType1, rdfTermTypeConstant1, typeTermType2), true));
  }

  @ParameterizedTest
  @MethodSource("equalsTestProvider")
  public void equalsTest(MMecValueFunctionSymbol mmecValueFunctionSymbol, Object other,
      boolean expected) {
    Assertions.assertEquals(expected, mmecValueFunctionSymbol.equals(other));
  }

  @ParameterizedTest
  @MethodSource("equalsTestProvider")
  public void hasCodeTest(MMecValueFunctionSymbol mmecValueFunctionSymbol, Object other,
      boolean expectedEquals) {
    if (expectedEquals) {
      Assertions.assertEquals(mmecValueFunctionSymbol.hashCode(), other.hashCode());
    } else {
      Assertions.assertNotEquals(mmecValueFunctionSymbol.hashCode(),
          Optional.ofNullable(other).orElse(new Object()).hashCode());
    }
  }

  private static class MMecValueFunctionSymbolTester extends MMecValueFunctionSymbol {
    public MMecValueFunctionSymbolTester(DBTermType valueType,
        RDFTermTypeConstant rdfTermTypeConstant, MetaRDFTermType typeTermType) {
      super(valueType, rdfTermTypeConstant, typeTermType);
    }


    @Override
    protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
      return super.isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms();
    }
  }
}

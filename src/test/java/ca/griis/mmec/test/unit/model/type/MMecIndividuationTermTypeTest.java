package ca.griis.mmec.test.unit.model.type;

import ca.griis.mmec.controller.ontop.model.type.MMecIndividuationTermType;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.DBTypeFactory;
import it.unibz.inf.ontop.model.type.RDFDatatype;
import it.unibz.inf.ontop.model.type.TermTypeAncestry;
import it.unibz.inf.ontop.model.type.impl.TermTypeImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecIndividuationTermTypeTest {
  private TermTypeAncestry parentAncestry;
  private DBTermType individuationType;
  private MMecIndividuationTermType mMecIndividuationTermType;

  @BeforeEach
  public void setUp() {
    parentAncestry = Mockito.mock(TermTypeAncestry.class);
    individuationType = Mockito.mock(DBTermType.class);
    mMecIndividuationTermType = new MMecIndividuationTermType(parentAncestry, individuationType);
  }

  @Test
  public void getClosestDbTypeTest() {
    DBTypeFactory dbTypeFactory = Mockito.mock(DBTypeFactory.class);
    Assertions.assertSame(individuationType,
        mMecIndividuationTermType.getClosestDBType(dbTypeFactory));
  }

  @Test
  public void isBlankNodeTest() {
    Assertions.assertFalse(mMecIndividuationTermType.isBlankNode());
  }

  @Test
  public void getNameTest() {
    String expected = "ID";
    Mockito.when(individuationType.getName()).thenReturn(expected);
    Assertions.assertEquals(expected, mMecIndividuationTermType.getName());
  }

  @Test
  public void getCastNameTest() {
    String expected = "ID";
    Mockito.when(individuationType.getCastName()).thenReturn(expected);
    Assertions.assertEquals(expected, mMecIndividuationTermType.getCastName());
  }

  @Test
  public void getCategoryTest() {
    DBTermType.Category expected = Mockito.mock(DBTermType.Category.class);
    Mockito.when(individuationType.getCategory()).thenReturn(expected);
    Assertions.assertSame(expected, mMecIndividuationTermType.getCategory());
  }

  @Test
  public void getNaturalRdfDatatypeTest() {
    RDFDatatype expected = Mockito.mock(RDFDatatype.class);
    Mockito.when(individuationType.getNaturalRDFDatatype())
        .thenReturn(java.util.Optional.of(expected));
    Assertions.assertEquals(expected,
        mMecIndividuationTermType.getNaturalRDFDatatype().orElse(null));
  }

  @Test
  public void isNeedingIRISafeEncodingTest() {
    Mockito.when(individuationType.isNeedingIRISafeEncoding()).thenReturn(true);
    Assertions.assertTrue(mMecIndividuationTermType.isNeedingIRISafeEncoding());

    Mockito.when(individuationType.isNeedingIRISafeEncoding()).thenReturn(false);
    Assertions.assertFalse(mMecIndividuationTermType.isNeedingIRISafeEncoding());
  }

  @Test
  public void areEqualitiesStrictTest() {
    Mockito.when(individuationType.areEqualitiesStrict()).thenReturn(true);
    Assertions.assertTrue(mMecIndividuationTermType.areEqualitiesStrict());

    Mockito.when(individuationType.areEqualitiesStrict()).thenReturn(false);
    Assertions.assertFalse(mMecIndividuationTermType.areEqualitiesStrict());
  }

  @Test
  public void areEqualitiesStrictWithDBTermTypeTest() {
    DBTermType otherType = Mockito.mock(DBTermType.class);

    Mockito.when(individuationType.areEqualitiesStrict(otherType))
        .thenReturn(java.util.Optional.of(true));
    Assertions.assertTrue(mMecIndividuationTermType.areEqualitiesStrict(otherType).orElse(false));

    Mockito.when(individuationType.areEqualitiesStrict(otherType))
        .thenReturn(java.util.Optional.of(false));
    Assertions.assertFalse(mMecIndividuationTermType.areEqualitiesStrict(otherType).orElse(true));
  }

  @Test
  public void areEqualitiesBetweenTwoDBAttributesStrictTest() {
    Mockito.when(individuationType.areEqualitiesBetweenTwoDBAttributesStrict()).thenReturn(true);
    Assertions.assertTrue(mMecIndividuationTermType.areEqualitiesBetweenTwoDBAttributesStrict());

    Mockito.when(individuationType.areEqualitiesBetweenTwoDBAttributesStrict()).thenReturn(false);
    Assertions.assertFalse(mMecIndividuationTermType.areEqualitiesBetweenTwoDBAttributesStrict());
  }

  @Test
  public void isValidLexicalValueTest() {
    String lexicalValue = "lexicalValue";
    Mockito.when(individuationType.isValidLexicalValue(lexicalValue))
        .thenReturn(java.util.Optional.of(true));
    Assertions.assertTrue(
        mMecIndividuationTermType.isValidLexicalValue(lexicalValue).orElse(false));

    Mockito.when(individuationType.isValidLexicalValue(lexicalValue))
        .thenReturn(java.util.Optional.of(false));
    Assertions.assertFalse(
        mMecIndividuationTermType.isValidLexicalValue(lexicalValue).orElse(true));
  }

  @Test
  public void isPreventDistinctRecommendedTest() {
    Mockito.when(individuationType.isPreventDistinctRecommended()).thenReturn(true);
    Assertions.assertTrue(mMecIndividuationTermType.isPreventDistinctRecommended());

    Mockito.when(individuationType.isPreventDistinctRecommended()).thenReturn(false);
    Assertions.assertFalse(mMecIndividuationTermType.isPreventDistinctRecommended());
  }

  @Test
  public void equalsTest() {
    DBTermType individuationType2 = Mockito.mock(DBTermType.class);
    MMecIndividuationTermType mMecIndividuationTermType2 =
        new MMecIndividuationTermType(parentAncestry, individuationType2);

    Assertions.assertNotEquals(null, mMecIndividuationTermType);
    Assertions.assertNotEquals(new Object(), mMecIndividuationTermType);

    Mockito.when(individuationType.getName()).thenReturn("name");
    Assertions.assertEquals(mMecIndividuationTermType, mMecIndividuationTermType);

    Mockito.when(individuationType.getName()).thenReturn("same_name");
    Mockito.when(individuationType2.getName()).thenReturn("same_name");
    Assertions.assertEquals(mMecIndividuationTermType, mMecIndividuationTermType2);

    Mockito.when(individuationType.getName()).thenReturn("first_name");
    Mockito.when(individuationType2.getName()).thenReturn("second_name");
    Assertions.assertNotEquals(mMecIndividuationTermType, mMecIndividuationTermType2);
  }

  @Test
  public void hashCodeTest() {
    String name = "name";
    Mockito.when(individuationType.getName()).thenReturn(name);
    Assertions.assertEquals(name.hashCode(), mMecIndividuationTermType.hashCode());
  }
}

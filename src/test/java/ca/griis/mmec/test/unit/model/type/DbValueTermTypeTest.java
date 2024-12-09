package ca.griis.mmec.test.unit.model.type;

import ca.griis.mmec.controller.ontop.model.type.DbValueTermType;
import it.unibz.inf.ontop.model.type.*;
import org.apache.commons.rdf.api.IRI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class DbValueTermTypeTest {
  private RDFDatatype innerRdfTermType;
  private DBTermType innerDbTermType;
  private DbValueTermType dbValueTermType;

  @BeforeEach
  public void setUp() {
    innerRdfTermType = Mockito.mock(RDFDatatype.class);
    innerDbTermType = Mockito.mock(DBTermType.class);

    dbValueTermType = new DbValueTermType(innerRdfTermType, innerDbTermType);
  }

  @Test
  public void isAbstractFalseTest() {
    Assertions.assertFalse(dbValueTermType.isAbstract());
  }

  @Test
  public void getClosestDBTypeTest() {
    DBTypeFactory dbTypeFactory = Mockito.mock(DBTypeFactory.class);
    Assertions.assertEquals(innerDbTermType, dbValueTermType.getClosestDBType(dbTypeFactory));
  }

  @Test
  public void getNaturalRDFDatatypeTest() {
    Assertions.assertEquals(innerRdfTermType, dbValueTermType.getNaturalRDFDatatype().orElse(null));
  }

  @Test
  public void getNameTest() {
    Mockito.when(innerDbTermType.getName()).thenReturn("name");
    Assertions.assertEquals("name", dbValueTermType.getName());
  }

  @Test
  public void getCastNameTest() {
    Mockito.when(innerDbTermType.getCastName()).thenReturn("castName");
    Assertions.assertEquals("castName", dbValueTermType.getCastName());
  }

  @Test
  public void getCategoryTest() {
    Mockito.when(innerDbTermType.getCategory()).thenReturn(DBTermType.Category.STRING);
    Assertions.assertEquals(DBTermType.Category.STRING, dbValueTermType.getCategory());
  }

  @Test
  public void isNeedingIRISafeEncodingTest() {
    Mockito.when(innerDbTermType.isNeedingIRISafeEncoding()).thenReturn(true);
    Assertions.assertTrue(dbValueTermType.isNeedingIRISafeEncoding());
  }

  @Test
  public void areEqualitiesStrictTest() {
    Mockito.when(innerDbTermType.areEqualitiesStrict()).thenReturn(true);
    Assertions.assertTrue(dbValueTermType.areEqualitiesStrict());
  }

  @Test
  public void areEqualitiesBetweenTwoDBAttributesStrictTest() {
    Mockito.when(innerDbTermType.areEqualitiesBetweenTwoDBAttributesStrict()).thenReturn(true);
    Assertions.assertTrue(dbValueTermType.areEqualitiesBetweenTwoDBAttributesStrict());
  }

  @Test
  public void isValidLexicalValueTest() {
    String lexicalValue = "lexicalValue";
    Mockito.when(innerDbTermType.isValidLexicalValue(lexicalValue)).thenReturn(Optional.of(true));
    Assertions.assertTrue(dbValueTermType.isValidLexicalValue(lexicalValue).orElse(false));
  }

  @Test
  public void isPreventDistinctRecommendedTest() {
    Mockito.when(innerDbTermType.isPreventDistinctRecommended()).thenReturn(true);
    Assertions.assertTrue(dbValueTermType.isPreventDistinctRecommended());
  }

  @Test
  public void getCommonDenominatorTest() {
    DBTermType otherType = Mockito.mock(DBTermType.class);
    DBTermType commonDenominator = Mockito.mock(DBTermType.class);
    Mockito.when(innerRdfTermType.getCommonDenominator(otherType)).thenReturn(commonDenominator);
    Assertions.assertEquals(commonDenominator, dbValueTermType.getCommonDenominator(otherType));
  }

  @Test
  public void getAncestryTest() {
    TermTypeAncestry ancestry = Mockito.mock(TermTypeAncestry.class);
    Mockito.when(innerRdfTermType.getAncestry()).thenReturn(ancestry);
    Assertions.assertEquals(ancestry, dbValueTermType.getAncestry());
  }

  @Test
  public void getLanguageTagTest() {
    LanguageTag langageTag = Mockito.mock(LanguageTag.class);
    Mockito.when(innerRdfTermType.getLanguageTag()).thenReturn(Optional.of(langageTag));
    Assertions.assertEquals(langageTag, dbValueTermType.getLanguageTag().orElse(null));
  }

  @Test
  public void isATermTypeTest() {
    TermType otherTermType = Mockito.mock(TermType.class);
    Mockito.when(innerRdfTermType.isA(otherTermType)).thenReturn(true);
    Assertions.assertTrue(dbValueTermType.isA(otherTermType));
  }

  @Test
  public void isAIriTest() {
    IRI baseDatatypeIri = Mockito.mock(IRI.class);
    Mockito.when(innerRdfTermType.isA(baseDatatypeIri)).thenReturn(true);
    Assertions.assertTrue(dbValueTermType.isA(baseDatatypeIri));
  }

  @Test
  public void getIriTest() {
    IRI iri = Mockito.mock(IRI.class);
    Mockito.when(innerRdfTermType.getIRI()).thenReturn(iri);
    Assertions.assertEquals(iri, dbValueTermType.getIRI());
  }

}

package ca.griis.mmec.test.unit.model.type.impl;

import ca.griis.mmec.controller.ontop.model.type.impl.MMecPostgreSqlDbTypeFactory;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TermTypeAncestry;
import it.unibz.inf.ontop.model.type.TypeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecPostgreSqlDbTypeFactoryTest {
  private MMecPostgreSqlDbTypeFactoryTester mmecPostgreSqlDbTypeFactoryTester;

  @BeforeEach
  public void setUp() {
    TermType rootTermType = Mockito.mock(TermType.class);
    TermTypeAncestry rootAncestry = Mockito.mock(TermTypeAncestry.class);
    TypeFactory typeFactory = Mockito.mock(TypeFactory.class);

    Mockito.when(rootTermType.getAncestry()).thenReturn(rootAncestry);
    Mockito.when(rootAncestry.newAncestry(Mockito.any())).thenReturn(rootAncestry);

    mmecPostgreSqlDbTypeFactoryTester =
        new MMecPostgreSqlDbTypeFactoryTester(rootTermType, typeFactory);
  }

  @Test
  public void preprocessTypeNameRemovesOptionalLengthTest() {
    String typeName = "type(10)";
    String expected = "TYPE";

    String actual = mmecPostgreSqlDbTypeFactoryTester.preprocessTypeName(typeName);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void preprocessTypeNameDoNotUpperCaseWhenQuotedTest() {
    String typeName = "\"type\"";
    String expected = "\"type\"";

    String actual = mmecPostgreSqlDbTypeFactoryTester.preprocessTypeName(typeName);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void preprocessTypeNameWithColumnSizeRemovesOptionalLengthTest() {
    String typeName = "type(10)";
    String expected = "TYPE";

    String actual = mmecPostgreSqlDbTypeFactoryTester.preprocessTypeName(typeName, 1);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void preprocessTypeNameWithColumnSizeDoNotUpperCaseWhenQuotedTest() {
    String typeName = "\"type\"";
    String expected = "\"type\"";

    String actual = mmecPostgreSqlDbTypeFactoryTester.preprocessTypeName(typeName, 1);

    Assertions.assertEquals(expected, actual);
  }

  private static class MMecPostgreSqlDbTypeFactoryTester extends MMecPostgreSqlDbTypeFactory {
    protected MMecPostgreSqlDbTypeFactoryTester(TermType rootTermType, TypeFactory typeFactory) {
      super(rootTermType, typeFactory);
    }

    @Override
    protected String preprocessTypeName(String typeName) {
      return super.preprocessTypeName(typeName);
    }

    @Override
    protected String preprocessTypeName(String typeName, int columnSize) {
      return super.preprocessTypeName(typeName, columnSize);
    }
  }
}

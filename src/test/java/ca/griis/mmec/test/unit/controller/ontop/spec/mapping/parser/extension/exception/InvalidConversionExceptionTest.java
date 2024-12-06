package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.parser.extension.exception;

import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.InvalidConversionException;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class InvalidConversionExceptionTest {
  @Test
  public void gettersTest() {
    BlankNodeOrIRI conversionTriple = Mockito.mock(BlankNodeOrIRI.class);
    String reason = "reason";

    InvalidConversionException invalidConversionException =
        new InvalidConversionException(conversionTriple, reason) {};

    Assertions.assertSame(conversionTriple, invalidConversionException.getConversionTriple());
    Assertions.assertTrue(
        invalidConversionException.getMessage().contains(conversionTriple.toString()));
    Assertions.assertTrue(invalidConversionException.getMessage().contains(reason));
  }
}

package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.parser.extension.exception;

import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SignatureComponentMismatchException;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SignatureComponentMismatchExceptionTest {
  @Test
  public void gettersTest() {
    BlankNodeOrIRI invalidNode = Mockito.mock(BlankNodeOrIRI.class);
    BlankNodeOrIRI parentNode = Mockito.mock(BlankNodeOrIRI.class);
    String invalidNodeName = "invalidNodeName";
    String parentNodeName = "parentNodeName";

    Mockito.when(invalidNode.ntriplesString()).thenReturn(invalidNodeName);
    Mockito.when(parentNode.ntriplesString()).thenReturn(parentNodeName);

    SignatureComponentMismatchException signatureComponentMismatchException =
        new SignatureComponentMismatchException(invalidNode, parentNode);

    Assertions.assertSame(invalidNode, signatureComponentMismatchException.getInvalidNode());
    Assertions.assertSame(parentNode, signatureComponentMismatchException.getParentNode());
    Assertions.assertTrue(
        signatureComponentMismatchException.getMessage().contains(invalidNodeName));
    Assertions.assertTrue(
        signatureComponentMismatchException.getMessage().contains(parentNodeName));
  }
}

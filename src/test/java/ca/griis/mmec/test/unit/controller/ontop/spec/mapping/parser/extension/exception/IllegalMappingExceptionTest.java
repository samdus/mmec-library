package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.parser.extension.exception;

import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.IllegalMappingException;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IllegalMappingExceptionTest {

  @Test
  public void gettersTest() {
    BlankNodeOrIRI node = Mockito.mock(BlankNodeOrIRI.class);
    String reason = "reason";
    String nodeName = "nodeName";

    Mockito.when(node.ntriplesString()).thenReturn(nodeName);

    IllegalMappingException illegalMappingException = new IllegalMappingException(node, reason) {
    };

    Assertions.assertSame(node, illegalMappingException.getInvalidNode());
    Assertions.assertTrue(illegalMappingException.getMessage().contains(reason));
    Assertions.assertTrue(illegalMappingException.getMessage().contains(nodeName));
  }
}

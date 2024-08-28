package ca.griis.mmec.test.unit.api.exception;

import ca.griis.mmec.api.exception.DefaultOntopConfigurationNotFoundException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefaultOntopConfigurationNotFoundExceptionTest {
  @Test
  public void testDefaultOntopConfigurationNotFoundException() {
    SQLException cause = new SQLException();
    DefaultOntopConfigurationNotFoundException e =
        new DefaultOntopConfigurationNotFoundException(cause);

    Assertions.assertNotNull(e);
    Assertions.assertNotNull(e.getMessage());
    Assertions.assertNotEquals("", e.getMessage());
    Assertions.assertEquals(cause, e.getCause());
  }
}

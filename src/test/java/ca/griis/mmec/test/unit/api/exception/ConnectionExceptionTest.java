package ca.griis.mmec.test.unit.api.exception;

import ca.griis.mmec.api.exception.ConnectionException;
import java.sql.SQLException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectionExceptionTest {
  @Test
  public void testConnectionException() {
    SQLException cause = new SQLException();
    ConnectionException connectionException = new ConnectionException(cause);

    Assertions.assertNotNull(connectionException);
    Assertions.assertNotNull(connectionException.getMessage());
    Assertions.assertNotEquals("", connectionException.getMessage());
    Assertions.assertEquals(cause, connectionException.getCause());
  }
}

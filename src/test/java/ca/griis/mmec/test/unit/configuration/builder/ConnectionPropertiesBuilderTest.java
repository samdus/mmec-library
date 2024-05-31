/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe ConnectionConfigurationBuilderTest.
 * @brief @~english ConnectionConfigurationBuilderTest class implementation.
 */

package ca.griis.mmec.test.unit.configuration.builder;

import ca.griis.mmec.properties.ConnectionProperties;
import ca.griis.mmec.properties.MissingPropertyException;
import ca.griis.mmec.properties.builder.ConnectionPropertiesBuilder;
import java.io.IOException;
import java.util.Properties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details
 *      «Detailed description of the component (optional)»
 * @par Model
 *      «Model (Abstract, automation, etc.) (optional)»
 * @par Conception
 *      «Conception description (criteria and constraints) (optional)»
 * @par Limits
 *      «Limits description (optional)»
 *
 * @brief @~french Test de la classe ConnectionConfigurationBuilder.
 * @par Détails
 *      S.O.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2023-09-07 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class ConnectionPropertiesBuilderTest {
  private ConnectionPropertiesBuilder builder;

  @BeforeEach
  public void setUp() {
    builder = new ConnectionPropertiesBuilder();
  }

  @Test
  public void testBuildConnectionConfiguration() throws MissingPropertyException {
    String driverName = "TestDriver";
    String databaseName = "TestDatabase";
    String jdbcUrl = "jdbc:test";
    String username = "testuser";
    String password = "testpassword";

    ConnectionProperties actualProperties = builder
        .withDriverName(driverName)
        .withDatabaseName(databaseName)
        .withJdbcUrl(jdbcUrl)
        .withUsername(username)
        .withPassword(password)
        .build();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertEquals(driverName, actualProperties.getDriverName());
    Assertions.assertEquals(databaseName, actualProperties.getDatabaseName());
    Assertions.assertEquals(jdbcUrl, actualProperties.getJdbcUrl());
    Assertions.assertEquals(username, actualProperties.getUsername());
    Assertions.assertEquals(password, actualProperties.getPassword());
  }

  @Test
  public void testBuildConnexionGetOntopConfiguration() throws IOException,
      MissingPropertyException {
    String driverName = "TestDriver";
    String databaseName = "TestDatabase";
    String jdbcUrl = "jdbc:test";
    String username = "testuser";
    String password = "testpassword";

    ConnectionProperties actualProperties = builder
        .withDriverName(driverName)
        .withDatabaseName(databaseName)
        .withJdbcUrl(jdbcUrl)
        .withUsername(username)
        .withPassword(password)
        .build();
    Properties propertiesForOntop = actualProperties.getPropertiesForOntop();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertEquals(propertiesForOntop.get("jdbc.driver"),
        actualProperties.getDriverName());
    Assertions.assertEquals(propertiesForOntop.get("jdbc.name"),
        actualProperties.getDatabaseName());
    Assertions.assertEquals(propertiesForOntop.get("jdbc.url"), actualProperties.getJdbcUrl());
    Assertions.assertEquals(propertiesForOntop.get("jdbc.user"), actualProperties.getUsername());
    Assertions.assertEquals(propertiesForOntop.get("jdbc.password"),
        actualProperties.getPassword());
  }
}

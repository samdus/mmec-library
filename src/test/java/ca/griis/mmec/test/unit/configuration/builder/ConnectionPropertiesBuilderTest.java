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
import ca.griis.mmec.properties.builder.ConnectionPropertiesBuilder;
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
  public void testBuildConnectionConfiguration() {
    String driverName = "TestDriver";
    String databaseName = "TestDatabase";
    String jdbcUrl = "jdbc:test";
    String username = "testuser";
    String password = "testpassword";

    ConnectionProperties configuration = builder
        .setDriverName(driverName)
        .setDatabaseName(databaseName)
        .setJdbcUrl(jdbcUrl)
        .setUsername(username)
        .setPassword(password)
        .build();

    Assertions.assertEquals(driverName, configuration.getDriverName());
    Assertions.assertEquals(databaseName, configuration.getDatabaseName());
    Assertions.assertEquals(jdbcUrl, configuration.getJdbcUrl());
    Assertions.assertEquals(username, configuration.getUsername());
    Assertions.assertEquals(password, configuration.getPassword());
  }

  @Test
  public void testBuildConnexionGetOntopConfiguration() {
    String driverName = "TestDriver";
    String databaseName = "TestDatabase";
    String jdbcUrl = "jdbc:test";
    String username = "testuser";
    String password = "testpassword";

    ConnectionProperties configuration = builder
        .setDriverName(driverName)
        .setDatabaseName(databaseName)
        .setJdbcUrl(jdbcUrl)
        .setUsername(username)
        .setPassword(password)
        .build();
    Properties propertiesForOntop = configuration.getPropertiesForOntop();

    Assertions.assertEquals(propertiesForOntop.get("jdbc.driver"), configuration.getDriverName());
    Assertions.assertEquals(propertiesForOntop.get("jdbc.name"), configuration.getDatabaseName());
    Assertions.assertEquals(propertiesForOntop.get("jdbc.url"), configuration.getJdbcUrl());
    Assertions.assertEquals(propertiesForOntop.get("jdbc.user"), configuration.getUsername());
    Assertions.assertEquals(propertiesForOntop.get("jdbc.password"), configuration.getPassword());
  }
}

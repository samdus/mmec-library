/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation du constructeur pour la configuration de connexion.
 * @brief @~english Implementation of the constructor for the connection configuration.
 */
package ca.griis.mmec.configuration.builder;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.configuration.ConnectionConfiguration;

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
 * @brief @~french Objet contenant les informations de connexion à la source de données
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
 *      2023-09-01 [SD] - Implémentation initiale.
 *
 * @par Tâches
 *      S.O.
 */
public class ConnectionConfigurationBuilder {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(ConnectionConfigurationBuilder.class);

  private String driverName;
  private String databaseName;
  private String jdbcUrl;
  private String username;
  private String password;

  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Spécifie le nom du pilote JDBC.
   * @return Le constructeur de configuration de connexion en cours de configuration.
   */
  public ConnectionConfigurationBuilder setDriverName(String driverName) {
    this.driverName = driverName;
    return this;
  }

  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Spécifie le nom de la base de données.
   * @return Le constructeur de configuration de connexion en cours de configuration.
   */
  public ConnectionConfigurationBuilder setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
    return this;
  }


  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Spécifie l'url de la base de données.
   * @return Le constructeur de configuration de connexion en cours de configuration.
   */
  public ConnectionConfigurationBuilder setJdbcUrl(String jdbcUrl) {
    this.jdbcUrl = jdbcUrl;
    return this;
  }

  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Spécifie le nom d'utilisateur de la base de données.
   * @return Le constructeur de configuration de connexion en cours de configuration.
   */
  public ConnectionConfigurationBuilder setUsername(String username) {
    this.username = username;
    return this;
  }

  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Spécifie le mot de passe de la base de données.
   * @return Le constructeur de configuration de connexion en cours de configuration.
   */
  public ConnectionConfigurationBuilder setPassword(String password) {
    this.password = password;
    return this;
  }

  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Construit la configuration de connexion.
   * @par Details
   *      S.O.
   * @return La configuration de connexion à partir des paramètres spécifiés.
   */
  public ConnectionConfiguration build() {
    logger.trace(Trace.ENTER_METHOD_0);

    return new ConnectionConfiguration() {
      @Override
      public String getDriverName() {
        return driverName;
      }

      @Override
      public String getDatabaseName() {
        return databaseName;
      }

      @Override
      public String getJdbcUrl() {
        return jdbcUrl;
      }

      @Override
      public String getUsername() {
        return username;
      }

      @Override
      public String getPassword() {
        return password;
      }
    };
  }
}

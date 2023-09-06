/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'objet de configuration de la connexion à la base de données.
 * @brief @~english Implementation of the database connection configuration object.
 */
package ca.griis.mmec.configuration;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;

import java.util.Properties;

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
 * @brief @~french Objet contenant les configurations de connexion à la source de données.
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
 *      2023-09-01 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public abstract class ConnectionConfiguration {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(ConnectionConfiguration.class);

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer le nom du pilote de la base de données.
   * @return Le nom du pilote de la base de données.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   * @par Tâches
   *    S.O.
   */
  public abstract String getDriverName();

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer le nom de la base de données.
   * @return Le nom de la base de données.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   * @par Tâches
   *    S.O.
   */
  public abstract String getDatabaseName();

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer l'URL de connexion à la base de données.
   * @return Le nom de la base de données.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   * @par Tâches
   *    S.O.
   */
  public abstract String getJdbcUrl();

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer le nom d'utilisateur de la base de données.
   * @return Le nom d'utilisateur de la base de données.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *    S.O.
   */
  public abstract String getUsername();

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer le mot de passe de la base de données.
   * @return Le mot de passe de la base de données.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *    S.O.
   */
  public abstract String getPassword();

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer les propriétés dans un format compréhensible pour Ontop
   * @return un Object Properties contenant les propriétés de connexion à la base de données.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   * @par Tâches
   *    S.O.
   */
  public Properties getPropertiesForOntop() {
    logger.trace(Trace.ENTER_METHOD_0);

    Properties properties = new Properties();
    properties.setProperty("jdbc.driver", getDriverName());
    properties.setProperty("jdbc.name", getDatabaseName());
    properties.setProperty("jdbc.url", getJdbcUrl());
    properties.setProperty("jdbc.user", getUsername());
    properties.setProperty("jdbc.password", getPassword());

    logger.trace(Trace.EXIT_METHOD_0);
    return properties;
  }
}

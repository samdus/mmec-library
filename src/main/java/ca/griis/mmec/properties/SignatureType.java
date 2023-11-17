/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'énumération SignatureType.
 * @brief @~english SignatureType enum implementation.
 */

package ca.griis.mmec.properties;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;

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
 * @brief @~french Enumération des types de signature qui sont prédéfinies.
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
 *      2023-11-17 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public enum SignatureType {
  /**
   * Signatures définies à l'aide de la concaténation des attributs identifiants.
   */
  STRING("sql_template/postgres/signature_string.stg");

  private static final GriisLogger logger = GriisLoggerFactory.getLogger(SignatureType.class);
  private String stgPath;

  SignatureType(String resourcePath) {
    this.stgPath = resourcePath;
  }

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer le chemin vers le fichier de gabarit de la signature.
   * @return Le chemin vers le fichier de gabarit de ce type de signature.
   *
   * @note S.O.
   *
   * @par Tâches
   *      S.O.
   */
  public String getStgPath() {
    logger.trace(Trace.ENTER_METHOD_0);
    return stgPath;
  }
}

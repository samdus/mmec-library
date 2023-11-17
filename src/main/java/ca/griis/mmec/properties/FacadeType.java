/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'énumération FacadeType.
 * @brief @~english FacadeType enum implementation.
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
 * @brief @~french Enumération des types de façade qui sont prédéfinies.
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
public enum FacadeType {
  /**
   * Façade d'arrimage à partir de vues.
   */
  VIEWS("sql_template/postgres/facade_views.stg");

  private static final GriisLogger logger = GriisLoggerFactory.getLogger(FacadeType.class);
  private String stgPath;

  FacadeType(String stgPath) {
    this.stgPath = stgPath;
  }

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer le chemin vers le fichier de gabarit de la façade.
   * @return Le chemin vers le fichier de gabarit de ce type de façade.
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

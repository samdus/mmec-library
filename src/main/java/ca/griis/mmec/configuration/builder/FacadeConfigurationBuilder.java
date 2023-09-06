/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation du constructeur pour la configuration d'une façade d'arrimage.
 * @brief @~english Implementation of the constructor for the mapping facade configuration.
 */
package ca.griis.mmec.configuration.builder;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.configuration.FacadeConfiguration;


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
 * @brief @~french Constructeur d'objet contenant les configurations de la façade d'arrimage.
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
public class FacadeConfigurationBuilder {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(FacadeConfigurationBuilder.class);

  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Construit l'instance de configuration de façade
   * @par Details
   *      S.O.
   * @return La configuration de la façade d'arrimage à partir des paramètres spécifiés.
   */
  public FacadeConfiguration build() {
    logger.trace(Trace.ENTER_METHOD_0);

    return new FacadeConfiguration() {
    };
  }
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'interface MMecFacadeService.
 * @brief @~english Implementation of the MMecFacadeService interface.
 */

package ca.griis.mmec.api;

import ca.griis.mmec.configuration.ConnectionConfiguration;
import ca.griis.mmec.configuration.FacadeConfiguration;
import ca.griis.mmec.configuration.MappingConfiguration;
import ca.griis.mmec.model.MMecFacade;

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
 * @brief @~french Offre les services en lien avec la génération de façade MMec.
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
public interface MMecFacadeService {
  /**
   * @brief @~english «Description of the function»
   * @param «parameter name» «Parameter description»
   * @exception «exception name» «Exception description»
   * @return «Return description»
   *
   * @brief @~french Création d'une façade MMec à partir .
   * @param mmecFacadeConfiguration La configuration de la façade MMec.
   * @return La façade MMec.
   *
   * @par Tâches
   *      S.O.
   */
  MMecFacade createFacade(ConnectionConfiguration connectionConfiguration,
      MappingConfiguration mappingConfiguration, FacadeConfiguration mmecFacadeConfiguration);
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecFacadeView.
 * @brief @~english MMecFacadeView class implementation.
 */

package ca.griis.mmec.view;

import ca.griis.mmec.model.ImMecFacade;

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
 * @brief @~french Classe responsable de la représentation textuelle d'une façade MMec
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
 *      2023-11-20 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecFacadeView implements ImMecFacadeView {
  @Override
  public String getFacadeInstallScript(ImMecFacade facade) {
    return null;
  }

  @Override
  public String getFacadeUninstallScript(ImMecFacade facade) {
    return null;
  }
}

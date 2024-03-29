/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe FacadePropertiesImpl.
 * @brief @~english FacadePropertiesImpl class implementation.
 */

package ca.griis.mmec.properties.impl;

import ca.griis.mmec.properties.FacadeProperties;
import java.net.URL;

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
 * @brief @~french Configurations de la façade d'arrimage.
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
 *      2024-01-29 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class FacadePropertiesImpl extends FacadeProperties {
  private final URL facadeStgUrl;

  public FacadePropertiesImpl(URL facadeStgUrl) {
    this.facadeStgUrl = facadeStgUrl;
  }

  @Override
  public URL getFacadeStgUrl() {
    return facadeStgUrl;
  }

}

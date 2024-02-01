/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MappingPropertiesImpl.
 * @brief @~english MappingPropertiesImpl class implementation.
 */

package ca.griis.mmec.properties.impl;

import ca.griis.mmec.properties.MappingProperties;

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
 * @brief @~french Configurations de l'arrimage.
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
public class MappingPropertiesImpl extends MappingProperties {
  private String ontoRelId;

  public MappingPropertiesImpl(String ontoRelId) {
    this.ontoRelId = ontoRelId;
  }

  @Override
  public String getOntoRelId() {
    return ontoRelId;
  }
}

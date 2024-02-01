/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecModule.
 * @brief @~english MMecModule class implementation.
 */

package it.unibz.inf.ontop.injection.impl;

import ca.griis.mmec.properties.FacadeProperties;
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
 * @brief @~french Module Guice servant à injecter les dépendances MMec
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
public class MMecModule extends OntopAbstractModule {
  private final MMecConfiguration configuration;

  protected MMecModule(MMecConfiguration configuration) {
    super(configuration.getSettings());
    this.configuration = configuration;
  }

  @Override
  protected void configure() {
    bind(FacadeProperties.class).toInstance(configuration.getFacadeProperties());
    bind(MappingProperties.class).toInstance(configuration.getMappingProperties());
  }
}

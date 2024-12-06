/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecModule.
 * @brief @~english MMecModule class implementation.
 */

package it.unibz.inf.ontop.injection.impl;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.repository.OntoRelCatRepository;
import ca.griis.mmec.view.MappedOntoRelTableView;
import org.jooq.DSLContext;

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
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecModule.class);
  private final MMecConfiguration configuration;

  protected MMecModule(MMecConfiguration configuration) {
    super(configuration.getSettings());
    this.configuration = configuration;
  }

  @Override
  protected void configure() {
    logger.trace(Trace.ENTER_METHOD_0);

    bind(FacadeProperties.class).toInstance(configuration.getFacadeProperties());
    bind(MappingProperties.class).toInstance(configuration.getMappingProperties());
    bind(DSLContext.class).toInstance(configuration.getJooqContext());
    bind(MMecMappingExtension.class).toInstance(new MMecMappingExtension());

    bindFromSettings(OntoRelCatRepository.class);
    bindFromSettings(MappedOntoRelTableView.class);
  }

}

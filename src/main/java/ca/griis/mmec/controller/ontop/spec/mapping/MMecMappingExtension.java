/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe MMecMappingExtension.
 * @brief @~english MMecMappingExtension class implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
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
 *      2024-03-05 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecMappingExtension {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecMappingExtension.class);
  private final Map<DBTermType, Map<DBTermType, MMecMappingConversion>> conversions;

  public MMecMappingExtension() {
    this.conversions = new HashMap<>();
  }

  public Optional<MMecMappingConversion> getMappingConversion(DBTermType from, DBTermType to) {
    logger.trace(Trace.ENTER_METHOD_2, from, to);
    return Optional.ofNullable(conversions.get(from))
        .map(m -> m.get(to));
  }

  public void addMappingConversion(MMecMappingConversion addedConversion) {
    logger.trace(Trace.ENTER_METHOD_1, addedConversion);
    conversions.computeIfAbsent(addedConversion.getInputType(), k -> new HashMap<>())
        .put(addedConversion.getOutputType(), addedConversion);
    logger.trace(Trace.EXIT_METHOD_0);
  }
}

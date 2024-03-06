/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecMappingExtension.
 * @brief @~english MMecMappingExtension class implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping;

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
  private final Map<DBTermType, Map<DBTermType, MMecMappingConversion>> conversions;

  public MMecMappingExtension() {
    this.conversions = new HashMap<>();
  }

  public Optional<MMecMappingConversion> getMappingConversion(DBTermType from, DBTermType to) {
    return Optional.ofNullable(conversions.get(from))
        .map(m -> m.get(to));
  }

  public void addMappingConversion(MMecMappingConversion addedConversion) {
    conversions.computeIfAbsent(addedConversion.getInputType(), k -> new HashMap<>())
        .put(addedConversion.getOutputType(), addedConversion);
  }
}

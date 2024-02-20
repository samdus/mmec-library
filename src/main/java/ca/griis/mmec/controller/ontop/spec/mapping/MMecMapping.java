/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecMapping.
 * @brief @~english MMecMapping class implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping;

import ca.griis.mmec.model.MMecTriplesMap;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.spec.mapping.PrefixManager;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMapping;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;

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
 *      2024-02-05 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecMapping implements SQLPPMapping {

  private PrefixManager prefixManager;
  private ImmutableList<MMecTriplesMap> tripleMaps;

  public MMecMapping(PrefixManager prefixManager, ImmutableList<SQLPPTriplesMap> tripleMaps) {
    this.prefixManager = prefixManager;
    this.tripleMaps = tripleMaps.stream()
        .map(MMecTriplesMap.class::cast)
        .collect(ImmutableList.toImmutableList());
  }

  @Override
  public PrefixManager getPrefixManager() {
    return prefixManager;
  }

  @Override
  public ImmutableList<SQLPPTriplesMap> getTripleMaps() {
    return ImmutableList.copyOf(tripleMaps);
  }

  public ImmutableList<MMecTriplesMap> getMMecTripleMaps() {
    return tripleMaps;
  }
}

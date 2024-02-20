/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecTMappingRule.
 * @brief @~english MMecTMappingRule class implementation.
 */
package it.unibz.inf.ontop.spec.mapping.transformer.impl;

import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecPPMappingAssertionProvenance;
import ca.griis.mmec.model.MMecTriplesMap;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.model.term.ImmutableExpression;
import it.unibz.inf.ontop.model.term.ImmutableTerm;

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
 *      2024-02-20 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecTMappingRule extends TMappingRule {
  private final MMecPPMappingAssertionProvenance provenance;

  public MMecTMappingRule(MMecPPMappingAssertionProvenance provenance, IQ iq,
      CoreSingletons coreSingletons) {
    super(iq, coreSingletons);
    this.provenance = provenance;
  }

  public MMecTMappingRule(MMecPPMappingAssertionProvenance provenance,
      ImmutableList<ImmutableTerm> headTerms, TMappingRule baseRule) {
    super(headTerms, baseRule);
    this.provenance = provenance;
  }

  public MMecTMappingRule(MMecTMappingRule baseRule,
      ImmutableList<ImmutableList<ImmutableExpression>> filter) {
    super(baseRule, filter);
    this.provenance = baseRule.getProvenance();
  }

  public MMecPPMappingAssertionProvenance getProvenance() {
    return provenance;
  }
}

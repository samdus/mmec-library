/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe MMecPPMappingAssertionProvenance.
 * @brief @~english MMecPPMappingAssertionProvenance class implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping.pp;

import it.unibz.inf.ontop.spec.mapping.TargetAtom;
import it.unibz.inf.ontop.spec.mapping.pp.PPMappingAssertionProvenance;

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
public class MMecPpMappingAssertionProvenance implements PPMappingAssertionProvenance {
  private final TargetAtom targetAtom;
  private final MMecTriplesMap mmecTriplesMap;

  public MMecPpMappingAssertionProvenance(TargetAtom targetAtom, MMecTriplesMap mmecTriplesMap) {
    this.targetAtom = targetAtom;
    this.mmecTriplesMap = mmecTriplesMap;
  }

  public MMecTriplesMap getMmecTriplesMap() {
    return mmecTriplesMap;
  }

  public TargetAtom getTargetAtom() {
    return targetAtom;
  }

  @Override
  public String getProvenanceInfo() {
    return "id: " + mmecTriplesMap.getId() + "\ntarget atom: " + targetAtom.toString()
        + "\nsource query: " + mmecTriplesMap.getSourceQuery();
  }

  @Override
  public String toString() {
    return getProvenanceInfo();
  }
}

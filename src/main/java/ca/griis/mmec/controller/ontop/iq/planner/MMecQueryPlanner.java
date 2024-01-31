/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecQueryPlanner.
 * @brief @~english MMecQueryPlanner class implementation.
 */
package ca.griis.mmec.controller.ontop.iq.planner;

import ca.griis.mmec.controller.ontop.iq.optimizer.MMecQueryOptimizer;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.planner.QueryPlanner;
import it.unibz.inf.ontop.iq.planner.impl.AvoidJoinAboveUnionPlanner;
import javax.inject.Inject;
import javax.inject.Singleton;

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
 * @brief @~french Surcharge de la classe AvoidJoinAboveUnionPlanner de Ontop pour ajouter
 *        l'optimisation pour l'extension MMec.
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
 *      2024-01-09 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
@Singleton
public class MMecQueryPlanner implements QueryPlanner {

  private final AvoidJoinAboveUnionPlanner avoidJoinAboveUnionPlanner;
  private final MMecQueryOptimizer mMecQueryOptimizer;

  @Inject
  public MMecQueryPlanner(AvoidJoinAboveUnionPlanner avoidJoinAboveUnionPlanner,
      MMecQueryOptimizer mMecQueryOptimizer) {
    this.avoidJoinAboveUnionPlanner = avoidJoinAboveUnionPlanner;
    this.mMecQueryOptimizer = mMecQueryOptimizer;
  }

  /**
   * @brief @~english «Description of the method»
   * @param query «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Optimise la requête en utilisant le QueryPlanner par défaut de Ontop
   *        (AvoidJoinAboveUnionPlanner) puis en utilisant le QueryUpdateForMMecOptimizer pour
   *        préparer la requête pour l'extension MMec.
   * @param query La requête à optimiser.
   * @return La requête optimisée.
   *
   * @par Tâches
   *      S.O.
   */
  @Override
  public IQ optimize(IQ query) {
    return mMecQueryOptimizer.optimize(avoidJoinAboveUnionPlanner.optimize(query));
  }
}

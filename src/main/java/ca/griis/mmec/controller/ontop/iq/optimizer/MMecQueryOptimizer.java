/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe QueryUpdateForMMecOptimizer.
 * @brief @~english QueryUpdateForMMecOptimizer class implementation.
 */

package ca.griis.mmec.controller.ontop.iq.optimizer;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.iq.transform.DataPropertyProjectionTransformer;
import ca.griis.mmec.controller.ontop.iq.transform.IndividuationFunctionQueryTransformer;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.transform.IQTreeVisitingTransformer;
import it.unibz.inf.ontop.model.term.TermFactory;
import java.util.List;

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
 * @brief @~french Optimiseur de requête pour mMec, permet d'appliquer tous les transformateurs
 *        de requête utile pour mMec.
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
 *      2023-12-21 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 */
public class MMecQueryOptimizer {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecQueryOptimizer.class);
  protected final IntermediateQueryFactory iqFactory;
  protected final TermFactory termFactory;
  protected final List<IQTreeVisitingTransformer> transformers;

  @Inject
  public MMecQueryOptimizer(IntermediateQueryFactory iqFactory, TermFactory termFactory,
      IndividuationFunctionQueryTransformer individuationFunctionQueryTransformer,
      DataPropertyProjectionTransformer dataPropertyProjectionTransformer) {
    this.iqFactory = iqFactory;
    this.termFactory = termFactory;
    this.transformers =
        ImmutableList.of(individuationFunctionQueryTransformer, dataPropertyProjectionTransformer);
  }

  public IQTree optimize(IQTree tree) {
    logger.trace(Trace.ENTER_METHOD_1, tree);

    for (IQTreeVisitingTransformer transformer : transformers) {
      tree = tree.acceptTransformer(transformer);
    }
    return tree;
  }

}

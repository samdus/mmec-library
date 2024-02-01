/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe QueryUpdateForMMecOptimizer.
 * @brief @~english QueryUpdateForMMecOptimizer class implementation.
 */

package ca.griis.mmec.controller.ontop.iq.optimizer;

import ca.griis.mmec.controller.ontop.iq.transform.DataPropertyProjectionTransformer;
import ca.griis.mmec.controller.ontop.iq.transform.IndividuationFunctionQueryTransformer;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.optimizer.IQOptimizer;
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
 *      2023-12-21 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 * @todo 2024-01-01 [SD] - Ajouter les distinct et les not null pour les expressions de classes et
 *       d'ObjectProperty
 */
public class MMecQueryOptimizer implements IQOptimizer {
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

  @Override
  public IQ optimize(IQ query) {
    IQTree newTree = acceptAllTransformer(query.getTree());
    return iqFactory.createIQ(query.getProjectionAtom(), newTree);
  }

  private IQTree acceptAllTransformer(IQTree tree) {
    for (IQTreeVisitingTransformer transformer : transformers) {
      tree = tree.acceptTransformer(transformer);
    }
    return tree;
  }

}

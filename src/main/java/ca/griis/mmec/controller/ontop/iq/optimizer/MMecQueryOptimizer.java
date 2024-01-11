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

import ca.griis.mmec.controller.ontop.iq.transform.IndividuationFunctionQueryTransformer;
import com.google.inject.Inject;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.optimizer.IQOptimizer;
import it.unibz.inf.ontop.iq.type.impl.BasicSingleTermTypeExtractor;
import it.unibz.inf.ontop.model.term.TermFactory;

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
 *      S.O.
 */
public class MMecQueryOptimizer implements IQOptimizer {
  protected final IntermediateQueryFactory iqFactory;
  protected final TermFactory termFactory;
  protected final IndividuationFunctionQueryTransformer individuationFunctionQueryTransformer;

  @Inject
  public MMecQueryOptimizer(IntermediateQueryFactory iqFactory, TermFactory termFactory, BasicSingleTermTypeExtractor typeExtractor) {
    this.iqFactory = iqFactory;
    this.termFactory = termFactory;
    this.individuationFunctionQueryTransformer = new IndividuationFunctionQueryTransformer(iqFactory, termFactory, typeExtractor);
  }

  @Override
  public IQ optimize(IQ query) {
    //TODO: Cette fonction doit pouvoir modifier les IQ pour remplacer les appels de fonctions qui
    //      génère des IRI pour appeler la fonction de génération de signature.

    //TODO: Ajouter le premier paramètre pour l'identifiant du groupe d'individuation.

    //TODO: Faire en sorte d'ajouter les paires de fonctions de conversions de type et les not null

    IQTree newTree = optimize(query.getTree());
    return iqFactory.createIQ(query.getProjectionAtom(), newTree);
  }

  private IQTree optimize(IQTree tree) {
    return tree.acceptTransformer(individuationFunctionQueryTransformer);
  }

}

/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecToFullNativeQueryReformulator.
 * @brief @~english MMecToFullNativeQueryReformulator class implementation.
 */

package ca.griis.mmec.controller.ontop.answering.reformulation;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import it.unibz.inf.ontop.answering.logging.QueryLogger;
import it.unibz.inf.ontop.answering.reformulation.QueryCache;
import it.unibz.inf.ontop.answering.reformulation.impl.QuestQueryProcessor;
import it.unibz.inf.ontop.answering.reformulation.rewriting.QueryRewriter;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.injection.TranslationFactory;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.node.EmptyNode;
import it.unibz.inf.ontop.iq.node.NativeNode;
import it.unibz.inf.ontop.iq.optimizer.GeneralStructuralAndSemanticIQOptimizer;
import it.unibz.inf.ontop.iq.planner.QueryPlanner;
import it.unibz.inf.ontop.query.KGQueryFactory;
import it.unibz.inf.ontop.query.translation.KGQueryTranslator;
import it.unibz.inf.ontop.query.unfolding.QueryUnfolder;
import it.unibz.inf.ontop.spec.OBDASpecification;

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
 * @brief @~french Reformulateur de requête pour des MMec. Diffère du reformulateur Ontop par le
 *        fait que la requête initiale est déjà dans les termes de la base de données.
 *        <br />
 *        C'est-à-dire que le bloc de construction qui contenait des substitutions RDF
 *        a déjà été remplacé par des variables de la source de données et l'appel à la
 *        fonction d'individuation.
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
 *      2024-01-11 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 * @todo 2024-02-01 [SD] - Ajouter le logger griis
 */
public class MMecToFullNativeQueryReformulator extends QuestQueryProcessor {

  @AssistedInject
  public MMecToFullNativeQueryReformulator(
      @Assisted OBDASpecification obdaSpecification,
      QueryCache queryCache,
      QueryUnfolder.Factory queryUnfolderFactory,
      TranslationFactory translationFactory,
      QueryRewriter queryRewriter,
      KGQueryFactory kgQueryFactory,
      KGQueryTranslator inputQueryTranslator,
      GeneralStructuralAndSemanticIQOptimizer generalOptimizer,
      QueryPlanner queryPlanner,
      QueryLogger.Factory queryLoggerFactory) {
    super(obdaSpecification, queryCache, queryUnfolderFactory, translationFactory, queryRewriter,
        kgQueryFactory, inputQueryTranslator, generalOptimizer, queryPlanner, queryLoggerFactory);
  }

  @Override
  protected IQ generateExecutableQuery(IQ iq) throws OntopReformulationException {
    if (iq.getTree() instanceof EmptyNode) {
      return iq;
    } else {
      IQ sourceQuery;
      try {
        sourceQuery = datasourceQueryGenerator.generateSourceQuery(iq, true)
            .normalizeForOptimization();
      } catch (UnsupportedOperationException e) {
        throw new MMecNotFullyTranslatableToNativeQueryException(
            "TODO: Comprendre pourquoi le DP génère une exception ici, "
                + "voir dans la classe originale de ontop");
      }

      if (!(sourceQuery.getTree() instanceof NativeNode)) {
        throw new MMecNotFullyTranslatableToNativeQueryException(
            "the post-processing step could not be eliminated");
      }

      return sourceQuery;
    }
  }

  public static class MMecNotFullyTranslatableToNativeQueryException
      extends OntopReformulationException {
    protected MMecNotFullyTranslatableToNativeQueryException(String message) {
      super("Not fully translatable to a native query: " + message);
    }
  }
}

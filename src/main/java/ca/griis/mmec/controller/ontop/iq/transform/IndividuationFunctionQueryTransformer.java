/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe IndividuationFunctionQueryTransformer.
 * @brief @~english IndividuationFunctionQueryTransformer class implementation.
 */

package ca.griis.mmec.controller.ontop.iq.transform;

import ca.griis.mmec.controller.ontop.model.term.MMecTermFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.transform.impl.DefaultRecursiveIQTreeVisitingTransformer;
import it.unibz.inf.ontop.iq.type.impl.BasicSingleTermTypeExtractor;
import it.unibz.inf.ontop.model.term.DBConstant;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.NonGroundFunctionalTerm;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.IRIStringTemplateFunctionSymbol;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.impl.IRITermType;
import it.unibz.inf.ontop.substitution.Substitution;
import it.unibz.inf.ontop.substitution.impl.SubstitutionImpl;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Inject;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details «Detailed description of the component (optional)»
 * @par Model «Model (Abstract, automation, etc.) (optional)»
 * @par Conception «Conception description (criteria and constraints) (optional)»
 * @par Limits «Limits description (optional)»
 * @brief @~french Transforme la requête pour modifier les appels de fonctions qui génère des IRI
 *        pour appeler la fonction de génération de signature. Retire aussi les conversions de type.
 * @par Détails S.O.
 * @par Modèle S.O.
 * @par Conception S.O.
 * @par Limites S.O.
 * @par Historique 2024-01-09 [SD] - Implémentation initiale<br>
 * @par Tâches S.O.
 */
public class IndividuationFunctionQueryTransformer extends
    DefaultRecursiveIQTreeVisitingTransformer {

  private final MMecTermFactory termFactory;
  private final BasicSingleTermTypeExtractor typeExtractor;

  @Inject
  public IndividuationFunctionQueryTransformer(
      IntermediateQueryFactory iqFactory, TermFactory termFactory,
      BasicSingleTermTypeExtractor typeExtractor) {
    super(iqFactory);

    assert termFactory instanceof MMecTermFactory;
    this.termFactory = (MMecTermFactory) termFactory;
    this.typeExtractor = typeExtractor;
  }

  @Override
  public IQTree transformConstruction(IQTree tree, ConstructionNode constructionNode,
      IQTree child) {
    Substitution<ImmutableTerm> substitution = new SubstitutionImpl<>(
        ImmutableMap.copyOf(constructionNode.getSubstitution().stream()
            .collect(Collectors.toMap(Map.Entry::getKey,
                value -> updateTermIfRelatedToIndividuation(tree, value)))),
        termFactory, true);

    ConstructionNode newConstructionNode = iqFactory.createConstructionNode(
        constructionNode.getVariables(),
        substitution);
    return transformUnaryNode(tree, newConstructionNode, child);
  }

  /**
   * @brief @~english «Description of the method»
   * @param tree «Parameter description»
   * @param substitutionEntry «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Updates the term if it is related to individuation.
   * @param tree The IQTree in which the substituted term is defined.
   * @param substitutionEntry The substitution entry to update.
   * @return The value of the substitution entry if not related to individuation.
   *         The inner term if the substitution was a call to the RDF function, without
   *         any call to the IRIStringTemplateFunction.
   *         A new term MMEcSignatureFunction term if the substitution was a call to the
   *         IRIStringTemplateFunction or a call to RDF with an inner term that was a
   *         call to the IRIStringTemplateFunction.
   *
   * @par Tâches
   *    S.O.
   */
  private ImmutableTerm updateTermIfRelatedToIndividuation(IQTree tree,
      Map.Entry<Variable, ImmutableTerm> substitutionEntry) {
    ImmutableTerm newTerm = substitutionEntry.getValue();

    if (substitutionEntry.getValue() instanceof NonGroundFunctionalTerm term
        && term.getFunctionSymbol() instanceof RDFTermFunctionSymbol
        && term.getTerm(1) instanceof RDFTermTypeConstant rdfTermTypeConstant
        && rdfTermTypeConstant.getRDFTermType() instanceof IRITermType
        && term.getTerm(0) instanceof NonGroundFunctionalTerm iriFunctionTerm
        && iriFunctionTerm.getFunctionSymbol() instanceof IRIStringTemplateFunctionSymbol iriStrTemplateFn) {
      DBConstant identifierForSignatureGroup = termFactory.getDBStringConstant(
          iriStrTemplateFn.getName());
      ImmutableList<ImmutableTerm> arguments = ImmutableList.<ImmutableTerm>builder()
          .add(identifierForSignatureGroup)
          .addAll(iriFunctionTerm.getVariables().asList())
          .build();
      ImmutableList<TermType> argTypes =
          arguments.stream().map(
                  variable -> typeExtractor.extractSingleTermType(variable, tree).orElseThrow())
              .collect(ImmutableList.toImmutableList());

      return termFactory.getMMecSignatureFunction(argTypes, arguments);
    }

    return newTerm;
  }
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecJoinLikeChildBindingLifter.
 * @brief @~english MMecJoinLikeChildBindingLifter class implementation.
 */
package it.unibz.inf.ontop.iq.node.normalization.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.node.VariableNullability;
import it.unibz.inf.ontop.iq.node.impl.UnsatisfiableConditionException;
import it.unibz.inf.ontop.iq.node.normalization.ConditionSimplifier;
import it.unibz.inf.ontop.model.term.ImmutableExpression;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.VariableOrGroundTerm;
import it.unibz.inf.ontop.substitution.InjectiveSubstitution;
import it.unibz.inf.ontop.substitution.Substitution;
import it.unibz.inf.ontop.substitution.SubstitutionFactory;
import it.unibz.inf.ontop.substitution.SubstitutionOperations;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import it.unibz.inf.ontop.utils.VariableGenerator;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
 *      2024-03-01 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecJoinLikeChildBindingLifter {
  private final ConditionSimplifier conditionSimplifier;
  private final TermFactory termFactory;
  private final SubstitutionFactory substitutionFactory;

  @Inject
  private MMecJoinLikeChildBindingLifter(ConditionSimplifier conditionSimplifier, TermFactory termFactory,
      SubstitutionFactory substitutionFactory) {
    this.conditionSimplifier = conditionSimplifier;
    this.termFactory = termFactory;
    this.substitutionFactory = substitutionFactory;
  }

  /**
   * For children of a commutative join or for the left child of a LJ
   */
  public <R> R liftRegularChildBinding(ConstructionNode selectedChildConstructionNode,
      int selectedChildPosition,
      IQTree selectedGrandChild,
      ImmutableList<IQTree> children,
      ImmutableSet<Variable> nonLiftableVariables,
      Optional<ImmutableExpression> initialJoiningCondition,
      VariableGenerator variableGenerator,
      VariableNullability variableNullability,
      JoinLikeChildBindingLifter.BindingLiftConverter<R> bindingLiftConverter) throws
      UnsatisfiableConditionException {

    Substitution<ImmutableTerm> selectedChildSubstitution = selectedChildConstructionNode.getSubstitution();

    Substitution<VariableOrGroundTerm> downPropagableFragment = selectedChildSubstitution.restrictRangeTo(VariableOrGroundTerm.class);

    Substitution<ImmutableFunctionalTerm> nonDownPropagableFragment = selectedChildSubstitution.restrictRangeTo(ImmutableFunctionalTerm.class);

    ImmutableSet<Variable> otherChildrenVariables = IntStream.range(0, children.size())
        .filter(i -> i != selectedChildPosition)
        .mapToObj(children::get)
        .flatMap(iq -> iq.getVariables().stream())
        .collect(ImmutableCollectors.toSet());

    InjectiveSubstitution<Variable> freshRenaming = Sets.intersection(nonDownPropagableFragment.getDomain(), otherChildrenVariables).stream()
        .collect(substitutionFactory.toFreshRenamingSubstitution(variableGenerator));

    Stream<ImmutableExpression> equalities = freshRenaming.builder()
        .toStream((v, t) -> termFactory.getStrictEquality(selectedChildSubstitution.apply(v), t));

    ConditionSimplifier.ExpressionAndSubstitution expressionResults = conditionSimplifier.simplifyCondition(
        termFactory.getConjunction(initialJoiningCondition.map(selectedChildSubstitution::apply), equalities),
        nonLiftableVariables, children, variableNullability);

    Optional<ImmutableExpression> newCondition = expressionResults.getOptionalExpression();

    // NB: this substitution is said to be "naive" as further restrictions may be applied
    // to the effective ascending substitution (e.g., for the LJ, in the case of the renaming of right-specific vars)
    Substitution<ImmutableTerm> naiveAscendingSubstitution =
        expressionResults.getSubstitution().compose(selectedChildSubstitution);

    SubstitutionOperations<VariableOrGroundTerm> substitutionOperations =
        substitutionFactory.onVariableOrGroundTerms();
    Substitution<VariableOrGroundTerm> descendingSubstitution =
        substitutionOperations.compose(
            expressionResults.getSubstitution(),
            substitutionOperations.compose(freshRenaming.builder().build(), downPropagableFragment));

    return bindingLiftConverter.convert(children, selectedGrandChild, selectedChildPosition, newCondition,
        naiveAscendingSubstitution, descendingSubstitution);
  }
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecTMappingEntry.
 * @brief @~english MMecTMappingEntry class implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping.transformer.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import it.unibz.inf.ontop.constraints.ImmutableHomomorphism;
import it.unibz.inf.ontop.constraints.ImmutableHomomorphismIterator;
import it.unibz.inf.ontop.constraints.impl.ImmutableCQContainmentCheckUnderLIDs;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.iq.tools.impl.IQ2CQ;
import it.unibz.inf.ontop.model.atom.RelationPredicate;
import it.unibz.inf.ontop.model.term.ImmutableExpression;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.spec.mapping.transformer.impl.MMecTMappingRule;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
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
 * @brief @~french Classe permettant
 * @par Détails
 *      Il s'agit d'une copie de "it.unibz.inf.ontop.spec.mapping.transformer.impl.TMappingEntry"
 *      dans laquelle on a ajouté un traitement lors de l'étape de fusion des règles.
 *      <br>
 *      Ce traitement fait en sorte de ne pas ajouter une règle si elle est défini comme
 *      sous-ensemble d'une autre règle et supprime les règles qui sont définies comme sous-ensemble
 *      de la règle à ajouter.
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
public class MMecTMappingEntry {
  public MMecTMappingEntry(ImmutableCQContainmentCheckUnderLIDs<RelationPredicate> cqc,
      CoreSingletons coreSingletons) {
    this.cqc = cqc;
    this.termFactory = coreSingletons.getTermFactory();
    this.coreSingletons = coreSingletons;
  }

  public static Collector<MMecTMappingRule, MMecTMappingEntry, ImmutableList<MMecTMappingRule>> toMMecTMappingEntry(
      ImmutableCQContainmentCheckUnderLIDs<RelationPredicate> cqc,
      CoreSingletons coreSingletons) {
    return Collector.of(
        () -> new MMecTMappingEntry(cqc, coreSingletons), // Supplier
        MMecTMappingEntry::add, // Accumulator
        (b1, b2) -> b1.addAll(b2.build().iterator()), // Merger
        MMecTMappingEntry::build, // Finisher
        Collector.Characteristics.UNORDERED);
  }

  private final List<MMecTMappingRule> rules = new ArrayList<>();
  private final ImmutableCQContainmentCheckUnderLIDs<RelationPredicate> cqc;
  private final TermFactory termFactory;
  private final CoreSingletons coreSingletons;

  public MMecTMappingEntry add(MMecTMappingRule rule) {
    mergeMappingsWithCQC(rule);
    return this;
  }

  public MMecTMappingEntry addAll(Iterator<MMecTMappingRule> rs) {
    while (rs.hasNext())
      mergeMappingsWithCQC(rs.next());
    return this;
  }

  public ImmutableList<MMecTMappingRule> build() {
    return ImmutableList.copyOf(rules);
  }


  /***
   *
   * This is an optimization mechanism that allows T-mappings to reduce
   * the number of mapping assertions. The unfolding will then produce fewer queries.
   *
   * The method
   *    (1) removes a mapping assertion from rules if it is subsumed by the given assertion
   *
   *    (2) does not add the assertion if it is subsumed by one of the rules
   *
   *    (3) merges the given assertion into an existing assertion if their database atoms
   *        are homomorphically equivalent
   *
   *    (4) does not add the assertion if it is a subset of another assertion
   *
   *    (5) removes any assertion that is a subset of the given assertion
   *
   * For example, if we are given
   *     S(x,z) :- R(x,y,z), y = 2
   * and rules contains
   *     S(x,z) :- R(x,y,z), y > 7
   * then this method will modify the existing assertion into
   *     S(x,z) :- R(x,y,z), OR(y > 7, y = 2)
   */

  private void mergeMappingsWithCQC(MMecTMappingRule assertion) {

    if (rules.contains(assertion)) {
      return;
    }

    if (assertion.getDatabaseAtoms().isEmpty() && assertion.getConditions().isEmpty()) {
      rules.add(assertion); // facts are just added
      return;
    }

    Iterator<MMecTMappingRule> mappingIterator = rules.iterator();
    while (mappingIterator.hasNext()) {

      MMecTMappingRule current = mappingIterator.next();
      // to and from refer to "to assertion" and "from assertion"

      boolean couldIgnore = false;

      Optional<ImmutableHomomorphism> to = getHomomorphismIterator(current, assertion)
          .filter(ImmutableHomomorphismIterator::hasNext)
          .map(ImmutableHomomorphismIterator::next);

      if (to.isPresent()) {
        if (current.getConditions().isEmpty() ||
            (current.getConditions().size() == 1 &&
                assertion.getConditions().size() == 1 &&
                // rule1.getConditions().get(0) contains all images of rule2.getConditions.get(0)
                current.getConditions().get(0).stream()
                    .map(atom -> to.get().applyToBooleanExpression(atom, termFactory))
                    .allMatch(atom -> assertion.getConditions().get(0).contains(atom)))) {

          if (assertion.getDatabaseAtoms().size() < current.getDatabaseAtoms().size()) {
            couldIgnore = true;
          } else {
            // if the new mapping is redundant and there are no conditions then do not add anything
            return;
          }
        }
      }

      Optional<ImmutableHomomorphism> from = getHomomorphismIterator(assertion, current)
          .filter(ImmutableHomomorphismIterator::hasNext)
          .map(ImmutableHomomorphismIterator::next);

      if (from.isPresent()) {
        if (assertion.getConditions().isEmpty() ||
            (assertion.getConditions().size() == 1 &&
                current.getConditions().size() == 1 &&
                // rule1.getConditions().get(0) contains all images of rule2.getConditions.get(0)
                assertion.getConditions().get(0).stream()
                    .map(atom -> from.get().applyToBooleanExpression(atom, termFactory))
                    .allMatch(atom -> current.getConditions().get(0).contains(atom)))) {

          // The existing query is more specific than the new query, so we
          // need to add the new query and remove the old
          mappingIterator.remove();
          continue;
        }
      }

      if (couldIgnore) {
        // if the new mapping is redundant and there are no conditions then do not add anything
        return;
      }

      if (to.isPresent() && from.isPresent()) {
        // We found an equivalence, we will try to merge the conditions of
        // newRule into the current
        // Here we can merge conditions of the new query with the one we have just found
        // new map always has just one set of filters  !!
        ImmutableList<ImmutableExpression> newf = assertion.getConditions().get(0).stream()
            .map(atom -> from.get().applyToBooleanExpression(atom, termFactory))
            .collect(ImmutableCollectors.toList());

        ImmutableSet<Variable> newfVars = newf.stream()
            .flatMap(ImmutableTerm::getVariableStream)
            .collect(ImmutableCollectors.toSet());
        ImmutableSet<Variable> ccVars = current.getDatabaseAtoms().stream()
            .flatMap(a -> a.getVariables().stream())
            .collect(ImmutableCollectors.toSet());
        if (ccVars.containsAll(newfVars)) {
          // if each of the existing conditions in one of the filter groups
          // is found in the new filter then the new filter is redundant
          if (current.getConditions().stream().anyMatch(newf::containsAll)) {
            return;
          }

          // REPLACE THE CURRENT RULE
          mappingIterator.remove();
          rules.add(new MMecTMappingRule(current, Stream.concat(
                  current.getConditions().stream()
                      // if each of the new conditions is found among econd then the old condition is redundant
                      .filter(f -> !f.containsAll(newf)),
                  Stream.of(newf))
              .collect(ImmutableCollectors.toList())));
          return;
        }
      }

      // Do not add the new rule if another rule is a superset of the new rule
      if (rules.stream().anyMatch(
          potentialSuperSet -> potentialSuperSet.getProvenance().getmMecTriplesMap().getSubsetList()
              .contains(assertion.getProvenance().getmMecTriplesMap()))) {
        return;
      }
      // Remove any rule that are subset of the new rule
      Iterators.removeIf(rules.iterator(), potentialSubSet ->
          assertion.getProvenance().getmMecTriplesMap().getSubsetList().contains(
              potentialSubSet.getProvenance().getmMecTriplesMap()));
    }
    rules.add(assertion);
  }

  private Optional<ImmutableHomomorphismIterator<RelationPredicate>> getHomomorphismIterator(
      MMecTMappingRule from, MMecTMappingRule to) {
    ImmutableHomomorphism.Builder builder = ImmutableHomomorphism.builder();
    for (int i = 0; i < from.getHeadTerms().size(); i++)
      if (!builder.extend(from.getHeadTerms().get(i), to.getHeadTerms().get(i)).isValid()) {
        return Optional.empty();
      }

    ImmutableHomomorphism h = builder.build();
    return Optional.of(
        cqc.homomorphismIterator(h, IQ2CQ.toDataAtoms(from.getDatabaseAtoms(), coreSingletons),
            IQ2CQ.toDataAtoms(to.getDatabaseAtoms(), coreSingletons)));
  }
}

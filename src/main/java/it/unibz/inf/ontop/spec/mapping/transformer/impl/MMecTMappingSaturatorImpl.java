/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Copie de l'implémentation de
 * it.unibz.inf.ontop.spec.mapping.transformer.impl.MMecTMappingSaturatorImpl.
 * @brief @~english Copy of the implementation of
 * it.unibz.inf.ontop.spec.mapping.transformer.impl.MMecTMappingSaturatorImpl.
 */

package it.unibz.inf.ontop.spec.mapping.transformer.impl;

/*
 * #%L
 * ontop-reformulation-core
 * %%
 * Copyright (C) 2009 - 2014 Free University of Bozen-Bolzano
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 *
 * NOTE:
 * This is a copy of it.unibz.inf.ontop.spec.mapping.transformer.impl.TMappingSaturatorImpl
 * that has been modified to use MMecMappingAssertionUnion instead of MappingAssertionUnion.
 */

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.unibz.inf.ontop.constraints.impl.ExtensionalDataNodeListContainmentCheck;
import it.unibz.inf.ontop.exception.MinorOntopInternalBugException;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.tools.UnionBasedQueryMerger;
import it.unibz.inf.ontop.model.atom.DistinctVariableOnlyDataAtom;
import it.unibz.inf.ontop.model.atom.RDFAtomPredicate;
import it.unibz.inf.ontop.model.term.IRIConstant;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.vocabulary.RDF;
import it.unibz.inf.ontop.spec.mapping.MappingAssertion;
import it.unibz.inf.ontop.spec.mapping.MappingAssertionIndex;
import it.unibz.inf.ontop.spec.mapping.TMappingExclusionConfig;
import it.unibz.inf.ontop.spec.mapping.transformer.MappingCQCOptimizer;
import it.unibz.inf.ontop.spec.mapping.transformer.MappingSaturator;
import it.unibz.inf.ontop.spec.ontology.ClassExpression;
import it.unibz.inf.ontop.spec.ontology.ClassifiedTBox;
import it.unibz.inf.ontop.spec.ontology.DataPropertyExpression;
import it.unibz.inf.ontop.spec.ontology.DataSomeValuesFrom;
import it.unibz.inf.ontop.spec.ontology.Equivalences;
import it.unibz.inf.ontop.spec.ontology.EquivalencesDAG;
import it.unibz.inf.ontop.spec.ontology.OClass;
import it.unibz.inf.ontop.spec.ontology.ObjectPropertyExpression;
import it.unibz.inf.ontop.spec.ontology.ObjectSomeValuesFrom;
import it.unibz.inf.ontop.substitution.InjectiveSubstitution;
import it.unibz.inf.ontop.substitution.Substitution;
import it.unibz.inf.ontop.substitution.SubstitutionFactory;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.lang3.tuple.Pair;

@Singleton
public class MMecTMappingSaturatorImpl implements MappingSaturator {

  // TODO: the implementation of EXCLUDE ignores equivalent classes / properties

  private final TMappingExclusionConfig exclusionConfig;
  private final TermFactory termFactory;
  private final MappingCQCOptimizer mappingCqcOptimizer;
  private final UnionBasedQueryMerger queryMerger;
  private final CoreSingletons coreSingletons;
  private final IntermediateQueryFactory iqFactory;
  private final SubstitutionFactory substitutionFactory;

  @Inject
  private MMecTMappingSaturatorImpl(TMappingExclusionConfig exclusionConfig,
      MappingCQCOptimizer mappingCqcOptimizer,
      UnionBasedQueryMerger queryMerger,
      CoreSingletons coreSingletons) {
    this.exclusionConfig = exclusionConfig;
    this.termFactory = coreSingletons.getTermFactory();
    this.mappingCqcOptimizer = mappingCqcOptimizer;
    this.queryMerger = queryMerger;
    this.coreSingletons = coreSingletons;
    this.substitutionFactory = coreSingletons.getSubstitutionFactory();
    this.iqFactory = coreSingletons.getIQFactory();
  }

  @Override
  public ImmutableList<MappingAssertion> saturate(ImmutableList<MappingAssertion> mapping,
      ClassifiedTBox reasoner) {

    ExtensionalDataNodeListContainmentCheck cqc = new ExtensionalDataNodeListContainmentCheck(
        coreSingletons.getHomomorphismFactory(), coreSingletons.getCoreUtilsFactory());

    // index mapping assertions by the predicate type
    // same IRI can be a class name and a property name
    // but the same IRI cannot be an object and a data or annotation property name at the same time
    // see https://www.w3.org/TR/owl2-new-features/#F12:_Punning

    ImmutableMultimap<MappingAssertionIndex, MappingAssertion> original = mapping.stream()
        .map(m -> optimize(cqc, m))
        .collect(ImmutableCollectors.toMultimap(MappingAssertion::getIndex, m -> m));

    ImmutableMap<MappingAssertionIndex, MappingAssertion> saturated = original.keySet().stream()
        .map(MappingAssertionIndex::getPredicate)
        .distinct()
        .map(MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformerProvider::new)
        .flatMap(provider -> Stream.concat(Stream.concat(
            reasoner.objectPropertiesDAG().stream()
                .filter(node -> !node.getRepresentative().isInverse()
                    && !exclusionConfig.contains(node.getRepresentative()))
                .flatMap(node -> saturate(node.getRepresentative(),
                    getSubsumees(reasoner.objectPropertiesDAG(), node), original,
                    provider::getTransformer,
                    cqc).stream()
                        .flatMap(ma -> node.getMembers().stream()
                            .filter(
                                d -> !d.isInverse()
                                    || d.getInverse() != node.getRepresentative())
                            .map(d -> Maps.immutableEntry(
                                provider.getTransformer(node.getRepresentative(), d),
                                ma)))),

            reasoner.dataPropertiesDAG().stream()
                .filter(node -> !exclusionConfig.contains(node.getRepresentative()))
                .flatMap(node -> saturate(node.getRepresentative(),
                    getSubsumees(reasoner.dataPropertiesDAG(), node), original,
                    provider::getTransformer, cqc).stream()
                        .flatMap(ma -> node.getMembers().stream()
                            .map(d -> Maps.immutableEntry(
                                provider.getTransformer(node.getRepresentative(), d), ma))))),

            reasoner.classesDAG().stream()
                .filter(node -> node.getRepresentative() instanceof OClass
                    && !exclusionConfig.contains((OClass) node.getRepresentative()))
                .flatMap(node -> saturate(node.getRepresentative(),
                    getSubsumees(reasoner.classesDAG(), node), original, provider::getTransformer,
                    cqc).stream()
                        .flatMap(ma -> node.getMembers().stream()
                            .filter(d -> d instanceof OClass)
                            .map(d -> Maps.immutableEntry(
                                provider.getTransformer(node.getRepresentative(), d), ma))))))

        .map(e -> Maps.immutableEntry(
            e.getKey().getToIndex(), e.getKey().updateConstructionNodeIri(e.getValue())))
        .collect(ImmutableCollectors.toMap());

    return Stream.concat(
        saturated.values().stream(),
        original.asMap().entrySet().stream()
            .filter(e -> !saturated.containsKey(e.getKey()))
            .map(e -> e.getValue().stream()
                .collect(
                    MMecMappingAssertionUnion.toMappingAssertion(
                        cqc, coreSingletons, queryMerger)))
            .map(Optional::orElseThrow))
        .collect(ImmutableCollectors.toList());
  }

  private <T> Optional<MappingAssertion> saturate(T representative, Stream<T> subsumees,
      ImmutableMultimap<MappingAssertionIndex, MappingAssertion> original,
      BiFunction<T, T, MappingAssertionConstructionNodeTransformer> transformerProvider,
      ExtensionalDataNodeListContainmentCheck cqc) {

    return subsumees
        .map(s -> transformerProvider.apply(s, representative))
        .flatMap(u -> original.get(u.getFromIndex()).stream()
            .map(u::updateConstructionNodeIri)
            .map(m -> u.needOptimization() ? optimize(cqc, m) : m))
        .collect(MMecMappingAssertionUnion.toMappingAssertion(cqc, coreSingletons, queryMerger));
  }

  private MappingAssertion optimize(ExtensionalDataNodeListContainmentCheck cqc,
      MappingAssertion m) {
    IQ optimizedIQ = m.getQuery().normalizeForOptimization();
    IQ cqcOptimizedIQ = mappingCqcOptimizer.optimize(cqc, optimizedIQ);
    return m.copyOf(cqcOptimizedIQ);
  }

  private static <T> Stream<T> getSubsumees(EquivalencesDAG<T> dag, Equivalences<T> node) {
    return dag.getSub(node).stream()
        .flatMap(n -> n.getMembers().stream());
  }

  private class MappingAssertionConstructionNodeTransformer {
    private final MappingAssertionIndex fromIndex;
    private final MappingAssertionIndex toIndex;
    private final Function<ImmutableList<ImmutableTerm>, ImmutableList<ImmutableTerm>> transformer;
    private final boolean needOptimization;

    MappingAssertionConstructionNodeTransformer(MappingAssertionIndex fromIndex,
        MappingAssertionIndex toIndex,
        Function<ImmutableList<ImmutableTerm>, ImmutableList<ImmutableTerm>> termTransformer,
        boolean needOptimization) {
      this.fromIndex = fromIndex;
      this.toIndex = toIndex;
      this.transformer = termTransformer;
      this.needOptimization = needOptimization;
    }

    MappingAssertionIndex getFromIndex() {
      return fromIndex;
    }

    MappingAssertionIndex getToIndex() {
      return toIndex;
    }

    boolean needOptimization() {
      return needOptimization;
    }

    MappingAssertion updateConstructionNodeIri(MappingAssertion assertion) {
      IQ query = assertion.getQuery();
      ConstructionNode constructionNode = (ConstructionNode) query.getTree().getRootNode();
      DistinctVariableOnlyDataAtom projectionAtom = query.getProjectionAtom();
      ImmutableList<Variable> variables = projectionAtom.getArguments();
      ImmutableList<ImmutableTerm> args = constructionNode.getSubstitution().apply(variables);
      Substitution<ImmutableTerm> updatedSubstitution = substitutionFactory.getSubstitution(
          variables, transformer.apply(args));
      Pair<IQTree, Substitution<ImmutableTerm>> circularSubstitutionRenamed =
          renameCircularSubstitution(updatedSubstitution, query);

      IQTree updatedChild = circularSubstitutionRenamed.getLeft();
      Substitution<ImmutableTerm> substitutionWithoutSwap = circularSubstitutionRenamed.getRight();

      ConstructionNode updatedConstructionNode = iqFactory.createConstructionNode(
          constructionNode.getVariables(), substitutionWithoutSwap);

      IQ updatedQuery = iqFactory.createIQ(projectionAtom,
          iqFactory.createUnaryIQTree(updatedConstructionNode,
              updatedChild));

      return assertion.copyOf(updatedQuery);
    }

    /**
     *
     * @brief @~english «Description of the method»
     * @param updatedSubstitution «Parameter description»
     * @param query «Parameter description»
     * @return «Return description»
     *
     * @brief @~french Lors de la mise à jour du ConstructionNode, il est fréquent
     *        d'induire des substitutions circulaires. Cette méthode
     *        permet de renommer les variables du sous-arbre de sorte qu'aucune valeur
     *        définie par le ConstructionNode n'aient le même nom.
     * @param updatedSubstitution l'instance de Substitution découlant d'une mise à jour d'IRI
     * @param query la requête sous-jaçente
     * @return La nouvelle substitution et la requête
     *
     * @par Tâches
     *      S.O.
     */
    private Pair<IQTree, Substitution<ImmutableTerm>> renameCircularSubstitution(
        Substitution<ImmutableTerm> updatedSubstitution, IQ query) {
      ImmutableMap<Variable, Variable> circularSubstitution = updatedSubstitution.stream()
          .filter(sub -> sub.getValue() instanceof Variable)
          .filter(sub -> updatedSubstitution.isDefining((Variable) sub.getValue()))
          .map(sub -> Maps.immutableEntry(sub.getKey(), (Variable) sub.getValue()))
          .collect(ImmutableCollectors.toMap());
      List<Variable> newVariables = new ArrayList<>(updatedSubstitution.stream()
          .filter(v -> !circularSubstitution.containsKey(v.getKey()))
          .map(Map.Entry::getKey)
          .toList());
      List<ImmutableTerm> newValues = new ArrayList<>(updatedSubstitution.stream()
          .filter(v -> !circularSubstitution.containsKey(v.getKey()))
          .map(Map.Entry::getValue)
          .toList());
      IQTree childTree = ((UnaryIQTree) query.getTree()).getChild();

      for (Variable circularVariable : circularSubstitution.keySet()) {
        Variable toReplace = circularSubstitution.get(circularVariable);
        Variable freshVariable = query.getVariableGenerator().generateNewVariableFromVar(
            toReplace);
        InjectiveSubstitution<Variable> renaming = substitutionFactory
            .getSubstitution(toReplace, freshVariable)
            .injective();
        childTree = childTree.applyFreshRenaming(renaming);
        newVariables.add(circularVariable);
        newValues.add(freshVariable);
      }

      return Pair.of(childTree, substitutionFactory.getSubstitution(
          ImmutableList.copyOf(newVariables),
          ImmutableList.copyOf(newValues)));
    }

    @Override
    public String toString() {
      return fromIndex + " -> " + toIndex;
    }
  }


  private class MappingAssertionConstructionNodeTransformerProvider {
    private final RDFAtomPredicate rdfAtomPredicate;
    private final IRIConstant rdfType;

    MappingAssertionConstructionNodeTransformerProvider(RDFAtomPredicate rdfAtomPredicate) {
      this.rdfAtomPredicate = rdfAtomPredicate;
      this.rdfType = termFactory.getConstantIRI(RDF.TYPE);
    }

    MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformer getTransformer(
        ClassExpression from, ClassExpression to) {
      if (!(to instanceof OClass toClass)) {
        throw new MinorOntopInternalBugException(
            "Cannot get a transformer to a property restriction: " + from + " " + to);
      }

      IRIConstant newIri = termFactory.getConstantIRI(toClass.getIRI());
      if (from instanceof OClass oc) {
        return new MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformer(
            MappingAssertionIndex.ofClass(rdfAtomPredicate, oc.getIRI()),
            MappingAssertionIndex.ofClass(rdfAtomPredicate, toClass.getIRI()),
            args -> rdfAtomPredicate.updateSPO(args, rdfAtomPredicate.getSubject(args), rdfType,
                newIri),
            false);
      } else if (from instanceof ObjectSomeValuesFrom) {
        ObjectPropertyExpression ope = ((ObjectSomeValuesFrom) from).getProperty();
        return new MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformer(
            MappingAssertionIndex.ofProperty(rdfAtomPredicate, ope.getIRI()),
            MappingAssertionIndex.ofClass(rdfAtomPredicate, toClass.getIRI()),
            ope.isInverse()
                ? args -> rdfAtomPredicate.updateSPO(args, rdfAtomPredicate.getObject(args),
                    rdfType, newIri)
                : args -> rdfAtomPredicate.updateSPO(args, rdfAtomPredicate.getSubject(args),
                    rdfType, newIri),
            true);
      } else if (from instanceof DataSomeValuesFrom) {
        DataPropertyExpression dpe = ((DataSomeValuesFrom) from).getProperty();
        return new MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformer(
            MappingAssertionIndex.ofProperty(rdfAtomPredicate, dpe.getIRI()),
            MappingAssertionIndex.ofClass(rdfAtomPredicate, toClass.getIRI()),
            args -> rdfAtomPredicate.updateSPO(args, rdfAtomPredicate.getSubject(args), rdfType,
                newIri),
            true);
      } else {
        throw new MinorOntopInternalBugException("Unexpected type" + from);
      }
    }

    MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformer getTransformer(
        ObjectPropertyExpression from, ObjectPropertyExpression to) {
      IRIConstant newIri = termFactory.getConstantIRI(to.getIRI());
      return new MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformer(
          MappingAssertionIndex.ofProperty(rdfAtomPredicate, from.getIRI()),
          MappingAssertionIndex.ofProperty(rdfAtomPredicate, to.getIRI()),
          from.isInverse() != to.isInverse()
              ? args -> rdfAtomPredicate.updateSPO(args, rdfAtomPredicate.getObject(args), newIri,
                  rdfAtomPredicate.getSubject(args))
              : args -> rdfAtomPredicate.updateSPO(args, rdfAtomPredicate.getSubject(args), newIri,
                  rdfAtomPredicate.getObject(args)),
          false);
    }

    MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformer getTransformer(
        DataPropertyExpression from, DataPropertyExpression to) {
      IRIConstant newIri = termFactory.getConstantIRI(to.getIRI());
      return new MMecTMappingSaturatorImpl.MappingAssertionConstructionNodeTransformer(
          MappingAssertionIndex.ofProperty(rdfAtomPredicate, from.getIRI()),
          MappingAssertionIndex.ofProperty(rdfAtomPredicate, to.getIRI()),
          args -> rdfAtomPredicate.updateSPO(args, rdfAtomPredicate.getSubject(args), newIri,
              rdfAtomPredicate.getObject(args)),
          false);
    }
  }
}

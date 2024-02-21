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
 * it.unibz.inf.ontop.spec.mapping.transformer.impl.TMappingSaturatorImpl.
 * @brief @~english Copy of the implementation of
 * it.unibz.inf.ontop.spec.mapping.transformer.impl.TMappingSaturatorImpl.
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
 * This class is a copy of it.unibz.inf.ontop.spec.mapping.transformer.impl.TMappingSaturatorImpl
 * that has been modified to use MMecTMappingRules
 */

import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecPPMappingAssertionProvenance;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import it.unibz.inf.ontop.constraints.impl.DBLinearInclusionDependenciesImpl;
import it.unibz.inf.ontop.constraints.impl.ImmutableCQContainmentCheckUnderLIDs;
import it.unibz.inf.ontop.datalog.UnionFlattener;
import it.unibz.inf.ontop.exception.MinorOntopInternalBugException;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.tools.UnionBasedQueryMerger;
import it.unibz.inf.ontop.model.atom.AtomFactory;
import it.unibz.inf.ontop.model.atom.RDFAtomPredicate;
import it.unibz.inf.ontop.model.atom.RelationPredicate;
import it.unibz.inf.ontop.model.term.IRIConstant;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.vocabulary.RDF;
import it.unibz.inf.ontop.spec.mapping.MappingAssertion;
import it.unibz.inf.ontop.spec.mapping.MappingAssertionIndex;
import it.unibz.inf.ontop.spec.mapping.TMappingExclusionConfig;
import it.unibz.inf.ontop.spec.mapping.transformer.MappingCQCOptimizer;
import it.unibz.inf.ontop.spec.mapping.transformer.MappingSaturator;
import it.unibz.inf.ontop.spec.mapping.transformer.QueryUnionSplitter;
import it.unibz.inf.ontop.spec.ontology.ClassExpression;
import it.unibz.inf.ontop.spec.ontology.ClassifiedTBox;
import it.unibz.inf.ontop.spec.ontology.DataPropertyExpression;
import it.unibz.inf.ontop.spec.ontology.DataSomeValuesFrom;
import it.unibz.inf.ontop.spec.ontology.Equivalences;
import it.unibz.inf.ontop.spec.ontology.EquivalencesDAG;
import it.unibz.inf.ontop.spec.ontology.OClass;
import it.unibz.inf.ontop.spec.ontology.ObjectPropertyExpression;
import it.unibz.inf.ontop.spec.ontology.ObjectSomeValuesFrom;
import it.unibz.inf.ontop.utils.CoreUtilsFactory;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

@Singleton
public class MMecTMappingSaturatorImpl implements MappingSaturator {

  // TODO: the implementation of EXCLUDE ignores equivalent classes / properties

  private final TMappingExclusionConfig tmappingExclusionConfig;
  private final AtomFactory atomFactory;
  private final TermFactory termFactory;
  private final QueryUnionSplitter unionSplitter;
  private final UnionFlattener unionNormalizer;
  private final MappingCQCOptimizer mappingCqcOptimizer;
  private final UnionBasedQueryMerger queryMerger;
  private final CoreUtilsFactory coreUtilsFactory;
  private final CoreSingletons coreSingletons;

  @Inject
  public MMecTMappingSaturatorImpl(TMappingExclusionConfig tmappingExclusionConfig,
      QueryUnionSplitter unionSplitter, UnionFlattener unionNormalizer,
      MappingCQCOptimizer mappingCqcOptimizer, UnionBasedQueryMerger queryMerger,
      CoreSingletons coreSingletons) {
    this.tmappingExclusionConfig = tmappingExclusionConfig;
    this.atomFactory = coreSingletons.getAtomFactory();
    this.termFactory = coreSingletons.getTermFactory();
    this.unionSplitter = unionSplitter;
    this.unionNormalizer = unionNormalizer;
    this.mappingCqcOptimizer = mappingCqcOptimizer;
    this.queryMerger = queryMerger;
    this.coreUtilsFactory = coreSingletons.getCoreUtilsFactory();
    this.coreSingletons = coreSingletons;
  }

  @Override
  public ImmutableList<MappingAssertion> saturate(ImmutableList<MappingAssertion> mapping,
      ClassifiedTBox reasoner) {

    ImmutableCQContainmentCheckUnderLIDs<RelationPredicate> cqc =
        new ImmutableCQContainmentCheckUnderLIDs<>(
            new DBLinearInclusionDependenciesImpl(coreUtilsFactory, atomFactory));

    // index mapping assertions by the predicate type
    // same IRI can be a class name and a property name
    // but the same IRI cannot be an object and a data or annotation property name at the same time
    // see https://www.w3.org/TR/owl2-new-features/#F12:_Punning

    ImmutableMap<MappingAssertionIndex, Collection<MMecTMappingRule>> original =
        mapping.stream().flatMap(a -> unionSplitter.splitUnion(
                    unionNormalizer.optimize(a.getQuery()))
                .map(IQ::normalizeForOptimization) // replaces join equalities
                .map(q -> mappingCqcOptimizer.optimize(cqc, q))
                .map(q -> Maps.immutableEntry(a.getIndex(), new MMecTMappingRule(
                    (MMecPPMappingAssertionProvenance) a.getProvenance(), q,
                    coreSingletons)))
            )
            .collect(ImmutableCollectors.toMultimap())
            .asMap();

    ImmutableMap<MappingAssertionIndex, ImmutableList<MMecTMappingRule>> saturated =
        original.keySet().stream().map(MappingAssertionIndex::getPredicate).distinct().map(
                rdfAtomPredicate -> new TMappingRuleHeadConstructorProvider(rdfAtomPredicate,
                    termFactory))
            .flatMap(provider -> Stream.concat(Stream.concat(
                    reasoner.objectPropertiesDAG().stream().filter(
                            node -> !node.getRepresentative().isInverse()
                                && !tmappingExclusionConfig.contains(
                                node.getRepresentative()))
                        .flatMap(node -> node.getMembers().stream()
                            .filter(d -> !d.isInverse() || d.getInverse() != node.getRepresentative())
                            .map(
                                saturator(node, reasoner.objectPropertiesDAG(), original,
                                    provider::constructor,
                                    cqc))),

                    reasoner.dataPropertiesDAG().stream()
                        .filter(node -> !tmappingExclusionConfig.contains(node.getRepresentative()))
                        .flatMap(node -> node.getMembers().stream().map(
                            saturator(node, reasoner.dataPropertiesDAG(), original,
                                provider::constructor,
                                cqc)))),

                reasoner.classesDAG().stream().filter(
                        node -> node.getRepresentative() instanceof OClass
                            && !tmappingExclusionConfig.contains((OClass) node.getRepresentative()))
                    .flatMap(
                        node -> node.getMembers().stream().filter(d -> d instanceof OClass).map(
                            saturator(node, reasoner.classesDAG(), original, provider::constructor,
                                cqc)))))

            .filter(e -> !e.getValue().isEmpty()).collect(ImmutableCollectors.toMap());

    ImmutableMap<MappingAssertionIndex, ImmutableList<MMecTMappingRule>> combined = Stream.concat(
            saturated.entrySet().stream(),
            original.entrySet().stream().filter(e -> !saturated.containsKey(e.getKey())).map(
                e -> Maps.immutableEntry(e.getKey(),
                    e.getValue().stream().collect(
                        MMecTMappingEntry.toMMecTMappingEntry(cqc, coreSingletons)))))
        .collect(ImmutableCollectors.toMap());

    return combined.entrySet().stream().map(
        e -> new MappingAssertion(e.getKey(), toIQ(e.getValue()), null)).collect(
        ImmutableCollectors.toList());
  }

  private IQ toIQ(Collection<MMecTMappingRule> rules) {
    return queryMerger.mergeDefinitions(
            rules.stream().map(r -> r.asIQ(coreSingletons)).collect(ImmutableCollectors.toList())).get()
        .normalizeForOptimization();
  }

  private <T> Function<T, Map.Entry<MappingAssertionIndex, ImmutableList<MMecTMappingRule>>> saturator(
      Equivalences<T> node, EquivalencesDAG<T> dag,
      ImmutableMap<MappingAssertionIndex, Collection<MMecTMappingRule>> original,
      Function<T, TMappingRuleHeadConstructor> constructor,
      ImmutableCQContainmentCheckUnderLIDs<RelationPredicate> cqc) {

    IRIConstant iri = constructor.apply(node.getRepresentative()).getIri();

    ImmutableList<MMecTMappingRule> saturatedRepresentative = dag.getSub(node).stream().flatMap(
            subnode -> subnode.getMembers().stream()).map(constructor).flatMap(
            t -> original.getOrDefault(t.indexOf(), ImmutableList.of()).stream()
                .map(m -> new MMecTMappingRule(m.getProvenance(), t.getArguments(m.getHeadTerms(), iri),
                    m)))
        .collect(
            MMecTMappingEntry.toMMecTMappingEntry(cqc, coreSingletons));

    return constructor.andThen(t -> Maps.immutableEntry(t.indexOf(),
        saturatedRepresentative.stream()
            .map(m -> new MMecTMappingRule(m.getProvenance(),
                t.getArguments(m.getHeadTerms(), t.getIri()), m))
            .collect(ImmutableCollectors.toList())));
  }

  private abstract static class TMappingRuleHeadConstructor {
    final MappingAssertionIndex index;
    final IRIConstant iri;

    TMappingRuleHeadConstructor(MappingAssertionIndex index, TermFactory termFactory) {
      this.index = index;
      this.iri = termFactory.getConstantIRI(index.getIri());
    }

    MappingAssertionIndex indexOf() {
      return index;
    }

    IRIConstant getIri() {
      return iri;
    }

    abstract ImmutableList<ImmutableTerm> getArguments(ImmutableList<ImmutableTerm> args,
        IRIConstant newIri);
  }


  private static class TMappingRuleHeadConstructorProvider {
    private final RDFAtomPredicate predicate;
    private final TermFactory termFactory;
    private final IRIConstant rdfType;

    TMappingRuleHeadConstructorProvider(RDFAtomPredicate rdfAtomPredicate,
        TermFactory termFactory) {
      this.predicate = rdfAtomPredicate;
      this.termFactory = termFactory;
      this.rdfType = termFactory.getConstantIRI(RDF.TYPE);
    }

    TMappingRuleHeadConstructor constructor(ClassExpression ce) {
      if (ce instanceof OClass oc) {
        return new TMappingRuleHeadConstructor(
            MappingAssertionIndex.ofClass(predicate, oc.getIRI()), termFactory) {
          @Override
          public ImmutableList<ImmutableTerm> getArguments(ImmutableList<ImmutableTerm> args,
              IRIConstant newIri) {
            return predicate.updateSPO(args, predicate.getSubject(args), rdfType, newIri);
          }
        };
      } else if (ce instanceof ObjectSomeValuesFrom) {
        ObjectPropertyExpression ope = ((ObjectSomeValuesFrom) ce).getProperty();
        return new TMappingRuleHeadConstructor(
            MappingAssertionIndex.ofProperty(predicate, ope.getIRI()), termFactory) {
          @Override
          public ImmutableList<ImmutableTerm> getArguments(ImmutableList<ImmutableTerm> args,
              IRIConstant newIri) {
            return predicate.updateSPO(args,
                ope.isInverse() ? predicate.getObject(args) : predicate.getSubject(args), rdfType,
                newIri);
          }
        };
      } else if (ce instanceof DataSomeValuesFrom) {
        DataPropertyExpression dpe = ((DataSomeValuesFrom) ce).getProperty();
        return new TMappingRuleHeadConstructor(
            MappingAssertionIndex.ofProperty(predicate, dpe.getIRI()), termFactory) {
          @Override
          public ImmutableList<ImmutableTerm> getArguments(ImmutableList<ImmutableTerm> args,
              IRIConstant newIri) {
            return predicate.updateSPO(args, predicate.getSubject(args), rdfType, newIri);
          }
        };
      } else {
        throw new MinorOntopInternalBugException("Unexpected type" + ce);
      }
    }

    TMappingRuleHeadConstructor constructor(ObjectPropertyExpression ope) {
      return new TMappingRuleHeadConstructor(
          MappingAssertionIndex.ofProperty(predicate, ope.getIRI()), termFactory) {
        @Override
        public ImmutableList<ImmutableTerm> getArguments(ImmutableList<ImmutableTerm> args,
            IRIConstant newIri) {
          return ope.isInverse() ? predicate.updateSPO(args, predicate.getObject(args), newIri,
              predicate.getSubject(args))
              : predicate.updateSPO(args, predicate.getSubject(args),
                  newIri, predicate.getObject(args));
        }
      };
    }

    TMappingRuleHeadConstructor constructor(DataPropertyExpression dpe) {
      return new TMappingRuleHeadConstructor(
          MappingAssertionIndex.ofProperty(predicate, dpe.getIRI()), termFactory) {
        @Override
        public ImmutableList<ImmutableTerm> getArguments(ImmutableList<ImmutableTerm> args,
            IRIConstant newIri) {
          return predicate.updateSPO(args, predicate.getSubject(args), newIri,
              predicate.getObject(args));
        }
      };
    }
  }
}

package it.unibz.inf.ontop.spec.mapping.transformer.impl;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecPpMappingAssertionProvenance;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.ProvUnion;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import it.unibz.inf.ontop.constraints.Homomorphism;
import it.unibz.inf.ontop.constraints.HomomorphismFactory;
import it.unibz.inf.ontop.constraints.impl.ExtensionalDataNodeHomomorphismIteratorImpl;
import it.unibz.inf.ontop.constraints.impl.ExtensionalDataNodeListContainmentCheck;
import it.unibz.inf.ontop.exception.MinorOntopInternalBugException;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.node.ExtensionalDataNode;
import it.unibz.inf.ontop.iq.node.FilterNode;
import it.unibz.inf.ontop.iq.node.InnerJoinNode;
import it.unibz.inf.ontop.iq.node.QueryNode;
import it.unibz.inf.ontop.iq.node.TrueNode;
import it.unibz.inf.ontop.iq.node.ValuesNode;
import it.unibz.inf.ontop.iq.tools.UnionBasedQueryMerger;
import it.unibz.inf.ontop.model.atom.DistinctVariableOnlyDataAtom;
import it.unibz.inf.ontop.model.atom.RDFAtomPredicate;
import it.unibz.inf.ontop.model.term.Constant;
import it.unibz.inf.ontop.model.term.IRIConstant;
import it.unibz.inf.ontop.model.term.ImmutableExpression;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.VariableOrGroundTerm;
import it.unibz.inf.ontop.model.vocabulary.RDF;
import it.unibz.inf.ontop.spec.mapping.MappingAssertion;
import it.unibz.inf.ontop.spec.mapping.pp.PPMappingAssertionProvenance;
import it.unibz.inf.ontop.substitution.Substitution;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import it.unibz.inf.ontop.utils.VariableGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
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
 * @brief @~french Copie de la classe
 *        it.unibz.inf.ontop.spec.mapping.transformer.impl.MappingAssertionUnion pour l'extension
 *        MMec.
 * @par Détails
 *      Permet de conserver la provenance des règles de mapping, de sorte à pouvoir utiliser des
 *      attributs d'arrimage spécifiques à MMec comme le subset.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2024-03-04 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecMappingAssertionUnion {

  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecMappingAssertionUnion.class);
  private static final Logger log = LoggerFactory.getLogger(MMecMappingAssertionUnion.class);


  public static class MMecMappingAssertionUnionCollector implements
      Collector<MappingAssertion, MMecMappingAssertionUnion, Optional<MappingAssertion>> {
    private final ExtensionalDataNodeListContainmentCheck cqc;
    private final CoreSingletons coreSingletons;
    private final UnionBasedQueryMerger queryMerger;

    public MMecMappingAssertionUnionCollector(ExtensionalDataNodeListContainmentCheck cqc,
        CoreSingletons coreSingletons,
        UnionBasedQueryMerger queryMerger) {
      this.cqc = cqc;
      this.coreSingletons = coreSingletons;
      this.queryMerger = queryMerger;
    }

    @Override
    public Supplier<MMecMappingAssertionUnion> supplier() {
      logger.trace(Trace.ENTER_METHOD_0);
      return () -> new MMecMappingAssertionUnion(cqc, coreSingletons, queryMerger);
    }

    @Override
    public BiConsumer<MMecMappingAssertionUnion, MappingAssertion> accumulator() {
      logger.trace(Trace.ENTER_METHOD_0);
      return MMecMappingAssertionUnion::add;
    }

    @Override
    public BinaryOperator<MMecMappingAssertionUnion> combiner() {
      logger.trace(Trace.ENTER_METHOD_0);
      return (union1, union2) -> {
        throw new MinorOntopInternalBugException("no merge");
      };
    }

    @Override
    public Function<MMecMappingAssertionUnion, Optional<MappingAssertion>> finisher() {
      logger.trace(Trace.ENTER_METHOD_0);
      return MMecMappingAssertionUnion::build;
    }

    @Override
    public Set<Characteristics> characteristics() {
      logger.trace(Trace.ENTER_METHOD_0);
      return Set.of(Collector.Characteristics.UNORDERED);
    }
  }

  public static MMecMappingAssertionUnionCollector toMappingAssertion(
      ExtensionalDataNodeListContainmentCheck cqc, CoreSingletons coreSingletons,
      UnionBasedQueryMerger queryMerger) {
    logger.trace(Trace.ENTER_METHOD_3, cqc, coreSingletons, queryMerger);
    return new MMecMappingAssertionUnionCollector(cqc, coreSingletons, queryMerger);
  }

  private final List<ConjunctiveIQ> conjunctiveIqs = new ArrayList<>();
  private final List<IQ> otherIqs = new ArrayList<>();
  private final ExtensionalDataNodeListContainmentCheck cqc;
  private final TermFactory termFactory;
  private final IntermediateQueryFactory iqFactory;
  private final HomomorphismFactory homomorphismFactory;
  private final CoreSingletons coreSingletons;
  private final UnionBasedQueryMerger queryMerger;

  public MMecMappingAssertionUnion(ExtensionalDataNodeListContainmentCheck cqc,
      CoreSingletons coreSingletons, UnionBasedQueryMerger queryMerger) {
    this.cqc = cqc;
    this.termFactory = coreSingletons.getTermFactory();
    this.iqFactory = coreSingletons.getIQFactory();
    this.homomorphismFactory = coreSingletons.getHomomorphismFactory();
    this.coreSingletons = coreSingletons;
    this.queryMerger = queryMerger;
  }

  public MMecMappingAssertionUnion add(MappingAssertion assertion) {
    logger.trace(Trace.ENTER_METHOD_1, assertion);
    Optional<ConjunctiveIQ> cq = extractConjunctiveIQ(assertion);
    cq.ifPresentOrElse(this::mergeMappingsWithCqc, () -> otherIqs.add(assertion.getQuery()));
    return this;
  }

  private class ConjunctiveIQ {
    private final DistinctVariableOnlyDataAtom projectionAtom;
    private final Substitution<ImmutableTerm> substitution;
    private final ImmutableList<ExtensionalDataNode> extensionalDataNodes;
    private final Optional<ValuesNode> valuesNode;
    private final DisjunctionOfConjunctions filter;

    private final MMecPpMappingAssertionProvenance provenance;

    ConjunctiveIQ(DistinctVariableOnlyDataAtom projectionAtom, ConstructionNode constructionNode,
        ImmutableList<ExtensionalDataNode> extensionalDataNodes, Optional<ValuesNode> valuesNode,
        DisjunctionOfConjunctions filter, PPMappingAssertionProvenance provenance) {
      logger.trace(Trace.ENTER_METHOD_6, projectionAtom, constructionNode, extensionalDataNodes,
          valuesNode, filter, provenance);
      this.provenance = (MMecPpMappingAssertionProvenance) provenance;

      VariableGenerator variableGenerator =
          coreSingletons.getCoreUtilsFactory().createVariableGenerator(
              Stream.concat(constructionNode.getVariables().stream(), Stream.concat(
                  extensionalDataNodes.stream().flatMap(n -> n.getVariables().stream()),
                  valuesNode.stream().flatMap(n -> n.getVariables().stream())))
                  .collect(ImmutableCollectors.toSet()));

      this.projectionAtom = projectionAtom;

      // replaces constant IRI in the object position of properties with a ValueNode
      RDFAtomPredicate rdfAtomPredicate = (RDFAtomPredicate) projectionAtom.getPredicate();
      ImmutableList<ImmutableTerm> args = constructionNode.getSubstitution().apply(
          projectionAtom.getArguments());

      ImmutableMap<IRIConstant, Variable> map = Stream.of(
          Optional.of(rdfAtomPredicate.getSubject(args)), rdfAtomPredicate.getPropertyIRI(args)
              .filter(i -> !i.equals(RDF.TYPE)).map(i -> rdfAtomPredicate.getObject(args)),
          rdfAtomPredicate.getGraph(args)).flatMap(Optional::stream).filter(
              c -> c instanceof IRIConstant)
          .map(c -> (IRIConstant) c).distinct().collect(
              ImmutableCollectors.toMap(c -> c, c -> variableGenerator.generateNewVariable()));

      this.substitution = constructionNode.getSubstitution().transform(t -> Optional.ofNullable(
          map.get(t)).<ImmutableTerm>map(termFactory::getIRIFunctionalTerm).orElse(t));

      ImmutableMap<Variable, Constant> constantSubstitutionEntries =
          map.entrySet().stream().collect(ImmutableCollectors.toMap(Map.Entry::getValue,
              e -> termFactory.getDBStringConstant(e.getKey().getIRI().getIRIString())));

      // replaces constants in extensional data nodes with a ValueNode
      ImmutableMap<Integer, ImmutableMap<Integer, Variable>> variableMap = IntStream.range(0,
          extensionalDataNodes.size()).boxed().collect(
              ImmutableCollectors.toMap(i -> i, i -> extensionalDataNodes.get(i).getArgumentMap()
                  .entrySet().stream().filter(e -> e.getValue() instanceof Constant).collect(
                      ImmutableCollectors.toMap(Map.Entry::getKey,
                          e -> variableGenerator.generateNewVariable()))));

      this.extensionalDataNodes = variableMap.isEmpty() ? extensionalDataNodes
          : IntStream.range(0,
              extensionalDataNodes.size()).mapToObj(
                  i -> variableMap.get(i).isEmpty()
                      ? extensionalDataNodes.get(i)
                      : iqFactory.createExtensionalDataNode(
                          extensionalDataNodes.get(i).getRelationDefinition(),
                          extensionalDataNodes.get(i).getArgumentMap().entrySet().stream().collect(
                              ImmutableCollectors.toMap(Map.Entry::getKey,
                                  e -> Optional.<VariableOrGroundTerm>ofNullable(
                                      variableMap.get(i).get(e.getKey())).orElseGet(e::getValue)))))
              .collect(
                  ImmutableCollectors.toList());

      Optional<ImmutableMap<Variable, Constant>> constantsMap = Optional.of(
          Stream.concat(constantSubstitutionEntries.entrySet().stream(),
              variableMap.entrySet().stream().flatMap(me -> me.getValue().entrySet().stream()
                  .map(e -> Maps.immutableEntry(e.getValue(),
                      (Constant) extensionalDataNodes.get(me.getKey())
                          .getArgumentMap().get(e.getKey())))))
              .collect(ImmutableCollectors.toMap()))
          .filter(cm -> !cm.isEmpty());

      this.valuesNode = valuesNode.map(v -> constantsMap.map(cm -> iqFactory.createValuesNode(
          Sets.union(v.getVariables(), cm.keySet()).immutableCopy(), v.getValueMaps().stream().map(
              m -> Stream.concat(m.entrySet().stream(), cm.entrySet().stream())
                  .collect(ImmutableCollectors.toMap()))
              .collect(ImmutableCollectors.toList())))
          .orElse(v)).or(() -> constantsMap.map(
              cm -> iqFactory.createValuesNode(cm.keySet(), ImmutableList.of(cm))));

      this.filter = filter;
    }

    ConjunctiveIQ(ConjunctiveIQ other, DisjunctionOfConjunctions filter,
        Optional<ValuesNode> valuesNode, MMecPpMappingAssertionProvenance provenance) {
      logger.trace(Trace.ENTER_METHOD_4, other, filter, valuesNode, provenance);
      this.projectionAtom = other.projectionAtom;
      this.substitution = other.substitution;
      this.extensionalDataNodes = other.extensionalDataNodes;

      this.filter = filter;
      this.valuesNode = valuesNode;
      this.provenance = provenance;
    }

    public MMecPpMappingAssertionProvenance getProvenance() {
      return provenance;
    }

    IQ asIQ() {
      logger.trace(Trace.ENTER_METHOD_0);
      return iqFactory.createIQ(projectionAtom,
          iqFactory.createUnaryIQTree(iqFactory.createDistinctNode(), iqFactory.createUnaryIQTree(
              iqFactory.createConstructionNode(projectionAtom.getVariables(), substitution),
              getTree())));
    }

    IQTree getTree() {
      logger.trace(Trace.ENTER_METHOD_0);
      // assumes that filter is a possibly empty list of non-empty lists
      Optional<ImmutableExpression> mergedConditions = translate(filter);

      if (extensionalDataNodes.isEmpty() && valuesNode.isEmpty()) {
        return iqFactory.createTrueNode();
      } else if (valuesNode.isEmpty() && extensionalDataNodes.size() == 1) {
        return mergedConditions.<IQTree>map(
            c -> iqFactory.createUnaryIQTree(iqFactory.createFilterNode(c),
                extensionalDataNodes.get(0)))
            .orElseGet(() -> extensionalDataNodes.get(0));
      } else if (valuesNode.isPresent() && extensionalDataNodes.isEmpty()) {
        return mergedConditions.<IQTree>map(
            c -> iqFactory.createUnaryIQTree(iqFactory.createFilterNode(c), valuesNode.get()))
            .orElseGet(valuesNode::get);
      } else {
        return iqFactory.createNaryIQTree(iqFactory.createInnerJoinNode(mergedConditions),
            Stream.concat(extensionalDataNodes.stream(), valuesNode.stream())
                .collect(ImmutableCollectors.toList()));
      }
    }

    Optional<ImmutableExpression> translate(DisjunctionOfConjunctions filter) {
      logger.trace(Trace.ENTER_METHOD_1, filter);
      switch (filter.getNumberOfConjunctions()) {
        case 0:
          return Optional.empty();
        case 1:
          return termFactory.getDisjunction(
              filter.stream().map(e -> termFactory.getConjunction(ImmutableList.copyOf(e))));
        default:
          ImmutableSet<ImmutableExpression> sharedAtoms = filter.stream().findFirst().map(
              e -> e.stream().filter(c -> filter.stream().allMatch(e2 -> e2.contains(c)))
                  .collect(ImmutableCollectors.toSet()))
              .get();

          return termFactory.getConjunction(Stream.concat(sharedAtoms.stream(),
              termFactory.getDisjunction(filter.stream().map(e -> termFactory.getConjunction(
                  ImmutableList.copyOf(Sets.difference(e, sharedAtoms))))).stream()));
      }
    }

    public ImmutableList<ImmutableTerm> getHeadTerms() {
      logger.trace(Trace.ENTER_METHOD_0);
      return substitution.applyToTerms(projectionAtom.getArguments());
    }

    public Substitution<ImmutableTerm> getSubstitution() {
      logger.trace(Trace.ENTER_METHOD_0);
      return substitution;
    }

    public ImmutableList<ExtensionalDataNode> getDatabaseAtoms() {
      logger.trace(Trace.ENTER_METHOD_0);
      return extensionalDataNodes;
    }

    public Optional<ValuesNode> getValuesNode() {
      logger.trace(Trace.ENTER_METHOD_0);
      return valuesNode;
    }

    public DisjunctionOfConjunctions getConditions() {
      logger.trace(Trace.ENTER_METHOD_0);
      return filter;
    }

    @Override
    public int hashCode() {
      logger.trace(Trace.ENTER_METHOD_0);
      return Objects.hash(substitution, extensionalDataNodes, valuesNode, filter);
    }

    @Override
    public boolean equals(Object o) {
      logger.trace(Trace.ENTER_METHOD_1, o);
      if (o instanceof ConjunctiveIQ other) {
        return projectionAtom.equals(other.projectionAtom) && substitution.equals(
            other.substitution) && extensionalDataNodes.equals(other.extensionalDataNodes)
            && valuesNode.equals(other.valuesNode) && filter.equals(other.filter);
      }
      return false;
    }

    @Override
    public String toString() {
      logger.trace(Trace.ENTER_METHOD_0);
      return projectionAtom.getPredicate() + "(" + getHeadTerms() + ") <- " + extensionalDataNodes
          + " FILTER " + filter + " " + valuesNode;
    }

  }

  private Optional<ConjunctiveIQ> extractConjunctiveIQ(MappingAssertion assertion) {
    DistinctVariableOnlyDataAtom projectionAtom = assertion.getProjectionAtom();
    ConstructionNode constructionNode =
        (ConstructionNode) assertion.getQuery().getTree().getRootNode();
    IQTree topTree = assertion.getTopChild();
    if (topTree instanceof TrueNode) {
      return Optional.of(
          new ConjunctiveIQ(projectionAtom, constructionNode, ImmutableList.of(), Optional.empty(),
              DisjunctionOfConjunctions.getTrue(), assertion.getProvenance()));
    }
    if (topTree instanceof ExtensionalDataNode) {
      return Optional.of(new ConjunctiveIQ(projectionAtom, constructionNode,
          ImmutableList.of((ExtensionalDataNode) topTree), Optional.empty(),
          DisjunctionOfConjunctions.getTrue(), assertion.getProvenance()));
    }
    if (topTree instanceof ValuesNode) {
      return Optional.of(new ConjunctiveIQ(projectionAtom, constructionNode, ImmutableList.of(),
          Optional.of((ValuesNode) topTree), DisjunctionOfConjunctions.getTrue(),
          assertion.getProvenance()));
    }

    QueryNode topNode = topTree.getRootNode();
    if (topNode instanceof FilterNode) {
      ImmutableExpression filter = ((FilterNode) topNode).getFilterCondition();
      IQTree childTree = ((UnaryIQTree) topTree).getChild();
      if (childTree instanceof ExtensionalDataNode) {
        return Optional.of(new ConjunctiveIQ(projectionAtom, constructionNode,
            ImmutableList.of((ExtensionalDataNode) childTree), Optional.empty(),
            DisjunctionOfConjunctions.of(filter), assertion.getProvenance()));
      }
      if (childTree instanceof ValuesNode) {
        return Optional.of(new ConjunctiveIQ(projectionAtom, constructionNode, ImmutableList.of(),
            Optional.of((ValuesNode) childTree), DisjunctionOfConjunctions.of(filter),
            assertion.getProvenance()));
      }
    }

    if (topNode instanceof InnerJoinNode) {
      ImmutableList<IQTree> childrenTrees = topTree.getChildren();
      ImmutableList<ExtensionalDataNode> extensionalDataNodes = childrenTrees.stream().filter(
          n -> n instanceof ExtensionalDataNode).map(n -> (ExtensionalDataNode) n).collect(
              ImmutableCollectors.toList());

      ImmutableList<ValuesNode> valuesNodes = childrenTrees.stream().filter(
          n -> n instanceof ValuesNode).map(n -> (ValuesNode) n).collect(
              ImmutableCollectors.toList());

      if (extensionalDataNodes.size() + valuesNodes.size() == childrenTrees.size()
          && valuesNodes.size() <= 1) {
        DisjunctionOfConjunctions filter =
            ((InnerJoinNode) topNode).getOptionalFilterCondition().map(
                DisjunctionOfConjunctions::of).orElseGet(DisjunctionOfConjunctions::getTrue);

        return Optional.of(new ConjunctiveIQ(projectionAtom, constructionNode, extensionalDataNodes,
            valuesNodes.stream().findFirst(), filter, assertion.getProvenance()));
      }
    }

    return Optional.empty();
  }

  public Optional<MappingAssertion> build() {
    Optional<IQ> query = queryMerger.mergeDefinitions(
        Stream.concat(conjunctiveIqs.stream().map(ConjunctiveIQ::asIQ), otherIqs.stream())
            .collect(ImmutableCollectors.toList()))
        .map(IQ::normalizeForOptimization);

    // if (query.toString().contains("UNION"))
    // System.out.println("MAU-UNION: " + query);
    PPMappingAssertionProvenance provenance = conjunctiveIqs.stream().map(
        ConjunctiveIQ::getProvenance).collect(ProvUnion.getPpMappingAssertionProvenanceCollector())
        .orElse(null);
    return query.map(q -> new MappingAssertion(q, provenance));
  }



  /***
   * This is an optimization mechanism that allows T-mappings to reduce
   * the number of mapping assertions. The unfolding will then produce fewer queries.
   * <br>
   * The method
   * (1) removes a mapping assertion from rules if it is subsumed by the given assertion
   * <br>
   * (2) does not add the assertion if it is subsumed by one of the rules
   * <br>
   * (3) merges the given assertion into an existing assertion if their database atoms
   * are homomorphically equivalent
   * <br>
   * (4) removes any assertion that is a subset of the given assertion
   * <br>
   * For example, if we are given
   * S(x,z) :- R(x,y,z), y = 2
   * and rules contains
   * S(x,z) :- R(x,y,z), y > 7
   * then this method will modify the existing assertion into
   * S(x,z) :- R(x,y,z), OR(y > 7, y = 2)
   */
  private void mergeMappingsWithCqc(ConjunctiveIQ newCiq) {

    // System.out.println("PROCESSING: " + newCiq);

    if (conjunctiveIqs.contains(newCiq)) {
      return;
    }

    Iterator<ConjunctiveIQ> iterator = conjunctiveIqs.iterator();
    while (iterator.hasNext()) {

      ConjunctiveIQ currentCiq = iterator.next();

      boolean currentCiqContainsNewCiqButIsLonger = false;

      Optional<Homomorphism> fromCurrentCiq = getHomomorphismIterator(currentCiq, newCiq).filter(
          Iterator::hasNext).map(Iterator::next);
      Optional<DisjunctionOfConjunctions> currentCiqConditionsImage = fromCurrentCiq.map(
          h -> applyHomomorphism(h, currentCiq.getConditions()));
      if (fromCurrentCiq.isPresent() && contains(currentCiqConditionsImage.get(),
          newCiq.getConditions())
          && contains(fromCurrentCiq.get(), currentCiq.getValuesNode(),
              newCiq.getValuesNode())) {
        if (newCiq.getDatabaseAtoms().size() >= currentCiq.getDatabaseAtoms().size()) {
          return;
        }
        currentCiqContainsNewCiqButIsLonger = true;
      }

      Optional<Homomorphism> fromNewCiq = getHomomorphismIterator(newCiq, currentCiq).filter(
          Iterator::hasNext).map(Iterator::next);
      Optional<DisjunctionOfConjunctions> newCiqConditionsImage = fromNewCiq.map(
          h -> applyHomomorphism(h, newCiq.getConditions()));

      if (fromNewCiq.isPresent() && contains(newCiqConditionsImage.get(),
          currentCiq.getConditions())
          && contains(fromNewCiq.get(), newCiq.getValuesNode(),
              currentCiq.getValuesNode())) {
        iterator.remove();
        continue;
      }

      if (currentCiqContainsNewCiqButIsLonger) {
        return;
      }

      if (fromCurrentCiq.isPresent() && fromNewCiq.isPresent()) {
        if (currentCiq.getConditions().isTrue() && newCiq.getConditions().isTrue()
            || newCiqConditionsImage.get().equals(currentCiq.getConditions())) {
          ValuesNode currentCiqValuesNode = currentCiq.getValuesNode().get();
          Optional<ValuesNode> optionalNewCiqValuesNodeImage = applyHomomorphism(fromNewCiq.get(),
              newCiq.getValuesNode().get());
          if (optionalNewCiqValuesNodeImage.isPresent()) {
            ValuesNode newCiqValuesNodeImage = optionalNewCiqValuesNodeImage.get();
            if (newCiqValuesNodeImage.getVariables().equals(currentCiqValuesNode.getVariables())) {
              iterator.remove();
              conjunctiveIqs.add(new ConjunctiveIQ(currentCiq, currentCiq.getConditions(),
                  Optional.of(
                      iqFactory.createValuesNode(currentCiqValuesNode.getVariables(), Stream.concat(
                          newCiqValuesNodeImage.getValueMaps().stream(),
                          currentCiqValuesNode.getValueMaps().stream()).distinct()
                          .collect(ImmutableCollectors.toList()))),
                  currentCiq.provenance));
              // System.out.println("MAU-MERGE-VALUES: " + currentCiq + " AND " + newCiq);
              return;
            }
          }
        }
        // We found an equivalence, we will try to merge the *non-empty* conditions of newCiq into
        // currentCiq
        ImmutableSet<Variable> currentCiqDatabaseAtomVariables =
            currentCiq.getDatabaseAtoms().stream().flatMap(a -> a.getVariables().stream()).collect(
                ImmutableCollectors.toSet());

        DisjunctionOfConjunctions newCiqCombinedConditionsImage = DisjunctionOfConjunctions.getAND(
            newCiqConditionsImage.get(),
            applyHomomorphism(fromNewCiq.get(), translate(newCiq.getValuesNode())));

        if (currentCiqDatabaseAtomVariables.containsAll(
            newCiqCombinedConditionsImage.getVariables())) {
          iterator.remove();
          conjunctiveIqs.add(new ConjunctiveIQ(currentCiq, DisjunctionOfConjunctions.getOR(
              DisjunctionOfConjunctions.getAND(currentCiq.getConditions(),
                  translate(currentCiq.getValuesNode())),
              newCiqCombinedConditionsImage),
              Optional.empty(), currentCiq.provenance));
          // System.out.println("MAU-MERGE-CONDITION: " + currentCiq + " AND " + newCiq);
          return;
        }
        // one reason for non-merge is R(x,_), x = 1 and R(_,x), x = 2 (see
        // TMappingConstantPositionsTest)
        // second reason for non-merge is variables in ValueNode that do not occur in data atoms
        // (but occur in the ConstructionNode instead)
        // System.out.println("MAU-CANT-MERGE-45: " + currentCiq + " AND " + newCiq + " " +
        // currentCiqDatabaseAtomVariables + " " + newCiqCombinedConditionsImage.getVariables());
      }

      if (isSubsetOfAlreadyPresentRule(conjunctiveIqs, newCiq)) {
        return;
      }

      Iterators.removeIf(iterator,
          potentialSubSet -> newCiq.getProvenance().getMmecTriplesMap().getSubsetList()
              .contains(potentialSubSet.getProvenance().getMmecTriplesMap()));
    }
    conjunctiveIqs.add(newCiq);
  }

  /**
   * @brief @~english «Description of the method»
   * @param newCiq «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Vérifie si la nouvelle règle est un sous-ensemble d'une règle déjà présente
   * @param newCiq La nouvelle règle à vérifier
   * @return Vrai si la nouvelle règle est un sous-ensemble d'une règle déjà présente
   */
  private boolean isSubsetOfAlreadyPresentRule(List<ConjunctiveIQ> conjunctiveIQs,
      ConjunctiveIQ newCiq) {
    return conjunctiveIQs.stream().anyMatch(
        potentialSuperSet -> potentialSuperSet.getProvenance().getMmecTriplesMap().getSubsetList()
            .contains(newCiq.getProvenance().getMmecTriplesMap()));
  }

  private DisjunctionOfConjunctions translate(Optional<ValuesNode> valuesNode) {
    if (valuesNode.isEmpty()) {
      return DisjunctionOfConjunctions.getTrue();
    }

    return DisjunctionOfConjunctions.of(termFactory.getDisjunction(
        valuesNode.get().getValueMaps().stream().map(m -> termFactory.getConjunction(
            m.entrySet().stream().map(e -> termFactory.getStrictEquality(e.getKey(), e.getValue()))
                .collect(ImmutableCollectors.toList())))
            .collect(ImmutableCollectors.toList())));
  }

  private Optional<Iterator<Homomorphism>> getHomomorphismIterator(ConjunctiveIQ from,
      ConjunctiveIQ to) {
    Homomorphism.Builder builder = homomorphismFactory.getHomomorphismBuilder();
    if (!builder.extend(from.getHeadTerms(), to.getHeadTerms()).isValid()) {
      return Optional.empty();
    }

    Homomorphism h = builder.build();
    return Optional.of(new ExtensionalDataNodeHomomorphismIteratorImpl(h, from.getDatabaseAtoms(),
        cqc.chase(to.getDatabaseAtoms())));
  }

  private DisjunctionOfConjunctions applyHomomorphism(Homomorphism h, DisjunctionOfConjunctions f) {
    return f.stream().map(d -> d.stream().map(atom -> h.applyToBooleanExpression(atom, termFactory))
        .collect(ImmutableCollectors.toSet())).collect(
            DisjunctionOfConjunctions.toDisjunctionOfConjunctions());
  }

  private Optional<ValuesNode> applyHomomorphism(Homomorphism h, ValuesNode n) {
    ImmutableSet<Variable> newVariables = n.getVariables().stream().map(h::apply).map(
        v -> (Variable) v).collect(ImmutableCollectors.toSet());

    if (newVariables.size() < n.getVariables().size()) {
      return Optional.empty();
    }

    return Optional.of(iqFactory.createValuesNode(newVariables, n.getValueMaps().stream().map(
        m -> m.entrySet().stream().collect(
            ImmutableCollectors.toMap(e -> (Variable) h.apply(e.getKey()), Map.Entry::getValue)))
        .collect(ImmutableCollectors.toList())));
  }

  private boolean contains(DisjunctionOfConjunctions f1, DisjunctionOfConjunctions f2) {
    return f1.isTrue() || !f2.isTrue() && f2.stream().allMatch(
        c -> f1.stream().anyMatch(c::containsAll));
  }

  private boolean contains(Homomorphism h, Optional<ValuesNode> v1, Optional<ValuesNode> v2) {
    if (v1.isEmpty()) {
      return true;
    }

    Optional<ValuesNode> v1Image = applyHomomorphism(h, v1.get());
    return v1Image.filter(valuesNode -> v2.isPresent() && v2.get().getValueMaps().stream().allMatch(
        c -> valuesNode.getValueMaps().stream()
            .anyMatch(m -> c.entrySet().containsAll(m.entrySet()))))
        .isPresent();

  }
}

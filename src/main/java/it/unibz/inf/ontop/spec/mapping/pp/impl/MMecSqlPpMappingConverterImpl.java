/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Copie de l'implémentation de
 *  it.unibz.inf.ontop.spec.mapping.pp.impl.SQLPPMappingConverterImpl.
 * @brief @~english Copy of the implementation of
 *  it.unibz.inf.ontop.spec.mapping.pp.impl.SQLPPMappingConverterImpl.
 */

package it.unibz.inf.ontop.spec.mapping.pp.impl;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.iq.optimizer.MMecQueryOptimizer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import it.unibz.inf.ontop.dbschema.MetadataLookup;
import it.unibz.inf.ontop.dbschema.QuotedID;
import it.unibz.inf.ontop.dbschema.QuotedIDFactory;
import it.unibz.inf.ontop.dbschema.impl.RawQuotedIDFactory;
import it.unibz.inf.ontop.exception.InvalidMappingSourceQueriesException;
import it.unibz.inf.ontop.exception.InvalidQueryException;
import it.unibz.inf.ontop.exception.MetadataExtractionException;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.injection.OntopOBDASettings;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.NonVariableTerm;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.spec.mapping.MappingAssertion;
import it.unibz.inf.ontop.spec.mapping.TargetAtom;
import it.unibz.inf.ontop.spec.mapping.pp.PPMappingAssertionProvenance;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMappingConverter;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import it.unibz.inf.ontop.spec.sqlparser.RAExpression;
import it.unibz.inf.ontop.spec.sqlparser.SQLQueryParser;
import it.unibz.inf.ontop.substitution.Substitution;
import it.unibz.inf.ontop.substitution.SubstitutionFactory;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * SQLPPMapping -> MappingAssertion
 */
public class MMecSqlPpMappingConverterImpl implements SQLPPMappingConverter {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecSqlPpMappingConverterImpl.class);

  private final IntermediateQueryFactory iqFactory;
  private final SubstitutionFactory substitutionFactory;
  private final SQLQueryParser sqlQueryParser;

  private final boolean ignoreInvalidMappingEntries;
  private final MMecQueryOptimizer mmecOptimizer;

  @Inject
  public MMecSqlPpMappingConverterImpl(CoreSingletons coreSingletons,
      SQLQueryParser sqlQueryParser, MMecQueryOptimizer mmecOptimizer) {
    this.iqFactory = coreSingletons.getIQFactory();
    this.substitutionFactory = coreSingletons.getSubstitutionFactory();
    this.sqlQueryParser = sqlQueryParser;

    ignoreInvalidMappingEntries =
        ((OntopOBDASettings) coreSingletons.getSettings()).ignoreInvalidMappingEntries();
    this.mmecOptimizer = mmecOptimizer;
  }

  private static <T> Function<Variable, Optional<T>> placeholderLookup(
      SQLPPTriplesMap mappingAssertion, QuotedIDFactory idFactory,
      ImmutableMap<QuotedID, T> lookup) {
    logger.trace(Trace.ENTER_METHOD_3, mappingAssertion, idFactory, lookup);

    Function<Variable, Optional<T>> standard =
        v -> Optional.ofNullable(lookup.get(idFactory.createAttributeID(v.getName().trim())));

    if (mappingAssertion instanceof OntopNativeSQLPPTriplesMap) {
      QuotedIDFactory rawIdFactory = new RawQuotedIDFactory(idFactory);
      return v -> Optional.ofNullable(
          standard.apply(v).orElse(lookup.get(rawIdFactory.createAttributeID(v.getName().trim()))));
    } else {
      return standard;
    }
  }

  @Override
  public ImmutableList<MappingAssertion> convert(ImmutableList<SQLPPTriplesMap> mapping,
      MetadataLookup metadataLookup)
      throws InvalidMappingSourceQueriesException, MetadataExtractionException {
    logger.trace(Trace.ENTER_METHOD_2, mapping, metadataLookup);
    ImmutableList.Builder<MappingAssertion> builder = ImmutableList.builder();
    for (SQLPPTriplesMap assertion : mapping) {
      RAExpression re;
      IQTree tree;
      Function<Variable, Optional<ImmutableTerm>> lookup;

      try {
        re = getRaExpression(assertion, metadataLookup);
        tree = sqlQueryParser.convert(re);

        lookup = placeholderLookup(assertion, metadataLookup.getQuotedIDFactory(),
            re.getUnqualifiedAttributes());
      } catch (InvalidMappingSourceQueriesException | MetadataExtractionException
          | RuntimeException e) {
        /*
         * NB: runtime exceptions are also caught due to some JDBC drivers throwing them instead of
         * SQLException-s
         */
        if (!ignoreInvalidMappingEntries) {
          throw e;
        }
        logger.warn("Mapping entry {} was ignored due to an issue: {}", assertion.getId(),
            e.getMessage());
        continue;
      }

      for (TargetAtom target : assertion.getTargetAtoms()) {
        try {
          PPMappingAssertionProvenance provenance = assertion.getMappingAssertionProvenance(target);
          builder.add(convert(target, lookup, provenance, tree));
        } catch (InvalidMappingSourceQueriesException e) {
          if (!ignoreInvalidMappingEntries) {
            throw e;
          }
          logger.warn("Target atom {} was ignored due to an issue: {}", target, e.getMessage());
        }
      }
    }

    ImmutableList<MappingAssertion> result = builder.build();
    logger.debug("Original mapping size: {}", result.size());
    return result;
  }

  private MappingAssertion convert(TargetAtom target,
      Function<Variable, Optional<ImmutableTerm>> lookup, PPMappingAssertionProvenance provenance,
      IQTree tree) throws InvalidMappingSourceQueriesException {
    logger.trace(Trace.ENTER_METHOD_4, target, lookup, provenance, tree);
    Substitution<ImmutableTerm> targetSubstitution = target.getSubstitution();

    ImmutableMap<Variable, Optional<ImmutableTerm>> targetPreMap =
        targetSubstitution.apply(target.getProjectionAtom().getArguments()).stream()
            .flatMap(ImmutableTerm::getVariableStream).distinct()
            .collect(ImmutableCollectors.toMap(v -> v, lookup));

    ImmutableList<String> missingPlaceholders =
        targetPreMap.entrySet().stream().filter(e -> e.getValue().isEmpty()).map(Map.Entry::getKey)
            .map(Variable::getName).collect(ImmutableCollectors.toList());

    if (!missingPlaceholders.isEmpty()) {
      throw new InvalidMappingSourceQueriesException(missingPlaceholders.stream().collect(
          Collectors.joining(", ", "The placeholder(s) ",
              " in the target do(es) not occur in source query of the mapping assertion\n["
                  + provenance.getProvenanceInfo() + "]")));
    }

    // noinspection OptionalGetWithoutIsPresent
    Substitution<ImmutableTerm> substitution = targetPreMap.entrySet().stream().collect(
        substitutionFactory.toSubstitutionSkippingIdentityEntries(Map.Entry::getKey,
            e -> e.getValue().get()));

    Substitution<Variable> targetRenamingPart = substitution.restrictRangeTo(Variable.class);
    Substitution<ImmutableTerm> spoSubstitution =
        targetSubstitution.transform(targetRenamingPart::applyToTerm);

    Substitution<? extends ImmutableTerm> selectSubstitution =
        substitution.restrictRangeTo(NonVariableTerm.class);

    IQTree selectTree = iqFactory.createUnaryIQTree(
        iqFactory.createConstructionNode(spoSubstitution.getRangeVariables(), selectSubstitution),
        tree);

    IQTree mappingTree = iqFactory.createUnaryIQTree(
        iqFactory.createConstructionNode(target.getProjectionAtom().getVariables(),
            spoSubstitution),
        selectTree);

    mappingTree = mmecOptimizer.optimize(mappingTree);

    return new MappingAssertion(iqFactory.createIQ(target.getProjectionAtom(), mappingTree),
        provenance);
  }

  public RAExpression getRaExpression(SQLPPTriplesMap mappingAssertion,
      MetadataLookup metadataLookup)
      throws InvalidMappingSourceQueriesException, MetadataExtractionException {
    logger.trace(Trace.ENTER_METHOD_2, mappingAssertion, metadataLookup);
    String sourceQuery = mappingAssertion.getSourceQuery().getSQL();
    try {
      return sqlQueryParser.getRAExpression(sourceQuery, metadataLookup);
    } catch (InvalidQueryException e) {
      throw new InvalidMappingSourceQueriesException(
          "Error: " + e.getMessage() + " \nProblem location: source query of triplesMap \n["
              + mappingAssertion.getTriplesMapProvenance().getProvenanceInfo() + "]");
    }
  }
}

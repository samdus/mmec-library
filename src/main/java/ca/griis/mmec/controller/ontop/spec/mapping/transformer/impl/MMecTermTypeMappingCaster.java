/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecTermTypeMappingCaster.
 * @brief @~english MMecTermTypeMappingCaster class implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping.transformer.impl;

import com.google.inject.Inject;
import it.unibz.inf.ontop.exception.MinorOntopInternalBugException;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.type.SingleTermTypeExtractor;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.RDFConstant;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.FunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.FunctionSymbolFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.RDFTermType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.spec.mapping.MappingAssertion;
import it.unibz.inf.ontop.spec.mapping.transformer.MappingCaster;
import it.unibz.inf.ontop.substitution.Substitution;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.util.Optional;

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
 * @brief @~french Copie de it.unibz.inf.ontop.spec.mapping.transformer.impl.TermTypeMappingCaster
 *                 où on ne vérifie pas que les termes sont RDF.
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
 *      2024-02-28 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecTermTypeMappingCaster implements MappingCaster  {
  private final FunctionSymbolFactory functionSymbolFactory;
  private final IntermediateQueryFactory iqFactory;
  private final SingleTermTypeExtractor typeExtractor;
  private final TermFactory termFactory;
  private final DBTermType dBStringType;

  @Inject
  private MMecTermTypeMappingCaster(FunctionSymbolFactory functionSymbolFactory,
      CoreSingletons coreSingletons,
      SingleTermTypeExtractor typeExtractor) {
    this.functionSymbolFactory = functionSymbolFactory;
    this.iqFactory = coreSingletons.getIQFactory();
    this.typeExtractor = typeExtractor;
    this.termFactory = coreSingletons.getTermFactory();
    this.dBStringType = coreSingletons.getTypeFactory().getDBTypeFactory().getDBStringType();
  }

  @Override
  public MappingAssertion transform(MappingAssertion assertion) {
    return assertion;
//    IQTree childTree = assertion.getTopChild();
//
//    Substitution<ImmutableTerm> newSubstitution = assertion.getTopSubstitution()
//        .transform(t -> transformDefinition(t, childTree));
//
//    ConstructionNode newRootNode = iqFactory.createConstructionNode(assertion.getProjectedVariables(), newSubstitution);
//
//    return assertion.copyOf(iqFactory.createUnaryIQTree(newRootNode, childTree), iqFactory);
  }

  private ImmutableTerm transformDefinition(ImmutableTerm rdfTerm, IQTree childTree) {
    if (rdfTerm instanceof ImmutableFunctionalTerm) {
      ImmutableFunctionalTerm rdfTermDefinition = (ImmutableFunctionalTerm) rdfTerm;
      ImmutableTerm uncastLexicalTerm = DBTypeConversionFunctionSymbol.uncast(rdfTermDefinition.getTerm(0));
      ImmutableTerm rdfTypeTerm = rdfTermDefinition.getTerm(1);

      Optional<DBTermType> dbType = extractInputDBType(uncastLexicalTerm, childTree);
      RDFTermType rdfType = extractRDFTermType(rdfTypeTerm);

      ImmutableTerm newLexicalTerm = transformNestedTemporaryToStringConversions(
          transformTopOfLexicalTerm(uncastLexicalTerm, dbType, rdfType), childTree);

      return termFactory.getRDFFunctionalTerm(newLexicalTerm, rdfTypeTerm).simplify();
    }
    else if (rdfTerm instanceof RDFConstant) {
      return rdfTerm;
    }
    else
      throw new IllegalArgumentException("Was expecting an ImmutableFunctionalTerm or a Constant");
  }

  private Optional<DBTermType> extractInputDBType(ImmutableTerm uncastLexicalTerm, IQTree childTree) {
    Optional<TermType> type = typeExtractor.extractSingleTermType(uncastLexicalTerm, childTree);
    if (type
        .filter(t -> !(t instanceof DBTermType))
        .isPresent()) {
      throw new MinorOntopInternalBugException("Was expecting to get a DBTermType, not a "
          + type.get().getClass() + " (" + type.get() + ")");
    }
    return type
        .map(t -> (DBTermType)t);
  }

  private RDFTermType extractRDFTermType(ImmutableTerm rdfTypeTerm) {
    if (rdfTypeTerm instanceof RDFTermTypeConstant) {
      return ((RDFTermTypeConstant) rdfTypeTerm).getRDFTermType();
    }
    throw new MinorOntopInternalBugException("Was expecting a RDFTermTypeConstant in the RDF term function, " +
        "not " + rdfTypeTerm);
  }

  private ImmutableTerm transformTopOfLexicalTerm(ImmutableTerm uncastLexicalTerm, Optional<DBTermType> dbType,
      RDFTermType rdfType) {

    return dbType
        .map(i ->
            i.equals(dBStringType)
                ? uncastLexicalTerm
                : termFactory.getConversion2RDFLexical(i, uncastLexicalTerm, rdfType))
        .orElseGet(() -> termFactory.getDBCastFunctionalTerm(dBStringType, uncastLexicalTerm));
  }

  /**
   * For dealing with arguments of templates (which are always cast as strings)
   *
   * Either remove the conversion function (if not needed), replace it by a conversion function
   * knowing its input type or, in the "worst" case, by a replace it by a casting function
   * NOT knowing the input type.
   *
   */
  private ImmutableTerm transformNestedTemporaryToStringConversions(ImmutableTerm term, IQTree childTree) {
    if (term instanceof ImmutableFunctionalTerm) {
      ImmutableFunctionalTerm functionalTerm = (ImmutableFunctionalTerm) term;
      FunctionSymbol functionSymbol = functionalTerm.getFunctionSymbol();

      if (DBTypeConversionFunctionSymbol.isTemporary(functionSymbol)) {
        DBTypeConversionFunctionSymbol conversionFunctionSymbol = (DBTypeConversionFunctionSymbol) functionSymbol;
        if (functionSymbol.getArity() != 1)
          throw new MinorOntopInternalBugException("The casting function was expected to be unary");

        // Optimization: recursion does not seem to be needed
        ImmutableTerm childTerm = functionalTerm.getTerm(0);

        Optional<DBTermType> inputType = extractInputDBType(childTerm, childTree);

        return Optional.of(conversionFunctionSymbol.getTargetType())
            .filter(targetType -> !inputType.filter(targetType::equals).isPresent())
            .map(targetType -> inputType
                .map(i -> targetType.getCategory().equals(DBTermType.Category.STRING)
                    ? termFactory.getConversion2RDFLexical(i, childTerm, termFactory.getTypeFactory().getXsdStringDatatype())
                    // Should not happen. TODO: simplify
                    : termFactory.getDBCastFunctionalTerm(i, targetType, childTerm))
                .orElseGet(() -> termFactory.getDBCastFunctionalTerm(targetType, childTerm)))
            .map(t -> (ImmutableTerm) t)
            .orElse(childTerm);
      }
      else {
        // Recursive
        return termFactory.getImmutableFunctionalTerm(functionSymbol,
            functionalTerm.getTerms().stream()
                .map(t -> transformNestedTemporaryToStringConversions(t, childTree))
                .collect(ImmutableCollectors.toList()));
      }
    }
    else
      return term;
  }
}

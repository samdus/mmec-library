/**
 * @file
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 * @version 1.2.0
 * @brief @~french Implémentation de la classe MMecIndividuationFunctionSymbol.
 * @brief @~english MMecIndividuationFunctionSymbol class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.model.type.MMecIndividuationTermType;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.iq.node.VariableNullability;
import it.unibz.inf.ontop.model.term.ImmutableExpression;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.IncrementalEvaluation;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.AbstractTypedDBFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.ObjectRDFType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TermTypeInference;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
 * @brief @~french Symbole pour la fonction d'individuation.
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
 *      2024-01-30 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      TODO 2024-03-29 [SD] - Retirer l'attribut functionCallTemplate et remplacer le nom de la
 *      fonction appelée par individuation_n où n correspond au nombre de
 *      propriétés identifiantes.
 */
public class MMecIndividuationFunctionSymbol extends AbstractTypedDBFunctionSymbol
    implements RDFTermFunctionSymbol {

  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecIndividuationFunctionSymbol.class);

  private final String functionCallTemplate;
  private final MMecIndividuationTermType mmecIndividuationTermType;

  /***
   * @brief @~english «Description of the method»
   * @param argTypes Type des arguments de la fonction - Spécifiques aux propriétés identifiantes
   * @param returnType «Parameter description»
   *
   * @param functionCallTemplate
   * @brief @~french Constructeur pour le symbole de fonction d'individuation.
   * @par Tâches
   *      S.O.
   */
  public MMecIndividuationFunctionSymbol(ImmutableList<TermType> argTypes,
      ObjectRDFType iriTermType, DBTermType returnType, String functionCallTemplate) {
    super(String.format("Individuation_%s", argTypes.size() - 1), argTypes, returnType);
    this.functionCallTemplate = functionCallTemplate;
    mmecIndividuationTermType = new MMecIndividuationTermType(iriTermType.getAncestry(),
        returnType);
  }

  @Override
  protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
    logger.trace(Trace.ENTER_METHOD_0);
    return true;
  }

  @Override
  public boolean canBePostProcessed(ImmutableList<? extends ImmutableTerm> immutableList) {
    logger.trace(Trace.ENTER_METHOD_1, immutableList);
    return false;
  }

  @Override
  public boolean tolerateNulls() {
    logger.trace(Trace.ENTER_METHOD_0);
    return false;
  }

  @Override
  public String getNativeDBString(ImmutableList<? extends ImmutableTerm> terms,
      Function<ImmutableTerm, String> termConverter, TermFactory termFactory) {
    logger.trace(Trace.ENTER_METHOD_3, terms, termConverter, termFactory);
    return String.format(functionCallTemplate,
        terms.stream().map(termConverter).collect(Collectors.joining(", ")));
  }

  @Override
  public Optional<TermTypeInference> inferType(ImmutableList<? extends ImmutableTerm> terms) {
    logger.trace(Trace.ENTER_METHOD_1, terms);
    return Optional.of(mmecIndividuationTermType).map(TermTypeInference::declareTermType);
  }

  @Override
  public IncrementalEvaluation evaluateStrictEq(ImmutableList<? extends ImmutableTerm> terms,
      ImmutableTerm otherTerm, TermFactory termFactory, VariableNullability variableNullability) {
    logger.trace(Trace.ENTER_METHOD_4, terms, otherTerm, termFactory, variableNullability);
    IncrementalEvaluation evaluation;
    if (otherTerm instanceof ImmutableFunctionalTerm otherTermFunctional
        && otherTermFunctional.getFunctionSymbol() instanceof MMecIndividuationFunctionSymbol) {
      if (otherTermFunctional.getTerms().size() == terms.size()) {
        ImmutableList<? extends ImmutableTerm> otherSubTerms =
            otherTermFunctional.getTerms();

        ImmutableList<ImmutableExpression> conjonctionTerms = IntStream.range(0, terms.size())
            .mapToObj(i -> termFactory.getStrictEquality(terms.get(i), otherSubTerms.get(i)))
            .collect(ImmutableList.toImmutableList());

        evaluation = termFactory.getConjunction(conjonctionTerms).evaluate(variableNullability,
            true);
      } else {
        evaluation = IncrementalEvaluation.declareIsFalse();
      }
    } else {
      evaluation = super.evaluateStrictEq(terms, otherTerm, termFactory, variableNullability);
    }
    return evaluation;
  }

  @Override
  protected Decomposability testDecomposabilityIntoConjunction(
      ImmutableList<? extends ImmutableTerm> terms,
      VariableNullability variableNullability,
      ImmutableList<? extends ImmutableTerm> otherTerms) {
    logger.trace(Trace.ENTER_METHOD_3, terms, variableNullability, otherTerms);
    return Decomposability.NO_WRAPPING_NEEDED;
  }

  @Override
  public final boolean equals(Object other) {
    logger.trace(Trace.ENTER_METHOD_1, other);
    return other instanceof MMecIndividuationFunctionSymbol otherSymbol
        && this.functionCallTemplate.compareToIgnoreCase(otherSymbol.functionCallTemplate) == 0
        && this.mmecIndividuationTermType.equals(otherSymbol.mmecIndividuationTermType)
        && this.getExpectedBaseTypes().equals(otherSymbol.getExpectedBaseTypes());
  }

  @Override
  public final int hashCode() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Arrays.hashCode(new Object[] {
        this.functionCallTemplate.toLowerCase(),
        this.mmecIndividuationTermType,
        this.getExpectedBaseTypes()
    });
  }
}

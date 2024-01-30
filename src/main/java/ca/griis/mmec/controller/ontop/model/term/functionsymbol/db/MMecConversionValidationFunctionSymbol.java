/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecIndividuationFunctionSymbol.
 * @brief @~english MMecIndividuationFunctionSymbol class implementation.
 */
package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.ImmutableExpression;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.AbstractTypedDBFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.DBBooleanFunctionSymbolImpl;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TermType;
import java.util.function.Function;
import java.util.stream.Collectors;

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
 * @brief @~french Symbole pour la fonction de vérification de conversion.
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
 *      S.O.
 */
public class MMecConversionValidationFunctionSymbol extends DBBooleanFunctionSymbolImpl {
  private final String functionCallTemplate;

  /***
   * @brief @~english «Description of the method»
   * @param dbBooleanType «Parameter description»
   * @param argType «Parameter description»
   * @param functionCallTemplate «Parameter description»
   *
   * @brief @~french Constructeur pour le symbole de fonction de vérification de conversion.
   * @param argType Type de l'argument de la fonction
   * @param dbBooleanType Type Booléen dans la base de données
   * @param functionCallTemplate Template pour l'appel de la fonction
   *
   * @par Tâches
   *    S.O.
   */
  protected MMecConversionValidationFunctionSymbol(TermType argType,
      DBTermType dbBooleanType, String functionCallTemplate) {
    super("ConversionValidation", ImmutableList.of(argType), dbBooleanType);
    this.functionCallTemplate = functionCallTemplate;
  }

  @Override
  public String getNativeDBString(ImmutableList<? extends ImmutableTerm> terms,
      Function<ImmutableTerm, String> termConverter, TermFactory termFactory) {
    return String.format(functionCallTemplate,
        terms.stream().map(termConverter).collect(Collectors.joining(", ")));
  }

  @Override
  protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
    return false;
  }

  @Override
  protected boolean tolerateNulls() {
    return true;
  }

  @Override
  public boolean canBePostProcessed(ImmutableList<? extends ImmutableTerm> immutableList) {
    return true;
  }

  @Override
  public boolean blocksNegation() {
    return true;
  }

  @Override
  public ImmutableExpression negate(ImmutableList<? extends ImmutableTerm> subTerms,
      TermFactory termFactory) {
    throw new UnsupportedOperationException();
  }
}

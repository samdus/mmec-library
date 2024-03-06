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
import it.unibz.inf.ontop.model.term.DBConstant;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.AbstractDBTypeConversionFunctionSymbolImpl;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details «Detailed description of the component (optional)»
 * @par Model «Model (Abstract, automation, etc.) (optional)»
 * @par Conception «Conception description (criteria and constraints) (optional)»
 * @par Limits «Limits description (optional)»
 * @brief @~french Symbole pour la fonction de vérification de conversion.
 * @par Détails S.O.
 * @par Modèle S.O.
 * @par Conception S.O.
 * @par Limites S.O.
 * @par Historique 2024-01-30 [SD] - Implémentation initiale<br>
 * @par Tâches S.O.
 */
public class MMecConversionFunctionSymbol extends AbstractDBTypeConversionFunctionSymbolImpl {
  private final String functionName;
  @Nullable
  private final DBTermType inputType;

  /***
   * @brief @~english «Description of the method»
   * @param functionName «Parameter description»
   * @param targetType «Parameter description»
   * @param inputType «Parameter description»
   *
   * @brief @~french Constructeur pour le symbole de fonction de vérification de conversion.
   * @param functionName Nom de la fonction déclarée dans l'arrimage
   * @param inputType Type de l'argument de la fonction
   * @param targetType Type vers lequel faire la conversion
   *
   * @par Tâches
   *      S.O.
   */
  protected MMecConversionFunctionSymbol(String functionName, DBTermType inputType,
      DBTermType targetType) {
    super("Conversion", inputType, targetType);
    this.inputType = inputType;
    this.functionName = functionName;
  }

  @Override
  public String getNativeDBString(ImmutableList<? extends ImmutableTerm> terms,
      Function<ImmutableTerm, String> termConverter, TermFactory termFactory) {
    return String.format("%s(%s)", functionName,
        terms.stream().map(termConverter).collect(Collectors.joining(", ")));
  }

  @Override
  protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
    return getInputType().isPresent();
  }

  @Override
  protected boolean tolerateNulls() {
    return true;
  }

  @Override
  public boolean canBePostProcessed(ImmutableList<? extends ImmutableTerm> immutableList) {
    return getInputType().isPresent();
  }

  @Override
  protected ImmutableTerm convertDBConstant(DBConstant constant, TermFactory termFactory)
      throws DBTypeConversionException {
    return termFactory.getImmutableFunctionalTerm(this, constant);
  }

  @Override
  public Optional<DBTermType> getInputType() {
    return Optional.ofNullable(inputType);
  }

  @Override
  public boolean isTemporary() {
    return false;
  }

  @Override
  public boolean isSimple() {
    return false;
  }
}

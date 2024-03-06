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
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBFunctionSymbolSerializer;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.AbstractDBTypeConversionFunctionSymbolImpl;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.Serializers;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.util.Optional;
import java.util.function.Function;

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
 * @brief @~french Sert à s'assurer que le type exprimé par la requête d'arrimage est bien le type
 *        prévu par l'OntoRel.
 *        <br>
 *        S'assure aussi que la conversion s'applique explicitement pour les constantes.
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
 *      2024-03-06 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecSimpleConversionFunctionSymbol
    extends AbstractDBTypeConversionFunctionSymbolImpl {
  private final DBTermType inputType;
  private final DBFunctionSymbolSerializer serializer;

  protected MMecSimpleConversionFunctionSymbol(DBTermType inputType, DBTermType targetType) {
    super("SimpleCastTo" + targetType.getName(), targetType, targetType);
    serializer = Serializers.getCastSerializer(targetType);
    this.inputType = inputType;
  }

  @Override
  public String getNativeDBString(ImmutableList<? extends ImmutableTerm> terms,
      Function<ImmutableTerm, String> termConverter, TermFactory termFactory) {
    return serializer.getNativeDBString(terms, termConverter, termFactory);
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
    return false;
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

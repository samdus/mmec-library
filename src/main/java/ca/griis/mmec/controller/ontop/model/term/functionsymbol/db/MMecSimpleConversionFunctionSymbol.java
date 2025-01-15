/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecIndividuationFunctionSymbol.
 * @brief @~english MMecIndividuationFunctionSymbol class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.DBConstant;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBFunctionSymbolSerializer;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.AbstractDBTypeConversionFunctionSymbolImpl;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.Serializers;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.util.Arrays;
import java.util.Objects;
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
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecSimpleConversionFunctionSymbol.class);
  private final DBTermType inputType;
  private final DBFunctionSymbolSerializer serializer;

  public MMecSimpleConversionFunctionSymbol(DBTermType inputType, DBTermType targetType) {
    super("SimpleCastTo" + targetType.getName(), targetType, targetType);
    serializer = Serializers.getCastSerializer(targetType);
    this.inputType = inputType;
  }

  @Override
  public String getNativeDBString(ImmutableList<? extends ImmutableTerm> terms,
      Function<ImmutableTerm, String> termConverter, TermFactory termFactory) {
    logger.trace(Trace.ENTER_METHOD_3, terms, termConverter, termFactory);
    return serializer.getNativeDBString(terms, termConverter, termFactory);
  }

  @Override
  protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
    logger.trace(Trace.ENTER_METHOD_0);
    return getInputType().isPresent();
  }

  @Override
  protected boolean tolerateNulls() {
    logger.trace(Trace.ENTER_METHOD_0);
    return true;
  }

  @Override
  public boolean canBePostProcessed(ImmutableList<? extends ImmutableTerm> immutableList) {
    logger.trace(Trace.ENTER_METHOD_1, immutableList);
    return false;
  }

  @Override
  protected ImmutableTerm convertDBConstant(DBConstant constant, TermFactory termFactory)
      throws DBTypeConversionException {
    logger.trace(Trace.ENTER_METHOD_2, constant, termFactory);
    return termFactory.getImmutableFunctionalTerm(this, constant);
  }

  @Override
  public Optional<DBTermType> getInputType() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Optional.ofNullable(inputType);
  }

  @Override
  public boolean isTemporary() {
    logger.trace(Trace.ENTER_METHOD_0);
    return false;
  }

  @Override
  public boolean isSimple() {
    logger.trace(Trace.ENTER_METHOD_0);
    return false;
  }

  @Override
  public final boolean equals(Object other) {
    logger.trace(Trace.ENTER_METHOD_1, other);
    return super.equals(other)
        && other instanceof MMecSimpleConversionFunctionSymbol otherSymbol
        && Objects.equals(this.inputType, otherSymbol.inputType);
  }

  @Override
  public final int hashCode() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Arrays.hashCode(new Object[] {
        super.hashCode(),
        this.inputType
    });
  }
}

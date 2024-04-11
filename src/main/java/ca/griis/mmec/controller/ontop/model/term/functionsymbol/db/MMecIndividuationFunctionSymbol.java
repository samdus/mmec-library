/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecIndividuationFunctionSymbol.
 * @brief @~english MMecIndividuationFunctionSymbol class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import ca.griis.mmec.controller.ontop.model.type.MMecIndividuationTermType;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
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
public class MMecIndividuationFunctionSymbol extends AbstractTypedDBFunctionSymbol implements
    RDFTermFunctionSymbol {
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
  protected MMecIndividuationFunctionSymbol(ImmutableList<TermType> argTypes,
      ObjectRDFType iriTermType, DBTermType returnType,
      String functionCallTemplate) {
    super(String.format("Individuation_%s", argTypes.size()), argTypes, returnType);
    this.functionCallTemplate = functionCallTemplate;
    mmecIndividuationTermType = new MMecIndividuationTermType(
        iriTermType.getAncestry(), returnType);
  }

  @Override
  protected boolean isAlwaysInjectiveInTheAbsenceOfNonInjectiveFunctionalTerms() {
    return true;
  }

  @Override
  public boolean canBePostProcessed(ImmutableList<? extends ImmutableTerm> immutableList) {
    return false;
  }

  @Override
  public boolean tolerateNulls() {
    return false;
  }

  @Override
  public String getNativeDBString(ImmutableList<? extends ImmutableTerm> terms,
      Function<ImmutableTerm, String> termConverter, TermFactory termFactory) {
    return String.format(functionCallTemplate,
        terms.stream().map(termConverter).collect(Collectors.joining(", ")));
  }

  @Override
  public Optional<TermTypeInference> inferType(ImmutableList<? extends ImmutableTerm> terms) {
    return Optional.of(mmecIndividuationTermType).map(TermTypeInference::declareTermType);
  }

  @Override
  public final boolean equals(Object other) {
    return super.equals(other)
        && other instanceof MMecIndividuationFunctionSymbol otherSymbol
        && this.functionCallTemplate.compareToIgnoreCase(otherSymbol.functionCallTemplate) == 0
        && this.mmecIndividuationTermType.equals(otherSymbol.mmecIndividuationTermType);
  }

  @Override
  public final int hashCode() {
    return Arrays.hashCode(new Object[] {
        super.hashCode(),
        this.functionCallTemplate.toLowerCase(),
        this.mmecIndividuationTermType
    });
  }
}

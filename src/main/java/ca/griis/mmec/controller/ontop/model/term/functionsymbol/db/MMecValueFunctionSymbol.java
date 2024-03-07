/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecIndividuationFunctionSymbol.
 * @brief @~english MMecIndividuationFunctionSymbol class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import ca.griis.mmec.controller.ontop.model.type.DbValueTermType;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.AbstractTypedDBFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.MetaRDFTermType;
import it.unibz.inf.ontop.model.type.RDFDatatype;
import it.unibz.inf.ontop.model.type.TermTypeInference;
import java.util.Arrays;
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
 * @brief @~french Symbole pour une valeur de données.
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
 *      2024-02-29 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecValueFunctionSymbol extends AbstractTypedDBFunctionSymbol implements
    RDFTermFunctionSymbol {

  private final DBTermType valueType;
  private final RDFDatatype rdfDatatype;

  /**
   * @brief @~english «Description of the method»
   * @param valueType «Parameter description»
   *
   * @brief @~french Constructeur pour le symbole de valeur.
   * @param valueType Type de la valeur
   * @par typeTermType Type de terme
   *
   * @par Tâches
   *      S.O.
   */
  protected MMecValueFunctionSymbol(DBTermType valueType, RDFTermTypeConstant rdfTermTypeConstant,
      MetaRDFTermType typeTermType) {
    super(String.format("Value_%s", valueType.getName()), ImmutableList.of(valueType, typeTermType),
        valueType);
    this.valueType = valueType;
    this.rdfDatatype = Optional.of(rdfTermTypeConstant.getRDFTermType())
        .filter(type -> type instanceof RDFDatatype)
        .map(RDFDatatype.class::cast)
        .orElseThrow();
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
    checkArity(terms);
    return termConverter.apply(terms.get(0));
  }

  @Override
  public Optional<TermTypeInference> inferType(ImmutableList<? extends ImmutableTerm> terms) {
    return Optional.of(
        TermTypeInference.declareTermType(new DbValueTermType(rdfDatatype, valueType)));
  }

  private static void checkArity(ImmutableList<? extends ImmutableTerm> terms)
      throws IllegalArgumentException {
    if (terms.size() != 2) {
      throw new IllegalArgumentException("Wrong arity");
    }
  }

  @Override
  public final boolean equals(Object other) {
    return super.equals(other)
        && other instanceof MMecValueFunctionSymbol otherSymbol
        && this.valueType.equals(otherSymbol.valueType)
        && this.rdfDatatype.equals(otherSymbol.rdfDatatype);
  }

  @Override
  public final int hashCode() {
    return Arrays.hashCode(new Object[] {
        super.hashCode(),
        valueType,
        rdfDatatype,
    });
  }
}

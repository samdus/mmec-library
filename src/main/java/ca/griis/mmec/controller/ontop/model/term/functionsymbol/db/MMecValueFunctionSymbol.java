/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecIndividuationFunctionSymbol.
 * @brief @~english MMecIndividuationFunctionSymbol class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import ca.griis.mmec.controller.ontop.model.type.DBValueTermType;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.AbstractTypedDBFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.MetaRDFTermType;
import it.unibz.inf.ontop.model.type.TermTypeInference;
import it.unibz.inf.ontop.model.type.impl.SimpleRDFDatatype;
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

  /**
   * @brief @~english «Description of the method»
   * @param valueType «Parameter description»
   *
   * @brief @~french Constructeur pour le symbole de valeur.
   * @param valueType Type de la valeur
   * @par typeTermType Type de terme
   *
   * @par Tâches
   *    S.O.
   */
  protected MMecValueFunctionSymbol(DBTermType valueType, MetaRDFTermType typeTermType) {
    super(String.format("Value_%s", valueType.getName()), ImmutableList.of(valueType, typeTermType),
        valueType);
    this.valueType = valueType;
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
    checkArity(terms);

    return Optional.of(terms.get(1))
        .filter(term -> term instanceof RDFTermTypeConstant)
        .map(term -> (RDFTermTypeConstant) term)
        .map(RDFTermTypeConstant::getRDFTermType)
        .filter(rdfTermType -> rdfTermType instanceof SimpleRDFDatatype)
        .map(rdfTermType -> (SimpleRDFDatatype) rdfTermType)
        .map(rdfTermType -> new DBValueTermType(rdfTermType, valueType))
        .map(TermTypeInference::declareTermType);
  }

  private static void checkArity(ImmutableList<? extends ImmutableTerm> terms)
      throws IllegalArgumentException {
    if (terms.size() != 2) {
      throw new IllegalArgumentException("Wrong arity");
    }
  }
}

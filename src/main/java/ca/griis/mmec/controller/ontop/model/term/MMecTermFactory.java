/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecTermFactoryImpl.
 * @brief @~english MMecTermFactoryImpl class implementation.
 */
package ca.griis.mmec.controller.ontop.model.term;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecSQLDBFunctionSymbolFactory;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import it.unibz.inf.ontop.injection.OntopModelSettings;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.functionsymbol.FunctionSymbolFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBFunctionSymbolFactory;
import it.unibz.inf.ontop.model.term.impl.AbstractMMecTermFactory;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TypeFactory;
import it.unibz.inf.ontop.utils.CoreUtilsFactory;
import org.apache.commons.rdf.api.RDF;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details «Detailed description of the component (optional)»
 * @par Model «Model (Abstract, automation, etc.) (optional)»
 * @par Conception «Conception description (criteria and constraints) (optional)»
 * @par Limits «Limits description (optional)»
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
 * @par Détails S.O.
 * @par Modèle S.O.
 * @par Conception S.O.
 * @par Limites S.O.
 * @par Historique 2024-01-09 [SD] - Implémentation initiale<br>
 * @par Tâches S.O.
 */
public class MMecTermFactory extends AbstractMMecTermFactory {

  @Inject
  protected MMecTermFactory(TypeFactory typeFactory,
      FunctionSymbolFactory functionSymbolFactory,
      DBFunctionSymbolFactory dbFunctionSymbolFactory,
      CoreUtilsFactory coreUtilsFactory,
      OntopModelSettings settings,
      RDF rdfFactory) {
    super(typeFactory, functionSymbolFactory, dbFunctionSymbolFactory, coreUtilsFactory, settings,
        rdfFactory);
    assert dbFunctionSymbolFactory instanceof MMecSQLDBFunctionSymbolFactory;
  }

  public ImmutableFunctionalTerm getMMecSignatureFunction(
      ImmutableList<TermType> argTypes,
      ImmutableList<? extends ImmutableTerm> terms) {
    return getImmutableFunctionalTerm(
        getMMecDBFunctionSymbolFactory().createMMecIndividuationFunctionSymbol(argTypes), terms);
  }

  public ImmutableTerm getMMecConversionFunction(Variable variable, DBTermType variableType,
      DBTermType sqlDataType) {
    return getImmutableFunctionalTerm(
        getMMecDBFunctionSymbolFactory().createMMecConversionFunctionSymbol(variableType,
            sqlDataType),
        variable);
  }

  private MMecSQLDBFunctionSymbolFactory getMMecDBFunctionSymbolFactory() {
    return (MMecSQLDBFunctionSymbolFactory) getDBFunctionSymbolFactory();
  }

  public ImmutableTerm getMMecConversionValidationFunction(Variable variable,
      DBTermType variableType, DBTermType sqlDataType) {
    return getImmutableFunctionalTerm(
        getMMecDBFunctionSymbolFactory().createMMecConversionValidationFunctionSymbol(variableType,
            sqlDataType),
        variable);
  }
}

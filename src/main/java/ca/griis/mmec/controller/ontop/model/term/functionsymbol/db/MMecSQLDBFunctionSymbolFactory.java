/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de l'interface MMecSQLDBFunctionSymbolFactory.
 * @brief @~english MMecSQLDBFunctionSymbolFactory interface implementation.
 */
package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.functionsymbol.FunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.DBBooleanFunctionSymbolImpl;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TermType;

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
public interface MMecSQLDBFunctionSymbolFactory {
  MMecIndividuationFunctionSymbol createMMecIndividuationFunctionSymbol(
      ImmutableList<TermType> argTypes);

  DBTypeConversionFunctionSymbol createMMecConversionFunctionSymbol(DBTermType variableType,
      DBTermType sqlDataType);

  DBBooleanFunctionSymbolImpl createMMecConversionValidationFunctionSymbol(DBTermType variableType, DBTermType sqlDataType);
}

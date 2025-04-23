/**
 * @file
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 * @version 1.2.0
 * @brief @~french Implémentation de l'interface MMecSQLDBFunctionSymbolFactory.
 * @brief @~english MMecSQLDBFunctionSymbolFactory interface implementation.
 */

package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBBooleanFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBFunctionSymbolFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
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
public interface MMecSqlDbFunctionSymbolFactory extends DBFunctionSymbolFactory {
  MMecIndividuationFunctionSymbol createMMecIndividuationFunctionSymbol(
      ImmutableList<TermType> argTypes);

  DBTypeConversionFunctionSymbol createMMecSimpleConversionFunctionSymbol(DBTermType inputType,
      DBTermType targetType);

  DBTypeConversionFunctionSymbol createMMecConversionFunctionSymbol(String functionName,
      DBTermType inputType, DBTermType targetType);

  DBBooleanFunctionSymbol createMMecConversionValidationFunctionSymbol(String functionName,
      DBTermType inputType, DBTermType targetType);

  MMecValueFunctionSymbol createMMecValueFunctionSymbol(DBTermType valueType,
      RDFTermTypeConstant rdfTermTypeConstant);
}

/**
 * @file
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 * @version 1.2.0
 * @brief @~french Implémentation de la classe MMecPostgreSQLDBFunctionSymbolFactory.
 * @brief @~english MMecPostgreSQLDBFunctionSymbolFactory class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.model.type.impl.MMecPostgreSqlDbTypeFactory;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBBooleanFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.PostgreSQLDBFunctionSymbolFactory;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TypeFactory;

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
 * @brief @~french Fabrique de symboles de fonctions pour la base de données PostgreSQL.
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
 *      TODO 2024-01-11 [SD] - Injecter la paramétrisation pour le template d'appel aux différentes
 *      fonctions d'individuation et de leur type de retour.
 */
public class MMecPostgreSqlDbFunctionSymbolFactory extends PostgreSQLDBFunctionSymbolFactory
    implements MMecSqlDbFunctionSymbolFactory {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecPostgreSqlDbFunctionSymbolFactory.class);
  private final String individuationFunctionCallTemplate;
  private final DBTermType individuationFunctionReturnType;

  @Inject
  public MMecPostgreSqlDbFunctionSymbolFactory(
      TypeFactory typeFactory) {
    super(typeFactory);
    individuationFunctionCallTemplate = "individuation(%s)";
    individuationFunctionReturnType =
        dbTypeFactory.getDBTermType(MMecPostgreSqlDbTypeFactory.UUID_STR);
  }

  @Override
  public MMecIndividuationFunctionSymbol createMMecIndividuationFunctionSymbol(
      ImmutableList<TermType> argTypes) {
    logger.trace(Trace.ENTER_METHOD_1, argTypes);

    return new MMecIndividuationFunctionSymbol(argTypes,
        typeFactory.getIRITermType(),
        individuationFunctionReturnType,
        individuationFunctionCallTemplate);
  }

  @Override
  public DBTypeConversionFunctionSymbol createMMecSimpleConversionFunctionSymbol(
      DBTermType inputType, DBTermType targetType) {
    logger.trace(Trace.ENTER_METHOD_2, inputType, targetType);
    return new MMecSimpleConversionFunctionSymbol(inputType, targetType);
  }

  @Override
  public DBTypeConversionFunctionSymbol createMMecConversionFunctionSymbol(String functionName,
      DBTermType inputType, DBTermType targetType) {
    logger.trace(Trace.ENTER_METHOD_3, functionName, inputType, targetType);
    return new MMecConversionFunctionSymbol(functionName, inputType, targetType);
  }

  @Override
  public DBBooleanFunctionSymbol createMMecConversionValidationFunctionSymbol(
      String functionName, DBTermType inputType, DBTermType targetType) {
    logger.trace(Trace.ENTER_METHOD_3, functionName, inputType, targetType);
    return new MMecConversionValidationFunctionSymbol(functionName, inputType, targetType);
  }

  @Override
  public MMecValueFunctionSymbol createMMecValueFunctionSymbol(DBTermType valueType,
      RDFTermTypeConstant rdfTermTypeConstant) {
    logger.trace(Trace.ENTER_METHOD_2, valueType, rdfTermTypeConstant);
    return new MMecValueFunctionSymbol(valueType, rdfTermTypeConstant,
        typeFactory.getMetaRDFTermType());
  }
}

/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecPostgreSQLDBFunctionSymbolFactory.
 * @brief @~english MMecPostgreSQLDBFunctionSymbolFactory class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

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
public class MMecPostgreSqlDbFunctionSymbolFactory extends PostgreSQLDBFunctionSymbolFactory
    implements MMecSqlDbFunctionSymbolFactory {
  private final String individuationFunctionCallTemplate;
  private final DBTermType individuationFunctionReturnType;

  // TODO: Injecter la paramétrisation pour le template d'appel aux différentes fonctions
  // d'individuation et de leur type de retour.
  @Inject
  protected MMecPostgreSqlDbFunctionSymbolFactory(
      TypeFactory typeFactory) {
    super(typeFactory);
    individuationFunctionCallTemplate = "individuation(%s)";
    individuationFunctionReturnType =
        dbTypeFactory.getDBTermType(MMecPostgreSqlDbTypeFactory.UUID_STR);
  }

  @Override
  public MMecIndividuationFunctionSymbol createMMecIndividuationFunctionSymbol(
      ImmutableList<TermType> argTypes) {
    return new MMecIndividuationFunctionSymbol(argTypes,
        typeFactory.getIRITermType(),
        individuationFunctionReturnType,
        individuationFunctionCallTemplate);
  }

  @Override
  public DBTypeConversionFunctionSymbol createMMecSimpleConversionFunctionSymbol(
      DBTermType inputType, DBTermType targetType) {
    return new MMecSimpleConversionFunctionSymbol(inputType, targetType);
  }

  @Override
  public DBTypeConversionFunctionSymbol createMMecConversionFunctionSymbol(String functionName,
      DBTermType inputType, DBTermType targetType) {
    return new MMecConversionFunctionSymbol(functionName, inputType, targetType);
  }

  @Override
  public DBBooleanFunctionSymbol createMMecConversionValidationFunctionSymbol(
      String functionName, DBTermType inputType, DBTermType targetType) {
    return new MMecConversionValidationFunctionSymbol(functionName, inputType, targetType);
  }

  @Override
  public MMecValueFunctionSymbol createMMecValueFunctionSymbol(DBTermType valueType,
      RDFTermTypeConstant rdfTermTypeConstant) {
    return new MMecValueFunctionSymbol(valueType, rdfTermTypeConstant,
        typeFactory.getMetaRDFTermType());
  }
}

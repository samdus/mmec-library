/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecPostgreSQLDBFunctionSymbolFactory.
 * @brief @~english MMecPostgreSQLDBFunctionSymbolFactory class implementation.
 */
package ca.griis.mmec.controller.ontop.model.term.functionsymbol.db;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.PostgreSQLDBFunctionSymbolFactory;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TypeFactory;
import it.unibz.inf.ontop.model.type.impl.PostgreSQLDBTypeFactory;

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
public class MMecPostgreSQLDBFunctionSymbolFactory extends PostgreSQLDBFunctionSymbolFactory
    implements MMecSQLDBFunctionSymbolFactory {
  private final String functionCallTemplate;
  private final DBTermType individuationFunctionReturnType;

  // TODO: Injecter la paramétrisation pour le template d'appel aux différentes fonctions
  // d'individuation et de leur type de retour.
  @Inject
  protected MMecPostgreSQLDBFunctionSymbolFactory(
      TypeFactory typeFactory) {
    super(typeFactory);
    functionCallTemplate = "individuation(%s)";
    individuationFunctionReturnType = dbTypeFactory.getDBTermType(PostgreSQLDBTypeFactory.UUID_STR);
  }

  @Override
  public MMecIndividuationFunctionSymbol createMMecIndividuationFunctionSymbol(
      ImmutableList<TermType> argTypes) {
    return new MMecIndividuationFunctionSymbol(argTypes, individuationFunctionReturnType,
        functionCallTemplate);
  }

  public DBTypeConversionFunctionSymbol createMMecConversionFunctionSymbol(DBTermType variableType,
      DBTermType sqlDataType) {
    return getDBCastFunctionSymbol(variableType, sqlDataType);
  }
}

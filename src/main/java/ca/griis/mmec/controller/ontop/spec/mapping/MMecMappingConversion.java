/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecMappingConversion.
 * @brief @~english MMecMappingConversion class implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping;

import it.unibz.inf.ontop.model.term.functionsymbol.db.DBBooleanFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.util.Optional;

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
 * @brief @~french Description des différentes conversions configurées dans l'arrimage
 * @par Détails
 *      Si une conversion est configurée dans l'arrimage, ça veut dire qu'il est possible de
 *      convertir le type de donnée d'entrée vers le type de donnée de sortie. Une conversion
 *      peut définir une fonction de conversion spécifique et une fonction de validation pour
 *      s'assurer que la conversion est possible.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2024-03-05 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecMappingConversion {
  private final DBTermType inputType;
  private final DBTermType outputType;
  private final Optional<DBTypeConversionFunctionSymbol> conversionFunction;
  private final Optional<DBBooleanFunctionSymbol> validationFunction;

  public MMecMappingConversion(DBTermType inputType, DBTermType outputType,
      Optional<DBTypeConversionFunctionSymbol> conversionFunction,
      Optional<DBBooleanFunctionSymbol> validationFunction) {
    this.inputType = inputType;
    this.outputType = outputType;
    this.conversionFunction = conversionFunction;
    this.validationFunction = validationFunction;
  }

  public DBTermType getInputType() {
    return inputType;
  }

  public DBTermType getOutputType() {
    return outputType;
  }

  public Optional<DBTypeConversionFunctionSymbol> getConversionFunction() {
    return conversionFunction;
  }

  public Optional<DBBooleanFunctionSymbol> getValidationFunction() {
    return validationFunction;
  }
}

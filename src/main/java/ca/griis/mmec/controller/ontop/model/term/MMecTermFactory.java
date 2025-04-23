/**
 * @file
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 * @version 1.2.0
 * @brief @~french Implémentation de la classe MMecTermFactoryImpl.
 * @brief @~english MMecTermFactoryImpl class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecSqlDbFunctionSymbolFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingConversion;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.NonGroundFunctionalTerm;
import it.unibz.inf.ontop.model.term.PartialTermFactory;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.impl.TermFactoryImpl;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TermType;

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
 * @brief @~french Factory pour les termes de mMec
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
 *      2024-08-27 [SD] - Séparer le defaultTermFactory dans un PartialTermFactory<br>
 *      2024-03-06 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecTermFactory extends PartialTermFactory {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecTermFactory.class);

  @Inject
  public MMecTermFactory(TermFactoryImpl defaultTermFactory) {
    super(defaultTermFactory);
  }

  /**
   * @brief @~english «Description of the method»
   * @param argTypes «Parameter description»
   * @param terms «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Crée un terme fonctionnel pour la signature de la fonction d'individuation.
   * @param argTypes Types des arguments de la fonction
   * @param terms Arguments de la fonction
   * @return Terme fonctionnel pour la signature de la fonction d'individuation
   */
  public NonGroundFunctionalTerm getMMecSignatureFunction(
      ImmutableList<TermType> argTypes,
      ImmutableList<? extends ImmutableTerm> terms) {
    return defaultTermFactory.getNonGroundFunctionalTerm(
        getMMecDbFunctionSymbolFactory().createMMecIndividuationFunctionSymbol(argTypes),
        terms.toArray(new ImmutableTerm[0]));
  }

  /**
   * @brief @~english «Description of the method»
   * @param inputType «Parameter description»
   * @param targetType «Parameter description»
   * @param term «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Crée un terme fonctionnel pour la conversion simple de type.
   * @param inputType Type de la variable à convertir
   * @param targetType Type de destination
   * @param term Variable à convertir
   * @return Terme fonctionnel pour la conversion simple de type
   */
  public NonGroundFunctionalTerm getMMecSimpleCastFunctionalTerm(DBTermType inputType,
      DBTermType targetType, ImmutableTerm term) {
    logger.trace(Trace.ENTER_METHOD_3, inputType, targetType, term);
    return defaultTermFactory.getNonGroundFunctionalTerm(
        getMMecDbFunctionSymbolFactory().createMMecSimpleConversionFunctionSymbol(inputType,
            targetType),
        term);
  }

  /**
   * @brief @~english «Description of the method»
   * @param variable «Parameter description»
   * @param conversion «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Crée un terme fonctionnel pour la fonction de conversion de type.
   * @param variable Variable à convertir
   * @param conversion Conversion de type
   * @return Terme fonctionnel pour la fonction de conversion de type
   */
  public NonGroundFunctionalTerm getMMecConversionFunction(ImmutableTerm variable,
      MMecMappingConversion conversion) {
    logger.trace(Trace.ENTER_METHOD_2, variable, conversion);
    return defaultTermFactory.getNonGroundFunctionalTerm(
        conversion.getConversionFunction().orElseThrow(),
        variable);
  }

  /**
   * @brief @~english «Description of the method»
   * @param variable «Parameter description»
   * @param conversion «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Crée un terme fonctionnel pour la fonction de validation de conversion de type.
   * @param variable Variable à convertir
   * @param conversion La conversion de type à effectuer
   * @return Terme fonctionnel pour la fonction de validation de conversion de type
   */
  public NonGroundFunctionalTerm getMMecConversionValidationFunction(ImmutableTerm variable,
      MMecMappingConversion conversion) {
    logger.trace(Trace.ENTER_METHOD_2, variable, conversion);
    return defaultTermFactory.getNonGroundFunctionalTerm(
        conversion.getValidationFunction().orElseThrow(),
        variable);
  }

  /**
   * @brief @~english «Description of the method»
   * @param variable «Parameter description»
   * @param variableType «Parameter description»
   * @param rdfTermTypeConstant «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Crée un terme fonctionnel pour la fonction englobant une valeur
   * @param variable Variable à englober
   * @param variableType Type de la variable
   * @param rdfTermTypeConstant Type RDF de la variable
   * @return Terme fonctionnel pour la fonction englobant une valeur
   */
  public NonGroundFunctionalTerm getMMecValueFunction(ImmutableTerm variable,
      DBTermType variableType, RDFTermTypeConstant rdfTermTypeConstant) {
    logger.trace(Trace.ENTER_METHOD_3, variable, variableType, rdfTermTypeConstant);
    return defaultTermFactory.getNonGroundFunctionalTerm(
        getMMecDbFunctionSymbolFactory().createMMecValueFunctionSymbol(variableType,
            rdfTermTypeConstant),
        variable, rdfTermTypeConstant);
  }

  private MMecSqlDbFunctionSymbolFactory getMMecDbFunctionSymbolFactory() {
    logger.trace(Trace.ENTER_METHOD_0);
    return (MMecSqlDbFunctionSymbolFactory) defaultTermFactory.getDBFunctionSymbolFactory();
  }
}

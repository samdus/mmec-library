/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe MMecParserConversionExtension.
 * @brief @~english MMecParserConversionExtension class implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.after;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecPostgreSqlDbFunctionSymbolFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingConversion;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.MappingExtendedAfterParsing;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.ConversionWithoutInputTypeException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.ConversionWithoutOutputTypeException;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import eu.optique.r2rml.api.model.TriplesMap;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBBooleanFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TypeFactory;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.Triple;
import org.apache.commons.rdf.rdf4j.RDF4J;

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
 * @brief @~french Extension de l'arrimage qui permet de traiter les expressions de conversion.
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
 *      2024-04-10 [SD] - Extraction de la classe depuis MappingParserExtension<br>
 *      2024-03-05 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecParserConversionExtension extends MappingExtendedAfterParsing {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecParserConversionExtension.class);

  private final TypeFactory typeFactory;
  private final MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory;
  private final MMecMappingExtension mappingExtension;

  @Inject
  public MMecParserConversionExtension(RDF4J rdf, TypeFactory typeFactory,
      MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory,
      MMecMappingExtension mappingExtension) {
    super(rdf);
    this.typeFactory = typeFactory;
    this.sqlDbFunctionSymbolFactory = sqlDbFunctionSymbolFactory;
    this.mappingExtension = mappingExtension;
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   *
   * @brief @~french Traite les expressions de conversion.
   * @param mappingGraph Le graphe d'arrimage.
   * @param tripleMaps Les tripleMaps.
   * @param sourceMappings Les mappings sources.
   */
  @Override
  public void parse(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
      ImmutableList<MMecTriplesMap> sourceMappings) {
    logger.trace(Trace.ENTER_METHOD_1, mappingGraph);
    List<? extends Triple> conversionTriples = mappingGraph.stream(null,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(MMecVocabulary.C_CONVERSION)).toList();

    for (Triple conversionTriple : conversionTriples) {
      DBTermType declaredInputType = getObjectsQualifiedIdentifier(mappingGraph,
          conversionTriple.getSubject(),
          rdf.createIRI(MMecVocabulary.P_CONVERSION_INPUT_TYPE))
              .map(typeFactory.getDBTypeFactory()::getDBTermType)
              .orElseThrow(
                  () -> new ConversionWithoutInputTypeException(conversionTriple.getSubject()));
      DBTermType declaredOutputType = getObjectsQualifiedIdentifier(mappingGraph,
          conversionTriple.getSubject(),
          rdf.createIRI(MMecVocabulary.P_CONVERSION_OUTPUT_TYPE))
              .map(typeFactory.getDBTypeFactory()::getDBTermType)
              .orElseThrow(
                  () -> new ConversionWithoutOutputTypeException(conversionTriple.getSubject()));
      Optional<DBTypeConversionFunctionSymbol> declaredConversionFunction =
          getObjectsQualifiedIdentifier(mappingGraph, conversionTriple.getSubject(),
              rdf.createIRI(MMecVocabulary.P_CONVERSION_FUNCTION))
                  .map(
                      functionName -> sqlDbFunctionSymbolFactory.createMMecConversionFunctionSymbol(
                          functionName, declaredInputType, declaredOutputType));
      Optional<DBBooleanFunctionSymbol> declaredValidationFunction = getObjectsQualifiedIdentifier(
          mappingGraph, conversionTriple.getSubject(),
          rdf.createIRI(MMecVocabulary.P_CONVERSION_VERIFICATION_FUNCTION))
              .map(functionName -> sqlDbFunctionSymbolFactory
                  .createMMecConversionValidationFunctionSymbol(functionName,
                      declaredInputType, declaredOutputType));

      mappingExtension.addMappingConversion(
          new MMecMappingConversion(declaredInputType, declaredOutputType,
              declaredConversionFunction, declaredValidationFunction));
    }

    logger.trace(Trace.EXIT_METHOD_0);
  }
}

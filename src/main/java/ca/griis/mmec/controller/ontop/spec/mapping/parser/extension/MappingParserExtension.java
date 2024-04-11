/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'objet MappingParserExtension.
 * @brief @~english MappingParserExtension object implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.after.MMecParserConversionExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.after.MMecParserSubsetsExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before.MMecParserRefSubjectMapExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before.MMecParserTemplatesExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import eu.optique.r2rml.api.model.TriplesMap;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.spec.mapping.PrefixManager;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMapping;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.rdf.api.Graph;

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
 * @brief @~french Étend le R2RMLMappingParser avec des prétraitements du graphe d'arrimage et des
 *        traitements avant la génération des PPMapping.
 *        Sert à étendre le modèle interne avec les fonctions R2RML étendues.
 * @par Détails
 *      L'arrimage R2RML étendu permet de spécifier les signatures de classes de façon à réduire les
 *      erreurs liées à l'individuation et améliorer la qualité de celle-ci. Elle permet aussi de
 *      spécifier des fonctions de conversion de type pour les valeurs littérales.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2023-09-05 [SD] - Implémentation initiale.
 *
 * @par Tâches
 *      S.O.
 */
public class MappingParserExtension {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MappingParserExtension.class);
  private final SQLPPMappingFactory ppMappingFactory;
  private final List<MappingExtendedBeforeParsing> beforeParsingExtensions;
  private final List<MappingExtendedAfterParsing> afterParsingExtensions;

  @Inject
  public MappingParserExtension(SQLPPMappingFactory ppMappingFactory,
      MMecParserRefSubjectMapExtension refSubjectMapExtension,
      MMecParserTemplatesExtension templatesExtension,
      MMecParserConversionExtension conversionExtension,
      MMecParserSubsetsExtension subsetsExtension) {
    this.ppMappingFactory = ppMappingFactory;
    this.beforeParsingExtensions = ImmutableList.of(refSubjectMapExtension, templatesExtension);
    this.afterParsingExtensions = ImmutableList.of(conversionExtension, subsetsExtension);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param prefixes «Parameter description»
   *
   * @brief @~french Prétraitement du graphe d'arrimage avant la génération des PPMapping.
   * @param mappingGraph Le graphe d'arrimage.
   * @param prefixes Les préfixes de l'arrimage.
   */
  public void updateMappingGraphBeforeParse(Graph mappingGraph,
      ImmutableMap<String, String> prefixes) {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, prefixes);

    for (MappingExtendedBeforeParsing extension : beforeParsingExtensions) {
      extension.updateGraph(mappingGraph, prefixes);
    }

    logger.trace(Trace.EXIT_METHOD_0);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param tripleMaps «Parameter description»
   * @param sourceMappings «Parameter description»
   * @param prefixManager «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Ajoute les informations de l'arrimage R2RML étendu aux expressions d'arrimage
   *        Ontop.
   * @param mappingGraph Le graphe d'arrimage.
   * @param tripleMaps Les triplets d'arrimage importés du graphe.
   * @param sourceMappings Les expressions d'arrimage déduites converties à partir des triplets.
   * @param prefixManager Le gestionnaire de préfixes.
   * @return Le mapping mMEc.
   */
  public SQLPPMapping getExtendedMapping(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
      ImmutableList<SQLPPTriplesMap> sourceMappings, PrefixManager prefixManager) {
    logger.trace(Trace.ENTER_METHOD_4, mappingGraph, tripleMaps, sourceMappings, prefixManager);
    ImmutableList<MMecTriplesMap> mmecSourceMappings =
        sourceMappings.stream().map(MMecTriplesMap::new).collect(ImmutableCollectors.toList());

    for (MappingExtendedAfterParsing extension : afterParsingExtensions) {
      extension.parse(mappingGraph, tripleMaps, mmecSourceMappings);
    }

    ImmutableList<SQLPPTriplesMap> extendedSourceMapping = mmecSourceMappings.stream().map(
        SQLPPTriplesMap.class::cast)
        .collect(ImmutableCollectors.toList());

    return ppMappingFactory.createSQLPreProcessedMapping(extendedSourceMapping, prefixManager);
  }

}

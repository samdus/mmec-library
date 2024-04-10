/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecParserSubsetsExtension.
 * @brief @~english MMecParserSubsetsExtension class implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.after;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.MappingExtendedAfterParsing;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before.MMecParserRefSubjectMapExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import eu.optique.r2rml.api.model.TriplesMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.Graph;
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
 * @brief @~french Extension de l'arrimage qui permet d'associer les expressions d'arrimage aux
 *                 expressions qui sont déclarés comme leur sous-ensemble.
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
 *      2023-09-10 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecParserSubsetsExtension extends MappingExtendedAfterParsing {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecParserRefSubjectMapExtension.class);

  @Inject
  public MMecParserSubsetsExtension(RDF4J rdf) {
    super(rdf);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param tripleMaps «Parameter description»
   * @param sourceMappings «Parameter description»
   *
   * @brief @~french Associe les expressions d'arrimage aux expressions qui sont déclarés comme
   *        leur sous-ensemble.
   * @param mappingGraph Le graphe d'arrimage.
   * @param tripleMaps Les triplets d'arrimage importés du graphe.
   * @param sourceMappings Les expressions d'arrimage déduites converties à partir des triplets.
   */
  @Override
  public void parse(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
      ImmutableList<MMecTriplesMap> sourceMappings) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, tripleMaps, sourceMappings);
    Map<TriplesMap, List<TriplesMap>> hasSubset =
        mappingGraph.stream(null, rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS), null)
            .filter(axiom ->
                // If the superset is a SIGNATURE_SUPERSET, it's not required in the hasSubset Map
                mappingGraph.stream((BlankNodeOrIRI) axiom.getObject(), rdf.createIRI(nsTypeIri),
                        rdf.createIRI(MMecVocabulary.C_SIGNATURE_SUPERSET))
                    .findAny().isEmpty())
            .map(
                axiom -> new ImmutablePair<>(
                    tripleMaps.stream()
                        .filter(triple -> triple.getNode().equals(axiom.getSubject()))
                        .findFirst().orElseThrow(/* TODO: Créer une exception */),
                    tripleMaps.stream().filter(
                            triple -> triple.getNode().equals(axiom.getObject()))
                        .findFirst().orElseThrow(/* TODO: Créer une exception */)))
            .collect(Collectors.groupingBy(ImmutablePair::getRight,
                Collectors.mapping(ImmutablePair::getLeft, Collectors.toList())));

    hasSubset.forEach(
        (supersetMapping, subsetMappingList) -> subsetMappingList.forEach(subsetMapping -> {
          MMecTriplesMap superSetSourceMapping = sourceMappings.stream().filter(
                  sourceMapping -> sourceMapping.getId()
                      .equals(String.format("mapping-%s", supersetMapping.hashCode())))
              .findFirst()
              .orElseThrow(/* TODO: Créer une exception */);
          MMecTriplesMap subSetSourceMapping = sourceMappings.stream().filter(
                  sourceMapping -> sourceMapping.getId()
                      .equals(String.format("mapping-%s", subsetMapping.hashCode())))
              .findFirst()
              .orElseThrow(/* TODO: Créer une exception */);

          superSetSourceMapping.addSubset(subSetSourceMapping);
        }));
    logger.trace(Trace.EXIT_METHOD_0);
  }
}

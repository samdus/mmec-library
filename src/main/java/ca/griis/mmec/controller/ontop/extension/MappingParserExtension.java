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

package ca.griis.mmec.controller.ontop.extension;

import ca.griis.mmec.model.MMecTriplesMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import eu.optique.r2rml.api.model.TriplesMap;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.ImmutablePair;
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
 * @brief @~french Étend le R2RMLMappingParser avec un prétraitement du graphe d'arrimage et un
 *        traitement avant la génération des PPMapping.
 *        Sert à étendre le modèle interne avec les fonctions R2RML étendues.
 * @par Détails
 *      L'arrimage R2RML étendu permet de spécifier les signatures de classes de façon à réduire les
 *      erreurs liées à l'individuation et améliorer la qualité de celle-ci.
 *
 *      En particulier, il s'agit d'inclure des triplets pour spécifier
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
 * @todo 2023-09-06 [SD] - Faire la conception.
 */
public class MappingParserExtension {

  private static final MappingParserExtension instance = new MappingParserExtension();

  public static MappingParserExtension getInstance() {
    return instance;
  }

  /**
   * @brief @~english «Description of the function»
   * @param mappingGraph «Parameter description»
   * @param prefixes «Parameter description»
   *
   * @brief @~french Ajoute les triplets rr:template en concordance avec les fonctions R2RML
   *        étendues.
   * @par Details
   *      TODO: Définition de l'algo
   * @param mappingGraph Le graphe d'arrimage.
   * @param prefixes Les préfixes de l'ontologie.
   *
   * @par Tâches
   *      S.O.
   */
  public void updateMappingGraphBeforeParse(Graph mappingGraph,
      ImmutableMap<String, String> prefixes) {

  }

  /**
   * @brief @~english «Description of the function»
   * @param mappingGraph «Parameter description»
   * @param tripleMaps «Parameter description»
   * @param mapping «Parameter description»
   *
   * @brief @~french Ajoute les informations de l'arrimage R2RML étendu aux expressions d'arrimage
   *        Ontop.
   * @par Details
   *      TODO: Définition de l'algo
   * @param mappingGraph Le graphe original de l'arrimage.
   * @param tripleMaps Les triplets d'arrimage importés du graphe
   * @param mapping Les expressions d'arrimage déduites converties à partir des triplets
   *
   * @par Tâches
   *      S.O.
   */
  public ImmutableList<SQLPPTriplesMap> getTriplesMapBeforePreprocess(Graph mappingGraph,
      Collection<TriplesMap> tripleMaps, ImmutableList<SQLPPTriplesMap> mapping) {
    RDF4J rdf = new RDF4J();
    ImmutableList<MMecTriplesMap> sourceMappings =
        mapping.stream().map(MMecTriplesMap::new).collect(ImmutableCollectors.toList());

    // Voici un exemple de comment réassocier les triplets de fonctions custom au mapping généré :
    Map<TriplesMap, List<TriplesMap>> hasSubset =
        mappingGraph.stream(null, rdf.createIRI("http://www.griis.ca/projects/relrel#subsets"),
            null).map(
                axiom -> new ImmutablePair<>(
                    tripleMaps.stream()
                        .filter(triple -> triple.getNode().equals(axiom.getSubject()))
                        .findFirst().orElseThrow(),
                    tripleMaps.stream().filter(triple -> triple.getNode().equals(axiom.getObject()))
                        .findFirst().orElseThrow()))
            .collect(Collectors.groupingBy(ImmutablePair::getRight,
                Collectors.mapping(ImmutablePair::getLeft, Collectors.toList())));

    hasSubset.forEach(
        (supersetMapping, subsetMappingList) -> subsetMappingList.forEach(subsetMapping -> {
          MMecTriplesMap superSetSourceMapping = sourceMappings.stream().filter(
              sourceMapping -> sourceMapping.getId()
                  .equals(String.format("mapping-%s", supersetMapping.hashCode())))
              .findFirst()
              .orElseThrow();
          SQLPPTriplesMap subSetSourceMapping = sourceMappings.stream().filter(
              sourceMapping -> sourceMapping.getId()
                  .equals(String.format("mapping-%s", subsetMapping.hashCode())))
              .findFirst()
              .orElseThrow();

          superSetSourceMapping.addSubset(subSetSourceMapping);
        }));

    return sourceMappings.stream().map(SQLPPTriplesMap.class::cast)
        .collect(ImmutableCollectors.toList());
  }
}

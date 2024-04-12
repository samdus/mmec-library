/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MappingExtendedAfterParsing.
 * @brief @~english MappingExtendedAfterParsing class implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension;

import com.google.common.collect.ImmutableMap;
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
 * @brief @~french Classe servant à ajouter des traîtements du graphe de mapping avant
 *        le traitement standard.
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
 *      2024-04-10 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public abstract class MappingExtendedBeforeParsing extends MappingExtendedParser {

  protected MappingExtendedBeforeParsing(RDF4J rdf) {
    super(rdf);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param prefixes «Parameter description»
   *
   * @brief @~french Mettre à jour le graphe de mapping à partir des éléments de l'extension.
   * @param mappingGraph Le graphe de mapping à mettre à jour.
   * @param prefixes Les préfixes du graphe de mapping.
   */
  public abstract void updateGraph(Graph mappingGraph, ImmutableMap<String, String> prefixes);

}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'interface IMappingParserExtensionBefore.
 * @brief @~english IMappingParserExtensionBefore interface implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension;

import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import com.google.common.collect.ImmutableList;
import eu.optique.r2rml.api.model.TriplesMap;
import java.util.Collection;
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
 * @brief @~french Interface servant à ajouter des traîtements au mapping après
 *                 le traitement standard.
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
public abstract class MappingExtendedAfterParsing extends MappingExtendedParser {

    protected MappingExtendedAfterParsing(RDF4J rdf) {
        super(rdf);
    }

    public abstract void parse(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
        ImmutableList<MMecTriplesMap> sourceMappings);
}

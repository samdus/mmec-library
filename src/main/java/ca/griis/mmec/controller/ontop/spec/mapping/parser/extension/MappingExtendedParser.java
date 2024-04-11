/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MappingExtendedParser.
 * @brief @~english MappingExtendedParser class implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.model.MMecVocabulary;
import java.util.List;
import java.util.Optional;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.api.Literal;
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
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
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
public abstract class MappingExtendedParser {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MappingExtendedParser.class);

  protected final String nsTypeIri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
  protected final RDF4J rdf;

  protected MappingExtendedParser(RDF4J rdf) {
    this.rdf = rdf;
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param subject «Parameter description»
   * @param predicate «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtenir l'identifiant qualifié de l'objet d'un triplet.
   * @param mappingGraph Le graphe duquel extraire le triplet.
   * @param subject Le sujet du triplet.
   * @param predicate Le prédicat du triplet.
   * @return L'identifiant qualifié de l'objet du triplet.
   */
  protected Optional<String> getObjectsQualifiedIdentifier(Graph mappingGraph,
      BlankNodeOrIRI subject,
      IRI predicate) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, subject, predicate);
    return getObject(mappingGraph, subject, predicate)
        .flatMap(type -> getLiteral(mappingGraph, type,
            rdf.createIRI(MMecVocabulary.P_SQL_QUALIFIED_IDENTIFIER)));
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param subject «Parameter description»
   * @param predicate «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtenir l'objet BlankNodeOrIRI d'un triplet.
   * @param mappingGraph Le graphe duquel extraire le triplet.
   * @param subject Le sujet du triplet.
   * @param predicate Le prédicat du triplet.
   * @return L'objet du triplet, s'il s'agit d'un BlankNodeOrIRI
   */
  protected Optional<BlankNodeOrIRI> getObject(Graph mappingGraph, BlankNodeOrIRI subject,
      IRI predicate) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, subject, predicate);
    return mappingGraph.stream(subject, predicate, null)
        .map(Triple::getObject)
        .filter(term -> term instanceof BlankNodeOrIRI)
        .map(term -> (BlankNodeOrIRI) term)
        .findFirst();
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param subject «Parameter description»
   * @param predicate «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtenir la forme lexicale de la valeur littérale d'un triplet.
   * @param mappingGraph Le graphe duquel extraire le triplet.
   * @param subject Le sujet du triplet.
   * @param predicate Le prédicat du triplet.
   * @return La forme lexicale de la valeur littérale d'un triplet.
   */
  protected Optional<String> getLiteral(Graph mappingGraph, BlankNodeOrIRI subject,
      IRI predicate) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, subject, predicate);
    return mappingGraph.stream(subject, predicate, null)
        .map(Triple::getObject)
        .filter(term -> term instanceof Literal)
        .map(term -> (Literal) term)
        .map(Literal::getLexicalForm)
        .findFirst();
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param subject «Parameter description»
   * @param predicate «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtenir la forme lexicale de la valeur littérale de tous les triplets.
   * @param mappingGraph Le graphe duquel extraire le triplet.
   * @param subject Le sujet des triplets.
   * @param predicate Le prédicat des triplets.
   * @return Une liste de la forme lexicale de la valeur littérale des triplets.
   */
  protected List<String> getAllLiterals(Graph mappingGraph, BlankNodeOrIRI subject,
      IRI predicate) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, subject, predicate);
    return mappingGraph.stream(subject, predicate, null)
        .map(Triple::getObject)
        .filter(term -> term instanceof Literal)
        .map(term -> (Literal) term)
        .map(Literal::getLexicalForm)
        .toList();
  }
}

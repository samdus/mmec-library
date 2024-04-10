/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecTemplatesExtension.
 * @brief @~english MMecTemplatesExtension class implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.MappingExtendedBeforeParsing;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SignatureComponentMismatchException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SignatureComponentMissingException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SignatureWithoutSubjectMapException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SubsetHasTemplateException;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import eu.optique.r2rml.api.model.R2RMLVocabulary;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.IRI;
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
 * @brief @~french Extension de l'arrimage qui permet d'engendrer des templates à partir des
 *                 composants de signature en tenant compte des relations subsets.
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
 *      2024-03-22 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      TODO 2024-04-04 [SD] - Vérifier que l'ordre des composants est garantie
 *      TODO 2024-04-04 [SD] - Faire en sorte que les classes définies pour toutes la hierarchie
 *                             des parents soient ajouté à l'enfant.
 */
public class MMecParserTemplatesExtension extends MappingExtendedBeforeParsing {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecParserTemplatesExtension.class);

  @Inject
  public MMecParserTemplatesExtension(RDF4J rdf) {
    super(rdf);
  }

  /**
   * @brief @~english «Description of the function»
   * @param mappingGraph «Parameter description»
   * @param prefixes «Parameter description»
   *
   * @brief @~french Ajoute les triplets rr:template en concordance avec les fonctions R2RML
   *        étendues.
   * @par Details
   *      Pour chaque triplet <x, a, rr:TriplesMap> dans le graphe :
   *      __p := x
   *      __Jusqu'à ce qu'il n'existe pas de triplet <p, mmec:subsets, y> dans le graphe :
   *      ____p := y
   *      __Obtenir <x, rr:subjectMap, xSubjectMap>
   *      __Obtenir <p, rr:subjectMap, pSubjectMap>
   *      __S'il existe <xSubjectMap, rr:template, xTemplate>
   *      ____S'il existe <ANY, mmec:subsets, x> ou si p <> x :
   *      ______Lancer une exception
   *      ____Sinon Si le mapping ne défini pas ses composants de signatures
   *      ______Passer au triplet suivant
   *      ____Sinon
   *      ______Lancer un avertissement
   *      ______Retirer le triplet <xSubjectMap, rr:template, xTemplate>
   *      __signScope := IRI de p, s'il s'agit d'un IRI, ntriplesString sinon
   *      __
   *      __Si le nombre de triplets <xSubjectMap, mmec:signComponent, ANY> est différent
   *      ______du nombre de triplets <pSubjectMap, mmec:signComponent, ANY>
   *      ____Lancer une exception
   *      __componentString := Former une chaîne de caractère à partir des triplets
   *      ______<pSubjectMap, mmec:signComponent, c> en utilisant l'expression "/{" + c + "}"
   *      __Ajouter un triplet <xSubjectMap, rr:template, signScope+componentString>
   *      --
   *      Notes :
   *      - Si p correspond à un mmec:SignatureSuperSet, il est possible que le pSubjectMap
   *      n'existe pas, mais le traitement reste valide.
   *      - La chaîne de caractère générée pour signScope doit être encodée pour un URL
   * @param mappingGraph Le graphe d'arrimage.
   * @param prefixes Les préfixes de l'arrimage.
   */
  public void updateGraph(Graph mappingGraph,
      ImmutableMap<String, String> prefixes) {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, prefixes);
    for (Triple currentTriple : mappingGraph.stream(null, rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP)).toList()) {
      generateTemplates(mappingGraph, currentTriple.getSubject());
    }
    logger.trace(Trace.EXIT_METHOD_0);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param current «Parameter description»
   *
   * @brief @~french Génère les templates pour un triplet donné.
   * @param mappingGraph Le graphe d'arrimage
   * @param current Le triplet courant
   */
  protected void generateTemplates(Graph mappingGraph, BlankNodeOrIRI current) {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, current);

    final BlankNodeOrIRI parentRoot = getParentRoot(mappingGraph, current);
    final BlankNodeOrIRI currentSubjectMap = getObject(mappingGraph, current,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP)).orElseThrow(
        () -> new SignatureWithoutSubjectMapException(current));
    final Optional<BlankNodeOrIRI> parentSubjectMap = getObject(mappingGraph, parentRoot,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP));
    final Optional<String> currentTemplate = getLiteral(mappingGraph, currentSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE));
    final List<String> currentComponents = getAllLiterals(mappingGraph, currentSubjectMap,
        rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT));

    final String signScope = Optional.of(parentRoot)
        .filter(parent -> parent instanceof IRI)
        .map(parent -> ((IRI) parent).getIRIString())
        .orElse(parentRoot.ntriplesString());
    final List<String> parentComponents = parentSubjectMap
        .map(subjectMap -> getAllLiterals(mappingGraph, subjectMap,
            rdf.createIRI(MMecVocabulary.P_SIGNATURE_COMPONENT)))
        .orElse(List.of());

    if (currentTemplate.isPresent()) {
      if (current.equals(parentRoot)
          && mappingGraph.stream(null, rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS), current)
          .findAny().isEmpty()) {
        if (currentComponents.isEmpty()) {
          return;
        } else {
          logger.warn("The mapping '" + current.ntriplesString() + "' defined "
              + "a rr:template that will be overwritten by the mmec extension");
          mappingGraph.remove(currentSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
              null);
        }
      } else {
        throw new SubsetHasTemplateException(current);
      }
    }

    if (currentComponents.isEmpty()) {
      throw new SignatureComponentMissingException(current);
    }

    if (mappingGraph.stream(parentRoot, rdf.createIRI(nsTypeIri),
        rdf.createIRI(MMecVocabulary.C_SIGNATURE_SUPERSET)).findAny().isEmpty()
        && currentComponents.size() != parentComponents.size()) {
      throw new SignatureComponentMismatchException(current, parentRoot);
    }

    final String componentString = currentComponents.stream()
        .map(component -> "{" + component + "}")
        .collect(Collectors.joining("/"));

    mappingGraph.add(currentSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        rdf.createLiteral(signScope + "/" + componentString));
    logger.trace(Trace.EXIT_METHOD_0);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param current «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtient le parent le plus haut dans la hierarchie de superset
   * @param mappingGraph Le graphe d'arrimage
   * @param current Le noeud courant
   * @return Le prochain noeud sans parent dans la chaîne de subsets
   */
  private BlankNodeOrIRI getParentRoot(Graph mappingGraph, BlankNodeOrIRI current) {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, current);
    Optional<BlankNodeOrIRI> parent = getObject(mappingGraph, current,
        rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS));
    if (parent.isPresent()) {
      return getParentRoot(mappingGraph, parent.get());
    }
    return current;
  }
}

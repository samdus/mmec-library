/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe SignatureComponentMismatchException.
 * @brief @~english SignatureComponentMismatchException class implementation.
 */
package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception;

import org.apache.commons.rdf.api.BlankNodeOrIRI;

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
 * @brief @~french Exception lancée lorsqu'un nœud a un nombre de composants de signature différent
 *        de celui duquel il dépend par la relation subsets.
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
public class SignatureComponentMismatchException extends IllegalMappingException {
  private final BlankNodeOrIRI parentNode;

  public SignatureComponentMismatchException(BlankNodeOrIRI invalidNode,
      BlankNodeOrIRI parentNode) {
    super(invalidNode, String.format(
        "it has a different number of signature components than the one it depends on (%s).",
        getNodeName(parentNode)));
    this.parentNode = parentNode;
  }

  public BlankNodeOrIRI getParentNode() {
    return parentNode;
  }
}

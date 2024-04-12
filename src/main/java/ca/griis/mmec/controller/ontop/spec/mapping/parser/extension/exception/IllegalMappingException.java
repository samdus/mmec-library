/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe IllegalMappingException.
 * @brief @~english IllegalMappingException class implementation.
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
 * @brief @~french Exception levée lorsqu'un nœud de mapping est considéré invalide.
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
public abstract class IllegalMappingException extends IllegalStateException {
  private final BlankNodeOrIRI invalidNode;

  public IllegalMappingException(BlankNodeOrIRI invalidNode, String reason) {
    super(String.format("The mapping '%s' is invalid: %s", getNodeName(invalidNode), reason));
    this.invalidNode = invalidNode;
  }

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Obtient le nœud invalide.
   * @return Le nœud invalide.
   */
  public BlankNodeOrIRI getInvalidNode() {
    return invalidNode;
  }

  /**
   * @brief @~english «Description of the method»
   * @param current «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtient le nom du nœud
   * @param current Le nœud dont on veut obtenir le nom
   * @return Le nom du nœud
   */
  protected static String getNodeName(BlankNodeOrIRI current) {
    return current.ntriplesString();
  }
}

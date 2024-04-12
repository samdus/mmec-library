/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe InvalidConversionException.
 * @brief @~english InvalidConversionException class implementation.
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
 * @brief @~french Exception levée lorsqu'une conversion est invalide.
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
public abstract class InvalidConversionException extends IllegalStateException {
  protected final BlankNodeOrIRI conversionTriple;

  public InvalidConversionException(
      BlankNodeOrIRI conversionTriple, String reason) {
    super(String.format("The conversion '%s' is invalid: %s", conversionTriple, reason));
    this.conversionTriple = conversionTriple;
  }

  public BlankNodeOrIRI getConversionTriple() {
    return conversionTriple;
  }
}

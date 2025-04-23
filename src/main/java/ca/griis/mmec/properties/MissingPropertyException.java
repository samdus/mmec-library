/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe MissingPropertyException.
 * @brief @~english MissingPropertyException class implementation.
 */

package ca.griis.mmec.properties;

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
 * @brief @~french Exception lancée lorsqu'une propriété est manquante.
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
 *      2024-05-31 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MissingPropertyException extends Exception {
  public MissingPropertyException(String propertyName, String propertyDescription) {
    super(String.format("The %s (property: %s) is required.", propertyDescription, propertyName));
  }
}

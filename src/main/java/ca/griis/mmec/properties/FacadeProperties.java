/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de l'objet FacadeConfiguration.
 * @brief @~english FacadeConfiguration object implementation.
 */

package ca.griis.mmec.properties;

import java.net.URL;

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
 * @brief @~french Objet contenant les configurations pour la façade d'arrimage.
 * @par Détails
 *      Les informations spécifiques à la façade. On y trouve le type de façade
 *      (vues, vues matérialisées ou alimentation) et le type de signature (type, chaine de
 *      caractère, etc.)
 *      <br />
 *      Ces informations sont spécifiées soit par un nom (parmi les choix prédéfinis dans une
 *      structure d'énumération) ou du chemin vers un fichier de patron (.stg).
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2023-09-01 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public interface FacadeProperties {
  URL getFacadeStgUrl();
}

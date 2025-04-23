/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de l'interface DataPropertyTable.
 * @brief @~english DataPropertyTable interface implementation.
 */

package ca.griis.mmec.model.ontorel;

import ca.griis.mmec.model.OntoRelTable;

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
 * @brief @~french Interface pour une table de propriété de donnée d'OntoRel.
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
 *      2024-04-12 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public interface ObjectPropertyTable extends OntoRelTable {
  String iriSubject();

  String iriPredicate();

  String iriObject();

  String ontorelSubjectColumnId();

  String ontorelSubjectColumnType();

  String ontorelObjectColumnId();

  String ontorelObjectColumnType();
}

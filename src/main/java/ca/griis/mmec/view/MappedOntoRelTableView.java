/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe MappedOntoRelTableView.
 * @brief @~english MappedOntoRelTableView class implementation.
 */

package ca.griis.mmec.view;

import ca.griis.mmec.model.mapped.MappedClassTable;
import ca.griis.mmec.model.mapped.MappedDataPropertyTable;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTable;

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
 * @brief @~french Vues servant à obtenir les expressions des différentes tables d'OntoRel arrimées.
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
public interface MappedOntoRelTableView {
  String getExpression(MappedClassTable mappedClassTable);

  String getExpression(MappedObjectPropertyTable mappedObjectPropertyTable);

  String getExpression(MappedDataPropertyTable mappedDataPropertyTable);
}

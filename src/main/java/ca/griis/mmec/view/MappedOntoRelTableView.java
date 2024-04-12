/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MappedOntoRelTableView.
 * @brief @~english MappedOntoRelTableView class implementation.
 */

package ca.griis.mmec.view;

import ca.griis.mmec.model.MappedClassTable;
import ca.griis.mmec.model.MappedDpTable;
import ca.griis.mmec.model.MappedOpTable;

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

  String getExpression(MappedOpTable mappedOpTable);

  String getExpression(MappedDpTable mappedDpTable);
}

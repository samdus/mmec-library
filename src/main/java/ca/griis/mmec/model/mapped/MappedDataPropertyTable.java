/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'interface MappedTablePropertyTable.
 * @brief @~english MappedTablePropertyTable interface implementation.
 */

package ca.griis.mmec.model.mapped;

import ca.griis.mmec.model.MappedOntoRelTable;
import ca.griis.mmec.model.ontorel.DataPropertyTable;

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
 * @brief @~french Interface pour une table de propriété de donnée d'OntoRel qui a été arrimé.
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
public interface MappedDataPropertyTable extends DataPropertyTable, MappedOntoRelTable {
  String mmecQuerySubjectColumnId();

  String mmecQueryValueColumnId();
}

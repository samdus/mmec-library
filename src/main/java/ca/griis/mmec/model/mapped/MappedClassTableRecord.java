/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MappedClassTable.
 * @brief @~english MappedClassTable class implementation.
 */

package ca.griis.mmec.model.mapped;

import ca.griis.mmec.model.ontorel.ClassTable;
import java.util.Optional;

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
 * @brief @~french Table d'OntoRel représentant une classe qui a été arrimée.
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
public record MappedClassTableRecord (
    String tableName,
    String label,
    String iri,
    String ontorelColumnId,
    String ontorelColumnType,
    String schema,
    Optional<String> mmecQuery,
    String mmecQueryColumnId)
    implements MappedClassTable {
  public MappedClassTableRecord(ClassTable classTableRecord, String schema,
      Optional<String> mmecQuery, String mmecQueryColumnId) {
    this(classTableRecord.tableName(), classTableRecord.label(), classTableRecord.iri(),
        classTableRecord.ontorelColumnId(), classTableRecord.ontorelColumnType(), schema, mmecQuery,
        mmecQueryColumnId);
  }
}

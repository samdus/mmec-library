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

import ca.griis.mmec.model.ontorel.ObjectPropertyTable;
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
 * @brief @~french Table d'OntoRel représentant un axiome de classe qui a été arrimée.
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
public record MappedObjectPropertyTableRecord (
    String tableName,
    String label,
    String iriSubject,
    String iriPredicate,
    String iriObject,
    String ontorelSubjectColumnId,
    String ontorelSubjectColumnType,
    String ontorelObjectColumnId,
    String ontorelObjectColumnType,
    String schema,
    Optional<String> mmecQuery,
    String mmecQuerySubjectColumnId,
    String mmecQueryObjectColumnId)
    implements MappedObjectPropertyTable {
  public MappedObjectPropertyTableRecord(ObjectPropertyTable objectPropertyTableRecord,
      String schema,
      Optional<String> mmecQuery, String mmecQuerySubjectColumnId, String mmecQueryObjectColumnId) {
    this(objectPropertyTableRecord.tableName(), objectPropertyTableRecord.label(),
        objectPropertyTableRecord.iriSubject(), objectPropertyTableRecord.iriPredicate(),
        objectPropertyTableRecord.iriObject(), objectPropertyTableRecord.ontorelSubjectColumnId(),
        objectPropertyTableRecord.ontorelSubjectColumnType(),
        objectPropertyTableRecord.ontorelObjectColumnId(),
        objectPropertyTableRecord.ontorelObjectColumnType(), schema, mmecQuery,
        mmecQuerySubjectColumnId, mmecQueryObjectColumnId);
  }
}

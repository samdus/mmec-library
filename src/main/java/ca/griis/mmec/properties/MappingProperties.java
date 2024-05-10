/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'objet MappingConfiguration.
 * @brief @~english MappingConfiguration object implementation.
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
 * @brief @~french Configurations de l'arrimage.
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
 *      2023-09-06 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public abstract class MappingProperties {
  // TODO: Add the properties for the configuration of the mapping. For exemple, the path of the
  // mapping file.
  public abstract String getOntoRelId();

  public abstract String getMappingSchema();
}

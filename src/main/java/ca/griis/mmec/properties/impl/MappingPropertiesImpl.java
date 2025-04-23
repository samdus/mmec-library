/**
 * @file
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 * @version 1.2.0
 * @brief @~french Implémentation de la classe MappingPropertiesImpl.
 * @brief @~english MappingPropertiesImpl class implementation.
 */

package ca.griis.mmec.properties.impl;

import ca.griis.mmec.properties.MappingProperties;

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
 *      2024-01-29 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MappingPropertiesImpl extends MappingProperties {
  private final String ontoRelId;
  private final String mappingSchema;
  private final String r2rmlMappingFilePath;
  private final String ontologyFilePath;

  public MappingPropertiesImpl(String ontoRelId, String mappingSchema, String r2rmlMappingFilePath,
      String ontologyFilePath) {
    this.ontoRelId = ontoRelId;
    this.mappingSchema = mappingSchema;
    this.r2rmlMappingFilePath = r2rmlMappingFilePath;
    this.ontologyFilePath = ontologyFilePath;
  }

  @Override
  public String getOntoRelId() {
    return ontoRelId;
  }

  @Override
  public String getMappingSchema() {
    return mappingSchema;
  }

  @Override
  public String getR2rmlMappingFilePath() {
    return r2rmlMappingFilePath;
  }

  @Override
  public String getOntologyFilePath() {
    return ontologyFilePath;
  }
}

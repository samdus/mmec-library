/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe MappingConfigurationBuilder
 * @brief @~english MappingConfigurationBuilder implementation
 */

package ca.griis.mmec.properties.builder;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.properties.MissingPropertyException;
import ca.griis.mmec.properties.impl.MappingPropertiesImpl;

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
 * @brief @~french Constructeur d'objet contenant les configurations de l'arrimage en tant que tel.
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
 *      2023-09-01 [SD] - Implémentation initiale.
 *
 * @par Tâches
 *      S.O.
 */
public class MappingPropertiesBuilder {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MappingPropertiesBuilder.class);

  private String ontoRelId;
  private String mappingSchema;
  private String r2rmlMappingFilePath;
  private String ontologyFilePath;

  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Construit l'instance de configuration de l'arrimage
   * @par Details
   *      S.O.
   * @return La configuration d'arrimage à partir des paramètres spécifiés.
   */
  public MappingProperties build() throws MissingPropertyException {
    logger.trace(Trace.ENTER_METHOD_0);

    if (ontoRelId == null) {
      throw new MissingPropertyException("ontoRelId", "OntoRel identifier in the OntoRelCat");
    }

    if (mappingSchema == null) {
      throw new MissingPropertyException("mappingSchema", "mapping schema");
    }

    if (r2rmlMappingFilePath == null) {
      throw new MissingPropertyException("r2rmlMappingFilePath", "R2RML mapping file path");
    }

    if (ontologyFilePath == null) {
      throw new MissingPropertyException("ontologyFilePath", "ontology file path");
    }

    return new MappingPropertiesImpl(ontoRelId, mappingSchema, r2rmlMappingFilePath,
        ontologyFilePath);
  }

  public MappingPropertiesBuilder withOntoRelId(String ontoRelId) {
    logger.trace(Trace.ENTER_METHOD_1, ontoRelId);
    this.ontoRelId = ontoRelId;
    return this;
  }

  public MappingPropertiesBuilder withMappingSchema(String mappingSchema) {
    logger.trace(Trace.ENTER_METHOD_1, mappingSchema);
    this.mappingSchema = mappingSchema;
    return this;
  }

  public MappingPropertiesBuilder withR2rmlMappingFilePath(String r2rmlMappingFilePath) {
    logger.trace(Trace.ENTER_METHOD_1, r2rmlMappingFilePath);
    this.r2rmlMappingFilePath = r2rmlMappingFilePath;
    return this;
  }

  public MappingPropertiesBuilder withOntologyFilePath(String ontologyFilePath) {
    logger.trace(Trace.ENTER_METHOD_1, ontologyFilePath);
    this.ontologyFilePath = ontologyFilePath;
    return this;
  }
}

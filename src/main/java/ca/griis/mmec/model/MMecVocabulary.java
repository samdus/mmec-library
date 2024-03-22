/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecVocabulary.
 * @brief @~english MMecVocabulary class implementation.
 */

package ca.griis.mmec.model;

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
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
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
 *      2024-03-21 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecVocabulary {
  // Namespace
  public static final String NAMESPACE = "http://www.griis.ca/ns/mmec#";

  // Headers
  public static final String MAPPING_DEFINITION = NAMESPACE + "mappingDefinition";
  public static final String MAPPING_ONTOREL = NAMESPACE + "ontorel";
  public static final String MAPPING_SOURCE = NAMESPACE + "source";
  public static final String MAPPING_TEMPLATE_PREFIX = NAMESPACE + "templatePrefix";


  // Signatures
  public static final String SIGNATURE_SCOPE = NAMESPACE + "signatureScope";
  public static final String SIGNATURE_COMPONENT = NAMESPACE + "signatureComponent";
  public static final String SIGNATURE_SUBSETS = NAMESPACE + "subsets";

  // Type conversions
  public static final String CONVERSION = NAMESPACE + "conversion";
  public static final String CONVERSION_INPUT_TYPE =
      NAMESPACE + "conversionInputType";
  public static final String CONVERSION_OUTPUT_TYPE =
      NAMESPACE + "conversionOutputType";
  public static final String CONVERSION_FUNCTION =
      NAMESPACE + "conversionFunction";
  public static final String CONVERSION_VALIDATION_FUNCTION =
      NAMESPACE + "validationFunction";
  public static final String SIGNATURE_SUPERSET = NAMESPACE + "signatureSuperset";
}

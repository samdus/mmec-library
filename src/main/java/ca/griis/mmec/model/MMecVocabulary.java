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
  private static final String BASE = "http://www.griis.ca/ns/mmec#";

  // Headers
  public static final String C_MAPPING_HEADER = BASE + "MappingHeader";
  public static final String C_ONTOREL = BASE + "OntoRel";
  public static final String C_DATA_SOURCE = BASE + "DataSource";
  public static final String P_MAPPING_ONTOREL = BASE + "ontorel";
  public static final String P_MAPPING_SOURCE = BASE + "source";

  // Signatures
  public static final String C_SIGNATURE_SUPERSET = BASE + "SignatureSuperset";
  public static final String P_SIGNATURE_COMPONENT = BASE + "signatureComponent";
  public static final String P_SIGNATURE_SUBSETS = BASE + "subsets";

  // Type conversions
  public static final String C_CONVERSION = BASE + "Conversion";
  public static final String C_SQL_FUNCTION = BASE + "SQLFunction";
  public static final String C_SQL_TYPE = BASE + "SQLType";
  public static final String P_CONVERSION_INPUT_TYPE =
      BASE + "conversionInputType";
  public static final String P_CONVERSION_OUTPUT_TYPE =
      BASE + "conversionOutputType";
  public static final String P_CONVERSION_FUNCTION =
      BASE + "conversionFunction";
  public static final String P_CONVERSION_VERIFICATION_FUNCTION =
      BASE + "verificationFunction";
  public static final String P_SQL_QUALIFIED_IDENTIFIER =
      BASE + "qualifiedIdentifier";
}

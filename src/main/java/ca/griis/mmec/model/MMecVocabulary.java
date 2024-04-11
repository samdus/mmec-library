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
 *      TODO 2024-04-11 [SD] - Cette classe gagnerait à être un enum
 *                             Prendre exemple sur org.semanticweb.owlapi.vocab.DublinCoreVocabulary
 */
public class MMecVocabulary {
  public static final String NS_MMEC = "http://www.griis.ca/ns/mmec#";

  // Headers
  public static final String C_MAPPING_HEADER = NS_MMEC + "MappingHeader";
  public static final String C_ONTOREL = NS_MMEC + "OntoRel";
  public static final String C_DATA_SOURCE = NS_MMEC + "DataSource";
  public static final String P_MAPPING_ONTOREL = NS_MMEC + "ontorel";
  public static final String P_MAPPING_SOURCE = NS_MMEC + "source";

  // Signatures
  public static final String C_SIGNATURE_SUPERSET = NS_MMEC + "SignatureSuperset";
  public static final String C_REF_SUBJECT_MAP = NS_MMEC + "RefSubjectMap";
  public static final String P_SIGNATURE_COMPONENT = NS_MMEC + "signatureComponent";
  public static final String P_SIGNATURE_SUBSETS = NS_MMEC + "subsets";
  public static final String P_REF_SUBJECT_MAP = NS_MMEC + "refSubjectMap";

  // Type conversions
  public static final String C_CONVERSION = NS_MMEC + "Conversion";
  public static final String C_SQL_FUNCTION = NS_MMEC + "SQLFunction";
  public static final String C_SQL_TYPE = NS_MMEC + "SQLType";
  public static final String P_CONVERSION_INPUT_TYPE =
      NS_MMEC + "conversionInputType";
  public static final String P_CONVERSION_OUTPUT_TYPE =
      NS_MMEC + "conversionOutputType";
  public static final String P_CONVERSION_FUNCTION =
      NS_MMEC + "conversionFunction";
  public static final String P_CONVERSION_VERIFICATION_FUNCTION =
      NS_MMEC + "verificationFunction";
  public static final String P_SQL_QUALIFIED_IDENTIFIER =
      NS_MMEC + "qualifiedIdentifier";
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'objet FacadeConfiguration.
 * @brief @~english FacadeConfiguration object implementation.
 */

package ca.griis.mmec.properties;

import java.io.InputStream;

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
 * @brief @~french Objet contenant les configurations de connexion à la source de données.
 * @par Détails
 *      Les informations spécifiques à la façade. On y trouve le type de façade
 *      (vues, vues matérialisées ou alimentation) et le type de signature (type, chaine de
 *      caractère, etc.)
 *      <br />
 *      Ces informations sont spécifiées soit par un nom (parmi les choix prédéfinis dans une
 *      structure d'énumération) ou du chemin vers un fichier de patron (.stg).
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2023-09-01 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public abstract class FacadeProperties {
  public abstract String getFacadeStgPath();

  public abstract String getSignatureStgPath();

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer le chemin vers le fichier de gabarit des signatures.
   * @return Chemin vers le fichier de gabarit des signatures.
   *
   * @note S.O.
   *
   * @par Tâches
   *      S.O.
   */
  public InputStream getSignatureStgStream() {
    return getInputStream(getSignatureStgPath());
  }

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Récupérer le chemin vers le fichier de gabarit de la façade.
   * @return Chemin vers le fichier de gabarit de la façade.
   *
   * @note S.O.
   *
   * @par Tâches
   *      S.O.
   */
  public InputStream getFacadeStgStream() {
    return getInputStream(getFacadeStgPath());
  }

  private InputStream getInputStream(String streamPath) {
    return FacadeProperties.class.getClassLoader().getResourceAsStream(streamPath);
  }

}

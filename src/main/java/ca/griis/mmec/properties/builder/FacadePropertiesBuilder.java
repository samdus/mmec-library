/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation du constructeur pour la configuration d'une façade d'arrimage.
 * @brief @~english Implementation of the constructor for the mapping facade configuration.
 */

package ca.griis.mmec.properties.builder;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.FacadeType;
import ca.griis.mmec.properties.impl.FacadePropertiesImpl;
import java.net.URL;


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
 * @brief @~french Constructeur d'objet contenant les configurations de la façade d'arrimage.
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
public class FacadePropertiesBuilder {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(FacadePropertiesBuilder.class);

  private URL facadeStgUrl;

  /**
   * @brief @~english «Description of the method»
   * @param facadeStgPath «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Indique le chemin vers le fichier de template de la façade d'arrimage.
   * @param facadeStgPath Le chemin vers le fichier de template de la façade d'arrimage.
   * @return L'instance du constructeur de la configuration de la façade d'arrimage.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *      S.O.
   */
  public FacadePropertiesBuilder withFacadeStgPath(URL facadeStgPath) {
    logger.trace(Trace.ENTER_METHOD_1, facadeStgPath);
    this.facadeStgUrl = facadeStgPath;
    logger.trace(Trace.EXIT_METHOD_0);
    return this;
  }

  /**
   * @brief @~english «Description of the method»
   * @param facadeType «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Indique le chemin vers le fichier de template de la façade d'arrimage, basé
   *        sur un type de façade prédéfinie.
   * @param facadeType Le type de façade prédéfinie.
   * @return L'instance du constructeur de la configuration de la façade d'arrimage.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *      S.O.
   */
  public FacadePropertiesBuilder withFacadeType(FacadeType facadeType) {
    logger.trace(Trace.ENTER_METHOD_1, facadeType);
    this.facadeStgUrl = facadeType.getStgUrl();
    logger.trace(Trace.EXIT_METHOD_0);
    return this;
  }

  /**
   * @brief @~english «Description of the function»
   * @return «Return description»
   *
   * @brief @~french Construit l'instance de configuration de façade
   * @par Details
   *      S.O.
   * @return La configuration de la façade d'arrimage à partir des paramètres spécifiés.
   */
  public FacadeProperties build() {
    logger.trace(Trace.ENTER_METHOD_0);
    return new FacadePropertiesImpl(facadeStgUrl);
  }
}

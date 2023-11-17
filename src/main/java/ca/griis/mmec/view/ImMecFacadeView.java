/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MappingTemplate.
 * @brief @~english MappingTemplate class implementation.
 */

package ca.griis.mmec.view;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import ca.griis.mmec.model.ImMecFacade;

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
 * @brief @~french Classe responsable de la représentation textuelle d'une façade MMec
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
 *      2023-11-17 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public interface ImMecFacadeView {
  /**
   * @brief @~english «Description of the method»
   * @param facade «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Création d'une chaîne de caractère correspondant au script d'installation de la
   *        façade MMec.
   * @param facade La façade à installer
   * @return La chaîne de caractère représentant la façade MMec. Cette chaîne peut être utilisée
   *         pour installer la façade dans la source de données. Elle construit l'ensemble d'objets
   *         de base de données qui sont nécessaires pour la façade. Les instructions sont en ordre
   *         d'interdépendance.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *      S.O.
   */
  String getFacadeInstallView(ImMecFacade facade);

  /**
   * @brief @~english «Description of the method»
   * @param facade «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Création d'une chaîne de caractère correspondant au script de désinstallation
   *        de la façade MMec.
   * @param facade La façade à désinstaller
   * @return La chaîne de caractère représentant la façade MMec. Cette chaîne peut être utilisée
   *         pour désinstaller la façade dans la source de données. Elle détruit l'ensemble d'objets
   *         de base de données qui sont nécessaires pour la façade. Les instructions sont en ordre
   *         inverse d'interdépendance.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *      S.O.
   */
  String getFacadeUninstallView(ImMecFacade facade);
}

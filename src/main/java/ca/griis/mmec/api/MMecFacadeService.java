/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'interface MMecFacadeService.
 * @brief @~english Implementation of the MMecFacadeService interface.
 */

package ca.griis.mmec.api;

import ca.griis.mmec.model.ImMecFacade;
import ca.griis.mmec.properties.ConnectionProperties;
import ca.griis.mmec.properties.FacadeProperties;
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
 * @brief @~french Offre les services en lien avec une façade MMec.
 * @par Détails
 *      Le service permet de créer et d'intéragir avec une façade MMec. Une façade MMec correspond
 *      à un modèle intermédiaire entre un OntoRel et une source de données. Une fois la façade
 *      installée sur la source de données, il sera possible d'accéder aux données de celle-ci en
 *      utilisant le modèle de l'OntoRel pour formuler des requêtes.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      1. Acteur
 *      - Auteur :: La personne responsable de concevoir l'arrimage et qui fournit les
 *      paramètres de configuration.
 *      2. Lexique
 *      S.O.
 *      3. Entrées
 *      - connectionProperties :: La configuration de la connexion à la source de données. Le type
 *      de SGBD sera utilisé pour déterminer quel gabarit utiliser pour
 *      la génération de code SQL de la façade. Il aura un impact sur le
 *      dialect utilisé, ainsi que sur les fonctions de conversion de
 *      types disponibles.
 *      - mappingProperties :: Les informations spécifiques à l'arrimage de la source à l'OntoRel.
 *      On y trouve le chemin d'accès vers les fichiers de mapping et
 *      d'ontologie, ainsi que la configuration d'Ontop.
 *      - mmecFacadeProperties :: Les informations spécifiques à la façade. On y trouve
 *      le type de façade (vues, vues matérialisées ou alimentation) et
 *      le type de signature (type, chaine de caractère, etc.)
 *      4. Sorties
 *      - mmecFacade :: Une représentation de la façade qui pourra être installée sur la source
 *      5. Hypothèses
 *      - Les paramètres de configuration sont valides.
 *      6. Contraintes
 *      7. Fonctions
 *      7.1 createFacade
 *      Entrées : connectionProperties, mappingProperties, mmecFacadeProperties
 *      Sorties : mmecFacade
 *      Comportement : Création d'une façade MMec à partir d'une configuration valide.
 *
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2023-09-01 [SD] - Implémentation initiale.
 *
 * @par Tâches
 *      S.O.
 */
public interface MMecFacadeService {
  /**
   * @brief @~english «Description of the function»
   * @param connectionProperties «Parameter description»
   * @param mappingProperties «Parameter description»
   * @param mmecFacadeProperties «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Création d'une façade MMec à partir d'une configuration valide.
   * @param connectionProperties La configuration de la connexion à la source de données.
   * @param mappingProperties La configuration du mapping.
   * @param mmecFacadeProperties La configuration de la façade MMec.
   * @return La façade MMec.
   *
   * @par Tâches
   *      S.O.
   */
  ImMecFacade createFacade(ConnectionProperties connectionProperties,
      MappingProperties mappingProperties, FacadeProperties mmecFacadeProperties);
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'objet MappingConverterExtension.
 * @brief @~english MappingConverterExtension object implementation.
 */
package ca.griis.mmec.controller.ontop.extension;

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
 * @brief @~french Étend le R2RMLMappingParser avec un prétraitement du graphe d'arrimage et un traitement avant
 *                 la génération des PPMapping. Sert à étendre le modèle interne avec les fonctions R2RML étendues.
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
 *      2023-09-05 [SD] - Implémentation initiale.
 *
 * @par Tâches
 *      @todo 2023-09-06 [SD] - Faire la conception.
 */
public class MappingConverterExtension {
  private static final MappingConverterExtension instance = new MappingConverterExtension();

  public static MappingConverterExtension getInstance() {
    return instance;
  }
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'objet MMecFacade.
 * @brief @~english MMecFacade object implementation.
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
 * @brief @~french Représente une façade MMec.
 * @par Détails
 *      Une façade MMec correspond à un modèle intermédiaire entre un OntoRel et une source de
 *      données. Une fois la façade installée sur la source de données, il sera possible d'accéder
 *      aux données de celle-ci en utilisant le modèle de l'OntoRel pour formuler des requêtes.
 *      <br />
 *      Un exemple de configuration possible pour une façade MMec est la génération de vues dont le
 *      schéma correspond à l'OntoRel, mais dont la définition est spécifiées sur les éléments de
 *      la source de données.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      La facade correspond à un modèle intermédiaire entre un OntoRel et une source de données qui
 *      permet d'accéder aux données de la source de données en utilisant le modèle de l'OntoRel.
 *      <br />
 *      De ce fait, à partir de ce modèle, il est possible d'engendrer un script SQL dans un
 *      dialecte spécifique à la source de données. Ce script permettra d'installer la façade
 *      sur la source de données.
 *      <br />
 *      Il existe plusieurs représentations de façades MMec. Par exemple, une façade peut être
 *      installée en utilisant des vues, des vues matérialisées, voir même un serveur permettant
 *      la réécriture de requête.
 *      <br />
 *      Entrées : S.O.
 *      <br />
 *      Sorties :
 *      - SignPrototype :: La liste de prototypes de signatures utilisées dans l'arrimage.
 *      Chaque prototype correspond à une liste ordonnée de types et une liste d'identifiant de
 *      classes. Les types correspondent aux types des composants de signatures de ces classes.
 *      - CastFunctions :: Une liste de fonctions de conversion de types utilisées dans les
 *      expressions d'arrimage. Chaque fonction possède un type d'entrée et un
 *      type de sortie.
 *      - ClassExpressions :: Une liste d'expression permettant d'obtenir la façade d'une classe
 *      dans la source de données. Chaque expression possède un identifiant,
 *      le texte de son implémentation et une instruction de
 *      désinstallation.
 *      - ObjectPropertyExpressions :: Une liste d'expression permettant d'obtenir la façade d'une
 *      propriété d'objet dans la source de données. Chaque
 *      expression possède un identifiant, le texte de son
 *      implémentation et une instruction de désinstallation.
 *      - DataPropertyExpressions :: Une liste d'expression permettant d'obtenir la façade d'une
 *      propriété de données dans la source de données. Chaque
 *      expression possède un identifiant, le texte de son
 *      implémentation et une instruction de désinstallation.
 *      - DependencyGraph :: Le graphe de dépendances entre les éléments de l'OntoRel. Ce graphe
 *      permet de déterminer l'ordre d'installation et de désinstallation
 *      des éléments de la façade.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2023-09-06 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      2023-11-20 [SD] - Il faut modifier la conception pour que ce qui est dans le modèle soit
 *      indépendant de la configuration. La vue est responsable de créer le script
 *      qui correspond à la config. Ici, on est dans une façade générique.
 *
 *      SignPrototype et CastFunction ont étés ajustés, mais pas les autres.
 *      Ce qui me bug c'est le fait que les expressions sont déjà parsé par ontop
 *      à ce moment, alors on a déjà utilisé la vue. Ce qui contrevient au principe
 *      de MVC.
 */
public interface ImMecFacade {

}

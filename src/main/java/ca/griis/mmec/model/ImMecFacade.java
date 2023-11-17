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
 *      Ce modèle servira à engendrer un script SQL dans un dialecte spécifique à la source de
 *      données. Ce script permettra d'installer la façade sur la source de données.
 *      <br />
 *      Il existe plusieurs types de façades MMec. Par exemple, une façade peut être composée de
 *      vues ou de vues matérialisées.
 *      <br />
 *      Entrées :
 *      Sorties :
 *      - SignFunctions :: Une liste de fonctions permettant de calculer les signatures.
 *      Chaque fonction possède un identifiant, une liste de paramètres et
 *      le texte de son implémentation. Ces fonctions sont prédéfinies selon
 *      le gabarit d'arrimage sélectionné dans la configuration d'arrimage.
 *      - CastFunctions :: Une liste de fonctions de conversion de types. Chaque fonction possède
 *      un identifiant, un type d'entrée, un type de sortie et le texte de son
 *      implémentation. Ces fonctions sont prédéfinies par le gabarit
 *      correspondant au SGBD de la source de données.
 *      - CastCheckFunctions :: Une liste de fonction permettant de vérifier si une conversion
 *      est possible. Chaque fonction possède un identifiant, l'identifiant
 *      de la fonction de conversion correspondante et le texte de son
 *      implémentation. Ces fonctions sont prédéfinies par le gabarit
 *      correspondant au SGBD de la source de données.
 *      - SignatureExpressions :: Une liste d'expression permettant d'obtenir des signatures dans
 *      la source de données. Chaque expression possède un identifiant,
 *      le texte de son implémentation et une instruction de
 *      désinstallation.
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
 */
public interface ImMecFacade {
}

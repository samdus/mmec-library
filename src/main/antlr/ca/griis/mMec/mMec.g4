/*
-- =========================================================================== A
Produit : RelRel
Segment : mMec
Composant : mMec.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Samuel.Dussault@USherbrooke.ca
Description : Grammaire de mRel (v0).
Statut : en cours d'élaboration.

*Présentation* (à venir)
1. Description plus élaborée du composant.
2. Modèle (type abstrait, automate, etc.) retenu.
3. Critères de conception et contraintes applicables.
4. Description de la conception.
5. Limites.

*Copyright* 2021-...., GRIIS (http://griis.ca/)
GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé)
Faculté des sciences et Faculté de médecine et sciences de la santé
Université de Sherbrooke
Sherbrooke(Québec)  J1K 2R1  CANADA
[CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]

*Tâches projetées et questions*
  [SD 2022-08-26]
  TODO: Ajouter une instruction define variable/view pour pouvoir réutiliser des expressions
  [SD 2021-10-22]
  TODO: Inclure les grammaires réelles de discipulus et mrel
  QUESTIONS
    - Comment intégrer les idenfiticateurs de définitions dans Discipulus ?
      - D'ailleur, je crois qu'on devrait permettre de spécifier un nom de schéma plur le mapping et forcer d'utiliser l'identifiant qualifié pour référer aux signatures
    - Est-ce que "using" et "depending on" est fonctionnenet bien pour définir les dépendances de l'expressions textuelles ?
        --> depending on: Utile pour l'ordre de définition
        --> using: Uitle pour déterminer les attributs non utilisés dans la source
    - Est-ce qu'on devrait éviter d'avoir un mot clé à deux mot ("from expression", "depending on") ?
    - Est-ce que c'est grave d'avoir directemment le lexeur dans le présent fichier ? C'est la seule façon de pouvoir avoir les imports dans un autre dossier...
    - Pourquoi ne puis-je pas remplacer PROJECT par SELECT ? (ça fonctionne, mais ça devient sensible à la casse...)
    - Je n'aime pas trop l'idée d'introduire un attribut "sign" aux définitions qui réfères à des tables de classes. À discuter. En même temps, on pourrait aussi accéder aux autres composants au besoin ?

*Tâches réalisées*
2021-10-22 (0.1.0) [SD] Définition initiale.
  * Développement de la première version élaborée pour mRel.

*Références*
  S.O.

@version 0.1.0
@author [SD] Samuel.Dussault@USherbrooke.ca
@author [CK] Christina.Khnaisser@USherbrooke.ca
@author [LL] Luc.Lavoie@USherbrooke.ca
-- =========================================================================== A
*/
grammar mMec;
import Discipulus_LEX, IRI_LEX, LEX, Discipulus, mRel;

mMec_document: base EOF;

/* Base */
base: header exclusions mapping modifiers;

/* Entête */
header: ontorel_ref source_ref ;
ontorel_ref: ONTOREL ontorel_ref_id DEFINITION_DELIMITER ;
source_ref: SOURCE source_ref_id DEFINITION_DELIMITER ;
ontorel_ref_id: STRING ;
source_ref_id: STRING ;

/* Définitions des exclusions */
exclusions: exclusion_expression* ;
exclusion_expression: EXCLUSION exclusion_element exclusion_message DEFINITION_DELIMITER ;

exclusion_element: exclusion_source | exclusion_ontorel ;
exclusion_source: discipulus_qualified_attribute_list ;
exclusion_ontorel: mRel_relation_identifier exclusion_semantic ;
exclusion_semantic: NOT_AVAILABLE | UNDEFINED ;
exclusion_message: STRING ;

/* Définitions d'arrimage */
mapping: mapping_def+ ;
mapping_def: MAPPING_DEFINITION definition_id FOR mRel_relation_identifier expression DEFINITION_DELIMITER ;
definition_id: IDENT ;
expression: discipulus_expression | string_expression ;
definition_id_list: definition_id (LIST_DELIM definition_id)*;

// L'expression est une chaîne générique et une projection.
//  On peut définir les symboles de la sources qui ont été utilisés (afin de pouvoir valider l'ensemble des exclusions)
//  On peut définir les dépendances, pour permettre de générer l'arbre de dépendance et contrôler l'ordre d'initialisation
string_expression: FROM_EXPRESSION STRING PROJECT string_expression_selection_list (USING string_expression_used_symbol_list)? (DEPENDING_ON string_expression_dependency_symbol_list)? ;
string_expression_selection_list: discipulus_attribute_list ;
string_expression_used_symbol_list: discipulus_qualified_attribute_list ;
string_expression_dependency_symbol_list: definition_id_list ;

/* Définitions des modificateurs */
modifiers: mapping_modifier* ;
mapping_modifier: SET modifier_function DEFINITION_DELIMITER ;
modifier_function: shared | shadow ;

shared: SHARED FUNCTION_ARGUMENT_START shared_definition_id_list FUNCTION_ARGUMENT_END;
shared_definition_id_list: definition_id_list  ;

shadow: SHADOW FUNCTION_ARGUMENT_START shadower_definition_id LIST_DELIM shadowed_definition_id FUNCTION_ARGUMENT_END ;
shadower_definition_id:  definition_id ;
shadowed_definition_id: definition_id ;

/* Définitions importée d'autres grammaires */
// - mRel
mRel_relation_identifier: entity_identifier ;

// - Discipulus
discipulus_expression: rel_query ;
discipulus_attribute_list: attribute_list ;
discipulus_qualified_attribute_list: qualified_attribute_list ;

/* Mots réservés */
ONTOREL: O N T O R E L ;
SOURCE: S O U R C E ;
EXCLUSION: E X C L U S I O N ;
MAPPING_DEFINITION: D E F I N E ;

UNDEFINED: U N D E F I N E D ;
NOT_AVAILABLE: N O T '_' A V A I L A B L E ;

FOR: F O R ;
FROM: F R O M ;
FROM_EXPRESSION: F R O M ' ' E X P R E S S I O N;

PROJECT: P R O J E C T ;
USING: U S I N G ;
DEPENDING_ON: D E P E N D I N G ' ' O N ;

SET: S E T ;
SHARED: S H A R E D;
SHADOW: S H A D O W;

/* Éléments de constructions */
DEFINITION_DELIMITER: ';' ;
FUNCTION_ARGUMENT_START: '(' ;
FUNCTION_ARGUMENT_END: ')' ;
LIST_DELIM: ',' ;

/*
-- =========================================================================== Z
-- fin de mMec.g4
-- =========================================================================== Z
*/

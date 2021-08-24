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

*Tâches réalisées*
2013-04-09 (0.1.0) [SD] Définition initiale.
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

/* Base */
base: header exclusions mapping ;

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
mapping: mapping_def+ mapping_modifier* ;
mapping_def: MAPPING_DEFINITION definition_id FOR mRel_relation_identifier expression DEFINITION_DELIMITER ;
definition_id: IDENT ;
expression: discipulus_expression | string_expression ;

string_expression: FROM_EXPRESSION STRING SELECT discipulus_attribute_list ;

/* Définitions des modificateurs */
mapping_modifier: SET modifier_function DEFINITION_DELIMITER ;
modifier_function: modifier_function_id FUNCTION_ARGUMENT_START modifier_function_argument_list FUNCTION_ARGUMENT_END ;
modifier_function_argument_list: modifier_function_argument (FUNCTION_ARGUMENT_DELIM modifier_function_argument)* ;
modifier_function_argument: definition_id ;
modifier_function_id: IDENT ;

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
SET: S E T ;
FOR: F O R ;

/* Éléments de constructions */
DEFINITION_DELIMITER: ';' ;
NOT_AVAILABLE: N O T '_' A V A I L A B L E ;
UNDEFINED: U N D E F I N E D ;
FROM: F R O M ;
FROM_EXPRESSION: F R O M ' ' E X P R E S S I O N;
SELECT: S E L E C T ;
FUNCTION_ARGUMENT_START: '(' ;
FUNCTION_ARGUMENT_END: ')' ;
FUNCTION_ARGUMENT_DELIM: ',' ;

/*
-- =========================================================================== Z
-- fin de mMec.g4
-- =========================================================================== Z
*/

/*
-- =========================================================================== A
Produit : RelRel
Segment : mRel
Composant : mRel.g4
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
grammar mRel;
import mRel_LEX, LEX, mDiscipulus;

/* Base */
base: header ontorel_subset source_subset mapping ;

/* Entête */
header: ontorel source dialect ;
ontorel: ONTOREL ONTOREL_REF ;
source: SOURCE DICT_SOURCE_REF ;
dialect: DIALECT IDENT ':' VERSION ;

/* Définitions d'arrimage */
mapping: mapping_def+ ;

ontorel_subset: ontorel_exp* ;
source_subset: source_exp* ;

ontorel_exp: ONTOREL_EXP ONTOREL_ELEM_REF exp_semantic exp_message ;
source_exp: SOURCE_EXP SOURCE_ELEM_REF ;

exp_semantic: NA | NY ; // not available or not yet mapped
exp_message: STRING ;

mapping_def: MAPPING_DEF ONTOREL_ELEM_REF DEF_ID signature expression ';' ;
expression: STRING | rel_expression ;

// TODO: Retirer les charactères et unifier Classes, OP et DP.
//        --> Donc, véfifier si tout les types de mapping sont intéressant à définir avec juste une expression
signature: '{' components '}' ;
components: attribute_name  (',' attribute_name)* ;

/*
-- =========================================================================== Z
-- fin de RelRel/mRel.g4
-- =========================================================================== Z
*/

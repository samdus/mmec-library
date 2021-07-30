/*
-- =========================================================================== A
Produit : RelRel
Segment : RelRelLang
Composant : RelRelLang.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Samuel.Dussault@USherbrooke.ca
Description : Grammaire de RelRelLang (v0).
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
  * Développement de la première version élaborée pour RelRelLang.

*Références*
  S.O.

@version 0.1.0
@author [SD] Samuel.Dussault@USherbrooke.ca
@author [CK] Christina.Khnaisser@USherbrooke.ca
@author [LL] Luc.Lavoie@USherbrooke.ca
-- =========================================================================== A
*/
grammar RelRelLang;
import RelRelLang_LEX, LEX;

/* Base */
mapping: ontorel source dialect signature+
;

/* Entête */
ontorel: ONTOREL ontology rel;
source: SOURCE IDENT ;
dialect: DIALECT IDENT ':' VERSION ;

ontology: IDENT ':' VERSION ;
rel: IDENT ':' VERSION ;

/* Signatures */
signature: SIGNATURE IDENT (((signature_id)? '{' components '}' (from | from_expr) ';') | (NA ':' reason));
signature_id: IDENT;
components: attribute_name  (',' attribute_name)* ;
from: FROM rel_query;
from_expr: FROM_EXP expression ;

reason: STRING;
expression: STRING ;

// TODO: Définir le sous-ensemble discipulus disponible
rel_query: rel_var_name WHERE boolean_expression ;
boolean_expression: STRING ;

schema_name: IDENT;
rel_var_name: (schema_name '.')? IDENT;
attribute_name: (rel_var_name '.')? IDENT;

/*
-- =========================================================================== Z
-- fin de RelRel/RelRelLang.g4
-- =========================================================================== Z
*/

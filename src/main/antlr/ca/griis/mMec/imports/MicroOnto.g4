/*
-- =========================================================================== A
Produit : Ἀριστοτέλης
Segment : MicroOnto
Composant : MicroOnto.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Luc.Lavoie@USherbrooke.ca
Description : Syntaxe du langage MicroOnto (v1) proposé par le GRIIS.
Statut : en cours d'élaboration sur la base mOnto, une simplification de la syntaxe de Manchester.

*Présentation* (à venir)
1. Description plus élaborée du composant.
2. Modèle (type abstrait, automate, etc.) retenu.
3. Critères de conception et contraintes applicables.
4. Description de la conception.
5. Limites.

Copyright* 2016-2018, GRIIS (http://griis.ca/)
GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé)
Faculté des sciences et Faculté de médecine et sciences de la santé
Université de Sherbrooke
Sherbrooke(Québec)  J1K 2R1  CANADA
[CC-BY-NC-4.0 (http://creativecommons.org/licenses/by-nc/4.0)]

*Tâches projetées et questions*
TODO 2019-01-19 [CK] Permettre les participations dans les deux sens.
TODO 2019-01-19 [LL] Ajouter le concept d'Alias.
TODO 2017-08-14 [LL] Traiter les équivalences.
TODO 2017-08-14 [LL] Traiter les individus.
TODO 2017-08-14 [LL] Ajouter un langage de définition de types.

*Tâches réalisées*
2018-04-08 (0.1.0) [LL] Définition initiale.
  * Développement de la première version élaborée pour mOnto.

*Références*
  S.O.

@version 0.1.0
@author [CK] Christina.Khnaisser@USherbrooke.ca
@author [LL] Luc.Lavoie@USherbrooke.ca
-- =========================================================================== A
*/

grammar MicroOnto;
import MOnto_LEX, LEX;

// ===========================================================================
// Catégorie initiale : ontologie_def
// ...
// note : ...
// ----

ontology_def :
  (prefix_def)* 
  ONTOLOGY ontology_dec 
  (entity_def)*
  ;
prefix_def :
  PREFIX alias? ':' IDENT 
  // CK : renommer IDENT : emplacement ?
  ;
entity_def : 
  class_def | property_def | type_def // | equivalence_def | individal_def
  ;
class_def :
  CLASS class_dec inheritance* axiom* 
  ;
property_def :
  PROPERTY property_dec (dataProperty_def | objectProperty_def)
  ;
dataProperty_def :
  inheritance*
  // Domaine Portee                             -- LL: il faut au moins ajouter le domaine et la portée
  // Domaine participation Portee participation -- LL: ou mieux, permettre une (ou deux) participation(s)
  // INV? FCT?                                  -- LL: désormais inutile?
  ;
objectProperty_def :
  inheritance*
  inverse_def*
  // Domaine Portee                             -- LL: il faut au moins ajouter le domaine et la portée
  // Domaine participation Portee participation -- LL: ou mieux, permettre une (ou deux) participation(s)
  // FCT?                                  -- LL: désormais inutile?
  ;
type_def :
  TYPE type_dec 
  // la définition du type est pour le moment externe dans tous les cas
  ;
inheritance :
  ISA reference
  ;
inverse_def :
  INV property
  ;
/*
 À venir

equiv_def :
  EQUIV class_dec association_exp 
  ;
*/

/*===================== Les déclarations ===================== */
ontology_dec :
  declaration
  ;
class_dec :
  declaration
  ;
property_dec :
  declaration
  ;
type_dec :
  declaration
  ;
declaration :
  iri (LABEL label+)? (DESC description+)?
  ;
label :
  annotation
  ;
description :
  annotation
  ;
annotation :
  '@' LNG STRING
  ;
/*===================== Les expressions ===================== */
axiom :
  property participation association_exp
  ;
  
association_exp : 
  association_exp AND association_exp
  | association_exp OR association_exp
  | property participation association_exp
  | ontoClass
  | '(' association_exp ')'

  ;
/*===================== Les références ===================== */
ontoClass :
  reference
  ;
type :
  reference
  ;
property :
  reference
  ;
reference :
  iri
  ;
iri :
  alias? ':' iri_local 
  ;
alias :
  IDENT
  ;
iri_local :
  IDENT
  ;
participation :
  '[' min '..' max ']'
  ;
min :
  INTEGER
  ;
max :
  INTEGER | '*'
  ;

/*
-- =========================================================================== B
Pour normaliser, il suffit de limiter les catégories suivantes en préservant
l'équivalence :

classe_exp :
  classe
  ;
relation_exp :
  relation
  ;
-- =========================================================================== B
*/

/*
-- =========================================================================== Z
-- fin MicroOnto.g4
-- =========================================================================== Z
*/

/*
-- =========================================================================== A
Produit : RelRel
Segment : RelRelLang
Composant : RelRelLang_LEX.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Samuel.Dussault@USherbrooke.ca
Description : Mots réservés et conventions lexicales spécifiques RelRelLang (v0).
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

lexer grammar RelRelLang_LEX;
import LEX;

/* Constructions */
VERSION: (V)? INTEGER ('.'INTEGER)*;

/* Éléments d'entête */
ONTOREL: O N T O R E L;
SOURCE: S O U R C E;
DIALECT: D I A L E C T;

/* Constructions */
SIGNATURE: S I G N A T U R E;
OBJECTPROPERTIES: O B J E C T P R O P E R T I E S ;
DATAPROPERTIES: D A T A P R O P E R T I E S;

/* Signatures */
SELECT: S E L E C T;
FROM: F R O M;
FROM_EXP: F R O M ' ' E X P R E S S I O N;
WHERE: W H E R E;
NA: N A;

/* Object properties */

/* Data properties */

/*
-- =========================================================================== Z
-- fin de RelRel/RelRelLang_LEX.g4
-- =========================================================================== Z
*/

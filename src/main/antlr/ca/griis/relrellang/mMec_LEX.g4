/*
-- =========================================================================== A
Produit : RelRel
Segment : mRel
Composant : mMec_LEX.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Samuel.Dussault@USherbrooke.ca
Description : Mots réservés et conventions lexicales spécifiques mRel (v0).
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

lexer grammar mMec_LEX;
import Discipulus_LEX, IRI_LEX, LEX;

/* Mots réservés */
ONTOREL: O N T O R E L ;
SOURCE: S O U R C E ;
EXCLUSION: E X C L U S I O N ;
MAPPING_DEFINITION: D E F I N E ;
SET: S E T ;
FOR: F O R ;

/* Éléments de constructions */
NOT_AVAILABLE: N O T '_' A V A I L A B L E ;
UNDEFINED: U N D E F I N E D ;
DEFINITION_DELIMITER: ';' ;
FROM: F R O M ;
FROM_EXPRESSION: F R O M ' ' E X P R E S S I O N;
SELECT: S E L E C T ;
FUNCTION_ARGUMENT_START: '(' ;
FUNCTION_ARGUMENT_END: ')' ;
FUNCTION_ARGUMENT_DELIM: ',' ;

/*
-- =========================================================================== Z
-- fin de RelRel/mMec_LEX.g4
-- =========================================================================== Z
*/

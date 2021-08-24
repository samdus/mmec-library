/*
-- =========================================================================== A
Produit : Ἀριστοτέλης
Segment : mRel
Composant : mRel.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Luc.Lavoie@USherbrooke.ca
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
2021-08-04 (0.1.0) [SD] Définition initiale.
  * Développement d'une version temporaire pour le projet RelRel.

*Références*
  S.O.

@version 0.1.0
@author [SD] Samuel.Dussault@USherbrooke.ca
@author [CK] Christina.Khnaisser@USherbrooke.ca
@author [LL] Luc.Lavoie@USherbrooke.ca
-- =========================================================================== A
*/
grammar mRel;
import mRel_LEX, MicroOnto;

entity_relation: entity_identifier ;
entity_identifier: IDENT;

/*
-- =========================================================================== Z
-- fin de mRel.g4
-- =========================================================================== Z
*/

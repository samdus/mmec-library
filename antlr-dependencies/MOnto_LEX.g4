/*
-- =========================================================================== A
Produit : Ἀριστοτέλης
Segment : MicroOnto
Composant : MOnto.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Luc.Lavoie@USherbrooke.ca
Description : Mots réservés et conventions lexicales spécifiques MicroOnto (v1).
Statut : en cours d'élaboration.

*Présentation* (à venir)
1. Description plus élaborée du composant.
2. Modèle (type abstrait, automate, etc.) retenu.
3. Critères de conception et contraintes applicables.
4. Description de la conception.
5. Limites.

*Copyright* 2018-...., GRIIS (http://griis.ca/)
GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé)
Faculté des sciences et Faculté de médecine et sciences de la santé
Université de Sherbrooke
Sherbrooke(Québec)  J1K 2R1  CANADA
[CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]

*Tâches projetées et questions*
TODO 2018-04-09 [LL] Sensibilité à la casse.
  * Les identificateurs réservés en lettres latines sont insensibles à la casse...
    Est-ce la bonne décision ?
TODO 2017-08-26 [LL] Lettres grecques.
  * Les lettres grecques sont prises dans le groupe mathématique (mathematical
    small italic) pas dans le groupe alphabétique (greek small letter).
    Est-ce la bonne décision ?

*Tâches réalisées*
2013-04-09 (0.1.0) [LL] Définition initiale.
  * Développement de la première version élaborée pour mOnto.

*Références*
  S.O.

@version 0.1.0
@author [CK] Christina.Khnaisser@USherbrooke.ca
@author [LL] Luc.Lavoie@USherbrooke.ca
-- =========================================================================== A
*/
 
lexer grammar MOnto_LEX;
import LEX;

ONTOLOGY :             O N T O L O G I E     |  O N T O L O G Y ;
CLASS    : 'κ' | '𝜅' | C L A S S E           | C L A S S ;
EQUIV    : 'ι' | '𝜄' | E Q U I V A L E N C E;
PROPERTY : 'ρ' | '𝜌' | P R O P R I E T E     | P R O P E R T Y ;
INDIV    : 'α' | '𝛼' | I N D V I D U         | I N D V I D U A L ;
TYPE     : 'τ' | '𝜏' | T Y P E;
PREFIX   : 'π' | '𝜋' | P R E F I X E         | P R E F I X ;
        
/*===================== Les annotations ===================== */ 
LABEL    : '#'       | E T I Q U E T T E     | L A B E L ;
DESC     : '!'       | D E S C R I P T I O N ;

/*===================== Les opérateurs logiques ============= */ 
AND      : '∧' | '∩' |  E T   |  A N D |  I N T E R S E C T I O N ;
OR       : '∨' | '∪' |  O U   |  O R   |  U N I O N ;
NOT      : '¬'       |  N O N |  N O T ;

/*===================== La taxonomie ============ */
ISA      : '⊑' | '⊆' |  E S T  |  I S A ;

/*===================== Les modificateurs d'axiome ============ */
INV      : '-1'      |  I N V  |  I N V E R S E ;
FCT      : '⨍'       |  F C T  |  F O N C T I O N E L L E  |  F U N C T I O N A L ;

/*======== À compléter grâce à la référence ISO ============= */
LNG :
  'de' | 'en' | 'es' | 'fr' | 'it' ;


/*
-- =========================================================================== Z
-- fin de Ἀριστοτέλης/MicroOnto/Monto_LEX.g4
-- =========================================================================== Z
*/

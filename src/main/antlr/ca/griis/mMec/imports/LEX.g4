/*
-- =========================================================================== A
Produit : Discipulus/*
Composant : LEX.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Luc.Lavoie@USherbrooke.ca
Description : Conventions lexicales communes à l'ensemble des langages du GRIIS.
Statut : en cours d'élaboration sur la base de SQL, Eiffel et Discipulus.
Projets concernés (liste non fermée) : Discipulus, SSQL, mOnto, DadaGem.

*Présentation* (à développer)
1. Description plus élaborée du composant.
2. Modèle (type abstrait, automate, etc.) retenu.
3. Critères de conception et contraintes applicables.
4. Description de la conception.
5. Limites.

*Références* (à développer)
  ...

*Copyright* 2014-2016, Μῆτις (http://info.usherbrooke.ca/llavoie/)
*Copyright* 2016-...., GRIIS (http://griis.ca/)
GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé)
Faculté des sciences et Faculté de médecine et des sciences de la santé
Université de Sherbrooke
Sherbrooke (Québec)  J1K 2R1  CANADA
[CC-BY-4.0 (http://creativecommons.org/licenses/by/4.0)]

*Tâches projetées et questions*
TODO 2019-12-13 [LL] Mieux intégrer les caraxctères et les classes Unicode.
  * Utiliser les classes pour intégrer toutes les lettres dans IDENT.
  * Utiliser l'opérateur de complément pour intégrer tous les caractères dans STRING.

TODO 2019-12-07 [LL] Factoriser ce code pour l'ensemble des langages du GRIIS.
  * Include dans une bibliothèque commune à tous les langages développés au GRIIS.
  * Y inclure les autres éléments commun dont le canevas d'application
    (ConsoleXXX, AnalyseurXXX, ErreurSyntaxique, etc.).

TODO 2019-11-09 [LL] Traitement des soulignés "_".
  * Comme en Eiffel, les soulignés sont signifiants dans les identificateurs,
    mais non signifiants dans les nombres (il peuvent être utilisés pour séparer
    les triades, par exemple).
  * Faut-il maintenir ces conventions particulières (non uniformes) ?
    - CK : retirer les soulignés dans les nombres.
    - LL : je suis toujours indécis.

TODO 2019-11-09 [LL] Revoir certaines définitions lexicales
  * Revoir COMMENTAIRE_LIGNE : pourquoi la définition suivante ne suffirait-elle pas ?
      COMMENTAIRE_LIGNE : '//' .*? '\n' -> skip
    Rappel : la notation *? est la version minimale (non greedy) de la fermeture de Kleene,
             alors que * en est la version maximale (greedy).
  * Revoir SRING_MULTI : pourquoi la définition suivante ne suffirait-elle pas ?
      fragment STRING_MULTI : '«' (' ' | '\t')* '\n' (.*? '\n')*? '»' (' ' | '\t')* '\n' ;
  * Revoir le traitement de /r et HT dans COMMENTAIRE_LIGNE et ESPACES.
  * Voir comment retirer les débuts et fins de chaines dans la valeur des lexèmes STRING.
  * Voir comment substituer le caractère Unicode pour les ESC_SEQ.

PATCH 2019-11-09 [LL] ANTLR ne catégorise pas le "É" est une lettre majuscule.
  * Le fragment correspondant au "e accent aigu" n'a donc pu être identifié
    simplement par "É" ; "Eé" a été utilisé en lieu et place.
    Si d'autres lettres accentuées sont requises, il faudra procéder de façon analogue.

TODO 2019-11-09 [LL] Ajouter PATCH dans la liste des "task tag".
  * Pour désigner les modifications introduites pour pallier une erreur d'un
    outil (ici ANTLR). Exemple d'utilisation : les modifications induites par
    les erreurs de catégorisation des majuscules par ANTLR.

TODO 2019-11-09 [LL] Ajouter CANCEL dans la liste des "task tag".
  * Pour désigner une modification abandonnée et documenter la raison de cet
    abandon.

TODO 2017-08-19 [LL] Étendre le traitement Unicode jusqu'à U+10FFFF.
  * Désormais possible depuis ANTLR 4.7, mais nécessite l'utilisation de
    la classe CharStreams en Java.

TODO 2017-08-14 [LL] Changement des conventions relativement à SQL.
  * On remarque que la convention utilisée pour les identificateurs
    et les chaines de caractères est celle de SQL.
  * Est-ce une bonne idée ?

DONE 2017-08-14 [LL] 2019-12-09 [LL] Forme des identificateurs.
  * Je suis très tenté d'imposer la forme STRING2 aux identificateurs
    définis par le programmeur et d'imposer la forme IDENT0 aux
    identificateurs réservés par le langage.

*Tâches réalisées*
2019-12-26 (0.5.4) [LL] Ajout des échappements pour les guillemets
  * Ajout de %Y, %Z, %« et %».
  * Factorisation de IDENT_FIRST dans IDENT_FOLLOW.

2019-12-15 (0.5.3) [LL] Définition des fragments IDENT_FIRST et IDENT_FOLLOW
  * Afin de faciliter la construction d'identificateurs spécialisés (voir DadaGem)

2019-11-09 (0.5.2) [LL] Distinguer chaine uniligne et multiligne.
  * Ne retenir que deux formes de chaine : une uniligne et l'autre multiligne.
  * Distinguer la chaine (STRING) du caractère (CHARACTER).
  * Le souligné ne pouvait débuter un identificateur, comme c'est l'usage pour
    les identificateurs de paramètre en SQL/PSM; cette restriction a été levée.
  * Renommage des fragments associés aux chaines, aux caractères et aux identificateurs.
  * Le commentaire multiligne se termine maintenant à la fin de ligne
    (antérieurement, il comprenait toutes les fins de ligne terminales).

2017-08-19 (0.5.1) [LL] Restriction aux caractères Unicode à 16 bits
  * Retrait des STRING "à la Eiffel" délimités par "<" et ">".
  * Ajout des caractères délimités par les "vrais guillemets" « et ».
  * Ajustement du fragment ESC_SEQ en conséquence (et améliorations).
  * Inclusion temporaire, à des fins de test, des formes STRING1, 2, 3
    dans la définition de STRING - à revoir lorsqu'il aura été décidé
    si le domaine CHARACTER doit être introduit dans Discipulus ou non.

2017-08-14 (0.5.0) [LL] Épuration à partir de la version du 2017-08-12.
  * Introduction des deux formes d'identificateurs.
  * Retrait du lexème CHARACTER.
  * Déplacement des lexèmes FAUX et VRAI vers DLUS_LEX.
  * Extension des STRINGi aux parties hautes de l'Unicode.

2013-10-21 (0.1.0) [LL] Mise en oeuvre initiale.
  * Développé pour la première version de Discipulus et pour SSQL.
  * La forme ('.' DEC_DIGITS  EXPONENT?) pour les FLOAT a été exclue
    même si elle se rencontre dans de nombreux langages laxistes.

@version 0.5.5
@author [CK] Christina.Khnaisser@USherbrooke.ca
@author [LL] Luc.Lavoie@USherbrooke.ca
-- =========================================================================== A
*/

lexer grammar LEX;

// ====================
// Ajuster au besoin l'entête du module java, par exemple :
// @lexer::header { package ca.griis.odmv2 ; }

// ====================
// Lexique de base - pourra être étendu au besoin
//
IDENT :
  IDENT_SIMPLE | IDENT_DELIM
  ;
STRING :
  STRING_UNI | STRING_MULTI
  ;
CHARACTER :
  STRING_CAR
  ;
INTEGER :
                    DEC_DIGITS
    | '0' ('b'|'B') BIN_DIGITS
    | '0' ('c'|'C') OCT_DIGITS
    | '0' ('x'|'X') HEX_DIGITS
    ;
FLOAT :
      DEC_DIGITS '.' DEC_DIGITS  EXPONENT?
    | DEC_DIGITS                 EXPONENT
    ;

// ====================
// Conventions relatives aux espaces, fins de ligne et commentaires
//
ESPACES :
  (' ' | '\t' | '\n' | '\r' | '\f' )+ -> skip
  ;
//COMMENTAIRE_LIGNE :
//  '//' ~('\n'|'\r')* ('\n'|'\r') -> skip
//  ;
COMMENTAIRE_MULTI :
  '/*' .*? '*/' -> skip
  ;

// ====================
// Fragments :
//   "Fragments are reusable parts of lexer rules which cannot match on their own -
//   they need to be referenced from a lexer rule." -- ANTLR Ref. Manual.
//

// Utile pour composer les identificateurs réservés insensibles à la casse
//
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment Eé:('é'|'É');
fragment F:('f'|'F');
fragment G:('g'|'G');
fragment H:('h'|'H');
fragment I:('i'|'I');
fragment J:('j'|'J');
fragment K:('k'|'K');
fragment L:('l'|'L');
fragment M:('m'|'M');
fragment N:('n'|'N');
fragment O:('o'|'O');
fragment P:('p'|'P');
fragment Q:('q'|'Q');
fragment R:('r'|'R');
fragment S:('s'|'S');
fragment T:('t'|'T');
fragment U:('u'|'U');
fragment V:('v'|'V');
fragment W:('w'|'W');
fragment X:('x'|'X');
fragment Y:('y'|'Y');
fragment Z:('z'|'Z');

fragment
IDENT_FIRST :
  ('a'..'z'|'A'..'Z'|'_')
  ;
fragment
IDENT_FOLLOW :
  IDENT_FIRST | ('0'..'9')
  ;
fragment
IDENT_SIMPLE :
  IDENT_FIRST IDENT_FOLLOW*
  ;
fragment
IDENT_DELIM :
  '"' (' ' | '!' | /* '"' | */ '#' |'$' | ('%' ESC_SEQ) | '&'..'~' | UNICODE_H0)* '"'
  ;
fragment
STRING_UNI :
  '\'' (' '..'$' | ('%' ESC_SEQ) | '&' | /* '\'' | */ '('..'~' | UNICODE_H0)* '\''
  ;
fragment
STRING_CAR :
  '`' (' '..'$' | ('%' ESC_SEQ) | '&'..'_' | /* '`' | */ 'a'..'~' | UNICODE_H0)* '`'
  ;
fragment
STRING_MULTI :
  (' ' | '\t')*             // QST 2021-01-29 [LL01] faut-il inclure ce préfixe ?
  ('«'|'$$') (' ' | '\t')* '\n'
  (' '..'~' | UNICODE_H0 | '\n')*? '\n'
  (' ' | '\t')* ('»' | '$$')
  (' ' | '\t')* '\n'        // QST 2021-01-29 [LL01] faut-il inclure ce suffixe ?
  ;
fragment
UNICODE_H0 :
  '\u00A0'..'\u00FF' | '\u0100'..'\u086F' | '\u08A0'..'\uFFFF'
  ;
//  fragment
//  UNICODE_H1 : // UNICODE_H0 sauf le guillemet fermant '»'
//  '\u00A0'..'\u00BA' | '\u00BC'..'\u00FF' | '\u0100'..'\u086F' | '\u08A0'..'\uFFFF'
//  ;
fragment
ESC_SEQ :
            // Char Code Mnemonic name
      'A'   // @     %A  At-sign
    | 'B'   // BS    %B  Backspace
    | 'C'   // ^     %C  Circumflex
    | 'D'   // $     %D  Dollar
    | 'F'   // FF    %F  Form feed
    | 'H'   // \     %H  Backslash
    | 'J'   // LF    %J  Line Feed
    | 'L'   // ~     %L  Tilde
    | 'N'   //       %N  Newline (typically LF on Unix based systems and CRLF on Windows systems)
    | 'Q'   // `     %Q  Backquote (Grave accent)
    | 'R'   // CR    %R  Carriage return
    | 'S'   // #     %S  Sharp
    | 'T'   // HT    %T  Horizontal tab
    | 'U'   // NUL   %U  Null
    | 'V'   // |     %V  Vertical bar
    | 'Y'   // «     %Y  Guillemet ouvrant
    | 'Z'   // »     %Z  Guillemet fermant
    | '%'   // %     %%  Percent
    | '\''  // '     %'  Single quote
    | '"'   // "     %"  Double quote
    | '('   // [     %(  Opening bracket
    | ')'   // ]     %)  Closing bracket
    | '<'   // {     %<  Opening brace
    | '>'   // }     %>  Closing brace
    | '`'   // `     %`  Grave accent (Backquote)
    | '«'   // «     %«  Guillemet ouvrant
    | '»'   // »     %»  Guillemet fermant
    | UNICODE_ESC
    ;
fragment
UNICODE_ESC :
    '/' INTEGER '/'
    ;
fragment
EXPONENT :
    ('e'|'E') ('+'|'-')? DEC_DIGITS
    ;
fragment
HEX_DIGITS :
    HEX_DIGIT (HEX_DIGIT | '_' HEX_DIGIT)*
    ;
fragment
HEX_DIGIT :
    ('0'..'9' | 'a'..'f' | 'A'..'F')
    ;
fragment
DEC_DIGITS :
    DEC_DIGIT (DEC_DIGIT | '_' DEC_DIGIT)*
    ;
fragment
DEC_DIGIT :
    ('0'..'9')
    ;
fragment
OCT_DIGITS :
    OCT_DIGIT (OCT_DIGIT | '_' OCT_DIGIT)*
    ;
fragment
OCT_DIGIT :
    ('0'..'7')
    ;
fragment
BIN_DIGITS :
    BIN_DIGIT (BIN_DIGIT | '_' BIN_DIGIT)*
    ;
fragment
BIN_DIGIT :
    ('0'..'1')
    ;

/*
-- =========================================================================== Z
-- fin de LEX.g4
-- =========================================================================== Z
*/

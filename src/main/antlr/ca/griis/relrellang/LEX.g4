/*
-- =========================================================================== A
Produit : Hephaïstos
Segment : Discipulus
Composant : LEX.g4 (LEX3.g4 aux fins d'exploration)
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Luc.Lavoie@USherbrooke.ca
Description : Conventions lexicales communes à l'ensemble des langages du GRIIS.
Statut : en cours d'élaboration sur la base de Tutorial D et Discipulus.

*Présentation (à venir)*
1. Description plus élaborée du composant.
2. Modèle (type abstrait, automate, etc.) retenu.
3. Critères de conception et contraintes applicables.
4. Description de la conception.
5. Limites.

*Copyright* 2014-2016, Μῆτις (http://info.usherbrooke.ca/llavoie/)
*Copyright* 2016-...., GRIIS (http://griis.ca/)
GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé)
Faculté des sciences et Faculté de médecine et sciences de la santé
Université de Sherbrooke
Sherbrooke(Québec)  J1K 2R1  CANADA
[CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]

*Tâches projetées et questions*
TODO 2017-08-19 [LL] Étendre le traitement Unicode jusqu'à U+10FFFF.
Désormais possible depuis ANTLR 4.7, mais nécessite l'utilisation de
la classe CharStreams en Java.

TODO 2017-08-14 [LL] Changement des conventions relativement à SQL.
On remarque que la convention utilisées pour les identificateurs
et les chaines de caractères est celle de SQL.
Est-ce une bonne idée ? 

TODO 2017-08-14 [LL] Forme des identificateurs.
Je suis très tenté d'imposer la forme STRING2 aux identificateurs
définis par le programmeur et d'imposer la forme IDENT0 aux
identificateurs réservés par le langage.

*Tâches réalisées*
2017-08-19 (0.5.1) [LL] Restriction aux caractères Unicode à 16 bits
  * Retrait des STRING avec plus petit et plus grand "à la Eiffel".
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

@version 0.5.0
@author [CK] Christina.Khnaisser@USherbrooke.ca
@author [LL] Luc.Lavoie@USherbrooke.ca
-- =========================================================================== A
*/

lexer grammar LEX;
@header {
//package ca.griis.lex;
/**
 * Le lexique.
 *
 * @version 0.1.0 2018-04-08 
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */
}
// ====================
// Lexique - pourra être étendu au besoin
//
IDENT :
  IDENT0 | STRING0
  ;
STRING :
  STRING1 | STRING2 | STRING3
  ;
//  CHARACTER :
//    STRING2
//    ;
INTEGER :
                    DEC_DIGITS
    | '0' ('b'|'B') BIN_DIGITS
    | '0' ('c'|'C') OCT_DIGITS
    | '0' ('x'|'X') HEX_DIGITS
    ;
FLOAT :
      DEC_DIGITS '.' DEC_DIGITS  EXPONENT?
    | DEC_DIGITS                 EXPONENT
//  |            '.' DEC_DIGITS  EXPONENT? // forme autorisée par Eiffel,
                                           // exclue dans Discipulus et les
                                           // autres langages du GRIIS
    ;

// ====================
// Conventions relatives aux espaces, fins de ligne et commentaires
//
ESPACES :
  (' ' | '\t' | '\n' | '\r' | '\f' )+ -> skip
  ;
COMMENTAIRE_LIGNE :
  '//' ~('\n'|'\r')* ('\n'|'\r')+ -> skip
  ;
COMMENTAIRE_MULTI :
  '/*' .*? '*/' -> skip
  ;
  
// ====================
// Framents :
//   "Fragments are reusable parts of lexer rules which cannot match on their own - 
//   they need to be referenced from a lexer rule." -- ANTLR Ref. Manual.
//

// Utile pour composer les identificateurs réservés insensibles à la casse
fragment A:('a'|'A');
fragment B:('b'|'B');
fragment C:('c'|'C');
fragment D:('d'|'D');
fragment E:('e'|'E');
fragment Eé:('é'|'É'); // ANTLR ne se rend par compte que É est une majuscule!
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
IDENT0 :
  ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-')*
  ;
fragment
STRING0 :
  '"' (' ' | '!' | /* '"' */ '#' |'$' | ('%' ESC_SEQ) | '&'..'~' | UNICODE_H0)* '"'
  ;
fragment
STRING1 :
  '\'' (' '..'$' | ('%' ESC_SEQ) | '&' | /* '\'' */ '('..'~' | UNICODE_H0 | '\n')* '\''
  ;
fragment
STRING2 :
  '`' (' '..'$' | ('%' ESC_SEQ) | '&'..'_' | /* '`' */ 'a'..'~' | UNICODE_H0 | '\n')* '`'
  ;
fragment
STRING3 :
  '«' (' '..'$' | ('%' ESC_SEQ) | '&'..'~' | UNICODE_H1 | '\n')* '»'
  ;
fragment
UNICODE_H0 :
  '\u00A0'..'\u00FF' | '\u0100'..'\u086F' | '\u08A0'..'\uFFFF'
  ;
fragment
UNICODE_H1 : // UNICODE_H0 sauf le guillemet fermant '»'
  '\u00A0'..'\u00BA' | '\u00BC'..'\u00FF' | '\u0100'..'\u086F' | '\u08A0'..'\uFFFF'
  ;
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
    | '%'   // %     %%  Percent
    | '\''  // '     %'  Single quote
    | '"'   // "     %"  Double quote
    | '('   // [     %(  Opening bracket
    | ')'   // ]     %)  Closing bracket
    | '<'   // {     %<  Opening brace
    | '>'   // }     %>  Closing brace
    | '`'   // `     %`  Grave accent (Backquote)
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
fragment
ALPHA :
    ('a'..'z'|'A'..'Z')
    ;

/*
-- =========================================================================== Z
-- fin de Hephaïstos/Discipulus/Grammaire/LEX.g4
-- =========================================================================== Z
*/

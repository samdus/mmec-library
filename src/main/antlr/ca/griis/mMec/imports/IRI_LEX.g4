/*
-- =========================================================================== A
Produit : RFC 3987
Composant : IRI_LEX.g4
Encodage : UTF8 sans BOM, fin de ligne Unix (LF)
Responsable : Samuel.Dussault@USherbrooke.ca
Description : Il s'agit d'une approximation de la grammaire définie par la https://datatracker.ietf.org/doc/html/rfc3987[RFC 3987 (IRI)].

*Présentation*
  ...

*Références*
  ...

*Copyright* 2016-...., GRIIS (http://griis.ca/)
GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé)
Faculté des sciences et Faculté de médecine et des sciences de la santé
Université de Sherbrooke
Sherbrooke (Québec)  J1K 2R1  CANADA
[CC-BY-4.0 (http://creativecommons.org/licenses/by/4.0)]

*Tâches projetées et questions*
FIXME 2021-08-06 [SD] Cette version ne semble pas fonctionnelle, à corriger.
TODO 2021-08-04 [SD] Intégrer la définition des éléments bornés comme IPV6ADDRESS et IPATH_EMPTY

@version 0.1.0
@author [SD] Samuel.Dussault@USherbrooke.ca
@author [LL] Luc.Lavoie@USherbrooke.ca

-- =========================================================================== A
*/
lexer grammar IRI_LEX;

//import LEX;

IRI            : SCHEME ':' IHIER_PART ( '?' IQUERY )?
                         ( '#' IFRAGMENT )?
;
fragment
   IHIER_PART     : '//' IAUTHORITY IPATH_ABEMPTY
                  | IPATH_ABSOLUTE
                  | IPATH_ROOTLESS
//                  | IPATH_EMPTY
;
fragment
   IRI_REFERENCE  : IRI | IRELATIVE_REF
;
fragment
   ABSOLUTE_IRI   : SCHEME ':' IHIER_PART ( '?' IQUERY )?
;
fragment
   IRELATIVE_REF  : IRELATIVE_PART ( '?' IQUERY )? ( '#' IFRAGMENT )?
;
fragment
   IRELATIVE_PART : '//' IAUTHORITY IPATH_ABEMPTY
                       | IPATH_ABSOLUTE
                  | IPATH_NOSCHEME
//                  | IPATH_EMPTY
;
fragment
   IAUTHORITY     : ( IUSERINFO '@' )? IHOST ( ':' PORT )?
;
fragment
   IUSERINFO      : ( IUNRESERVED | PCT_ENCODED | SUB_DELIMS | ':' )*
;
fragment
   IHOST          : IP_LITERAL | IPV4ADDRESS | IREG_NAME
;
fragment
   IREG_NAME      : ( IUNRESERVED | PCT_ENCODED | SUB_DELIMS )*
;
fragment
   IPATH          : IPATH_ABEMPTY   // BEGINS WITH '/' OR IS EMPTY
                  | IPATH_ABSOLUTE  // BEGINS WITH '/' BUT NOT '//'
                  | IPATH_NOSCHEME  // BEGINS WITH A NON_COLON SEGMENT
                  | IPATH_ROOTLESS  // BEGINS WITH A SEGMENT
//                  | IPATH_EMPTY     // ZERO CHARACTERS
;
fragment
   IPATH_ABEMPTY  : ( '/' ISEGMENT )*
;
fragment
   IPATH_ABSOLUTE : '/' ( ISEGMENT_NZ ( '/' ISEGMENT )* )?
;
fragment
   IPATH_NOSCHEME : ISEGMENT_NZ_NC ( '/' ISEGMENT )*
;
fragment
   IPATH_ROOTLESS : ISEGMENT_NZ ( '/' ISEGMENT )*
;
//   IPATH_EMPTY    : 0<IPCHAR>
//;
fragment
   ISEGMENT       : IPCHAR*
;
fragment
   ISEGMENT_NZ    : IPCHAR+
;
fragment
   ISEGMENT_NZ_NC : ( IUNRESERVED | PCT_ENCODED | SUB_DELIMS
                        | '@' )*
                  // NON_ZERO_LENGTH SEGMENT WITHOUT ANY COLON ':'
;
fragment
   IPCHAR         : IUNRESERVED | PCT_ENCODED | SUB_DELIMS | ':'
                  | '@'
;
fragment
   IQUERY         : ( IPCHAR | IPRIVATE | '/' | '?' )*
;
fragment
   IFRAGMENT      : ( IPCHAR | '/' | '?' )*
;
fragment
   IUNRESERVED    : (ALPHA | DEC_DIGIT | '-' | '.' | '_' | '~' | UCSCHAR)+
;
fragment
   UCSCHAR        : '%XA0-D7FF' | '%XF900-FDCF' | '%XFDF0-FFEF'
                  | '%X10000-1FFFD' | '%X20000-2FFFD' | '%X30000-3FFFD'
                  | '%X40000-4FFFD' | '%X50000-5FFFD' | '%X60000-6FFFD'
                  | '%X70000-7FFFD' | '%X80000-8FFFD' | '%X90000-9FFFD'
                  | '%XA0000-AFFFD' | '%XB0000-BFFFD' | '%XC0000-CFFFD'
                  | '%XD0000-DFFFD' | '%XE1000-EFFFD'
;
fragment
   IPRIVATE       : '%XE000-F8FF' | '%XF0000-FFFFD' | '%X100000-10FFFD'
;
fragment
   SCHEME         : ALPHA ( ALPHA | DEC_DIGIT | '+' | '-' | '.' )*
;
fragment
   PORT           : DEC_DIGIT*
;
fragment
   IP_LITERAL     : '(' ( IPV4ADDRESS  ) ')?'
;
//   IPVFUTURE      : 'V' 1*HEXDIG '.' 1( UNRESERVED | SUB_DELIMS | ':' )*
//;
//   IPV6ADDRESS    :                            6( H16 ':' ) LS32
//                  |                       '::' 5( H16 ':' ) LS32
//                  | (               H16 )? '::' 4( H16 ':' ) LS32
//                  | ( *1( H16 ':' ) H16 )? '::' 3( H16 ':' ) LS32
//                  | ( *2( H16 ':' ) H16 )? '::' 2( H16 ':' ) LS32
//                  | ( *3( H16 ':' ) H16 )? '::'    H16 ':'   LS32
//                  | ( *4( H16 ':' ) H16 )? '::'              LS32
//                  | ( *5( H16 ':' ) H16 )? '::'              H16
//                  | ( *6( H16 ':' ) H16 )? '::'
//;
//   H16            : 1*4HEXDIG
//   LS32           : ( H16 ':' H16 ) | IPV4ADDRESS
//;
fragment
   IPV4ADDRESS    : DEC_OCTET '.' DEC_OCTET '.' DEC_OCTET '.' DEC_OCTET
;
fragment
   DEC_OCTET      : DEC_DIGIT                 // 0-9
                  | '%X31-39' DEC_DIGIT       // 10-99
                  | '1' DEC_DIGIT DEC_DIGIT   // 100-199
                  | '2' '%X30-34' DEC_DIGIT   // 200-249
                  | '25' '%X30-35'            // 250-255
;
fragment
   PCT_ENCODED    : '%' HEX_DIGIT HEX_DIGIT
;
fragment
   UNRESERVED     : ALPHA | DEC_DIGIT | '-' | '.' | '_' | '~'
;
fragment
   RESERVED       : GEN_DELIMS | SUB_DELIMS
;
fragment
   GEN_DELIMS     : ':' | '/' | '?' | '#' | '(' | ')?' | '@'
;
fragment
   SUB_DELIMS     : '!' | '$' | '&' | '\'' | '(' | ')'
                  | '*' | '+' | ',' | ';' | ':'
;
fragment
  ALPHA : '\u00A0'..'\u00FF' | '\u0100'..'\u086F' | '\u08A0'..'\uFFFF'
;
fragment
  DEC_DIGIT: ('0'..'9')
;
fragment
  HEX_DIGIT: ('0'..'9' | 'a'..'f' | 'A'..'F')
;

/*
-- =========================================================================== Z
-- fin de IRI_LEX.g4
-- =========================================================================== Z
*/

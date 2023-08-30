//TODO: Remplacer avec le lexeur de Discipulus
lexer grammar Discipulus_LEX;
import LEX;

AND: A N D ;
OR: O R ;
EQUALS: '=' ;
NOT_EQUALS: '<>' ;
IS_NULL: I S ' ' N U L L;
IS_NOT_NULL: I S ' ' N O T ' ' N U L L ;
GREATER_THAN: '>' ;
GREATER_OR_EQUALS: '>=' ;
LESSER_THAN: '<' ;
LESSER_OR_EQUALS: '<=' ;

FROM: F R O M ;
SELECT: S E L E C T ;
JOIN: J O I N ;
NATURAL_JOIN: N A T U R A L ' ' J O I N ;
LEFT_JOIN: L E F T ' ' JOIN ;
RIGHT_JOIN: R I G H T ' ' JOIN ;
ON: O N ;
USING: U S I N G ;
WHERE: W H E R E ;
AS: A S ;

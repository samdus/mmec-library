//TODO: Remplacer avec la réelle grammaire Discipulus
grammar Discipulus;
import Discipulus_LEX, LEX;

// Grammaire en version simplifiée
rel_query :
  ((from_term select_term?) | (select_term from_term?)) where_term?
  ;

from_term:
  FROM relation_specification join_list
  ;
join_list:
  join_term*
  ;
join_term:
  inner_join_term | natural_join_term | left_join_term | right_join_term
  ;

inner_join_term:
  JOIN relation_specification join_clause
  ;
natural_join_term:
  NATURAL_JOIN relation_specification
  ;
left_join_term:
  LEFT_JOIN relation_specification join_clause
  ;
right_join_term:
  RIGHT_JOIN relation_specification join_clause
  ;
join_clause:
  join_using_clause | join_on_clause
  ;
join_using_clause:
  USING '(' ident_list ')'
  ;
join_on_clause:
  ON predicate
  ;

select_term:
  SELECT argument_list
  ;

where_term:
  WHERE predicate
  ;

relation_specification:
  relation_name rename_expression?
  ;
rename_expression:
  AS IDENT
;

predicate:
  boolean_expression_list | boolean_parenthesis
  ;
boolean_parenthesis:
  '(' boolean_expression_list ')'
;

boolean_expression_list:
  boolean_expression (composition_operator predicate)*
  ;
boolean_expression :
  argument | unary_boolean_expression | nary_boolean_expression
  ;
unary_boolean_expression :
  argument unary_boolean_operator ;
nary_boolean_expression:
  argument boolean_operator argument
  ;

//predicate_expression:
//  predicate (boolean_op predicate)*
//  ;
//predicate:
//  argument (unary_op | (op predicate_expression))?
//  ;

composition_operator:
  AND | OR
  ;
boolean_operator:
  EQUALS | NOT_EQUALS | GREATER_THAN | GREATER_OR_EQUALS | LESSER_THAN | LESSER_OR_EQUALS
  ;
unary_boolean_operator:
  IS_NULL | IS_NOT_NULL
  ;

function_call:
  function_name '('  argument_list ')'
;
function_name:
  (schema_name '.')? IDENT
  ;

argument_list:
  argument (',' argument)*
  ;
argument:
  attribute_name | function_call | const_argument
  ;

schema_name:
  IDENT
  ;
relation_name:
  (schema_name '.')? IDENT
  ;
attribute_name:
  (relation_name '.')? IDENT
  ;

attribute_list:
  attribute_name (',' attribute_name)*
  ;
qualified_attribute_list:
  qualified_attribute_name (',' qualified_attribute_name)*
  ;
qualified_attribute_name:
  relation_name '.' IDENT
  ;

ident_list:
  IDENT (',' IDENT)*
  ;

const_argument:
  STRING | CHARACTER | INTEGER | FLOAT
  ;

// Grammaire Discipulus V0, selon le mémoire de Zouir
//rel_expression :
//	rel_term (add_rel_op rel_term)*
//	;
//rel_term :
//	rel_factor (mul_rel_op rel_factor)*
//	;
//rel_factor :
//	relation_name | '(' rel_query ')'
//	;
//add_rel_op :
//	'union' | 'minus'
//	;
//mul_rel_op :
//	'join' | 'inter' | 'cross' | 'by'
//	;
//rel_query :
//	'from' rel_list ( ':' relation_name )? rel_construction
//	// En l'absence de relation_name, la dénotation des qualified_attribute_name de
//	// chacune des attribute_value_def des attribute_value_def_list est obligatoire.
//	// En présence de relation_name, les qualified_attribute_name sont soit tous
//	// présents, soit tous absents (et alors l'association est positionnelle).
//	;
//rel_list :
//	(rel_item ('natural join' rel_item)*)? //FIXME: ici, il s'agissait d'une virgule..?
//	;
//rel_item :
//	rel_simple_item | '(' rel_query ')' 'as' relation_name
//	;
//rel_simple_item :
//	rel_var_name
//	;
//rel_construction :
//	selection | groupement
//	;
//selection :
//	'select' attribute_list ('where' boolean_expression)?
//	;
//groupement :
//	'group' attribute_list 'adding' '(' attribute_value_def_list ')'
//	;
//att_renaming_list :
//	'(' ( attribute_renaming (',' attribute_renaming)* )? ')'
//	;
//attribute_renaming :
//	attribute_name 'as' attribute_name
//	;
//attribute_value_def_list :
//	(attribute_value_def (',' attribute_value_def)*)?
//	;
//attribute_value_def :
//	(attribute_name ' :')? rel_expression
//	;
//attribute_list :
//	(attribute (',' attribute)*)?
//	;
//qualified_attribute_list :
//	(qualified_attribute (',' qualified_attribute)*)?
//	;
//attribute:
//  attribute_name | qualified_attribute
//  ;
//qualified_attribute :
//	relation_name '.' attribute_name
//	;
//boolean_expression :
//  unary_boolean_expression | nary_boolean_expression
//  ;
//unary_boolean_expression :
//  IDENT unary_boolean_operator ;
//nary_boolean_expression:
//  attribute boolean_operator attribute
//  ;
//boolean_operator :
// OR | AND
//  ;
//unary_boolean_operator :
//  IS NOT? NULL
//  ;
//schema_name:
//  IDENT
//  ;
//relation_name:
//  (schema_name '.')? IDENT
//  ;
//rel_var_name:
//  relation_name
//  ;
//attribute_name:
//  IDENT
//  ;

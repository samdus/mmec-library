//TODO: Remplacer avec la réelle grammaire Discipulus
grammar Discipulus;
import Discipulus_LEX, LEX;

rel_expression :
	rel_term (add_rel_op rel_term)*
	;
rel_term :
	rel_factor (mul_rel_op rel_factor)*
	;
rel_factor :
	relation_name | '(' rel_query ')'
	;
add_rel_op :
	'union' | 'minus'
	;
mul_rel_op :
	'join' | 'inter' | 'cross' | 'by'
	;
rel_query :
	'from' rel_list ( ':' relation_name )? rel_construction
	// En l'absence de relation_name, la dénotation des qualified_attribute_name de
	// chacune des attribute_value_def des attribute_value_def_list est obligatoire.
	// En présence de relation_name, les qualified_attribute_name sont soit tous
	// présents, soit tous absents (et alors l'association est positionnelle).
	;
rel_list :
	(rel_item (',' rel_item)*)?
	;
rel_item :
	rel_simple_item | '(' rel_query ')' 'as' relation_name
	;
rel_simple_item :
	rel_var_name
	;
rel_construction :
	selection | groupement
	;
selection :
	'select' attribute_list ('where' boolean_expression)?
	;
groupement :
	'group' attribute_list 'adding' '(' attribute_value_def_list ')'
	;
att_renaming_list :
	'(' ( attribute_renaming (',' attribute_renaming)* )? ')'
	;
attribute_renaming :
	attribute_name 'as' attribute_name
	;
attribute_value_def_list :
	(attribute_value_def (',' attribute_value_def)*)?
	;
attribute_value_def :
	(attribute_name ' :')? rel_expression
	;
attribute_list :
	(attribute (',' attribute)*)?
	;
qualified_attribute_list :
	(qualified_attribute (',' qualified_attribute)*)?
	;
attribute:
  attribute_name | qualified_attribute
  ;
qualified_attribute :
	relation_name '.' attribute_name
	;
boolean_expression :
  unary_boolean_expression | nary_boolean_expression
  ;
unary_boolean_expression :
  IDENT unary_boolean_operator ;
nary_boolean_expression:
  attribute boolean_operator attribute
  ;
boolean_operator :
 OR | AND
  ;
unary_boolean_operator :
  IS NOT? NULL
  ;
schema_name:
  IDENT
  ;
relation_name:
  (schema_name '.')? IDENT
  ;
rel_var_name:
  relation_name
  ;
attribute_name:
  IDENT
  ;

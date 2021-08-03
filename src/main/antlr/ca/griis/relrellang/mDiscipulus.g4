grammar mDiscipulus;
import LEX, mDiscipulus_LEX;

rel_expression: rel_var_name WHERE boolean_expression ;
boolean_expression: STRING ;

schema_name: IDENT ;
rel_var_name: (schema_name '.')? IDENT ;
attribute_name: (rel_var_name '.')? IDENT ;

/*
-- =========================================================================== A
Schema : simple
Creation Date : 20240515-1532
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Call procedure created to insert data into OntoRelCat schema
-- =========================================================================== A
*/

 call "ontorelcat_pub".ontorel_ins ('basicR2RML','1.2.2','2024-05-15T15:32:13.613999-04:00');

 call "ontorelcat_pub".onto_config_db_ins ('basicR2RML',
                            'uid',
                            'uid_domain',
                            'TEXT',
                            'value',
                            'value_domain',
                            'TEXT',
                            '60',
                            'false',
                            'false',
                            'false',
                            'false');

 call "ontorelcat_pub".onto_schema_ins ('basicR2RML','simple','en','BASE');

 call "ontorelcat_pub".ontology_ins ('basicR2RML','http://www.griis.ca/projects/onto_tst','ontology.ttl','onto_tst','','2024-01-12T16:55:05Z');

 call "ontorelcat_pub".onto_class_ins ('basicR2RML','http://www.w3.org/2002/07/owl#Thing','T7f4f794200','DECLARED');

 call "ontorelcat_pub".onto_class_ins ('basicR2RML','http://www.griis.ca/projects/tst3','T4f2a1f1000','DECLARED');

 call "ontorelcat_pub".onto_class_ins ('basicR2RML','http://www.griis.ca/projects/tst','T29732e8200','DECLARED');

 call "ontorelcat_pub".onto_class_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0004X','T305deffb00','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0004X','fr','tst1 C0004X');

 call "ontorelcat_pub".onto_label_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0004X','en','tst1 C0004Xtst3 | rel | tst2');

 call "ontorelcat_pub".onto_definition_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0004X','fr','tst1 C0004X');

 call "ontorelcat_pub".onto_definition_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0004X','en','tst1 C0004X');

 call "ontorelcat_pub".onto_class_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0006X','T305df03900','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0006X','fr','tst1 C0004X unionOf ');

 call "ontorelcat_pub".onto_label_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0006X','en','tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3');

 call "ontorelcat_pub".onto_definition_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0006X','fr','tst1 C0004X unionOf ');

 call "ontorelcat_pub".onto_definition_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0006X','en','tst1 C0004Xtst3 | rel | tst2 unionOf ');

 call "ontorelcat_pub".onto_class_ins ('basicR2RML','http://www.griis.ca/projects/tst2','T4f2a1f0000','DECLARED');

 call "ontorelcat_pub".onto_class_ins ('basicR2RML','http://www.griis.ca/projects/tst1','T4f2a1ef000','DECLARED');

 call "ontorelcat_pub".onto_data_type_ins ('basicR2RML','http://www.w3.org/1999/02/22-rdf-syntax-ns#langString','','"simple"."langString_domain"');

 call "ontorelcat_pub".onto_data_type_ins ('basicR2RML','http://www.w3.org/2001/XMLSchema#string','','"simple"."string_domain"');

 call "ontorelcat_pub".onto_object_properties_ins ('basicR2RML','http://www.griis.ca/projects/rel', null);

 call "ontorelcat_pub".onto_data_properties_ins ('basicR2RML','http://www.griis.ca/projects/has_value');

 call "ontorelcat_pub".onto_class_inheritance_ins ('basicR2RML','http://www.w3.org/2002/07/owl#Thing','http://www.griis.ca/projects/ONTORELA_C0006X');

 call "ontorelcat_pub".onto_class_inheritance_ins ('basicR2RML','http://www.w3.org/2002/07/owl#Thing','http://www.griis.ca/projects/ONTORELA_C0004X');

 call "ontorelcat_pub".onto_class_inheritance_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0006X','http://www.griis.ca/projects/tst2');

 call "ontorelcat_pub".onto_class_inheritance_ins ('basicR2RML','http://www.griis.ca/projects/tst','http://www.griis.ca/projects/tst3');

 call "ontorelcat_pub".onto_class_inheritance_ins ('basicR2RML','http://www.w3.org/2002/07/owl#Thing','http://www.griis.ca/projects/tst');

 call "ontorelcat_pub".onto_class_inheritance_ins ('basicR2RML','http://www.griis.ca/projects/tst','http://www.griis.ca/projects/tst1');

 call "ontorelcat_pub".onto_class_inheritance_ins ('basicR2RML','http://www.griis.ca/projects/tst','http://www.griis.ca/projects/tst2');

 call "ontorelcat_pub".onto_class_inheritance_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0006X','http://www.griis.ca/projects/tst3');

 call "ontorelcat_pub".onto_class_axiom_ins ('basicR2RML','http://www.griis.ca/projects/ONTORELA_C0004X','http://www.griis.ca/projects/ONTORELA_C0006X','http://www.griis.ca/projects/rel','[1..*]','[0.. *]','DECLARED','T7f06a14e00');

 call "ontorelcat_pub".onto_class_axiom_ins ('basicR2RML','http://www.griis.ca/projects/tst1','http://www.griis.ca/projects/ONTORELA_C0004X','http://www.griis.ca/projects/rel','[1..*]','[0.. *]','DECLARED','T3801380400');

 call "ontorelcat_pub".onto_data_axiom_ins ('basicR2RML','http://www.griis.ca/projects/tst','http://www.w3.org/2001/XMLSchema#string','http://www.griis.ca/projects/has_value','[1..1]','DECLARED','T75162af000');


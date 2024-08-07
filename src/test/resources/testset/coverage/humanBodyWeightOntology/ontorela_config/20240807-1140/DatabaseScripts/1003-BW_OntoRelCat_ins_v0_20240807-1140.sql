/*
-- =========================================================================== A
Schema : BW
Creation Date : 20240807-1140
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Call procedure created to insert data into OntoRelCat schema
-- =========================================================================== A
*/

 call "ontorelcat_pub".ontorel_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','1.2.2','2024-08-07T11:40:20.907297-04:00');

 call "ontorelcat_pub".onto_config_db_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4',
                            'uid',
                            'uid_domain',
                            'TEXT',
                            'value',
                            'value_domain',
                            'TEXT',
                            '60',
                            'true',
                            'false',
                            'false',
                            'false',
                            'false');

 call "ontorelcat_pub".onto_schema_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','BW','en','BASE');

 call "ontorelcat_pub".ontology_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl','HumanBodyWeightAppli_couverture.owl','humanbodyweight-appli.owl','','2024-02-13T15:17:24Z');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2002/07/owl#Thing','Thing','DECLARED');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2002/07/owl#Thing','en','The class owl:Thing is the class of all individuals.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000006','HBW_0000006','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000006','en','medical record identifier');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000006','en','A CRID symbol that is sufficent to look up a patient file in a medical record registry.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000040','BFO_0000040','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000040','en','material');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000040','en','An independent continuant that is spatially extended whose identity is independent of that of other entities and can be maintained through time.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000026','HBW_0000026','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000026','fr','weight measurement datum');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000026','en','A scalar measurement datum composed of two parts: a Decimal and a weight unit label.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd','ONTORELA_C1edc1ccd','INTERSECTION_CLASS');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd','fr','BFO_0000016 or BFO_0000019');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd','en','disposition or quality');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd','fr','(BFO_0000016 or BFO_0000019)
 and (RO_0000052 some OBI_0100026)');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd','en','(disposition or quality)
 and (inheres in some organism)Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000010','HBW_0000010','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000010','en','health care provider role');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000010','en','A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000209','OMRSE_00000209','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000209','en','gender identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000209','en','A social identity information content entity that is about whether some person identifies as some gender.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000002','HBW_0000002','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000002','en','RAMQ vulnerability code');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000002','en','A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000014','HBW_0000014','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000014','en','obesity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000014','en','A disease marked by an abnormally high, unhealthy amount of body fat.; A disorder characterized by having an increased body fat.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000022','HBW_0000022','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000022','en','human name');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000022','en','An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000009','IAO_0000009','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000009','en','datum label');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000009','en','A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000017','BFO_0000017','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000017','en','realizable entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000017','en','RealizableEntity');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0001194','VO_0001194','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0001194','en','biological sex datum');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0001194','en','A measurement datum that represents the biological sex of an animal. The result can be represented using a discretized digit, for example, 0 = female; 1 = male.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','BFO_0000001','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','en','entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','en','A thing that exists or has existed or will exist.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000109','IAO_0000109','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000109','en','measurement datum');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000109','en','A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000029','HBW_0000029','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000029','en','RAMQ vulnerability code statement');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000029','en','A statement about the inscription of a patient in a category of health situation in order to adjust administrative handling of physician billing by the RAMQ.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000204','OMRSE_00000204','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000204','en','social identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000204','en','An information content entity that is intended to be a truthful statement about some person and whether that person identifies as some particular aspect of social identity—such as a gender, an ethnicity, a race, or a sexual orientation—where the sense of identifying may correspond to either (i) an aspect of one’s cognitive representation of oneself, (ii) how one prefers to be regarded by others within some social context, or (iii) how one chooses to present oneself to others within some social context.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000005','HBW_0000005','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000005','en','physiological evaluation report');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000005','en','A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000212','OMRSE_00000212','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000212','en','non-binary identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000212','en','A gender identity information content entity that is about some person''s identifying as non-binary in gender.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000577','IAO_0000577','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000577','en','centrally registered identifier symbol');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000577','en','A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000009','HBW_0000009','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000009','en','body weight');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000009','en','a quality of a body of having a weight');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000013','HBW_0000013','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000013','en','physiological evaluation from health care provider');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000013','en','A physiological evaluation that is evaluated by a health care provider');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000028','IAO_0000028','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000028','en','symbol');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000028','en','An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0100026','OBI_0100026','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0100026','en','organism');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0100026','en','A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000025','HBW_0000025','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000025','en','female biological sex or gender identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000025','en','A biological sex or gender identity datum that is intended to denote a female biological sex or a female gender identity.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000001','HBW_0000001','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000001','en','physiological data item');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000001','en','A data item that is the specified output of some physiological evaluation.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000032','IAO_0000032','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000032','en','scalar measurement datum');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000032','en','a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','ONTORELA_C4d0c3f45','INTERSECTION_CLASS');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','fr','HBW_0000004
 and (IAO_0000136 some HBW_0000007)');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','en','health care record
 and (is about some patient)');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','fr','HBW_0000006');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','en','medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','BFO_0000002','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','en','continuant');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','en','Continuant');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OGMS_0000031','OGMS_0000031','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OGMS_0000031','en','disease');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OGMS_0000031','en','A disposition (i) to undergo pathological processes that (ii) exists in an organism because of one or more disorders in that organism.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020015','IAO_0020015','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020015','en','personal name');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020015','en','An identifier referring to an individual entity that is ascribed personhood by the user of the identifier.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','ONTORELA_C61c354fb','INTERSECTION_CLASS');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','fr','IAO_0000027
 and (IAO_0000136 some 
    ((BFO_0000016 or BFO_0000019)
     and (RO_0000052 some OBI_0100026)))');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','en','data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','fr','HBW_0000012');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','en','physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000028','HBW_0000028','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000028','en','human biological sex or gender identity statement');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000028','en','A statement about the biological sex or gender identity of a human');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000004','HBW_0000004','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000004','en','health care record');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000004','en','A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0000613','VO_0000613','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0000613','en','male biological sex datum');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0000613','en','A biological sex measurement datum that is intended to denote a male biological sex.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000008','HBW_0000008','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000008','en','health care provider');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000008','en','A homo sapiens having with the health care provider role');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000211','OMRSE_00000211','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000211','en','male gender identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000211','en','A gender identity information content entity that is about some person''s identifying as male in gender.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000310','IAO_0000310','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000310','en','document');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000310','en','An information content entity that is a collection of information content entities intended to be understood together as a whole.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000003','IAO_0000003','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000003','en','measurement unit label');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000003','en','A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000027','IAO_0000027','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000027','en','data item');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000027','en','a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000024','HBW_0000024','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000024','en','intersex biological sex or non-binary gender identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000024','en','A biological sex or gender identity datum that is intended to denote a intersex biological sex or a non-binary gender identity.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','OBI_0000011','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','en','planned process');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','en','A process that realizes a plan which is the concretization of a plan specification.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000012','HBW_0000012','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000012','en','physiological evaluation');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000012','en','A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0004896','VO_0004896','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0004896','en','intersex biological sex datum');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0004896','en','A biological sex measurement datum that is intended to denote an intersex biological sex.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000019','BFO_0000019','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000019','en','quality');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000019','en','Quality');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','BFO_0000003','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','en','occurrent');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','en','Occurrent');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000015','BFO_0000015','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000015','en','process');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000015','en','Process');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000031','BFO_0000031','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000031','en','gdc');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000031','en','b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001])');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000013','NOYO_0000013','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000013','en','statement');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000013','en','An informational entity that is considered valid by some agent at some point in time. (TBD)');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020000','IAO_0020000','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020000','en','identifier');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020000','en','An information content entity that is the outcome of a dubbing process and is used to refer to one instance of entity shared by a group of people to refer to that individual entity.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000023','BFO_0000023','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000023','en','role');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000023','en','A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000012','NOYO_0000012','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000012','en','informational entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000012','en','A generically dependent continuant that is a building block of information or a combination thereof.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000007','HBW_0000007','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000007','en','patient');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000007','en','An organism having the role of patient.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000210','OMRSE_00000210','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000210','en','female gender identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000210','en','A gender identity information content entity that is about some person''s identifying as female in gender.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NCBITaxon_9606','NCBITaxon_9606','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NCBITaxon_9606','en','Homo sapiens');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NCBITaxon_9606','en','Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IOIO_0000012','IOIO_0000012','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IOIO_0000012','en','human biological sex or gender identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IOIO_0000012','en','An information content entity that denotes a biological sex or a gender identity of a human.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000003','HBW_0000003','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000003','en','weight unit');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000003','en','a measurement unit label of a weight');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000011','HBW_0000011','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000011','en','patient role');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000011','en','a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000023','HBW_0000023','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000023','en','male biological sex or gender identity information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000023','en','A biological sex or gender identity datum that is intended to denote a male biological sex or a male gender identity.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','IAO_0000030','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','en','information content entity');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','en','An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0004895','VO_0004895','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0004895','en','female biological sex datum');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0004895','en','A biological sex datum that represents the biological sex of an animal (including human) as being female.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020017','IAO_0020017','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020017','en','family name');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020017','en','An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','BFO_0000004','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','en','independent continuant');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','en','b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000016','BFO_0000016','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000016','en','disposition');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000016','en','realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','ONTORELA_C2986e108','INTERSECTION_CLASS');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','fr','(BFO_0000016 or BFO_0000019)
 and (RO_0000052 some OBI_0100026)');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','en','(disposition or quality)
 and (inheres in some organism)');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','fr','IAO_0000027
 and (IAO_0000136 some 
    ((BFO_0000016 or BFO_0000019)
     and (RO_0000052 some OBI_0100026)))');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','en','data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "ontorelcat_pub".onto_class_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','BFO_0000020','DECLARED');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','en','specifically dependent continuant');

 call "ontorelcat_pub".onto_definition_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','en','SpecificallyDependentContinuant');

 call "ontorelcat_pub".onto_data_type_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2000/01/rdf-schema#Literal','','"BW"."Literal_domain"');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2000/01/rdf-schema#Literal','en','Literal');

 call "ontorelcat_pub".onto_data_type_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#boolean','','"BW"."boolean_domain"');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#boolean','en','Boolean');

 call "ontorelcat_pub".onto_data_type_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/1999/02/22-rdf-syntax-ns#langString','','"BW"."langString_domain"');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/1999/02/22-rdf-syntax-ns#langString','en','langString');

 call "ontorelcat_pub".onto_data_type_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#string','','"BW"."string_domain"');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#string','en','String');

 call "ontorelcat_pub".onto_data_type_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#double','','"BW"."double_domain"');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#double','en','Double');

 call "ontorelcat_pub".onto_data_type_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#decimal','','"BW"."decimal_domain"');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#decimal','en','Decimal');

 call "ontorelcat_pub".onto_data_type_sql_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4',null,'uid_domain','TEXT');

 call "ontorelcat_pub".onto_data_type_sql_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4',null,'value_domain','TEXT');

 call "ontorelcat_pub".onto_data_type_sql_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2000/01/rdf-schema#Literal','Literal_domain','TEXT');

 call "ontorelcat_pub".onto_data_type_sql_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#boolean','boolean_domain','BOOLEAN');

 call "ontorelcat_pub".onto_data_type_sql_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/1999/02/22-rdf-syntax-ns#langString','langString_domain','TEXT');

 call "ontorelcat_pub".onto_data_type_sql_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#string','string_domain','TEXT');

 call "ontorelcat_pub".onto_data_type_sql_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#double','double_domain','DOUBLE PRECISION');

 call "ontorelcat_pub".onto_data_type_sql_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#decimal','decimal_domain','DECIMAL');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000050', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000050','en','part of');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000050');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000050');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000051', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000051','en','has part');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000052', null);

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000054', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000054','en','realized in');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000054');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000054');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000055', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000055','en','realizes');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000055');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000055');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000056', null);

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000057', null);

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000066', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000066','en','occurs in');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000066');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000066');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000039', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000039','en','has measurement unit label');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000039');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000039');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000136', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000136','en','is about');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0000136');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000136');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000219', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000219','en','denotes');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0000219');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000219');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000221', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000221','en','is quality measurement of');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000221');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000413', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000413','en','is duration of');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/IAO_0000413');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000417', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000417','en','is quality measured as');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000293', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000293','en','has_specified_input');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000293');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000295', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000295','en','is_specified_input_of');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000295');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000299', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000299','en','has_specified_output');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000299');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000312', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000312','en','is_specified_output_of');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000312');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000417', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000417','en','achieves_planned_objective');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000417');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000833', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000833','en','objective_achieved_by');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000833');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0001938', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0001938','en','has value specification');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/PHYSIO_0000089', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/PHYSIO_0000089','en','has evaluant');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000052', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000052','en','inheres in');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000053', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000053','en','bearer of');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000053');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000056', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000056','en','participates in');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/RO_0000056');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/RO_0000056');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000057', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000057','en','has participant');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/RO_0000057');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/RO_0000057');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000058', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000058','en','is concretized as');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/RO_0000058');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000058');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000059', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000059','en','concretizes');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000059');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/RO_0000059');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000079', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000079','en','function of');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000080', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000080','en','quality of');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000081', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000081','en','role of');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000085', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000085','en','has function');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0000085');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000086', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000086','en','has quality');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000087', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000087','en','has role');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0000087');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/RO_0000087');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000091', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000091','en','has disposition');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0000091');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000092', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000092','en','disposition of');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0001015', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0001015','en','location of');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0001025', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0001025','en','located in');

 call "ontorelcat_pub".onto_object_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0001025');

 call "ontorelcat_pub".onto_object_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0001025');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002131', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002131','en','overlaps');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002323', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002323','en','mereotopologically related to');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002350', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002350','en','member of');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002351', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002351','en','has member');

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.org/obo/owl/OBO_REL#exists_during', null);

 call "ontorelcat_pub".onto_object_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.org/obo/owl/obo#towards', null);

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.org/obo/owl/obo#towards','en','towards');

 call "ontorelcat_pub".onto_data_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000004');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000004','en','has measurement value');

 call "ontorelcat_pub".onto_data_properties_domain_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000004');

 call "ontorelcat_pub".onto_data_properties_range_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2001/XMLSchema#double','http://purl.obolibrary.org/obo/IAO_0000004', 'DOUBLE PRECISION');

 call "ontorelcat_pub".onto_data_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/PHYSIO_0000100');

 call "ontorelcat_pub".onto_label_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/PHYSIO_0000100','en','has value');

 call "ontorelcat_pub".onto_data_properties_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2002/07/owl#topDataProperty');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000013','http://purl.obolibrary.org/obo/HBW_0000029');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000031');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2002/07/owl#Thing','http://purl.obolibrary.org/obo/BFO_0000001');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/HBW_0000013');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/HBW_0000008');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000028','http://purl.obolibrary.org/obo/IAO_0000577');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000310','http://purl.obolibrary.org/obo/HBW_0000005');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/HBW_0000011');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000209','http://purl.obolibrary.org/obo/OMRSE_00000211');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IOIO_0000012');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IOIO_0000012','http://purl.obolibrary.org/obo/VO_0001194');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000577','http://purl.obolibrary.org/obo/HBW_0000006');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000027','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0001194','http://purl.obolibrary.org/obo/VO_0004895');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000016');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IOIO_0000012','http://purl.obolibrary.org/obo/HBW_0000024');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000009','http://purl.obolibrary.org/obo/IAO_0000003');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OGMS_0000031','http://purl.obolibrary.org/obo/HBW_0000014');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0000027');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000027','http://purl.obolibrary.org/obo/HBW_0000001');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000040');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000015');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000040','http://purl.obolibrary.org/obo/OBI_0100026');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020000','http://purl.obolibrary.org/obo/HBW_0000022');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000016','http://purl.obolibrary.org/obo/OGMS_0000031');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/NCBITaxon_9606');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/HBW_0000012');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000023');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0000310');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000004');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://www.w3.org/2002/07/owl#Thing','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/IAO_0000030');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/HBW_0000003');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0001194','http://purl.obolibrary.org/obo/VO_0000613');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0000009');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000027','http://purl.obolibrary.org/obo/HBW_0000002');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000209','http://purl.obolibrary.org/obo/OMRSE_00000210');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/HBW_0000010');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0000028');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0020000');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000027','http://purl.obolibrary.org/obo/IAO_0000109');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000310','http://purl.obolibrary.org/obo/HBW_0000004');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000019','http://purl.obolibrary.org/obo/HBW_0000009');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000209','http://purl.obolibrary.org/obo/OMRSE_00000212');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/VO_0001194','http://purl.obolibrary.org/obo/VO_0004896');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IOIO_0000012','http://purl.obolibrary.org/obo/OMRSE_00000209');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/HBW_0000007');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/VO_0001194');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000020');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/HBW_0000026');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/OBI_0000011');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000004','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/OMRSE_00000204');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OMRSE_00000204','http://purl.obolibrary.org/obo/OMRSE_00000209');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020000','http://purl.obolibrary.org/obo/IAO_0020017');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000003');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IOIO_0000012','http://purl.obolibrary.org/obo/HBW_0000025');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000032');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020000','http://purl.obolibrary.org/obo/IAO_0020015');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IOIO_0000012','http://purl.obolibrary.org/obo/HBW_0000023');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/NOYO_0000012');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000002');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000012','http://purl.obolibrary.org/obo/NOYO_0000013');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000017');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/NOYO_0000013','http://purl.obolibrary.org/obo/HBW_0000028');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd','http://purl.obolibrary.org/obo/BFO_0000016');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000019');

 call "ontorelcat_pub".onto_class_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C1edc1ccd','http://purl.obolibrary.org/obo/BFO_0000019');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000050','http://purl.obolibrary.org/obo/RO_0002131');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000051','http://purl.obolibrary.org/obo/RO_0002131');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000039','http://purl.obolibrary.org/obo/BFO_0000051');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000219','http://purl.obolibrary.org/obo/IAO_0000136');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000221','http://purl.obolibrary.org/obo/IAO_0000136');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000413','http://purl.obolibrary.org/obo/IAO_0000136');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000293','http://purl.obolibrary.org/obo/RO_0000057');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000295','http://purl.obolibrary.org/obo/RO_0000056');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000299','http://purl.obolibrary.org/obo/RO_0000057');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000299','http://purl.obolibrary.org/obo/BFO_0000057');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/OBI_0000312','http://purl.obolibrary.org/obo/RO_0000056');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/PHYSIO_0000089','http://purl.obolibrary.org/obo/RO_0000057');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000079','http://purl.obolibrary.org/obo/RO_0000052');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000080','http://purl.obolibrary.org/obo/RO_0000052');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000081','http://purl.obolibrary.org/obo/RO_0000052');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000085','http://purl.obolibrary.org/obo/RO_0000053');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000086','http://purl.obolibrary.org/obo/RO_0000053');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000087','http://purl.obolibrary.org/obo/RO_0000053');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000091','http://purl.obolibrary.org/obo/RO_0000053');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0000092','http://purl.obolibrary.org/obo/RO_0000052');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002131','http://purl.obolibrary.org/obo/RO_0002323');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002350','http://purl.obolibrary.org/obo/BFO_0000050');

 call "ontorelcat_pub".onto_object_property_inheritance_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/RO_0002351','http://purl.obolibrary.org/obo/BFO_0000051');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020000','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000219','[1..*]','[0.. *]','DECLARED','IAO_0020000_IAO_0000219_BFO_0000001');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','IAO_0000030_IAO_0000136_BFO_0000001');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/RO_0000052','[1..*]','[0.. *]','UNION_AXIOM','ONTORELA_C2986e108_RO_0000052_OBI_0100026');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/RO_0000056','[1..*]','[0.. *]','DECLARED','BFO_0000002_RO_0000056_BFO_0000003');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000039','[1..*]','[1.. *]','DECLARED','IAO_0000032_IAO_0000039_IAO_0000003');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000219','[1..*]','[0.. *]','DECLARED','IAO_0000030_IAO_0000219_BFO_0000001');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000028','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/BFO_0000051','[1..1]','[0.. *]','DECLARED','HBW_0000028_BFO_0000051_HBW_0000006');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000039','[1..1]','[1.. *]','DECLARED','IAO_0000109_IAO_0000039_IAO_0000003');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000022','http://purl.obolibrary.org/obo/IAO_0020015','http://purl.obolibrary.org/obo/BFO_0000051','[1..*]','[0.. *]','DECLARED','HBW_0000022_BFO_0000051_IAO_0020015');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000022','http://purl.obolibrary.org/obo/IAO_0020017','http://purl.obolibrary.org/obo/BFO_0000051','[1..*]','[0.. *]','DECLARED','HBW_0000022_BFO_0000051_IAO_0020017');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000058','[1..*]','[0.. *]','DECLARED','BFO_0000031_RO_0000058_BFO_0000020');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/RO_0000059','[1..*]','[0.. *]','DECLARED','BFO_0000020_RO_0000059_BFO_0000031');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000022','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/IAO_0000219','[1..*]','[0.. *]','DECLARED','HBW_0000022_IAO_0000219_NCBITaxon_9606');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','INTERSECTION_AXIOM','ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000001','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/OBI_0000312','[1..*]','[0.. *]','INTERSECTION_AXIOM','HBW_0000001_OBI_0000312_HBW_0000012');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000005','http://purl.obolibrary.org/obo/HBW_0000001','http://purl.obolibrary.org/obo/BFO_0000051','[1..*]','[0.. *]','DECLARED','HBW_0000005_BFO_0000051_HBW_0000001');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/RO_0000057','[1..*]','[0.. *]','DECLARED','BFO_0000003_RO_0000057_BFO_0000002');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0001025','[1..*]','[0.. *]','DECLARED','BFO_0000004_RO_0001025_BFO_0000004');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000054','[1..*]','[0.. *]','DECLARED','BFO_0000017_BFO_0000054_BFO_0000015');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','http://purl.obolibrary.org/obo/IAO_0000219','[1..1]','[0.. *]','INTERSECTION_AXIOM','HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000026','http://purl.obolibrary.org/obo/HBW_0000003','http://purl.obolibrary.org/obo/IAO_0000039','[1..*]','[1.. *]','DECLARED','HBW_0000026_IAO_0000039_HBW_0000003');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000008','http://purl.obolibrary.org/obo/HBW_0000010','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','INTERSECTION_AXIOM','HBW_0000008_RO_0000087_HBW_0000010');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000005','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/BFO_0000051','[1..1]','[0.. *]','DECLARED','HBW_0000005_BFO_0000051_HBW_0000006');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','http://purl.obolibrary.org/obo/HBW_0000007','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','INTERSECTION_AXIOM','ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000004','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','HBW_0000004_IAO_0000136_OBI_0100026');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000066','[1..*]','[0.. *]','DECLARED','BFO_0000003_BFO_0000066_BFO_0000004');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000028','http://purl.obolibrary.org/obo/IOIO_0000012','http://purl.obolibrary.org/obo/BFO_0000051','[1..1]','[0.. *]','DECLARED','HBW_0000028_BFO_0000051_IOIO_0000012');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000007','http://purl.obolibrary.org/obo/HBW_0000011','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','INTERSECTION_AXIOM','HBW_0000007_RO_0000087_HBW_0000011');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000055','[1..*]','[0.. *]','DECLARED','BFO_0000015_BFO_0000055_BFO_0000017');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000050','[1..*]','[0.. *]','DECLARED','BFO_0000001_BFO_0000050_BFO_0000001');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','http://purl.obolibrary.org/obo/OBI_0000299','[1..*]','[0.. *]','INTERSECTION_AXIOM','HBW_0000012_OBI_0000299_ONTORELA_C61c354fb');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/PHYSIO_0000089','[1..1]','[0.. *]','DECLARED','HBW_0000012_PHYSIO_0000089_NCBITaxon_9606');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000029','http://purl.obolibrary.org/obo/HBW_0000002','http://purl.obolibrary.org/obo/BFO_0000051','[1..1]','[0.. *]','DECLARED','HBW_0000029_BFO_0000051_HBW_0000002');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000013','http://purl.obolibrary.org/obo/HBW_0000008','http://purl.obolibrary.org/obo/PHYSIO_0000089','[1..1]','[0.. *]','INTERSECTION_AXIOM','HBW_0000013_PHYSIO_0000089_HBW_0000008');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000029','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/BFO_0000051','[1..1]','[0.. *]','DECLARED','HBW_0000029_BFO_0000051_HBW_0000006');

 call "ontorelcat_pub".onto_class_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','DECLARED','BFO_0000004_RO_0000087_BFO_0000023');

 call "ontorelcat_pub".onto_data_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020017','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','IAO_0020017_PHYSIO_0000100_string');

 call "ontorelcat_pub".onto_data_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000003','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','IAO_0000003_PHYSIO_0000100_string');

 call "ontorelcat_pub".onto_data_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2000/01/rdf-schema#Literal','http://purl.obolibrary.org/obo/IAO_0000004','[1..*]','DECLARED','IAO_0000032_IAO_0000004_Literal');

 call "ontorelcat_pub".onto_data_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000002','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','HBW_0000002_PHYSIO_0000100_string');

 call "ontorelcat_pub".onto_data_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/HBW_0000026','http://www.w3.org/2001/XMLSchema#decimal','http://purl.obolibrary.org/obo/IAO_0000004','[1..*]','DECLARED','HBW_0000026_IAO_0000004_decimal');

 call "ontorelcat_pub".onto_data_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2001/XMLSchema#double','http://purl.obolibrary.org/obo/IAO_0000004','[1..1]','DECLARED','IAO_0000032_IAO_0000004_double');

 call "ontorelcat_pub".onto_data_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0000577','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','IAO_0000577_PHYSIO_0000100_string');

 call "ontorelcat_pub".onto_data_axiom_ins ('d62e5825-d8f0-4f79-8c9b-7671785166f4','http://purl.obolibrary.org/obo/IAO_0020015','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','IAO_0020015_PHYSIO_0000100_string');


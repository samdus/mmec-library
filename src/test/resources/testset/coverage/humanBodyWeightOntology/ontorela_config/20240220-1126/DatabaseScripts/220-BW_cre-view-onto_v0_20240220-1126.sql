/*
-- =========================================================================== A
Schema : BW_ontoView
Creation Date : 20240220-1126
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Create views with short IRI of BW_ontoView
-- =========================================================================== A
*/

CREATE SCHEMA IF NOT EXISTS "BW_ontoView";

COMMENT ON SCHEMA "BW_ontoView" IS 'Create views with short IRI of BW_ontoView 20240220-1126';

-- Vue de la classe HBW_0000002
CREATE VIEW "BW_ontoView"."HBW_0000002_p" AS
  SELECT *
  FROM "BW"."HBW_0000002" 
    JOIN "BW"."HBW_0000002_PHYSIO_0000100_string" USING("HBW_0000002_uid") -- HBW_0000002 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000002_p" IS 'RAMQ vulnerability code::A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe HBW_0000002
CREATE VIEW "BW_ontoView"."HBW_0000002_c" AS
  SELECT *
  FROM "BW"."HBW_0000002" 
    JOIN "BW"."HBW_0000002_PHYSIO_0000100_string" USING("HBW_0000002_uid") -- HBW_0000002 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000002_c" IS 'RAMQ vulnerability code::A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe HBW_0000022
CREATE VIEW "BW_ontoView"."HBW_0000022_c" AS
  SELECT *
  FROM "BW"."HBW_0000022" 
    JOIN "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606" USING("HBW_0000022_uid") -- HBW_0000022 [1..*] IAO_0000219 NCBITaxon_9606
    JOIN "BW"."HBW_0000022_BFO_0000051_IAO_0020017" USING("HBW_0000022_uid") -- HBW_0000022 [1..*] BFO_0000051 IAO_0020017
    JOIN "BW"."HBW_0000022_BFO_0000051_IAO_0020015" USING("HBW_0000022_uid") -- HBW_0000022 [1..*] BFO_0000051 IAO_0020015
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000022_c" IS 'human name::An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. null Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans. An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. a core relation that holds between a whole and its part An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children. An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. a core relation that holds between a whole and its part Sep 29, 2016: The comment that including the wikipedia definition of personal name is not to be interpreted in a way that restricts this class to only contain strings of letters. A numerical or alphanumerical identifier that denotes a human is being is a personal name, too. (MB)';

-- Vue de la classe HBW_0000006
CREATE VIEW "BW_ontoView"."HBW_0000006_p" AS
  SELECT *
  FROM "BW"."HBW_0000006" 
    JOIN "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" USING("HBW_0000006_uid") -- HBW_0000006 [1..1] IAO_0000219 ONTORELA_C4d0c3f45
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000006_p" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry. A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient.';

-- Vue de la classe HBW_0000006
CREATE VIEW "BW_ontoView"."HBW_0000006_c" AS
  SELECT *
  FROM "BW"."HBW_0000006" 
    JOIN "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" USING("HBW_0000006_uid") -- HBW_0000006 [1..1] IAO_0000219 ONTORELA_C4d0c3f45
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000006_c" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry. A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient.';

-- Vue de la classe HBW_0000026
CREATE VIEW "BW_ontoView"."HBW_0000026_c" AS
  SELECT *
  FROM "BW"."HBW_0000026" 
    JOIN "BW"."HBW_0000026_IAO_0000039_HBW_0000003" USING("HBW_0000026_uid") -- HBW_0000026 [1..*] IAO_0000039 HBW_0000003
    JOIN "BW"."HBW_0000026_IAO_0000004_decimal" USING("HBW_0000026_uid") -- HBW_0000026 [1..*] IAO_0000004 decimal
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000026_c" IS 'HBW_0000026::A scalar measurement datum composed of two parts: a Decimal and a weight unit label. A scalar measurement datum composed of two parts: a Decimal and a weight unit label. null a measurement unit label of a weight DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> xsd:decimal)';

-- Vue de la classe BFO_0000020
CREATE VIEW "BW_ontoView"."BFO_0000020_c" AS
  SELECT *
  FROM "BW"."BFO_0000020" 
    JOIN "BW"."BFO_0000020_RO_0000059_BFO_0000031" USING("BFO_0000020_uid") -- BFO_0000020 [1..*] RO_0000059 BFO_0000031
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000020_c" IS 'specifically dependent continuant::SpecificallyDependentContinuant SpecificallyDependentContinuant A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. GenericallyDependentContinuant';

-- Vue de la classe BFO_0000004
CREATE VIEW "BW_ontoView"."BFO_0000004_c" AS
  SELECT *
  FROM "BW"."BFO_0000004" 
    JOIN "BW"."BFO_0000004_RO_0001025_BFO_0000004" USING("BFO_0000004_uid") -- BFO_0000004 [1..*] RO_0001025 BFO_0000004
    JOIN "BW"."BFO_0000004_RO_0000087_BFO_0000023" USING("BFO_0000004_uid") -- BFO_0000004 [1..*] RO_0000087 BFO_0000023
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000004_c" IS 'independent continuant::IndependentContinuant IndependentContinuant a relation between two independent continuants, the target and the location, in which the target is entirely within the location IndependentContinuant IndependentContinuant a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence Role';

-- Vue de la classe IAO_0020015
CREATE VIEW "BW_ontoView"."IAO_0020015_p" AS
  SELECT *
  FROM "BW"."IAO_0020015" 
    JOIN "BW"."IAO_0020015_PHYSIO_0000100_string" USING("IAO_0020015_uid") -- IAO_0020015 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0020015_p" IS 'personal name::Sep 29, 2016: The comment that including the wikipedia definition of personal name is not to be interpreted in a way that restricts this class to only contain strings of letters. A numerical or alphanumerical identifier that denotes a human is being is a personal name, too. (MB) DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0020015
CREATE VIEW "BW_ontoView"."IAO_0020015_c" AS
  SELECT *
  FROM "BW"."IAO_0020015" 
    JOIN "BW"."IAO_0020015_PHYSIO_0000100_string" USING("IAO_0020015_uid") -- IAO_0020015 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0020015_c" IS 'personal name::Sep 29, 2016: The comment that including the wikipedia definition of personal name is not to be interpreted in a way that restricts this class to only contain strings of letters. A numerical or alphanumerical identifier that denotes a human is being is a personal name, too. (MB) DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000032
CREATE VIEW "BW_ontoView"."IAO_0000032_p" AS
  SELECT *
  FROM "BW"."IAO_0000032" 
    JOIN "BW"."IAO_0000032_IAO_0000004_double" USING("IAO_0000032_uid") -- IAO_0000032 [1..1] IAO_0000004 double
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000032_p" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. IAO_0000032 [1..1] IAO_0000004 double';

-- Vue de la classe IAO_0000032
CREATE VIEW "BW_ontoView"."IAO_0000032_c" AS
  SELECT *
  FROM "BW"."IAO_0000032" 
    JOIN "BW"."IAO_0000032_IAO_0000004_Literal" USING("IAO_0000032_uid") -- IAO_0000032 [1..*] IAO_0000004 Literal
    JOIN "BW"."IAO_0000032_IAO_0000039_IAO_0000003" USING("IAO_0000032_uid") -- IAO_0000032 [1..*] IAO_0000039 IAO_0000003
    JOIN "BW"."IAO_0000032_IAO_0000004_double" USING("IAO_0000032_uid") -- IAO_0000032 [1..1] IAO_0000004 double
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000032_c" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal) a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure. IAO_0000032 [1..1] IAO_0000004 double';

-- Vue de la classe HBW_0000013
CREATE VIEW "BW_ontoView"."HBW_0000013_p" AS
  SELECT *
  FROM "BW"."HBW_0000013" 
    JOIN "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008" USING("HBW_0000013_uid") -- HBW_0000013 [1..1] PHYSIO_0000089 HBW_0000008
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000013_p" IS 'physiological evaluation from health care provider::A physiological evaluation that is evaluated by a health care provider A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

-- Vue de la classe HBW_0000013
CREATE VIEW "BW_ontoView"."HBW_0000013_c" AS
  SELECT *
  FROM "BW"."HBW_0000013" 
    JOIN "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008" USING("HBW_0000013_uid") -- HBW_0000013 [1..1] PHYSIO_0000089 HBW_0000008
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000013_c" IS 'physiological evaluation from health care provider::A physiological evaluation that is evaluated by a health care provider A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

-- Vue de la classe HBW_0000001
CREATE VIEW "BW_ontoView"."HBW_0000001_c" AS
  SELECT *
  FROM "BW"."HBW_0000001" 
    JOIN "BW"."HBW_0000001_OBI_0000312_HBW_0000012" USING("HBW_0000001_uid") -- HBW_0000001 [1..*] OBI_0000312 HBW_0000012
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000001_c" IS 'physiological data item::A data item that is the specified output of some physiological evaluation. A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

-- Vue de la classe IAO_0000109
CREATE VIEW "BW_ontoView"."IAO_0000109_p" AS
  SELECT *
  FROM "BW"."IAO_0000109" 
    JOIN "BW"."IAO_0000109_IAO_0000039_IAO_0000003" USING("IAO_0000109_uid") -- IAO_0000109 [1..1] IAO_0000039 IAO_0000003
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000109_p" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

-- Vue de la classe IAO_0000109
CREATE VIEW "BW_ontoView"."IAO_0000109_c" AS
  SELECT *
  FROM "BW"."IAO_0000109" 
    JOIN "BW"."IAO_0000109_IAO_0000039_IAO_0000003" USING("IAO_0000109_uid") -- IAO_0000109 [1..1] IAO_0000039 IAO_0000003
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000109_c" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

-- Vue de la classe HBW_0000005
CREATE VIEW "BW_ontoView"."HBW_0000005_p" AS
  SELECT *
  FROM "BW"."HBW_0000005" 
    JOIN "BW"."HBW_0000005_BFO_0000051_HBW_0000006" USING("HBW_0000005_uid") -- HBW_0000005 [1..1] BFO_0000051 HBW_0000006
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000005_p" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

-- Vue de la classe HBW_0000005
CREATE VIEW "BW_ontoView"."HBW_0000005_c" AS
  SELECT *
  FROM "BW"."HBW_0000005" 
    JOIN "BW"."HBW_0000005_BFO_0000051_HBW_0000001" USING("HBW_0000005_uid") -- HBW_0000005 [1..*] BFO_0000051 HBW_0000001
    JOIN "BW"."HBW_0000005_BFO_0000051_HBW_0000006" USING("HBW_0000005_uid") -- HBW_0000005 [1..1] BFO_0000051 HBW_0000006
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000005_c" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

-- Vue de la classe ONTORELA_C61c354fb
CREATE VIEW "BW_ontoView"."ONTORELA_C61c354fb_c" AS
  SELECT *
  FROM "BW"."ONTORELA_C61c354fb" 
    JOIN "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" USING("ONTORELA_C61c354fb_uid") -- ONTORELA_C61c354fb [1..*] IAO_0000136 ONTORELA_C2986e108
;

COMMENT ON VIEW "BW_ontoView"."ONTORELA_C61c354fb_c" IS 'data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))::physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. is_about is a (currently) primitive relation that relates an information artifact to an entity. data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe BFO_0000017
CREATE VIEW "BW_ontoView"."BFO_0000017_c" AS
  SELECT *
  FROM "BW"."BFO_0000017" 
    JOIN "BW"."BFO_0000017_BFO_0000054_BFO_0000015" USING("BFO_0000017_uid") -- BFO_0000017 [1..*] BFO_0000054 BFO_0000015
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000017_c" IS 'realizable entity::RealizableEntity RealizableEntity Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process Process';

-- Vue de la classe BFO_0000001
CREATE VIEW "BW_ontoView"."BFO_0000001_c" AS
  SELECT *
  FROM "BW"."BFO_0000001" 
    JOIN "BW"."BFO_0000001_BFO_0000050_BFO_0000001" USING("BFO_0000001_uid") -- BFO_0000001 [1..*] BFO_0000050 BFO_0000001
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000001_c" IS 'entity::Entity Entity a core relation that holds between a part and its whole Entity';

-- Vue de la classe IAO_0000003
CREATE VIEW "BW_ontoView"."IAO_0000003_p" AS
  SELECT *
  FROM "BW"."IAO_0000003" 
    JOIN "BW"."IAO_0000003_PHYSIO_0000100_string" USING("IAO_0000003_uid") -- IAO_0000003 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000003_p" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000003
CREATE VIEW "BW_ontoView"."IAO_0000003_c" AS
  SELECT *
  FROM "BW"."IAO_0000003" 
    JOIN "BW"."IAO_0000003_PHYSIO_0000100_string" USING("IAO_0000003_uid") -- IAO_0000003 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000003_c" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe HBW_0000012
CREATE VIEW "BW_ontoView"."HBW_0000012_p" AS
  SELECT *
  FROM "BW"."HBW_0000012" 
    JOIN "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" USING("HBW_0000012_uid") -- HBW_0000012 [1..1] PHYSIO_0000089 NCBITaxon_9606
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000012_p" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

-- Vue de la classe HBW_0000012
CREATE VIEW "BW_ontoView"."HBW_0000012_c" AS
  SELECT *
  FROM "BW"."HBW_0000012" 
    JOIN "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" USING("HBW_0000012_uid") -- HBW_0000012 [1..*] OBI_0000299 ONTORELA_C61c354fb
    JOIN "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" USING("HBW_0000012_uid") -- HBW_0000012 [1..1] PHYSIO_0000089 NCBITaxon_9606
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000012_c" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

-- Vue de la classe ONTORELA_C4d0c3f45
CREATE VIEW "BW_ontoView"."ONTORELA_C4d0c3f45_c" AS
  SELECT *
  FROM "BW"."ONTORELA_C4d0c3f45" 
    JOIN "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" USING("ONTORELA_C4d0c3f45_uid") -- ONTORELA_C4d0c3f45 [1..*] IAO_0000136 HBW_0000007
;

COMMENT ON VIEW "BW_ontoView"."ONTORELA_C4d0c3f45_c" IS 'health care record
 and (is about some patient)::medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient. medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

-- Vue de la classe IAO_0020000
CREATE VIEW "BW_ontoView"."IAO_0020000_c" AS
  SELECT *
  FROM "BW"."IAO_0020000" 
    JOIN "BW"."IAO_0020000_IAO_0000219_BFO_0000001" USING("IAO_0020000_uid") -- IAO_0020000 [1..*] IAO_0000219 BFO_0000001
;

COMMENT ON VIEW "BW_ontoView"."IAO_0020000_c" IS 'identifier::An information content entity that is the outcome of a dubbing process and is used to refer to one instance of entity shared by a group of people to refer to that individual entity. An information content entity that is the outcome of a dubbing process and is used to refer to one instance of entity shared by a group of people to refer to that individual entity. null Entity';

-- Vue de la classe HBW_0000004
CREATE VIEW "BW_ontoView"."HBW_0000004_c" AS
  SELECT *
  FROM "BW"."HBW_0000004" 
    JOIN "BW"."HBW_0000004_IAO_0000136_OBI_0100026" USING("HBW_0000004_uid") -- HBW_0000004 [1..*] IAO_0000136 OBI_0100026
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000004_c" IS 'health care record::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe HBW_0000008
CREATE VIEW "BW_ontoView"."HBW_0000008_c" AS
  SELECT *
  FROM "BW"."HBW_0000008" 
    JOIN "BW"."HBW_0000008_RO_0000087_HBW_0000010" USING("HBW_0000008_uid") -- HBW_0000008 [1..*] RO_0000087 HBW_0000010
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000008_c" IS 'health care provider::A homo sapiens having with the health care provider role A homo sapiens having with the health care provider role a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

-- Vue de la classe BFO_0000002
CREATE VIEW "BW_ontoView"."BFO_0000002_c" AS
  SELECT *
  FROM "BW"."BFO_0000002" 
    JOIN "BW"."BFO_0000002_RO_0000056_BFO_0000003" USING("BFO_0000002_uid") -- BFO_0000002 [1..*] RO_0000056 BFO_0000003
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000002_c" IS 'continuant::Continuant Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process per discussion with Barry Smith';

-- Vue de la classe IAO_0020017
CREATE VIEW "BW_ontoView"."IAO_0020017_p" AS
  SELECT *
  FROM "BW"."IAO_0020017" 
    JOIN "BW"."IAO_0020017_PHYSIO_0000100_string" USING("IAO_0020017_uid") -- IAO_0020017 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0020017_p" IS 'family name::An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0020017
CREATE VIEW "BW_ontoView"."IAO_0020017_c" AS
  SELECT *
  FROM "BW"."IAO_0020017" 
    JOIN "BW"."IAO_0020017_PHYSIO_0000100_string" USING("IAO_0020017_uid") -- IAO_0020017 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0020017_c" IS 'family name::An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000030
CREATE VIEW "BW_ontoView"."IAO_0000030_c" AS
  SELECT *
  FROM "BW"."IAO_0000030" 
    JOIN "BW"."IAO_0000030_IAO_0000219_BFO_0000001" USING("IAO_0000030_uid") -- IAO_0000030 [1..*] IAO_0000219 BFO_0000001
    JOIN "BW"."IAO_0000030_IAO_0000136_BFO_0000001" USING("IAO_0000030_uid") -- IAO_0000030 [1..*] IAO_0000136 BFO_0000001
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000030_c" IS 'information content entity::An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity null Entity An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity is_about is a (currently) primitive relation that relates an information artifact to an entity. Entity';

-- Vue de la classe IAO_0000577
CREATE VIEW "BW_ontoView"."IAO_0000577_p" AS
  SELECT *
  FROM "BW"."IAO_0000577" 
    JOIN "BW"."IAO_0000577_PHYSIO_0000100_string" USING("IAO_0000577_uid") -- IAO_0000577 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000577_p" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000577
CREATE VIEW "BW_ontoView"."IAO_0000577_c" AS
  SELECT *
  FROM "BW"."IAO_0000577" 
    JOIN "BW"."IAO_0000577_PHYSIO_0000100_string" USING("IAO_0000577_uid") -- IAO_0000577 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000577_c" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe NOYO_0000050
CREATE VIEW "BW_ontoView"."NOYO_0000050_c" AS
  SELECT *
  FROM "BW"."NOYO_0000050" 
    JOIN "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606" USING("NOYO_0000050_uid") -- NOYO_0000050 [1..*] IAO_0000136 NCBITaxon_9606
;

COMMENT ON VIEW "BW_ontoView"."NOYO_0000050_c" IS 'birth statement::A statement about the information surrounding the birth of a human. A statement about the information surrounding the birth of a human. is_about is a (currently) primitive relation that relates an information artifact to an entity. Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

-- Vue de la classe BFO_0000031
CREATE VIEW "BW_ontoView"."BFO_0000031_c" AS
  SELECT *
  FROM "BW"."BFO_0000031" 
    JOIN "BW"."BFO_0000031_RO_0000058_BFO_0000020" USING("BFO_0000031_uid") -- BFO_0000031 [1..*] RO_0000058 BFO_0000020
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000031_c" IS 'gdc::GenericallyDependentContinuant GenericallyDependentContinuant A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. SpecificallyDependentContinuant';

-- Vue de la classe HBW_0000007
CREATE VIEW "BW_ontoView"."HBW_0000007_c" AS
  SELECT *
  FROM "BW"."HBW_0000007" 
    JOIN "BW"."HBW_0000007_RO_0000087_HBW_0000011" USING("HBW_0000007_uid") -- HBW_0000007 [1..*] RO_0000087 HBW_0000011
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000007_c" IS 'patient::An organism having the role of patient. An organism having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

-- Vue de la classe BFO_0000015
CREATE VIEW "BW_ontoView"."BFO_0000015_c" AS
  SELECT *
  FROM "BW"."BFO_0000015" 
    JOIN "BW"."BFO_0000015_BFO_0000055_BFO_0000017" USING("BFO_0000015_uid") -- BFO_0000015 [1..*] BFO_0000055 BFO_0000017
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000015_c" IS 'process::Process Process Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process RealizableEntity';

-- Vue de la classe ONTORELA_C2986e108
CREATE VIEW "BW_ontoView"."ONTORELA_C2986e108_c" AS
  SELECT *
  FROM "BW"."ONTORELA_C2986e108" 
    JOIN "BW"."ONTORELA_C2986e108_RO_0000052_OBI_0100026" USING("ONTORELA_C2986e108_uid") -- ONTORELA_C2986e108 [1..*] RO_0000052 OBI_0100026
;

COMMENT ON VIEW "BW_ontoView"."ONTORELA_C2986e108_c" IS '(disposition or quality)
 and (inheres in some organism)::data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe BFO_0000003
CREATE VIEW "BW_ontoView"."BFO_0000003_c" AS
  SELECT *
  FROM "BW"."BFO_0000003" 
    JOIN "BW"."BFO_0000003_RO_0000057_BFO_0000002" USING("BFO_0000003_uid") -- BFO_0000003 [1..*] RO_0000057 BFO_0000002
    JOIN "BW"."BFO_0000003_BFO_0000066_BFO_0000004" USING("BFO_0000003_uid") -- BFO_0000003 [1..*] BFO_0000066 BFO_0000004
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000003_c" IS 'occurrent::per discussion with Barry Smith per discussion with Barry Smith a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant per discussion with Barry Smith b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t IndependentContinuant';


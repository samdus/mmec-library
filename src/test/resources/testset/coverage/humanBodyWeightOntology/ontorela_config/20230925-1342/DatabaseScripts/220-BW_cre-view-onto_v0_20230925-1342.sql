/*
-- =========================================================================== A
Schema : BW_ontoView
Creation Date : 20230925-1342
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

COMMENT ON SCHEMA "BW_ontoView" IS 'Create views with short IRI of BW_ontoView 20230925-1342';

-- Vue de la classe IAO_0000003
CREATE VIEW "BW_ontoView"."IAO_0000003_p" AS
  SELECT *
  FROM "BW"."T0003" 
    JOIN "BW"."T0027" USING("T0003_uid") -- IAO_0000003 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000003_p" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000003
CREATE VIEW "BW_ontoView"."IAO_0000003_c" AS
  SELECT *
  FROM "BW"."T0003" 
    JOIN "BW"."T0027" USING("T0003_uid") -- IAO_0000003 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000003_c" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe PHYSIO_0000065
CREATE VIEW "BW_ontoView"."PHYSIO_0000065_c" AS
  SELECT *
  FROM "BW"."T0004" 
    JOIN "BW"."T002a" USING("T0004_uid") -- PHYSIO_0000065 [1..*] OBI_0000312 PHYSIO_0000008
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000065_c" IS 'human body mass measurement datum::A scalar measurement datum that is a measurement of the mass of a human body. A scalar measurement datum that is a measurement of the mass of a human body. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A physiological evaluation that evaluates an organism''s body weight.';

-- Vue de la classe PHYSIO_0000083
CREATE VIEW "BW_ontoView"."PHYSIO_0000083_p" AS
  SELECT *
  FROM "BW"."T0006" 
    JOIN "BW"."T002c" USING("T0006_uid") -- PHYSIO_0000083 [1..1] BFO_0000051 HADO_0000006
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000083_p" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

-- Vue de la classe PHYSIO_0000083
CREATE VIEW "BW_ontoView"."PHYSIO_0000083_c" AS
  SELECT *
  FROM "BW"."T0006" 
    JOIN "BW"."T002c" USING("T0006_uid") -- PHYSIO_0000083 [1..1] BFO_0000051 HADO_0000006
    JOIN "BW"."T002b" USING("T0006_uid") -- PHYSIO_0000083 [1..*] BFO_0000051 PHYSIO_0000093
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000083_c" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation.';

-- Vue de la classe BFO_0000015
CREATE VIEW "BW_ontoView"."BFO_0000015_c" AS
  SELECT *
  FROM "BW"."T0007" 
    JOIN "BW"."T002d" USING("T0007_uid") -- BFO_0000015 [1..*] BFO_0000055 BFO_0000017
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000015_c" IS 'process::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process RealizableEntity';

-- Vue de la classe HADO_0000008
CREATE VIEW "BW_ontoView"."HADO_0000008_c" AS
  SELECT *
  FROM "BW"."T0008" 
    JOIN "BW"."T002e" USING("T0008_uid") -- HADO_0000008 [1..*] RO_0000087 OBI_0000093
;

COMMENT ON VIEW "BW_ontoView"."HADO_0000008_c" IS 'patient::Homo sapiens having the role of patient. Homo sapiens having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

-- Vue de la classe PHYSIO_0000090
CREATE VIEW "BW_ontoView"."PHYSIO_0000090_p" AS
  SELECT *
  FROM "BW"."T0009" 
    JOIN "BW"."T002f" USING("T0009_uid") -- PHYSIO_0000090 [1..1] PHYSIO_0000089 NCBITaxon_9606
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000090_p" IS 'physiological evaluation of human::A physiological evaluation that evaluates a human''s body weight. A physiological evaluation that evaluates a human''s body weight. A has participant property in a evaluation process Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

-- Vue de la classe PHYSIO_0000090
CREATE VIEW "BW_ontoView"."PHYSIO_0000090_c" AS
  SELECT *
  FROM "BW"."T0009" 
    JOIN "BW"."T002f" USING("T0009_uid") -- PHYSIO_0000090 [1..1] PHYSIO_0000089 NCBITaxon_9606
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000090_c" IS 'physiological evaluation of human::A physiological evaluation that evaluates a human''s body weight. A physiological evaluation that evaluates a human''s body weight. A has participant property in a evaluation process Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

-- Vue de la classe BFO_0000017
CREATE VIEW "BW_ontoView"."BFO_0000017_c" AS
  SELECT *
  FROM "BW"."T000a" 
    JOIN "BW"."T0030" USING("T000a_uid") -- BFO_0000017 [1..*] BFO_0000054 BFO_0000015
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000017_c" IS 'realizable entity::RealizableEntity RealizableEntity Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

-- Vue de la classe HADO_0000006
CREATE VIEW "BW_ontoView"."HADO_0000006_p" AS
  SELECT *
  FROM "BW"."T000b" 
    JOIN "BW"."T0031" USING("T000b_uid") -- HADO_0000006 [1..1] IAO_0000219 ONTORELA_C0025X
;

COMMENT ON VIEW "BW_ontoView"."HADO_0000006_p" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry. A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

-- Vue de la classe HADO_0000006
CREATE VIEW "BW_ontoView"."HADO_0000006_c" AS
  SELECT *
  FROM "BW"."T000b" 
    JOIN "BW"."T0031" USING("T000b_uid") -- HADO_0000006 [1..1] IAO_0000219 ONTORELA_C0025X
;

COMMENT ON VIEW "BW_ontoView"."HADO_0000006_c" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry. A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

-- Vue de la classe ONTORELA_C0025X
CREATE VIEW "BW_ontoView"."ONTORELA_C0025X_c" AS
  SELECT *
  FROM "BW"."T000c" 
    JOIN "BW"."T0032" USING("T000c_uid") -- ONTORELA_C0025X [1..*] IAO_0000136 HADO_0000008
;

COMMENT ON VIEW "BW_ontoView"."ONTORELA_C0025X_c" IS 'medical record identifier intersectionOf health care record | is about | patient::medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient. medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

-- Vue de la classe BFO_0000031
CREATE VIEW "BW_ontoView"."BFO_0000031_c" AS
  SELECT *
  FROM "BW"."T000e" 
    JOIN "BW"."T0033" USING("T000e_uid") -- BFO_0000031 [1..*] RO_0000058 BFO_0000020
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000031_c" IS 'gdc::b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001]) b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001]) A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])';

-- Vue de la classe BFO_0000001
CREATE VIEW "BW_ontoView"."BFO_0000001_c" AS
  SELECT *
  FROM "BW"."T0010" 
    JOIN "BW"."T0034" USING("T0010_uid") -- BFO_0000001 [1..*] BFO_0000050 BFO_0000001
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000001_c" IS 'entity::Entity Entity 
a core relation that holds between a part and its whole
 Entity';

-- Vue de la classe BFO_0000003
CREATE VIEW "BW_ontoView"."BFO_0000003_c" AS
  SELECT *
  FROM "BW"."T0012" 
    JOIN "BW"."T0036" USING("T0012_uid") -- BFO_0000003 [1..*] RO_0000057 BFO_0000002
    JOIN "BW"."T0035" USING("T0012_uid") -- BFO_0000003 [1..*] BFO_0000066 BFO_0000004
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000003_c" IS 'occurrent::Occurrent Occurrent a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant Occurrent b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t IndependentContinuant';

-- Vue de la classe IAO_0000577
CREATE VIEW "BW_ontoView"."IAO_0000577_p" AS
  SELECT *
  FROM "BW"."T0015" 
    JOIN "BW"."T0029" USING("T0015_uid") -- IAO_0000577 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000577_p" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000577
CREATE VIEW "BW_ontoView"."IAO_0000577_c" AS
  SELECT *
  FROM "BW"."T0015" 
    JOIN "BW"."T0029" USING("T0015_uid") -- IAO_0000577 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000577_c" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000109
CREATE VIEW "BW_ontoView"."IAO_0000109_p" AS
  SELECT *
  FROM "BW"."T0017" 
    JOIN "BW"."T0037" USING("T0017_uid") -- IAO_0000109 [1..1] IAO_0000039 IAO_0000003
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000109_p" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

-- Vue de la classe IAO_0000109
CREATE VIEW "BW_ontoView"."IAO_0000109_c" AS
  SELECT *
  FROM "BW"."T0017" 
    JOIN "BW"."T0038" USING("T0017_uid") -- IAO_0000109 [1..*] OBI_0001938 OBI_0001933
    JOIN "BW"."T0037" USING("T0017_uid") -- IAO_0000109 [1..1] IAO_0000039 IAO_0000003
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000109_c" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null An information content entity that specifies a value within a classification scheme or on a quantitative scale. A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

-- Vue de la classe PHYSIO_0000094
CREATE VIEW "BW_ontoView"."PHYSIO_0000094_c" AS
  SELECT *
  FROM "BW"."T0018" 
    JOIN "BW"."T0039" USING("T0018_uid") -- PHYSIO_0000094 [1..*] IAO_0000136 OBI_0100026
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000094_c" IS 'health care record::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe BFO_0000004
CREATE VIEW "BW_ontoView"."BFO_0000004_c" AS
  SELECT *
  FROM "BW"."T0019" 
    JOIN "BW"."T003a" USING("T0019_uid") -- BFO_0000004 [1..*] RO_0000087 BFO_0000023
    JOIN "BW"."T003b" USING("T0019_uid") -- BFO_0000004 [1..*] RO_0001025 BFO_0000004
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000004_c" IS 'independent continuant::IndependentContinuant IndependentContinuant a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed. IndependentContinuant a relation between two independent continuants, the target and the location, in which the target is entirely within the location IndependentContinuant';

-- Vue de la classe PHYSIO_0000091
CREATE VIEW "BW_ontoView"."PHYSIO_0000091_p" AS
  SELECT *
  FROM "BW"."T001a" 
    JOIN "BW"."T003c" USING("T001a_uid") -- PHYSIO_0000091 [1..1] PHYSIO_0000089 HADO_0000008
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000091_p" IS 'physiological evaluation of patient::A physiological evaluation that evaluates a patient''s body weight. A physiological evaluation that evaluates a patient''s body weight. A has participant property in a evaluation process Homo sapiens having the role of patient.';

-- Vue de la classe PHYSIO_0000091
CREATE VIEW "BW_ontoView"."PHYSIO_0000091_c" AS
  SELECT *
  FROM "BW"."T001a" 
    JOIN "BW"."T003c" USING("T001a_uid") -- PHYSIO_0000091 [1..1] PHYSIO_0000089 HADO_0000008
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000091_c" IS 'physiological evaluation of patient::A physiological evaluation that evaluates a patient''s body weight. A physiological evaluation that evaluates a patient''s body weight. A has participant property in a evaluation process Homo sapiens having the role of patient.';

-- Vue de la classe PHYSIO_0000085
CREATE VIEW "BW_ontoView"."PHYSIO_0000085_p" AS
  SELECT *
  FROM "BW"."T001e" 
    JOIN "BW"."T003d" USING("T001e_uid") -- PHYSIO_0000085 [1..1] PHYSIO_0000089 OBI_0100026
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000085_p" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe PHYSIO_0000085
CREATE VIEW "BW_ontoView"."PHYSIO_0000085_c" AS
  SELECT *
  FROM "BW"."T001e" 
    JOIN "BW"."T003d" USING("T001e_uid") -- PHYSIO_0000085 [1..1] PHYSIO_0000089 OBI_0100026
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000085_c" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe PHYSIO_0000093
CREATE VIEW "BW_ontoView"."PHYSIO_0000093_c" AS
  SELECT *
  FROM "BW"."T001f" 
    JOIN "BW"."T003e" USING("T001f_uid") -- PHYSIO_0000093 [1..*] OBI_0000312 PHYSIO_0000085
;

COMMENT ON VIEW "BW_ontoView"."PHYSIO_0000093_c" IS 'physiological data item::A data item that is the specified output of some physiological evaluation. A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

-- Vue de la classe OBI_0000093
CREATE VIEW "BW_ontoView"."OBI_0000093_c" AS
  SELECT *
  FROM "BW"."T0020" 
    JOIN "BW"."T003f" USING("T0020_uid") -- OBI_0000093 [1..*] RO_0000052 NCBITaxon_9606
;

COMMENT ON VIEW "BW_ontoView"."OBI_0000093_c" IS 'patient role::a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

-- Vue de la classe IAO_0000030
CREATE VIEW "BW_ontoView"."IAO_0000030_c" AS
  SELECT *
  FROM "BW"."T0022" 
    JOIN "BW"."T0040" USING("T0022_uid") -- IAO_0000030 [1..*] IAO_0000136 BFO_0000001
    JOIN "BW"."T0041" USING("T0022_uid") -- IAO_0000030 [1..*] IAO_0000219 BFO_0000001
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000030_c" IS 'information content entity::An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity is_about is a (currently) primitive relation that relates an information artifact to an entity. Entity An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity null Entity';

-- Vue de la classe BFO_0000020
CREATE VIEW "BW_ontoView"."BFO_0000020_c" AS
  SELECT *
  FROM "BW"."T0023" 
    JOIN "BW"."T0042" USING("T0023_uid") -- BFO_0000020 [1..*] RO_0000059 BFO_0000031
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000020_c" IS 'sdc::b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003]) b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003]) A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001])';

-- Vue de la classe IAO_0000032
CREATE VIEW "BW_ontoView"."IAO_0000032_p" AS
  SELECT *
  FROM "BW"."T0024" 
    JOIN "BW"."T0026" USING("T0024_uid") -- IAO_0000032 [1..1] IAO_0000004 double
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000032_p" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. IAO_0000032 [1..1] IAO_0000004 double';

-- Vue de la classe IAO_0000032
CREATE VIEW "BW_ontoView"."IAO_0000032_c" AS
  SELECT *
  FROM "BW"."T0024" 
    JOIN "BW"."T0026" USING("T0024_uid") -- IAO_0000032 [1..1] IAO_0000004 double
    JOIN "BW"."T0028" USING("T0024_uid") -- IAO_0000032 [1..*] IAO_0000004 Literal
    JOIN "BW"."T0044" USING("T0024_uid") -- IAO_0000032 [1..*] OBI_0001938 OBI_0001931
    JOIN "BW"."T0043" USING("T0024_uid") -- IAO_0000032 [1..*] IAO_0000039 Thing
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000032_c" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. IAO_0000032 [1..1] IAO_0000004 double DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal) a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A value specification that consists of two parts: a numeral and a unit label a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null The class owl:Thing is the class of all individuals.';

-- Vue de la classe BFO_0000002
CREATE VIEW "BW_ontoView"."BFO_0000002_c" AS
  SELECT *
  FROM "BW"."T0025" 
    JOIN "BW"."T0045" USING("T0025_uid") -- BFO_0000002 [1..*] RO_0000056 BFO_0000003
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000002_c" IS 'continuant::Continuant Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process Occurrent';


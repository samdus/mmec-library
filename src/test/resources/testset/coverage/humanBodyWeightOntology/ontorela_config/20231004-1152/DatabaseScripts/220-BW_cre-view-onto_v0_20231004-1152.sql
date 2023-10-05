/*
-- =========================================================================== A
Schema : BW_ontoView
Creation Date : 20231004-1152
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

COMMENT ON SCHEMA "BW_ontoView" IS 'Create views with short IRI of BW_ontoView 20231004-1152';

-- Vue de la classe IAO_0000032
CREATE VIEW "BW_ontoView"."IAO_0000032_p" AS
  SELECT *
  FROM "BW"."T0001" 
    JOIN "BW"."T002e" USING("T0001_uid") -- IAO_0000032 [1..1] IAO_0000004 double
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000032_p" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. IAO_0000032 [1..1] IAO_0000004 double';

-- Vue de la classe IAO_0000032
CREATE VIEW "BW_ontoView"."IAO_0000032_c" AS
  SELECT *
  FROM "BW"."T0001" 
    JOIN "BW"."T0033" USING("T0001_uid") -- IAO_0000032 [1..*] IAO_0000039 Thing
    JOIN "BW"."T0032" USING("T0001_uid") -- IAO_0000032 [1..*] OBI_0001938 OBI_0001931
    JOIN "BW"."T002f" USING("T0001_uid") -- IAO_0000032 [1..*] IAO_0000004 Literal
    JOIN "BW"."T002e" USING("T0001_uid") -- IAO_0000032 [1..1] IAO_0000004 double
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000032_c" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null The class owl:Thing is the class of all individuals. a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A value specification that consists of two parts: a numeral and a unit label DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal) IAO_0000032 [1..1] IAO_0000004 double';

-- Vue de la classe BFO_0000020
CREATE VIEW "BW_ontoView"."BFO_0000020_c" AS
  SELECT *
  FROM "BW"."T0003" 
    JOIN "BW"."T0034" USING("T0003_uid") -- BFO_0000020 [1..*] RO_0000059 BFO_0000031
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000020_c" IS 'sdc::SpecificallyDependentContinuant SpecificallyDependentContinuant A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

-- Vue de la classe IAO_0000030
CREATE VIEW "BW_ontoView"."IAO_0000030_c" AS
  SELECT *
  FROM "BW"."T0004" 
    JOIN "BW"."T0036" USING("T0004_uid") -- IAO_0000030 [1..*] IAO_0000219 BFO_0000001
    JOIN "BW"."T0035" USING("T0004_uid") -- IAO_0000030 [1..*] IAO_0000136 BFO_0000001
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000030_c" IS 'information content entity::A generically dependent continuant that is about some thing. A generically dependent continuant that is about some thing. null A thing that exists or has existed or will exist. A generically dependent continuant that is about some thing. is_about is a (currently) primitive relation that relates an information artifact to an entity. A thing that exists or has existed or will exist.';

-- Vue de la classe BFO_0000004
CREATE VIEW "BW_ontoView"."BFO_0000004_c" AS
  SELECT *
  FROM "BW"."T0007" 
    JOIN "BW"."T0037" USING("T0007_uid") -- BFO_0000004 [1..*] RO_0000087 BFO_0000023
    JOIN "BW"."T0038" USING("T0007_uid") -- BFO_0000004 [1..*] RO_0001025 BFO_0000004
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000004_c" IS 'ic::b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed. b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) a relation between two independent continuants, the target and the location, in which the target is entirely within the location b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

-- Vue de la classe BFO_0000002
CREATE VIEW "BW_ontoView"."BFO_0000002_c" AS
  SELECT *
  FROM "BW"."T0008" 
    JOIN "BW"."T0039" USING("T0008_uid") -- BFO_0000002 [1..*] RO_0000056 BFO_0000003
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000002_c" IS 'continuant::Continuant Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process 
An entity that has temporal parts and that happens, unfolds or develops through time.
';

-- Vue de la classe HBW_0000004
CREATE VIEW "BW_ontoView"."HBW_0000004_c" AS
  SELECT *
  FROM "BW"."T000a" 
    JOIN "BW"."T003a" USING("T000a_uid") -- HBW_0000004 [1..*] IAO_0000136 OBI_0100026
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000004_c" IS 'health care record::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe HBW_0000006
CREATE VIEW "BW_ontoView"."HBW_0000006_p" AS
  SELECT *
  FROM "BW"."T000b" 
    JOIN "BW"."T003b" USING("T000b_uid") -- HBW_0000006 [1..1] IAO_0000219 ONTORELA_C002aX
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000006_p" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry. A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

-- Vue de la classe HBW_0000006
CREATE VIEW "BW_ontoView"."HBW_0000006_c" AS
  SELECT *
  FROM "BW"."T000b" 
    JOIN "BW"."T003b" USING("T000b_uid") -- HBW_0000006 [1..1] IAO_0000219 ONTORELA_C002aX
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000006_c" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry. A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

-- Vue de la classe HBW_0000008
CREATE VIEW "BW_ontoView"."HBW_0000008_c" AS
  SELECT *
  FROM "BW"."T000d" 
    JOIN "BW"."T003c" USING("T000d_uid") -- HBW_0000008 [1..*] RO_0000087 HBW_0000010
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000008_c" IS 'health care provider::A homo sapiens having with the health care provider role A homo sapiens having with the health care provider role a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

-- Vue de la classe ONTORELA_C002aX
CREATE VIEW "BW_ontoView"."ONTORELA_C002aX_c" AS
  SELECT *
  FROM "BW"."T000f" 
    JOIN "BW"."T003d" USING("T000f_uid") -- ONTORELA_C002aX [1..*] IAO_0000136 HBW_0000007
;

COMMENT ON VIEW "BW_ontoView"."ONTORELA_C002aX_c" IS 'medical record identifier intersectionOf health care record | is about | patient::medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient. medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

-- Vue de la classe IAO_0000003
CREATE VIEW "BW_ontoView"."IAO_0000003_p" AS
  SELECT *
  FROM "BW"."T0011" 
    JOIN "BW"."T0030" USING("T0011_uid") -- IAO_0000003 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000003_p" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000003
CREATE VIEW "BW_ontoView"."IAO_0000003_c" AS
  SELECT *
  FROM "BW"."T0011" 
    JOIN "BW"."T0030" USING("T0011_uid") -- IAO_0000003 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000003_c" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe ONTORELA_C002cX
CREATE VIEW "BW_ontoView"."ONTORELA_C002cX_c" AS
  SELECT *
  FROM "BW"."T0012" 
    JOIN "BW"."T003e" USING("T0012_uid") -- ONTORELA_C002cX [1..*] IAO_0000136 ONTORELA_C002eX
;

COMMENT ON VIEW "BW_ontoView"."ONTORELA_C002cX_c" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. is_about is a (currently) primitive relation that relates an information artifact to an entity. physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe HBW_0000012
CREATE VIEW "BW_ontoView"."HBW_0000012_p" AS
  SELECT *
  FROM "BW"."T0014" 
    JOIN "BW"."T0040" USING("T0014_uid") -- HBW_0000012 [1..1] PHYSIO_0000089 NCBITaxon_9606
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000012_p" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

-- Vue de la classe HBW_0000012
CREATE VIEW "BW_ontoView"."HBW_0000012_c" AS
  SELECT *
  FROM "BW"."T0014" 
    JOIN "BW"."T0040" USING("T0014_uid") -- HBW_0000012 [1..1] PHYSIO_0000089 NCBITaxon_9606
    JOIN "BW"."T003f" USING("T0014_uid") -- HBW_0000012 [1..*] OBI_0000299 ONTORELA_C002cX
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000012_c" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe BFO_0000017
CREATE VIEW "BW_ontoView"."BFO_0000017_c" AS
  SELECT *
  FROM "BW"."T0018" 
    JOIN "BW"."T0041" USING("T0018_uid") -- BFO_0000017 [1..*] BFO_0000054 BFO_0000015
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000017_c" IS 'realizable::RealizableEntity RealizableEntity Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

-- Vue de la classe BFO_0000001
CREATE VIEW "BW_ontoView"."BFO_0000001_c" AS
  SELECT *
  FROM "BW"."T0019" 
    JOIN "BW"."T0042" USING("T0019_uid") -- BFO_0000001 [1..*] BFO_0000050 BFO_0000001
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000001_c" IS 'entity::A thing that exists or has existed or will exist. A thing that exists or has existed or will exist. 
a core relation that holds between a part and its whole
 A thing that exists or has existed or will exist.';

-- Vue de la classe BFO_0000031
CREATE VIEW "BW_ontoView"."BFO_0000031_c" AS
  SELECT *
  FROM "BW"."T001d" 
    JOIN "BW"."T0043" USING("T001d_uid") -- BFO_0000031 [1..*] RO_0000058 BFO_0000020
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000031_c" IS 'gdc::A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time. A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time. A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. SpecificallyDependentContinuant';

-- Vue de la classe BFO_0000015
CREATE VIEW "BW_ontoView"."BFO_0000015_c" AS
  SELECT *
  FROM "BW"."T001e" 
    JOIN "BW"."T0044" USING("T001e_uid") -- BFO_0000015 [1..*] BFO_0000055 BFO_0000017
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000015_c" IS 'process::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process RealizableEntity';

-- Vue de la classe BFO_0000003
CREATE VIEW "BW_ontoView"."BFO_0000003_c" AS
  SELECT *
  FROM "BW"."T001f" 
    JOIN "BW"."T0045" USING("T001f_uid") -- BFO_0000003 [1..*] BFO_0000066 BFO_0000004
    JOIN "BW"."T0046" USING("T001f_uid") -- BFO_0000003 [1..*] RO_0000057 BFO_0000002
;

COMMENT ON VIEW "BW_ontoView"."BFO_0000003_c" IS 'occurrent::
An entity that has temporal parts and that happens, unfolds or develops through time.
 
An entity that has temporal parts and that happens, unfolds or develops through time.
 b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) 
An entity that has temporal parts and that happens, unfolds or develops through time.
 a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant';

-- Vue de la classe HBW_0000005
CREATE VIEW "BW_ontoView"."HBW_0000005_p" AS
  SELECT *
  FROM "BW"."T0020" 
    JOIN "BW"."T0048" USING("T0020_uid") -- HBW_0000005 [1..1] BFO_0000051 HBW_0000006
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000005_p" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

-- Vue de la classe HBW_0000005
CREATE VIEW "BW_ontoView"."HBW_0000005_c" AS
  SELECT *
  FROM "BW"."T0020" 
    JOIN "BW"."T0047" USING("T0020_uid") -- HBW_0000005 [1..*] BFO_0000051 HBW_0000001
    JOIN "BW"."T0048" USING("T0020_uid") -- HBW_0000005 [1..1] BFO_0000051 HBW_0000006
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000005_c" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation. A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

-- Vue de la classe ONTORELA_C002eX-el0
CREATE VIEW "BW_ontoView"."ONTORELA_C002eX-el0_c" AS
  SELECT *
  FROM "BW"."T0021" 
    JOIN "BW"."T0049" USING("T0021_uid") -- ONTORELA_C002eX-el0 [1..*] RO_0000052 OBI_0100026
;

COMMENT ON VIEW "BW_ontoView"."ONTORELA_C002eX-el0_c" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality::physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

-- Vue de la classe HBW_0000007
CREATE VIEW "BW_ontoView"."HBW_0000007_c" AS
  SELECT *
  FROM "BW"."T0022" 
    JOIN "BW"."T004a" USING("T0022_uid") -- HBW_0000007 [1..*] RO_0000087 HBW_0000011
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000007_c" IS 'patient::An organism having the role of patient. An organism having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

-- Vue de la classe IAO_0000577
CREATE VIEW "BW_ontoView"."IAO_0000577_p" AS
  SELECT *
  FROM "BW"."T0025" 
    JOIN "BW"."T0031" USING("T0025_uid") -- IAO_0000577 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000577_p" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe IAO_0000577
CREATE VIEW "BW_ontoView"."IAO_0000577_c" AS
  SELECT *
  FROM "BW"."T0025" 
    JOIN "BW"."T0031" USING("T0025_uid") -- IAO_0000577 [1..1] PHYSIO_0000100 string
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000577_c" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry. DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

-- Vue de la classe HBW_0000001
CREATE VIEW "BW_ontoView"."HBW_0000001_c" AS
  SELECT *
  FROM "BW"."T002a" 
    JOIN "BW"."T004b" USING("T002a_uid") -- HBW_0000001 [1..*] OBI_0000312 HBW_0000012
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000001_c" IS 'physiological data item::A data item that is the specified output of some physiological evaluation. A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

-- Vue de la classe HBW_0000013
CREATE VIEW "BW_ontoView"."HBW_0000013_p" AS
  SELECT *
  FROM "BW"."T002b" 
    JOIN "BW"."T004c" USING("T002b_uid") -- HBW_0000013 [1..1] PHYSIO_0000089 HBW_0000008
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000013_p" IS 'physiological evaluation from health care provider::A physiological evaluation that is evaluated by a health care provider A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

-- Vue de la classe HBW_0000013
CREATE VIEW "BW_ontoView"."HBW_0000013_c" AS
  SELECT *
  FROM "BW"."T002b" 
    JOIN "BW"."T004c" USING("T002b_uid") -- HBW_0000013 [1..1] PHYSIO_0000089 HBW_0000008
;

COMMENT ON VIEW "BW_ontoView"."HBW_0000013_c" IS 'physiological evaluation from health care provider::A physiological evaluation that is evaluated by a health care provider A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

-- Vue de la classe IAO_0000109
CREATE VIEW "BW_ontoView"."IAO_0000109_p" AS
  SELECT *
  FROM "BW"."T002c" 
    JOIN "BW"."T004d" USING("T002c_uid") -- IAO_0000109 [1..1] IAO_0000039 IAO_0000003
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000109_p" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

-- Vue de la classe IAO_0000109
CREATE VIEW "BW_ontoView"."IAO_0000109_c" AS
  SELECT *
  FROM "BW"."T002c" 
    JOIN "BW"."T004e" USING("T002c_uid") -- IAO_0000109 [1..*] OBI_0001938 OBI_0001933
    JOIN "BW"."T004d" USING("T002c_uid") -- IAO_0000109 [1..1] IAO_0000039 IAO_0000003
;

COMMENT ON VIEW "BW_ontoView"."IAO_0000109_c" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null An information content entity that specifies a value within a classification scheme or on a quantitative scale. A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';


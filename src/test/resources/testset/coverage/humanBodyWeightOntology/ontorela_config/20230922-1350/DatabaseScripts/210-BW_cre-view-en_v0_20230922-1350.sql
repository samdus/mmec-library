/*
-- =========================================================================== A
Schema : BW_en
Creation Date : 20230922-1350
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Create views in en of BW
-- =========================================================================== A
*/

CREATE SCHEMA IF NOT EXISTS "BW_en";

COMMENT ON SCHEMA "BW_en" IS 'Create views in en of BW 20230922-1350';

CREATE VIEW "BW_en"."T0000_Thing" AS
  SELECT "T0000_uid" AS "uid Thing"
  FROM "BW"."T0000";

COMMENT ON VIEW "BW_en"."T0000_Thing" IS 'Top table';

CREATE VIEW "BW_en"."T0001_document" AS
  SELECT "T0001_uid" AS "uid document"
  FROM "BW"."T0001";

COMMENT ON VIEW "BW_en"."T0001_document" IS 'An information content entity that is a collection of information content entities intended to be understood together as a whole.';

CREATE VIEW "BW_en"."T0002_data item" AS
  SELECT "T0002_uid" AS "uid data item"
  FROM "BW"."T0002";

COMMENT ON VIEW "BW_en"."T0002_data item" IS 'a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.';

CREATE VIEW "BW_en"."T0003_measurement unit label" AS
  SELECT "T0003_uid" AS "uid measurement unit label"
  FROM "BW"."T0003";

COMMENT ON VIEW "BW_en"."T0003_measurement unit label" IS 'A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_en"."T0004_human body mass measurement datum" AS
  SELECT "T0004_uid" AS "uid human body mass measurement datum"
  FROM "BW"."T0004";

COMMENT ON VIEW "BW_en"."T0004_human body mass measurement datum" IS 'A scalar measurement datum that is a measurement of the mass of a human body.';

CREATE VIEW "BW_en"."T0005_datum label" AS
  SELECT "T0005_uid" AS "uid datum label"
  FROM "BW"."T0005";

COMMENT ON VIEW "BW_en"."T0005_datum label" IS 'A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label';

CREATE VIEW "BW_en"."T0006_physiological evaluation report" AS
  SELECT "T0006_uid" AS "uid physiological evaluation report"
  FROM "BW"."T0006";

COMMENT ON VIEW "BW_en"."T0006_physiological evaluation report" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."T0007_process" AS
  SELECT "T0007_uid" AS "uid process"
  FROM "BW"."T0007";

COMMENT ON VIEW "BW_en"."T0007_process" IS 'Process';

CREATE VIEW "BW_en"."T0008_patient" AS
  SELECT "T0008_uid" AS "uid patient"
  FROM "BW"."T0008";

COMMENT ON VIEW "BW_en"."T0008_patient" IS 'Homo sapiens having the role of patient.';

CREATE VIEW "BW_en"."T0009_physiological evaluation of human" AS
  SELECT "T0009_uid" AS "uid physiological evaluation of human"
  FROM "BW"."T0009";

COMMENT ON VIEW "BW_en"."T0009_physiological evaluation of human" IS 'A physiological evaluation that evaluates a human''s body weight.';

CREATE VIEW "BW_en"."T000a_realizable entity" AS
  SELECT "T000a_uid" AS "uid realizable entity"
  FROM "BW"."T000a";

COMMENT ON VIEW "BW_en"."T000a_realizable entity" IS 'A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.';

CREATE VIEW "BW_en"."T000b_medical record identifier" AS
  SELECT "T000b_uid" AS "uid medical record identifier"
  FROM "BW"."T000b";

COMMENT ON VIEW "BW_en"."T000b_medical record identifier" IS 'A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_en"."T000c_ONTORELA_C0025X" AS
  SELECT "T000c_uid" AS "T000c_uid"
  FROM "BW"."T000c";

COMMENT ON VIEW "BW_en"."T000c_ONTORELA_C0025X" IS 'medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

CREATE VIEW "BW_en"."T000d_scalar value specification" AS
  SELECT "T000d_uid" AS "uid scalar value specification"
  FROM "BW"."T000d";

COMMENT ON VIEW "BW_en"."T000d_scalar value specification" IS 'A value specification that consists of two parts: a numeral and a unit label';

CREATE VIEW "BW_en"."T000e_generically dependent continuant" AS
  SELECT "T000e_uid" AS "uid generically dependent continuant"
  FROM "BW"."T000e";

COMMENT ON VIEW "BW_en"."T000e_generically dependent continuant" IS 'b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001])';

CREATE VIEW "BW_en"."T000f_value specification" AS
  SELECT "T000f_uid" AS "uid value specification"
  FROM "BW"."T000f";

COMMENT ON VIEW "BW_en"."T000f_value specification" IS 'An information content entity that specifies a value within a classification scheme or on a quantitative scale.';

CREATE VIEW "BW_en"."T0010_entity" AS
  SELECT "T0010_uid" AS "uid entity"
  FROM "BW"."T0010";

COMMENT ON VIEW "BW_en"."T0010_entity" IS 'Entity';

CREATE VIEW "BW_en"."T0011_role" AS
  SELECT "T0011_uid" AS "uid role"
  FROM "BW"."T0011";

COMMENT ON VIEW "BW_en"."T0011_role" IS 'A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

CREATE VIEW "BW_en"."T0012_occurrent" AS
  SELECT "T0012_uid" AS "uid occurrent"
  FROM "BW"."T0012";

COMMENT ON VIEW "BW_en"."T0012_occurrent" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
';

CREATE VIEW "BW_en"."T0013_symbol" AS
  SELECT "T0013_uid" AS "uid symbol"
  FROM "BW"."T0013";

COMMENT ON VIEW "BW_en"."T0013_symbol" IS 'An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.';

CREATE VIEW "BW_en"."T0014_body weight measurement process" AS
  SELECT "T0014_uid" AS "uid body weight measurement process"
  FROM "BW"."T0014";

COMMENT ON VIEW "BW_en"."T0014_body weight measurement process" IS 'A physiological evaluation that evaluates an organism''s body weight.';

CREATE VIEW "BW_en"."T0015_centrally registered identifier symbol" AS
  SELECT "T0015_uid" AS "uid centrally registered identifier symbol"
  FROM "BW"."T0015";

COMMENT ON VIEW "BW_en"."T0015_centrally registered identifier symbol" IS 'A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.';

CREATE VIEW "BW_en"."T0016_organism" AS
  SELECT "T0016_uid" AS "uid organism"
  FROM "BW"."T0016";

COMMENT ON VIEW "BW_en"."T0016_organism" IS 'A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T0017_measurement datum" AS
  SELECT "T0017_uid" AS "uid measurement datum"
  FROM "BW"."T0017";

COMMENT ON VIEW "BW_en"."T0017_measurement datum" IS 'A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.';

CREATE VIEW "BW_en"."T0018_health care record" AS
  SELECT "T0018_uid" AS "uid health care record"
  FROM "BW"."T0018";

COMMENT ON VIEW "BW_en"."T0018_health care record" IS 'A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.';

CREATE VIEW "BW_en"."T0019_independent continuant" AS
  SELECT "T0019_uid" AS "uid independent continuant"
  FROM "BW"."T0019";

COMMENT ON VIEW "BW_en"."T0019_independent continuant" IS 'IndependentContinuant';

CREATE VIEW "BW_en"."T001a_physiological evaluation of patient" AS
  SELECT "T001a_uid" AS "uid physiological evaluation of patient"
  FROM "BW"."T001a";

COMMENT ON VIEW "BW_en"."T001a_physiological evaluation of patient" IS 'A physiological evaluation that evaluates a patient''s body weight.';

CREATE VIEW "BW_en"."T001b_planned process" AS
  SELECT "T001b_uid" AS "uid planned process"
  FROM "BW"."T001b";

COMMENT ON VIEW "BW_en"."T001b_planned process" IS 'A process that realizes a plan which is the concretization of a plan specification.';

CREATE VIEW "BW_en"."T001c_Homo sapiens" AS
  SELECT "T001c_uid" AS "uid Homo sapiens"
  FROM "BW"."T001c";

COMMENT ON VIEW "BW_en"."T001c_Homo sapiens" IS 'Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_en"."T001d_mass unit" AS
  SELECT "T001d_uid" AS "uid mass unit"
  FROM "BW"."T001d";

COMMENT ON VIEW "BW_en"."T001d_mass unit" IS 'A unit which is a standard measure of the amount of matter/energy of a physical object.';

CREATE VIEW "BW_en"."T001e_physiological evaluation" AS
  SELECT "T001e_uid" AS "uid physiological evaluation"
  FROM "BW"."T001e";

COMMENT ON VIEW "BW_en"."T001e_physiological evaluation" IS 'A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."T001f_physiological data item" AS
  SELECT "T001f_uid" AS "uid physiological data item"
  FROM "BW"."T001f";

COMMENT ON VIEW "BW_en"."T001f_physiological data item" IS 'A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_en"."T0020_patient role" AS
  SELECT "T0020_uid" AS "uid patient role"
  FROM "BW"."T0020";

COMMENT ON VIEW "BW_en"."T0020_patient role" IS 'a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_en"."T0021_material entity" AS
  SELECT "T0021_uid" AS "uid material entity"
  FROM "BW"."T0021";

COMMENT ON VIEW "BW_en"."T0021_material entity" IS 'MaterialEntity';

CREATE VIEW "BW_en"."T0022_information content entity" AS
  SELECT "T0022_uid" AS "uid information content entity"
  FROM "BW"."T0022";

COMMENT ON VIEW "BW_en"."T0022_information content entity" IS 'A generically dependent continuant that is about some thing.';

CREATE VIEW "BW_en"."T0023_sdc" AS
  SELECT "T0023_uid" AS "uid sdc"
  FROM "BW"."T0023";

COMMENT ON VIEW "BW_en"."T0023_sdc" IS 'b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])';

CREATE VIEW "BW_en"."T0024_scalar measurement datum" AS
  SELECT "T0024_uid" AS "uid scalar measurement datum"
  FROM "BW"."T0024";

COMMENT ON VIEW "BW_en"."T0024_scalar measurement datum" IS 'a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.';

CREATE VIEW "BW_en"."T0025_continuant" AS
  SELECT "T0025_uid" AS "uid continuant"
  FROM "BW"."T0025";

COMMENT ON VIEW "BW_en"."T0025_continuant" IS 'Continuant';

CREATE VIEW "BW_en"."T0026_scalar measurement datum has measurement value" AS
  SELECT "T0026_IAO_0000004" AS "has measurement value",  
    "T0024_uid" AS "uid scalar measurement datum"
  FROM "BW"."T0026";

COMMENT ON VIEW "BW_en"."T0026_scalar measurement datum has measurement value" IS 'IAO_0000032 [1..1] IAO_0000004 double';

CREATE VIEW "BW_en"."T0027_measurement unit label has value" AS
  SELECT "T0027_PHYSIO_0000100" AS "has value",  
    "T0003_uid" AS "uid measurement unit label"
  FROM "BW"."T0027";

COMMENT ON VIEW "BW_en"."T0027_measurement unit label has value" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."T0028_scalar measurement datum has measurement value" AS
  SELECT "T0024_uid" AS "uid scalar measurement datum",  
    "T0028_IAO_0000004" AS "has measurement value"
  FROM "BW"."T0028";

COMMENT ON VIEW "BW_en"."T0028_scalar measurement datum has measurement value" IS 'DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal)';

CREATE VIEW "BW_en"."T0029_centrally registered identifier symbol has value" AS
  SELECT "T0029_PHYSIO_0000100" AS "has value",  
    "T0015_uid" AS "uid centrally registered identifier symbol"
  FROM "BW"."T0029";

COMMENT ON VIEW "BW_en"."T0029_centrally registered identifier symbol has value" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."T002a_PHYSIO_0000065_OBI_0000312_PHYSIO_0000008" AS
  SELECT "T0004_uid" AS "uid human body mass measurement datum",  
    "T0014_uid" AS "uid body weight measurement process"
  FROM "BW"."T002a";

COMMENT ON VIEW "BW_en"."T002a_PHYSIO_0000065_OBI_0000312_PHYSIO_0000008" IS 'A scalar measurement datum that is a measurement of the mass of a human body. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A physiological evaluation that evaluates an organism''s body weight.';

CREATE VIEW "BW_en"."T002b_PHYSIO_0000083_BFO_0000051_HADO_0000006" AS
  SELECT "T0006_uid" AS "uid physiological evaluation report",  
    "T000b_uid" AS "uid medical record identifier"
  FROM "BW"."T002b";

COMMENT ON VIEW "BW_en"."T002b_PHYSIO_0000083_BFO_0000051_HADO_0000006" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_en"."T002c_PHYSIO_0000083_BFO_0000051_PHYSIO_0000093" AS
  SELECT "T0006_uid" AS "uid physiological evaluation report",  
    "T001f_uid" AS "uid physiological data item"
  FROM "BW"."T002c";

COMMENT ON VIEW "BW_en"."T002c_PHYSIO_0000083_BFO_0000051_PHYSIO_0000093" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_en"."T002d_process realizes realizable entity" AS
  SELECT "T0007_uid" AS "uid process",  
    "T000a_uid" AS "uid realizable entity"
  FROM "BW"."T002d";

COMMENT ON VIEW "BW_en"."T002d_process realizes realizable entity" IS 'Process Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.';

CREATE VIEW "BW_en"."T002e_patient has role patient role" AS
  SELECT "T0008_uid" AS "uid patient",  
    "T0020_uid" AS "uid patient role"
  FROM "BW"."T002e";

COMMENT ON VIEW "BW_en"."T002e_patient has role patient role" IS 'Homo sapiens having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_en"."T002f_PHYSIO_0000090_PHYSIO_0000089_NCBITaxon_9606" AS
  SELECT "T0009_uid" AS "uid physiological evaluation of human",  
    "T001c_uid" AS "uid Homo sapiens"
  FROM "BW"."T002f";

COMMENT ON VIEW "BW_en"."T002f_PHYSIO_0000090_PHYSIO_0000089_NCBITaxon_9606" IS 'A physiological evaluation that evaluates a human''s body weight. A has participant property in a evaluation process Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_en"."T0030_realizable entity realized in process" AS
  SELECT "T000a_uid" AS "uid realizable entity",  
    "T0007_uid" AS "uid process"
  FROM "BW"."T0030";

COMMENT ON VIEW "BW_en"."T0030_realizable entity realized in process" IS 'A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type. Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process Process';

CREATE VIEW "BW_en"."T0031_HADO_0000006_IAO_0000219_ONTORELA_C0025X" AS
  SELECT "T000b_uid" AS "uid medical record identifier",  
    "T000c_uid" AS "T000c_uid"
  FROM "BW"."T0031";

COMMENT ON VIEW "BW_en"."T0031_HADO_0000006_IAO_0000219_ONTORELA_C0025X" IS 'A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

CREATE VIEW "BW_en"."T0032_ONTORELA_C0025X_IAO_0000136_HADO_0000008" AS
  SELECT "T000c_uid" AS "T000c_uid",  
    "T0008_uid" AS "uid patient"
  FROM "BW"."T0032";

COMMENT ON VIEW "BW_en"."T0032_ONTORELA_C0025X_IAO_0000136_HADO_0000008" IS 'medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

CREATE VIEW "BW_en"."T0033_generically dependent continuant is concretized as sdc" AS
  SELECT "T000e_uid" AS "uid generically dependent continuant",  
    "T0023_uid" AS "uid sdc"
  FROM "BW"."T0033";

COMMENT ON VIEW "BW_en"."T0033_generically dependent continuant is concretized as sdc" IS 'b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001]) A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])';

CREATE VIEW "BW_en"."T0034_entity part of entity" AS
  SELECT "T0010_uid_domain" AS "uid entity_domain",  
    "T0010_uid_range" AS "uid entity_range"
  FROM "BW"."T0034";

COMMENT ON VIEW "BW_en"."T0034_entity part of entity" IS 'Entity a core relation that holds between a part and its whole Entity';

CREATE VIEW "BW_en"."T0035_occurrent occurs in independent continuant" AS
  SELECT "T0012_uid" AS "uid occurrent",  
    "T0019_uid" AS "uid independent continuant"
  FROM "BW"."T0035";

COMMENT ON VIEW "BW_en"."T0035_occurrent occurs in independent continuant" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
 b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t IndependentContinuant';

CREATE VIEW "BW_en"."T0036_occurrent has participant continuant" AS
  SELECT "T0012_uid" AS "uid occurrent",  
    "T0025_uid" AS "uid continuant"
  FROM "BW"."T0036";

COMMENT ON VIEW "BW_en"."T0036_occurrent has participant continuant" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
 a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant';

CREATE VIEW "BW_en"."T0037_IAO_0000109_IAO_0000039_IAO_0000003" AS
  SELECT "T0017_uid" AS "uid measurement datum",  
    "T0003_uid" AS "uid measurement unit label"
  FROM "BW"."T0037";

COMMENT ON VIEW "BW_en"."T0037_IAO_0000109_IAO_0000039_IAO_0000003" IS 'A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_en"."T0038_IAO_0000109_OBI_0001938_OBI_0001933" AS
  SELECT "T0017_uid" AS "uid measurement datum",  
    "T000f_uid" AS "uid value specification"
  FROM "BW"."T0038";

COMMENT ON VIEW "BW_en"."T0038_IAO_0000109_OBI_0001938_OBI_0001933" IS 'A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null An information content entity that specifies a value within a classification scheme or on a quantitative scale.';

CREATE VIEW "BW_en"."T0039_health care record is about organism" AS
  SELECT "T0018_uid" AS "uid health care record",  
    "T0016_uid" AS "uid organism"
  FROM "BW"."T0039";

COMMENT ON VIEW "BW_en"."T0039_health care record is about organism" IS 'A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T003a_independent continuant has role role" AS
  SELECT "T0019_uid" AS "uid independent continuant",  
    "T0011_uid" AS "uid role"
  FROM "BW"."T003a";

COMMENT ON VIEW "BW_en"."T003a_independent continuant has role role" IS 'IndependentContinuant a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

CREATE VIEW "BW_en"."T003b_BFO_0000004_RO_0001025_BFO_0000004" AS
  SELECT "T0019_uid_domain" AS "uid independent continuant_domain",  
    "T0019_uid_range" AS "uid independent continuant_range"
  FROM "BW"."T003b";

COMMENT ON VIEW "BW_en"."T003b_BFO_0000004_RO_0001025_BFO_0000004" IS 'IndependentContinuant a relation between two independent continuants, the target and the location, in which the target is entirely within the location IndependentContinuant';

CREATE VIEW "BW_en"."T003c_PHYSIO_0000091_PHYSIO_0000089_HADO_0000008" AS
  SELECT "T001a_uid" AS "uid physiological evaluation of patient",  
    "T0008_uid" AS "uid patient"
  FROM "BW"."T003c";

COMMENT ON VIEW "BW_en"."T003c_PHYSIO_0000091_PHYSIO_0000089_HADO_0000008" IS 'A physiological evaluation that evaluates a patient''s body weight. A has participant property in a evaluation process Homo sapiens having the role of patient.';

CREATE VIEW "BW_en"."T003d_physiological evaluation has evaluant organism" AS
  SELECT "T001e_uid" AS "uid physiological evaluation",  
    "T0016_uid" AS "uid organism"
  FROM "BW"."T003d";

COMMENT ON VIEW "BW_en"."T003d_physiological evaluation has evaluant organism" IS 'A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T003e_PHYSIO_0000093_OBI_0000312_PHYSIO_0000085" AS
  SELECT "T001f_uid" AS "uid physiological data item",  
    "T001e_uid" AS "uid physiological evaluation"
  FROM "BW"."T003e";

COMMENT ON VIEW "BW_en"."T003e_PHYSIO_0000093_OBI_0000312_PHYSIO_0000085" IS 'A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."T003f_patient role inheres in Homo sapiens" AS
  SELECT "T0020_uid" AS "uid patient role",  
    "T001c_uid" AS "uid Homo sapiens"
  FROM "BW"."T003f";

COMMENT ON VIEW "BW_en"."T003f_patient role inheres in Homo sapiens" IS 'a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_en"."T0040_information content entity is about entity" AS
  SELECT "T0022_uid" AS "uid information content entity",  
    "T0010_uid" AS "uid entity"
  FROM "BW"."T0040";

COMMENT ON VIEW "BW_en"."T0040_information content entity is about entity" IS 'A generically dependent continuant that is about some thing. is_about is a (currently) primitive relation that relates an information artifact to an entity. Entity';

CREATE VIEW "BW_en"."T0041_information content entity denotes entity" AS
  SELECT "T0022_uid" AS "uid information content entity",  
    "T0010_uid" AS "uid entity"
  FROM "BW"."T0041";

COMMENT ON VIEW "BW_en"."T0041_information content entity denotes entity" IS 'A generically dependent continuant that is about some thing. null Entity';

CREATE VIEW "BW_en"."T0042_sdc concretizes generically dependent continuant" AS
  SELECT "T0023_uid" AS "uid sdc",  
    "T000e_uid" AS "uid generically dependent continuant"
  FROM "BW"."T0042";

COMMENT ON VIEW "BW_en"."T0042_sdc concretizes generically dependent continuant" IS 'b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003]) A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001])';

CREATE VIEW "BW_en"."T0043_IAO_0000032_OBI_0001938_OBI_0001931" AS
  SELECT "T0024_uid" AS "uid scalar measurement datum",  
    "T000d_uid" AS "uid scalar value specification"
  FROM "BW"."T0043";

COMMENT ON VIEW "BW_en"."T0043_IAO_0000032_OBI_0001938_OBI_0001931" IS 'a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A value specification that consists of two parts: a numeral and a unit label';

CREATE VIEW "BW_en"."T0044_IAO_0000032_IAO_0000039_Thing" AS
  SELECT "T0024_uid" AS "uid scalar measurement datum",  
    "T0000_uid" AS "uid Thing"
  FROM "BW"."T0044";

COMMENT ON VIEW "BW_en"."T0044_IAO_0000032_IAO_0000039_Thing" IS 'a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null The class owl:Thing is the class of all individuals.';

CREATE VIEW "BW_en"."T0045_continuant participates in occurrent" AS
  SELECT "T0025_uid" AS "uid continuant",  
    "T0012_uid" AS "uid occurrent"
  FROM "BW"."T0045";

COMMENT ON VIEW "BW_en"."T0045_continuant participates in occurrent" IS 'Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process 
An entity that has temporal parts and that happens, unfolds or develops through time.
';


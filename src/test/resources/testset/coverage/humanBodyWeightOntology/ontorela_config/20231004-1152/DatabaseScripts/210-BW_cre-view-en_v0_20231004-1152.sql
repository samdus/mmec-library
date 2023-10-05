/*
-- =========================================================================== A
Schema : BW_en
Creation Date : 20231004-1152
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

COMMENT ON SCHEMA "BW_en" IS 'Create views in en of BW 20231004-1152';

CREATE VIEW "BW_en"."T0000_Thing" AS
  SELECT "T0000_uid" AS "uid Thing"
  FROM "BW"."T0000";

COMMENT ON VIEW "BW_en"."T0000_Thing" IS 'Top table';

CREATE VIEW "BW_en"."T0001_scalar measurement datum" AS
  SELECT "T0001_uid" AS "uid scalar measurement datum"
  FROM "BW"."T0001";

COMMENT ON VIEW "BW_en"."T0001_scalar measurement datum" IS 'a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.';

CREATE VIEW "BW_en"."T0002_value specification" AS
  SELECT "T0002_uid" AS "uid value specification"
  FROM "BW"."T0002";

COMMENT ON VIEW "BW_en"."T0002_value specification" IS 'An information content entity that specifies a value within a classification scheme or on a quantitative scale.';

CREATE VIEW "BW_en"."T0003_sdc" AS
  SELECT "T0003_uid" AS "uid sdc"
  FROM "BW"."T0003";

COMMENT ON VIEW "BW_en"."T0003_sdc" IS 'SpecificallyDependentContinuant';

CREATE VIEW "BW_en"."T0004_information content entity" AS
  SELECT "T0004_uid" AS "uid information content entity"
  FROM "BW"."T0004";

COMMENT ON VIEW "BW_en"."T0004_information content entity" IS 'A generically dependent continuant that is about some thing.';

CREATE VIEW "BW_en"."T0005_scalar value specification" AS
  SELECT "T0005_uid" AS "uid scalar value specification"
  FROM "BW"."T0005";

COMMENT ON VIEW "BW_en"."T0005_scalar value specification" IS 'A value specification that consists of two parts: a numeral and a unit label';

CREATE VIEW "BW_en"."T0006_disposition" AS
  SELECT "T0006_uid" AS "uid disposition"
  FROM "BW"."T0006";

COMMENT ON VIEW "BW_en"."T0006_disposition" IS 'realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed';

CREATE VIEW "BW_en"."T0007_ic" AS
  SELECT "T0007_uid" AS "uid ic"
  FROM "BW"."T0007";

COMMENT ON VIEW "BW_en"."T0007_ic" IS 'b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

CREATE VIEW "BW_en"."T0008_continuant" AS
  SELECT "T0008_uid" AS "uid continuant"
  FROM "BW"."T0008";

COMMENT ON VIEW "BW_en"."T0008_continuant" IS 'Continuant';

CREATE VIEW "BW_en"."T0009_datum label" AS
  SELECT "T0009_uid" AS "uid datum label"
  FROM "BW"."T0009";

COMMENT ON VIEW "BW_en"."T0009_datum label" IS 'A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label';

CREATE VIEW "BW_en"."T000a_health care record" AS
  SELECT "T000a_uid" AS "uid health care record"
  FROM "BW"."T000a";

COMMENT ON VIEW "BW_en"."T000a_health care record" IS 'A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.';

CREATE VIEW "BW_en"."T000b_medical record identifier" AS
  SELECT "T000b_uid" AS "uid medical record identifier"
  FROM "BW"."T000b";

COMMENT ON VIEW "BW_en"."T000b_medical record identifier" IS 'A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_en"."T000c_data item" AS
  SELECT "T000c_uid" AS "uid data item"
  FROM "BW"."T000c";

COMMENT ON VIEW "BW_en"."T000c_data item" IS 'a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.';

CREATE VIEW "BW_en"."T000d_health care provider" AS
  SELECT "T000d_uid" AS "uid health care provider"
  FROM "BW"."T000d";

COMMENT ON VIEW "BW_en"."T000d_health care provider" IS 'A homo sapiens having with the health care provider role';

CREATE VIEW "BW_en"."T000e_material" AS
  SELECT "T000e_uid" AS "uid material"
  FROM "BW"."T000e";

COMMENT ON VIEW "BW_en"."T000e_material" IS 'An independent continuant that is spatially extended whose identity is independent of that of other entities and can be maintained through time.';

CREATE VIEW "BW_en"."T000f_ONTORELA_C002aX" AS
  SELECT "T000f_uid" AS "T000f_uid"
  FROM "BW"."T000f";

COMMENT ON VIEW "BW_en"."T000f_ONTORELA_C002aX" IS 'medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

CREATE VIEW "BW_en"."T0010_document" AS
  SELECT "T0010_uid" AS "uid document"
  FROM "BW"."T0010";

COMMENT ON VIEW "BW_en"."T0010_document" IS 'An information content entity that is a collection of information content entities intended to be understood together as a whole.';

CREATE VIEW "BW_en"."T0011_measurement unit label" AS
  SELECT "T0011_uid" AS "uid measurement unit label"
  FROM "BW"."T0011";

COMMENT ON VIEW "BW_en"."T0011_measurement unit label" IS 'A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_en"."T0012_ONTORELA_C002cX" AS
  SELECT "T0012_uid" AS "T0012_uid"
  FROM "BW"."T0012";

COMMENT ON VIEW "BW_en"."T0012_ONTORELA_C002cX" IS 'physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T0013_health care provider role" AS
  SELECT "T0013_uid" AS "uid health care provider role"
  FROM "BW"."T0013";

COMMENT ON VIEW "BW_en"."T0013_health care provider role" IS 'A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

CREATE VIEW "BW_en"."T0014_physiological evaluation" AS
  SELECT "T0014_uid" AS "uid physiological evaluation"
  FROM "BW"."T0014";

COMMENT ON VIEW "BW_en"."T0014_physiological evaluation" IS 'A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."T0015_RAMQ vulnerability code" AS
  SELECT "T0015_uid" AS "uid RAMQ vulnerability code"
  FROM "BW"."T0015";

COMMENT ON VIEW "BW_en"."T0015_RAMQ vulnerability code" IS 'A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.';

CREATE VIEW "BW_en"."T0016_obesity" AS
  SELECT "T0016_uid" AS "uid obesity"
  FROM "BW"."T0016";

COMMENT ON VIEW "BW_en"."T0016_obesity" IS 'A disease marked by an abnormally high, unhealthy amount of body fat.; A disorder characterized by having an increased body fat.';

CREATE VIEW "BW_en"."T0017_quality" AS
  SELECT "T0017_uid" AS "uid quality"
  FROM "BW"."T0017";

COMMENT ON VIEW "BW_en"."T0017_quality" IS 'a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized';

CREATE VIEW "BW_en"."T0018_realizable" AS
  SELECT "T0018_uid" AS "uid realizable"
  FROM "BW"."T0018";

COMMENT ON VIEW "BW_en"."T0018_realizable" IS 'RealizableEntity';

CREATE VIEW "BW_en"."T0019_entity" AS
  SELECT "T0019_uid" AS "uid entity"
  FROM "BW"."T0019";

COMMENT ON VIEW "BW_en"."T0019_entity" IS 'A thing that exists or has existed or will exist.';

CREATE VIEW "BW_en"."T001a_role" AS
  SELECT "T001a_uid" AS "uid role"
  FROM "BW"."T001a";

COMMENT ON VIEW "BW_en"."T001a_role" IS 'A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

CREATE VIEW "BW_en"."T001b_disease" AS
  SELECT "T001b_uid" AS "uid disease"
  FROM "BW"."T001b";

COMMENT ON VIEW "BW_en"."T001b_disease" IS 'A disposition (i) to undergo pathological processes that (ii) exists in an organism because of one or more disorders in that organism.';

CREATE VIEW "BW_en"."T001c_ONTORELA_C002eX" AS
  SELECT "T001c_uid" AS "T001c_uid"
  FROM "BW"."T001c";

COMMENT ON VIEW "BW_en"."T001c_ONTORELA_C002eX" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T001d_gdc" AS
  SELECT "T001d_uid" AS "uid gdc"
  FROM "BW"."T001d";

COMMENT ON VIEW "BW_en"."T001d_gdc" IS 'A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

CREATE VIEW "BW_en"."T001e_process" AS
  SELECT "T001e_uid" AS "uid process"
  FROM "BW"."T001e";

COMMENT ON VIEW "BW_en"."T001e_process" IS 'p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

CREATE VIEW "BW_en"."T001f_occurrent" AS
  SELECT "T001f_uid" AS "uid occurrent"
  FROM "BW"."T001f";

COMMENT ON VIEW "BW_en"."T001f_occurrent" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
';

CREATE VIEW "BW_en"."T0020_physiological evaluation report" AS
  SELECT "T0020_uid" AS "uid physiological evaluation report"
  FROM "BW"."T0020";

COMMENT ON VIEW "BW_en"."T0020_physiological evaluation report" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."T0021_ONTORELA_C002eX-el0" AS
  SELECT "T0021_uid" AS "T0021_uid"
  FROM "BW"."T0021";

COMMENT ON VIEW "BW_en"."T0021_ONTORELA_C002eX-el0" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality';

CREATE VIEW "BW_en"."T0022_patient" AS
  SELECT "T0022_uid" AS "uid patient"
  FROM "BW"."T0022";

COMMENT ON VIEW "BW_en"."T0022_patient" IS 'An organism having the role of patient.';

CREATE VIEW "BW_en"."T0023_symbol" AS
  SELECT "T0023_uid" AS "uid symbol"
  FROM "BW"."T0023";

COMMENT ON VIEW "BW_en"."T0023_symbol" IS 'An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.';

CREATE VIEW "BW_en"."T0024_body weight" AS
  SELECT "T0024_uid" AS "uid body weight"
  FROM "BW"."T0024";

COMMENT ON VIEW "BW_en"."T0024_body weight" IS 'a quality of a body of having a weight';

CREATE VIEW "BW_en"."T0025_centrally registered identifier symbol" AS
  SELECT "T0025_uid" AS "uid centrally registered identifier symbol"
  FROM "BW"."T0025";

COMMENT ON VIEW "BW_en"."T0025_centrally registered identifier symbol" IS 'A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.';

CREATE VIEW "BW_en"."T0026_Homo sapiens" AS
  SELECT "T0026_uid" AS "uid Homo sapiens"
  FROM "BW"."T0026";

COMMENT ON VIEW "BW_en"."T0026_Homo sapiens" IS 'Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_en"."T0027_organism" AS
  SELECT "T0027_uid" AS "uid organism"
  FROM "BW"."T0027";

COMMENT ON VIEW "BW_en"."T0027_organism" IS 'A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T0028_patient role" AS
  SELECT "T0028_uid" AS "uid patient role"
  FROM "BW"."T0028";

COMMENT ON VIEW "BW_en"."T0028_patient role" IS 'a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_en"."T0029_planned process" AS
  SELECT "T0029_uid" AS "uid planned process"
  FROM "BW"."T0029";

COMMENT ON VIEW "BW_en"."T0029_planned process" IS 'A process that realizes a plan which is the concretization of a plan specification.';

CREATE VIEW "BW_en"."T002a_physiological data item" AS
  SELECT "T002a_uid" AS "uid physiological data item"
  FROM "BW"."T002a";

COMMENT ON VIEW "BW_en"."T002a_physiological data item" IS 'A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_en"."T002b_physiological evaluation from health care provider" AS
  SELECT "T002b_uid" AS "uid physiological evaluation from health care provider"
  FROM "BW"."T002b";

COMMENT ON VIEW "BW_en"."T002b_physiological evaluation from health care provider" IS 'A physiological evaluation that is evaluated by a health care provider';

CREATE VIEW "BW_en"."T002c_measurement datum" AS
  SELECT "T002c_uid" AS "uid measurement datum"
  FROM "BW"."T002c";

COMMENT ON VIEW "BW_en"."T002c_measurement datum" IS 'A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.';

CREATE VIEW "BW_en"."T002d_weight unit" AS
  SELECT "T002d_uid" AS "uid weight unit"
  FROM "BW"."T002d";

COMMENT ON VIEW "BW_en"."T002d_weight unit" IS 'a measurement unit label of a weight';

CREATE VIEW "BW_en"."T002e_scalar measurement datum has measurement value" AS
  SELECT "T002e_IAO_0000004" AS "has measurement value",  
    "T0001_uid" AS "uid scalar measurement datum"
  FROM "BW"."T002e";

COMMENT ON VIEW "BW_en"."T002e_scalar measurement datum has measurement value" IS 'IAO_0000032 [1..1] IAO_0000004 double';

CREATE VIEW "BW_en"."T002f_scalar measurement datum has measurement value" AS
  SELECT "T0001_uid" AS "uid scalar measurement datum",  
    "T002f_IAO_0000004" AS "has measurement value"
  FROM "BW"."T002f";

COMMENT ON VIEW "BW_en"."T002f_scalar measurement datum has measurement value" IS 'DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal)';

CREATE VIEW "BW_en"."T0030_measurement unit label has value" AS
  SELECT "T0030_PHYSIO_0000100" AS "has value",  
    "T0011_uid" AS "uid measurement unit label"
  FROM "BW"."T0030";

COMMENT ON VIEW "BW_en"."T0030_measurement unit label has value" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."T0031_centrally registered identifier symbol has value" AS
  SELECT "T0031_PHYSIO_0000100" AS "has value",  
    "T0025_uid" AS "uid centrally registered identifier symbol"
  FROM "BW"."T0031";

COMMENT ON VIEW "BW_en"."T0031_centrally registered identifier symbol has value" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."T0032_IAO_0000032_OBI_0001938_OBI_0001931" AS
  SELECT "T0001_uid" AS "uid scalar measurement datum",  
    "T0005_uid" AS "uid scalar value specification"
  FROM "BW"."T0032";

COMMENT ON VIEW "BW_en"."T0032_IAO_0000032_OBI_0001938_OBI_0001931" IS 'a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A value specification that consists of two parts: a numeral and a unit label';

CREATE VIEW "BW_en"."T0033_IAO_0000032_IAO_0000039_Thing" AS
  SELECT "T0001_uid" AS "uid scalar measurement datum",  
    "T0000_uid" AS "uid Thing"
  FROM "BW"."T0033";

COMMENT ON VIEW "BW_en"."T0033_IAO_0000032_IAO_0000039_Thing" IS 'a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null The class owl:Thing is the class of all individuals.';

CREATE VIEW "BW_en"."T0034_sdc concretizes gdc" AS
  SELECT "T0003_uid" AS "uid sdc",  
    "T001d_uid" AS "uid gdc"
  FROM "BW"."T0034";

COMMENT ON VIEW "BW_en"."T0034_sdc concretizes gdc" IS 'SpecificallyDependentContinuant A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

CREATE VIEW "BW_en"."T0035_information content entity is about entity" AS
  SELECT "T0004_uid" AS "uid information content entity",  
    "T0019_uid" AS "uid entity"
  FROM "BW"."T0035";

COMMENT ON VIEW "BW_en"."T0035_information content entity is about entity" IS 'A generically dependent continuant that is about some thing. is_about is a (currently) primitive relation that relates an information artifact to an entity. A thing that exists or has existed or will exist.';

CREATE VIEW "BW_en"."T0036_information content entity denotes entity" AS
  SELECT "T0004_uid" AS "uid information content entity",  
    "T0019_uid" AS "uid entity"
  FROM "BW"."T0036";

COMMENT ON VIEW "BW_en"."T0036_information content entity denotes entity" IS 'A generically dependent continuant that is about some thing. null A thing that exists or has existed or will exist.';

CREATE VIEW "BW_en"."T0037_ic has role role" AS
  SELECT "T0007_uid" AS "uid ic",  
    "T001a_uid" AS "uid role"
  FROM "BW"."T0037";

COMMENT ON VIEW "BW_en"."T0037_ic has role role" IS 'b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

CREATE VIEW "BW_en"."T0038_ic located in ic" AS
  SELECT "T0007_uid_domain" AS "uid ic_domain",  
    "T0007_uid_range" AS "uid ic_range"
  FROM "BW"."T0038";

COMMENT ON VIEW "BW_en"."T0038_ic located in ic" IS 'b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) a relation between two independent continuants, the target and the location, in which the target is entirely within the location b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

CREATE VIEW "BW_en"."T0039_continuant participates in occurrent" AS
  SELECT "T0008_uid" AS "uid continuant",  
    "T001f_uid" AS "uid occurrent"
  FROM "BW"."T0039";

COMMENT ON VIEW "BW_en"."T0039_continuant participates in occurrent" IS 'Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process 
An entity that has temporal parts and that happens, unfolds or develops through time.
';

CREATE VIEW "BW_en"."T003a_health care record is about organism" AS
  SELECT "T000a_uid" AS "uid health care record",  
    "T0027_uid" AS "uid organism"
  FROM "BW"."T003a";

COMMENT ON VIEW "BW_en"."T003a_health care record is about organism" IS 'A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T003b_HBW_0000006_IAO_0000219_ONTORELA_C002aX" AS
  SELECT "T000b_uid" AS "uid medical record identifier",  
    "T000f_uid" AS "T000f_uid"
  FROM "BW"."T003b";

COMMENT ON VIEW "BW_en"."T003b_HBW_0000006_IAO_0000219_ONTORELA_C002aX" IS 'A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

CREATE VIEW "BW_en"."T003c_HBW_0000008_RO_0000087_HBW_0000010" AS
  SELECT "T000d_uid" AS "uid health care provider",  
    "T0013_uid" AS "uid health care provider role"
  FROM "BW"."T003c";

COMMENT ON VIEW "BW_en"."T003c_HBW_0000008_RO_0000087_HBW_0000010" IS 'A homo sapiens having with the health care provider role a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

CREATE VIEW "BW_en"."T003d_ONTORELA_C002aX_IAO_0000136_HBW_0000007" AS
  SELECT "T000f_uid" AS "T000f_uid",  
    "T0022_uid" AS "uid patient"
  FROM "BW"."T003d";

COMMENT ON VIEW "BW_en"."T003d_ONTORELA_C002aX_IAO_0000136_HBW_0000007" IS 'medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

CREATE VIEW "BW_en"."T003e_ONTORELA_C002cX_IAO_0000136_ONTORELA_C002eX" AS
  SELECT "T0012_uid" AS "T0012_uid",  
    "T001c_uid" AS "T001c_uid"
  FROM "BW"."T003e";

COMMENT ON VIEW "BW_en"."T003e_ONTORELA_C002cX_IAO_0000136_ONTORELA_C002eX" IS 'physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. is_about is a (currently) primitive relation that relates an information artifact to an entity. physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T003f_HBW_0000012_OBI_0000299_ONTORELA_C002cX" AS
  SELECT "T0014_uid" AS "uid physiological evaluation",  
    "T0012_uid" AS "T0012_uid"
  FROM "BW"."T003f";

COMMENT ON VIEW "BW_en"."T003f_HBW_0000012_OBI_0000299_ONTORELA_C002cX" IS 'A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T0040_physiological evaluation has evaluant Homo sapiens" AS
  SELECT "T0014_uid" AS "uid physiological evaluation",  
    "T0026_uid" AS "uid Homo sapiens"
  FROM "BW"."T0040";

COMMENT ON VIEW "BW_en"."T0040_physiological evaluation has evaluant Homo sapiens" IS 'A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_en"."T0041_realizable realized in process" AS
  SELECT "T0018_uid" AS "uid realizable",  
    "T001e_uid" AS "uid process"
  FROM "BW"."T0041";

COMMENT ON VIEW "BW_en"."T0041_realizable realized in process" IS 'RealizableEntity Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

CREATE VIEW "BW_en"."T0042_entity part of entity" AS
  SELECT "T0019_uid_domain" AS "uid entity_domain",  
    "T0019_uid_range" AS "uid entity_range"
  FROM "BW"."T0042";

COMMENT ON VIEW "BW_en"."T0042_entity part of entity" IS 'A thing that exists or has existed or will exist. 
a core relation that holds between a part and its whole
 A thing that exists or has existed or will exist.';

CREATE VIEW "BW_en"."T0043_gdc is concretized as sdc" AS
  SELECT "T001d_uid" AS "uid gdc",  
    "T0003_uid" AS "uid sdc"
  FROM "BW"."T0043";

COMMENT ON VIEW "BW_en"."T0043_gdc is concretized as sdc" IS 'A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time. A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. SpecificallyDependentContinuant';

CREATE VIEW "BW_en"."T0044_process realizes realizable" AS
  SELECT "T001e_uid" AS "uid process",  
    "T0018_uid" AS "uid realizable"
  FROM "BW"."T0044";

COMMENT ON VIEW "BW_en"."T0044_process realizes realizable" IS 'p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process RealizableEntity';

CREATE VIEW "BW_en"."T0045_occurrent occurs in ic" AS
  SELECT "T001f_uid" AS "uid occurrent",  
    "T0007_uid" AS "uid ic"
  FROM "BW"."T0045";

COMMENT ON VIEW "BW_en"."T0045_occurrent occurs in ic" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
 b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

CREATE VIEW "BW_en"."T0046_occurrent has participant continuant" AS
  SELECT "T001f_uid" AS "uid occurrent",  
    "T0008_uid" AS "uid continuant"
  FROM "BW"."T0046";

COMMENT ON VIEW "BW_en"."T0046_occurrent has participant continuant" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
 a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant';

CREATE VIEW "BW_en"."T0047_HBW_0000005_BFO_0000051_HBW_0000001" AS
  SELECT "T0020_uid" AS "uid physiological evaluation report",  
    "T002a_uid" AS "uid physiological data item"
  FROM "BW"."T0047";

COMMENT ON VIEW "BW_en"."T0047_HBW_0000005_BFO_0000051_HBW_0000001" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_en"."T0048_HBW_0000005_BFO_0000051_HBW_0000006" AS
  SELECT "T0020_uid" AS "uid physiological evaluation report",  
    "T000b_uid" AS "uid medical record identifier"
  FROM "BW"."T0048";

COMMENT ON VIEW "BW_en"."T0048_HBW_0000005_BFO_0000051_HBW_0000006" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_en"."T0049_ONTORELA_C002eX-el0_RO_0000052_OBI_0100026" AS
  SELECT "T0021_uid" AS "T0021_uid",  
    "T0027_uid" AS "uid organism"
  FROM "BW"."T0049";

COMMENT ON VIEW "BW_en"."T0049_ONTORELA_C002eX-el0_RO_0000052_OBI_0100026" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."T004a_patient has role patient role" AS
  SELECT "T0022_uid" AS "uid patient",  
    "T0028_uid" AS "uid patient role"
  FROM "BW"."T004a";

COMMENT ON VIEW "BW_en"."T004a_patient has role patient role" IS 'An organism having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_en"."T004b_HBW_0000001_OBI_0000312_HBW_0000012" AS
  SELECT "T002a_uid" AS "uid physiological data item",  
    "T0014_uid" AS "uid physiological evaluation"
  FROM "BW"."T004b";

COMMENT ON VIEW "BW_en"."T004b_HBW_0000001_OBI_0000312_HBW_0000012" IS 'A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."T004c_HBW_0000013_PHYSIO_0000089_HBW_0000008" AS
  SELECT "T002b_uid" AS "uid physiological evaluation from health care provider",  
    "T000d_uid" AS "uid health care provider"
  FROM "BW"."T004c";

COMMENT ON VIEW "BW_en"."T004c_HBW_0000013_PHYSIO_0000089_HBW_0000008" IS 'A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

CREATE VIEW "BW_en"."T004d_IAO_0000109_IAO_0000039_IAO_0000003" AS
  SELECT "T002c_uid" AS "uid measurement datum",  
    "T0011_uid" AS "uid measurement unit label"
  FROM "BW"."T004d";

COMMENT ON VIEW "BW_en"."T004d_IAO_0000109_IAO_0000039_IAO_0000003" IS 'A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_en"."T004e_IAO_0000109_OBI_0001938_OBI_0001933" AS
  SELECT "T002c_uid" AS "uid measurement datum",  
    "T0002_uid" AS "uid value specification"
  FROM "BW"."T004e";

COMMENT ON VIEW "BW_en"."T004e_IAO_0000109_OBI_0001938_OBI_0001933" IS 'A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null An information content entity that specifies a value within a classification scheme or on a quantitative scale.';


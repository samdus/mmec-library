/*
-- =========================================================================== A
Schema : BW_iri
Creation Date : 20231004-1152
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Create views with short IRI of BW_iri
-- =========================================================================== A
*/

CREATE SCHEMA IF NOT EXISTS "BW_iri";

COMMENT ON SCHEMA "BW_iri" IS 'Create views with short IRI of BW_iri 20231004-1152';

CREATE VIEW "BW_iri"."Thing" AS
  SELECT "T0000_uid" AS "Thing_uid"
  FROM "BW"."T0000";

COMMENT ON VIEW "BW_iri"."Thing" IS 'Thing::Top table';

CREATE VIEW "BW_iri"."IAO_0000032" AS
  SELECT "T0001_uid" AS "IAO_0000032_uid"
  FROM "BW"."T0001";

COMMENT ON VIEW "BW_iri"."IAO_0000032" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.';

CREATE VIEW "BW_iri"."OBI_0001933" AS
  SELECT "T0002_uid" AS "OBI_0001933_uid"
  FROM "BW"."T0002";

COMMENT ON VIEW "BW_iri"."OBI_0001933" IS 'value specification::An information content entity that specifies a value within a classification scheme or on a quantitative scale.';

CREATE VIEW "BW_iri"."BFO_0000020" AS
  SELECT "T0003_uid" AS "BFO_0000020_uid"
  FROM "BW"."T0003";

COMMENT ON VIEW "BW_iri"."BFO_0000020" IS 'sdc::SpecificallyDependentContinuant';

CREATE VIEW "BW_iri"."IAO_0000030" AS
  SELECT "T0004_uid" AS "IAO_0000030_uid"
  FROM "BW"."T0004";

COMMENT ON VIEW "BW_iri"."IAO_0000030" IS 'information content entity::A generically dependent continuant that is about some thing.';

CREATE VIEW "BW_iri"."OBI_0001931" AS
  SELECT "T0005_uid" AS "OBI_0001931_uid"
  FROM "BW"."T0005";

COMMENT ON VIEW "BW_iri"."OBI_0001931" IS 'scalar value specification::A value specification that consists of two parts: a numeral and a unit label';

CREATE VIEW "BW_iri"."BFO_0000016" AS
  SELECT "T0006_uid" AS "BFO_0000016_uid"
  FROM "BW"."T0006";

COMMENT ON VIEW "BW_iri"."BFO_0000016" IS 'disposition::realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed';

CREATE VIEW "BW_iri"."BFO_0000004" AS
  SELECT "T0007_uid" AS "BFO_0000004_uid"
  FROM "BW"."T0007";

COMMENT ON VIEW "BW_iri"."BFO_0000004" IS 'ic::b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

CREATE VIEW "BW_iri"."BFO_0000002" AS
  SELECT "T0008_uid" AS "BFO_0000002_uid"
  FROM "BW"."T0008";

COMMENT ON VIEW "BW_iri"."BFO_0000002" IS 'continuant::Continuant';

CREATE VIEW "BW_iri"."IAO_0000009" AS
  SELECT "T0009_uid" AS "IAO_0000009_uid"
  FROM "BW"."T0009";

COMMENT ON VIEW "BW_iri"."IAO_0000009" IS 'datum label::A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label';

CREATE VIEW "BW_iri"."HBW_0000004" AS
  SELECT "T000a_uid" AS "HBW_0000004_uid"
  FROM "BW"."T000a";

COMMENT ON VIEW "BW_iri"."HBW_0000004" IS 'health care record::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.';

CREATE VIEW "BW_iri"."HBW_0000006" AS
  SELECT "T000b_uid" AS "HBW_0000006_uid"
  FROM "BW"."T000b";

COMMENT ON VIEW "BW_iri"."HBW_0000006" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_iri"."IAO_0000027" AS
  SELECT "T000c_uid" AS "IAO_0000027_uid"
  FROM "BW"."T000c";

COMMENT ON VIEW "BW_iri"."IAO_0000027" IS 'data item::a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.';

CREATE VIEW "BW_iri"."HBW_0000008" AS
  SELECT "T000d_uid" AS "HBW_0000008_uid"
  FROM "BW"."T000d";

COMMENT ON VIEW "BW_iri"."HBW_0000008" IS 'health care provider::A homo sapiens having with the health care provider role';

CREATE VIEW "BW_iri"."BFO_0000040" AS
  SELECT "T000e_uid" AS "BFO_0000040_uid"
  FROM "BW"."T000e";

COMMENT ON VIEW "BW_iri"."BFO_0000040" IS 'material::An independent continuant that is spatially extended whose identity is independent of that of other entities and can be maintained through time.';

CREATE VIEW "BW_iri"."ONTORELA_C002aX" AS
  SELECT "T000f_uid" AS "ONTORELA_C002aX_uid"
  FROM "BW"."T000f";

COMMENT ON VIEW "BW_iri"."ONTORELA_C002aX" IS 'medical record identifier intersectionOf health care record | is about | patient::medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

CREATE VIEW "BW_iri"."IAO_0000310" AS
  SELECT "T0010_uid" AS "IAO_0000310_uid"
  FROM "BW"."T0010";

COMMENT ON VIEW "BW_iri"."IAO_0000310" IS 'document::An information content entity that is a collection of information content entities intended to be understood together as a whole.';

CREATE VIEW "BW_iri"."IAO_0000003" AS
  SELECT "T0011_uid" AS "IAO_0000003_uid"
  FROM "BW"."T0011";

COMMENT ON VIEW "BW_iri"."IAO_0000003" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_iri"."ONTORELA_C002cX" AS
  SELECT "T0012_uid" AS "ONTORELA_C002cX_uid"
  FROM "BW"."T0012";

COMMENT ON VIEW "BW_iri"."ONTORELA_C002cX" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."HBW_0000010" AS
  SELECT "T0013_uid" AS "HBW_0000010_uid"
  FROM "BW"."T0013";

COMMENT ON VIEW "BW_iri"."HBW_0000010" IS 'health care provider role::A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

CREATE VIEW "BW_iri"."HBW_0000012" AS
  SELECT "T0014_uid" AS "HBW_0000012_uid"
  FROM "BW"."T0014";

COMMENT ON VIEW "BW_iri"."HBW_0000012" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."HBW_0000002" AS
  SELECT "T0015_uid" AS "HBW_0000002_uid"
  FROM "BW"."T0015";

COMMENT ON VIEW "BW_iri"."HBW_0000002" IS 'RAMQ vulnerability code::A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.';

CREATE VIEW "BW_iri"."HBW_0000014" AS
  SELECT "T0016_uid" AS "HBW_0000014_uid"
  FROM "BW"."T0016";

COMMENT ON VIEW "BW_iri"."HBW_0000014" IS 'obesity::A disease marked by an abnormally high, unhealthy amount of body fat.; A disorder characterized by having an increased body fat.';

CREATE VIEW "BW_iri"."BFO_0000019" AS
  SELECT "T0017_uid" AS "BFO_0000019_uid"
  FROM "BW"."T0017";

COMMENT ON VIEW "BW_iri"."BFO_0000019" IS 'quality::a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized';

CREATE VIEW "BW_iri"."BFO_0000017" AS
  SELECT "T0018_uid" AS "BFO_0000017_uid"
  FROM "BW"."T0018";

COMMENT ON VIEW "BW_iri"."BFO_0000017" IS 'realizable::RealizableEntity';

CREATE VIEW "BW_iri"."BFO_0000001" AS
  SELECT "T0019_uid" AS "BFO_0000001_uid"
  FROM "BW"."T0019";

COMMENT ON VIEW "BW_iri"."BFO_0000001" IS 'entity::A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."BFO_0000023" AS
  SELECT "T001a_uid" AS "BFO_0000023_uid"
  FROM "BW"."T001a";

COMMENT ON VIEW "BW_iri"."BFO_0000023" IS 'role::A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

CREATE VIEW "BW_iri"."OGMS_0000031" AS
  SELECT "T001b_uid" AS "OGMS_0000031_uid"
  FROM "BW"."T001b";

COMMENT ON VIEW "BW_iri"."OGMS_0000031" IS 'disease::A disposition (i) to undergo pathological processes that (ii) exists in an organism because of one or more disorders in that organism.';

CREATE VIEW "BW_iri"."ONTORELA_C002eX" AS
  SELECT "T001c_uid" AS "ONTORELA_C002eX_uid"
  FROM "BW"."T001c";

COMMENT ON VIEW "BW_iri"."ONTORELA_C002eX" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism::physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."BFO_0000031" AS
  SELECT "T001d_uid" AS "BFO_0000031_uid"
  FROM "BW"."T001d";

COMMENT ON VIEW "BW_iri"."BFO_0000031" IS 'gdc::A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

CREATE VIEW "BW_iri"."BFO_0000015" AS
  SELECT "T001e_uid" AS "BFO_0000015_uid"
  FROM "BW"."T001e";

COMMENT ON VIEW "BW_iri"."BFO_0000015" IS 'process::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

CREATE VIEW "BW_iri"."BFO_0000003" AS
  SELECT "T001f_uid" AS "BFO_0000003_uid"
  FROM "BW"."T001f";

COMMENT ON VIEW "BW_iri"."BFO_0000003" IS 'occurrent::
An entity that has temporal parts and that happens, unfolds or develops through time.
';

CREATE VIEW "BW_iri"."HBW_0000005" AS
  SELECT "T0020_uid" AS "HBW_0000005_uid"
  FROM "BW"."T0020";

COMMENT ON VIEW "BW_iri"."HBW_0000005" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."ONTORELA_C002eX-el0" AS
  SELECT "T0021_uid" AS "ONTORELA_C002eX-el0_uid"
  FROM "BW"."T0021";

COMMENT ON VIEW "BW_iri"."ONTORELA_C002eX-el0" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality::physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality';

CREATE VIEW "BW_iri"."HBW_0000007" AS
  SELECT "T0022_uid" AS "HBW_0000007_uid"
  FROM "BW"."T0022";

COMMENT ON VIEW "BW_iri"."HBW_0000007" IS 'patient::An organism having the role of patient.';

CREATE VIEW "BW_iri"."IAO_0000028" AS
  SELECT "T0023_uid" AS "IAO_0000028_uid"
  FROM "BW"."T0023";

COMMENT ON VIEW "BW_iri"."IAO_0000028" IS 'symbol::An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.';

CREATE VIEW "BW_iri"."HBW_0000009" AS
  SELECT "T0024_uid" AS "HBW_0000009_uid"
  FROM "BW"."T0024";

COMMENT ON VIEW "BW_iri"."HBW_0000009" IS 'body weight::a quality of a body of having a weight';

CREATE VIEW "BW_iri"."IAO_0000577" AS
  SELECT "T0025_uid" AS "IAO_0000577_uid"
  FROM "BW"."T0025";

COMMENT ON VIEW "BW_iri"."IAO_0000577" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.';

CREATE VIEW "BW_iri"."NCBITaxon_9606" AS
  SELECT "T0026_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."T0026";

COMMENT ON VIEW "BW_iri"."NCBITaxon_9606" IS 'Homo sapiens::Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."OBI_0100026" AS
  SELECT "T0027_uid" AS "OBI_0100026_uid"
  FROM "BW"."T0027";

COMMENT ON VIEW "BW_iri"."OBI_0100026" IS 'organism::A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."HBW_0000011" AS
  SELECT "T0028_uid" AS "HBW_0000011_uid"
  FROM "BW"."T0028";

COMMENT ON VIEW "BW_iri"."HBW_0000011" IS 'patient role::a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_iri"."OBI_0000011" AS
  SELECT "T0029_uid" AS "OBI_0000011_uid"
  FROM "BW"."T0029";

COMMENT ON VIEW "BW_iri"."OBI_0000011" IS 'planned process::A process that realizes a plan which is the concretization of a plan specification.';

CREATE VIEW "BW_iri"."HBW_0000001" AS
  SELECT "T002a_uid" AS "HBW_0000001_uid"
  FROM "BW"."T002a";

COMMENT ON VIEW "BW_iri"."HBW_0000001" IS 'physiological data item::A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_iri"."HBW_0000013" AS
  SELECT "T002b_uid" AS "HBW_0000013_uid"
  FROM "BW"."T002b";

COMMENT ON VIEW "BW_iri"."HBW_0000013" IS 'physiological evaluation from health care provider::A physiological evaluation that is evaluated by a health care provider';

CREATE VIEW "BW_iri"."IAO_0000109" AS
  SELECT "T002c_uid" AS "IAO_0000109_uid"
  FROM "BW"."T002c";

COMMENT ON VIEW "BW_iri"."IAO_0000109" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.';

CREATE VIEW "BW_iri"."HBW_0000003" AS
  SELECT "T002d_uid" AS "HBW_0000003_uid"
  FROM "BW"."T002d";

COMMENT ON VIEW "BW_iri"."HBW_0000003" IS 'weight unit::a measurement unit label of a weight';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000004_double" AS
  SELECT "T002e_IAO_0000004" AS "T002e_IAO_0000004",  
    "T0001_uid" AS "IAO_0000032_uid"
  FROM "BW"."T002e";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000004_double" IS 'scalar measurement datum has measurement value::IAO_0000032 [1..1] IAO_0000004 double';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000004_Literal" AS
  SELECT "T0001_uid" AS "IAO_0000032_uid",  
    "T002f_IAO_0000004" AS "T002f_IAO_0000004"
  FROM "BW"."T002f";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000004_Literal" IS 'scalar measurement datum has measurement value::DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal)';

CREATE VIEW "BW_iri"."IAO_0000003_PHYSIO_0000100_string" AS
  SELECT "T0030_PHYSIO_0000100" AS "T0030_PHYSIO_0000100",  
    "T0011_uid" AS "IAO_0000003_uid"
  FROM "BW"."T0030";

COMMENT ON VIEW "BW_iri"."IAO_0000003_PHYSIO_0000100_string" IS 'measurement unit label has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."IAO_0000577_PHYSIO_0000100_string" AS
  SELECT "T0031_PHYSIO_0000100" AS "T0031_PHYSIO_0000100",  
    "T0025_uid" AS "IAO_0000577_uid"
  FROM "BW"."T0031";

COMMENT ON VIEW "BW_iri"."IAO_0000577_PHYSIO_0000100_string" IS 'centrally registered identifier symbol has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."IAO_0000032_OBI_0001938_OBI_0001931" AS
  SELECT "T0001_uid" AS "IAO_0000032_uid",  
    "T0005_uid" AS "OBI_0001931_uid"
  FROM "BW"."T0032";

COMMENT ON VIEW "BW_iri"."IAO_0000032_OBI_0001938_OBI_0001931" IS 'scalar measurement datum has value specification scalar value specification::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A value specification that consists of two parts: a numeral and a unit label';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000039_Thing" AS
  SELECT "T0001_uid" AS "IAO_0000032_uid",  
    "T0000_uid" AS "Thing_uid"
  FROM "BW"."T0033";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000039_Thing" IS 'scalar measurement datum has measurement unit label Thing::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null The class owl:Thing is the class of all individuals.';

CREATE VIEW "BW_iri"."BFO_0000020_RO_0000059_BFO_0000031" AS
  SELECT "T0003_uid" AS "BFO_0000020_uid",  
    "T001d_uid" AS "BFO_0000031_uid"
  FROM "BW"."T0034";

COMMENT ON VIEW "BW_iri"."BFO_0000020_RO_0000059_BFO_0000031" IS 'sdc concretizes gdc::SpecificallyDependentContinuant A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

CREATE VIEW "BW_iri"."IAO_0000030_IAO_0000136_BFO_0000001" AS
  SELECT "T0004_uid" AS "IAO_0000030_uid",  
    "T0019_uid" AS "BFO_0000001_uid"
  FROM "BW"."T0035";

COMMENT ON VIEW "BW_iri"."IAO_0000030_IAO_0000136_BFO_0000001" IS 'information content entity is about entity::A generically dependent continuant that is about some thing. is_about is a (currently) primitive relation that relates an information artifact to an entity. A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."IAO_0000030_IAO_0000219_BFO_0000001" AS
  SELECT "T0004_uid" AS "IAO_0000030_uid",  
    "T0019_uid" AS "BFO_0000001_uid"
  FROM "BW"."T0036";

COMMENT ON VIEW "BW_iri"."IAO_0000030_IAO_0000219_BFO_0000001" IS 'information content entity denotes entity::A generically dependent continuant that is about some thing. null A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."BFO_0000004_RO_0000087_BFO_0000023" AS
  SELECT "T0007_uid" AS "BFO_0000004_uid",  
    "T001a_uid" AS "BFO_0000023_uid"
  FROM "BW"."T0037";

COMMENT ON VIEW "BW_iri"."BFO_0000004_RO_0000087_BFO_0000023" IS 'ic has role role::b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

CREATE VIEW "BW_iri"."BFO_0000004_RO_0001025_BFO_0000004" AS
  SELECT "T0007_uid_domain" AS "BFO_0000004_uid_domain",  
    "T0007_uid_range" AS "BFO_0000004_uid_range"
  FROM "BW"."T0038";

COMMENT ON VIEW "BW_iri"."BFO_0000004_RO_0001025_BFO_0000004" IS 'ic located in ic::b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) a relation between two independent continuants, the target and the location, in which the target is entirely within the location b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

CREATE VIEW "BW_iri"."BFO_0000002_RO_0000056_BFO_0000003" AS
  SELECT "T0008_uid" AS "BFO_0000002_uid",  
    "T001f_uid" AS "BFO_0000003_uid"
  FROM "BW"."T0039";

COMMENT ON VIEW "BW_iri"."BFO_0000002_RO_0000056_BFO_0000003" IS 'continuant participates in occurrent::Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process 
An entity that has temporal parts and that happens, unfolds or develops through time.
';

CREATE VIEW "BW_iri"."HBW_0000004_IAO_0000136_OBI_0100026" AS
  SELECT "T000a_uid" AS "HBW_0000004_uid",  
    "T0027_uid" AS "OBI_0100026_uid"
  FROM "BW"."T003a";

COMMENT ON VIEW "BW_iri"."HBW_0000004_IAO_0000136_OBI_0100026" IS 'health care record is about organism::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."HBW_0000006_IAO_0000219_ONTORELA_C002aX" AS
  SELECT "T000b_uid" AS "HBW_0000006_uid",  
    "T000f_uid" AS "ONTORELA_C002aX_uid"
  FROM "BW"."T003b";

COMMENT ON VIEW "BW_iri"."HBW_0000006_IAO_0000219_ONTORELA_C002aX" IS 'medical record identifier denotes medical record identifier intersectionOf health care record | is about | patient::A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

CREATE VIEW "BW_iri"."HBW_0000008_RO_0000087_HBW_0000010" AS
  SELECT "T000d_uid" AS "HBW_0000008_uid",  
    "T0013_uid" AS "HBW_0000010_uid"
  FROM "BW"."T003c";

COMMENT ON VIEW "BW_iri"."HBW_0000008_RO_0000087_HBW_0000010" IS 'health care provider has role health care provider role::A homo sapiens having with the health care provider role a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

CREATE VIEW "BW_iri"."ONTORELA_C002aX_IAO_0000136_HBW_0000007" AS
  SELECT "T000f_uid" AS "ONTORELA_C002aX_uid",  
    "T0022_uid" AS "HBW_0000007_uid"
  FROM "BW"."T003d";

COMMENT ON VIEW "BW_iri"."ONTORELA_C002aX_IAO_0000136_HBW_0000007" IS 'medical record identifier intersectionOf health care record | is about | patient is about patient::medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

CREATE VIEW "BW_iri"."ONTORELA_C002cX_IAO_0000136_ONTORELA_C002eX" AS
  SELECT "T0012_uid" AS "ONTORELA_C002cX_uid",  
    "T001c_uid" AS "ONTORELA_C002eX_uid"
  FROM "BW"."T003e";

COMMENT ON VIEW "BW_iri"."ONTORELA_C002cX_IAO_0000136_ONTORELA_C002eX" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism is about physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism::physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. is_about is a (currently) primitive relation that relates an information artifact to an entity. physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."HBW_0000012_OBI_0000299_ONTORELA_C002cX" AS
  SELECT "T0014_uid" AS "HBW_0000012_uid",  
    "T0012_uid" AS "ONTORELA_C002cX_uid"
  FROM "BW"."T003f";

COMMENT ON VIEW "BW_iri"."HBW_0000012_OBI_0000299_ONTORELA_C002cX" IS 'physiological evaluation has_specified_output physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" AS
  SELECT "T0014_uid" AS "HBW_0000012_uid",  
    "T0026_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."T0040";

COMMENT ON VIEW "BW_iri"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" IS 'physiological evaluation has evaluant Homo sapiens::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."BFO_0000017_BFO_0000054_BFO_0000015" AS
  SELECT "T0018_uid" AS "BFO_0000017_uid",  
    "T001e_uid" AS "BFO_0000015_uid"
  FROM "BW"."T0041";

COMMENT ON VIEW "BW_iri"."BFO_0000017_BFO_0000054_BFO_0000015" IS 'realizable realized in process::RealizableEntity Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

CREATE VIEW "BW_iri"."BFO_0000001_BFO_0000050_BFO_0000001" AS
  SELECT "T0019_uid_domain" AS "BFO_0000001_uid_domain",  
    "T0019_uid_range" AS "BFO_0000001_uid_range"
  FROM "BW"."T0042";

COMMENT ON VIEW "BW_iri"."BFO_0000001_BFO_0000050_BFO_0000001" IS 'entity part of entity::A thing that exists or has existed or will exist. 
a core relation that holds between a part and its whole
 A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."BFO_0000031_RO_0000058_BFO_0000020" AS
  SELECT "T001d_uid" AS "BFO_0000031_uid",  
    "T0003_uid" AS "BFO_0000020_uid"
  FROM "BW"."T0043";

COMMENT ON VIEW "BW_iri"."BFO_0000031_RO_0000058_BFO_0000020" IS 'gdc is concretized as sdc::A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time. A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. SpecificallyDependentContinuant';

CREATE VIEW "BW_iri"."BFO_0000015_BFO_0000055_BFO_0000017" AS
  SELECT "T001e_uid" AS "BFO_0000015_uid",  
    "T0018_uid" AS "BFO_0000017_uid"
  FROM "BW"."T0044";

COMMENT ON VIEW "BW_iri"."BFO_0000015_BFO_0000055_BFO_0000017" IS 'process realizes realizable::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process RealizableEntity';

CREATE VIEW "BW_iri"."BFO_0000003_BFO_0000066_BFO_0000004" AS
  SELECT "T001f_uid" AS "BFO_0000003_uid",  
    "T0007_uid" AS "BFO_0000004_uid"
  FROM "BW"."T0045";

COMMENT ON VIEW "BW_iri"."BFO_0000003_BFO_0000066_BFO_0000004" IS 'occurrent occurs in ic::
An entity that has temporal parts and that happens, unfolds or develops through time.
 b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

CREATE VIEW "BW_iri"."BFO_0000003_RO_0000057_BFO_0000002" AS
  SELECT "T001f_uid" AS "BFO_0000003_uid",  
    "T0008_uid" AS "BFO_0000002_uid"
  FROM "BW"."T0046";

COMMENT ON VIEW "BW_iri"."BFO_0000003_RO_0000057_BFO_0000002" IS 'occurrent has participant continuant::
An entity that has temporal parts and that happens, unfolds or develops through time.
 a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant';

CREATE VIEW "BW_iri"."HBW_0000005_BFO_0000051_HBW_0000001" AS
  SELECT "T0020_uid" AS "HBW_0000005_uid",  
    "T002a_uid" AS "HBW_0000001_uid"
  FROM "BW"."T0047";

COMMENT ON VIEW "BW_iri"."HBW_0000005_BFO_0000051_HBW_0000001" IS 'physiological evaluation report has part physiological data item::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_iri"."HBW_0000005_BFO_0000051_HBW_0000006" AS
  SELECT "T0020_uid" AS "HBW_0000005_uid",  
    "T000b_uid" AS "HBW_0000006_uid"
  FROM "BW"."T0048";

COMMENT ON VIEW "BW_iri"."HBW_0000005_BFO_0000051_HBW_0000006" IS 'physiological evaluation report has part medical record identifier::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_iri"."ONTORELA_C002eX-el0_RO_0000052_OBI_0100026" AS
  SELECT "T0021_uid" AS "ONTORELA_C002eX-el0_uid",  
    "T0027_uid" AS "OBI_0100026_uid"
  FROM "BW"."T0049";

COMMENT ON VIEW "BW_iri"."ONTORELA_C002eX-el0_RO_0000052_OBI_0100026" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality inheres in organism::physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."HBW_0000007_RO_0000087_HBW_0000011" AS
  SELECT "T0022_uid" AS "HBW_0000007_uid",  
    "T0028_uid" AS "HBW_0000011_uid"
  FROM "BW"."T004a";

COMMENT ON VIEW "BW_iri"."HBW_0000007_RO_0000087_HBW_0000011" IS 'patient has role patient role::An organism having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_iri"."HBW_0000001_OBI_0000312_HBW_0000012" AS
  SELECT "T002a_uid" AS "HBW_0000001_uid",  
    "T0014_uid" AS "HBW_0000012_uid"
  FROM "BW"."T004b";

COMMENT ON VIEW "BW_iri"."HBW_0000001_OBI_0000312_HBW_0000012" IS 'physiological data item is_specified_output_of physiological evaluation::A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."HBW_0000013_PHYSIO_0000089_HBW_0000008" AS
  SELECT "T002b_uid" AS "HBW_0000013_uid",  
    "T000d_uid" AS "HBW_0000008_uid"
  FROM "BW"."T004c";

COMMENT ON VIEW "BW_iri"."HBW_0000013_PHYSIO_0000089_HBW_0000008" IS 'physiological evaluation from health care provider has evaluant health care provider::A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

CREATE VIEW "BW_iri"."IAO_0000109_IAO_0000039_IAO_0000003" AS
  SELECT "T002c_uid" AS "IAO_0000109_uid",  
    "T0011_uid" AS "IAO_0000003_uid"
  FROM "BW"."T004d";

COMMENT ON VIEW "BW_iri"."IAO_0000109_IAO_0000039_IAO_0000003" IS 'measurement datum has measurement unit label measurement unit label::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_iri"."IAO_0000109_OBI_0001938_OBI_0001933" AS
  SELECT "T002c_uid" AS "IAO_0000109_uid",  
    "T0002_uid" AS "OBI_0001933_uid"
  FROM "BW"."T004e";

COMMENT ON VIEW "BW_iri"."IAO_0000109_OBI_0001938_OBI_0001933" IS 'measurement datum has value specification value specification::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null An information content entity that specifies a value within a classification scheme or on a quantitative scale.';


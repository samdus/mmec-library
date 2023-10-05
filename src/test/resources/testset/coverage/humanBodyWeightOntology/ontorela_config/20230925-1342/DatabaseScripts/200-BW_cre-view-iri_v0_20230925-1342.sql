/*
-- =========================================================================== A
Schema : BW_iri
Creation Date : 20230925-1342
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

COMMENT ON SCHEMA "BW_iri" IS 'Create views with short IRI of BW_iri 20230925-1342';

CREATE VIEW "BW_iri"."Thing" AS
  SELECT "T0000_uid" AS "Thing_uid"
  FROM "BW"."T0000";

COMMENT ON VIEW "BW_iri"."Thing" IS 'Thing::Top table';

CREATE VIEW "BW_iri"."IAO_0000310" AS
  SELECT "T0001_uid" AS "IAO_0000310_uid"
  FROM "BW"."T0001";

COMMENT ON VIEW "BW_iri"."IAO_0000310" IS 'document::An information content entity that is a collection of information content entities intended to be understood together as a whole.';

CREATE VIEW "BW_iri"."IAO_0000027" AS
  SELECT "T0002_uid" AS "IAO_0000027_uid"
  FROM "BW"."T0002";

COMMENT ON VIEW "BW_iri"."IAO_0000027" IS 'data item::a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.';

CREATE VIEW "BW_iri"."IAO_0000003" AS
  SELECT "T0003_uid" AS "IAO_0000003_uid"
  FROM "BW"."T0003";

COMMENT ON VIEW "BW_iri"."IAO_0000003" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_iri"."PHYSIO_0000065" AS
  SELECT "T0004_uid" AS "PHYSIO_0000065_uid"
  FROM "BW"."T0004";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000065" IS 'human body mass measurement datum::A scalar measurement datum that is a measurement of the mass of a human body.';

CREATE VIEW "BW_iri"."IAO_0000009" AS
  SELECT "T0005_uid" AS "IAO_0000009_uid"
  FROM "BW"."T0005";

COMMENT ON VIEW "BW_iri"."IAO_0000009" IS 'datum label::A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label';

CREATE VIEW "BW_iri"."PHYSIO_0000083" AS
  SELECT "T0006_uid" AS "PHYSIO_0000083_uid"
  FROM "BW"."T0006";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000083" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."BFO_0000015" AS
  SELECT "T0007_uid" AS "BFO_0000015_uid"
  FROM "BW"."T0007";

COMMENT ON VIEW "BW_iri"."BFO_0000015" IS 'process::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

CREATE VIEW "BW_iri"."HADO_0000008" AS
  SELECT "T0008_uid" AS "HADO_0000008_uid"
  FROM "BW"."T0008";

COMMENT ON VIEW "BW_iri"."HADO_0000008" IS 'patient::Homo sapiens having the role of patient.';

CREATE VIEW "BW_iri"."PHYSIO_0000090" AS
  SELECT "T0009_uid" AS "PHYSIO_0000090_uid"
  FROM "BW"."T0009";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000090" IS 'physiological evaluation of human::A physiological evaluation that evaluates a human''s body weight.';

CREATE VIEW "BW_iri"."BFO_0000017" AS
  SELECT "T000a_uid" AS "BFO_0000017_uid"
  FROM "BW"."T000a";

COMMENT ON VIEW "BW_iri"."BFO_0000017" IS 'realizable entity::RealizableEntity';

CREATE VIEW "BW_iri"."HADO_0000006" AS
  SELECT "T000b_uid" AS "HADO_0000006_uid"
  FROM "BW"."T000b";

COMMENT ON VIEW "BW_iri"."HADO_0000006" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_iri"."ONTORELA_C0025X" AS
  SELECT "T000c_uid" AS "ONTORELA_C0025X_uid"
  FROM "BW"."T000c";

COMMENT ON VIEW "BW_iri"."ONTORELA_C0025X" IS 'medical record identifier intersectionOf health care record | is about | patient::medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

CREATE VIEW "BW_iri"."OBI_0001931" AS
  SELECT "T000d_uid" AS "OBI_0001931_uid"
  FROM "BW"."T000d";

COMMENT ON VIEW "BW_iri"."OBI_0001931" IS 'scalar value specification::A value specification that consists of two parts: a numeral and a unit label';

CREATE VIEW "BW_iri"."BFO_0000031" AS
  SELECT "T000e_uid" AS "BFO_0000031_uid"
  FROM "BW"."T000e";

COMMENT ON VIEW "BW_iri"."BFO_0000031" IS 'gdc::b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001])';

CREATE VIEW "BW_iri"."OBI_0001933" AS
  SELECT "T000f_uid" AS "OBI_0001933_uid"
  FROM "BW"."T000f";

COMMENT ON VIEW "BW_iri"."OBI_0001933" IS 'value specification::An information content entity that specifies a value within a classification scheme or on a quantitative scale.';

CREATE VIEW "BW_iri"."BFO_0000001" AS
  SELECT "T0010_uid" AS "BFO_0000001_uid"
  FROM "BW"."T0010";

COMMENT ON VIEW "BW_iri"."BFO_0000001" IS 'entity::Entity';

CREATE VIEW "BW_iri"."BFO_0000023" AS
  SELECT "T0011_uid" AS "BFO_0000023_uid"
  FROM "BW"."T0011";

COMMENT ON VIEW "BW_iri"."BFO_0000023" IS 'role::A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

CREATE VIEW "BW_iri"."BFO_0000003" AS
  SELECT "T0012_uid" AS "BFO_0000003_uid"
  FROM "BW"."T0012";

COMMENT ON VIEW "BW_iri"."BFO_0000003" IS 'occurrent::Occurrent';

CREATE VIEW "BW_iri"."IAO_0000028" AS
  SELECT "T0013_uid" AS "IAO_0000028_uid"
  FROM "BW"."T0013";

COMMENT ON VIEW "BW_iri"."IAO_0000028" IS 'symbol::An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.';

CREATE VIEW "BW_iri"."PHYSIO_0000008" AS
  SELECT "T0014_uid" AS "PHYSIO_0000008_uid"
  FROM "BW"."T0014";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000008" IS 'body weight measurement process::A physiological evaluation that evaluates an organism''s body weight.';

CREATE VIEW "BW_iri"."IAO_0000577" AS
  SELECT "T0015_uid" AS "IAO_0000577_uid"
  FROM "BW"."T0015";

COMMENT ON VIEW "BW_iri"."IAO_0000577" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.';

CREATE VIEW "BW_iri"."OBI_0100026" AS
  SELECT "T0016_uid" AS "OBI_0100026_uid"
  FROM "BW"."T0016";

COMMENT ON VIEW "BW_iri"."OBI_0100026" IS 'organism::A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."IAO_0000109" AS
  SELECT "T0017_uid" AS "IAO_0000109_uid"
  FROM "BW"."T0017";

COMMENT ON VIEW "BW_iri"."IAO_0000109" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.';

CREATE VIEW "BW_iri"."PHYSIO_0000094" AS
  SELECT "T0018_uid" AS "PHYSIO_0000094_uid"
  FROM "BW"."T0018";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000094" IS 'health care record::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.';

CREATE VIEW "BW_iri"."BFO_0000004" AS
  SELECT "T0019_uid" AS "BFO_0000004_uid"
  FROM "BW"."T0019";

COMMENT ON VIEW "BW_iri"."BFO_0000004" IS 'independent continuant::IndependentContinuant';

CREATE VIEW "BW_iri"."PHYSIO_0000091" AS
  SELECT "T001a_uid" AS "PHYSIO_0000091_uid"
  FROM "BW"."T001a";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000091" IS 'physiological evaluation of patient::A physiological evaluation that evaluates a patient''s body weight.';

CREATE VIEW "BW_iri"."OBI_0000011" AS
  SELECT "T001b_uid" AS "OBI_0000011_uid"
  FROM "BW"."T001b";

COMMENT ON VIEW "BW_iri"."OBI_0000011" IS 'planned process::A process that realizes a plan which is the concretization of a plan specification.';

CREATE VIEW "BW_iri"."NCBITaxon_9606" AS
  SELECT "T001c_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."T001c";

COMMENT ON VIEW "BW_iri"."NCBITaxon_9606" IS 'Homo sapiens::Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."UO_0000002" AS
  SELECT "T001d_uid" AS "UO_0000002_uid"
  FROM "BW"."T001d";

COMMENT ON VIEW "BW_iri"."UO_0000002" IS 'mass unit::A unit which is a standard measure of the amount of matter/energy of a physical object.';

CREATE VIEW "BW_iri"."PHYSIO_0000085" AS
  SELECT "T001e_uid" AS "PHYSIO_0000085_uid"
  FROM "BW"."T001e";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000085" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."PHYSIO_0000093" AS
  SELECT "T001f_uid" AS "PHYSIO_0000093_uid"
  FROM "BW"."T001f";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000093" IS 'physiological data item::A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_iri"."OBI_0000093" AS
  SELECT "T0020_uid" AS "OBI_0000093_uid"
  FROM "BW"."T0020";

COMMENT ON VIEW "BW_iri"."OBI_0000093" IS 'patient role::a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_iri"."BFO_0000040" AS
  SELECT "T0021_uid" AS "BFO_0000040_uid"
  FROM "BW"."T0021";

COMMENT ON VIEW "BW_iri"."BFO_0000040" IS 'material entity::An independent continuant that is spatially extended whose identity is independent of that of other entities and can be maintained through time.';

CREATE VIEW "BW_iri"."IAO_0000030" AS
  SELECT "T0022_uid" AS "IAO_0000030_uid"
  FROM "BW"."T0022";

COMMENT ON VIEW "BW_iri"."IAO_0000030" IS 'information content entity::An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity';

CREATE VIEW "BW_iri"."BFO_0000020" AS
  SELECT "T0023_uid" AS "BFO_0000020_uid"
  FROM "BW"."T0023";

COMMENT ON VIEW "BW_iri"."BFO_0000020" IS 'sdc::b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])';

CREATE VIEW "BW_iri"."IAO_0000032" AS
  SELECT "T0024_uid" AS "IAO_0000032_uid"
  FROM "BW"."T0024";

COMMENT ON VIEW "BW_iri"."IAO_0000032" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.';

CREATE VIEW "BW_iri"."BFO_0000002" AS
  SELECT "T0025_uid" AS "BFO_0000002_uid"
  FROM "BW"."T0025";

COMMENT ON VIEW "BW_iri"."BFO_0000002" IS 'continuant::Continuant';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000004_double" AS
  SELECT "T0026_IAO_0000004" AS "T0026_IAO_0000004",  
    "T0024_uid" AS "IAO_0000032_uid"
  FROM "BW"."T0026";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000004_double" IS 'scalar measurement datum has measurement value::IAO_0000032 [1..1] IAO_0000004 double';

CREATE VIEW "BW_iri"."IAO_0000003_PHYSIO_0000100_string" AS
  SELECT "T0027_PHYSIO_0000100" AS "T0027_PHYSIO_0000100",  
    "T0003_uid" AS "IAO_0000003_uid"
  FROM "BW"."T0027";

COMMENT ON VIEW "BW_iri"."IAO_0000003_PHYSIO_0000100_string" IS 'measurement unit label has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000004_Literal" AS
  SELECT "T0024_uid" AS "IAO_0000032_uid",  
    "T0028_IAO_0000004" AS "T0028_IAO_0000004"
  FROM "BW"."T0028";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000004_Literal" IS 'scalar measurement datum has measurement value::DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal)';

CREATE VIEW "BW_iri"."IAO_0000577_PHYSIO_0000100_string" AS
  SELECT "T0029_PHYSIO_0000100" AS "T0029_PHYSIO_0000100",  
    "T0015_uid" AS "IAO_0000577_uid"
  FROM "BW"."T0029";

COMMENT ON VIEW "BW_iri"."IAO_0000577_PHYSIO_0000100_string" IS 'centrally registered identifier symbol has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."PHYSIO_0000065_OBI_0000312_PHYSIO_0000008" AS
  SELECT "T0004_uid" AS "PHYSIO_0000065_uid",  
    "T0014_uid" AS "PHYSIO_0000008_uid"
  FROM "BW"."T002a";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000065_OBI_0000312_PHYSIO_0000008" IS 'human body mass measurement datum is_specified_output_of body weight measurement process::A scalar measurement datum that is a measurement of the mass of a human body. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A physiological evaluation that evaluates an organism''s body weight.';

CREATE VIEW "BW_iri"."PHYSIO_0000083_BFO_0000051_PHYSIO_0000093" AS
  SELECT "T0006_uid" AS "PHYSIO_0000083_uid",  
    "T001f_uid" AS "PHYSIO_0000093_uid"
  FROM "BW"."T002b";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000083_BFO_0000051_PHYSIO_0000093" IS 'physiological evaluation report has_part physiological data item::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_iri"."PHYSIO_0000083_BFO_0000051_HADO_0000006" AS
  SELECT "T0006_uid" AS "PHYSIO_0000083_uid",  
    "T000b_uid" AS "HADO_0000006_uid"
  FROM "BW"."T002c";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000083_BFO_0000051_HADO_0000006" IS 'physiological evaluation report has_part medical record identifier::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_iri"."BFO_0000015_BFO_0000055_BFO_0000017" AS
  SELECT "T0007_uid" AS "BFO_0000015_uid",  
    "T000a_uid" AS "BFO_0000017_uid"
  FROM "BW"."T002d";

COMMENT ON VIEW "BW_iri"."BFO_0000015_BFO_0000055_BFO_0000017" IS 'process realizes realizable entity::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process RealizableEntity';

CREATE VIEW "BW_iri"."HADO_0000008_RO_0000087_OBI_0000093" AS
  SELECT "T0008_uid" AS "HADO_0000008_uid",  
    "T0020_uid" AS "OBI_0000093_uid"
  FROM "BW"."T002e";

COMMENT ON VIEW "BW_iri"."HADO_0000008_RO_0000087_OBI_0000093" IS 'patient has role patient role::Homo sapiens having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_iri"."PHYSIO_0000090_PHYSIO_0000089_NCBITaxon_9606" AS
  SELECT "T0009_uid" AS "PHYSIO_0000090_uid",  
    "T001c_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."T002f";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000090_PHYSIO_0000089_NCBITaxon_9606" IS 'physiological evaluation of human has evaluant Homo sapiens::A physiological evaluation that evaluates a human''s body weight. A has participant property in a evaluation process Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."BFO_0000017_BFO_0000054_BFO_0000015" AS
  SELECT "T000a_uid" AS "BFO_0000017_uid",  
    "T0007_uid" AS "BFO_0000015_uid"
  FROM "BW"."T0030";

COMMENT ON VIEW "BW_iri"."BFO_0000017_BFO_0000054_BFO_0000015" IS 'realizable entity realized in process::RealizableEntity Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

CREATE VIEW "BW_iri"."HADO_0000006_IAO_0000219_ONTORELA_C0025X" AS
  SELECT "T000b_uid" AS "HADO_0000006_uid",  
    "T000c_uid" AS "ONTORELA_C0025X_uid"
  FROM "BW"."T0031";

COMMENT ON VIEW "BW_iri"."HADO_0000006_IAO_0000219_ONTORELA_C0025X" IS 'medical record identifier denotes medical record identifier intersectionOf health care record | is about | patient::A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

CREATE VIEW "BW_iri"."ONTORELA_C0025X_IAO_0000136_HADO_0000008" AS
  SELECT "T000c_uid" AS "ONTORELA_C0025X_uid",  
    "T0008_uid" AS "HADO_0000008_uid"
  FROM "BW"."T0032";

COMMENT ON VIEW "BW_iri"."ONTORELA_C0025X_IAO_0000136_HADO_0000008" IS 'medical record identifier intersectionOf health care record | is about | patient is about patient::medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.';

CREATE VIEW "BW_iri"."BFO_0000031_RO_0000058_BFO_0000020" AS
  SELECT "T000e_uid" AS "BFO_0000031_uid",  
    "T0023_uid" AS "BFO_0000020_uid"
  FROM "BW"."T0033";

COMMENT ON VIEW "BW_iri"."BFO_0000031_RO_0000058_BFO_0000020" IS 'gdc is concretized as sdc::b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001]) A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])';

CREATE VIEW "BW_iri"."BFO_0000001_BFO_0000050_BFO_0000001" AS
  SELECT "T0010_uid_domain" AS "BFO_0000001_uid_domain",  
    "T0010_uid_range" AS "BFO_0000001_uid_range"
  FROM "BW"."T0034";

COMMENT ON VIEW "BW_iri"."BFO_0000001_BFO_0000050_BFO_0000001" IS 'entity part of entity::Entity 
a core relation that holds between a part and its whole
 Entity';

CREATE VIEW "BW_iri"."BFO_0000003_BFO_0000066_BFO_0000004" AS
  SELECT "T0012_uid" AS "BFO_0000003_uid",  
    "T0019_uid" AS "BFO_0000004_uid"
  FROM "BW"."T0035";

COMMENT ON VIEW "BW_iri"."BFO_0000003_BFO_0000066_BFO_0000004" IS 'occurrent occurs in independent continuant::Occurrent b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t IndependentContinuant';

CREATE VIEW "BW_iri"."BFO_0000003_RO_0000057_BFO_0000002" AS
  SELECT "T0012_uid" AS "BFO_0000003_uid",  
    "T0025_uid" AS "BFO_0000002_uid"
  FROM "BW"."T0036";

COMMENT ON VIEW "BW_iri"."BFO_0000003_RO_0000057_BFO_0000002" IS 'occurrent has participant continuant::Occurrent a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant';

CREATE VIEW "BW_iri"."IAO_0000109_IAO_0000039_IAO_0000003" AS
  SELECT "T0017_uid" AS "IAO_0000109_uid",  
    "T0003_uid" AS "IAO_0000003_uid"
  FROM "BW"."T0037";

COMMENT ON VIEW "BW_iri"."IAO_0000109_IAO_0000039_IAO_0000003" IS 'measurement datum has measurement unit label measurement unit label::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_iri"."IAO_0000109_OBI_0001938_OBI_0001933" AS
  SELECT "T0017_uid" AS "IAO_0000109_uid",  
    "T000f_uid" AS "OBI_0001933_uid"
  FROM "BW"."T0038";

COMMENT ON VIEW "BW_iri"."IAO_0000109_OBI_0001938_OBI_0001933" IS 'measurement datum has value specification value specification::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null An information content entity that specifies a value within a classification scheme or on a quantitative scale.';

CREATE VIEW "BW_iri"."PHYSIO_0000094_IAO_0000136_OBI_0100026" AS
  SELECT "T0018_uid" AS "PHYSIO_0000094_uid",  
    "T0016_uid" AS "OBI_0100026_uid"
  FROM "BW"."T0039";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000094_IAO_0000136_OBI_0100026" IS 'health care record is about organism::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."BFO_0000004_RO_0000087_BFO_0000023" AS
  SELECT "T0019_uid" AS "BFO_0000004_uid",  
    "T0011_uid" AS "BFO_0000023_uid"
  FROM "BW"."T003a";

COMMENT ON VIEW "BW_iri"."BFO_0000004_RO_0000087_BFO_0000023" IS 'independent continuant has role role::IndependentContinuant a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

CREATE VIEW "BW_iri"."BFO_0000004_RO_0001025_BFO_0000004" AS
  SELECT "T0019_uid_domain" AS "BFO_0000004_uid_domain",  
    "T0019_uid_range" AS "BFO_0000004_uid_range"
  FROM "BW"."T003b";

COMMENT ON VIEW "BW_iri"."BFO_0000004_RO_0001025_BFO_0000004" IS 'independent continuant located in independent continuant::IndependentContinuant a relation between two independent continuants, the target and the location, in which the target is entirely within the location IndependentContinuant';

CREATE VIEW "BW_iri"."PHYSIO_0000091_PHYSIO_0000089_HADO_0000008" AS
  SELECT "T001a_uid" AS "PHYSIO_0000091_uid",  
    "T0008_uid" AS "HADO_0000008_uid"
  FROM "BW"."T003c";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000091_PHYSIO_0000089_HADO_0000008" IS 'physiological evaluation of patient has evaluant patient::A physiological evaluation that evaluates a patient''s body weight. A has participant property in a evaluation process Homo sapiens having the role of patient.';

CREATE VIEW "BW_iri"."PHYSIO_0000085_PHYSIO_0000089_OBI_0100026" AS
  SELECT "T001e_uid" AS "PHYSIO_0000085_uid",  
    "T0016_uid" AS "OBI_0100026_uid"
  FROM "BW"."T003d";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000085_PHYSIO_0000089_OBI_0100026" IS 'physiological evaluation has evaluant organism::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."PHYSIO_0000093_OBI_0000312_PHYSIO_0000085" AS
  SELECT "T001f_uid" AS "PHYSIO_0000093_uid",  
    "T001e_uid" AS "PHYSIO_0000085_uid"
  FROM "BW"."T003e";

COMMENT ON VIEW "BW_iri"."PHYSIO_0000093_OBI_0000312_PHYSIO_0000085" IS 'physiological data item is_specified_output_of physiological evaluation::A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."OBI_0000093_RO_0000052_NCBITaxon_9606" AS
  SELECT "T0020_uid" AS "OBI_0000093_uid",  
    "T001c_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."T003f";

COMMENT ON VIEW "BW_iri"."OBI_0000093_RO_0000052_NCBITaxon_9606" IS 'patient role inheres in Homo sapiens::a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."IAO_0000030_IAO_0000136_BFO_0000001" AS
  SELECT "T0022_uid" AS "IAO_0000030_uid",  
    "T0010_uid" AS "BFO_0000001_uid"
  FROM "BW"."T0040";

COMMENT ON VIEW "BW_iri"."IAO_0000030_IAO_0000136_BFO_0000001" IS 'information content entity is about entity::An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity is_about is a (currently) primitive relation that relates an information artifact to an entity. Entity';

CREATE VIEW "BW_iri"."IAO_0000030_IAO_0000219_BFO_0000001" AS
  SELECT "T0022_uid" AS "IAO_0000030_uid",  
    "T0010_uid" AS "BFO_0000001_uid"
  FROM "BW"."T0041";

COMMENT ON VIEW "BW_iri"."IAO_0000030_IAO_0000219_BFO_0000001" IS 'information content entity denotes entity::An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity null Entity';

CREATE VIEW "BW_iri"."BFO_0000020_RO_0000059_BFO_0000031" AS
  SELECT "T0023_uid" AS "BFO_0000020_uid",  
    "T000e_uid" AS "BFO_0000031_uid"
  FROM "BW"."T0042";

COMMENT ON VIEW "BW_iri"."BFO_0000020_RO_0000059_BFO_0000031" IS 'sdc concretizes gdc::b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003]) A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001])';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000039_Thing" AS
  SELECT "T0024_uid" AS "IAO_0000032_uid",  
    "T0000_uid" AS "Thing_uid"
  FROM "BW"."T0043";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000039_Thing" IS 'scalar measurement datum has measurement unit label Thing::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null The class owl:Thing is the class of all individuals.';

CREATE VIEW "BW_iri"."IAO_0000032_OBI_0001938_OBI_0001931" AS
  SELECT "T0024_uid" AS "IAO_0000032_uid",  
    "T000d_uid" AS "OBI_0001931_uid"
  FROM "BW"."T0044";

COMMENT ON VIEW "BW_iri"."IAO_0000032_OBI_0001938_OBI_0001931" IS 'scalar measurement datum has value specification scalar value specification::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A value specification that consists of two parts: a numeral and a unit label';

CREATE VIEW "BW_iri"."BFO_0000002_RO_0000056_BFO_0000003" AS
  SELECT "T0025_uid" AS "BFO_0000002_uid",  
    "T0012_uid" AS "BFO_0000003_uid"
  FROM "BW"."T0045";

COMMENT ON VIEW "BW_iri"."BFO_0000002_RO_0000056_BFO_0000003" IS 'continuant participates in occurrent::Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process Occurrent';


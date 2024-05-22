/*
-- =========================================================================== A
Schema : BW_iri
Creation Date : 20240515-1537
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

COMMENT ON SCHEMA "BW_iri" IS 'Create views with short IRI of BW_iri 20240515-1537';

CREATE VIEW "BW_iri"."Thing" AS
  SELECT "Thing_uid" AS "Thing_uid"
  FROM "BW"."Thing";

COMMENT ON VIEW "BW_iri"."Thing" IS 'Thing::Top table';

CREATE VIEW "BW_iri"."IAO_0000009" AS
  SELECT "IAO_0000009_uid" AS "IAO_0000009_uid"
  FROM "BW"."IAO_0000009";

COMMENT ON VIEW "BW_iri"."IAO_0000009" IS 'datum label::A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label';

CREATE VIEW "BW_iri"."HBW_0000026" AS
  SELECT "HBW_0000026_uid" AS "HBW_0000026_uid"
  FROM "BW"."HBW_0000026";

COMMENT ON VIEW "BW_iri"."HBW_0000026" IS 'HBW_0000026::A scalar measurement datum composed of two parts: a Decimal and a weight unit label.';

CREATE VIEW "BW_iri"."HBW_0000006" AS
  SELECT "HBW_0000006_uid" AS "HBW_0000006_uid"
  FROM "BW"."HBW_0000006";

COMMENT ON VIEW "BW_iri"."HBW_0000006" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_iri"."HBW_0000022" AS
  SELECT "HBW_0000022_uid" AS "HBW_0000022_uid"
  FROM "BW"."HBW_0000022";

COMMENT ON VIEW "BW_iri"."HBW_0000022" IS 'human name::An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens.';

CREATE VIEW "BW_iri"."HBW_0000002" AS
  SELECT "HBW_0000002_uid" AS "HBW_0000002_uid"
  FROM "BW"."HBW_0000002";

COMMENT ON VIEW "BW_iri"."HBW_0000002" IS 'RAMQ vulnerability code::A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.';

CREATE VIEW "BW_iri"."OMRSE_00000209" AS
  SELECT "OMRSE_00000209_uid" AS "OMRSE_00000209_uid"
  FROM "BW"."OMRSE_00000209";

COMMENT ON VIEW "BW_iri"."OMRSE_00000209" IS 'gender identity information content entity::A social identity information content entity that is about whether some person identifies as some gender.';

CREATE VIEW "BW_iri"."HBW_0000014" AS
  SELECT "HBW_0000014_uid" AS "HBW_0000014_uid"
  FROM "BW"."HBW_0000014";

COMMENT ON VIEW "BW_iri"."HBW_0000014" IS 'obesity::A disease marked by an abnormally high, unhealthy amount of body fat.; A disorder characterized by having an increased body fat.';

CREATE VIEW "BW_iri"."HBW_0000010" AS
  SELECT "HBW_0000010_uid" AS "HBW_0000010_uid"
  FROM "BW"."HBW_0000010";

COMMENT ON VIEW "BW_iri"."HBW_0000010" IS 'health care provider role::A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

CREATE VIEW "BW_iri"."VO_0004895" AS
  SELECT "VO_0004895_uid" AS "VO_0004895_uid"
  FROM "BW"."VO_0004895";

COMMENT ON VIEW "BW_iri"."VO_0004895" IS 'female biological sex datum::A biological sex datum that represents the biological sex of an animal (including human) as being female.';

CREATE VIEW "BW_iri"."BFO_0000016" AS
  SELECT "BFO_0000016_uid" AS "BFO_0000016_uid"
  FROM "BW"."BFO_0000016";

COMMENT ON VIEW "BW_iri"."BFO_0000016" IS 'disposition::Disposition';

CREATE VIEW "BW_iri"."BFO_0000004" AS
  SELECT "BFO_0000004_uid" AS "BFO_0000004_uid"
  FROM "BW"."BFO_0000004";

COMMENT ON VIEW "BW_iri"."BFO_0000004" IS 'ic::A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything.';

CREATE VIEW "BW_iri"."OGMS_0000031" AS
  SELECT "OGMS_0000031_uid" AS "OGMS_0000031_uid"
  FROM "BW"."OGMS_0000031";

COMMENT ON VIEW "BW_iri"."OGMS_0000031" IS 'disease::A disposition (i) to undergo pathological processes that (ii) exists in an organism because of one or more disorders in that organism.';

CREATE VIEW "BW_iri"."ONTORELA_C2986e108" AS
  SELECT "ONTORELA_C2986e108_uid" AS "ONTORELA_C2986e108_uid"
  FROM "BW"."ONTORELA_C2986e108";

COMMENT ON VIEW "BW_iri"."ONTORELA_C2986e108" IS '(disposition or quality)
 and (inheres in some organism)::data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."BFO_0000020" AS
  SELECT "BFO_0000020_uid" AS "BFO_0000020_uid"
  FROM "BW"."BFO_0000020";

COMMENT ON VIEW "BW_iri"."BFO_0000020" IS 'sdc::SpecificallyDependentContinuant';

CREATE VIEW "BW_iri"."ONTORELA_C61c354fb" AS
  SELECT "ONTORELA_C61c354fb_uid" AS "ONTORELA_C61c354fb_uid"
  FROM "BW"."ONTORELA_C61c354fb";

COMMENT ON VIEW "BW_iri"."ONTORELA_C61c354fb" IS 'data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))::physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."NOYO_0000050" AS
  SELECT "NOYO_0000050_uid" AS "NOYO_0000050_uid"
  FROM "BW"."NOYO_0000050";

COMMENT ON VIEW "BW_iri"."NOYO_0000050" IS 'birth statement::A statement about the information surrounding the birth of a human.';

CREATE VIEW "BW_iri"."BFO_0000040" AS
  SELECT "BFO_0000040_uid" AS "BFO_0000040_uid"
  FROM "BW"."BFO_0000040";

COMMENT ON VIEW "BW_iri"."BFO_0000040" IS 'material entity::An independent continuant that is spatially extended whose identity is independent of that of other entities and can be maintained through time.';

CREATE VIEW "BW_iri"."HBW_0000005" AS
  SELECT "HBW_0000005_uid" AS "HBW_0000005_uid"
  FROM "BW"."HBW_0000005";

COMMENT ON VIEW "BW_iri"."HBW_0000005" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."IOIO_0000012" AS
  SELECT "IOIO_0000012_uid" AS "IOIO_0000012_uid"
  FROM "BW"."IOIO_0000012";

COMMENT ON VIEW "BW_iri"."IOIO_0000012" IS 'human biological sex or gender identity information content entity::An information content entity that denotes a biological sex or a gender identity of a human.';

CREATE VIEW "BW_iri"."IAO_0000028" AS
  SELECT "IAO_0000028_uid" AS "IAO_0000028_uid"
  FROM "BW"."IAO_0000028";

COMMENT ON VIEW "BW_iri"."IAO_0000028" IS 'symbol::An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.';

CREATE VIEW "BW_iri"."HBW_0000001" AS
  SELECT "HBW_0000001_uid" AS "HBW_0000001_uid"
  FROM "BW"."HBW_0000001";

COMMENT ON VIEW "BW_iri"."HBW_0000001" IS 'physiological data item::A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_iri"."HBW_0000013" AS
  SELECT "HBW_0000013_uid" AS "HBW_0000013_uid"
  FROM "BW"."HBW_0000013";

COMMENT ON VIEW "BW_iri"."HBW_0000013" IS 'physiological evaluation from health care provider::A physiological evaluation that is evaluated by a health care provider';

CREATE VIEW "BW_iri"."IAO_0000109" AS
  SELECT "IAO_0000109_uid" AS "IAO_0000109_uid"
  FROM "BW"."IAO_0000109";

COMMENT ON VIEW "BW_iri"."IAO_0000109" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.';

CREATE VIEW "BW_iri"."HBW_0000025" AS
  SELECT "HBW_0000025_uid" AS "HBW_0000025_uid"
  FROM "BW"."HBW_0000025";

COMMENT ON VIEW "BW_iri"."HBW_0000025" IS 'female biological sex or gender identity information content entity::A biological sex or gender identity datum that is intended to denote a female biological sex or a female gender identity.';

CREATE VIEW "BW_iri"."IAO_0020015" AS
  SELECT "IAO_0020015_uid" AS "IAO_0020015_uid"
  FROM "BW"."IAO_0020015";

COMMENT ON VIEW "BW_iri"."IAO_0020015" IS 'personal name::Personal names to not include names of fictional characters, e.g. Sherlock Holmes.';

CREATE VIEW "BW_iri"."IAO_0000032" AS
  SELECT "IAO_0000032_uid" AS "IAO_0000032_uid"
  FROM "BW"."IAO_0000032";

COMMENT ON VIEW "BW_iri"."IAO_0000032" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.';

CREATE VIEW "BW_iri"."OBI_0100026" AS
  SELECT "OBI_0100026_uid" AS "OBI_0100026_uid"
  FROM "BW"."OBI_0100026";

COMMENT ON VIEW "BW_iri"."OBI_0100026" IS 'organism::A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."OMRSE_00000210" AS
  SELECT "OMRSE_00000210_uid" AS "OMRSE_00000210_uid"
  FROM "BW"."OMRSE_00000210";

COMMENT ON VIEW "BW_iri"."OMRSE_00000210" IS 'female gender identity information content entity::A gender identity information content entity that is about some person''s identifying as female in gender.';

CREATE VIEW "BW_iri"."IAO_0000577" AS
  SELECT "IAO_0000577_uid" AS "IAO_0000577_uid"
  FROM "BW"."IAO_0000577";

COMMENT ON VIEW "BW_iri"."IAO_0000577" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.';

CREATE VIEW "BW_iri"."VO_0004896" AS
  SELECT "VO_0004896_uid" AS "VO_0004896_uid"
  FROM "BW"."VO_0004896";

COMMENT ON VIEW "BW_iri"."VO_0004896" IS 'intersex biological sex datum::A biological sex measurement datum that is intended to denote an intersex biological sex.';

CREATE VIEW "BW_iri"."BFO_0000017" AS
  SELECT "BFO_0000017_uid" AS "BFO_0000017_uid"
  FROM "BW"."BFO_0000017";

COMMENT ON VIEW "BW_iri"."BFO_0000017" IS 'realizable entity::A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.';

CREATE VIEW "BW_iri"."OBI_0000011" AS
  SELECT "OBI_0000011_uid" AS "OBI_0000011_uid"
  FROM "BW"."OBI_0000011";

COMMENT ON VIEW "BW_iri"."OBI_0000011" IS 'planned process::A process that realizes a plan which is the concretization of a plan specification.';

CREATE VIEW "BW_iri"."BFO_0000001" AS
  SELECT "BFO_0000001_uid" AS "BFO_0000001_uid"
  FROM "BW"."BFO_0000001";

COMMENT ON VIEW "BW_iri"."BFO_0000001" IS 'entity::A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."VO_0001194" AS
  SELECT "VO_0001194_uid" AS "VO_0001194_uid"
  FROM "BW"."VO_0001194";

COMMENT ON VIEW "BW_iri"."VO_0001194" IS 'biological sex datum::A measurement datum that represents the biological sex of an animal. The result can be represented using a discretized digit, for example, 0 = female; 1 = male.';

CREATE VIEW "BW_iri"."HBW_0000009" AS
  SELECT "HBW_0000009_uid" AS "HBW_0000009_uid"
  FROM "BW"."HBW_0000009";

COMMENT ON VIEW "BW_iri"."HBW_0000009" IS 'body weight::a quality of a body of having a weight';

CREATE VIEW "BW_iri"."HBW_0000004" AS
  SELECT "HBW_0000004_uid" AS "HBW_0000004_uid"
  FROM "BW"."HBW_0000004";

COMMENT ON VIEW "BW_iri"."HBW_0000004" IS 'health care record::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.';

CREATE VIEW "BW_iri"."ONTORELA_C4d0c3f45" AS
  SELECT "ONTORELA_C4d0c3f45_uid" AS "ONTORELA_C4d0c3f45_uid"
  FROM "BW"."ONTORELA_C4d0c3f45";

COMMENT ON VIEW "BW_iri"."ONTORELA_C4d0c3f45" IS 'health care record
 and (is about some patient)::medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient.';

CREATE VIEW "BW_iri"."NOYO_0000013" AS
  SELECT "NOYO_0000013_uid" AS "NOYO_0000013_uid"
  FROM "BW"."NOYO_0000013";

COMMENT ON VIEW "BW_iri"."NOYO_0000013" IS 'statement::An informational entity that is considered valid by some agent at some point in time. (TBD)';

CREATE VIEW "BW_iri"."IAO_0020000" AS
  SELECT "IAO_0020000_uid" AS "IAO_0020000_uid"
  FROM "BW"."IAO_0020000";

COMMENT ON VIEW "BW_iri"."IAO_0020000" IS 'identifier::An information content entity that is the outcome of a dubbing process and is used to refer to one instance of entity shared by a group of people to refer to that individual entity.';

CREATE VIEW "BW_iri"."HBW_0000012" AS
  SELECT "HBW_0000012_uid" AS "HBW_0000012_uid"
  FROM "BW"."HBW_0000012";

COMMENT ON VIEW "BW_iri"."HBW_0000012" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."HBW_0000024" AS
  SELECT "HBW_0000024_uid" AS "HBW_0000024_uid"
  FROM "BW"."HBW_0000024";

COMMENT ON VIEW "BW_iri"."HBW_0000024" IS 'intersex biological sex or non-binary gender identity information content entity::A biological sex or gender identity datum that is intended to denote a intersex biological sex or a non-binary gender identity.';

CREATE VIEW "BW_iri"."OMRSE_00000211" AS
  SELECT "OMRSE_00000211_uid" AS "OMRSE_00000211_uid"
  FROM "BW"."OMRSE_00000211";

COMMENT ON VIEW "BW_iri"."OMRSE_00000211" IS 'male gender identity information content entity::A gender identity information content entity that is about some person''s identifying as male in gender.';

CREATE VIEW "BW_iri"."IAO_0000027" AS
  SELECT "IAO_0000027_uid" AS "IAO_0000027_uid"
  FROM "BW"."IAO_0000027";

COMMENT ON VIEW "BW_iri"."IAO_0000027" IS 'data item::a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.';

CREATE VIEW "BW_iri"."IAO_0000310" AS
  SELECT "IAO_0000310_uid" AS "IAO_0000310_uid"
  FROM "BW"."IAO_0000310";

COMMENT ON VIEW "BW_iri"."IAO_0000310" IS 'document::An information content entity that is a collection of information content entities intended to be understood together as a whole.';

CREATE VIEW "BW_iri"."IAO_0000003" AS
  SELECT "IAO_0000003_uid" AS "IAO_0000003_uid"
  FROM "BW"."IAO_0000003";

COMMENT ON VIEW "BW_iri"."IAO_0000003" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_iri"."IAO_0000030" AS
  SELECT "IAO_0000030_uid" AS "IAO_0000030_uid"
  FROM "BW"."IAO_0000030";

COMMENT ON VIEW "BW_iri"."IAO_0000030" IS 'information content entity::A generically dependent continuant that is about some thing.';

CREATE VIEW "BW_iri"."BFO_0000002" AS
  SELECT "BFO_0000002_uid" AS "BFO_0000002_uid"
  FROM "BW"."BFO_0000002";

COMMENT ON VIEW "BW_iri"."BFO_0000002" IS 'continuant::Continuant';

CREATE VIEW "BW_iri"."HBW_0000008" AS
  SELECT "HBW_0000008_uid" AS "HBW_0000008_uid"
  FROM "BW"."HBW_0000008";

COMMENT ON VIEW "BW_iri"."HBW_0000008" IS 'health care provider::A homo sapiens having with the health care provider role';

CREATE VIEW "BW_iri"."VO_0000613" AS
  SELECT "VO_0000613_uid" AS "VO_0000613_uid"
  FROM "BW"."VO_0000613";

COMMENT ON VIEW "BW_iri"."VO_0000613" IS 'male biological sex datum::A biological sex measurement datum that is intended to denote a male biological sex.';

CREATE VIEW "BW_iri"."OMRSE_00000204" AS
  SELECT "OMRSE_00000204_uid" AS "OMRSE_00000204_uid"
  FROM "BW"."OMRSE_00000204";

COMMENT ON VIEW "BW_iri"."OMRSE_00000204" IS 'social identity information content entity::We include (i)-(iii) to acknowledge that there are different senses of "identify" that are relevant here, and that we may not always be sure which sense the person concretizing the social identity information content entity intended. While (i) concerns how one thinks of oneself, (ii) and (iii) are more focused on one''s interactions with others. Importantly, some choose not to share with others how they identify in the sense of (i). For example, one can consider oneself to be some certain gender without either wanting others to know or choosing to present oneself in a corresponding way. We distinguish (ii) and (iii) because one can prefer to be regarded some certain way without attempting to present oneself in any corresponding way.';

CREATE VIEW "BW_iri"."NOYO_0000012" AS
  SELECT "NOYO_0000012_uid" AS "NOYO_0000012_uid"
  FROM "BW"."NOYO_0000012";

COMMENT ON VIEW "BW_iri"."NOYO_0000012" IS 'informational entity::A generically dependent continuant that is a building block of information or a combination thereof.';

CREATE VIEW "BW_iri"."HBW_0000007" AS
  SELECT "HBW_0000007_uid" AS "HBW_0000007_uid"
  FROM "BW"."HBW_0000007";

COMMENT ON VIEW "BW_iri"."HBW_0000007" IS 'patient::An organism having the role of patient.';

CREATE VIEW "BW_iri"."HBW_0000011" AS
  SELECT "HBW_0000011_uid" AS "HBW_0000011_uid"
  FROM "BW"."HBW_0000011";

COMMENT ON VIEW "BW_iri"."HBW_0000011" IS 'patient role::a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_iri"."HBW_0000023" AS
  SELECT "HBW_0000023_uid" AS "HBW_0000023_uid"
  FROM "BW"."HBW_0000023";

COMMENT ON VIEW "BW_iri"."HBW_0000023" IS 'male biological sex or gender identity information content entity::A biological sex or gender identity datum that is intended to denote a male biological sex or a male gender identity.';

CREATE VIEW "BW_iri"."HBW_0000003" AS
  SELECT "HBW_0000003_uid" AS "HBW_0000003_uid"
  FROM "BW"."HBW_0000003";

COMMENT ON VIEW "BW_iri"."HBW_0000003" IS 'weight unit::a measurement unit label of a weight';

CREATE VIEW "BW_iri"."NCBITaxon_9606" AS
  SELECT "NCBITaxon_9606_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."NCBITaxon_9606";

COMMENT ON VIEW "BW_iri"."NCBITaxon_9606" IS 'Homo sapiens::Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."IAO_0020017" AS
  SELECT "IAO_0020017_uid" AS "IAO_0020017_uid"
  FROM "BW"."IAO_0020017";

COMMENT ON VIEW "BW_iri"."IAO_0020017" IS 'family name::An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children.';

CREATE VIEW "BW_iri"."OMRSE_00000212" AS
  SELECT "OMRSE_00000212_uid" AS "OMRSE_00000212_uid"
  FROM "BW"."OMRSE_00000212";

COMMENT ON VIEW "BW_iri"."OMRSE_00000212" IS 'non-binary identity information content entity::A gender identity information content entity that is about some person''s identifying as non-binary in gender.';

CREATE VIEW "BW_iri"."BFO_0000019" AS
  SELECT "BFO_0000019_uid" AS "BFO_0000019_uid"
  FROM "BW"."BFO_0000019";

COMMENT ON VIEW "BW_iri"."BFO_0000019" IS 'quality::a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized';

CREATE VIEW "BW_iri"."BFO_0000015" AS
  SELECT "BFO_0000015_uid" AS "BFO_0000015_uid"
  FROM "BW"."BFO_0000015";

COMMENT ON VIEW "BW_iri"."BFO_0000015" IS 'process::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

CREATE VIEW "BW_iri"."BFO_0000003" AS
  SELECT "BFO_0000003_uid" AS "BFO_0000003_uid"
  FROM "BW"."BFO_0000003";

COMMENT ON VIEW "BW_iri"."BFO_0000003" IS 'occurrent::Occurrent';

CREATE VIEW "BW_iri"."ONTORELA_C1edc1ccd" AS
  SELECT "ONTORELA_C1edc1ccd_uid" AS "ONTORELA_C1edc1ccd_uid"
  FROM "BW"."ONTORELA_C1edc1ccd";

COMMENT ON VIEW "BW_iri"."ONTORELA_C1edc1ccd" IS 'disposition or quality::(disposition or quality)
 and (inheres in some organism)Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality';

CREATE VIEW "BW_iri"."BFO_0000023" AS
  SELECT "BFO_0000023_uid" AS "BFO_0000023_uid"
  FROM "BW"."BFO_0000023";

COMMENT ON VIEW "BW_iri"."BFO_0000023" IS 'role::Role';

CREATE VIEW "BW_iri"."BFO_0000031" AS
  SELECT "BFO_0000031_uid" AS "BFO_0000031_uid"
  FROM "BW"."BFO_0000031";

COMMENT ON VIEW "BW_iri"."BFO_0000031" IS 'gdc::A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000004_double" AS
  SELECT "IAO_0000032_IAO_0000004_double_IAO_0000004" AS "IAO_0000032_IAO_0000004_double_IAO_0000004",  
    "IAO_0000032_uid" AS "IAO_0000032_uid"
  FROM "BW"."IAO_0000032_IAO_0000004_double";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000004_double" IS 'scalar measurement datum has measurement value::IAO_0000032 [1..1] IAO_0000004 double';

CREATE VIEW "BW_iri"."IAO_0000577_PHYSIO_0000100_string" AS
  SELECT "IAO_0000577_PHYSIO_0000100_string_PHYSIO_0000100" AS "IAO_0000577_PHYSIO_0000100_string_PHYSIO_0000100",  
    "IAO_0000577_uid" AS "IAO_0000577_uid"
  FROM "BW"."IAO_0000577_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_iri"."IAO_0000577_PHYSIO_0000100_string" IS 'centrally registered identifier symbol has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."HBW_0000026_IAO_0000004_decimal" AS
  SELECT "HBW_0000026_uid" AS "HBW_0000026_uid",  
    "HBW_0000026_IAO_0000004_decimal_IAO_0000004" AS "HBW_0000026_IAO_0000004_decimal_IAO_0000004"
  FROM "BW"."HBW_0000026_IAO_0000004_decimal";

COMMENT ON VIEW "BW_iri"."HBW_0000026_IAO_0000004_decimal" IS 'HBW_0000026 has measurement value::DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> xsd:decimal)';

CREATE VIEW "BW_iri"."IAO_0000003_PHYSIO_0000100_string" AS
  SELECT "IAO_0000003_PHYSIO_0000100_string_PHYSIO_0000100" AS "IAO_0000003_PHYSIO_0000100_string_PHYSIO_0000100",  
    "IAO_0000003_uid" AS "IAO_0000003_uid"
  FROM "BW"."IAO_0000003_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_iri"."IAO_0000003_PHYSIO_0000100_string" IS 'measurement unit label has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."IAO_0020015_PHYSIO_0000100_string" AS
  SELECT "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100" AS "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100",  
    "IAO_0020015_uid" AS "IAO_0020015_uid"
  FROM "BW"."IAO_0020015_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_iri"."IAO_0020015_PHYSIO_0000100_string" IS 'personal name has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."HBW_0000002_PHYSIO_0000100_string" AS
  SELECT "HBW_0000002_PHYSIO_0000100_string_PHYSIO_0000100" AS "HBW_0000002_PHYSIO_0000100_string_PHYSIO_0000100",  
    "HBW_0000002_uid" AS "HBW_0000002_uid"
  FROM "BW"."HBW_0000002_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_iri"."HBW_0000002_PHYSIO_0000100_string" IS 'RAMQ vulnerability code has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000004_Literal" AS
  SELECT "IAO_0000032_uid" AS "IAO_0000032_uid",  
    "IAO_0000032_IAO_0000004_Literal_IAO_0000004" AS "IAO_0000032_IAO_0000004_Literal_IAO_0000004"
  FROM "BW"."IAO_0000032_IAO_0000004_Literal";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000004_Literal" IS 'scalar measurement datum has measurement value::DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal)';

CREATE VIEW "BW_iri"."IAO_0020017_PHYSIO_0000100_string" AS
  SELECT "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100" AS "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100",  
    "IAO_0020017_uid" AS "IAO_0020017_uid"
  FROM "BW"."IAO_0020017_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_iri"."IAO_0020017_PHYSIO_0000100_string" IS 'family name has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_iri"."HBW_0000026_IAO_0000039_HBW_0000003" AS
  SELECT "HBW_0000026_uid" AS "HBW_0000026_uid",  
    "HBW_0000003_uid" AS "HBW_0000003_uid"
  FROM "BW"."HBW_0000026_IAO_0000039_HBW_0000003";

COMMENT ON VIEW "BW_iri"."HBW_0000026_IAO_0000039_HBW_0000003" IS 'HBW_0000026 has measurement unit label weight unit::A scalar measurement datum composed of two parts: a Decimal and a weight unit label. null a measurement unit label of a weight';

CREATE VIEW "BW_iri"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" AS
  SELECT "HBW_0000006_uid" AS "HBW_0000006_uid",  
    "ONTORELA_C4d0c3f45_uid" AS "ONTORELA_C4d0c3f45_uid"
  FROM "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45";

COMMENT ON VIEW "BW_iri"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" IS 'medical record identifier denotes health care record
 and (is about some patient)::A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient.';

CREATE VIEW "BW_iri"."HBW_0000022_BFO_0000051_IAO_0020017" AS
  SELECT "HBW_0000022_uid" AS "HBW_0000022_uid",  
    "IAO_0020017_uid" AS "IAO_0020017_uid"
  FROM "BW"."HBW_0000022_BFO_0000051_IAO_0020017";

COMMENT ON VIEW "BW_iri"."HBW_0000022_BFO_0000051_IAO_0020017" IS 'human name has part family name::An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. 
a core relation that holds between a whole and its part
 An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children.';

CREATE VIEW "BW_iri"."HBW_0000022_BFO_0000051_IAO_0020015" AS
  SELECT "HBW_0000022_uid" AS "HBW_0000022_uid",  
    "IAO_0020015_uid" AS "IAO_0020015_uid"
  FROM "BW"."HBW_0000022_BFO_0000051_IAO_0020015";

COMMENT ON VIEW "BW_iri"."HBW_0000022_BFO_0000051_IAO_0020015" IS 'human name has part personal name::An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. 
a core relation that holds between a whole and its part
 Personal names to not include names of fictional characters, e.g. Sherlock Holmes.';

CREATE VIEW "BW_iri"."HBW_0000022_IAO_0000219_NCBITaxon_9606" AS
  SELECT "HBW_0000022_uid" AS "HBW_0000022_uid",  
    "NCBITaxon_9606_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606";

COMMENT ON VIEW "BW_iri"."HBW_0000022_IAO_0000219_NCBITaxon_9606" IS 'human name denotes Homo sapiens::An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. null Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."BFO_0000004_RO_0000087_BFO_0000023" AS
  SELECT "BFO_0000004_uid" AS "BFO_0000004_uid",  
    "BFO_0000023_uid" AS "BFO_0000023_uid"
  FROM "BW"."BFO_0000004_RO_0000087_BFO_0000023";

COMMENT ON VIEW "BW_iri"."BFO_0000004_RO_0000087_BFO_0000023" IS 'ic has role role::A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence Role';

CREATE VIEW "BW_iri"."BFO_0000004_RO_0001025_BFO_0000004" AS
  SELECT "BFO_0000004_uid_domain" AS "BFO_0000004_uid_domain",  
    "BFO_0000004_uid_range" AS "BFO_0000004_uid_range"
  FROM "BW"."BFO_0000004_RO_0001025_BFO_0000004";

COMMENT ON VIEW "BW_iri"."BFO_0000004_RO_0001025_BFO_0000004" IS 'ic located in ic::A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything. a relation between two independent continuants, the target and the location, in which the target is entirely within the location A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything.';

CREATE VIEW "BW_iri"."ONTORELA_C2986e108_RO_0000052_OBI_0100026" AS
  SELECT "ONTORELA_C2986e108_uid" AS "ONTORELA_C2986e108_uid",  
    "OBI_0100026_uid" AS "OBI_0100026_uid"
  FROM "BW"."ONTORELA_C2986e108_RO_0000052_OBI_0100026";

COMMENT ON VIEW "BW_iri"."ONTORELA_C2986e108_RO_0000052_OBI_0100026" IS '(disposition or quality)
 and (inheres in some organism) inheres in organism::data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."BFO_0000020_RO_0000059_BFO_0000031" AS
  SELECT "BFO_0000020_uid" AS "BFO_0000020_uid",  
    "BFO_0000031_uid" AS "BFO_0000031_uid"
  FROM "BW"."BFO_0000020_RO_0000059_BFO_0000031";

COMMENT ON VIEW "BW_iri"."BFO_0000020_RO_0000059_BFO_0000031" IS 'sdc concretizes gdc::SpecificallyDependentContinuant A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

CREATE VIEW "BW_iri"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" AS
  SELECT "ONTORELA_C61c354fb_uid" AS "ONTORELA_C61c354fb_uid",  
    "ONTORELA_C2986e108_uid" AS "ONTORELA_C2986e108_uid"
  FROM "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108";

COMMENT ON VIEW "BW_iri"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" IS 'data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism))) is about (disposition or quality)
 and (inheres in some organism)::physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. is_about is a (currently) primitive relation that relates an information artifact to an entity. data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."NOYO_0000050_IAO_0000136_NCBITaxon_9606" AS
  SELECT "NOYO_0000050_uid" AS "NOYO_0000050_uid",  
    "NCBITaxon_9606_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606";

COMMENT ON VIEW "BW_iri"."NOYO_0000050_IAO_0000136_NCBITaxon_9606" IS 'birth statement is about Homo sapiens::A statement about the information surrounding the birth of a human. is_about is a (currently) primitive relation that relates an information artifact to an entity. Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."HBW_0000005_BFO_0000051_HBW_0000001" AS
  SELECT "HBW_0000005_uid" AS "HBW_0000005_uid",  
    "HBW_0000001_uid" AS "HBW_0000001_uid"
  FROM "BW"."HBW_0000005_BFO_0000051_HBW_0000001";

COMMENT ON VIEW "BW_iri"."HBW_0000005_BFO_0000051_HBW_0000001" IS 'physiological evaluation report has part physiological data item::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. 
a core relation that holds between a whole and its part
 A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_iri"."HBW_0000005_BFO_0000051_HBW_0000006" AS
  SELECT "HBW_0000005_uid" AS "HBW_0000005_uid",  
    "HBW_0000006_uid" AS "HBW_0000006_uid"
  FROM "BW"."HBW_0000005_BFO_0000051_HBW_0000006";

COMMENT ON VIEW "BW_iri"."HBW_0000005_BFO_0000051_HBW_0000006" IS 'physiological evaluation report has part medical record identifier::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. 
a core relation that holds between a whole and its part
 A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_iri"."HBW_0000001_OBI_0000312_HBW_0000012" AS
  SELECT "HBW_0000001_uid" AS "HBW_0000001_uid",  
    "HBW_0000012_uid" AS "HBW_0000012_uid"
  FROM "BW"."HBW_0000001_OBI_0000312_HBW_0000012";

COMMENT ON VIEW "BW_iri"."HBW_0000001_OBI_0000312_HBW_0000012" IS 'physiological data item is_specified_output_of physiological evaluation::A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_iri"."HBW_0000013_PHYSIO_0000089_HBW_0000008" AS
  SELECT "HBW_0000013_uid" AS "HBW_0000013_uid",  
    "HBW_0000008_uid" AS "HBW_0000008_uid"
  FROM "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008";

COMMENT ON VIEW "BW_iri"."HBW_0000013_PHYSIO_0000089_HBW_0000008" IS 'physiological evaluation from health care provider has evaluant health care provider::A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

CREATE VIEW "BW_iri"."IAO_0000109_IAO_0000039_IAO_0000003" AS
  SELECT "IAO_0000109_uid" AS "IAO_0000109_uid",  
    "IAO_0000003_uid" AS "IAO_0000003_uid"
  FROM "BW"."IAO_0000109_IAO_0000039_IAO_0000003";

COMMENT ON VIEW "BW_iri"."IAO_0000109_IAO_0000039_IAO_0000003" IS 'measurement datum has measurement unit label measurement unit label::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_iri"."IAO_0000032_IAO_0000039_IAO_0000003" AS
  SELECT "IAO_0000032_uid" AS "IAO_0000032_uid",  
    "IAO_0000003_uid" AS "IAO_0000003_uid"
  FROM "BW"."IAO_0000032_IAO_0000039_IAO_0000003";

COMMENT ON VIEW "BW_iri"."IAO_0000032_IAO_0000039_IAO_0000003" IS 'scalar measurement datum has measurement unit label measurement unit label::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_iri"."BFO_0000017_BFO_0000054_BFO_0000015" AS
  SELECT "BFO_0000017_uid" AS "BFO_0000017_uid",  
    "BFO_0000015_uid" AS "BFO_0000015_uid"
  FROM "BW"."BFO_0000017_BFO_0000054_BFO_0000015";

COMMENT ON VIEW "BW_iri"."BFO_0000017_BFO_0000054_BFO_0000015" IS 'realizable entity realized in process::A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type. Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

CREATE VIEW "BW_iri"."BFO_0000001_BFO_0000050_BFO_0000001" AS
  SELECT "BFO_0000001_uid_domain" AS "BFO_0000001_uid_domain",  
    "BFO_0000001_uid_range" AS "BFO_0000001_uid_range"
  FROM "BW"."BFO_0000001_BFO_0000050_BFO_0000001";

COMMENT ON VIEW "BW_iri"."BFO_0000001_BFO_0000050_BFO_0000001" IS 'entity part of entity::A thing that exists or has existed or will exist. a core relation that holds between a part and its whole A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."HBW_0000004_IAO_0000136_OBI_0100026" AS
  SELECT "HBW_0000004_uid" AS "HBW_0000004_uid",  
    "OBI_0100026_uid" AS "OBI_0100026_uid"
  FROM "BW"."HBW_0000004_IAO_0000136_OBI_0100026";

COMMENT ON VIEW "BW_iri"."HBW_0000004_IAO_0000136_OBI_0100026" IS 'health care record is about organism::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" AS
  SELECT "ONTORELA_C4d0c3f45_uid" AS "ONTORELA_C4d0c3f45_uid",  
    "HBW_0000007_uid" AS "HBW_0000007_uid"
  FROM "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007";

COMMENT ON VIEW "BW_iri"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" IS 'health care record
 and (is about some patient) is about patient::medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

CREATE VIEW "BW_iri"."IAO_0020000_IAO_0000219_BFO_0000001" AS
  SELECT "IAO_0020000_uid" AS "IAO_0020000_uid",  
    "BFO_0000001_uid" AS "BFO_0000001_uid"
  FROM "BW"."IAO_0020000_IAO_0000219_BFO_0000001";

COMMENT ON VIEW "BW_iri"."IAO_0020000_IAO_0000219_BFO_0000001" IS 'identifier denotes entity::An information content entity that is the outcome of a dubbing process and is used to refer to one instance of entity shared by a group of people to refer to that individual entity. null A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" AS
  SELECT "HBW_0000012_uid" AS "HBW_0000012_uid",  
    "NCBITaxon_9606_uid" AS "NCBITaxon_9606_uid"
  FROM "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606";

COMMENT ON VIEW "BW_iri"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" IS 'physiological evaluation has evaluant Homo sapiens::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_iri"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" AS
  SELECT "HBW_0000012_uid" AS "HBW_0000012_uid",  
    "ONTORELA_C61c354fb_uid" AS "ONTORELA_C61c354fb_uid"
  FROM "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb";

COMMENT ON VIEW "BW_iri"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" IS 'physiological evaluation has_specified_output data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_iri"."IAO_0000030_IAO_0000136_BFO_0000001" AS
  SELECT "IAO_0000030_uid" AS "IAO_0000030_uid",  
    "BFO_0000001_uid" AS "BFO_0000001_uid"
  FROM "BW"."IAO_0000030_IAO_0000136_BFO_0000001";

COMMENT ON VIEW "BW_iri"."IAO_0000030_IAO_0000136_BFO_0000001" IS 'information content entity is about entity::A generically dependent continuant that is about some thing. is_about is a (currently) primitive relation that relates an information artifact to an entity. A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."IAO_0000030_IAO_0000219_BFO_0000001" AS
  SELECT "IAO_0000030_uid" AS "IAO_0000030_uid",  
    "BFO_0000001_uid" AS "BFO_0000001_uid"
  FROM "BW"."IAO_0000030_IAO_0000219_BFO_0000001";

COMMENT ON VIEW "BW_iri"."IAO_0000030_IAO_0000219_BFO_0000001" IS 'information content entity denotes entity::A generically dependent continuant that is about some thing. null A thing that exists or has existed or will exist.';

CREATE VIEW "BW_iri"."BFO_0000002_RO_0000056_BFO_0000003" AS
  SELECT "BFO_0000002_uid" AS "BFO_0000002_uid",  
    "BFO_0000003_uid" AS "BFO_0000003_uid"
  FROM "BW"."BFO_0000002_RO_0000056_BFO_0000003";

COMMENT ON VIEW "BW_iri"."BFO_0000002_RO_0000056_BFO_0000003" IS 'continuant participates in occurrent::Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process Occurrent';

CREATE VIEW "BW_iri"."HBW_0000008_RO_0000087_HBW_0000010" AS
  SELECT "HBW_0000008_uid" AS "HBW_0000008_uid",  
    "HBW_0000010_uid" AS "HBW_0000010_uid"
  FROM "BW"."HBW_0000008_RO_0000087_HBW_0000010";

COMMENT ON VIEW "BW_iri"."HBW_0000008_RO_0000087_HBW_0000010" IS 'health care provider has role health care provider role::A homo sapiens having with the health care provider role a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

CREATE VIEW "BW_iri"."HBW_0000007_RO_0000087_HBW_0000011" AS
  SELECT "HBW_0000007_uid" AS "HBW_0000007_uid",  
    "HBW_0000011_uid" AS "HBW_0000011_uid"
  FROM "BW"."HBW_0000007_RO_0000087_HBW_0000011";

COMMENT ON VIEW "BW_iri"."HBW_0000007_RO_0000087_HBW_0000011" IS 'patient has role patient role::An organism having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_iri"."BFO_0000015_BFO_0000055_BFO_0000017" AS
  SELECT "BFO_0000015_uid" AS "BFO_0000015_uid",  
    "BFO_0000017_uid" AS "BFO_0000017_uid"
  FROM "BW"."BFO_0000015_BFO_0000055_BFO_0000017";

COMMENT ON VIEW "BW_iri"."BFO_0000015_BFO_0000055_BFO_0000017" IS 'process realizes realizable entity::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.';

CREATE VIEW "BW_iri"."BFO_0000003_BFO_0000066_BFO_0000004" AS
  SELECT "BFO_0000003_uid" AS "BFO_0000003_uid",  
    "BFO_0000004_uid" AS "BFO_0000004_uid"
  FROM "BW"."BFO_0000003_BFO_0000066_BFO_0000004";

COMMENT ON VIEW "BW_iri"."BFO_0000003_BFO_0000066_BFO_0000004" IS 'occurrent occurs in ic::Occurrent b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything.';

CREATE VIEW "BW_iri"."BFO_0000003_RO_0000057_BFO_0000002" AS
  SELECT "BFO_0000003_uid" AS "BFO_0000003_uid",  
    "BFO_0000002_uid" AS "BFO_0000002_uid"
  FROM "BW"."BFO_0000003_RO_0000057_BFO_0000002";

COMMENT ON VIEW "BW_iri"."BFO_0000003_RO_0000057_BFO_0000002" IS 'occurrent has participant continuant::Occurrent a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant';

CREATE VIEW "BW_iri"."BFO_0000031_RO_0000058_BFO_0000020" AS
  SELECT "BFO_0000031_uid" AS "BFO_0000031_uid",  
    "BFO_0000020_uid" AS "BFO_0000020_uid"
  FROM "BW"."BFO_0000031_RO_0000058_BFO_0000020";

COMMENT ON VIEW "BW_iri"."BFO_0000031_RO_0000058_BFO_0000020" IS 'gdc is concretized as sdc::A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time. A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. SpecificallyDependentContinuant';


/*
-- =========================================================================== A
Schema : BW_en
Creation Date : 20240807-1140
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

COMMENT ON SCHEMA "BW_en" IS 'Create views in en of BW 20240807-1140';

CREATE VIEW "BW_en"."Thing" AS
  SELECT "Thing_uid" AS "uid Thing"
  FROM "BW"."Thing";

COMMENT ON VIEW "BW_en"."Thing" IS 'Top table';

CREATE VIEW "BW_en"."medical record identifier" AS
  SELECT "HBW_0000006_uid" AS "uid medical record identifier"
  FROM "BW"."HBW_0000006";

COMMENT ON VIEW "BW_en"."medical record identifier" IS 'A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_en"."material entity" AS
  SELECT "BFO_0000040_uid" AS "uid material entity"
  FROM "BW"."BFO_0000040";

COMMENT ON VIEW "BW_en"."material entity" IS 'MaterialEntity';

CREATE VIEW "BW_en"."HBW_0000026" AS
  SELECT "HBW_0000026_uid" AS "uid HBW_0000026"
  FROM "BW"."HBW_0000026";

COMMENT ON VIEW "BW_en"."HBW_0000026" IS 'A scalar measurement datum composed of two parts: a Decimal and a weight unit label.';

CREATE VIEW "BW_en"."disposition or quality" AS
  SELECT "ONTORELA_C1edc1ccd_uid" AS "uid disposition or quality"
  FROM "BW"."ONTORELA_C1edc1ccd";

COMMENT ON VIEW "BW_en"."disposition or quality" IS '(disposition or quality)
 and (inheres in some organism)Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality';

CREATE VIEW "BW_en"."health care provider role" AS
  SELECT "HBW_0000010_uid" AS "uid health care provider role"
  FROM "BW"."HBW_0000010";

COMMENT ON VIEW "BW_en"."health care provider role" IS 'A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

CREATE VIEW "BW_en"."gender identity information content entity" AS
  SELECT "OMRSE_00000209_uid" AS "uid gender identity information content entity"
  FROM "BW"."OMRSE_00000209";

COMMENT ON VIEW "BW_en"."gender identity information content entity" IS 'A social identity information content entity that is about whether some person identifies as some gender.';

CREATE VIEW "BW_en"."RAMQ vulnerability code" AS
  SELECT "HBW_0000002_uid" AS "uid RAMQ vulnerability code"
  FROM "BW"."HBW_0000002";

COMMENT ON VIEW "BW_en"."RAMQ vulnerability code" IS 'A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.';

CREATE VIEW "BW_en"."obesity" AS
  SELECT "HBW_0000014_uid" AS "uid obesity"
  FROM "BW"."HBW_0000014";

COMMENT ON VIEW "BW_en"."obesity" IS 'A disease marked by an abnormally high, unhealthy amount of body fat.; A disorder characterized by having an increased body fat.';

CREATE VIEW "BW_en"."human name" AS
  SELECT "HBW_0000022_uid" AS "uid human name"
  FROM "BW"."HBW_0000022";

COMMENT ON VIEW "BW_en"."human name" IS 'An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens.';

CREATE VIEW "BW_en"."datum label" AS
  SELECT "IAO_0000009_uid" AS "uid datum label"
  FROM "BW"."IAO_0000009";

COMMENT ON VIEW "BW_en"."datum label" IS 'A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label';

CREATE VIEW "BW_en"."realizable" AS
  SELECT "BFO_0000017_uid" AS "uid realizable"
  FROM "BW"."BFO_0000017";

COMMENT ON VIEW "BW_en"."realizable" IS 'A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.';

CREATE VIEW "BW_en"."biological sex datum" AS
  SELECT "VO_0001194_uid" AS "uid biological sex datum"
  FROM "BW"."VO_0001194";

COMMENT ON VIEW "BW_en"."biological sex datum" IS 'A measurement datum that represents the biological sex of an animal. The result can be represented using a discretized digit, for example, 0 = female; 1 = male.';

CREATE VIEW "BW_en"."entity" AS
  SELECT "BFO_0000001_uid" AS "uid entity"
  FROM "BW"."BFO_0000001";

COMMENT ON VIEW "BW_en"."entity" IS 'per discussion with Barry Smith';

CREATE VIEW "BW_en"."measurement datum" AS
  SELECT "IAO_0000109_uid" AS "uid measurement datum"
  FROM "BW"."IAO_0000109";

COMMENT ON VIEW "BW_en"."measurement datum" IS 'A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.';

CREATE VIEW "BW_en"."RAMQ vulnerability code statement" AS
  SELECT "HBW_0000029_uid" AS "uid RAMQ vulnerability code statement"
  FROM "BW"."HBW_0000029";

COMMENT ON VIEW "BW_en"."RAMQ vulnerability code statement" IS 'A statement about the inscription of a patient in a category of health situation in order to adjust administrative handling of physician billing by the RAMQ.';

CREATE VIEW "BW_en"."social identity information content entity" AS
  SELECT "OMRSE_00000204_uid" AS "uid social identity information content entity"
  FROM "BW"."OMRSE_00000204";

COMMENT ON VIEW "BW_en"."social identity information content entity" IS 'We include (i)-(iii) to acknowledge that there are different senses of "identify" that are relevant here, and that we may not always be sure which sense the person concretizing the social identity information content entity intended. While (i) concerns how one thinks of oneself, (ii) and (iii) are more focused on one''s interactions with others. Importantly, some choose not to share with others how they identify in the sense of (i). For example, one can consider oneself to be some certain gender without either wanting others to know or choosing to present oneself in a corresponding way. We distinguish (ii) and (iii) because one can prefer to be regarded some certain way without attempting to present oneself in any corresponding way.';

CREATE VIEW "BW_en"."physiological evaluation report" AS
  SELECT "HBW_0000005_uid" AS "uid physiological evaluation report"
  FROM "BW"."HBW_0000005";

COMMENT ON VIEW "BW_en"."physiological evaluation report" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."non-binary identity information content entity" AS
  SELECT "OMRSE_00000212_uid" AS "uid non-binary identity information content entity"
  FROM "BW"."OMRSE_00000212";

COMMENT ON VIEW "BW_en"."non-binary identity information content entity" IS 'A gender identity information content entity that is about some person''s identifying as non-binary in gender.';

CREATE VIEW "BW_en"."centrally registered identifier symbol" AS
  SELECT "IAO_0000577_uid" AS "uid centrally registered identifier symbol"
  FROM "BW"."IAO_0000577";

COMMENT ON VIEW "BW_en"."centrally registered identifier symbol" IS 'A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.';

CREATE VIEW "BW_en"."body weight" AS
  SELECT "HBW_0000009_uid" AS "uid body weight"
  FROM "BW"."HBW_0000009";

COMMENT ON VIEW "BW_en"."body weight" IS 'a quality of a body of having a weight';

CREATE VIEW "BW_en"."physiological evaluation from health care provider" AS
  SELECT "HBW_0000013_uid" AS "uid physiological evaluation from health care provider"
  FROM "BW"."HBW_0000013";

COMMENT ON VIEW "BW_en"."physiological evaluation from health care provider" IS 'A physiological evaluation that is evaluated by a health care provider';

CREATE VIEW "BW_en"."symbol" AS
  SELECT "IAO_0000028_uid" AS "uid symbol"
  FROM "BW"."IAO_0000028";

COMMENT ON VIEW "BW_en"."symbol" IS 'An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.';

CREATE VIEW "BW_en"."organism" AS
  SELECT "OBI_0100026_uid" AS "uid organism"
  FROM "BW"."OBI_0100026";

COMMENT ON VIEW "BW_en"."organism" IS 'A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."HBW_0000025" AS
  SELECT "HBW_0000025_uid" AS "HBW_0000025_uid"
  FROM "BW"."HBW_0000025";

COMMENT ON VIEW "BW_en"."HBW_0000025" IS 'A biological sex or gender identity datum that is intended to denote a female biological sex or a female gender identity.';

CREATE VIEW "BW_en"."physiological data item" AS
  SELECT "HBW_0000001_uid" AS "uid physiological data item"
  FROM "BW"."HBW_0000001";

COMMENT ON VIEW "BW_en"."physiological data item" IS 'A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_en"."scalar measurement datum" AS
  SELECT "IAO_0000032_uid" AS "uid scalar measurement datum"
  FROM "BW"."IAO_0000032";

COMMENT ON VIEW "BW_en"."scalar measurement datum" IS 'a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.';

CREATE VIEW "BW_en"."health care record
 and (is about some patient)" AS
  SELECT "ONTORELA_C4d0c3f45_uid" AS "uid health care record
 and (is about some patient)"
  FROM "BW"."ONTORELA_C4d0c3f45";

COMMENT ON VIEW "BW_en"."health care record
 and (is about some patient)" IS 'medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient.';

CREATE VIEW "BW_en"."continuant" AS
  SELECT "BFO_0000002_uid" AS "uid continuant"
  FROM "BW"."BFO_0000002";

COMMENT ON VIEW "BW_en"."continuant" IS 'An entity that exists in full at any time in which it exists at all, persists through time while maintaining its identity and has no temporal parts.';

CREATE VIEW "BW_en"."disease" AS
  SELECT "OGMS_0000031_uid" AS "uid disease"
  FROM "BW"."OGMS_0000031";

COMMENT ON VIEW "BW_en"."disease" IS 'A disposition (i) to undergo pathological processes that (ii) exists in an organism because of one or more disorders in that organism.';

CREATE VIEW "BW_en"."personal name" AS
  SELECT "IAO_0020015_uid" AS "uid personal name"
  FROM "BW"."IAO_0020015";

COMMENT ON VIEW "BW_en"."personal name" IS 'Sep 29, 2016: The comment that including the wikipedia definition of personal name is not to be interpreted in a way that restricts this class to only contain strings of letters. A numerical or alphanumerical identifier that denotes a human is being is a personal name, too. (MB)';

CREATE VIEW "BW_en"."ONTORELA_C61c354fb" AS
  SELECT "ONTORELA_C61c354fb_uid" AS "ONTORELA_C61c354fb_uid"
  FROM "BW"."ONTORELA_C61c354fb";

COMMENT ON VIEW "BW_en"."ONTORELA_C61c354fb" IS 'physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."human biological sex or gender identity statement" AS
  SELECT "HBW_0000028_uid" AS "uid human biological sex or gender identity statement"
  FROM "BW"."HBW_0000028";

COMMENT ON VIEW "BW_en"."human biological sex or gender identity statement" IS 'A statement about the biological sex or gender identity of a human';

CREATE VIEW "BW_en"."health care record" AS
  SELECT "HBW_0000004_uid" AS "uid health care record"
  FROM "BW"."HBW_0000004";

COMMENT ON VIEW "BW_en"."health care record" IS 'A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.';

CREATE VIEW "BW_en"."male biological sex datum" AS
  SELECT "VO_0000613_uid" AS "uid male biological sex datum"
  FROM "BW"."VO_0000613";

COMMENT ON VIEW "BW_en"."male biological sex datum" IS 'A biological sex datum that represents the biological sex of an animal (including human) as being male.';

CREATE VIEW "BW_en"."health care provider" AS
  SELECT "HBW_0000008_uid" AS "uid health care provider"
  FROM "BW"."HBW_0000008";

COMMENT ON VIEW "BW_en"."health care provider" IS 'A homo sapiens having with the health care provider role';

CREATE VIEW "BW_en"."male gender identity information content entity" AS
  SELECT "OMRSE_00000211_uid" AS "uid male gender identity information content entity"
  FROM "BW"."OMRSE_00000211";

COMMENT ON VIEW "BW_en"."male gender identity information content entity" IS 'A gender identity information content entity that is about some person''s identifying as male in gender.';

CREATE VIEW "BW_en"."document" AS
  SELECT "IAO_0000310_uid" AS "uid document"
  FROM "BW"."IAO_0000310";

COMMENT ON VIEW "BW_en"."document" IS 'An information content entity that is a collection of information content entities intended to be understood together as a whole.';

CREATE VIEW "BW_en"."measurement unit label" AS
  SELECT "IAO_0000003_uid" AS "uid measurement unit label"
  FROM "BW"."IAO_0000003";

COMMENT ON VIEW "BW_en"."measurement unit label" IS 'A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_en"."data item" AS
  SELECT "IAO_0000027_uid" AS "uid data item"
  FROM "BW"."IAO_0000027";

COMMENT ON VIEW "BW_en"."data item" IS 'a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.';

CREATE VIEW "BW_en"."HBW_0000024" AS
  SELECT "HBW_0000024_uid" AS "HBW_0000024_uid"
  FROM "BW"."HBW_0000024";

COMMENT ON VIEW "BW_en"."HBW_0000024" IS 'A biological sex or gender identity datum that is intended to denote a intersex biological sex or a non-binary gender identity.';

CREATE VIEW "BW_en"."planned process" AS
  SELECT "OBI_0000011_uid" AS "uid planned process"
  FROM "BW"."OBI_0000011";

COMMENT ON VIEW "BW_en"."planned process" IS 'A process that realizes a plan which is the concretization of a plan specification.';

CREATE VIEW "BW_en"."physiological evaluation" AS
  SELECT "HBW_0000012_uid" AS "uid physiological evaluation"
  FROM "BW"."HBW_0000012";

COMMENT ON VIEW "BW_en"."physiological evaluation" IS 'A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."intersex biological sex datum" AS
  SELECT "VO_0004896_uid" AS "uid intersex biological sex datum"
  FROM "BW"."VO_0004896";

COMMENT ON VIEW "BW_en"."intersex biological sex datum" IS 'A biological sex datum that represents the biological sex of an animal (including human) as being intersex.';

CREATE VIEW "BW_en"."quality" AS
  SELECT "BFO_0000019_uid" AS "uid quality"
  FROM "BW"."BFO_0000019";

COMMENT ON VIEW "BW_en"."quality" IS 'a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized';

CREATE VIEW "BW_en"."occurrent" AS
  SELECT "BFO_0000003_uid" AS "uid occurrent"
  FROM "BW"."BFO_0000003";

COMMENT ON VIEW "BW_en"."occurrent" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
';

CREATE VIEW "BW_en"."process" AS
  SELECT "BFO_0000015_uid" AS "uid process"
  FROM "BW"."BFO_0000015";

COMMENT ON VIEW "BW_en"."process" IS 'An occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t.';

CREATE VIEW "BW_en"."generically dependent continuant" AS
  SELECT "BFO_0000031_uid" AS "uid generically dependent continuant"
  FROM "BW"."BFO_0000031";

COMMENT ON VIEW "BW_en"."generically dependent continuant" IS 'A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

CREATE VIEW "BW_en"."statement" AS
  SELECT "NOYO_0000013_uid" AS "uid statement"
  FROM "BW"."NOYO_0000013";

COMMENT ON VIEW "BW_en"."statement" IS 'An informational entity that is considered valid by some agent at some point in time. (TBD)';

CREATE VIEW "BW_en"."identifier" AS
  SELECT "IAO_0020000_uid" AS "uid identifier"
  FROM "BW"."IAO_0020000";

COMMENT ON VIEW "BW_en"."identifier" IS 'An information content entity that is the outcome of a dubbing process and is used to refer to one instance of entity shared by a group of people to refer to that individual entity.';

CREATE VIEW "BW_en"."role" AS
  SELECT "BFO_0000023_uid" AS "uid role"
  FROM "BW"."BFO_0000023";

COMMENT ON VIEW "BW_en"."role" IS 'Role';

CREATE VIEW "BW_en"."informational entity" AS
  SELECT "NOYO_0000012_uid" AS "uid informational entity"
  FROM "BW"."NOYO_0000012";

COMMENT ON VIEW "BW_en"."informational entity" IS 'A generically dependent continuant that is a building block of information or a combination thereof.';

CREATE VIEW "BW_en"."patient" AS
  SELECT "HBW_0000007_uid" AS "uid patient"
  FROM "BW"."HBW_0000007";

COMMENT ON VIEW "BW_en"."patient" IS 'An organism having the role of patient.';

CREATE VIEW "BW_en"."female gender identity information content entity" AS
  SELECT "OMRSE_00000210_uid" AS "uid female gender identity information content entity"
  FROM "BW"."OMRSE_00000210";

COMMENT ON VIEW "BW_en"."female gender identity information content entity" IS 'A gender identity information content entity that is about some person''s identifying as female in gender.';

CREATE VIEW "BW_en"."Homo sapiens" AS
  SELECT "NCBITaxon_9606_uid" AS "uid Homo sapiens"
  FROM "BW"."NCBITaxon_9606";

COMMENT ON VIEW "BW_en"."Homo sapiens" IS 'Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_en"."IOIO_0000012" AS
  SELECT "IOIO_0000012_uid" AS "IOIO_0000012_uid"
  FROM "BW"."IOIO_0000012";

COMMENT ON VIEW "BW_en"."IOIO_0000012" IS 'An information content entity that denotes a biological sex or a gender identity of a human.';

CREATE VIEW "BW_en"."weight unit" AS
  SELECT "HBW_0000003_uid" AS "uid weight unit"
  FROM "BW"."HBW_0000003";

COMMENT ON VIEW "BW_en"."weight unit" IS 'a measurement unit label of a weight';

CREATE VIEW "BW_en"."patient role" AS
  SELECT "HBW_0000011_uid" AS "uid patient role"
  FROM "BW"."HBW_0000011";

COMMENT ON VIEW "BW_en"."patient role" IS 'a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_en"."HBW_0000023" AS
  SELECT "HBW_0000023_uid" AS "HBW_0000023_uid"
  FROM "BW"."HBW_0000023";

COMMENT ON VIEW "BW_en"."HBW_0000023" IS 'A biological sex or gender identity datum that is intended to denote a male biological sex or a male gender identity.';

CREATE VIEW "BW_en"."information content entity" AS
  SELECT "IAO_0000030_uid" AS "uid information content entity"
  FROM "BW"."IAO_0000030";

COMMENT ON VIEW "BW_en"."information content entity" IS 'A generically dependent continuant that is about some thing.';

CREATE VIEW "BW_en"."female biological sex datum" AS
  SELECT "VO_0004895_uid" AS "uid female biological sex datum"
  FROM "BW"."VO_0004895";

COMMENT ON VIEW "BW_en"."female biological sex datum" IS 'A biological sex measurement datum that is intended to denote a female biological sex.';

CREATE VIEW "BW_en"."family name" AS
  SELECT "IAO_0020017_uid" AS "uid family name"
  FROM "BW"."IAO_0020017";

COMMENT ON VIEW "BW_en"."family name" IS 'An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children.';

CREATE VIEW "BW_en"."ic" AS
  SELECT "BFO_0000004_uid" AS "uid ic"
  FROM "BW"."BFO_0000004";

COMMENT ON VIEW "BW_en"."ic" IS 'A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything.';

CREATE VIEW "BW_en"."disposition" AS
  SELECT "BFO_0000016_uid" AS "uid disposition"
  FROM "BW"."BFO_0000016";

COMMENT ON VIEW "BW_en"."disposition" IS 'Disposition';

CREATE VIEW "BW_en"."(disposition or quality)
 and (inheres in some organism)" AS
  SELECT "ONTORELA_C2986e108_uid" AS "uid (disposition or quality)
 and (inheres in some organism)"
  FROM "BW"."ONTORELA_C2986e108";

COMMENT ON VIEW "BW_en"."(disposition or quality)
 and (inheres in some organism)" IS 'data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."sdc" AS
  SELECT "BFO_0000020_uid" AS "uid sdc"
  FROM "BW"."BFO_0000020";

COMMENT ON VIEW "BW_en"."sdc" IS 'b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])';

CREATE VIEW "BW_en"."scalar measurement datum has measurement value Double" AS
  SELECT "IAO_0000032_IAO_0000004_double_IAO_0000004" AS "has measurement value",  
    "IAO_0000032_uid" AS "uid scalar measurement datum"
  FROM "BW"."IAO_0000032_IAO_0000004_double";

COMMENT ON VIEW "BW_en"."scalar measurement datum has measurement value Double" IS 'IAO_0000032 [1..1] IAO_0000004 double';

CREATE VIEW "BW_en"."RAMQ vulnerability code has value String" AS
  SELECT "HBW_0000002_PHYSIO_0000100_string_PHYSIO_0000100" AS "has value",  
    "HBW_0000002_uid" AS "uid RAMQ vulnerability code"
  FROM "BW"."HBW_0000002_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_en"."RAMQ vulnerability code has value String" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."family name has value String" AS
  SELECT "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100" AS "has value",  
    "IAO_0020017_uid" AS "uid family name"
  FROM "BW"."IAO_0020017_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_en"."family name has value String" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."scalar measurement datum has measurement value Literal" AS
  SELECT "IAO_0000032_uid" AS "uid scalar measurement datum",  
    "IAO_0000032_IAO_0000004_Literal_IAO_0000004" AS "has measurement value"
  FROM "BW"."IAO_0000032_IAO_0000004_Literal";

COMMENT ON VIEW "BW_en"."scalar measurement datum has measurement value Literal" IS 'DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal)';

CREATE VIEW "BW_en"."HBW_0000026 has measurement value Decimal" AS
  SELECT "HBW_0000026_uid" AS "uid HBW_0000026",  
    "HBW_0000026_IAO_0000004_decimal_IAO_0000004" AS "has measurement value"
  FROM "BW"."HBW_0000026_IAO_0000004_decimal";

COMMENT ON VIEW "BW_en"."HBW_0000026 has measurement value Decimal" IS 'DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> xsd:decimal)';

CREATE VIEW "BW_en"."measurement unit label has value String" AS
  SELECT "IAO_0000003_PHYSIO_0000100_string_PHYSIO_0000100" AS "has value",  
    "IAO_0000003_uid" AS "uid measurement unit label"
  FROM "BW"."IAO_0000003_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_en"."measurement unit label has value String" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."personal name has value String" AS
  SELECT "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100" AS "has value",  
    "IAO_0020015_uid" AS "uid personal name"
  FROM "BW"."IAO_0020015_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_en"."personal name has value String" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."centrally registered identifier symbol has value String" AS
  SELECT "IAO_0000577_PHYSIO_0000100_string_PHYSIO_0000100" AS "has value",  
    "IAO_0000577_uid" AS "uid centrally registered identifier symbol"
  FROM "BW"."IAO_0000577_PHYSIO_0000100_string";

COMMENT ON VIEW "BW_en"."centrally registered identifier symbol has value String" IS 'DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

CREATE VIEW "BW_en"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" AS
  SELECT "HBW_0000006_uid" AS "uid medical record identifier",  
    "ONTORELA_C4d0c3f45_uid" AS "uid health care record
 and (is about some patient)"
  FROM "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45";

COMMENT ON VIEW "BW_en"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" IS 'A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient.';

CREATE VIEW "BW_en"."HBW_0000026 has measurement unit label weight unit" AS
  SELECT "HBW_0000026_uid" AS "uid HBW_0000026",  
    "HBW_0000003_uid" AS "uid weight unit"
  FROM "BW"."HBW_0000026_IAO_0000039_HBW_0000003";

COMMENT ON VIEW "BW_en"."HBW_0000026 has measurement unit label weight unit" IS 'A scalar measurement datum composed of two parts: a Decimal and a weight unit label. null a measurement unit label of a weight';

CREATE VIEW "BW_en"."human name has_part family name" AS
  SELECT "HBW_0000022_uid" AS "uid human name",  
    "IAO_0020017_uid" AS "uid family name"
  FROM "BW"."HBW_0000022_BFO_0000051_IAO_0020017";

COMMENT ON VIEW "BW_en"."human name has_part family name" IS 'An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. a core relation that holds between a whole and its part An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children.';

CREATE VIEW "BW_en"."human name has_part personal name" AS
  SELECT "HBW_0000022_uid" AS "uid human name",  
    "IAO_0020015_uid" AS "uid personal name"
  FROM "BW"."HBW_0000022_BFO_0000051_IAO_0020015";

COMMENT ON VIEW "BW_en"."human name has_part personal name" IS 'An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. a core relation that holds between a whole and its part Sep 29, 2016: The comment that including the wikipedia definition of personal name is not to be interpreted in a way that restricts this class to only contain strings of letters. A numerical or alphanumerical identifier that denotes a human is being is a personal name, too. (MB)';

CREATE VIEW "BW_en"."human name denotes Homo sapiens" AS
  SELECT "HBW_0000022_uid" AS "uid human name",  
    "NCBITaxon_9606_uid" AS "uid Homo sapiens"
  FROM "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606";

COMMENT ON VIEW "BW_en"."human name denotes Homo sapiens" IS 'An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens. null Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_en"."realizable realized in process" AS
  SELECT "BFO_0000017_uid" AS "uid realizable",  
    "BFO_0000015_uid" AS "uid process"
  FROM "BW"."BFO_0000017_BFO_0000054_BFO_0000015";

COMMENT ON VIEW "BW_en"."realizable realized in process" IS 'A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type. Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process An occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t.';

CREATE VIEW "BW_en"."entity part of entity" AS
  SELECT "BFO_0000001_uid_domain" AS "uid entity_domain",  
    "BFO_0000001_uid_range" AS "uid entity_range"
  FROM "BW"."BFO_0000001_BFO_0000050_BFO_0000001";

COMMENT ON VIEW "BW_en"."entity part of entity" IS 'per discussion with Barry Smith 
a core relation that holds between a part and its whole
 per discussion with Barry Smith';

CREATE VIEW "BW_en"."IAO_0000109_IAO_0000039_IAO_0000003" AS
  SELECT "IAO_0000109_uid" AS "uid measurement datum",  
    "IAO_0000003_uid" AS "uid measurement unit label"
  FROM "BW"."IAO_0000109_IAO_0000039_IAO_0000003";

COMMENT ON VIEW "BW_en"."IAO_0000109_IAO_0000039_IAO_0000003" IS 'A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_en"."HBW_0000029_BFO_0000051_HBW_0000006" AS
  SELECT "HBW_0000029_uid" AS "uid RAMQ vulnerability code statement",  
    "HBW_0000006_uid" AS "uid medical record identifier"
  FROM "BW"."HBW_0000029_BFO_0000051_HBW_0000006";

COMMENT ON VIEW "BW_en"."HBW_0000029_BFO_0000051_HBW_0000006" IS 'A statement about the inscription of a patient in a category of health situation in order to adjust administrative handling of physician billing by the RAMQ. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_en"."HBW_0000029_BFO_0000051_HBW_0000002" AS
  SELECT "HBW_0000029_uid" AS "uid RAMQ vulnerability code statement",  
    "HBW_0000002_uid" AS "uid RAMQ vulnerability code"
  FROM "BW"."HBW_0000029_BFO_0000051_HBW_0000002";

COMMENT ON VIEW "BW_en"."HBW_0000029_BFO_0000051_HBW_0000002" IS 'A statement about the inscription of a patient in a category of health situation in order to adjust administrative handling of physician billing by the RAMQ. a core relation that holds between a whole and its part A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.';

CREATE VIEW "BW_en"."HBW_0000005_BFO_0000051_HBW_0000001" AS
  SELECT "HBW_0000005_uid" AS "uid physiological evaluation report",  
    "HBW_0000001_uid" AS "uid physiological data item"
  FROM "BW"."HBW_0000005_BFO_0000051_HBW_0000001";

COMMENT ON VIEW "BW_en"."HBW_0000005_BFO_0000051_HBW_0000001" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation.';

CREATE VIEW "BW_en"."HBW_0000005_BFO_0000051_HBW_0000006" AS
  SELECT "HBW_0000005_uid" AS "uid physiological evaluation report",  
    "HBW_0000006_uid" AS "uid medical record identifier"
  FROM "BW"."HBW_0000005_BFO_0000051_HBW_0000006";

COMMENT ON VIEW "BW_en"."HBW_0000005_BFO_0000051_HBW_0000006" IS 'A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_en"."HBW_0000013_PHYSIO_0000089_HBW_0000008" AS
  SELECT "HBW_0000013_uid" AS "uid physiological evaluation from health care provider",  
    "HBW_0000008_uid" AS "uid health care provider"
  FROM "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008";

COMMENT ON VIEW "BW_en"."HBW_0000013_PHYSIO_0000089_HBW_0000008" IS 'A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

CREATE VIEW "BW_en"."HBW_0000001_OBI_0000312_HBW_0000012" AS
  SELECT "HBW_0000001_uid" AS "uid physiological data item",  
    "HBW_0000012_uid" AS "uid physiological evaluation"
  FROM "BW"."HBW_0000001_OBI_0000312_HBW_0000012";

COMMENT ON VIEW "BW_en"."HBW_0000001_OBI_0000312_HBW_0000012" IS 'A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

CREATE VIEW "BW_en"."IAO_0000032_IAO_0000039_IAO_0000003" AS
  SELECT "IAO_0000032_uid" AS "uid scalar measurement datum",  
    "IAO_0000003_uid" AS "uid measurement unit label"
  FROM "BW"."IAO_0000032_IAO_0000039_IAO_0000003";

COMMENT ON VIEW "BW_en"."IAO_0000032_IAO_0000039_IAO_0000003" IS 'a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

CREATE VIEW "BW_en"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" AS
  SELECT "ONTORELA_C4d0c3f45_uid" AS "uid health care record
 and (is about some patient)",  
    "HBW_0000007_uid" AS "uid patient"
  FROM "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007";

COMMENT ON VIEW "BW_en"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" IS 'medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

CREATE VIEW "BW_en"."continuant participates in occurrent" AS
  SELECT "BFO_0000002_uid" AS "uid continuant",  
    "BFO_0000003_uid" AS "uid occurrent"
  FROM "BW"."BFO_0000002_RO_0000056_BFO_0000003";

COMMENT ON VIEW "BW_en"."continuant participates in occurrent" IS 'An entity that exists in full at any time in which it exists at all, persists through time while maintaining its identity and has no temporal parts. a relation between a continuant and a process, in which the continuant is somehow involved in the process 
An entity that has temporal parts and that happens, unfolds or develops through time.
';

CREATE VIEW "BW_en"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" AS
  SELECT "ONTORELA_C61c354fb_uid" AS "ONTORELA_C61c354fb_uid",  
    "ONTORELA_C2986e108_uid" AS "uid (disposition or quality)
 and (inheres in some organism)"
  FROM "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108";

COMMENT ON VIEW "BW_en"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" IS 'physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. is_about is a (currently) primitive relation that relates an information artifact to an entity. data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."HBW_0000028_BFO_0000051_HBW_0000006" AS
  SELECT "HBW_0000028_uid" AS "uid human biological sex or gender identity statement",  
    "HBW_0000006_uid" AS "uid medical record identifier"
  FROM "BW"."HBW_0000028_BFO_0000051_HBW_0000006";

COMMENT ON VIEW "BW_en"."HBW_0000028_BFO_0000051_HBW_0000006" IS 'A statement about the biological sex or gender identity of a human a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

CREATE VIEW "BW_en"."HBW_0000028_BFO_0000051_IOIO_0000012" AS
  SELECT "HBW_0000028_uid" AS "uid human biological sex or gender identity statement",  
    "IOIO_0000012_uid" AS "IOIO_0000012_uid"
  FROM "BW"."HBW_0000028_BFO_0000051_IOIO_0000012";

COMMENT ON VIEW "BW_en"."HBW_0000028_BFO_0000051_IOIO_0000012" IS 'A statement about the biological sex or gender identity of a human a core relation that holds between a whole and its part An information content entity that denotes a biological sex or a gender identity of a human.';

CREATE VIEW "BW_en"."health care record is about organism" AS
  SELECT "HBW_0000004_uid" AS "uid health care record",  
    "OBI_0100026_uid" AS "uid organism"
  FROM "BW"."HBW_0000004_IAO_0000136_OBI_0100026";

COMMENT ON VIEW "BW_en"."health care record is about organism" IS 'A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."health care provider has role health care provider role" AS
  SELECT "HBW_0000008_uid" AS "uid health care provider",  
    "HBW_0000010_uid" AS "uid health care provider role"
  FROM "BW"."HBW_0000008_RO_0000087_HBW_0000010";

COMMENT ON VIEW "BW_en"."health care provider has role health care provider role" IS 'A homo sapiens having with the health care provider role a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

CREATE VIEW "BW_en"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" AS
  SELECT "HBW_0000012_uid" AS "uid physiological evaluation",  
    "ONTORELA_C61c354fb_uid" AS "ONTORELA_C61c354fb_uid"
  FROM "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb";

COMMENT ON VIEW "BW_en"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" IS 'A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."physiological evaluation has evaluant Homo sapiens" AS
  SELECT "HBW_0000012_uid" AS "uid physiological evaluation",  
    "NCBITaxon_9606_uid" AS "uid Homo sapiens"
  FROM "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606";

COMMENT ON VIEW "BW_en"."physiological evaluation has evaluant Homo sapiens" IS 'A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

CREATE VIEW "BW_en"."occurrent occurs in ic" AS
  SELECT "BFO_0000003_uid" AS "uid occurrent",  
    "BFO_0000004_uid" AS "uid ic"
  FROM "BW"."BFO_0000003_BFO_0000066_BFO_0000004";

COMMENT ON VIEW "BW_en"."occurrent occurs in ic" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
 b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything.';

CREATE VIEW "BW_en"."occurrent has participant continuant" AS
  SELECT "BFO_0000003_uid" AS "uid occurrent",  
    "BFO_0000002_uid" AS "uid continuant"
  FROM "BW"."BFO_0000003_RO_0000057_BFO_0000002";

COMMENT ON VIEW "BW_en"."occurrent has participant continuant" IS '
An entity that has temporal parts and that happens, unfolds or develops through time.
 a relation between a process and a continuant, in which the continuant is somehow involved in the process An entity that exists in full at any time in which it exists at all, persists through time while maintaining its identity and has no temporal parts.';

CREATE VIEW "BW_en"."process realizes realizable" AS
  SELECT "BFO_0000015_uid" AS "uid process",  
    "BFO_0000017_uid" AS "uid realizable"
  FROM "BW"."BFO_0000015_BFO_0000055_BFO_0000017";

COMMENT ON VIEW "BW_en"."process realizes realizable" IS 'An occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.';

CREATE VIEW "BW_en"."generically dependent continuant is concretized as sdc" AS
  SELECT "BFO_0000031_uid" AS "uid generically dependent continuant",  
    "BFO_0000020_uid" AS "uid sdc"
  FROM "BW"."BFO_0000031_RO_0000058_BFO_0000020";

COMMENT ON VIEW "BW_en"."generically dependent continuant is concretized as sdc" IS 'A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time. A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])';

CREATE VIEW "BW_en"."identifier denotes entity" AS
  SELECT "IAO_0020000_uid" AS "uid identifier",  
    "BFO_0000001_uid" AS "uid entity"
  FROM "BW"."IAO_0020000_IAO_0000219_BFO_0000001";

COMMENT ON VIEW "BW_en"."identifier denotes entity" IS 'An information content entity that is the outcome of a dubbing process and is used to refer to one instance of entity shared by a group of people to refer to that individual entity. null per discussion with Barry Smith';

CREATE VIEW "BW_en"."patient has role patient role" AS
  SELECT "HBW_0000007_uid" AS "uid patient",  
    "HBW_0000011_uid" AS "uid patient role"
  FROM "BW"."HBW_0000007_RO_0000087_HBW_0000011";

COMMENT ON VIEW "BW_en"."patient has role patient role" IS 'An organism having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

CREATE VIEW "BW_en"."information content entity is about entity" AS
  SELECT "IAO_0000030_uid" AS "uid information content entity",  
    "BFO_0000001_uid" AS "uid entity"
  FROM "BW"."IAO_0000030_IAO_0000136_BFO_0000001";

COMMENT ON VIEW "BW_en"."information content entity is about entity" IS 'A generically dependent continuant that is about some thing. is_about is a (currently) primitive relation that relates an information artifact to an entity. per discussion with Barry Smith';

CREATE VIEW "BW_en"."information content entity denotes entity" AS
  SELECT "IAO_0000030_uid" AS "uid information content entity",  
    "BFO_0000001_uid" AS "uid entity"
  FROM "BW"."IAO_0000030_IAO_0000219_BFO_0000001";

COMMENT ON VIEW "BW_en"."information content entity denotes entity" IS 'A generically dependent continuant that is about some thing. null per discussion with Barry Smith';

CREATE VIEW "BW_en"."ic has role role" AS
  SELECT "BFO_0000004_uid" AS "uid ic",  
    "BFO_0000023_uid" AS "uid role"
  FROM "BW"."BFO_0000004_RO_0000087_BFO_0000023";

COMMENT ON VIEW "BW_en"."ic has role role" IS 'A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence Role';

CREATE VIEW "BW_en"."ic located in ic" AS
  SELECT "BFO_0000004_uid_domain" AS "uid ic_domain",  
    "BFO_0000004_uid_range" AS "uid ic_range"
  FROM "BW"."BFO_0000004_RO_0001025_BFO_0000004";

COMMENT ON VIEW "BW_en"."ic located in ic" IS 'A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything. a relation between two independent continuants, the target and the location, in which the target is entirely within the location A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything.';

CREATE VIEW "BW_en"."ONTORELA_C2986e108_RO_0000052_OBI_0100026" AS
  SELECT "ONTORELA_C2986e108_uid" AS "uid (disposition or quality)
 and (inheres in some organism)",  
    "OBI_0100026_uid" AS "uid organism"
  FROM "BW"."ONTORELA_C2986e108_RO_0000052_OBI_0100026";

COMMENT ON VIEW "BW_en"."ONTORELA_C2986e108_RO_0000052_OBI_0100026" IS 'data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

CREATE VIEW "BW_en"."sdc concretizes generically dependent continuant" AS
  SELECT "BFO_0000020_uid" AS "uid sdc",  
    "BFO_0000031_uid" AS "uid generically dependent continuant"
  FROM "BW"."BFO_0000020_RO_0000059_BFO_0000031";

COMMENT ON VIEW "BW_en"."sdc concretizes generically dependent continuant" IS 'b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003]) A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';


/*
-- =========================================================================== A
Schema : BW
Creation Date : 20231004-1152
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Create domains and tables
-- =========================================================================== A
*/

CREATE SCHEMA IF NOT EXISTS "BW";

COMMENT ON SCHEMA "BW" IS 'Schéma BW créé le 20231004-1152';

-- uid_domain domain definition
CREATE DOMAIN "BW"."uid_domain" AS TEXT;

-- value_domain domain definition
CREATE DOMAIN "BW"."value_domain" AS TEXT;

-- Literal domain definition
CREATE DOMAIN "BW"."Literal" AS TEXT;

-- boolean domain definition
CREATE DOMAIN "BW"."boolean" AS BOOLEAN;

-- langString domain definition
CREATE DOMAIN "BW"."langString" AS TEXT;

-- string domain definition
CREATE DOMAIN "BW"."string" AS TEXT;

-- double domain definition
CREATE DOMAIN "BW"."double" AS DOUBLE PRECISION;

-- table T0000 definition
CREATE TABLE "BW"."T0000"
(
  "T0000_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0000 PRIMARY KEY ("T0000_uid")
);

COMMENT ON TABLE "BW"."T0000" IS 'Thing::Top table';

COMMENT ON COLUMN "BW"."T0000"."T0000_uid" IS 'uid Thing::Default primary key of Thing';

-- table T0001 definition
CREATE TABLE "BW"."T0001"
(
  "T0001_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0001 PRIMARY KEY ("T0001_uid")
);

COMMENT ON TABLE "BW"."T0001" IS 'scalar measurement datum::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.';

COMMENT ON COLUMN "BW"."T0001"."T0001_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

-- table T0002 definition
CREATE TABLE "BW"."T0002"
(
  "T0002_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0002 PRIMARY KEY ("T0002_uid")
);

COMMENT ON TABLE "BW"."T0002" IS 'value specification::An information content entity that specifies a value within a classification scheme or on a quantitative scale.';

COMMENT ON COLUMN "BW"."T0002"."T0002_uid" IS 'uid value specification::Default primary key of value specification';

-- table T0003 definition
CREATE TABLE "BW"."T0003"
(
  "T0003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0003 PRIMARY KEY ("T0003_uid")
);

COMMENT ON TABLE "BW"."T0003" IS 'sdc::SpecificallyDependentContinuant';

COMMENT ON COLUMN "BW"."T0003"."T0003_uid" IS 'uid sdc::Default primary key of sdc';

-- table T0004 definition
CREATE TABLE "BW"."T0004"
(
  "T0004_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0004 PRIMARY KEY ("T0004_uid")
);

COMMENT ON TABLE "BW"."T0004" IS 'information content entity::A generically dependent continuant that is about some thing.';

COMMENT ON COLUMN "BW"."T0004"."T0004_uid" IS 'uid information content entity::Default primary key of information content entity';

-- table T0005 definition
CREATE TABLE "BW"."T0005"
(
  "T0005_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0005 PRIMARY KEY ("T0005_uid")
);

COMMENT ON TABLE "BW"."T0005" IS 'scalar value specification::A value specification that consists of two parts: a numeral and a unit label';

COMMENT ON COLUMN "BW"."T0005"."T0005_uid" IS 'uid scalar value specification::Default primary key of scalar value specification';

-- table T0006 definition
CREATE TABLE "BW"."T0006"
(
  "T0006_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0006 PRIMARY KEY ("T0006_uid")
);

COMMENT ON TABLE "BW"."T0006" IS 'disposition::realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed';

COMMENT ON COLUMN "BW"."T0006"."T0006_uid" IS 'uid disposition::Default primary key of disposition';

-- table T0007 definition
CREATE TABLE "BW"."T0007"
(
  "T0007_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0007 PRIMARY KEY ("T0007_uid")
);

COMMENT ON TABLE "BW"."T0007" IS 'ic::b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

COMMENT ON COLUMN "BW"."T0007"."T0007_uid" IS 'uid ic::Default primary key of ic';

-- table T0008 definition
CREATE TABLE "BW"."T0008"
(
  "T0008_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0008 PRIMARY KEY ("T0008_uid")
);

COMMENT ON TABLE "BW"."T0008" IS 'continuant::Continuant';

COMMENT ON COLUMN "BW"."T0008"."T0008_uid" IS 'uid continuant::Default primary key of continuant';

-- table T0009 definition
CREATE TABLE "BW"."T0009"
(
  "T0009_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0009 PRIMARY KEY ("T0009_uid")
);

COMMENT ON TABLE "BW"."T0009" IS 'datum label::A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label';

COMMENT ON COLUMN "BW"."T0009"."T0009_uid" IS 'uid datum label::Default primary key of datum label';

-- table T000a definition
CREATE TABLE "BW"."T000a"
(
  "T000a_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T000a PRIMARY KEY ("T000a_uid")
);

COMMENT ON TABLE "BW"."T000a" IS 'health care record::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.';

COMMENT ON COLUMN "BW"."T000a"."T000a_uid" IS 'uid health care record::Default primary key of health care record';

-- table T000b definition
CREATE TABLE "BW"."T000b"
(
  "T000b_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T000b PRIMARY KEY ("T000b_uid")
);

COMMENT ON TABLE "BW"."T000b" IS 'medical record identifier::A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

COMMENT ON COLUMN "BW"."T000b"."T000b_uid" IS 'uid medical record identifier::Default primary key of medical record identifier';

-- table T000c definition
CREATE TABLE "BW"."T000c"
(
  "T000c_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T000c PRIMARY KEY ("T000c_uid")
);

COMMENT ON TABLE "BW"."T000c" IS 'data item::a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.';

COMMENT ON COLUMN "BW"."T000c"."T000c_uid" IS 'uid data item::Default primary key of data item';

-- table T000d definition
CREATE TABLE "BW"."T000d"
(
  "T000d_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T000d PRIMARY KEY ("T000d_uid")
);

COMMENT ON TABLE "BW"."T000d" IS 'health care provider::A homo sapiens having with the health care provider role';

COMMENT ON COLUMN "BW"."T000d"."T000d_uid" IS 'uid health care provider::Default primary key of health care provider';

-- table T000e definition
CREATE TABLE "BW"."T000e"
(
  "T000e_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T000e PRIMARY KEY ("T000e_uid")
);

COMMENT ON TABLE "BW"."T000e" IS 'material::An independent continuant that is spatially extended whose identity is independent of that of other entities and can be maintained through time.';

COMMENT ON COLUMN "BW"."T000e"."T000e_uid" IS 'uid material::Default primary key of material';

-- table T000f definition
CREATE TABLE "BW"."T000f"
(
  "T000f_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T000f PRIMARY KEY ("T000f_uid")
);

COMMENT ON TABLE "BW"."T000f" IS 'medical record identifier intersectionOf health care record | is about | patient::medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

COMMENT ON COLUMN "BW"."T000f"."T000f_uid" IS 'uid medical record identifier intersectionOf health care record | is about | patient::Default primary key of medical record identifier intersectionOf health care record | is about | patient';

-- table T0010 definition
CREATE TABLE "BW"."T0010"
(
  "T0010_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0010 PRIMARY KEY ("T0010_uid")
);

COMMENT ON TABLE "BW"."T0010" IS 'document::An information content entity that is a collection of information content entities intended to be understood together as a whole.';

COMMENT ON COLUMN "BW"."T0010"."T0010_uid" IS 'uid document::Default primary key of document';

-- table T0011 definition
CREATE TABLE "BW"."T0011"
(
  "T0011_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0011 PRIMARY KEY ("T0011_uid")
);

COMMENT ON TABLE "BW"."T0011" IS 'measurement unit label::A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

COMMENT ON COLUMN "BW"."T0011"."T0011_uid" IS 'uid measurement unit label::Default primary key of measurement unit label';

-- table T0012 definition
CREATE TABLE "BW"."T0012"
(
  "T0012_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0012 PRIMARY KEY ("T0012_uid")
);

COMMENT ON TABLE "BW"."T0012" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

COMMENT ON COLUMN "BW"."T0012"."T0012_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

-- table T0013 definition
CREATE TABLE "BW"."T0013"
(
  "T0013_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0013 PRIMARY KEY ("T0013_uid")
);

COMMENT ON TABLE "BW"."T0013" IS 'health care provider role::A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

COMMENT ON COLUMN "BW"."T0013"."T0013_uid" IS 'uid health care provider role::Default primary key of health care provider role';

-- table T0014 definition
CREATE TABLE "BW"."T0014"
(
  "T0014_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0014 PRIMARY KEY ("T0014_uid")
);

COMMENT ON TABLE "BW"."T0014" IS 'physiological evaluation::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

COMMENT ON COLUMN "BW"."T0014"."T0014_uid" IS 'uid physiological evaluation::Default primary key of physiological evaluation';

-- table T0015 definition
CREATE TABLE "BW"."T0015"
(
  "T0015_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0015 PRIMARY KEY ("T0015_uid")
);

COMMENT ON TABLE "BW"."T0015" IS 'RAMQ vulnerability code::A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.';

COMMENT ON COLUMN "BW"."T0015"."T0015_uid" IS 'uid RAMQ vulnerability code::Default primary key of RAMQ vulnerability code';

-- table T0016 definition
CREATE TABLE "BW"."T0016"
(
  "T0016_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0016 PRIMARY KEY ("T0016_uid")
);

COMMENT ON TABLE "BW"."T0016" IS 'obesity::A disease marked by an abnormally high, unhealthy amount of body fat.; A disorder characterized by having an increased body fat.';

COMMENT ON COLUMN "BW"."T0016"."T0016_uid" IS 'uid obesity::Default primary key of obesity';

-- table T0017 definition
CREATE TABLE "BW"."T0017"
(
  "T0017_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0017 PRIMARY KEY ("T0017_uid")
);

COMMENT ON TABLE "BW"."T0017" IS 'quality::a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized';

COMMENT ON COLUMN "BW"."T0017"."T0017_uid" IS 'uid quality::Default primary key of quality';

-- table T0018 definition
CREATE TABLE "BW"."T0018"
(
  "T0018_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0018 PRIMARY KEY ("T0018_uid")
);

COMMENT ON TABLE "BW"."T0018" IS 'realizable::RealizableEntity';

COMMENT ON COLUMN "BW"."T0018"."T0018_uid" IS 'uid realizable::Default primary key of realizable';

-- table T0019 definition
CREATE TABLE "BW"."T0019"
(
  "T0019_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0019 PRIMARY KEY ("T0019_uid")
);

COMMENT ON TABLE "BW"."T0019" IS 'entity::A thing that exists or has existed or will exist.';

COMMENT ON COLUMN "BW"."T0019"."T0019_uid" IS 'uid entity::Default primary key of entity';

-- table T001a definition
CREATE TABLE "BW"."T001a"
(
  "T001a_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T001a PRIMARY KEY ("T001a_uid")
);

COMMENT ON TABLE "BW"."T001a" IS 'role::A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

COMMENT ON COLUMN "BW"."T001a"."T001a_uid" IS 'uid role::Default primary key of role';

-- table T001b definition
CREATE TABLE "BW"."T001b"
(
  "T001b_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T001b PRIMARY KEY ("T001b_uid")
);

COMMENT ON TABLE "BW"."T001b" IS 'disease::A disposition (i) to undergo pathological processes that (ii) exists in an organism because of one or more disorders in that organism.';

COMMENT ON COLUMN "BW"."T001b"."T001b_uid" IS 'uid disease::Default primary key of disease';

-- table T001c definition
CREATE TABLE "BW"."T001c"
(
  "T001c_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T001c PRIMARY KEY ("T001c_uid")
);

COMMENT ON TABLE "BW"."T001c" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism::physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

COMMENT ON COLUMN "BW"."T001c"."T001c_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism';

-- table T001d definition
CREATE TABLE "BW"."T001d"
(
  "T001d_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T001d PRIMARY KEY ("T001d_uid")
);

COMMENT ON TABLE "BW"."T001d" IS 'gdc::A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

COMMENT ON COLUMN "BW"."T001d"."T001d_uid" IS 'uid gdc::Default primary key of gdc';

-- table T001e definition
CREATE TABLE "BW"."T001e"
(
  "T001e_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T001e PRIMARY KEY ("T001e_uid")
);

COMMENT ON TABLE "BW"."T001e" IS 'process::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

COMMENT ON COLUMN "BW"."T001e"."T001e_uid" IS 'uid process::Default primary key of process';

-- table T001f definition
CREATE TABLE "BW"."T001f"
(
  "T001f_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T001f PRIMARY KEY ("T001f_uid")
);

COMMENT ON TABLE "BW"."T001f" IS 'occurrent::
An entity that has temporal parts and that happens, unfolds or develops through time.
';

COMMENT ON COLUMN "BW"."T001f"."T001f_uid" IS 'uid occurrent::Default primary key of occurrent';

-- table T0020 definition
CREATE TABLE "BW"."T0020"
(
  "T0020_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0020 PRIMARY KEY ("T0020_uid")
);

COMMENT ON TABLE "BW"."T0020" IS 'physiological evaluation report::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

COMMENT ON COLUMN "BW"."T0020"."T0020_uid" IS 'uid physiological evaluation report::Default primary key of physiological evaluation report';

-- table T0021 definition
CREATE TABLE "BW"."T0021"
(
  "T0021_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0021 PRIMARY KEY ("T0021_uid")
);

COMMENT ON TABLE "BW"."T0021" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality::physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality';

COMMENT ON COLUMN "BW"."T0021"."T0021_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- table T0022 definition
CREATE TABLE "BW"."T0022"
(
  "T0022_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0022 PRIMARY KEY ("T0022_uid")
);

COMMENT ON TABLE "BW"."T0022" IS 'patient::An organism having the role of patient.';

COMMENT ON COLUMN "BW"."T0022"."T0022_uid" IS 'uid patient::Default primary key of patient';

-- table T0023 definition
CREATE TABLE "BW"."T0023"
(
  "T0023_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0023 PRIMARY KEY ("T0023_uid")
);

COMMENT ON TABLE "BW"."T0023" IS 'symbol::An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.';

COMMENT ON COLUMN "BW"."T0023"."T0023_uid" IS 'uid symbol::Default primary key of symbol';

-- table T0024 definition
CREATE TABLE "BW"."T0024"
(
  "T0024_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0024 PRIMARY KEY ("T0024_uid")
);

COMMENT ON TABLE "BW"."T0024" IS 'body weight::a quality of a body of having a weight';

COMMENT ON COLUMN "BW"."T0024"."T0024_uid" IS 'uid body weight::Default primary key of body weight';

-- table T0025 definition
CREATE TABLE "BW"."T0025"
(
  "T0025_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0025 PRIMARY KEY ("T0025_uid")
);

COMMENT ON TABLE "BW"."T0025" IS 'centrally registered identifier symbol::A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.';

COMMENT ON COLUMN "BW"."T0025"."T0025_uid" IS 'uid centrally registered identifier symbol::Default primary key of centrally registered identifier symbol';

-- table T0026 definition
CREATE TABLE "BW"."T0026"
(
  "T0026_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0026 PRIMARY KEY ("T0026_uid")
);

COMMENT ON TABLE "BW"."T0026" IS 'Homo sapiens::Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

COMMENT ON COLUMN "BW"."T0026"."T0026_uid" IS 'uid Homo sapiens::Default primary key of Homo sapiens';

-- table T0027 definition
CREATE TABLE "BW"."T0027"
(
  "T0027_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0027 PRIMARY KEY ("T0027_uid")
);

COMMENT ON TABLE "BW"."T0027" IS 'organism::A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

COMMENT ON COLUMN "BW"."T0027"."T0027_uid" IS 'uid organism::Default primary key of organism';

-- table T0028 definition
CREATE TABLE "BW"."T0028"
(
  "T0028_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0028 PRIMARY KEY ("T0028_uid")
);

COMMENT ON TABLE "BW"."T0028" IS 'patient role::a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

COMMENT ON COLUMN "BW"."T0028"."T0028_uid" IS 'uid patient role::Default primary key of patient role';

-- table T0029 definition
CREATE TABLE "BW"."T0029"
(
  "T0029_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0029 PRIMARY KEY ("T0029_uid")
);

COMMENT ON TABLE "BW"."T0029" IS 'planned process::A process that realizes a plan which is the concretization of a plan specification.';

COMMENT ON COLUMN "BW"."T0029"."T0029_uid" IS 'uid planned process::Default primary key of planned process';

-- table T002a definition
CREATE TABLE "BW"."T002a"
(
  "T002a_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T002a PRIMARY KEY ("T002a_uid")
);

COMMENT ON TABLE "BW"."T002a" IS 'physiological data item::A data item that is the specified output of some physiological evaluation.';

COMMENT ON COLUMN "BW"."T002a"."T002a_uid" IS 'uid physiological data item::Default primary key of physiological data item';

-- table T002b definition
CREATE TABLE "BW"."T002b"
(
  "T002b_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T002b PRIMARY KEY ("T002b_uid")
);

COMMENT ON TABLE "BW"."T002b" IS 'physiological evaluation from health care provider::A physiological evaluation that is evaluated by a health care provider';

COMMENT ON COLUMN "BW"."T002b"."T002b_uid" IS 'uid physiological evaluation from health care provider::Default primary key of physiological evaluation from health care provider';

-- table T002c definition
CREATE TABLE "BW"."T002c"
(
  "T002c_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T002c PRIMARY KEY ("T002c_uid")
);

COMMENT ON TABLE "BW"."T002c" IS 'measurement datum::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.';

COMMENT ON COLUMN "BW"."T002c"."T002c_uid" IS 'uid measurement datum::Default primary key of measurement datum';

-- table T002d definition
CREATE TABLE "BW"."T002d"
(
  "T002d_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T002d PRIMARY KEY ("T002d_uid")
);

COMMENT ON TABLE "BW"."T002d" IS 'weight unit::a measurement unit label of a weight';

COMMENT ON COLUMN "BW"."T002d"."T002d_uid" IS 'uid weight unit::Default primary key of weight unit';

-- table T002e definition
CREATE TABLE "BW"."T002e"
(
  "T002e_IAO_0000004" "BW"."double"  NOT NULL, 
  "T0001_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T002e PRIMARY KEY ("T0001_uid")
);

COMMENT ON TABLE "BW"."T002e" IS 'scalar measurement datum has measurement value::IAO_0000032 [1..1] IAO_0000004 double';

COMMENT ON COLUMN "BW"."T002e"."T002e_IAO_0000004" IS 'has measurement value::null';

COMMENT ON COLUMN "BW"."T002e"."T0001_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

-- table T002f definition
CREATE TABLE "BW"."T002f"
(
  "T0001_uid" "BW"."uid_domain"  NOT NULL, 
  "T002f_IAO_0000004" "BW"."Literal"  NOT NULL,
  CONSTRAINT key_T002f PRIMARY KEY ("T0001_uid", "T002f_IAO_0000004")
);

COMMENT ON TABLE "BW"."T002f" IS 'scalar measurement datum has measurement value::DataMinCardinality(1 <http://purl.obolibrary.org/obo/IAO_0000004> rdfs:Literal)';

COMMENT ON COLUMN "BW"."T002f"."T0001_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

COMMENT ON COLUMN "BW"."T002f"."T002f_IAO_0000004" IS 'has measurement value::null';

-- table T0030 definition
CREATE TABLE "BW"."T0030"
(
  "T0030_PHYSIO_0000100" "BW"."string"  NOT NULL, 
  "T0011_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0030 PRIMARY KEY ("T0011_uid")
);

COMMENT ON TABLE "BW"."T0030" IS 'measurement unit label has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

COMMENT ON COLUMN "BW"."T0030"."T0030_PHYSIO_0000100" IS 'has value::null';

COMMENT ON COLUMN "BW"."T0030"."T0011_uid" IS 'uid measurement unit label::Default primary key of measurement unit label';

-- table T0031 definition
CREATE TABLE "BW"."T0031"
(
  "T0031_PHYSIO_0000100" "BW"."string"  NOT NULL, 
  "T0025_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0031 PRIMARY KEY ("T0025_uid")
);

COMMENT ON TABLE "BW"."T0031" IS 'centrally registered identifier symbol has value::DataExactCardinality(1 <http://purl.obolibrary.org/obo/PHYSIO_0000100> xsd:string)';

COMMENT ON COLUMN "BW"."T0031"."T0031_PHYSIO_0000100" IS 'has value::null';

COMMENT ON COLUMN "BW"."T0031"."T0025_uid" IS 'uid centrally registered identifier symbol::Default primary key of centrally registered identifier symbol';

-- table T0032 definition
CREATE TABLE "BW"."T0032"
(
  "T0001_uid" "BW"."uid_domain"  NOT NULL, 
  "T0005_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0032 PRIMARY KEY ("T0001_uid", "T0005_uid")
);

COMMENT ON TABLE "BW"."T0032" IS 'scalar measurement datum has value specification scalar value specification::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null A value specification that consists of two parts: a numeral and a unit label';

COMMENT ON COLUMN "BW"."T0032"."T0001_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

COMMENT ON COLUMN "BW"."T0032"."T0005_uid" IS 'uid scalar value specification::Default primary key of scalar value specification';

-- table T0033 definition
CREATE TABLE "BW"."T0033"
(
  "T0001_uid" "BW"."uid_domain"  NOT NULL, 
  "T0000_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0033 PRIMARY KEY ("T0001_uid")
);

COMMENT ON TABLE "BW"."T0033" IS 'scalar measurement datum has measurement unit label Thing::a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label. null The class owl:Thing is the class of all individuals.';

COMMENT ON COLUMN "BW"."T0033"."T0001_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

COMMENT ON COLUMN "BW"."T0033"."T0000_uid" IS 'uid Thing::Default primary key of Thing';

-- table T0034 definition
CREATE TABLE "BW"."T0034"
(
  "T0003_uid" "BW"."uid_domain"  NOT NULL, 
  "T001d_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0034 PRIMARY KEY ("T0003_uid", "T001d_uid")
);

COMMENT ON TABLE "BW"."T0034" IS 'sdc concretizes gdc::SpecificallyDependentContinuant A relationship between a specifically dependent continuant and a generically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. Multiple specifically dependent continuants can concretize the same generically dependent continuant. A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time.';

COMMENT ON COLUMN "BW"."T0034"."T0003_uid" IS 'uid sdc::Default primary key of sdc';

COMMENT ON COLUMN "BW"."T0034"."T001d_uid" IS 'uid gdc::Default primary key of gdc';

-- table T0035 definition
CREATE TABLE "BW"."T0035"
(
  "T0004_uid" "BW"."uid_domain"  NOT NULL, 
  "T0019_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0035 PRIMARY KEY ("T0004_uid", "T0019_uid")
);

COMMENT ON TABLE "BW"."T0035" IS 'information content entity is about entity::A generically dependent continuant that is about some thing. is_about is a (currently) primitive relation that relates an information artifact to an entity. A thing that exists or has existed or will exist.';

COMMENT ON COLUMN "BW"."T0035"."T0004_uid" IS 'uid information content entity::Default primary key of information content entity';

COMMENT ON COLUMN "BW"."T0035"."T0019_uid" IS 'uid entity::Default primary key of entity';

-- table T0036 definition
CREATE TABLE "BW"."T0036"
(
  "T0004_uid" "BW"."uid_domain"  NOT NULL, 
  "T0019_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0036 PRIMARY KEY ("T0004_uid", "T0019_uid")
);

COMMENT ON TABLE "BW"."T0036" IS 'information content entity denotes entity::A generically dependent continuant that is about some thing. null A thing that exists or has existed or will exist.';

COMMENT ON COLUMN "BW"."T0036"."T0004_uid" IS 'uid information content entity::Default primary key of information content entity';

COMMENT ON COLUMN "BW"."T0036"."T0019_uid" IS 'uid entity::Default primary key of entity';

-- table T0037 definition
CREATE TABLE "BW"."T0037"
(
  "T0007_uid" "BW"."uid_domain"  NOT NULL, 
  "T001a_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0037 PRIMARY KEY ("T0007_uid", "T001a_uid")
);

COMMENT ON TABLE "BW"."T0037" IS 'ic has role role::b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.';

COMMENT ON COLUMN "BW"."T0037"."T0007_uid" IS 'uid ic::Default primary key of ic';

COMMENT ON COLUMN "BW"."T0037"."T001a_uid" IS 'uid role::Default primary key of role';

-- table T0038 definition
CREATE TABLE "BW"."T0038"
(
  "T0007_uid_domain" "BW"."uid_domain"  NOT NULL, 
  "T0007_uid_range" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0038 PRIMARY KEY ("T0007_uid_domain", "T0007_uid_range")
);

COMMENT ON TABLE "BW"."T0038" IS 'ic located in ic::b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002]) a relation between two independent continuants, the target and the location, in which the target is entirely within the location b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

COMMENT ON COLUMN "BW"."T0038"."T0007_uid_domain" IS 'uid ic_domain::Default primary key of ic';

COMMENT ON COLUMN "BW"."T0038"."T0007_uid_range" IS 'uid ic_range::Default primary key of ic';

-- table T0039 definition
CREATE TABLE "BW"."T0039"
(
  "T0008_uid" "BW"."uid_domain"  NOT NULL, 
  "T001f_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0039 PRIMARY KEY ("T0008_uid", "T001f_uid")
);

COMMENT ON TABLE "BW"."T0039" IS 'continuant participates in occurrent::Continuant a relation between a continuant and a process, in which the continuant is somehow involved in the process 
An entity that has temporal parts and that happens, unfolds or develops through time.
';

COMMENT ON COLUMN "BW"."T0039"."T0008_uid" IS 'uid continuant::Default primary key of continuant';

COMMENT ON COLUMN "BW"."T0039"."T001f_uid" IS 'uid occurrent::Default primary key of occurrent';

-- table T003a definition
CREATE TABLE "BW"."T003a"
(
  "T000a_uid" "BW"."uid_domain"  NOT NULL, 
  "T0027_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T003a PRIMARY KEY ("T000a_uid", "T0027_uid")
);

COMMENT ON TABLE "BW"."T003a" IS 'health care record is about organism::A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

COMMENT ON COLUMN "BW"."T003a"."T000a_uid" IS 'uid health care record::Default primary key of health care record';

COMMENT ON COLUMN "BW"."T003a"."T0027_uid" IS 'uid organism::Default primary key of organism';

-- table T003b definition
CREATE TABLE "BW"."T003b"
(
  "T000b_uid" "BW"."uid_domain"  NOT NULL, 
  "T000f_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T003b PRIMARY KEY ("T000b_uid", "T000f_uid")
);

COMMENT ON TABLE "BW"."T003b" IS 'medical record identifier denotes medical record identifier intersectionOf health care record | is about | patient::A CRID symbol that is sufficent to look up a patient file in a medical record registry. null medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

COMMENT ON COLUMN "BW"."T003b"."T000b_uid" IS 'uid medical record identifier::Default primary key of medical record identifier';

COMMENT ON COLUMN "BW"."T003b"."T000f_uid" IS 'uid medical record identifier intersectionOf health care record | is about | patient::Default primary key of medical record identifier intersectionOf health care record | is about | patient';

-- table T003c definition
CREATE TABLE "BW"."T003c"
(
  "T000d_uid" "BW"."uid_domain"  NOT NULL, 
  "T0013_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T003c PRIMARY KEY ("T000d_uid", "T0013_uid")
);

COMMENT ON TABLE "BW"."T003c" IS 'health care provider has role health care provider role::A homo sapiens having with the health care provider role a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.';

COMMENT ON COLUMN "BW"."T003c"."T000d_uid" IS 'uid health care provider::Default primary key of health care provider';

COMMENT ON COLUMN "BW"."T003c"."T0013_uid" IS 'uid health care provider role::Default primary key of health care provider role';

-- table T003d definition
CREATE TABLE "BW"."T003d"
(
  "T000f_uid" "BW"."uid_domain"  NOT NULL, 
  "T0022_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T003d PRIMARY KEY ("T000f_uid", "T0022_uid")
);

COMMENT ON TABLE "BW"."T003d" IS 'medical record identifier intersectionOf health care record | is about | patient is about patient::medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.';

COMMENT ON COLUMN "BW"."T003d"."T000f_uid" IS 'uid medical record identifier intersectionOf health care record | is about | patient::Default primary key of medical record identifier intersectionOf health care record | is about | patient';

COMMENT ON COLUMN "BW"."T003d"."T0022_uid" IS 'uid patient::Default primary key of patient';

-- table T003e definition
CREATE TABLE "BW"."T003e"
(
  "T0012_uid" "BW"."uid_domain"  NOT NULL, 
  "T001c_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T003e PRIMARY KEY ("T0012_uid", "T001c_uid")
);

COMMENT ON TABLE "BW"."T003e" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism is about physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism::physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs. is_about is a (currently) primitive relation that relates an information artifact to an entity. physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

COMMENT ON COLUMN "BW"."T003e"."T0012_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

COMMENT ON COLUMN "BW"."T003e"."T001c_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism';

-- table T003f definition
CREATE TABLE "BW"."T003f"
(
  "T0014_uid" "BW"."uid_domain"  NOT NULL, 
  "T0012_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T003f PRIMARY KEY ("T0014_uid", "T0012_uid")
);

COMMENT ON TABLE "BW"."T003f" IS 'physiological evaluation has_specified_output physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

COMMENT ON COLUMN "BW"."T003f"."T0014_uid" IS 'uid physiological evaluation::Default primary key of physiological evaluation';

COMMENT ON COLUMN "BW"."T003f"."T0012_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

-- table T0040 definition
CREATE TABLE "BW"."T0040"
(
  "T0014_uid" "BW"."uid_domain"  NOT NULL, 
  "T0026_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0040 PRIMARY KEY ("T0014_uid", "T0026_uid")
);

COMMENT ON TABLE "BW"."T0040" IS 'physiological evaluation has evaluant Homo sapiens::A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. A has participant property in a evaluation process where the participant does evaluate Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.';

COMMENT ON COLUMN "BW"."T0040"."T0014_uid" IS 'uid physiological evaluation::Default primary key of physiological evaluation';

COMMENT ON COLUMN "BW"."T0040"."T0026_uid" IS 'uid Homo sapiens::Default primary key of Homo sapiens';

-- table T0041 definition
CREATE TABLE "BW"."T0041"
(
  "T0018_uid" "BW"."uid_domain"  NOT NULL, 
  "T001e_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0041 PRIMARY KEY ("T0018_uid", "T001e_uid")
);

COMMENT ON TABLE "BW"."T0041" IS 'realizable realized in process::RealizableEntity Paraphrase of elucidation: a relation between a realizable entity and a process, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003])';

COMMENT ON COLUMN "BW"."T0041"."T0018_uid" IS 'uid realizable::Default primary key of realizable';

COMMENT ON COLUMN "BW"."T0041"."T001e_uid" IS 'uid process::Default primary key of process';

-- table T0042 definition
CREATE TABLE "BW"."T0042"
(
  "T0019_uid_domain" "BW"."uid_domain"  NOT NULL, 
  "T0019_uid_range" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0042 PRIMARY KEY ("T0019_uid_domain", "T0019_uid_range")
);

COMMENT ON TABLE "BW"."T0042" IS 'entity part of entity::A thing that exists or has existed or will exist. 
a core relation that holds between a part and its whole
 A thing that exists or has existed or will exist.';

COMMENT ON COLUMN "BW"."T0042"."T0019_uid_domain" IS 'uid entity_domain::Default primary key of entity';

COMMENT ON COLUMN "BW"."T0042"."T0019_uid_range" IS 'uid entity_range::Default primary key of entity';

-- table T0043 definition
CREATE TABLE "BW"."T0043"
(
  "T001d_uid" "BW"."uid_domain"  NOT NULL, 
  "T0003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0043 PRIMARY KEY ("T001d_uid", "T0003_uid")
);

COMMENT ON TABLE "BW"."T0043" IS 'gdc is concretized as sdc::A continuant that is dependent on one or other independent continuant bearers. For every instance of A requires some instance of (an independent continuant type) B but which instance of B serves can change from time to time. A relationship between a generically dependent continuant and a specifically dependent continuant, in which the generically dependent continuant depends on some independent continuant in virtue of the fact that the specifically dependent continuant also depends on that same independent continuant. A generically dependent continuant may be concretized as multiple specifically dependent continuants. SpecificallyDependentContinuant';

COMMENT ON COLUMN "BW"."T0043"."T001d_uid" IS 'uid gdc::Default primary key of gdc';

COMMENT ON COLUMN "BW"."T0043"."T0003_uid" IS 'uid sdc::Default primary key of sdc';

-- table T0044 definition
CREATE TABLE "BW"."T0044"
(
  "T001e_uid" "BW"."uid_domain"  NOT NULL, 
  "T0018_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0044 PRIMARY KEY ("T001e_uid", "T0018_uid")
);

COMMENT ON TABLE "BW"."T0044" IS 'process realizes realizable::p is a process = Def. p is an occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t. (axiom label in BFO2 Reference: [083-003]) Paraphrase of elucidation: a relation between a process and a realizable entity, where there is some material entity that is bearer of the realizable entity and participates in the process, and the realizable entity comes to be realized in the course of the process RealizableEntity';

COMMENT ON COLUMN "BW"."T0044"."T001e_uid" IS 'uid process::Default primary key of process';

COMMENT ON COLUMN "BW"."T0044"."T0018_uid" IS 'uid realizable::Default primary key of realizable';

-- table T0045 definition
CREATE TABLE "BW"."T0045"
(
  "T001f_uid" "BW"."uid_domain"  NOT NULL, 
  "T0007_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0045 PRIMARY KEY ("T001f_uid", "T0007_uid")
);

COMMENT ON TABLE "BW"."T0045" IS 'occurrent occurs in ic::
An entity that has temporal parts and that happens, unfolds or develops through time.
 b occurs_in c =def b is a process and c is a material entity or immaterial entity& there exists a spatiotemporal region r and b occupies_spatiotemporal_region r.& forall(t) if b exists_at t then c exists_at t & there exist spatial regions s and s’ where & b spatially_projects_onto s at t& c is occupies_spatial_region s’ at t& s is a proper_continuant_part_of s’ at t b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])';

COMMENT ON COLUMN "BW"."T0045"."T001f_uid" IS 'uid occurrent::Default primary key of occurrent';

COMMENT ON COLUMN "BW"."T0045"."T0007_uid" IS 'uid ic::Default primary key of ic';

-- table T0046 definition
CREATE TABLE "BW"."T0046"
(
  "T001f_uid" "BW"."uid_domain"  NOT NULL, 
  "T0008_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0046 PRIMARY KEY ("T001f_uid", "T0008_uid")
);

COMMENT ON TABLE "BW"."T0046" IS 'occurrent has participant continuant::
An entity that has temporal parts and that happens, unfolds or develops through time.
 a relation between a process and a continuant, in which the continuant is somehow involved in the process Continuant';

COMMENT ON COLUMN "BW"."T0046"."T001f_uid" IS 'uid occurrent::Default primary key of occurrent';

COMMENT ON COLUMN "BW"."T0046"."T0008_uid" IS 'uid continuant::Default primary key of continuant';

-- table T0047 definition
CREATE TABLE "BW"."T0047"
(
  "T0020_uid" "BW"."uid_domain"  NOT NULL, 
  "T002a_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0047 PRIMARY KEY ("T0020_uid", "T002a_uid")
);

COMMENT ON TABLE "BW"."T0047" IS 'physiological evaluation report has part physiological data item::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A data item that is the specified output of some physiological evaluation.';

COMMENT ON COLUMN "BW"."T0047"."T0020_uid" IS 'uid physiological evaluation report::Default primary key of physiological evaluation report';

COMMENT ON COLUMN "BW"."T0047"."T002a_uid" IS 'uid physiological data item::Default primary key of physiological data item';

-- table T0048 definition
CREATE TABLE "BW"."T0048"
(
  "T0020_uid" "BW"."uid_domain"  NOT NULL, 
  "T000b_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0048 PRIMARY KEY ("T0020_uid", "T000b_uid")
);

COMMENT ON TABLE "BW"."T0048" IS 'physiological evaluation report has part medical record identifier::A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions. a core relation that holds between a whole and its part A CRID symbol that is sufficent to look up a patient file in a medical record registry.';

COMMENT ON COLUMN "BW"."T0048"."T0020_uid" IS 'uid physiological evaluation report::Default primary key of physiological evaluation report';

COMMENT ON COLUMN "BW"."T0048"."T000b_uid" IS 'uid medical record identifier::Default primary key of medical record identifier';

-- table T0049 definition
CREATE TABLE "BW"."T0049"
(
  "T0021_uid" "BW"."uid_domain"  NOT NULL, 
  "T0027_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T0049 PRIMARY KEY ("T0021_uid", "T0027_uid")
);

COMMENT ON TABLE "BW"."T0049" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality inheres in organism::physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.';

COMMENT ON COLUMN "BW"."T0049"."T0021_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

COMMENT ON COLUMN "BW"."T0049"."T0027_uid" IS 'uid organism::Default primary key of organism';

-- table T004a definition
CREATE TABLE "BW"."T004a"
(
  "T0022_uid" "BW"."uid_domain"  NOT NULL, 
  "T0028_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T004a PRIMARY KEY ("T0022_uid", "T0028_uid")
);

COMMENT ON TABLE "BW"."T004a" IS 'patient has role patient role::An organism having the role of patient. a relation between an independent continuant (the bearer) and a role, in which the role specifically depends on the bearer for its existence a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider';

COMMENT ON COLUMN "BW"."T004a"."T0022_uid" IS 'uid patient::Default primary key of patient';

COMMENT ON COLUMN "BW"."T004a"."T0028_uid" IS 'uid patient role::Default primary key of patient role';

-- table T004b definition
CREATE TABLE "BW"."T004b"
(
  "T002a_uid" "BW"."uid_domain"  NOT NULL, 
  "T0014_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T004b PRIMARY KEY ("T002a_uid", "T0014_uid")
);

COMMENT ON TABLE "BW"."T004b" IS 'physiological data item is_specified_output_of physiological evaluation::A data item that is the specified output of some physiological evaluation. A relation between a planned process and a continuant participating in that process. The presence of the continuant at the end of the process is explicitly specified in the objective specification which the process realizes the concretization of. A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.';

COMMENT ON COLUMN "BW"."T004b"."T002a_uid" IS 'uid physiological data item::Default primary key of physiological data item';

COMMENT ON COLUMN "BW"."T004b"."T0014_uid" IS 'uid physiological evaluation::Default primary key of physiological evaluation';

-- table T004c definition
CREATE TABLE "BW"."T004c"
(
  "T002b_uid" "BW"."uid_domain"  NOT NULL, 
  "T000d_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T004c PRIMARY KEY ("T002b_uid", "T000d_uid")
);

COMMENT ON TABLE "BW"."T004c" IS 'physiological evaluation from health care provider has evaluant health care provider::A physiological evaluation that is evaluated by a health care provider A has participant property in a evaluation process where the participant does evaluate A homo sapiens having with the health care provider role';

COMMENT ON COLUMN "BW"."T004c"."T002b_uid" IS 'uid physiological evaluation from health care provider::Default primary key of physiological evaluation from health care provider';

COMMENT ON COLUMN "BW"."T004c"."T000d_uid" IS 'uid health care provider::Default primary key of health care provider';

-- table T004d definition
CREATE TABLE "BW"."T004d"
(
  "T002c_uid" "BW"."uid_domain"  NOT NULL, 
  "T0011_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T004d PRIMARY KEY ("T002c_uid")
);

COMMENT ON TABLE "BW"."T004d" IS 'measurement datum has measurement unit label measurement unit label::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.';

COMMENT ON COLUMN "BW"."T004d"."T002c_uid" IS 'uid measurement datum::Default primary key of measurement datum';

COMMENT ON COLUMN "BW"."T004d"."T0011_uid" IS 'uid measurement unit label::Default primary key of measurement unit label';

-- table T004e definition
CREATE TABLE "BW"."T004e"
(
  "T002c_uid" "BW"."uid_domain"  NOT NULL, 
  "T0002_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT key_T004e PRIMARY KEY ("T002c_uid", "T0002_uid")
);

COMMENT ON TABLE "BW"."T004e" IS 'measurement datum has value specification value specification::A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device. null An information content entity that specifies a value within a classification scheme or on a quantitative scale.';

COMMENT ON COLUMN "BW"."T004e"."T002c_uid" IS 'uid measurement datum::Default primary key of measurement datum';

COMMENT ON COLUMN "BW"."T004e"."T0002_uid" IS 'uid value specification::Default primary key of value specification';

-- Foreign key definition : T0021 -> T0000
ALTER TABLE "BW"."T0021"
  ADD CONSTRAINT fk0_T0021 FOREIGN KEY ("T0021_uid")
    REFERENCES "BW"."T0000" ("T0000_uid");

COMMENT ON CONSTRAINT fk0_T0021 ON "BW"."T0021" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality -> Thing';

-- Foreign key definition : T001f -> T0019
ALTER TABLE "BW"."T001f"
  ADD CONSTRAINT fk0_T001f FOREIGN KEY ("T001f_uid")
    REFERENCES "BW"."T0019" ("T0019_uid");

COMMENT ON CONSTRAINT fk0_T001f ON "BW"."T001f" IS 'occurrent -> entity';

-- Foreign key definition : T0013 -> T001a
ALTER TABLE "BW"."T0013"
  ADD CONSTRAINT fk0_T0013 FOREIGN KEY ("T0013_uid")
    REFERENCES "BW"."T001a" ("T001a_uid");

COMMENT ON CONSTRAINT fk0_T0013 ON "BW"."T0013" IS 'health care provider role -> role';

-- Foreign key definition : T0020 -> T0010
ALTER TABLE "BW"."T0020"
  ADD CONSTRAINT fk0_T0020 FOREIGN KEY ("T0020_uid")
    REFERENCES "BW"."T0010" ("T0010_uid");

COMMENT ON CONSTRAINT fk0_T0020 ON "BW"."T0020" IS 'physiological evaluation report -> document';

-- Foreign key definition : T0010 -> T0004
ALTER TABLE "BW"."T0010"
  ADD CONSTRAINT fk0_T0010 FOREIGN KEY ("T0010_uid")
    REFERENCES "BW"."T0004" ("T0004_uid");

COMMENT ON CONSTRAINT fk0_T0010 ON "BW"."T0010" IS 'document -> information content entity';

-- Foreign key definition : T002a -> T000c
ALTER TABLE "BW"."T002a"
  ADD CONSTRAINT fk0_T002a FOREIGN KEY ("T002a_uid")
    REFERENCES "BW"."T000c" ("T000c_uid");

COMMENT ON CONSTRAINT fk0_T002a ON "BW"."T002a" IS 'physiological data item -> data item';

-- Foreign key definition : T002c -> T000c
ALTER TABLE "BW"."T002c"
  ADD CONSTRAINT fk0_T002c FOREIGN KEY ("T002c_uid")
    REFERENCES "BW"."T000c" ("T000c_uid");

COMMENT ON CONSTRAINT fk0_T002c ON "BW"."T002c" IS 'measurement datum -> data item';

-- Foreign key definition : T0015 -> T000c
ALTER TABLE "BW"."T0015"
  ADD CONSTRAINT fk0_T0015 FOREIGN KEY ("T0015_uid")
    REFERENCES "BW"."T000c" ("T000c_uid");

COMMENT ON CONSTRAINT fk0_T0015 ON "BW"."T0015" IS 'RAMQ vulnerability code -> data item';

-- Foreign key definition : T002b -> T0014
ALTER TABLE "BW"."T002b"
  ADD CONSTRAINT fk0_T002b FOREIGN KEY ("T002b_uid")
    REFERENCES "BW"."T0014" ("T0014_uid");

COMMENT ON CONSTRAINT fk0_T002b ON "BW"."T002b" IS 'physiological evaluation from health care provider -> physiological evaluation';

-- Foreign key definition : T0018 -> T0003
ALTER TABLE "BW"."T0018"
  ADD CONSTRAINT fk0_T0018 FOREIGN KEY ("T0018_uid")
    REFERENCES "BW"."T0003" ("T0003_uid");

COMMENT ON CONSTRAINT fk0_T0018 ON "BW"."T0018" IS 'realizable -> sdc';

-- Foreign key definition : T0009 -> T0004
ALTER TABLE "BW"."T0009"
  ADD CONSTRAINT fk0_T0009 FOREIGN KEY ("T0009_uid")
    REFERENCES "BW"."T0004" ("T0004_uid");

COMMENT ON CONSTRAINT fk0_T0009 ON "BW"."T0009" IS 'datum label -> information content entity';

-- Foreign key definition : T0017 -> T0003
ALTER TABLE "BW"."T0017"
  ADD CONSTRAINT fk0_T0017 FOREIGN KEY ("T0017_uid")
    REFERENCES "BW"."T0003" ("T0003_uid");

COMMENT ON CONSTRAINT fk0_T0017 ON "BW"."T0017" IS 'quality -> sdc';

-- Foreign key definition : T0026 -> T0027
ALTER TABLE "BW"."T0026"
  ADD CONSTRAINT fk0_T0026 FOREIGN KEY ("T0026_uid")
    REFERENCES "BW"."T0027" ("T0027_uid");

COMMENT ON CONSTRAINT fk0_T0026 ON "BW"."T0026" IS 'Homo sapiens -> organism';

-- Foreign key definition : T0016 -> T001b
ALTER TABLE "BW"."T0016"
  ADD CONSTRAINT fk0_T0016 FOREIGN KEY ("T0016_uid")
    REFERENCES "BW"."T001b" ("T001b_uid");

COMMENT ON CONSTRAINT fk0_T0016 ON "BW"."T0016" IS 'obesity -> disease';

-- Foreign key definition : T0011 -> T0009
ALTER TABLE "BW"."T0011"
  ADD CONSTRAINT fk0_T0011 FOREIGN KEY ("T0011_uid")
    REFERENCES "BW"."T0009" ("T0009_uid");

COMMENT ON CONSTRAINT fk0_T0011 ON "BW"."T0011" IS 'measurement unit label -> datum label';

-- Foreign key definition : T0004 -> T001d
ALTER TABLE "BW"."T0004"
  ADD CONSTRAINT fk0_T0004 FOREIGN KEY ("T0004_uid")
    REFERENCES "BW"."T001d" ("T001d_uid");

COMMENT ON CONSTRAINT fk0_T0004 ON "BW"."T0004" IS 'information content entity -> gdc';

-- Foreign key definition : T0002 -> T0004
ALTER TABLE "BW"."T0002"
  ADD CONSTRAINT fk0_T0002 FOREIGN KEY ("T0002_uid")
    REFERENCES "BW"."T0004" ("T0004_uid");

COMMENT ON CONSTRAINT fk0_T0002 ON "BW"."T0002" IS 'value specification -> information content entity';

-- Foreign key definition : T0006 -> T0018
ALTER TABLE "BW"."T0006"
  ADD CONSTRAINT fk0_T0006 FOREIGN KEY ("T0006_uid")
    REFERENCES "BW"."T0018" ("T0018_uid");

COMMENT ON CONSTRAINT fk0_T0006 ON "BW"."T0006" IS 'disposition -> realizable';

-- Foreign key definition : T001b -> T0006
ALTER TABLE "BW"."T001b"
  ADD CONSTRAINT fk0_T001b FOREIGN KEY ("T001b_uid")
    REFERENCES "BW"."T0006" ("T0006_uid");

COMMENT ON CONSTRAINT fk0_T001b ON "BW"."T001b" IS 'disease -> disposition';

-- Foreign key definition : T0023 -> T0004
ALTER TABLE "BW"."T0023"
  ADD CONSTRAINT fk0_T0023 FOREIGN KEY ("T0023_uid")
    REFERENCES "BW"."T0004" ("T0004_uid");

COMMENT ON CONSTRAINT fk0_T0023 ON "BW"."T0023" IS 'symbol -> information content entity';

-- Foreign key definition : T0014 -> T0029
ALTER TABLE "BW"."T0014"
  ADD CONSTRAINT fk0_T0014 FOREIGN KEY ("T0014_uid")
    REFERENCES "BW"."T0029" ("T0029_uid");

COMMENT ON CONSTRAINT fk0_T0014 ON "BW"."T0014" IS 'physiological evaluation -> planned process';

-- Foreign key definition : T000d -> T0026
ALTER TABLE "BW"."T000d"
  ADD CONSTRAINT fk0_T000d FOREIGN KEY ("T000d_uid")
    REFERENCES "BW"."T0026" ("T0026_uid");

COMMENT ON CONSTRAINT fk0_T000d ON "BW"."T000d" IS 'health care provider -> Homo sapiens';

-- Foreign key definition : T0019 -> T0000
ALTER TABLE "BW"."T0019"
  ADD CONSTRAINT fk0_T0019 FOREIGN KEY ("T0019_uid")
    REFERENCES "BW"."T0000" ("T0000_uid");

COMMENT ON CONSTRAINT fk0_T0019 ON "BW"."T0019" IS 'entity -> Thing';

-- Foreign key definition : T000a -> T0010
ALTER TABLE "BW"."T000a"
  ADD CONSTRAINT fk0_T000a FOREIGN KEY ("T000a_uid")
    REFERENCES "BW"."T0010" ("T0010_uid");

COMMENT ON CONSTRAINT fk0_T000a ON "BW"."T000a" IS 'health care record -> document';

-- Foreign key definition : T001d -> T0008
ALTER TABLE "BW"."T001d"
  ADD CONSTRAINT fk0_T001d FOREIGN KEY ("T001d_uid")
    REFERENCES "BW"."T0008" ("T0008_uid");

COMMENT ON CONSTRAINT fk0_T001d ON "BW"."T001d" IS 'gdc -> continuant';

-- Foreign key definition : T0028 -> T001a
ALTER TABLE "BW"."T0028"
  ADD CONSTRAINT fk0_T0028 FOREIGN KEY ("T0028_uid")
    REFERENCES "BW"."T001a" ("T001a_uid");

COMMENT ON CONSTRAINT fk0_T0028 ON "BW"."T0028" IS 'patient role -> role';

-- Foreign key definition : T000b -> T0025
ALTER TABLE "BW"."T000b"
  ADD CONSTRAINT fk0_T000b FOREIGN KEY ("T000b_uid")
    REFERENCES "BW"."T0025" ("T0025_uid");

COMMENT ON CONSTRAINT fk0_T000b ON "BW"."T000b" IS 'medical record identifier -> centrally registered identifier symbol';

-- Foreign key definition : T0005 -> T0002
ALTER TABLE "BW"."T0005"
  ADD CONSTRAINT fk0_T0005 FOREIGN KEY ("T0005_uid")
    REFERENCES "BW"."T0002" ("T0002_uid");

COMMENT ON CONSTRAINT fk0_T0005 ON "BW"."T0005" IS 'scalar value specification -> value specification';

-- Foreign key definition : T001a -> T0018
ALTER TABLE "BW"."T001a"
  ADD CONSTRAINT fk0_T001a FOREIGN KEY ("T001a_uid")
    REFERENCES "BW"."T0018" ("T0018_uid");

COMMENT ON CONSTRAINT fk0_T001a ON "BW"."T001a" IS 'role -> realizable';

-- Foreign key definition : T002d -> T0011
ALTER TABLE "BW"."T002d"
  ADD CONSTRAINT fk0_T002d FOREIGN KEY ("T002d_uid")
    REFERENCES "BW"."T0011" ("T0011_uid");

COMMENT ON CONSTRAINT fk0_T002d ON "BW"."T002d" IS 'weight unit -> measurement unit label';

-- Foreign key definition : T0025 -> T0023
ALTER TABLE "BW"."T0025"
  ADD CONSTRAINT fk0_T0025 FOREIGN KEY ("T0025_uid")
    REFERENCES "BW"."T0023" ("T0023_uid");

COMMENT ON CONSTRAINT fk0_T0025 ON "BW"."T0025" IS 'centrally registered identifier symbol -> symbol';

-- Foreign key definition : T0007 -> T0008
ALTER TABLE "BW"."T0007"
  ADD CONSTRAINT fk0_T0007 FOREIGN KEY ("T0007_uid")
    REFERENCES "BW"."T0008" ("T0008_uid");

COMMENT ON CONSTRAINT fk0_T0007 ON "BW"."T0007" IS 'ic -> continuant';

-- Foreign key definition : T0008 -> T0019
ALTER TABLE "BW"."T0008"
  ADD CONSTRAINT fk0_T0008 FOREIGN KEY ("T0008_uid")
    REFERENCES "BW"."T0019" ("T0019_uid");

COMMENT ON CONSTRAINT fk0_T0008 ON "BW"."T0008" IS 'continuant -> entity';

-- Foreign key definition : T0022 -> T0027
ALTER TABLE "BW"."T0022"
  ADD CONSTRAINT fk0_T0022 FOREIGN KEY ("T0022_uid")
    REFERENCES "BW"."T0027" ("T0027_uid");

COMMENT ON CONSTRAINT fk0_T0022 ON "BW"."T0022" IS 'patient -> organism';

-- Foreign key definition : T001e -> T001f
ALTER TABLE "BW"."T001e"
  ADD CONSTRAINT fk0_T001e FOREIGN KEY ("T001e_uid")
    REFERENCES "BW"."T001f" ("T001f_uid");

COMMENT ON CONSTRAINT fk0_T001e ON "BW"."T001e" IS 'process -> occurrent';

-- Foreign key definition : T0001 -> T002c
ALTER TABLE "BW"."T0001"
  ADD CONSTRAINT fk0_T0001 FOREIGN KEY ("T0001_uid")
    REFERENCES "BW"."T002c" ("T002c_uid");

COMMENT ON CONSTRAINT fk0_T0001 ON "BW"."T0001" IS 'scalar measurement datum -> measurement datum';

-- Foreign key definition : T000c -> T0004
ALTER TABLE "BW"."T000c"
  ADD CONSTRAINT fk0_T000c FOREIGN KEY ("T000c_uid")
    REFERENCES "BW"."T0004" ("T0004_uid");

COMMENT ON CONSTRAINT fk0_T000c ON "BW"."T000c" IS 'data item -> information content entity';

-- Foreign key definition : T0003 -> T0008
ALTER TABLE "BW"."T0003"
  ADD CONSTRAINT fk0_T0003 FOREIGN KEY ("T0003_uid")
    REFERENCES "BW"."T0008" ("T0008_uid");

COMMENT ON CONSTRAINT fk0_T0003 ON "BW"."T0003" IS 'sdc -> continuant';

-- Foreign key definition : T0024 -> T0017
ALTER TABLE "BW"."T0024"
  ADD CONSTRAINT fk0_T0024 FOREIGN KEY ("T0024_uid")
    REFERENCES "BW"."T0017" ("T0017_uid");

COMMENT ON CONSTRAINT fk0_T0024 ON "BW"."T0024" IS 'body weight -> quality';

-- Foreign key definition : T000e -> T0007
ALTER TABLE "BW"."T000e"
  ADD CONSTRAINT fk0_T000e FOREIGN KEY ("T000e_uid")
    REFERENCES "BW"."T0007" ("T0007_uid");

COMMENT ON CONSTRAINT fk0_T000e ON "BW"."T000e" IS 'material -> ic';

-- Foreign key definition : T0027 -> T000e
ALTER TABLE "BW"."T0027"
  ADD CONSTRAINT fk0_T0027 FOREIGN KEY ("T0027_uid")
    REFERENCES "BW"."T000e" ("T000e_uid");

COMMENT ON CONSTRAINT fk0_T0027 ON "BW"."T0027" IS 'organism -> material';

-- Foreign key definition : T0029 -> T001e
ALTER TABLE "BW"."T0029"
  ADD CONSTRAINT fk0_T0029 FOREIGN KEY ("T0029_uid")
    REFERENCES "BW"."T001e" ("T001e_uid");

COMMENT ON CONSTRAINT fk0_T0029 ON "BW"."T0029" IS 'planned process -> process';

-- Foreign key definition : T000f -> T000a
ALTER TABLE "BW"."T000f"
  ADD CONSTRAINT fk0_T000f FOREIGN KEY ("T000f_uid")
    REFERENCES "BW"."T000a" ("T000a_uid");

COMMENT ON CONSTRAINT fk0_T000f ON "BW"."T000f" IS 'medical record identifier intersectionOf health care record | is about | patient -> health care record';

-- Foreign key definition : T0012 -> T000c
ALTER TABLE "BW"."T0012"
  ADD CONSTRAINT fk0_T0012 FOREIGN KEY ("T0012_uid")
    REFERENCES "BW"."T000c" ("T000c_uid");

COMMENT ON CONSTRAINT fk0_T0012 ON "BW"."T0012" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism -> data item';

-- Foreign key definition : T001c -> T0021
ALTER TABLE "BW"."T001c"
  ADD CONSTRAINT fk0_T001c FOREIGN KEY ("T001c_uid")
    REFERENCES "BW"."T0021" ("T0021_uid");

COMMENT ON CONSTRAINT fk0_T001c ON "BW"."T001c" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- Foreign key definition : T0006 -> T0021
ALTER TABLE "BW"."T0006"
  ADD CONSTRAINT fk1_T0006 FOREIGN KEY ("T0006_uid")
    REFERENCES "BW"."T0021" ("T0021_uid");

COMMENT ON CONSTRAINT fk1_T0006 ON "BW"."T0006" IS 'disposition -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- Foreign key definition : T0017 -> T0021
ALTER TABLE "BW"."T0017"
  ADD CONSTRAINT fk1_T0017 FOREIGN KEY ("T0017_uid")
    REFERENCES "BW"."T0021" ("T0021_uid");

COMMENT ON CONSTRAINT fk1_T0017 ON "BW"."T0017" IS 'quality -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- Foreign key definition : T002e -> T0001
ALTER TABLE "BW"."T002e"
  ADD CONSTRAINT fk0_T002e FOREIGN KEY ("T0001_uid")
    REFERENCES "BW"."T0001" ("T0001_uid");

COMMENT ON CONSTRAINT fk0_T002e ON "BW"."T002e" IS 'scalar measurement datum has measurement value -> scalar measurement datum';

-- Foreign key definition : T002f -> T0001
ALTER TABLE "BW"."T002f"
  ADD CONSTRAINT fk0_T002f FOREIGN KEY ("T0001_uid")
    REFERENCES "BW"."T0001" ("T0001_uid");

COMMENT ON CONSTRAINT fk0_T002f ON "BW"."T002f" IS 'scalar measurement datum has measurement value -> scalar measurement datum';

-- Foreign key definition : T0030 -> T0011
ALTER TABLE "BW"."T0030"
  ADD CONSTRAINT fk0_T0030 FOREIGN KEY ("T0011_uid")
    REFERENCES "BW"."T0011" ("T0011_uid");

COMMENT ON CONSTRAINT fk0_T0030 ON "BW"."T0030" IS 'measurement unit label has value -> measurement unit label';

-- Foreign key definition : T0031 -> T0025
ALTER TABLE "BW"."T0031"
  ADD CONSTRAINT fk0_T0031 FOREIGN KEY ("T0025_uid")
    REFERENCES "BW"."T0025" ("T0025_uid");

COMMENT ON CONSTRAINT fk0_T0031 ON "BW"."T0031" IS 'centrally registered identifier symbol has value -> centrally registered identifier symbol';

-- Foreign key definition : T0032 -> T0001
ALTER TABLE "BW"."T0032"
  ADD CONSTRAINT fk0_T0032 FOREIGN KEY ("T0001_uid")
    REFERENCES "BW"."T0001" ("T0001_uid");

COMMENT ON CONSTRAINT fk0_T0032 ON "BW"."T0032" IS 'scalar measurement datum has value specification scalar value specification -> scalar measurement datum';

-- Foreign key definition : T0032 -> T0005
ALTER TABLE "BW"."T0032"
  ADD CONSTRAINT fk1_T0032 FOREIGN KEY ("T0005_uid")
    REFERENCES "BW"."T0005" ("T0005_uid");

COMMENT ON CONSTRAINT fk1_T0032 ON "BW"."T0032" IS 'scalar measurement datum has value specification scalar value specification -> scalar value specification';

-- Foreign key definition : T0033 -> T0001
ALTER TABLE "BW"."T0033"
  ADD CONSTRAINT fk0_T0033 FOREIGN KEY ("T0001_uid")
    REFERENCES "BW"."T0001" ("T0001_uid");

COMMENT ON CONSTRAINT fk0_T0033 ON "BW"."T0033" IS 'scalar measurement datum has measurement unit label Thing -> scalar measurement datum';

-- Foreign key definition : T0033 -> T0000
ALTER TABLE "BW"."T0033"
  ADD CONSTRAINT fk1_T0033 FOREIGN KEY ("T0000_uid")
    REFERENCES "BW"."T0000" ("T0000_uid");

COMMENT ON CONSTRAINT fk1_T0033 ON "BW"."T0033" IS 'scalar measurement datum has measurement unit label Thing -> Thing';

-- Foreign key definition : T0034 -> T0003
ALTER TABLE "BW"."T0034"
  ADD CONSTRAINT fk0_T0034 FOREIGN KEY ("T0003_uid")
    REFERENCES "BW"."T0003" ("T0003_uid");

COMMENT ON CONSTRAINT fk0_T0034 ON "BW"."T0034" IS 'sdc concretizes gdc -> sdc';

-- Foreign key definition : T0034 -> T001d
ALTER TABLE "BW"."T0034"
  ADD CONSTRAINT fk1_T0034 FOREIGN KEY ("T001d_uid")
    REFERENCES "BW"."T001d" ("T001d_uid");

COMMENT ON CONSTRAINT fk1_T0034 ON "BW"."T0034" IS 'sdc concretizes gdc -> gdc';

-- Foreign key definition : T0035 -> T0004
ALTER TABLE "BW"."T0035"
  ADD CONSTRAINT fk0_T0035 FOREIGN KEY ("T0004_uid")
    REFERENCES "BW"."T0004" ("T0004_uid");

COMMENT ON CONSTRAINT fk0_T0035 ON "BW"."T0035" IS 'information content entity is about entity -> information content entity';

-- Foreign key definition : T0035 -> T0019
ALTER TABLE "BW"."T0035"
  ADD CONSTRAINT fk1_T0035 FOREIGN KEY ("T0019_uid")
    REFERENCES "BW"."T0019" ("T0019_uid");

COMMENT ON CONSTRAINT fk1_T0035 ON "BW"."T0035" IS 'information content entity is about entity -> entity';

-- Foreign key definition : T0036 -> T0004
ALTER TABLE "BW"."T0036"
  ADD CONSTRAINT fk0_T0036 FOREIGN KEY ("T0004_uid")
    REFERENCES "BW"."T0004" ("T0004_uid");

COMMENT ON CONSTRAINT fk0_T0036 ON "BW"."T0036" IS 'information content entity denotes entity -> information content entity';

-- Foreign key definition : T0036 -> T0019
ALTER TABLE "BW"."T0036"
  ADD CONSTRAINT fk1_T0036 FOREIGN KEY ("T0019_uid")
    REFERENCES "BW"."T0019" ("T0019_uid");

COMMENT ON CONSTRAINT fk1_T0036 ON "BW"."T0036" IS 'information content entity denotes entity -> entity';

-- Foreign key definition : T0037 -> T0007
ALTER TABLE "BW"."T0037"
  ADD CONSTRAINT fk0_T0037 FOREIGN KEY ("T0007_uid")
    REFERENCES "BW"."T0007" ("T0007_uid");

COMMENT ON CONSTRAINT fk0_T0037 ON "BW"."T0037" IS 'ic has role role -> ic';

-- Foreign key definition : T0037 -> T001a
ALTER TABLE "BW"."T0037"
  ADD CONSTRAINT fk1_T0037 FOREIGN KEY ("T001a_uid")
    REFERENCES "BW"."T001a" ("T001a_uid");

COMMENT ON CONSTRAINT fk1_T0037 ON "BW"."T0037" IS 'ic has role role -> role';

-- Foreign key definition : T0038 -> T0007
ALTER TABLE "BW"."T0038"
  ADD CONSTRAINT fk0_T0038 FOREIGN KEY ("T0007_uid_domain")
    REFERENCES "BW"."T0007" ("T0007_uid");

COMMENT ON CONSTRAINT fk0_T0038 ON "BW"."T0038" IS 'ic located in ic -> ic';

-- Foreign key definition : T0038 -> T0007
ALTER TABLE "BW"."T0038"
  ADD CONSTRAINT fk1_T0038 FOREIGN KEY ("T0007_uid_range")
    REFERENCES "BW"."T0007" ("T0007_uid");

COMMENT ON CONSTRAINT fk1_T0038 ON "BW"."T0038" IS 'ic located in ic -> ic';

-- Foreign key definition : T0039 -> T0008
ALTER TABLE "BW"."T0039"
  ADD CONSTRAINT fk0_T0039 FOREIGN KEY ("T0008_uid")
    REFERENCES "BW"."T0008" ("T0008_uid");

COMMENT ON CONSTRAINT fk0_T0039 ON "BW"."T0039" IS 'continuant participates in occurrent -> continuant';

-- Foreign key definition : T0039 -> T001f
ALTER TABLE "BW"."T0039"
  ADD CONSTRAINT fk1_T0039 FOREIGN KEY ("T001f_uid")
    REFERENCES "BW"."T001f" ("T001f_uid");

COMMENT ON CONSTRAINT fk1_T0039 ON "BW"."T0039" IS 'continuant participates in occurrent -> occurrent';

-- Foreign key definition : T003a -> T000a
ALTER TABLE "BW"."T003a"
  ADD CONSTRAINT fk0_T003a FOREIGN KEY ("T000a_uid")
    REFERENCES "BW"."T000a" ("T000a_uid");

COMMENT ON CONSTRAINT fk0_T003a ON "BW"."T003a" IS 'health care record is about organism -> health care record';

-- Foreign key definition : T003a -> T0027
ALTER TABLE "BW"."T003a"
  ADD CONSTRAINT fk1_T003a FOREIGN KEY ("T0027_uid")
    REFERENCES "BW"."T0027" ("T0027_uid");

COMMENT ON CONSTRAINT fk1_T003a ON "BW"."T003a" IS 'health care record is about organism -> organism';

-- Foreign key definition : T003b -> T000b
ALTER TABLE "BW"."T003b"
  ADD CONSTRAINT fk0_T003b FOREIGN KEY ("T000b_uid")
    REFERENCES "BW"."T000b" ("T000b_uid");

COMMENT ON CONSTRAINT fk0_T003b ON "BW"."T003b" IS 'medical record identifier denotes medical record identifier intersectionOf health care record | is about | patient -> medical record identifier';

-- Foreign key definition : T003b -> T000f
ALTER TABLE "BW"."T003b"
  ADD CONSTRAINT fk1_T003b FOREIGN KEY ("T000f_uid")
    REFERENCES "BW"."T000f" ("T000f_uid");

COMMENT ON CONSTRAINT fk1_T003b ON "BW"."T003b" IS 'medical record identifier denotes medical record identifier intersectionOf health care record | is about | patient -> medical record identifier intersectionOf health care record | is about | patient';

-- Foreign key definition : T003c -> T000d
ALTER TABLE "BW"."T003c"
  ADD CONSTRAINT fk0_T003c FOREIGN KEY ("T000d_uid")
    REFERENCES "BW"."T000d" ("T000d_uid");

COMMENT ON CONSTRAINT fk0_T003c ON "BW"."T003c" IS 'health care provider has role health care provider role -> health care provider';

-- Foreign key definition : T003c -> T0013
ALTER TABLE "BW"."T003c"
  ADD CONSTRAINT fk1_T003c FOREIGN KEY ("T0013_uid")
    REFERENCES "BW"."T0013" ("T0013_uid");

COMMENT ON CONSTRAINT fk1_T003c ON "BW"."T003c" IS 'health care provider has role health care provider role -> health care provider role';

-- Foreign key definition : T003d -> T000f
ALTER TABLE "BW"."T003d"
  ADD CONSTRAINT fk0_T003d FOREIGN KEY ("T000f_uid")
    REFERENCES "BW"."T000f" ("T000f_uid");

COMMENT ON CONSTRAINT fk0_T003d ON "BW"."T003d" IS 'medical record identifier intersectionOf health care record | is about | patient is about patient -> medical record identifier intersectionOf health care record | is about | patient';

-- Foreign key definition : T003d -> T0022
ALTER TABLE "BW"."T003d"
  ADD CONSTRAINT fk1_T003d FOREIGN KEY ("T0022_uid")
    REFERENCES "BW"."T0022" ("T0022_uid");

COMMENT ON CONSTRAINT fk1_T003d ON "BW"."T003d" IS 'medical record identifier intersectionOf health care record | is about | patient is about patient -> patient';

-- Foreign key definition : T003e -> T0012
ALTER TABLE "BW"."T003e"
  ADD CONSTRAINT fk0_T003e FOREIGN KEY ("T0012_uid")
    REFERENCES "BW"."T0012" ("T0012_uid");

COMMENT ON CONSTRAINT fk0_T003e ON "BW"."T003e" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism is about physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

-- Foreign key definition : T003e -> T001c
ALTER TABLE "BW"."T003e"
  ADD CONSTRAINT fk1_T003e FOREIGN KEY ("T001c_uid")
    REFERENCES "BW"."T001c" ("T001c_uid");

COMMENT ON CONSTRAINT fk1_T003e ON "BW"."T003e" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism is about physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism';

-- Foreign key definition : T003f -> T0014
ALTER TABLE "BW"."T003f"
  ADD CONSTRAINT fk0_T003f FOREIGN KEY ("T0014_uid")
    REFERENCES "BW"."T0014" ("T0014_uid");

COMMENT ON CONSTRAINT fk0_T003f ON "BW"."T003f" IS 'physiological evaluation has_specified_output physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism -> physiological evaluation';

-- Foreign key definition : T003f -> T0012
ALTER TABLE "BW"."T003f"
  ADD CONSTRAINT fk1_T003f FOREIGN KEY ("T0012_uid")
    REFERENCES "BW"."T0012" ("T0012_uid");

COMMENT ON CONSTRAINT fk1_T003f ON "BW"."T003f" IS 'physiological evaluation has_specified_output physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

-- Foreign key definition : T0040 -> T0014
ALTER TABLE "BW"."T0040"
  ADD CONSTRAINT fk0_T0040 FOREIGN KEY ("T0014_uid")
    REFERENCES "BW"."T0014" ("T0014_uid");

COMMENT ON CONSTRAINT fk0_T0040 ON "BW"."T0040" IS 'physiological evaluation has evaluant Homo sapiens -> physiological evaluation';

-- Foreign key definition : T0040 -> T0026
ALTER TABLE "BW"."T0040"
  ADD CONSTRAINT fk1_T0040 FOREIGN KEY ("T0026_uid")
    REFERENCES "BW"."T0026" ("T0026_uid");

COMMENT ON CONSTRAINT fk1_T0040 ON "BW"."T0040" IS 'physiological evaluation has evaluant Homo sapiens -> Homo sapiens';

-- Foreign key definition : T0041 -> T0018
ALTER TABLE "BW"."T0041"
  ADD CONSTRAINT fk0_T0041 FOREIGN KEY ("T0018_uid")
    REFERENCES "BW"."T0018" ("T0018_uid");

COMMENT ON CONSTRAINT fk0_T0041 ON "BW"."T0041" IS 'realizable realized in process -> realizable';

-- Foreign key definition : T0041 -> T001e
ALTER TABLE "BW"."T0041"
  ADD CONSTRAINT fk1_T0041 FOREIGN KEY ("T001e_uid")
    REFERENCES "BW"."T001e" ("T001e_uid");

COMMENT ON CONSTRAINT fk1_T0041 ON "BW"."T0041" IS 'realizable realized in process -> process';

-- Foreign key definition : T0042 -> T0019
ALTER TABLE "BW"."T0042"
  ADD CONSTRAINT fk0_T0042 FOREIGN KEY ("T0019_uid_domain")
    REFERENCES "BW"."T0019" ("T0019_uid");

COMMENT ON CONSTRAINT fk0_T0042 ON "BW"."T0042" IS 'entity part of entity -> entity';

-- Foreign key definition : T0042 -> T0019
ALTER TABLE "BW"."T0042"
  ADD CONSTRAINT fk1_T0042 FOREIGN KEY ("T0019_uid_range")
    REFERENCES "BW"."T0019" ("T0019_uid");

COMMENT ON CONSTRAINT fk1_T0042 ON "BW"."T0042" IS 'entity part of entity -> entity';

-- Foreign key definition : T0043 -> T001d
ALTER TABLE "BW"."T0043"
  ADD CONSTRAINT fk0_T0043 FOREIGN KEY ("T001d_uid")
    REFERENCES "BW"."T001d" ("T001d_uid");

COMMENT ON CONSTRAINT fk0_T0043 ON "BW"."T0043" IS 'gdc is concretized as sdc -> gdc';

-- Foreign key definition : T0043 -> T0003
ALTER TABLE "BW"."T0043"
  ADD CONSTRAINT fk1_T0043 FOREIGN KEY ("T0003_uid")
    REFERENCES "BW"."T0003" ("T0003_uid");

COMMENT ON CONSTRAINT fk1_T0043 ON "BW"."T0043" IS 'gdc is concretized as sdc -> sdc';

-- Foreign key definition : T0044 -> T001e
ALTER TABLE "BW"."T0044"
  ADD CONSTRAINT fk0_T0044 FOREIGN KEY ("T001e_uid")
    REFERENCES "BW"."T001e" ("T001e_uid");

COMMENT ON CONSTRAINT fk0_T0044 ON "BW"."T0044" IS 'process realizes realizable -> process';

-- Foreign key definition : T0044 -> T0018
ALTER TABLE "BW"."T0044"
  ADD CONSTRAINT fk1_T0044 FOREIGN KEY ("T0018_uid")
    REFERENCES "BW"."T0018" ("T0018_uid");

COMMENT ON CONSTRAINT fk1_T0044 ON "BW"."T0044" IS 'process realizes realizable -> realizable';

-- Foreign key definition : T0045 -> T001f
ALTER TABLE "BW"."T0045"
  ADD CONSTRAINT fk0_T0045 FOREIGN KEY ("T001f_uid")
    REFERENCES "BW"."T001f" ("T001f_uid");

COMMENT ON CONSTRAINT fk0_T0045 ON "BW"."T0045" IS 'occurrent occurs in ic -> occurrent';

-- Foreign key definition : T0045 -> T0007
ALTER TABLE "BW"."T0045"
  ADD CONSTRAINT fk1_T0045 FOREIGN KEY ("T0007_uid")
    REFERENCES "BW"."T0007" ("T0007_uid");

COMMENT ON CONSTRAINT fk1_T0045 ON "BW"."T0045" IS 'occurrent occurs in ic -> ic';

-- Foreign key definition : T0046 -> T001f
ALTER TABLE "BW"."T0046"
  ADD CONSTRAINT fk0_T0046 FOREIGN KEY ("T001f_uid")
    REFERENCES "BW"."T001f" ("T001f_uid");

COMMENT ON CONSTRAINT fk0_T0046 ON "BW"."T0046" IS 'occurrent has participant continuant -> occurrent';

-- Foreign key definition : T0046 -> T0008
ALTER TABLE "BW"."T0046"
  ADD CONSTRAINT fk1_T0046 FOREIGN KEY ("T0008_uid")
    REFERENCES "BW"."T0008" ("T0008_uid");

COMMENT ON CONSTRAINT fk1_T0046 ON "BW"."T0046" IS 'occurrent has participant continuant -> continuant';

-- Foreign key definition : T0047 -> T0020
ALTER TABLE "BW"."T0047"
  ADD CONSTRAINT fk0_T0047 FOREIGN KEY ("T0020_uid")
    REFERENCES "BW"."T0020" ("T0020_uid");

COMMENT ON CONSTRAINT fk0_T0047 ON "BW"."T0047" IS 'physiological evaluation report has part physiological data item -> physiological evaluation report';

-- Foreign key definition : T0047 -> T002a
ALTER TABLE "BW"."T0047"
  ADD CONSTRAINT fk1_T0047 FOREIGN KEY ("T002a_uid")
    REFERENCES "BW"."T002a" ("T002a_uid");

COMMENT ON CONSTRAINT fk1_T0047 ON "BW"."T0047" IS 'physiological evaluation report has part physiological data item -> physiological data item';

-- Foreign key definition : T0048 -> T0020
ALTER TABLE "BW"."T0048"
  ADD CONSTRAINT fk0_T0048 FOREIGN KEY ("T0020_uid")
    REFERENCES "BW"."T0020" ("T0020_uid");

COMMENT ON CONSTRAINT fk0_T0048 ON "BW"."T0048" IS 'physiological evaluation report has part medical record identifier -> physiological evaluation report';

-- Foreign key definition : T0048 -> T000b
ALTER TABLE "BW"."T0048"
  ADD CONSTRAINT fk1_T0048 FOREIGN KEY ("T000b_uid")
    REFERENCES "BW"."T000b" ("T000b_uid");

COMMENT ON CONSTRAINT fk1_T0048 ON "BW"."T0048" IS 'physiological evaluation report has part medical record identifier -> medical record identifier';

-- Foreign key definition : T0049 -> T0021
ALTER TABLE "BW"."T0049"
  ADD CONSTRAINT fk0_T0049 FOREIGN KEY ("T0021_uid")
    REFERENCES "BW"."T0021" ("T0021_uid");

COMMENT ON CONSTRAINT fk0_T0049 ON "BW"."T0049" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality inheres in organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- Foreign key definition : T0049 -> T0027
ALTER TABLE "BW"."T0049"
  ADD CONSTRAINT fk1_T0049 FOREIGN KEY ("T0027_uid")
    REFERENCES "BW"."T0027" ("T0027_uid");

COMMENT ON CONSTRAINT fk1_T0049 ON "BW"."T0049" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality inheres in organism -> organism';

-- Foreign key definition : T004a -> T0022
ALTER TABLE "BW"."T004a"
  ADD CONSTRAINT fk0_T004a FOREIGN KEY ("T0022_uid")
    REFERENCES "BW"."T0022" ("T0022_uid");

COMMENT ON CONSTRAINT fk0_T004a ON "BW"."T004a" IS 'patient has role patient role -> patient';

-- Foreign key definition : T004a -> T0028
ALTER TABLE "BW"."T004a"
  ADD CONSTRAINT fk1_T004a FOREIGN KEY ("T0028_uid")
    REFERENCES "BW"."T0028" ("T0028_uid");

COMMENT ON CONSTRAINT fk1_T004a ON "BW"."T004a" IS 'patient has role patient role -> patient role';

-- Foreign key definition : T004b -> T002a
ALTER TABLE "BW"."T004b"
  ADD CONSTRAINT fk0_T004b FOREIGN KEY ("T002a_uid")
    REFERENCES "BW"."T002a" ("T002a_uid");

COMMENT ON CONSTRAINT fk0_T004b ON "BW"."T004b" IS 'physiological data item is_specified_output_of physiological evaluation -> physiological data item';

-- Foreign key definition : T004b -> T0014
ALTER TABLE "BW"."T004b"
  ADD CONSTRAINT fk1_T004b FOREIGN KEY ("T0014_uid")
    REFERENCES "BW"."T0014" ("T0014_uid");

COMMENT ON CONSTRAINT fk1_T004b ON "BW"."T004b" IS 'physiological data item is_specified_output_of physiological evaluation -> physiological evaluation';

-- Foreign key definition : T004c -> T002b
ALTER TABLE "BW"."T004c"
  ADD CONSTRAINT fk0_T004c FOREIGN KEY ("T002b_uid")
    REFERENCES "BW"."T002b" ("T002b_uid");

COMMENT ON CONSTRAINT fk0_T004c ON "BW"."T004c" IS 'physiological evaluation from health care provider has evaluant health care provider -> physiological evaluation from health care provider';

-- Foreign key definition : T004c -> T000d
ALTER TABLE "BW"."T004c"
  ADD CONSTRAINT fk1_T004c FOREIGN KEY ("T000d_uid")
    REFERENCES "BW"."T000d" ("T000d_uid");

COMMENT ON CONSTRAINT fk1_T004c ON "BW"."T004c" IS 'physiological evaluation from health care provider has evaluant health care provider -> health care provider';

-- Foreign key definition : T004d -> T002c
ALTER TABLE "BW"."T004d"
  ADD CONSTRAINT fk0_T004d FOREIGN KEY ("T002c_uid")
    REFERENCES "BW"."T002c" ("T002c_uid");

COMMENT ON CONSTRAINT fk0_T004d ON "BW"."T004d" IS 'measurement datum has measurement unit label measurement unit label -> measurement datum';

-- Foreign key definition : T004d -> T0011
ALTER TABLE "BW"."T004d"
  ADD CONSTRAINT fk1_T004d FOREIGN KEY ("T0011_uid")
    REFERENCES "BW"."T0011" ("T0011_uid");

COMMENT ON CONSTRAINT fk1_T004d ON "BW"."T004d" IS 'measurement datum has measurement unit label measurement unit label -> measurement unit label';

-- Foreign key definition : T004e -> T002c
ALTER TABLE "BW"."T004e"
  ADD CONSTRAINT fk0_T004e FOREIGN KEY ("T002c_uid")
    REFERENCES "BW"."T002c" ("T002c_uid");

COMMENT ON CONSTRAINT fk0_T004e ON "BW"."T004e" IS 'measurement datum has value specification value specification -> measurement datum';

-- Foreign key definition : T004e -> T0002
ALTER TABLE "BW"."T004e"
  ADD CONSTRAINT fk1_T004e FOREIGN KEY ("T0002_uid")
    REFERENCES "BW"."T0002" ("T0002_uid");

COMMENT ON CONSTRAINT fk1_T004e ON "BW"."T004e" IS 'measurement datum has value specification value specification -> value specification';


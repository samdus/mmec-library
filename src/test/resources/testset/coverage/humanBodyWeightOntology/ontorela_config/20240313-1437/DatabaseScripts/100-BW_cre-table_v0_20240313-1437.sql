/*
-- =========================================================================== A
Schema : BW
Creation Date : 20240313-1437
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

-- table Thing definition
CREATE TABLE "BW"."Thing"
(
  "Thing_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_Thing" PRIMARY KEY ("Thing_uid")
);

COMMENT ON COLUMN "BW"."Thing"."Thing_uid" IS 'uid Thing::Default primary key of Thing';

-- table HBW_0000002 definition
CREATE TABLE "BW"."HBW_0000002"
(
  "HBW_0000002_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000002" PRIMARY KEY ("HBW_0000002_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000002"."HBW_0000002_uid" IS 'uid RAMQ vulnerability code::Default primary key of RAMQ vulnerability code';

-- table VO_0001194 definition
CREATE TABLE "BW"."VO_0001194"
(
  "VO_0001194_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_VO_0001194" PRIMARY KEY ("VO_0001194_uid")
);

COMMENT ON COLUMN "BW"."VO_0001194"."VO_0001194_uid" IS 'uid biological sex datum::Default primary key of biological sex datum';

-- table HBW_0000022 definition
CREATE TABLE "BW"."HBW_0000022"
(
  "HBW_0000022_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000022" PRIMARY KEY ("HBW_0000022_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000022"."HBW_0000022_uid" IS 'uid human name::Default primary key of human name';

-- table HBW_0000010 definition
CREATE TABLE "BW"."HBW_0000010"
(
  "HBW_0000010_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000010" PRIMARY KEY ("HBW_0000010_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000010"."HBW_0000010_uid" IS 'uid health care provider role::Default primary key of health care provider role';

-- table HBW_0000006 definition
CREATE TABLE "BW"."HBW_0000006"
(
  "HBW_0000006_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000006" PRIMARY KEY ("HBW_0000006_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000006"."HBW_0000006_uid" IS 'uid medical record identifier::Default primary key of medical record identifier';

-- table IAO_0000009 definition
CREATE TABLE "BW"."IAO_0000009"
(
  "IAO_0000009_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000009" PRIMARY KEY ("IAO_0000009_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000009"."IAO_0000009_uid" IS 'uid datum label::Default primary key of datum label';

-- table HBW_0000026 definition
CREATE TABLE "BW"."HBW_0000026"
(
  "HBW_0000026_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000026" PRIMARY KEY ("HBW_0000026_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000026"."HBW_0000026_uid" IS 'uid HBW_0000026::Default primary key of HBW_0000026';

-- table HBW_0000014 definition
CREATE TABLE "BW"."HBW_0000014"
(
  "HBW_0000014_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000014" PRIMARY KEY ("HBW_0000014_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000014"."HBW_0000014_uid" IS 'uid obesity::Default primary key of obesity';

-- table BFO_0000020 definition
CREATE TABLE "BW"."BFO_0000020"
(
  "BFO_0000020_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000020" PRIMARY KEY ("BFO_0000020_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000020"."BFO_0000020_uid" IS 'uid specifically dependent continuant::Default primary key of specifically dependent continuant';

-- table ONTORELA_C4d0c3f45 definition
CREATE TABLE "BW"."ONTORELA_C4d0c3f45"
(
  "ONTORELA_C4d0c3f45_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_ONTORELA_C4d0c3f45" PRIMARY KEY ("ONTORELA_C4d0c3f45_uid")
);

COMMENT ON COLUMN "BW"."ONTORELA_C4d0c3f45"."ONTORELA_C4d0c3f45_uid" IS 'uid medical record identifier intersectionOf health care record | is about | patient::Default primary key of medical record identifier intersectionOf health care record | is about | patient';

-- table BFO_0000040 definition
CREATE TABLE "BW"."BFO_0000040"
(
  "BFO_0000040_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000040" PRIMARY KEY ("BFO_0000040_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000040"."BFO_0000040_uid" IS 'uid material::Default primary key of material';

-- table BFO_0000016 definition
CREATE TABLE "BW"."BFO_0000016"
(
  "BFO_0000016_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000016" PRIMARY KEY ("BFO_0000016_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000016"."BFO_0000016_uid" IS 'uid disposition::Default primary key of disposition';

-- table OGMS_0000031 definition
CREATE TABLE "BW"."OGMS_0000031"
(
  "OGMS_0000031_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_OGMS_0000031" PRIMARY KEY ("OGMS_0000031_uid")
);

COMMENT ON COLUMN "BW"."OGMS_0000031"."OGMS_0000031_uid" IS 'uid disease::Default primary key of disease';

-- table BFO_0000004 definition
CREATE TABLE "BW"."BFO_0000004"
(
  "BFO_0000004_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000004" PRIMARY KEY ("BFO_0000004_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000004"."BFO_0000004_uid" IS 'uid independent continuant::Default primary key of independent continuant';

-- table IAO_0020015 definition
CREATE TABLE "BW"."IAO_0020015"
(
  "IAO_0020015_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0020015" PRIMARY KEY ("IAO_0020015_uid")
);

COMMENT ON COLUMN "BW"."IAO_0020015"."IAO_0020015_uid" IS 'uid personal name::Default primary key of personal name';

-- table OMRSE_00000209 definition
CREATE TABLE "BW"."OMRSE_00000209"
(
  "OMRSE_00000209_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_OMRSE_00000209" PRIMARY KEY ("OMRSE_00000209_uid")
);

COMMENT ON COLUMN "BW"."OMRSE_00000209"."OMRSE_00000209_uid" IS 'uid gender identity information content entity::Default primary key of gender identity information content entity';

-- table OBI_0100026 definition
CREATE TABLE "BW"."OBI_0100026"
(
  "OBI_0100026_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_OBI_0100026" PRIMARY KEY ("OBI_0100026_uid")
);

COMMENT ON COLUMN "BW"."OBI_0100026"."OBI_0100026_uid" IS 'uid organism::Default primary key of organism';

-- table NCBITaxon_9606 definition
CREATE TABLE "BW"."NCBITaxon_9606"
(
  "NCBITaxon_9606_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_NCBITaxon_9606" PRIMARY KEY ("NCBITaxon_9606_uid")
);

COMMENT ON COLUMN "BW"."NCBITaxon_9606"."NCBITaxon_9606_uid" IS 'uid Homo sapiens::Default primary key of Homo sapiens';

-- table IAO_0000032 definition
CREATE TABLE "BW"."IAO_0000032"
(
  "IAO_0000032_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000032" PRIMARY KEY ("IAO_0000032_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000032"."IAO_0000032_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

-- table IOIO_0000012 definition
CREATE TABLE "BW"."IOIO_0000012"
(
  "IOIO_0000012_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IOIO_0000012" PRIMARY KEY ("IOIO_0000012_uid")
);

COMMENT ON COLUMN "BW"."IOIO_0000012"."IOIO_0000012_uid" IS 'uid human biological sex or gender identity information content entity::Default primary key of human biological sex or gender identity information content entity';

-- table HBW_0000013 definition
CREATE TABLE "BW"."HBW_0000013"
(
  "HBW_0000013_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000013" PRIMARY KEY ("HBW_0000013_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000013"."HBW_0000013_uid" IS 'uid physiological evaluation from health care provider::Default primary key of physiological evaluation from health care provider';

-- table IAO_0000028 definition
CREATE TABLE "BW"."IAO_0000028"
(
  "IAO_0000028_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000028" PRIMARY KEY ("IAO_0000028_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000028"."IAO_0000028_uid" IS 'uid symbol::Default primary key of symbol';

-- table HBW_0000001 definition
CREATE TABLE "BW"."HBW_0000001"
(
  "HBW_0000001_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000001" PRIMARY KEY ("HBW_0000001_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000001"."HBW_0000001_uid" IS 'uid physiological data item::Default primary key of physiological data item';

-- table OMRSE_00000210 definition
CREATE TABLE "BW"."OMRSE_00000210"
(
  "OMRSE_00000210_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_OMRSE_00000210" PRIMARY KEY ("OMRSE_00000210_uid")
);

COMMENT ON COLUMN "BW"."OMRSE_00000210"."OMRSE_00000210_uid" IS 'uid female gender identity information content entity::Default primary key of female gender identity information content entity';

-- table IAO_0000109 definition
CREATE TABLE "BW"."IAO_0000109"
(
  "IAO_0000109_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000109" PRIMARY KEY ("IAO_0000109_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000109"."IAO_0000109_uid" IS 'uid measurement datum::Default primary key of measurement datum';

-- table HBW_0000005 definition
CREATE TABLE "BW"."HBW_0000005"
(
  "HBW_0000005_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000005" PRIMARY KEY ("HBW_0000005_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000005"."HBW_0000005_uid" IS 'uid physiological evaluation report::Default primary key of physiological evaluation report';

-- table HBW_0000025 definition
CREATE TABLE "BW"."HBW_0000025"
(
  "HBW_0000025_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000025" PRIMARY KEY ("HBW_0000025_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000025"."HBW_0000025_uid" IS 'uid female biological sex or gender identity information content entity::Default primary key of female biological sex or gender identity information content entity';

-- table HBW_0000009 definition
CREATE TABLE "BW"."HBW_0000009"
(
  "HBW_0000009_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000009" PRIMARY KEY ("HBW_0000009_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000009"."HBW_0000009_uid" IS 'uid body weight::Default primary key of body weight';

-- table NOYO_0000012 definition
CREATE TABLE "BW"."NOYO_0000012"
(
  "NOYO_0000012_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_NOYO_0000012" PRIMARY KEY ("NOYO_0000012_uid")
);

COMMENT ON COLUMN "BW"."NOYO_0000012"."NOYO_0000012_uid" IS 'uid informational entity::Default primary key of informational entity';

-- table VO_0004895 definition
CREATE TABLE "BW"."VO_0004895"
(
  "VO_0004895_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_VO_0004895" PRIMARY KEY ("VO_0004895_uid")
);

COMMENT ON COLUMN "BW"."VO_0004895"."VO_0004895_uid" IS 'uid female biological sex datum::Default primary key of female biological sex datum';

-- table BFO_0000017 definition
CREATE TABLE "BW"."BFO_0000017"
(
  "BFO_0000017_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000017" PRIMARY KEY ("BFO_0000017_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000017"."BFO_0000017_uid" IS 'uid realizable entity::Default primary key of realizable entity';

-- table BFO_0000001 definition
CREATE TABLE "BW"."BFO_0000001"
(
  "BFO_0000001_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000001" PRIMARY KEY ("BFO_0000001_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000001"."BFO_0000001_uid" IS 'uid entity::Default primary key of entity';

-- table IAO_0000310 definition
CREATE TABLE "BW"."IAO_0000310"
(
  "IAO_0000310_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000310" PRIMARY KEY ("IAO_0000310_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000310"."IAO_0000310_uid" IS 'uid document::Default primary key of document';

-- table IAO_0000003 definition
CREATE TABLE "BW"."IAO_0000003"
(
  "IAO_0000003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000003" PRIMARY KEY ("IAO_0000003_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000003"."IAO_0000003_uid" IS 'uid measurement unit label::Default primary key of measurement unit label';

-- table HBW_0000024 definition
CREATE TABLE "BW"."HBW_0000024"
(
  "HBW_0000024_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000024" PRIMARY KEY ("HBW_0000024_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000024"."HBW_0000024_uid" IS 'uid intersex biological sex or non-binary gender identity information content entity::Default primary key of intersex biological sex or non-binary gender identity information content entity';

-- table OMRSE_00000211 definition
CREATE TABLE "BW"."OMRSE_00000211"
(
  "OMRSE_00000211_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_OMRSE_00000211" PRIMARY KEY ("OMRSE_00000211_uid")
);

COMMENT ON COLUMN "BW"."OMRSE_00000211"."OMRSE_00000211_uid" IS 'uid male gender identity information content entity::Default primary key of male gender identity information content entity';

-- table HBW_0000012 definition
CREATE TABLE "BW"."HBW_0000012"
(
  "HBW_0000012_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000012" PRIMARY KEY ("HBW_0000012_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000012"."HBW_0000012_uid" IS 'uid physiological evaluation::Default primary key of physiological evaluation';

-- table IAO_0000027 definition
CREATE TABLE "BW"."IAO_0000027"
(
  "IAO_0000027_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000027" PRIMARY KEY ("IAO_0000027_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000027"."IAO_0000027_uid" IS 'uid data item::Default primary key of data item';

-- table VO_0000613 definition
CREATE TABLE "BW"."VO_0000613"
(
  "VO_0000613_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_VO_0000613" PRIMARY KEY ("VO_0000613_uid")
);

COMMENT ON COLUMN "BW"."VO_0000613"."VO_0000613_uid" IS 'uid male biological sex datum::Default primary key of male biological sex datum';

-- table IAO_0020000 definition
CREATE TABLE "BW"."IAO_0020000"
(
  "IAO_0020000_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0020000" PRIMARY KEY ("IAO_0020000_uid")
);

COMMENT ON COLUMN "BW"."IAO_0020000"."IAO_0020000_uid" IS 'uid identifier::Default primary key of identifier';

-- table HBW_0000004 definition
CREATE TABLE "BW"."HBW_0000004"
(
  "HBW_0000004_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000004" PRIMARY KEY ("HBW_0000004_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000004"."HBW_0000004_uid" IS 'uid health care record::Default primary key of health care record';

-- table HBW_0000008 definition
CREATE TABLE "BW"."HBW_0000008"
(
  "HBW_0000008_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000008" PRIMARY KEY ("HBW_0000008_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000008"."HBW_0000008_uid" IS 'uid health care provider::Default primary key of health care provider';

-- table NOYO_0000013 definition
CREATE TABLE "BW"."NOYO_0000013"
(
  "NOYO_0000013_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_NOYO_0000013" PRIMARY KEY ("NOYO_0000013_uid")
);

COMMENT ON COLUMN "BW"."NOYO_0000013"."NOYO_0000013_uid" IS 'uid statement::Default primary key of statement';

-- table OBI_0000011 definition
CREATE TABLE "BW"."OBI_0000011"
(
  "OBI_0000011_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_OBI_0000011" PRIMARY KEY ("OBI_0000011_uid")
);

COMMENT ON COLUMN "BW"."OBI_0000011"."OBI_0000011_uid" IS 'uid planned process::Default primary key of planned process';

-- table VO_0004896 definition
CREATE TABLE "BW"."VO_0004896"
(
  "VO_0004896_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_VO_0004896" PRIMARY KEY ("VO_0004896_uid")
);

COMMENT ON COLUMN "BW"."VO_0004896"."VO_0004896_uid" IS 'uid intersex biological sex datum::Default primary key of intersex biological sex datum';

-- table BFO_0000002 definition
CREATE TABLE "BW"."BFO_0000002"
(
  "BFO_0000002_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000002" PRIMARY KEY ("BFO_0000002_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000002"."BFO_0000002_uid" IS 'uid continuant::Default primary key of continuant';

-- table IAO_0020017 definition
CREATE TABLE "BW"."IAO_0020017"
(
  "IAO_0020017_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0020017" PRIMARY KEY ("IAO_0020017_uid")
);

COMMENT ON COLUMN "BW"."IAO_0020017"."IAO_0020017_uid" IS 'uid family name::Default primary key of family name';

-- table IAO_0000030 definition
CREATE TABLE "BW"."IAO_0000030"
(
  "IAO_0000030_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000030" PRIMARY KEY ("IAO_0000030_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000030"."IAO_0000030_uid" IS 'uid information content entity::Default primary key of information content entity';

-- table ONTORELA_C2986e108 definition
CREATE TABLE "BW"."ONTORELA_C2986e108"
(
  "ONTORELA_C2986e108_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_ONTORELA_C2986e108" PRIMARY KEY ("ONTORELA_C2986e108_uid")
);

COMMENT ON COLUMN "BW"."ONTORELA_C2986e108"."ONTORELA_C2986e108_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism';

-- table IAO_0000577 definition
CREATE TABLE "BW"."IAO_0000577"
(
  "IAO_0000577_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000577" PRIMARY KEY ("IAO_0000577_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000577"."IAO_0000577_uid" IS 'uid centrally registered identifier symbol::Default primary key of centrally registered identifier symbol';

-- table NOYO_0000050 definition
CREATE TABLE "BW"."NOYO_0000050"
(
  "NOYO_0000050_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_NOYO_0000050" PRIMARY KEY ("NOYO_0000050_uid")
);

COMMENT ON COLUMN "BW"."NOYO_0000050"."NOYO_0000050_uid" IS 'uid birth statement::Default primary key of birth statement';

-- table OMRSE_00000212 definition
CREATE TABLE "BW"."OMRSE_00000212"
(
  "OMRSE_00000212_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_OMRSE_00000212" PRIMARY KEY ("OMRSE_00000212_uid")
);

COMMENT ON COLUMN "BW"."OMRSE_00000212"."OMRSE_00000212_uid" IS 'uid non-binary identity information content entity::Default primary key of non-binary identity information content entity';

-- table HBW_0000023 definition
CREATE TABLE "BW"."HBW_0000023"
(
  "HBW_0000023_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000023" PRIMARY KEY ("HBW_0000023_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000023"."HBW_0000023_uid" IS 'uid male biological sex or gender identity information content entity::Default primary key of male biological sex or gender identity information content entity';

-- table HBW_0000011 definition
CREATE TABLE "BW"."HBW_0000011"
(
  "HBW_0000011_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000011" PRIMARY KEY ("HBW_0000011_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000011"."HBW_0000011_uid" IS 'uid patient role::Default primary key of patient role';

-- table ONTORELA_C61c354fb definition
CREATE TABLE "BW"."ONTORELA_C61c354fb"
(
  "ONTORELA_C61c354fb_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_ONTORELA_C61c354fb" PRIMARY KEY ("ONTORELA_C61c354fb_uid")
);

COMMENT ON COLUMN "BW"."ONTORELA_C61c354fb"."ONTORELA_C61c354fb_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

-- table HBW_0000003 definition
CREATE TABLE "BW"."HBW_0000003"
(
  "HBW_0000003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000003" PRIMARY KEY ("HBW_0000003_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000003"."HBW_0000003_uid" IS 'uid weight unit::Default primary key of weight unit';

-- table BFO_0000031 definition
CREATE TABLE "BW"."BFO_0000031"
(
  "BFO_0000031_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000031" PRIMARY KEY ("BFO_0000031_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000031"."BFO_0000031_uid" IS 'uid generically dependent continuant::Default primary key of generically dependent continuant';

-- table ONTORELA_C2986e108-el0 definition
CREATE TABLE "BW"."ONTORELA_C2986e108-el0"
(
  "ONTORELA_C2986e108-el0_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_ONTORELA_C2986e108-el0" PRIMARY KEY ("ONTORELA_C2986e108-el0_uid")
);

COMMENT ON COLUMN "BW"."ONTORELA_C2986e108-el0"."ONTORELA_C2986e108-el0_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- table HBW_0000007 definition
CREATE TABLE "BW"."HBW_0000007"
(
  "HBW_0000007_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000007" PRIMARY KEY ("HBW_0000007_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000007"."HBW_0000007_uid" IS 'uid patient::Default primary key of patient';

-- table BFO_0000019 definition
CREATE TABLE "BW"."BFO_0000019"
(
  "BFO_0000019_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000019" PRIMARY KEY ("BFO_0000019_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000019"."BFO_0000019_uid" IS 'uid quality::Default primary key of quality';

-- table BFO_0000023 definition
CREATE TABLE "BW"."BFO_0000023"
(
  "BFO_0000023_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000023" PRIMARY KEY ("BFO_0000023_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000023"."BFO_0000023_uid" IS 'uid role::Default primary key of role';

-- table BFO_0000015 definition
CREATE TABLE "BW"."BFO_0000015"
(
  "BFO_0000015_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000015" PRIMARY KEY ("BFO_0000015_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000015"."BFO_0000015_uid" IS 'uid process::Default primary key of process';

-- table BFO_0000003 definition
CREATE TABLE "BW"."BFO_0000003"
(
  "BFO_0000003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000003" PRIMARY KEY ("BFO_0000003_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000003"."BFO_0000003_uid" IS 'uid occurrent::Default primary key of occurrent';

-- table OMRSE_00000204 definition
CREATE TABLE "BW"."OMRSE_00000204"
(
  "OMRSE_00000204_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_OMRSE_00000204" PRIMARY KEY ("OMRSE_00000204_uid")
);

COMMENT ON COLUMN "BW"."OMRSE_00000204"."OMRSE_00000204_uid" IS 'uid social identity information content entity::Default primary key of social identity information content entity';

-- table IAO_0000032_IAO_0000004_double definition
CREATE TABLE "BW"."IAO_0000032_IAO_0000004_double"
(
  "IAO_0000032_IAO_0000004_double_IAO_0000004" "BW"."double"  NOT NULL, 
  "IAO_0000032_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000032_IAO_0000004_double" PRIMARY KEY ("IAO_0000032_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000032_IAO_0000004_double"."IAO_0000032_IAO_0000004_double_IAO_0000004" IS 'has measurement value::null';

COMMENT ON COLUMN "BW"."IAO_0000032_IAO_0000004_double"."IAO_0000032_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

-- table HBW_0000002_PHYSIO_0000100_string definition
CREATE TABLE "BW"."HBW_0000002_PHYSIO_0000100_string"
(
  "HBW_0000002_PHYSIO_0000100_string_PHYSIO_0000100" "BW"."string"  NOT NULL, 
  "HBW_0000002_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000002_PHYSIO_0000100_string" PRIMARY KEY ("HBW_0000002_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000002_PHYSIO_0000100_string"."HBW_0000002_PHYSIO_0000100_string_PHYSIO_0000100" IS 'has value::null';

COMMENT ON COLUMN "BW"."HBW_0000002_PHYSIO_0000100_string"."HBW_0000002_uid" IS 'uid RAMQ vulnerability code::Default primary key of RAMQ vulnerability code';

-- table IAO_0020015_PHYSIO_0000100_string definition
CREATE TABLE "BW"."IAO_0020015_PHYSIO_0000100_string"
(
  "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100" "BW"."string"  NOT NULL, 
  "IAO_0020015_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0020015_PHYSIO_0000100_string" PRIMARY KEY ("IAO_0020015_uid")
);

COMMENT ON COLUMN "BW"."IAO_0020015_PHYSIO_0000100_string"."IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100" IS 'has value::null';

COMMENT ON COLUMN "BW"."IAO_0020015_PHYSIO_0000100_string"."IAO_0020015_uid" IS 'uid personal name::Default primary key of personal name';

-- table IAO_0000032_IAO_0000004_Literal definition
CREATE TABLE "BW"."IAO_0000032_IAO_0000004_Literal"
(
  "IAO_0000032_uid" "BW"."uid_domain"  NOT NULL, 
  "IAO_0000032_IAO_0000004_Literal_IAO_0000004" "BW"."Literal"  NOT NULL,
  CONSTRAINT "key_IAO_0000032_IAO_0000004_Literal" PRIMARY KEY ("IAO_0000032_uid", "IAO_0000032_IAO_0000004_Literal_IAO_0000004")
);

COMMENT ON COLUMN "BW"."IAO_0000032_IAO_0000004_Literal"."IAO_0000032_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

COMMENT ON COLUMN "BW"."IAO_0000032_IAO_0000004_Literal"."IAO_0000032_IAO_0000004_Literal_IAO_0000004" IS 'has measurement value::null';

-- table IAO_0000003_PHYSIO_0000100_string definition
CREATE TABLE "BW"."IAO_0000003_PHYSIO_0000100_string"
(
  "IAO_0000003_PHYSIO_0000100_string_PHYSIO_0000100" "BW"."string"  NOT NULL, 
  "IAO_0000003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000003_PHYSIO_0000100_string" PRIMARY KEY ("IAO_0000003_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000003_PHYSIO_0000100_string"."IAO_0000003_PHYSIO_0000100_string_PHYSIO_0000100" IS 'has value::null';

COMMENT ON COLUMN "BW"."IAO_0000003_PHYSIO_0000100_string"."IAO_0000003_uid" IS 'uid measurement unit label::Default primary key of measurement unit label';

-- table IAO_0000577_PHYSIO_0000100_string definition
CREATE TABLE "BW"."IAO_0000577_PHYSIO_0000100_string"
(
  "IAO_0000577_PHYSIO_0000100_string_PHYSIO_0000100" "BW"."string"  NOT NULL, 
  "IAO_0000577_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000577_PHYSIO_0000100_string" PRIMARY KEY ("IAO_0000577_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000577_PHYSIO_0000100_string"."IAO_0000577_PHYSIO_0000100_string_PHYSIO_0000100" IS 'has value::null';

COMMENT ON COLUMN "BW"."IAO_0000577_PHYSIO_0000100_string"."IAO_0000577_uid" IS 'uid centrally registered identifier symbol::Default primary key of centrally registered identifier symbol';

-- table HBW_0000026_IAO_0000004_decimal definition
CREATE TABLE "BW"."HBW_0000026_IAO_0000004_decimal"
(
  "HBW_0000026_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000026_IAO_0000004_decimal_IAO_0000004" "BW"."decimal"  NOT NULL,
  CONSTRAINT "key_HBW_0000026_IAO_0000004_decimal" PRIMARY KEY ("HBW_0000026_uid", "HBW_0000026_IAO_0000004_decimal_IAO_0000004")
);

COMMENT ON COLUMN "BW"."HBW_0000026_IAO_0000004_decimal"."HBW_0000026_uid" IS 'uid HBW_0000026::Default primary key of HBW_0000026';

COMMENT ON COLUMN "BW"."HBW_0000026_IAO_0000004_decimal"."HBW_0000026_IAO_0000004_decimal_IAO_0000004" IS 'has measurement value::null';

-- table IAO_0020017_PHYSIO_0000100_string definition
CREATE TABLE "BW"."IAO_0020017_PHYSIO_0000100_string"
(
  "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100" "BW"."string"  NOT NULL, 
  "IAO_0020017_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0020017_PHYSIO_0000100_string" PRIMARY KEY ("IAO_0020017_uid")
);

COMMENT ON COLUMN "BW"."IAO_0020017_PHYSIO_0000100_string"."IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100" IS 'has value::null';

COMMENT ON COLUMN "BW"."IAO_0020017_PHYSIO_0000100_string"."IAO_0020017_uid" IS 'uid family name::Default primary key of family name';

-- table HBW_0000022_BFO_0000051_IAO_0020015 definition
CREATE TABLE "BW"."HBW_0000022_BFO_0000051_IAO_0020015"
(
  "HBW_0000022_uid" "BW"."uid_domain"  NOT NULL, 
  "IAO_0020015_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000022_BFO_0000051_IAO_0020015" PRIMARY KEY ("HBW_0000022_uid", "IAO_0020015_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000022_BFO_0000051_IAO_0020015"."HBW_0000022_uid" IS 'uid human name::Default primary key of human name';

COMMENT ON COLUMN "BW"."HBW_0000022_BFO_0000051_IAO_0020015"."IAO_0020015_uid" IS 'uid personal name::Default primary key of personal name';

-- table HBW_0000022_BFO_0000051_IAO_0020017 definition
CREATE TABLE "BW"."HBW_0000022_BFO_0000051_IAO_0020017"
(
  "HBW_0000022_uid" "BW"."uid_domain"  NOT NULL, 
  "IAO_0020017_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000022_BFO_0000051_IAO_0020017" PRIMARY KEY ("HBW_0000022_uid", "IAO_0020017_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000022_BFO_0000051_IAO_0020017"."HBW_0000022_uid" IS 'uid human name::Default primary key of human name';

COMMENT ON COLUMN "BW"."HBW_0000022_BFO_0000051_IAO_0020017"."IAO_0020017_uid" IS 'uid family name::Default primary key of family name';

-- table HBW_0000022_IAO_0000219_NCBITaxon_9606 definition
CREATE TABLE "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606"
(
  "HBW_0000022_uid" "BW"."uid_domain"  NOT NULL, 
  "NCBITaxon_9606_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000022_IAO_0000219_NCBITaxon_9606" PRIMARY KEY ("HBW_0000022_uid", "NCBITaxon_9606_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606"."HBW_0000022_uid" IS 'uid human name::Default primary key of human name';

COMMENT ON COLUMN "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606"."NCBITaxon_9606_uid" IS 'uid Homo sapiens::Default primary key of Homo sapiens';

-- table HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45 definition
CREATE TABLE "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"
(
  "HBW_0000006_uid" "BW"."uid_domain"  NOT NULL, 
  "ONTORELA_C4d0c3f45_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" PRIMARY KEY ("HBW_0000006_uid", "ONTORELA_C4d0c3f45_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"."HBW_0000006_uid" IS 'uid medical record identifier::Default primary key of medical record identifier';

COMMENT ON COLUMN "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"."ONTORELA_C4d0c3f45_uid" IS 'uid medical record identifier intersectionOf health care record | is about | patient::Default primary key of medical record identifier intersectionOf health care record | is about | patient';

-- table HBW_0000026_IAO_0000039_HBW_0000003 definition
CREATE TABLE "BW"."HBW_0000026_IAO_0000039_HBW_0000003"
(
  "HBW_0000026_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000026_IAO_0000039_HBW_0000003" PRIMARY KEY ("HBW_0000026_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000026_IAO_0000039_HBW_0000003"."HBW_0000026_uid" IS 'uid HBW_0000026::Default primary key of HBW_0000026';

COMMENT ON COLUMN "BW"."HBW_0000026_IAO_0000039_HBW_0000003"."HBW_0000003_uid" IS 'uid weight unit::Default primary key of weight unit';

-- table BFO_0000020_RO_0000059_BFO_0000031 definition
CREATE TABLE "BW"."BFO_0000020_RO_0000059_BFO_0000031"
(
  "BFO_0000020_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000031_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000020_RO_0000059_BFO_0000031" PRIMARY KEY ("BFO_0000020_uid", "BFO_0000031_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000020_RO_0000059_BFO_0000031"."BFO_0000020_uid" IS 'uid specifically dependent continuant::Default primary key of specifically dependent continuant';

COMMENT ON COLUMN "BW"."BFO_0000020_RO_0000059_BFO_0000031"."BFO_0000031_uid" IS 'uid generically dependent continuant::Default primary key of generically dependent continuant';

-- table ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007 definition
CREATE TABLE "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007"
(
  "ONTORELA_C4d0c3f45_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000007_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" PRIMARY KEY ("ONTORELA_C4d0c3f45_uid", "HBW_0000007_uid")
);

COMMENT ON COLUMN "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007"."ONTORELA_C4d0c3f45_uid" IS 'uid medical record identifier intersectionOf health care record | is about | patient::Default primary key of medical record identifier intersectionOf health care record | is about | patient';

COMMENT ON COLUMN "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007"."HBW_0000007_uid" IS 'uid patient::Default primary key of patient';

-- table BFO_0000004_RO_0000087_BFO_0000023 definition
CREATE TABLE "BW"."BFO_0000004_RO_0000087_BFO_0000023"
(
  "BFO_0000004_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000023_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000004_RO_0000087_BFO_0000023" PRIMARY KEY ("BFO_0000004_uid", "BFO_0000023_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000004_RO_0000087_BFO_0000023"."BFO_0000004_uid" IS 'uid independent continuant::Default primary key of independent continuant';

COMMENT ON COLUMN "BW"."BFO_0000004_RO_0000087_BFO_0000023"."BFO_0000023_uid" IS 'uid role::Default primary key of role';

-- table BFO_0000004_RO_0001025_BFO_0000004 definition
CREATE TABLE "BW"."BFO_0000004_RO_0001025_BFO_0000004"
(
  "BFO_0000004_uid_domain" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000004_uid_range" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000004_RO_0001025_BFO_0000004" PRIMARY KEY ("BFO_0000004_uid_domain", "BFO_0000004_uid_range")
);

COMMENT ON COLUMN "BW"."BFO_0000004_RO_0001025_BFO_0000004"."BFO_0000004_uid_domain" IS 'uid independent continuant_domain::Default primary key of independent continuant';

COMMENT ON COLUMN "BW"."BFO_0000004_RO_0001025_BFO_0000004"."BFO_0000004_uid_range" IS 'uid independent continuant_range::Default primary key of independent continuant';

-- table IAO_0000032_IAO_0000039_IAO_0000003 definition
CREATE TABLE "BW"."IAO_0000032_IAO_0000039_IAO_0000003"
(
  "IAO_0000032_uid" "BW"."uid_domain"  NOT NULL, 
  "IAO_0000003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000032_IAO_0000039_IAO_0000003" PRIMARY KEY ("IAO_0000032_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000032_IAO_0000039_IAO_0000003"."IAO_0000032_uid" IS 'uid scalar measurement datum::Default primary key of scalar measurement datum';

COMMENT ON COLUMN "BW"."IAO_0000032_IAO_0000039_IAO_0000003"."IAO_0000003_uid" IS 'uid measurement unit label::Default primary key of measurement unit label';

-- table HBW_0000013_PHYSIO_0000089_HBW_0000008 definition
CREATE TABLE "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008"
(
  "HBW_0000013_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000008_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000013_PHYSIO_0000089_HBW_0000008" PRIMARY KEY ("HBW_0000013_uid", "HBW_0000008_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008"."HBW_0000013_uid" IS 'uid physiological evaluation from health care provider::Default primary key of physiological evaluation from health care provider';

COMMENT ON COLUMN "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008"."HBW_0000008_uid" IS 'uid health care provider::Default primary key of health care provider';

-- table HBW_0000001_OBI_0000312_HBW_0000012 definition
CREATE TABLE "BW"."HBW_0000001_OBI_0000312_HBW_0000012"
(
  "HBW_0000001_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000012_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000001_OBI_0000312_HBW_0000012" PRIMARY KEY ("HBW_0000001_uid", "HBW_0000012_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000001_OBI_0000312_HBW_0000012"."HBW_0000001_uid" IS 'uid physiological data item::Default primary key of physiological data item';

COMMENT ON COLUMN "BW"."HBW_0000001_OBI_0000312_HBW_0000012"."HBW_0000012_uid" IS 'uid physiological evaluation::Default primary key of physiological evaluation';

-- table IAO_0000109_IAO_0000039_IAO_0000003 definition
CREATE TABLE "BW"."IAO_0000109_IAO_0000039_IAO_0000003"
(
  "IAO_0000109_uid" "BW"."uid_domain"  NOT NULL, 
  "IAO_0000003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000109_IAO_0000039_IAO_0000003" PRIMARY KEY ("IAO_0000109_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000109_IAO_0000039_IAO_0000003"."IAO_0000109_uid" IS 'uid measurement datum::Default primary key of measurement datum';

COMMENT ON COLUMN "BW"."IAO_0000109_IAO_0000039_IAO_0000003"."IAO_0000003_uid" IS 'uid measurement unit label::Default primary key of measurement unit label';

-- table HBW_0000005_BFO_0000051_HBW_0000006 definition
CREATE TABLE "BW"."HBW_0000005_BFO_0000051_HBW_0000006"
(
  "HBW_0000005_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000006_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000005_BFO_0000051_HBW_0000006" PRIMARY KEY ("HBW_0000005_uid", "HBW_0000006_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000005_BFO_0000051_HBW_0000006"."HBW_0000005_uid" IS 'uid physiological evaluation report::Default primary key of physiological evaluation report';

COMMENT ON COLUMN "BW"."HBW_0000005_BFO_0000051_HBW_0000006"."HBW_0000006_uid" IS 'uid medical record identifier::Default primary key of medical record identifier';

-- table HBW_0000005_BFO_0000051_HBW_0000001 definition
CREATE TABLE "BW"."HBW_0000005_BFO_0000051_HBW_0000001"
(
  "HBW_0000005_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000001_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000005_BFO_0000051_HBW_0000001" PRIMARY KEY ("HBW_0000005_uid", "HBW_0000001_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000005_BFO_0000051_HBW_0000001"."HBW_0000005_uid" IS 'uid physiological evaluation report::Default primary key of physiological evaluation report';

COMMENT ON COLUMN "BW"."HBW_0000005_BFO_0000051_HBW_0000001"."HBW_0000001_uid" IS 'uid physiological data item::Default primary key of physiological data item';

-- table BFO_0000017_BFO_0000054_BFO_0000015 definition
CREATE TABLE "BW"."BFO_0000017_BFO_0000054_BFO_0000015"
(
  "BFO_0000017_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000015_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000017_BFO_0000054_BFO_0000015" PRIMARY KEY ("BFO_0000017_uid", "BFO_0000015_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000017_BFO_0000054_BFO_0000015"."BFO_0000017_uid" IS 'uid realizable entity::Default primary key of realizable entity';

COMMENT ON COLUMN "BW"."BFO_0000017_BFO_0000054_BFO_0000015"."BFO_0000015_uid" IS 'uid process::Default primary key of process';

-- table BFO_0000001_BFO_0000050_BFO_0000001 definition
CREATE TABLE "BW"."BFO_0000001_BFO_0000050_BFO_0000001"
(
  "BFO_0000001_uid_domain" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000001_uid_range" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000001_BFO_0000050_BFO_0000001" PRIMARY KEY ("BFO_0000001_uid_domain", "BFO_0000001_uid_range")
);

COMMENT ON COLUMN "BW"."BFO_0000001_BFO_0000050_BFO_0000001"."BFO_0000001_uid_domain" IS 'uid entity_domain::Default primary key of entity';

COMMENT ON COLUMN "BW"."BFO_0000001_BFO_0000050_BFO_0000001"."BFO_0000001_uid_range" IS 'uid entity_range::Default primary key of entity';

-- table HBW_0000012_PHYSIO_0000089_NCBITaxon_9606 definition
CREATE TABLE "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"
(
  "HBW_0000012_uid" "BW"."uid_domain"  NOT NULL, 
  "NCBITaxon_9606_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" PRIMARY KEY ("HBW_0000012_uid", "NCBITaxon_9606_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"."HBW_0000012_uid" IS 'uid physiological evaluation::Default primary key of physiological evaluation';

COMMENT ON COLUMN "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"."NCBITaxon_9606_uid" IS 'uid Homo sapiens::Default primary key of Homo sapiens';

-- table HBW_0000012_OBI_0000299_ONTORELA_C61c354fb definition
CREATE TABLE "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb"
(
  "HBW_0000012_uid" "BW"."uid_domain"  NOT NULL, 
  "ONTORELA_C61c354fb_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" PRIMARY KEY ("HBW_0000012_uid", "ONTORELA_C61c354fb_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb"."HBW_0000012_uid" IS 'uid physiological evaluation::Default primary key of physiological evaluation';

COMMENT ON COLUMN "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb"."ONTORELA_C61c354fb_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

-- table IAO_0020000_IAO_0000219_BFO_0000001 definition
CREATE TABLE "BW"."IAO_0020000_IAO_0000219_BFO_0000001"
(
  "IAO_0020000_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000001_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0020000_IAO_0000219_BFO_0000001" PRIMARY KEY ("IAO_0020000_uid", "BFO_0000001_uid")
);

COMMENT ON COLUMN "BW"."IAO_0020000_IAO_0000219_BFO_0000001"."IAO_0020000_uid" IS 'uid identifier::Default primary key of identifier';

COMMENT ON COLUMN "BW"."IAO_0020000_IAO_0000219_BFO_0000001"."BFO_0000001_uid" IS 'uid entity::Default primary key of entity';

-- table HBW_0000004_IAO_0000136_OBI_0100026 definition
CREATE TABLE "BW"."HBW_0000004_IAO_0000136_OBI_0100026"
(
  "HBW_0000004_uid" "BW"."uid_domain"  NOT NULL, 
  "OBI_0100026_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000004_IAO_0000136_OBI_0100026" PRIMARY KEY ("HBW_0000004_uid", "OBI_0100026_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000004_IAO_0000136_OBI_0100026"."HBW_0000004_uid" IS 'uid health care record::Default primary key of health care record';

COMMENT ON COLUMN "BW"."HBW_0000004_IAO_0000136_OBI_0100026"."OBI_0100026_uid" IS 'uid organism::Default primary key of organism';

-- table HBW_0000008_RO_0000087_HBW_0000010 definition
CREATE TABLE "BW"."HBW_0000008_RO_0000087_HBW_0000010"
(
  "HBW_0000008_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000010_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000008_RO_0000087_HBW_0000010" PRIMARY KEY ("HBW_0000008_uid", "HBW_0000010_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000008_RO_0000087_HBW_0000010"."HBW_0000008_uid" IS 'uid health care provider::Default primary key of health care provider';

COMMENT ON COLUMN "BW"."HBW_0000008_RO_0000087_HBW_0000010"."HBW_0000010_uid" IS 'uid health care provider role::Default primary key of health care provider role';

-- table BFO_0000002_RO_0000056_BFO_0000003 definition
CREATE TABLE "BW"."BFO_0000002_RO_0000056_BFO_0000003"
(
  "BFO_0000002_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000003_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000002_RO_0000056_BFO_0000003" PRIMARY KEY ("BFO_0000002_uid", "BFO_0000003_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000002_RO_0000056_BFO_0000003"."BFO_0000002_uid" IS 'uid continuant::Default primary key of continuant';

COMMENT ON COLUMN "BW"."BFO_0000002_RO_0000056_BFO_0000003"."BFO_0000003_uid" IS 'uid occurrent::Default primary key of occurrent';

-- table IAO_0000030_IAO_0000136_BFO_0000001 definition
CREATE TABLE "BW"."IAO_0000030_IAO_0000136_BFO_0000001"
(
  "IAO_0000030_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000001_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000030_IAO_0000136_BFO_0000001" PRIMARY KEY ("IAO_0000030_uid", "BFO_0000001_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000030_IAO_0000136_BFO_0000001"."IAO_0000030_uid" IS 'uid information content entity::Default primary key of information content entity';

COMMENT ON COLUMN "BW"."IAO_0000030_IAO_0000136_BFO_0000001"."BFO_0000001_uid" IS 'uid entity::Default primary key of entity';

-- table IAO_0000030_IAO_0000219_BFO_0000001 definition
CREATE TABLE "BW"."IAO_0000030_IAO_0000219_BFO_0000001"
(
  "IAO_0000030_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000001_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_IAO_0000030_IAO_0000219_BFO_0000001" PRIMARY KEY ("IAO_0000030_uid", "BFO_0000001_uid")
);

COMMENT ON COLUMN "BW"."IAO_0000030_IAO_0000219_BFO_0000001"."IAO_0000030_uid" IS 'uid information content entity::Default primary key of information content entity';

COMMENT ON COLUMN "BW"."IAO_0000030_IAO_0000219_BFO_0000001"."BFO_0000001_uid" IS 'uid entity::Default primary key of entity';

-- table NOYO_0000050_IAO_0000136_NCBITaxon_9606 definition
CREATE TABLE "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606"
(
  "NOYO_0000050_uid" "BW"."uid_domain"  NOT NULL, 
  "NCBITaxon_9606_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_NOYO_0000050_IAO_0000136_NCBITaxon_9606" PRIMARY KEY ("NOYO_0000050_uid", "NCBITaxon_9606_uid")
);

COMMENT ON COLUMN "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606"."NOYO_0000050_uid" IS 'uid birth statement::Default primary key of birth statement';

COMMENT ON COLUMN "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606"."NCBITaxon_9606_uid" IS 'uid Homo sapiens::Default primary key of Homo sapiens';

-- table ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108 definition
CREATE TABLE "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108"
(
  "ONTORELA_C61c354fb_uid" "BW"."uid_domain"  NOT NULL, 
  "ONTORELA_C2986e108_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" PRIMARY KEY ("ONTORELA_C61c354fb_uid", "ONTORELA_C2986e108_uid")
);

COMMENT ON COLUMN "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108"."ONTORELA_C61c354fb_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

COMMENT ON COLUMN "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108"."ONTORELA_C2986e108_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism';

-- table BFO_0000031_RO_0000058_BFO_0000020 definition
CREATE TABLE "BW"."BFO_0000031_RO_0000058_BFO_0000020"
(
  "BFO_0000031_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000020_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000031_RO_0000058_BFO_0000020" PRIMARY KEY ("BFO_0000031_uid", "BFO_0000020_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000031_RO_0000058_BFO_0000020"."BFO_0000031_uid" IS 'uid generically dependent continuant::Default primary key of generically dependent continuant';

COMMENT ON COLUMN "BW"."BFO_0000031_RO_0000058_BFO_0000020"."BFO_0000020_uid" IS 'uid specifically dependent continuant::Default primary key of specifically dependent continuant';

-- table ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026 definition
CREATE TABLE "BW"."ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026"
(
  "ONTORELA_C2986e108-el0_uid" "BW"."uid_domain"  NOT NULL, 
  "OBI_0100026_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026" PRIMARY KEY ("ONTORELA_C2986e108-el0_uid", "OBI_0100026_uid")
);

COMMENT ON COLUMN "BW"."ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026"."ONTORELA_C2986e108-el0_uid" IS 'uid physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality::Default primary key of physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

COMMENT ON COLUMN "BW"."ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026"."OBI_0100026_uid" IS 'uid organism::Default primary key of organism';

-- table HBW_0000007_RO_0000087_HBW_0000011 definition
CREATE TABLE "BW"."HBW_0000007_RO_0000087_HBW_0000011"
(
  "HBW_0000007_uid" "BW"."uid_domain"  NOT NULL, 
  "HBW_0000011_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_HBW_0000007_RO_0000087_HBW_0000011" PRIMARY KEY ("HBW_0000007_uid", "HBW_0000011_uid")
);

COMMENT ON COLUMN "BW"."HBW_0000007_RO_0000087_HBW_0000011"."HBW_0000007_uid" IS 'uid patient::Default primary key of patient';

COMMENT ON COLUMN "BW"."HBW_0000007_RO_0000087_HBW_0000011"."HBW_0000011_uid" IS 'uid patient role::Default primary key of patient role';

-- table BFO_0000015_BFO_0000055_BFO_0000017 definition
CREATE TABLE "BW"."BFO_0000015_BFO_0000055_BFO_0000017"
(
  "BFO_0000015_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000017_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000015_BFO_0000055_BFO_0000017" PRIMARY KEY ("BFO_0000015_uid", "BFO_0000017_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000015_BFO_0000055_BFO_0000017"."BFO_0000015_uid" IS 'uid process::Default primary key of process';

COMMENT ON COLUMN "BW"."BFO_0000015_BFO_0000055_BFO_0000017"."BFO_0000017_uid" IS 'uid realizable entity::Default primary key of realizable entity';

-- table BFO_0000003_BFO_0000066_BFO_0000004 definition
CREATE TABLE "BW"."BFO_0000003_BFO_0000066_BFO_0000004"
(
  "BFO_0000003_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000004_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000003_BFO_0000066_BFO_0000004" PRIMARY KEY ("BFO_0000003_uid", "BFO_0000004_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000003_BFO_0000066_BFO_0000004"."BFO_0000003_uid" IS 'uid occurrent::Default primary key of occurrent';

COMMENT ON COLUMN "BW"."BFO_0000003_BFO_0000066_BFO_0000004"."BFO_0000004_uid" IS 'uid independent continuant::Default primary key of independent continuant';

-- table BFO_0000003_RO_0000057_BFO_0000002 definition
CREATE TABLE "BW"."BFO_0000003_RO_0000057_BFO_0000002"
(
  "BFO_0000003_uid" "BW"."uid_domain"  NOT NULL, 
  "BFO_0000002_uid" "BW"."uid_domain"  NOT NULL,
  CONSTRAINT "key_BFO_0000003_RO_0000057_BFO_0000002" PRIMARY KEY ("BFO_0000003_uid", "BFO_0000002_uid")
);

COMMENT ON COLUMN "BW"."BFO_0000003_RO_0000057_BFO_0000002"."BFO_0000003_uid" IS 'uid occurrent::Default primary key of occurrent';

COMMENT ON COLUMN "BW"."BFO_0000003_RO_0000057_BFO_0000002"."BFO_0000002_uid" IS 'uid continuant::Default primary key of continuant';

-- Foreign key definition : ONTORELA_C2986e108-el0 -> Thing
ALTER TABLE "BW"."ONTORELA_C2986e108-el0"
  ADD CONSTRAINT "fk0_ONTORELA_C2986e108-el0" FOREIGN KEY ("ONTORELA_C2986e108-el0_uid")
    REFERENCES "BW"."Thing" ("Thing_uid");

COMMENT ON CONSTRAINT "fk0_ONTORELA_C2986e108-el0" ON "BW"."ONTORELA_C2986e108-el0" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality -> Thing';

-- Foreign key definition : BFO_0000016 -> BFO_0000017
ALTER TABLE "BW"."BFO_0000016"
  ADD CONSTRAINT "fk0_BFO_0000016" FOREIGN KEY ("BFO_0000016_uid")
    REFERENCES "BW"."BFO_0000017" ("BFO_0000017_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000016" ON "BW"."BFO_0000016" IS 'disposition -> realizable entity';

-- Foreign key definition : HBW_0000002 -> IAO_0000027
ALTER TABLE "BW"."HBW_0000002"
  ADD CONSTRAINT "fk0_HBW_0000002" FOREIGN KEY ("HBW_0000002_uid")
    REFERENCES "BW"."IAO_0000027" ("IAO_0000027_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000002" ON "BW"."HBW_0000002" IS 'RAMQ vulnerability code -> data item';

-- Foreign key definition : IAO_0000109 -> IAO_0000027
ALTER TABLE "BW"."IAO_0000109"
  ADD CONSTRAINT "fk0_IAO_0000109" FOREIGN KEY ("IAO_0000109_uid")
    REFERENCES "BW"."IAO_0000027" ("IAO_0000027_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000109" ON "BW"."IAO_0000109" IS 'measurement datum -> data item';

-- Foreign key definition : OGMS_0000031 -> BFO_0000016
ALTER TABLE "BW"."OGMS_0000031"
  ADD CONSTRAINT "fk0_OGMS_0000031" FOREIGN KEY ("OGMS_0000031_uid")
    REFERENCES "BW"."BFO_0000016" ("BFO_0000016_uid");

COMMENT ON CONSTRAINT "fk0_OGMS_0000031" ON "BW"."OGMS_0000031" IS 'disease -> disposition';

-- Foreign key definition : HBW_0000004 -> IAO_0000310
ALTER TABLE "BW"."HBW_0000004"
  ADD CONSTRAINT "fk0_HBW_0000004" FOREIGN KEY ("HBW_0000004_uid")
    REFERENCES "BW"."IAO_0000310" ("IAO_0000310_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000004" ON "BW"."HBW_0000004" IS 'health care record -> document';

-- Foreign key definition : NCBITaxon_9606 -> OBI_0100026
ALTER TABLE "BW"."NCBITaxon_9606"
  ADD CONSTRAINT "fk0_NCBITaxon_9606" FOREIGN KEY ("NCBITaxon_9606_uid")
    REFERENCES "BW"."OBI_0100026" ("OBI_0100026_uid");

COMMENT ON CONSTRAINT "fk0_NCBITaxon_9606" ON "BW"."NCBITaxon_9606" IS 'Homo sapiens -> organism';

-- Foreign key definition : VO_0001194 -> IAO_0000109
ALTER TABLE "BW"."VO_0001194"
  ADD CONSTRAINT "fk0_VO_0001194" FOREIGN KEY ("VO_0001194_uid")
    REFERENCES "BW"."IAO_0000109" ("IAO_0000109_uid");

COMMENT ON CONSTRAINT "fk0_VO_0001194" ON "BW"."VO_0001194" IS 'biological sex datum -> measurement datum';

-- Foreign key definition : HBW_0000024 -> IOIO_0000012
ALTER TABLE "BW"."HBW_0000024"
  ADD CONSTRAINT "fk0_HBW_0000024" FOREIGN KEY ("HBW_0000024_uid")
    REFERENCES "BW"."IOIO_0000012" ("IOIO_0000012_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000024" ON "BW"."HBW_0000024" IS 'intersex biological sex or non-binary gender identity information content entity -> human biological sex or gender identity information content entity';

-- Foreign key definition : HBW_0000023 -> IOIO_0000012
ALTER TABLE "BW"."HBW_0000023"
  ADD CONSTRAINT "fk0_HBW_0000023" FOREIGN KEY ("HBW_0000023_uid")
    REFERENCES "BW"."IOIO_0000012" ("IOIO_0000012_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000023" ON "BW"."HBW_0000023" IS 'male biological sex or gender identity information content entity -> human biological sex or gender identity information content entity';

-- Foreign key definition : BFO_0000003 -> BFO_0000001
ALTER TABLE "BW"."BFO_0000003"
  ADD CONSTRAINT "fk0_BFO_0000003" FOREIGN KEY ("BFO_0000003_uid")
    REFERENCES "BW"."BFO_0000001" ("BFO_0000001_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000003" ON "BW"."BFO_0000003" IS 'occurrent -> entity';

-- Foreign key definition : BFO_0000001 -> Thing
ALTER TABLE "BW"."BFO_0000001"
  ADD CONSTRAINT "fk0_BFO_0000001" FOREIGN KEY ("BFO_0000001_uid")
    REFERENCES "BW"."Thing" ("Thing_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000001" ON "BW"."BFO_0000001" IS 'entity -> Thing';

-- Foreign key definition : NOYO_0000012 -> BFO_0000031
ALTER TABLE "BW"."NOYO_0000012"
  ADD CONSTRAINT "fk0_NOYO_0000012" FOREIGN KEY ("NOYO_0000012_uid")
    REFERENCES "BW"."BFO_0000031" ("BFO_0000031_uid");

COMMENT ON CONSTRAINT "fk0_NOYO_0000012" ON "BW"."NOYO_0000012" IS 'informational entity -> generically dependent continuant';

-- Foreign key definition : NOYO_0000050 -> NOYO_0000013
ALTER TABLE "BW"."NOYO_0000050"
  ADD CONSTRAINT "fk0_NOYO_0000050" FOREIGN KEY ("NOYO_0000050_uid")
    REFERENCES "BW"."NOYO_0000013" ("NOYO_0000013_uid");

COMMENT ON CONSTRAINT "fk0_NOYO_0000050" ON "BW"."NOYO_0000050" IS 'birth statement -> statement';

-- Foreign key definition : IAO_0020000 -> IAO_0000030
ALTER TABLE "BW"."IAO_0020000"
  ADD CONSTRAINT "fk0_IAO_0020000" FOREIGN KEY ("IAO_0020000_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0020000" ON "BW"."IAO_0020000" IS 'identifier -> information content entity';

-- Foreign key definition : IAO_0020017 -> IAO_0020000
ALTER TABLE "BW"."IAO_0020017"
  ADD CONSTRAINT "fk0_IAO_0020017" FOREIGN KEY ("IAO_0020017_uid")
    REFERENCES "BW"."IAO_0020000" ("IAO_0020000_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0020017" ON "BW"."IAO_0020017" IS 'family name -> identifier';

-- Foreign key definition : IAO_0020015 -> IAO_0020000
ALTER TABLE "BW"."IAO_0020015"
  ADD CONSTRAINT "fk0_IAO_0020015" FOREIGN KEY ("IAO_0020015_uid")
    REFERENCES "BW"."IAO_0020000" ("IAO_0020000_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0020015" ON "BW"."IAO_0020015" IS 'personal name -> identifier';

-- Foreign key definition : OMRSE_00000209 -> OMRSE_00000204
ALTER TABLE "BW"."OMRSE_00000209"
  ADD CONSTRAINT "fk0_OMRSE_00000209" FOREIGN KEY ("OMRSE_00000209_uid")
    REFERENCES "BW"."OMRSE_00000204" ("OMRSE_00000204_uid");

COMMENT ON CONSTRAINT "fk0_OMRSE_00000209" ON "BW"."OMRSE_00000209" IS 'gender identity information content entity -> social identity information content entity';

-- Foreign key definition : IAO_0000577 -> IAO_0000028
ALTER TABLE "BW"."IAO_0000577"
  ADD CONSTRAINT "fk0_IAO_0000577" FOREIGN KEY ("IAO_0000577_uid")
    REFERENCES "BW"."IAO_0000028" ("IAO_0000028_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000577" ON "BW"."IAO_0000577" IS 'centrally registered identifier symbol -> symbol';

-- Foreign key definition : BFO_0000023 -> BFO_0000017
ALTER TABLE "BW"."BFO_0000023"
  ADD CONSTRAINT "fk0_BFO_0000023" FOREIGN KEY ("BFO_0000023_uid")
    REFERENCES "BW"."BFO_0000017" ("BFO_0000017_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000023" ON "BW"."BFO_0000023" IS 'role -> realizable entity';

-- Foreign key definition : BFO_0000004 -> BFO_0000002
ALTER TABLE "BW"."BFO_0000004"
  ADD CONSTRAINT "fk0_BFO_0000004" FOREIGN KEY ("BFO_0000004_uid")
    REFERENCES "BW"."BFO_0000002" ("BFO_0000002_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000004" ON "BW"."BFO_0000004" IS 'independent continuant -> continuant';

-- Foreign key definition : VO_0004895 -> VO_0001194
ALTER TABLE "BW"."VO_0004895"
  ADD CONSTRAINT "fk0_VO_0004895" FOREIGN KEY ("VO_0004895_uid")
    REFERENCES "BW"."VO_0001194" ("VO_0001194_uid");

COMMENT ON CONSTRAINT "fk0_VO_0004895" ON "BW"."VO_0004895" IS 'female biological sex datum -> biological sex datum';

-- Foreign key definition : BFO_0000015 -> BFO_0000003
ALTER TABLE "BW"."BFO_0000015"
  ADD CONSTRAINT "fk0_BFO_0000015" FOREIGN KEY ("BFO_0000015_uid")
    REFERENCES "BW"."BFO_0000003" ("BFO_0000003_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000015" ON "BW"."BFO_0000015" IS 'process -> occurrent';

-- Foreign key definition : BFO_0000017 -> BFO_0000020
ALTER TABLE "BW"."BFO_0000017"
  ADD CONSTRAINT "fk0_BFO_0000017" FOREIGN KEY ("BFO_0000017_uid")
    REFERENCES "BW"."BFO_0000020" ("BFO_0000020_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000017" ON "BW"."BFO_0000017" IS 'realizable entity -> specifically dependent continuant';

-- Foreign key definition : OMRSE_00000211 -> OMRSE_00000209
ALTER TABLE "BW"."OMRSE_00000211"
  ADD CONSTRAINT "fk0_OMRSE_00000211" FOREIGN KEY ("OMRSE_00000211_uid")
    REFERENCES "BW"."OMRSE_00000209" ("OMRSE_00000209_uid");

COMMENT ON CONSTRAINT "fk0_OMRSE_00000211" ON "BW"."OMRSE_00000211" IS 'male gender identity information content entity -> gender identity information content entity';

-- Foreign key definition : BFO_0000031 -> BFO_0000002
ALTER TABLE "BW"."BFO_0000031"
  ADD CONSTRAINT "fk0_BFO_0000031" FOREIGN KEY ("BFO_0000031_uid")
    REFERENCES "BW"."BFO_0000002" ("BFO_0000002_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000031" ON "BW"."BFO_0000031" IS 'generically dependent continuant -> continuant';

-- Foreign key definition : HBW_0000012 -> OBI_0000011
ALTER TABLE "BW"."HBW_0000012"
  ADD CONSTRAINT "fk0_HBW_0000012" FOREIGN KEY ("HBW_0000012_uid")
    REFERENCES "BW"."OBI_0000011" ("OBI_0000011_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000012" ON "BW"."HBW_0000012" IS 'physiological evaluation -> planned process';

-- Foreign key definition : IAO_0000009 -> IAO_0000030
ALTER TABLE "BW"."IAO_0000009"
  ADD CONSTRAINT "fk0_IAO_0000009" FOREIGN KEY ("IAO_0000009_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000009" ON "BW"."IAO_0000009" IS 'datum label -> information content entity';

-- Foreign key definition : IAO_0000032 -> IAO_0000109
ALTER TABLE "BW"."IAO_0000032"
  ADD CONSTRAINT "fk0_IAO_0000032" FOREIGN KEY ("IAO_0000032_uid")
    REFERENCES "BW"."IAO_0000109" ("IAO_0000109_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000032" ON "BW"."IAO_0000032" IS 'scalar measurement datum -> measurement datum';

-- Foreign key definition : HBW_0000014 -> OGMS_0000031
ALTER TABLE "BW"."HBW_0000014"
  ADD CONSTRAINT "fk0_HBW_0000014" FOREIGN KEY ("HBW_0000014_uid")
    REFERENCES "BW"."OGMS_0000031" ("OGMS_0000031_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000014" ON "BW"."HBW_0000014" IS 'obesity -> disease';

-- Foreign key definition : OMRSE_00000204 -> IAO_0000030
ALTER TABLE "BW"."OMRSE_00000204"
  ADD CONSTRAINT "fk0_OMRSE_00000204" FOREIGN KEY ("OMRSE_00000204_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_OMRSE_00000204" ON "BW"."OMRSE_00000204" IS 'social identity information content entity -> information content entity';

-- Foreign key definition : HBW_0000006 -> IAO_0000577
ALTER TABLE "BW"."HBW_0000006"
  ADD CONSTRAINT "fk0_HBW_0000006" FOREIGN KEY ("HBW_0000006_uid")
    REFERENCES "BW"."IAO_0000577" ("IAO_0000577_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000006" ON "BW"."HBW_0000006" IS 'medical record identifier -> centrally registered identifier symbol';

-- Foreign key definition : HBW_0000011 -> BFO_0000023
ALTER TABLE "BW"."HBW_0000011"
  ADD CONSTRAINT "fk0_HBW_0000011" FOREIGN KEY ("HBW_0000011_uid")
    REFERENCES "BW"."BFO_0000023" ("BFO_0000023_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000011" ON "BW"."HBW_0000011" IS 'patient role -> role';

-- Foreign key definition : HBW_0000003 -> IAO_0000003
ALTER TABLE "BW"."HBW_0000003"
  ADD CONSTRAINT "fk0_HBW_0000003" FOREIGN KEY ("HBW_0000003_uid")
    REFERENCES "BW"."IAO_0000003" ("IAO_0000003_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000003" ON "BW"."HBW_0000003" IS 'weight unit -> measurement unit label';

-- Foreign key definition : HBW_0000022 -> IAO_0020000
ALTER TABLE "BW"."HBW_0000022"
  ADD CONSTRAINT "fk0_HBW_0000022" FOREIGN KEY ("HBW_0000022_uid")
    REFERENCES "BW"."IAO_0020000" ("IAO_0020000_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000022" ON "BW"."HBW_0000022" IS 'human name -> identifier';

-- Foreign key definition : IAO_0000030 -> BFO_0000031
ALTER TABLE "BW"."IAO_0000030"
  ADD CONSTRAINT "fk0_IAO_0000030" FOREIGN KEY ("IAO_0000030_uid")
    REFERENCES "BW"."BFO_0000031" ("BFO_0000031_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000030" ON "BW"."IAO_0000030" IS 'information content entity -> generically dependent continuant';

-- Foreign key definition : BFO_0000040 -> BFO_0000004
ALTER TABLE "BW"."BFO_0000040"
  ADD CONSTRAINT "fk0_BFO_0000040" FOREIGN KEY ("BFO_0000040_uid")
    REFERENCES "BW"."BFO_0000004" ("BFO_0000004_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000040" ON "BW"."BFO_0000040" IS 'material -> independent continuant';

-- Foreign key definition : BFO_0000002 -> BFO_0000001
ALTER TABLE "BW"."BFO_0000002"
  ADD CONSTRAINT "fk0_BFO_0000002" FOREIGN KEY ("BFO_0000002_uid")
    REFERENCES "BW"."BFO_0000001" ("BFO_0000001_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000002" ON "BW"."BFO_0000002" IS 'continuant -> entity';

-- Foreign key definition : BFO_0000019 -> BFO_0000020
ALTER TABLE "BW"."BFO_0000019"
  ADD CONSTRAINT "fk0_BFO_0000019" FOREIGN KEY ("BFO_0000019_uid")
    REFERENCES "BW"."BFO_0000020" ("BFO_0000020_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000019" ON "BW"."BFO_0000019" IS 'quality -> specifically dependent continuant';

-- Foreign key definition : HBW_0000005 -> IAO_0000310
ALTER TABLE "BW"."HBW_0000005"
  ADD CONSTRAINT "fk0_HBW_0000005" FOREIGN KEY ("HBW_0000005_uid")
    REFERENCES "BW"."IAO_0000310" ("IAO_0000310_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000005" ON "BW"."HBW_0000005" IS 'physiological evaluation report -> document';

-- Foreign key definition : OMRSE_00000210 -> OMRSE_00000209
ALTER TABLE "BW"."OMRSE_00000210"
  ADD CONSTRAINT "fk0_OMRSE_00000210" FOREIGN KEY ("OMRSE_00000210_uid")
    REFERENCES "BW"."OMRSE_00000209" ("OMRSE_00000209_uid");

COMMENT ON CONSTRAINT "fk0_OMRSE_00000210" ON "BW"."OMRSE_00000210" IS 'female gender identity information content entity -> gender identity information content entity';

-- Foreign key definition : HBW_0000013 -> HBW_0000012
ALTER TABLE "BW"."HBW_0000013"
  ADD CONSTRAINT "fk0_HBW_0000013" FOREIGN KEY ("HBW_0000013_uid")
    REFERENCES "BW"."HBW_0000012" ("HBW_0000012_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000013" ON "BW"."HBW_0000013" IS 'physiological evaluation from health care provider -> physiological evaluation';

-- Foreign key definition : HBW_0000001 -> IAO_0000027
ALTER TABLE "BW"."HBW_0000001"
  ADD CONSTRAINT "fk0_HBW_0000001" FOREIGN KEY ("HBW_0000001_uid")
    REFERENCES "BW"."IAO_0000027" ("IAO_0000027_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000001" ON "BW"."HBW_0000001" IS 'physiological data item -> data item';

-- Foreign key definition : NOYO_0000050 -> IAO_0000030
ALTER TABLE "BW"."NOYO_0000050"
  ADD CONSTRAINT "fk1_NOYO_0000050" FOREIGN KEY ("NOYO_0000050_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk1_NOYO_0000050" ON "BW"."NOYO_0000050" IS 'birth statement -> information content entity';

-- Foreign key definition : VO_0004896 -> VO_0001194
ALTER TABLE "BW"."VO_0004896"
  ADD CONSTRAINT "fk0_VO_0004896" FOREIGN KEY ("VO_0004896_uid")
    REFERENCES "BW"."VO_0001194" ("VO_0001194_uid");

COMMENT ON CONSTRAINT "fk0_VO_0004896" ON "BW"."VO_0004896" IS 'intersex biological sex datum -> biological sex datum';

-- Foreign key definition : BFO_0000020 -> BFO_0000002
ALTER TABLE "BW"."BFO_0000020"
  ADD CONSTRAINT "fk0_BFO_0000020" FOREIGN KEY ("BFO_0000020_uid")
    REFERENCES "BW"."BFO_0000002" ("BFO_0000002_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000020" ON "BW"."BFO_0000020" IS 'specifically dependent continuant -> continuant';

-- Foreign key definition : HBW_0000009 -> BFO_0000019
ALTER TABLE "BW"."HBW_0000009"
  ADD CONSTRAINT "fk0_HBW_0000009" FOREIGN KEY ("HBW_0000009_uid")
    REFERENCES "BW"."BFO_0000019" ("BFO_0000019_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000009" ON "BW"."HBW_0000009" IS 'body weight -> quality';

-- Foreign key definition : OBI_0100026 -> BFO_0000040
ALTER TABLE "BW"."OBI_0100026"
  ADD CONSTRAINT "fk0_OBI_0100026" FOREIGN KEY ("OBI_0100026_uid")
    REFERENCES "BW"."BFO_0000040" ("BFO_0000040_uid");

COMMENT ON CONSTRAINT "fk0_OBI_0100026" ON "BW"."OBI_0100026" IS 'organism -> material';

-- Foreign key definition : HBW_0000026 -> IAO_0000032
ALTER TABLE "BW"."HBW_0000026"
  ADD CONSTRAINT "fk0_HBW_0000026" FOREIGN KEY ("HBW_0000026_uid")
    REFERENCES "BW"."IAO_0000032" ("IAO_0000032_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000026" ON "BW"."HBW_0000026" IS 'HBW_0000026 -> scalar measurement datum';

-- Foreign key definition : IOIO_0000012 -> IAO_0000030
ALTER TABLE "BW"."IOIO_0000012"
  ADD CONSTRAINT "fk0_IOIO_0000012" FOREIGN KEY ("IOIO_0000012_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_IOIO_0000012" ON "BW"."IOIO_0000012" IS 'human biological sex or gender identity information content entity -> information content entity';

-- Foreign key definition : HBW_0000025 -> IOIO_0000012
ALTER TABLE "BW"."HBW_0000025"
  ADD CONSTRAINT "fk0_HBW_0000025" FOREIGN KEY ("HBW_0000025_uid")
    REFERENCES "BW"."IOIO_0000012" ("IOIO_0000012_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000025" ON "BW"."HBW_0000025" IS 'female biological sex or gender identity information content entity -> human biological sex or gender identity information content entity';

-- Foreign key definition : IAO_0000027 -> IAO_0000030
ALTER TABLE "BW"."IAO_0000027"
  ADD CONSTRAINT "fk0_IAO_0000027" FOREIGN KEY ("IAO_0000027_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000027" ON "BW"."IAO_0000027" IS 'data item -> information content entity';

-- Foreign key definition : OMRSE_00000212 -> OMRSE_00000209
ALTER TABLE "BW"."OMRSE_00000212"
  ADD CONSTRAINT "fk0_OMRSE_00000212" FOREIGN KEY ("OMRSE_00000212_uid")
    REFERENCES "BW"."OMRSE_00000209" ("OMRSE_00000209_uid");

COMMENT ON CONSTRAINT "fk0_OMRSE_00000212" ON "BW"."OMRSE_00000212" IS 'non-binary identity information content entity -> gender identity information content entity';

-- Foreign key definition : NOYO_0000013 -> NOYO_0000012
ALTER TABLE "BW"."NOYO_0000013"
  ADD CONSTRAINT "fk0_NOYO_0000013" FOREIGN KEY ("NOYO_0000013_uid")
    REFERENCES "BW"."NOYO_0000012" ("NOYO_0000012_uid");

COMMENT ON CONSTRAINT "fk0_NOYO_0000013" ON "BW"."NOYO_0000013" IS 'statement -> informational entity';

-- Foreign key definition : VO_0000613 -> VO_0001194
ALTER TABLE "BW"."VO_0000613"
  ADD CONSTRAINT "fk0_VO_0000613" FOREIGN KEY ("VO_0000613_uid")
    REFERENCES "BW"."VO_0001194" ("VO_0001194_uid");

COMMENT ON CONSTRAINT "fk0_VO_0000613" ON "BW"."VO_0000613" IS 'male biological sex datum -> biological sex datum';

-- Foreign key definition : IAO_0000310 -> IAO_0000030
ALTER TABLE "BW"."IAO_0000310"
  ADD CONSTRAINT "fk0_IAO_0000310" FOREIGN KEY ("IAO_0000310_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000310" ON "BW"."IAO_0000310" IS 'document -> information content entity';

-- Foreign key definition : IAO_0000028 -> IAO_0000030
ALTER TABLE "BW"."IAO_0000028"
  ADD CONSTRAINT "fk0_IAO_0000028" FOREIGN KEY ("IAO_0000028_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000028" ON "BW"."IAO_0000028" IS 'symbol -> information content entity';

-- Foreign key definition : IAO_0000003 -> IAO_0000009
ALTER TABLE "BW"."IAO_0000003"
  ADD CONSTRAINT "fk0_IAO_0000003" FOREIGN KEY ("IAO_0000003_uid")
    REFERENCES "BW"."IAO_0000009" ("IAO_0000009_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000003" ON "BW"."IAO_0000003" IS 'measurement unit label -> datum label';

-- Foreign key definition : OBI_0000011 -> BFO_0000015
ALTER TABLE "BW"."OBI_0000011"
  ADD CONSTRAINT "fk0_OBI_0000011" FOREIGN KEY ("OBI_0000011_uid")
    REFERENCES "BW"."BFO_0000015" ("BFO_0000015_uid");

COMMENT ON CONSTRAINT "fk0_OBI_0000011" ON "BW"."OBI_0000011" IS 'planned process -> process';

-- Foreign key definition : HBW_0000010 -> BFO_0000023
ALTER TABLE "BW"."HBW_0000010"
  ADD CONSTRAINT "fk0_HBW_0000010" FOREIGN KEY ("HBW_0000010_uid")
    REFERENCES "BW"."BFO_0000023" ("BFO_0000023_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000010" ON "BW"."HBW_0000010" IS 'health care provider role -> role';

-- Foreign key definition : ONTORELA_C4d0c3f45 -> HBW_0000004
ALTER TABLE "BW"."ONTORELA_C4d0c3f45"
  ADD CONSTRAINT "fk0_ONTORELA_C4d0c3f45" FOREIGN KEY ("ONTORELA_C4d0c3f45_uid")
    REFERENCES "BW"."HBW_0000004" ("HBW_0000004_uid");

COMMENT ON CONSTRAINT "fk0_ONTORELA_C4d0c3f45" ON "BW"."ONTORELA_C4d0c3f45" IS 'medical record identifier intersectionOf health care record | is about | patient -> health care record';

-- Foreign key definition : ONTORELA_C61c354fb -> IAO_0000027
ALTER TABLE "BW"."ONTORELA_C61c354fb"
  ADD CONSTRAINT "fk0_ONTORELA_C61c354fb" FOREIGN KEY ("ONTORELA_C61c354fb_uid")
    REFERENCES "BW"."IAO_0000027" ("IAO_0000027_uid");

COMMENT ON CONSTRAINT "fk0_ONTORELA_C61c354fb" ON "BW"."ONTORELA_C61c354fb" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism -> data item';

-- Foreign key definition : ONTORELA_C2986e108 -> ONTORELA_C2986e108-el0
ALTER TABLE "BW"."ONTORELA_C2986e108"
  ADD CONSTRAINT "fk0_ONTORELA_C2986e108" FOREIGN KEY ("ONTORELA_C2986e108_uid")
    REFERENCES "BW"."ONTORELA_C2986e108-el0" ("ONTORELA_C2986e108-el0_uid");

COMMENT ON CONSTRAINT "fk0_ONTORELA_C2986e108" ON "BW"."ONTORELA_C2986e108" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- Foreign key definition : BFO_0000016 -> ONTORELA_C2986e108-el0
ALTER TABLE "BW"."BFO_0000016"
  ADD CONSTRAINT "fk1_BFO_0000016" FOREIGN KEY ("BFO_0000016_uid")
    REFERENCES "BW"."ONTORELA_C2986e108-el0" ("ONTORELA_C2986e108-el0_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000016" ON "BW"."BFO_0000016" IS 'disposition -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- Foreign key definition : BFO_0000019 -> ONTORELA_C2986e108-el0
ALTER TABLE "BW"."BFO_0000019"
  ADD CONSTRAINT "fk1_BFO_0000019" FOREIGN KEY ("BFO_0000019_uid")
    REFERENCES "BW"."ONTORELA_C2986e108-el0" ("ONTORELA_C2986e108-el0_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000019" ON "BW"."BFO_0000019" IS 'quality -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- Foreign key definition : OMRSE_00000209 -> IOIO_0000012
ALTER TABLE "BW"."OMRSE_00000209"
  ADD CONSTRAINT "fk1_OMRSE_00000209" FOREIGN KEY ("OMRSE_00000209_uid")
    REFERENCES "BW"."IOIO_0000012" ("IOIO_0000012_uid");

COMMENT ON CONSTRAINT "fk1_OMRSE_00000209" ON "BW"."OMRSE_00000209" IS 'gender identity information content entity -> human biological sex or gender identity information content entity';

-- Foreign key definition : VO_0001194 -> IOIO_0000012
ALTER TABLE "BW"."VO_0001194"
  ADD CONSTRAINT "fk1_VO_0001194" FOREIGN KEY ("VO_0001194_uid")
    REFERENCES "BW"."IOIO_0000012" ("IOIO_0000012_uid");

COMMENT ON CONSTRAINT "fk1_VO_0001194" ON "BW"."VO_0001194" IS 'biological sex datum -> human biological sex or gender identity information content entity';

-- Foreign key definition : HBW_0000007 -> OBI_0100026
ALTER TABLE "BW"."HBW_0000007"
  ADD CONSTRAINT "fk0_HBW_0000007" FOREIGN KEY ("HBW_0000007_uid")
    REFERENCES "BW"."OBI_0100026" ("OBI_0100026_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000007" ON "BW"."HBW_0000007" IS 'patient -> organism';

-- Foreign key definition : HBW_0000008 -> NCBITaxon_9606
ALTER TABLE "BW"."HBW_0000008"
  ADD CONSTRAINT "fk0_HBW_0000008" FOREIGN KEY ("HBW_0000008_uid")
    REFERENCES "BW"."NCBITaxon_9606" ("NCBITaxon_9606_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000008" ON "BW"."HBW_0000008" IS 'health care provider -> Homo sapiens';

-- Foreign key definition : IAO_0000032_IAO_0000004_double -> IAO_0000032
ALTER TABLE "BW"."IAO_0000032_IAO_0000004_double"
  ADD CONSTRAINT "fk0_IAO_0000032_IAO_0000004_double" FOREIGN KEY ("IAO_0000032_uid")
    REFERENCES "BW"."IAO_0000032" ("IAO_0000032_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000032_IAO_0000004_double" ON "BW"."IAO_0000032_IAO_0000004_double" IS 'scalar measurement datum has measurement value -> scalar measurement datum';

-- Foreign key definition : HBW_0000002_PHYSIO_0000100_string -> HBW_0000002
ALTER TABLE "BW"."HBW_0000002_PHYSIO_0000100_string"
  ADD CONSTRAINT "fk0_HBW_0000002_PHYSIO_0000100_string" FOREIGN KEY ("HBW_0000002_uid")
    REFERENCES "BW"."HBW_0000002" ("HBW_0000002_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000002_PHYSIO_0000100_string" ON "BW"."HBW_0000002_PHYSIO_0000100_string" IS 'RAMQ vulnerability code has value -> RAMQ vulnerability code';

-- Foreign key definition : IAO_0020015_PHYSIO_0000100_string -> IAO_0020015
ALTER TABLE "BW"."IAO_0020015_PHYSIO_0000100_string"
  ADD CONSTRAINT "fk0_IAO_0020015_PHYSIO_0000100_string" FOREIGN KEY ("IAO_0020015_uid")
    REFERENCES "BW"."IAO_0020015" ("IAO_0020015_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0020015_PHYSIO_0000100_string" ON "BW"."IAO_0020015_PHYSIO_0000100_string" IS 'personal name has value -> personal name';

-- Foreign key definition : IAO_0000032_IAO_0000004_Literal -> IAO_0000032
ALTER TABLE "BW"."IAO_0000032_IAO_0000004_Literal"
  ADD CONSTRAINT "fk0_IAO_0000032_IAO_0000004_Literal" FOREIGN KEY ("IAO_0000032_uid")
    REFERENCES "BW"."IAO_0000032" ("IAO_0000032_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000032_IAO_0000004_Literal" ON "BW"."IAO_0000032_IAO_0000004_Literal" IS 'scalar measurement datum has measurement value -> scalar measurement datum';

-- Foreign key definition : IAO_0000003_PHYSIO_0000100_string -> IAO_0000003
ALTER TABLE "BW"."IAO_0000003_PHYSIO_0000100_string"
  ADD CONSTRAINT "fk0_IAO_0000003_PHYSIO_0000100_string" FOREIGN KEY ("IAO_0000003_uid")
    REFERENCES "BW"."IAO_0000003" ("IAO_0000003_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000003_PHYSIO_0000100_string" ON "BW"."IAO_0000003_PHYSIO_0000100_string" IS 'measurement unit label has value -> measurement unit label';

-- Foreign key definition : IAO_0000577_PHYSIO_0000100_string -> IAO_0000577
ALTER TABLE "BW"."IAO_0000577_PHYSIO_0000100_string"
  ADD CONSTRAINT "fk0_IAO_0000577_PHYSIO_0000100_string" FOREIGN KEY ("IAO_0000577_uid")
    REFERENCES "BW"."IAO_0000577" ("IAO_0000577_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000577_PHYSIO_0000100_string" ON "BW"."IAO_0000577_PHYSIO_0000100_string" IS 'centrally registered identifier symbol has value -> centrally registered identifier symbol';

-- Foreign key definition : HBW_0000026_IAO_0000004_decimal -> HBW_0000026
ALTER TABLE "BW"."HBW_0000026_IAO_0000004_decimal"
  ADD CONSTRAINT "fk0_HBW_0000026_IAO_0000004_decimal" FOREIGN KEY ("HBW_0000026_uid")
    REFERENCES "BW"."HBW_0000026" ("HBW_0000026_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000026_IAO_0000004_decimal" ON "BW"."HBW_0000026_IAO_0000004_decimal" IS 'HBW_0000026 has measurement value -> HBW_0000026';

-- Foreign key definition : IAO_0020017_PHYSIO_0000100_string -> IAO_0020017
ALTER TABLE "BW"."IAO_0020017_PHYSIO_0000100_string"
  ADD CONSTRAINT "fk0_IAO_0020017_PHYSIO_0000100_string" FOREIGN KEY ("IAO_0020017_uid")
    REFERENCES "BW"."IAO_0020017" ("IAO_0020017_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0020017_PHYSIO_0000100_string" ON "BW"."IAO_0020017_PHYSIO_0000100_string" IS 'family name has value -> family name';

-- Foreign key definition : HBW_0000022_BFO_0000051_IAO_0020015 -> HBW_0000022
ALTER TABLE "BW"."HBW_0000022_BFO_0000051_IAO_0020015"
  ADD CONSTRAINT "fk0_HBW_0000022_BFO_0000051_IAO_0020015" FOREIGN KEY ("HBW_0000022_uid")
    REFERENCES "BW"."HBW_0000022" ("HBW_0000022_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000022_BFO_0000051_IAO_0020015" ON "BW"."HBW_0000022_BFO_0000051_IAO_0020015" IS 'human name has_part personal name -> human name';

-- Foreign key definition : HBW_0000022_BFO_0000051_IAO_0020015 -> IAO_0020015
ALTER TABLE "BW"."HBW_0000022_BFO_0000051_IAO_0020015"
  ADD CONSTRAINT "fk1_HBW_0000022_BFO_0000051_IAO_0020015" FOREIGN KEY ("IAO_0020015_uid")
    REFERENCES "BW"."IAO_0020015" ("IAO_0020015_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000022_BFO_0000051_IAO_0020015" ON "BW"."HBW_0000022_BFO_0000051_IAO_0020015" IS 'human name has_part personal name -> personal name';

-- Foreign key definition : HBW_0000022_BFO_0000051_IAO_0020017 -> HBW_0000022
ALTER TABLE "BW"."HBW_0000022_BFO_0000051_IAO_0020017"
  ADD CONSTRAINT "fk0_HBW_0000022_BFO_0000051_IAO_0020017" FOREIGN KEY ("HBW_0000022_uid")
    REFERENCES "BW"."HBW_0000022" ("HBW_0000022_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000022_BFO_0000051_IAO_0020017" ON "BW"."HBW_0000022_BFO_0000051_IAO_0020017" IS 'human name has_part family name -> human name';

-- Foreign key definition : HBW_0000022_BFO_0000051_IAO_0020017 -> IAO_0020017
ALTER TABLE "BW"."HBW_0000022_BFO_0000051_IAO_0020017"
  ADD CONSTRAINT "fk1_HBW_0000022_BFO_0000051_IAO_0020017" FOREIGN KEY ("IAO_0020017_uid")
    REFERENCES "BW"."IAO_0020017" ("IAO_0020017_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000022_BFO_0000051_IAO_0020017" ON "BW"."HBW_0000022_BFO_0000051_IAO_0020017" IS 'human name has_part family name -> family name';

-- Foreign key definition : HBW_0000022_IAO_0000219_NCBITaxon_9606 -> HBW_0000022
ALTER TABLE "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606"
  ADD CONSTRAINT "fk0_HBW_0000022_IAO_0000219_NCBITaxon_9606" FOREIGN KEY ("HBW_0000022_uid")
    REFERENCES "BW"."HBW_0000022" ("HBW_0000022_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000022_IAO_0000219_NCBITaxon_9606" ON "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606" IS 'human name denotes Homo sapiens -> human name';

-- Foreign key definition : HBW_0000022_IAO_0000219_NCBITaxon_9606 -> NCBITaxon_9606
ALTER TABLE "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606"
  ADD CONSTRAINT "fk1_HBW_0000022_IAO_0000219_NCBITaxon_9606" FOREIGN KEY ("NCBITaxon_9606_uid")
    REFERENCES "BW"."NCBITaxon_9606" ("NCBITaxon_9606_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000022_IAO_0000219_NCBITaxon_9606" ON "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606" IS 'human name denotes Homo sapiens -> Homo sapiens';

-- Foreign key definition : HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45 -> HBW_0000006
ALTER TABLE "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"
  ADD CONSTRAINT "fk0_HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" FOREIGN KEY ("HBW_0000006_uid")
    REFERENCES "BW"."HBW_0000006" ("HBW_0000006_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" ON "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" IS 'medical record identifier denotes medical record identifier intersectionOf health care record | is about | patient -> medical record identifier';

-- Foreign key definition : HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45 -> ONTORELA_C4d0c3f45
ALTER TABLE "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"
  ADD CONSTRAINT "fk1_HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" FOREIGN KEY ("ONTORELA_C4d0c3f45_uid")
    REFERENCES "BW"."ONTORELA_C4d0c3f45" ("ONTORELA_C4d0c3f45_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" ON "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" IS 'medical record identifier denotes medical record identifier intersectionOf health care record | is about | patient -> medical record identifier intersectionOf health care record | is about | patient';

-- Foreign key definition : HBW_0000026_IAO_0000039_HBW_0000003 -> HBW_0000026
ALTER TABLE "BW"."HBW_0000026_IAO_0000039_HBW_0000003"
  ADD CONSTRAINT "fk0_HBW_0000026_IAO_0000039_HBW_0000003" FOREIGN KEY ("HBW_0000026_uid")
    REFERENCES "BW"."HBW_0000026" ("HBW_0000026_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000026_IAO_0000039_HBW_0000003" ON "BW"."HBW_0000026_IAO_0000039_HBW_0000003" IS 'HBW_0000026 has measurement unit label weight unit -> HBW_0000026';

-- Foreign key definition : HBW_0000026_IAO_0000039_HBW_0000003 -> HBW_0000003
ALTER TABLE "BW"."HBW_0000026_IAO_0000039_HBW_0000003"
  ADD CONSTRAINT "fk1_HBW_0000026_IAO_0000039_HBW_0000003" FOREIGN KEY ("HBW_0000003_uid")
    REFERENCES "BW"."HBW_0000003" ("HBW_0000003_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000026_IAO_0000039_HBW_0000003" ON "BW"."HBW_0000026_IAO_0000039_HBW_0000003" IS 'HBW_0000026 has measurement unit label weight unit -> weight unit';

-- Foreign key definition : BFO_0000020_RO_0000059_BFO_0000031 -> BFO_0000020
ALTER TABLE "BW"."BFO_0000020_RO_0000059_BFO_0000031"
  ADD CONSTRAINT "fk0_BFO_0000020_RO_0000059_BFO_0000031" FOREIGN KEY ("BFO_0000020_uid")
    REFERENCES "BW"."BFO_0000020" ("BFO_0000020_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000020_RO_0000059_BFO_0000031" ON "BW"."BFO_0000020_RO_0000059_BFO_0000031" IS 'specifically dependent continuant concretizes generically dependent continuant -> specifically dependent continuant';

-- Foreign key definition : BFO_0000020_RO_0000059_BFO_0000031 -> BFO_0000031
ALTER TABLE "BW"."BFO_0000020_RO_0000059_BFO_0000031"
  ADD CONSTRAINT "fk1_BFO_0000020_RO_0000059_BFO_0000031" FOREIGN KEY ("BFO_0000031_uid")
    REFERENCES "BW"."BFO_0000031" ("BFO_0000031_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000020_RO_0000059_BFO_0000031" ON "BW"."BFO_0000020_RO_0000059_BFO_0000031" IS 'specifically dependent continuant concretizes generically dependent continuant -> generically dependent continuant';

-- Foreign key definition : ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007 -> ONTORELA_C4d0c3f45
ALTER TABLE "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007"
  ADD CONSTRAINT "fk0_ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" FOREIGN KEY ("ONTORELA_C4d0c3f45_uid")
    REFERENCES "BW"."ONTORELA_C4d0c3f45" ("ONTORELA_C4d0c3f45_uid");

COMMENT ON CONSTRAINT "fk0_ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" ON "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" IS 'medical record identifier intersectionOf health care record | is about | patient is about patient -> medical record identifier intersectionOf health care record | is about | patient';

-- Foreign key definition : ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007 -> HBW_0000007
ALTER TABLE "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007"
  ADD CONSTRAINT "fk1_ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" FOREIGN KEY ("HBW_0000007_uid")
    REFERENCES "BW"."HBW_0000007" ("HBW_0000007_uid");

COMMENT ON CONSTRAINT "fk1_ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" ON "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007" IS 'medical record identifier intersectionOf health care record | is about | patient is about patient -> patient';

-- Foreign key definition : BFO_0000004_RO_0000087_BFO_0000023 -> BFO_0000004
ALTER TABLE "BW"."BFO_0000004_RO_0000087_BFO_0000023"
  ADD CONSTRAINT "fk0_BFO_0000004_RO_0000087_BFO_0000023" FOREIGN KEY ("BFO_0000004_uid")
    REFERENCES "BW"."BFO_0000004" ("BFO_0000004_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000004_RO_0000087_BFO_0000023" ON "BW"."BFO_0000004_RO_0000087_BFO_0000023" IS 'independent continuant has role role -> independent continuant';

-- Foreign key definition : BFO_0000004_RO_0000087_BFO_0000023 -> BFO_0000023
ALTER TABLE "BW"."BFO_0000004_RO_0000087_BFO_0000023"
  ADD CONSTRAINT "fk1_BFO_0000004_RO_0000087_BFO_0000023" FOREIGN KEY ("BFO_0000023_uid")
    REFERENCES "BW"."BFO_0000023" ("BFO_0000023_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000004_RO_0000087_BFO_0000023" ON "BW"."BFO_0000004_RO_0000087_BFO_0000023" IS 'independent continuant has role role -> role';

-- Foreign key definition : BFO_0000004_RO_0001025_BFO_0000004 -> BFO_0000004
ALTER TABLE "BW"."BFO_0000004_RO_0001025_BFO_0000004"
  ADD CONSTRAINT "fk0_BFO_0000004_RO_0001025_BFO_0000004" FOREIGN KEY ("BFO_0000004_uid_domain")
    REFERENCES "BW"."BFO_0000004" ("BFO_0000004_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000004_RO_0001025_BFO_0000004" ON "BW"."BFO_0000004_RO_0001025_BFO_0000004" IS 'independent continuant located in independent continuant -> independent continuant';

-- Foreign key definition : BFO_0000004_RO_0001025_BFO_0000004 -> BFO_0000004
ALTER TABLE "BW"."BFO_0000004_RO_0001025_BFO_0000004"
  ADD CONSTRAINT "fk1_BFO_0000004_RO_0001025_BFO_0000004" FOREIGN KEY ("BFO_0000004_uid_range")
    REFERENCES "BW"."BFO_0000004" ("BFO_0000004_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000004_RO_0001025_BFO_0000004" ON "BW"."BFO_0000004_RO_0001025_BFO_0000004" IS 'independent continuant located in independent continuant -> independent continuant';

-- Foreign key definition : IAO_0000032_IAO_0000039_IAO_0000003 -> IAO_0000032
ALTER TABLE "BW"."IAO_0000032_IAO_0000039_IAO_0000003"
  ADD CONSTRAINT "fk0_IAO_0000032_IAO_0000039_IAO_0000003" FOREIGN KEY ("IAO_0000032_uid")
    REFERENCES "BW"."IAO_0000032" ("IAO_0000032_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000032_IAO_0000039_IAO_0000003" ON "BW"."IAO_0000032_IAO_0000039_IAO_0000003" IS 'scalar measurement datum has measurement unit label measurement unit label -> scalar measurement datum';

-- Foreign key definition : IAO_0000032_IAO_0000039_IAO_0000003 -> IAO_0000003
ALTER TABLE "BW"."IAO_0000032_IAO_0000039_IAO_0000003"
  ADD CONSTRAINT "fk1_IAO_0000032_IAO_0000039_IAO_0000003" FOREIGN KEY ("IAO_0000003_uid")
    REFERENCES "BW"."IAO_0000003" ("IAO_0000003_uid");

COMMENT ON CONSTRAINT "fk1_IAO_0000032_IAO_0000039_IAO_0000003" ON "BW"."IAO_0000032_IAO_0000039_IAO_0000003" IS 'scalar measurement datum has measurement unit label measurement unit label -> measurement unit label';

-- Foreign key definition : HBW_0000013_PHYSIO_0000089_HBW_0000008 -> HBW_0000013
ALTER TABLE "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008"
  ADD CONSTRAINT "fk0_HBW_0000013_PHYSIO_0000089_HBW_0000008" FOREIGN KEY ("HBW_0000013_uid")
    REFERENCES "BW"."HBW_0000013" ("HBW_0000013_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000013_PHYSIO_0000089_HBW_0000008" ON "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008" IS 'physiological evaluation from health care provider has evaluant health care provider -> physiological evaluation from health care provider';

-- Foreign key definition : HBW_0000013_PHYSIO_0000089_HBW_0000008 -> HBW_0000008
ALTER TABLE "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008"
  ADD CONSTRAINT "fk1_HBW_0000013_PHYSIO_0000089_HBW_0000008" FOREIGN KEY ("HBW_0000008_uid")
    REFERENCES "BW"."HBW_0000008" ("HBW_0000008_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000013_PHYSIO_0000089_HBW_0000008" ON "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008" IS 'physiological evaluation from health care provider has evaluant health care provider -> health care provider';

-- Foreign key definition : HBW_0000001_OBI_0000312_HBW_0000012 -> HBW_0000001
ALTER TABLE "BW"."HBW_0000001_OBI_0000312_HBW_0000012"
  ADD CONSTRAINT "fk0_HBW_0000001_OBI_0000312_HBW_0000012" FOREIGN KEY ("HBW_0000001_uid")
    REFERENCES "BW"."HBW_0000001" ("HBW_0000001_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000001_OBI_0000312_HBW_0000012" ON "BW"."HBW_0000001_OBI_0000312_HBW_0000012" IS 'physiological data item is_specified_output_of physiological evaluation -> physiological data item';

-- Foreign key definition : HBW_0000001_OBI_0000312_HBW_0000012 -> HBW_0000012
ALTER TABLE "BW"."HBW_0000001_OBI_0000312_HBW_0000012"
  ADD CONSTRAINT "fk1_HBW_0000001_OBI_0000312_HBW_0000012" FOREIGN KEY ("HBW_0000012_uid")
    REFERENCES "BW"."HBW_0000012" ("HBW_0000012_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000001_OBI_0000312_HBW_0000012" ON "BW"."HBW_0000001_OBI_0000312_HBW_0000012" IS 'physiological data item is_specified_output_of physiological evaluation -> physiological evaluation';

-- Foreign key definition : IAO_0000109_IAO_0000039_IAO_0000003 -> IAO_0000109
ALTER TABLE "BW"."IAO_0000109_IAO_0000039_IAO_0000003"
  ADD CONSTRAINT "fk0_IAO_0000109_IAO_0000039_IAO_0000003" FOREIGN KEY ("IAO_0000109_uid")
    REFERENCES "BW"."IAO_0000109" ("IAO_0000109_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000109_IAO_0000039_IAO_0000003" ON "BW"."IAO_0000109_IAO_0000039_IAO_0000003" IS 'measurement datum has measurement unit label measurement unit label -> measurement datum';

-- Foreign key definition : IAO_0000109_IAO_0000039_IAO_0000003 -> IAO_0000003
ALTER TABLE "BW"."IAO_0000109_IAO_0000039_IAO_0000003"
  ADD CONSTRAINT "fk1_IAO_0000109_IAO_0000039_IAO_0000003" FOREIGN KEY ("IAO_0000003_uid")
    REFERENCES "BW"."IAO_0000003" ("IAO_0000003_uid");

COMMENT ON CONSTRAINT "fk1_IAO_0000109_IAO_0000039_IAO_0000003" ON "BW"."IAO_0000109_IAO_0000039_IAO_0000003" IS 'measurement datum has measurement unit label measurement unit label -> measurement unit label';

-- Foreign key definition : HBW_0000005_BFO_0000051_HBW_0000006 -> HBW_0000005
ALTER TABLE "BW"."HBW_0000005_BFO_0000051_HBW_0000006"
  ADD CONSTRAINT "fk0_HBW_0000005_BFO_0000051_HBW_0000006" FOREIGN KEY ("HBW_0000005_uid")
    REFERENCES "BW"."HBW_0000005" ("HBW_0000005_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000005_BFO_0000051_HBW_0000006" ON "BW"."HBW_0000005_BFO_0000051_HBW_0000006" IS 'physiological evaluation report has_part medical record identifier -> physiological evaluation report';

-- Foreign key definition : HBW_0000005_BFO_0000051_HBW_0000006 -> HBW_0000006
ALTER TABLE "BW"."HBW_0000005_BFO_0000051_HBW_0000006"
  ADD CONSTRAINT "fk1_HBW_0000005_BFO_0000051_HBW_0000006" FOREIGN KEY ("HBW_0000006_uid")
    REFERENCES "BW"."HBW_0000006" ("HBW_0000006_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000005_BFO_0000051_HBW_0000006" ON "BW"."HBW_0000005_BFO_0000051_HBW_0000006" IS 'physiological evaluation report has_part medical record identifier -> medical record identifier';

-- Foreign key definition : HBW_0000005_BFO_0000051_HBW_0000001 -> HBW_0000005
ALTER TABLE "BW"."HBW_0000005_BFO_0000051_HBW_0000001"
  ADD CONSTRAINT "fk0_HBW_0000005_BFO_0000051_HBW_0000001" FOREIGN KEY ("HBW_0000005_uid")
    REFERENCES "BW"."HBW_0000005" ("HBW_0000005_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000005_BFO_0000051_HBW_0000001" ON "BW"."HBW_0000005_BFO_0000051_HBW_0000001" IS 'physiological evaluation report has_part physiological data item -> physiological evaluation report';

-- Foreign key definition : HBW_0000005_BFO_0000051_HBW_0000001 -> HBW_0000001
ALTER TABLE "BW"."HBW_0000005_BFO_0000051_HBW_0000001"
  ADD CONSTRAINT "fk1_HBW_0000005_BFO_0000051_HBW_0000001" FOREIGN KEY ("HBW_0000001_uid")
    REFERENCES "BW"."HBW_0000001" ("HBW_0000001_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000005_BFO_0000051_HBW_0000001" ON "BW"."HBW_0000005_BFO_0000051_HBW_0000001" IS 'physiological evaluation report has_part physiological data item -> physiological data item';

-- Foreign key definition : BFO_0000017_BFO_0000054_BFO_0000015 -> BFO_0000017
ALTER TABLE "BW"."BFO_0000017_BFO_0000054_BFO_0000015"
  ADD CONSTRAINT "fk0_BFO_0000017_BFO_0000054_BFO_0000015" FOREIGN KEY ("BFO_0000017_uid")
    REFERENCES "BW"."BFO_0000017" ("BFO_0000017_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000017_BFO_0000054_BFO_0000015" ON "BW"."BFO_0000017_BFO_0000054_BFO_0000015" IS 'realizable entity realized in process -> realizable entity';

-- Foreign key definition : BFO_0000017_BFO_0000054_BFO_0000015 -> BFO_0000015
ALTER TABLE "BW"."BFO_0000017_BFO_0000054_BFO_0000015"
  ADD CONSTRAINT "fk1_BFO_0000017_BFO_0000054_BFO_0000015" FOREIGN KEY ("BFO_0000015_uid")
    REFERENCES "BW"."BFO_0000015" ("BFO_0000015_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000017_BFO_0000054_BFO_0000015" ON "BW"."BFO_0000017_BFO_0000054_BFO_0000015" IS 'realizable entity realized in process -> process';

-- Foreign key definition : BFO_0000001_BFO_0000050_BFO_0000001 -> BFO_0000001
ALTER TABLE "BW"."BFO_0000001_BFO_0000050_BFO_0000001"
  ADD CONSTRAINT "fk0_BFO_0000001_BFO_0000050_BFO_0000001" FOREIGN KEY ("BFO_0000001_uid_domain")
    REFERENCES "BW"."BFO_0000001" ("BFO_0000001_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000001_BFO_0000050_BFO_0000001" ON "BW"."BFO_0000001_BFO_0000050_BFO_0000001" IS 'entity part of entity -> entity';

-- Foreign key definition : BFO_0000001_BFO_0000050_BFO_0000001 -> BFO_0000001
ALTER TABLE "BW"."BFO_0000001_BFO_0000050_BFO_0000001"
  ADD CONSTRAINT "fk1_BFO_0000001_BFO_0000050_BFO_0000001" FOREIGN KEY ("BFO_0000001_uid_range")
    REFERENCES "BW"."BFO_0000001" ("BFO_0000001_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000001_BFO_0000050_BFO_0000001" ON "BW"."BFO_0000001_BFO_0000050_BFO_0000001" IS 'entity part of entity -> entity';

-- Foreign key definition : HBW_0000012_PHYSIO_0000089_NCBITaxon_9606 -> HBW_0000012
ALTER TABLE "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"
  ADD CONSTRAINT "fk0_HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" FOREIGN KEY ("HBW_0000012_uid")
    REFERENCES "BW"."HBW_0000012" ("HBW_0000012_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" ON "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" IS 'physiological evaluation has evaluant Homo sapiens -> physiological evaluation';

-- Foreign key definition : HBW_0000012_PHYSIO_0000089_NCBITaxon_9606 -> NCBITaxon_9606
ALTER TABLE "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"
  ADD CONSTRAINT "fk1_HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" FOREIGN KEY ("NCBITaxon_9606_uid")
    REFERENCES "BW"."NCBITaxon_9606" ("NCBITaxon_9606_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" ON "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606" IS 'physiological evaluation has evaluant Homo sapiens -> Homo sapiens';

-- Foreign key definition : HBW_0000012_OBI_0000299_ONTORELA_C61c354fb -> HBW_0000012
ALTER TABLE "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb"
  ADD CONSTRAINT "fk0_HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" FOREIGN KEY ("HBW_0000012_uid")
    REFERENCES "BW"."HBW_0000012" ("HBW_0000012_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" ON "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" IS 'physiological evaluation has_specified_output physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism -> physiological evaluation';

-- Foreign key definition : HBW_0000012_OBI_0000299_ONTORELA_C61c354fb -> ONTORELA_C61c354fb
ALTER TABLE "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb"
  ADD CONSTRAINT "fk1_HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" FOREIGN KEY ("ONTORELA_C61c354fb_uid")
    REFERENCES "BW"."ONTORELA_C61c354fb" ("ONTORELA_C61c354fb_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" ON "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb" IS 'physiological evaluation has_specified_output physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

-- Foreign key definition : IAO_0020000_IAO_0000219_BFO_0000001 -> IAO_0020000
ALTER TABLE "BW"."IAO_0020000_IAO_0000219_BFO_0000001"
  ADD CONSTRAINT "fk0_IAO_0020000_IAO_0000219_BFO_0000001" FOREIGN KEY ("IAO_0020000_uid")
    REFERENCES "BW"."IAO_0020000" ("IAO_0020000_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0020000_IAO_0000219_BFO_0000001" ON "BW"."IAO_0020000_IAO_0000219_BFO_0000001" IS 'identifier denotes entity -> identifier';

-- Foreign key definition : IAO_0020000_IAO_0000219_BFO_0000001 -> BFO_0000001
ALTER TABLE "BW"."IAO_0020000_IAO_0000219_BFO_0000001"
  ADD CONSTRAINT "fk1_IAO_0020000_IAO_0000219_BFO_0000001" FOREIGN KEY ("BFO_0000001_uid")
    REFERENCES "BW"."BFO_0000001" ("BFO_0000001_uid");

COMMENT ON CONSTRAINT "fk1_IAO_0020000_IAO_0000219_BFO_0000001" ON "BW"."IAO_0020000_IAO_0000219_BFO_0000001" IS 'identifier denotes entity -> entity';

-- Foreign key definition : HBW_0000004_IAO_0000136_OBI_0100026 -> HBW_0000004
ALTER TABLE "BW"."HBW_0000004_IAO_0000136_OBI_0100026"
  ADD CONSTRAINT "fk0_HBW_0000004_IAO_0000136_OBI_0100026" FOREIGN KEY ("HBW_0000004_uid")
    REFERENCES "BW"."HBW_0000004" ("HBW_0000004_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000004_IAO_0000136_OBI_0100026" ON "BW"."HBW_0000004_IAO_0000136_OBI_0100026" IS 'health care record is about organism -> health care record';

-- Foreign key definition : HBW_0000004_IAO_0000136_OBI_0100026 -> OBI_0100026
ALTER TABLE "BW"."HBW_0000004_IAO_0000136_OBI_0100026"
  ADD CONSTRAINT "fk1_HBW_0000004_IAO_0000136_OBI_0100026" FOREIGN KEY ("OBI_0100026_uid")
    REFERENCES "BW"."OBI_0100026" ("OBI_0100026_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000004_IAO_0000136_OBI_0100026" ON "BW"."HBW_0000004_IAO_0000136_OBI_0100026" IS 'health care record is about organism -> organism';

-- Foreign key definition : HBW_0000008_RO_0000087_HBW_0000010 -> HBW_0000008
ALTER TABLE "BW"."HBW_0000008_RO_0000087_HBW_0000010"
  ADD CONSTRAINT "fk0_HBW_0000008_RO_0000087_HBW_0000010" FOREIGN KEY ("HBW_0000008_uid")
    REFERENCES "BW"."HBW_0000008" ("HBW_0000008_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000008_RO_0000087_HBW_0000010" ON "BW"."HBW_0000008_RO_0000087_HBW_0000010" IS 'health care provider has role health care provider role -> health care provider';

-- Foreign key definition : HBW_0000008_RO_0000087_HBW_0000010 -> HBW_0000010
ALTER TABLE "BW"."HBW_0000008_RO_0000087_HBW_0000010"
  ADD CONSTRAINT "fk1_HBW_0000008_RO_0000087_HBW_0000010" FOREIGN KEY ("HBW_0000010_uid")
    REFERENCES "BW"."HBW_0000010" ("HBW_0000010_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000008_RO_0000087_HBW_0000010" ON "BW"."HBW_0000008_RO_0000087_HBW_0000010" IS 'health care provider has role health care provider role -> health care provider role';

-- Foreign key definition : BFO_0000002_RO_0000056_BFO_0000003 -> BFO_0000002
ALTER TABLE "BW"."BFO_0000002_RO_0000056_BFO_0000003"
  ADD CONSTRAINT "fk0_BFO_0000002_RO_0000056_BFO_0000003" FOREIGN KEY ("BFO_0000002_uid")
    REFERENCES "BW"."BFO_0000002" ("BFO_0000002_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000002_RO_0000056_BFO_0000003" ON "BW"."BFO_0000002_RO_0000056_BFO_0000003" IS 'continuant participates in occurrent -> continuant';

-- Foreign key definition : BFO_0000002_RO_0000056_BFO_0000003 -> BFO_0000003
ALTER TABLE "BW"."BFO_0000002_RO_0000056_BFO_0000003"
  ADD CONSTRAINT "fk1_BFO_0000002_RO_0000056_BFO_0000003" FOREIGN KEY ("BFO_0000003_uid")
    REFERENCES "BW"."BFO_0000003" ("BFO_0000003_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000002_RO_0000056_BFO_0000003" ON "BW"."BFO_0000002_RO_0000056_BFO_0000003" IS 'continuant participates in occurrent -> occurrent';

-- Foreign key definition : IAO_0000030_IAO_0000136_BFO_0000001 -> IAO_0000030
ALTER TABLE "BW"."IAO_0000030_IAO_0000136_BFO_0000001"
  ADD CONSTRAINT "fk0_IAO_0000030_IAO_0000136_BFO_0000001" FOREIGN KEY ("IAO_0000030_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000030_IAO_0000136_BFO_0000001" ON "BW"."IAO_0000030_IAO_0000136_BFO_0000001" IS 'information content entity is about entity -> information content entity';

-- Foreign key definition : IAO_0000030_IAO_0000136_BFO_0000001 -> BFO_0000001
ALTER TABLE "BW"."IAO_0000030_IAO_0000136_BFO_0000001"
  ADD CONSTRAINT "fk1_IAO_0000030_IAO_0000136_BFO_0000001" FOREIGN KEY ("BFO_0000001_uid")
    REFERENCES "BW"."BFO_0000001" ("BFO_0000001_uid");

COMMENT ON CONSTRAINT "fk1_IAO_0000030_IAO_0000136_BFO_0000001" ON "BW"."IAO_0000030_IAO_0000136_BFO_0000001" IS 'information content entity is about entity -> entity';

-- Foreign key definition : IAO_0000030_IAO_0000219_BFO_0000001 -> IAO_0000030
ALTER TABLE "BW"."IAO_0000030_IAO_0000219_BFO_0000001"
  ADD CONSTRAINT "fk0_IAO_0000030_IAO_0000219_BFO_0000001" FOREIGN KEY ("IAO_0000030_uid")
    REFERENCES "BW"."IAO_0000030" ("IAO_0000030_uid");

COMMENT ON CONSTRAINT "fk0_IAO_0000030_IAO_0000219_BFO_0000001" ON "BW"."IAO_0000030_IAO_0000219_BFO_0000001" IS 'information content entity denotes entity -> information content entity';

-- Foreign key definition : IAO_0000030_IAO_0000219_BFO_0000001 -> BFO_0000001
ALTER TABLE "BW"."IAO_0000030_IAO_0000219_BFO_0000001"
  ADD CONSTRAINT "fk1_IAO_0000030_IAO_0000219_BFO_0000001" FOREIGN KEY ("BFO_0000001_uid")
    REFERENCES "BW"."BFO_0000001" ("BFO_0000001_uid");

COMMENT ON CONSTRAINT "fk1_IAO_0000030_IAO_0000219_BFO_0000001" ON "BW"."IAO_0000030_IAO_0000219_BFO_0000001" IS 'information content entity denotes entity -> entity';

-- Foreign key definition : NOYO_0000050_IAO_0000136_NCBITaxon_9606 -> NOYO_0000050
ALTER TABLE "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606"
  ADD CONSTRAINT "fk0_NOYO_0000050_IAO_0000136_NCBITaxon_9606" FOREIGN KEY ("NOYO_0000050_uid")
    REFERENCES "BW"."NOYO_0000050" ("NOYO_0000050_uid");

COMMENT ON CONSTRAINT "fk0_NOYO_0000050_IAO_0000136_NCBITaxon_9606" ON "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606" IS 'birth statement is about Homo sapiens -> birth statement';

-- Foreign key definition : NOYO_0000050_IAO_0000136_NCBITaxon_9606 -> NCBITaxon_9606
ALTER TABLE "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606"
  ADD CONSTRAINT "fk1_NOYO_0000050_IAO_0000136_NCBITaxon_9606" FOREIGN KEY ("NCBITaxon_9606_uid")
    REFERENCES "BW"."NCBITaxon_9606" ("NCBITaxon_9606_uid");

COMMENT ON CONSTRAINT "fk1_NOYO_0000050_IAO_0000136_NCBITaxon_9606" ON "BW"."NOYO_0000050_IAO_0000136_NCBITaxon_9606" IS 'birth statement is about Homo sapiens -> Homo sapiens';

-- Foreign key definition : ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108 -> ONTORELA_C61c354fb
ALTER TABLE "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108"
  ADD CONSTRAINT "fk0_ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" FOREIGN KEY ("ONTORELA_C61c354fb_uid")
    REFERENCES "BW"."ONTORELA_C61c354fb" ("ONTORELA_C61c354fb_uid");

COMMENT ON CONSTRAINT "fk0_ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" ON "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism is about physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism';

-- Foreign key definition : ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108 -> ONTORELA_C2986e108
ALTER TABLE "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108"
  ADD CONSTRAINT "fk1_ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" FOREIGN KEY ("ONTORELA_C2986e108_uid")
    REFERENCES "BW"."ONTORELA_C2986e108" ("ONTORELA_C2986e108_uid");

COMMENT ON CONSTRAINT "fk1_ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" ON "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism is about physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism';

-- Foreign key definition : BFO_0000031_RO_0000058_BFO_0000020 -> BFO_0000031
ALTER TABLE "BW"."BFO_0000031_RO_0000058_BFO_0000020"
  ADD CONSTRAINT "fk0_BFO_0000031_RO_0000058_BFO_0000020" FOREIGN KEY ("BFO_0000031_uid")
    REFERENCES "BW"."BFO_0000031" ("BFO_0000031_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000031_RO_0000058_BFO_0000020" ON "BW"."BFO_0000031_RO_0000058_BFO_0000020" IS 'generically dependent continuant is concretized as specifically dependent continuant -> generically dependent continuant';

-- Foreign key definition : BFO_0000031_RO_0000058_BFO_0000020 -> BFO_0000020
ALTER TABLE "BW"."BFO_0000031_RO_0000058_BFO_0000020"
  ADD CONSTRAINT "fk1_BFO_0000031_RO_0000058_BFO_0000020" FOREIGN KEY ("BFO_0000020_uid")
    REFERENCES "BW"."BFO_0000020" ("BFO_0000020_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000031_RO_0000058_BFO_0000020" ON "BW"."BFO_0000031_RO_0000058_BFO_0000020" IS 'generically dependent continuant is concretized as specifically dependent continuant -> specifically dependent continuant';

-- Foreign key definition : ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026 -> ONTORELA_C2986e108-el0
ALTER TABLE "BW"."ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026"
  ADD CONSTRAINT "fk0_ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026" FOREIGN KEY ("ONTORELA_C2986e108-el0_uid")
    REFERENCES "BW"."ONTORELA_C2986e108-el0" ("ONTORELA_C2986e108-el0_uid");

COMMENT ON CONSTRAINT "fk0_ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026" ON "BW"."ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality inheres in organism -> physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality';

-- Foreign key definition : ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026 -> OBI_0100026
ALTER TABLE "BW"."ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026"
  ADD CONSTRAINT "fk1_ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026" FOREIGN KEY ("OBI_0100026_uid")
    REFERENCES "BW"."OBI_0100026" ("OBI_0100026_uid");

COMMENT ON CONSTRAINT "fk1_ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026" ON "BW"."ONTORELA_C2986e108-el0_RO_0000052_OBI_0100026" IS 'physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality inheres in organism -> organism';

-- Foreign key definition : HBW_0000007_RO_0000087_HBW_0000011 -> HBW_0000007
ALTER TABLE "BW"."HBW_0000007_RO_0000087_HBW_0000011"
  ADD CONSTRAINT "fk0_HBW_0000007_RO_0000087_HBW_0000011" FOREIGN KEY ("HBW_0000007_uid")
    REFERENCES "BW"."HBW_0000007" ("HBW_0000007_uid");

COMMENT ON CONSTRAINT "fk0_HBW_0000007_RO_0000087_HBW_0000011" ON "BW"."HBW_0000007_RO_0000087_HBW_0000011" IS 'patient has role patient role -> patient';

-- Foreign key definition : HBW_0000007_RO_0000087_HBW_0000011 -> HBW_0000011
ALTER TABLE "BW"."HBW_0000007_RO_0000087_HBW_0000011"
  ADD CONSTRAINT "fk1_HBW_0000007_RO_0000087_HBW_0000011" FOREIGN KEY ("HBW_0000011_uid")
    REFERENCES "BW"."HBW_0000011" ("HBW_0000011_uid");

COMMENT ON CONSTRAINT "fk1_HBW_0000007_RO_0000087_HBW_0000011" ON "BW"."HBW_0000007_RO_0000087_HBW_0000011" IS 'patient has role patient role -> patient role';

-- Foreign key definition : BFO_0000015_BFO_0000055_BFO_0000017 -> BFO_0000015
ALTER TABLE "BW"."BFO_0000015_BFO_0000055_BFO_0000017"
  ADD CONSTRAINT "fk0_BFO_0000015_BFO_0000055_BFO_0000017" FOREIGN KEY ("BFO_0000015_uid")
    REFERENCES "BW"."BFO_0000015" ("BFO_0000015_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000015_BFO_0000055_BFO_0000017" ON "BW"."BFO_0000015_BFO_0000055_BFO_0000017" IS 'process realizes realizable entity -> process';

-- Foreign key definition : BFO_0000015_BFO_0000055_BFO_0000017 -> BFO_0000017
ALTER TABLE "BW"."BFO_0000015_BFO_0000055_BFO_0000017"
  ADD CONSTRAINT "fk1_BFO_0000015_BFO_0000055_BFO_0000017" FOREIGN KEY ("BFO_0000017_uid")
    REFERENCES "BW"."BFO_0000017" ("BFO_0000017_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000015_BFO_0000055_BFO_0000017" ON "BW"."BFO_0000015_BFO_0000055_BFO_0000017" IS 'process realizes realizable entity -> realizable entity';

-- Foreign key definition : BFO_0000003_BFO_0000066_BFO_0000004 -> BFO_0000003
ALTER TABLE "BW"."BFO_0000003_BFO_0000066_BFO_0000004"
  ADD CONSTRAINT "fk0_BFO_0000003_BFO_0000066_BFO_0000004" FOREIGN KEY ("BFO_0000003_uid")
    REFERENCES "BW"."BFO_0000003" ("BFO_0000003_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000003_BFO_0000066_BFO_0000004" ON "BW"."BFO_0000003_BFO_0000066_BFO_0000004" IS 'occurrent occurs in independent continuant -> occurrent';

-- Foreign key definition : BFO_0000003_BFO_0000066_BFO_0000004 -> BFO_0000004
ALTER TABLE "BW"."BFO_0000003_BFO_0000066_BFO_0000004"
  ADD CONSTRAINT "fk1_BFO_0000003_BFO_0000066_BFO_0000004" FOREIGN KEY ("BFO_0000004_uid")
    REFERENCES "BW"."BFO_0000004" ("BFO_0000004_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000003_BFO_0000066_BFO_0000004" ON "BW"."BFO_0000003_BFO_0000066_BFO_0000004" IS 'occurrent occurs in independent continuant -> independent continuant';

-- Foreign key definition : BFO_0000003_RO_0000057_BFO_0000002 -> BFO_0000003
ALTER TABLE "BW"."BFO_0000003_RO_0000057_BFO_0000002"
  ADD CONSTRAINT "fk0_BFO_0000003_RO_0000057_BFO_0000002" FOREIGN KEY ("BFO_0000003_uid")
    REFERENCES "BW"."BFO_0000003" ("BFO_0000003_uid");

COMMENT ON CONSTRAINT "fk0_BFO_0000003_RO_0000057_BFO_0000002" ON "BW"."BFO_0000003_RO_0000057_BFO_0000002" IS 'occurrent has participant continuant -> occurrent';

-- Foreign key definition : BFO_0000003_RO_0000057_BFO_0000002 -> BFO_0000002
ALTER TABLE "BW"."BFO_0000003_RO_0000057_BFO_0000002"
  ADD CONSTRAINT "fk1_BFO_0000003_RO_0000057_BFO_0000002" FOREIGN KEY ("BFO_0000002_uid")
    REFERENCES "BW"."BFO_0000002" ("BFO_0000002_uid");

COMMENT ON CONSTRAINT "fk1_BFO_0000003_RO_0000057_BFO_0000002" ON "BW"."BFO_0000003_RO_0000057_BFO_0000002" IS 'occurrent has participant continuant -> continuant';


/*
-- =========================================================================== A
Schema : simple
Creation Date : 20240515-1535
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Create domains and tables
-- =========================================================================== A
*/

CREATE SCHEMA IF NOT EXISTS "simple";

COMMENT ON SCHEMA "simple" IS 'Schéma simple créé le 20240515-1535';

-- uid_domain domain definition
CREATE DOMAIN "simple"."uid_domain" AS TEXT;

-- value_domain domain definition
CREATE DOMAIN "simple"."value_domain" AS TEXT;

-- langString_domain domain definition
CREATE DOMAIN "simple"."langString_domain" AS TEXT;

-- string_domain domain definition
CREATE DOMAIN "simple"."string_domain" AS TEXT;

-- table T7f4f794200 definition
CREATE TABLE "simple"."T7f4f794200"
(
  "T7f4f794200_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T7f4f794200" PRIMARY KEY ("T7f4f794200_uid")
);

COMMENT ON COLUMN "simple"."T7f4f794200"."T7f4f794200_uid" IS 'uid Thing::Default primary key of Thing';

-- table T4f2a1f1000 definition
CREATE TABLE "simple"."T4f2a1f1000"
(
  "T4f2a1f1000_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T4f2a1f1000" PRIMARY KEY ("T4f2a1f1000_uid")
);

COMMENT ON COLUMN "simple"."T4f2a1f1000"."T4f2a1f1000_uid" IS 'uid tst3::Default primary key of tst3';

-- table T29732e8200 definition
CREATE TABLE "simple"."T29732e8200"
(
  "T29732e8200_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T29732e8200" PRIMARY KEY ("T29732e8200_uid")
);

COMMENT ON COLUMN "simple"."T29732e8200"."T29732e8200_uid" IS 'uid tst::Default primary key of tst';

-- table T305deffb00 definition
CREATE TABLE "simple"."T305deffb00"
(
  "T305deffb00_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T305deffb00" PRIMARY KEY ("T305deffb00_uid")
);

COMMENT ON COLUMN "simple"."T305deffb00"."T305deffb00_uid" IS 'uid tst1 C0004Xtst3 | rel | tst2::Default primary key of tst1 C0004Xtst3 | rel | tst2';

-- table T305df03900 definition
CREATE TABLE "simple"."T305df03900"
(
  "T305df03900_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T305df03900" PRIMARY KEY ("T305df03900_uid")
);

COMMENT ON COLUMN "simple"."T305df03900"."T305df03900_uid" IS 'uid tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3::Default primary key of tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3';

-- table T4f2a1f0000 definition
CREATE TABLE "simple"."T4f2a1f0000"
(
  "T4f2a1f0000_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T4f2a1f0000" PRIMARY KEY ("T4f2a1f0000_uid")
);

COMMENT ON COLUMN "simple"."T4f2a1f0000"."T4f2a1f0000_uid" IS 'uid tst2::Default primary key of tst2';

-- table T4f2a1ef000 definition
CREATE TABLE "simple"."T4f2a1ef000"
(
  "T4f2a1ef000_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T4f2a1ef000" PRIMARY KEY ("T4f2a1ef000_uid")
);

COMMENT ON COLUMN "simple"."T4f2a1ef000"."T4f2a1ef000_uid" IS 'uid tst1::Default primary key of tst1';

-- table T75162af000 definition
CREATE TABLE "simple"."T75162af000"
(
  "T75162af000_has_value" "simple"."string_domain"  NOT NULL, 
  "T29732e8200_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T75162af000" PRIMARY KEY ("T29732e8200_uid")
);

COMMENT ON COLUMN "simple"."T75162af000"."T75162af000_has_value" IS 'has_value::null';

COMMENT ON COLUMN "simple"."T75162af000"."T29732e8200_uid" IS 'uid tst::Default primary key of tst';

-- table T7f06a14e00 definition
CREATE TABLE "simple"."T7f06a14e00"
(
  "T305deffb00_uid" "simple"."uid_domain"  NOT NULL, 
  "T305df03900_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T7f06a14e00" PRIMARY KEY ("T305deffb00_uid", "T305df03900_uid")
);

COMMENT ON COLUMN "simple"."T7f06a14e00"."T305deffb00_uid" IS 'uid tst1 C0004Xtst3 | rel | tst2::Default primary key of tst1 C0004Xtst3 | rel | tst2';

COMMENT ON COLUMN "simple"."T7f06a14e00"."T305df03900_uid" IS 'uid tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3::Default primary key of tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3';

-- table T3801380400 definition
CREATE TABLE "simple"."T3801380400"
(
  "T4f2a1ef000_uid" "simple"."uid_domain"  NOT NULL, 
  "T305deffb00_uid" "simple"."uid_domain"  NOT NULL,
  CONSTRAINT "key_T3801380400" PRIMARY KEY ("T4f2a1ef000_uid", "T305deffb00_uid")
);

COMMENT ON COLUMN "simple"."T3801380400"."T4f2a1ef000_uid" IS 'uid tst1::Default primary key of tst1';

COMMENT ON COLUMN "simple"."T3801380400"."T305deffb00_uid" IS 'uid tst1 C0004Xtst3 | rel | tst2::Default primary key of tst1 C0004Xtst3 | rel | tst2';

-- Foreign key definition : T29732e8200 -> T7f4f794200
ALTER TABLE "simple"."T29732e8200"
  ADD CONSTRAINT "fk0_T29732e8200" FOREIGN KEY ("T29732e8200_uid")
    REFERENCES "simple"."T7f4f794200" ("T7f4f794200_uid");

COMMENT ON CONSTRAINT "fk0_T29732e8200" ON "simple"."T29732e8200" IS 'tst -> Thing';

-- Foreign key definition : T305deffb00 -> T7f4f794200
ALTER TABLE "simple"."T305deffb00"
  ADD CONSTRAINT "fk0_T305deffb00" FOREIGN KEY ("T305deffb00_uid")
    REFERENCES "simple"."T7f4f794200" ("T7f4f794200_uid");

COMMENT ON CONSTRAINT "fk0_T305deffb00" ON "simple"."T305deffb00" IS 'tst1 C0004Xtst3 | rel | tst2 -> Thing';

-- Foreign key definition : T305df03900 -> T7f4f794200
ALTER TABLE "simple"."T305df03900"
  ADD CONSTRAINT "fk0_T305df03900" FOREIGN KEY ("T305df03900_uid")
    REFERENCES "simple"."T7f4f794200" ("T7f4f794200_uid");

COMMENT ON CONSTRAINT "fk0_T305df03900" ON "simple"."T305df03900" IS 'tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3 -> Thing';

-- Foreign key definition : T4f2a1f0000 -> T29732e8200
ALTER TABLE "simple"."T4f2a1f0000"
  ADD CONSTRAINT "fk0_T4f2a1f0000" FOREIGN KEY ("T4f2a1f0000_uid")
    REFERENCES "simple"."T29732e8200" ("T29732e8200_uid");

COMMENT ON CONSTRAINT "fk0_T4f2a1f0000" ON "simple"."T4f2a1f0000" IS 'tst2 -> tst';

-- Foreign key definition : T4f2a1ef000 -> T29732e8200
ALTER TABLE "simple"."T4f2a1ef000"
  ADD CONSTRAINT "fk0_T4f2a1ef000" FOREIGN KEY ("T4f2a1ef000_uid")
    REFERENCES "simple"."T29732e8200" ("T29732e8200_uid");

COMMENT ON CONSTRAINT "fk0_T4f2a1ef000" ON "simple"."T4f2a1ef000" IS 'tst1 -> tst';

-- Foreign key definition : T4f2a1f1000 -> T305df03900
ALTER TABLE "simple"."T4f2a1f1000"
  ADD CONSTRAINT "fk0_T4f2a1f1000" FOREIGN KEY ("T4f2a1f1000_uid")
    REFERENCES "simple"."T305df03900" ("T305df03900_uid");

COMMENT ON CONSTRAINT "fk0_T4f2a1f1000" ON "simple"."T4f2a1f1000" IS 'tst3 -> tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3';

-- Foreign key definition : T4f2a1f0000 -> T305df03900
ALTER TABLE "simple"."T4f2a1f0000"
  ADD CONSTRAINT "fk1_T4f2a1f0000" FOREIGN KEY ("T4f2a1f0000_uid")
    REFERENCES "simple"."T305df03900" ("T305df03900_uid");

COMMENT ON CONSTRAINT "fk1_T4f2a1f0000" ON "simple"."T4f2a1f0000" IS 'tst2 -> tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3';

-- Foreign key definition : T4f2a1f1000 -> T29732e8200
ALTER TABLE "simple"."T4f2a1f1000"
  ADD CONSTRAINT "fk1_T4f2a1f1000" FOREIGN KEY ("T4f2a1f1000_uid")
    REFERENCES "simple"."T29732e8200" ("T29732e8200_uid");

COMMENT ON CONSTRAINT "fk1_T4f2a1f1000" ON "simple"."T4f2a1f1000" IS 'tst3 -> tst';

-- Foreign key definition : T75162af000 -> T29732e8200
ALTER TABLE "simple"."T75162af000"
  ADD CONSTRAINT "fk0_T75162af000" FOREIGN KEY ("T29732e8200_uid")
    REFERENCES "simple"."T29732e8200" ("T29732e8200_uid");

COMMENT ON CONSTRAINT "fk0_T75162af000" ON "simple"."T75162af000" IS 'tst has_value -> tst';

-- Foreign key definition : T7f06a14e00 -> T305deffb00
ALTER TABLE "simple"."T7f06a14e00"
  ADD CONSTRAINT "fk0_T7f06a14e00" FOREIGN KEY ("T305deffb00_uid")
    REFERENCES "simple"."T305deffb00" ("T305deffb00_uid");

COMMENT ON CONSTRAINT "fk0_T7f06a14e00" ON "simple"."T7f06a14e00" IS 'tst1 C0004Xtst3 | rel | tst2 rel tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3 -> tst1 C0004Xtst3 | rel | tst2';

-- Foreign key definition : T7f06a14e00 -> T305df03900
ALTER TABLE "simple"."T7f06a14e00"
  ADD CONSTRAINT "fk1_T7f06a14e00" FOREIGN KEY ("T305df03900_uid")
    REFERENCES "simple"."T305df03900" ("T305df03900_uid");

COMMENT ON CONSTRAINT "fk1_T7f06a14e00" ON "simple"."T7f06a14e00" IS 'tst1 C0004Xtst3 | rel | tst2 rel tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3 -> tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3';

-- Foreign key definition : T3801380400 -> T4f2a1ef000
ALTER TABLE "simple"."T3801380400"
  ADD CONSTRAINT "fk0_T3801380400" FOREIGN KEY ("T4f2a1ef000_uid")
    REFERENCES "simple"."T4f2a1ef000" ("T4f2a1ef000_uid");

COMMENT ON CONSTRAINT "fk0_T3801380400" ON "simple"."T3801380400" IS 'tst1 rel tst1 C0004Xtst3 | rel | tst2 -> tst1';

-- Foreign key definition : T3801380400 -> T305deffb00
ALTER TABLE "simple"."T3801380400"
  ADD CONSTRAINT "fk1_T3801380400" FOREIGN KEY ("T305deffb00_uid")
    REFERENCES "simple"."T305deffb00" ("T305deffb00_uid");

COMMENT ON CONSTRAINT "fk1_T3801380400" ON "simple"."T3801380400" IS 'tst1 rel tst1 C0004Xtst3 | rel | tst2 -> tst1 C0004Xtst3 | rel | tst2';


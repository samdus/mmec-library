/*
-- =========================================================================== A
Schema : simple_iri
Creation Date : 20240515-1535
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Create views with short IRI of simple_iri
-- =========================================================================== A
*/

CREATE SCHEMA IF NOT EXISTS "simple_iri";

COMMENT ON SCHEMA "simple_iri" IS 'Create views with short IRI of simple_iri 20240515-1535';

CREATE VIEW "simple_iri"."Thing" AS
  SELECT "T7f4f794200_uid" AS "Thing_uid"
  FROM "simple"."T7f4f794200";

COMMENT ON VIEW "simple_iri"."Thing" IS 'Thing::Top table';

CREATE VIEW "simple_iri"."tst3" AS
  SELECT "T4f2a1f1000_uid" AS "tst3_uid"
  FROM "simple"."T4f2a1f1000";

CREATE VIEW "simple_iri"."tst" AS
  SELECT "T29732e8200_uid" AS "tst_uid"
  FROM "simple"."T29732e8200";

CREATE VIEW "simple_iri"."ONTORELA_C0004X" AS
  SELECT "T305deffb00_uid" AS "ONTORELA_C0004X_uid"
  FROM "simple"."T305deffb00";

COMMENT ON VIEW "simple_iri"."ONTORELA_C0004X" IS 'tst1 C0004Xtst3 | rel | tst2::tst1 C0004X';

CREATE VIEW "simple_iri"."ONTORELA_C0006X" AS
  SELECT "T305df03900_uid" AS "ONTORELA_C0006X_uid"
  FROM "simple"."T305df03900";

COMMENT ON VIEW "simple_iri"."ONTORELA_C0006X" IS 'tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3::tst1 C0004Xtst3 | rel | tst2 unionOf ';

CREATE VIEW "simple_iri"."tst2" AS
  SELECT "T4f2a1f0000_uid" AS "tst2_uid"
  FROM "simple"."T4f2a1f0000";

CREATE VIEW "simple_iri"."tst1" AS
  SELECT "T4f2a1ef000_uid" AS "tst1_uid"
  FROM "simple"."T4f2a1ef000";

CREATE VIEW "simple_iri"."tst_has_value_string" AS
  SELECT "T75162af000_has_value" AS "T75162af000_has_value",  
    "T29732e8200_uid" AS "tst_uid"
  FROM "simple"."T75162af000";

COMMENT ON VIEW "simple_iri"."tst_has_value_string" IS 'tst has_value::DataExactCardinality(1 <http://www.griis.ca/projects/has_value> xsd:string)';

CREATE VIEW "simple_iri"."ONTORELA_C0004X_rel_ONTORELA_C0006X" AS
  SELECT "T305deffb00_uid" AS "ONTORELA_C0004X_uid",  
    "T305df03900_uid" AS "ONTORELA_C0006X_uid"
  FROM "simple"."T7f06a14e00";

COMMENT ON VIEW "simple_iri"."ONTORELA_C0004X_rel_ONTORELA_C0006X" IS 'tst1 C0004Xtst3 | rel | tst2 rel tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3::tst1 C0004X null tst1 C0004Xtst3 | rel | tst2 unionOf ';

CREATE VIEW "simple_iri"."tst1_rel_ONTORELA_C0004X" AS
  SELECT "T4f2a1ef000_uid" AS "tst1_uid",  
    "T305deffb00_uid" AS "ONTORELA_C0004X_uid"
  FROM "simple"."T3801380400";

COMMENT ON VIEW "simple_iri"."tst1_rel_ONTORELA_C0004X" IS 'tst1 rel tst1 C0004Xtst3 | rel | tst2::null null tst1 C0004X';


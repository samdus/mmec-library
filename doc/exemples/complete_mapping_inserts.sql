-- ========================================================
-- Classes
-- ========================================================
/*
http://www.w3.org/2002/07/owl#Thing
Empty mapping: insert not required
*/
/*
female biological sex datum
Empty mapping: insert not required
*/
/*
realizable
Empty mapping: insert not required
*/
/*
health care provider role
Empty mapping: insert not required
*/
/*
Homo sapiens
*/
insert into "MappingSchema"."NCBITaxon_9606"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
WHERE v1."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v3."ID_PERSONNE_EXT") AS "uid"
FROM "EXP"."PERSONNE" v3
)) v5
)
select "uid"
from mmec_query
;
/*
human name
*/
insert into "MappingSchema"."HBW_0000022"(
  "uid"
)
with mmec_query as (
  SELECT DISTINCT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v1."PRENOM", v1."NOM") AS "uid"
FROM "EXP"."PERSONNE" v1
)
select "uid"
from mmec_query
;
/*
weight unit
Empty mapping: insert not required
*/
/*
patient
*/
insert into "MappingSchema"."HBW_0000007"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
WHERE v1."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v3."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v3
)) v5
)
select "uid"
from mmec_query
;
/*
female gender identity information content entity
Empty mapping: insert not required
*/
/*
biological sex datum
Empty mapping: insert not required
*/
/*
entity
*/
insert into "MappingSchema"."BFO_0000001"(
  "uid"
)
with mmec_query as (
  SELECT DISTINCT v25."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000012_taille/{}', v1."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v1
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000012_poids/{}', v3."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v3
WHERE v3."POIDS" IS NOT NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v5."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v5
WHERE v5."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v7."ID_PERSONNE_EXT") AS "uid"
FROM "EXP"."PERSONNE" v7
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#IAO_0020017/{}', v11."NOM1m8") AS "uid"
FROM (SELECT DISTINCT v9."NOM" AS "NOM1m8"
FROM "EXP"."PERSONNE" v9
) v11
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v15."PRENOM1m8", v15."NOM17m8") AS "uid"
FROM (SELECT DISTINCT v13."NOM" AS "NOM17m8", v13."PRENOM" AS "PRENOM1m8"
FROM "EXP"."PERSONNE" v13
) v15
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#IAO_0020015/{}', v19."PRENOM21m8") AS "uid"
FROM (SELECT DISTINCT v17."PRENOM" AS "PRENOM21m8"
FROM "EXP"."PERSONNE" v17
) v19
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000006/{}', v21."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v21
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v23."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v23
)) v25
)
select "uid"
from mmec_query
;
/*
intersex biological sex datum
Empty mapping: insert not required
*/
/*
organism
*/
insert into "MappingSchema"."OBI_0100026"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
WHERE v1."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v3."ID_PERSONNE_EXT") AS "uid"
FROM "EXP"."PERSONNE" v3
)) v5
)
select "uid"
from mmec_query
;
/*
disposition or quality
Empty mapping: insert not required
*/
/*
planned process
*/
insert into "MappingSchema"."OBI_0000011"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000012_taille/{}', v1."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v1
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000012_poids/{}', v3."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v3
WHERE v3."POIDS" IS NOT NULL
)) v5
)
select "uid"
from mmec_query
;
/*
datum label
Empty mapping: insert not required
*/
/*
physiological data item
Empty mapping: insert not required
*/
/*
centrally registered identifier symbol
*/
insert into "MappingSchema"."IAO_0000577"(
  "uid"
)
with mmec_query as (
  SELECT individuation('http://www.griis.ca/projects#HBW_0000006/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
)
select "uid"
from mmec_query
;
/*
obesity
Empty mapping: insert not required
*/
/*
RAMQ vulnerability code
Empty mapping: insert not required
*/
/*
symbol
*/
insert into "MappingSchema"."IAO_0000028"(
  "uid"
)
with mmec_query as (
  SELECT individuation('http://www.griis.ca/projects#HBW_0000006/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
)
select "uid"
from mmec_query
;
/*
medical record identifier
*/
insert into "MappingSchema"."HBW_0000006"(
  "uid"
)
with mmec_query as (
  SELECT individuation('http://www.griis.ca/projects#HBW_0000006/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
)
select "uid"
from mmec_query
;
/*
male gender identity information content entity
Empty mapping: insert not required
*/
/*
male biological sex datum
Empty mapping: insert not required
*/
/*
birth statement
Empty mapping: insert not required
*/
/*
scalar measurement datum
Empty mapping: insert not required
*/
/*
personal name
*/
insert into "MappingSchema"."IAO_0020015"(
  "uid"
)
with mmec_query as (
  SELECT DISTINCT individuation('http://www.griis.ca/projects#IAO_0020015/{}', v1."PRENOM") AS "uid"
FROM "EXP"."PERSONNE" v1
)
select "uid"
from mmec_query
;
/*
(disposition or quality)
 and (inheres in some organism)
Empty mapping: insert not required
*/
/*
disease
Empty mapping: insert not required
*/
/*
continuant
*/
insert into "MappingSchema"."BFO_0000002"(
  "uid"
)
with mmec_query as (
  SELECT DISTINCT v21."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
WHERE v1."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v3."ID_PERSONNE_EXT") AS "uid"
FROM "EXP"."PERSONNE" v3
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#IAO_0020017/{}', v7."NOM1m9") AS "uid"
FROM (SELECT DISTINCT v5."NOM" AS "NOM1m9"
FROM "EXP"."PERSONNE" v5
) v7
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v11."PRENOM1m9", v11."NOM9m9") AS "uid"
FROM (SELECT DISTINCT v9."NOM" AS "NOM9m9", v9."PRENOM" AS "PRENOM1m9"
FROM "EXP"."PERSONNE" v9
) v11
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#IAO_0020015/{}', v15."PRENOM13m9") AS "uid"
FROM (SELECT DISTINCT v13."PRENOM" AS "PRENOM13m9"
FROM "EXP"."PERSONNE" v13
) v15
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000006/{}', v17."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v17
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v19."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v19
)) v21
)
select "uid"
from mmec_query
;
/*
health care record
 and (is about some patient)
*/
insert into "MappingSchema"."ONTORELA_C4d0c3f45"(
  "uid"
)
with mmec_query as (
  SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
)
select "uid"
from mmec_query
;
/*
process
*/
insert into "MappingSchema"."BFO_0000015"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000012_taille/{}', v1."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v1
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000012_poids/{}', v3."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v3
WHERE v3."POIDS" IS NOT NULL
)) v5
)
select "uid"
from mmec_query
;
/*
family name
*/
insert into "MappingSchema"."IAO_0020017"(
  "uid"
)
with mmec_query as (
  SELECT DISTINCT individuation('http://www.griis.ca/projects#IAO_0020017/{}', v1."NOM") AS "uid"
FROM "EXP"."PERSONNE" v1
)
select "uid"
from mmec_query
;
/*
quality
Empty mapping: insert not required
*/
/*
measurement datum
Empty mapping: insert not required
*/
/*
physiological evaluation
*/
insert into "MappingSchema"."HBW_0000012"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000012_taille/{}', v1."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v1
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000012_poids/{}', v3."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v3
WHERE v3."POIDS" IS NOT NULL
)) v5
)
select "uid"
from mmec_query
;
/*
female biological sex or gender identity information content entity
Empty mapping: insert not required
*/
/*
non-binary identity information content entity
Empty mapping: insert not required
*/
/*
human biological sex or gender identity information content entity
Empty mapping: insert not required
*/
/*
physiological evaluation from health care provider
*/
insert into "MappingSchema"."HBW_0000013"(
  "uid"
)
with mmec_query as (
  SELECT v9."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000012_poids/{}', v3."ID_PATIENT_EXT1m29") AS "uid"
FROM (SELECT DISTINCT v1."ID_PATIENT_EXT" AS "ID_PATIENT_EXT1m29"
FROM (select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "POIDS" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )) v1
WHERE v1."ID_PATIENT_EXT" IS NOT NULL
) v3
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000012_taille/{}', v7."ID_PATIENT_EXT1m29") AS "uid"
FROM (SELECT DISTINCT v5."ID_PATIENT_EXT" AS "ID_PATIENT_EXT1m29"
FROM (select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "TAILLE" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )) v5
WHERE v5."ID_PATIENT_EXT" IS NOT NULL
) v7
)) v9
)
select "uid"
from mmec_query
;
/*
social identity information content entity
Empty mapping: insert not required
*/
/*
physiological evaluation report
Empty mapping: insert not required
*/
/*
data item
Empty mapping: insert not required
*/
/*
measurement unit label
Empty mapping: insert not required
*/
/*
document
*/
insert into "MappingSchema"."IAO_0000310"(
  "uid"
)
with mmec_query as (
  SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
)
select "uid"
from mmec_query
;
/*
body weight
Empty mapping: insert not required
*/
/*
gdc
*/
insert into "MappingSchema"."BFO_0000031"(
  "uid"
)
with mmec_query as (
  SELECT DISTINCT v17."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#IAO_0020017/{}', v3."NOM1m14") AS "uid"
FROM (SELECT DISTINCT v1."NOM" AS "NOM1m14"
FROM "EXP"."PERSONNE" v1
) v3
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v7."PRENOM1m14", v7."NOM3m14") AS "uid"
FROM (SELECT DISTINCT v5."NOM" AS "NOM3m14", v5."PRENOM" AS "PRENOM1m14"
FROM "EXP"."PERSONNE" v5
) v7
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#IAO_0020015/{}', v11."PRENOM7m14") AS "uid"
FROM (SELECT DISTINCT v9."PRENOM" AS "PRENOM7m14"
FROM "EXP"."PERSONNE" v9
) v11
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000006/{}', v13."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v13
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v15."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v15
)) v17
)
select "uid"
from mmec_query
;
/*
occurrent
*/
insert into "MappingSchema"."BFO_0000003"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000012_taille/{}', v1."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v1
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000012_poids/{}', v3."ID_PATIENT_EXT") AS "uid"
FROM "EXP"."PATIENT" v3
WHERE v3."POIDS" IS NOT NULL
)) v5
)
select "uid"
from mmec_query
;
/*
statement
Empty mapping: insert not required
*/
/*
role
Empty mapping: insert not required
*/
/*
identifier
*/
insert into "MappingSchema"."IAO_0020000"(
  "uid"
)
with mmec_query as (
  SELECT DISTINCT v13."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#IAO_0020017/{}', v3."NOM1m16") AS "uid"
FROM (SELECT DISTINCT v1."NOM" AS "NOM1m16"
FROM "EXP"."PERSONNE" v1
) v3
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v7."PRENOM1m16", v7."NOM3m16") AS "uid"
FROM (SELECT DISTINCT v5."NOM" AS "NOM3m16", v5."PRENOM" AS "PRENOM1m16"
FROM "EXP"."PERSONNE" v5
) v7
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#IAO_0020015/{}', v11."PRENOM7m16") AS "uid"
FROM (SELECT DISTINCT v9."PRENOM" AS "PRENOM7m16"
FROM "EXP"."PERSONNE" v9
) v11
)) v13
)
select "uid"
from mmec_query
;
/*
disposition
Empty mapping: insert not required
*/
/*
ic
*/
insert into "MappingSchema"."BFO_0000004"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
WHERE v1."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v3."ID_PERSONNE_EXT") AS "uid"
FROM "EXP"."PERSONNE" v3
)) v5
)
select "uid"
from mmec_query
;
/*
gender identity information content entity
Empty mapping: insert not required
*/
/*
male biological sex or gender identity information content entity
Empty mapping: insert not required
*/
/*
patient role
Empty mapping: insert not required
*/
/*
intersex biological sex or non-binary gender identity information content entity
Empty mapping: insert not required
*/
/*
health care record
*/
insert into "MappingSchema"."HBW_0000004"(
  "uid"
)
with mmec_query as (
  SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
)
select "uid"
from mmec_query
;
/*
health care provider
*/
insert into "MappingSchema"."HBW_0000008"(
  "uid"
)
with mmec_query as (
  SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v1."ID_MEDECIN_EXT") AS "uid"
FROM "EXP"."MEDECIN" v1
)
select "uid"
from mmec_query
;
/*
specifically dependent continuant
Empty mapping: insert not required
*/
/*
data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))
Empty mapping: insert not required
*/
/*
information content entity
*/
insert into "MappingSchema"."IAO_0000030"(
  "uid"
)
with mmec_query as (
  SELECT DISTINCT v17."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#IAO_0020017/{}', v3."NOM1m15") AS "uid"
FROM (SELECT DISTINCT v1."NOM" AS "NOM1m15"
FROM "EXP"."PERSONNE" v1
) v3
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v7."PRENOM1m15", v7."NOM3m15") AS "uid"
FROM (SELECT DISTINCT v5."NOM" AS "NOM3m15", v5."PRENOM" AS "PRENOM1m15"
FROM "EXP"."PERSONNE" v5
) v7
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#IAO_0020015/{}', v11."PRENOM7m15") AS "uid"
FROM (SELECT DISTINCT v9."PRENOM" AS "PRENOM7m15"
FROM "EXP"."PERSONNE" v9
) v11
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000006/{}', v13."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v13
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v15."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v15
)) v17
)
select "uid"
from mmec_query
;
/*
material
*/
insert into "MappingSchema"."BFO_0000040"(
  "uid"
)
with mmec_query as (
  SELECT v5."uid" AS "uid"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v1."ID_PATIENT_UUID") AS "uid"
FROM "EXP"."DOSSIER" v1
WHERE v1."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v3."ID_PERSONNE_EXT") AS "uid"
FROM "EXP"."PERSONNE" v3
)) v5
)
select "uid"
from mmec_query
;
/*
informational entity
Empty mapping: insert not required
*/-- ========================================================
-- ObjectProperties
-- ========================================================
/*
IAO_0020000@'identifier' denotes [1..*] BFO_0000001@'entity'
Empty mapping: insert not required
*/
/*
IAO_0000030@'information content entity' is about [1..*] BFO_0000001@'entity'
*/
insert into "MappingSchema"."IAO_0000030_IAO_0000136_BFO_0000001"(
  "IAO_0000030_uid_domain",
  "BFO_0000001_uid_range"
)
with mmec_query as (
  SELECT individuation(v61."v6m1", v61."ID_PATIENT_UUID8m1") AS "BFO_0000001_uid_range", individuation(v61."v1m1", v61."ID_PATIENT_UUID8m1") AS "IAO_0000030_uid_domain"
FROM (SELECT DISTINCT v59."BFO_0000001_uid_range1" AS "BFO_0000001_uid_range1", v59."IAO_0000030_uid_domain0" AS "IAO_0000030_uid_domain0", v59."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", v59."v1m1" AS "v1m1", v59."v6m1" AS "v6m1"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v4."ID_PATIENT_UUID8m1") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v4."PRENOM1m15", v4."NOM3m15") AS "IAO_0000030_uid_domain0", v4."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v1m1", 'http://www.griis.ca/projects#HBW_0000007_not_identified/{}' AS "v6m1"
FROM (SELECT DISTINCT v2."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v1."NOM" AS "NOM3m15", v1."PRENOM" AS "PRENOM1m15"
FROM "EXP"."PERSONNE" v1, "EXP"."DOSSIER" v2
WHERE (individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v2."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v1."PRENOM", v1."NOM") AND v2."ID_PATIENT_EXT" IS NULL)
) v4
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v10."PRENOM1m8", v10."NOM17m8") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v10."PRENOM1m15", v10."NOM3m15") AS "IAO_0000030_uid_domain0", v10."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v1m1", 'http://www.griis.ca/projects#HBW_0000007_not_identified/{}' AS "v6m1"
FROM (SELECT DISTINCT v8."ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m1", v8."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v7."NOM" AS "NOM17m8", v6."NOM" AS "NOM3m15", v6."PRENOM" AS "PRENOM1m15", v7."PRENOM" AS "PRENOM1m8"
FROM "EXP"."PERSONNE" v6, "EXP"."PERSONNE" v7, "EXP"."DOSSIER" v8
WHERE (individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v8."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v6."PRENOM", v6."NOM") AND individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v8."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v7."PRENOM", v7."NOM") AND v8."ID_PATIENT_EXT" IS NULL)
) v10
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v12."ID_PATIENT_UUID") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v12."ID_PATIENT_UUID") AS "IAO_0000030_uid_domain0", v12."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v1m1", 'http://www.griis.ca/projects#HBW_0000007_not_identified/{}' AS "v6m1"
FROM "EXP"."DOSSIER" v12
WHERE v12."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v17."PRENOM1m8", v17."NOM17m8") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v17."ID_PATIENT_UUID8m1") AS "IAO_0000030_uid_domain0", v17."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v1m1", 'http://www.griis.ca/projects#HBW_0000007_not_identified/{}' AS "v6m1"
FROM (SELECT DISTINCT v14."ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m1", v14."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v15."NOM" AS "NOM17m8", v15."PRENOM" AS "PRENOM1m8"
FROM "EXP"."DOSSIER" v14, "EXP"."PERSONNE" v15
WHERE (individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v14."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v15."PRENOM", v15."NOM") AND v14."ID_PATIENT_EXT" IS NULL)
) v17
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v23."ID_PATIENT_UUID8m1") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v23."PRENOM1m15", v23."NOM3m15") AS "IAO_0000030_uid_domain0", v23."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v1m1", 'http://www.griis.ca/projects#NCBITaxon_9606/{}' AS "v6m1"
FROM (SELECT DISTINCT v20."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v19."NOM" AS "NOM3m15", v19."PRENOM" AS "PRENOM1m15"
FROM "EXP"."PERSONNE" v19, "EXP"."DOSSIER" v20, "EXP"."PATIENT" v21
WHERE (individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v20."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v19."PRENOM", v19."NOM") AND v20."ID_PATIENT_UUID" = v21."ID_PATIENT_EXT")
) v23
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v30."PRENOM1m8", v30."NOM17m8") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v30."PRENOM1m15", v30."NOM3m15") AS "IAO_0000030_uid_domain0", v30."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v1m1", 'http://www.griis.ca/projects#NCBITaxon_9606/{}' AS "v6m1"
FROM (SELECT DISTINCT v27."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v26."NOM" AS "NOM17m8", v25."NOM" AS "NOM3m15", v25."PRENOM" AS "PRENOM1m15", v26."PRENOM" AS "PRENOM1m8"
FROM "EXP"."PERSONNE" v25, "EXP"."PERSONNE" v26, "EXP"."DOSSIER" v27, "EXP"."PATIENT" v28
WHERE (individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v27."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v25."PRENOM", v25."NOM") AND individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v27."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v26."PRENOM", v26."NOM") AND v27."ID_PATIENT_UUID" = v28."ID_PATIENT_EXT")
) v30
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v32."ID_PATIENT_UUID") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v32."ID_PATIENT_UUID") AS "IAO_0000030_uid_domain0", v32."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v1m1", 'http://www.griis.ca/projects#NCBITaxon_9606/{}' AS "v6m1"
FROM "EXP"."DOSSIER" v32, "EXP"."PATIENT" v33
WHERE v32."ID_PATIENT_UUID" = v33."ID_PATIENT_EXT"
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v39."PRENOM1m8", v39."NOM17m8") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v39."ID_PATIENT_UUID8m1") AS "IAO_0000030_uid_domain0", v39."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v1m1", 'http://www.griis.ca/projects#NCBITaxon_9606/{}' AS "v6m1"
FROM (SELECT DISTINCT v35."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v36."NOM" AS "NOM17m8", v36."PRENOM" AS "PRENOM1m8"
FROM "EXP"."DOSSIER" v35, "EXP"."PERSONNE" v36, "EXP"."PATIENT" v37
WHERE (individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v35."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v36."PRENOM", v36."NOM") AND v35."ID_PATIENT_UUID" = v37."ID_PATIENT_EXT")
) v39
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v45."PRENOM1m8", v45."NOM17m8") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v45."PRENOM1m15", v45."NOM3m15") AS "IAO_0000030_uid_domain0", v45."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#HBW_0000006/{}' AS "v1m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v6m1"
FROM (SELECT DISTINCT v43."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v42."NOM" AS "NOM17m8", v41."NOM" AS "NOM3m15", v41."PRENOM" AS "PRENOM1m15", v42."PRENOM" AS "PRENOM1m8"
FROM "EXP"."PERSONNE" v41, "EXP"."PERSONNE" v42, "EXP"."DOSSIER" v43
WHERE (individuation('http://www.griis.ca/projects#HBW_0000006/{}', v43."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v41."PRENOM", v41."NOM") AND individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v43."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v42."PRENOM", v42."NOM"))
) v45
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v50."ID_PATIENT_UUID8m1") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v50."PRENOM1m15", v50."NOM3m15") AS "IAO_0000030_uid_domain0", v50."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#HBW_0000006/{}' AS "v1m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v6m1"
FROM (SELECT DISTINCT v48."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v47."NOM" AS "NOM3m15", v47."PRENOM" AS "PRENOM1m15"
FROM "EXP"."PERSONNE" v47, "EXP"."DOSSIER" v48
WHERE individuation('http://www.griis.ca/projects#HBW_0000006/{}', v48."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v47."PRENOM", v47."NOM")
) v50
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v55."PRENOM1m8", v55."NOM17m8") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#HBW_0000006/{}', v55."ID_PATIENT_UUID8m1") AS "IAO_0000030_uid_domain0", v55."ID_PATIENT_UUID8m1" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#HBW_0000006/{}' AS "v1m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v6m1"
FROM (SELECT DISTINCT v52."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", v53."NOM" AS "NOM17m8", v53."PRENOM" AS "PRENOM1m8"
FROM "EXP"."DOSSIER" v52, "EXP"."PERSONNE" v53
WHERE individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v52."ID_PATIENT_UUID") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v53."PRENOM", v53."NOM")
) v55
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v57."ID_PATIENT_UUID") AS "BFO_0000001_uid_range1", individuation('http://www.griis.ca/projects#HBW_0000006/{}', v57."ID_PATIENT_UUID") AS "IAO_0000030_uid_domain0", v57."ID_PATIENT_UUID" AS "ID_PATIENT_UUID8m1", 'http://www.griis.ca/projects#HBW_0000006/{}' AS "v1m1", 'http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}' AS "v6m1"
FROM "EXP"."DOSSIER" v57
)) v59
) v61
)
select "IAO_0000030_uid_domain", "BFO_0000001_uid_range"
from mmec_query
;
/*
NOYO_0000050@'birth statement' is about [1..*] NCBITaxon_9606@'Homo sapiens'
Empty mapping: insert not required
*/
/*
BFO_0000004@'ic' has role [1..*] BFO_0000023@'role'
Empty mapping: insert not required
*/
/*
BFO_0000002@'continuant' participates in [1..*] BFO_0000003@'occurrent'
Empty mapping: insert not required
*/
/*
IAO_0000032@'scalar measurement datum' has measurement unit label [1..*] IAO_0000003@'measurement unit label'
Empty mapping: insert not required
*/
/*
HBW_0000005@'physiological evaluation report' has part [1..*] HBW_0000001@'physiological data item'
Empty mapping: insert not required
*/
/*
HBW_0000026@'http://purl.obolibrary.org/obo/HBW_0000026' has measurement unit label [1..*] HBW_0000003@'weight unit'
Empty mapping: insert not required
*/
/*
ONTORELA_C4d0c3f45@'health care record
 and (is about some patient)' is about [1..*] HBW_0000007@'patient'
*/
insert into "MappingSchema"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007"(
  "ONTORELA_C4d0c3f45_uid_domain",
  "HBW_0000007_uid_range"
)
with mmec_query as (
  SELECT v6."HBW_0000007_uid_range" AS "HBW_0000007_uid_range", v6."ONTORELA_C4d0c3f45_uid_domain" AS "ONTORELA_C4d0c3f45_uid_domain"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v1."ID_PATIENT_UUID") AS "HBW_0000007_uid_range", individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v1."ID_PATIENT_UUID") AS "ONTORELA_C4d0c3f45_uid_domain"
FROM "EXP"."DOSSIER" v1
WHERE v1."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v3."ID_PATIENT_UUID") AS "HBW_0000007_uid_range", individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v3."ID_PATIENT_UUID") AS "ONTORELA_C4d0c3f45_uid_domain"
FROM "EXP"."DOSSIER" v3, "EXP"."PATIENT" v4
WHERE v3."ID_PATIENT_UUID" = v4."ID_PATIENT_EXT"
)) v6
)
select "ONTORELA_C4d0c3f45_uid_domain", "HBW_0000007_uid_range"
from mmec_query
;
/*
HBW_0000005@'physiological evaluation report' has part [1..1] HBW_0000006@'medical record identifier'
Empty mapping: insert not required
*/
/*
ONTORELA_C61c354fb@'data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))' is about [1..*] ONTORELA_C2986e108@'(disposition or quality)
 and (inheres in some organism)'
Empty mapping: insert not required
*/
/*
BFO_0000015@'process' realizes [1..*] BFO_0000017@'realizable'
Empty mapping: insert not required
*/
/*
ONTORELA_C2986e108@'(disposition or quality)
 and (inheres in some organism)' inheres in [1..*] OBI_0100026@'organism'
Empty mapping: insert not required
*/
/*
HBW_0000012@'physiological evaluation' has evaluant [1..1] NCBITaxon_9606@'Homo sapiens'
*/
insert into "MappingSchema"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"(
  "HBW_0000012_uid_domain",
  "NCBITaxon_9606_uid_range"
)
with mmec_query as (
  SELECT v13."HBW_0000012_uid_domain" AS "HBW_0000012_uid_domain", v13."NCBITaxon_9606_uid_range" AS "NCBITaxon_9606_uid_range"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000012_taille/{}', v5."ID_PATIENT_EXT2m27") AS "HBW_0000012_uid_domain", individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v5."ID_PATIENT_UUID2m17") AS "NCBITaxon_9606_uid_range"
FROM (SELECT DISTINCT v1."ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m27", v2."ID_PERSONNE_EXT" AS "ID_PATIENT_UUID2m17"
FROM "EXP"."PATIENT" v1, "EXP"."PERSONNE" v2, (SELECT CHILD."ID_PATIENT_EXT" AS "CHILD_ID_PATIENT_EXT", PARENT."ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT" FROM (SELECT *
FROM (SELECT * FROM "EXP"."MEDECIN_TRAITANT") AS child
JOIN (
                        select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "TAILLE" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )
                      ) AS parent
  USING ("ID_PATIENT_EXT")) CHILD, (SELECT * FROM  "EXP"."MEDECIN") PARENT WHERE CHILD. "ID_MEDECIN_EXT"  = PARENT. "ID_MEDECIN_EXT" ) v3
WHERE (v1."ID_PATIENT_EXT" = v3."CHILD_ID_PATIENT_EXT" AND v2."ID_PERSONNE_EXT" = v3."PARENT_ID_MEDECIN_EXT")
) v5
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#HBW_0000012_poids/{}', v11."ID_PATIENT_EXT2m27") AS "HBW_0000012_uid_domain", individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v11."ID_PATIENT_UUID2m17") AS "NCBITaxon_9606_uid_range"
FROM (SELECT DISTINCT v7."ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m27", v8."ID_PERSONNE_EXT" AS "ID_PATIENT_UUID2m17"
FROM "EXP"."PATIENT" v7, "EXP"."PERSONNE" v8, (SELECT CHILD."ID_PATIENT_EXT" AS "CHILD_ID_PATIENT_EXT", PARENT."ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT" FROM (SELECT *
FROM (SELECT * FROM "EXP"."MEDECIN_TRAITANT") AS child
JOIN (
                        select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "POIDS" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )
                      ) AS parent
  USING ("ID_PATIENT_EXT")) CHILD, (SELECT * FROM  "EXP"."MEDECIN") PARENT WHERE CHILD. "ID_MEDECIN_EXT"  = PARENT. "ID_MEDECIN_EXT" ) v9
WHERE (v7."POIDS" IS NOT NULL AND v7."ID_PATIENT_EXT" = v9."CHILD_ID_PATIENT_EXT" AND v8."ID_PERSONNE_EXT" = v9."PARENT_ID_MEDECIN_EXT")
) v11
)) v13
)
select "HBW_0000012_uid_domain", "NCBITaxon_9606_uid_range"
from mmec_query
;
/*
HBW_0000001@'physiological data item' is_specified_output_of [1..*] HBW_0000012@'physiological evaluation'
Empty mapping: insert not required
*/
/*
BFO_0000004@'ic' located in [1..*] BFO_0000004@'ic'
Empty mapping: insert not required
*/
/*
BFO_0000031@'gdc' is concretized as [1..*] BFO_0000020@'specifically dependent continuant'
Empty mapping: insert not required
*/
/*
HBW_0000012@'physiological evaluation' has_specified_output [1..*] ONTORELA_C61c354fb@'data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))'
Empty mapping: insert not required
*/
/*
HBW_0000008@'health care provider' has role [1..*] HBW_0000010@'health care provider role'
Empty mapping: insert not required
*/
/*
BFO_0000020@'specifically dependent continuant' concretizes [1..*] BFO_0000031@'gdc'
Empty mapping: insert not required
*/
/*
HBW_0000007@'patient' has role [1..*] HBW_0000011@'patient role'
Empty mapping: insert not required
*/
/*
HBW_0000004@'health care record' is about [1..*] OBI_0100026@'organism'
*/
insert into "MappingSchema"."HBW_0000004_IAO_0000136_OBI_0100026"(
  "HBW_0000004_uid_domain",
  "OBI_0100026_uid_range"
)
with mmec_query as (
  SELECT v6."HBW_0000004_uid_domain" AS "HBW_0000004_uid_domain", v6."OBI_0100026_uid_range" AS "OBI_0100026_uid_range"
FROM ((SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v1."ID_PATIENT_UUID") AS "HBW_0000004_uid_domain", individuation('http://www.griis.ca/projects#HBW_0000007_not_identified/{}', v1."ID_PATIENT_UUID") AS "OBI_0100026_uid_range"
FROM "EXP"."DOSSIER" v1
WHERE v1."ID_PATIENT_EXT" IS NULL
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#ONTORELA_C4d0c3f45/{}', v3."ID_PATIENT_UUID") AS "HBW_0000004_uid_domain", individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v3."ID_PATIENT_UUID") AS "OBI_0100026_uid_range"
FROM "EXP"."DOSSIER" v3, "EXP"."PATIENT" v4
WHERE v3."ID_PATIENT_UUID" = v4."ID_PATIENT_EXT"
)) v6
)
select "HBW_0000004_uid_domain", "OBI_0100026_uid_range"
from mmec_query
;
/*
HBW_0000013@'physiological evaluation from health care provider' has evaluant [1..1] HBW_0000008@'health care provider'
*/
insert into "MappingSchema"."HBW_0000013_PHYSIO_0000089_HBW_0000008"(
  "HBW_0000013_uid_domain",
  "HBW_0000008_uid_range"
)
with mmec_query as (
  SELECT v13."HBW_0000008_uid_range" AS "HBW_0000008_uid_range", v13."HBW_0000013_uid_domain" AS "HBW_0000013_uid_domain"
FROM ((SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v5."ID_MEDECIN_EXT1m18") AS "HBW_0000008_uid_range", individuation('http://www.griis.ca/projects#HBW_0000012_poids/{}', v5."ID_PATIENT_EXT1m29") AS "HBW_0000013_uid_domain"
FROM (SELECT DISTINCT v2."ID_MEDECIN_EXT" AS "ID_MEDECIN_EXT1m18", v1."ID_PATIENT_EXT" AS "ID_PATIENT_EXT1m29"
FROM (select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "POIDS" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )) v1, "EXP"."MEDECIN" v2, (SELECT CHILD."ID_PATIENT_EXT" AS "CHILD_ID_PATIENT_EXT", PARENT."ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT" FROM (SELECT *
FROM (SELECT * FROM "EXP"."MEDECIN_TRAITANT") AS child
JOIN (
                        select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "POIDS" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )
                      ) AS parent
  USING ("ID_PATIENT_EXT")) CHILD, (SELECT * FROM  "EXP"."MEDECIN") PARENT WHERE CHILD. "ID_MEDECIN_EXT"  = PARENT. "ID_MEDECIN_EXT" ) v3
WHERE (v1."ID_PATIENT_EXT" = v3."CHILD_ID_PATIENT_EXT" AND v2."ID_MEDECIN_EXT" = v3."PARENT_ID_MEDECIN_EXT")
) v5
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v11."ID_MEDECIN_EXT1m18") AS "HBW_0000008_uid_range", individuation('http://www.griis.ca/projects#HBW_0000012_taille/{}', v11."ID_PATIENT_EXT1m29") AS "HBW_0000013_uid_domain"
FROM (SELECT DISTINCT v8."ID_MEDECIN_EXT" AS "ID_MEDECIN_EXT1m18", v7."ID_PATIENT_EXT" AS "ID_PATIENT_EXT1m29"
FROM (select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "TAILLE" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )) v7, "EXP"."MEDECIN" v8, (SELECT CHILD."ID_PATIENT_EXT" AS "CHILD_ID_PATIENT_EXT", PARENT."ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT" FROM (SELECT *
FROM (SELECT * FROM "EXP"."MEDECIN_TRAITANT") AS child
JOIN (
                        select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "TAILLE" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )
                      ) AS parent
  USING ("ID_PATIENT_EXT")) CHILD, (SELECT * FROM  "EXP"."MEDECIN") PARENT WHERE CHILD. "ID_MEDECIN_EXT"  = PARENT. "ID_MEDECIN_EXT" ) v9
WHERE (v7."ID_PATIENT_EXT" = v9."CHILD_ID_PATIENT_EXT" AND v8."ID_MEDECIN_EXT" = v9."PARENT_ID_MEDECIN_EXT")
) v11
)) v13
)
select "HBW_0000013_uid_domain", "HBW_0000008_uid_range"
from mmec_query
;
/*
BFO_0000003@'occurrent' occurs in [1..*] BFO_0000004@'ic'
Empty mapping: insert not required
*/
/*
BFO_0000001@'entity' part of [1..*] BFO_0000001@'entity'
Empty mapping: insert not required
*/
/*
BFO_0000003@'occurrent' has participant [1..*] BFO_0000002@'continuant'
*/
insert into "MappingSchema"."BFO_0000003_RO_0000057_BFO_0000002"(
  "BFO_0000003_uid_domain",
  "BFO_0000002_uid_range"
)
with mmec_query as (
  SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v31."PARENT_ID_MEDECIN_EXT2m2") AS "BFO_0000002_uid_range", individuation(v31."v0m24", v31."ID_PATIENT_EXT2m24") AS "BFO_0000003_uid_domain"
FROM (SELECT DISTINCT v29."BFO_0000002_uid_range1" AS "BFO_0000002_uid_range1", v29."ID_PATIENT_EXT2m24" AS "ID_PATIENT_EXT2m24", v29."PARENT_ID_MEDECIN_EXT2m2" AS "PARENT_ID_MEDECIN_EXT2m2", v29."v0m24" AS "v0m24"
FROM ((SELECT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v15."PRENOM1m9", v15."NOM9m9") AS "BFO_0000002_uid_range1", v15."ID_PATIENT_EXT2m24" AS "ID_PATIENT_EXT2m24", v15."PARENT_ID_MEDECIN_EXT2m2" AS "PARENT_ID_MEDECIN_EXT2m2", v15."v0m24" AS "v0m24"
FROM (SELECT DISTINCT v13."ID_PATIENT_EXT2m24" AS "ID_PATIENT_EXT2m24", v13."NOM9m9" AS "NOM9m9", v13."PARENT_ID_MEDECIN_EXT2m2" AS "PARENT_ID_MEDECIN_EXT2m2", v13."PRENOM1m9" AS "PRENOM1m9", v13."v0m24" AS "v0m24"
FROM ((SELECT v1."ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m24", v2."NOM" AS "NOM9m9", v5."PARENT_ID_MEDECIN_EXT2m2" AS "PARENT_ID_MEDECIN_EXT2m2", v2."PRENOM" AS "PRENOM1m9", 'http://www.griis.ca/projects#HBW_0000012_taille/{}' AS "v0m24"
FROM "EXP"."PATIENT" v1, "EXP"."PERSONNE" v2, (SELECT DISTINCT v3."CHILD_ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m0", v3."PARENT_ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT2m2"
FROM (SELECT CHILD."ID_PATIENT_EXT" AS "CHILD_ID_PATIENT_EXT", PARENT."ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT" FROM (SELECT *
FROM (SELECT * FROM "EXP"."MEDECIN_TRAITANT") AS child
JOIN (
                        select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "TAILLE" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )
                      ) AS parent
  USING ("ID_PATIENT_EXT")) CHILD, (SELECT * FROM  "EXP"."MEDECIN") PARENT WHERE CHILD. "ID_MEDECIN_EXT"  = PARENT. "ID_MEDECIN_EXT" ) v3
WHERE (v3."CHILD_ID_PATIENT_EXT" IS NOT NULL AND v3."PARENT_ID_MEDECIN_EXT" IS NOT NULL)
) v5
WHERE (individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v5."PARENT_ID_MEDECIN_EXT2m2") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v2."PRENOM", v2."NOM") AND v1."ID_PATIENT_EXT" = v5."ID_PATIENT_EXT2m0")
)UNION ALL 
(SELECT v7."ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m24", v8."NOM" AS "NOM9m9", v11."PARENT_ID_MEDECIN_EXT2m2" AS "PARENT_ID_MEDECIN_EXT2m2", v8."PRENOM" AS "PRENOM1m9", 'http://www.griis.ca/projects#HBW_0000012_poids/{}' AS "v0m24"
FROM "EXP"."PATIENT" v7, "EXP"."PERSONNE" v8, (SELECT DISTINCT v9."CHILD_ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m1", v9."PARENT_ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT2m2"
FROM (SELECT CHILD."ID_PATIENT_EXT" AS "CHILD_ID_PATIENT_EXT", PARENT."ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT" FROM (SELECT *
FROM (SELECT * FROM "EXP"."MEDECIN_TRAITANT") AS child
JOIN (
                        select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "POIDS" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )
                      ) AS parent
  USING ("ID_PATIENT_EXT")) CHILD, (SELECT * FROM  "EXP"."MEDECIN") PARENT WHERE CHILD. "ID_MEDECIN_EXT"  = PARENT. "ID_MEDECIN_EXT" ) v9
WHERE (v9."CHILD_ID_PATIENT_EXT" IS NOT NULL AND v9."PARENT_ID_MEDECIN_EXT" IS NOT NULL)
) v11
WHERE (individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v11."PARENT_ID_MEDECIN_EXT2m2") = individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v8."PRENOM", v8."NOM") AND v7."POIDS" IS NOT NULL AND v7."ID_PATIENT_EXT" = v11."ID_PATIENT_EXT2m1")
)) v13
) v15
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v21."PARENT_ID_MEDECIN_EXT2m2") AS "BFO_0000002_uid_range1", v21."ID_PATIENT_EXT2m24" AS "ID_PATIENT_EXT2m24", v21."PARENT_ID_MEDECIN_EXT2m2" AS "PARENT_ID_MEDECIN_EXT2m2", 'http://www.griis.ca/projects#HBW_0000012_taille/{}' AS "v0m24"
FROM (SELECT DISTINCT v17."ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m24", v18."ID_PERSONNE_EXT" AS "PARENT_ID_MEDECIN_EXT2m2"
FROM "EXP"."PATIENT" v17, "EXP"."PERSONNE" v18, (SELECT CHILD."ID_PATIENT_EXT" AS "CHILD_ID_PATIENT_EXT", PARENT."ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT" FROM (SELECT *
FROM (SELECT * FROM "EXP"."MEDECIN_TRAITANT") AS child
JOIN (
                        select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "TAILLE" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )
                      ) AS parent
  USING ("ID_PATIENT_EXT")) CHILD, (SELECT * FROM  "EXP"."MEDECIN") PARENT WHERE CHILD. "ID_MEDECIN_EXT"  = PARENT. "ID_MEDECIN_EXT" ) v19
WHERE (v17."ID_PATIENT_EXT" = v19."CHILD_ID_PATIENT_EXT" AND v18."ID_PERSONNE_EXT" = v19."PARENT_ID_MEDECIN_EXT")
) v21
)UNION ALL 
(SELECT individuation('http://www.griis.ca/projects#NCBITaxon_9606/{}', v27."PARENT_ID_MEDECIN_EXT2m2") AS "BFO_0000002_uid_range1", v27."ID_PATIENT_EXT2m24" AS "ID_PATIENT_EXT2m24", v27."PARENT_ID_MEDECIN_EXT2m2" AS "PARENT_ID_MEDECIN_EXT2m2", 'http://www.griis.ca/projects#HBW_0000012_poids/{}' AS "v0m24"
FROM (SELECT DISTINCT v23."ID_PATIENT_EXT" AS "ID_PATIENT_EXT2m24", v24."ID_PERSONNE_EXT" AS "PARENT_ID_MEDECIN_EXT2m2"
FROM "EXP"."PATIENT" v23, "EXP"."PERSONNE" v24, (SELECT CHILD."ID_PATIENT_EXT" AS "CHILD_ID_PATIENT_EXT", PARENT."ID_MEDECIN_EXT" AS "PARENT_ID_MEDECIN_EXT" FROM (SELECT *
FROM (SELECT * FROM "EXP"."MEDECIN_TRAITANT") AS child
JOIN (
                        select "ID_PATIENT_EXT"
                        from "EXP"."PATIENT"
                        where "POIDS" is not null
                          and exists (
                            select 1
                            from "EXP"."MEDECIN_TRAITANT"
                            where "MEDECIN_TRAITANT"."ID_PATIENT_EXT" = "PATIENT"."ID_PATIENT_EXT"
                        )
                      ) AS parent
  USING ("ID_PATIENT_EXT")) CHILD, (SELECT * FROM  "EXP"."MEDECIN") PARENT WHERE CHILD. "ID_MEDECIN_EXT"  = PARENT. "ID_MEDECIN_EXT" ) v25
WHERE (v23."POIDS" IS NOT NULL AND v23."ID_PATIENT_EXT" = v25."CHILD_ID_PATIENT_EXT" AND v24."ID_PERSONNE_EXT" = v25."PARENT_ID_MEDECIN_EXT")
) v27
)) v29
) v31
)
select "BFO_0000003_uid_domain", "BFO_0000002_uid_range"
from mmec_query
;
/*
BFO_0000017@'realizable' realized in [1..*] BFO_0000015@'process'
Empty mapping: insert not required
*/
/*
HBW_0000006@'medical record identifier' denotes [1..1] ONTORELA_C4d0c3f45@'health care record
 and (is about some patient)'
Empty mapping: insert not required
*/
/*
HBW_0000022@'human name' denotes [1..*] NCBITaxon_9606@'Homo sapiens'
Empty mapping: insert not required
*/
/*
IAO_0000109@'measurement datum' has measurement unit label [1..1] IAO_0000003@'measurement unit label'
Empty mapping: insert not required
*/
/*
IAO_0000030@'information content entity' denotes [1..*] BFO_0000001@'entity'
Empty mapping: insert not required
*/
/*
HBW_0000022@'human name' has part [1..*] IAO_0020015@'personal name'
*/
insert into "MappingSchema"."HBW_0000022_BFO_0000051_IAO_0020015"(
  "HBW_0000022_uid_domain",
  "IAO_0020015_uid_range"
)
with mmec_query as (
  SELECT DISTINCT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v1."PRENOM", v1."NOM") AS "HBW_0000022_uid_domain", individuation('http://www.griis.ca/projects#IAO_0020015/{}', v1."PRENOM") AS "IAO_0020015_uid_range"
FROM "EXP"."PERSONNE" v1
)
select "HBW_0000022_uid_domain", "IAO_0020015_uid_range"
from mmec_query
;
/*
HBW_0000022@'human name' has part [1..*] IAO_0020017@'family name'
*/
insert into "MappingSchema"."HBW_0000022_BFO_0000051_IAO_0020017"(
  "HBW_0000022_uid_domain",
  "IAO_0020017_uid_range"
)
with mmec_query as (
  SELECT DISTINCT individuation('http://www.griis.ca/projects#HBW_0000022/{}/{}', v1."PRENOM", v1."NOM") AS "HBW_0000022_uid_domain", individuation('http://www.griis.ca/projects#IAO_0020017/{}', v1."NOM") AS "IAO_0020017_uid_range"
FROM "EXP"."PERSONNE" v1
)
select "HBW_0000022_uid_domain", "IAO_0020017_uid_range"
from mmec_query
;-- ========================================================
-- DataProperties
-- ========================================================
/*
IAO_0000032@'scalar measurement datum' has measurement value [1..*] @'Literal'
Empty mapping: insert not required
*/
/*
IAO_0020017@'family name' has value [1..1] @'String'
*/
insert into "MappingSchema"."IAO_0020017_PHYSIO_0000100_string"(
  "IAO_0020017_uid",
  "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100"
)
with mmec_query as (
  SELECT DISTINCT CAST(v1."NOM" AS "BW"."STRING_DOMAIN") AS "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100", individuation('http://www.griis.ca/projects#IAO_0020017/{}', v1."NOM") AS "IAO_0020017_uid"
FROM "EXP"."PERSONNE" v1
)
select "IAO_0020017_uid", "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100"
from mmec_query
;
/*
IAO_0020015@'personal name' has value [1..1] @'String'
*/
insert into "MappingSchema"."IAO_0020015_PHYSIO_0000100_string"(
  "IAO_0020015_uid",
  "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100"
)
with mmec_query as (
  SELECT DISTINCT CAST(v1."PRENOM" AS "BW"."STRING_DOMAIN") AS "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100", individuation('http://www.griis.ca/projects#IAO_0020015/{}', v1."PRENOM") AS "IAO_0020015_uid"
FROM "EXP"."PERSONNE" v1
)
select "IAO_0020015_uid", "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100"
from mmec_query
;
/*
IAO_0000577@'centrally registered identifier symbol' has value [1..1] @'String'
Empty mapping: insert not required
*/
/*
IAO_0000032@'scalar measurement datum' has measurement value [1..1] @'Double'
Empty mapping: insert not required
*/
/*
HBW_0000026@'http://purl.obolibrary.org/obo/HBW_0000026' has measurement value [1..*] @'Decimal'
Empty mapping: insert not required
*/
/*
IAO_0000003@'measurement unit label' has value [1..1] @'String'
Empty mapping: insert not required
*/
/*
HBW_0000002@'RAMQ vulnerability code' has value [1..1] @'String'
Empty mapping: insert not required
*/
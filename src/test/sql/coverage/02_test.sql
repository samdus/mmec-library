\echo Test 1: Cas de base
with data_from_ontorel as (select "NCBITaxon_9606_uid"                               as "humain",
                                  "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100" as "nom",
                                  "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100" as "prenom"
                           from "MappingSchema"."NCBITaxon_9606"
                                    -- HBW_0000022@'human name' denotes [1..*] NCBITaxon_9606@'Homo sapiens'
                                    join "MappingSchema"."HBW_0000022_IAO_0000219_NCBITaxon_9606"
                                         using ("NCBITaxon_9606_uid")
                               -- HBW_0000022@'human name' has_part [1..*] IAO_0020015@'personal name'
                                    join "MappingSchema"."HBW_0000022_BFO_0000051_IAO_0020015" using ("HBW_0000022_uid")
                               -- HBW_0000022@'human name' has_part [1..*] IAO_0020017@'family name'
                                    join "MappingSchema"."HBW_0000022_BFO_0000051_IAO_0020017" using ("HBW_0000022_uid")
                               -- IAO_0020015@'personal name' has value [1..1] @'String'
                                    join "MappingSchema"."IAO_0020015_PHYSIO_0000100_string" using ("IAO_0020015_uid")
                               -- IAO_0020017@'family name' has value [1..1] @'String'
                                    join "MappingSchema"."IAO_0020017_PHYSIO_0000100_string" using ("IAO_0020017_uid")),
     attendu as (select "MappingSchema"."individuation"('http://www.griis.ca/projects#NCBITaxon_9606/{}',
                                                        "ID_PERSONNE_EXT") as "humain",
                        "NOM"                                              as "nom",
                        "PRENOM"                                           as "prenom"
                 from "EXP"."PERSONNE"),
     nbAttendu as (select count(*) as "Nombre de lignes attendues"
                   from attendu),
     nbObtenu as (select count(*) as "Nombre de lignes obtenues"
                  from data_from_ontorel
                           natural join attendu)
select "Nombre de lignes attendues",
       "Nombre de lignes obtenues",
       "Nombre de lignes attendues" - "Nombre de lignes obtenues" as "différence"
-- On veut que la différence soit 0
from nbAttendu,
     nbObtenu;

\echo Test 2: Héritage de base
with data_from_ontorel as (select "HBW_0000022_uid" as "human name"
                           from "MappingSchema"."HBW_0000022" -- human name
                                    join "MappingSchema"."IAO_0020000"
                                         on "HBW_0000022_uid" = "IAO_0020000_uid" -- identifer
                                    join "MappingSchema"."IAO_0000030" on "IAO_0020000_uid" = "IAO_0000030_uid" -- ICE
                                    join "MappingSchema"."BFO_0000031" on "IAO_0000030_uid" = "BFO_0000031_uid" -- gdc
                                    join "MappingSchema"."BFO_0000002"
                                         on "BFO_0000031_uid" = "BFO_0000002_uid" -- continuant
                                    join "MappingSchema"."BFO_0000001" on "BFO_0000002_uid" = "BFO_0000001_uid" -- entity
),
     attendu as (select "MappingSchema"."individuation"('http://www.griis.ca/projects#HBW_0000022/{}/{}', "PRENOM",
                                                        "NOM") as "human name"
                 from "EXP"."PERSONNE"),
     nbAttendu as (select count(*) as "Nombre de lignes attendues"
                   from attendu),
     nbObtenu as (select count(*) as "Nombre de lignes obtenues"
                  from data_from_ontorel
                           natural join attendu)
select "Nombre de lignes attendues",
       "Nombre de lignes obtenues",
       "Nombre de lignes attendues" - "Nombre de lignes obtenues" as "différence"
-- On veut que la différence soit 0
from nbAttendu,
     nbObtenu;

\echo Test 3: Héritage par disjonction
with data_from_ontorel as (select "BFO_0000023_uid" as "role"
                           from "MappingSchema"."BFO_0000023"),
     attendu as (select "MappingSchema"."individuation"('http://www.griis.ca/projects#HBW_0000010/{}',
                                                        "ID_MEDECIN_EXT") as "role"
                 from "EXP"."MEDECIN"
                 union
                 select "MappingSchema"."individuation"('http://www.griis.ca/projects#HBW_0000011/{}',
                                                        "ID_PATIENT_EXT") as "role"
                 from "EXP"."PATIENT"),
     nbAttendu as (select count(*) as "Nombre de lignes attendues"
                   from attendu),
     nbObtenu as (select count(*) as "Nombre de lignes obtenues"
                  from data_from_ontorel
                           natural join attendu)
select "Nombre de lignes attendues",
       "Nombre de lignes obtenues",
       "Nombre de lignes attendues" - "Nombre de lignes obtenues" as "différence"
-- On veut que la différence soit 0
from nbAttendu,
     nbObtenu;

\echo test 4: Héritage avec chevauchement
with data_from_ontorel as (select "HBW_0000007_uid" as "organism"
                           from "MappingSchema"."HBW_0000007"
                           union
                           select "HBW_0000008_uid" as "organism"
                           from "MappingSchema"."HBW_0000008"),
     attendu as (select "MappingSchema"."individuation"('http://www.griis.ca/projects#NCBITaxon_9606/{}',
                                                        "ID_PERSONNE_EXT") AS "organism"
                 from "EXP"."PERSONNE"
                 union
                 select "MappingSchema"."individuation"('http://www.griis.ca/projects#HBW_0000007_not_identified/{}',
                                                        "ID_PATIENT_UUID") AS "organism"
                 from "EXP"."DOSSIER"
                 where "ID_PATIENT_EXT" is null),
     nbAttendu as (select count(*) as "Nombre de lignes attendues"
                   from attendu),
     nbObtenu as (select count(*) as "Nombre de lignes obtenues"
                  from data_from_ontorel
                           natural join attendu)
select "Nombre de lignes attendues",
       "Nombre de lignes obtenues",
       "Nombre de lignes attendues" - "Nombre de lignes obtenues" as "différence"
-- On veut que la différence soit 0
from nbAttendu,
     nbObtenu;

\echo test 5: Héritage multiple
with data_from_ontorel as (select "HBW_0000009_uid" as "body weight"
                           from "MappingSchema"."HBW_0000009" -- body weight
                           where exists (select
                                         from "MappingSchema"."ONTORELA_C1edc1ccd" -- quality ∨ disposition
                                         where "ONTORELA_C1edc1ccd_uid" = "HBW_0000009_uid")
                             and exists (select
                                         from "MappingSchema"."BFO_0000020" -- sdc
                                         where "BFO_0000020_uid" = "HBW_0000009_uid")),
     attendu as (select "MappingSchema"."individuation"('http://www.griis.ca/projects#HBW_0000009/{}',
                                                        "ID_PERSONNE_EXT") as "body weight"
                 from "EXP"."PERSONNE"),
     nbAttendu as (select count(*) as "Nombre de lignes attendues"
                   from attendu),
     nbObtenu as (select count(*) as "Nombre de lignes obtenues"
                  from data_from_ontorel
                           natural join attendu)
select "Nombre de lignes attendues",
       "Nombre de lignes obtenues",
       "Nombre de lignes attendues" - "Nombre de lignes obtenues" as "différence"
-- On veut que la différence soit 0
from nbAttendu,
     nbObtenu;

\echo test 6: Classe à signatures multiples
with data_from_ontorel as (select "OBI_0100026_uid"                                  as "patient",
                                  "HBW_0000002_PHYSIO_0000100_string_PHYSIO_0000100" as "code"
                           from
                               -- HBW_0000004@'health care record' is about [1..*] OBI_0100026@'organism'
                               "MappingSchema"."HBW_0000004_IAO_0000136_OBI_0100026"
                                   --HBW_0000006@'medical record identifier' denotes [1..1] ONTORELA_C4d0c3f45@'health care record and (is about some patient)'
                                   join "MappingSchema"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" as "HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"("HBW_0000006_uid", "HBW_0000004_uid")
                                        using ("HBW_0000004_uid")
                                   -- HBW_0000029@'RAMQ vulnerability code statement' has_part [1..1] HBW_0000006@'medical record identifier'
                                   join "MappingSchema"."HBW_0000029_BFO_0000051_HBW_0000006" using ("HBW_0000006_uid")
                                   -- HBW_0000029@'RAMQ vulnerability code statement' has_part [1..1] HBW_0000002@'RAMQ vulnerability code'
                                   join "MappingSchema"."HBW_0000029_BFO_0000051_HBW_0000002" using ("HBW_0000029_uid")
                                   -- HBW_0000002@'RAMQ vulnerability code' has value [1..1] @'String'
                                   join "MappingSchema"."HBW_0000002_PHYSIO_0000100_string" using ("HBW_0000002_uid")),
     attendu as (select "MappingSchema"."individuation"('http://www.griis.ca/projects#NCBITaxon_9606/{}',
                                                        "ID_PATIENT_EXT") as "patient",
                        "CODE_VULN_1"::"BW".string_domain                 as "code"
                 from "EXP"."PATIENT"
                          join "EXP"."DOSSIER" using ("ID_PATIENT_EXT")
                 union
                 select "MappingSchema"."individuation"('http://www.griis.ca/projects#NCBITaxon_9606/{}',
                                                        "ID_PATIENT_EXT") as "patient",
                        "CODE_VULN_2"::"BW".string_domain                 as "code"
                 from "EXP"."PATIENT"
                          join "EXP"."DOSSIER" using ("ID_PATIENT_EXT")
                 union
                 select "MappingSchema"."individuation"('http://www.griis.ca/projects#NCBITaxon_9606/{}',
                                                        "ID_PATIENT_EXT") as "patient",
                        "CODE_VULN_3"::"BW".string_domain                 as "code"
                 from "EXP"."PATIENT"
                          join "EXP"."DOSSIER" using ("ID_PATIENT_EXT")),
     nbAttendu as (select count(*) as "Nombre de lignes attendues"
                   from attendu),
     nbObtenu as (select count(*) as "Nombre de lignes obtenues"
                  from data_from_ontorel
                           natural join attendu)
select "Nombre de lignes attendues",
       "Nombre de lignes obtenues",
       "Nombre de lignes attendues" - "Nombre de lignes obtenues" as "différence"
-- On veut que la différence soit 0
from nbAttendu,
     nbObtenu;

\echo test 7: Individuation d’une conjonction
\echo Skip - Déjà testé avec les tests précédents
\echo

\echo test 8: Individuation d’une disjonction
with sexe as (select "OBI_0100026_uid"                       as "patient",
                     case
                         when "HBW_0000025_uid" is not null then 'F'
                         when "HBW_0000023_uid" is not null then 'M'
                         end::"EXP"."SEXE_OU_IDENTITE_GENRE" as "SEXE"
              from -- HBW_0000004@'health care record' is about [1..*] OBI_0100026@'organism'
                   "MappingSchema"."HBW_0000004_IAO_0000136_OBI_0100026"
                       --HBW_0000006@'medical record identifier' denotes [1..1] ONTORELA_C4d0c3f45@'health care record and (is about some patient)'
                       join "MappingSchema"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" as "HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"("HBW_0000006_uid", "HBW_0000004_uid")
                            using ("HBW_0000004_uid")
                       -- HBW_0000028@'human biological sex or gender identity statement' has_part [1..1] HBW_0000006@'medical record identifier'
                       join "MappingSchema"."HBW_0000028_BFO_0000051_HBW_0000006"
                            using ("HBW_0000006_uid")
-- HBW_0000028@'human biological sex or gender identity statement' has_part [1..1] IOIO_0000012@'human biological sex or gender identity information content entity'
                       join "MappingSchema"."HBW_0000028_BFO_0000051_IOIO_0000012" as "HBW_0000028_BFO_0000051_unknown"("HBW_0000028_uid", "unknown_uid")
                            using ("HBW_0000028_uid")
                       -- female datum or gender ICE
                       left join "MappingSchema"."HBW_0000025" on "HBW_0000025_uid" = "unknown_uid"
                       -- HBW_0000023 male datum or gender ICE
                       left join "MappingSchema"."HBW_0000023" on "HBW_0000023_uid" = "unknown_uid"
              where not exists(select
                               from "MappingSchema"."VO_0001194"
                               where "VO_0001194_uid" = "unknown_uid")
                and not exists(select
                               from "MappingSchema"."OMRSE_00000209"
                               where "OMRSE_00000209_uid" = "unknown_uid")),
     "sexe_bio" as (select "OBI_0100026_uid"         as "patient",
                           case
                               when "VO_0004895_uid" is not null then 'F'
                               when "VO_0004896_uid" is not null then 'I'
                               when "VO_0000613_uid" is not null then 'M'
                               end::"EXP"."SEXE_BIO" as "SEXE_BIO"
                    from -- HBW_0000004@'health care record' is about [1..*] OBI_0100026@'organism'
                         "MappingSchema"."HBW_0000004_IAO_0000136_OBI_0100026"
                             --HBW_0000006@'medical record identifier' denotes [1..1] ONTORELA_C4d0c3f45@'health care record and (is about some patient)'
                             join "MappingSchema"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" as "HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"("HBW_0000006_uid", "HBW_0000004_uid")
                                  using ("HBW_0000004_uid")
                             -- HBW_0000028@'human biological sex or gender identity statement' has_part [1..1] HBW_0000006@'medical record identifier'
                             join "MappingSchema"."HBW_0000028_BFO_0000051_HBW_0000006"
                                  using ("HBW_0000006_uid")
                             -- HBW_0000028@'human biological sex or gender identity statement' has_part [1..1] IOIO_0000012@'human biological sex or gender identity information content entity'
                             join "MappingSchema"."HBW_0000028_BFO_0000051_IOIO_0000012" as "HBW_0000028_BFO_0000051_VO_0001194"("HBW_0000028_uid", "VO_0001194_uid")
                                  using ("HBW_0000028_uid")
                             -- biological sex datum
                             join "MappingSchema"."VO_0001194" using ("VO_0001194_uid")
                             -- intersex datum
                             left join "MappingSchema"."VO_0004896" on "VO_0004896_uid" = "VO_0001194_uid"
                             -- female datum
                             left join "MappingSchema"."VO_0004895" on "VO_0004895_uid" = "VO_0001194_uid"
                             -- male datum
                             left join "MappingSchema"."VO_0000613" on "VO_0000613_uid" = "VO_0001194_uid"),
     "identite_genre" as (select "OBI_0100026_uid"               as "patient",
                                 case
                                     when "OMRSE_00000210_uid" is not null then 'F'
                                     when "OMRSE_00000212_uid" is not null then 'NB'
                                     when "OMRSE_00000211_uid" is not null then 'M'
                                     end::"EXP"."IDENTITE_GENRE" as "IDENTITE_GENRE"
                          from -- HBW_0000004@'health care record' is about [1..*] OBI_0100026@'organism'
                               "MappingSchema"."HBW_0000004_IAO_0000136_OBI_0100026"
                                   --HBW_0000006@'medical record identifier' denotes [1..1] ONTORELA_C4d0c3f45@'health care record and (is about some patient)'
                                   join "MappingSchema"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45" as "HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"("HBW_0000006_uid", "HBW_0000004_uid")
                                        using ("HBW_0000004_uid")
                                   -- HBW_0000028@'human biological sex or gender identity statement' has_part [1..1] HBW_0000006@'medical record identifier'
                                   join "MappingSchema"."HBW_0000028_BFO_0000051_HBW_0000006"
                                        using ("HBW_0000006_uid")
                                   -- HBW_0000028@'human biological sex or gender identity statement' has_part [1..1] IOIO_0000012@'human biological sex or gender identity information content entity'
                                   join "MappingSchema"."HBW_0000028_BFO_0000051_IOIO_0000012" as "HBW_0000028_BFO_0000051_OMRSE_00000209"("HBW_0000028_uid", "OMRSE_00000209_uid")
                                        using ("HBW_0000028_uid")
                                   -- gender identity ICE
                                   join "MappingSchema"."OMRSE_00000209" using ("OMRSE_00000209_uid")
                                   -- female gender identity ICE
                                   left join "MappingSchema"."OMRSE_00000210"
                                             on "OMRSE_00000210_uid" = "OMRSE_00000209_uid"
                                   -- male gender identity ICE
                                   left join "MappingSchema"."OMRSE_00000211"
                                             on "OMRSE_00000211_uid" = "OMRSE_00000209_uid"
                                   -- non-binary identity ICE
                                   left join "MappingSchema"."OMRSE_00000212"
                                             on "OMRSE_00000212_uid" = "OMRSE_00000209_uid"),
     data_from_ontorel as (select *
                           from "MappingSchema"."HBW_0000007" as "HBW_0000007"("patient")
                                    left join sexe using ("patient")
                                    left join sexe_bio using ("patient")
                                    left join identite_genre using ("patient")),
     attendu as (select "MappingSchema"."individuation"('http://www.griis.ca/projects#NCBITaxon_9606/{}',
                                                        "ID_PATIENT_EXT") AS "patient",
                        "SEXE",
                        "SEXE_BIO",
                        "IDENTITE_GENRE"
                 from "EXP"."PATIENT"
                          join "EXP"."DOSSIER" using ("ID_PATIENT_EXT")),
     nbAttendu as (select count(*) as "Nombre de lignes attendues"
                   from attendu),
     nbObtenu as (select count(*) as "Nombre de lignes obtenues"
                  from data_from_ontorel
                           join attendu
                                on attendu.patient = data_from_ontorel.patient
                                    and (attendu."SEXE" = data_from_ontorel."SEXE" or
                                         (attendu."SEXE" is null and data_from_ontorel."SEXE" is null))
                                    and (attendu."SEXE_BIO" = data_from_ontorel."SEXE_BIO" or
                                         (attendu."SEXE_BIO" is null and data_from_ontorel."SEXE_BIO" is null))
                                    and (attendu."IDENTITE_GENRE" = data_from_ontorel."IDENTITE_GENRE" or
                                         (attendu."IDENTITE_GENRE" is null and
                                          data_from_ontorel."IDENTITE_GENRE" is null)))
select "Nombre de lignes attendues",
       "Nombre de lignes obtenues",
       "Nombre de lignes attendues" - "Nombre de lignes obtenues" as "différence"
-- On veut que la différence soit 0
from nbAttendu,
     nbObtenu;

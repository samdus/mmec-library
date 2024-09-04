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
                            join "MappingSchema"."IAO_0020000" on "HBW_0000022_uid" = "IAO_0020000_uid" -- identifer
                            join "MappingSchema"."IAO_0000030" on "IAO_0020000_uid" = "IAO_0000030_uid" -- ICE
                            join "MappingSchema"."BFO_0000031" on "IAO_0000030_uid" = "BFO_0000031_uid" -- gdc
                            join "MappingSchema"."BFO_0000002" on "BFO_0000031_uid" = "BFO_0000002_uid" -- continuant
                            join "MappingSchema"."BFO_0000001" on "BFO_0000002_uid" = "BFO_0000001_uid" -- entity
                           ),
     attendu as (select "MappingSchema"."individuation"('http://www.griis.ca/projects#HBW_0000022/{}/{}', "PRENOM", "NOM") as "human name"
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
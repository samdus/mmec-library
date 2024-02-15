-- *****************************************************************************
-- Insertions pour Héritage multiple
-- *****************************************************************************
with ins_t0024 AS (
    insert into "BW"."T0024" ("T0024_uid")
        values ('po1'), ('po2'), ('po3'), ('po4')
        returning "T0024_uid"),
     ins_t0017 AS (
         insert into "BW"."T0017" ("T0017_uid")
             select "T0024_uid"
             from ins_t0024
             returning "T0017_uid"),
     ins_t0021 AS (
         insert into "BW"."T0021" ("T0021_uid")
             select "T0017_uid"
             from ins_t0017
             returning "T0021_uid"),
     ins_t0003 AS (
         insert into "BW"."T0003" ("T0003_uid")
             select "T0021_uid"
             from ins_t0021
             returning "T0003_uid"),
     ins_t0008 AS (
         insert into "BW"."T0008" ("T0008_uid")
             select "T0003_uid"
             from ins_t0003
             returning "T0008_uid"),
     ins_t0019 AS (
         insert into "BW"."T0019" ("T0019_uid")
             select "T0008_uid"
             from ins_t0008
             returning "T0019_uid"),
     ins_t0000 AS (
         insert into "BW"."T0000" ("T0000_uid")
             select "T0019_uid"
             from ins_t0019
             returning "T0000_uid")
select *
from ins_t0000;

-- *****************************************************************************
-- Insertions pour Héritage disjoint
-- *****************************************************************************
with ins_t0028 AS (
    insert into "BW"."T0028" ("T0028_uid")
        values ('pr1'), ('pr2'), ('pr3')
        returning "T0028_uid"),
     ins_t0013 AS (
         insert into "BW"."T0013" ("T0013_uid")
             values ('pm1'), ('pm2'), ('pm3')
             returning "T0013_uid"),
     ins_t001a AS (
         insert into "BW"."T001a" ("T001a_uid")
             select "T001a_uid"
             from (select "T0028_uid"
                   from ins_t0028
                   union all
                   select "T0013_uid"
                   from ins_t0013) as t("T001a_uid")
             returning "T001a_uid"),
     "ins_t0018" AS (
         insert into "BW"."T0018" ("T0018_uid")
             select "T001a_uid"
             from ins_t001a
             returning "T0018_uid"),
     "ins_t0003" AS (
         insert into "BW"."T0003" ("T0003_uid")
             select "T0018_uid"
             from ins_t0018
             returning "T0003_uid"),
     "ins_t0008" AS (
         insert into "BW"."T0008" ("T0008_uid")
             select "T0003_uid"
             from ins_t0003
             returning "T0008_uid"),
     "ins_t0019" AS (
         insert into "BW"."T0019" ("T0019_uid")
             select "T0008_uid"
             from ins_t0008
             returning "T0019_uid"),
     "ins_t0000" AS (
         insert into "BW"."T0000" ("T0000_uid")
             select "T0019_uid"
             from ins_t0019
             returning "T0000_uid")
select *
from ins_t0000;

-- *****************************************************************************
-- Insertion pour Héritage avec chevauchement
-- *****************************************************************************
with ins_t0022 AS (
    insert into "BW"."T0022" ("T0022_uid")
        values ('o1', 'o2', 'o3')
        returning "T0022_uid"),
     ins_t000d AS (
         insert into "BW"."T000d" ("T000d_uid")
             values ('o2'), ('o3'), ('o4')
             returning "T000d_uid"),
     ins_t0026 AS (
         insert into "BW"."T0026" ("T0026_uid")
             select "T000d_uid"
             from ins_t000d
             returning "T0026_uid"),
     ins_t0027 AS (
         insert into "BW"."T0027" ("T0027_uid")
             select "T0022_uid"
             from ins_t0022
             union
             select "T0026_uid"
             from ins_t0026
             returning "T0027_uid"),
     ins_t000e AS (
         insert into "BW"."T000e" ("T000e_uid")
             select "T0027_uid"
             from ins_t0027
             returning "T000e_uid"),
     ins_t0007 AS (
         insert into "BW"."T0007" ("T0007_uid")
             select "T000e_uid"
             from ins_t000e
             returning "T0007_uid"),
     ins_t0008 AS (
         insert into "BW"."T0008" ("T0008_uid")
             select "T0007_uid"
             from ins_t0007
             returning "T0008_uid"),
     ins_t0019 AS (
         insert into "BW"."T0019" ("T0019_uid")
             select "T0008_uid"
             from ins_t0008
             returning "T0019_uid"),
     ins_t0000 AS (
         insert into "BW"."T0000" ("T0000_uid")
             select "T0019_uid"
             from ins_t0019
             returning "T0000_uid")
select *
from ins_t0000;

-- *****************************************************************************
-- Insertion pour Plusieurs signatures pour une classe
-- *****************************************************************************
with ins_t0015 AS (
    insert into "BW"."T0015" ("T0015_uid")
        values ('c1'), ('c2'), ('c3'), ('c4'), ('c5'), ('c6')
        returning "T0015_uid"),
     ins_t000c AS (
         insert into "BW"."T000c" ("T000c_uid")
             select "T0015_uid"
             from ins_t0015
             returning "T000c_uid"),
     ins_t0004 AS (
         insert into "BW"."T0004" ("T0004_uid")
             select "T000c_uid"
             from ins_t000c
             returning "T0004_uid"),
     ins_t001d AS (
         insert into "BW"."T001d" ("T001d_uid")
             select "T0004_uid"
             from ins_t0004
             returning "T001d_uid"),
     ins_t0008 AS (
         insert into "BW"."T0008" ("T0008_uid")
             select "T001d_uid"
             from ins_t001d
             returning "T0008_uid"),
     ins_t0019 AS (
         insert into "BW"."T0019" ("T0019_uid")
             select "T0008_uid"
             from ins_t0008
             returning "T0019_uid"),
     ins_t0000 AS (
         insert into "BW"."T0000" ("T0000_uid")
             select "T0019_uid"
             from ins_t0019
             returning "T0000_uid")
select *
from ins_t0000;

-- *****************************************************************************
-- Insertions pour Conjonction (en supposant que o1, o2 et o3 existent déjà)
-- *****************************************************************************

-- Insérer 'mri1' et 'mri2' dans T000b (donc, dans T0025,  T0023,  T0004, T001d,  T0008,  T0019,  T0000)
with ins_t000b AS (
    insert into "BW"."T000b"
        values ('mri1'), ('mri2')
        returning "T000b_uid"),
     ins_t0025 AS (
         insert into "BW"."T0025"
             select "T000b_uid"
             from ins_t000b
             returning "T0025_uid"),
     ins_t0023 AS (
         insert into "BW"."T0023"
             select "T0025_uid"
             from ins_t0025
             returning "T0023_uid"),
     ins_t0004 AS (
         insert into "BW"."T0004"
             select "T0023_uid"
             from ins_t0023
             returning "T0004_uid"),
     ins_t001d AS (
         insert into "BW"."T001d"
             select "T0004_uid"
             from ins_t0004
             returning "T001d_uid"),
     ins_t0008 AS (
         insert into "BW"."T0008"
             select "T001d_uid"
             from ins_t001d
             returning "T0008_uid"),
     ins_t0019 AS (
         insert into "BW"."T0019"
             select "T0008_uid"
             from ins_t0008
             returning "T0019_uid"),
     ins_t0000 AS (
         insert into "BW"."T0000"
             select "T0019_uid"
             from ins_t0019
             returning "T0000_uid")
select *
from ins_t0000;

-- Insérer x1 et x2 dans T000f (donc, dans T000a, T0010, T0004, T001d, T0008, T0019, T0000)
with ins_t000f AS (
    insert into "BW"."T000f"
        values ('x1'), ('x2')
        returning "T000f_uid"),
     ins_t000a AS (
         insert into "BW"."T000a"
             select "T000f_uid"
             from ins_t000f
             returning "T000a_uid"),
     ins_t0010 AS (
         insert into "BW"."T0010"
             select "T000a_uid"
             from ins_t000a
             returning "T0010_uid"),
     ins_t0004 AS (
         insert into "BW"."T0004"
             select "T0010_uid"
             from ins_t0010
             returning "T0004_uid"),
     ins_t001d AS (
         insert into "BW"."T001d"
             select "T0004_uid"
             from ins_t0004
             returning "T001d_uid"),
     ins_t0008 AS (
         insert into "BW"."T0008"
             select "T001d_uid"
             from ins_t001d
             returning "T0008_uid"),
     ins_t0019 AS (
         insert into "BW"."T0019"
             select "T0008_uid"
             from ins_t0008
             returning "T0019_uid"),
     ins_t0000 AS (
         insert into "BW"."T0000"
             select "T0019_uid"
             from ins_t0019
             returning "T0000_uid")
select *
from ins_t0000;

-- Insérer mri1 denotes x1 et mri2 denotes x2
insert into "BW"."T003b"("T000b_uid", "T000f_uid")
values ('mri1', 'x1'),
       ('mri2', 'x2')
returning *;

-- Insérer x1 is about o2 et x2 is about o3
insert into "BW"."T003d"("T000f_uid", "T0022_uid")
values ('x1', 'o2'),
       ('x2', 'o3')
returning *;

-- *****************************************************************************
-- Insertions pour Arrimage Simple
-- *****************************************************************************


-- Insertions personal name
with personalName AS (select *
                      from (values ('pn1', 'Owen'), ('pn2', 'Beru')) "t"("IAO_0020015_uid", "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100")),
     ins_IAO_0020015 AS (
         insert into "BW"."IAO_0020015" ("IAO_0020015_uid")
             select "IAO_0020015_uid"
             from personalName
             returning "IAO_0020015_uid"),
     ins_IAO_0020000 AS (
         insert into "BW"."IAO_0020000" ("IAO_0020000_uid")
             select "IAO_0020015_uid"
             from ins_IAO_0020015
             returning "IAO_0020000_uid"),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IAO_0020000_uid"
             from ins_IAO_0020000
             returning "IAO_0000030_uid"),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning "BFO_0000031_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid"),
     ins_IAO_0020015_PHYSIO_0000100_string AS (
         insert into "BW"."IAO_0020015_PHYSIO_0000100_string" ("IAO_0020015_uid", "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100")
             select "IAO_0020015_uid", "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100"
             from personalName
             returning "IAO_0020015_uid", "IAO_0020015_PHYSIO_0000100_string_PHYSIO_0000100")
select *
from ins_Thing ins_Thing("IAO_0020015_uid")
         natural join ins_IAO_0020015_PHYSIO_0000100_string;

-- Insertions family name
with familyName AS (select *
                    from (values ('nm1', 'Lars'), ('nm2', 'Whitesun lars')) as t("IAO_0020017_uid", "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100")),
     ins_IAO_0020017 AS (
         insert into "BW"."IAO_0020017" ("IAO_0020017_uid")
             select "IAO_0020017_uid"
             from familyName
             returning "IAO_0020017_uid"),
     ins_IAO_0020000 AS (
         insert into "BW"."IAO_0020000" ("IAO_0020000_uid")
             select "IAO_0020017_uid"
             from ins_IAO_0020017
             returning "IAO_0020000_uid"),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IAO_0020000_uid"
             from ins_IAO_0020000
             returning "IAO_0000030_uid"),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning "BFO_0000031_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid"),
     ins_IAO_0020017_PHYSIO_0000100_string AS (
         insert into "BW"."IAO_0020017_PHYSIO_0000100_string" ("IAO_0020017_uid", "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100")
             select "IAO_0020017_uid", "IAO_0020017_PHYSIO_0000100_string_PHYSIO_0000100"
             from familyName
             returning *)
select *
from ins_Thing ins_Thing("IAO_0020017_uid")
         natural join ins_IAO_0020017_PHYSIO_0000100_string;

-- insert human name
with ins_HBW_0000022 AS (
    insert into "BW"."HBW_0000022" ("HBW_0000022_uid")
        values ('n1'), ('n2')
        returning *),
     ins_IAO_0020000 AS (
         insert into "BW"."IAO_0020000" ("IAO_0020000_uid")
             select "HBW_0000022_uid"
             from ins_HBW_0000022
             returning *),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IAO_0020000_uid"
             from ins_IAO_0020000
             returning *),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning *),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning *),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning *),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning *)
select *
from ins_Thing;

-- Insertions for the association between the family name and the human name
insert into "BW"."HBW_0000022_BFO_0000051_IAO_0020017"("HBW_0000022_uid", "IAO_0020017_uid")
values ('n1', 'nm1'),
       ('n2', 'nm2');

-- Insertions for the association between the personal name and the human name
insert into "BW"."HBW_0000022_BFO_0000051_IAO_0020015"("HBW_0000022_uid", "IAO_0020015_uid")
values ('n1', 'pn1'),
       ('n2', 'pn2');

-- *****************************************************************************
-- Insertions pour Disjonction
-- *****************************************************************************

-- Insertions d'une information qu'on ne peut différencier d'un biological sex datum ou d'un gender identity ice
with ins_HBW_0000025 AS (
    insert into "BW"."HBW_0000025" ("HBW_0000025_uid")
        values ('ice2')
        returning "HBW_0000025_uid"),
     ins_IOIO_0000012 AS (
         insert into "BW"."IOIO_0000012" ("IOIO_0000012_uid")
             select "HBW_0000025_uid"
             from ins_HBW_0000025
             returning "IOIO_0000012_uid"),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IOIO_0000012_uid"
             from ins_IOIO_0000012
             returning "IAO_0000030_uid"),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning "BFO_0000031_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- Insertions pour un female datum
with ins_VO_0004895 AS (
    insert into "BW"."VO_0004895" ("VO_0004895_uid")
        values ('ice1')
        returning "VO_0004895_uid"),
     ins_VO_0001194 AS (
         insert into "BW"."VO_0001194" ("VO_0001194_uid")
             select "VO_0004895_uid"
             from ins_VO_0004895
             returning "VO_0001194_uid"),
     ins_HBW_0000025 AS (
         insert into "BW"."HBW_0000025" ("HBW_0000025_uid")
             select "VO_0001194_uid"
             from ins_VO_0001194
             returning "HBW_0000025_uid"),
     ins_IAO_0000109 AS (
         insert into "BW"."IAO_0000109" ("IAO_0000109_uid")
             select "HBW_0000025_uid"
             from ins_HBW_0000025
             returning "IAO_0000109_uid"),
     ins_IAO_0000027 AS (
         insert into "BW"."IAO_0000027" ("IAO_0000027_uid")
             select "IAO_0000109_uid"
             from ins_IAO_0000109
             returning "IAO_0000027_uid"),
     ins_IOIO_0000012 AS (
         insert into "BW"."IOIO_0000012" ("IOIO_0000012_uid")
             select "HBW_0000025_uid"
             from ins_HBW_0000025
             returning "IOIO_0000012_uid"),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IOIO_0000012_uid"
             from ins_IOIO_0000012
             returning "IAO_0000030_uid"),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning "BFO_0000031_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- Insertions pour un female gender identity ICE
with ins_OMRSE_00000210 AS (
    insert into "BW"."OMRSE_00000210" ("OMRSE_00000210_uid")
        values ('ice3')
        returning "OMRSE_00000210_uid"),
     ins_OMRSE_00000209 AS (
         insert into "BW"."OMRSE_00000209" ("OMRSE_00000209_uid")
             select "OMRSE_00000210_uid"
             from ins_OMRSE_00000210
             returning "OMRSE_00000209_uid"),
     ins_OMRSE_00000204 AS (
         insert into "BW"."OMRSE_00000204" ("OMRSE_00000204_uid")
             select "OMRSE_00000209_uid"
             from ins_OMRSE_00000209
             returning "OMRSE_00000204_uid"),
     ins_IOIO_0000012 AS (
         insert into "BW"."IOIO_0000012" ("IOIO_0000012_uid")
             select "OMRSE_00000204_uid"
             from ins_OMRSE_00000204
             returning "IOIO_0000012_uid"),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IOIO_0000012_uid"
             from ins_IOIO_0000012
             returning "IAO_0000030_uid"),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning "BFO_0000031_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- Insertions pour un intersex datum
with ins_VO_0004896 AS (
    insert into "BW"."VO_0004896" ("VO_0004896_uid")
        values ('ice4')
        returning "VO_0004896_uid"),
     ins_VO_0001194 AS (
         insert into "BW"."VO_0001194" ("VO_0001194_uid")
             select "VO_0004896_uid"
             from ins_VO_0004896
             returning "VO_0001194_uid"),
     ins_IOIO_0000012 AS (
         insert into "BW"."IOIO_0000012" ("IOIO_0000012_uid")
             select "VO_0001194_uid"
             from ins_VO_0001194
             returning "IOIO_0000012_uid"),
     ins_IAO_0000109 AS (
         insert into "BW"."IAO_0000109" ("IAO_0000109_uid")
             select "VO_0001194_uid"
             from ins_VO_0001194
             returning "IAO_0000109_uid"),
     ins_IAO_0000027 AS (
         insert into "BW"."IAO_0000027" ("IAO_0000027_uid")
             select "IAO_0000109_uid"
             from ins_IAO_0000109
             returning "IAO_0000027_uid"),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IOIO_0000012_uid"
             from ins_IOIO_0000012
             returning "IAO_0000030_uid"),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning "BFO_0000031_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- Insertions pour un non-binary identity ICE
with ins_OMRSE_00000212 AS (
    insert into "BW"."OMRSE_00000212" ("OMRSE_00000212_uid")
        values ('ice5')
        returning "OMRSE_00000212_uid"),
     ins_OMRSE_00000209 AS (
         insert into "BW"."OMRSE_00000209" ("OMRSE_00000209_uid")
             select "OMRSE_00000212_uid"
             from ins_OMRSE_00000212
             returning "OMRSE_00000209_uid"),
     ins_IOIO_0000012 AS (
         insert into "BW"."IOIO_0000012" ("IOIO_0000012_uid")
             select "OMRSE_00000209_uid"
             from ins_OMRSE_00000209
             returning "IOIO_0000012_uid"),
     ins_OMRSE_00000204 AS (
         insert into "BW"."OMRSE_00000204" ("OMRSE_00000204_uid")
             select "OMRSE_00000209_uid"
             from ins_OMRSE_00000209
             returning "OMRSE_00000204_uid"),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IOIO_0000012_uid"
             from ins_IOIO_0000012
             returning "IAO_0000030_uid"),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning "BFO_0000031_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- *****************************************************************************
-- Insertions pour Conjonction de disjonction
-- *****************************************************************************

-- Insertion des instances de physiological evaluation
with ins_HBW_0000012 AS (
    insert into "BW"."HBW_0000012" ("HBW_0000012_uid")
        values ('eva1'), ('eva2')
        returning "HBW_0000012_uid"),
     ins_OBI_0000011 AS (
         insert into "BW"."OBI_0000011" ("OBI_0000011_uid")
             select "HBW_0000012_uid"
             from ins_HBW_0000012
             returning "OBI_0000011_uid"),
     ins_BFO_0000015 AS (
         insert into "BW"."BFO_0000015" ("BFO_0000015_uid")
             select "OBI_0000011_uid"
             from ins_OBI_0000011
             returning "BFO_0000015_uid"),
     ins_BFO_0000003 AS (
         insert into "BW"."BFO_0000003" ("BFO_0000003_uid")
             select "BFO_0000015_uid"
             from ins_BFO_0000015
             returning "BFO_0000003_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000003_uid"
             from ins_BFO_0000003
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- Insertion des instances des output
with ins_ONTORELA_C61c354fb AS (
    insert into "BW"."ONTORELA_C61c354fb" ("ONTORELA_C61c354fb_uid")
        values ('out1'), ('out2')
        returning "ONTORELA_C61c354fb_uid"),
     ins_IAO_0000027 AS (
         insert into "BW"."IAO_0000027" ("IAO_0000027_uid")
             select "ONTORELA_C61c354fb_uid"
             from ins_ONTORELA_C61c354fb
             returning "IAO_0000027_uid"),
     ins_IAO_0000030 AS (
         insert into "BW"."IAO_0000030" ("IAO_0000030_uid")
             select "IAO_0000027_uid"
             from ins_IAO_0000027
             returning "IAO_0000030_uid"),
     ins_BFO_0000031 AS (
         insert into "BW"."BFO_0000031" ("BFO_0000031_uid")
             select "IAO_0000030_uid"
             from ins_IAO_0000030
             returning "BFO_0000031_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000031_uid"
             from ins_BFO_0000031
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- Insertion des instances de body weight
with ins_HBW_0000009 AS (
    insert into "BW"."HBW_0000009" ("HBW_0000009_uid")
        values ('bow1'), ('bow2')
        returning "HBW_0000009_uid"),
     ins_BFO_0000019 AS (
         insert into "BW"."BFO_0000019" ("BFO_0000019_uid")
             select "HBW_0000009_uid"
             from ins_HBW_0000009
             returning "BFO_0000019_uid"),
     ins_BFO_0000020 AS (
         insert into "BW"."BFO_0000020" ("BFO_0000020_uid")
             select "BFO_0000019_uid"
             from ins_BFO_0000019
             returning "BFO_0000020_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000020_uid"
             from ins_BFO_0000020
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     "ins_ONTORELA_C2986e108-el0" AS (
         insert into "BW"."ONTORELA_C2986e108-el0" ("ONTORELA_C2986e108-el0_uid")
             select "BFO_0000019_uid"
             from ins_BFO_0000019
             returning "ONTORELA_C2986e108-el0_uid"),
     ins_ONTORELA_C2986e108 AS (
         insert into "BW"."ONTORELA_C2986e108" ("ONTORELA_C2986e108_uid")
             select "ONTORELA_C2986e108-el0_uid"
             from "ins_ONTORELA_C2986e108-el0"
             returning "ONTORELA_C2986e108_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- Insertion des instances de organism
with ins_OBI_0100026 AS (
    insert into "BW"."OBI_0100026" ("OBI_0100026_uid")
        values ('org1'), ('org2')
        returning "OBI_0100026_uid"),
     ins_BFO_0000040 AS (
         insert into "BW"."BFO_0000040" ("BFO_0000040_uid")
             select "OBI_0100026_uid"
             from ins_OBI_0100026
             returning "BFO_0000040_uid"),
     ins_BFO_0000004 AS (
         insert into "BW"."BFO_0000004" ("BFO_0000004_uid")
             select "BFO_0000040_uid"
             from ins_BFO_0000040
             returning "BFO_0000004_uid"),
     ins_BFO_0000002 AS (
         insert into "BW"."BFO_0000002" ("BFO_0000002_uid")
             select "BFO_0000004_uid"
             from ins_BFO_0000004
             returning "BFO_0000002_uid"),
     ins_BFO_0000001 AS (
         insert into "BW"."BFO_0000001" ("BFO_0000001_uid")
             select "BFO_0000002_uid"
             from ins_BFO_0000002
             returning "BFO_0000001_uid"),
     ins_Thing AS (
         insert into "BW"."Thing" ("Thing_uid")
             select "BFO_0000001_uid"
             from ins_BFO_0000001
             returning "Thing_uid")
select *
from ins_Thing;

-- eva has_specified_output out
insert into "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb"("HBW_0000012_uid", "ONTORELA_C61c354fb_uid")
values ('eva1', 'out1'),
       ('eva2', 'out2');

-- out is about bow
insert into "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108"("ONTORELA_C61c354fb_uid", "ONTORELA_C2986e108_uid")
values ('out1', 'bow1'),
       ('out2', 'bow2');

-- bow inheres in org
insert into "BW"."ONTORELA_C2986e108_RO_0000052_OBI_0100026"("ONTORELA_C2986e108_uid", "OBI_0100026_uid")
values ('bow1', 'org1'),
       ('bow2', 'org2');

-- Insertions pour Héritage multiple
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

-- Données de tests pour Héritage disjoint
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

-- Insertion pour Héritage avec chevauchement
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

-- Insertion pour le cas de plusieurs signatures pour une classe
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

-- Insertion pour le cas de conjonction (en supposant que o1, o2 et o3 existent déjà)

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


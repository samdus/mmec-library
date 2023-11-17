/*
-- =========================================================================== A
-- Composant 05A-EXP_MAJForCoverage.sql
-- -----------------------------------------------------------------------------
Encodage : UTF-8, sans BOM; fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.4 à 15.2
Responsable : Samuel.Dussault@USherbrooke.ca
Version : 1.0.0a
Statut : en vigueur
-- =========================================================================== A
*/

/*
-- =========================================================================== B
-- Modifications du schéma et des données EXP de façon à couvrir les différents
-- cas d'individuation.
-- =========================================================================== B
*/

/*
-- =====
-- Ajout d'une table PERSONNE qui sert à regrouper les patients et les médecins.
-- =====
 */

create table "EXP"."PERSONNE"
(
    "ID_PERSONNE_EXT" varchar(10) primary key,
    "NOM"             varchar(50) not null,
    "PRENOM"          varchar(50) not null
);

insert into "EXP"."PERSONNE" ("ID_PERSONNE_EXT", "NOM", "PRENOM")
select "ID_PATIENT_EXT", "NOM", "PRENOM"
from "EXP"."PATIENT";

-- Les noms des médecins ayant un même identifiant que celui d'un patient seront écrasés par le
-- nom du patient. Ils seront considérés comme étant le même individu.
insert into "EXP"."PERSONNE" ("ID_PERSONNE_EXT", "NOM", "PRENOM")
select "ID_MEDECIN_EXT", "NOM", "PRENOM"
from "EXP"."MEDECIN"
where not exists (select
                  from "EXP"."PERSONNE"
                  where "ID_PERSONNE_EXT" = "ID_MEDECIN_EXT");

alter table "EXP"."PATIENT"
    drop column "NOM",
    drop column "PRENOM",
    add constraint "FK_PATIENT_PERSONNE" foreign key ("ID_PATIENT_EXT") references "EXP"."PERSONNE" ("ID_PERSONNE_EXT");

alter table "EXP"."MEDECIN"
    drop column "NOM",
    drop column "PRENOM",
    add constraint "FK_MEDECIN_PERSONNE" foreign key ("ID_MEDECIN_EXT") references "EXP"."PERSONNE" ("ID_PERSONNE_EXT");

-- Faire en sorte qu'un patient soit également un médecin
with "nb_patient_medecin_egaux" AS (select 1 as "nb_patient_medecin_egaux"),
     "premier_patient" as (select row_number() over (order by "ID_MEDECIN_EXT"), "ID_MEDECIN_EXT"
                           from "EXP"."MEDECIN"
                           limit (select nb_patient_medecin_egaux from "nb_patient_medecin_egaux")),
     "premier_med" as (select row_number() over (order by "ID_PATIENT_EXT"), "ID_PATIENT_EXT"
                       from "EXP"."PATIENT"
                       limit (select nb_patient_medecin_egaux from "nb_patient_medecin_egaux")),
     "med_patient" as (select "ID_MEDECIN_EXT", "ID_PATIENT_EXT"
                       from premier_med
                                natural join premier_patient),
     "med_update" as (
         update "EXP"."MEDECIN"
             set "ID_MEDECIN_EXT" = "ID_PATIENT_EXT"
             from "med_patient"
             where "MEDECIN"."ID_MEDECIN_EXT" = "med_patient"."ID_MEDECIN_EXT"
             returning "MEDECIN"."ID_MEDECIN_EXT"),
     "personne_delete" as (
         delete from "EXP"."PERSONNE"
             where "ID_PERSONNE_EXT" in (select "ID_MEDECIN_EXT"
                                         from "med_patient")
             returning "ID_PERSONNE_EXT"),
     "med_traitant_update" as (
         update "EXP"."MEDECIN_TRAITANT"
             set "ID_MEDECIN_EXT" = "med_patient"."ID_PATIENT_EXT"
             from "med_patient"
             where "MEDECIN_TRAITANT"."ID_MEDECIN_EXT" = "med_patient"."ID_MEDECIN_EXT"
             returning "MEDECIN_TRAITANT"."ID_MEDECIN_EXT"),
     "prescription_update" as (
         update "EXP"."PRESCRIPTION"
             set "ID_MEDECIN_EXT" = "med_patient"."ID_PATIENT_EXT"
             from "med_patient"
             where "PRESCRIPTION"."ID_MEDECIN_EXT" = "med_patient"."ID_MEDECIN_EXT"
             returning "PRESCRIPTION"."ID_MEDECIN_EXT")
select *
from med_update
union all
select *
from personne_delete
union all
select *
from med_traitant_update
union all
select *
from prescription_update;

-- Faire en sorte que le premier patient n'ait pas de dossier
with "patient_sans_dossier" AS (select *
                                from "EXP"."PATIENT"
                                order by "ID_PATIENT_EXT"
                                limit 1 offset 0)
delete from "EXP"."DOSSIER"
where "ID_PATIENT_EXT" = (select "ID_PATIENT_EXT" from "patient_sans_dossier");


/*
-- =========================================================================== Z
Contributeurs :
  (CK) Samuel.Dussault@USherbrooke.ca

Adresse, droits d’auteur et copyright :
 @copyright @@GRIIS_COPYRIGHT@@

 @licence @@GRIIS_LICENCE@@

 @version @@GRIIS_VERSION@@

Tâches projetées :

Tâches réalisées :
2023-10-03 (SD) : création initiale
-- -----------------------------------------------------------------------------
-- Fin de 05A-EXP_MAJForCoverage.sql
-- =========================================================================== Z
*/

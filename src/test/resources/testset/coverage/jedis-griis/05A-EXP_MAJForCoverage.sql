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
delete
from "EXP"."DOSSIER"
where "ID_PATIENT_EXT" = (select "ID_PATIENT_EXT" from "patient_sans_dossier");

-- Ajouter une colonne pour le sexe biologique et une autre pour l'identité de genre
-- On va considérer que la colonne "SEXE" est indistinguable d'un ou l'autre, selon une ancienne pratique
-- SEXE est toujours null si une des deux autres colonnes sont renseignées.

create type "EXP"."SEXE_OU_IDENTITE_GENRE" as enum ('M', 'F');
create type "EXP"."SEXE_BIO" as enum ('M', 'F', 'I');
create type "EXP"."IDENTITE_GENRE" as enum ('M', 'F', 'NB');

alter table "EXP"."PATIENT"
    alter column "SEXE" type "EXP"."SEXE_OU_IDENTITE_GENRE" using "SEXE"::"EXP"."SEXE_OU_IDENTITE_GENRE",
    add column "SEXE_BIO"       "EXP"."SEXE_BIO",
    add column "IDENTITE_GENRE" "EXP"."IDENTITE_GENRE",
    add constraint "CK_SEXE_BIO_IDENTITE_GENRE" check (
        "SEXE" is null or ("SEXE_BIO" is null and "IDENTITE_GENRE" is null)
        );

select distinct "SEXE"
from "EXP"."PATIENT";

-- On représente 15 cas de figure pour les combinaisons de sexe et d'identité de genre
-- On va considérer que les autres patients ont une valeur indistinguable pour le moment
with "sexe_m_identite_inconnue" as (select *, null as "S_OU_G", 'M' "S", null "G"
                                    from "EXP"."PATIENT"
                                    order by "ID_PATIENT_EXT"
                                    limit 1 offset 0),
     "sexe_f_identite_inconnue" as (select *, null, 'F', null
                                    from "EXP"."PATIENT"
                                    order by "ID_PATIENT_EXT"
                                    limit 1 offset 2),
     "sexe_i_identite_inconnue" as (select *, null, 'I', null
                                    from "EXP"."PATIENT"
                                    order by "ID_PATIENT_EXT"
                                    limit 1 offset 3),
     "sexe_m_identite_m" as (select *, null, 'M', 'M'
                             from "EXP"."PATIENT"
                             order by "ID_PATIENT_EXT"
                             limit 1 offset 4),
     "sexe_f_identite_f" as (select *, null, 'F', 'F'
                             from "EXP"."PATIENT"
                             order by "ID_PATIENT_EXT"
                             limit 1 offset 5),
     "sexe_m_identite_nb" as (select *, null, 'M', 'NB'
                              from "EXP"."PATIENT"
                              order by "ID_PATIENT_EXT"
                              limit 1 offset 6),
     "sexe_f_identite_nb" as (select *, null, 'F', 'NB'
                              from "EXP"."PATIENT"
                              order by "ID_PATIENT_EXT"
                              limit 1 offset 7),
     "sexe_i_identite_nb" as (select *, null, 'I', 'NB'
                              from "EXP"."PATIENT"
                              order by "ID_PATIENT_EXT"
                              limit 1 offset 8),
     "sexe_m_identite_f" as (select *, null, 'M', 'F'
                             from "EXP"."PATIENT"
                             order by "ID_PATIENT_EXT"
                             limit 1 offset 9),
     "sexe_f_identite_m" as (select *, null, 'F', 'M'
                             from "EXP"."PATIENT"
                             order by "ID_PATIENT_EXT"
                             limit 1 offset 10),
     "sexe_i_identite_m" as (select *, null, 'I', 'M'
                             from "EXP"."PATIENT"
                             order by "ID_PATIENT_EXT"
                             limit 1 offset 11),
     "sexe_i_identite_f" as (select *, null, 'I', 'F'
                             from "EXP"."PATIENT"
                             order by "ID_PATIENT_EXT"
                             limit 1 offset 12),
     "sexe_inconnue_identite_m" as (select *, null, null, 'M'
                                    from "EXP"."PATIENT"
                                    order by "ID_PATIENT_EXT"
                                    limit 1 offset 13),
     "sexe_inconnue_identite_f" as (select *, null, null, 'F'
                                    from "EXP"."PATIENT"
                                    order by "ID_PATIENT_EXT"
                                    limit 1 offset 14),
     "sexe_inconnue_identite_nb" as (select *, null, null, 'NB'
                                     from "EXP"."PATIENT"
                                     order by "ID_PATIENT_EXT"
                                     limit 1 offset 15),
     "a_changer" as (select *
                     from "sexe_m_identite_inconnue"
                     union
                     select *
                     from "sexe_f_identite_inconnue"
                     union
                     select *
                     from "sexe_i_identite_inconnue"
                     union
                     select *
                     from "sexe_m_identite_m"
                     union
                     select *
                     from "sexe_f_identite_f"
                     union
                     select *
                     from "sexe_m_identite_nb"
                     union
                     select *
                     from "sexe_f_identite_nb"
                     union
                     select *
                     from "sexe_i_identite_nb"
                     union
                     select *
                     from "sexe_m_identite_f"
                     union
                     select *
                     from "sexe_f_identite_m"
                     union
                     select *
                     from "sexe_i_identite_m"
                     union
                     select *
                     from "sexe_i_identite_f"
                     union
                     select *
                     from "sexe_inconnue_identite_m"
                     union
                     select *
                     from "sexe_inconnue_identite_f"
                     union
                     select *
                     from "sexe_inconnue_identite_nb")
update "EXP"."PATIENT"
set "SEXE"           = "a_changer"."S_OU_G"::"EXP"."SEXE_OU_IDENTITE_GENRE",
    "SEXE_BIO"       = "a_changer"."S"::"EXP"."SEXE_BIO",
    "IDENTITE_GENRE" = "a_changer"."G"::"EXP"."IDENTITE_GENRE"
from "a_changer"
where "PATIENT"."ID_PATIENT_EXT" = "a_changer"."ID_PATIENT_EXT";

-- Ajouter une code de vulnérabilité 7 (VIH/SIDA, hépatite-C) pour le patient 1
with echantillon as (select *
                     from (values ('P0000001', 5, 7, 0),
                                  ('P0000002', 0, 5, 0),
                                  ('P0000003', 0, 0, 5))
                              as e("ID_PATIENT_EXT", "CODE_VULN_1", "CODE_VULN_2", "CODE_VULN_3"))
update "EXP"."PATIENT"
set "CODE_VULN_1" = echantillon."CODE_VULN_1",
    "CODE_VULN_2" = echantillon."CODE_VULN_2",
    "CODE_VULN_3" = echantillon."CODE_VULN_3"
from echantillon
where "PATIENT"."ID_PATIENT_EXT" = echantillon."ID_PATIENT_EXT"
returning "PATIENT"."ID_PATIENT_EXT", "PATIENT"."CODE_VULN_1", "PATIENT"."CODE_VULN_2", "PATIENT"."CODE_VULN_3";

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

/*
Création des tables auxiliaires dans lesquelles le contenu des EXPortations
de production (PROD) seront stockées avant EXPortation. Elles sont également
utilisées par les EXPortations de développement (DEV) comme base avant
pseudo-anonymisation à la volée. Finalement, le script est aussi bine utilisé
pour la source (présumément un SGBD Oracle contenant les données d'Omnimed)
que pour la cible (présumément un SGPD PostgreSQL devant contenir les données
requises pour l'application Reflex-D).

Notes de mise en oeuvre
Initialement, le script a été développé en utilisant les mêmes types que la base
de données d'Omnimed. Lors de standardisation, qui visait à permettre l'utilisation
du même script pour l'EXPortation (depuis Oracle) et pour l'importation
(vers PostgreSQL), un seul type a été changé significativement :
l'attribut "EXP_PRESCRIPTION"."TEXT_DOSAGE" de type "CLOB" a été « réduit » à VARCHAR(255).
En pratique, en regard des données reçues, le plus long texte était étant de
173 caractères, cela ne devrait pas avoir d'impact.

Tous les identifiants se terminant par "_EXT" sont générés distinctement de
ceux d'Omnimed. Ils ont pour vocation à être utilisés par les applications
externes, telles Reflex_D, afin de ne pas révéler les identifiants de dossier
d'Omnimed ou de permettre des recoupement entre cliniques.

Les contraintes de clés ont été séparée dans des scripts distincts afin de
permettre la réception des données en provenance d'Omnimed et leur vérification.
Le script "EXP_coi.sql" contient les contraintes de clés internes (candidates,
primaires, secondaires, uniques) le fichier "EXP_coe.sql" les clés externes
(référentielles, étrangères).

@fixme 2019-06-02 [DC] Ce fichier est un duplicat du projet tiger-mapping-omnimed. Il faudrait créer un projet SQL commun pour éviter cette situation. 
FIXME 2019-03-03 [LL] Valider les attributs à pseudo-anonymiser (pa) pour DEV et PROD.
FIXED 2019-03-12 [LL,JFE,TE] Pseudo-anonymisation validée.
TODO 2019-03-20 [LL] Généraliser les identifiants externes
 * Sont encore manquants : ID_LABORATOIRE_EXT et ID_PRESCRIPTION_EXT
DONE 2019-03-20 [LL] Tous lesidentifiants sont externalisés
TOIMPROVE 2019-03-09 [LL] Certains types pourraient être plus compacts et précis (e.a.: DIN_CODE).
 * Devrait-on prendre le DIN comme identifiant externe des médicaments et retirer
 * ID_MEDICAMENT_EXT ?
*/

DROP SCHEMA IF EXISTS "EXP" CASCADE;
CREATE SCHEMA "EXP";

--
-- Tables
--

CREATE TABLE "EXP"."PATIENT" (
/*
Le patient dont son identifiant externe est "ID_PATIENT_EXT" porte le prenom "PRENOM" et
le nom "NOM". Il est née à une date de naissance "DATE_NAISSANCE" avec une caractéristique 
du sexe ou genre "SEXE". Le patient a une taille "TAILLE" en cm et un poid "POIDS" en kg.

Dans le dictionaire est defini que le "SEXE" du patient peut être :
-- A: Agender 
-- I: Intersex
-- F: Female 
-- M: Male.

Dans le contexte de ReflexD, nous n'utilisons que le code de vulnérabilité "CODE_VULN_1" avec le code 5,
les deux autres codes  "CODE_VULN_2" et "CODE_VULN_3" seront mis à zéro (pour le moment). 
Los codes de vulnérabilité sont deux chiffres (de 01 à 14) associés aux catégories de problèmes de santé 
reconnues et énnumérées au Québec. La description de chacun des codes est dans le lien suivant : 
https://www.ramq.gouv.qc.ca/SiteCollectionDocuments/professionnels/infolettres/2017/info171-7.pdf

*/
  "ID_PATIENT_EXT" VARCHAR(10) NOT NULL,
  "NOM" VARCHAR(24),                        -- pa : DEV et PROD
  "PRENOM" VARCHAR(24),                     -- pa : DEV et PROD
  "DATE_NAISSANCE" DATE,                    -- pa : DEV
  "SEXE" VARCHAR(1),                        -- pa : DEV
  "CODE_VULN_1" DECIMAL(11) NOT NULL,
  "CODE_VULN_2" DECIMAL(11) NOT NULL,
  "CODE_VULN_3" DECIMAL(11) NOT NULL,
  "POIDS" DECIMAL(11),
  "TAILLE" DECIMAL(11)
);

CREATE TABLE "EXP"."DOSSIER" (
/*
Une fois le patient "ID_PATIENT_EXT" est enrégistré dans la clinique, il obtiendra son numéro de dossier 
"ID_PATIENT_UUID" (Identifiant patient universel).
*/
  "ID_PATIENT_UUID" VARCHAR(255) NOT NULL,  -- pa : DEV
  "ID_PATIENT_EXT" VARCHAR(10) NOT NULL
);

CREATE TABLE "EXP"."MEDECIN" (
/*
Le clinicien dont son identifiant externe est "ID_MEDECIN_EXT" porte le nom, "NOM" et le 
prenom "PRENOM".

L'identifiant externe "ID_MEDECIN_EXT" doit débuter par un M et suivi de 7 chiffres.
*/
  "ID_MEDECIN_EXT" VARCHAR(10) NOT NULL,
  "NOM" VARCHAR(50),                        -- pa : DEV et PROD
  "PRENOM" VARCHAR(50)                      -- pa : DEV et PROD
);

CREATE TABLE "EXP"."MEDECIN_TRAITANT" (
/*
Le médecin identifié par "ID_MEDECIN_EXT" est responsable du suivit du patient identifié par "ID_PATIENT_EXT". 
*/
  "ID_PATIENT_EXT" VARCHAR(10) NOT NULL,
  "ID_MEDECIN_EXT" VARCHAR(10) NOT NULL
);

CREATE TABLE "EXP"."LABORATOIRE" (
/*
L'analyse d'un prélèvement "ID_LABORATOIRE_EXT" pour le patient identifié par "ID_PATIENT_EXT" a donné le résultat "VALEUR".
L'analyse prescrite "NOM_TEST" qui a été prélèvée à la date "DATE_PRELEVEMENT" a une valeur de référence "REF_LABO".
*/
  "ID_LABORATOIRE_EXT" VARCHAR(10) NOT NULL,
  "ID_PATIENT_EXT" VARCHAR(10) NOT NULL,
  "DATE_PRELEVEMENT" DATE NOT NULL,         -- pa : DEV
  "VALEUR" VARCHAR(200),
  "REF_LABO" VARCHAR(355),
  "NOM_TEST" VARCHAR(650) NOT NULL
);

CREATE TABLE "EXP"."MEDICAMENT" (
/*
Le médicament qui porte un nom "NOM_MEDICAMENT", un code din (Drug Identification Number ) "DIN_CODE",
un identifiant externe "ID_MEDICAMENT_EXT", avec une forme posologique "FORME", la force de l'ingrédient 
médicinal "FORCE" et la voie d'administration "ROUTE".

Le din code "DIN_CODE" est le numéro à 8 chiffres figurant sur l'étiquette des médicaments sur ordonnance 
et en vente libre qui ont été évalués par la Direction des produits thérapeutiques (DPT) et approuvés 
pour la vente au Canada.
*/
  "ID_MEDICAMENT_EXT" VARCHAR(10) NOT NULL,
  "NOM_MEDICAMENT" VARCHAR(255),
  "DIN_CODE" VARCHAR(255) NOT NULL,
  "FORME" VARCHAR(255),
  "FORCE" VARCHAR(255),
  "ROUTE" VARCHAR(255)
);

CREATE TABLE "EXP"."CLASSE_MEDICAMENT" (
/*
Un medicament "DIN_CODE" est classifié en classe de médicament avec le code ATC "ATC_CODE" de la classe.
*/
  "DIN_CODE" VARCHAR(255) NOT NULL,
  "ATC_CODE" VARCHAR(255) NOT NULL
);

CREATE TABLE "EXP"."PRESCRIPTION" (
/*
Une prescription "ID_PRESCRIPTION_EXT" est l'acte par lequel un professionnel de la santé "ID_MEDECIN_EXT" 
habilité ordonne des recommandations thérapeutiques "TEXT_DOSAGE" et des medicament "ID_MEDICAMENT_EXT" 
auprès d'un patient "ID_PATIENT_EXT". Le plan medical a une date de debut "DEBUT", mais pas nécessairement 
une date de fin "FIN".
*/
  "ID_PRESCRIPTION_EXT" VARCHAR(10) NOT NULL,
  "ID_PATIENT_EXT" VARCHAR(10) NOT NULL,
  "ID_MEDECIN_EXT" VARCHAR(10) NOT NULL,
  "ID_MEDICAMENT_EXT" VARCHAR(10) NOT NULL,
  "DEBUT" DATE NOT NULL,
  "FIN" DATE,
  "TEXT_DOSAGE" VARCHAR(255) -- le maximum observé est de 175 caractères
);

CREATE TABLE "EXP"."MEDICATION_SP" (
/*
Pendant une consultation "ID_CONSULTATION_EXT" à une date "MOMENT", le patient va déclarer le medicament
auto-rapporté "ID_MEDICAMENT_EXT" qu'il utilise.
*/
  "ID_CONSULTATION_EXT" VARCHAR(10) NOT NULL,
  "ID_MEDICAMENT_EXT" VARCHAR(10) NOT NULL,
  "MOMENT" TIMESTAMP(6) NOT NULL
);

CREATE TABLE "EXP"."CONSULTATION" (
/*
Une consultation médicale "ID_CONSULTATION_EXT" est définie par la rencontre entre un professionnel de la 
santé et un patient "ID_PATIENT_EXT" à une date "DATE_CONS par le medecin "ID_MEDECIN_EXT"". 
*/
  "ID_CONSULTATION_EXT" VARCHAR(10) NOT NULL,
  "ID_PATIENT_EXT" VARCHAR(10) NOT NULL,
  "DATE_CONS" DATE,
  "ID_MEDECIN_EXT" VARCHAR(10) NOT NULL
);

/* *-======================================================================-* */

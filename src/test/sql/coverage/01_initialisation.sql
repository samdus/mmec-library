---
-- =============================================================================
-- Création du schéma du mapping et du schéma de l'OntoRel
-- =============================================================================
create schema "MappingSchema";
create schema "BW";

-- =============================================================================
-- Création de l'extension uuid-ossp utilisé pour la génération des UUID
-- =============================================================================
create extension if not exists "uuid-ossp";

-- =============================================================================
-- Création des domaines
-- =============================================================================

-- uid_domain domain definition
CREATE DOMAIN "BW"."uid_domain" AS TEXT;

-- value_domain domain definition
CREATE DOMAIN "BW"."value_domain" AS TEXT;

-- boolean_domain domain definition
CREATE DOMAIN "BW"."boolean_domain" AS BOOLEAN;

-- langString_domain domain definition
CREATE DOMAIN "BW"."langString_domain" AS TEXT;

-- string_domain domain definition
CREATE DOMAIN "BW"."string_domain" AS TEXT;

-- decimal_domain domain definition
CREATE DOMAIN "BW"."decimal_domain" AS DECIMAL;

-- =============================================================================
-- Création des fonctions d'individuation
-- =============================================================================
create or replace function "MappingSchema"."getBaseUUID"()
    returns uuid
    language sql
    immutable strict
return '98208a37-f4c8-405b-a196-cf33cfcb1ac2'::uuid;

create or replace function "MappingSchema"."individuation"(i_signature_id varchar, i_int integer)
    returns uuid
    language sql
    immutable strict
return "public"."uuid_generate_v5"("public"."uuid_generate_v5"("MappingSchema"."getBaseUUID"(), i_signature_id), i_int::text);

create or replace function "MappingSchema"."individuation"(i_signature_id varchar, i_num numeric)
    returns uuid
    language sql
    immutable strict
return "public"."uuid_generate_v5"("public"."uuid_generate_v5"("MappingSchema"."getBaseUUID"(), i_signature_id), i_num::text);

create or replace function "MappingSchema"."individuation"(i_signature_id varchar, i_varchar character varying)
    returns uuid
    language sql
    immutable strict
return "public"."uuid_generate_v5"("public"."uuid_generate_v5"("MappingSchema"."getBaseUUID"(), i_signature_id), i_varchar);

create or replace function "MappingSchema"."individuation"(i_signature_id varchar, i_int_1 integer, i_int_2 integer)
    returns uuid
    language sql
    immutable strict
return "public"."uuid_generate_v5"("MappingSchema"."individuation"(i_signature_id, i_int_1), i_int_2::text);

create or replace function "MappingSchema"."individuation"(i_signature_id varchar, i_varchar_1 varchar, i_varchar_2 varchar)
    returns uuid
    language sql
    immutable strict
return "public"."uuid_generate_v5"("MappingSchema"."individuation"(i_signature_id, i_varchar_1), i_varchar_2);

create or replace function "MappingSchema"."individuation"(i_signature_id varchar, i_sexe "EXP"."SEXE_BIO")
    returns uuid
    language sql
    immutable strict
return "public"."uuid_generate_v5"("public"."uuid_generate_v5"("MappingSchema"."getBaseUUID"(), i_signature_id), i_sexe::text);

create or replace function "MappingSchema"."individuation"(i_signature_id varchar, i_genre "EXP"."IDENTITE_GENRE")
    returns uuid
    language sql
    immutable strict
return "public"."uuid_generate_v5"("public"."uuid_generate_v5"("MappingSchema"."getBaseUUID"(), i_signature_id), i_genre::text);

create or replace function "MappingSchema"."individuation"(i_signature_id varchar, i_sexgenre "EXP"."SEXE_OU_IDENTITE_GENRE")
    returns uuid
    language sql
    immutable strict
return "public"."uuid_generate_v5"("public"."uuid_generate_v5"("MappingSchema"."getBaseUUID"(), i_signature_id), i_sexgenre::text);

-- =============================================================================
-- Création des fonctions de conversion
-- =============================================================================
create or replace function "MappingSchema"."convertTextToBWString"(i_text text)
    returns "BW"."string_domain"
    language sql
    immutable strict
return i_text;

create or replace function "MappingSchema"."v_convertTextToBWString"(i_text text)
    returns boolean
    language sql
    immutable strict
return i_text is not null;

-- =============================================================================
-- Changement du search_path en prévision de l'exécution de l'artefact d'arrimage
-- =============================================================================
set search_path to "MappingSchema";
CREATE SCHEMA IF NOT EXISTS "BW";

COMMENT ON SCHEMA "BW" IS 'Schéma BW créé le 20240313-1437';

-- uid_domain domain definition
CREATE DOMAIN "BW"."uid_domain" AS TEXT;

-- value_domain domain definition
CREATE DOMAIN "BW"."value_domain" AS TEXT;

-- Literal domain definition
CREATE DOMAIN "BW"."Literal" AS TEXT;

-- boolean domain definition
CREATE DOMAIN "BW"."boolean" AS BOOLEAN;

-- langString domain definition
CREATE DOMAIN "BW"."langString" AS TEXT;

-- string domain definition
CREATE DOMAIN "BW"."string" AS TEXT;

-- double domain definition
CREATE DOMAIN "BW"."double" AS DOUBLE PRECISION;

-- decimal domain definition
CREATE DOMAIN "BW"."decimal" AS DECIMAL;

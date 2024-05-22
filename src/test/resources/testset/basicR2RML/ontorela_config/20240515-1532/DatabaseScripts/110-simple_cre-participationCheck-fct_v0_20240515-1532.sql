/*
-- =========================================================================== A
Schema : simple
Creation Date : 20240515-1532
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Create check participation functions
-- =========================================================================== A
*/

-- Minimum participation ckeck on : T75162af000
CREATE OR REPLACE FUNCTION "simple"."T75162af000_checkParticipationMin"("_T29732e8200_uid" "simple"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "simple"."T75162af000"
      WHERE "T29732e8200_uid" = "_T29732e8200_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'T75162af000', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : T75162af000
CREATE OR REPLACE FUNCTION "simple"."T75162af000_checkParticipationMax"("_T29732e8200_uid" "simple"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "simple"."T75162af000"
      WHERE "T29732e8200_uid" = "_T29732e8200_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'T75162af000', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : T7f06a14e00
CREATE OR REPLACE FUNCTION "simple"."T7f06a14e00_checkParticipationMin"("_T305deffb00_uid" "simple"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "simple"."T7f06a14e00"
      WHERE "T305deffb00_uid" = "_T305deffb00_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'T7f06a14e00', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : T3801380400
CREATE OR REPLACE FUNCTION "simple"."T3801380400_checkParticipationMin"("_T4f2a1ef000_uid" "simple"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "simple"."T3801380400"
      WHERE "T4f2a1ef000_uid" = "_T4f2a1ef000_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'T3801380400', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';


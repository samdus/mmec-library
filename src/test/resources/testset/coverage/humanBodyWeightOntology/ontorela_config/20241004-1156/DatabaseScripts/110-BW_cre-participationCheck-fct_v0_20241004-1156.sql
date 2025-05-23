/*
-- =========================================================================== A
Schema : BW
Creation Date : 20241004-1156
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Create check participation functions
-- =========================================================================== A
*/

-- Minimum participation ckeck on : IAO_0000032_IAO_0000004_decimal
CREATE OR REPLACE FUNCTION "BW"."IAO_0000032_IAO_0000004_decimal_checkParticipationMin"("_IAO_0000032_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000032_IAO_0000004_decimal"
      WHERE "IAO_0000032_uid" = "_IAO_0000032_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0000032_IAO_0000004_decimal', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : IAO_0000032_IAO_0000004_decimal
CREATE OR REPLACE FUNCTION "BW"."IAO_0000032_IAO_0000004_decimal_checkParticipationMax"("_IAO_0000032_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000032_IAO_0000004_decimal"
      WHERE "IAO_0000032_uid" = "_IAO_0000032_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'IAO_0000032_IAO_0000004_decimal', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0020015_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."IAO_0020015_PHYSIO_0000100_string_checkParticipationMin"("_IAO_0020015_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0020015_PHYSIO_0000100_string"
      WHERE "IAO_0020015_uid" = "_IAO_0020015_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0020015_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : IAO_0020015_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."IAO_0020015_PHYSIO_0000100_string_checkParticipationMax"("_IAO_0020015_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0020015_PHYSIO_0000100_string"
      WHERE "IAO_0020015_uid" = "_IAO_0020015_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'IAO_0020015_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000026_IAO_0000004_decimal
CREATE OR REPLACE FUNCTION "BW"."HBW_0000026_IAO_0000004_decimal_checkParticipationMin"("_HBW_0000026_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000026_IAO_0000004_decimal"
      WHERE "HBW_0000026_uid" = "_HBW_0000026_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000026_IAO_0000004_decimal', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0000577_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."IAO_0000577_PHYSIO_0000100_string_checkParticipationMin"("_IAO_0000577_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000577_PHYSIO_0000100_string"
      WHERE "IAO_0000577_uid" = "_IAO_0000577_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0000577_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : IAO_0000577_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."IAO_0000577_PHYSIO_0000100_string_checkParticipationMax"("_IAO_0000577_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000577_PHYSIO_0000100_string"
      WHERE "IAO_0000577_uid" = "_IAO_0000577_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'IAO_0000577_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0000003_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."IAO_0000003_PHYSIO_0000100_string_checkParticipationMin"("_IAO_0000003_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000003_PHYSIO_0000100_string"
      WHERE "IAO_0000003_uid" = "_IAO_0000003_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0000003_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : IAO_0000003_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."IAO_0000003_PHYSIO_0000100_string_checkParticipationMax"("_IAO_0000003_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000003_PHYSIO_0000100_string"
      WHERE "IAO_0000003_uid" = "_IAO_0000003_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'IAO_0000003_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0020017_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."IAO_0020017_PHYSIO_0000100_string_checkParticipationMin"("_IAO_0020017_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0020017_PHYSIO_0000100_string"
      WHERE "IAO_0020017_uid" = "_IAO_0020017_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0020017_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : IAO_0020017_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."IAO_0020017_PHYSIO_0000100_string_checkParticipationMax"("_IAO_0020017_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0020017_PHYSIO_0000100_string"
      WHERE "IAO_0020017_uid" = "_IAO_0020017_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'IAO_0020017_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000002_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."HBW_0000002_PHYSIO_0000100_string_checkParticipationMin"("_HBW_0000002_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000002_PHYSIO_0000100_string"
      WHERE "HBW_0000002_uid" = "_HBW_0000002_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000002_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : HBW_0000002_PHYSIO_0000100_string
CREATE OR REPLACE FUNCTION "BW"."HBW_0000002_PHYSIO_0000100_string_checkParticipationMax"("_HBW_0000002_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000002_PHYSIO_0000100_string"
      WHERE "HBW_0000002_uid" = "_HBW_0000002_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'HBW_0000002_PHYSIO_0000100_string', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0000032_IAO_0000039_IAO_0000003
CREATE OR REPLACE FUNCTION "BW"."IAO_0000032_IAO_0000039_IAO_0000003_checkParticipationMin"("_IAO_0000032_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000032_IAO_0000039_IAO_0000003"
      WHERE "IAO_0000032_uid" = "_IAO_0000032_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0000032_IAO_0000039_IAO_0000003', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000013_PHYSIO_0000089_HBW_0000008
CREATE OR REPLACE FUNCTION "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008_checkParticipationMin"("_HBW_0000013_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008"
      WHERE "HBW_0000013_uid" = "_HBW_0000013_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000013_PHYSIO_0000089_HBW_0000008', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : HBW_0000013_PHYSIO_0000089_HBW_0000008
CREATE OR REPLACE FUNCTION "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008_checkParticipationMax"("_HBW_0000013_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000013_PHYSIO_0000089_HBW_0000008"
      WHERE "HBW_0000013_uid" = "_HBW_0000013_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'HBW_0000013_PHYSIO_0000089_HBW_0000008', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0000109_IAO_0000039_IAO_0000003
CREATE OR REPLACE FUNCTION "BW"."IAO_0000109_IAO_0000039_IAO_0000003_checkParticipationMin"("_IAO_0000109_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000109_IAO_0000039_IAO_0000003"
      WHERE "IAO_0000109_uid" = "_IAO_0000109_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0000109_IAO_0000039_IAO_0000003', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : IAO_0000109_IAO_0000039_IAO_0000003
CREATE OR REPLACE FUNCTION "BW"."IAO_0000109_IAO_0000039_IAO_0000003_checkParticipationMax"("_IAO_0000109_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000109_IAO_0000039_IAO_0000003"
      WHERE "IAO_0000109_uid" = "_IAO_0000109_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'IAO_0000109_IAO_0000039_IAO_0000003', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000029_BFO_0000051_HBW_0000002
CREATE OR REPLACE FUNCTION "BW"."HBW_0000029_BFO_0000051_HBW_0000002_checkParticipationMin"("_HBW_0000029_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000029_BFO_0000051_HBW_0000002"
      WHERE "HBW_0000029_uid" = "_HBW_0000029_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000029_BFO_0000051_HBW_0000002', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : HBW_0000029_BFO_0000051_HBW_0000002
CREATE OR REPLACE FUNCTION "BW"."HBW_0000029_BFO_0000051_HBW_0000002_checkParticipationMax"("_HBW_0000029_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000029_BFO_0000051_HBW_0000002"
      WHERE "HBW_0000029_uid" = "_HBW_0000029_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'HBW_0000029_BFO_0000051_HBW_0000002', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000029_BFO_0000051_HBW_0000006
CREATE OR REPLACE FUNCTION "BW"."HBW_0000029_BFO_0000051_HBW_0000006_checkParticipationMin"("_HBW_0000029_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000029_BFO_0000051_HBW_0000006"
      WHERE "HBW_0000029_uid" = "_HBW_0000029_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000029_BFO_0000051_HBW_0000006', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : HBW_0000029_BFO_0000051_HBW_0000006
CREATE OR REPLACE FUNCTION "BW"."HBW_0000029_BFO_0000051_HBW_0000006_checkParticipationMax"("_HBW_0000029_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000029_BFO_0000051_HBW_0000006"
      WHERE "HBW_0000029_uid" = "_HBW_0000029_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'HBW_0000029_BFO_0000051_HBW_0000006', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : BFO_0000003_RO_0000057_BFO_0000002
CREATE OR REPLACE FUNCTION "BW"."BFO_0000003_RO_0000057_BFO_0000002_checkParticipationMin"("_BFO_0000003_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."BFO_0000003_RO_0000057_BFO_0000002"
      WHERE "BFO_0000003_uid" = "_BFO_0000003_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'BFO_0000003_RO_0000057_BFO_0000002', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007
CREATE OR REPLACE FUNCTION "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007_checkParticipationMin"("_ONTORELA_C4d0c3f45_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007"
      WHERE "ONTORELA_C4d0c3f45_uid" = "_ONTORELA_C4d0c3f45_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000026_IAO_0000039_HBW_0000003
CREATE OR REPLACE FUNCTION "BW"."HBW_0000026_IAO_0000039_HBW_0000003_checkParticipationMin"("_HBW_0000026_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000026_IAO_0000039_HBW_0000003"
      WHERE "HBW_0000026_uid" = "_HBW_0000026_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000026_IAO_0000039_HBW_0000003', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000022_BFO_0000051_IAO_0020015
CREATE OR REPLACE FUNCTION "BW"."HBW_0000022_BFO_0000051_IAO_0020015_checkParticipationMin"("_HBW_0000022_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000022_BFO_0000051_IAO_0020015"
      WHERE "HBW_0000022_uid" = "_HBW_0000022_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000022_BFO_0000051_IAO_0020015', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000022_BFO_0000051_IAO_0020017
CREATE OR REPLACE FUNCTION "BW"."HBW_0000022_BFO_0000051_IAO_0020017_checkParticipationMin"("_HBW_0000022_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000022_BFO_0000051_IAO_0020017"
      WHERE "HBW_0000022_uid" = "_HBW_0000022_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000022_BFO_0000051_IAO_0020017', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000022_IAO_0000219_NCBITaxon_9606
CREATE OR REPLACE FUNCTION "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606_checkParticipationMin"("_HBW_0000022_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000022_IAO_0000219_NCBITaxon_9606"
      WHERE "HBW_0000022_uid" = "_HBW_0000022_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000022_IAO_0000219_NCBITaxon_9606', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45
CREATE OR REPLACE FUNCTION "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45_checkParticipationMin"("_HBW_0000006_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"
      WHERE "HBW_0000006_uid" = "_HBW_0000006_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45
CREATE OR REPLACE FUNCTION "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45_checkParticipationMax"("_HBW_0000006_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"
      WHERE "HBW_0000006_uid" = "_HBW_0000006_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0000030_IAO_0000136_BFO_0000001
CREATE OR REPLACE FUNCTION "BW"."IAO_0000030_IAO_0000136_BFO_0000001_checkParticipationMin"("_IAO_0000030_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000030_IAO_0000136_BFO_0000001"
      WHERE "IAO_0000030_uid" = "_IAO_0000030_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0000030_IAO_0000136_BFO_0000001', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0000030_IAO_0000219_BFO_0000001
CREATE OR REPLACE FUNCTION "BW"."IAO_0000030_IAO_0000219_BFO_0000001_checkParticipationMin"("_IAO_0000030_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0000030_IAO_0000219_BFO_0000001"
      WHERE "IAO_0000030_uid" = "_IAO_0000030_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0000030_IAO_0000219_BFO_0000001', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108
CREATE OR REPLACE FUNCTION "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108_checkParticipationMin"("_ONTORELA_C61c354fb_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108"
      WHERE "ONTORELA_C61c354fb_uid" = "_ONTORELA_C61c354fb_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000007_RO_0000087_HBW_0000011
CREATE OR REPLACE FUNCTION "BW"."HBW_0000007_RO_0000087_HBW_0000011_checkParticipationMin"("_HBW_0000007_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000007_RO_0000087_HBW_0000011"
      WHERE "HBW_0000007_uid" = "_HBW_0000007_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000007_RO_0000087_HBW_0000011', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : ONTORELA_C2986e108_RO_0000052_OBI_0100026
CREATE OR REPLACE FUNCTION "BW"."ONTORELA_C2986e108_RO_0000052_OBI_0100026_checkParticipationMin"("_ONTORELA_C2986e108_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."ONTORELA_C2986e108_RO_0000052_OBI_0100026"
      WHERE "ONTORELA_C2986e108_uid" = "_ONTORELA_C2986e108_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'ONTORELA_C2986e108_RO_0000052_OBI_0100026', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : IAO_0020000_IAO_0000219_BFO_0000001
CREATE OR REPLACE FUNCTION "BW"."IAO_0020000_IAO_0000219_BFO_0000001_checkParticipationMin"("_IAO_0020000_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."IAO_0020000_IAO_0000219_BFO_0000001"
      WHERE "IAO_0020000_uid" = "_IAO_0020000_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'IAO_0020000_IAO_0000219_BFO_0000001', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000004_IAO_0000136_OBI_0100026
CREATE OR REPLACE FUNCTION "BW"."HBW_0000004_IAO_0000136_OBI_0100026_checkParticipationMin"("_HBW_0000004_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000004_IAO_0000136_OBI_0100026"
      WHERE "HBW_0000004_uid" = "_HBW_0000004_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000004_IAO_0000136_OBI_0100026', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000012_PHYSIO_0000089_NCBITaxon_9606
CREATE OR REPLACE FUNCTION "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606_checkParticipationMin"("_HBW_0000012_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"
      WHERE "HBW_0000012_uid" = "_HBW_0000012_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000012_PHYSIO_0000089_NCBITaxon_9606', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : HBW_0000012_PHYSIO_0000089_NCBITaxon_9606
CREATE OR REPLACE FUNCTION "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606_checkParticipationMax"("_HBW_0000012_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"
      WHERE "HBW_0000012_uid" = "_HBW_0000012_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'HBW_0000012_PHYSIO_0000089_NCBITaxon_9606', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000012_OBI_0000299_ONTORELA_C61c354fb
CREATE OR REPLACE FUNCTION "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb_checkParticipationMin"("_HBW_0000012_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000012_OBI_0000299_ONTORELA_C61c354fb"
      WHERE "HBW_0000012_uid" = "_HBW_0000012_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000012_OBI_0000299_ONTORELA_C61c354fb', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : BFO_0000004_RO_0000087_BFO_0000023
CREATE OR REPLACE FUNCTION "BW"."BFO_0000004_RO_0000087_BFO_0000023_checkParticipationMin"("_BFO_0000004_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."BFO_0000004_RO_0000087_BFO_0000023"
      WHERE "BFO_0000004_uid" = "_BFO_0000004_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'BFO_0000004_RO_0000087_BFO_0000023', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000008_RO_0000087_HBW_0000010
CREATE OR REPLACE FUNCTION "BW"."HBW_0000008_RO_0000087_HBW_0000010_checkParticipationMin"("_HBW_0000008_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000008_RO_0000087_HBW_0000010"
      WHERE "HBW_0000008_uid" = "_HBW_0000008_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000008_RO_0000087_HBW_0000010', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000028_BFO_0000051_HBW_0000006
CREATE OR REPLACE FUNCTION "BW"."HBW_0000028_BFO_0000051_HBW_0000006_checkParticipationMin"("_HBW_0000028_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000028_BFO_0000051_HBW_0000006"
      WHERE "HBW_0000028_uid" = "_HBW_0000028_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000028_BFO_0000051_HBW_0000006', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : HBW_0000028_BFO_0000051_HBW_0000006
CREATE OR REPLACE FUNCTION "BW"."HBW_0000028_BFO_0000051_HBW_0000006_checkParticipationMax"("_HBW_0000028_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000028_BFO_0000051_HBW_0000006"
      WHERE "HBW_0000028_uid" = "_HBW_0000028_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'HBW_0000028_BFO_0000051_HBW_0000006', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Minimum participation ckeck on : HBW_0000028_BFO_0000051_IOIO_0000012
CREATE OR REPLACE FUNCTION "BW"."HBW_0000028_BFO_0000051_IOIO_0000012_checkParticipationMin"("_HBW_0000028_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000028_BFO_0000051_IOIO_0000012"
      WHERE "HBW_0000028_uid" = "_HBW_0000028_uid"
    ) >= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect minimum value %', 'HBW_0000028_BFO_0000051_IOIO_0000012', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';

-- Maximum participqtion ckeck on : HBW_0000028_BFO_0000051_IOIO_0000012
CREATE OR REPLACE FUNCTION "BW"."HBW_0000028_BFO_0000051_IOIO_0000012_checkParticipationMax"("_HBW_0000028_uid" "BW"."uid_domain")
  RETURNS BOOLEAN AS
$$
BEGIN
  IF
  (
    (
      SELECT COUNT(*)
      FROM "BW"."HBW_0000028_BFO_0000051_IOIO_0000012"
      WHERE "HBW_0000028_uid" = "_HBW_0000028_uid"
    ) <= 1
  )
  THEN
    RETURN TRUE;
  ELSE
    RAISE NOTICE 'Participation  %  does not respect maximal value %', 'HBW_0000028_BFO_0000051_IOIO_0000012', 1;
    RETURN FALSE;
  END IF;
END;
$$
LANGUAGE 'plpgsql';


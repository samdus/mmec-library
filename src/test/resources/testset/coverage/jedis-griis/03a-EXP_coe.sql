/*
Ajout des contraintes externes au schéma EXP.

Il est suggéré d'exécuter ce fichier après l'exportation au titre de vérification.

@fixme 2019-06-02 [DC] Ce fichier est un duplicat du projet tiger-mapping-omnimed. Il faudrait créer un projet SQL commun pour éviter cette situation. 
TOIMPROVE 2019-06-07 [LL] Définir les clés référentielles du schéma EXP
*/

ALTER TABLE "EXP"."CONSULTATION"
ADD FOREIGN KEY ("ID_PATIENT_EXT") REFERENCES "EXP"."PATIENT"("ID_PATIENT_EXT");

ALTER TABLE "EXP"."DOSSIER"
ADD FOREIGN KEY ("ID_PATIENT_EXT") REFERENCES "EXP"."PATIENT"("ID_PATIENT_EXT");

ALTER TABLE "EXP"."LABORATOIRE"
ADD FOREIGN KEY ("ID_PATIENT_EXT") REFERENCES "EXP"."PATIENT"("ID_PATIENT_EXT");

ALTER TABLE "EXP"."MEDECIN_TRAITANT"
ADD FOREIGN KEY ("ID_PATIENT_EXT") REFERENCES "EXP"."PATIENT"("ID_PATIENT_EXT");
ALTER TABLE "EXP"."MEDECIN_TRAITANT"
ADD FOREIGN KEY ("ID_MEDECIN_EXT") REFERENCES "EXP"."MEDECIN"("ID_MEDECIN_EXT");

ALTER TABLE "EXP"."MEDICAMENT"
ADD FOREIGN KEY ("DIN_CODE") REFERENCES "EXP"."CLASSE_MEDICAMENT"("DIN_CODE");

ALTER TABLE "EXP"."MEDICATION_SP"
ADD FOREIGN KEY ("ID_CONSULTATION_EXT") REFERENCES "EXP"."CONSULTATION"("ID_CONSULTATION_EXT");
ALTER TABLE "EXP"."MEDICATION_SP"
ADD FOREIGN KEY ("ID_MEDICAMENT_EXT") REFERENCES "EXP"."MEDICAMENT"("ID_MEDICAMENT_EXT");

ALTER TABLE "EXP"."PRESCRIPTION"
ADD FOREIGN KEY ("ID_PATIENT_EXT") REFERENCES "EXP"."PATIENT"("ID_PATIENT_EXT");
ALTER TABLE "EXP"."PRESCRIPTION"
ADD FOREIGN KEY ("ID_MEDECIN_EXT") REFERENCES "EXP"."MEDECIN"("ID_MEDECIN_EXT");
ALTER TABLE "EXP"."PRESCRIPTION"
ADD FOREIGN KEY ("ID_MEDICAMENT_EXT") REFERENCES "EXP"."MEDICAMENT"("ID_MEDICAMENT_EXT");

/* *-======================================================================-* */

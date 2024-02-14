\i '/docker-entrypoint-initdb.d/coverage/jedis-griis/01a-EXP_cre.sql'
\i '/docker-entrypoint-initdb.d/coverage/jedis-griis/02a-EXP_coi.sql'
\i '/docker-entrypoint-initdb.d/coverage/jedis-griis/04a-EXP_chargement.sql'
\i '/docker-entrypoint-initdb.d/coverage/jedis-griis/03a-EXP_coe.sql'
\i '/docker-entrypoint-initdb.d/coverage/jedis-griis/05A-EXP_MAJForCoverage.sql'

\i '/docker-entrypoint-initdb.d/coverage/humanBodyWeightOntology/ontorela_config/20240213-1415/DatabaseScripts/100-BW_cre-table_v0_20240213-1415.sql'
\i '/docker-entrypoint-initdb.d/coverage/humanBodyWeightOntology/ontorela_config/20240213-1415/DatabaseScripts/110-BW_cre-participationCheck-fct_v0_20240213-1415.sql'
\i '/docker-entrypoint-initdb.d/coverage/humanBodyWeightOntology/ontorela_config/20240213-1415/DatabaseScripts/120-BW_cre-unionAxiomCheck-fct_v0_20240213-1415.sql'
\i '/docker-entrypoint-initdb.d/coverage/humanBodyWeightOntology/ontorela_config/20240213-1415/DatabaseScripts/130-BW_cre-membershipCheck-fct_v0_20240213-1415.sql'

-- todo: Le script généré par OntoRelA n'est pas compatible avec la nouvelle version de OntoRelCat
--       Lorsque l'ontologie sera finalisée, il faudra rerouler OntoRelA et modifier le script généré pour que
--       ça fonctionne avec OntoRelCat.
-- \i '/docker-entrypoint-initdb.d/coverage/humanBodyWeightOntology/ontorela_config/20240213-1415/DatabaseScripts/1000-BW_OntoRelCat_ins_v0_20240213-1415.sql'

-- todo: Cette ligne est commentée puisqu'il est plus simple d'exécuter le fichier manuellement et réagir aux erreurs directement
-- \i '/docker-entrypoint-initdb.d/coverage/humanBodyWeightOntology/test_data_ins.sql'

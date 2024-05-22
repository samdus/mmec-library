
======================================================= 
 START OntoRelA  
======================================================= 
Ontology configuration file : /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/ontology_config.yml
Database configuration file : /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/database_config.yml

--------------------------------------- 
Building ontology...
--------------------------------------- 
  IRI_owlapi [ontoIRI=OntoIRI [fullIRI=http://www.griis.ca/projects/onto_tst, shortIRI=onto_tst], iriOwlapi=http://www.griis.ca/projects/onto_tst]
  Ontology graph generated: /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/Graphs/InitialOntoGraph.dot
  Ontology reports generated: 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/OntologyAnnotationDiagnostics.txt
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/OntologyDetails.txt
  Normalized ontology generated (monto): 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/onto_tst_normalized.txt
  Normalized ontology generated (owl): 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/onto_tst_normalized.ttl
  Filtered ontology graph generated: 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/Graphs/OntoGraph.dot
  Filtered ontology reports generated: 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/OntologyAnnotationDiagnostics.txt
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/OntologyDetails.txt
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/OntologyAnomalies.txt

--------------------------------------- 
Building ontology ended.
--------------------------------------- 

--------------------------------------- 
Building database...
--------------------------------------- 
  Database [databaseId=onto_tst, schemaSet=[Schema [id=simple, schemaType=BASE]]]
  OntoRel anomalies generated: /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/OntoRelDiagnostics.txt
  OntoRelCat generated: 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/1003-simple_OntoRelCat_ins_v0_20240515-1532.sql
  Database report generated: 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseReport.txt
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseIdentifierAnomalies.txt
  Database graph generated: 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/Graphs/RelGraph.dot
  OntoRel graph generated: 
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/Graphs/OntoRelGraph.dot
  Database scripts:
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/100-simple_cre-table_v0_20240515-1532.sql
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/920-simple_drp-table_v0_20240515-1532.sql
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/110-simple_cre-participationCheck-fct_v0_20240515-1532.sql
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/120-simple_cre-unionAxiomCheck-fct_v0_20240515-1532.sql
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/130-simple_cre-membershipCheck-fct_v0_20240515-1532.sql
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/200-simple_cre-view-iri_v0_20240515-1532.sql
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/210-simple_cre-view-en_v0_20240515-1532.sql
    /Users/samueldussault/Documents/Projets/arot/hephaistos/mMEC/src/test/resources/testset/basicR2RML/ontorela_config/20240515-1532/DatabaseScripts/800-simple_del-table_v0_20240515-1532.sql

--------------------------------------- 
Building database ended.
--------------------------------------- 

======================================================= 
 END OntoRelA 1 sec
======================================================= 

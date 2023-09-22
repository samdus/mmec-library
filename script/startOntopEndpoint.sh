#!/bin/bash
ontop endpoint \
            --properties /Users/samueldussault/Documents/Projets/duss2503/testsOntopQueryOptim/src/main/resources/postgresql-configuration.properties \
            --ontology   src/test/resources/testset/simpleTest/ontology.ttl \
            --mapping    src/test/resources/testset/simpleTest/mapping.ttl \
            --port 8080 \
            --dev

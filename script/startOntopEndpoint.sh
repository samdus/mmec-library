#!/bin/bash
ontop endpoint \
            --properties src/main/resources/postgresql-configuration.properties \
            --ontology   src/main/resources/ontology_normalized.ttl \
            --mapping    src/main/resources/mapping.ttl \
            --port 8080 \
            --dev
/*
-- =========================================================================== A
Schema : simple
Creation Date : 20240119-1529
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Call procedure created to insert data into OntoRelCat schema
-- =========================================================================== A
*/

call ontorelcat_pub.ontorel_ins('da724cb8-84b8-403b-a66b-d7345d34b662', '1.2.2');

call ontorelcat_pub.onto_config_db_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                       'uid',
                                       'uid_domain',
                                       'TEXT',
                                       'value',
                                       'value_domain',
                                       'TEXT',
                                       '60',
                                       'false',
                                       'false',
                                       'false',
                                       'false');

call ontorelcat_pub.onto_import_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'OntoRelCat.json', '{
  "OntoRel": {
    "ontologyIri": "http://www.griis.ca/projects/onto_tst",
    "label": {
      "fr": null,
      "en": null
    },
    "dbBaseSchemaId": "simple",
    "ontoRelversion": null,
    "creationDate": "2024-01-19T15:29:52.789164-05:00"
  },
  "Classes": [
    {
      "iri": "http://www.w3.org/2002/07/owl#Thing",
      "origin": "DECLARED",
      "tableId": "T0000",
      "label": {
        "fr": null,
        "en": null
      },
      "dataAxiomTables": [],
      "classAxiomTables": []
    },
    {
      "iri": "http://www.griis.ca/projects/ONTORELA_C0004X",
      "origin": "DECLARED",
      "tableId": "T0001",
      "label": {
        "fr": "tst1 C0004X",
        "en": "tst1 C0004Xtst3 | rel | tst2"
      },
      "dataAxiomTables": [],
      "classAxiomTables": [
        "T0008"
      ]
    },
    {
      "iri": "http://www.griis.ca/projects/ONTORELA_C0006X",
      "origin": "DECLARED",
      "tableId": "T0002",
      "label": {
        "fr": "tst1 C0004X unionOf ",
        "en": "tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3"
      },
      "dataAxiomTables": [],
      "classAxiomTables": []
    },
    {
      "iri": "http://www.griis.ca/projects/tst3",
      "origin": "DECLARED",
      "tableId": "T0003",
      "label": {
        "fr": null,
        "en": null
      },
      "dataAxiomTables": [],
      "classAxiomTables": []
    },
    {
      "iri": "http://www.griis.ca/projects/tst2",
      "origin": "DECLARED",
      "tableId": "T0004",
      "label": {
        "fr": null,
        "en": null
      },
      "dataAxiomTables": [],
      "classAxiomTables": []
    },
    {
      "iri": "http://www.griis.ca/projects/tst",
      "origin": "DECLARED",
      "tableId": "T0005",
      "label": {
        "fr": null,
        "en": null
      },
      "dataAxiomTables": [
        "T0007"
      ],
      "classAxiomTables": []
    },
    {
      "iri": "http://www.griis.ca/projects/tst1",
      "origin": "DECLARED",
      "tableId": "T0006",
      "label": {
        "fr": null,
        "en": null
      },
      "dataAxiomTables": [],
      "classAxiomTables": [
        "T0009"
      ]
    }
  ],
  "Types": [],
  "ObjectProperties": [],
  "DataProperties": [
    {
      "iri": "http://www.griis.ca/projects/has_value",
      "label": {
        "fr": null,
        "en": null
      },
      "domainClassIri": [],
      "rangeDataTypeIri": null
    }
  ],
  "IsaAxioms": [
    {
      "subClassIri": "tst1",
      "subClassTableId": "T0006",
      "superClassIri": "tst",
      "superClassTableId": "T0005"
    },
    {
      "subClassIri": "tst3",
      "subClassTableId": "T0003",
      "superClassIri": "tst",
      "superClassTableId": "T0005"
    },
    {
      "subClassIri": "tst",
      "subClassTableId": "T0005",
      "superClassIri": "Thing",
      "superClassTableId": "T0000"
    },
    {
      "subClassIri": "tst3",
      "subClassTableId": "T0003",
      "superClassIri": "ONTORELA_C0006X",
      "superClassTableId": "T0002"
    },
    {
      "subClassIri": "ONTORELA_C0004X",
      "subClassTableId": "T0001",
      "superClassIri": "Thing",
      "superClassTableId": "T0000"
    },
    {
      "subClassIri": "tst2",
      "subClassTableId": "T0004",
      "superClassIri": "ONTORELA_C0006X",
      "superClassTableId": "T0002"
    },
    {
      "subClassIri": "tst2",
      "subClassTableId": "T0004",
      "superClassIri": "tst",
      "superClassTableId": "T0005"
    },
    {
      "subClassIri": "ONTORELA_C0006X",
      "subClassTableId": "T0002",
      "superClassIri": "Thing",
      "superClassTableId": "T0000"
    }
  ],
  "ClassAxioms": [
    {
      "expression": "ONTORELA_C0004X [1..*] rel ONTORELA_C0006X",
      "origin": "DECLARED",
      "tableId": "T0008",
      "domainClassIri": "http://www.griis.ca/projects/ONTORELA_C0004X",
      "domainTableId": "T0001",
      "rangeClassIri": "http://www.griis.ca/projects/ONTORELA_C0006X",
      "rangeTableId": "T0002",
      "propertyIri": "http://www.griis.ca/projects/rel",
      "domainParticipation": {
        "min": "1",
        "max": "*"
      },
      "rangeParticipation": {
        "min": "0",
        "max": "*"
      }
    },
    {
      "expression": "tst1 [1..*] rel ONTORELA_C0004X",
      "origin": "DECLARED",
      "tableId": "T0009",
      "domainClassIri": "http://www.griis.ca/projects/tst1",
      "domainTableId": "T0006",
      "rangeClassIri": "http://www.griis.ca/projects/ONTORELA_C0004X",
      "rangeTableId": "T0001",
      "propertyIri": "http://www.griis.ca/projects/rel",
      "domainParticipation": {
        "min": "1",
        "max": "*"
      },
      "rangeParticipation": {
        "min": "0",
        "max": "*"
      }
    }
  ],
  "DataAxioms": [
    {
      "expression": "tst [1..1] has_value string",
      "tableId": "T0007",
      "domainClassIri": "http://www.griis.ca/projects/tst",
      "domainTableId": "T0005",
      "rangeClassIri": "http://www.w3.org/2001/XMLSchema#string",
      "rangeTableId": null,
      "propertyIri": "http://www.griis.ca/projects/has_value",
      "domainParticipation": {
        "min": "1",
        "max": "1"
      }
    }
  ]
}', '2024-01-19T15:29:52.8347-05:00');

call ontorelcat_pub.onto_schema_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'simple', 'en', 'BASE');

call ontorelcat_pub.ontology_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/onto_tst',
                                 'ontology.ttl', 'onto_tst', '', '2023-08-17T15:01:00Z');

call ontorelcat_pub.onto_class_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.w3.org/2002/07/owl#Thing',
                                   'T0000', 'DECLARED');

call ontorelcat_pub.onto_class_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                   'http://www.griis.ca/projects/ONTORELA_C0004X', 'T0001', 'DECLARED');

call ontorelcat_pub.label_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/ONTORELA_C0004X',
                              'fr', 'tst1 C0004X');

call ontorelcat_pub.label_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/ONTORELA_C0004X',
                              'en', 'tst1 C0004Xtst3 | rel | tst2');

call ontorelcat_pub.definition_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                   'http://www.griis.ca/projects/ONTORELA_C0004X', 'fr', 'tst1 C0004X');

call ontorelcat_pub.definition_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                   'http://www.griis.ca/projects/ONTORELA_C0004X', 'en', 'tst1 C0004X');

call ontorelcat_pub.onto_class_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                   'http://www.griis.ca/projects/ONTORELA_C0006X', 'T0002', 'DECLARED');

call ontorelcat_pub.label_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/ONTORELA_C0006X',
                              'fr', 'tst1 C0004X unionOf ');

call ontorelcat_pub.label_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/ONTORELA_C0006X',
                              'en', 'tst1 C0004Xtst3 | rel | tst2 unionOf tst2 | tst3');

call ontorelcat_pub.definition_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                   'http://www.griis.ca/projects/ONTORELA_C0006X', 'fr', 'tst1 C0004X unionOf ');

call ontorelcat_pub.definition_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                   'http://www.griis.ca/projects/ONTORELA_C0006X', 'en',
                                   'tst1 C0004Xtst3 | rel | tst2 unionOf ');

call ontorelcat_pub.onto_class_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/tst3', 'T0003',
                                   'DECLARED');

call ontorelcat_pub.onto_class_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/tst2', 'T0004',
                                   'DECLARED');

call ontorelcat_pub.onto_class_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/tst', 'T0005',
                                   'DECLARED');

call ontorelcat_pub.onto_class_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/tst1', 'T0006',
                                   'DECLARED');

call ontorelcat_pub.onto_data_properties_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                             'http://www.griis.ca/projects/has_value');

call ontorelcat_pub.onto_class_inheritance_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/tst1', 'http://www.griis.ca/projects/tst');

call ontorelcat_pub.onto_class_inheritance_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/tst3', 'http://www.griis.ca/projects/tst');

call ontorelcat_pub.onto_class_inheritance_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/tst',
                                               'http://www.w3.org/2002/07/owl#Thing');

call ontorelcat_pub.onto_class_inheritance_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/tst3',
                                               'http://www.griis.ca/projects/ONTORELA_C0006X');

call ontorelcat_pub.onto_class_inheritance_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/ONTORELA_C0004X',
                                               'http://www.w3.org/2002/07/owl#Thing');

call ontorelcat_pub.onto_class_inheritance_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/tst2',
                                               'http://www.griis.ca/projects/ONTORELA_C0006X');

call ontorelcat_pub.onto_class_inheritance_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/tst2', 'http://www.griis.ca/projects/tst');

call ontorelcat_pub.onto_class_inheritance_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/ONTORELA_C0006X',
                                               'http://www.w3.org/2002/07/owl#Thing');

call ontorelcat_pub.onto_object_properties_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                               'http://www.griis.ca/projects/rel', null);

call ontorelcat_pub.onto_class_axiom_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                         'http://www.griis.ca/projects/ONTORELA_C0004X',
                                         'http://www.griis.ca/projects/ONTORELA_C0006X',
                                         'http://www.griis.ca/projects/rel', '[1..*]', '[0.. *]', 'DECLARED', 'T0008');

call ontorelcat_pub.onto_class_axiom_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/tst1',
                                         'http://www.griis.ca/projects/ONTORELA_C0004X',
                                         'http://www.griis.ca/projects/rel', '[1..*]', '[0.. *]', 'DECLARED', 'T0009');

call ontorelcat_pub.onto_data_type_ins('da724cb8-84b8-403b-a66b-d7345d34b662',
                                       'http://www.w3.org/2001/XMLSchema#string', null, 'TEXT');
call ontorelcat_pub.onto_data_axiom_ins('da724cb8-84b8-403b-a66b-d7345d34b662', 'http://www.griis.ca/projects/tst',
                                        'http://www.w3.org/2001/XMLSchema#string',
                                        'http://www.griis.ca/projects/has_value', '[1..1]', 'DECLARED', 'T0007');

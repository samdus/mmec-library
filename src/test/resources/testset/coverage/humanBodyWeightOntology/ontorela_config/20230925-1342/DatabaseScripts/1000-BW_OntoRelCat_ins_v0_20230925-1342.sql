/*
-- =========================================================================== A
Schema : BW
Creation Date : 20230925-1342
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Call procedure created to insert data into OntoRelCat schema
-- =========================================================================== A
*/

 call "OntoRelCat".ontorel_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','1.2.2');

 call "OntoRelCat".onto_config_db_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2',
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

 call "OntoRelCat".onto_import_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','OntoRelCat.json','{"OntoRel":{"ontologyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl","label":{"fr":null,"en":null},"dbBaseSchemaId":"BW","ontoRelversion":null,"creationDate":"2023-09-25T13:42:12.653235-04:00"},"Classes":[{"iri":"http://www.w3.org/2002/07/owl#Thing","origin":"DECLARED","tableId":"T0000","label":{"fr":null,"en":null},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000310","origin":"DECLARED","tableId":"T0001","label":{"fr":null,"en":"document"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000027","origin":"DECLARED","tableId":"T0002","label":{"fr":null,"en":"data item"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000003","origin":"DECLARED","tableId":"T0003","label":{"fr":null,"en":"measurement unit label"},"dataAxiomTables":["T0027"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/PHYSIO_0000065","origin":"DECLARED","tableId":"T0004","label":{"fr":null,"en":"human body mass measurement datum"},"dataAxiomTables":[],"classAxiomTables":["T002a"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000009","origin":"DECLARED","tableId":"T0005","label":{"fr":null,"en":"datum label"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/PHYSIO_0000083","origin":"DECLARED","tableId":"T0006","label":{"fr":null,"en":"physiological evaluation report"},"dataAxiomTables":[],"classAxiomTables":["T002c","T002b"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000015","origin":"DECLARED","tableId":"T0007","label":{"fr":null,"en":"process"},"dataAxiomTables":[],"classAxiomTables":["T002d"]},{"iri":"http://purl.obolibrary.org/obo/HADO_0000008","origin":"DECLARED","tableId":"T0008","label":{"fr":null,"en":"patient"},"dataAxiomTables":[],"classAxiomTables":["T002e"]},{"iri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000090","origin":"DECLARED","tableId":"T0009","label":{"fr":null,"en":"physiological evaluation of human"},"dataAxiomTables":[],"classAxiomTables":["T002f"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000017","origin":"DECLARED","tableId":"T000a","label":{"fr":null,"en":"realizable entity"},"dataAxiomTables":[],"classAxiomTables":["T0030"]},{"iri":"http://purl.obolibrary.org/obo/HADO_0000006","origin":"DECLARED","tableId":"T000b","label":{"fr":null,"en":"medical record identifier"},"dataAxiomTables":[],"classAxiomTables":["T0031"]},{"iri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X","origin":"INTERSECTION_CLASS","tableId":"T000c","label":{"fr":"HADO_0000006 intersectionOf ","en":"medical record identifier intersectionOf health care record | is about | patient"},"dataAxiomTables":[],"classAxiomTables":["T0032"]},{"iri":"http://purl.obolibrary.org/obo/OBI_0001931","origin":"DECLARED","tableId":"T000d","label":{"fr":null,"en":"scalar value specification"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000031","origin":"DECLARED","tableId":"T000e","label":{"fr":null,"en":"gdc"},"dataAxiomTables":[],"classAxiomTables":["T0033"]},{"iri":"http://purl.obolibrary.org/obo/OBI_0001933","origin":"DECLARED","tableId":"T000f","label":{"fr":null,"en":"value specification"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000001","origin":"DECLARED","tableId":"T0010","label":{"fr":null,"en":"entity"},"dataAxiomTables":[],"classAxiomTables":["T0034"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000023","origin":"DECLARED","tableId":"T0011","label":{"fr":null,"en":"role"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000003","origin":"DECLARED","tableId":"T0012","label":{"fr":null,"en":"occurrent"},"dataAxiomTables":[],"classAxiomTables":["T0036","T0035"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000028","origin":"DECLARED","tableId":"T0013","label":{"fr":null,"en":"symbol"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/PHYSIO_0000008","origin":"DECLARED","tableId":"T0014","label":{"fr":null,"en":"body weight measurement process"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000577","origin":"DECLARED","tableId":"T0015","label":{"fr":null,"en":"centrally registered identifier symbol"},"dataAxiomTables":["T0029"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OBI_0100026","origin":"DECLARED","tableId":"T0016","label":{"fr":null,"en":"organism"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000109","origin":"DECLARED","tableId":"T0017","label":{"fr":null,"en":"measurement datum"},"dataAxiomTables":[],"classAxiomTables":["T0038","T0037"]},{"iri":"http://purl.obolibrary.org/obo/PHYSIO_0000094","origin":"DECLARED","tableId":"T0018","label":{"fr":null,"en":"health care record"},"dataAxiomTables":[],"classAxiomTables":["T0039"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000004","origin":"DECLARED","tableId":"T0019","label":{"fr":null,"en":"independent continuant"},"dataAxiomTables":[],"classAxiomTables":["T003a","T003b"]},{"iri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000091","origin":"DECLARED","tableId":"T001a","label":{"fr":null,"en":"physiological evaluation of patient"},"dataAxiomTables":[],"classAxiomTables":["T003c"]},{"iri":"http://purl.obolibrary.org/obo/OBI_0000011","origin":"DECLARED","tableId":"T001b","label":{"fr":null,"en":"planned process"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","origin":"DECLARED","tableId":"T001c","label":{"fr":null,"en":"Homo sapiens"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/UO_0000002","origin":"DECLARED","tableId":"T001d","label":{"fr":null,"en":"mass unit"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085","origin":"DECLARED","tableId":"T001e","label":{"fr":null,"en":"physiological evaluation"},"dataAxiomTables":[],"classAxiomTables":["T003d"]},{"iri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093","origin":"DECLARED","tableId":"T001f","label":{"fr":null,"en":"physiological data item"},"dataAxiomTables":[],"classAxiomTables":["T003e"]},{"iri":"http://purl.obolibrary.org/obo/OBI_0000093","origin":"DECLARED","tableId":"T0020","label":{"fr":null,"en":"patient role"},"dataAxiomTables":[],"classAxiomTables":["T003f"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000040","origin":"DECLARED","tableId":"T0021","label":{"fr":null,"en":"material entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000030","origin":"DECLARED","tableId":"T0022","label":{"fr":null,"en":"information content entity"},"dataAxiomTables":[],"classAxiomTables":["T0040","T0041"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000020","origin":"DECLARED","tableId":"T0023","label":{"fr":null,"en":"sdc"},"dataAxiomTables":[],"classAxiomTables":["T0042"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000032","origin":"DECLARED","tableId":"T0024","label":{"fr":null,"en":"scalar measurement datum"},"dataAxiomTables":["T0026","T0028"],"classAxiomTables":["T0044","T0043"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000002","origin":"DECLARED","tableId":"T0025","label":{"fr":null,"en":"continuant"},"dataAxiomTables":[],"classAxiomTables":["T0045"]}],"Types":[],"ObjectProperties":[],"DataProperties":[{"iri":"http://purl.obolibrary.org/obo/IAO_0000004","label":{"fr":null,"en":"has measurement value"},"domainClassIri":["http://purl.obolibrary.org/obo/IAO_0000032"],"rangeDataTypeIri":"http://www.w3.org/2001/XMLSchema#double"},{"iri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","label":{"fr":null,"en":"has value"},"domainClassIri":[],"rangeDataTypeIri":null},{"iri":"http://www.w3.org/2002/07/owl#topDataProperty","label":{"fr":null,"en":null},"domainClassIri":[],"rangeDataTypeIri":null}],"IsaAxioms":[{"subClassIri":"HADO_0000006","subClassTableId":"T000b","superClassIri":"IAO_0000577","superClassTableId":"T0015"},{"subClassIri":"PHYSIO_0000065","subClassTableId":"T0004","superClassIri":"IAO_0000032","superClassTableId":"T0024"},{"subClassIri":"BFO_0000015","subClassTableId":"T0007","superClassIri":"BFO_0000003","superClassTableId":"T0012"},{"subClassIri":"IAO_0000027","subClassTableId":"T0002","superClassIri":"IAO_0000030","superClassTableId":"T0022"},{"subClassIri":"PHYSIO_0000085","subClassTableId":"T001e","superClassIri":"OBI_0000011","superClassTableId":"T001b"},{"subClassIri":"IAO_0000109","subClassTableId":"T0017","superClassIri":"IAO_0000027","superClassTableId":"T0002"},{"subClassIri":"OBI_0000093","subClassTableId":"T0020","superClassIri":"BFO_0000023","superClassTableId":"T0011"},{"subClassIri":"NCBITaxon_9606","subClassTableId":"T001c","superClassIri":"OBI_0100026","superClassTableId":"T0016"},{"subClassIri":"IAO_0000003","subClassTableId":"T0003","superClassIri":"IAO_0000009","superClassTableId":"T0005"},{"subClassIri":"BFO_0000023","subClassTableId":"T0011","superClassIri":"BFO_0000017","superClassTableId":"T000a"},{"subClassIri":"OBI_0000011","subClassTableId":"T001b","superClassIri":"BFO_0000015","superClassTableId":"T0007"},{"subClassIri":"IAO_0000028","subClassTableId":"T0013","superClassIri":"IAO_0000030","superClassTableId":"T0022"},{"subClassIri":"ONTORELA_C0025X","subClassTableId":"T000c","superClassIri":"PHYSIO_0000094","superClassTableId":"T0018"},{"subClassIri":"OBI_0100026","subClassTableId":"T0016","superClassIri":"BFO_0000040","superClassTableId":"T0021"},{"subClassIri":"IAO_0000009","subClassTableId":"T0005","superClassIri":"IAO_0000030","superClassTableId":"T0022"},{"subClassIri":"BFO_0000020","subClassTableId":"T0023","superClassIri":"BFO_0000002","superClassTableId":"T0025"},{"subClassIri":"PHYSIO_0000083","subClassTableId":"T0006","superClassIri":"IAO_0000310","superClassTableId":"T0001"},{"subClassIri":"IAO_0000310","subClassTableId":"T0001","superClassIri":"IAO_0000030","superClassTableId":"T0022"},{"subClassIri":"PHYSIO_0000094","subClassTableId":"T0018","superClassIri":"IAO_0000310","superClassTableId":"T0001"},{"subClassIri":"PHYSIO_0000091","subClassTableId":"T001a","superClassIri":"PHYSIO_0000085","superClassTableId":"T001e"},{"subClassIri":"OBI_0001933","subClassTableId":"T000f","superClassIri":"IAO_0000030","superClassTableId":"T0022"},{"subClassIri":"UO_0000002","subClassTableId":"T001d","superClassIri":"IAO_0000003","superClassTableId":"T0003"},{"subClassIri":"IAO_0000030","subClassTableId":"T0022","superClassIri":"BFO_0000031","superClassTableId":"T000e"},{"subClassIri":"BFO_0000002","subClassTableId":"T0025","superClassIri":"BFO_0000001","superClassTableId":"T0010"},{"subClassIri":"BFO_0000031","subClassTableId":"T000e","superClassIri":"BFO_0000002","superClassTableId":"T0025"},{"subClassIri":"BFO_0000003","subClassTableId":"T0012","superClassIri":"BFO_0000001","superClassTableId":"T0010"},{"subClassIri":"BFO_0000001","subClassTableId":"T0010","superClassIri":"Thing","superClassTableId":"T0000"},{"subClassIri":"OBI_0001931","subClassTableId":"T000d","superClassIri":"OBI_0001933","superClassTableId":"T000f"},{"subClassIri":"BFO_0000040","subClassTableId":"T0021","superClassIri":"BFO_0000004","superClassTableId":"T0019"},{"subClassIri":"PHYSIO_0000008","subClassTableId":"T0014","superClassIri":"PHYSIO_0000085","superClassTableId":"T001e"},{"subClassIri":"BFO_0000017","subClassTableId":"T000a","superClassIri":"BFO_0000020","superClassTableId":"T0023"},{"subClassIri":"PHYSIO_0000093","subClassTableId":"T001f","superClassIri":"IAO_0000027","superClassTableId":"T0002"},{"subClassIri":"HADO_0000008","subClassTableId":"T0008","superClassIri":"NCBITaxon_9606","superClassTableId":"T001c"},{"subClassIri":"BFO_0000004","subClassTableId":"T0019","superClassIri":"BFO_0000002","superClassTableId":"T0025"},{"subClassIri":"IAO_0000032","subClassTableId":"T0024","superClassIri":"IAO_0000109","superClassTableId":"T0017"},{"subClassIri":"IAO_0000577","subClassTableId":"T0015","superClassIri":"IAO_0000028","superClassTableId":"T0013"},{"subClassIri":"PHYSIO_0000090","subClassTableId":"T0009","superClassIri":"PHYSIO_0000085","superClassTableId":"T001e"}],"ClassAxioms":[{"expression":"HADO_0000006 [1..1] IAO_0000219 ONTORELA_C0025X","origin":"INTERSECTION_AXIOM","tableId":"T0031","domainClassIri":"http://purl.obolibrary.org/obo/HADO_0000006","domainTableId":"T000b","rangeClassIri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X","rangeTableId":"T000c","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000219","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"PHYSIO_0000090 [1..1] PHYSIO_0000089 NCBITaxon_9606","origin":"INTERSECTION_AXIOM","tableId":"T002f","domainClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000090","domainTableId":"T0009","rangeClassIri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","rangeTableId":"T001c","propertyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000004 [1..*] RO_0001025 BFO_0000004","origin":"DECLARED","tableId":"T003b","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","domainTableId":"T0019","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","rangeTableId":"T0019","propertyIri":"http://purl.obolibrary.org/obo/RO_0001025","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"PHYSIO_0000094 [1..*] IAO_0000136 OBI_0100026","origin":"DECLARED","tableId":"T0039","domainClassIri":"http://purl.obolibrary.org/obo/PHYSIO_0000094","domainTableId":"T0018","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0100026","rangeTableId":"T0016","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000003 [1..*] BFO_0000066 BFO_0000004","origin":"DECLARED","tableId":"T0035","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","domainTableId":"T0012","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","rangeTableId":"T0019","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000066","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"PHYSIO_0000083 [1..*] BFO_0000051 PHYSIO_0000093","origin":"DECLARED","tableId":"T002b","domainClassIri":"http://purl.obolibrary.org/obo/PHYSIO_0000083","domainTableId":"T0006","rangeClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093","rangeTableId":"T001f","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000051","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HADO_0000008 [1..*] RO_0000087 OBI_0000093","origin":"INTERSECTION_AXIOM","tableId":"T002e","domainClassIri":"http://purl.obolibrary.org/obo/HADO_0000008","domainTableId":"T0008","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0000093","rangeTableId":"T0020","propertyIri":"http://purl.obolibrary.org/obo/RO_0000087","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"PHYSIO_0000085 [1..1] PHYSIO_0000089 OBI_0100026","origin":"DECLARED","tableId":"T003d","domainClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085","domainTableId":"T001e","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0100026","rangeTableId":"T0016","propertyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"ONTORELA_C0025X [1..*] IAO_0000136 HADO_0000008","origin":"INTERSECTION_AXIOM","tableId":"T0032","domainClassIri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X","domainTableId":"T000c","rangeClassIri":"http://purl.obolibrary.org/obo/HADO_0000008","rangeTableId":"T0008","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000003 [1..*] RO_0000057 BFO_0000002","origin":"DECLARED","tableId":"T0036","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","domainTableId":"T0012","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000002","rangeTableId":"T0025","propertyIri":"http://purl.obolibrary.org/obo/RO_0000057","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000017 [1..*] BFO_0000054 BFO_0000015","origin":"DECLARED","tableId":"T0030","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000017","domainTableId":"T000a","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000015","rangeTableId":"T0007","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000054","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"OBI_0000093 [1..*] RO_0000052 NCBITaxon_9606","origin":"DECLARED","tableId":"T003f","domainClassIri":"http://purl.obolibrary.org/obo/OBI_0000093","domainTableId":"T0020","rangeClassIri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","rangeTableId":"T001c","propertyIri":"http://purl.obolibrary.org/obo/RO_0000052","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000030 [1..*] IAO_0000136 BFO_0000001","origin":"DECLARED","tableId":"T0040","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000030","domainTableId":"T0022","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"T0010","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000002 [1..*] RO_0000056 BFO_0000003","origin":"DECLARED","tableId":"T0045","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000002","domainTableId":"T0025","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","rangeTableId":"T0012","propertyIri":"http://purl.obolibrary.org/obo/RO_0000056","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000109 [1..*] OBI_0001938 OBI_0001933","origin":"DECLARED","tableId":"T0038","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000109","domainTableId":"T0017","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0001933","rangeTableId":"T000f","propertyIri":"http://purl.obolibrary.org/obo/OBI_0001938","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000030 [1..*] IAO_0000219 BFO_0000001","origin":"DECLARED","tableId":"T0041","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000030","domainTableId":"T0022","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"T0010","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000219","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000004 [1..*] RO_0000087 BFO_0000023","origin":"DECLARED","tableId":"T003a","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","domainTableId":"T0019","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000023","rangeTableId":"T0011","propertyIri":"http://purl.obolibrary.org/obo/RO_0000087","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000109 [1..1] IAO_0000039 IAO_0000003","origin":"DECLARED","tableId":"T0037","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000109","domainTableId":"T0017","rangeClassIri":"http://purl.obolibrary.org/obo/IAO_0000003","rangeTableId":"T0003","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000039","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"1","max":"*"}},{"expression":"IAO_0000032 [1..*] OBI_0001938 OBI_0001931","origin":"DECLARED","tableId":"T0044","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"T0024","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0001931","rangeTableId":"T000d","propertyIri":"http://purl.obolibrary.org/obo/OBI_0001938","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"PHYSIO_0000083 [1..1] BFO_0000051 HADO_0000006","origin":"DECLARED","tableId":"T002c","domainClassIri":"http://purl.obolibrary.org/obo/PHYSIO_0000083","domainTableId":"T0006","rangeClassIri":"http://purl.obolibrary.org/obo/HADO_0000006","rangeTableId":"T000b","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000051","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"PHYSIO_0000091 [1..1] PHYSIO_0000089 HADO_0000008","origin":"INTERSECTION_AXIOM","tableId":"T003c","domainClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000091","domainTableId":"T001a","rangeClassIri":"http://purl.obolibrary.org/obo/HADO_0000008","rangeTableId":"T0008","propertyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"PHYSIO_0000093 [1..*] OBI_0000312 PHYSIO_0000085","origin":"INTERSECTION_AXIOM","tableId":"T003e","domainClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093","domainTableId":"T001f","rangeClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085","rangeTableId":"T001e","propertyIri":"http://purl.obolibrary.org/obo/OBI_0000312","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000015 [1..*] BFO_0000055 BFO_0000017","origin":"DECLARED","tableId":"T002d","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000015","domainTableId":"T0007","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000017","rangeTableId":"T000a","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000055","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000001 [1..*] BFO_0000050 BFO_0000001","origin":"DECLARED","tableId":"T0034","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","domainTableId":"T0010","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"T0010","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000050","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000020 [1..*] RO_0000059 BFO_0000031","origin":"DECLARED","tableId":"T0042","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000020","domainTableId":"T0023","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000031","rangeTableId":"T000e","propertyIri":"http://purl.obolibrary.org/obo/RO_0000059","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"PHYSIO_0000065 [1..*] OBI_0000312 PHYSIO_0000008","origin":"DECLARED","tableId":"T002a","domainClassIri":"http://purl.obolibrary.org/obo/PHYSIO_0000065","domainTableId":"T0004","rangeClassIri":"http://purl.obolibrary.org/obo/PHYSIO_0000008","rangeTableId":"T0014","propertyIri":"http://purl.obolibrary.org/obo/OBI_0000312","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000031 [1..*] RO_0000058 BFO_0000020","origin":"DECLARED","tableId":"T0033","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000031","domainTableId":"T000e","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000020","rangeTableId":"T0023","propertyIri":"http://purl.obolibrary.org/obo/RO_0000058","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000032 [1..*] IAO_0000039 Thing","origin":"DECLARED","tableId":"T0043","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"T0024","rangeClassIri":"http://www.w3.org/2002/07/owl#Thing","rangeTableId":"T0000","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000039","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"1","max":"*"}}],"DataAxioms":[{"expression":"IAO_0000032 [1..1] IAO_0000004 double","tableId":"T0026","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"T0024","rangeClassIri":"http://www.w3.org/2001/XMLSchema#double","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/IAO_0000004","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0000577 [1..1] PHYSIO_0000100 string","tableId":"T0029","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000577","domainTableId":"T0015","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0000032 [1..*] IAO_0000004 Literal","tableId":"T0028","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"T0024","rangeClassIri":"http://www.w3.org/2000/01/rdf-schema#Literal","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/IAO_0000004","domainParticipation":{"min":"1","max":"*"}},{"expression":"IAO_0000003 [1..1] PHYSIO_0000100 string","tableId":"T0027","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000003","domainTableId":"T0003","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}}]}','2023-09-25T13:42:12.727582-04:00');

 call "OntoRelCat".onto_schema_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','BW','en','BASE');

 call "OntoRelCat".ontology_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl','HumanBodyWeightAppli.owl','humanbodyweight-appli.owl','','2021-03-11T16:03:42Z');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://www.w3.org/2002/07/owl#Thing','T0000','DECLARED');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://www.w3.org/2002/07/owl#Thing','en','The class owl:Thing is the class of all individuals.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000310','T0001','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000310','en','document');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000310','en','An information content entity that is a collection of information content entities intended to be understood together as a whole.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000027','T0002','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000027','en','data item');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000027','en','a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000003','T0003','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000003','en','measurement unit label');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000003','en','A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000065','T0004','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000065','en','human body mass measurement datum');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000065','en','A scalar measurement datum that is a measurement of the mass of a human body.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000009','T0005','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000009','en','datum label');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000009','en','A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000083','T0006','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000083','en','physiological evaluation report');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000083','en','A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000015','T0007','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000015','en','process');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000015','en','
An occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t.
');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000008','T0008','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000008','en','patient');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000008','en','Homo sapiens having the role of patient.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000090','T0009','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000090','en','physiological evaluation of human');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000090','en','A physiological evaluation that evaluates a human''s body weight.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000017','T000a','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000017','en','realizable');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000017','en','A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000006','T000b','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000006','en','medical record identifier');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000006','en','A CRID symbol that is sufficent to look up a patient file in a medical record registry.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X','T000c','INTERSECTION_CLASS');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X','fr','HADO_0000006 intersectionOf ');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X','en','medical record identifier intersectionOf health care record | is about | patient');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X','fr','HADO_0000006 intersectionOf ');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X','en','medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. Homo sapiens having the role of patient.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0001931','T000d','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0001931','en','scalar value specification');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0001931','en','A value specification that consists of two parts: a numeral and a unit label');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000031','T000e','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000031','en','generically dependent continuant');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000031','en','GenericallyDependentContinuant');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0001933','T000f','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0001933','en','value specification');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0001933','en','An information content entity that specifies a value within a classification scheme or on a quantitative scale.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000001','T0010','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000001','en','entity');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000001','en','per discussion with Barry Smith');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000023','T0011','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000023','en','role');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000023','en','Role');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000003','T0012','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000003','en','occurrent');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000003','en','
An entity that has temporal parts and that happens, unfolds or develops through time.
');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000028','T0013','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000028','en','symbol');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000028','en','An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000008','T0014','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000008','en','body weight measurement process');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000008','en','A physiological evaluation that evaluates an organism''s body weight.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000577','T0015','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000577','en','centrally registered identifier symbol');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000577','en','A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0100026','T0016','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0100026','en','organism');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0100026','en','A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000109','T0017','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000109','en','measurement datum');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000109','en','A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000094','T0018','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000094','en','health care record');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000094','en','A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000004','T0019','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000004','en','ic');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000004','en','b is an independent continuant = Def. b is a continuant which is such that there is no c and no t such that b s-depends_on c at t. (axiom label in BFO2 Reference: [017-002])');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000091','T001a','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000091','en','physiological evaluation of patient');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000091','en','A physiological evaluation that evaluates a patient''s body weight.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000011','T001b','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000011','en','planned process');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000011','en','A process that realizes a plan which is the concretization of a plan specification.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/NCBITaxon_9606','T001c','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/NCBITaxon_9606','en','Homo sapiens');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/NCBITaxon_9606','en','Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/UO_0000002','T001d','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/UO_0000002','en','mass unit');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/UO_0000002','en','A unit which is a standard measure of the amount of matter/energy of a physical object.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085','T001e','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085','en','physiological evaluation');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085','en','A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093','T001f','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093','en','physiological data item');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093','en','A data item that is the specified output of some physiological evaluation.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000093','T0020','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000093','en','patient role');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000093','en','a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000040','T0021','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000040','en','material');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000040','en','MaterialEntity');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000030','T0022','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000030','en','information content entity');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000030','en','A generically dependent continuant that is about some thing.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000020','T0023','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000020','en','specifically dependent continuant');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000020','en','SpecificallyDependentContinuant');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','T0024','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','en','scalar measurement datum');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','en','a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.');

 call "OntoRelCat".onto_class_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000002','T0025','DECLARED');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000002','en','continuant');

 call "OntoRelCat".definition_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000002','en','
An entity that exists in full at any time in which it exists at all, persists through time while maintaining its identity and has no temporal parts.
');

 call "OntoRelCat".onto_data_properties_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000004');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000004','en','has measurement value');

 call "OntoRelCat".onto_data_properties_domain_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000004');

 call "OntoRelCat".onto_data_properties_range_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://www.w3.org/2001/XMLSchema#double','http://purl.obolibrary.org/obo/IAO_0000004', 'DOUBLE PRECISION');

 call "OntoRelCat".onto_data_properties_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000100');

 call "OntoRelCat".label_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000100','en','has value');

 call "OntoRelCat".onto_data_properties_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://www.w3.org/2002/07/owl#topDataProperty');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000006','http://purl.obolibrary.org/obo/IAO_0000577');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000065','http://purl.obolibrary.org/obo/IAO_0000032');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000003');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000027','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085','http://purl.obolibrary.org/obo/OBI_0000011');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000093','http://purl.obolibrary.org/obo/BFO_0000023');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/OBI_0100026');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000009');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/BFO_0000017');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/BFO_0000015');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000028','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X','http://purl.obolibrary.org/obo/PHYSIO_0000094');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/BFO_0000040');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000009','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000083','http://purl.obolibrary.org/obo/IAO_0000310');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000310','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000094','http://purl.obolibrary.org/obo/IAO_0000310');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000091','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0001933','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/UO_0000002','http://purl.obolibrary.org/obo/IAO_0000003');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000031');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000001');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000001');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000001','http://www.w3.org/2002/07/owl#Thing');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0001931','http://purl.obolibrary.org/obo/OBI_0001933');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000040','http://purl.obolibrary.org/obo/BFO_0000004');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000008','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000020');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000008','http://purl.obolibrary.org/obo/NCBITaxon_9606');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000109');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000577','http://purl.obolibrary.org/obo/IAO_0000028');

 call "OntoRelCat".onto_class_inheritance_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000090','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000006','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X','http://purl.obolibrary.org/obo/IAO_0000219','[1..1]','[0.. *]','INTERSECTION_AXIOM','T0031');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000090','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089','[1..1]','[0.. *]','INTERSECTION_AXIOM','T002f');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0001025','[1..*]','[0.. *]','DECLARED','T003b');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000094','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','T0039');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000066','[1..*]','[0.. *]','DECLARED','T0035');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000083','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093','http://purl.obolibrary.org/obo/BFO_0000051','[1..*]','[0.. *]','DECLARED','T002b');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/HADO_0000008','http://purl.obolibrary.org/obo/OBI_0000093','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','INTERSECTION_AXIOM','T002e');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089','[1..1]','[0.. *]','DECLARED','T003d');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C0025X','http://purl.obolibrary.org/obo/HADO_0000008','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','INTERSECTION_AXIOM','T0032');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/RO_0000057','[1..*]','[0.. *]','DECLARED','T0036');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000054','[1..*]','[0.. *]','DECLARED','T0030');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/OBI_0000093','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/RO_0000052','[1..*]','[0.. *]','DECLARED','T003f');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','T0040');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/RO_0000056','[1..*]','[0.. *]','DECLARED','T0045');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/OBI_0001933','http://purl.obolibrary.org/obo/OBI_0001938','[1..*]','[0.. *]','DECLARED','T0038');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000219','[1..*]','[0.. *]','DECLARED','T0041');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','DECLARED','T003a');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000039','[1..1]','[1.. *]','DECLARED','T0037');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/OBI_0001931','http://purl.obolibrary.org/obo/OBI_0001938','[1..*]','[0.. *]','DECLARED','T0044');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000083','http://purl.obolibrary.org/obo/HADO_0000006','http://purl.obolibrary.org/obo/BFO_0000051','[1..1]','[0.. *]','DECLARED','T002c');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000091','http://purl.obolibrary.org/obo/HADO_0000008','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089','[1..1]','[0.. *]','INTERSECTION_AXIOM','T003c');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000093','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000085','http://purl.obolibrary.org/obo/OBI_0000312','[1..*]','[0.. *]','INTERSECTION_AXIOM','T003e');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000055','[1..*]','[0.. *]','DECLARED','T002d');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000050','[1..*]','[0.. *]','DECLARED','T0034');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/RO_0000059','[1..*]','[0.. *]','DECLARED','T0042');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/PHYSIO_0000065','http://purl.obolibrary.org/obo/PHYSIO_0000008','http://purl.obolibrary.org/obo/OBI_0000312','[1..*]','[0.. *]','DECLARED','T002a');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000058','[1..*]','[0.. *]','DECLARED','T0033');

 call "OntoRelCat".onto_class_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2002/07/owl#Thing','http://purl.obolibrary.org/obo/IAO_0000039','[1..*]','[1.. *]','DECLARED','T0043');

 call "OntoRelCat".onto_data_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2001/XMLSchema#double','http://purl.obolibrary.org/obo/IAO_0000004','[1..1]','DECLARED','T0026');

 call "OntoRelCat".onto_data_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000577','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','T0029');

 call "OntoRelCat".onto_data_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2000/01/rdf-schema#Literal','http://purl.obolibrary.org/obo/IAO_0000004','[1..*]','DECLARED','T0028');

 call "OntoRelCat".onto_data_axiom_ins ('06d9870d-c681-4596-a391-f7c7dbe96fb2','http://purl.obolibrary.org/obo/IAO_0000003','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','T0027');


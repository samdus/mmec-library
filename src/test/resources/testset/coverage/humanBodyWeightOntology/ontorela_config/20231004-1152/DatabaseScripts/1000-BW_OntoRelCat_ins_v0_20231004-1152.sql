/*
-- =========================================================================== A
Schema : BW
Creation Date : 20231004-1152
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Call procedure created to insert data into OntoRelCat schema
-- =========================================================================== A
*/

 call "OntoRelCat".ontorel_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','1.2.2');

 call "OntoRelCat".onto_config_db_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e',
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

 call "OntoRelCat".onto_import_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','OntoRelCat.json','{"OntoRel":{"ontologyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl","label":{"fr":null,"en":null},"dbBaseSchemaId":"BW","ontoRelversion":null,"creationDate":"2023-10-04T11:52:59.481887-04:00"},"Classes":[{"iri":"http://www.w3.org/2002/07/owl#Thing","origin":"DECLARED","tableId":"T0000","label":{"fr":null,"en":null},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000032","origin":"DECLARED","tableId":"T0001","label":{"fr":null,"en":"scalar measurement datum"},"dataAxiomTables":["T002f","T002e"],"classAxiomTables":["T0033","T0032"]},{"iri":"http://purl.obolibrary.org/obo/OBI_0001933","origin":"DECLARED","tableId":"T0002","label":{"fr":null,"en":"value specification"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000020","origin":"DECLARED","tableId":"T0003","label":{"fr":null,"en":"sdc"},"dataAxiomTables":[],"classAxiomTables":["T0034"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000030","origin":"DECLARED","tableId":"T0004","label":{"fr":null,"en":"information content entity"},"dataAxiomTables":[],"classAxiomTables":["T0036","T0035"]},{"iri":"http://purl.obolibrary.org/obo/OBI_0001931","origin":"DECLARED","tableId":"T0005","label":{"fr":null,"en":"scalar value specification"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000016","origin":"DECLARED","tableId":"T0006","label":{"fr":null,"en":"disposition"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000004","origin":"DECLARED","tableId":"T0007","label":{"fr":null,"en":"ic"},"dataAxiomTables":[],"classAxiomTables":["T0037","T0038"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000002","origin":"DECLARED","tableId":"T0008","label":{"fr":null,"en":"continuant"},"dataAxiomTables":[],"classAxiomTables":["T0039"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000009","origin":"DECLARED","tableId":"T0009","label":{"fr":null,"en":"datum label"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000004","origin":"DECLARED","tableId":"T000a","label":{"fr":null,"en":"health care record"},"dataAxiomTables":[],"classAxiomTables":["T003a"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000006","origin":"DECLARED","tableId":"T000b","label":{"fr":null,"en":"medical record identifier"},"dataAxiomTables":[],"classAxiomTables":["T003b"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000027","origin":"DECLARED","tableId":"T000c","label":{"fr":null,"en":"data item"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000008","origin":"DECLARED","tableId":"T000d","label":{"fr":null,"en":"health care provider"},"dataAxiomTables":[],"classAxiomTables":["T003c"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000040","origin":"DECLARED","tableId":"T000e","label":{"fr":null,"en":"material"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX","origin":"INTERSECTION_CLASS","tableId":"T000f","label":{"fr":"HBW_0000006 intersectionOf ","en":"medical record identifier intersectionOf health care record | is about | patient"},"dataAxiomTables":[],"classAxiomTables":["T003d"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000310","origin":"DECLARED","tableId":"T0010","label":{"fr":null,"en":"document"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000003","origin":"DECLARED","tableId":"T0011","label":{"fr":null,"en":"measurement unit label"},"dataAxiomTables":["T0030"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX","origin":"INTERSECTION_CLASS","tableId":"T0012","label":{"fr":"HBW_0000012 intersectionOf ","en":"physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism"},"dataAxiomTables":[],"classAxiomTables":["T003e"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000010","origin":"DECLARED","tableId":"T0013","label":{"fr":null,"en":"health care provider role"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000012","origin":"DECLARED","tableId":"T0014","label":{"fr":null,"en":"physiological evaluation"},"dataAxiomTables":[],"classAxiomTables":["T0040","T003f"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000002","origin":"DECLARED","tableId":"T0015","label":{"fr":null,"en":"RAMQ vulnerability code"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000014","origin":"DECLARED","tableId":"T0016","label":{"fr":null,"en":"obesity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000019","origin":"DECLARED","tableId":"T0017","label":{"fr":null,"en":"quality"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000017","origin":"DECLARED","tableId":"T0018","label":{"fr":null,"en":"realizable"},"dataAxiomTables":[],"classAxiomTables":["T0041"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000001","origin":"DECLARED","tableId":"T0019","label":{"fr":null,"en":"entity"},"dataAxiomTables":[],"classAxiomTables":["T0042"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000023","origin":"DECLARED","tableId":"T001a","label":{"fr":null,"en":"role"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OGMS_0000031","origin":"DECLARED","tableId":"T001b","label":{"fr":null,"en":"disease"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX","origin":"INTERSECTION_CLASS","tableId":"T001c","label":{"fr":"HBW_0000012 intersectionOf  intersectionOf ","en":"physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000031","origin":"DECLARED","tableId":"T001d","label":{"fr":null,"en":"gdc"},"dataAxiomTables":[],"classAxiomTables":["T0043"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000015","origin":"DECLARED","tableId":"T001e","label":{"fr":null,"en":"process"},"dataAxiomTables":[],"classAxiomTables":["T0044"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000003","origin":"DECLARED","tableId":"T001f","label":{"fr":null,"en":"occurrent"},"dataAxiomTables":[],"classAxiomTables":["T0045","T0046"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000005","origin":"DECLARED","tableId":"T0020","label":{"fr":null,"en":"physiological evaluation report"},"dataAxiomTables":[],"classAxiomTables":["T0047","T0048"]},{"iri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0","origin":"INTERSECTION_EL_CLASS","tableId":"T0021","label":{"fr":"HBW_0000012 intersectionOf  intersectionOf  el ","en":"physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality"},"dataAxiomTables":[],"classAxiomTables":["T0049"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000007","origin":"DECLARED","tableId":"T0022","label":{"fr":null,"en":"patient"},"dataAxiomTables":[],"classAxiomTables":["T004a"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000028","origin":"DECLARED","tableId":"T0023","label":{"fr":null,"en":"symbol"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000009","origin":"DECLARED","tableId":"T0024","label":{"fr":null,"en":"body weight"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000577","origin":"DECLARED","tableId":"T0025","label":{"fr":null,"en":"centrally registered identifier symbol"},"dataAxiomTables":["T0031"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","origin":"DECLARED","tableId":"T0026","label":{"fr":null,"en":"Homo sapiens"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OBI_0100026","origin":"DECLARED","tableId":"T0027","label":{"fr":null,"en":"organism"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000011","origin":"DECLARED","tableId":"T0028","label":{"fr":null,"en":"patient role"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OBI_0000011","origin":"DECLARED","tableId":"T0029","label":{"fr":null,"en":"planned process"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000001","origin":"DECLARED","tableId":"T002a","label":{"fr":null,"en":"physiological data item"},"dataAxiomTables":[],"classAxiomTables":["T004b"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000013","origin":"DECLARED","tableId":"T002b","label":{"fr":null,"en":"physiological evaluation from health care provider"},"dataAxiomTables":[],"classAxiomTables":["T004c"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000109","origin":"DECLARED","tableId":"T002c","label":{"fr":null,"en":"measurement datum"},"dataAxiomTables":[],"classAxiomTables":["T004e","T004d"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000003","origin":"DECLARED","tableId":"T002d","label":{"fr":null,"en":"weight unit"},"dataAxiomTables":[],"classAxiomTables":[]}],"Types":[],"ObjectProperties":[],"DataProperties":[{"iri":"http://purl.obolibrary.org/obo/IAO_0000004","label":{"fr":null,"en":"has measurement value"},"domainClassIri":["http://purl.obolibrary.org/obo/IAO_0000032"],"rangeDataTypeIri":"http://www.w3.org/2001/XMLSchema#double"},{"iri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","label":{"fr":null,"en":"has value"},"domainClassIri":[],"rangeDataTypeIri":null},{"iri":"http://www.w3.org/2002/07/owl#topDataProperty","label":{"fr":null,"en":null},"domainClassIri":[],"rangeDataTypeIri":null}],"IsaAxioms":[{"subClassIri":"BFO_0000017","subClassTableId":"T0018","superClassIri":"BFO_0000020","superClassTableId":"T0003"},{"subClassIri":"HBW_0000003","subClassTableId":"T002d","superClassIri":"IAO_0000003","superClassTableId":"T0011"},{"subClassIri":"ONTORELA_C002aX","subClassTableId":"T000f","superClassIri":"HBW_0000004","superClassTableId":"T000a"},{"subClassIri":"HBW_0000006","subClassTableId":"T000b","superClassIri":"IAO_0000577","superClassTableId":"T0025"},{"subClassIri":"HBW_0000007","subClassTableId":"T0022","superClassIri":"OBI_0100026","superClassTableId":"T0027"},{"subClassIri":"OGMS_0000031","subClassTableId":"T001b","superClassIri":"BFO_0000016","superClassTableId":"T0006"},{"subClassIri":"IAO_0000030","subClassTableId":"T0004","superClassIri":"BFO_0000031","superClassTableId":"T001d"},{"subClassIri":"HBW_0000010","subClassTableId":"T0013","superClassIri":"BFO_0000023","superClassTableId":"T001a"},{"subClassIri":"IAO_0000027","subClassTableId":"T000c","superClassIri":"IAO_0000030","superClassTableId":"T0004"},{"subClassIri":"ONTORELA_C002eX-el0","subClassTableId":"T0021","superClassIri":"Thing","superClassTableId":"T0000"},{"subClassIri":"IAO_0000003","subClassTableId":"T0011","superClassIri":"IAO_0000009","superClassTableId":"T0009"},{"subClassIri":"IAO_0000032","subClassTableId":"T0001","superClassIri":"IAO_0000109","superClassTableId":"T002c"},{"subClassIri":"HBW_0000011","subClassTableId":"T0028","superClassIri":"BFO_0000023","superClassTableId":"T001a"},{"subClassIri":"BFO_0000015","subClassTableId":"T001e","superClassIri":"BFO_0000003","superClassTableId":"T001f"},{"subClassIri":"OBI_0100026","subClassTableId":"T0027","superClassIri":"BFO_0000040","superClassTableId":"T000e"},{"subClassIri":"BFO_0000020","subClassTableId":"T0003","superClassIri":"BFO_0000002","superClassTableId":"T0008"},{"subClassIri":"BFO_0000002","subClassTableId":"T0008","superClassIri":"BFO_0000001","superClassTableId":"T0019"},{"subClassIri":"HBW_0000002","subClassTableId":"T0015","superClassIri":"IAO_0000027","superClassTableId":"T000c"},{"subClassIri":"BFO_0000004","subClassTableId":"T0007","superClassIri":"BFO_0000002","superClassTableId":"T0008"},{"subClassIri":"IAO_0000577","subClassTableId":"T0025","superClassIri":"IAO_0000028","superClassTableId":"T0023"},{"subClassIri":"OBI_0001931","subClassTableId":"T0005","superClassIri":"OBI_0001933","superClassTableId":"T0002"},{"subClassIri":"ONTORELA_C002eX","subClassTableId":"T001c","superClassIri":"ONTORELA_C002eX-el0","superClassTableId":"T0021"},{"subClassIri":"HBW_0000004","subClassTableId":"T000a","superClassIri":"IAO_0000310","superClassTableId":"T0010"},{"subClassIri":"ONTORELA_C002cX","subClassTableId":"T0012","superClassIri":"IAO_0000027","superClassTableId":"T000c"},{"subClassIri":"IAO_0000310","subClassTableId":"T0010","superClassIri":"IAO_0000030","superClassTableId":"T0004"},{"subClassIri":"HBW_0000013","subClassTableId":"T002b","superClassIri":"HBW_0000012","superClassTableId":"T0014"},{"subClassIri":"HBW_0000008","subClassTableId":"T000d","superClassIri":"NCBITaxon_9606","superClassTableId":"T0026"},{"subClassIri":"BFO_0000023","subClassTableId":"T001a","superClassIri":"BFO_0000017","superClassTableId":"T0018"},{"subClassIri":"IAO_0000028","subClassTableId":"T0023","superClassIri":"IAO_0000030","superClassTableId":"T0004"},{"subClassIri":"BFO_0000019","subClassTableId":"T0017","superClassIri":"BFO_0000020","superClassTableId":"T0003"},{"subClassIri":"HBW_0000014","subClassTableId":"T0016","superClassIri":"OGMS_0000031","superClassTableId":"T001b"},{"subClassIri":"BFO_0000016","subClassTableId":"T0006","superClassIri":"BFO_0000017","superClassTableId":"T0018"},{"subClassIri":"BFO_0000019","subClassTableId":"T0017","superClassIri":"ONTORELA_C002eX-el0","superClassTableId":"T0021"},{"subClassIri":"HBW_0000005","subClassTableId":"T0020","superClassIri":"IAO_0000310","superClassTableId":"T0010"},{"subClassIri":"IAO_0000009","subClassTableId":"T0009","superClassIri":"IAO_0000030","superClassTableId":"T0004"},{"subClassIri":"HBW_0000009","subClassTableId":"T0024","superClassIri":"BFO_0000019","superClassTableId":"T0017"},{"subClassIri":"HBW_0000001","subClassTableId":"T002a","superClassIri":"IAO_0000027","superClassTableId":"T000c"},{"subClassIri":"IAO_0000109","subClassTableId":"T002c","superClassIri":"IAO_0000027","superClassTableId":"T000c"},{"subClassIri":"OBI_0001933","subClassTableId":"T0002","superClassIri":"IAO_0000030","superClassTableId":"T0004"},{"subClassIri":"HBW_0000012","subClassTableId":"T0014","superClassIri":"OBI_0000011","superClassTableId":"T0029"},{"subClassIri":"BFO_0000001","subClassTableId":"T0019","superClassIri":"Thing","superClassTableId":"T0000"},{"subClassIri":"BFO_0000040","subClassTableId":"T000e","superClassIri":"BFO_0000004","superClassTableId":"T0007"},{"subClassIri":"OBI_0000011","subClassTableId":"T0029","superClassIri":"BFO_0000015","superClassTableId":"T001e"},{"subClassIri":"BFO_0000003","subClassTableId":"T001f","superClassIri":"BFO_0000001","superClassTableId":"T0019"},{"subClassIri":"NCBITaxon_9606","subClassTableId":"T0026","superClassIri":"OBI_0100026","superClassTableId":"T0027"},{"subClassIri":"BFO_0000031","subClassTableId":"T001d","superClassIri":"BFO_0000002","superClassTableId":"T0008"},{"subClassIri":"BFO_0000016","subClassTableId":"T0006","superClassIri":"ONTORELA_C002eX-el0","superClassTableId":"T0021"}],"ClassAxioms":[{"expression":"BFO_0000004 [1..*] RO_0000087 BFO_0000023","origin":"DECLARED","tableId":"T0037","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","domainTableId":"T0007","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000023","rangeTableId":"T001a","propertyIri":"http://purl.obolibrary.org/obo/RO_0000087","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000032 [1..*] IAO_0000039 Thing","origin":"DECLARED","tableId":"T0033","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"T0001","rangeClassIri":"http://www.w3.org/2002/07/owl#Thing","rangeTableId":"T0000","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000039","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"1","max":"*"}},{"expression":"IAO_0000030 [1..*] IAO_0000219 BFO_0000001","origin":"DECLARED","tableId":"T0036","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000030","domainTableId":"T0004","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"T0019","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000219","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000006 [1..1] IAO_0000219 ONTORELA_C002aX","origin":"INTERSECTION_AXIOM","tableId":"T003b","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000006","domainTableId":"T000b","rangeClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX","rangeTableId":"T000f","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000219","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000002 [1..*] RO_0000056 BFO_0000003","origin":"DECLARED","tableId":"T0039","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000002","domainTableId":"T0008","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","rangeTableId":"T001f","propertyIri":"http://purl.obolibrary.org/obo/RO_0000056","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000012 [1..1] PHYSIO_0000089 NCBITaxon_9606","origin":"DECLARED","tableId":"T0040","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000012","domainTableId":"T0014","rangeClassIri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","rangeTableId":"T0026","propertyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000109 [1..*] OBI_0001938 OBI_0001933","origin":"DECLARED","tableId":"T004e","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000109","domainTableId":"T002c","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0001933","rangeTableId":"T0002","propertyIri":"http://purl.obolibrary.org/obo/OBI_0001938","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000008 [1..*] RO_0000087 HBW_0000010","origin":"INTERSECTION_AXIOM","tableId":"T003c","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000008","domainTableId":"T000d","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000010","rangeTableId":"T0013","propertyIri":"http://purl.obolibrary.org/obo/RO_0000087","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000005 [1..*] BFO_0000051 HBW_0000001","origin":"DECLARED","tableId":"T0047","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000005","domainTableId":"T0020","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000001","rangeTableId":"T002a","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000051","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000005 [1..1] BFO_0000051 HBW_0000006","origin":"DECLARED","tableId":"T0048","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000005","domainTableId":"T0020","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000006","rangeTableId":"T000b","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000051","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000017 [1..*] BFO_0000054 BFO_0000015","origin":"DECLARED","tableId":"T0041","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000017","domainTableId":"T0018","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000015","rangeTableId":"T001e","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000054","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000001 [1..*] BFO_0000050 BFO_0000001","origin":"DECLARED","tableId":"T0042","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","domainTableId":"T0019","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"T0019","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000050","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000032 [1..*] OBI_0001938 OBI_0001931","origin":"DECLARED","tableId":"T0032","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"T0001","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0001931","rangeTableId":"T0005","propertyIri":"http://purl.obolibrary.org/obo/OBI_0001938","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000003 [1..*] RO_0000057 BFO_0000002","origin":"DECLARED","tableId":"T0046","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","domainTableId":"T001f","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000002","rangeTableId":"T0008","propertyIri":"http://purl.obolibrary.org/obo/RO_0000057","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000109 [1..1] IAO_0000039 IAO_0000003","origin":"DECLARED","tableId":"T004d","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000109","domainTableId":"T002c","rangeClassIri":"http://purl.obolibrary.org/obo/IAO_0000003","rangeTableId":"T0011","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000039","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"1","max":"*"}},{"expression":"IAO_0000030 [1..*] IAO_0000136 BFO_0000001","origin":"DECLARED","tableId":"T0035","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000030","domainTableId":"T0004","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"T0019","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"ONTORELA_C002aX [1..*] IAO_0000136 HBW_0000007","origin":"INTERSECTION_AXIOM","tableId":"T003d","domainClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX","domainTableId":"T000f","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000007","rangeTableId":"T0022","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000003 [1..*] BFO_0000066 BFO_0000004","origin":"DECLARED","tableId":"T0045","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","domainTableId":"T001f","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","rangeTableId":"T0007","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000066","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000004 [1..*] RO_0001025 BFO_0000004","origin":"DECLARED","tableId":"T0038","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","domainTableId":"T0007","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","rangeTableId":"T0007","propertyIri":"http://purl.obolibrary.org/obo/RO_0001025","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"ONTORELA_C002cX [1..*] IAO_0000136 ONTORELA_C002eX","origin":"INTERSECTION_AXIOM","tableId":"T003e","domainClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX","domainTableId":"T0012","rangeClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX","rangeTableId":"T001c","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000004 [1..*] IAO_0000136 OBI_0100026","origin":"DECLARED","tableId":"T003a","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000004","domainTableId":"T000a","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0100026","rangeTableId":"T0027","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000012 [1..*] OBI_0000299 ONTORELA_C002cX","origin":"INTERSECTION_AXIOM","tableId":"T003f","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000012","domainTableId":"T0014","rangeClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX","rangeTableId":"T0012","propertyIri":"http://purl.obolibrary.org/obo/OBI_0000299","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000015 [1..*] BFO_0000055 BFO_0000017","origin":"DECLARED","tableId":"T0044","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000015","domainTableId":"T001e","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000017","rangeTableId":"T0018","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000055","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"ONTORELA_C002eX-el0 [1..*] RO_0000052 OBI_0100026","origin":"UNION_AXIOM","tableId":"T0049","domainClassIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0","domainTableId":"T0021","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0100026","rangeTableId":"T0027","propertyIri":"http://purl.obolibrary.org/obo/RO_0000052","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000001 [1..*] OBI_0000312 HBW_0000012","origin":"INTERSECTION_AXIOM","tableId":"T004b","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000001","domainTableId":"T002a","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000012","rangeTableId":"T0014","propertyIri":"http://purl.obolibrary.org/obo/OBI_0000312","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000007 [1..*] RO_0000087 HBW_0000011","origin":"INTERSECTION_AXIOM","tableId":"T004a","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000007","domainTableId":"T0022","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000011","rangeTableId":"T0028","propertyIri":"http://purl.obolibrary.org/obo/RO_0000087","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000031 [1..*] RO_0000058 BFO_0000020","origin":"DECLARED","tableId":"T0043","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000031","domainTableId":"T001d","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000020","rangeTableId":"T0003","propertyIri":"http://purl.obolibrary.org/obo/RO_0000058","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000013 [1..1] PHYSIO_0000089 HBW_0000008","origin":"INTERSECTION_AXIOM","tableId":"T004c","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000013","domainTableId":"T002b","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000008","rangeTableId":"T000d","propertyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000020 [1..*] RO_0000059 BFO_0000031","origin":"DECLARED","tableId":"T0034","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000020","domainTableId":"T0003","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000031","rangeTableId":"T001d","propertyIri":"http://purl.obolibrary.org/obo/RO_0000059","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}}],"DataAxioms":[{"expression":"IAO_0000003 [1..1] PHYSIO_0000100 string","tableId":"T0030","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000003","domainTableId":"T0011","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0000577 [1..1] PHYSIO_0000100 string","tableId":"T0031","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000577","domainTableId":"T0025","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0000032 [1..*] IAO_0000004 Literal","tableId":"T002f","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"T0001","rangeClassIri":"http://www.w3.org/2000/01/rdf-schema#Literal","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/IAO_0000004","domainParticipation":{"min":"1","max":"*"}},{"expression":"IAO_0000032 [1..1] IAO_0000004 double","tableId":"T002e","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"T0001","rangeClassIri":"http://www.w3.org/2001/XMLSchema#double","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/IAO_0000004","domainParticipation":{"min":"1","max":"1"}}]}','2023-10-04T11:52:59.561998-04:00');

 call "OntoRelCat".onto_schema_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','BW','en','BASE');

 call "OntoRelCat".ontology_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl','HumanBodyWeightAppli_couverture-inferred.owl','humanbodyweight-appli.owl','','2023-10-04T15:48:43Z');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://www.w3.org/2002/07/owl#Thing','T0000','DECLARED');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://www.w3.org/2002/07/owl#Thing','en','The class owl:Thing is the class of all individuals.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','T0001','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','en','scalar measurement datum');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','en','a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0001933','T0002','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0001933','en','value specification');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0001933','en','An information content entity that specifies a value within a classification scheme or on a quantitative scale.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000020','T0003','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000020','en','specifically dependent continuant');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000020','en','b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000030','T0004','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000030','en','information content entity');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000030','en','An information content entity is an entity that is generically dependent on some artifact and stands in relation of aboutness to some entity');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0001931','T0005','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0001931','en','scalar value specification');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0001931','en','A value specification that consists of two parts: a numeral and a unit label');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000016','T0006','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000016','en','disposition');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000016','en','Disposition');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000004','T0007','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000004','en','independent continuant');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000004','en','A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000002','T0008','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000002','en','continuant');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000002','en','
An entity that exists in full at any time in which it exists at all, persists through time while maintaining its identity and has no temporal parts.
');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000009','T0009','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000009','en','datum label');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000009','en','A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000004','T000a','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000004','en','health care record');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000004','en','A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000006','T000b','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000006','en','medical record identifier');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000006','en','A CRID symbol that is sufficent to look up a patient file in a medical record registry.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000027','T000c','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000027','en','data item');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000027','en','a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000008','T000d','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000008','en','health care provider');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000008','en','A homo sapiens having with the health care provider role');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000040','T000e','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000040','en','material entity');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000040','en','MaterialEntity');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX','T000f','INTERSECTION_CLASS');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX','fr','HBW_0000006 intersectionOf ');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX','en','medical record identifier intersectionOf health care record | is about | patient');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX','fr','HBW_0000006 intersectionOf ');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX','en','medical record identifier intersectionOf A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. is_about is a (currently) primitive relation that relates an information artifact to an entity. An organism having the role of patient.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000310','T0010','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000310','en','document');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000310','en','An information content entity that is a collection of information content entities intended to be understood together as a whole.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000003','T0011','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000003','en','measurement unit label');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000003','en','A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX','T0012','INTERSECTION_CLASS');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX','fr','HBW_0000012 intersectionOf ');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX','en','physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX','fr','HBW_0000012 intersectionOf ');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX','en','physiological evaluation intersectionOf a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. is_about is a (currently) primitive relation that relates an information artifact to an entity. a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000010','T0013','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000010','en','health care provider role');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000010','en','A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000012','T0014','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000012','en','physiological evaluation');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000012','en','A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000002','T0015','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000002','en','RAMQ vulnerability code');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000002','en','A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000014','T0016','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000014','en','obesity');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000014','en','A disease marked by an abnormally high, unhealthy amount of body fat.; A disorder characterized by having an increased body fat.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000019','T0017','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000019','en','quality');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000019','en','Quality');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000017','T0018','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000017','en','realizable entity');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000017','en','A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000001','T0019','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000001','en','entity');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000001','en','per discussion with Barry Smith');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000023','T001a','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000023','en','role');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000023','en','Role');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OGMS_0000031','T001b','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OGMS_0000031','en','disease');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OGMS_0000031','en','A disposition (i) to undergo pathological processes that (ii) exists in an organism because of one or more disorders in that organism.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX','T001c','INTERSECTION_CLASS');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX','fr','HBW_0000012 intersectionOf  intersectionOf ');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX','en','physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX','fr','HBW_0000012 intersectionOf  intersectionOf ');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX','en','physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality a relation between a specifically dependent continuant (the dependent) and an independent continuant (the bearer), in which the dependent specifically depends on the bearer for its existence A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000031','T001d','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000031','en','generically dependent continuant');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000031','en','b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001])');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000015','T001e','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000015','en','process');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000015','en','
An occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t.
');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000003','T001f','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000003','en','occurrent');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000003','en','An entity that has temporal parts and that happens, unfolds or develops through time.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000005','T0020','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000005','en','physiological evaluation report');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000005','en','A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0','T0021','INTERSECTION_EL_CLASS');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0','fr','HBW_0000012 intersectionOf  intersectionOf  el ');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0','en','physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el disposition | quality');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0','fr','HBW_0000012 intersectionOf  intersectionOf  el ');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0','en','physiological evaluation intersectionOf data item | is about | inheres in | disposition | quality | organism intersectionOf disposition | quality | inheres in | organism el realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Disposition a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized Quality');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000007','T0022','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000007','en','patient');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000007','en','An organism having the role of patient.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000028','T0023','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000028','en','symbol');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000028','en','An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000009','T0024','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000009','en','body weight');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000009','en','a quality of a body of having a weight');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000577','T0025','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000577','en','centrally registered identifier symbol');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000577','en','A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/NCBITaxon_9606','T0026','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/NCBITaxon_9606','en','Homo sapiens');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/NCBITaxon_9606','en','Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0100026','T0027','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0100026','en','organism');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0100026','en','A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000011','T0028','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000011','en','patient role');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000011','en','a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0000011','T0029','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0000011','en','planned process');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0000011','en','A process that realizes a plan which is the concretization of a plan specification.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000001','T002a','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000001','en','physiological data item');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000001','en','A data item that is the specified output of some physiological evaluation.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000013','T002b','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000013','en','physiological evaluation from health care provider');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000013','en','A physiological evaluation that is evaluated by a health care provider');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000109','T002c','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000109','en','measurement datum');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000109','en','A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.');

 call "OntoRelCat".onto_class_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000003','T002d','DECLARED');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000003','en','weight unit');

 call "OntoRelCat".definition_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000003','en','a measurement unit label of a weight');

 call "OntoRelCat".onto_data_properties_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000004');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000004','en','has measurement value');

 call "OntoRelCat".onto_data_properties_domain_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000004');

 call "OntoRelCat".onto_data_properties_range_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://www.w3.org/2001/XMLSchema#double','http://purl.obolibrary.org/obo/IAO_0000004', 'DOUBLE PRECISION');

 call "OntoRelCat".onto_data_properties_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/PHYSIO_0000100');

 call "OntoRelCat".label_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/PHYSIO_0000100','en','has value');

 call "OntoRelCat".onto_data_properties_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://www.w3.org/2002/07/owl#topDataProperty');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000020');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000003','http://purl.obolibrary.org/obo/IAO_0000003');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX','http://purl.obolibrary.org/obo/HBW_0000004');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/IAO_0000577');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000007','http://purl.obolibrary.org/obo/OBI_0100026');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OGMS_0000031','http://purl.obolibrary.org/obo/BFO_0000016');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000031');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000010','http://purl.obolibrary.org/obo/BFO_0000023');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000027','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0','http://www.w3.org/2002/07/owl#Thing');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000009');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000109');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000011','http://purl.obolibrary.org/obo/BFO_0000023');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000003');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/BFO_0000040');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000001');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000002','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000577','http://purl.obolibrary.org/obo/IAO_0000028');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0001931','http://purl.obolibrary.org/obo/OBI_0001933');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000004','http://purl.obolibrary.org/obo/IAO_0000310');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000310','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000013','http://purl.obolibrary.org/obo/HBW_0000012');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000008','http://purl.obolibrary.org/obo/NCBITaxon_9606');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/BFO_0000017');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000028','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000019','http://purl.obolibrary.org/obo/BFO_0000020');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000014','http://purl.obolibrary.org/obo/OGMS_0000031');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000016','http://purl.obolibrary.org/obo/BFO_0000017');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000019','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000005','http://purl.obolibrary.org/obo/IAO_0000310');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000009','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000009','http://purl.obolibrary.org/obo/BFO_0000019');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000001','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0001933','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/OBI_0000011');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000001','http://www.w3.org/2002/07/owl#Thing');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000040','http://purl.obolibrary.org/obo/BFO_0000004');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/BFO_0000015');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000001');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/OBI_0100026');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000016','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','DECLARED','T0037');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2002/07/owl#Thing','http://purl.obolibrary.org/obo/IAO_0000039','[1..*]','[1.. *]','DECLARED','T0033');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000219','[1..*]','[0.. *]','DECLARED','T0036');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX','http://purl.obolibrary.org/obo/IAO_0000219','[1..1]','[0.. *]','INTERSECTION_AXIOM','T003b');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/RO_0000056','[1..*]','[0.. *]','DECLARED','T0039');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089','[1..1]','[0.. *]','DECLARED','T0040');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/OBI_0001933','http://purl.obolibrary.org/obo/OBI_0001938','[1..*]','[0.. *]','DECLARED','T004e');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000008','http://purl.obolibrary.org/obo/HBW_0000010','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','INTERSECTION_AXIOM','T003c');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000005','http://purl.obolibrary.org/obo/HBW_0000001','http://purl.obolibrary.org/obo/BFO_0000051','[1..*]','[0.. *]','DECLARED','T0047');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000005','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/BFO_0000051','[1..1]','[0.. *]','DECLARED','T0048');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000054','[1..*]','[0.. *]','DECLARED','T0041');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000050','[1..*]','[0.. *]','DECLARED','T0042');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/OBI_0001931','http://purl.obolibrary.org/obo/OBI_0001938','[1..*]','[0.. *]','DECLARED','T0032');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/RO_0000057','[1..*]','[0.. *]','DECLARED','T0046');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000039','[1..1]','[1.. *]','DECLARED','T004d');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','T0035');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002aX','http://purl.obolibrary.org/obo/HBW_0000007','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','INTERSECTION_AXIOM','T003d');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000066','[1..*]','[0.. *]','DECLARED','T0045');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0001025','[1..*]','[0.. *]','DECLARED','T0038');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','INTERSECTION_AXIOM','T003e');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000004','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','T003a');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002cX','http://purl.obolibrary.org/obo/OBI_0000299','[1..*]','[0.. *]','INTERSECTION_AXIOM','T003f');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000055','[1..*]','[0.. *]','DECLARED','T0044');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl#ONTORELA_C002eX-el0','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/RO_0000052','[1..*]','[0.. *]','UNION_AXIOM','T0049');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000001','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/OBI_0000312','[1..*]','[0.. *]','INTERSECTION_AXIOM','T004b');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000007','http://purl.obolibrary.org/obo/HBW_0000011','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','INTERSECTION_AXIOM','T004a');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000058','[1..*]','[0.. *]','DECLARED','T0043');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/HBW_0000013','http://purl.obolibrary.org/obo/HBW_0000008','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089','[1..1]','[0.. *]','INTERSECTION_AXIOM','T004c');

 call "OntoRelCat".onto_class_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/RO_0000059','[1..*]','[0.. *]','DECLARED','T0034');

 call "OntoRelCat".onto_data_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000003','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','T0030');

 call "OntoRelCat".onto_data_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000577','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','T0031');

 call "OntoRelCat".onto_data_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2000/01/rdf-schema#Literal','http://purl.obolibrary.org/obo/IAO_0000004','[1..*]','DECLARED','T002f');

 call "OntoRelCat".onto_data_axiom_ins ('189a3f74-a1a9-4774-ae47-ca02ce6a056e','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2001/XMLSchema#double','http://purl.obolibrary.org/obo/IAO_0000004','[1..1]','DECLARED','T002e');


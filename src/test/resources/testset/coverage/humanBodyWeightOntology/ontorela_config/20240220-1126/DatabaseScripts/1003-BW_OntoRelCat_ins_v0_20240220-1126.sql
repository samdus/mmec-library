/*
-- =========================================================================== A
Schema : BW
Creation Date : 20240220-1126
Encoding : UTF-8, sans BOM, fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.6
Responsable : OntoRelA
Version : v0
Status : dev
Objet :
  Call procedure created to insert data into OntoRelCat schema
-- =========================================================================== A
*/

 call "OntoRelCat".ontorel_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','1.2.2');

 call "OntoRelCat".onto_config_db_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372',
                            'uid',
                            'uid_domain',
                            'TEXT',
                            'value',
                            'value_domain',
                            'TEXT',
                            '60',
                            'true',
                            'false',
                            'false',
                            'false');

 call "OntoRelCat".onto_import_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','OntoRelCat.json','{"OntoRel":{"ontologyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl","label":{"fr":null,"en":null},"dbBaseSchemaId":"BW","ontoRelversion":null,"creationDate":"2024-02-20T11:26:36.667206-05:00"},"Classes":[{"iri":"http://www.w3.org/2002/07/owl#Thing","origin":"DECLARED","tableId":"Thing","label":{"fr":null,"en":null},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000002","origin":"DECLARED","tableId":"HBW_0000002","label":{"fr":null,"en":"RAMQ vulnerability code"},"dataAxiomTables":["HBW_0000002_PHYSIO_0000100_string"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/VO_0001194","origin":"DECLARED","tableId":"VO_0001194","label":{"fr":null,"en":"biological sex datum"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000022","origin":"DECLARED","tableId":"HBW_0000022","label":{"fr":null,"en":"human name"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000022_IAO_0000219_NCBITaxon_9606","HBW_0000022_BFO_0000051_IAO_0020017","HBW_0000022_BFO_0000051_IAO_0020015"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000010","origin":"DECLARED","tableId":"HBW_0000010","label":{"fr":null,"en":"health care provider role"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000006","origin":"DECLARED","tableId":"HBW_0000006","label":{"fr":null,"en":"medical record identifier"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000009","origin":"DECLARED","tableId":"IAO_0000009","label":{"fr":null,"en":"datum label"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000026","origin":"DECLARED","tableId":"HBW_0000026","label":{"fr":"weight measurement datum","en":null},"dataAxiomTables":["HBW_0000026_IAO_0000004_decimal"],"classAxiomTables":["HBW_0000026_IAO_0000039_HBW_0000003"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000014","origin":"DECLARED","tableId":"HBW_0000014","label":{"fr":null,"en":"obesity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000020","origin":"DECLARED","tableId":"BFO_0000020","label":{"fr":null,"en":"specifically dependent continuant"},"dataAxiomTables":[],"classAxiomTables":["BFO_0000020_RO_0000059_BFO_0000031"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000040","origin":"DECLARED","tableId":"BFO_0000040","label":{"fr":null,"en":"material entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000016","origin":"DECLARED","tableId":"BFO_0000016","label":{"fr":null,"en":"disposition"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OGMS_0000031","origin":"DECLARED","tableId":"OGMS_0000031","label":{"fr":null,"en":"disease"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000004","origin":"DECLARED","tableId":"BFO_0000004","label":{"fr":null,"en":"independent continuant"},"dataAxiomTables":[],"classAxiomTables":["BFO_0000004_RO_0001025_BFO_0000004","BFO_0000004_RO_0000087_BFO_0000023"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0020015","origin":"DECLARED","tableId":"IAO_0020015","label":{"fr":null,"en":"personal name"},"dataAxiomTables":["IAO_0020015_PHYSIO_0000100_string"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OMRSE_00000209","origin":"DECLARED","tableId":"OMRSE_00000209","label":{"fr":null,"en":"gender identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OBI_0100026","origin":"DECLARED","tableId":"OBI_0100026","label":{"fr":null,"en":"organism"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","origin":"DECLARED","tableId":"NCBITaxon_9606","label":{"fr":null,"en":"Homo sapiens"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000032","origin":"DECLARED","tableId":"IAO_0000032","label":{"fr":null,"en":"scalar measurement datum"},"dataAxiomTables":["IAO_0000032_IAO_0000004_Literal","IAO_0000032_IAO_0000004_double"],"classAxiomTables":["IAO_0000032_IAO_0000039_IAO_0000003"]},{"iri":"http://purl.obolibrary.org/obo/IOIO_0000012","origin":"DECLARED","tableId":"IOIO_0000012","label":{"fr":null,"en":"human biological sex or gender identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000013","origin":"DECLARED","tableId":"HBW_0000013","label":{"fr":null,"en":"physiological evaluation from health care provider"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000013_PHYSIO_0000089_HBW_0000008"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000028","origin":"DECLARED","tableId":"IAO_0000028","label":{"fr":null,"en":"symbol"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000001","origin":"DECLARED","tableId":"HBW_0000001","label":{"fr":null,"en":"physiological data item"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000001_OBI_0000312_HBW_0000012"]},{"iri":"http://purl.obolibrary.org/obo/OMRSE_00000210","origin":"DECLARED","tableId":"OMRSE_00000210","label":{"fr":null,"en":"female gender identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000109","origin":"DECLARED","tableId":"IAO_0000109","label":{"fr":null,"en":"measurement datum"},"dataAxiomTables":[],"classAxiomTables":["IAO_0000109_IAO_0000039_IAO_0000003"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000005","origin":"DECLARED","tableId":"HBW_0000005","label":{"fr":null,"en":"physiological evaluation report"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000005_BFO_0000051_HBW_0000001","HBW_0000005_BFO_0000051_HBW_0000006"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000025","origin":"DECLARED","tableId":"HBW_0000025","label":{"fr":null,"en":"female biological sex or gender identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000009","origin":"DECLARED","tableId":"HBW_0000009","label":{"fr":null,"en":"body weight"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/NOYO_0000012","origin":"DECLARED","tableId":"NOYO_0000012","label":{"fr":null,"en":"informational entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb","origin":"INTERSECTION_CLASS","tableId":"ONTORELA_C61c354fb","label":{"fr":"IAO_0000027\n and (IAO_0000136 some \n    ((BFO_0000016 or BFO_0000019)\n     and (RO_0000052 some OBI_0100026)))","en":"data item\n and (is about some \n    ((disposition or quality)\n     and (inheres in some organism)))"},"dataAxiomTables":[],"classAxiomTables":["ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108"]},{"iri":"http://purl.obolibrary.org/obo/VO_0004895","origin":"DECLARED","tableId":"VO_0004895","label":{"fr":null,"en":"female biological sex datum"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000017","origin":"DECLARED","tableId":"BFO_0000017","label":{"fr":null,"en":"realizable entity"},"dataAxiomTables":[],"classAxiomTables":["BFO_0000017_BFO_0000054_BFO_0000015"]},{"iri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0","origin":"INTERSECTION_EL_CLASS","tableId":"ONTORELA_C2986e108-el0","label":{"fr":"BFO_0000016 or BFO_0000019","en":"disposition or quality"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000001","origin":"DECLARED","tableId":"BFO_0000001","label":{"fr":null,"en":"entity"},"dataAxiomTables":[],"classAxiomTables":["BFO_0000001_BFO_0000050_BFO_0000001"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000310","origin":"DECLARED","tableId":"IAO_0000310","label":{"fr":null,"en":"document"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000003","origin":"DECLARED","tableId":"IAO_0000003","label":{"fr":null,"en":"measurement unit label"},"dataAxiomTables":["IAO_0000003_PHYSIO_0000100_string"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000024","origin":"DECLARED","tableId":"HBW_0000024","label":{"fr":null,"en":"intersex biological sex or non-binary gender identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OMRSE_00000211","origin":"DECLARED","tableId":"OMRSE_00000211","label":{"fr":null,"en":"male gender identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000012","origin":"DECLARED","tableId":"HBW_0000012","label":{"fr":null,"en":"physiological evaluation"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000012_OBI_0000299_ONTORELA_C61c354fb","HBW_0000012_PHYSIO_0000089_NCBITaxon_9606"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000027","origin":"DECLARED","tableId":"IAO_0000027","label":{"fr":null,"en":"data item"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/VO_0000613","origin":"DECLARED","tableId":"VO_0000613","label":{"fr":null,"en":"male biological sex datum"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45","origin":"INTERSECTION_CLASS","tableId":"ONTORELA_C4d0c3f45","label":{"fr":"HBW_0000004\n and (IAO_0000136 some HBW_0000007)","en":"health care record\n and (is about some patient)"},"dataAxiomTables":[],"classAxiomTables":["ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0020000","origin":"DECLARED","tableId":"IAO_0020000","label":{"fr":null,"en":"identifier"},"dataAxiomTables":[],"classAxiomTables":["IAO_0020000_IAO_0000219_BFO_0000001"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000004","origin":"DECLARED","tableId":"HBW_0000004","label":{"fr":null,"en":"health care record"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000004_IAO_0000136_OBI_0100026"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000008","origin":"DECLARED","tableId":"HBW_0000008","label":{"fr":null,"en":"health care provider"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000008_RO_0000087_HBW_0000010"]},{"iri":"http://purl.obolibrary.org/obo/NOYO_0000013","origin":"DECLARED","tableId":"NOYO_0000013","label":{"fr":null,"en":"statement"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/OBI_0000011","origin":"DECLARED","tableId":"OBI_0000011","label":{"fr":null,"en":"planned process"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/VO_0004896","origin":"DECLARED","tableId":"VO_0004896","label":{"fr":null,"en":"intersex biological sex datum"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000002","origin":"DECLARED","tableId":"BFO_0000002","label":{"fr":null,"en":"continuant"},"dataAxiomTables":[],"classAxiomTables":["BFO_0000002_RO_0000056_BFO_0000003"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0020017","origin":"DECLARED","tableId":"IAO_0020017","label":{"fr":null,"en":"family name"},"dataAxiomTables":["IAO_0020017_PHYSIO_0000100_string"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000030","origin":"DECLARED","tableId":"IAO_0000030","label":{"fr":null,"en":"information content entity"},"dataAxiomTables":[],"classAxiomTables":["IAO_0000030_IAO_0000219_BFO_0000001","IAO_0000030_IAO_0000136_BFO_0000001"]},{"iri":"http://purl.obolibrary.org/obo/IAO_0000577","origin":"DECLARED","tableId":"IAO_0000577","label":{"fr":null,"en":"centrally registered identifier symbol"},"dataAxiomTables":["IAO_0000577_PHYSIO_0000100_string"],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/NOYO_0000050","origin":"DECLARED","tableId":"NOYO_0000050","label":{"fr":null,"en":"birth statement"},"dataAxiomTables":[],"classAxiomTables":["NOYO_0000050_IAO_0000136_NCBITaxon_9606"]},{"iri":"http://purl.obolibrary.org/obo/OMRSE_00000212","origin":"DECLARED","tableId":"OMRSE_00000212","label":{"fr":null,"en":"non-binary identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000023","origin":"DECLARED","tableId":"HBW_0000023","label":{"fr":null,"en":"male biological sex or gender identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000011","origin":"DECLARED","tableId":"HBW_0000011","label":{"fr":null,"en":"patient role"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000003","origin":"DECLARED","tableId":"HBW_0000003","label":{"fr":null,"en":"weight unit"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000031","origin":"DECLARED","tableId":"BFO_0000031","label":{"fr":null,"en":"gdc"},"dataAxiomTables":[],"classAxiomTables":["BFO_0000031_RO_0000058_BFO_0000020"]},{"iri":"http://purl.obolibrary.org/obo/HBW_0000007","origin":"DECLARED","tableId":"HBW_0000007","label":{"fr":null,"en":"patient"},"dataAxiomTables":[],"classAxiomTables":["HBW_0000007_RO_0000087_HBW_0000011"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000019","origin":"DECLARED","tableId":"BFO_0000019","label":{"fr":null,"en":"quality"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000023","origin":"DECLARED","tableId":"BFO_0000023","label":{"fr":null,"en":"role"},"dataAxiomTables":[],"classAxiomTables":[]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000015","origin":"DECLARED","tableId":"BFO_0000015","label":{"fr":null,"en":"process"},"dataAxiomTables":[],"classAxiomTables":["BFO_0000015_BFO_0000055_BFO_0000017"]},{"iri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108","origin":"INTERSECTION_CLASS","tableId":"ONTORELA_C2986e108","label":{"fr":"(BFO_0000016 or BFO_0000019)\n and (RO_0000052 some OBI_0100026)","en":"(disposition or quality)\n and (inheres in some organism)"},"dataAxiomTables":[],"classAxiomTables":["ONTORELA_C2986e108_RO_0000052_OBI_0100026"]},{"iri":"http://purl.obolibrary.org/obo/BFO_0000003","origin":"DECLARED","tableId":"BFO_0000003","label":{"fr":null,"en":"occurrent"},"dataAxiomTables":[],"classAxiomTables":["BFO_0000003_RO_0000057_BFO_0000002","BFO_0000003_BFO_0000066_BFO_0000004"]},{"iri":"http://purl.obolibrary.org/obo/OMRSE_00000204","origin":"DECLARED","tableId":"OMRSE_00000204","label":{"fr":null,"en":"social identity information content entity"},"dataAxiomTables":[],"classAxiomTables":[]}],"Types":[],"ObjectProperties":[],"DataProperties":[{"iri":"http://purl.obolibrary.org/obo/IAO_0000004","label":{"fr":null,"en":"has measurement value"},"domainClassIri":["http://purl.obolibrary.org/obo/IAO_0000032"],"rangeDataTypeIri":"http://www.w3.org/2001/XMLSchema#double"},{"iri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","label":{"fr":null,"en":"has value"},"domainClassIri":[],"rangeDataTypeIri":null},{"iri":"http://www.w3.org/2002/07/owl#topDataProperty","label":{"fr":null,"en":null},"domainClassIri":[],"rangeDataTypeIri":null}],"IsaAxioms":[{"subClassIri":"BFO_0000031","subClassTableId":"BFO_0000031","superClassIri":"BFO_0000002","superClassTableId":"BFO_0000002"},{"subClassIri":"BFO_0000001","subClassTableId":"BFO_0000001","superClassIri":"Thing","superClassTableId":"Thing"},{"subClassIri":"HBW_0000013","subClassTableId":"HBW_0000013","superClassIri":"HBW_0000012","superClassTableId":"HBW_0000012"},{"subClassIri":"HBW_0000008","subClassTableId":"HBW_0000008","superClassIri":"NCBITaxon_9606","superClassTableId":"NCBITaxon_9606"},{"subClassIri":"IAO_0000577","subClassTableId":"IAO_0000577","superClassIri":"IAO_0000028","superClassTableId":"IAO_0000028"},{"subClassIri":"HBW_0000011","subClassTableId":"HBW_0000011","superClassIri":"BFO_0000023","superClassTableId":"BFO_0000023"},{"subClassIri":"HBW_0000005","subClassTableId":"HBW_0000005","superClassIri":"IAO_0000310","superClassTableId":"IAO_0000310"},{"subClassIri":"OMRSE_00000211","subClassTableId":"OMRSE_00000211","superClassIri":"OMRSE_00000209","superClassTableId":"OMRSE_00000209"},{"subClassIri":"IOIO_0000012","subClassTableId":"IOIO_0000012","superClassIri":"IAO_0000030","superClassTableId":"IAO_0000030"},{"subClassIri":"VO_0001194","subClassTableId":"VO_0001194","superClassIri":"IOIO_0000012","superClassTableId":"IOIO_0000012"},{"subClassIri":"NOYO_0000050","subClassTableId":"NOYO_0000050","superClassIri":"NOYO_0000013","superClassTableId":"NOYO_0000013"},{"subClassIri":"HBW_0000006","subClassTableId":"HBW_0000006","superClassIri":"IAO_0000577","superClassTableId":"IAO_0000577"},{"subClassIri":"ONTORELA_C61c354fb","subClassTableId":"ONTORELA_C61c354fb","superClassIri":"IAO_0000027","superClassTableId":"IAO_0000027"},{"subClassIri":"VO_0004895","subClassTableId":"VO_0004895","superClassIri":"VO_0001194","superClassTableId":"VO_0001194"},{"subClassIri":"BFO_0000016","subClassTableId":"BFO_0000016","superClassIri":"BFO_0000017","superClassTableId":"BFO_0000017"},{"subClassIri":"HBW_0000024","subClassTableId":"HBW_0000024","superClassIri":"IOIO_0000012","superClassTableId":"IOIO_0000012"},{"subClassIri":"BFO_0000016","subClassTableId":"BFO_0000016","superClassIri":"ONTORELA_C2986e108-el0","superClassTableId":"ONTORELA_C2986e108-el0"},{"subClassIri":"BFO_0000019","subClassTableId":"BFO_0000019","superClassIri":"ONTORELA_C2986e108-el0","superClassTableId":"ONTORELA_C2986e108-el0"},{"subClassIri":"HBW_0000014","subClassTableId":"HBW_0000014","superClassIri":"OGMS_0000031","superClassTableId":"OGMS_0000031"},{"subClassIri":"IAO_0000003","subClassTableId":"IAO_0000003","superClassIri":"IAO_0000009","superClassTableId":"IAO_0000009"},{"subClassIri":"IAO_0000027","subClassTableId":"IAO_0000027","superClassIri":"IAO_0000030","superClassTableId":"IAO_0000030"},{"subClassIri":"BFO_0000040","subClassTableId":"BFO_0000040","superClassIri":"BFO_0000004","superClassTableId":"BFO_0000004"},{"subClassIri":"HBW_0000001","subClassTableId":"HBW_0000001","superClassIri":"IAO_0000027","superClassTableId":"IAO_0000027"},{"subClassIri":"BFO_0000015","subClassTableId":"BFO_0000015","superClassIri":"BFO_0000003","superClassTableId":"BFO_0000003"},{"subClassIri":"OBI_0100026","subClassTableId":"OBI_0100026","superClassIri":"BFO_0000040","superClassTableId":"BFO_0000040"},{"subClassIri":"HBW_0000022","subClassTableId":"HBW_0000022","superClassIri":"IAO_0020000","superClassTableId":"IAO_0020000"},{"subClassIri":"NCBITaxon_9606","subClassTableId":"NCBITaxon_9606","superClassIri":"OBI_0100026","superClassTableId":"OBI_0100026"},{"subClassIri":"OGMS_0000031","subClassTableId":"OGMS_0000031","superClassIri":"BFO_0000016","superClassTableId":"BFO_0000016"},{"subClassIri":"ONTORELA_C2986e108-el0","subClassTableId":"ONTORELA_C2986e108-el0","superClassIri":"Thing","superClassTableId":"Thing"},{"subClassIri":"HBW_0000012","subClassTableId":"HBW_0000012","superClassIri":"OBI_0000011","superClassTableId":"OBI_0000011"},{"subClassIri":"BFO_0000023","subClassTableId":"BFO_0000023","superClassIri":"BFO_0000017","superClassTableId":"BFO_0000017"},{"subClassIri":"IAO_0000310","subClassTableId":"IAO_0000310","superClassIri":"IAO_0000030","superClassTableId":"IAO_0000030"},{"subClassIri":"BFO_0000004","subClassTableId":"BFO_0000004","superClassIri":"BFO_0000002","superClassTableId":"BFO_0000002"},{"subClassIri":"IAO_0000030","subClassTableId":"IAO_0000030","superClassIri":"BFO_0000031","superClassTableId":"BFO_0000031"},{"subClassIri":"HBW_0000003","subClassTableId":"HBW_0000003","superClassIri":"IAO_0000003","superClassTableId":"IAO_0000003"},{"subClassIri":"VO_0000613","subClassTableId":"VO_0000613","superClassIri":"VO_0001194","superClassTableId":"VO_0001194"},{"subClassIri":"IAO_0000009","subClassTableId":"IAO_0000009","superClassIri":"IAO_0000030","superClassTableId":"IAO_0000030"},{"subClassIri":"HBW_0000002","subClassTableId":"HBW_0000002","superClassIri":"IAO_0000027","superClassTableId":"IAO_0000027"},{"subClassIri":"OMRSE_00000210","subClassTableId":"OMRSE_00000210","superClassIri":"OMRSE_00000209","superClassTableId":"OMRSE_00000209"},{"subClassIri":"HBW_0000010","subClassTableId":"HBW_0000010","superClassIri":"BFO_0000023","superClassTableId":"BFO_0000023"},{"subClassIri":"NOYO_0000050","subClassTableId":"NOYO_0000050","superClassIri":"IAO_0000030","superClassTableId":"IAO_0000030"},{"subClassIri":"IAO_0000028","subClassTableId":"IAO_0000028","superClassIri":"IAO_0000030","superClassTableId":"IAO_0000030"},{"subClassIri":"IAO_0020000","subClassTableId":"IAO_0020000","superClassIri":"IAO_0000030","superClassTableId":"IAO_0000030"},{"subClassIri":"IAO_0000109","subClassTableId":"IAO_0000109","superClassIri":"IAO_0000027","superClassTableId":"IAO_0000027"},{"subClassIri":"HBW_0000009","subClassTableId":"HBW_0000009","superClassIri":"BFO_0000019","superClassTableId":"BFO_0000019"},{"subClassIri":"HBW_0000004","subClassTableId":"HBW_0000004","superClassIri":"IAO_0000310","superClassTableId":"IAO_0000310"},{"subClassIri":"OMRSE_00000212","subClassTableId":"OMRSE_00000212","superClassIri":"OMRSE_00000209","superClassTableId":"OMRSE_00000209"},{"subClassIri":"VO_0004896","subClassTableId":"VO_0004896","superClassIri":"VO_0001194","superClassTableId":"VO_0001194"},{"subClassIri":"HBW_0000007","subClassTableId":"HBW_0000007","superClassIri":"OBI_0100026","superClassTableId":"OBI_0100026"},{"subClassIri":"OMRSE_00000209","subClassTableId":"OMRSE_00000209","superClassIri":"IOIO_0000012","superClassTableId":"IOIO_0000012"},{"subClassIri":"VO_0001194","subClassTableId":"VO_0001194","superClassIri":"IAO_0000109","superClassTableId":"IAO_0000109"},{"subClassIri":"BFO_0000020","subClassTableId":"BFO_0000020","superClassIri":"BFO_0000002","superClassTableId":"BFO_0000002"},{"subClassIri":"HBW_0000026","subClassTableId":"HBW_0000026","superClassIri":"IAO_0000032","superClassTableId":"IAO_0000032"},{"subClassIri":"OBI_0000011","subClassTableId":"OBI_0000011","superClassIri":"BFO_0000015","superClassTableId":"BFO_0000015"},{"subClassIri":"ONTORELA_C4d0c3f45","subClassTableId":"ONTORELA_C4d0c3f45","superClassIri":"HBW_0000004","superClassTableId":"HBW_0000004"},{"subClassIri":"OMRSE_00000204","subClassTableId":"OMRSE_00000204","superClassIri":"IAO_0000030","superClassTableId":"IAO_0000030"},{"subClassIri":"OMRSE_00000209","subClassTableId":"OMRSE_00000209","superClassIri":"OMRSE_00000204","superClassTableId":"OMRSE_00000204"},{"subClassIri":"IAO_0020017","subClassTableId":"IAO_0020017","superClassIri":"IAO_0020000","superClassTableId":"IAO_0020000"},{"subClassIri":"BFO_0000003","subClassTableId":"BFO_0000003","superClassIri":"BFO_0000001","superClassTableId":"BFO_0000001"},{"subClassIri":"IAO_0000032","subClassTableId":"IAO_0000032","superClassIri":"IAO_0000109","superClassTableId":"IAO_0000109"},{"subClassIri":"HBW_0000025","subClassTableId":"HBW_0000025","superClassIri":"IOIO_0000012","superClassTableId":"IOIO_0000012"},{"subClassIri":"IAO_0020015","subClassTableId":"IAO_0020015","superClassIri":"IAO_0020000","superClassTableId":"IAO_0020000"},{"subClassIri":"ONTORELA_C2986e108","subClassTableId":"ONTORELA_C2986e108","superClassIri":"ONTORELA_C2986e108-el0","superClassTableId":"ONTORELA_C2986e108-el0"},{"subClassIri":"HBW_0000023","subClassTableId":"HBW_0000023","superClassIri":"IOIO_0000012","superClassTableId":"IOIO_0000012"},{"subClassIri":"BFO_0000002","subClassTableId":"BFO_0000002","superClassIri":"BFO_0000001","superClassTableId":"BFO_0000001"},{"subClassIri":"NOYO_0000012","subClassTableId":"NOYO_0000012","superClassIri":"BFO_0000031","superClassTableId":"BFO_0000031"},{"subClassIri":"NOYO_0000013","subClassTableId":"NOYO_0000013","superClassIri":"NOYO_0000012","superClassTableId":"NOYO_0000012"},{"subClassIri":"BFO_0000017","subClassTableId":"BFO_0000017","superClassIri":"BFO_0000020","superClassTableId":"BFO_0000020"},{"subClassIri":"BFO_0000019","subClassTableId":"BFO_0000019","superClassIri":"BFO_0000020","superClassTableId":"BFO_0000020"}],"ClassAxioms":[{"expression":"IAO_0000032 [1..*] IAO_0000039 IAO_0000003","origin":"DECLARED","tableId":"IAO_0000032_IAO_0000039_IAO_0000003","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"IAO_0000032","rangeClassIri":"http://purl.obolibrary.org/obo/IAO_0000003","rangeTableId":"IAO_0000003","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000039","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"1","max":"*"}},{"expression":"HBW_0000026 [1..*] IAO_0000039 HBW_0000003","origin":"DECLARED","tableId":"HBW_0000026_IAO_0000039_HBW_0000003","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000026","domainTableId":"HBW_0000026","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000003","rangeTableId":"HBW_0000003","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000039","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"1","max":"*"}},{"expression":"BFO_0000003 [1..*] RO_0000057 BFO_0000002","origin":"DECLARED","tableId":"BFO_0000003_RO_0000057_BFO_0000002","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","domainTableId":"BFO_0000003","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000002","rangeTableId":"BFO_0000002","propertyIri":"http://purl.obolibrary.org/obo/RO_0000057","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0020000 [1..*] IAO_0000219 BFO_0000001","origin":"DECLARED","tableId":"IAO_0020000_IAO_0000219_BFO_0000001","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0020000","domainTableId":"IAO_0020000","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"BFO_0000001","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000219","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"NOYO_0000050 [1..*] IAO_0000136 NCBITaxon_9606","origin":"DECLARED","tableId":"NOYO_0000050_IAO_0000136_NCBITaxon_9606","domainClassIri":"http://purl.obolibrary.org/obo/NOYO_0000050","domainTableId":"NOYO_0000050","rangeClassIri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","rangeTableId":"NCBITaxon_9606","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000004 [1..*] RO_0000087 BFO_0000023","origin":"DECLARED","tableId":"BFO_0000004_RO_0000087_BFO_0000023","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","domainTableId":"BFO_0000004","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000023","rangeTableId":"BFO_0000023","propertyIri":"http://purl.obolibrary.org/obo/RO_0000087","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000012 [1..*] OBI_0000299 ONTORELA_C61c354fb","origin":"INTERSECTION_AXIOM","tableId":"HBW_0000012_OBI_0000299_ONTORELA_C61c354fb","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000012","domainTableId":"HBW_0000012","rangeClassIri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb","rangeTableId":"ONTORELA_C61c354fb","propertyIri":"http://purl.obolibrary.org/obo/OBI_0000299","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000015 [1..*] BFO_0000055 BFO_0000017","origin":"DECLARED","tableId":"BFO_0000015_BFO_0000055_BFO_0000017","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000015","domainTableId":"BFO_0000015","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000017","rangeTableId":"BFO_0000017","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000055","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000004 [1..*] RO_0001025 BFO_0000004","origin":"DECLARED","tableId":"BFO_0000004_RO_0001025_BFO_0000004","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","domainTableId":"BFO_0000004","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","rangeTableId":"BFO_0000004","propertyIri":"http://purl.obolibrary.org/obo/RO_0001025","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000031 [1..*] RO_0000058 BFO_0000020","origin":"DECLARED","tableId":"BFO_0000031_RO_0000058_BFO_0000020","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000031","domainTableId":"BFO_0000031","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000020","rangeTableId":"BFO_0000020","propertyIri":"http://purl.obolibrary.org/obo/RO_0000058","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"ONTORELA_C2986e108 [1..*] RO_0000052 OBI_0100026","origin":"UNION_AXIOM","tableId":"ONTORELA_C2986e108_RO_0000052_OBI_0100026","domainClassIri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108","domainTableId":"ONTORELA_C2986e108","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0100026","rangeTableId":"OBI_0100026","propertyIri":"http://purl.obolibrary.org/obo/RO_0000052","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000006 [1..1] IAO_0000219 ONTORELA_C4d0c3f45","origin":"INTERSECTION_AXIOM","tableId":"HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000006","domainTableId":"HBW_0000006","rangeClassIri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45","rangeTableId":"ONTORELA_C4d0c3f45","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000219","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000020 [1..*] RO_0000059 BFO_0000031","origin":"DECLARED","tableId":"BFO_0000020_RO_0000059_BFO_0000031","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000020","domainTableId":"BFO_0000020","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000031","rangeTableId":"BFO_0000031","propertyIri":"http://purl.obolibrary.org/obo/RO_0000059","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"ONTORELA_C61c354fb [1..*] IAO_0000136 ONTORELA_C2986e108","origin":"INTERSECTION_AXIOM","tableId":"ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108","domainClassIri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb","domainTableId":"ONTORELA_C61c354fb","rangeClassIri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108","rangeTableId":"ONTORELA_C2986e108","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000001 [1..*] OBI_0000312 HBW_0000012","origin":"INTERSECTION_AXIOM","tableId":"HBW_0000001_OBI_0000312_HBW_0000012","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000001","domainTableId":"HBW_0000001","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000012","rangeTableId":"HBW_0000012","propertyIri":"http://purl.obolibrary.org/obo/OBI_0000312","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"ONTORELA_C4d0c3f45 [1..*] IAO_0000136 HBW_0000007","origin":"INTERSECTION_AXIOM","tableId":"ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007","domainClassIri":"http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45","domainTableId":"ONTORELA_C4d0c3f45","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000007","rangeTableId":"HBW_0000007","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000001 [1..*] BFO_0000050 BFO_0000001","origin":"DECLARED","tableId":"BFO_0000001_BFO_0000050_BFO_0000001","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","domainTableId":"BFO_0000001","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"BFO_0000001","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000050","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000008 [1..*] RO_0000087 HBW_0000010","origin":"INTERSECTION_AXIOM","tableId":"HBW_0000008_RO_0000087_HBW_0000010","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000008","domainTableId":"HBW_0000008","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000010","rangeTableId":"HBW_0000010","propertyIri":"http://purl.obolibrary.org/obo/RO_0000087","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000004 [1..*] IAO_0000136 OBI_0100026","origin":"DECLARED","tableId":"HBW_0000004_IAO_0000136_OBI_0100026","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000004","domainTableId":"HBW_0000004","rangeClassIri":"http://purl.obolibrary.org/obo/OBI_0100026","rangeTableId":"OBI_0100026","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000017 [1..*] BFO_0000054 BFO_0000015","origin":"DECLARED","tableId":"BFO_0000017_BFO_0000054_BFO_0000015","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000017","domainTableId":"BFO_0000017","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000015","rangeTableId":"BFO_0000015","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000054","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000005 [1..1] BFO_0000051 HBW_0000006","origin":"DECLARED","tableId":"HBW_0000005_BFO_0000051_HBW_0000006","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000005","domainTableId":"HBW_0000005","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000006","rangeTableId":"HBW_0000006","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000051","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000012 [1..1] PHYSIO_0000089 NCBITaxon_9606","origin":"DECLARED","tableId":"HBW_0000012_PHYSIO_0000089_NCBITaxon_9606","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000012","domainTableId":"HBW_0000012","rangeClassIri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","rangeTableId":"NCBITaxon_9606","propertyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000022 [1..*] IAO_0000219 NCBITaxon_9606","origin":"DECLARED","tableId":"HBW_0000022_IAO_0000219_NCBITaxon_9606","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000022","domainTableId":"HBW_0000022","rangeClassIri":"http://purl.obolibrary.org/obo/NCBITaxon_9606","rangeTableId":"NCBITaxon_9606","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000219","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000005 [1..*] BFO_0000051 HBW_0000001","origin":"DECLARED","tableId":"HBW_0000005_BFO_0000051_HBW_0000001","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000005","domainTableId":"HBW_0000005","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000001","rangeTableId":"HBW_0000001","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000051","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000030 [1..*] IAO_0000219 BFO_0000001","origin":"DECLARED","tableId":"IAO_0000030_IAO_0000219_BFO_0000001","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000030","domainTableId":"IAO_0000030","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"BFO_0000001","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000219","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000007 [1..*] RO_0000087 HBW_0000011","origin":"INTERSECTION_AXIOM","tableId":"HBW_0000007_RO_0000087_HBW_0000011","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000007","domainTableId":"HBW_0000007","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000011","rangeTableId":"HBW_0000011","propertyIri":"http://purl.obolibrary.org/obo/RO_0000087","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000002 [1..*] RO_0000056 BFO_0000003","origin":"DECLARED","tableId":"BFO_0000002_RO_0000056_BFO_0000003","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000002","domainTableId":"BFO_0000002","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","rangeTableId":"BFO_0000003","propertyIri":"http://purl.obolibrary.org/obo/RO_0000056","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000013 [1..1] PHYSIO_0000089 HBW_0000008","origin":"INTERSECTION_AXIOM","tableId":"HBW_0000013_PHYSIO_0000089_HBW_0000008","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000013","domainTableId":"HBW_0000013","rangeClassIri":"http://purl.obolibrary.org/obo/HBW_0000008","rangeTableId":"HBW_0000008","propertyIri":"http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"BFO_0000003 [1..*] BFO_0000066 BFO_0000004","origin":"DECLARED","tableId":"BFO_0000003_BFO_0000066_BFO_0000004","domainClassIri":"http://purl.obolibrary.org/obo/BFO_0000003","domainTableId":"BFO_0000003","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000004","rangeTableId":"BFO_0000004","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000066","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"HBW_0000022 [1..*] BFO_0000051 IAO_0020017","origin":"DECLARED","tableId":"HBW_0000022_BFO_0000051_IAO_0020017","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000022","domainTableId":"HBW_0000022","rangeClassIri":"http://purl.obolibrary.org/obo/IAO_0020017","rangeTableId":"IAO_0020017","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000051","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000109 [1..1] IAO_0000039 IAO_0000003","origin":"DECLARED","tableId":"IAO_0000109_IAO_0000039_IAO_0000003","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000109","domainTableId":"IAO_0000109","rangeClassIri":"http://purl.obolibrary.org/obo/IAO_0000003","rangeTableId":"IAO_0000003","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000039","domainParticipation":{"min":"1","max":"1"},"rangeParticipation":{"min":"1","max":"*"}},{"expression":"HBW_0000022 [1..*] BFO_0000051 IAO_0020015","origin":"DECLARED","tableId":"HBW_0000022_BFO_0000051_IAO_0020015","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000022","domainTableId":"HBW_0000022","rangeClassIri":"http://purl.obolibrary.org/obo/IAO_0020015","rangeTableId":"IAO_0020015","propertyIri":"http://purl.obolibrary.org/obo/BFO_0000051","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}},{"expression":"IAO_0000030 [1..*] IAO_0000136 BFO_0000001","origin":"DECLARED","tableId":"IAO_0000030_IAO_0000136_BFO_0000001","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000030","domainTableId":"IAO_0000030","rangeClassIri":"http://purl.obolibrary.org/obo/BFO_0000001","rangeTableId":"BFO_0000001","propertyIri":"http://purl.obolibrary.org/obo/IAO_0000136","domainParticipation":{"min":"1","max":"*"},"rangeParticipation":{"min":"0","max":"*"}}],"DataAxioms":[{"expression":"IAO_0000032 [1..*] IAO_0000004 Literal","tableId":"IAO_0000032_IAO_0000004_Literal","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"IAO_0000032","rangeClassIri":"http://www.w3.org/2000/01/rdf-schema#Literal","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/IAO_0000004","domainParticipation":{"min":"1","max":"*"}},{"expression":"HBW_0000002 [1..1] PHYSIO_0000100 string","tableId":"HBW_0000002_PHYSIO_0000100_string","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000002","domainTableId":"HBW_0000002","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0000032 [1..1] IAO_0000004 double","tableId":"IAO_0000032_IAO_0000004_double","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000032","domainTableId":"IAO_0000032","rangeClassIri":"http://www.w3.org/2001/XMLSchema#double","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/IAO_0000004","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0020015 [1..1] PHYSIO_0000100 string","tableId":"IAO_0020015_PHYSIO_0000100_string","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0020015","domainTableId":"IAO_0020015","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0020017 [1..1] PHYSIO_0000100 string","tableId":"IAO_0020017_PHYSIO_0000100_string","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0020017","domainTableId":"IAO_0020017","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0000577 [1..1] PHYSIO_0000100 string","tableId":"IAO_0000577_PHYSIO_0000100_string","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000577","domainTableId":"IAO_0000577","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}},{"expression":"IAO_0000003 [1..1] PHYSIO_0000100 string","tableId":"IAO_0000003_PHYSIO_0000100_string","domainClassIri":"http://purl.obolibrary.org/obo/IAO_0000003","domainTableId":"IAO_0000003","rangeClassIri":"http://www.w3.org/2001/XMLSchema#string","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/PHYSIO_0000100","domainParticipation":{"min":"1","max":"1"}},{"expression":"HBW_0000026 [1..*] IAO_0000004 decimal","tableId":"HBW_0000026_IAO_0000004_decimal","domainClassIri":"http://purl.obolibrary.org/obo/HBW_0000026","domainTableId":"HBW_0000026","rangeClassIri":"http://www.w3.org/2001/XMLSchema#decimal","rangeTableId":null,"propertyIri":"http://purl.obolibrary.org/obo/IAO_0000004","domainParticipation":{"min":"1","max":"*"}}]}','2024-02-20T11:26:36.71178-05:00');

 call "OntoRelCat".onto_schema_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','BW','en','BASE');

 call "OntoRelCat".ontology_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl','HumanBodyWeightAppli_couverture.owl','humanbodyweight-appli.owl','','2024-02-13T15:17:24Z');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://www.w3.org/2002/07/owl#Thing','Thing','DECLARED');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://www.w3.org/2002/07/owl#Thing','en','The class owl:Thing is the class of all individuals.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000002','HBW_0000002','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000002','en','RAMQ vulnerability code');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000002','en','A data item categorizing a type of health situation in order to adjust administrative handling of physician billing by the RAMQ.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0001194','VO_0001194','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0001194','en','biological sex datum');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0001194','en','A measurement datum that represents the biological sex of an animal. The result can be represented using a discretized digit, for example, 0 = female; 1 = male.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000022','HBW_0000022','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000022','en','human name');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000022','en','An identifier that is composed of some family name and some personal name that denotes of an Homo Sapiens.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000010','HBW_0000010','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000010','en','health care provider role');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000010','en','A role inhering in an organization or human being that is realized by a process of providing health care services to an organism.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000006','HBW_0000006','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000006','en','medical record identifier');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000006','en','A CRID symbol that is sufficent to look up a patient file in a medical record registry.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000009','IAO_0000009','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000009','en','datum label');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000009','en','A label is a symbol that is part of some other datum and is used to either partially define  the denotation of that datum or to provide a means for identifying the datum as a member of the set of data with the same label');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000026','HBW_0000026','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000026','fr','weight measurement datum');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000026','en','A scalar measurement datum composed of two parts: a Decimal and a weight unit label.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000014','HBW_0000014','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000014','en','obesity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000014','en','A disease marked by an abnormally high, unhealthy amount of body fat.; A disorder characterized by having an increased body fat.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000020','BFO_0000020','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000020','en','sdc');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000020','en','b is a specifically dependent continuant = Def. b is a continuant & there is some independent continuant c which is not a spatial region and which is such that b s-depends_on c at every time t during the course of b’s existence. (axiom label in BFO2 Reference: [050-003])');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000040','BFO_0000040','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000040','en','material');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000040','en','MaterialEntity');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000016','BFO_0000016','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000016','en','disposition');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000016','en','realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OGMS_0000031','OGMS_0000031','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OGMS_0000031','en','disease');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OGMS_0000031','en','A disposition (i) to undergo pathological processes that (ii) exists in an organism because of one or more disorders in that organism.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','BFO_0000004','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','en','ic');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','en','A continuant that is a bearer of quality and realizable entity entities, in which other entities inhere and which itself cannot inhere in anything.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020015','IAO_0020015','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020015','en','personal name');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020015','en','Personal names "today usually comprises a given name bestowed at birth or at a young age plus a surname. It is nearly universal for a human to have a name; except in rare cases, for example feral children growing up in isolation, or infants orphaned by natural disaster for whom no written record survives.[citation needed] The Convention on the Rights of the Child specifies that a child has the right from birth to a name. Certain isolated tribes, such as the Machiguenga of the Amazon, also lack personal names." (http://en.wikipedia.org/wiki/Personal_name)');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000209','OMRSE_00000209','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000209','en','gender identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000209','en','A social identity information content entity that is about whether some person identifies as some gender.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0100026','OBI_0100026','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0100026','en','organism');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0100026','en','A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NCBITaxon_9606','NCBITaxon_9606','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NCBITaxon_9606','en','Homo sapiens');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NCBITaxon_9606','en','Organism member of the genus Homo, evolving from Homo heidelbergensis or a similar species and migrating out of Africa, gradually replacing or interbreeding with local populations of archaic humans.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000032','IAO_0000032','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000032','en','scalar measurement datum');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000032','en','a scalar measurement datum is a measurement datum that is composed of two parts, numerals and a unit label.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IOIO_0000012','IOIO_0000012','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IOIO_0000012','en','human biological sex or gender identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IOIO_0000012','en','An information content entity that denotes a biological sex or a gender identity of a human.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000013','HBW_0000013','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000013','en','physiological evaluation from health care provider');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000013','en','A physiological evaluation that is evaluated by a health care provider');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000028','IAO_0000028','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000028','en','symbol');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000028','en','An information content entity that is a mark(s) or character(s) used as a conventional representation of another entity.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000001','HBW_0000001','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000001','en','physiological data item');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000001','en','A data item that is the specified output of some physiological evaluation.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000210','OMRSE_00000210','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000210','en','female gender identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000210','en','A gender identity information content entity that is about some person''s identifying as female in gender.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000109','IAO_0000109','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000109','en','measurement datum');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000109','en','A measurement datum is an information content entity that is a recording of the output of a measurement such as produced by a device.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000005','HBW_0000005','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000005','en','physiological evaluation report');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000005','en','A document that contains information representing the health-relevant qualities of a patient''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000025','HBW_0000025','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000025','en','female biological sex or gender identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000025','en','A biological sex or gender identity datum that is intended to denote a female biological sex or a female gender identity.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000009','HBW_0000009','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000009','en','body weight');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000009','en','a quality of a body of having a weight');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000012','NOYO_0000012','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000012','en','informational entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000012','en','A generically dependent continuant that is a building block of information or a combination thereof.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','ONTORELA_C61c354fb','INTERSECTION_CLASS');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','fr','IAO_0000027
 and (IAO_0000136 some 
    ((BFO_0000016 or BFO_0000019)
     and (RO_0000052 some OBI_0100026)))');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','en','data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','fr','HBW_0000012');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','en','physiological evaluationDisposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements. A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0004895','VO_0004895','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0004895','en','female biological sex datum');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0004895','en','A biological sex datum that represents the biological sex of an animal (including human) as being female.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000017','BFO_0000017','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000017','en','realizable');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000017','en','A specifically dependent continuant that inheres in some independent continuant which is not a spatial region and is of a type instances of which are realized in processes of a correlated type.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0','ONTORELA_C2986e108-el0','INTERSECTION_EL_CLASS');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0','fr','BFO_0000016 or BFO_0000019');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0','en','disposition or quality');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0','fr','(BFO_0000016 or BFO_0000019)
 and (RO_0000052 some OBI_0100026)');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0','en','(disposition or quality)
 and (inheres in some organism)Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','BFO_0000001','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','en','entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','en','per discussion with Barry Smith');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000310','IAO_0000310','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000310','en','document');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000310','en','An information content entity that is a collection of information content entities intended to be understood together as a whole.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000003','IAO_0000003','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000003','en','measurement unit label');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000003','en','A measurement unit label is as a label that is part of a scalar measurement datum and denotes a unit of measure.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000024','HBW_0000024','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000024','en','intersex biological sex or non-binary gender identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000024','en','A biological sex or gender identity datum that is intended to denote a intersex biological sex or a non-binary gender identity.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000211','OMRSE_00000211','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000211','en','male gender identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000211','en','A gender identity information content entity that is about some person''s identifying as male in gender.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000012','HBW_0000012','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000012','en','physiological evaluation');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000012','en','A planned process that evaluates health-relevant qualities of an organism''s body, organ systems, individual organs, cells and biomolecules that perform chemical and physical functions.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000027','IAO_0000027','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000027','en','data item');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000027','en','a data item is an information content entity that is intended to be a truthful statement about something (modulo, e.g., measurement precision or other systematic errors) and is constructed/acquired by a method which reliably tends to produce (approximately) truthful statements.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0000613','VO_0000613','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0000613','en','male biological sex datum');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0000613','en','A biological sex measurement datum that is intended to denote a male biological sex.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','ONTORELA_C4d0c3f45','INTERSECTION_CLASS');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','fr','HBW_0000004
 and (IAO_0000136 some HBW_0000007)');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','en','health care record
 and (is about some patient)');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','fr','HBW_0000006');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','en','medical record identifierA document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting. An organism having the role of patient.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020000','IAO_0020000','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020000','en','identifier');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020000','en','An information content entity that is the outcome of a dubbing process and is used to refer to one instance of entity shared by a group of people to refer to that individual entity.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000004','HBW_0000004','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000004','en','health care record');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000004','en','A document that contains information representing health-relevant qualities of a patient written in a chronological manner and that is primarily used for patient care in a clinical setting.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000008','HBW_0000008','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000008','en','health care provider');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000008','en','A homo sapiens having with the health care provider role');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000013','NOYO_0000013','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000013','en','statement');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000013','en','An informational entity that is considered valid by some agent at some point in time. (TBD)');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','OBI_0000011','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','en','planned process');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','en','A process that realizes a plan which is the concretization of a plan specification.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0004896','VO_0004896','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0004896','en','intersex biological sex datum');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0004896','en','A biological sex datum that represents the biological sex of an animal (including human) as being intersex.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000002','BFO_0000002','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000002','en','continuant');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000002','en','
An entity that exists in full at any time in which it exists at all, persists through time while maintaining its identity and has no temporal parts.
');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020017','IAO_0020017','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020017','en','family name');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020017','en','An identifier that is typically a part of a person''s name which has been passed, according to law or custom, from one or both parents to their children.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000030','IAO_0000030','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000030','en','information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000030','en','A generically dependent continuant that is about some thing.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000577','IAO_0000577','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000577','en','centrally registered identifier symbol');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000577','en','A symbol that is part of a CRID and that is sufficient to look up a record from the CRID''s registry.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000050','NOYO_0000050','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000050','en','birth statement');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000050','en','A statement about the information surrounding the birth of a human.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000212','OMRSE_00000212','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000212','en','non-binary identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000212','en','A gender identity information content entity that is about some person''s identifying as non-binary in gender.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000023','HBW_0000023','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000023','en','male biological sex or gender identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000023','en','A biological sex or gender identity datum that is intended to denote a male biological sex or a male gender identity.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000011','HBW_0000011','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000011','en','patient role');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000011','en','a role which inheres in a person and is realized by the process of being under the care of a physician or health care provider');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000003','HBW_0000003','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000003','en','weight unit');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000003','en','a measurement unit label of a weight');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000031','BFO_0000031','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000031','en','generically dependent continuant');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000031','en','b is a generically dependent continuant = Def. b is a continuant that g-depends_on one or more other entities. (axiom label in BFO2 Reference: [074-001])');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000007','HBW_0000007','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000007','en','patient');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000007','en','An organism having the role of patient.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000019','BFO_0000019','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000019','en','quality');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000019','en','a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000023','BFO_0000023','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000023','en','role');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000023','en','A realizable entity that exists because there is some single bearer that is in some particular physical, social, or institutional set of circumstances in which this bearer does not have to be and is not such that, if it ceases to exist, then the physical make-up of the bearer is thereby changed.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000015','BFO_0000015','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000015','en','process');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000015','en','
An occurrent that has temporal proper parts and for some time t, p s-depends_on some material entity at t.
');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','ONTORELA_C2986e108','INTERSECTION_CLASS');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','fr','(BFO_0000016 or BFO_0000019)
 and (RO_0000052 some OBI_0100026)');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','en','(disposition or quality)
 and (inheres in some organism)');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','fr','IAO_0000027
 and (IAO_0000136 some 
    ((BFO_0000016 or BFO_0000019)
     and (RO_0000052 some OBI_0100026)))');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','en','data item
 and (is about some 
    ((disposition or quality)
     and (inheres in some organism)))Disposition realizable entity that specifically depends of some material entity,  its bearer, for which is such that if it ceases to exist, then its bearer is physically changed Quality a specifically dependent continuant that, in contrast to roles and dispositions, does not require any further process in order to be realized A material entity that is an individual living system, such as animal, plant, bacteria or virus, that is capable of replicating or reproducing, growth and maintenance in the right environment. An organism may be unicellular or made up, like humans, of many billions of cells divided into specialized tissues and organs.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','BFO_0000003','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','en','occurrent');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','en','An entity that has temporal parts and that happens, unfolds or develops through time.');

 call "OntoRelCat".onto_class_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000204','OMRSE_00000204','DECLARED');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000204','en','social identity information content entity');

 call "OntoRelCat".definition_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000204','en','We include (i)-(iii) to acknowledge that there are different senses of "identify" that are relevant here, and that we may not always be sure which sense the person concretizing the social identity information content entity intended. While (i) concerns how one thinks of oneself, (ii) and (iii) are more focused on one''s interactions with others. Importantly, some choose not to share with others how they identify in the sense of (i). For example, one can consider oneself to be some certain gender without either wanting others to know or choosing to present oneself in a corresponding way. We distinguish (ii) and (iii) because one can prefer to be regarded some certain way without attempting to present oneself in any corresponding way.');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000050', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000050','en','part of');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000050');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000050');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000051', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000051','en','has part');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000052', null);

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000054', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000054','en','realized in');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000054');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000054');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000055', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000055','en','realizes');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000055');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000055');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000056', null);

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000057', null);

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000066', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000066','en','occurs in');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000066');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000066');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000039', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000039','en','has measurement unit label');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000039');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000039');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000136', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000136','en','is about');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0000136');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000136');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000219', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000219','en','denotes');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/IAO_0000219');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000219');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000221', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000221','en','is quality measurement of');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000221');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000413', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000413','en','is duration of');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/IAO_0000413');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000417', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000417','en','is quality measured as');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000293', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000293','en','has_specified_input');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000293');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000295', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000295','en','is_specified_input_of');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000295');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000299', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000299','en','has_specified_output');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000299');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000312', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000312','en','is_specified_output_of');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000312');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000417', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000417','en','achieves_planned_objective');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000417');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000833', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000833','en','objective_achieved_by');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/OBI_0000833');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0001938', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0001938','en','has value specification');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000052', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000052','en','inheres in');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000053', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000053','en','bearer of');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000053');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000056', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000056','en','participates in');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/RO_0000056');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/RO_0000056');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000057', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000057','en','has participant');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/RO_0000057');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/RO_0000057');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000058', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000058','en','is concretized as');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/RO_0000058');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000058');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000059', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000059','en','concretizes');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000059');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/RO_0000059');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000079', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000079','en','function of');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000080', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000080','en','quality of');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000081', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000081','en','role of');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000085', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000085','en','has function');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0000085');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000086', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000086','en','has quality');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000087', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000087','en','has role');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0000087');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/RO_0000087');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000091', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000091','en','has disposition');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0000091');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000092', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0000092','en','disposition of');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0001015', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0001015','en','location of');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0001025', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0001025','en','located in');

 call "OntoRelCat".onto_object_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0001025');

 call "OntoRelCat".onto_object_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0001025');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0002131', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0002131','en','overlaps');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0002323', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0002323','en','mereotopologically related to');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0002350', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0002350','en','member of');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0002351', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/RO_0002351','en','has member');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089','en','has evaluant');

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.org/obo/owl/OBO_REL#exists_during', null);

 call "OntoRelCat".onto_object_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.org/obo/owl/obo#towards', null);

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.org/obo/owl/obo#towards','en','towards');

 call "OntoRelCat".onto_data_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000004');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000004','en','has measurement value');

 call "OntoRelCat".onto_data_properties_domain_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000004');

 call "OntoRelCat".onto_data_properties_range_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://www.w3.org/2001/XMLSchema#double','http://purl.obolibrary.org/obo/IAO_0000004', 'DOUBLE PRECISION');

 call "OntoRelCat".onto_data_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/PHYSIO_0000100');

 call "OntoRelCat".label_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/PHYSIO_0000100','en','has value');

 call "OntoRelCat".onto_data_properties_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://www.w3.org/2002/07/owl#topDataProperty');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','http://www.w3.org/2002/07/owl#Thing');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000013','http://purl.obolibrary.org/obo/HBW_0000012');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000008','http://purl.obolibrary.org/obo/NCBITaxon_9606');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000577','http://purl.obolibrary.org/obo/IAO_0000028');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000011','http://purl.obolibrary.org/obo/BFO_0000023');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000005','http://purl.obolibrary.org/obo/IAO_0000310');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000211','http://purl.obolibrary.org/obo/OMRSE_00000209');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IOIO_0000012','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0001194','http://purl.obolibrary.org/obo/IOIO_0000012');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000050','http://purl.obolibrary.org/obo/NOYO_0000013');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/IAO_0000577');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0004895','http://purl.obolibrary.org/obo/VO_0001194');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000016','http://purl.obolibrary.org/obo/BFO_0000017');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000024','http://purl.obolibrary.org/obo/IOIO_0000012');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000016','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000019','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000014','http://purl.obolibrary.org/obo/OGMS_0000031');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000009');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000027','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000040','http://purl.obolibrary.org/obo/BFO_0000004');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000001','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000003');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/BFO_0000040');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000022','http://purl.obolibrary.org/obo/IAO_0020000');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/OBI_0100026');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OGMS_0000031','http://purl.obolibrary.org/obo/BFO_0000016');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0','http://www.w3.org/2002/07/owl#Thing');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/OBI_0000011');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/BFO_0000017');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000310','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000031');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000003','http://purl.obolibrary.org/obo/IAO_0000003');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0000613','http://purl.obolibrary.org/obo/VO_0001194');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000009','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000002','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000210','http://purl.obolibrary.org/obo/OMRSE_00000209');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000010','http://purl.obolibrary.org/obo/BFO_0000023');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000050','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000028','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020000','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000027');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000009','http://purl.obolibrary.org/obo/BFO_0000019');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000004','http://purl.obolibrary.org/obo/IAO_0000310');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000212','http://purl.obolibrary.org/obo/OMRSE_00000209');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0004896','http://purl.obolibrary.org/obo/VO_0001194');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000007','http://purl.obolibrary.org/obo/OBI_0100026');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000209','http://purl.obolibrary.org/obo/IOIO_0000012');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/VO_0001194','http://purl.obolibrary.org/obo/IAO_0000109');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000002');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000026','http://purl.obolibrary.org/obo/IAO_0000032');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OBI_0000011','http://purl.obolibrary.org/obo/BFO_0000015');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','http://purl.obolibrary.org/obo/HBW_0000004');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000204','http://purl.obolibrary.org/obo/IAO_0000030');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/OMRSE_00000209','http://purl.obolibrary.org/obo/OMRSE_00000204');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020017','http://purl.obolibrary.org/obo/IAO_0020000');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000001');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000109');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000025','http://purl.obolibrary.org/obo/IOIO_0000012');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020015','http://purl.obolibrary.org/obo/IAO_0020000');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108-el0');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000023','http://purl.obolibrary.org/obo/IOIO_0000012');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000001');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000012','http://purl.obolibrary.org/obo/BFO_0000031');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000013','http://purl.obolibrary.org/obo/NOYO_0000012');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000020');

 call "OntoRelCat".onto_class_inheritance_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000019','http://purl.obolibrary.org/obo/BFO_0000020');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000032','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000039','[1..*]','[1.. *]','DECLARED','IAO_0000032_IAO_0000039_IAO_0000003');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000026','http://purl.obolibrary.org/obo/HBW_0000003','http://purl.obolibrary.org/obo/IAO_0000039','[1..*]','[1.. *]','DECLARED','HBW_0000026_IAO_0000039_HBW_0000003');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/RO_0000057','[1..*]','[0.. *]','DECLARED','BFO_0000003_RO_0000057_BFO_0000002');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020000','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000219','[1..*]','[0.. *]','DECLARED','IAO_0020000_IAO_0000219_BFO_0000001');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/NOYO_0000050','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','NOYO_0000050_IAO_0000136_NCBITaxon_9606');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000023','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','DECLARED','BFO_0000004_RO_0000087_BFO_0000023');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','http://purl.obolibrary.org/obo/OBI_0000299','[1..*]','[0.. *]','INTERSECTION_AXIOM','HBW_0000012_OBI_0000299_ONTORELA_C61c354fb');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000055','[1..*]','[0.. *]','DECLARED','BFO_0000015_BFO_0000055_BFO_0000017');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/RO_0001025','[1..*]','[0.. *]','DECLARED','BFO_0000004_RO_0001025_BFO_0000004');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/RO_0000058','[1..*]','[0.. *]','DECLARED','BFO_0000031_RO_0000058_BFO_0000020');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/RO_0000052','[1..*]','[0.. *]','UNION_AXIOM','ONTORELA_C2986e108_RO_0000052_OBI_0100026');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','http://purl.obolibrary.org/obo/IAO_0000219','[1..1]','[0.. *]','INTERSECTION_AXIOM','HBW_0000006_IAO_0000219_ONTORELA_C4d0c3f45');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000020','http://purl.obolibrary.org/obo/BFO_0000031','http://purl.obolibrary.org/obo/RO_0000059','[1..*]','[0.. *]','DECLARED','BFO_0000020_RO_0000059_BFO_0000031');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C61c354fb','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C2986e108','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','INTERSECTION_AXIOM','ONTORELA_C61c354fb_IAO_0000136_ONTORELA_C2986e108');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000001','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/OBI_0000312','[1..*]','[0.. *]','INTERSECTION_AXIOM','HBW_0000001_OBI_0000312_HBW_0000012');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/physio.owl#ONTORELA_C4d0c3f45','http://purl.obolibrary.org/obo/HBW_0000007','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','INTERSECTION_AXIOM','ONTORELA_C4d0c3f45_IAO_0000136_HBW_0000007');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/BFO_0000050','[1..*]','[0.. *]','DECLARED','BFO_0000001_BFO_0000050_BFO_0000001');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000008','http://purl.obolibrary.org/obo/HBW_0000010','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','INTERSECTION_AXIOM','HBW_0000008_RO_0000087_HBW_0000010');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000004','http://purl.obolibrary.org/obo/OBI_0100026','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','HBW_0000004_IAO_0000136_OBI_0100026');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000017','http://purl.obolibrary.org/obo/BFO_0000015','http://purl.obolibrary.org/obo/BFO_0000054','[1..*]','[0.. *]','DECLARED','BFO_0000017_BFO_0000054_BFO_0000015');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000005','http://purl.obolibrary.org/obo/HBW_0000006','http://purl.obolibrary.org/obo/BFO_0000051','[1..1]','[0.. *]','DECLARED','HBW_0000005_BFO_0000051_HBW_0000006');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000012','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089','[1..1]','[0.. *]','DECLARED','HBW_0000012_PHYSIO_0000089_NCBITaxon_9606');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000022','http://purl.obolibrary.org/obo/NCBITaxon_9606','http://purl.obolibrary.org/obo/IAO_0000219','[1..*]','[0.. *]','DECLARED','HBW_0000022_IAO_0000219_NCBITaxon_9606');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000005','http://purl.obolibrary.org/obo/HBW_0000001','http://purl.obolibrary.org/obo/BFO_0000051','[1..*]','[0.. *]','DECLARED','HBW_0000005_BFO_0000051_HBW_0000001');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000219','[1..*]','[0.. *]','DECLARED','IAO_0000030_IAO_0000219_BFO_0000001');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000007','http://purl.obolibrary.org/obo/HBW_0000011','http://purl.obolibrary.org/obo/RO_0000087','[1..*]','[0.. *]','INTERSECTION_AXIOM','HBW_0000007_RO_0000087_HBW_0000011');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000002','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/RO_0000056','[1..*]','[0.. *]','DECLARED','BFO_0000002_RO_0000056_BFO_0000003');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000013','http://purl.obolibrary.org/obo/HBW_0000008','http://purl.obolibrary.org/obo/humanbodyweight-appli.owl/PHYSIO_0000089','[1..1]','[0.. *]','INTERSECTION_AXIOM','HBW_0000013_PHYSIO_0000089_HBW_0000008');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/BFO_0000003','http://purl.obolibrary.org/obo/BFO_0000004','http://purl.obolibrary.org/obo/BFO_0000066','[1..*]','[0.. *]','DECLARED','BFO_0000003_BFO_0000066_BFO_0000004');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000022','http://purl.obolibrary.org/obo/IAO_0020017','http://purl.obolibrary.org/obo/BFO_0000051','[1..*]','[0.. *]','DECLARED','HBW_0000022_BFO_0000051_IAO_0020017');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000109','http://purl.obolibrary.org/obo/IAO_0000003','http://purl.obolibrary.org/obo/IAO_0000039','[1..1]','[1.. *]','DECLARED','IAO_0000109_IAO_0000039_IAO_0000003');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000022','http://purl.obolibrary.org/obo/IAO_0020015','http://purl.obolibrary.org/obo/BFO_0000051','[1..*]','[0.. *]','DECLARED','HBW_0000022_BFO_0000051_IAO_0020015');

 call "OntoRelCat".onto_class_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000030','http://purl.obolibrary.org/obo/BFO_0000001','http://purl.obolibrary.org/obo/IAO_0000136','[1..*]','[0.. *]','DECLARED','IAO_0000030_IAO_0000136_BFO_0000001');

 call "OntoRelCat".onto_data_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2000/01/rdf-schema#Literal','http://purl.obolibrary.org/obo/IAO_0000004','[1..*]','DECLARED','IAO_0000032_IAO_0000004_Literal');

 call "OntoRelCat".onto_data_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000002','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','HBW_0000002_PHYSIO_0000100_string');

 call "OntoRelCat".onto_data_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000032','http://www.w3.org/2001/XMLSchema#double','http://purl.obolibrary.org/obo/IAO_0000004','[1..1]','DECLARED','IAO_0000032_IAO_0000004_double');

 call "OntoRelCat".onto_data_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020015','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','IAO_0020015_PHYSIO_0000100_string');

 call "OntoRelCat".onto_data_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0020017','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','IAO_0020017_PHYSIO_0000100_string');

 call "OntoRelCat".onto_data_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000577','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','IAO_0000577_PHYSIO_0000100_string');

 call "OntoRelCat".onto_data_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/IAO_0000003','http://www.w3.org/2001/XMLSchema#string','http://purl.obolibrary.org/obo/PHYSIO_0000100','[1..1]','DECLARED','IAO_0000003_PHYSIO_0000100_string');

 call "OntoRelCat".onto_data_axiom_ins ('10f3216f-b535-4bc5-a49a-59b5fe78e372','http://purl.obolibrary.org/obo/HBW_0000026','http://www.w3.org/2001/XMLSchema#decimal','http://purl.obolibrary.org/obo/IAO_0000004','[1..*]','DECLARED','HBW_0000026_IAO_0000004_decimal');


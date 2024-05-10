package ca.griis.mmec.test.integration.util;


import ca.griis.mmec.model.ontorel.ClassTable;
import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import it.unibz.inf.ontop.answering.OntopQueryEngine;
import it.unibz.inf.ontop.answering.connection.OntopConnection;
import it.unibz.inf.ontop.answering.connection.OntopStatement;
import it.unibz.inf.ontop.answering.reformulation.QueryReformulator;
import it.unibz.inf.ontop.evaluator.QueryContext;
import it.unibz.inf.ontop.exception.OBDASpecificationException;
import it.unibz.inf.ontop.exception.OntologyException;
import it.unibz.inf.ontop.exception.OntopConnectionException;
import it.unibz.inf.ontop.exception.OntopInvalidKGQueryException;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.injection.OntopMappingSQLAllConfiguration;
import it.unibz.inf.ontop.injection.OntopReformulationSQLConfiguration;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.node.NativeNode;
import it.unibz.inf.ontop.model.atom.RDFAtomPredicate;
import it.unibz.inf.ontop.query.KGQueryFactory;
import it.unibz.inf.ontop.query.RDF4JQueryFactory;
import it.unibz.inf.ontop.query.RDF4JSelectQuery;
import it.unibz.inf.ontop.query.SelectQuery;
import it.unibz.inf.ontop.spec.OBDASpecification;
import it.unibz.inf.ontop.spec.mapping.Mapping;
import it.unibz.inf.ontop.spec.ontology.Ontology;
import it.unibz.inf.ontop.spec.ontology.owlapi.OWLAPITranslatorOWL2QL;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;
import org.apache.commons.rdf.api.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.Compare;
import org.eclipse.rdf4j.query.algebra.Datatype;
import org.eclipse.rdf4j.query.algebra.Filter;
import org.eclipse.rdf4j.query.algebra.Join;
import org.eclipse.rdf4j.query.algebra.Projection;
import org.eclipse.rdf4j.query.algebra.ProjectionElem;
import org.eclipse.rdf4j.query.algebra.ProjectionElemList;
import org.eclipse.rdf4j.query.algebra.QueryRoot;
import org.eclipse.rdf4j.query.algebra.StatementPattern;
import org.eclipse.rdf4j.query.algebra.ValueConstant;
import org.eclipse.rdf4j.query.algebra.Var;
import org.eclipse.rdf4j.query.impl.MapBindingSet;
import org.eclipse.rdf4j.query.parser.ParsedTupleQuery;
import org.junit.jupiter.api.Assertions;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class R2rmlTester extends OntopTester {

  public R2rmlTester(PostgresContainerWrapper postgresContainerWrapper, File ontologyFile,
      File mappingFile) throws ClassNotFoundException, IOException, OWLOntologyCreationException {
    super(postgresContainerWrapper, ontologyFile, mappingFile);
  }

  public void runTest() throws Exception {
    // String withAutomaticInjectors = testWithAutomaticInjector();
    // System.out.println(withAutomaticInjectors);
    // String withoutAutomaticInjectors = testWithoutAutomaticInjectors();
    //
    // Assertions.assertEquals(withAutomaticInjectors, withoutAutomaticInjectors);
    // tt();
    // testGetDefinitions();
    try (OntopQueryEngine ontopQueryEngine = configuration.loadQueryEngine()) {
      ontopQueryEngine.connect();
      try (OntopConnection connection = ontopQueryEngine.getConnection()) {
        testGetAllDefinitions(connection);
//        testFigureCasDeBase(connection);
//        testPourLaFigureProprieteDefinieALAideDUneJointure(connection);
      }
    }
  }

  public String testWithAutomaticInjector() throws OBDASpecificationException {
    StringBuilder builder = new StringBuilder();

    OBDASpecification obdaSpecification = configuration.loadSpecification();
    Mapping mapping = obdaSpecification.getSaturatedMapping();

    HashMap<IRI, Optional<IQ>> classesMapping = new HashMap<>();
    HashMap<IRI, Optional<IQ>> propertiesMapping = new HashMap<>();

    for (RDFAtomPredicate predicate : mapping.getRDFAtomPredicates()) {
      mapping.getRDFClasses(predicate).forEach(
          c -> classesMapping.put(c, mapping.getRDFClassDefinition(predicate, c)));
      mapping.getRDFProperties(predicate).forEach(
          c -> propertiesMapping.put(c, mapping.getRDFPropertyDefinition(predicate, c)));
    }

    classesMapping.forEach((c, iq) -> {
      builder.append(String.format("Mapping for %s =>%n %s%n%n", c.getIRIString(),
          iq.map(IQ::toString).orElse("No IQ")));
    });

    propertiesMapping.forEach((c, iq) -> {
      builder.append(String.format("Mapping for %s =>%n %s%n%n", c.getIRIString(),
          iq.map(IQ::toString).orElse("No IQ")));
    });

    return builder.toString();
  }

  // public String testWithoutAutomaticInjectors()
  // throws OntopConnectionException, OntopInvalidKGQueryException, OntopReformulationException,
  // OBDASpecificationException, MetadataExtractionException {
  // SQLPPMappingFactory ppMappingFactory = configuration.getInjector().getInstance(
  // SQLPPMappingFactory.class);
  // SpecificationFactory specificationFactory = configuration.getInjector().getInstance(
  // SpecificationFactory.class);
  // R2RMLToSQLPPTriplesMapConverter transformer = configuration.getInjector().getInstance(
  // R2RMLToSQLPPTriplesMapConverter.class);
  // TMappingExclusionConfig tmappingExclusionConfig = configuration.getInjector().getInstance(
  // TMappingExclusionConfig.class);
  // QueryUnionSplitter unionSplitter = configuration.getInjector().getInstance(
  // QueryUnionSplitter.class);
  // UnionFlattener unionFlattener = configuration.getInjector().getInstance(UnionFlattener.class);
  // MappingCQCOptimizer mappingCqcOptimizer = configuration.getInjector().getInstance(
  // MappingCQCOptimizer.class);
  // // DefaultMappingTransformer defaultMappingTransformer =
  // // configuration.getInjector().getInstance(
  // // DefaultMappingTransformer.class);
  // UnionBasedQueryMerger queryMerger = configuration.getInjector().getInstance(
  // UnionBasedQueryMerger.class);
  // // JDBCMetadataProviderFactory metadataProviderFactory =
  // // configuration.getInjector().getInstance(
  // // JDBCMetadataProviderFactory.class);
  // SQLMappingExtractor mappingExtractor = configuration.getInjector().getInstance(
  // SQLMappingExtractor.class);
  //
  // StringBuilder builder = new StringBuilder();
  //
  // // try (Connection connection = LocalJDBCConnectionUtils.createConnection(
  // // configuration.getSettings())) {
  // // DBMetadataProvider metadataProvider =
  // // metadataProviderFactory.getMetadataProvider(connection);
  // // CachingMetadataLookup metadataLookup = new CachingMetadataLookup(metadataProvider);
  //
  // MMecR2rmlMappingParserImpl mMecR2rmlMappingParserImpl = new MMecR2rmlMappingParserImpl(
  // ppMappingFactory, specificationFactory, transformer);
  // // MMecSqlPpMappingConverterImpl mMecSqlPpMappingConverterImpl =
  // // new MMecSqlPpMappingConverterImpl(coreSingletons, sqlQueryParser);
  // MMecTMappingSaturatorImpl mMecTMappingSaturatorImpl = new MMecTMappingSaturatorImpl(
  // tmappingExclusionConfig, unionSplitter, unionFlattener, mappingCqcOptimizer, queryMerger,
  // coreSingletons);
  //
  // Ontology ontology = loadOntology();
  // SQLPPMapping ppMapping = mMecR2rmlMappingParserImpl.parse(mappingFile);
  //
  // OBDASpecInput specInput = OBDASpecInput.defaultBuilder().build();
  //
  // MappingExtractor.MappingAndDBParameters mappingAndDBParameters = mappingExtractor.extract(
  // ppMapping, specInput, Optional.of(ontology));
  // ImmutableList<MappingAssertion> mappingAssertions = mappingAndDBParameters.getMapping();
  // // ImmutableList<MappingAssertion> mappingAssertions = mMecSqlPpMappingConverterImpl.convert(
  // // ppMapping.getTripleMaps(), metadataLookup);
  //
  // ImmutableList<MappingAssertion> saturatedMappingAssertions =
  // mMecTMappingSaturatorImpl.saturate(mappingAssertions, loadOntology().tbox());
  // // OBDASpecification obdaSpecification = defaultMappingTransformer.transform(
  // // saturatedMappingAssertions,
  // // metadataProvider.getDBParameters(), Optional.of(loadOntology()), ImmutableSet.of(),
  // // ImmutableList.of());
  // // Mapping mapping = obdaSpecification.getSaturatedMapping();
  //
  // HashMap<IRI, Optional<IQ>> classesMapping = new HashMap<>();
  //
  // // for (RDFAtomPredicate predicate : mapping.getRDFAtomPredicates()) {
  // for (MappingAssertion assertion : saturatedMappingAssertions) {
  // classesMapping.put(assertion.getIndex().getIri(), Optional.of(assertion.getQuery()));
  // }
  //
  // classesMapping.forEach((c, iq) -> {
  // builder.append(String.format("Mapping for %s =>%n %s%n%n", c.getIRIString(),
  // iq.map(IQ::toString).orElse("No IQ")));
  // });
  //
  // // } catch (Exception e) {
  // // e.printStackTrace();
  // // }
  //
  // return builder.toString();
  // }

  public void testGetAllDefinitions(OntopConnection connection) {
    ontoRelCatRepository.getClassTables(mappingProperties.getOntoRelId())
        .stream()
        .map(classTable -> {
          try {
            return ontoRelTableMappingController.map(connection, classTable);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        })
        .map(mappedOntoRelTableView::getExpression)
        .forEach(System.out::println);

    ontoRelCatRepository.getObjectPropertyTables(mappingProperties.getOntoRelId())
        .stream()
        .map(opTable -> {
          try {
            return ontoRelTableMappingController.map(connection, opTable);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        })
        .map(mappedOntoRelTableView::getExpression)
        .forEach(System.out::println);

    ontoRelCatRepository.getDataPropertyTables(mappingProperties.getOntoRelId())
        .stream()
        .map(dpTable -> {
          try {
            return ontoRelTableMappingController.map(connection, dpTable);
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        })
        .map(mappedOntoRelTableView::getExpression)
        .forEach(System.out::println);

  }

  private void testFigureCasDeBase(OntopConnection connection)
      throws OBDASpecificationException, OntopConnectionException, OntopReformulationException {
    System.out.println("*********************************************");
    System.out.println("Tests pour la figure: Cas de base");
    System.out.println("*********************************************");
    System.out.println();

    System.out.println("---------------------------------------------");
    System.out.println("Classes");
    System.out.println("---------------------------------------------");
    System.out.println("Expression pour engendrer la classe \"IAO_0020015\"@personal name :");
    testGetClassDef(connection, "http://purl.obolibrary.org/obo/IAO_0020015");

    System.out.println("Expression pour engendrer la classe \"IAO_0020017\"@family name :");
    testGetClassDef(connection, "http://purl.obolibrary.org/obo/IAO_0020017");

    System.out.println("Expression pour engendrer la classe \"HBW_0000022\"@human name :");
    testGetClassDef(connection, "http://purl.obolibrary.org/obo/HBW_0000022");

    System.out.println("---------------------------------------------");
    System.out.println("ObjectProperties");
    System.out.println("---------------------------------------------");
    System.out.println("\"HBW_0000022\"@human name BFO_0000051@'has part' " +
        "\"IAO_0020015\"@personal name");
    testGetOPDef(connection, "http://purl.obolibrary.org/obo/HBW_0000022",
        "http://purl.obolibrary.org/obo/BFO_0000051",
        "http://purl.obolibrary.org/obo/IAO_0020015");

    System.out.println("\"HBW_0000022\"@personal name BFO_0000051@'has part' " +
        "\"IAO_0020017\"@family name");
    testGetOPDef(connection, "http://purl.obolibrary.org/obo/HBW_0000022",
        "http://purl.obolibrary.org/obo/BFO_0000051",
        "http://purl.obolibrary.org/obo/IAO_0020017");

    System.out.println("---------------------------------------------");
    System.out.println("DataProperties");
    System.out.println("---------------------------------------------");
    System.out.println("\"IAO_0020015\"@personal name PHYSIO_0000100@'has value' string");
    testGetDPDef(connection, "http://purl.obolibrary.org/obo/IAO_0020015",
        "http://purl.obolibrary.org/obo/PHYSIO_0000100",
        "http://www.w3.org/2001/XMLSchema#string");

    System.out.println("\"IAO_0020017\"@family name 'has value' \"NOM\"");
    testGetDPDef(connection, "http://purl.obolibrary.org/obo/IAO_0020017",
        "http://purl.obolibrary.org/obo/PHYSIO_0000100",
        "http://www.w3.org/2001/XMLSchema#string");
  }

  public void testPourLaFigureProprieteDefinieALAideDUneJointure(OntopConnection connection)
      throws OBDASpecificationException, OntopConnectionException, OntopReformulationException {
    System.out.println("*********************************************");
    System.out.println("Tests pour la figure: Propriété définie à l'aide d'une jointure");
    System.out.println("*********************************************");
    System.out.println();

    System.out.println("---------------------------------------------");
    System.out.println("Classes");
    System.out.println("---------------------------------------------");
    System.out.println("Expression pour engendrer la classe HBW_0000013@physiological"
        + " evaluation from health care provider :");
    testGetClassDef(connection, "http://purl.obolibrary.org/obo/HBW_0000013");

    System.out.println("Expression pour engendrer la classe HBW_0000008@health care provider :");
    testGetClassDef(connection, "http://purl.obolibrary.org/obo/HBW_0000008");

    System.out.println("---------------------------------------------");
    System.out.println("Object Properties");
    System.out.println("---------------------------------------------");
    System.out.println("HBW_0000013@physiological evaluation from health care provider"
        + " PHYSIO_0000089@has evaluant HBW_0000008@health care provider");
    testGetOPDef(connection, "http://purl.obolibrary.org/obo/HBW_0000013",
        "http://purl.obolibrary.org/obo/PHYSIO_0000089",
        "http://purl.obolibrary.org/obo/HBW_0000008");
  }

  public void testGetClassDef(String classIri)
      throws OntopConnectionException, OntopReformulationException, OBDASpecificationException {
    try (OntopQueryEngine ontopQueryEngine = configuration.loadQueryEngine()) {
      ontopQueryEngine.connect();
      try (OntopConnection connection = ontopQueryEngine.getConnection()) {
        testGetClassDef(connection, classIri);
      }
    }
  }

  protected void testGetClassDef(OntopConnection connection, String classIri)
      throws OntopConnectionException, OntopReformulationException {
    try (OntopStatement statement = connection.createStatement()) {

      SimpleValueFactory valueFactory = SimpleValueFactory.getInstance();

      StatementPattern classStatement = new StatementPattern(new Var("uid"),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("uid_uri",
              valueFactory.createIRI(classIri), true, true));

      QueryRoot queryRoot = new QueryRoot(classStatement);

      RDF4JQueryFactory factrdf4JQueryFactory = configuration.getInjector().getInstance(
          RDF4JQueryFactory.class);
      RDF4JSelectQuery rdf4JSelectQuery = factrdf4JQueryFactory.createSelectQuery(
          queryRoot.toString(),
          new ParsedTupleQuery(queryRoot), new MapBindingSet());

      printExecutableQuery(statement, rdf4JSelectQuery);
    }
  }

  public void testGetOPDef(String subUri, String opUri, String objUri)
      throws OntopConnectionException, OntopReformulationException, OBDASpecificationException {
    try (OntopQueryEngine ontopQueryEngine = configuration.loadQueryEngine()) {
      ontopQueryEngine.connect();
      try (OntopConnection connection = ontopQueryEngine.getConnection()) {
        testGetOPDef(connection, subUri, opUri, objUri);
      }
    }
  }

  protected void testGetOPDef(OntopConnection connection, String subUri, String opUri,
      String objUri)
      throws OntopConnectionException, OntopReformulationException {
    try (OntopStatement statement = connection.createStatement()) {

      SimpleValueFactory valueFactory = SimpleValueFactory.getInstance();

      StatementPattern subStatement = new StatementPattern(new Var("sub"),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("sub_uri",
              valueFactory.createIRI(subUri), true, true));

      StatementPattern objStatement = new StatementPattern(new Var("obj"),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("obj_uri",
              valueFactory.createIRI(objUri), true, true));

      StatementPattern relStatement = new StatementPattern(new Var("sub"),
          new Var("op_uri",
              valueFactory.createIRI(opUri), true, true),
          new Var("obj"));

      Join subAndObjJoin = new Join(subStatement, objStatement);
      Join relJoin = new Join(subAndObjJoin, relStatement);

      Projection projection = new Projection(relJoin,
          new ProjectionElemList(new ProjectionElem("sub"),
              new ProjectionElem("obj")));
      QueryRoot queryRoot = new QueryRoot(projection);

      RDF4JQueryFactory factrdf4JQueryFactory = configuration.getInjector().getInstance(
          RDF4JQueryFactory.class);
      RDF4JSelectQuery rdf4JSelectQuery = factrdf4JQueryFactory.createSelectQuery(
          queryRoot.toString(),
          new ParsedTupleQuery(queryRoot), new MapBindingSet());

      printExecutableQuery(statement, rdf4JSelectQuery);
    }
  }

  public void testGetDPDef(String subUri, String dpUri, String dtUri)
      throws OntopConnectionException, OntopReformulationException, OBDASpecificationException {
    try (OntopQueryEngine ontopQueryEngine = configuration.loadQueryEngine()) {
      ontopQueryEngine.connect();
      try (OntopConnection connection = ontopQueryEngine.getConnection()) {
        testGetDPDef(connection, subUri, dpUri, dtUri);
      }
    }
  }

  protected void testGetDPDef(OntopConnection connection, String subUri, String dpUri, String dtUri)
      throws OntopConnectionException, OntopReformulationException, OBDASpecificationException {
    try (OntopStatement statement = connection.createStatement()) {

      SimpleValueFactory valueFactory = SimpleValueFactory.getInstance();

      StatementPattern subStatement = new StatementPattern(new Var("sub"),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("sub_uri",
              valueFactory.createIRI(subUri), true, true));

      StatementPattern relStatement = new StatementPattern(new Var("sub"),
          new Var("dp_uri",
              valueFactory.createIRI(dpUri), true, true),
          // has_value
          new Var("val"));

      Join relJoin = new Join(subStatement, relStatement);
      Compare compare = new Compare(
          new Datatype(new Var("val")),
          new ValueConstant(valueFactory.createIRI(dtUri)));
      Filter filter = new Filter(relJoin, compare);

      Projection projection = new Projection(filter,
          new ProjectionElemList(new ProjectionElem("sub"),
              new ProjectionElem("val")));
      QueryRoot queryRoot = new QueryRoot(projection);

      RDF4JQueryFactory factrdf4JQueryFactory = configuration.getInjector().getInstance(
          RDF4JQueryFactory.class);
      RDF4JSelectQuery rdf4JSelectQuery = factrdf4JQueryFactory.createSelectQuery(
          queryRoot.toString(),
          new ParsedTupleQuery(queryRoot), new MapBindingSet());

      printExecutableQuery(statement, rdf4JSelectQuery);
    }
  }

  private static void printExecutableQuery(OntopStatement statement,
      RDF4JSelectQuery rdf4JSelectQuery)
      throws OntopReformulationException {
    try {
      IQ firstExecutableQuery = statement.getExecutableQuery(rdf4JSelectQuery,
          ImmutableMultimap.of());
      System.out.println(firstExecutableQuery.toString());
    } catch (Exception e) {
      if (e.getMessage().contains("IQ: EMPTY")) {
        System.out.println("Empty mapping");
      } else {
        throw e;
      }
    }
  }

  public void tt()
      throws OBDASpecificationException, OntopInvalidKGQueryException, OntopReformulationException {
    String PERSON_QUERY_STRING = "PREFIX : <http://www.griis.ca/projects/>\n"
        + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
        + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + "\n"
        + "SELECT DISTINCT ?sub ?val WHERE {\n" + "  ?sub rdf:type :tst .\n"
        + "  \n" + "  ?sub :has_value ?val .\n"
        + "  \n" + "  filter(datatype(?val) = xsd:string) .\n"
        + "}";

    QueryReformulator queryReformulator = createReformulator();
    KGQueryFactory kgQueryFactory = queryReformulator.getInputQueryFactory();

    SelectQuery query = kgQueryFactory.createSelectQuery(PERSON_QUERY_STRING);
    QueryContext emptyQueryContext = queryReformulator.getQueryContextFactory().create(
        ImmutableMap.of());

    IQ executableQuery = queryReformulator.reformulateIntoNativeQuery(query, emptyQueryContext,
        queryReformulator.getQueryLoggerFactory().create(ImmutableMap.of()));
    String sqlQuery = Optional.of(executableQuery.getTree()).filter(t -> t instanceof UnaryIQTree)
        .map(t -> ((UnaryIQTree) t).getChild().getRootNode()).filter(n -> n instanceof NativeNode)
        .map(n -> ((NativeNode) n).getNativeQueryString()).orElseThrow(
            () -> new RuntimeException("Cannot extract the SQL query from\n" + executableQuery));

    Assertions.assertFalse(sqlQuery.isEmpty());
  }

  /**
   * Instantiation of the query reformulator
   */
  private QueryReformulator createReformulator() throws OBDASpecificationException {

    OBDASpecification obdaSpecification = loadOBDASpecification();

    OntopReformulationSQLConfiguration reformulationConfiguration =
        OntopReformulationSQLConfiguration.defaultBuilder().obdaSpecification(obdaSpecification)
            .jdbcUrl(configuration.getSettings().getJdbcUrl()).build();

    return reformulationConfiguration.loadQueryReformulator();
  }

  private OBDASpecification loadOBDASpecification() throws OBDASpecificationException {
    OntopMappingSQLAllConfiguration mappingConfiguration =
        OntopMappingSQLAllConfiguration.defaultBuilder()
            // .nativeOntopMappingFile("/Users/samueldussault/Documents/Projets/GitHub/ontop/engine/system/sql/core/src/test/resources/marriage/marriage.obda")
            .r2rmlMappingFile(mappingFile).jdbcUser(configuration.getSettings().getJdbcUser().get())
            .jdbcPassword(configuration.getSettings().getJdbcPassword().get()).jdbcUrl(
                configuration.getSettings().getJdbcUrl())
            .build();

    return mappingConfiguration.loadSpecification();
  }

  Ontology loadOntology() throws OntologyException {
    OWLAPITranslatorOWL2QL translator = configuration.getInjector().getInstance(
        OWLAPITranslatorOWL2QL.class);
    try {
      return configuration.loadInputOntology().map(translator::translateAndClassify).orElseThrow();
    } catch (OWLOntologyCreationException e) {
      throw new OntologyException(e.getMessage());
    }
  }
}

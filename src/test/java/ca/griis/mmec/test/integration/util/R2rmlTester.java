package ca.griis.mmec.test.integration.util;


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

  @Override
  public void runTest() throws Exception {
    //    String withAutomaticInjectors = testWithAutomaticInjector();
    //    System.out.println(withAutomaticInjectors);
    // String withoutAutomaticInjectors = testWithoutAutomaticInjectors();
    //
    // Assertions.assertEquals(withAutomaticInjectors, withoutAutomaticInjectors);
    // tt();
    testGetDefinitions();
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

  private void testGetDefinitions()
      throws OBDASpecificationException, OntopConnectionException, OntopReformulationException {

    // TODO: Ajouter un test pour les expressions vide et la mécanique pour générer des
    //       expressions relationnelles vides.
    try (OntopQueryEngine ontopQueryEngine = configuration.loadQueryEngine()) {
      ontopQueryEngine.connect();
      try (OntopConnection connection = ontopQueryEngine.getConnection()) {
        System.out.println("Test de génération d'une expression de classe");
        System.out.println("---------------------------------------------");
        testGetClassDef(connection);

        System.out.println("Test de génération d'une expression de ObjectProperty");
        System.out.println("---------------------------------------------------");
        testGetOPDef(connection);

        System.out.println("Test de génération d'une expression de DataProperty");
        System.out.println("---------------------------------------------------");
        testGetDPDef(connection);
      }
    }
  }

  private void testGetClassDef(OntopConnection connection)
      throws OntopConnectionException, OntopReformulationException {
    try (OntopStatement statement = connection.createStatement()) {

      SimpleValueFactory valueFactory = SimpleValueFactory.getInstance();

      StatementPattern classStatement = new StatementPattern(new Var("uid"),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("uid_uri",
              valueFactory.createIRI("http://purl.obolibrary.org/obo/HBW_0000004"), true, true));

      QueryRoot queryRoot = new QueryRoot(classStatement);

      RDF4JQueryFactory factrdf4JQueryFactory = configuration.getInjector().getInstance(
          RDF4JQueryFactory.class);
      RDF4JSelectQuery rdf4JSelectQuery = factrdf4JQueryFactory.createSelectQuery(
          queryRoot.toString(),
          new ParsedTupleQuery(queryRoot), new MapBindingSet());

      IQ firstExecutableQuery = statement.getExecutableQuery(rdf4JSelectQuery,
          ImmutableMultimap.of());
      System.out.println(firstExecutableQuery.toString());

      // La configuration Ontop originale génère ceci :
      // ans1(uid)
      // CONSTRUCT [uid] [uid/RDF(TEXTToTEXT(uid),IRI)]
      // NATIVE [uid]
      // SELECT ('http://www.griis.ca/projects/tst1C0004X/' || CAST(v1."m" AS TEXT)) AS "uid"
      // FROM "TABLE2" v1
      // Alors que la configuration MMec génère ceci :
      // ans1(uid)
      // NATIVE [uid]
      // SELECT individuation('http://www.griis.ca/projects/tst1C0004X/{}', v1."m") AS "uid"
      // FROM "TABLE2" v1
    }
  }

  private void testGetOPDef(OntopConnection connection)
      throws OntopConnectionException, OntopReformulationException {
    try (OntopStatement statement = connection.createStatement()) {

      SimpleValueFactory valueFactory = SimpleValueFactory.getInstance();

      StatementPattern subStatement = new StatementPattern(new Var("sub"),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("sub_uri",
              valueFactory.createIRI("http://purl.obolibrary.org/obo/IAO_0000032"), true, true));

      StatementPattern objStatement = new StatementPattern(new Var("obj"),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("obj_uri",
              valueFactory.createIRI("http://purl.obolibrary.org/obo/IAO_0000003"), true, true));

      StatementPattern relStatement = new StatementPattern(new Var("sub"),
          new Var("op_uri",
              valueFactory.createIRI("http://purl.obolibrary.org/obo/IAO_0000039"), true, true),
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

      IQ firstExecutableQuery = statement.getExecutableQuery(rdf4JSelectQuery,
          ImmutableMultimap.of());
      System.out.println(firstExecutableQuery.toString());

      // La configuration Ontop originale génère ceci :
      // ans1(sub, obj)
      // CONSTRUCT [obj, sub] [obj/RDF(TEXTToTEXT(obj),IRI), sub/RDF(TEXTToTEXT(sub),IRI)]
      // NATIVE [obj, sub]
      // SELECT DISTINCT ('http://www.griis.ca/projects/tst1C0004XUnionOf/' || CAST(v1."n" AS TEXT))
      // AS "obj", ('http://www.griis.ca/projects/tst1C0004X/' || CAST(v1."m" AS TEXT)) AS "sub"
      // FROM "TABLE2" v1, "TABLE2" v2
      // WHERE (((v2."o" < 5) OR (v2."o" >= 5)) AND ((v1."o" >= 5) OR (v1."o" < 5)) AND v1."n" =
      // v2."n")
      // Alors que la configuration MMec génère ceci :
      // ans1(sub, obj)
      // NATIVE [obj, sub]
      // SELECT DISTINCT individuation('http://www.griis.ca/projects/tst1C0004XUnionOf/{}', v1."n")
      // AS "obj", individuation('http://www.griis.ca/projects/tst1C0004X/{}', v1."m") AS "sub"
      // FROM "TABLE2" v1, "TABLE2" v2
      // WHERE (((v2."o" < 5) OR (v2."o" >= 5)) AND ((v1."o" >= 5) OR (v1."o" < 5)) AND v1."n" =
      // v2."n")
    }
  }


  private void testGetDPDef(OntopConnection connection)
      throws OntopConnectionException, OntopReformulationException, OBDASpecificationException {
    try (OntopStatement statement = connection.createStatement()) {

      SimpleValueFactory valueFactory = SimpleValueFactory.getInstance();

      StatementPattern subStatement = new StatementPattern(new Var("sub"),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("sub_uri",
              valueFactory.createIRI("http://purl.obolibrary.org/obo/HBW_0000003"), true, true));

      StatementPattern relStatement = new StatementPattern(new Var("sub"),
          new Var("dp_uri",
              valueFactory.createIRI("http://purl.obolibrary.org/obo/PHYSIO_0000100"), true, true),
          //has_value
          new Var("val"));

      Join relJoin = new Join(subStatement, relStatement);
      Compare compare = new Compare(
          new Datatype(new Var("val")),
          new ValueConstant(valueFactory.createIRI("http://www.w3.org/2001/XMLSchema#string")));
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

      IQ firstExecutableQuery = statement.getExecutableQuery(rdf4JSelectQuery,
          ImmutableMultimap.of());
      System.out.println(firstExecutableQuery.toString());

      // La configuration Ontop originale génère ceci :
      // ans1(sub, val)
      // CONSTRUCT [sub, val] [sub/RDF(TEXTToTEXT(sub),IRI), val/RDF(TEXTToTEXT(val),xsd:string)]
      // NATIVE [sub, val]
      // SELECT ('http://www.griis.ca/projects/tst/' || CAST(v1."m" AS TEXT)) AS "sub", CAST(v1."o"
      // AS TEXT) AS "val"
      // FROM "TABLE2" v1
      // WHERE v1."o" IS NOT NULL

      // Alors que la configuration MMec génère ceci :
      // ans1(sub, val)
      // NATIVE [sub, val]
      // SELECT individuation('http://www.griis.ca/projects/tst/{}', v1."m") AS "sub", CAST(v1."o" AS TEXT) AS "val"
      // FROM "TABLE2" v1
      // WHERE v1."o" IS NOT NULL
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

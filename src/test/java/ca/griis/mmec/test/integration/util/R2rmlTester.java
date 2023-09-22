package ca.griis.mmec.test.integration.util;


import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import it.unibz.inf.ontop.answering.OntopQueryEngine;
import it.unibz.inf.ontop.answering.connection.OntopConnection;
import it.unibz.inf.ontop.answering.connection.OntopStatement;
import it.unibz.inf.ontop.answering.reformulation.QueryReformulator;
import it.unibz.inf.ontop.datalog.UnionFlattener;
import it.unibz.inf.ontop.dbschema.DBMetadataProvider;
import it.unibz.inf.ontop.dbschema.impl.CachingMetadataLookup;
import it.unibz.inf.ontop.dbschema.impl.JDBCMetadataProviderFactory;
import it.unibz.inf.ontop.exception.OBDASpecificationException;
import it.unibz.inf.ontop.exception.OntologyException;
import it.unibz.inf.ontop.exception.OntopConnectionException;
import it.unibz.inf.ontop.exception.OntopInvalidKGQueryException;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.injection.OntopMappingSQLAllConfiguration;
import it.unibz.inf.ontop.injection.OntopReformulationSQLConfiguration;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.injection.SpecificationFactory;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.node.NativeNode;
import it.unibz.inf.ontop.iq.tools.UnionBasedQueryMerger;
import it.unibz.inf.ontop.model.atom.RDFAtomPredicate;
import it.unibz.inf.ontop.query.KGQueryFactory;
import it.unibz.inf.ontop.query.RDF4JQueryFactory;
import it.unibz.inf.ontop.query.RDF4JSelectQuery;
import it.unibz.inf.ontop.query.SelectQuery;
import it.unibz.inf.ontop.spec.OBDASpecInput;
import it.unibz.inf.ontop.spec.OBDASpecification;
import it.unibz.inf.ontop.spec.mapping.Mapping;
import it.unibz.inf.ontop.spec.mapping.MappingAssertion;
import it.unibz.inf.ontop.spec.mapping.MappingExtractor;
import it.unibz.inf.ontop.spec.mapping.TMappingExclusionConfig;
import it.unibz.inf.ontop.spec.mapping.impl.SQLMappingExtractor;
import it.unibz.inf.ontop.spec.mapping.parser.impl.MMecR2rmlMappingParserImpl;
import it.unibz.inf.ontop.spec.mapping.parser.impl.R2RMLToSQLPPTriplesMapConverter;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMapping;
import it.unibz.inf.ontop.spec.mapping.pp.impl.MMecSqlPpMappingConverterImpl;
import it.unibz.inf.ontop.spec.mapping.transformer.MappingCQCOptimizer;
import it.unibz.inf.ontop.spec.mapping.transformer.QueryUnionSplitter;
import it.unibz.inf.ontop.spec.mapping.transformer.impl.DefaultMappingTransformer;
import it.unibz.inf.ontop.spec.mapping.transformer.impl.MMecTMappingSaturatorImpl;
import it.unibz.inf.ontop.spec.ontology.Ontology;
import it.unibz.inf.ontop.spec.ontology.owlapi.OWLAPITranslatorOWL2QL;
import it.unibz.inf.ontop.utils.LocalJDBCConnectionUtils;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Optional;
import org.apache.commons.rdf.api.IRI;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.Join;
import org.eclipse.rdf4j.query.algebra.Projection;
import org.eclipse.rdf4j.query.algebra.ProjectionElem;
import org.eclipse.rdf4j.query.algebra.ProjectionElemList;
import org.eclipse.rdf4j.query.algebra.QueryRoot;
import org.eclipse.rdf4j.query.algebra.StatementPattern;
import org.eclipse.rdf4j.query.algebra.Var;
import org.eclipse.rdf4j.query.impl.MapBindingSet;
import org.eclipse.rdf4j.query.parser.ParsedTupleQuery;
import org.junit.jupiter.api.Assertions;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class R2rmlTester extends OntopTester {

  public R2rmlTester(PostgresContainerWrapper postgresContainerWrapper, String ontologyFile,
      String mappingFile) throws ClassNotFoundException, IOException, OWLOntologyCreationException {
    super(postgresContainerWrapper, ontologyFile, mappingFile);
  }

  @Override
  public void runTest() throws Exception {
//    String withAutomaticInjectors = testWithAutomaticInjector();
//    String withoutAutomaticInjectors = testWithoutAutomaticInjectors();
//
//    Assertions.assertEquals(withAutomaticInjectors, withoutAutomaticInjectors);
    //    tt();

    testGetOPDef();
  }

  public String testWithAutomaticInjector() throws OBDASpecificationException {
    StringBuilder builder = new StringBuilder();

    // TODO: Voir comment est-ce qu'on peut obtenir une requête SQL à partir d'un IQ qu'on a
    // contruit à partir d'un OP (ex: un IQ qui correspondrait au sparql :
    // select suj rel obj from { suj rdf:type <SujetIRI> . rel rdf:type <RelationIRI> . obj rdf:type
    // <ObjetIRI> . suj rel obj . }
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

  public String testWithoutAutomaticInjectors()
      throws OntopConnectionException, OntopInvalidKGQueryException, OntopReformulationException,
      OBDASpecificationException {
    SQLPPMappingFactory ppMappingFactory = configuration.getInjector().getInstance(
        SQLPPMappingFactory.class);
    SpecificationFactory specificationFactory = configuration.getInjector().getInstance(
        SpecificationFactory.class);
    R2RMLToSQLPPTriplesMapConverter transformer = configuration.getInjector().getInstance(
        R2RMLToSQLPPTriplesMapConverter.class);
    TMappingExclusionConfig tmappingExclusionConfig = configuration.getInjector().getInstance(
        TMappingExclusionConfig.class);
    QueryUnionSplitter unionSplitter = configuration.getInjector().getInstance(
        QueryUnionSplitter.class);
    UnionFlattener unionFlattener = configuration.getInjector().getInstance(UnionFlattener.class);
    MappingCQCOptimizer mappingCqcOptimizer = configuration.getInjector().getInstance(
        MappingCQCOptimizer.class);
    DefaultMappingTransformer defaultMappingTransformer = configuration.getInjector().getInstance(
        DefaultMappingTransformer.class);
    UnionBasedQueryMerger queryMerger = configuration.getInjector().getInstance(
        UnionBasedQueryMerger.class);
    JDBCMetadataProviderFactory metadataProviderFactory = configuration.getInjector().getInstance(
        JDBCMetadataProviderFactory.class);
    SQLMappingExtractor mappingExtractor = configuration.getInjector().getInstance(
        SQLMappingExtractor.class);

    StringBuilder builder = new StringBuilder();

    try (Connection connection = LocalJDBCConnectionUtils.createConnection(
        configuration.getSettings())) {
      DBMetadataProvider metadataProvider = metadataProviderFactory.getMetadataProvider(connection);
      CachingMetadataLookup metadataLookup = new CachingMetadataLookup(metadataProvider);

      MMecR2rmlMappingParserImpl mMecR2rmlMappingParserImpl = new MMecR2rmlMappingParserImpl(
          ppMappingFactory, specificationFactory, transformer);
      MMecSqlPpMappingConverterImpl mMecSqlPpMappingConverterImpl =
          new MMecSqlPpMappingConverterImpl(coreSingletons, sqlQueryParser);
      MMecTMappingSaturatorImpl mMecTMappingSaturatorImpl = new MMecTMappingSaturatorImpl(
          tmappingExclusionConfig, unionSplitter, unionFlattener, mappingCqcOptimizer, queryMerger,
          coreSingletons);

      Ontology ontology = loadOntology();
      SQLPPMapping ppMapping = mMecR2rmlMappingParserImpl.parse(new File(mappingFile));

      OBDASpecInput specInput = OBDASpecInput.defaultBuilder().build();

      MappingExtractor.MappingAndDBParameters mappingAndDBParameters = mappingExtractor.extract(
          ppMapping, specInput, Optional.of(ontology));
      ImmutableList<MappingAssertion> mappingAssertions = mappingAndDBParameters.getMapping();
      // ImmutableList<MappingAssertion> mappingAssertions = mMecSqlPpMappingConverterImpl.convert(
      // ppMapping.getTripleMaps(), metadataLookup);

      ImmutableList<MappingAssertion> saturatedMappingAssertions =
          mMecTMappingSaturatorImpl.saturate(mappingAssertions, loadOntology().tbox());
      // OBDASpecification obdaSpecification = defaultMappingTransformer.transform(
      // saturatedMappingAssertions,
      // metadataProvider.getDBParameters(), Optional.of(loadOntology()), ImmutableSet.of(),
      // ImmutableList.of());
      // Mapping mapping = obdaSpecification.getSaturatedMapping();

      HashMap<IRI, Optional<IQ>> classesMapping = new HashMap<>();

      // for (RDFAtomPredicate predicate : mapping.getRDFAtomPredicates()) {
      for (MappingAssertion assertion : saturatedMappingAssertions) {
        classesMapping.put(assertion.getIndex().getIri(), Optional.of(assertion.getQuery()));
      }

      classesMapping.forEach((c, iq) -> {
        builder.append(String.format("Mapping for %s =>%n %s%n%n", c.getIRIString(),
            iq.map(IQ::toString).orElse("No IQ")));
      });

    } catch (Exception e) {
      e.printStackTrace();
    }

    return builder.toString();
  }

  private void testGetOPDef()
      throws OBDASpecificationException, OntopConnectionException, OntopReformulationException {
    configuration.loadSpecification();

    try (OntopQueryEngine ontopQueryEngine = configuration.loadQueryEngine()) {
      ontopQueryEngine.connect();
      try (OntopConnection connection = ontopQueryEngine.getConnection();
          OntopStatement statement = connection.createStatement()) {

        SimpleValueFactory valueFactory = SimpleValueFactory.getInstance();

        StatementPattern subStatement = new StatementPattern(new Var("sub"),
            new Var("_const_f5e5585a_uri",
                valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true),
            new Var("_const_29732e82_uri",
                valueFactory.createIRI("http://www.griis.ca/projects/ONTORELA_C0004X"), true));

        StatementPattern objStatement = new StatementPattern(new Var("obj"),
            new Var("_const_f5e5585a_uri",
                valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true),
            new Var("_const_305deffb_uri",
                valueFactory.createIRI("http://www.griis.ca/projects/ONTORELA_C0006X"), true));

        StatementPattern relStatement = new StatementPattern(new Var("sub"),
            new Var("_const_29732546_uri",
                valueFactory.createIRI("http://www.griis.ca/projects/rel"), true), new Var("obj"));

        Join subAndObjJoin = new Join(subStatement, objStatement);
        Join relJoin = new Join(subAndObjJoin, relStatement);

        Projection projection = new Projection(relJoin,
            new ProjectionElemList(new ProjectionElem("sub"),
                new ProjectionElem("obj")));
        QueryRoot queryRoot = new QueryRoot(projection);

        RDF4JQueryFactory factrdf4JQueryFactory = configuration.getInjector().getInstance(
            RDF4JQueryFactory.class);
        RDF4JSelectQuery rdf4JSelectQuery = factrdf4JQueryFactory.createSelectQuery("",
            new ParsedTupleQuery(queryRoot), new MapBindingSet());

        IQ firstExecutableQuery = statement.getExecutableQuery(rdf4JSelectQuery);

        System.out.println(firstExecutableQuery.toString());

        // Se traduit par :
        //     ans1(sub, obj)
        //     CONSTRUCT [sub, obj] [sub/RDF(http://www.griis.ca/projects/tst/{}(INTEGERToTEXT(m1m6)),IRI), obj/RDF(http://www.griis.ca/projects/tst1C0004X/{}(INTEGERToTEXT(m1m6)),IRI)]
        //     NATIVE [m1m6]
        //       SELECT v1."m" AS "m1m6"
        //       FROM "TABLE2" v1
      }
    }
  }

  public void tt()
      throws OBDASpecificationException, OntopInvalidKGQueryException, OntopReformulationException {
    String PERSON_QUERY_STRING = "PREFIX : <http://www.griis.ca/projects/>\n"
        + "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
        + "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + "\n"
        + "SELECT DISTINCT ?sub ?obj WHERE {\n" + "  ?sub rdf:type :tst .\n"
        + "  ?obj rdf:type :ONTORELA_C0004X .\n" + "  ?sub :rel ?obj .\n" + "}";

    QueryReformulator queryReformulator = createReformulator();
    KGQueryFactory kgQueryFactory = queryReformulator.getInputQueryFactory();

    SelectQuery query = kgQueryFactory.createSelectQuery(PERSON_QUERY_STRING);

    IQ executableQuery = queryReformulator.reformulateIntoNativeQuery(query,
        queryReformulator.getQueryLoggerFactory().create(ImmutableMultimap.of()));
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
            //            .nativeOntopMappingFile("/Users/samueldussault/Documents/Projets/GitHub/ontop/engine/system/sql/core/src/test/resources/marriage/marriage.obda")
            .r2rmlMappingFile(mappingFile).jdbcUser(configuration.getSettings().getJdbcUser().get())
            .jdbcPassword(configuration.getSettings().getJdbcPassword().get()).jdbcUrl(
                configuration.getSettings().getJdbcUrl()).build();

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

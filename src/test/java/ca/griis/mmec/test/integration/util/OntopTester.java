package ca.griis.mmec.test.integration.util;

import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import it.unibz.inf.ontop.answering.reformulation.generation.NativeQueryGenerator;
import it.unibz.inf.ontop.answering.reformulation.rewriting.QueryRewriter;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.injection.OntopSQLOWLAPIConfiguration;
import it.unibz.inf.ontop.injection.TranslationFactory;
import it.unibz.inf.ontop.iq.optimizer.GeneralStructuralAndSemanticIQOptimizer;
import it.unibz.inf.ontop.iq.planner.QueryPlanner;
import it.unibz.inf.ontop.iq.type.NotYetTypedBinaryMathOperationTransformer;
import it.unibz.inf.ontop.iq.type.NotYetTypedEqualityTransformer;
import it.unibz.inf.ontop.model.atom.AtomFactory;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.spec.mapping.impl.SQLMappingExtractor;
import it.unibz.inf.ontop.spec.mapping.parser.impl.R2RMLMMecMappingParserImpl;
import it.unibz.inf.ontop.spec.sqlparser.SQLQueryParser;
import it.unibz.inf.ontop.substitution.SubstitutionFactory;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.stream.Stream;

public abstract class OntopTester {
  protected final OntopSQLOWLAPIConfiguration configuration;
  protected final CoreSingletons coreSingletons;
  protected final SubstitutionFactory substitutionFactory;
  protected final IntermediateQueryFactory iqFactory;
  protected final TranslationFactory translationFactory;
  protected final AtomFactory atomFactory;
  protected final TermFactory termFactory;
  protected final QueryRewriter queryRewriter;
  protected final GeneralStructuralAndSemanticIQOptimizer generalOptimizer;
  protected final QueryPlanner queryPlanner;
  protected final NativeQueryGenerator nativeQueryGenerator;
  protected final NotYetTypedEqualityTransformer notYetTypedEqualityTransformer;
  protected final NotYetTypedBinaryMathOperationTransformer
      notYetTypedBinaryMathOperationTransformer;
  protected final SQLQueryParser sqlQueryParser;
  protected final R2RMLMMecMappingParserImpl r2RMLMMecMappingParserImpl;
  protected final SQLMappingExtractor mappingExtractor;
  protected final String injectionConfigurationFile = "defaultConfiguration.properties";

  public OntopTester(PostgresContainerWrapper postgresContainerWrapper, String ontologyFile,
      String mappingFile) throws ClassNotFoundException, IOException, OWLOntologyCreationException {
    Properties dbProperties = postgresContainerWrapper.getPropertiesForOntop();
    Properties defaultConfigurationProperties = getInjectionConfigurationProperties();
    Properties properties = mergeProperties(dbProperties, defaultConfigurationProperties);

    configuration = OntopSQLOWLAPIConfiguration.defaultBuilder()
        .properties(properties)
        .r2rmlMappingFile(mappingFile)
        .ontologyFile(ontologyFile)
        .build();

    coreSingletons = configuration.getInjector().getInstance(CoreSingletons.class);
    substitutionFactory = configuration.getInjector().getInstance(SubstitutionFactory.class);
    translationFactory = configuration.getInjector().getInstance(TranslationFactory.class);
    iqFactory = configuration.getInjector().getInstance(IntermediateQueryFactory.class);
    atomFactory = configuration.getInjector().getInstance(AtomFactory.class);
    termFactory = configuration.getInjector().getInstance(TermFactory.class);
    queryRewriter = configuration.getInjector().getInstance(QueryRewriter.class);
    notYetTypedEqualityTransformer =
        configuration.getInjector().getInstance(NotYetTypedEqualityTransformer.class);
    notYetTypedBinaryMathOperationTransformer =
        configuration.getInjector().getInstance(NotYetTypedBinaryMathOperationTransformer.class);
    generalOptimizer =
        configuration.getInjector().getInstance(GeneralStructuralAndSemanticIQOptimizer.class);
    r2RMLMMecMappingParserImpl =
        configuration.getInjector().getInstance(R2RMLMMecMappingParserImpl.class);
    queryPlanner = configuration.getInjector().getInstance(QueryPlanner.class);
    mappingExtractor = configuration.getInjector().getInstance(SQLMappingExtractor.class);
    nativeQueryGenerator =
        translationFactory.create(postgresContainerWrapper.getDBParameters(coreSingletons));
    sqlQueryParser = new SQLQueryParser(coreSingletons);
  }

  abstract public void runTest() throws Exception;

  private Properties getInjectionConfigurationProperties() throws IOException {
    Properties prop = new Properties();

    try (InputStream propStream = this.getClass().getClassLoader()
        .getResourceAsStream(injectionConfigurationFile)) {
      if (propStream == null) {
        throw new IOException("Cannot find file " + injectionConfigurationFile);
      }

      prop.load(propStream);
      return prop;
    }
  }

  private Properties mergeProperties(Properties... properties) {
    return Stream.of(properties)
        .collect(Properties::new, Hashtable::putAll, Hashtable::putAll);
  }
}

package ca.griis.mmec.test.integration.util;

import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.properties.builder.FacadePropertiesBuilder;
import ca.griis.mmec.properties.builder.MappingPropertiesBuilder;
import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import it.unibz.inf.ontop.answering.reformulation.generation.NativeQueryGenerator;
import it.unibz.inf.ontop.answering.reformulation.rewriting.QueryRewriter;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.injection.TranslationFactory;
import it.unibz.inf.ontop.injection.impl.MMecConfiguration;
import it.unibz.inf.ontop.iq.optimizer.GeneralStructuralAndSemanticIQOptimizer;
import it.unibz.inf.ontop.iq.planner.QueryPlanner;
import it.unibz.inf.ontop.iq.type.NotYetTypedBinaryMathOperationTransformer;
import it.unibz.inf.ontop.iq.type.NotYetTypedEqualityTransformer;
import it.unibz.inf.ontop.model.atom.AtomFactory;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.spec.mapping.impl.SQLMappingExtractor;
import it.unibz.inf.ontop.spec.mapping.parser.impl.MMecR2rmlMappingParserImpl;
import it.unibz.inf.ontop.spec.sqlparser.SQLQueryParser;
import it.unibz.inf.ontop.substitution.SubstitutionFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.stream.Stream;

public abstract class OntopTester {
  protected final MMecConfiguration configuration;
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
  protected final NotYetTypedBinaryMathOperationTransformer notYetTypedBinaryMathOperationTransformer;
  protected final SQLQueryParser sqlQueryParser;
  protected final MMecR2rmlMappingParserImpl mMecR2rmlMappingParserImpl;
  protected final SQLMappingExtractor mappingExtractor;
  protected final File mappingFile;
  protected static final String injectionConfigurationFile = "defaultConfiguration.properties";

  public OntopTester(PostgresContainerWrapper postgresContainerWrapper, File ontologyFile,
      File mappingFile) {
    Properties dbProperties = postgresContainerWrapper.getPropertiesForOntop();
    Properties defaultConfigurationProperties = null;
    try {
      defaultConfigurationProperties = getInjectionConfigurationProperties();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    Properties properties = mergeProperties(dbProperties, defaultConfigurationProperties);
    MappingProperties mappingProperties = new MappingPropertiesBuilder()
        .setOntoRelId("OntoRelCat_simple").build();
    FacadeProperties facadeProperties = new FacadePropertiesBuilder().build();

    configuration = new MMecConfiguration.MMecConfigurationBuilder()
        .properties(properties)
        .r2rmlMappingFile(mappingFile)
        .ontologyFile(ontologyFile)
        .mappingProperties(mappingProperties)
        .facadeProperties(facadeProperties)
        .build();

    this.mappingFile = mappingFile;

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
    mMecR2rmlMappingParserImpl =
        configuration.getInjector().getInstance(MMecR2rmlMappingParserImpl.class);
    queryPlanner = configuration.getInjector().getInstance(QueryPlanner.class);
    mappingExtractor = configuration.getInjector().getInstance(SQLMappingExtractor.class);
    nativeQueryGenerator =
        translationFactory.create(postgresContainerWrapper.getDBParameters(coreSingletons));
    sqlQueryParser = new SQLQueryParser(coreSingletons);
  }

  public abstract void runTest() throws Exception;

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

package ca.griis.mmec.test.integration.util;

import ca.griis.mmec.controller.ontop.OntoRelTableMappingController;
import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.FacadeType;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.properties.builder.FacadePropertiesBuilder;
import ca.griis.mmec.properties.builder.MappingPropertiesBuilder;
import ca.griis.mmec.repository.OntoRelCatRepository;
import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import ca.griis.mmec.view.MappedOntoRelTableView;
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

public class OntopTester {
  public final MMecConfiguration configuration;
  public final CoreSingletons coreSingletons;
  public final SubstitutionFactory substitutionFactory;
  public final IntermediateQueryFactory iqFactory;
  public final TranslationFactory translationFactory;
  public final AtomFactory atomFactory;
  public final TermFactory termFactory;
  public final QueryRewriter queryRewriter;
  public final GeneralStructuralAndSemanticIQOptimizer generalOptimizer;
  public final QueryPlanner queryPlanner;
  public final NativeQueryGenerator nativeQueryGenerator;
  public final NotYetTypedEqualityTransformer notYetTypedEqualityTransformer;
  public final NotYetTypedBinaryMathOperationTransformer notYetTypedBinaryMathOperationTransformer;
  public final SQLQueryParser sqlQueryParser;
  public final MMecR2rmlMappingParserImpl mMecR2rmlMappingParserImpl;
  public final SQLMappingExtractor mappingExtractor;
  public final File mappingFile;
  public final OntoRelCatRepository ontoRelCatRepository;
  public final MappingProperties mappingProperties;
  public final MappedOntoRelTableView mappedOntoRelTableView;
  public final OntoRelTableMappingController ontoRelTableMappingController;
  public static final String injectionConfigurationFile = "defaultConfiguration.properties";

  public OntopTester(PostgresContainerWrapper postgresContainerWrapper, String ontoRelId,
      File ontologyFile, File mappingFile) {
    Properties dbProperties = postgresContainerWrapper.getPropertiesForOntop();
    Properties defaultConfigurationProperties = null;
    try {
      defaultConfigurationProperties = getInjectionConfigurationProperties();
    } catch (IOException e) {
      System.err.println(e.getMessage());
    }
    Properties properties = mergeProperties(dbProperties, defaultConfigurationProperties);
    mappingProperties = new MappingPropertiesBuilder()
        .withOntoRelId(ontoRelId)
        .withMappingSchema("MappingSchema")
        .build();
    FacadeProperties facadeProperties = new FacadePropertiesBuilder()
        .withFacadeType(FacadeType.VIEWS)
        .build();

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
    ontoRelCatRepository = configuration.getInjector().getInstance(OntoRelCatRepository.class);
    mappedOntoRelTableView = configuration.getInjector().getInstance(
        MappedOntoRelTableView.class);
    ontoRelTableMappingController = configuration.getInjector().getInstance(
        OntoRelTableMappingController.class);
  }

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

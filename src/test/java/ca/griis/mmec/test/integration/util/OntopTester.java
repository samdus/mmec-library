package ca.griis.mmec.test.integration.util;

import it.unibz.inf.ontop.answering.reformulation.generation.NativeQueryGenerator;
import it.unibz.inf.ontop.answering.reformulation.rewriting.QueryRewriter;
import it.unibz.inf.ontop.injection.*;
import it.unibz.inf.ontop.iq.optimizer.GeneralStructuralAndSemanticIQOptimizer;
import it.unibz.inf.ontop.iq.planner.QueryPlanner;
import it.unibz.inf.ontop.iq.type.NotYetTypedBinaryMathOperationTransformer;
import it.unibz.inf.ontop.iq.type.NotYetTypedEqualityTransformer;
import it.unibz.inf.ontop.model.atom.AtomFactory;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.spec.mapping.impl.SQLMappingExtractor;
import it.unibz.inf.ontop.spec.sqlparser.SQLQueryParser;
import it.unibz.inf.ontop.substitution.SubstitutionFactory;
import it.unibz.inf.ontop.utils.LocalJDBCConnectionUtils;
import ca.griis.mmec.test.integration.util.dbtype.Db;
import it.unibz.inf.ontop.spec.mapping.parser.impl.R2RMLMMeclMappingParserImpl;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
    protected final NotYetTypedBinaryMathOperationTransformer notYetTypedBinaryMathOperationTransformer;
    protected final SQLQueryParser sqlQueryParser;
    protected final R2RMLMMeclMappingParserImpl r2RMLMMeclMappingParserImpl;
    protected final SQLMappingExtractor mappingExtractor;
    protected final String ontologyFile = "src/test/resources/ontology_normalized.ttl";
    protected final String mappingFile = "src/test/resources/mapping.ttl";
    protected final String injectionConfigurationFile = "injection-configuration.properties";

    abstract public void runTest() throws Exception;

    public OntopTester(Db db) throws ClassNotFoundException, IOException, OWLOntologyCreationException {
        Properties dbProperties = db.getProperties();
        Properties injectionConfigurationProperties = getInjectionConfigurationProperties();
        Properties properties = mergeProperties(dbProperties, injectionConfigurationProperties);

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
        notYetTypedEqualityTransformer = configuration.getInjector().getInstance(NotYetTypedEqualityTransformer.class);
        notYetTypedBinaryMathOperationTransformer = configuration.getInjector().getInstance(NotYetTypedBinaryMathOperationTransformer.class);
        generalOptimizer = configuration.getInjector().getInstance(GeneralStructuralAndSemanticIQOptimizer.class);
        r2RMLMMeclMappingParserImpl = configuration.getInjector().getInstance(R2RMLMMeclMappingParserImpl.class);
        queryPlanner = configuration.getInjector().getInstance(QueryPlanner.class);
        mappingExtractor = configuration.getInjector().getInstance(SQLMappingExtractor.class);
        nativeQueryGenerator = translationFactory.create(db.getDBParameters(coreSingletons));
        sqlQueryParser = new SQLQueryParser(coreSingletons);
    }

    public void initDB() throws SQLException {
        try (Connection connection = LocalJDBCConnectionUtils.createConnection((OntopSQLCredentialSettings) configuration.getSettings())) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("DROP TABLE IF EXISTS \"TABLE1\" CASCADE");
                statement.executeUpdate("DROP TABLE IF EXISTS \"TABLE2\" CASCADE");
                statement.executeUpdate("DROP TABLE IF EXISTS \"TABLE3\" CASCADE");

                statement.executeUpdate("CREATE TABLE \"TABLE1\" (\"m\" INT PRIMARY KEY, \"n\" int, \"o\" int)");
                statement.executeUpdate("CREATE TABLE \"TABLE2\" (\"m\" INT PRIMARY KEY, \"n\" int, \"o\" int)");
                statement.executeUpdate("CREATE TABLE \"TABLE3\" (\"m\" INT PRIMARY KEY)");

                statement.executeUpdate("INSERT INTO \"TABLE1\" VALUES (1, 2, 3)");
                statement.executeUpdate("INSERT INTO \"TABLE1\" VALUES (2, 5, 6)");
                statement.executeUpdate("INSERT INTO \"TABLE1\" VALUES (3, 8, 9)");
                statement.executeUpdate("INSERT INTO \"TABLE1\" VALUES (4, 11, 12)");
                statement.executeUpdate("INSERT INTO \"TABLE1\" VALUES (5, 14, 15)");

                statement.executeUpdate("INSERT INTO \"TABLE2\" VALUES (1, 2, 3)");
                statement.executeUpdate("INSERT INTO \"TABLE2\" VALUES (2, 5, 6)");
                statement.executeUpdate("INSERT INTO \"TABLE2\" VALUES (3, 8, 9)");

                statement.executeUpdate("INSERT INTO \"TABLE3\" VALUES (1)");
                statement.executeUpdate("INSERT INTO \"TABLE3\" VALUES (2)");
                statement.executeUpdate("INSERT INTO \"TABLE3\" VALUES (3)");
                statement.executeUpdate("INSERT INTO \"TABLE3\" VALUES (4)");
            }
        }
    }

    private Properties getInjectionConfigurationProperties() throws IOException {
        Properties prop = new Properties();

        try(InputStream propStream = this.getClass().getClassLoader().getResourceAsStream(injectionConfigurationFile)) {
            if(propStream == null) {
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

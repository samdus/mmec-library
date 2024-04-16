package ca.griis.mmec.test.integration.util;

import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.dbschema.DBMetadataProvider;
import it.unibz.inf.ontop.dbschema.QuotedID;
import it.unibz.inf.ontop.dbschema.impl.CachingMetadataLookup;
import it.unibz.inf.ontop.dbschema.impl.JDBCMetadataProviderFactory;
import it.unibz.inf.ontop.exception.MinorOntopInternalBugException;
import it.unibz.inf.ontop.exception.OntopInternalBugException;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.exception.EmptyQueryException;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.node.NativeNode;
import it.unibz.inf.ontop.model.atom.AtomPredicate;
import it.unibz.inf.ontop.model.atom.DistinctVariableOnlyDataAtom;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.spec.sqlparser.RAExpression;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import it.unibz.inf.ontop.utils.LocalJDBCConnectionUtils;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptimizeTester extends OntopTester {
  final Logger logger = LoggerFactory.getLogger(OptimizeTester.class);

  private final List<String> queries = new ArrayList<>() {
    {
      // TODO: Ajouter des requêtes en prenant exemple sur it.unibz.inf.ontop.iq.executor
      add("select \"m\",\"t1\".\"n\",\"t1\".\"o\" from \"TABLE1\" AS \"t1\" join \"TABLE1\" using(\"m\")");
      add("select \"m\",\"n\",\"o\" from \"TABLE1\" where \"m\" is null");
      add("select \"t1\".\"m\",\"t1\".\"n\",\"t1\".\"o\" from \"TABLE1\" AS \"t1\" left join \"TABLE2\" on \"t1\".\"m\" = \"TABLE2\".\"m\" where \"TABLE2\".\"m\" is null");
      add("SELECT CHILD.\"m\" AS \"CHILD_m\", PARENT.\"m\" AS \"PARENT_m\" FROM (SELECT * FROM \"TABLE2\") CHILD, (SELECT \"m\", \"n\", \"o\" FROM \"TABLE2\") PARENT WHERE CHILD.m = PARENT.m");
    }
  };

  public OptimizeTester(PostgresContainerWrapper postgresContainerWrapper, File ontologyFile,
      File mappingFile) throws ClassNotFoundException, IOException, OWLOntologyCreationException {
    super(postgresContainerWrapper, ontologyFile, mappingFile);
  }

  public void runTest() throws Exception {
    try (Connection connection = LocalJDBCConnectionUtils.createConnection(
        configuration.getSettings())) {
      JDBCMetadataProviderFactory metadataProviderFactory =
          configuration.getInjector().getInstance(JDBCMetadataProviderFactory.class);

      for (String sourceQuery : queries) {
        DBMetadataProvider metadataProvider =
            metadataProviderFactory.getMetadataProvider(connection);
        CachingMetadataLookup metadataLookup = new CachingMetadataLookup(metadataProvider);

        // TODO: Modifier les requêtes à parser pour qu'elles soient incluables comme sous-requête
        // et qu'elle puisse être analysée correctement
        // Ex: Retirer les points virgules à la fin.
        RAExpression re = sqlQueryParser.getRAExpression(sourceQuery, metadataLookup);
        IQTree tree = sqlQueryParser.convert(re);

        metadataLookup.extractImmutableMetadata();

        logger.info("========================================");
        logger.info("========================================");
        logger.info("Initial query:\n{}", sourceQuery);

        logger.debug("Tree before transformer:\n{}", tree);

        // TODO: Vérifier dans
        // it.unibz.inf.ontop.spec.mapping.impl.SQLMappingExtractor.SQLMappingExtractor
        // Quels autres tranformers sont requis ici (ex: ImplicitDBConstraintsProviderFactory)
        tree = notYetTypedEqualityTransformer.transform(tree);
        tree = notYetTypedBinaryMathOperationTransformer.transform(tree);
        logger.debug("Tree after transformers:\n{}", tree);

        tree.validate();

        ImmutableList<Variable> variablesProjection = re.getUnqualifiedAttributes()
            .keySet()
            .stream()
            .map(QuotedID::toString)
            .map(var -> var.replace("\"", ""))
            .map(termFactory::getVariable)
            .collect(ImmutableCollectors.toList());
        ImmutableList<Variable> variablesConstruction = re.getUnqualifiedAttributes()
            .values()
            .stream()
            .map(ImmutableTerm::toString)
            .map(var -> var.replace("\"", ""))
            .map(termFactory::getVariable)
            .collect(ImmutableCollectors.toList());

        AtomPredicate rdfAnswerPredicate =
            atomFactory.getRDFAnswerPredicate(variablesProjection.size());

        DistinctVariableOnlyDataAtom projectionAtom =
            atomFactory.getDistinctVariableOnlyDataAtom(rdfAnswerPredicate,
                variablesProjection.toArray(new Variable[0]));
        ConstructionNode constructionNode =
            iqFactory.createConstructionNode(projectionAtom.getVariables(),
                substitutionFactory.getSubstitution(variablesProjection, variablesConstruction));

        IQ iq =
            iqFactory.createIQ(projectionAtom, iqFactory.createUnaryIQTree(constructionNode, tree));

        logger.info("IQ before optimization:\n{}", iq);

        logger.debug("Start the rewriting process...");

        IQ rewrittenIQ = queryRewriter.rewrite(iq);
        logger.debug("Rewritten IQ:\n{}\n", rewrittenIQ);

        IQ unfoldedIQ = rewrittenIQ;
        // Le Unfolder sert à unfold le mapping, il faudra simplement créer notre propre unfolder
        // (qui ressemblera beaucoup au LensUnfolder)
        //
        // logger.debug("Start the unfolding...");
        // IQ unfoldedIQ = queryUnfolder.optimize(rewrittenIQ);
        // if (unfoldedIQ.getTree().isDeclaredAsEmpty()) {
        // return unfoldedIQ;
        // }
        logger.debug("Unfolded query:\n{}\n", unfoldedIQ);

        IQ optimizedQuery = generalOptimizer.optimize(unfoldedIQ);
        logger.debug("Optimized query:\n{}\n", optimizedQuery);

        IQ plannedQuery = queryPlanner.optimize(optimizedQuery);
        logger.info("Planned query:\n{}\n", plannedQuery);

        IQ reformulatedIQ = nativeQueryGenerator.generateSourceQuery(plannedQuery);

        logger.debug("IQ after reformulation:\n{}", reformulatedIQ);

        try {
          String sqlQuery = extractSQLQuery(reformulatedIQ);
          logger.info("Final query:\n{}", sqlQuery);
          executeQuery(sqlQuery, connection);
        } catch (EmptyQueryException e) {
          // TODO: Plutôt qu'un message, il faudrait créer une nouvelle projection qui respecte les
          // bons types
          // et qui retourne l'ensemble vide, mais avec la bonne entête.
          logger.info("Final query is empty");
        }
      }
    }
  }

  // Copie de it.unibz.inf.ontop.answering.connection.impl.SQLQuestStatement.extractSQLQuery (membre
  // privé)
  private String extractSQLQuery(IQ executableQuery)
      throws EmptyQueryException, OntopInternalBugException {
    IQTree tree = executableQuery.getTree();
    if (tree.isDeclaredAsEmpty()) {
      throw new EmptyQueryException();
    }

    String queryString = Optional.of(tree)
        .filter(t -> t instanceof UnaryIQTree)
        .map(t -> ((UnaryIQTree) t).getChild().getRootNode())
        .filter(n -> n instanceof NativeNode)
        .map(n -> (NativeNode) n)
        .map(NativeNode::getNativeQueryString)
        .orElseThrow(() -> new MinorOntopInternalBugException(
            "The query does not have the expected structure " +
                "of an executable query\n" + executableQuery));

    if (queryString.isEmpty()) {
      throw new EmptyQueryException();
    }

    return queryString;
  }

  private void executeQuery(String sqlQuery, Connection connection) throws SQLException {
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(sqlQuery)) {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        int longerColumn = 0;
        StringBuilder sb = new StringBuilder("Query result:\n");
        for (int i = 1; i <= columnCount; i++) {
          sb.append(metaData.getColumnName(i)).append("\t");
          longerColumn = Math.max(longerColumn, metaData.getColumnName(i).length());
        }

        sb.append("\n");
        sb.append("-".repeat(Math.max(1, columnCount * longerColumn * 4)));
        sb.append("\n");

        while (resultSet.next()) {
          for (int i = 1; i <= columnCount; i++) {
            sb.append(resultSet.getString(i)).append("\t");
          }
          sb.append("\n");
        }

        logger.info(sb.toString());
      }
    }
  }
}

package ca.griis.mmec.test.unit.controller.ontop.answering.reformulation;

import ca.griis.mmec.controller.ontop.answering.reformulation.MMecToFullNativeQueryReformulator;
import it.unibz.inf.ontop.answering.logging.QueryLogger;
import it.unibz.inf.ontop.answering.reformulation.QueryCache;
import it.unibz.inf.ontop.answering.reformulation.generation.NativeQueryGenerator;
import it.unibz.inf.ontop.answering.reformulation.impl.QuestQueryProcessor;
import it.unibz.inf.ontop.answering.reformulation.rewriting.QueryRewriter;
import it.unibz.inf.ontop.dbschema.DBParameters;
import it.unibz.inf.ontop.exception.OntopInvalidKGQueryException;
import it.unibz.inf.ontop.exception.OntopReformulationException;
import it.unibz.inf.ontop.exception.OntopUnsupportedKGQueryException;
import it.unibz.inf.ontop.injection.TranslationFactory;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.UnaryIQTree;
import it.unibz.inf.ontop.iq.exception.EmptyQueryException;
import it.unibz.inf.ontop.iq.node.EmptyNode;
import it.unibz.inf.ontop.iq.node.IntensionalDataNode;
import it.unibz.inf.ontop.iq.node.NativeNode;
import it.unibz.inf.ontop.iq.optimizer.GeneralStructuralAndSemanticIQOptimizer;
import it.unibz.inf.ontop.iq.planner.QueryPlanner;
import it.unibz.inf.ontop.iq.type.impl.BasicSingleTermTypeExtractor;
import it.unibz.inf.ontop.query.KGQueryFactory;
import it.unibz.inf.ontop.query.RDF4JSelectQuery;
import it.unibz.inf.ontop.query.translation.KGQueryTranslator;
import it.unibz.inf.ontop.query.unfolding.QueryUnfolder;
import it.unibz.inf.ontop.spec.OBDASpecification;
import it.unibz.inf.ontop.spec.mapping.Mapping;
import it.unibz.inf.ontop.spec.ontology.ClassifiedTBox;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MMecToFullNativeQueryReformulatorTest {
  OBDASpecification obdaSpecification;
  QueryCache queryCache;
  QueryUnfolder.Factory queryUnfolderFactory;
  QueryUnfolder queryUnfolder;
  TranslationFactory translationFactory;
  QueryRewriter queryRewriter;
  KGQueryFactory kgQueryFactory;
  KGQueryTranslator inputQueryTranslator;
  GeneralStructuralAndSemanticIQOptimizer generalOptimizer;
  QueryPlanner queryPlanner;
  QueryLogger.Factory queryLoggerFactory;
  BasicSingleTermTypeExtractor typeExtractor;
  QueryLogger queryLogger;
  ClassifiedTBox tBox;
  Mapping saturatedMapping;
  DBParameters dbParameters;
  NativeQueryGenerator datasourceQueryGenerator;

  @BeforeEach
  void initialisation() {
    obdaSpecification = Mockito.mock(OBDASpecification.class);
    queryCache = Mockito.mock(QueryCache.class);
    queryUnfolderFactory = Mockito.mock(QueryUnfolder.Factory.class);
    queryUnfolder = Mockito.mock(QueryUnfolder.class);
    translationFactory = Mockito.mock(TranslationFactory.class);
    queryRewriter = Mockito.mock(QueryRewriter.class);
    kgQueryFactory = Mockito.mock(KGQueryFactory.class);
    inputQueryTranslator = Mockito.mock(KGQueryTranslator.class);
    generalOptimizer = Mockito.mock(GeneralStructuralAndSemanticIQOptimizer.class);
    queryPlanner = Mockito.mock(QueryPlanner.class);
    queryLoggerFactory = Mockito.mock(QueryLogger.Factory.class);
    typeExtractor = Mockito.mock(BasicSingleTermTypeExtractor.class);
    queryLogger = Mockito.mock(QueryLogger.class);
    tBox = Mockito.mock(ClassifiedTBox.class);
    saturatedMapping = Mockito.mock(Mapping.class);
    dbParameters = Mockito.mock(DBParameters.class);
    datasourceQueryGenerator = Mockito.mock(NativeQueryGenerator.class);

    Mockito.when(obdaSpecification.getSaturatedTBox()).thenReturn(tBox);
    Mockito.when(obdaSpecification.getSaturatedMapping()).thenReturn(saturatedMapping);
    Mockito.when(queryUnfolderFactory.create(saturatedMapping)).thenReturn(queryUnfolder);
    Mockito.when(obdaSpecification.getDBParameters()).thenReturn(dbParameters);
    Mockito.when(translationFactory.create(dbParameters)).thenReturn(datasourceQueryGenerator);
  }

  @Test
  void emptyQueryGeneratesEmptyQueryTest()
      throws OntopReformulationException, OntopUnsupportedKGQueryException,
      OntopInvalidKGQueryException, EmptyQueryException {
    QuestQueryProcessor mMecQueryProcessor = new MMecToFullNativeQueryReformulator(
        obdaSpecification, queryCache, queryUnfolderFactory,
        translationFactory, queryRewriter, kgQueryFactory, inputQueryTranslator, generalOptimizer,
        queryPlanner, queryLoggerFactory, typeExtractor);
    RDF4JSelectQuery inputQuery = Mockito.mock(RDF4JSelectQuery.class);
    IQ expected = Mockito.mock(IQ.class);

    IQ intermediaryIQ = Mockito.mock(IQ.class);
    IQTree intermediaryTree = Mockito.mock(IQTree.class);
    IQTree emptyTree = Mockito.mock(EmptyNode.class);

    Mockito.when(queryCache.get(inputQuery)).thenReturn(null);
    Mockito.when(inputQuery.getOriginalString()).thenReturn(
        "emptyQueryGeneratesEmptyQueryTest");
    Mockito.when(inputQuery.translate(inputQueryTranslator)).thenReturn(intermediaryIQ);
    Mockito.when(queryRewriter.rewrite(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(queryUnfolder.optimize(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(intermediaryIQ.getTree()).thenReturn(intermediaryTree);
    Mockito.when(intermediaryTree.isDeclaredAsEmpty()).thenReturn(false);
    Mockito.when(generalOptimizer.optimize(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(queryPlanner.optimize(intermediaryIQ)).thenReturn(expected);
    Mockito.when(expected.getTree()).thenReturn(emptyTree);

    IQ actual = mMecQueryProcessor.reformulateIntoNativeQuery(inputQuery, queryLogger);

    Assertions.assertEquals(actual, expected);
  }

  @Test
  void nonEmptyQueryGeneratesNonEmptyQueryTest()
      throws OntopReformulationException, OntopUnsupportedKGQueryException,
      OntopInvalidKGQueryException, EmptyQueryException {
    QuestQueryProcessor mMecQueryProcessor = new MMecToFullNativeQueryReformulator(
        obdaSpecification, queryCache, queryUnfolderFactory,
        translationFactory, queryRewriter, kgQueryFactory, inputQueryTranslator, generalOptimizer,
        queryPlanner, queryLoggerFactory, typeExtractor);
    RDF4JSelectQuery inputQuery = Mockito.mock(RDF4JSelectQuery.class);
    IQ expected = Mockito.mock(IQ.class);

    IQ intermediaryIQ = Mockito.mock(IQ.class);
    IQTree intermediaryTree = Mockito.mock(IQTree.class);
    IQTree nonEmptyTree = Mockito.mock(UnaryIQTree.class);
    IQTree nativeNode = Mockito.mock(NativeNode.class);

    Mockito.when(queryCache.get(inputQuery)).thenReturn(null);
    Mockito.when(inputQuery.getOriginalString()).thenReturn(
        "nonEmptyQueryGeneratesNonEmptyQueryTest");
    Mockito.when(inputQuery.translate(inputQueryTranslator)).thenReturn(intermediaryIQ);
    Mockito.when(queryRewriter.rewrite(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(queryUnfolder.optimize(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(intermediaryIQ.getTree()).thenReturn(intermediaryTree);
    Mockito.when(intermediaryTree.isDeclaredAsEmpty()).thenReturn(false);
    Mockito.when(generalOptimizer.optimize(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(queryPlanner.optimize(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(intermediaryIQ.getTree()).thenReturn(nonEmptyTree);
    Mockito.when(datasourceQueryGenerator.generateSourceQuery(intermediaryIQ, true)).thenReturn(
        intermediaryIQ);
    Mockito.when(intermediaryIQ.normalizeForOptimization()).thenReturn(expected);
    Mockito.when(expected.getTree()).thenReturn(nativeNode);

    IQ actual = mMecQueryProcessor.reformulateIntoNativeQuery(inputQuery, queryLogger);

    Assertions.assertEquals(actual, expected);
  }

  @Test
  public void nonEmptyQueryResultingInNotNativeNodeShouldThrow()
      throws OntopReformulationException, OntopUnsupportedKGQueryException,
      OntopInvalidKGQueryException, EmptyQueryException {
    QuestQueryProcessor mMecQueryProcessor = new MMecToFullNativeQueryReformulator(
        obdaSpecification, queryCache, queryUnfolderFactory,
        translationFactory, queryRewriter, kgQueryFactory, inputQueryTranslator, generalOptimizer,
        queryPlanner, queryLoggerFactory, typeExtractor);
    RDF4JSelectQuery inputQuery = Mockito.mock(RDF4JSelectQuery.class);
    IQ expected = Mockito.mock(IQ.class);

    IQ intermediaryIQ = Mockito.mock(IQ.class);
    IQTree intermediaryTree = Mockito.mock(IQTree.class);
    IQTree nonEmptyTree = Mockito.mock(UnaryIQTree.class);
    IQTree notNativeNode = Mockito.mock(IntensionalDataNode.class);

    Mockito.when(queryCache.get(inputQuery)).thenReturn(null);
    Mockito.when(inputQuery.getOriginalString()).thenReturn(
        "nonEmptyQueryResultingInNotNativeNodeShouldThrow");
    Mockito.when(inputQuery.translate(inputQueryTranslator)).thenReturn(intermediaryIQ);
    Mockito.when(queryRewriter.rewrite(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(queryUnfolder.optimize(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(intermediaryIQ.getTree()).thenReturn(intermediaryTree);
    Mockito.when(intermediaryTree.isDeclaredAsEmpty()).thenReturn(false);
    Mockito.when(generalOptimizer.optimize(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(queryPlanner.optimize(intermediaryIQ)).thenReturn(intermediaryIQ);
    Mockito.when(intermediaryIQ.getTree()).thenReturn(nonEmptyTree);
    Mockito.when(datasourceQueryGenerator.generateSourceQuery(intermediaryIQ, true)).thenReturn(
        intermediaryIQ);
    Mockito.when(intermediaryIQ.normalizeForOptimization()).thenReturn(expected);
    Mockito.when(expected.getTree()).thenReturn(notNativeNode);

    Assertions.assertThrows(OntopReformulationException.class,
        () -> mMecQueryProcessor.reformulateIntoNativeQuery(inputQuery, queryLogger));
  }
}

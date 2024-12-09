package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.parser.extension;

import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.MappingExtendedParser;
import ca.griis.mmec.model.MMecVocabulary;
import java.util.List;
import java.util.Optional;
import org.apache.commons.rdf.api.*;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MappingExtendedParserTest {

  @Test
  public void testGetObjectsQualifiedIdentifierOkTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    Optional<String> expected = Optional.of("expected");
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");
    IRI object = rdf.createIRI("http://example.org/object");
    IRI pSqlQualifiedIdentifier = rdf.createIRI(MMecVocabulary.P_SQL_QUALIFIED_IDENTIFIER);

    Mockito.doReturn(Optional.of(object)).when(mappingExtendedParserTester)
        .getObject_p(mappingGraph, subject, predicate);
    Mockito.doReturn(expected).when(mappingExtendedParserTester)
        .getLiteral_p(mappingGraph, object, pSqlQualifiedIdentifier);

    Optional<String> actual =
        mappingExtendedParserTester.getObjectsQualifiedIdentifier_p(mappingGraph, subject,
            predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void testGetObjectsQualifiedIdentifierNotFoundTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    Optional<String> expected = Optional.empty();
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");

    Mockito.doReturn(Optional.empty()).when(mappingExtendedParserTester)
        .getObject_p(mappingGraph, subject, predicate);

    Optional<String> actual =
        mappingExtendedParserTester.getObjectsQualifiedIdentifier_p(mappingGraph, subject,
            predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getObjectOkTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    Optional<BlankNodeOrIRI> expected = Optional.of(rdf.createIRI("http://example.org/object"));
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");
    IRI object = rdf.createIRI("http://example.org/object");

    mappingGraph.add(subject, predicate, object);
    Optional<BlankNodeOrIRI> actual =
        mappingExtendedParserTester.getObject_p(mappingGraph, subject, predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getObjectNotFoundTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    Optional<BlankNodeOrIRI> expected = Optional.empty();
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");

    Optional<BlankNodeOrIRI> actual =
        mappingExtendedParserTester.getObject_p(mappingGraph, subject, predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getObjectNotBlankNodeOrIRITest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    Optional<BlankNodeOrIRI> expected = Optional.empty();
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");
    Literal object = rdf.createLiteral("LiteralObject");

    mappingGraph.add(subject, predicate, object);
    Optional<BlankNodeOrIRI> actual =
        mappingExtendedParserTester.getObject_p(mappingGraph, subject, predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getLiteralOkTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    Optional<String> expected = Optional.of("expected");
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");
    Literal object = rdf.createLiteral("expected");

    mappingGraph.add(subject, predicate, object);
    Optional<String> actual =
        mappingExtendedParserTester.getLiteral_p(mappingGraph, subject, predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getLiteralNotFoundTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    Optional<String> expected = Optional.empty();
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");

    Optional<String> actual =
        mappingExtendedParserTester.getLiteral_p(mappingGraph, subject, predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getLiteralNotLiteralTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    Optional<String> expected = Optional.empty();
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");
    IRI object = rdf.createIRI("http://example.org/shouldHaveBeenLiteral");

    mappingGraph.add(subject, predicate, object);
    Optional<String> actual =
        mappingExtendedParserTester.getLiteral_p(mappingGraph, subject, predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getAllLiteralsOkTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    List<String> expected = List.of("expected1", "expected2");
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");
    Literal object1 = rdf.createLiteral("expected1");
    Literal object2 = rdf.createLiteral("expected2");
    IRI unexpectedObject = rdf.createIRI("http://example.org/unexpectedObject");

    mappingGraph.add(subject, predicate, object1);
    mappingGraph.add(subject, predicate, object2);
    mappingGraph.add(subject, predicate, unexpectedObject);

    List<String> actual =
        mappingExtendedParserTester.getAllLiterals_p(mappingGraph, subject, predicate);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getAllLiteralsNotFoundTest() {
    RDF4J rdf = new RDF4J();
    Graph mappingGraph = rdf.createGraph();

    MappingExtendedParserTester innerMappingExtendedParserTester =
        new MappingExtendedParserTester(rdf);
    MappingExtendedParserTester mappingExtendedParserTester =
        Mockito.spy(innerMappingExtendedParserTester);

    List<String> expected = List.of();
    BlankNodeOrIRI subject = rdf.createIRI("http://example.org/subject");
    IRI predicate = rdf.createIRI("http://example.org/predicate");

    List<String> actual =
        mappingExtendedParserTester.getAllLiterals_p(mappingGraph, subject, predicate);

    Assertions.assertEquals(expected, actual);
  }

  private static class MappingExtendedParserTester extends MappingExtendedParser {
    public MappingExtendedParserTester(RDF4J rdf) {
      super(rdf);
    }

    @Override
    protected Optional<String> getObjectsQualifiedIdentifier(Graph mappingGraph,
        BlankNodeOrIRI subject,
        IRI predicate) {
      return getObjectsQualifiedIdentifier_p(mappingGraph, subject, predicate);
    }

    @Override
    protected Optional<BlankNodeOrIRI> getObject(Graph mappingGraph, BlankNodeOrIRI subject,
        IRI predicate) {
      return getObject_p(mappingGraph, subject, predicate);
    }

    @Override
    protected Optional<String> getLiteral(Graph mappingGraph, BlankNodeOrIRI subject,
        IRI predicate) {
      return getLiteral_p(mappingGraph, subject, predicate);
    }

    @Override
    protected List<String> getAllLiterals(Graph mappingGraph, BlankNodeOrIRI subject,
        IRI predicate) {
      return getAllLiterals_p(mappingGraph, subject, predicate);
    }

    public Optional<String> getObjectsQualifiedIdentifier_p(Graph mappingGraph,
        BlankNodeOrIRI subject,
        IRI predicate) {
      return super.getObjectsQualifiedIdentifier(mappingGraph, subject, predicate);
    }

    public Optional<BlankNodeOrIRI> getObject_p(Graph mappingGraph, BlankNodeOrIRI subject,
        IRI predicate) {
      return super.getObject(mappingGraph, subject, predicate);
    }

    public Optional<String> getLiteral_p(Graph mappingGraph, BlankNodeOrIRI subject,
        IRI predicate) {
      return super.getLiteral(mappingGraph, subject, predicate);
    }

    public List<String> getAllLiterals_p(Graph mappingGraph, BlankNodeOrIRI subject,
        IRI predicate) {
      return super.getAllLiterals(mappingGraph, subject, predicate);
    }
  }
}

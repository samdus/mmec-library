package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.parser.extension.after;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecPostgreSqlDbFunctionSymbolFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingConversion;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.after.MMecParserConversionExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.ConversionWithoutInputTypeException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.ConversionWithoutOutputTypeException;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableList;
import eu.optique.r2rml.api.model.TriplesMap;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBBooleanFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.DBTypeFactory;
import it.unibz.inf.ontop.model.type.TypeFactory;
import org.apache.commons.rdf.api.BlankNode;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.api.Literal;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("unchecked")
public class MMecParserConversionExtensionTest {
  private static final String nsTypeIriString = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";

  private RDF4J rdf;
  private IRI nsTypeIri;
  private IRI cConversionIri;
  private IRI conversionInputType;
  private IRI conversionOutputType;
  private IRI conversionFunction;
  private IRI conversionVerificationFunction;
  private IRI sqlQualifiedIdentifier;

  @BeforeEach
  public void beforeEach() {
    rdf = new RDF4J();
    nsTypeIri = rdf.createIRI(nsTypeIriString);
    cConversionIri = rdf.createIRI(MMecVocabulary.C_CONVERSION);

    conversionInputType = rdf.createIRI(MMecVocabulary.P_CONVERSION_INPUT_TYPE);
    conversionOutputType = rdf.createIRI(MMecVocabulary.P_CONVERSION_OUTPUT_TYPE);
    conversionFunction = rdf.createIRI(MMecVocabulary.P_CONVERSION_FUNCTION);
    conversionVerificationFunction =
        rdf.createIRI(MMecVocabulary.P_CONVERSION_VERIFICATION_FUNCTION);
    sqlQualifiedIdentifier = rdf.createIRI(MMecVocabulary.P_SQL_QUALIFIED_IDENTIFIER);
  }

  @Test
  public void parseWithoutAnyConversionTriplesTest() {
    TypeFactory typeFactory = Mockito.mock(TypeFactory.class);
    MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory =
        Mockito.mock(MMecPostgreSqlDbFunctionSymbolFactory.class);
    MMecMappingExtension mappingExtension = Mockito.mock(MMecMappingExtension.class);
    Graph mappingGraph = Mockito.mock(Graph.class);
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<MMecTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);

    MMecParserConversionExtension conversionExtension =
        new MMecParserConversionExtension(rdf, typeFactory, sqlDbFunctionSymbolFactory,
            mappingExtension);

    conversionExtension.parse(mappingGraph, tripleMaps, sourceMappings);

    Mockito.verify(mappingExtension, Mockito.never()).addMappingConversion(Mockito.any());
  }

  @Test
  public void parseMissingInputTypeShouldThrowTest() {
    Graph mappingGraph = rdf.createGraph();
    TypeFactory typeFactory = Mockito.mock(TypeFactory.class);
    DBTypeFactory dbTypeFactory = Mockito.mock(DBTypeFactory.class);
    MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory =
        Mockito.mock(MMecPostgreSqlDbFunctionSymbolFactory.class);
    MMecMappingExtension mappingExtension = Mockito.mock(MMecMappingExtension.class);
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<MMecTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);

    MMecParserConversionExtension conversionExtension =
        new MMecParserConversionExtension(rdf, typeFactory, sqlDbFunctionSymbolFactory,
            mappingExtension);

    IRI subject = rdf.createIRI("http://example.com/subject");
    mappingGraph.add(subject, nsTypeIri, cConversionIri);

    Mockito.when(typeFactory.getDBTypeFactory()).thenReturn(dbTypeFactory);

    Assertions.assertThrows(ConversionWithoutInputTypeException.class,
        () -> conversionExtension.parse(mappingGraph, tripleMaps, sourceMappings));
  }

  @Test
  public void parseMissingOutputTypeShouldThrowTest() {
    Graph mappingGraph = rdf.createGraph();
    TypeFactory typeFactory = Mockito.mock(TypeFactory.class);
    DBTypeFactory dbTypeFactory = Mockito.mock(DBTypeFactory.class);
    MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory =
        Mockito.mock(MMecPostgreSqlDbFunctionSymbolFactory.class);
    MMecMappingExtension mappingExtension = Mockito.mock(MMecMappingExtension.class);
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<MMecTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);

    MMecParserConversionExtension conversionExtension =
        new MMecParserConversionExtension(rdf, typeFactory, sqlDbFunctionSymbolFactory,
            mappingExtension);

    IRI subject = rdf.createIRI("http://example.com/subject");

    String inputTypeId = "inputType";
    BlankNode inputTypeNode = rdf.createBlankNode();
    Literal inputTypeLiteral = rdf.createLiteral(inputTypeId);
    DBTermType declaredInputType = Mockito.mock(DBTermType.class);

    mappingGraph.add(subject, nsTypeIri, cConversionIri);
    mappingGraph.add(subject, conversionInputType, inputTypeNode);
    mappingGraph.add(inputTypeNode, sqlQualifiedIdentifier, inputTypeLiteral);

    Mockito.when(typeFactory.getDBTypeFactory()).thenReturn(dbTypeFactory);
    Mockito.when(dbTypeFactory.getDBTermType(inputTypeId))
        .thenReturn(declaredInputType);

    Assertions.assertThrows(ConversionWithoutOutputTypeException.class,
        () -> conversionExtension.parse(mappingGraph, tripleMaps, sourceMappings));
  }

  @Test
  public void parseWithConversionFunctionWithoutValidationFunctionTest() {
    Graph mappingGraph = rdf.createGraph();
    TypeFactory typeFactory = Mockito.mock(TypeFactory.class);
    DBTypeFactory dbTypeFactory = Mockito.mock(DBTypeFactory.class);
    MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory =
        Mockito.mock(MMecPostgreSqlDbFunctionSymbolFactory.class);
    MMecMappingExtension mappingExtension = Mockito.mock(MMecMappingExtension.class);
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<MMecTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);

    ArgumentCaptor<MMecMappingConversion> mappingConversionCaptor =
        ArgumentCaptor.forClass(MMecMappingConversion.class);

    MMecParserConversionExtension conversionExtension =
        new MMecParserConversionExtension(rdf, typeFactory, sqlDbFunctionSymbolFactory,
            mappingExtension);

    IRI subject = rdf.createIRI("http://example.com/subject");

    String inputTypeId = "inputType";
    BlankNode inputTypeNode = rdf.createBlankNode();
    Literal inputTypeLiteral = rdf.createLiteral(inputTypeId);
    DBTermType declaredInputType = Mockito.mock(DBTermType.class);

    String outputTypeId = "outputType";
    BlankNode outputTypeNode = rdf.createBlankNode();
    Literal outputTypeLiteral = rdf.createLiteral(outputTypeId);
    DBTermType declaredOutputType = Mockito.mock(DBTermType.class);

    String functionName = "functionName";
    BlankNode functionNode = rdf.createBlankNode();
    Literal functionLiteral = rdf.createLiteral(functionName);
    DBTypeConversionFunctionSymbol declaredConversionFunction =
        Mockito.mock(DBTypeConversionFunctionSymbol.class);

    mappingGraph.add(subject, nsTypeIri, cConversionIri);
    mappingGraph.add(subject, conversionInputType, inputTypeNode);
    mappingGraph.add(inputTypeNode, sqlQualifiedIdentifier, inputTypeLiteral);
    mappingGraph.add(subject, conversionOutputType, outputTypeNode);
    mappingGraph.add(outputTypeNode, sqlQualifiedIdentifier, outputTypeLiteral);
    mappingGraph.add(subject, conversionFunction, functionNode);
    mappingGraph.add(functionNode, sqlQualifiedIdentifier, functionLiteral);

    Mockito.when(typeFactory.getDBTypeFactory()).thenReturn(dbTypeFactory);
    Mockito.when(dbTypeFactory.getDBTermType(inputTypeId))
        .thenReturn(declaredInputType);
    Mockito.when(dbTypeFactory.getDBTermType(outputTypeId))
        .thenReturn(declaredOutputType);
    Mockito.when(sqlDbFunctionSymbolFactory.createMMecConversionFunctionSymbol(functionName,
        declaredInputType, declaredOutputType)).thenReturn(declaredConversionFunction);

    conversionExtension.parse(mappingGraph, tripleMaps, sourceMappings);

    Mockito.verify(mappingExtension).addMappingConversion(mappingConversionCaptor.capture());
    Assertions.assertEquals(declaredInputType, mappingConversionCaptor.getValue().getInputType());
    Assertions.assertEquals(declaredOutputType, mappingConversionCaptor.getValue().getOutputType());
    Assertions.assertEquals(Optional.of(declaredConversionFunction),
        mappingConversionCaptor.getValue().getConversionFunction());
    Assertions.assertEquals(Optional.empty(),
        mappingConversionCaptor.getValue().getValidationFunction());
  }

  @Test
  public void parseWithoutConversionFunctionWithValidationFunctionTest() {
    Graph mappingGraph = rdf.createGraph();
    TypeFactory typeFactory = Mockito.mock(TypeFactory.class);
    DBTypeFactory dbTypeFactory = Mockito.mock(DBTypeFactory.class);
    MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory =
        Mockito.mock(MMecPostgreSqlDbFunctionSymbolFactory.class);
    MMecMappingExtension mappingExtension = Mockito.mock(MMecMappingExtension.class);
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<MMecTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);

    ArgumentCaptor<MMecMappingConversion> mappingConversionCaptor =
        ArgumentCaptor.forClass(MMecMappingConversion.class);

    MMecParserConversionExtension conversionExtension =
        new MMecParserConversionExtension(rdf, typeFactory, sqlDbFunctionSymbolFactory,
            mappingExtension);

    IRI subject = rdf.createIRI("http://example.com/subject");

    String inputTypeId = "inputType";
    BlankNode inputTypeNode = rdf.createBlankNode();
    Literal inputTypeLiteral = rdf.createLiteral(inputTypeId);
    DBTermType declaredInputType = Mockito.mock(DBTermType.class);

    String outputTypeId = "outputType";
    BlankNode outputTypeNode = rdf.createBlankNode();
    Literal outputTypeLiteral = rdf.createLiteral(outputTypeId);
    DBTermType declaredOutputType = Mockito.mock(DBTermType.class);

    String validationFunctionName = "validationFunctionName";
    BlankNode validationFunctionNode = rdf.createBlankNode();
    Literal validationFunctionLiteral = rdf.createLiteral(validationFunctionName);
    DBBooleanFunctionSymbol declaredValidationFunction =
        Mockito.mock(DBBooleanFunctionSymbol.class);

    mappingGraph.add(subject, nsTypeIri, cConversionIri);
    mappingGraph.add(subject, conversionInputType, inputTypeNode);
    mappingGraph.add(inputTypeNode, sqlQualifiedIdentifier, inputTypeLiteral);
    mappingGraph.add(subject, conversionOutputType, outputTypeNode);
    mappingGraph.add(outputTypeNode, sqlQualifiedIdentifier, outputTypeLiteral);
    mappingGraph.add(subject, conversionVerificationFunction, validationFunctionNode);
    mappingGraph.add(validationFunctionNode, sqlQualifiedIdentifier, validationFunctionLiteral);

    Mockito.when(typeFactory.getDBTypeFactory()).thenReturn(dbTypeFactory);
    Mockito.when(dbTypeFactory.getDBTermType(inputTypeId))
        .thenReturn(declaredInputType);
    Mockito.when(dbTypeFactory.getDBTermType(outputTypeId))
        .thenReturn(declaredOutputType);
    Mockito.when(sqlDbFunctionSymbolFactory.createMMecConversionValidationFunctionSymbol(
            validationFunctionName, declaredInputType, declaredOutputType))
        .thenReturn(declaredValidationFunction);

    conversionExtension.parse(mappingGraph, tripleMaps, sourceMappings);

    Mockito.verify(mappingExtension).addMappingConversion(mappingConversionCaptor.capture());
    Assertions.assertEquals(declaredInputType, mappingConversionCaptor.getValue().getInputType());
    Assertions.assertEquals(declaredOutputType, mappingConversionCaptor.getValue().getOutputType());
    Assertions.assertEquals(Optional.empty(),
        mappingConversionCaptor.getValue().getConversionFunction());
    Assertions.assertEquals(Optional.of(declaredValidationFunction),
        mappingConversionCaptor.getValue().getValidationFunction());
  }

  @Test
  public void parseWithoutConversionFunctionWithoutValidationFunctionTest() {
    Graph mappingGraph = rdf.createGraph();
    TypeFactory typeFactory = Mockito.mock(TypeFactory.class);
    DBTypeFactory dbTypeFactory = Mockito.mock(DBTypeFactory.class);
    MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory =
        Mockito.mock(MMecPostgreSqlDbFunctionSymbolFactory.class);
    MMecMappingExtension mappingExtension = Mockito.mock(MMecMappingExtension.class);
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<MMecTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);

    ArgumentCaptor<MMecMappingConversion> mappingConversionCaptor =
        ArgumentCaptor.forClass(MMecMappingConversion.class);

    MMecParserConversionExtension conversionExtension =
        new MMecParserConversionExtension(rdf, typeFactory, sqlDbFunctionSymbolFactory,
            mappingExtension);

    IRI subject = rdf.createIRI("http://example.com/subject");

    String inputTypeId = "inputType";
    BlankNode inputTypeNode = rdf.createBlankNode();
    Literal inputTypeLiteral = rdf.createLiteral(inputTypeId);
    DBTermType declaredInputType = Mockito.mock(DBTermType.class);

    String outputTypeId = "outputType";
    BlankNode outputTypeNode = rdf.createBlankNode();
    Literal outputTypeLiteral = rdf.createLiteral(outputTypeId);
    DBTermType declaredOutputType = Mockito.mock(DBTermType.class);

    mappingGraph.add(subject, nsTypeIri, cConversionIri);
    mappingGraph.add(subject, conversionInputType, inputTypeNode);
    mappingGraph.add(inputTypeNode, sqlQualifiedIdentifier, inputTypeLiteral);
    mappingGraph.add(subject, conversionOutputType, outputTypeNode);
    mappingGraph.add(outputTypeNode, sqlQualifiedIdentifier, outputTypeLiteral);

    Mockito.when(typeFactory.getDBTypeFactory()).thenReturn(dbTypeFactory);
    Mockito.when(dbTypeFactory.getDBTermType(inputTypeId))
        .thenReturn(declaredInputType);
    Mockito.when(dbTypeFactory.getDBTermType(outputTypeId))
        .thenReturn(declaredOutputType);

    conversionExtension.parse(mappingGraph, tripleMaps, sourceMappings);

    Mockito.verify(mappingExtension).addMappingConversion(mappingConversionCaptor.capture());
    Assertions.assertEquals(declaredInputType, mappingConversionCaptor.getValue().getInputType());
    Assertions.assertEquals(declaredOutputType, mappingConversionCaptor.getValue().getOutputType());
    Assertions.assertEquals(Optional.empty(),
        mappingConversionCaptor.getValue().getConversionFunction());
    Assertions.assertEquals(Optional.empty(),
        mappingConversionCaptor.getValue().getValidationFunction());
  }

  @Test
  public void parseWithConversionFunctionWithValidationFunctionTest() {
    Graph mappingGraph = rdf.createGraph();
    TypeFactory typeFactory = Mockito.mock(TypeFactory.class);
    DBTypeFactory dbTypeFactory = Mockito.mock(DBTypeFactory.class);
    MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory =
        Mockito.mock(MMecPostgreSqlDbFunctionSymbolFactory.class);
    MMecMappingExtension mappingExtension = Mockito.mock(MMecMappingExtension.class);
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<MMecTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);

    ArgumentCaptor<MMecMappingConversion> mappingConversionCaptor =
        ArgumentCaptor.forClass(MMecMappingConversion.class);

    MMecParserConversionExtension conversionExtension =
        new MMecParserConversionExtension(rdf, typeFactory, sqlDbFunctionSymbolFactory,
            mappingExtension);

    IRI subject = rdf.createIRI("http://example.com/subject");

    String inputTypeId = "inputType";
    BlankNode inputTypeNode = rdf.createBlankNode();
    Literal inputTypeLiteral = rdf.createLiteral(inputTypeId);
    DBTermType declaredInputType = Mockito.mock(DBTermType.class);

    String outputTypeId = "outputType";
    BlankNode outputTypeNode = rdf.createBlankNode();
    Literal outputTypeLiteral = rdf.createLiteral(outputTypeId);
    DBTermType declaredOutputType = Mockito.mock(DBTermType.class);

    String functionName = "functionName";
    BlankNode functionNode = rdf.createBlankNode();
    Literal functionLiteral = rdf.createLiteral(functionName);
    DBTypeConversionFunctionSymbol declaredConversionFunction =
        Mockito.mock(DBTypeConversionFunctionSymbol.class);

    String validationFunctionName = "validationFunctionName";
    BlankNode validationFunctionNode = rdf.createBlankNode();
    Literal validationFunctionLiteral = rdf.createLiteral(validationFunctionName);
    DBBooleanFunctionSymbol declaredValidationFunction =
        Mockito.mock(DBBooleanFunctionSymbol.class);

    mappingGraph.add(subject, nsTypeIri, cConversionIri);
    mappingGraph.add(subject, conversionInputType, inputTypeNode);
    mappingGraph.add(inputTypeNode, sqlQualifiedIdentifier, inputTypeLiteral);
    mappingGraph.add(subject, conversionOutputType, outputTypeNode);
    mappingGraph.add(outputTypeNode, sqlQualifiedIdentifier, outputTypeLiteral);
    mappingGraph.add(subject, conversionFunction, functionNode);
    mappingGraph.add(functionNode, sqlQualifiedIdentifier, functionLiteral);
    mappingGraph.add(subject, conversionVerificationFunction, validationFunctionNode);
    mappingGraph.add(validationFunctionNode, sqlQualifiedIdentifier, validationFunctionLiteral);

    Mockito.when(typeFactory.getDBTypeFactory()).thenReturn(dbTypeFactory);
    Mockito.when(dbTypeFactory.getDBTermType(inputTypeId))
        .thenReturn(declaredInputType);
    Mockito.when(dbTypeFactory.getDBTermType(outputTypeId))
        .thenReturn(declaredOutputType);
    Mockito.when(sqlDbFunctionSymbolFactory.createMMecConversionFunctionSymbol(functionName,
        declaredInputType, declaredOutputType)).thenReturn(declaredConversionFunction);
    Mockito.when(sqlDbFunctionSymbolFactory.createMMecConversionValidationFunctionSymbol(
            validationFunctionName, declaredInputType, declaredOutputType))
        .thenReturn(declaredValidationFunction);

    conversionExtension.parse(mappingGraph, tripleMaps, sourceMappings);

    Mockito.verify(mappingExtension).addMappingConversion(mappingConversionCaptor.capture());
    Assertions.assertEquals(declaredInputType, mappingConversionCaptor.getValue().getInputType());
    Assertions.assertEquals(declaredOutputType, mappingConversionCaptor.getValue().getOutputType());
    Assertions.assertEquals(Optional.of(declaredConversionFunction),
        mappingConversionCaptor.getValue().getConversionFunction());
    Assertions.assertEquals(Optional.of(declaredValidationFunction),
        mappingConversionCaptor.getValue().getValidationFunction());
  }
}

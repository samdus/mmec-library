package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.parser.extension.after;

import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.after.MMecParserSubsetsExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableList;
import eu.optique.r2rml.api.model.TriplesMap;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.IRI;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("unchecked")
public class MMecParserSubsetsExtensionTest {

  private RDF4J rdf;
  private Graph mappingGraph;
  private MMecParserSubsetsExtension parserSubsetsExtension;

  protected static final String nsType = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";
  private IRI subsetsProperty;
  private IRI supersetType;
  private IRI nsTypeIri;

  @BeforeEach
  public void setup() {
    rdf = new RDF4J();
    mappingGraph = rdf.createGraph();
    parserSubsetsExtension = new MMecParserSubsetsExtension(rdf);

    subsetsProperty = rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS);
    supersetType = rdf.createIRI(MMecVocabulary.C_SIGNATURE_SUPERSET);
    nsTypeIri = rdf.createIRI(nsType);
  }

  @Test
  public void parseWithEmptyGraphDoesNotModifySourceMappingsTest() {
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<MMecTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);

    parserSubsetsExtension.parse(mappingGraph, tripleMaps, sourceMappings);
    Mockito.verifyNoInteractions(sourceMappings);
  }

  @Test
  public void parseWithSimpleSubsetsTest() {
    IRI parentIRI = rdf.createIRI("http://example.com/parent");
    IRI childIRI = rdf.createIRI("http://example.com/child");
    TriplesMap parentTMap = Mockito.mock(TriplesMap.class);
    TriplesMap childTMap = Mockito.mock(TriplesMap.class);
    MMecTriplesMap parentMMecTMap = Mockito.mock(MMecTriplesMap.class);
    MMecTriplesMap childMMecTMap = Mockito.mock(MMecTriplesMap.class);
    int parentHashCode = parentTMap.hashCode();
    int childHashCode = childTMap.hashCode();
    String parentIdString = String.format("mapping-%s", parentHashCode);
    String childIdString = String.format("mapping-%s", childHashCode);

    Collection<TriplesMap> tripleMaps = List.of(parentTMap, childTMap);
    ImmutableList<MMecTriplesMap> sourceMappings = ImmutableList.of(parentMMecTMap, childMMecTMap);

    mappingGraph.add(childIRI, subsetsProperty, parentIRI);

    Mockito.when(parentTMap.getNode()).thenReturn(parentIRI);
    Mockito.when(childTMap.getNode()).thenReturn(childIRI);
    Mockito.when(parentMMecTMap.getId()).thenReturn(parentIdString);
    Mockito.when(childMMecTMap.getId()).thenReturn(childIdString);

    parserSubsetsExtension.parse(mappingGraph, tripleMaps, sourceMappings);

    Mockito.verify(parentMMecTMap).addSubset(childMMecTMap);
  }

  @Test
  public void parseWithSignatureSuperSetMustNotBeAddedTest() {
    IRI parentIRI = rdf.createIRI("http://example.com/parent");
    IRI childIRI = rdf.createIRI("http://example.com/child");
    TriplesMap parentTMap = Mockito.mock(TriplesMap.class);
    TriplesMap childTMap = Mockito.mock(TriplesMap.class);
    MMecTriplesMap parentMMecTMap = Mockito.mock(MMecTriplesMap.class);
    MMecTriplesMap childMMecTMap = Mockito.mock(MMecTriplesMap.class);
    int parentHashCode = parentTMap.hashCode();
    int childHashCode = childTMap.hashCode();
    String parentIdString = String.format("mapping-%s", parentHashCode);
    String childIdString = String.format("mapping-%s", childHashCode);

    Collection<TriplesMap> tripleMaps = List.of(parentTMap, childTMap);
    ImmutableList<MMecTriplesMap> sourceMappings = ImmutableList.of(parentMMecTMap, childMMecTMap);

    mappingGraph.add(childIRI, subsetsProperty, parentIRI);
    mappingGraph.add(parentIRI, nsTypeIri, supersetType);

    Mockito.when(parentTMap.getNode()).thenReturn(parentIRI);
    Mockito.when(childTMap.getNode()).thenReturn(childIRI);
    Mockito.when(parentMMecTMap.getId()).thenReturn(parentIdString);
    Mockito.when(childMMecTMap.getId()).thenReturn(childIdString);

    parserSubsetsExtension.parse(mappingGraph, tripleMaps, sourceMappings);

    Mockito.verify(parentMMecTMap, Mockito.never()).addSubset(childMMecTMap);
  }

  @Test
  public void parseWithChildNotFoundInTripleMapsThrowsExceptionTest() {
    IRI parentIRI = rdf.createIRI("http://example.com/parent");
    IRI childIRI = rdf.createIRI("http://example.com/child");
    TriplesMap parentTMap = Mockito.mock(TriplesMap.class);
    TriplesMap childTMap = Mockito.mock(TriplesMap.class);
    MMecTriplesMap parentMMecTMap = Mockito.mock(MMecTriplesMap.class);
    MMecTriplesMap childMMecTMap = Mockito.mock(MMecTriplesMap.class);
    int parentHashCode = parentTMap.hashCode();
    int childHashCode = childTMap.hashCode();
    String parentIdString = String.format("mapping-%s", parentHashCode);
    String childIdString = String.format("mapping-%s", childHashCode);

    Collection<TriplesMap> tripleMaps = List.of(parentTMap);
    ImmutableList<MMecTriplesMap> sourceMappings = ImmutableList.of(parentMMecTMap, childMMecTMap);

    mappingGraph.add(childIRI, subsetsProperty, parentIRI);

    Mockito.when(parentTMap.getNode()).thenReturn(parentIRI);
    Mockito.when(childTMap.getNode()).thenReturn(childIRI);
    Mockito.when(parentMMecTMap.getId()).thenReturn(parentIdString);
    Mockito.when(childMMecTMap.getId()).thenReturn(childIdString);

    Assertions.assertThrows(Exception.class,
        () -> parserSubsetsExtension.parse(mappingGraph, tripleMaps, sourceMappings));

    Mockito.verify(parentMMecTMap, Mockito.never()).addSubset(Mockito.any());
  }

  @Test
  public void parseWithParentNotFoundInTripleMapsThrowsExceptionTest() {
    IRI parentIRI = rdf.createIRI("http://example.com/parent");
    IRI childIRI = rdf.createIRI("http://example.com/child");
    TriplesMap parentTMap = Mockito.mock(TriplesMap.class);
    TriplesMap childTMap = Mockito.mock(TriplesMap.class);
    MMecTriplesMap parentMMecTMap = Mockito.mock(MMecTriplesMap.class);
    MMecTriplesMap childMMecTMap = Mockito.mock(MMecTriplesMap.class);
    int parentHashCode = parentTMap.hashCode();
    int childHashCode = childTMap.hashCode();
    String parentIdString = String.format("mapping-%s", parentHashCode);
    String childIdString = String.format("mapping-%s", childHashCode);

    Collection<TriplesMap> tripleMaps = List.of(childTMap);
    ImmutableList<MMecTriplesMap> sourceMappings = ImmutableList.of(parentMMecTMap, childMMecTMap);

    mappingGraph.add(childIRI, subsetsProperty, parentIRI);

    Mockito.when(parentTMap.getNode()).thenReturn(parentIRI);
    Mockito.when(childTMap.getNode()).thenReturn(childIRI);
    Mockito.when(parentMMecTMap.getId()).thenReturn(parentIdString);
    Mockito.when(childMMecTMap.getId()).thenReturn(childIdString);

    Assertions.assertThrows(Exception.class,
        () -> parserSubsetsExtension.parse(mappingGraph, tripleMaps, sourceMappings));

    Mockito.verify(parentMMecTMap, Mockito.never()).addSubset(Mockito.any());
  }


  @Test
  public void parseWithChildNotFoundInSourceMappingThrowsExceptionTest() {
    IRI parentIRI = rdf.createIRI("http://example.com/parent");
    IRI childIRI = rdf.createIRI("http://example.com/child");
    TriplesMap parentTMap = Mockito.mock(TriplesMap.class);
    TriplesMap childTMap = Mockito.mock(TriplesMap.class);
    MMecTriplesMap parentMMecTMap = Mockito.mock(MMecTriplesMap.class);
    MMecTriplesMap childMMecTMap = Mockito.mock(MMecTriplesMap.class);
    int parentHashCode = parentTMap.hashCode();
    int childHashCode = childTMap.hashCode();
    String parentIdString = String.format("mapping-%s", parentHashCode);
    String childIdString = String.format("mapping-%s", childHashCode);

    Collection<TriplesMap> tripleMaps = List.of(parentTMap, childTMap);
    ImmutableList<MMecTriplesMap> sourceMappings = ImmutableList.of(parentMMecTMap);

    mappingGraph.add(childIRI, subsetsProperty, parentIRI);

    Mockito.when(parentTMap.getNode()).thenReturn(parentIRI);
    Mockito.when(childTMap.getNode()).thenReturn(childIRI);
    Mockito.when(parentMMecTMap.getId()).thenReturn(parentIdString);
    Mockito.when(childMMecTMap.getId()).thenReturn(childIdString);

    Assertions.assertThrows(Exception.class,
        () -> parserSubsetsExtension.parse(mappingGraph, tripleMaps, sourceMappings));

    Mockito.verify(parentMMecTMap, Mockito.never()).addSubset(Mockito.any());
  }
  @Test
  public void parseWithParentNotFoundInSourceMappingThrowsExceptionTest() {
    IRI parentIRI = rdf.createIRI("http://example.com/parent");
    IRI childIRI = rdf.createIRI("http://example.com/child");
    TriplesMap parentTMap = Mockito.mock(TriplesMap.class);
    TriplesMap childTMap = Mockito.mock(TriplesMap.class);
    MMecTriplesMap parentMMecTMap = Mockito.mock(MMecTriplesMap.class);
    MMecTriplesMap childMMecTMap = Mockito.mock(MMecTriplesMap.class);
    int parentHashCode = parentTMap.hashCode();
    int childHashCode = childTMap.hashCode();
    String parentIdString = String.format("mapping-%s", parentHashCode);
    String childIdString = String.format("mapping-%s", childHashCode);

    Collection<TriplesMap> tripleMaps = List.of(parentTMap, childTMap);
    ImmutableList<MMecTriplesMap> sourceMappings = ImmutableList.of(childMMecTMap);

    mappingGraph.add(childIRI, subsetsProperty, parentIRI);

    Mockito.when(parentTMap.getNode()).thenReturn(parentIRI);
    Mockito.when(childTMap.getNode()).thenReturn(childIRI);
    Mockito.when(parentMMecTMap.getId()).thenReturn(parentIdString);
    Mockito.when(childMMecTMap.getId()).thenReturn(childIdString);

    Assertions.assertThrows(Exception.class,
        () -> parserSubsetsExtension.parse(mappingGraph, tripleMaps, sourceMappings));

    Mockito.verify(parentMMecTMap, Mockito.never()).addSubset(Mockito.any());
  }
}

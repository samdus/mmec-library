package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.parser.extension;

import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.MappingParserExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.after.MMecParserConversionExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.after.MMecParserSubsetsExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before.MMecParserRefSubjectMapExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before.MMecParserTemplatesExtension;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import eu.optique.r2rml.api.model.TriplesMap;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.spec.mapping.PrefixManager;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMapping;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import org.apache.commons.rdf.api.Graph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.testcontainers.shaded.com.google.common.collect.Streams;

import java.util.Collection;

@SuppressWarnings("unchecked")
public class MappingParserExtensionTest {
  @Test
  public void updateMappingGraphBeforeParseTest() {
    SQLPPMappingFactory ppMappingFactory = Mockito.mock(SQLPPMappingFactory.class);
    MMecParserRefSubjectMapExtension refSubjectMapExtension =
        Mockito.mock(MMecParserRefSubjectMapExtension.class);
    MMecParserTemplatesExtension templatesExtension =
        Mockito.mock(MMecParserTemplatesExtension.class);
    MMecParserConversionExtension conversionExtension =
        Mockito.mock(MMecParserConversionExtension.class);
    MMecParserSubsetsExtension subsetsExtension = Mockito.mock(MMecParserSubsetsExtension.class);
    Graph mappingGraph = Mockito.mock(Graph.class);
    ImmutableMap<String, String> prefixes = ImmutableMap.of();

    MappingParserExtension mappingParserExtension =
        new MappingParserExtension(ppMappingFactory, refSubjectMapExtension, templatesExtension,
            conversionExtension, subsetsExtension);

    mappingParserExtension.updateMappingGraphBeforeParse(mappingGraph, prefixes);

    Mockito.verify(refSubjectMapExtension).updateGraph(mappingGraph, prefixes);
    Mockito.verify(templatesExtension).updateGraph(mappingGraph, prefixes);
  }

  @Test
  public void getExtendedMappingTest() {
    SQLPPMappingFactory ppMappingFactory = Mockito.mock(SQLPPMappingFactory.class);
    MMecParserRefSubjectMapExtension refSubjectMapExtension =
        Mockito.mock(MMecParserRefSubjectMapExtension.class);
    MMecParserTemplatesExtension templatesExtension =
        Mockito.mock(MMecParserTemplatesExtension.class);
    MMecParserConversionExtension conversionExtension =
        Mockito.mock(MMecParserConversionExtension.class);
    MMecParserSubsetsExtension subsetsExtension = Mockito.mock(MMecParserSubsetsExtension.class);
    Graph mappingGraph = Mockito.mock(Graph.class);
    ArgumentCaptor<Graph> mappingGraphCaptor = ArgumentCaptor.forClass(Graph.class);
    ArgumentCaptor<Collection<TriplesMap>> tripleMapsCaptor =
        ArgumentCaptor.forClass(Collection.class);
    ArgumentCaptor<PrefixManager> prefixManagerCaptor =
        ArgumentCaptor.forClass(PrefixManager.class);
    ArgumentCaptor<ImmutableList<MMecTriplesMap>> mmecSourceMappings =
        ArgumentCaptor.forClass(ImmutableList.class);
    ArgumentCaptor<ImmutableList<SQLPPTriplesMap>> extendedSourceMapping =
        ArgumentCaptor.forClass(ImmutableList.class);
    Collection<TriplesMap> tripleMaps = Mockito.mock(Collection.class);
    ImmutableList<SQLPPTriplesMap> sourceMappings = Mockito.mock(ImmutableList.class);
    PrefixManager prefixManager = Mockito.mock(PrefixManager.class);
    SQLPPMapping expected = Mockito.mock(SQLPPMapping.class);

    MappingParserExtension mappingParserExtension =
        new MappingParserExtension(ppMappingFactory, refSubjectMapExtension, templatesExtension,
            conversionExtension, subsetsExtension);

    Mockito.when(ppMappingFactory.createSQLPreProcessedMapping(extendedSourceMapping.capture(),
        prefixManagerCaptor.capture())).thenReturn(expected);

    SQLPPMapping actual =
        mappingParserExtension.getExtendedMapping(mappingGraph, tripleMaps, sourceMappings,
            prefixManager);

    Mockito.verify(conversionExtension)
        .parse(mappingGraphCaptor.capture(), tripleMapsCaptor.capture(),
            mmecSourceMappings.capture());
    Mockito.verify(subsetsExtension).parse(mappingGraphCaptor.capture(), tripleMapsCaptor.capture(),
        mmecSourceMappings.capture());

    Assertions.assertEquals(expected, actual);
    for (Graph captedGraph : mappingGraphCaptor.getAllValues()) {
      Assertions.assertSame(mappingGraph, captedGraph);
    }
    for (Collection<TriplesMap> captedTripleMap : tripleMapsCaptor.getAllValues()) {
      Assertions.assertSame(tripleMaps, captedTripleMap);
    }
    for (PrefixManager captedPrefixManager : prefixManagerCaptor.getAllValues()) {
      Assertions.assertSame(prefixManager, captedPrefixManager);
    }

    Assertions.assertSame(mmecSourceMappings.getAllValues().get(0),
        mmecSourceMappings.getAllValues().get(1));
    Streams.zip(mmecSourceMappings.getAllValues().get(0).stream(),
        extendedSourceMapping.getValue().stream(), (mmec, extended) -> {
          Assertions.assertSame(mmec, extended);
          return 1;
        });
  }
}

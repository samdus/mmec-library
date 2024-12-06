package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.pp;

import ca.griis.mmec.controller.ontop.spec.mapping.pp.ProvUnion;
import it.unibz.inf.ontop.exception.MinorOntopInternalBugException;
import it.unibz.inf.ontop.spec.mapping.pp.PPMappingAssertionProvenance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Stream;

@SuppressWarnings({"RedundantOperationOnEmptyContainer"})
public class ProvUnionTest {
  @Test
  public void getProvenanceInfoWhenEmptyTest() {
    List<PPMappingAssertionProvenance> unionPpMappingAssertionProvenances = List.of();
    Optional<PPMappingAssertionProvenance> ppMappingAssertionProvenance =
        unionPpMappingAssertionProvenances.stream()
            .collect(ProvUnion.getPpMappingAssertionProvenanceCollector());

    Assertions.assertTrue(ppMappingAssertionProvenance.isEmpty());
  }

  @Test
  public void getProvenanceInfoWithTwoProvenancesTest() {
    PPMappingAssertionProvenance ppMappingAssertionProvenance1 =
        Mockito.mock(PPMappingAssertionProvenance.class);
    PPMappingAssertionProvenance ppMappingAssertionProvenance2 =
        Mockito.mock(PPMappingAssertionProvenance.class);

    Mockito.when(ppMappingAssertionProvenance1.getProvenanceInfo()).thenReturn("provenanceInfo1");
    Mockito.when(ppMappingAssertionProvenance2.getProvenanceInfo()).thenReturn("provenanceInfo2");

    List<PPMappingAssertionProvenance> unionPpMappingAssertionProvenances =
        List.of(ppMappingAssertionProvenance1, ppMappingAssertionProvenance2);
    Optional<PPMappingAssertionProvenance> ppMappingAssertionProvenance =
        unionPpMappingAssertionProvenances.stream()
            .collect(ProvUnion.getPpMappingAssertionProvenanceCollector());

    Assertions.assertTrue(ppMappingAssertionProvenance.isPresent());
    Assertions.assertEquals(ppMappingAssertionProvenance.get().getProvenanceInfo(),
        ppMappingAssertionProvenance.get().toString());
    Assertions.assertTrue(
        ppMappingAssertionProvenance.get().getProvenanceInfo().contains("Union of 2 provenance:"));
    Assertions.assertTrue(ppMappingAssertionProvenance.get().getProvenanceInfo()
        .contains(ppMappingAssertionProvenance1.getProvenanceInfo()));
    Assertions.assertTrue(ppMappingAssertionProvenance.get().getProvenanceInfo()
        .contains(ppMappingAssertionProvenance2.getProvenanceInfo()));
  }

  @Test
  public void provUnionInCombinerShouldThrowTest() {
    List<PPMappingAssertionProvenance> provList =
        List.of(Mockito.mock(PPMappingAssertionProvenance.class),
            Mockito.mock(PPMappingAssertionProvenance.class),
            Mockito.mock(PPMappingAssertionProvenance.class),
            Mockito.mock(PPMappingAssertionProvenance.class));

    Assertions.assertThrows(MinorOntopInternalBugException.class,
        () -> provList.parallelStream()
            .collect(ProvUnion.getPpMappingAssertionProvenanceCollector()));
  }

  @Test
  public void provUnionCollectorCharacteristicsTest() {
    Assertions.assertTrue(ProvUnion.getPpMappingAssertionProvenanceCollector().characteristics()
        .contains(Collector.Characteristics.UNORDERED));
  }
}

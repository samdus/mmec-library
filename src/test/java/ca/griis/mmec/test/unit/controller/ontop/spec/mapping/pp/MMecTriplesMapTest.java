package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.pp;

import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecPpMappingAssertionProvenance;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.spec.mapping.SQLPPSourceQuery;
import it.unibz.inf.ontop.spec.mapping.TargetAtom;
import it.unibz.inf.ontop.spec.mapping.pp.PPMappingAssertionProvenance;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecTriplesMapTest {
  @Test
  public void addAndGetSubsetTest() {
    SQLPPTriplesMap sqlppTriplesMap = Mockito.mock(SQLPPTriplesMap.class);
    MMecTriplesMap mmecTriplesMap = new MMecTriplesMap(sqlppTriplesMap);
    SQLPPSourceQuery sourceQuery = Mockito.mock(SQLPPSourceQuery.class);
    ImmutableList<TargetAtom> targetAtoms = ImmutableList.of();
    String triplesMapId = "triplesMapId";

    MMecTriplesMap subset1 = Mockito.mock(MMecTriplesMap.class);
    MMecTriplesMap subset2 = Mockito.mock(MMecTriplesMap.class);

    Mockito.when(sqlppTriplesMap.getSourceQuery()).thenReturn(sourceQuery);
    Mockito.when(sqlppTriplesMap.getTargetAtoms()).thenReturn(targetAtoms);
    Mockito.when(sqlppTriplesMap.getId()).thenReturn(triplesMapId);

    mmecTriplesMap.addSubset(subset1);
    mmecTriplesMap.addSubset(subset2);

    Assertions.assertEquals(subset1, mmecTriplesMap.getSubsetList().get(0));
    Assertions.assertEquals(subset2, mmecTriplesMap.getSubsetList().get(1));
  }

  @Test
  public void getMappingAssertionProvenanceTest() {
    SQLPPTriplesMap sqlppTriplesMap = Mockito.mock(SQLPPTriplesMap.class);
    SQLPPSourceQuery sourceQuery = Mockito.mock(SQLPPSourceQuery.class);
    TargetAtom targetAtom = Mockito.mock(TargetAtom.class);
    ImmutableList<TargetAtom> targetAtoms = ImmutableList.of(targetAtom);
    String tripleMapId = "triplesMapId";

    Mockito.when(sqlppTriplesMap.getSourceQuery()).thenReturn(sourceQuery);
    Mockito.when(sqlppTriplesMap.getTargetAtoms()).thenReturn(targetAtoms);
    Mockito.when(sqlppTriplesMap.getId()).thenReturn(tripleMapId);

    MMecTriplesMap mmecTriplesMap = new MMecTriplesMap(sqlppTriplesMap);
    PPMappingAssertionProvenance mMecPpMappingAssertionProvenance =
        mmecTriplesMap.getMappingAssertionProvenance(targetAtom);

    Assertions.assertInstanceOf(MMecPpMappingAssertionProvenance.class,
        mMecPpMappingAssertionProvenance);
    Assertions.assertSame(mmecTriplesMap,
        ((MMecPpMappingAssertionProvenance) mMecPpMappingAssertionProvenance).getMmecTriplesMap());
    Assertions.assertSame(targetAtom,
        ((MMecPpMappingAssertionProvenance) mMecPpMappingAssertionProvenance).getTargetAtom());
    Assertions.assertTrue(
        mMecPpMappingAssertionProvenance.getProvenanceInfo().contains(targetAtom.toString()));
    Assertions.assertTrue(
        mMecPpMappingAssertionProvenance.getProvenanceInfo().contains(sourceQuery.toString()));
    Assertions.assertTrue(
        mMecPpMappingAssertionProvenance.getProvenanceInfo().contains(tripleMapId));
  }
}

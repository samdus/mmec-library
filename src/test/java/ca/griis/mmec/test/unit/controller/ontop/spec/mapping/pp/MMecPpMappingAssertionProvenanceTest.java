package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.pp;

import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecPpMappingAssertionProvenance;
import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import it.unibz.inf.ontop.spec.mapping.SQLPPSourceQuery;
import it.unibz.inf.ontop.spec.mapping.TargetAtom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecPpMappingAssertionProvenanceTest {
  @Test
  public void gettersTest() {
    TargetAtom targetAtom = Mockito.mock(TargetAtom.class);
    MMecTriplesMap mmecTriplesMap = Mockito.mock(MMecTriplesMap.class);
    SQLPPSourceQuery sourceQuery = Mockito.mock(SQLPPSourceQuery.class);
    String tripleMapId = "triplemapid";

    Mockito.when(mmecTriplesMap.getSourceQuery()).thenReturn(sourceQuery);
    Mockito.when(mmecTriplesMap.getId()).thenReturn(tripleMapId);

    MMecPpMappingAssertionProvenance mMecPpMappingAssertionProvenance =
        new MMecPpMappingAssertionProvenance(targetAtom, mmecTriplesMap);

    Assertions.assertSame(mmecTriplesMap, mMecPpMappingAssertionProvenance.getMmecTriplesMap());
    Assertions.assertSame(targetAtom, mMecPpMappingAssertionProvenance.getTargetAtom());
    Assertions.assertTrue(
        mMecPpMappingAssertionProvenance.getProvenanceInfo().contains(targetAtom.toString()));
    Assertions.assertTrue(
        mMecPpMappingAssertionProvenance.getProvenanceInfo().contains(sourceQuery.toString()));
    Assertions.assertTrue(
        mMecPpMappingAssertionProvenance.getProvenanceInfo().contains(tripleMapId));
    Assertions.assertEquals(mMecPpMappingAssertionProvenance.toString(),
        mMecPpMappingAssertionProvenance.getProvenanceInfo());
  }
}

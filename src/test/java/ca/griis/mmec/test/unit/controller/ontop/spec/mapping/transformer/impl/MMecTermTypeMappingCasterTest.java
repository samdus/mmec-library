package ca.griis.mmec.test.unit.controller.ontop.spec.mapping.transformer.impl;

import ca.griis.mmec.controller.ontop.spec.mapping.transformer.impl.MMecTermTypeMappingCaster;
import it.unibz.inf.ontop.spec.mapping.MappingAssertion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecTermTypeMappingCasterTest {
  @Test
  public void transformIsIdentity() {
    MMecTermTypeMappingCaster mmecTermTypeMappingCaster = new MMecTermTypeMappingCaster();
    MappingAssertion assertion = Mockito.mock(MappingAssertion.class);

    MappingAssertion result = mmecTermTypeMappingCaster.transform(assertion);

    Assertions.assertSame(assertion, result);
    Mockito.verifyNoInteractions(assertion);
  }
}

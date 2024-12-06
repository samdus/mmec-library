package ca.griis.mmec.test.unit.controller.ontop.spec.mapping;

import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingConversion;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecMappingExtensionTest {
  @Test
  public void getMappingConversionTest() {
    MMecMappingExtension extension = new MMecMappingExtension();
    DBTermType firstFrom = Mockito.mock(DBTermType.class);
    DBTermType secondFrom = Mockito.mock(DBTermType.class);
    DBTermType firstTo = Mockito.mock(DBTermType.class);
    DBTermType secondTo = Mockito.mock(DBTermType.class);
    MMecMappingConversion conversion1 = Mockito.mock(MMecMappingConversion.class);
    MMecMappingConversion conversion2 = Mockito.mock(MMecMappingConversion.class);
    MMecMappingConversion conversion3 = Mockito.mock(MMecMappingConversion.class);

    Mockito.when(conversion1.getInputType()).thenReturn(firstFrom);
    Mockito.when(conversion1.getOutputType()).thenReturn(firstTo);
    Mockito.when(conversion2.getInputType()).thenReturn(firstFrom);
    Mockito.when(conversion2.getOutputType()).thenReturn(secondTo);
    Mockito.when(conversion3.getInputType()).thenReturn(secondFrom);
    Mockito.when(conversion3.getOutputType()).thenReturn(firstTo);

    extension.addMappingConversion(conversion1);
    extension.addMappingConversion(conversion2);
    extension.addMappingConversion(conversion3);

    Optional<MMecMappingConversion> actualConversion1 =
        extension.getMappingConversion(firstFrom, firstTo);
    Optional<MMecMappingConversion> actualConversion2 =
        extension.getMappingConversion(firstFrom, secondTo);
    Optional<MMecMappingConversion> actualConversion3 =
        extension.getMappingConversion(secondFrom, firstTo);

    Assertions.assertTrue(actualConversion1.isPresent());
    Assertions.assertTrue(actualConversion2.isPresent());
    Assertions.assertTrue(actualConversion3.isPresent());

    Assertions.assertEquals(conversion1, actualConversion1.get());
    Assertions.assertEquals(conversion2, actualConversion2.get());
    Assertions.assertEquals(conversion3, actualConversion3.get());
  }
}

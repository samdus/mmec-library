/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe FacadePropertiesBuilderTest.
 * @brief @~english FacadePropertiesBuilderTest class implementation.
 */
package ca.griis.mmec.test.unit.configuration.builder;

import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.FacadeType;
import ca.griis.mmec.properties.SignatureType;
import ca.griis.mmec.properties.builder.FacadePropertiesBuilder;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details
 *      «Detailed description of the component (optional)»
 * @par Model
 *      «Model (Abstract, automation, etc.) (optional)»
 * @par Conception
 *      «Conception description (criteria and constraints) (optional)»
 * @par Limits
 *      «Limits description (optional)»
 *
 * @brief @~french Test de la classe FacadePropertiesBuilder.
 * @par Détails
 *      S.O.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2023-09-07 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class FacadePropertiesBuilderTest {
  @Test
  public void testCustomFacadeStg() {
    String expectedFacadeStgPath = "TestFacadeStgPath";
    String expectedSignatureStgPath = "TestSignatureStgPath";

    FacadePropertiesBuilder builder = new FacadePropertiesBuilder();
    FacadeProperties actualProperties = builder
        .withFacadeStgPath(expectedFacadeStgPath)
        .withSignatureStgPath(expectedSignatureStgPath)
        .build();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertEquals(expectedFacadeStgPath, actualProperties.getFacadeStgPath());
    Assertions.assertEquals(expectedSignatureStgPath, actualProperties.getSignatureStgPath());
  }

  @Test
  public void testSetPredefinedFacadeStg() {
    String expectedFacadeStgPath = FacadeType.VIEWS.getStgPath();
    String expectedSignatureStgPath = SignatureType.STRING.getStgPath();

    FacadePropertiesBuilder builder = new FacadePropertiesBuilder();
    FacadeProperties actualProperties = builder
        .withFacadeType(FacadeType.VIEWS)
        .withSignatureType(SignatureType.STRING)
        .build();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertEquals(expectedFacadeStgPath, actualProperties.getFacadeStgPath());
    Assertions.assertEquals(expectedSignatureStgPath, actualProperties.getSignatureStgPath());
  }

  @Test
  public void testGetInStream() throws IOException {
    FacadePropertiesBuilder builder = new FacadePropertiesBuilder();
    FacadeProperties actualProperties = builder
        .withFacadeType(FacadeType.VIEWS)
        .withSignatureType(SignatureType.STRING)
        .build();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertNotNull(actualProperties.getFacadeStgStream());
    Assertions.assertNotNull(actualProperties.getSignatureStgStream());

    Assertions.assertTrue(actualProperties.getFacadeStgStream().readAllBytes().length > 0,
        "The facade stg stream is empty.");
    Assertions.assertTrue(actualProperties.getSignatureStgStream().readAllBytes().length > 0,
        "The signature stg stream is empty.");
  }
}

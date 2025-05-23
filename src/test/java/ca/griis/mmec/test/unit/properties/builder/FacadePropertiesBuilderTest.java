/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe FacadePropertiesBuilderTest.
 * @brief @~english FacadePropertiesBuilderTest class implementation.
 */

package ca.griis.mmec.test.unit.properties.builder;

import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.FacadeType;
import ca.griis.mmec.properties.MissingPropertyException;
import ca.griis.mmec.properties.builder.FacadePropertiesBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

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
  public void testCustomFacadeStg(@TempDir File tempDir)
      throws IOException, URISyntaxException, MissingPropertyException {
    URL stgFilePath = Path.of(tempDir.getAbsolutePath(), "TestFacade.stg").toUri().toURL();

    createSampleFile(stgFilePath);

    FacadePropertiesBuilder builder = new FacadePropertiesBuilder();
    FacadeProperties actualProperties = builder
        .withFacadeStgPath(stgFilePath)
        .build();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertNotNull(actualProperties.getFacadeStgUrl());
  }

  @Test
  public void testSetPredefinedFacadeStg() throws IOException, MissingPropertyException {
    FacadePropertiesBuilder builder = new FacadePropertiesBuilder();
    FacadeProperties actualProperties = builder
        .withFacadeType(FacadeType.VIEWS)
        .build();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertNotNull(actualProperties.getFacadeStgUrl());
  }

  @Test
  public void testGetInStream() throws IOException, MissingPropertyException {
    FacadePropertiesBuilder builder = new FacadePropertiesBuilder();
    FacadeProperties actualProperties = builder
        .withFacadeType(FacadeType.VIEWS)
        .build();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertNotNull(actualProperties.getFacadeStgUrl());

    try (InputStream inStream = actualProperties.getFacadeStgUrl().openStream()) {
      Assertions.assertTrue(inStream.readAllBytes().length > 0,
          "The facade stg stream is empty.");
    }
  }

  @Test
  public void testMissingFacadeStgShouldThrow() {
    FacadePropertiesBuilder builder = new FacadePropertiesBuilder();
    Assertions.assertThrows(MissingPropertyException.class, builder::build);
  }

  private static void createSampleFile(URL stgFilePath) throws URISyntaxException {
    try {
      File sampleFile = Paths.get(stgFilePath.toURI()).toFile();
      if (!sampleFile.createNewFile()) {
        Assertions.fail("Failed to create the sample file.");
      }
    } catch (IOException e) {
      Assertions.fail("Failed to create the sample file.");
    }
  }
}

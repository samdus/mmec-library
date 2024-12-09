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

package ca.griis.mmec.test.unit.properties.builder;

import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.properties.MissingPropertyException;
import ca.griis.mmec.properties.builder.MappingPropertiesBuilder;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
 * @brief @~french Test de la classe MappingPropertiesBuilder.
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
public class MappingPropertiesBuilderTest {
  @Test
  public void test() throws MissingPropertyException {
    String ontoRelId = "ontoRelId";
    String mappingSchema = "mappingSchema";
    String ontologyFilePath = "ontologyFilePath";
    String r2rmlMappingFilePath = "r2rmlMappingFilePath";

    MappingPropertiesBuilder builder = new MappingPropertiesBuilder();
    MappingProperties actualProperties = builder
        .withOntoRelId(ontoRelId)
        .withMappingSchema(mappingSchema)
        .withOntologyFilePath(ontologyFilePath)
        .withR2rmlMappingFilePath(r2rmlMappingFilePath)
        .build();

    Assertions.assertNotNull(actualProperties);
    Assertions.assertEquals(ontoRelId, actualProperties.getOntoRelId());
    Assertions.assertEquals(mappingSchema, actualProperties.getMappingSchema());
    Assertions.assertEquals(ontologyFilePath, actualProperties.getOntologyFilePath());
    Assertions.assertEquals(r2rmlMappingFilePath, actualProperties.getR2rmlMappingFilePath());
  }

  private static Stream<Arguments> provideMissingProperties() {
    return Stream.of(
        Arguments.of("ontoRelId", "mappingSchema", "ontologyFilePath", null),
        Arguments.of("ontoRelId", "mappingSchema", null, "r2rmlMappingFilePath"),
        Arguments.of("ontoRelId", null, "ontologyFilePath", "r2rmlMappingFilePath"),
        Arguments.of(null, "mappingSchema", "ontologyFilePath", "r2rmlMappingFilePath"));
  }

  @ParameterizedTest
  @MethodSource("provideMissingProperties")
  public void testMissingProperties(String ontoRelId, String mappingSchema, String ontologyFilePath,
      String r2rmlMappingFilePath) {
    MappingPropertiesBuilder builder = new MappingPropertiesBuilder();
    Assertions.assertThrows(MissingPropertyException.class, () -> {
      builder
          .withOntoRelId(ontoRelId)
          .withMappingSchema(mappingSchema)
          .withOntologyFilePath(ontologyFilePath)
          .withR2rmlMappingFilePath(r2rmlMappingFilePath)
          .build();
    });
  }
}

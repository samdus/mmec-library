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

import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.properties.builder.MappingPropertiesBuilder;
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
  public void test() {
    MappingPropertiesBuilder builder = new MappingPropertiesBuilder();
    MappingProperties actualProperties = builder.build();

    Assertions.assertNotNull(actualProperties);
  }
}

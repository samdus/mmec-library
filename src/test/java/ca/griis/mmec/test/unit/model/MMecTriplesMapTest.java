/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecTriplesMapTest.
 * @brief @~english MMecTriplesMapTest class implementation.
 */

package ca.griis.mmec.test.unit.model;

import ca.griis.mmec.controller.ontop.spec.mapping.pp.MMecTriplesMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
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
public class MMecTriplesMapTest {

  @Test
  public void setUp() {
    MMecTriplesMap supersetTripleMap = Mockito.mock(MMecTriplesMap.class);
    MMecTriplesMap subsetTripleMap = Mockito.mock(MMecTriplesMap.class);

    MMecTriplesMap mmecTriplesMap = new MMecTriplesMap(supersetTripleMap);
    mmecTriplesMap.addSubset(subsetTripleMap);

    Assertions.assertEquals(1, mmecTriplesMap.getSubsetList().size());
    Assertions.assertSame(subsetTripleMap, mmecTriplesMap.getSubsetList().get(0));
  }

}

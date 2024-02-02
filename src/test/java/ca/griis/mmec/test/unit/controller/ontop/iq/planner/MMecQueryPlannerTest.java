/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecQueryPlannerTest.
 * @brief @~english MMecQueryPlannerTest class implementation.
 */
package ca.griis.mmec.test.unit.controller.ontop.iq.planner;

import ca.griis.mmec.controller.ontop.iq.optimizer.MMecQueryOptimizer;
import ca.griis.mmec.controller.ontop.iq.planner.MMecQueryPlanner;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.planner.QueryPlanner;
import it.unibz.inf.ontop.iq.planner.impl.AvoidJoinAboveUnionPlanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
 * @brief @~french Tests unitaires pour la classe MMecQueryPlanner.
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
 *      2024-01-31 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecQueryPlannerTest {
  AvoidJoinAboveUnionPlanner avoidJoinAboveUnionPlanner;
  MMecQueryOptimizer MMecQueryOptimizer;

  @BeforeEach
  public void init() {
    avoidJoinAboveUnionPlanner = Mockito.mock(AvoidJoinAboveUnionPlanner.class);
    MMecQueryOptimizer = Mockito.mock(MMecQueryOptimizer.class);
  }

  @Test
  public void mustCallMMecQueryOptimizerAfterDefaultOptimizer() {
    QueryPlanner planner = new MMecQueryPlanner(avoidJoinAboveUnionPlanner, MMecQueryOptimizer);

    IQ initialIq = Mockito.mock(IQ.class);
    IQ intermediaryIq = Mockito.mock(IQ.class);
    IQ expected = Mockito.mock(IQ.class);

    Mockito.when(avoidJoinAboveUnionPlanner.optimize(initialIq)).thenReturn(intermediaryIq);
    Mockito.when(MMecQueryOptimizer.optimize(intermediaryIq)).thenReturn(expected);

    IQ actual = planner.optimize(initialIq);

    Assertions.assertEquals(expected, actual);
  }
}

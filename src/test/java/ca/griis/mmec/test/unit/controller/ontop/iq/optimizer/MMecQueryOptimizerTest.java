/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecQueryOptimizerTest.
 * @brief @~english MMecQueryOptimizerTest class implementation.
 */
package ca.griis.mmec.test.unit.controller.ontop.iq.optimizer;

import ca.griis.mmec.controller.ontop.iq.optimizer.MMecQueryOptimizer;
import ca.griis.mmec.controller.ontop.iq.transform.DataPropertyProjectionTransformer;
import ca.griis.mmec.controller.ontop.iq.transform.IndividuationFunctionQueryTransformer;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.optimizer.IQOptimizer;
import it.unibz.inf.ontop.model.atom.DistinctVariableOnlyDataAtom;
import it.unibz.inf.ontop.model.term.TermFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details «Detailed description of the component (optional)»
 * @par Model «Model (Abstract, automation, etc.) (optional)»
 * @par Conception «Conception description (criteria and constraints) (optional)»
 * @par Limits «Limits description (optional)»
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
 * @par Détails S.O.
 * @par Modèle S.O.
 * @par Conception S.O.
 * @par Limites S.O.
 * @par Historique 2024-01-31 [SD] - Implémentation initiale<br>
 * @par Tâches S.O.
 */
public class MMecQueryOptimizerTest {
  IntermediateQueryFactory iqFactory;
  TermFactory termFactory;
  IndividuationFunctionQueryTransformer individuationFunctionQueryTransformer;
  DataPropertyProjectionTransformer dataPropertyProjectionTransformer;

  @BeforeEach
  public void initialisation() {
    iqFactory = Mockito.mock(IntermediateQueryFactory.class);
    termFactory = Mockito.mock(TermFactory.class);
    individuationFunctionQueryTransformer = Mockito.mock(
        IndividuationFunctionQueryTransformer.class);
    dataPropertyProjectionTransformer = Mockito.mock(DataPropertyProjectionTransformer.class);
  }

  @Test
  public void allTransformerMustBeApplied() {
    IQOptimizer optimizer = new MMecQueryOptimizer(iqFactory, termFactory,
        individuationFunctionQueryTransformer, dataPropertyProjectionTransformer);

    IQ expected = Mockito.mock(IQ.class);
    DistinctVariableOnlyDataAtom projectionAtom = Mockito.mock(DistinctVariableOnlyDataAtom.class);
    IQ initialIq = Mockito.mock(IQ.class);
    IQTree iqTree = Mockito.mock(IQTree.class);

    Mockito.when(initialIq.getTree()).thenReturn(iqTree);
    Mockito.when(initialIq.getProjectionAtom()).thenReturn(projectionAtom);
    Mockito.when(iqTree.acceptTransformer(individuationFunctionQueryTransformer)).thenReturn(
        iqTree);
    Mockito.when(iqTree.acceptTransformer(dataPropertyProjectionTransformer)).thenReturn(iqTree);
    Mockito.when(iqFactory.createIQ(projectionAtom, iqTree)).thenReturn(expected);

    IQ actual = optimizer.optimize(initialIq);

    Assertions.assertEquals(expected, actual);
    Mockito.verify(iqTree).acceptTransformer(individuationFunctionQueryTransformer);
    Mockito.verify(iqTree).acceptTransformer(dataPropertyProjectionTransformer);
  }
}

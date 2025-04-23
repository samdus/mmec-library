/**
 * @file
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 * @version 1.2.0
 * @brief @~french Implémentation de la classe MMecQueryOptimizerTest.
 * @brief @~english MMecQueryOptimizerTest class implementation.
 */

package ca.griis.mmec.test.unit.controller.ontop.iq.optimizer;

import ca.griis.mmec.controller.ontop.iq.optimizer.MMecQueryOptimizer;
import ca.griis.mmec.controller.ontop.iq.transform.DataPropertyProjectionTransformer;
import ca.griis.mmec.controller.ontop.iq.transform.IndividuationFunctionQueryTransformer;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.model.term.TermFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecQueryOptimizerTest {
  IntermediateQueryFactory iqFactory;
  TermFactory termFactory;
  IndividuationFunctionQueryTransformer individuationFunctionQueryTransformer;
  DataPropertyProjectionTransformer dataPropertyProjectionTransformer;

  @BeforeEach
  public void init() {
    iqFactory = Mockito.mock(IntermediateQueryFactory.class);
    termFactory = Mockito.mock(TermFactory.class);
    individuationFunctionQueryTransformer = Mockito.mock(
        IndividuationFunctionQueryTransformer.class);
    dataPropertyProjectionTransformer = Mockito.mock(DataPropertyProjectionTransformer.class);
  }

  @Test
  public void allTransformerMustBeApplied() {
    MMecQueryOptimizer optimizer = new MMecQueryOptimizer(iqFactory, termFactory,
        individuationFunctionQueryTransformer, dataPropertyProjectionTransformer);

    IQTree iqTree = Mockito.mock(IQTree.class);
    IQTree expected = iqTree;

    Mockito.when(iqTree.acceptTransformer(individuationFunctionQueryTransformer)).thenReturn(
        iqTree);
    Mockito.when(iqTree.acceptTransformer(dataPropertyProjectionTransformer)).thenReturn(iqTree);

    IQTree actual = optimizer.optimize(iqTree);

    Assertions.assertEquals(expected, actual);
    Mockito.verify(iqTree).acceptTransformer(individuationFunctionQueryTransformer);
    Mockito.verify(iqTree).acceptTransformer(dataPropertyProjectionTransformer);
  }
}

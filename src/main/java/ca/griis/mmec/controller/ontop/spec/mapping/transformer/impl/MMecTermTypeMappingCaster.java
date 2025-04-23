/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe MMecTermTypeMappingCaster.
 * @brief @~english MMecTermTypeMappingCaster class implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping.transformer.impl;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import it.unibz.inf.ontop.spec.mapping.MappingAssertion;
import it.unibz.inf.ontop.spec.mapping.transformer.MappingCaster;

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
 * @brief @~french Copie de it.unibz.inf.ontop.spec.mapping.transformer.impl.TermTypeMappingCaster
 *        où on ne vérifie pas que les termes sont RDF.
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
 *      2024-02-28 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecTermTypeMappingCaster implements MappingCaster {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecTermTypeMappingCaster.class);

  @Override
  public MappingAssertion transform(MappingAssertion assertion) {
    logger.trace(Trace.ENTER_METHOD_1, assertion);
    return assertion;
  }
}

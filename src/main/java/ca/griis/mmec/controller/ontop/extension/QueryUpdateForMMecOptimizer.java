/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe QueryUpdateForMMecOptimizer.
 * @brief @~english QueryUpdateForMMecOptimizer class implementation.
 */
package ca.griis.mmec.controller.ontop.extension;

import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.iq.optimizer.IQOptimizer;

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
 *      2023-12-21 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class QueryUpdateForMMecOptimizer implements IQOptimizer {
  @Override
  public IQ optimize(IQ iq) {
    //TODO: Cette fonction doit pouvoir modifier les IQ pour remplacer les appels de fonctions qui
    //      génère des IRI pour appeler la fonction de génération de signature. Remplacer les
    //      conversion de type également.
    return iq;
  }
}

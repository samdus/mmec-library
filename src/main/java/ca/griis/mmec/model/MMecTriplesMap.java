/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'objet MMecTriplesMap.
 * @brief @~english MMecTriplesMap object implementation.
 */

package ca.griis.mmec.model;

import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import it.unibz.inf.ontop.spec.mapping.pp.impl.R2RMLSQLPPtriplesMap;

import java.util.ArrayList;
import java.util.List;


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
 * @brief @~french Classe servant à étendre le modèle interne de TripleMap
 *                 avec les fonctions R2RML étendues.
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
 *      2023-09-06 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *    S.O.
 */
public class MMecTriplesMap extends R2RMLSQLPPtriplesMap {
  private final List<SQLPPTriplesMap> subSetList = new ArrayList<>();

  /**
   * @brief @~english «Description of the method»
   * @param sqlppTriplesMap «Parameter description»
   *
   * @brief @~french Constructeur par défaut.
   * @param sqlppTriplesMap Le SQLPPTriplesMap à étendre.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *    S.O.
   */
  public MMecTriplesMap(SQLPPTriplesMap sqlppTriplesMap) {
    super(sqlppTriplesMap.getId(), sqlppTriplesMap.getSourceQuery(),
        sqlppTriplesMap.getTargetAtoms());
  }

  /**
   * @brief @~english «Description of the method»
   * @return «Return description»
   *
   * @brief @~french Obtenir la liste des sous-ensembles de l'expression d'arrimage.
   * @return La liste des sous-ensembles de l'expression d'arrimage.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *    S.O.
   */
  public List<SQLPPTriplesMap> getSubsetList() {
    return subSetList;
  }

  /**
   * @brief @~english «Description of the method»
   * @param subset «Parameter description»
   *
   * @brief @~french Ajouter une expression d'arrimage sous-ensemble à l'expression d'arrimage.
   * @param subset L'expression d'arrimage à ajouter comme sous-ensemble.
   *
   * @note «AAAA-MM-JJ» [«initiales»] - «Note informative»
   *
   * @par Tâches
   *    S.O.
   */
  public void addSubset(SQLPPTriplesMap subset) {
    subSetList.add(subset);
  }
}

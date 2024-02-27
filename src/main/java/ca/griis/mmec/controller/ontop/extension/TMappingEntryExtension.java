/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe TMappingEntryExtension.
 * @brief @~english TMappingEntryExtension class implementation.
 */
package ca.griis.mmec.controller.ontop.extension;

import com.google.common.collect.Iterators;
import it.unibz.inf.ontop.spec.mapping.transformer.impl.MMecTMappingRule;
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
 * @brief @~french Extension de TMappingEntry pour le merge de règles selon l'extension MMec.
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
 *      2024-02-21 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class TMappingEntryExtension {

  /**
   * @brief @~english «Description of the method»
   * @param assertion «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Exécution de l'extension du merge de règles. Retourne vrai si la nouvelle règle
   *                 ne devrait pas être ajouté.
   *                 <br>
   *                 Si la nouvelle règle est un sous-ensemble d'une règle déjà présente, elle ne
   *                 devrait pas être ajoutée. On retourne vrai.
   *                 <br>
   *                 Si une règle déjà présente est un sous-ensemble de la nouvelle règle, elle
   *                 sera supprimée. La règle en ajout peut être ajoutée, on retourne faux.
   * @param assertion La nouvelle règle en ajout
   * @return Vrai si la nouvelle règle ne devrait pas être ajoutée
   */
  public boolean extensionResultsInMerge(List<MMecTMappingRule> rules, MMecTMappingRule assertion) {
    if (isSubsetOfAlreadyPresentRule(rules, assertion)) {
      return true;
    }

    removeSubsets(rules, assertion);
    return false;
  }

  /**
   * @brief @~english Remove any rule that are subset of the new rule
   * @param assertion The new rule being added
   *
   * @brief @~french Supprime toute règle qui est un sous-ensemble de la nouvelle règle
   * @param assertion La nouvelle règle en ajout
   */
  public void removeSubsets(List<MMecTMappingRule> rules, MMecTMappingRule assertion) {
    Iterators.removeIf(rules.iterator(), potentialSubSet ->
        assertion.getProvenance().getmMecTriplesMap().getSubsetList().contains(
            potentialSubSet.getProvenance().getmMecTriplesMap()));
  }

  /**
   * @brief @~english «Description of the method»
   * @param assertion «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Vérifie si la nouvelle règle est un sous-ensemble d'une règle déjà présente
   * @param assertion La nouvelle règle à vérifier
   * @return Vrai si la nouvelle règle est un sous-ensemble d'une règle déjà présente
   */
  public boolean isSubsetOfAlreadyPresentRule(List<MMecTMappingRule> rules, MMecTMappingRule assertion) {
    return rules.stream().anyMatch(
        potentialSuperSet -> potentialSuperSet.getProvenance().getmMecTriplesMap().getSubsetList()
            .contains(assertion.getProvenance().getmMecTriplesMap()));
  }
}

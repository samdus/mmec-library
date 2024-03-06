/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecPPMappingAssertionProvenance.
 * @brief @~english MMecPPMappingAssertionProvenance class implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping.pp;

import it.unibz.inf.ontop.exception.MinorOntopInternalBugException;
import it.unibz.inf.ontop.spec.mapping.pp.PPMappingAssertionProvenance;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
 * @brief @~french Provenance d'une union d'assertions de mapping.
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
 *      2024-02-20 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class ProvUnion implements PPMappingAssertionProvenance {
  private final List<PPMappingAssertionProvenance> unionPpMappingAssertionProvenances;

  public ProvUnion() {
    unionPpMappingAssertionProvenances = new ArrayList<>();
  }

  @Override
  public String getProvenanceInfo() {
    String provenanceDescription = unionPpMappingAssertionProvenances.stream().map(
        unionPPMappingAssertionProvenance -> String.format("{\n%s\n}",
            unionPPMappingAssertionProvenance.getProvenanceInfo()))
        .collect(
            Collectors.joining(",\n"));

    return String.format("Union of %d provenance:\n[%s]", unionPpMappingAssertionProvenances.size(),
        provenanceDescription);
  }

  @Override
  public String toString() {
    return getProvenanceInfo();
  }

  public abstract static class AssertionProvenanceCollector implements
      Collector<PPMappingAssertionProvenance, ProvUnion, Optional<PPMappingAssertionProvenance>> {
  }

  public static AssertionProvenanceCollector getPpMappingAssertionProvenanceCollector() {
    return (AssertionProvenanceCollector) Collector.of(ProvUnion::new,
        // Supplier
        ProvUnion::add, // Accumulator
        (b1, b2) -> {
          throw new MinorOntopInternalBugException("no merge");
        }, // Merger
        ProvUnion::build, // Finisher
        Collector.Characteristics.UNORDERED);
  }

  private static void add(ProvUnion a, PPMappingAssertionProvenance t) {
    a.unionPpMappingAssertionProvenances.add(t);
  }

  private static Optional<PPMappingAssertionProvenance> build(ProvUnion a) {
    if (a.unionPpMappingAssertionProvenances.isEmpty()) {
      return Optional.empty();
    }
    return Optional.of(a);
  }
}

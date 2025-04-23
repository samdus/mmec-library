/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
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
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
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
        unionPPMappingAssertionProvenance -> String.format("{%n%s%n}",
            unionPPMappingAssertionProvenance.getProvenanceInfo()))
        .collect(
            Collectors.joining(",\n"));

    return String.format("Union of %d provenance:%n[%s]", unionPpMappingAssertionProvenances.size(),
        provenanceDescription);
  }

  @Override
  public String toString() {
    return getProvenanceInfo();
  }

  public static class AssertionProvenanceCollector implements
      Collector<PPMappingAssertionProvenance, ProvUnion, Optional<PPMappingAssertionProvenance>> {
    @Override
    public Supplier<ProvUnion> supplier() {
      return ProvUnion::new;
    }

    @Override
    public BiConsumer<ProvUnion, PPMappingAssertionProvenance> accumulator() {
      return ProvUnion::add;
    }

    @Override
    public BinaryOperator<ProvUnion> combiner() {
      return (union1, union2) -> {
        throw new MinorOntopInternalBugException("no merge");
      };
    }

    @Override
    public Function<ProvUnion, Optional<PPMappingAssertionProvenance>> finisher() {
      return ProvUnion::build;
    }

    @Override
    public Set<Characteristics> characteristics() {
      return Set.of(Collector.Characteristics.UNORDERED);
    }
  }

  public static AssertionProvenanceCollector getPpMappingAssertionProvenanceCollector() {
    return new AssertionProvenanceCollector();
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

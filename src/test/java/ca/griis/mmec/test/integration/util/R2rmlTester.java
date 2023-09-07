package ca.griis.mmec.test.integration.util;

import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.model.atom.RDFAtomPredicate;
import it.unibz.inf.ontop.spec.OBDASpecification;
import it.unibz.inf.ontop.spec.mapping.Mapping;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;
import org.apache.commons.rdf.api.IRI;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class R2rmlTester extends OntopTester {

  public R2rmlTester(PostgresContainerWrapper postgresContainerWrapper, String ontologyFile,
      String mappingFile) throws ClassNotFoundException, IOException, OWLOntologyCreationException {
    super(postgresContainerWrapper, ontologyFile, mappingFile);
  }

  @Override
  public void runTest() throws Exception {
    OBDASpecification obdaSpecification = configuration.loadSpecification();
    Mapping mapping = obdaSpecification.getSaturatedMapping();

    HashMap<IRI, Optional<IQ>> classesMapping = new HashMap<>();
    HashMap<IRI, Optional<IQ>> propertiesMapping = new HashMap<>();

    for (RDFAtomPredicate predicate : mapping.getRDFAtomPredicates()) {
      mapping.getRDFClasses(predicate)
          .forEach(c -> classesMapping.put(c, mapping.getRDFClassDefinition(predicate, c)));
      mapping.getRDFProperties(predicate)
          .forEach(c -> propertiesMapping.put(c, mapping.getRDFPropertyDefinition(predicate, c)));
    }

    classesMapping.forEach((c, iq) -> {
      System.out.printf("Mapping for %s =>%n %s%n%n", c.getIRIString(),
          iq.map(IQ::toString).orElse("No IQ"));
    });
  }
}

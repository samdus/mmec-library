package it.unibz.inf.ontop.injection.impl;

import com.google.common.collect.ImmutableSet;
import it.unibz.inf.ontop.exception.InvalidOntopConfigurationException;
import it.unibz.inf.ontop.exception.OBDASpecificationException;
import it.unibz.inf.ontop.injection.OntopSQLOWLAPIConfiguration;
import it.unibz.inf.ontop.injection.OntopStandaloneSQLSettings;
import it.unibz.inf.ontop.injection.impl.OntopMappingOntologyBuilders.OntopMappingOntologyOptions;
import it.unibz.inf.ontop.injection.impl.OntopMappingOntologyBuilders.StandardMappingOntologyBuilderFragment;
import it.unibz.inf.ontop.spec.OBDASpecification;
import it.unibz.inf.ontop.spec.ontology.RDFFact;
import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

/**
 * Copy of the it.unibz.inf.ontop.injection.impl.OntopSQLOWLAPIConfigurationImpl class required
 * because the original class doesn't uses the mappingOWLConfiguration constructor with the
 * injectorSupplier.
 */
public class MmecOntopSqlOwlApiConfigurationImpl extends OntopStandaloneSQLConfigurationImpl
    implements OntopSQLOWLAPIConfiguration {

  private final MmecOntopMappingOntologyConfigurationImpl mappingOwlConfiguration;

  public MmecOntopSqlOwlApiConfigurationImpl(OntopStandaloneSQLSettings settings,
      MmecOntopSqlOwlApiOptions options) {
    super(settings, options.sqlOptions);
    mappingOwlConfiguration = new MmecOntopMappingOntologyConfigurationImpl(settings,
        options.ontologyOptions, this::getInjector);
  }

  @Override
  public OBDASpecification loadOBDASpecification() throws OBDASpecificationException {
    return loadSpecification(mappingOwlConfiguration::loadOntology,
        mappingOwlConfiguration::loadInputFacts);
  }

  @Override
  public Optional<OWLOntology> loadInputOntology() throws OWLOntologyCreationException {
    return mappingOwlConfiguration.loadInputOntology();
  }

  @Override
  public Optional<ImmutableSet<RDFFact>> loadInputFacts() throws OBDASpecificationException {
    return mappingOwlConfiguration.loadInputFacts();
  }

  public static class MmecOntopSqlOwlApiOptions {
    final OntopStandaloneSQLOptions sqlOptions;
    final OntopMappingOntologyOptions ontologyOptions;

    MmecOntopSqlOwlApiOptions(OntopStandaloneSQLOptions sqlOptions,
        OntopMappingOntologyOptions ontologyOptions) {
      this.sqlOptions = sqlOptions;
      this.ontologyOptions = ontologyOptions;
    }
  }

  public abstract static class OwlApiBuilderMixin<B extends OntopSQLOWLAPIConfiguration.Builder<B>>
      extends OntopStandaloneSQLBuilderMixin<B>
      implements OntopSQLOWLAPIConfiguration.Builder<B> {

    private final StandardMappingOntologyBuilderFragment<B> ontologyBuilderFragment;
    private boolean isOntologyDefined = false;

    protected OwlApiBuilderMixin() {
      ontologyBuilderFragment = new StandardMappingOntologyBuilderFragment<>() {
        @Override
        protected B self() {
          return OwlApiBuilderMixin.this.self();
        }

        @Override
        protected void declareOntologyDefined() {
          OwlApiBuilderMixin.this.declareOntologyDefined();
        }
      };
    }

    @Override
    public B ontologyFile(@Nonnull String urlOrPath) {
      return ontologyBuilderFragment.ontologyFile(urlOrPath);
    }

    @Override
    public B ontologyFile(@Nonnull URL url) {
      return ontologyBuilderFragment.ontologyFile(url);
    }

    @Override
    public B ontologyFile(@Nonnull File owlFile) {
      return ontologyBuilderFragment.ontologyFile(owlFile);
    }

    @Override
    public B xmlCatalogFile(@Nonnull String xmlCatalogFile) {
      return ontologyBuilderFragment.xmlCatalogFile(xmlCatalogFile);
    }

    @Override
    public B ontologyReader(@Nonnull Reader reader) {
      return ontologyBuilderFragment.ontologyReader(reader);
    }

    @Override
    public B factFormat(@Nonnull String factFormat) {
      return ontologyBuilderFragment.factFormat(factFormat);
    }

    @Override
    public B factsBaseIRI(@Nonnull String factsBaseIri) {
      return ontologyBuilderFragment.factsBaseIRI(factsBaseIri);
    }

    @Override
    public B factsFile(@Nonnull String urlOrPath) {
      return ontologyBuilderFragment.factsFile(urlOrPath);
    }

    @Override
    public B factsFile(@Nonnull URL url) {
      return ontologyBuilderFragment.factsFile(url);
    }

    @Override
    public B factsFile(@Nonnull File owlFile) {
      return ontologyBuilderFragment.factsFile(owlFile);
    }

    @Override
    public B factsReader(@Nonnull Reader reader) {
      return ontologyBuilderFragment.factsReader(reader);
    }

    protected final void declareOntologyDefined() {
      if (isOntologyDefined) {
        throw new InvalidOntopConfigurationException("Ontology already defined!");
      }
      isOntologyDefined = true;
    }

    protected final MmecOntopSqlOwlApiOptions generateSqlOwlApiOptions() {
      OntopStandaloneSQLOptions standaloneSqlOptions = generateStandaloneSQLOptions();
      OntopMappingOntologyOptions mappingOntologyOptions =
          ontologyBuilderFragment.generateMappingOntologyOptions(
              standaloneSqlOptions.mappingOptions.mappingSQLOptions.mappingOptions);

      return new MmecOntopSqlOwlApiOptions(standaloneSqlOptions, mappingOntologyOptions);
    }
  }


  public static class BuilderImpl extends OwlApiBuilderMixin<BuilderImpl> {

    @Override
    public OntopSQLOWLAPIConfiguration build() {
      OntopStandaloneSQLSettings settings = new OntopStandaloneSQLSettingsImpl(generateProperties(),
          isR2rml());
      MmecOntopSqlOwlApiOptions options = generateSqlOwlApiOptions();
      return new MmecOntopSqlOwlApiConfigurationImpl(settings, options);
    }

    @Override
    protected BuilderImpl self() {
      return this;
    }
  }
}

/**
 * @file
 * @copyright @@Mmec_COPYRIGHT@@
 * @licence @@Mmec_LICENCE@@
 * @version @@Mmec_VERSION@@
 * @brief @~french Implémentation de la classe MMecConfiguration.
 * @brief @~english MMecConfiguration class implementation.
 */

package it.unibz.inf.ontop.injection.impl;

import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.MappingProperties;
import com.google.inject.Module;
import it.unibz.inf.ontop.injection.OntopStandaloneSQLSettings;
import java.util.stream.Stream;
import javax.annotation.Nonnull;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details «Detailed description of the component (optional)»
 * @par Model «Model (Abstract, automation, etc.) (optional)»
 * @par Conception «Conception description (criteria and constraints) (optional)»
 * @par Limits «Limits description (optional)»
 * @brief @~french Classe de configuration pour le module MMec
 * @par Détails S.O.
 * @par Modèle S.O.
 * @par Conception S.O.
 * @par Limites S.O.
 * @par Historique 2024-01-29 [SD] - Implémentation initiale<br>
 * @par Tâches S.O.
 */
public class MMecConfiguration extends MmecOntopSqlOwlApiConfigurationImpl {

  private final FacadeProperties facadeProperties;
  private final MappingProperties mappingProperties;

  MMecConfiguration(OntopStandaloneSQLSettings settings,
      MmecOntopSqlOwlApiOptions options, @Nonnull FacadeProperties facadeProperties,
      @Nonnull MappingProperties mappingProperties) {
    super(settings, options);

    this.facadeProperties = facadeProperties;
    this.mappingProperties = mappingProperties;
  }

  public static class MMecConfigurationBuilder
      extends OwlApiBuilderMixin<MMecConfigurationBuilder> {

    private FacadeProperties facadeProperties;
    private MappingProperties mappingProperties;

    @Override
    public MMecConfiguration build() {
      OntopStandaloneSQLSettings settings = new OntopStandaloneSQLSettingsImpl(generateProperties(),
          isR2rml());
      MmecOntopSqlOwlApiOptions options =
          generateSqlOwlApiOptions();

      return new MMecConfiguration(settings, options, facadeProperties, mappingProperties);
    }

    public MMecConfigurationBuilder facadeProperties(FacadeProperties facadeProperties) {
      this.facadeProperties = facadeProperties;
      return this;
    }

    public MMecConfigurationBuilder mappingProperties(MappingProperties mappingProperties) {
      this.mappingProperties = mappingProperties;
      return this;
    }

    @Override
    protected MMecConfigurationBuilder self() {
      return this;
    }
  }

  @Override
  protected Stream<Module> buildGuiceModules() {
    return Stream.concat(
        super.buildGuiceModules(),
        Stream.of(new MMecModule(this)));
  }

  public FacadeProperties getFacadeProperties() {
    return facadeProperties;
  }

  public MappingProperties getMappingProperties() {
    return mappingProperties;
  }
}

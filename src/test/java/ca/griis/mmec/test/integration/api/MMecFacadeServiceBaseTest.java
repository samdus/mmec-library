/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecFacadeServiceBaseTest.
 * @brief @~english MMecFacadeServiceBaseTest class implementation.
 */

package ca.griis.mmec.test.integration.api;

import ca.griis.mmec.api.MMecFacadeServiceBase;
import ca.griis.mmec.properties.ConnectionProperties;
import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.properties.FacadeType;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.properties.builder.ConnectionPropertiesBuilder;
import ca.griis.mmec.properties.builder.FacadePropertiesBuilder;
import ca.griis.mmec.properties.builder.MappingPropertiesBuilder;
import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MMecFacadeServiceBaseTest {
  private static final Path testSetPath = Paths.get("src", "test", "resources", "testset");
  private static final String mappingSchema = "MappingSchema";
  private static final String exportFilePattern = "build/tmp/test/%s_%s.sql";
  private final PostgresContainerWrapper postgresContainerWrapper =
      PostgresContainerWrapper.getInstance();
  private ConnectionPropertiesBuilder connectionPropertiesBuilder;
  private MappingPropertiesBuilder mappingPropertiesBuilder;
  private FacadePropertiesBuilder facadePropertiesBuilder;

  @BeforeEach
  public void setUp() {
    connectionPropertiesBuilder = new ConnectionPropertiesBuilder();
    mappingPropertiesBuilder = new MappingPropertiesBuilder();
    facadePropertiesBuilder = new FacadePropertiesBuilder();
  }

  private static Stream<Arguments> listTestElements() throws IOException {
    try {
      return Files.list(testSetPath)
          .filter(Files::isDirectory)
          .flatMap(file -> Arrays.stream(FacadeType.class.getEnumConstants()).map(facadeType -> {
            try {
              Path ontologyFile = null;
              Path mappingFile = null;
              String ontoRelId = file.getFileName().toString();

              try (DirectoryStream<Path> fichiers = Files.newDirectoryStream(file)) {
                for (Path fichier : fichiers) {
                  String nomFichier = fichier.getFileName().toString();
                  switch (nomFichier) {
                    case "ontology.ttl" -> ontologyFile = fichier;
                    case "mapping.ttl" -> mappingFile = fichier;
                    default -> {
                    }
                  }
                }
              }

              return Arguments.of(ontoRelId, ontologyFile, mappingFile, facadeType);
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          }));
    } catch (RuntimeException e) {
      throw (IOException) e.getCause();
    }
  }

  @ParameterizedTest
  @MethodSource("listTestElements")
  public void testApi(String ontoRelId, Path ontologyFile, Path mappingFile, FacadeType facadeType)
      throws Exception {

    ConnectionProperties connectionProperties = connectionPropertiesBuilder
        .withDriverName(postgresContainerWrapper.getDriverName())
        .withDatabaseName(postgresContainerWrapper.getDataBaseName())
        .withJdbcUrl(postgresContainerWrapper.getJdbcUrl())
        .withUsername(postgresContainerWrapper.getUsername())
        .withPassword(postgresContainerWrapper.getPassword())
        .build();

    MappingProperties mappingProperties = mappingPropertiesBuilder
        .withOntoRelId(ontoRelId)
        .withMappingSchema(mappingSchema)
        .withR2rmlMappingFilePath(mappingFile.toAbsolutePath().toString())
        .withOntologyFilePath(ontologyFile.toAbsolutePath().toString())
        .build();

    FacadeProperties facadeProperties = facadePropertiesBuilder
        .withFacadeType(facadeType)
        .build();

    MMecFacadeServiceBase facadeService = new MMecFacadeServiceBase();
    String exportFile = String.format(exportFilePattern, ontoRelId,
        facadeType.toString().toLowerCase());

    String facade = facadeService.createFacade(connectionProperties, mappingProperties,
        facadeProperties);

    Assertions.assertNotNull(facade);
    Assertions.assertFalse(facade.isEmpty());

    try (PrintWriter writer = new PrintWriter(exportFile, StandardCharsets.UTF_8)) {
      writer.write(facade);
    }
  }
}

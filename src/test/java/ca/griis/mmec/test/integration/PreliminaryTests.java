package ca.griis.mmec.test.integration;

import ca.griis.mmec.test.integration.util.OntopTester;
import ca.griis.mmec.test.integration.util.OptimizeTester;
import ca.griis.mmec.test.integration.util.R2rmlTester;
import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PreliminaryTests {
  private static final Path testSetPath = Paths.get("src", "test", "resources", "testset");
  private final PostgresContainerWrapper postgresContainerWrapper =
      PostgresContainerWrapper.getInstance();

  private static Stream<Arguments> listTestElements() throws IOException {
    try {
      return Files.list(testSetPath)
          .filter(Files::isDirectory)
          .map(file -> {
            try {
              Path ontologyFile = null;
              Path mappingFile = null;

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

              return Arguments.of(ontologyFile, mappingFile);
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          });
    } catch (RuntimeException e) {
      throw (IOException) e.getCause();
    }
  }

  @ParameterizedTest
  @MethodSource("listTestElements")
  public void testOptimize(Path ontologyFile, Path mappingFile)
      throws Exception {
    OntopTester tester = new OptimizeTester(postgresContainerWrapper,
        ontologyFile.toFile(),
        mappingFile.toFile());
    tester.runTest();
  }

  @ParameterizedTest
  @MethodSource("listTestElements")
  public void testR2RML(Path ontologyFile, Path mappingFile) throws Exception {
    OntopTester tester = new R2rmlTester(postgresContainerWrapper,
        ontologyFile.toFile(),
        mappingFile.toFile());
    tester.runTest();
  }

  @Test
  public void specificTest() throws Exception {
    OntopTester tester = new R2rmlTester(postgresContainerWrapper,
        Paths.get("src", "test", "resources", "testset", "simple", "ontology.ttl").toFile(),
        Paths.get("src", "test", "resources", "testset", "simple", "mapping.ttl").toFile());
    tester.runTest();
  }

  @Test
  public void loadContainter() throws Exception {
    System.out.printf("Simplement mettre un break point ici pour garder le container.\n"
        + "Info du container:\n%s", postgresContainerWrapper.getPropertiesForOntop().toString());
  }
}

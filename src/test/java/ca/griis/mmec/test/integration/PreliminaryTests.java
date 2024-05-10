package ca.griis.mmec.test.integration;

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
    OptimizeTester tester = new OptimizeTester(postgresContainerWrapper,
        ontologyFile.toFile(),
        mappingFile.toFile());
    tester.runTest();
  }

  @ParameterizedTest
  @MethodSource("listTestElements")
  public void testR2RML(Path ontologyFile, Path mappingFile) throws Exception {
    R2rmlTester tester = new R2rmlTester(postgresContainerWrapper,
        ontologyFile.toFile(),
        mappingFile.toFile());
    tester.runTest();
  }

  @Test
  public void specificTest() throws Exception {
    R2rmlTester tester = new R2rmlTester(postgresContainerWrapper,
        Paths.get("src", "test", "resources", "testset", "coverage", "ontology.ttl").toFile(),
        Paths.get("src", "test", "resources", "testset", "coverage", "mapping.ttl").toFile());
    tester.runTest();
  }

  @Test
  public void testWithoutMMec() throws Exception {
    R2rmlTester tester = new R2rmlTester(postgresContainerWrapper,
        Paths.get("src", "test", "resources", "testset", "basicR2RML", "ontology.ttl").toFile(),
        Paths.get("src", "test", "resources", "testset", "basicR2RML", "mapping.ttl").toFile());

    tester.testGetClassDef("http://www.griis.ca/projects/tst1");

    tester.testGetOPDef("http://www.griis.ca/projects/tst1",
        "http://www.griis.ca/projects/rel",
        "http://www.griis.ca/projects/ONTORELA_C0004X");
  }

  @Test
  public void loadContainer() throws Exception {
    System.out.println(String.format("Info du container:\n%s",
        postgresContainerWrapper.getPropertiesForOntop().toString()));
    System.out.println("Simplement mettre un break point ici pour garder le container.");
  }
}

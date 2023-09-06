package ca.griis.mmec.test.integration;

import ca.griis.mmec.test.integration.util.OntopTester;
import ca.griis.mmec.test.integration.util.TestOptimize;
import ca.griis.mmec.test.integration.util.TestR2RML;
import ca.griis.mmec.test.integration.util.dbtype.PostgresContainerWrapper;
import org.junit.After;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Optional;
import java.util.stream.Stream;

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
              Optional<Path> databaseFile = Optional.empty();
              Optional<Path> ontologyFile = Optional.empty();
              Optional<Path> mappingFile = Optional.empty();

              try (DirectoryStream<Path> fichiers = Files.newDirectoryStream(file)) {
                for (Path fichier : fichiers) {
                  String nomFichier = fichier.getFileName().toString();
                  switch (nomFichier) {
                    case "database.sql" -> databaseFile = Optional.of(fichier);
                    case "ontology.ttl" -> ontologyFile = Optional.of(fichier);
                    case "mapping.ttl" -> mappingFile = Optional.of(fichier);
                  }
                }
              }

              return Arguments.of(databaseFile, ontologyFile, mappingFile);
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
          });
    } catch (RuntimeException e) {
      throw (IOException) e.getCause();
    }
  }

  @After
  public void tearDown() throws SQLException {
    postgresContainerWrapper.resetDB();
  }

  @ParameterizedTest
  @MethodSource("listTestElements")
  public void TestOptimize(Optional<Path> databaseFile, Optional<Path> ontologyFile,
      Optional<Path> mappingFile) throws Exception {
    postgresContainerWrapper.executeSQLFile(databaseFile.orElseThrow());

    OntopTester tester = new TestOptimize(postgresContainerWrapper,
        ontologyFile.orElseThrow().toAbsolutePath().toString(),
        mappingFile.orElseThrow().toAbsolutePath().toString());
    tester.runTest();
  }

  @ParameterizedTest
  @MethodSource("listTestElements")
  public void TestR2RML(Optional<Path> databaseFile, Optional<Path> ontologyFile,
      Optional<Path> mappingFile) throws Exception {
    postgresContainerWrapper.executeSQLFile(databaseFile.orElseThrow());

    OntopTester tester = new TestR2RML(postgresContainerWrapper,
        ontologyFile.orElseThrow().toAbsolutePath().toString(),
        mappingFile.orElseThrow().toAbsolutePath().toString());
    tester.runTest();
  }
}

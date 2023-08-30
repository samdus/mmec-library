package ca.griis.mmec;

import ca.griis.base.Descripteur;
import ca.griis.base.antlr.tool.ErreurSyntaxique;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ca.griis.mmec.util.AntlrTestUtil.hasBeenParsedCompletely;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParseTreeAnalyzerTest {

  private static final String datasetPath = "src/test/resources/dataset/";
  private static final String tracePath = "build/generated/traces/";

  private static final String testMappingFile = "test_mapping.json";

  private static final String testSuiteDirectory = "testSuite1";

  private static ParseTreeAnalyzer analyzer = new ParseTreeAnalyzer();

  @SuppressWarnings("PMD.UnusedPrivateMethod")
  private static Stream<Arguments> testFileProvider() throws IOException, URISyntaxException {
    final JSONObject mapping = loadTestMapping();
    List<Arguments> testCases = new ArrayList<>();
    mapping.keySet().stream().forEach(file -> {
      JSONObject fileJson = mapping.getJSONObject(file);
      fileJson.keySet().forEach(rule -> {
        testCases.add(Arguments.of(file, rule, fileJson.getString(rule)));
      });
    });

    return testCases.stream();
  }

  private static void createDirectory(String path) throws IOException {
    File repertoire = new File(path);
    if (!repertoire.exists()) {
      boolean success = repertoire.mkdirs();
      if (!success) {
        throw new IOException("Error while creating directory: " + path + ".");
      }
    }
  }

  private static JSONObject loadTestMapping() throws IOException, URISyntaxException {
    byte[] bytes = Files.readAllBytes(
        Paths.get(ParseTreeAnalyzerTest.class.getClassLoader().getResource(testMappingFile).toURI()));
    return new JSONObject(new String(bytes, StandardCharsets.UTF_8)).getJSONObject(
        testSuiteDirectory);
  }

  @BeforeAll
  public static void createTraceDirectory() throws IOException {
    createDirectory(tracePath + testSuiteDirectory);
  }

  @ParameterizedTest(name = "{index}: GrammarTest[{0}#{1}]")
  @MethodSource("testFileProvider")
  public void grammarTest(String filename, String rule, String expectedResult) throws Exception {
    final File file = new File(datasetPath + filename + analyzer.getExtensions().get(0));

    String traceFile =
        Paths.get(tracePath + testSuiteDirectory + "/" + filename + "#" + rule).toAbsolutePath()
            .toString();

    Descripteur descriptor = new Descripteur();

    try {
      System.out.println("Chosen rule : " + rule);
      descriptor.ajouter(analyzer.analyzeNewFile(file, rule));
      ErreurSyntaxique errors = analyzer.getErrors();
      Boolean noParsingError = errors.nbErreur == 0;
      Boolean completeParsing = hasBeenParsedCompletely(file, rule);

      if (expectedResult.equals("success")) {
        assertTrue(noParsingError && completeParsing,
            String.format("%s error(s) found in the following file: %s.", errors.nbErreur,
                file.getName()));
        assertTrue(hasBeenParsedCompletely(file, rule));
      } else if (expectedResult.equals("failure")) {
        assertFalse(noParsingError && completeParsing,
            String.format("%s error(s) found in the following file: %s.", errors.nbErreur,
                file.getName()));
      } else {
        throw new AssertionError(
            String.format("%s error(s) found in the following file: %s. The file might be invalid.",
                errors.nbErreur, file.getName()));
      }
    } finally {
      System.out.print(descriptor);
      analyzer.getTrace().creerFichier(traceFile, ".trace");
      System.out.println(String.format("Trace was generated here: %s.trace", traceFile));
    }
  }
}

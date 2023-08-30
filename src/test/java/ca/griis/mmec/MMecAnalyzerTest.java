package ca.griis.mmec;

import ca.griis.mmec.jooq.gen.tables.pojos.Mmec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.NoSuchElementException;

public class MMecAnalyzerTest {
    private static final String datasetPath = "src/test/resources/dataset";
    MMecAnalyzer analyzer;

    @BeforeEach
    public void beforeEachTest() {
        analyzer = new MMecAnalyzer();
    }

    @Test
    public void TestAnalysisOfCompleteExpression() {
        analyzer.analyzeNewFile(new File(String.format("%s/000-exemple_complet.mec", datasetPath)), "mMec_document");

        Assertions.assertEquals(0, analyzer.getErrors().nbErreur);

        // TODO: Faire en sorte que les chaînes de caractères soit analysées sans les symboles de délimitation (ex: ')
        // TODO: Faire le test de composition dans JOOQ

        Mmec mMecDocument = analyzer.getMMecDocument();
        Assertions.assertEquals("'https://griis.ca/PARS3-P4:v2.1/PARS3:v1.1'", mMecDocument.getOntorelRefId());
        Assertions.assertEquals("'https://griis.ca/JeDIS'", mMecDocument.getSourceRefId());
    }

    @Test
    public void TestAnalysisOfIncompleteExpression() {
        analyzer.analyzeNewFile(new File(String.format("%s/090-discipulus-expression.mec", datasetPath)), "expression");

        Assertions.assertEquals(0, analyzer.getErrors().nbErreur);
        Assertions.assertThrows(NoSuchElementException.class, analyzer::getMMecDocument);
    }
}

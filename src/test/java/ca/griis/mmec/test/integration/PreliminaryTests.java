package ca.griis.mmec.test.integration;

import ca.griis.mmec.test.integration.util.OntopTester;
import ca.griis.mmec.test.integration.util.TestOptimize;
import ca.griis.mmec.test.integration.util.TestR2RML;
import ca.griis.mmec.test.integration.util.dbtype.Db;
import ca.griis.mmec.test.integration.util.dbtype.Postgres;
import org.junit.jupiter.api.Test;

// TODO: Retirer H2 et mettre en place Postgres TestContainers
public class PreliminaryTests {
    @Test
    public void TestOptimize() throws Exception {
        Db db = new Postgres();
        OntopTester tester = new TestOptimize(db);

        tester.initDB();
        tester.runTest();
    }

    @Test
    public void TestR2RML() throws Exception {
        Db db = new Postgres();
        OntopTester tester = new TestR2RML(db);

        tester.initDB();
        tester.runTest();
    }
}

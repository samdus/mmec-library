package ca.griis.mmec.test.integration.util.dbtype;

public class H2 extends Db {
    @Override
    public String getName() {
        return "H2";
    }

    @Override
    public String getDriver() {
        return "org.h2.Driver";
    }

    @Override
    public String getConfigFilePath() {
        return "/h2-configuration.properties";
    }
}
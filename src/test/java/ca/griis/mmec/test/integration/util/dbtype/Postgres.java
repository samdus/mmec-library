package ca.griis.mmec.test.integration.util.dbtype;

public class Postgres extends Db {
    @Override
    public String getName() {
        return "PostgreSQL";
    }

    @Override
    public String getDriver() {
        return "org.postgresql.Driver";
    }

    @Override
    public String getConfigFilePath() {
        return "/postgresql-configuration.properties";
    }
}

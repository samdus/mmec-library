package ca.griis.mmec.test.integration.util.dbtype;

import it.unibz.inf.ontop.dbschema.DBParameters;
import it.unibz.inf.ontop.dbschema.QuotedIDFactory;
import it.unibz.inf.ontop.dbschema.impl.SQLStandardQuotedIDFactory;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.model.type.DBTypeFactory;

import java.io.IOException;
import java.util.Properties;

public abstract class Db {

    public abstract String getName();
    public abstract String getDriver();
    public abstract String getConfigFilePath();

    public Properties getProperties() throws ClassNotFoundException, IOException {
        Class.forName(getDriver());

        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(getConfigFilePath()));

        return properties;
    }

    public DBParameters getDBParameters(CoreSingletons coreSingletons) {
        return new DBParameters() {
            @Override
            public QuotedIDFactory getQuotedIDFactory() {
                return new SQLStandardQuotedIDFactory();
            }

            @Override
            public DBTypeFactory getDBTypeFactory() {
                return coreSingletons.getTypeFactory().getDBTypeFactory();
            }

            @Override
            public CoreSingletons getCoreSingletons() {
                return coreSingletons;
            }

            @Override
            public String getDriverName() {
                return getDriver();
            }

            @Override
            public String getDriverVersion() {
                return null;
            }

            @Override
            public String getDbmsProductName() {
                return getName();
            }

            @Override
            public String getDbmsVersion() {
                return null;
            }
        };
    }
}

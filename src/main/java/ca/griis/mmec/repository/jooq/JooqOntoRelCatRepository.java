package ca.griis.mmec.repository.jooq;

import ca.griis.mmec.repository.OntoRelCatRepository;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.injection.OntopModelSettings;
import it.unibz.inf.ontop.injection.OntopSQLCredentialSettings;
import it.unibz.inf.ontop.injection.OntopSystemSQLSettings;
import it.unibz.inf.ontop.utils.LocalJDBCConnectionUtils;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

import ca.griis.gen.ontorelcat_ldm.ontorelcat_api_client.Routines;

import javax.inject.Inject;

public class JooqOntoRelCatRepository implements OntoRelCatRepository {

    private OntopSQLCredentialSettings settings;

    @Inject
    public JooqOntoRelCatRepository(CoreSingletons coreSingletons){
        this.settings = (OntopSQLCredentialSettings) coreSingletons.getSettings();
    }

    @Override
    public String getSQLType(String ontoRelId, String typeIri) throws SQLException {
        try (Connection connection = LocalJDBCConnectionUtils.createConnection(settings)) {
            //TODO: Support dynamic dialect
            DSLContext context = DSL.using(connection, SQLDialect.POSTGRES);
            return Routines.getSqlTypeByIri(context.configuration(), ontoRelId, typeIri);
        }
    }
}

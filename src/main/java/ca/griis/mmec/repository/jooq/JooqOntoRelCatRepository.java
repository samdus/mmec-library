package ca.griis.mmec.repository.jooq;

import ca.griis.gen.ontorelcat_ldm.ontorelcat_api_client.Routines;
import ca.griis.mmec.repository.OntoRelCatRepository;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.injection.OntopSQLCredentialSettings;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.DBTypeFactory;
import it.unibz.inf.ontop.model.type.TypeFactory;
import it.unibz.inf.ontop.utils.LocalJDBCConnectionUtils;
import java.sql.Connection;
import java.sql.SQLException;
import javax.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

public class JooqOntoRelCatRepository implements OntoRelCatRepository {

  private DBTypeFactory dbTypeFactory;
  private OntopSQLCredentialSettings settings;

  @Inject
  public JooqOntoRelCatRepository(CoreSingletons coreSingletons, TypeFactory typeFactory) {
    this.dbTypeFactory = typeFactory.getDBTypeFactory();
    this.settings = (OntopSQLCredentialSettings) coreSingletons.getSettings();
  }

  @Override
  public DBTermType getSqlType(String ontoRelId, String typeIri) throws SQLException {
    try (Connection connection = LocalJDBCConnectionUtils.createConnection(settings)) {
      // TODO: Support dynamic dialect
      DSLContext context = DSL.using(connection, SQLDialect.POSTGRES);
      String sqlType = Routines.getSqlTypeByIri(context.configuration(), ontoRelId, typeIri);

      return dbTypeFactory.getDBTermType(sqlType);
    }
  }
}

package ca.griis.mmec.repository;

import it.unibz.inf.ontop.model.type.DBTermType;
import java.sql.SQLException;
import java.util.Optional;

public interface OntoRelCatRepository {
  Optional<DBTermType> getSqlType(String ontoRelId, String typeIri) throws SQLException;
}

package ca.griis.mmec.repository;

import it.unibz.inf.ontop.model.type.DBTermType;
import java.sql.SQLException;

public interface OntoRelCatRepository {
  DBTermType getSQLType(String ontoRelId, String typeIri) throws SQLException;
}

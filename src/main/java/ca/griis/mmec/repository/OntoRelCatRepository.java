package ca.griis.mmec.repository;

import java.sql.SQLException;

public interface OntoRelCatRepository {
    String getSQLType(String ontoRelId, String typeIri) throws SQLException;
}

package ca.griis.mmec.repository;

import ca.griis.mmec.model.ontorel.ClassTable;
import ca.griis.mmec.model.ontorel.DataPropertyTable;
import ca.griis.mmec.model.ontorel.ObjectPropertyTable;
import it.unibz.inf.ontop.model.type.DBTermType;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface OntoRelCatRepository {
  Optional<DBTermType> getSqlType(String ontoRelId, String typeIri);
  List<ClassTable> getClassTables(String ontoRelId);
  List<DataPropertyTable> getDataPropertyTables(String ontoRelId);
  List<ObjectPropertyTable> getObjectPropertyTables(String ontoRelId);
}

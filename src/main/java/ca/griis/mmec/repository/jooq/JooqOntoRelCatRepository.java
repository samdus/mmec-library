package ca.griis.mmec.repository.jooq;

import ca.griis.gen.ontorelcat_ldm.ontorelcat_api_relrel.Routines;
import ca.griis.mmec.model.ontorel.ClassTable;
import ca.griis.mmec.model.ontorel.ClassTableRecord;
import ca.griis.mmec.model.ontorel.DataPropertyTable;
import ca.griis.mmec.model.ontorel.DataPropertyTableRecord;
import ca.griis.mmec.model.ontorel.ObjectPropertyTable;
import ca.griis.mmec.model.ontorel.ObjectPropertyTableRecord;
import ca.griis.mmec.repository.OntoRelCatRepository;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.DBTypeFactory;
import it.unibz.inf.ontop.model.type.TypeFactory;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;
import org.jooq.DSLContext;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details
 *      «Detailed description of the component (optional)»
 * @par Model
 *      «Model (Abstract, automation, etc.) (optional)»
 * @par Conception
 *      «Conception description (criteria and constraints) (optional)»
 * @par Limits
 *      «Limits description (optional)»
 *
 * @brief @~french Repository Jooq pour OntoRelCat
 * @par Détails
 *      S.O.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2024-05-07 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class JooqOntoRelCatRepository implements OntoRelCatRepository {

  private final DBTypeFactory dbTypeFactory;
  private final DSLContext context;
  private final String langString = "en";

  @Inject
  public JooqOntoRelCatRepository(TypeFactory typeFactory, DSLContext context) {
    this.dbTypeFactory = typeFactory.getDBTypeFactory();
    this.context = context;
  }

  @Override
  public Optional<DBTermType> getSqlType(String ontoRelId, String typeIri) {
    String sqlType = Routines.getSqlTypeByIri(context.configuration(), ontoRelId, typeIri);

    return Optional.ofNullable(sqlType)
        .map(dbTypeFactory::getDBTermType);
  }

  @Override
  public List<ClassTable> getClassTables(String ontoRelId) {
    return Routines.getClassTables(context.configuration(), ontoRelId, langString)
        .stream()
        .map(record -> new ClassTableRecord(record.getIri(), record.getLabel(), record.getIri(),
            record.getOntorelColumnId(), record.getOntorelColumnType()))
        .map(ClassTable.class::cast)
        .toList();
  }

  @Override
  public List<DataPropertyTable> getDataPropertyTables(String ontoRelId) {
    return Routines.getDataPropertyTables(context.configuration(), ontoRelId, langString)
        .stream()
        .map(record -> new DataPropertyTableRecord(record.getTableName(), record.getLabel(),
            record.getIriSubject(), record.getIriPredicate(), record.getIriValue(),
            record.getOntorelSubjectColumnId(), record.getOntorelSubjectColumnType(),
            record.getOntorelValueColumnId(), record.getOntorelValueColumnType()))
        .map(DataPropertyTable.class::cast)
        .toList();
  }

  @Override
  public List<ObjectPropertyTable> getObjectPropertyTables(String ontoRelId) {
    return Routines.getObjectPropertyTables(context.configuration(), ontoRelId, langString)
        .stream()
        .map(record -> new ObjectPropertyTableRecord(record.getTableName(), record.getLabel(),
            record.getIriSubject(), record.getIriPredicate(), record.getIriObject(),
            record.getOntorelSubjectColumnId(), record.getOntorelSubjectColumnType(),
            record.getOntorelObjectColumnId(), record.getOntorelObjectColumnType()))
        .map(ObjectPropertyTable.class::cast)
        .toList();
  }
}

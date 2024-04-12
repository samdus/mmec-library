/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe OntoRelTableMapper.
 * @brief @~english OntoRelTableMapper class implementation.
 */

package ca.griis.mmec.controller.ontop;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.mmec.model.mapped.MappedClassTable;
import ca.griis.mmec.model.mapped.MappedClassTableRecord;
import ca.griis.mmec.model.mapped.MappedDataPropertyTable;
import ca.griis.mmec.model.mapped.MappedDataPropertyTableRecord;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTable;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTableRecord;
import ca.griis.mmec.model.ontorel.ClassTable;
import ca.griis.mmec.model.ontorel.DataPropertyTable;
import ca.griis.mmec.model.ontorel.ObjectPropertyTable;
import ca.griis.mmec.properties.MappingProperties;
import com.google.common.collect.ImmutableMultimap;
import it.unibz.inf.ontop.answering.connection.OntopConnection;
import it.unibz.inf.ontop.answering.connection.OntopStatement;
import it.unibz.inf.ontop.iq.IQ;
import it.unibz.inf.ontop.query.RDF4JQueryFactory;
import it.unibz.inf.ontop.query.RDF4JSelectQuery;
import java.util.Optional;
import javax.inject.Inject;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.query.algebra.Compare;
import org.eclipse.rdf4j.query.algebra.Datatype;
import org.eclipse.rdf4j.query.algebra.Filter;
import org.eclipse.rdf4j.query.algebra.Join;
import org.eclipse.rdf4j.query.algebra.Projection;
import org.eclipse.rdf4j.query.algebra.ProjectionElem;
import org.eclipse.rdf4j.query.algebra.ProjectionElemList;
import org.eclipse.rdf4j.query.algebra.QueryRoot;
import org.eclipse.rdf4j.query.algebra.StatementPattern;
import org.eclipse.rdf4j.query.algebra.ValueConstant;
import org.eclipse.rdf4j.query.algebra.Var;
import org.eclipse.rdf4j.query.impl.MapBindingSet;
import org.eclipse.rdf4j.query.parser.ParsedTupleQuery;

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
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
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
 *      2024-04-12 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      TODO 2024-04-12 [SD] - Tester la classe<br>
 */
public class OntoRelTableMapper {
  private static final GriisLogger logger = GriisLoggerFactory.getLogger(OntoRelTableMapper.class);

  private final MappingProperties mappingProperties;
  private final RDF4JQueryFactory factrdf4JQueryFactory;
  private final SimpleValueFactory valueFactory;
  private final String schema;

  private static final String classColumnName = "uid";
  private static final String opSubjectColumnName = "sub";
  private static final String opObjectColumnName = "obj";
  private static final String dpSubjectColumnName = "sub";
  private static final String dpValColumnName = "val";

  @Inject
  public OntoRelTableMapper(MappingProperties mappingProperties,
      RDF4JQueryFactory factrdf4JQueryFactory) {
    this.mappingProperties = mappingProperties;
    this.factrdf4JQueryFactory = factrdf4JQueryFactory;
    this.valueFactory = SimpleValueFactory.getInstance();
    this.schema = mappingProperties.getMappingSchema();
  }

  public MappedClassTable map(OntopConnection connection, ClassTable classTable) {
    Optional<String> mappingExpression = Optional.empty();

    try (OntopStatement statement = connection.createStatement()) {
      StatementPattern classStatement = new StatementPattern(new Var(classColumnName),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("uid_uri",
              valueFactory.createIRI(classTable.iri()), true, true));

      QueryRoot queryRoot = new QueryRoot(classStatement);

      RDF4JSelectQuery rdf4JSelectQuery = factrdf4JQueryFactory.createSelectQuery(
          queryRoot.toString(),
          new ParsedTupleQuery(queryRoot), new MapBindingSet());
      IQ firstExecutableQuery = statement.getExecutableQuery(rdf4JSelectQuery,
          ImmutableMultimap.of());
      mappingExpression = Optional.of(firstExecutableQuery.toString());
    } catch (Exception e) {
      if (!e.getMessage().contains("IQ: EMPTY")) {
        logger.error("Error while mapping class table: " + classTable.toString(), e);
      }
    }

    return new MappedClassTableRecord(classTable, schema, mappingExpression, classColumnName);
  }

  public MappedDataPropertyTable map(OntopConnection connection,
      DataPropertyTable dataPropertyTable) {
    Optional<String> mappingExpression = Optional.empty();

    try (OntopStatement statement = connection.createStatement()) {
      StatementPattern subStatement = new StatementPattern(new Var(dpSubjectColumnName),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("sub_uri",
              valueFactory.createIRI(dataPropertyTable.iriSubject()), true, true));

      StatementPattern relStatement = new StatementPattern(new Var(dpSubjectColumnName),
          new Var("dp_uri",
              valueFactory.createIRI(dataPropertyTable.iriPredicate()), true, true),
          new Var(dpValColumnName));

      Join relJoin = new Join(subStatement, relStatement);
      Compare compare = new Compare(
          new Datatype(new Var(dpValColumnName)),
          new ValueConstant(valueFactory.createIRI(dataPropertyTable.iriValue())));
      Filter filter = new Filter(relJoin, compare);

      Projection projection = new Projection(filter,
          new ProjectionElemList(new ProjectionElem(dpSubjectColumnName),
              new ProjectionElem(dpValColumnName)));
      QueryRoot queryRoot = new QueryRoot(projection);

      RDF4JSelectQuery rdf4JSelectQuery = factrdf4JQueryFactory.createSelectQuery(
          queryRoot.toString(),
          new ParsedTupleQuery(queryRoot), new MapBindingSet());

      IQ firstExecutableQuery = statement.getExecutableQuery(rdf4JSelectQuery,
          ImmutableMultimap.of());
      mappingExpression = Optional.of(firstExecutableQuery.toString());
    } catch (Exception e) {
      if (!e.getMessage().contains("IQ: EMPTY")) {
        logger.error("Error while mapping data property table: " + dataPropertyTable.toString(), e);
      }
    }

    return new MappedDataPropertyTableRecord(dataPropertyTable, schema, mappingExpression,
        dpSubjectColumnName, dpValColumnName);
  }

  public MappedObjectPropertyTable map(OntopConnection connection,
      ObjectPropertyTable objectPropertyTable) {
    Optional<String> mappingExpression = Optional.empty();

    try (OntopStatement statement = connection.createStatement()) {
      StatementPattern subStatement = new StatementPattern(new Var(opSubjectColumnName),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("sub_uri",
              valueFactory.createIRI(objectPropertyTable.iriSubject()), true, true));

      StatementPattern objStatement = new StatementPattern(new Var(opObjectColumnName),
          new Var("rdf_type_uri",
              valueFactory.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"), true,
              true),
          new Var("obj_uri",
              valueFactory.createIRI(objectPropertyTable.iriObject()), true, true));

      StatementPattern relStatement = new StatementPattern(new Var(opSubjectColumnName),
          new Var("op_uri",
              valueFactory.createIRI(objectPropertyTable.iriPredicate()), true, true),
          new Var(opObjectColumnName));

      Join subAndObjJoin = new Join(subStatement, objStatement);
      Join relJoin = new Join(subAndObjJoin, relStatement);

      Projection projection = new Projection(relJoin,
          new ProjectionElemList(new ProjectionElem(opSubjectColumnName),
              new ProjectionElem(opObjectColumnName)));
      QueryRoot queryRoot = new QueryRoot(projection);

      RDF4JSelectQuery rdf4JSelectQuery = factrdf4JQueryFactory.createSelectQuery(
          queryRoot.toString(),
          new ParsedTupleQuery(queryRoot), new MapBindingSet());

      IQ firstExecutableQuery = statement.getExecutableQuery(rdf4JSelectQuery,
          ImmutableMultimap.of());
      mappingExpression = Optional.of(firstExecutableQuery.toString());
    } catch (Exception e) {
      if (!e.getMessage().contains("IQ: EMPTY")) {
        logger.error("Error while mapping object property table: "
            + objectPropertyTable.toString(), e);
      }
    }

    return new MappedObjectPropertyTableRecord(objectPropertyTable, schema, mappingExpression,
        opSubjectColumnName, opObjectColumnName);
  }
}

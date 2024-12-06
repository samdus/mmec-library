/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe StView.
 * @brief @~english StView class implementation.
 */

package ca.griis.mmec.view.st;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.model.MappedOntoRelTable;
import ca.griis.mmec.model.mapped.MappedClassTable;
import ca.griis.mmec.model.mapped.MappedDataPropertyTable;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTable;
import ca.griis.mmec.properties.FacadeProperties;
import ca.griis.mmec.view.MappedOntoRelTableView;
import com.google.inject.Inject;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

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
 * @brief @~french MappedOntoRelTableView basées sur StringTemplate
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
 *      S.O.
 */
public class StMappedOntoRelTableView implements MappedOntoRelTableView {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(StMappedOntoRelTableView.class);

  public static final String classTemplateName = "class";
  private static final String emptyClassTemplateName = "class_empty";
  public static final String opTemplateName = "object_property";
  public static final String emptyOpTemplateName = "object_property_empty";
  public static final String dpTemplateName = "data_property";
  public static final String emptyDpTemplateName = "data_property_empty";

  STGroup group;

  @Inject
  public StMappedOntoRelTableView(FacadeProperties facadeProperties) {
    this.group = new STGroupFile(facadeProperties.getFacadeStgUrl());
  }

  @Override
  public String getExpression(MappedClassTable mappedClassTable) {
    logger.trace(Trace.ENTER_METHOD_1, mappedClassTable);

    ST st = initialiseStWithQueryIfPresent(mappedClassTable, classTemplateName,
        emptyClassTemplateName);

    st.add("comment", mappedClassTable.label());
    st.add("schema_id", mappedClassTable.schema());
    st.add("ontorel_table_id", mappedClassTable.tableName());
    st.add("mmec_query_column_id", mappedClassTable.mmecQueryColumnId());
    st.add("ontorel_column_id", mappedClassTable.ontorelColumnId());
    st.add("ontorel_column_type", mappedClassTable.ontorelColumnType());

    return st.render();
  }

  @Override
  public String getExpression(MappedObjectPropertyTable mappedObjectPropertyTable) {
    logger.trace(Trace.ENTER_METHOD_1, mappedObjectPropertyTable);

    ST st = initialiseStWithQueryIfPresent(mappedObjectPropertyTable, opTemplateName,
        emptyOpTemplateName);

    st.add("comment", mappedObjectPropertyTable.label());
    st.add("schema_id", mappedObjectPropertyTable.schema());
    st.add("ontorel_table_id", mappedObjectPropertyTable.tableName());
    st.add("mmec_query_column_id_subject", mappedObjectPropertyTable.mmecQuerySubjectColumnId());
    st.add("mmec_query_column_id_object", mappedObjectPropertyTable.mmecQueryObjectColumnId());
    st.add("ontorel_column_id_subject", mappedObjectPropertyTable.ontorelSubjectColumnId());
    st.add("ontorel_column_type_subject", mappedObjectPropertyTable.ontorelSubjectColumnType());
    st.add("ontorel_column_id_object", mappedObjectPropertyTable.ontorelObjectColumnId());
    st.add("ontorel_column_type_object", mappedObjectPropertyTable.ontorelObjectColumnType());

    return st.render();
  }

  @Override
  public String getExpression(MappedDataPropertyTable mappedDataPropertyTable) {
    logger.trace(Trace.ENTER_METHOD_1, mappedDataPropertyTable);

    ST st = initialiseStWithQueryIfPresent(mappedDataPropertyTable, dpTemplateName,
        emptyDpTemplateName);

    st.add("comment", mappedDataPropertyTable.label());
    st.add("schema_id", mappedDataPropertyTable.schema());
    st.add("ontorel_table_id", mappedDataPropertyTable.tableName());
    st.add("mmec_query_column_id_subject", mappedDataPropertyTable.mmecQuerySubjectColumnId());
    st.add("mmec_query_column_id_value", mappedDataPropertyTable.mmecQueryValueColumnId());
    st.add("ontorel_column_id_subject", mappedDataPropertyTable.ontorelSubjectColumnId());
    st.add("ontorel_column_type_subject", mappedDataPropertyTable.ontorelSubjectColumnType());
    st.add("ontorel_column_id_value", mappedDataPropertyTable.ontorelValueColumnId());
    st.add("ontorel_column_type_value", mappedDataPropertyTable.ontorelValueColumnType());

    return st.render();
  }

  private ST initialiseStWithQueryIfPresent(MappedOntoRelTable mappedOntoRelTable, String template,
      String emptyTemplate) {
    logger.trace(Trace.ENTER_METHOD_2, mappedOntoRelTable, template);

    ST st;
    if (mappedOntoRelTable.mmecQuery().isPresent()) {
      st = group.getInstanceOf(template);
      st.add("query", mappedOntoRelTable.mmecQuery().get());
    } else {
      st = group.getInstanceOf(emptyTemplate);
    }
    return st;
  }
}

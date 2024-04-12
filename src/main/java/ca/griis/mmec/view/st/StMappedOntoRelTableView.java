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

import ca.griis.mmec.model.mapped.MappedClassTableRecord;
import ca.griis.mmec.model.mapped.MappedDataPropertyTableRecord;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTableRecord;
import ca.griis.mmec.view.MappedOntoRelTableView;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

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
  public static final String classTemplateName = "class";
  public static final String opTemplateName = "object_property";
  public static final String dpTemplateName = "data_property";

  STGroup group;

  public StMappedOntoRelTableView(STGroup group) {
    this.group = group;
  }

  @Override
  public String getExpression(MappedClassTableRecord mappedClassTable) {
    ST st = group.getInstanceOf(classTemplateName);

    st.add("comment", mappedClassTable.label());
    st.add("schema_id", mappedClassTable.schema());
    st.add("ontorel_table_id", mappedClassTable.tableName());
    st.add("mmec_query_column_id", mappedClassTable.mmecQueryColumnId());
    st.add("ontorel_column_id", mappedClassTable.ontorelColumnId());
    st.add("query", mappedClassTable.mmecQuery());

    return st.render();
  }

  @Override
  public String getExpression(MappedObjectPropertyTableRecord mappedObjectPropertyTable) {
    ST st = group.getInstanceOf(opTemplateName);

    st.add("comment", mappedObjectPropertyTable.label());
    st.add("schema_id", mappedObjectPropertyTable.schema());
    st.add("ontorel_table_id", mappedObjectPropertyTable.tableName());
    st.add("mmec_query_column_id_subject", mappedObjectPropertyTable.mmecQuerySubjectColumnId());
    st.add("mmec_query_column_id_object", mappedObjectPropertyTable.mmecQueryObjectColumnId());
    st.add("ontorel_column_id_subject", mappedObjectPropertyTable.ontorelSubjectColumnId());
    st.add("ontorel_column_id_object", mappedObjectPropertyTable.ontorelObjectColumnId());
    st.add("query", mappedObjectPropertyTable.mmecQuery());

    return st.render();
  }

  @Override
  public String getExpression(MappedDataPropertyTableRecord mappedDataPropertyTable) {
    ST st = group.getInstanceOf(dpTemplateName);

    st.add("comment", mappedDataPropertyTable.label());
    st.add("schema_id", mappedDataPropertyTable.schema());
    st.add("ontorel_table_id", mappedDataPropertyTable.tableName());
    st.add("mmec_query_column_id_subject", mappedDataPropertyTable.mmecQuerySubjectColumnId());
    st.add("mmec_query_column_id_value", mappedDataPropertyTable.mmecQueryValueColumnId());
    st.add("ontorel_column_id_subject", mappedDataPropertyTable.ontorelSubjectColumnId());
    st.add("ontorel_column_id_value", mappedDataPropertyTable.ontorelValueColumnId());
    st.add("query", mappedDataPropertyTable.mmecQuery());

    return st.render();
  }
}

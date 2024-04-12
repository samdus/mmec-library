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

import ca.griis.mmec.model.MappedClassTable;
import ca.griis.mmec.model.MappedDPTable;
import ca.griis.mmec.model.MappedOPTable;
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
  public String getExpression(MappedClassTable mappedClassTable) {
    ST st = group.getInstanceOf(classTemplateName);

    st.add("comment", mappedClassTable.comment());
    st.add("schema_id", mappedClassTable.schema());
    st.add("ontorel_table_id", mappedClassTable.tableName());
    st.add("mmec_query_column_id", mappedClassTable.mmecQueryColumnId());
    st.add("ontorel_column_id", mappedClassTable.ontorelColumnId());
    st.add("query", mappedClassTable.mmecQuery());

    return st.render();
  }

  @Override
  public String getExpression(MappedOPTable mappedOPTable) {
    ST st = group.getInstanceOf(opTemplateName);

    st.add("comment", mappedOPTable.comment());
    st.add("schema_id", mappedOPTable.schema());
    st.add("ontorel_table_id", mappedOPTable.tableName());
    st.add("mmec_query_column_id_subject", mappedOPTable.mmecQuerySubjectColumnId());
    st.add("mmec_query_column_id_object", mappedOPTable.mmecQueryObjectColumnId());
    st.add("ontorel_column_id_subject", mappedOPTable.ontorelSubjectColumnId());
    st.add("ontorel_column_id_object", mappedOPTable.ontorelObjectColumnId());
    st.add("query", mappedOPTable.mmecQuery());

    return st.render();
  }

  @Override
  public String getExpression(MappedDPTable mappedDPTable) {
    ST st = group.getInstanceOf(dpTemplateName);

    st.add("comment", mappedDPTable.comment());
    st.add("schema_id", mappedDPTable.schema());
    st.add("ontorel_table_id", mappedDPTable.tableName());
    st.add("mmec_query_column_id_subject", mappedDPTable.mmecQuerySubjectColumnId());
    st.add("mmec_query_column_id_value", mappedDPTable.mmecQueryValueColumnId());
    st.add("ontorel_column_id_subject", mappedDPTable.ontorelSubjectColumnId());
    st.add("ontorel_column_id_value", mappedDPTable.ontorelValueColumnId());
    st.add("query", mappedDPTable.mmecQuery());

    return st.render();
  }
}

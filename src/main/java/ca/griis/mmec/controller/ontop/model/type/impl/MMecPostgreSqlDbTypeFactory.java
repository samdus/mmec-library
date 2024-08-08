/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecPostgreSQLDBTypeFactory.
 * @brief @~english MMecPostgreSQLDBTypeFactory class implementation.
 */

package ca.griis.mmec.controller.ontop.model.type.impl;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TypeFactory;
import it.unibz.inf.ontop.model.type.impl.PostgreSQLDBTypeFactory;
import java.util.regex.Pattern;

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
 * @brief @~french Implémentation mMec de la classe des types PostgresSQL
 * @par Détails
 *      Le modèle initial fait toujours le toupper pour les noms de type et c'est à
 *      éviter lorsque le nom du type contient des guillemets.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2024-08-07 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecPostgreSqlDbTypeFactory extends PostgreSQLDBTypeFactory {

  private static final Pattern OPTIONAL_LENGTH = Pattern.compile("\\([\\d, ]+\\)");

  @AssistedInject
  protected MMecPostgreSqlDbTypeFactory(@Assisted TermType rootTermType,
      @Assisted TypeFactory typeFactory) {
    super(rootTermType, typeFactory);
  }

  @Override
  protected String preprocessTypeName(String typeName) {
    String preprocessed = OPTIONAL_LENGTH.matcher(typeName).replaceAll("");
    if (!preprocessed.contains("\"")) {
      preprocessed = preprocessed.toUpperCase();
    }
    return preprocessed;
  }

  @Override
  protected String preprocessTypeName(String typeName, int columnSize) {
    String preprocessed = OPTIONAL_LENGTH.matcher(typeName).replaceAll("");
    if (!preprocessed.contains("\"")) {
      preprocessed = preprocessed.toUpperCase();
    }
    return preprocessed;
  }
}

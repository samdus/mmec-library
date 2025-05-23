/**
 * @file
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 * @version 1.2.0
 * @brief @~french Implémentation de la classe MMecPostgreSQLDBTypeFactory.
 * @brief @~english MMecPostgreSQLDBTypeFactory class implementation.
 */

package ca.griis.mmec.controller.ontop.model.type.impl;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
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

  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecPostgreSqlDbTypeFactory.class);
  private static final Pattern OPTIONAL_LENGTH = Pattern.compile("\\([\\d, ]+\\)");

  @AssistedInject
  protected MMecPostgreSqlDbTypeFactory(@Assisted TermType rootTermType,
      @Assisted TypeFactory typeFactory) {
    super(rootTermType, typeFactory);
  }

  @Override
  protected String preprocessTypeName(String typeName) {
    logger.trace(Trace.ENTER_METHOD_1, typeName);

    String preprocessed = OPTIONAL_LENGTH.matcher(typeName).replaceAll("");
    if (!preprocessed.contains("\"")) {
      preprocessed = preprocessed.toUpperCase();
    }
    return preprocessed;
  }

  @Override
  protected String preprocessTypeName(String typeName, int columnSize) {
    logger.trace(Trace.ENTER_METHOD_2, typeName, columnSize);

    String preprocessed = OPTIONAL_LENGTH.matcher(typeName).replaceAll("");
    if (!preprocessed.contains("\"")) {
      preprocessed = preprocessed.toUpperCase();
    }
    return preprocessed;
  }
}

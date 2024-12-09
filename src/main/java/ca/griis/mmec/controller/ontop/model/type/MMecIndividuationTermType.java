/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecIndividuationTermType.
 * @brief @~english MMecIndividuationTermType class implementation.
 */

package ca.griis.mmec.controller.ontop.model.type;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.ObjectRDFType;
import it.unibz.inf.ontop.model.type.RDFDatatype;
import it.unibz.inf.ontop.model.type.TermTypeAncestry;
import it.unibz.inf.ontop.model.type.impl.RDFTermTypeImpl;
import java.util.Optional;

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
 * @brief @~french Type pour le terme d'individuation.
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
 *      2024-03-01 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecIndividuationTermType extends RDFTermTypeImpl implements ObjectRDFType,
    DBTermType {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecIndividuationTermType.class);
  private final DBTermType individuationType;

  public MMecIndividuationTermType(TermTypeAncestry parentAncestry,
      DBTermType individuationType) {
    super("ID", parentAncestry, factory -> individuationType);
    this.individuationType = individuationType;
  }

  @Override
  public boolean isBlankNode() {
    logger.trace(Trace.ENTER_METHOD_0);
    return false;
  }

  @Override
  public String getName() {
    logger.trace(Trace.ENTER_METHOD_0);
    return individuationType.getName();
  }

  @Override
  public String getCastName() {
    logger.trace(Trace.ENTER_METHOD_0);
    return individuationType.getCastName();
  }

  @Override
  public Category getCategory() {
    logger.trace(Trace.ENTER_METHOD_0);
    return individuationType.getCategory();
  }

  @Override
  public Optional<RDFDatatype> getNaturalRDFDatatype() {
    logger.trace(Trace.ENTER_METHOD_0);
    return individuationType.getNaturalRDFDatatype();
  }

  @Override
  public boolean isNeedingIRISafeEncoding() {
    logger.trace(Trace.ENTER_METHOD_0);
    return individuationType.isNeedingIRISafeEncoding();
  }

  @Override
  public boolean areEqualitiesStrict() {
    logger.trace(Trace.ENTER_METHOD_0);
    return individuationType.areEqualitiesStrict();
  }

  @Override
  public Optional<Boolean> areEqualitiesStrict(DBTermType otherType) {
    logger.trace(Trace.ENTER_METHOD_1, otherType);
    return individuationType.areEqualitiesStrict(otherType);
  }

  @Override
  public boolean areEqualitiesBetweenTwoDBAttributesStrict() {
    logger.trace(Trace.ENTER_METHOD_0);
    return individuationType.areEqualitiesBetweenTwoDBAttributesStrict();
  }

  @Override
  public Optional<Boolean> isValidLexicalValue(String lexicalValue) {
    logger.trace(Trace.ENTER_METHOD_1, lexicalValue);
    return individuationType.isValidLexicalValue(lexicalValue);
  }

  @Override
  public boolean isPreventDistinctRecommended() {
    logger.trace(Trace.ENTER_METHOD_0);
    return individuationType.isPreventDistinctRecommended();
  }

  @Override
  public final boolean equals(Object other) {
    logger.trace(Trace.ENTER_METHOD_1, other);
    return other instanceof MMecIndividuationTermType otherTerm &&
        this.getName().equals(otherTerm.getName());
  }

  @Override
  public final int hashCode() {
    logger.trace(Trace.ENTER_METHOD_0);
    return this.getName().hashCode();
  }
}

/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecIndividuationTermType.
 * @brief @~english MMecIndividuationTermType class implementation.
 */

package ca.griis.mmec.controller.ontop.model.type;

import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.ObjectRDFType;
import it.unibz.inf.ontop.model.type.RDFDatatype;
import it.unibz.inf.ontop.model.type.TermTypeAncestry;
import it.unibz.inf.ontop.model.type.impl.RDFTermTypeImpl;
import java.util.Arrays;
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

  private final DBTermType individuationType;

  public MMecIndividuationTermType(TermTypeAncestry parentAncestry,
      DBTermType individuationType) {
    super("ID", parentAncestry, factory -> individuationType);
    this.individuationType = individuationType;
  }

  @Override
  public boolean isBlankNode() {
    return false;
  }

  @Override
  public String getName() {
    return individuationType.getName();
  }

  @Override
  public String getCastName() {
    return individuationType.getCastName();
  }

  @Override
  public Category getCategory() {
    return individuationType.getCategory();
  }

  @Override
  public Optional<RDFDatatype> getNaturalRDFDatatype() {
    return individuationType.getNaturalRDFDatatype();
  }

  @Override
  public boolean isNeedingIRISafeEncoding() {
    return individuationType.isNeedingIRISafeEncoding();
  }

  @Override
  public boolean areEqualitiesStrict() {
    return individuationType.areEqualitiesStrict();
  }

  @Override
  public Optional<Boolean> areEqualitiesStrict(DBTermType otherType) {
    return individuationType.areEqualitiesStrict(otherType);
  }

  @Override
  public boolean areEqualitiesBetweenTwoDBAttributesStrict() {
    return individuationType.areEqualitiesBetweenTwoDBAttributesStrict();
  }

  @Override
  public Optional<Boolean> isValidLexicalValue(String lexicalValue) {
    return individuationType.isValidLexicalValue(lexicalValue);
  }

  @Override
  public boolean isPreventDistinctRecommended() {
    return individuationType.isPreventDistinctRecommended();
  }

  @Override
  public final boolean equals(Object other) {
    return super.equals(other)
        && other instanceof MMecIndividuationTermType otherTermType
        && this.individuationType.equals(otherTermType.individuationType);
  }

  @Override
  public final int hashCode() {
    return Arrays.hashCode(new Object[] {
        super.hashCode(),
        individuationType
    });
  }
}

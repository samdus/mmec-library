/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe DBValueTermType.
 * @brief @~english DBValueTermType class implementation.
 */
package ca.griis.mmec.controller.ontop.model.type;

import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.DBTypeFactory;
import it.unibz.inf.ontop.model.type.LanguageTag;
import it.unibz.inf.ontop.model.type.RDFDatatype;
import it.unibz.inf.ontop.model.type.RDFTermType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TermTypeAncestry;
import it.unibz.inf.ontop.model.type.impl.SimpleRDFDatatype;
import java.util.Optional;
import org.apache.commons.rdf.api.IRI;

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
 * @brief @~french Type de terme à la fois RDF et DB
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
public class DBValueTermType implements DBTermType, RDFDatatype {
  private final RDFDatatype innerRDFTermType;
  private final DBTermType innerDBTermType;

  public DBValueTermType(RDFDatatype innerRDFTermType, DBTermType innerDBTermType) {
    this.innerRDFTermType = innerRDFTermType;
    this.innerDBTermType = innerDBTermType;
  }

  // Overloaded methods with a custom behavior

  @Override
  public boolean isAbstract() {
    return false;
  }

  @Override
  public DBTermType getClosestDBType(DBTypeFactory dbTypeFactory)
      throws UnsupportedOperationException {
    return innerDBTermType;
  }

  @Override
  public Optional<RDFDatatype> getNaturalRDFDatatype() {
    return Optional.of(innerRDFTermType);
  }

  // Delegated methods

  @Override
  public String getName() {
    return innerDBTermType.getName();
  }

  @Override
  public String getCastName() {
    return innerDBTermType.getCastName();
  }

  @Override
  public Category getCategory() {
    return innerDBTermType.getCategory();
  }

  @Override
  public boolean isNeedingIRISafeEncoding() {
    return innerDBTermType.isNeedingIRISafeEncoding();
  }

  @Override
  public boolean areEqualitiesStrict() {
    return innerDBTermType.areEqualitiesStrict();
  }

  @Override
  public Optional<Boolean> areEqualitiesStrict(DBTermType otherType) {
    return innerDBTermType.areEqualitiesStrict(otherType);
  }

  @Override
  public boolean areEqualitiesBetweenTwoDBAttributesStrict() {
    return innerDBTermType.areEqualitiesBetweenTwoDBAttributesStrict();
  }

  @Override
  public Optional<Boolean> isValidLexicalValue(String lexicalValue) {
    return innerDBTermType.isValidLexicalValue(lexicalValue);
  }

  @Override
  public boolean isPreventDistinctRecommended() {
    return innerDBTermType.isPreventDistinctRecommended();
  }

  @Override
  public boolean isA(TermType otherTermType) {
    return innerRDFTermType.isA(otherTermType);
  }

  @Override
  public TermType getCommonDenominator(TermType otherTermType) {
    return innerRDFTermType.getCommonDenominator(otherTermType);
  }

  @Override
  public TermTypeAncestry getAncestry() {
    return innerRDFTermType.getAncestry();
  }

  @Override
  public Optional<LanguageTag> getLanguageTag() {
    return innerRDFTermType.getLanguageTag();
  }

  @Override
  public boolean isA(IRI baseDatatypeIri) {
    return innerRDFTermType.isA(baseDatatypeIri);
  }

  @Override
  public IRI getIRI() {
    return innerRDFTermType.getIRI();
  }
}

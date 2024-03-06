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
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TermTypeAncestry;
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
public class DbValueTermType implements DBTermType, RDFDatatype {
  private final RDFDatatype innerRdfTermType;
  private final DBTermType innerDbTermType;

  public DbValueTermType(RDFDatatype innerRdfTermType, DBTermType innerDbTermType) {
    this.innerRdfTermType = innerRdfTermType;
    this.innerDbTermType = innerDbTermType;
  }

  // Overloaded methods with a custom behavior

  @Override
  public boolean isAbstract() {
    return false;
  }

  @Override
  public DBTermType getClosestDBType(DBTypeFactory dbTypeFactory)
      throws UnsupportedOperationException {
    return innerDbTermType;
  }

  @Override
  public Optional<RDFDatatype> getNaturalRDFDatatype() {
    return Optional.of(innerRdfTermType);
  }

  // Delegated methods

  @Override
  public String getName() {
    return innerDbTermType.getName();
  }

  @Override
  public String getCastName() {
    return innerDbTermType.getCastName();
  }

  @Override
  public Category getCategory() {
    return innerDbTermType.getCategory();
  }

  @Override
  public boolean isNeedingIRISafeEncoding() {
    return innerDbTermType.isNeedingIRISafeEncoding();
  }

  @Override
  public boolean areEqualitiesStrict() {
    return innerDbTermType.areEqualitiesStrict();
  }

  @Override
  public Optional<Boolean> areEqualitiesStrict(DBTermType otherType) {
    return innerDbTermType.areEqualitiesStrict(otherType);
  }

  @Override
  public boolean areEqualitiesBetweenTwoDBAttributesStrict() {
    return innerDbTermType.areEqualitiesBetweenTwoDBAttributesStrict();
  }

  @Override
  public Optional<Boolean> isValidLexicalValue(String lexicalValue) {
    return innerDbTermType.isValidLexicalValue(lexicalValue);
  }

  @Override
  public boolean isPreventDistinctRecommended() {
    return innerDbTermType.isPreventDistinctRecommended();
  }

  @Override
  public TermType getCommonDenominator(TermType otherTermType) {
    return innerRdfTermType.getCommonDenominator(otherTermType);
  }

  @Override
  public TermTypeAncestry getAncestry() {
    return innerRdfTermType.getAncestry();
  }

  @Override
  public Optional<LanguageTag> getLanguageTag() {
    return innerRdfTermType.getLanguageTag();
  }

  @Override
  public boolean isA(TermType otherTermType) {
    return innerRdfTermType.isA(otherTermType);
  }

  @Override
  public boolean isA(IRI baseDatatypeIri) {
    return innerRdfTermType.isA(baseDatatypeIri);
  }

  @Override
  public IRI getIRI() {
    return innerRdfTermType.getIRI();
  }
}

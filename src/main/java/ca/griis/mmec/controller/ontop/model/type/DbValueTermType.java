/**
 * @file
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 * @version 1.2.0
 * @brief @~french Implémentation de la classe DBValueTermType.
 * @brief @~english DBValueTermType class implementation.
 */

package ca.griis.mmec.controller.ontop.model.type;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
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
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(DbValueTermType.class);
  private final RDFDatatype innerRdfTermType;
  private final DBTermType innerDbTermType;

  public DbValueTermType(RDFDatatype innerRdfTermType, DBTermType innerDbTermType) {
    this.innerRdfTermType = innerRdfTermType;
    this.innerDbTermType = innerDbTermType;
  }

  // Overloaded methods with a custom behavior

  @Override
  public boolean isAbstract() {
    logger.trace(Trace.ENTER_METHOD_0);
    return false;
  }

  @Override
  public DBTermType getClosestDBType(DBTypeFactory dbTypeFactory)
      throws UnsupportedOperationException {
    logger.trace(Trace.ENTER_METHOD_1, dbTypeFactory);
    return innerDbTermType;
  }

  @Override
  public Optional<RDFDatatype> getNaturalRDFDatatype() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Optional.of(innerRdfTermType);
  }

  // Delegated methods

  @Override
  public String getName() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerDbTermType.getName();
  }

  @Override
  public String getCastName() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerDbTermType.getCastName();
  }

  @Override
  public Category getCategory() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerDbTermType.getCategory();
  }

  @Override
  public boolean isNeedingIRISafeEncoding() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerDbTermType.isNeedingIRISafeEncoding();
  }

  @Override
  public boolean areEqualitiesStrict() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerDbTermType.areEqualitiesStrict();
  }

  @Override
  public Optional<Boolean> areEqualitiesStrict(DBTermType otherType) {
    logger.trace(Trace.ENTER_METHOD_1, otherType);
    return innerDbTermType.areEqualitiesStrict(otherType);
  }

  @Override
  public boolean areEqualitiesBetweenTwoDBAttributesStrict() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerDbTermType.areEqualitiesBetweenTwoDBAttributesStrict();
  }

  @Override
  public Optional<Boolean> isValidLexicalValue(String lexicalValue) {
    logger.trace(Trace.ENTER_METHOD_1, lexicalValue);
    return innerDbTermType.isValidLexicalValue(lexicalValue);
  }

  @Override
  public boolean isPreventDistinctRecommended() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerDbTermType.isPreventDistinctRecommended();
  }

  @Override
  public TermType getCommonDenominator(TermType otherTermType) {
    logger.trace(Trace.ENTER_METHOD_1, otherTermType);
    return innerRdfTermType.getCommonDenominator(otherTermType);
  }

  @Override
  public TermTypeAncestry getAncestry() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerRdfTermType.getAncestry();
  }

  @Override
  public Optional<LanguageTag> getLanguageTag() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerRdfTermType.getLanguageTag();
  }

  @Override
  public boolean isA(TermType otherTermType) {
    logger.trace(Trace.ENTER_METHOD_1, otherTermType);
    return innerRdfTermType.isA(otherTermType);
  }

  @Override
  public boolean isA(IRI baseDatatypeIri) {
    logger.trace(Trace.ENTER_METHOD_1, baseDatatypeIri);
    return innerRdfTermType.isA(baseDatatypeIri);
  }

  @Override
  public IRI getIRI() {
    logger.trace(Trace.ENTER_METHOD_0);
    return innerRdfTermType.getIRI();
  }
}

/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecTermFactoryImpl.
 * @brief @~english MMecTermFactoryImpl class implementation.
 */

package ca.griis.mmec.controller.ontop.model.term;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecSqlDbFunctionSymbolFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingConversion;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import it.unibz.inf.ontop.iq.node.VariableNullability;
import it.unibz.inf.ontop.iq.tools.TypeConstantDictionary;
import it.unibz.inf.ontop.model.template.Template;
import it.unibz.inf.ontop.model.term.BNode;
import it.unibz.inf.ontop.model.term.Constant;
import it.unibz.inf.ontop.model.term.DBConstant;
import it.unibz.inf.ontop.model.term.IRIConstant;
import it.unibz.inf.ontop.model.term.ImmutableExpression;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.NonFunctionalTerm;
import it.unibz.inf.ontop.model.term.NonGroundFunctionalTerm;
import it.unibz.inf.ontop.model.term.RDFConstant;
import it.unibz.inf.ontop.model.term.RDFLiteralConstant;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.functionsymbol.BooleanFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.FunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.InequalityLabel;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBFunctionSymbolFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.db.IRIStringTemplateFunctionSymbol;
import it.unibz.inf.ontop.model.term.impl.TermFactoryImpl;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.RDFDatatype;
import it.unibz.inf.ontop.model.type.RDFTermType;
import it.unibz.inf.ontop.model.type.TermType;
import it.unibz.inf.ontop.model.type.TypeFactory;
import it.unibz.inf.ontop.substitution.Substitution;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Stream;
import org.apache.commons.rdf.api.IRI;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details «Detailed description of the component (optional)»
 * @par Model «Model (Abstract, automation, etc.) (optional)»
 * @par Conception «Conception description (criteria and constraints) (optional)»
 * @par Limits «Limits description (optional)»
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
 * @par Détails S.O.
 * @par Modèle S.O.
 * @par Conception S.O.
 * @par Limites S.O.
 * @par Historique 2024-01-09 [SD] - Implémentation initiale<br>
 * @par Tâches S.O.
 */
public class MMecTermFactory implements TermFactory {

  private final TermFactory defaultTermFactory;

  @Inject
  public MMecTermFactory(TermFactoryImpl defaultTermFactory) {
    this.defaultTermFactory = defaultTermFactory;
  }

  public NonGroundFunctionalTerm getMMecSignatureFunction(
      ImmutableList<TermType> argTypes,
      ImmutableList<? extends ImmutableTerm> terms) {
    return defaultTermFactory.getNonGroundFunctionalTerm(
        getMMecDbFunctionSymbolFactory().createMMecIndividuationFunctionSymbol(argTypes),
        terms.toArray(new ImmutableTerm[0]));
  }

  public NonGroundFunctionalTerm getMMecSimpleCastFunctionalTerm(DBTermType inputType,
      DBTermType targetType, ImmutableTerm term) {
    return defaultTermFactory.getNonGroundFunctionalTerm(
        getMMecDbFunctionSymbolFactory().createMMecSimpleConversionFunctionSymbol(inputType,
            targetType),
        term);
  }

  public NonGroundFunctionalTerm getMMecConversionFunction(ImmutableTerm variable,
      MMecMappingConversion conversion) {
    return defaultTermFactory.getNonGroundFunctionalTerm(
        conversion.getConversionFunction().orElseThrow(),
        variable);
  }

  public NonGroundFunctionalTerm getMMecConversionValidationFunction(ImmutableTerm variable,
      MMecMappingConversion conversion) {
    return defaultTermFactory.getNonGroundFunctionalTerm(
        conversion.getValidationFunction().orElseThrow(),
        variable);
  }

  public NonGroundFunctionalTerm getMMecValueFunction(ImmutableTerm variable,
      DBTermType variableType, RDFTermTypeConstant rdfTermTypeConstant) {
    return defaultTermFactory.getNonGroundFunctionalTerm(
        getMMecDbFunctionSymbolFactory().createMMecValueFunctionSymbol(variableType,
            rdfTermTypeConstant), variable, rdfTermTypeConstant);
  }

  private MMecSqlDbFunctionSymbolFactory getMMecDbFunctionSymbolFactory() {
    return (MMecSqlDbFunctionSymbolFactory) defaultTermFactory.getDBFunctionSymbolFactory();
  }

  // The following methods are just delegating to the default term factory
  @Override
  public ImmutableExpression getImmutableExpression(BooleanFunctionSymbol functor,
      ImmutableTerm... arguments) {
    return defaultTermFactory.getImmutableExpression(functor, arguments);
  }

  @Override
  public ImmutableExpression getImmutableExpression(BooleanFunctionSymbol functor,
      ImmutableList<? extends ImmutableTerm> arguments) {
    return defaultTermFactory.getImmutableExpression(functor, arguments);
  }

  @Override
  public ImmutableExpression getConjunction(
      ImmutableList<ImmutableExpression> nonEmptyExpressionList) {
    return defaultTermFactory.getConjunction(nonEmptyExpressionList);
  }

  @Override
  public ImmutableExpression getConjunction(ImmutableExpression expression,
      ImmutableExpression... otherExpressions) {
    return defaultTermFactory.getConjunction(expression, otherExpressions);
  }

  @Override
  public Optional<ImmutableExpression> getConjunction(
      Stream<ImmutableExpression> expressionStream) {
    return defaultTermFactory.getConjunction(expressionStream);
  }

  @Override
  public Optional<ImmutableExpression> getConjunction(
      Optional<ImmutableExpression> optionalExpression,
      Stream<ImmutableExpression> expressionStream) {
    return defaultTermFactory.getConjunction(optionalExpression, expressionStream);
  }

  @Override
  public ImmutableExpression getDisjunction(
      ImmutableList<ImmutableExpression> nonEmptyExpressionList) {
    return defaultTermFactory.getDisjunction(nonEmptyExpressionList);
  }

  @Override
  public ImmutableExpression getDisjunction(ImmutableExpression expression,
      ImmutableExpression... otherExpressions) {
    return defaultTermFactory.getDisjunction(expression, otherExpressions);
  }

  @Override
  public Optional<ImmutableExpression> getDisjunction(Stream<ImmutableExpression> expressions) {
    return defaultTermFactory.getDisjunction(expressions);
  }

  @Override
  public ImmutableExpression getDBNot(ImmutableExpression expression) {
    return defaultTermFactory.getDBNot(expression);
  }

  @Override
  public ImmutableExpression getFalseOrNullFunctionalTerm(
      ImmutableList<ImmutableExpression> arguments) {
    return defaultTermFactory.getFalseOrNullFunctionalTerm(arguments);
  }

  @Override
  public ImmutableExpression getTrueOrNullFunctionalTerm(
      ImmutableList<ImmutableExpression> arguments) {
    return defaultTermFactory.getTrueOrNullFunctionalTerm(arguments);
  }

  @Override
  public ImmutableExpression getIsAExpression(ImmutableTerm termTypeTerm, RDFTermType baseType) {
    return defaultTermFactory.getIsAExpression(termTypeTerm, baseType);
  }

  @Override
  public ImmutableExpression getAreCompatibleRDFStringExpression(ImmutableTerm typeTerm1,
      ImmutableTerm typeTerm2) {
    return defaultTermFactory.getAreCompatibleRDFStringExpression(typeTerm1, typeTerm2);
  }

  @Override
  public ImmutableExpression.Evaluation getEvaluation(ImmutableExpression expression) {
    return defaultTermFactory.getEvaluation(expression);
  }

  @Override
  public ImmutableExpression.Evaluation getPositiveEvaluation() {
    return defaultTermFactory.getPositiveEvaluation();
  }

  @Override
  public ImmutableExpression.Evaluation getNegativeEvaluation() {
    return defaultTermFactory.getNegativeEvaluation();
  }

  @Override
  public ImmutableExpression.Evaluation getNullEvaluation() {
    return defaultTermFactory.getNullEvaluation();
  }

  @Override
  public ImmutableFunctionalTerm.FunctionalTermDecomposition getFunctionalTermDecomposition(
      ImmutableTerm liftableTerm) {
    return defaultTermFactory.getFunctionalTermDecomposition(liftableTerm);
  }

  @Override
  public ImmutableFunctionalTerm.FunctionalTermDecomposition getFunctionalTermDecomposition(
      ImmutableTerm liftableTerm, Substitution<ImmutableFunctionalTerm> subTermSubstitution) {
    return defaultTermFactory.getFunctionalTermDecomposition(liftableTerm, subTermSubstitution);
  }

  @Override
  public ImmutableFunctionalTerm getImmutableFunctionalTerm(FunctionSymbol functor,
      ImmutableList<? extends ImmutableTerm> terms) {
    return defaultTermFactory.getImmutableFunctionalTerm(functor, terms);
  }

  @Override
  public ImmutableFunctionalTerm getImmutableFunctionalTerm(FunctionSymbol functor,
      ImmutableTerm... terms) {
    return defaultTermFactory.getImmutableFunctionalTerm(functor, terms);
  }

  @Override
  public NonGroundFunctionalTerm getNonGroundFunctionalTerm(FunctionSymbol functor,
      ImmutableTerm... terms) {
    return defaultTermFactory.getNonGroundFunctionalTerm(functor, terms);
  }

  @Override
  public NonGroundFunctionalTerm getNonGroundFunctionalTerm(FunctionSymbol functor,
      ImmutableList<ImmutableTerm> terms) {
    return defaultTermFactory.getNonGroundFunctionalTerm(functor, terms);
  }

  @Override
  public ImmutableExpression getNotYetTypedEquality(ImmutableTerm t1, ImmutableTerm t2) {
    return defaultTermFactory.getNotYetTypedEquality(t1, t2);
  }

  @Override
  public ImmutableExpression getLexicalNonStrictEquality(ImmutableTerm lexicalTerm1,
      ImmutableTerm typeTerm1, ImmutableTerm lexicalTerm2, ImmutableTerm typeTerm2) {
    return defaultTermFactory.getLexicalNonStrictEquality(lexicalTerm1, typeTerm1, lexicalTerm2,
        typeTerm2);
  }

  @Override
  public ImmutableExpression getLexicalInequality(InequalityLabel inequalityLabel,
      ImmutableTerm lexicalTerm1, ImmutableTerm typeTerm1, ImmutableTerm lexicalTerm2,
      ImmutableTerm typeTerm2) {
    return defaultTermFactory.getLexicalInequality(inequalityLabel, lexicalTerm1, typeTerm1,
        lexicalTerm2, typeTerm2);
  }

  @Override
  public ImmutableExpression getDBNonStrictNumericEquality(ImmutableTerm dbNumericTerm1,
      ImmutableTerm dbNumericTerm2) {
    return defaultTermFactory.getDBNonStrictNumericEquality(dbNumericTerm1, dbNumericTerm2);
  }

  @Override
  public ImmutableExpression getDBNonStrictStringEquality(ImmutableTerm dbStringTerm1,
      ImmutableTerm dbStringTerm2) {
    return defaultTermFactory.getDBNonStrictStringEquality(dbStringTerm1, dbStringTerm2);
  }

  @Override
  public ImmutableExpression getDBNonStrictDatetimeEquality(ImmutableTerm dbDatetimeTerm1,
      ImmutableTerm dbDatetimeTerm2) {
    return defaultTermFactory.getDBNonStrictDatetimeEquality(dbDatetimeTerm1, dbDatetimeTerm2);
  }

  @Override
  public ImmutableExpression getDBNonStrictDateEquality(ImmutableTerm dbTerm1,
      ImmutableTerm dbTerm2) {
    return defaultTermFactory.getDBNonStrictDateEquality(dbTerm1, dbTerm2);
  }

  @Override
  public ImmutableExpression getDBNonStrictDefaultEquality(ImmutableTerm dbTerm1,
      ImmutableTerm dbTerm2) {
    return defaultTermFactory.getDBNonStrictDefaultEquality(dbTerm1, dbTerm2);
  }

  @Override
  public ImmutableExpression getDBNumericInequality(InequalityLabel inequalityLabel,
      ImmutableTerm dbNumericTerm1, ImmutableTerm dbNumericTerm2) {
    return defaultTermFactory.getDBNumericInequality(inequalityLabel, dbNumericTerm1,
        dbNumericTerm2);
  }

  @Override
  public ImmutableExpression getDBBooleanInequality(InequalityLabel inequalityLabel,
      ImmutableTerm dbBooleanTerm1, ImmutableTerm dbBooleanTerm2) {
    return defaultTermFactory.getDBBooleanInequality(inequalityLabel, dbBooleanTerm1,
        dbBooleanTerm2);
  }

  @Override
  public ImmutableExpression getDBStringInequality(InequalityLabel inequalityLabel,
      ImmutableTerm dbStringTerm1, ImmutableTerm dbStringTerm2) {
    return defaultTermFactory.getDBStringInequality(inequalityLabel, dbStringTerm1, dbStringTerm2);
  }

  @Override
  public ImmutableExpression getDBDatetimeInequality(InequalityLabel inequalityLabel,
      ImmutableTerm dbDatetimeTerm1, ImmutableTerm dbDatetimeTerm2) {
    return defaultTermFactory.getDBDatetimeInequality(inequalityLabel, dbDatetimeTerm1,
        dbDatetimeTerm2);
  }

  @Override
  public ImmutableExpression getDBDateInequality(InequalityLabel inequalityLabel,
      ImmutableTerm dbDateTerm1, ImmutableTerm dbDateTerm2) {
    return defaultTermFactory.getDBDateInequality(inequalityLabel, dbDateTerm1, dbDateTerm2);
  }

  @Override
  public ImmutableExpression getDBDefaultInequality(InequalityLabel inequalityLabel,
      ImmutableTerm dbTerm1, ImmutableTerm dbTerm2) {
    return defaultTermFactory.getDBDefaultInequality(inequalityLabel, dbTerm1, dbTerm2);
  }

  @Override
  public IRIConstant getConstantIRI(IRI iri) {
    return defaultTermFactory.getConstantIRI(iri);
  }

  @Override
  public IRIConstant getConstantIRI(String iri) {
    return defaultTermFactory.getConstantIRI(iri);
  }

  @Override
  public BNode getConstantBNode(String name) {
    return defaultTermFactory.getConstantBNode(name);
  }

  @Override
  public DBConstant getDBBooleanConstant(boolean value) {
    return defaultTermFactory.getDBBooleanConstant(value);
  }

  @Override
  public DBConstant getXsdBooleanLexicalConstant(boolean value) {
    return defaultTermFactory.getXsdBooleanLexicalConstant(value);
  }

  @Override
  public Constant getNullConstant() {
    return defaultTermFactory.getNullConstant();
  }

  @Override
  public ImmutableFunctionalTerm getTypedNull(DBTermType termType) {
    return defaultTermFactory.getTypedNull(termType);
  }

  @Override
  public DBConstant getDBIntegerConstant(int value) {
    return defaultTermFactory.getDBIntegerConstant(value);
  }

  @Override
  public Optional<DBConstant> getDoubleNaN() {
    return defaultTermFactory.getDoubleNaN();
  }

  @Override
  public DBConstant getProvenanceSpecialConstant() {
    return defaultTermFactory.getProvenanceSpecialConstant();
  }

  @Override
  public RDFLiteralConstant getRDFLiteralConstant(String value, RDFDatatype type) {
    return defaultTermFactory.getRDFLiteralConstant(value, type);
  }

  @Override
  public RDFLiteralConstant getRDFLiteralConstant(String value, IRI type) {
    return defaultTermFactory.getRDFLiteralConstant(value, type);
  }

  @Override
  public RDFLiteralConstant getRDFLiteralConstant(String value, String language) {
    return defaultTermFactory.getRDFLiteralConstant(value, language);
  }

  @Override
  public RDFConstant getRDFConstant(String lexicalValue, RDFTermType termType) {
    return defaultTermFactory.getRDFConstant(lexicalValue, termType);
  }

  @Override
  public ImmutableFunctionalTerm getRDFLiteralFunctionalTerm(ImmutableTerm lexicalTerm,
      String language) {
    return defaultTermFactory.getRDFLiteralFunctionalTerm(lexicalTerm, language);
  }

  @Override
  public ImmutableFunctionalTerm getRDFLiteralFunctionalTerm(ImmutableTerm lexicalTerm,
      RDFDatatype type) {
    return defaultTermFactory.getRDFLiteralFunctionalTerm(lexicalTerm, type);
  }

  @Override
  public ImmutableFunctionalTerm getRDFLiteralFunctionalTerm(ImmutableTerm lexicalTerm,
      IRI datatypeIri) {
    return defaultTermFactory.getRDFLiteralFunctionalTerm(lexicalTerm, datatypeIri);
  }

  @Override
  public DBConstant getDBConstant(String value, DBTermType termType) {
    return defaultTermFactory.getDBConstant(value, termType);
  }

  @Override
  public DBConstant getDBStringConstant(String value) {
    return defaultTermFactory.getDBStringConstant(value);
  }

  @Override
  public Variable getVariable(String name) {
    return defaultTermFactory.getVariable(name);
  }

  @Override
  public RDFTermTypeConstant getRDFTermTypeConstant(RDFTermType type) {
    return defaultTermFactory.getRDFTermTypeConstant(type);
  }

  @Override
  public ImmutableFunctionalTerm getRDFTermTypeFunctionalTerm(ImmutableTerm term,
      TypeConstantDictionary dictionary, ImmutableSet<RDFTermTypeConstant> possibleConstants,
      boolean isSimplifiable) {
    return defaultTermFactory.getRDFTermTypeFunctionalTerm(term, dictionary, possibleConstants,
        isSimplifiable);
  }

  @Override
  public ImmutableFunctionalTerm getRDFFunctionalTerm(ImmutableTerm lexicalTerm,
      ImmutableTerm typeTerm) {
    return defaultTermFactory.getRDFFunctionalTerm(lexicalTerm, typeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getIRIFunctionalTerm(ImmutableTerm term) {
    return defaultTermFactory.getIRIFunctionalTerm(term);
  }

  @Override
  public ImmutableFunctionalTerm getIRIFunctionalTerm(ImmutableList<Template.Component> iriTemplate,
      ImmutableList<? extends ImmutableTerm> arguments) {
    return defaultTermFactory.getIRIFunctionalTerm(iriTemplate, arguments);
  }

  @Override
  public ImmutableFunctionalTerm getIRIFunctionalTerm(
      IRIStringTemplateFunctionSymbol templateSymbol, ImmutableList<DBConstant> arguments) {
    return defaultTermFactory.getIRIFunctionalTerm(templateSymbol, arguments);
  }

  @Override
  public ImmutableFunctionalTerm getBnodeFunctionalTerm(ImmutableTerm term) {
    return defaultTermFactory.getBnodeFunctionalTerm(term);
  }

  @Override
  public ImmutableFunctionalTerm getBnodeFunctionalTerm(
      ImmutableList<Template.Component> bnodeTemplate,
      ImmutableList<? extends ImmutableTerm> arguments) {
    return defaultTermFactory.getBnodeFunctionalTerm(bnodeTemplate, arguments);
  }

  @Override
  public ImmutableFunctionalTerm getDBCastFunctionalTerm(DBTermType targetType,
      ImmutableTerm term) {
    return defaultTermFactory.getDBCastFunctionalTerm(targetType, term);
  }

  @Override
  public ImmutableFunctionalTerm getDBCastFunctionalTerm(DBTermType inputType,
      DBTermType targetType, ImmutableTerm term) {
    return defaultTermFactory.getDBCastFunctionalTerm(inputType, targetType, term);
  }

  @Override
  public ImmutableFunctionalTerm getDBIntIndex(ImmutableTerm idTerm,
      ImmutableTerm... possibleValues) {
    return defaultTermFactory.getDBIntIndex(idTerm, possibleValues);
  }

  @Override
  public ImmutableFunctionalTerm getDBIntIndex(ImmutableTerm idTerm,
      ImmutableList<ImmutableTerm> possibleValues) {
    return defaultTermFactory.getDBIntIndex(idTerm, possibleValues);
  }

  @Override
  public ImmutableFunctionalTerm getConversion2RDFLexical(DBTermType inputType, ImmutableTerm term,
      RDFTermType rdfTermType) {
    return defaultTermFactory.getConversion2RDFLexical(inputType, term, rdfTermType);
  }

  @Override
  public ImmutableFunctionalTerm getConversion2RDFLexical(ImmutableTerm term,
      RDFTermType rdfTermType) {
    return defaultTermFactory.getConversion2RDFLexical(term, rdfTermType);
  }

  @Override
  public ImmutableFunctionalTerm getConversionFromRDFLexical2DB(DBTermType targetDbType,
      ImmutableTerm dbTerm, RDFTermType rdfType) {
    return defaultTermFactory.getConversionFromRDFLexical2DB(targetDbType, dbTerm, rdfType);
  }

  @Override
  public ImmutableFunctionalTerm getConversionFromRDFLexical2DB(DBTermType targetDbType,
      ImmutableTerm dbTerm) {
    return defaultTermFactory.getConversionFromRDFLexical2DB(targetDbType, dbTerm);
  }

  @Override
  public ImmutableFunctionalTerm getConversionFromRDFLexical2DB(ImmutableTerm dbTerm,
      RDFTermType rdfType) {
    return defaultTermFactory.getConversionFromRDFLexical2DB(dbTerm, rdfType);
  }

  @Override
  public ImmutableFunctionalTerm getPartiallyDefinedConversionToString(Variable variable) {
    return defaultTermFactory.getPartiallyDefinedConversionToString(variable);
  }

  @Override
  public ImmutableExpression getRDF2DBBooleanFunctionalTerm(ImmutableTerm xsdBooleanTerm) {
    return defaultTermFactory.getRDF2DBBooleanFunctionalTerm(xsdBooleanTerm);
  }

  @Override
  public ImmutableFunctionalTerm getIfElseNull(ImmutableExpression condition, ImmutableTerm term) {
    return defaultTermFactory.getIfElseNull(condition, term);
  }

  @Override
  public ImmutableExpression getBooleanIfElseNull(ImmutableExpression condition,
      ImmutableExpression thenExpression) {
    return defaultTermFactory.getBooleanIfElseNull(condition, thenExpression);
  }

  @Override
  public ImmutableFunctionalTerm getIfThenElse(ImmutableExpression condition,
      ImmutableTerm thenTerm, ImmutableTerm elseTerm) {
    return defaultTermFactory.getIfThenElse(condition, thenTerm, elseTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBCase(
      Stream<? extends Map.Entry<ImmutableExpression, ? extends ImmutableTerm>> whenPairs,
      ImmutableTerm defaultTerm, boolean doOrderingMatter) {
    return defaultTermFactory.getDBCase(whenPairs, defaultTerm, doOrderingMatter);
  }

  @Override
  public ImmutableFunctionalTerm getDBCaseElseNull(
      Stream<? extends Map.Entry<ImmutableExpression, ? extends ImmutableTerm>> whenPairs,
      boolean doOrderingMatter) {
    return defaultTermFactory.getDBCaseElseNull(whenPairs, doOrderingMatter);
  }

  @Override
  public ImmutableExpression getDBBooleanCase(
      Stream<Map.Entry<ImmutableExpression, ImmutableExpression>> whenPairs,
      ImmutableExpression defaultValue, boolean doOrderingMatter) {
    return defaultTermFactory.getDBBooleanCase(whenPairs, defaultValue, doOrderingMatter);
  }

  @Override
  public ImmutableFunctionalTerm getDBCoalesce(ImmutableTerm term1, ImmutableTerm term2,
      ImmutableTerm... terms) {
    return defaultTermFactory.getDBCoalesce(term1, term2, terms);
  }

  @Override
  public ImmutableFunctionalTerm getDBCoalesce(ImmutableList<ImmutableTerm> terms) {
    return defaultTermFactory.getDBCoalesce(terms);
  }

  @Override
  public ImmutableExpression getDBBooleanCoalesce(ImmutableList<ImmutableTerm> terms) {
    return defaultTermFactory.getDBBooleanCoalesce(terms);
  }

  @Override
  public ImmutableFunctionalTerm getDBReplace(ImmutableTerm arg, ImmutableTerm pattern,
      ImmutableTerm replacement) {
    return defaultTermFactory.getDBReplace(arg, pattern, replacement);
  }

  @Override
  public ImmutableFunctionalTerm getDBRegexpReplace(ImmutableTerm arg, ImmutableTerm pattern,
      ImmutableTerm replacement) {
    return defaultTermFactory.getDBRegexpReplace(arg, pattern, replacement);
  }

  @Override
  public ImmutableFunctionalTerm getDBRegexpReplace(ImmutableTerm arg, ImmutableTerm pattern,
      ImmutableTerm replacement, ImmutableTerm flags) {
    return defaultTermFactory.getDBRegexpReplace(arg, pattern, replacement, flags);
  }

  @Override
  public ImmutableExpression getDBStartsWith(ImmutableList<ImmutableTerm> terms) {
    return defaultTermFactory.getDBStartsWith(terms);
  }

  @Override
  public ImmutableExpression getDBEndsWith(ImmutableList<? extends ImmutableTerm> terms) {
    return defaultTermFactory.getDBEndsWith(terms);
  }

  @Override
  public ImmutableExpression getDBContains(ImmutableList<? extends ImmutableTerm> terms) {
    return defaultTermFactory.getDBContains(terms);
  }

  @Override
  public ImmutableExpression getDBRegexpMatches(ImmutableList<ImmutableTerm> terms) {
    return defaultTermFactory.getDBRegexpMatches(terms);
  }

  @Override
  public ImmutableFunctionalTerm getR2RMLIRISafeEncodeFunctionalTerm(ImmutableTerm term) {
    return defaultTermFactory.getR2RMLIRISafeEncodeFunctionalTerm(term);
  }

  @Override
  public ImmutableFunctionalTerm getDBEncodeForURI(ImmutableTerm term) {
    return defaultTermFactory.getDBEncodeForURI(term);
  }

  @Override
  public ImmutableFunctionalTerm getNullRejectingDBConcatFunctionalTerm(
      ImmutableList<? extends ImmutableTerm> terms) {
    return defaultTermFactory.getNullRejectingDBConcatFunctionalTerm(terms);
  }

  @Override
  public ImmutableFunctionalTerm getCommonDenominatorFunctionalTerm(
      ImmutableList<ImmutableTerm> typeTerms) {
    return defaultTermFactory.getCommonDenominatorFunctionalTerm(typeTerms);
  }

  @Override
  public ImmutableExpression getStrictEquality(ImmutableSet<ImmutableTerm> terms) {
    return defaultTermFactory.getStrictEquality(terms);
  }

  @Override
  public ImmutableExpression getStrictEquality(ImmutableList<? extends ImmutableTerm> terms) {
    return defaultTermFactory.getStrictEquality(terms);
  }

  @Override
  public ImmutableExpression getStrictEquality(ImmutableTerm term1, ImmutableTerm term2,
      ImmutableTerm... otherTerms) {
    return defaultTermFactory.getStrictEquality(term1, term2, otherTerms);
  }

  @Override
  public ImmutableExpression getDBIsStringEmpty(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBIsStringEmpty(stringTerm);
  }

  @Override
  public ImmutableExpression getStrictNEquality(ImmutableSet<ImmutableTerm> terms) {
    return defaultTermFactory.getStrictNEquality(terms);
  }

  @Override
  public ImmutableExpression getStrictNEquality(ImmutableList<? extends ImmutableTerm> terms) {
    return defaultTermFactory.getStrictNEquality(terms);
  }

  @Override
  public ImmutableExpression getStrictNEquality(ImmutableTerm term1, ImmutableTerm term2,
      ImmutableTerm... otherTerms) {
    return defaultTermFactory.getStrictNEquality(term1, term2, otherTerms);
  }

  @Override
  public ImmutableExpression getIsTrue(NonFunctionalTerm dbBooleanTerm) {
    return defaultTermFactory.getIsTrue(dbBooleanTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBSubString2(ImmutableTerm stringTerm, ImmutableTerm from) {
    return defaultTermFactory.getDBSubString2(stringTerm, from);
  }

  @Override
  public ImmutableFunctionalTerm getDBSubString3(ImmutableTerm stringTerm, ImmutableTerm from,
      ImmutableTerm to) {
    return defaultTermFactory.getDBSubString3(stringTerm, from, to);
  }

  @Override
  public ImmutableFunctionalTerm getDBRight(ImmutableTerm stringTerm, ImmutableTerm lengthTerm) {
    return defaultTermFactory.getDBRight(stringTerm, lengthTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBUpper(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBUpper(stringTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBLower(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBLower(stringTerm);
  }

  @Override
  public ImmutableFunctionalTerm getLangTypeFunctionalTerm(ImmutableTerm rdfTypeTerm) {
    return defaultTermFactory.getLangTypeFunctionalTerm(rdfTypeTerm);
  }

  @Override
  public ImmutableExpression getLexicalLangMatches(ImmutableTerm langTagTerm,
      ImmutableTerm langRangeTerm) {
    return defaultTermFactory.getLexicalLangMatches(langTagTerm, langRangeTerm);
  }

  @Override
  public TypeFactory getTypeFactory() {
    return defaultTermFactory.getTypeFactory();
  }

  @Override
  public VariableNullability createDummyVariableNullability(
      ImmutableFunctionalTerm functionalTerm) {
    return defaultTermFactory.createDummyVariableNullability(functionalTerm);
  }

  @Override
  public ImmutableFunctionalTerm getRDFDatatypeStringFunctionalTerm(ImmutableTerm rdfTypeTerm) {
    return defaultTermFactory.getRDFDatatypeStringFunctionalTerm(rdfTypeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBUUID(UUID uuid) {
    return defaultTermFactory.getDBUUID(uuid);
  }

  @Override
  public ImmutableFunctionalTerm getDBStrBefore(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBStrBefore(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBStrAfter(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBStrAfter(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBCharLength(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBCharLength(stringTerm);
  }

  @Override
  public ImmutableExpression getDBIsNull(ImmutableTerm immutableTerm) {
    return defaultTermFactory.getDBIsNull(immutableTerm);
  }

  @Override
  public ImmutableExpression getDBIsNotNull(ImmutableTerm immutableTerm) {
    return defaultTermFactory.getDBIsNotNull(immutableTerm);
  }

  @Override
  public Optional<ImmutableExpression> getDBIsNotNull(
      Stream<? extends ImmutableTerm> immutableTerms) {
    return defaultTermFactory.getDBIsNotNull(immutableTerms);
  }

  @Override
  public ImmutableFunctionalTerm getDBMd5(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBMd5(stringTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBSha1(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBSha1(stringTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBSha256(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBSha256(stringTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBSha384(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBSha384(stringTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBSha512(ImmutableTerm stringTerm) {
    return defaultTermFactory.getDBSha512(stringTerm);
  }

  @Override
  public ImmutableFunctionalTerm getCommonPropagatedOrSubstitutedNumericType(
      ImmutableTerm rdfTypeTerm1, ImmutableTerm rdfTypeTerm2) {
    return defaultTermFactory.getCommonPropagatedOrSubstitutedNumericType(rdfTypeTerm1,
        rdfTypeTerm2);
  }

  @Override
  public DBFunctionSymbolFactory getDBFunctionSymbolFactory() {
    return defaultTermFactory.getDBFunctionSymbolFactory();
  }

  @Override
  public <T extends ImmutableTerm> Substitution<T> getSubstitution(ImmutableMap<Variable, T> map) {
    return defaultTermFactory.getSubstitution(map);
  }

  @Override
  public ImmutableFunctionalTerm getBinaryNumericLexicalFunctionalTerm(
      String dbNumericOperationName, ImmutableTerm lexicalTerm1, ImmutableTerm lexicalTerm2,
      ImmutableTerm rdfTypeTerm) {
    return defaultTermFactory.getBinaryNumericLexicalFunctionalTerm(dbNumericOperationName,
        lexicalTerm1, lexicalTerm2, rdfTypeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBBinaryNumericFunctionalTerm(String dbNumericOperationName,
      DBTermType dbNumericType, ImmutableTerm dbTerm1, ImmutableTerm dbTerm2) {
    return defaultTermFactory.getDBBinaryNumericFunctionalTerm(dbNumericOperationName,
        dbNumericType,
        dbTerm1, dbTerm2);
  }

  @Override
  public ImmutableFunctionalTerm getDBBinaryNumericFunctionalTerm(String dbNumericOperationName,
      DBTermType argumentType1, DBTermType argumentType2, ImmutableTerm dbTerm1,
      ImmutableTerm dbTerm2) {
    return defaultTermFactory.getDBBinaryNumericFunctionalTerm(dbNumericOperationName,
        argumentType1,
        argumentType2, dbTerm1, dbTerm2);
  }

  @Override
  public ImmutableFunctionalTerm getUnaryLatelyTypedFunctionalTerm(ImmutableTerm lexicalTerm,
      ImmutableTerm inputRdfTypeTerm, DBTermType targetType,
      Function<DBTermType, Optional<DBFunctionSymbol>> dbFunctionSymbolFct) {
    return defaultTermFactory.getUnaryLatelyTypedFunctionalTerm(lexicalTerm, inputRdfTypeTerm,
        targetType, dbFunctionSymbolFct);
  }

  @Override
  public ImmutableFunctionalTerm getUnaryLexicalFunctionalTerm(ImmutableTerm lexicalTerm,
      ImmutableTerm rdfDatatypeTerm,
      Function<DBTermType, Optional<DBFunctionSymbol>> dbFunctionSymbolFct) {
    return defaultTermFactory.getUnaryLexicalFunctionalTerm(lexicalTerm, rdfDatatypeTerm,
        dbFunctionSymbolFct);
  }

  @Override
  public ImmutableFunctionalTerm getBinaryLatelyTypedFunctionalTerm(ImmutableTerm lexicalTerm0,
      ImmutableTerm lexicalTerm1, ImmutableTerm inputRdfTypeTerm0, ImmutableTerm inputRdfTypeTerm1,
      DBTermType targetType, Function<DBTermType, Optional<DBFunctionSymbol>> dbFunctionSymbolFct) {
    return defaultTermFactory.getBinaryLatelyTypedFunctionalTerm(lexicalTerm0, lexicalTerm1,
        inputRdfTypeTerm0, inputRdfTypeTerm1, targetType, dbFunctionSymbolFct);
  }

  @Override
  public ImmutableFunctionalTerm getSPARQLNonStrictEquality(ImmutableTerm rdfTerm1,
      ImmutableTerm rdfTerm2) {
    return defaultTermFactory.getSPARQLNonStrictEquality(rdfTerm1, rdfTerm2);
  }

  @Override
  public ImmutableFunctionalTerm getSPARQLEffectiveBooleanValue(ImmutableTerm rdfTerm) {
    return defaultTermFactory.getSPARQLEffectiveBooleanValue(rdfTerm);
  }

  @Override
  public ImmutableExpression getLexicalEffectiveBooleanValue(ImmutableTerm lexicalTerm,
      ImmutableTerm rdfDatatypeTerm) {
    return defaultTermFactory.getLexicalEffectiveBooleanValue(lexicalTerm, rdfDatatypeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBRand(UUID uuid) {
    return defaultTermFactory.getDBRand(uuid);
  }

  @Override
  public ImmutableFunctionalTerm getDBYearFromDatetime(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBYearFromDatetime(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBMonthFromDatetime(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBMonthFromDatetime(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBDayFromDatetime(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBDayFromDatetime(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBHours(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBHours(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBMinutes(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBMinutes(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBSeconds(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBSeconds(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBTz(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBTz(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBNow() {
    return defaultTermFactory.getDBNow();
  }

  @Override
  public ImmutableFunctionalTerm getDBRowUniqueStr() {
    return defaultTermFactory.getDBRowUniqueStr();
  }

  @Override
  public ImmutableFunctionalTerm getDBRowNumber() {
    return defaultTermFactory.getDBRowNumber();
  }

  @Override
  public ImmutableFunctionalTerm getDBIriStringResolution(IRI baseIri, ImmutableTerm argLexical) {
    return defaultTermFactory.getDBIriStringResolution(baseIri, argLexical);
  }

  @Override
  public ImmutableFunctionalTerm getDBCount(boolean isDistinct) {
    return defaultTermFactory.getDBCount(isDistinct);
  }

  @Override
  public ImmutableFunctionalTerm getDBCount(ImmutableTerm subTerm, boolean isDistinct) {
    return defaultTermFactory.getDBCount(subTerm, isDistinct);
  }

  @Override
  public ImmutableFunctionalTerm getDBSum(ImmutableTerm subTerm, DBTermType dbType,
      boolean isDistinct) {
    return defaultTermFactory.getDBSum(subTerm, dbType, isDistinct);
  }

  @Override
  public ImmutableFunctionalTerm getDBAvg(ImmutableTerm subTerm, DBTermType dbType,
      boolean isDistinct) {
    return defaultTermFactory.getDBAvg(subTerm, dbType, isDistinct);
  }

  @Override
  public ImmutableFunctionalTerm getDBStdev(ImmutableTerm subTerm, DBTermType dbType, boolean isPop,
      boolean isDistinct) {
    return defaultTermFactory.getDBStdev(subTerm, dbType, isPop, isDistinct);
  }

  @Override
  public ImmutableFunctionalTerm getDBVariance(ImmutableTerm subTerm, DBTermType dbType,
      boolean isPop, boolean isDistinct) {
    return defaultTermFactory.getDBVariance(subTerm, dbType, isPop, isDistinct);
  }

  @Override
  public ImmutableFunctionalTerm getDBMin(ImmutableTerm subTerm, DBTermType dbType) {
    return defaultTermFactory.getDBMin(subTerm, dbType);
  }

  @Override
  public ImmutableFunctionalTerm getDBMax(ImmutableTerm subTerm, DBTermType dbType) {
    return defaultTermFactory.getDBMax(subTerm, dbType);
  }

  @Override
  public ImmutableFunctionalTerm getDBSample(ImmutableTerm subTerm, DBTermType dbType) {
    return defaultTermFactory.getDBSample(subTerm, dbType);
  }

  @Override
  public ImmutableFunctionalTerm getDBGroupConcat(ImmutableTerm subTerm, String separator,
      boolean isDistinct) {
    return defaultTermFactory.getDBGroupConcat(subTerm, separator, isDistinct);
  }

  @Override
  public ImmutableTerm getDBSTWithin(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTWithin(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTContains(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTContains(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTCrosses(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTCrosses(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTDisjoint(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTDisjoint(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTEquals(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTEquals(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTIntersects(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTIntersects(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTOverlaps(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTOverlaps(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTTouches(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTTouches(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTCoveredBy(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTCoveredBy(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTCovers(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTCovers(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTContainsProperly(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTContainsProperly(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTSTransform(ImmutableTerm arg1, ImmutableTerm srid) {
    return defaultTermFactory.getDBSTSTransform(arg1, srid);
  }

  @Override
  public ImmutableTerm getDBSTSetSRID(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTSetSRID(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTGeomFromText(ImmutableTerm arg1) {
    return defaultTermFactory.getDBSTGeomFromText(arg1);
  }

  @Override
  public ImmutableTerm getDBSTMakePoint(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTMakePoint(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTFlipCoordinates(ImmutableTerm arg1) {
    return defaultTermFactory.getDBSTFlipCoordinates(arg1);
  }

  @Override
  public ImmutableTerm getDBSTDistanceSphere(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTDistanceSphere(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBSTDistanceSpheroid(ImmutableTerm arg1, ImmutableTerm arg2,
      ImmutableTerm arg3) {
    return defaultTermFactory.getDBSTDistanceSpheroid(arg1, arg2, arg3);
  }

  @Override
  public ImmutableTerm getDBSTDistance(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSTDistance(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBIntersection(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBIntersection(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBBoundary(ImmutableTerm arg1) {
    return defaultTermFactory.getDBBoundary(arg1);
  }

  @Override
  public ImmutableTerm getDBConvexHull(ImmutableTerm arg1) {
    return defaultTermFactory.getDBConvexHull(arg1);
  }

  @Override
  public ImmutableTerm getDBDifference(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBDifference(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBEnvelope(ImmutableTerm arg1) {
    return defaultTermFactory.getDBEnvelope(arg1);
  }

  @Override
  public ImmutableTerm getDBSymDifference(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBSymDifference(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBUnion(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBUnion(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBRelate(ImmutableTerm arg1, ImmutableTerm arg2, ImmutableTerm arg3) {
    return defaultTermFactory.getDBRelate(arg1, arg2, arg3);
  }

  @Override
  public ImmutableTerm getDBRelateMatrix(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBRelateMatrix(arg1, arg2);
  }

  @Override
  public ImmutableTerm getDBGetSRID(ImmutableTerm arg1) {
    return defaultTermFactory.getDBGetSRID(arg1);
  }

  @Override
  public ImmutableTerm getDBAsText(ImmutableTerm arg1) {
    return defaultTermFactory.getDBAsText(arg1);
  }

  @Override
  public ImmutableTerm getDBBuffer(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBBuffer(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBWeeksBetweenFromDateTime(ImmutableTerm arg1,
      ImmutableTerm arg2) {
    return defaultTermFactory.getDBWeeksBetweenFromDateTime(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBWeeksBetweenFromDate(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBWeeksBetweenFromDate(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBDaysBetweenFromDateTime(ImmutableTerm arg1,
      ImmutableTerm arg2) {
    return defaultTermFactory.getDBDaysBetweenFromDateTime(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBDaysBetweenFromDate(ImmutableTerm arg1, ImmutableTerm arg2) {
    return defaultTermFactory.getDBDaysBetweenFromDate(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBHoursBetweenFromDateTime(ImmutableTerm arg1,
      ImmutableTerm arg2) {
    return defaultTermFactory.getDBHoursBetweenFromDateTime(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBMinutesBetweenFromDateTime(ImmutableTerm arg1,
      ImmutableTerm arg2) {
    return defaultTermFactory.getDBMinutesBetweenFromDateTime(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBSecondsBetweenFromDateTime(ImmutableTerm arg1,
      ImmutableTerm arg2) {
    return defaultTermFactory.getDBSecondsBetweenFromDateTime(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBMillisBetweenFromDateTime(ImmutableTerm arg1,
      ImmutableTerm arg2) {
    return defaultTermFactory.getDBMillisBetweenFromDateTime(arg1, arg2);
  }

  @Override
  public ImmutableFunctionalTerm getDBJsonElement(ImmutableTerm arg, ImmutableList<String> path) {
    return defaultTermFactory.getDBJsonElement(arg, path);
  }

  @Override
  public ImmutableFunctionalTerm getDBJsonElementAsText(ImmutableTerm arg,
      ImmutableList<String> path) {
    return defaultTermFactory.getDBJsonElementAsText(arg, path);
  }

  @Override
  public ImmutableExpression getDBJsonIsBoolean(DBTermType dbType, ImmutableTerm arg) {
    return defaultTermFactory.getDBJsonIsBoolean(dbType, arg);
  }

  @Override
  public ImmutableExpression getDBJsonIsNumber(DBTermType dbType, ImmutableTerm arg) {
    return defaultTermFactory.getDBJsonIsNumber(dbType, arg);
  }

  @Override
  public ImmutableExpression getDBJsonIsScalar(DBTermType dbType, ImmutableTerm arg) {
    return defaultTermFactory.getDBJsonIsScalar(dbType, arg);
  }

  @Override
  public ImmutableExpression getDBIsArray(DBTermType dbType, ImmutableTerm arg) {
    return defaultTermFactory.getDBIsArray(dbType, arg);
  }

  @Override
  public ImmutableFunctionalTerm getDBWeek(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBWeek(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBQuarter(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBQuarter(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBDecade(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBDecade(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBCentury(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBCentury(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBMillennium(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBMillennium(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBMilliseconds(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBMilliseconds(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBMicroseconds(ImmutableTerm dbDatetimeTerm) {
    return defaultTermFactory.getDBMicroseconds(dbDatetimeTerm);
  }

  @Override
  public ImmutableFunctionalTerm getDBDateTrunc(ImmutableTerm dbDatetimeTerm,
      ImmutableTerm datePartTerm, String datePart) {
    return defaultTermFactory.getDBDateTrunc(dbDatetimeTerm, datePartTerm, datePart);
  }

  @Override
  public ImmutableFunctionalTerm getIdentityFunctionalTerm(ImmutableTerm immutableTerm) {
    return defaultTermFactory.getIdentityFunctionalTerm(immutableTerm);
  }
}

/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecTermFactoryTest.
 * @brief @~english MMecTermFactoryTest class implementation.
 */
package ca.griis.mmec.test.unit.controller.ontop.model.term;

import ca.griis.mmec.controller.ontop.model.term.MMecTermFactory;
import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecIndividuationFunctionSymbol;
import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecSqlDbFunctionSymbolFactory;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.ImmutableFunctionalTerm;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.NonGroundFunctionalTerm;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.impl.DBBooleanFunctionSymbolImpl;
import it.unibz.inf.ontop.model.term.impl.TermFactoryImpl;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.TermType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.internal.util.Primitives;

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
 * @brief @~french Tests pour la classe MMecTermFactory.
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
 *      2024-02-01 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecTermFactoryTest {
  TermFactoryImpl defaultTermFactory;

  @BeforeEach
  public void setUp() {
    defaultTermFactory = Mockito.mock(TermFactoryImpl.class);
  }

  @Test
  public void getMMecSignatureFunctionTest() {
    MMecTermFactory termFactory = new MMecTermFactory(defaultTermFactory);

    ImmutableList<TermType> argTypes = ImmutableList.of();
    ImmutableList<? extends ImmutableTerm> terms = ImmutableList.of();
    MMecSqlDbFunctionSymbolFactory dbFunctionSymbolFactory = Mockito.mock(
        MMecSqlDbFunctionSymbolFactory.class);
    MMecIndividuationFunctionSymbol individuationFunctionSymbol = Mockito.mock(
        MMecIndividuationFunctionSymbol.class);

    ImmutableFunctionalTerm expected = Mockito.mock(ImmutableFunctionalTerm.class);

    Mockito.when(defaultTermFactory.getDBFunctionSymbolFactory()).thenReturn(
        dbFunctionSymbolFactory);
    Mockito.when(dbFunctionSymbolFactory.createMMecIndividuationFunctionSymbol(argTypes))
        .thenReturn(individuationFunctionSymbol);
    Mockito.when(defaultTermFactory.getImmutableFunctionalTerm(individuationFunctionSymbol, terms))
        .thenReturn(expected);

    ImmutableFunctionalTerm actual = termFactory.getMMecSignatureFunction(argTypes, terms);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getMMecConversionFunction() {
    MMecTermFactory termFactory = new MMecTermFactory(defaultTermFactory);
    NonGroundFunctionalTerm expected = Mockito.mock(NonGroundFunctionalTerm.class);

    Variable variable = Mockito.mock(Variable.class);
    DBTermType variableType = Mockito.mock(DBTermType.class);
    DBTermType sqlDataType = Mockito.mock(DBTermType.class);
    MMecSqlDbFunctionSymbolFactory dbFunctionSymbolFactory = Mockito.mock(
        MMecSqlDbFunctionSymbolFactory.class);
    DBTypeConversionFunctionSymbol conversionFunctionSymbol = Mockito.mock(
        DBTypeConversionFunctionSymbol.class);

    Mockito.when(defaultTermFactory.getDBFunctionSymbolFactory()).thenReturn(
        dbFunctionSymbolFactory);
    Mockito.when(dbFunctionSymbolFactory.createMMecConversionFunctionSymbol(variableType,
        sqlDataType)).thenReturn(conversionFunctionSymbol);
    Mockito.when(defaultTermFactory.getNonGroundFunctionalTerm(conversionFunctionSymbol, variable))
        .thenReturn(expected);

    ImmutableTerm actual = termFactory.getMMecConversionFunction(variable, variableType,
        sqlDataType);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void getMMecConversionValidationFunction() {
    MMecTermFactory termFactory = new MMecTermFactory(defaultTermFactory);
    NonGroundFunctionalTerm expected = Mockito.mock(NonGroundFunctionalTerm.class);

    Variable variable = Mockito.mock(Variable.class);
    DBTermType variableType = Mockito.mock(DBTermType.class);
    DBTermType sqlDataType = Mockito.mock(DBTermType.class);
    MMecSqlDbFunctionSymbolFactory dbFunctionSymbolFactory = Mockito.mock(
        MMecSqlDbFunctionSymbolFactory.class);
    DBBooleanFunctionSymbolImpl conversionValidationFunctionSymbol = Mockito.mock(
        DBBooleanFunctionSymbolImpl.class);

    Mockito.when(defaultTermFactory.getDBFunctionSymbolFactory()).thenReturn(
        dbFunctionSymbolFactory);
    Mockito.when(dbFunctionSymbolFactory.createMMecConversionValidationFunctionSymbol(variableType,
        sqlDataType)).thenReturn(conversionValidationFunctionSymbol);
    Mockito.when(defaultTermFactory.getNonGroundFunctionalTerm(
        conversionValidationFunctionSymbol, variable)).thenReturn(expected);

    ImmutableTerm actual = termFactory.getMMecConversionValidationFunction(variable, variableType,
        sqlDataType);

    Assertions.assertEquals(expected, actual);
  }

  private static Stream<Method> getDelegatedMethods() {
    return Arrays.stream(TermFactoryImpl.class.getDeclaredMethods()).filter(
        mod -> Modifier.isPublic(mod.getModifiers()));
  }

  @ParameterizedTest
  @MethodSource("getDelegatedMethods")
  public void testDelegationToDefaultTermFactory(Method delegatedMethod)
      throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    MMecTermFactory termFactory = new MMecTermFactory(defaultTermFactory);

    Method methodUnderTest = termFactory.getClass().getMethod(delegatedMethod.getName(),
        delegatedMethod.getParameterTypes());
    Object[] args = Arrays.stream(delegatedMethod.getParameterTypes()).map(this::getMockForType)
        .toArray();
    Object expected = Mockito.mock(delegatedMethod.getReturnType());

    Mockito.when(delegatedMethod.invoke(defaultTermFactory, args)).thenReturn(expected);
    Object actual = methodUnderTest.invoke(termFactory, args);

    Assertions.assertEquals(expected, actual);
  }

  /**
   * @param aClass «Parameter description»
   * @param aClass La classe dont un veut un objet bidon
   * @return «Return description»
   * @return Un objet quelconque utilisable pour les tests
   * @brief @~english «Description of the method»
   * @brief @~french Obtenir un objet de la classe, la valeur par défaut du type ou null dans le cas
   *        ou il est impossible d'obtenir un mock
   * @par Tâches S.O.
   */
  private Object getMockForType(Class<?> aClass) {
    if (Primitives.isPrimitiveOrWrapper(aClass)) {
      return Primitives.defaultValue(aClass);
    }

    try {
      return Mockito.mock(aClass);
    } catch (MockitoException exception) {
      return null;
    }
  }

}

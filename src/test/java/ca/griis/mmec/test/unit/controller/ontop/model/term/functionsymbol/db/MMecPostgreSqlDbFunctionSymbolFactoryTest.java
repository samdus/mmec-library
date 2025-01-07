package ca.griis.mmec.test.unit.controller.ontop.model.term.functionsymbol.db;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.*;
import ca.griis.mmec.controller.ontop.model.type.impl.MMecPostgreSqlDbTypeFactory;
import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.type.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MMecPostgreSqlDbFunctionSymbolFactoryTest {
  private TypeFactory typeFactory;
  private DBTypeFactory dbTypeFactory;

  @BeforeEach
  public void setUp() {
    typeFactory = Mockito.mock(TypeFactory.class);
    dbTypeFactory = Mockito.mock(DBTypeFactory.class);

    Mockito.when(typeFactory.getDBTypeFactory()).thenReturn(dbTypeFactory);
    Mockito.when(dbTypeFactory.getAbstractRootDBType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBStringType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBBooleanType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBLargeIntegerType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBTermType(MMecPostgreSqlDbTypeFactory.INTEGER_STR))
        .thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBTermType(Mockito.any(), Mockito.anyInt()))
        .thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBArrayType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBDecimalType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBDateTimestampType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBDoubleType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBGeographyType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBDoubleType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBDateType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBArrayType(Mockito.any()))
        .thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBHexBinaryType()).thenReturn(Mockito.mock(DBTermType.class));
    Mockito.when(dbTypeFactory.getDBTimeType()).thenReturn(Mockito.mock(DBTermType.class));
  }

  @Test
  public void createMMecIndividuationFunctionSymbolWithArgTypesTest() {
    TermType argType1 = Mockito.mock(TermType.class);
    ImmutableList<TermType> argTypes = ImmutableList.of(argType1);
    ObjectRDFType iRITermType = Mockito.mock(ObjectRDFType.class);
    DBTermType individuationFunctionReturnType = Mockito.mock(DBTermType.class);
    String returnTypeName = "returnTypeName";
    String individuationFunctionCallTemplate = "individuation(%s)";

    Mockito.when(iRITermType.getAncestry()).thenReturn(Mockito.mock(TermTypeAncestry.class));
    Mockito.when(typeFactory.getIRITermType()).thenReturn(iRITermType);
    Mockito.when(dbTypeFactory.getDBTermType(MMecPostgreSqlDbTypeFactory.UUID_STR))
        .thenReturn(individuationFunctionReturnType);
    Mockito.when(individuationFunctionReturnType.getName()).thenReturn(returnTypeName);

    MMecPostgreSqlDbFunctionSymbolFactory mmecPostgreSqlDbFunctionSymbolFactory =
        new MMecPostgreSqlDbFunctionSymbolFactory(typeFactory);
    MMecIndividuationFunctionSymbol expected = new MMecIndividuationFunctionSymbol(argTypes,
        iRITermType,
        individuationFunctionReturnType,
        individuationFunctionCallTemplate);
    MMecIndividuationFunctionSymbol actual = mmecPostgreSqlDbFunctionSymbolFactory
        .createMMecIndividuationFunctionSymbol(argTypes);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void createMMecSimpleConversionFunctionSymbolTest() {
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);

    MMecPostgreSqlDbFunctionSymbolFactory mmecPostgreSqlDbFunctionSymbolFactory =
        new MMecPostgreSqlDbFunctionSymbolFactory(typeFactory);

    DBTypeConversionFunctionSymbol expected =
        new MMecSimpleConversionFunctionSymbol(inputType, targetType);
    DBTypeConversionFunctionSymbol actual = mmecPostgreSqlDbFunctionSymbolFactory
        .createMMecSimpleConversionFunctionSymbol(inputType, targetType);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void createMMecConversionFunctionSymbolTest() {
    String functionName = "functionName";
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);

    MMecPostgreSqlDbFunctionSymbolFactory mmecPostgreSqlDbFunctionSymbolFactory =
        new MMecPostgreSqlDbFunctionSymbolFactory(typeFactory);

    DBTypeConversionFunctionSymbol expected =
        new MMecConversionFunctionSymbol(functionName, inputType, targetType);
    DBTypeConversionFunctionSymbol actual = mmecPostgreSqlDbFunctionSymbolFactory
        .createMMecConversionFunctionSymbol(functionName, inputType, targetType);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void createMMecConversionValidationFunctionSymbolTest() {
    String functionName = "functionName";
    DBTermType inputType = Mockito.mock(DBTermType.class);
    DBTermType targetType = Mockito.mock(DBTermType.class);

    MMecPostgreSqlDbFunctionSymbolFactory mmecPostgreSqlDbFunctionSymbolFactory =
        new MMecPostgreSqlDbFunctionSymbolFactory(typeFactory);

    DBFunctionSymbol expected =
        new MMecConversionValidationFunctionSymbol(functionName, inputType, targetType);
    DBFunctionSymbol actual = mmecPostgreSqlDbFunctionSymbolFactory
        .createMMecConversionValidationFunctionSymbol(functionName, inputType, targetType);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  public void createMMecValueFunctionSymbolTest() {
    DBTermType valueType = Mockito.mock(DBTermType.class);
    RDFTermTypeConstant rdfTermTypeConstant = Mockito.mock(RDFTermTypeConstant.class);
    MetaRDFTermType typeTermType = Mockito.mock(MetaRDFTermType.class);

    Mockito.when(typeFactory.getMetaRDFTermType()).thenReturn(typeTermType);
    Mockito.when(rdfTermTypeConstant.getRDFTermType()).thenReturn(Mockito.mock(RDFDatatype.class));

    MMecPostgreSqlDbFunctionSymbolFactory mmecPostgreSqlDbFunctionSymbolFactory =
        new MMecPostgreSqlDbFunctionSymbolFactory(typeFactory);

    MMecValueFunctionSymbol expected =
        new MMecValueFunctionSymbol(valueType, rdfTermTypeConstant, typeTermType);
    MMecValueFunctionSymbol actual = mmecPostgreSqlDbFunctionSymbolFactory
        .createMMecValueFunctionSymbol(valueType, rdfTermTypeConstant);

    Assertions.assertEquals(expected, actual);
  }
}

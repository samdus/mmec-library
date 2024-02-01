package ca.griis.mmec.controller.ontop.iq.transform;

import ca.griis.mmec.controller.ontop.model.term.MMecTermFactory;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.repository.OntoRelCatRepository;
import ca.griis.mmec.repository.jooq.JooqOntoRelCatRepository;
import com.google.common.collect.ImmutableMap;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
import it.unibz.inf.ontop.iq.node.impl.FilterNodeImpl;
import it.unibz.inf.ontop.iq.transform.impl.DefaultRecursiveIQTreeVisitingTransformer;
import it.unibz.inf.ontop.iq.type.impl.BasicSingleTermTypeExtractor;
import it.unibz.inf.ontop.model.term.ImmutableTerm;
import it.unibz.inf.ontop.model.term.NonGroundFunctionalTerm;
import it.unibz.inf.ontop.model.term.RDFTermTypeConstant;
import it.unibz.inf.ontop.model.term.TermFactory;
import it.unibz.inf.ontop.model.term.Variable;
import it.unibz.inf.ontop.model.term.functionsymbol.RDFTermFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.impl.SimpleRDFDatatype;
import it.unibz.inf.ontop.substitution.Substitution;
import it.unibz.inf.ontop.substitution.impl.SubstitutionImpl;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

public class DataPropertyProjectionTransformer extends DefaultRecursiveIQTreeVisitingTransformer {
  private final MMecTermFactory termFactory;
  private final BasicSingleTermTypeExtractor typeExtractor;
  private final OntoRelCatRepository ontoRelCatRepository;
  private final MappingProperties mappingProperties;
  private final ImmutableMap<DBTermType.Category, ImmutableMap<DBTermType.Category, Boolean>> triv =
      ImmutableMap.of(
          DBTermType.Category.STRING, ImmutableMap.of(
              DBTermType.Category.STRING, true),
          DBTermType.Category.INTEGER, ImmutableMap.of(
              DBTermType.Category.INTEGER, true,
              DBTermType.Category.DECIMAL, true,
              DBTermType.Category.STRING, true),
          DBTermType.Category.DECIMAL, ImmutableMap.of(
              DBTermType.Category.DECIMAL, true,
              DBTermType.Category.STRING, true),
          DBTermType.Category.FLOAT_DOUBLE, ImmutableMap.of(
              DBTermType.Category.FLOAT_DOUBLE, true,
              DBTermType.Category.STRING, true),
          DBTermType.Category.BOOLEAN, ImmutableMap.of(
              DBTermType.Category.BOOLEAN, true,
              DBTermType.Category.STRING, true),
          DBTermType.Category.DATE, ImmutableMap.of(
              DBTermType.Category.DATE, true,
              DBTermType.Category.DATETIME, true,
              DBTermType.Category.STRING, true),
          DBTermType.Category.DATETIME, ImmutableMap.of(
              DBTermType.Category.DATETIME, true,
              DBTermType.Category.STRING, true),
          DBTermType.Category.UUID, ImmutableMap.of(
              DBTermType.Category.UUID, true,
              DBTermType.Category.STRING, true),
          DBTermType.Category.JSON, ImmutableMap.of(
              DBTermType.Category.JSON, true,
              DBTermType.Category.STRING, true),
          DBTermType.Category.ARRAY, ImmutableMap.of(
              DBTermType.Category.ARRAY, true,
              DBTermType.Category.STRING, true));

  @Inject
  public DataPropertyProjectionTransformer(IntermediateQueryFactory iqFactory,
      TermFactory termFactory,
      BasicSingleTermTypeExtractor typeExtractor,
      JooqOntoRelCatRepository ontoRelCatRepository,
      MappingProperties mappingProperties) {
    super(iqFactory);

    assert termFactory instanceof MMecTermFactory;
    this.termFactory = (MMecTermFactory) termFactory;
    this.typeExtractor = typeExtractor;
    this.ontoRelCatRepository = ontoRelCatRepository;
    this.mappingProperties = mappingProperties;
  }

  @Override
  public IQTree transformConstruction(IQTree tree, ConstructionNode constructionNode,
      IQTree child) {
    Map<Variable, ImmutableTerm> newSubstitutionMap = new HashMap<>();

    if (!constructionNode.getSubstitution().isEmpty()) {
      for (Map.Entry<Variable, ImmutableTerm> substitutionEntry : constructionNode.getSubstitution()
          .stream().toList()) {
        if (substitutionEntry.getValue() instanceof NonGroundFunctionalTerm term
            && term.getFunctionSymbol() instanceof RDFTermFunctionSymbol
            && term.getTerm(1) instanceof RDFTermTypeConstant rdfTermTypeConstant
            && rdfTermTypeConstant.getRDFTermType() instanceof SimpleRDFDatatype rdfDatatype) {
          try {
            DBTermType targetType = ontoRelCatRepository.getSqlType(
                mappingProperties.getOntoRelId(),
                rdfDatatype.getIRI().getIRIString());
            Variable variable = term.getVariables().stream().findFirst().orElseThrow(
                SQLException::new);
            DBTermType variableType = (DBTermType) typeExtractor.extractSingleTermType(variable,
                tree)
                .filter(termType -> termType instanceof DBTermType)
                .orElseThrow(SQLException::new);

            if (targetType.equals(variableType)) {
              newSubstitutionMap.put(substitutionEntry.getKey(), variable);
            } else if (isTrivialCast(variableType, targetType)) {
              newSubstitutionMap.put(substitutionEntry.getKey(),
                  termFactory.getDBCastFunctionalTerm(variableType, targetType, variable));
            } else {
              newSubstitutionMap.put(substitutionEntry.getKey(),
                  termFactory.getMMecConversionFunction(variable, variableType, targetType));

              // Remove the filter node if there was already one for this variable
              if (child.getRootNode() instanceof FilterNodeImpl filterNode
                  && child.getChildren().size() == 1
                  && filterNode.getFilterCondition().getVariables().size() == 1
                  && filterNode.getFilterCondition().getVariables().contains(variable)) {
                child = child.getChildren().get(0);
              }
              child = iqFactory.createUnaryIQTree(
                  iqFactory.createFilterNode(termFactory.getStrictEquality(
                      termFactory.getMMecConversionValidationFunction(variable, variableType,
                          targetType),
                      termFactory.getDBBooleanConstant(true))),
                  child);
            }
          } catch (SQLException e) {
            newSubstitutionMap.put(substitutionEntry.getKey(), substitutionEntry.getValue());
          }
        } else {
          newSubstitutionMap.put(substitutionEntry.getKey(), substitutionEntry.getValue());
        }
      }

      Substitution<ImmutableTerm> substitution = new SubstitutionImpl<>(
          ImmutableMap.copyOf(newSubstitutionMap), termFactory, true);
      constructionNode = iqFactory.createConstructionNode(
          constructionNode.getVariables(), substitution);
    }

    return transformUnaryNode(tree, constructionNode, child);
  }

  private boolean isTrivialCast(DBTermType variableType, DBTermType sqlDataType) {
    return triv.containsKey(variableType.getCategory())
        && triv.get(variableType.getCategory()).containsKey(sqlDataType.getCategory())
        && triv.get(variableType.getCategory()).get(sqlDataType.getCategory());
  }
}

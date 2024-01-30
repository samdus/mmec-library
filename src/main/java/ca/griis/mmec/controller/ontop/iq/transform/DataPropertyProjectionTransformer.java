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

  @Inject
  protected DataPropertyProjectionTransformer(IntermediateQueryFactory iqFactory,
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

    for (Map.Entry<Variable, ImmutableTerm> substitutionEntry : constructionNode.getSubstitution()
        .stream().toList()) {
      if (substitutionEntry.getValue() instanceof NonGroundFunctionalTerm term
          && term.getFunctionSymbol() instanceof RDFTermFunctionSymbol
          && term.getTerm(1) instanceof RDFTermTypeConstant rdfTermTypeConstant
          && rdfTermTypeConstant.getRDFTermType() instanceof SimpleRDFDatatype rdfDatatype) {
        try {
          DBTermType sqlDataType = ontoRelCatRepository.getSQLType(mappingProperties.getOntoRelId(),
              rdfDatatype.getIRI().getIRIString());
          Variable variable = term.getVariables().stream().findFirst().orElseThrow(
              SQLException::new);
          DBTermType variableType = (DBTermType) typeExtractor.extractSingleTermType(variable, tree)
              .filter(termType -> termType instanceof DBTermType)
              .orElseThrow(SQLException::new);

          if (sqlDataType.equals(variableType)) {
            newSubstitutionMap.put(substitutionEntry.getKey(), variable);
          } else {
            newSubstitutionMap.put(substitutionEntry.getKey(),
                termFactory.getMMecConversionFunction(variable, variableType, sqlDataType));

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
                        sqlDataType),
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
    ConstructionNode newConstructionNode = iqFactory.createConstructionNode(
        constructionNode.getVariables(), substitution);
    return transformUnaryNode(tree, newConstructionNode, child);
  }
}

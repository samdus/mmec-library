package ca.griis.mmec.controller.ontop.iq.transform;

import ca.griis.mmec.controller.ontop.model.term.MMecTermFactory;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.repository.OntoRelCatRepository;
import ca.griis.mmec.repository.jooq.JooqOntoRelCatRepository;
import com.google.common.collect.ImmutableMap;
import it.unibz.inf.ontop.injection.IntermediateQueryFactory;
import it.unibz.inf.ontop.iq.IQTree;
import it.unibz.inf.ontop.iq.node.ConstructionNode;
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
import java.util.Map;
import java.util.stream.Collectors;
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

    //        CONSTRUCT [sub, val] [val/RDF(INTEGERToTEXT(o1m2),xsd:string), sub/Individuation_2("http://www.griis.ca/projects/tst/{}"^^TEXT,m1m0)]
    //        FILTER IS_NOT_NULL(o1m2)
    //                EXTENSIONAL "TABLE2"(0:m1m0,2:o1m2)

    Substitution<ImmutableTerm> substitution = new SubstitutionImpl<>(
        ImmutableMap.copyOf(constructionNode.getSubstitution().stream()
            .collect(Collectors.toMap(Map.Entry::getKey,
                value -> getTermOrChangeRDFFunctionForConversionFunction(tree, value)))),
        termFactory, true);

    // TODO: Add a filter node for each added conversion function

    ConstructionNode newConstructionNode = iqFactory.createConstructionNode(
        constructionNode.getVariables(),
        substitution);
    return transformUnaryNode(tree, newConstructionNode, child);
  }

  private ImmutableTerm getTermOrChangeRDFFunctionForConversionFunction(IQTree tree,
      Map.Entry<Variable, ImmutableTerm> substitutionEntry) {
    if (substitutionEntry.getValue() instanceof NonGroundFunctionalTerm term
        && term.getFunctionSymbol() instanceof RDFTermFunctionSymbol
        && term.getTerm(1) instanceof RDFTermTypeConstant rdfTermTypeConstant
        && rdfTermTypeConstant.getRDFTermType() instanceof SimpleRDFDatatype rdfDatatype) {

      try {
        DBTermType sqlDataType = ontoRelCatRepository.getSQLType(mappingProperties.getOntoRelId(),
            rdfDatatype.getIRI().getIRIString());
        Variable variable = term.getVariables().stream().findFirst().orElseThrow(SQLException::new);
        DBTermType variableType = (DBTermType) typeExtractor.extractSingleTermType(variable, tree)
            .filter(termType -> termType instanceof DBTermType)
            .orElseThrow(SQLException::new);

        if (sqlDataType.equals(variableType)) {
          return variable;
        } else {
          return termFactory.getMMecConversionFunction(variable, variableType, sqlDataType);
        }
      } catch (SQLException e) {
        return substitutionEntry.getValue();
      }
    }
    return substitutionEntry.getValue();
  }
}

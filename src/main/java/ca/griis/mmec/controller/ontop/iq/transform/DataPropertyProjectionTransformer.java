package ca.griis.mmec.controller.ontop.iq.transform;

import ca.griis.mmec.controller.ontop.model.term.MMecTermFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingConversion;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.properties.MappingProperties;
import ca.griis.mmec.repository.OntoRelCatRepository;
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
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

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
 * @brief @~french Transformateur pour les projections de propriétés de données
 * @par Détails
 *      Permet de transformer les projections de requêtes de propriétés de données pour
 *      retourner la valeur SQL du modèle commun plutôt que sa représentation RDF.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      Parmi les substitutions de la requête, on cherche les substitutions de propriétés de données
 *      Pour chaque substitution de propriété de données, on détermine le type de la variable à
 *      substituer et le type de destination dans la configuration du modèle commun.
 *      <br>
 *      Si le type de la variable et le type de destination ont le même nom, on remplace la
 *      substitution par un simple renommage de la variable.
 *      <br>
 *      Si une fonction de conversion existe dans cet arrimage pour convertir une variable du type
 *      de la variable vers le type de destination, on remplace la substitution par l'appel de cette
 *      fonction. Si cette conversion définie une fonction de validation, l'appel à celle-ci est
 *      ajouté à la requête.
 *      <br>
 *      Si aucune des conditions précédentes n'est remplie, on lève une exception. La conversion
 *      aurait dû avoir été spécifié lors de l'arrimage.
 *
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2024-02-02 [SD] - Implémentation initiale<br>
 *      2024-03-05 [SD] - Correction de la gestion des conversions de type<br>
 *
 * @par Tâches
 *      S.O.
 */
public class DataPropertyProjectionTransformer
    extends DefaultRecursiveIQTreeVisitingTransformer {
  private final MMecTermFactory termFactory;
  private final BasicSingleTermTypeExtractor typeExtractor;
  private final OntoRelCatRepository ontoRelCatRepository;
  private final MappingProperties mappingProperties;
  private final MMecMappingExtension mappingExtension;

  @Inject
  public DataPropertyProjectionTransformer(
      MMecMappingExtension mappingExtension,
      IntermediateQueryFactory iqFactory,
      TermFactory termFactory,
      BasicSingleTermTypeExtractor typeExtractor,
      OntoRelCatRepository ontoRelCatRepository,
      MappingProperties mappingProperties) {
    super(iqFactory);

    this.mappingExtension = mappingExtension;
    this.termFactory = (MMecTermFactory) termFactory;
    this.typeExtractor = typeExtractor;
    this.ontoRelCatRepository = ontoRelCatRepository;
    this.mappingProperties = mappingProperties;
  }

  @Override
  public IQTree transformConstruction(IQTree tree, ConstructionNode constructionNode,
      IQTree child) {

    if (!constructionNode.getSubstitution().isEmpty()) {
      Map<Variable, ImmutableTerm> newSubstitutionMap = new HashMap<>();
      for (Map.Entry<Variable, ImmutableTerm> substitutionEntry : constructionNode.getSubstitution()
          .stream().toList()) {
        if (substitutionEntry.getValue() instanceof NonGroundFunctionalTerm term
            && term.getFunctionSymbol() instanceof RDFTermFunctionSymbol
            && term.getTerm(1) instanceof RDFTermTypeConstant rdfTermTypeConstant
            && rdfTermTypeConstant.getRDFTermType() instanceof SimpleRDFDatatype rdfDatatype) {

          DBTermType targetType = getTargetSqlType(tree, rdfDatatype);
          Variable variable = term.getVariables().stream().findFirst().orElseThrow(
              () -> new DataPropertyProjectionTransformerException(tree,
                  "Cannot get the variable from the data property's substitution."));
          DBTermType variableType = typeExtractor.extractSingleTermType(variable, child)
              .filter(termType -> termType instanceof DBTermType)
              .map(termType -> (DBTermType) termType)
              .orElseThrow(() -> new DataPropertyProjectionTransformerException(tree,
                  "Cannot get the type of the data property's substitution variable."));

          CastTermAndTree castTermAndTree = getCastTermAndTree(targetType, variable, variableType,
              child, tree);

          child = castTermAndTree.child();
          newSubstitutionMap.put(substitutionEntry.getKey(),
              termFactory.getMMecValueFunction(castTermAndTree.valueTerm(), targetType,
                  rdfTermTypeConstant));
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

  private record CastTermAndTree(ImmutableTerm valueTerm, IQTree child) {
  }

  private CastTermAndTree getCastTermAndTree(DBTermType targetType, Variable variable,
      DBTermType variableType, IQTree child, IQTree tree) {
    ImmutableTerm valueTerm;
    if (targetType.getName().contains("\"") && targetType.getName().equals(
        variableType.getName())
        || !targetType.getName().contains("\"") && targetType.getName().compareToIgnoreCase(
        variableType.getName()) == 0) {
      valueTerm = termFactory.getMMecSimpleCastFunctionalTerm(variableType, targetType,
          variable);
    } else {
      MMecMappingConversion conversion = mappingExtension
          .getMappingConversion(variableType, targetType)
          .orElseThrow(() -> new DataPropertyProjectionTransformerException(tree,
              String.format(
                  "No conversion found for the variable type %s to the target type %s.",
                  variableType.getName(), targetType.getName())));

      if (conversion.getConversionFunction().isPresent()) {
        valueTerm = termFactory.getMMecConversionFunction(variable, conversion);
      } else {
        valueTerm = termFactory.getMMecSimpleCastFunctionalTerm(variableType, targetType,
            variable);
      }

      if (conversion.getValidationFunction().isPresent()) {
        child = iqFactory.createUnaryIQTree(
            iqFactory.createFilterNode(termFactory.getStrictEquality(
                termFactory.getMMecConversionValidationFunction(variable, conversion),
                termFactory.getDBBooleanConstant(true))),
            child);
      }
    }
    return new CastTermAndTree(valueTerm, child);
  }

  private DBTermType getTargetSqlType(IQTree iqTree, SimpleRDFDatatype rdfDatatype) {
    return ontoRelCatRepository.getSqlType(mappingProperties.getOntoRelId(),
            rdfDatatype.getIRI().getIRIString())
        .orElseThrow(() -> new DataPropertyProjectionTransformerException(iqTree,
            String.format("Cannot retrieve RDFDatatype <%s> from the OntoRelCat.",
                rdfDatatype.getIRI().getIRIString())));
  }

  public static class DataPropertyProjectionTransformerException extends RuntimeException {
    public DataPropertyProjectionTransformerException(IQTree iqTree, String reason) {
      super(String.format("Impossible to transform the DataProperty from the following tree. {%n"
          + "Cause: \"%s\";%n"
          + "IQTree:%n%s%n}", reason, iqTree.toString()));
    }

    public DataPropertyProjectionTransformerException(IQTree iqTree, Throwable cause) {
      super(String.format("Impossible to transform the DataProperty from the following tree. {%n"
          + "Cause: \"%s\";%n"
          + "IQTree:%n%s%n}", cause.getMessage(), iqTree.toString()), cause);
    }
  }
}

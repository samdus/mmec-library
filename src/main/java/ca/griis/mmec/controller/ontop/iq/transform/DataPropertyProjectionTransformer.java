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
import java.util.Objects;
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
 *      Si le type de la variable et le type de destination sont identiques, on remplace la
 *      substitution par un simple renommage de la variable.
 *      <br>
 *      Si le nom de conversion du type de la variable et le nom de conversion du type de
 *      destination sont identiques, on remplace la substitution par une conversion simple de la
 *      variable (CAST SQL).
 *      <br>
 *      Si les tous les types qui sont dans la même catégorie que le type de la variable peuvent
 *      être trivialement convertis vers tous les types dans la même catégorie que le type de
 *      destination (par exemple, INTEGER vers DECIMAL), on remplace la substitution par une
 *      conversion simple de la variable (CAST SQL).
 *      <br>
 *      Si une fonction de conversion existe dans cet arrimage pour convertir une variable du type
 *      de la variable vers le type de destination, on remplace la substitution par l'appel de cette
 *      fonction en ajoutant l'appel à la fonction de validation de la conversion.
 *      <br>
 *      Si aucune des conditions précédentes n'est remplie, on lève une exception. La conversion
 *      aurait dû avoir été spécifié lors de l'arrimage.
 *      <br>
 *      <br>
 *      NOTE: Les catégories JSON, ARRAY et OTHER ne peuvent pas être converties de façon triviale
 *      vers d'autres types de la même catégorie, puisque leur structure est directement lié à la
 *      sémantique du contenu. Par exemple, on ne veut pas automatiquement tronquer un tableau de
 *      longueur 5 en un tableau de longueur 2.
 *
 * @par Limites
 *      Les types limités ne sont pas supportés dans le modèle commun.
 *      S'il advenait que le modèle commun utilisait des types de données limités (par
 *      exemple VARCHAR(50)) les conversions vers ce type résulteraient en une possible perte de
 *      données sans avertissement puisqu'on considère que toutes variables peut être converties
 *      vers n'importe quel type dans la même catégorie que son type d'origine. Notez qu'il s'agit
 *      d'une limitation de Ontop, qui ne conserve pas les limites de types.
 *
 * @par Historique
 *      2024-02-02 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      - @todo 2024-02-02 [SD] - Corriger l'implémentation pour aller chercher les conversions
 *                                possibles dans le SGBD tel que documenté dans la conception.
 *                                Prendre exemple sur la conversion C_CLOB_VARCHAR2 du mapping
 *                                Omnimed Oracle.
 */
public class DataPropertyProjectionTransformer extends DefaultRecursiveIQTreeVisitingTransformer {
  private final MMecTermFactory termFactory;
  private final BasicSingleTermTypeExtractor typeExtractor;
  private final OntoRelCatRepository ontoRelCatRepository;
  private final MappingProperties mappingProperties;

  @Inject
  public DataPropertyProjectionTransformer(IntermediateQueryFactory iqFactory,
      TermFactory termFactory,
      BasicSingleTermTypeExtractor typeExtractor,
      OntoRelCatRepository ontoRelCatRepository,
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

          DBTermType targetType = getTargetSqlType(tree, rdfDatatype);
          Variable variable = term.getVariables().stream().findFirst().orElseThrow(
              () -> new DataPropertyProjectionTransformerException(tree,
                  "Cannot get the variable from the data property's substitution."));
          DBTermType variableType = (DBTermType) typeExtractor.extractSingleTermType(variable, tree)
              .filter(termType -> termType instanceof DBTermType)
              .orElseThrow(() -> new DataPropertyProjectionTransformerException(tree,
                  "Cannot get the type of the data property's substitution variable."));

          NonGroundFunctionalTerm valueTerm = termFactory.getMMecValueFunction(variable,
              variableType, rdfTermTypeConstant);
          if (targetType.getName().equals(variableType.getName())) {
            newSubstitutionMap.put(substitutionEntry.getKey(), valueTerm);
          } else if (isTrivialCast(variableType, targetType)) {
            newSubstitutionMap.put(substitutionEntry.getKey(),
                termFactory.getDBCastFunctionalTerm(variableType, targetType, valueTerm));
          } else {
            newSubstitutionMap.put(substitutionEntry.getKey(),
                termFactory.getMMecConversionFunction(valueTerm, variableType, targetType));

            // Remove the filter node if there was already one for this variable
            if (child.getRootNode() instanceof FilterNodeImpl filterNode
                && child.getChildren().size() == 1
                && filterNode.getFilterCondition().getVariables().size() == 1
                && filterNode.getFilterCondition().getVariables().contains(variable)) {
              child = child.getChildren().get(0);
            }
            child = iqFactory.createUnaryIQTree(
                iqFactory.createFilterNode(termFactory.getStrictEquality(
                    termFactory.getMMecConversionValidationFunction(valueTerm, variableType,
                        targetType),
                    termFactory.getDBBooleanConstant(true))),
                child);
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

  public static ImmutableMap<DBTermType.Category, ImmutableMap<DBTermType.Category, Boolean>>
  getTrivialCasts() {
    return ImmutableMap.of(
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
  }

  private DBTermType getTargetSqlType(IQTree iqTree, SimpleRDFDatatype rdfDatatype) {
    try {
      return ontoRelCatRepository.getSqlType(mappingProperties.getOntoRelId(),
              rdfDatatype.getIRI().getIRIString())
          .orElseThrow(() -> new DataPropertyProjectionTransformerException(iqTree,
              String.format("Cannot retrieve RDFDatatype <%s> from the OntoRelCat.",
                  rdfDatatype.getIRI().getIRIString())));
    } catch (SQLException e) {
      throw new DataPropertyProjectionTransformerException(iqTree, e);
    }
  }

  private boolean isTrivialCast(DBTermType variableType, DBTermType sqlDataType) {
    return getTrivialCasts().containsKey(variableType.getCategory()) &&
        Boolean.TRUE.equals(
            Objects.requireNonNull(getTrivialCasts().get(variableType.getCategory()))
                .getOrDefault(sqlDataType.getCategory(), false));
  }

  public static class DataPropertyProjectionTransformerException extends RuntimeException {
    public DataPropertyProjectionTransformerException(IQTree iqTree, String reason) {
      super(String.format("Impossible to transform the DataProperty from the following tree. {\n"
          + "Cause: \"%s\";\n"
          + "IQTree:\n%s\n}", reason, iqTree.toString()));
    }

    public DataPropertyProjectionTransformerException(IQTree iqTree, Throwable cause) {
      super(String.format("Impossible to transform the DataProperty from the following tree. {\n"
          + "Cause: \"%s\";\n"
          + "IQTree:\n%s\n}", cause.getMessage(), iqTree.toString()), cause);
    }
  }
}

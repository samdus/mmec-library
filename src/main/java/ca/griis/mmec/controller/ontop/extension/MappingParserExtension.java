/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de l'objet MappingParserExtension.
 * @brief @~english MappingParserExtension object implementation.
 */

package ca.griis.mmec.controller.ontop.extension;

import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecPostgreSqlDbFunctionSymbolFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingConversion;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.model.MMecTriplesMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import eu.optique.r2rml.api.model.TriplesMap;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBBooleanFunctionSymbol;
import it.unibz.inf.ontop.model.term.functionsymbol.db.DBTypeConversionFunctionSymbol;
import it.unibz.inf.ontop.model.type.DBTermType;
import it.unibz.inf.ontop.model.type.DBTypeFactory;
import it.unibz.inf.ontop.model.type.TypeFactory;
import it.unibz.inf.ontop.spec.mapping.PrefixManager;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMapping;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.Literal;
import org.apache.commons.rdf.api.Triple;
import org.apache.commons.rdf.rdf4j.RDF4J;

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
 * @brief @~french Étend le R2RMLMappingParser avec un prétraitement du graphe d'arrimage et un
 *        traitement avant la génération des PPMapping.
 *        Sert à étendre le modèle interne avec les fonctions R2RML étendues.
 * @par Détails
 *      L'arrimage R2RML étendu permet de spécifier les signatures de classes de façon à réduire les
 *      erreurs liées à l'individuation et améliorer la qualité de celle-ci.
 *
 *      En particulier, il s'agit d'inclure des triplets pour spécifier
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2023-09-05 [SD] - Implémentation initiale.
 *
 * @par Tâches
 * @todo 2023-09-06 [SD] - Faire la conception.
 */
public class MappingParserExtension {

  public static final String subsetIRI = "http://www.griis.ca/projects/mmec/subsets";
  private static final String conversionIri = "http://www.griis.ca/projects/mmec/conversion";
  public static final String conversionInputTypeIri =
      "http://www.griis.ca/projects/mmec/conversionInputType";
  public static final String conversionOutputTypeIri =
      "http://www.griis.ca/projects/mmec/conversionOutputType";
  public static final String conversionFunctionIri =
      "http://www.griis.ca/projects/mmec/conversionFunction";
  public static final String validationFunctionIri =
      "http://www.griis.ca/projects/mmec/validationFunction";
  private final MMecMappingExtension mappingExtension;
  private final SQLPPMappingFactory ppMappingFactory;
  private final RDF4J rdf;
  private final DBTypeFactory dbTypeFactory;
  private final MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory;

  @Inject
  public MappingParserExtension(TypeFactory typeFactory, MMecMappingExtension mappingExtension,
      SQLPPMappingFactory ppMappingFactory, RDF4J rdf,
      MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory) {
    this.mappingExtension = mappingExtension;
    this.ppMappingFactory = ppMappingFactory;
    this.rdf = rdf;
    this.dbTypeFactory = typeFactory.getDBTypeFactory();
    this.sqlDbFunctionSymbolFactory = sqlDbFunctionSymbolFactory;
  }

  /**
   * @brief @~english «Description of the function»
   * @param mappingGraph «Parameter description»
   * @param prefixes «Parameter description»
   *
   * @brief @~french Ajoute les triplets rr:template en concordance avec les fonctions R2RML
   *        étendues.
   * @par Details
   *     Pour chaque triplet <x, a, rr:TriplesMap> dans le graphe :
   *       p := x
   *       Jusqu'à ce qu'il n'existe pas de triplet <p, mmec:subsets, y> dans le graphe :
   *         p := y
   *       Obtenir <x, rr:subjectMap, xSubjectMap>
   *       Obtenir <p, rr:subjectMap, pSubjectMap>
   *       S'il existe un triplet <pSubjectMap, mmec:signId, pSignId> dans le graphe :
   *         idSign := pSignId
   *       Sinon :
   *         idSign := p.ntriplesString()
   *       S'il existe un triplet <xSubjectMap, mmec:signId, xSignId> dans le graphe,
   *           avec xSignId <> idSign :
   *         Lancer une exception
   *       Si le nombre de triplets <xSubjectMap, mmec:signComponent, ANY> est différent
   *           du nombre de triplets <pSubjectMap, mmec:signComponent, ANY>
   *         Lancer une exception
   *       Obtenir <mappingDef, mmec:templatePrefix, templatePrefix>
   *       componentString := Former une chaîne de caractère à partir des triplets
   *           <pSubjectMap, mmec:signComponent, c> en utilisant l'expression "/{" + c + "}"
   *       Ajouter un triplet <xSubjectMap, rr:template, templatePrefix + componentString>
   * --
   *   Note : Si p correspond à un mmec:SignatureSuperSet, il est possible que pSubjectMap, mais le
   *          traitement reste valide.
   * @param mappingGraph Le graphe d'arrimage.
   * @param prefixes Les préfixes de l'ontologie.
   *
   * @par Tâches
   *      S.O.
   */
  public void updateMappingGraphBeforeParse(Graph mappingGraph,
      ImmutableMap<String, String> prefixes) {

  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param tripleMaps «Parameter description»
   * @param sourceMappings «Parameter description»
   * @param prefixManager «Parameter description»
   * @return «Return description»
   *
   * @brief @~french «Description de la méthode»
   * @param mappingGraph «Description du paramètre»
   * @param tripleMaps «Description du paramètre»
   * @param sourceMappings «Description du paramètre»
   * @param prefixManager «Description du paramètre»
   * @return «Description du retour»
   *
   * @par Tâches
   *      S.O.
   */
  public SQLPPMapping getExtendedMapping(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
      ImmutableList<SQLPPTriplesMap> sourceMappings, PrefixManager prefixManager) {
    ImmutableList<SQLPPTriplesMap> extendedSourceMapping = getTriplesMap(mappingGraph, tripleMaps,
        sourceMappings);
    return ppMappingFactory.createSQLPreProcessedMapping(extendedSourceMapping, prefixManager);
  }

  /**
   * @brief @~english «Description of the function»
   * @param mappingGraph «Parameter description»
   * @param tripleMaps «Parameter description»
   * @param mapping «Parameter description»
   *
   * @brief @~french Ajoute les informations de l'arrimage R2RML étendu aux expressions d'arrimage
   *        Ontop.
   * @par Details
   *      TODO: Faire la conception de l'extension
   * @param mappingGraph Le graphe original de l'arrimage.
   * @param tripleMaps Les triplets d'arrimage importés du graphe
   * @param mapping Les expressions d'arrimage déduites converties à partir des triplets
   *
   * @par Tâches
   *      S.O.
   */
  private ImmutableList<SQLPPTriplesMap> getTriplesMap(Graph mappingGraph,
      Collection<TriplesMap> tripleMaps, ImmutableList<SQLPPTriplesMap> mapping) {
    ImmutableList<MMecTriplesMap> sourceMappings =
        mapping.stream().map(MMecTriplesMap::new).collect(ImmutableCollectors.toList());

    processSubSetExpressions(mappingGraph, tripleMaps, sourceMappings);
    processConversionExpressions(mappingGraph);

    return sourceMappings.stream().map(SQLPPTriplesMap.class::cast)
        .collect(ImmutableCollectors.toList());
  }

  private void processSubSetExpressions(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
      ImmutableList<MMecTriplesMap> sourceMappings) {
    Map<TriplesMap, List<TriplesMap>> hasSubset =
        mappingGraph.stream(null, rdf.createIRI(subsetIRI), null).map(
                axiom -> new ImmutablePair<>(
                    tripleMaps.stream()
                        .filter(triple -> triple.getNode().equals(axiom.getSubject()))
                        .findFirst().orElseThrow(),
                    tripleMaps.stream().filter(triple -> triple.getNode().equals(axiom.getObject()))
                        .findFirst().orElseThrow()))
            .collect(Collectors.groupingBy(ImmutablePair::getRight,
                Collectors.mapping(ImmutablePair::getLeft, Collectors.toList())));

    hasSubset.forEach(
        (supersetMapping, subsetMappingList) -> subsetMappingList.forEach(subsetMapping -> {
          MMecTriplesMap superSetSourceMapping = sourceMappings.stream().filter(
                  sourceMapping -> sourceMapping.getId()
                      .equals(String.format("mapping-%s", supersetMapping.hashCode())))
              .findFirst()
              .orElseThrow();
          MMecTriplesMap subSetSourceMapping = sourceMappings.stream().filter(
                  sourceMapping -> sourceMapping.getId()
                      .equals(String.format("mapping-%s", subsetMapping.hashCode())))
              .findFirst()
              .orElseThrow();

          superSetSourceMapping.addSubset(subSetSourceMapping);
        }));
  }

  private void processConversionExpressions(Graph mappingGraph) {
    List<? extends Triple> conversionTriples = mappingGraph.stream(null,
        rdf.createIRI("http://www.w3.org/1999/02/22-rdf-syntax-ns#type"),
        rdf.createIRI(conversionIri)).toList();

    for (Triple conversionTriple : conversionTriples) {
      DBTermType declaredInputType = mappingGraph.stream(conversionTriple.getSubject(),
              rdf.createIRI(conversionInputTypeIri), null)
          .map(Triple::getObject)
          .filter(term -> term instanceof Literal)
          .map(Literal.class::cast)
          .map(Literal::getLexicalForm)
          .map(dbTypeFactory::getDBTermType)
          .findFirst()
          .orElseThrow();
      DBTermType declaredOutputType = mappingGraph.stream(conversionTriple.getSubject(),
              rdf.createIRI(conversionOutputTypeIri), null)
          .map(Triple::getObject)
          .filter(term -> term instanceof Literal)
          .map(Literal.class::cast)
          .map(Literal::getLexicalForm)
          .map(dbTypeFactory::getDBTermType)
          .findFirst()
          .orElseThrow();
      Optional<DBTypeConversionFunctionSymbol> declaredConversionFunction = mappingGraph.stream(
              conversionTriple.getSubject(),
              rdf.createIRI(conversionFunctionIri), null)
          .map(Triple::getObject)
          .filter(term -> term instanceof Literal)
          .map(Literal.class::cast)
          .map(Literal::getLexicalForm)
          .map(functionName -> sqlDbFunctionSymbolFactory.createMMecConversionFunctionSymbol(
              functionName, declaredInputType, declaredOutputType))
          .findFirst();
      Optional<DBBooleanFunctionSymbol> declaredValidationFunction = mappingGraph.stream(
              conversionTriple.getSubject(),
              rdf.createIRI(validationFunctionIri), null)
          .map(Triple::getObject)
          .filter(term -> term instanceof Literal)
          .map(Literal.class::cast)
          .map(Literal::getLexicalForm)
          .map(functionName -> sqlDbFunctionSymbolFactory
              .createMMecConversionValidationFunctionSymbol(functionName,
                  declaredInputType, declaredOutputType))
          .findFirst();

      mappingExtension.addMappingConversion(
          new MMecMappingConversion(declaredInputType, declaredOutputType,
              declaredConversionFunction,
              declaredValidationFunction));
    }
  }
}

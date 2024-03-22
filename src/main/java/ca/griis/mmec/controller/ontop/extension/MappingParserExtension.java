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

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.model.term.functionsymbol.db.MMecPostgreSqlDbFunctionSymbolFactory;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingConversion;
import ca.griis.mmec.controller.ontop.spec.mapping.MMecMappingExtension;
import ca.griis.mmec.model.MMecTriplesMap;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import eu.optique.r2rml.api.model.R2RMLVocabulary;
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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.IRI;
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
 *      erreurs liées à l'individuation et améliorer la qualité de celle-ci. Elle permet aussi de
 *      spécifier des fonctions de conversion de type pour les valeurs littérales.
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
 *      S.O.
 */
public class MappingParserExtension {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MappingParserExtension.class);
  private final MMecMappingExtension mappingExtension;
  private final SQLPPMappingFactory ppMappingFactory;
  private final RDF4J rdf;
  private final TypeFactory typeFactory;
  private final MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory;

  private static final String nsTypeIri = "http://www.w3.org/1999/02/22-rdf-syntax-ns#type";

  @Inject
  public MappingParserExtension(TypeFactory typeFactory, MMecMappingExtension mappingExtension,
      SQLPPMappingFactory ppMappingFactory, RDF4J rdf,
      MMecPostgreSqlDbFunctionSymbolFactory sqlDbFunctionSymbolFactory) {
    this.typeFactory = typeFactory;
    this.mappingExtension = mappingExtension;
    this.ppMappingFactory = ppMappingFactory;
    this.rdf = rdf;
    this.sqlDbFunctionSymbolFactory = sqlDbFunctionSymbolFactory;
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param prefixes «Parameter description»
   *
   * @brief @~french Prétraitement du graphe d'arrimage avant la génération des PPMapping.
   * @param mappingGraph Le graphe d'arrimage.
   * @param prefixes Les préfixes de l'arrimage.
   */
  public void updateMappingGraphBeforeParse(Graph mappingGraph,
      ImmutableMap<String, String> prefixes) {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, prefixes);
    generateTemplates(mappingGraph, prefixes);
    logger.trace(Trace.EXIT_METHOD_0);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param tripleMaps «Parameter description»
   * @param sourceMappings «Parameter description»
   * @param prefixManager «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Ajoute les informations de l'arrimage R2RML étendu aux expressions d'arrimage
   *                 Ontop.
   * @param mappingGraph Le graphe d'arrimage.
   * @param tripleMaps Les triplets d'arrimage importés du graphe.
   * @param sourceMappings Les expressions d'arrimage déduites converties à partir des triplets.
   * @param prefixManager Le gestionnaire de préfixes.
   * @return Le mapping mMEc.
   *
   * @par Tâches
   *      S.O.
   */
  public SQLPPMapping getExtendedMapping(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
      ImmutableList<SQLPPTriplesMap> sourceMappings, PrefixManager prefixManager) {
    logger.trace(Trace.ENTER_METHOD_4, mappingGraph, tripleMaps, sourceMappings, prefixManager);
    ImmutableList<MMecTriplesMap> mmecSourceMappings =
        sourceMappings.stream().map(MMecTriplesMap::new).collect(ImmutableCollectors.toList());

    processSubSetExpressions(mappingGraph, tripleMaps, mmecSourceMappings);
    processConversionExpressions(mappingGraph);

    ImmutableList<SQLPPTriplesMap> extendedSourceMapping = mmecSourceMappings.stream().map(
            SQLPPTriplesMap.class::cast)
        .collect(ImmutableCollectors.toList());

    return ppMappingFactory.createSQLPreProcessedMapping(extendedSourceMapping, prefixManager);
  }

  /**
   * @brief @~english «Description of the function»
   * @param mappingGraph «Parameter description»
   * @param prefixes «Parameter description»
   *
   * @brief @~french Ajoute les triplets rr:template en concordance avec les fonctions R2RML
   *        étendues.
   * @par Details
   *      Pour chaque triplet <x, a, rr:TriplesMap> dans le graphe :
   *        p := x
   *        Jusqu'à ce qu'il n'existe pas de triplet <p, mmec:subsets, y> dans le graphe :
   *          p := y
   *        Obtenir <x, rr:subjectMap, xSubjectMap>
   *        Obtenir <p, rr:subjectMap, pSubjectMap>
   *        S'il existe <xSubjectMap, rr:template, xTemplate>
   *          S'il existe <ANY, mmec:subsets, x> ou si p <> x :
   *            Lancer une exception
   *          Sinon Si le mapping ne défini pas ses composants de signatures
   *            Passer au triplet suivant
   *          Sinon
   *            Lancer un avertissement
   *            Retirer le triplet <xSubjectMap, rr:template, xTemplate>
   *        S'il existe un triplet <pSubjectMap, mmec:signatudeScope, pSignScope> dans le graphe :
   *          signScope := pSignScope
   *        Sinon :
   *          signScope := p.ntriplesString()
   *        S'il existe un triplet <xSubjectMap, mmec:signatudeScope, xSignScope> dans le graphe,
   *            avec xSignScope <> signScope :
   *          Lancer une exception
   *        Si le nombre de triplets <xSubjectMap, mmec:signComponent, ANY> est différent
   *            du nombre de triplets <pSubjectMap, mmec:signComponent, ANY>
   *          Lancer une exception
   *        Obtenir <mappingDef, mmec:templatePrefix, templatePrefix>
   *        componentString := Former une chaîne de caractère à partir des triplets
   *            <pSubjectMap, mmec:signComponent, c> en utilisant l'expression "/{" + c + "}"
   *        Ajouter un triplet <xSubjectMap, rr:template, templatePrefix+signScope+componentString>
   *      --
   *      Notes :
   *        - Si p correspond à un mmec:SignatureSuperSet, il est possible que le pSubjectMap
   *          n'existe pas, mais le traitement reste valide.
   *        - La chaîne de caractère générée pour signScope doit être encodée pour un URL
   * @param mappingGraph Le graphe d'arrimage.
   * @param prefixes Les préfixes de l'arrimage.
   *
   * @par Tâches
   *      2024-03-21 [SD] - Tester cette méthode.
   */
  protected void generateTemplates(Graph mappingGraph,
      ImmutableMap<String, String> prefixes) {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, prefixes);

    String templatePrefix = getLiteral(mappingGraph, null,
        rdf.createIRI(MMecVocabulary.MAPPING_TEMPLATE_PREFIX)).orElseThrow();

    for (Triple currentTriple : mappingGraph.stream(null, rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_TRIPLES_MAP)).toList()) {
      generateTemplate(mappingGraph, templatePrefix, currentTriple.getSubject());
    }
    logger.trace(Trace.EXIT_METHOD_0);
  }

  protected void generateTemplate(Graph mappingGraph, String templatePrefix,
      BlankNodeOrIRI current) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, templatePrefix, current);

    BlankNodeOrIRI parent = getParentRoot(mappingGraph, current);
    BlankNodeOrIRI currentSubjectMap = getObject(mappingGraph, current,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP)).orElseThrow();
    final Optional<BlankNodeOrIRI> parentSubjectMap = getObject(mappingGraph, parent,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP));
    final Optional<String> currentSignScope = getLiteral(mappingGraph, currentSubjectMap,
    Optional<String> currentSignScope = getLiteral(mappingGraph, currentSubjectMap,
        rdf.createIRI(MMecVocabulary.SIGNATURE_SCOPE));
    Optional<String> currentTemplate = getLiteral(mappingGraph, currentSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE));
    List<String> currentComponents = getAllLiterals(mappingGraph, currentSubjectMap,
        rdf.createIRI(MMecVocabulary.SIGNATURE_COMPONENT));

    final String signScope = parentSubjectMap
        .flatMap(subjectMap -> getLiteral(mappingGraph, subjectMap,
            rdf.createIRI(MMecVocabulary.SIGNATURE_SCOPE)))
        .orElse(parent.ntriplesString());
    final List<String> parentComponents = parentSubjectMap
        .map(subjectMap -> getAllLiterals(mappingGraph, subjectMap,
            rdf.createIRI(MMecVocabulary.SIGNATURE_COMPONENT)))
        .orElse(List.of());
    if (currentTemplate.isPresent()) {
      if (current.equals(parent) &&
          mappingGraph.stream(null, rdf.createIRI(MMecVocabulary.SIGNATURE_SUBSETS), current)
              .findAny().isEmpty()) {
        if (currentComponents.isEmpty()) {
          return;
        } else {
          logger.warn("The mapping '" + current.ntriplesString() + "' defined " +
              "a rr:template that will be overwritten by the mmec extension");
          mappingGraph.remove(currentSubjectMap, rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
              null);
        }
      } else {
        throw new SubsetHasTemplateException(current);
      }
    }

    if (currentSignScope.isPresent() && !currentSignScope.get().equals(signScope)) {
      throw new SignatureScopeMismatchException(current);
    }

    if (currentComponents.isEmpty()) {
      throw new SignatureComponentMissingException(current);
    }

    if (mappingGraph.stream(parent, rdf.createIRI(nsTypeIri),
        rdf.createIRI(MMecVocabulary.SIGNATURE_SUPERSET)).findAny().isEmpty()
        && currentComponents.size() != parentComponents.size()) {
      throw new SignatureComponentMismatchException(current, parent);
    }

    String componentString = currentComponents.stream()
        .map(component -> "{" + component + "}")
        .collect(Collectors.joining("/"));
    String signScopeUrlEncoded = URLEncoder.encode(signScope, StandardCharsets.UTF_8);

    mappingGraph.add(currentSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_TEMPLATE),
        rdf.createLiteral(templatePrefix + "/" + signScopeUrlEncoded + "/" + componentString));
    logger.trace(Trace.EXIT_METHOD_0);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param tripleMaps «Parameter description»
   * @param sourceMappings «Parameter description»
   *
   * @brief @~french Associe les expressions d'arrimage aux expressions qui sont déclarés comme
   *                 leur sous-ensemble.
   * @param mappingGraph Le graphe d'arrimage.
   * @param tripleMaps Les triplets d'arrimage importés du graphe.
   * @param sourceMappings Les expressions d'arrimage déduites converties à partir des triplets.
   */
  protected void processSubSetExpressions(Graph mappingGraph, Collection<TriplesMap> tripleMaps,
      ImmutableList<MMecTriplesMap> sourceMappings) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, tripleMaps, sourceMappings);
    Map<TriplesMap, List<TriplesMap>> hasSubset =
        mappingGraph.stream(null, rdf.createIRI(MMecVocabulary.SIGNATURE_SUBSETS), null)
            .filter(axiom ->
            // If the superset is a SIGNATURE_SUPERSET, it's not required in the hasSubset Map
            mappingGraph.stream((BlankNodeOrIRI) axiom.getObject(), rdf.createIRI(nsTypeIri),
                rdf.createIRI(MMecVocabulary.SIGNATURE_SUPERSET))
                .findAny().isEmpty())
            .map(
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

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   *
   * @brief @~french Traite les expressions de conversion.
   * @param mappingGraph Le graphe d'arrimage.
   */
  protected void processConversionExpressions(Graph mappingGraph) {
    logger.trace(Trace.ENTER_METHOD_1, mappingGraph);
    List<? extends Triple> conversionTriples = mappingGraph.stream(null,
        rdf.createIRI(nsTypeIri),
        rdf.createIRI(MMecVocabulary.CONVERSION)).toList();
    DBTypeFactory dbTypeFactory = typeFactory.getDBTypeFactory();

    for (Triple conversionTriple : conversionTriples) {
      DBTermType declaredInputType = mappingGraph.stream(conversionTriple.getSubject(),
              rdf.createIRI(MMecVocabulary.CONVERSION_INPUT_TYPE), null)
          .map(Triple::getObject)
          .filter(term -> term instanceof Literal)
          .map(Literal.class::cast)
          .map(Literal::getLexicalForm)
          .map(dbTypeFactory::getDBTermType)
          .findFirst()
          .orElseThrow();
      DBTermType declaredOutputType = mappingGraph.stream(conversionTriple.getSubject(),
              rdf.createIRI(MMecVocabulary.CONVERSION_OUTPUT_TYPE), null)
          .map(Triple::getObject)
          .filter(term -> term instanceof Literal)
          .map(Literal.class::cast)
          .map(Literal::getLexicalForm)
          .map(dbTypeFactory::getDBTermType)
          .findFirst()
          .orElseThrow();
      Optional<DBTypeConversionFunctionSymbol> declaredConversionFunction = mappingGraph.stream(
              conversionTriple.getSubject(),
              rdf.createIRI(MMecVocabulary.CONVERSION_FUNCTION), null)
          .map(Triple::getObject)
          .filter(term -> term instanceof Literal)
          .map(Literal.class::cast)
          .map(Literal::getLexicalForm)
          .map(functionName -> sqlDbFunctionSymbolFactory.createMMecConversionFunctionSymbol(
              functionName, declaredInputType, declaredOutputType))
          .findFirst();
      Optional<DBBooleanFunctionSymbol> declaredValidationFunction = mappingGraph.stream(
              conversionTriple.getSubject(),
              rdf.createIRI(MMecVocabulary.CONVERSION_VALIDATION_FUNCTION), null)
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

    logger.trace(Trace.EXIT_METHOD_0);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param subject «Parameter description»
   * @param predicate «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtenir l'objet BlankNodeOrIRI d'un triplet.
   * @param mappingGraph Le graphe duquel extraire le triplet.
   * @param subject Le sujet du triplet.
   * @param predicate Le prédicat du triplet.
   * @return L'objet du triplet, s'il s'agit d'un BlankNodeOrIRI
   */
  private static Optional<BlankNodeOrIRI> getObject(Graph mappingGraph, BlankNodeOrIRI subject,
      IRI predicate) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, subject, predicate);
    return mappingGraph.stream(subject, predicate, null)
        .map(Triple::getObject)
        .filter(term -> term instanceof BlankNodeOrIRI)
        .map(term -> (BlankNodeOrIRI) term)
        .findFirst();
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param subject «Parameter description»
   * @param predicate «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtenir la forme lexicale de la valeur littérale d'un triplet.
   * @param mappingGraph Le graphe duquel extraire le triplet.
   * @param subject Le sujet du triplet.
   * @param predicate Le prédicat du triplet.
   * @return La forme lexicale de la valeur littérale d'un triplet.
   */
  private static Optional<String> getLiteral(Graph mappingGraph, BlankNodeOrIRI subject,
      IRI predicate) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, subject, predicate);
    return mappingGraph.stream(subject, predicate, null)
        .map(Triple::getObject)
        .filter(term -> term instanceof Literal)
        .map(term -> (Literal) term)
        .map(Literal::getLexicalForm)
        .findFirst();
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param subject «Parameter description»
   * @param predicate «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtenir la forme lexicale de la valeur littérale de tous les triplets.
   * @param mappingGraph Le graphe duquel extraire le triplet.
   * @param subject Le sujet des triplets.
   * @param predicate Le prédicat des triplets.
   * @return Une liste de la forme lexicale de la valeur littérale des triplets.
   */
  private static List<String> getAllLiterals(Graph mappingGraph, BlankNodeOrIRI subject,
      IRI predicate) {
    logger.trace(Trace.ENTER_METHOD_3, mappingGraph, subject, predicate);
    return mappingGraph.stream(subject, predicate, null)
        .map(Triple::getObject)
        .filter(term -> term instanceof Literal)
        .map(term -> (Literal) term)
        .map(Literal::getLexicalForm)
        .toList();
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param current «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Obtient le parent le plus haut dans la hierarchie de superset
   * @param mappingGraph Le graphe d'arrimage
   * @param current Le noeud courant
   * @return Le prochain noeud sans parent dans la chaîne de subsets
   */
  private BlankNodeOrIRI getParentRoot(Graph mappingGraph, BlankNodeOrIRI current) {
    Optional<BlankNodeOrIRI> parent = getObject(mappingGraph, current,
        rdf.createIRI(MMecVocabulary.SIGNATURE_SUBSETS));
    if (parent.isPresent()) {
      return getParentRoot(mappingGraph, parent.get());
    }
    return current;
  }

  public static class IllegalMappingException extends IllegalStateException {
    private final BlankNodeOrIRI invalidNode;

    public IllegalMappingException(BlankNodeOrIRI invalidNode, String reason) {
      super(String.format("The mapping '%s' is invalid: %s", getNodeName(invalidNode), reason));
      this.invalidNode = invalidNode;
    }

    protected static String getNodeName(BlankNodeOrIRI current) {
      return current.ntriplesString();
    }

    public BlankNodeOrIRI getInvalidNode() {
      return invalidNode;
    }
  }


  public static class SubsetHasTemplateException extends IllegalMappingException {
    public SubsetHasTemplateException(BlankNodeOrIRI invalidNode) {
      super(invalidNode, "it has a template while it depends on another subject map.");
    }
  }


  public static class SignatureScopeMismatchException extends IllegalMappingException {
    public SignatureScopeMismatchException(BlankNodeOrIRI invalidNode) {
      super(invalidNode, "it has a different signature scope than the one it depends on.");
    }
  }


  public static class SignatureComponentMismatchException extends IllegalMappingException {
    private final BlankNodeOrIRI parentNode;

    public SignatureComponentMismatchException(BlankNodeOrIRI invalidNode,
        BlankNodeOrIRI parentNode) {
      super(invalidNode, String.format(
          "it has a different number of signature components than the one it depends on (%s).",
          getNodeName(parentNode)));
      this.parentNode = parentNode;
    }

    public BlankNodeOrIRI getParentNode() {
      return parentNode;
    }
  }


  public static class SignatureComponentMissingException extends IllegalMappingException {
    public SignatureComponentMissingException(BlankNodeOrIRI current) {
      super(current, "it has no signature components.");
    }
  }
}

/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe MMecParserRefSubjectMapExtension.
 * @brief @~english MMecParserRefSubjectMapExtension class implementation.
 */

package ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.before;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.MappingExtendedBeforeParsing;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.InvalidRefSubjectMapException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.JoinConditionWithoutChildColumnException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.JoinConditionWithoutParentColumnException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.LogicalTableWithoutSqlQueryNorTableNameException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.RefSubjectMapWithoutParentTriplesMapException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SignatureWithoutLogicalTableException;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.exception.SignatureWithoutSubjectMapException;
import ca.griis.mmec.model.MMecVocabulary;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import eu.optique.r2rml.api.model.R2RMLVocabulary;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.rdf.api.BlankNodeOrIRI;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.api.Triple;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.apache.commons.rdf.rdf4j.RDF4JBlankNode;

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
 * @brief @~french Extension de l'arrimage qui permet de traiter les RefSubjectMap
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
 *      2024-04-10 [SD] - Extraction de la classe depuis MappingParserExtension<br>
 *      2024-04-03 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecParserRefSubjectMapExtension extends MappingExtendedBeforeParsing {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecParserRefSubjectMapExtension.class);

  @Inject
  public MMecParserRefSubjectMapExtension(RDF4J rdf) {
    super(rdf);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param prefixes «Parameter description»
   *
   * @brief @~french Traite les RefSubjectMap en modifiant le logicalTable en incluant la requête
   *        du parent, en copiant les attributs du subjectMap du parent et en ajoutant les
   *        éventuels mmec:subsets du parent.
   * @par Details
   *      Pour chaque triplet <child, mmec:refSubjectMap, childRefSubjectMap> dans le graphe :
   *      __Obtenir le triplet <childRefSubjectMap, rr:parentTriplesMap, parentTriplesMap>
   *      __Obtenir le triplet <parentTriplesMap, rr:subjectMap, parentSubjectMap>
   *      __Obtenir le triplet <parentTriplesMap, mmec:subsets, parentSubsets>
   *      __Obtenir le triplet <parentTriplesMap, rr:logicalTable, parentLogicalTable>
   *      __Obtenir le triplet <parentLogicalTable, rr:sqlQuery, parentSqlQuery>
   *      __Obtenir le triplet <parentLogicalTable, rr:tableName, parentTable>
   *      __Obtenir le triplet <child, rr:logicalTable, childLogicalTable>
   *      __Obtenir le triplet <childLogicalTable, rr:sqlQuery, childSqlQuery>
   *      __Obtenir le triplet <childLogicalTable, rr:tableName, childTable>
   *      __Obtenir les triplets <childRefSubjectMap, rr:joinCondition, {joinConditions}>
   *      __
   *      __Si la valeur parentSqlQuery n'existe pas :
   *      ____parentSqlQuery = "SELECT * FROM " + parentTable
   *      __
   *      __Si la valeur childSqlQuery n'existe pas :
   *      ____childSqlQuery = "SELECT * FROM " + childTable
   *      __
   *      __Si joinConditions est vide :
   *      ____query = "SELECT * FROM (" + childSqlQuery + ") AS tmp"
   *      __Sinon :
   *      ____Pour chaque condition dans joinConditions :
   *      ______Obtenir le triplet <condition, rr:child, childColumn>
   *      ______Obtenir le triplet <condition, rr:parent, parentColumn>
   *      ______Ajout à joinConditionString, séparé par un "AND" : childColumn + " = " +
   *      parentColumn
   *      ________Sauf si tous les couples (childColumn, parentColumn) sont identiques, alors
   *      ________utiliser "USING" au lieu de "ON"
   *      ____query = "SELECT *
   *      _____________FROM (" + childSqlQuery + ") AS child
   *      _____________JOIN (" + parentSqlQuery + ") AS parent
   *      _______________" + joinConditionString
   *      __
   *      __retirer le triplet <child, rr:logicalTable, childLogicalTable>
   *      __ajouter un triplet <child, rr:logicalTable, newLogicalTable>
   *      __ajouter un triplet <newLogicalTable, rdf:type, rr:R2RMLView>
   *      __ajouter un triplet <newLogicalTable, rr:sqlQuery, query>
   *      __ajouter un triplet <child, rr:subjectMap, parentSubjectMap>
   *      __ajouter un triplet <child, mmec:subsets, parentTriplesMap>
   *      __Si parentSubsets existe :
   *      ____ajouter un triplet <child, mmec:subsets, parentSubsets>
   * @param mappingGraph Graph d'arrimage.
   * @param prefixes Préfixes de l'arrimage.
   */
  @Override
  public void updateGraph(Graph mappingGraph, ImmutableMap<String, String> prefixes) {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, prefixes);

    for (Triple currentTriple : mappingGraph.stream(null,
        rdf.createIRI(MMecVocabulary.P_REF_SUBJECT_MAP), null).toList()) {
      BlankNodeOrIRI subject = currentTriple.getSubject();
      BlankNodeOrIRI object = Optional.of(currentTriple.getObject())
          .filter(o -> o instanceof BlankNodeOrIRI)
          .map(o -> (BlankNodeOrIRI) o)
          .orElseThrow(() -> new InvalidRefSubjectMapException(subject));
      processRefSubjectMap(mappingGraph, subject, object);
    }

    logger.trace(Trace.EXIT_METHOD_0);
  }

  /**
   * @brief @~english «Description of the method»
   * @param mappingGraph «Parameter description»
   * @param child «Parameter description»
   * @param childRefSubjectMap «Parameter description»
   *
   * @brief @~french Traitement d'un seul RefSubjectMap.
   * @param mappingGraph Graph d'arrimage.
   * @param child Référence du sujet enfant.
   * @param childRefSubjectMap Référence du sujet enfant.
   */
  protected void processRefSubjectMap(Graph mappingGraph, BlankNodeOrIRI child,
      BlankNodeOrIRI childRefSubjectMap) {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, child);

    final BlankNodeOrIRI parentTriplesMap = getObject(mappingGraph, childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_PARENT_TRIPLES_MAP))
            .orElseThrow(() -> new RefSubjectMapWithoutParentTriplesMapException(child));
    final BlankNodeOrIRI parentSubjectMap = getObject(mappingGraph, parentTriplesMap,
        rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP))
            .orElseThrow(() -> new SignatureWithoutSubjectMapException(parentTriplesMap));
    final Optional<BlankNodeOrIRI> parentSubsets = getObject(mappingGraph, parentTriplesMap,
        rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS));
    final BlankNodeOrIRI parentLogicalTable = getObject(mappingGraph, parentTriplesMap,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE))
            .orElseThrow(() -> new SignatureWithoutLogicalTableException(parentTriplesMap));
    final Optional<String> maybeParentSqlQuery = getLiteral(mappingGraph, parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY));
    final Optional<String> parentTable = getLiteral(mappingGraph, parentLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME));
    final BlankNodeOrIRI childLogicalTable = getObject(mappingGraph, child,
        rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE))
            .orElseThrow(() -> new SignatureWithoutLogicalTableException(child));
    final Optional<String> maybeChildSqlQuery = getLiteral(mappingGraph, childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY));
    final Optional<String> childTable = getLiteral(mappingGraph, childLogicalTable,
        rdf.createIRI(R2RMLVocabulary.PROP_TABLE_NAME));
    final List<BlankNodeOrIRI> joinConditions = mappingGraph.stream(childRefSubjectMap,
        rdf.createIRI(R2RMLVocabulary.PROP_JOIN_CONDITION), null)
        .map(Triple::getObject)
        .filter(o -> o instanceof BlankNodeOrIRI)
        .map(o -> (BlankNodeOrIRI) o)
        .toList();

    final String parentSqlQuery = maybeParentSqlQuery
        .orElseGet(() -> "SELECT * FROM "
            + parentTable
                .map(String::trim)
                .orElseThrow(
                    () -> new LogicalTableWithoutSqlQueryNorTableNameException(
                        parentLogicalTable)));
    final String childSqlQuery = maybeChildSqlQuery.orElseGet(() -> "SELECT * FROM "
        + childTable
            .map(String::trim)
            .orElseThrow(
                () -> new LogicalTableWithoutSqlQueryNorTableNameException(childLogicalTable)));

    final String query;
    if (joinConditions.isEmpty()) {
      query = "SELECT * FROM (" + childSqlQuery + ") AS tmp";
    } else {
      List<Pair<String, String>> joins = joinConditions.stream()
          .map(condition -> {
            String childColumn = getLiteral(mappingGraph, condition,
                rdf.createIRI(R2RMLVocabulary.PROP_CHILD))
                    .orElseThrow(() -> new JoinConditionWithoutChildColumnException(condition));
            String parentColumn = getLiteral(mappingGraph, condition,
                rdf.createIRI(R2RMLVocabulary.PROP_PARENT))
                    .orElseThrow(() -> new JoinConditionWithoutParentColumnException(condition));
            return Pair.of(childColumn.trim(), parentColumn.trim());
          }).toList();

      String joinConditionString;
      if (joins.stream().allMatch(pair -> pair.getLeft().equals(pair.getRight()))) {
        joinConditionString = String.format("USING (%s)",
            joins.stream().map(Pair::getLeft).collect(Collectors.joining(", ")));
      } else {
        joinConditionString = String.format("ON %s",
            joins.stream()
                .map(pair -> String.format("child.%s = parent.%s", pair.getLeft(), pair.getRight()))
                .collect(Collectors.joining("\n    AND ")));
      }

      query = "SELECT *\n"
          + "FROM (" + childSqlQuery + ") AS child\n"
          + "JOIN (" + parentSqlQuery + ") AS parent\n"
          + "  " + joinConditionString;
    }

    RDF4JBlankNode newLogicalTable = rdf.createBlankNode();
    mappingGraph.remove(child, rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE),
        childLogicalTable);
    mappingGraph.add(child, rdf.createIRI(R2RMLVocabulary.PROP_LOGICAL_TABLE), newLogicalTable);
    mappingGraph.add(newLogicalTable, rdf.createIRI(nsTypeIri),
        rdf.createIRI(R2RMLVocabulary.TYPE_R2RML_VIEW));
    mappingGraph.add(newLogicalTable, rdf.createIRI(R2RMLVocabulary.PROP_SQL_QUERY),
        rdf.createLiteral(query));
    mappingGraph.add(child, rdf.createIRI(R2RMLVocabulary.PROP_SUBJECT_MAP), parentSubjectMap);
    mappingGraph.add(child, rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS), parentTriplesMap);

    if (parentSubsets.isPresent()) {
      mappingGraph.add(child, rdf.createIRI(MMecVocabulary.P_SIGNATURE_SUBSETS),
          parentSubsets.get());
    }

    logger.trace(Trace.EXIT_METHOD_0);
  }
}

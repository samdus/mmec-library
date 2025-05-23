/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Copie de l'implémentation de
 *  * it.unibz.inf.ontop.spec.mapping.parser.impl.R2RMLMappingParser.
 * @brief @~english Copy of the implementation of
 *  * it.unibz.inf.ontop.spec.mapping.parser.impl.R2RMLMappingParser including an extension.
 */

package it.unibz.inf.ontop.spec.mapping.parser.impl;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.mmec.controller.ontop.spec.mapping.parser.extension.MappingParserExtension;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import eu.optique.r2rml.api.binding.rdf4j.RDF4JR2RMLMappingManager;
import eu.optique.r2rml.api.model.TriplesMap;
import eu.optique.r2rml.api.model.impl.InvalidR2RMLMappingException;
import it.unibz.inf.ontop.exception.InvalidMappingException;
import it.unibz.inf.ontop.exception.MappingIOException;
import it.unibz.inf.ontop.injection.SpecificationFactory;
import it.unibz.inf.ontop.spec.mapping.PrefixManager;
import it.unibz.inf.ontop.spec.mapping.parser.SQLMappingParser;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMapping;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Collection;
import org.apache.commons.rdf.api.Graph;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.eclipse.rdf4j.model.Namespace;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFHandlerException;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.rio.RDFParser;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.helpers.StatementCollector;

/**
 * High-level class that implements the MappingParser interface for R2RML.
 */
public class MMecR2rmlMappingParserImpl implements SQLMappingParser {
  private static final GriisLogger logger =
      GriisLoggerFactory.getLogger(MMecR2rmlMappingParserImpl.class);
  private final SpecificationFactory specificationFactory;
  private final R2RMLToSQLPPTriplesMapConverter transformer;
  private final RDF4JR2RMLMappingManager manager;
  private final MappingParserExtension mappingParserExtension;


  @Inject
  public MMecR2rmlMappingParserImpl(SpecificationFactory specificationFactory,
      R2RMLToSQLPPTriplesMapConverter transformer,
      MappingParserExtension mappingParserExtension) {
    this.specificationFactory = specificationFactory;
    this.transformer = transformer;
    this.manager = RDF4JR2RMLMappingManager.getInstance();
    this.mappingParserExtension = mappingParserExtension;
  }

  @Override
  public SQLPPMapping parse(File mappingFile) throws InvalidMappingException, MappingIOException {
    logger.trace(Trace.ENTER_METHOD_1, mappingFile);

    LinkedHashModel rdf4jGraph = new LinkedHashModel();
    RDFParser parser = Rio.createParser(RDFFormat.TURTLE);
    StatementCollector collector = new StatementCollector(rdf4jGraph);
    parser.setRDFHandler(collector);
    try (InputStream in = new FileInputStream(mappingFile)) {
      URL documentUrl = new URL("file://" + mappingFile);
      parser.parse(in, documentUrl.toString());
      return parse(new RDF4J().asGraph(rdf4jGraph), extractPrefixes(rdf4jGraph));
    } catch (IOException e) {
      throw new MappingIOException(e);
    } catch (RDFParseException | RDFHandlerException e) {
      throw new InvalidMappingException(e.getMessage());
    }
  }

  @Override
  public SQLPPMapping parse(Reader reader) throws InvalidMappingException, MappingIOException {
    logger.trace(Trace.ENTER_METHOD_1, reader);

    LinkedHashModel rdf4jGraph = new LinkedHashModel();
    RDFParser parser = Rio.createParser(RDFFormat.TURTLE);
    StatementCollector collector = new StatementCollector(rdf4jGraph);
    parser.setRDFHandler(collector);
    try (Reader r = reader) {
      // TODO: get the base IRI in a proper way
      parser.parse(r, "http://example.org/baseIRI/");
      return parse(new RDF4J().asGraph(rdf4jGraph), extractPrefixes(rdf4jGraph));
    } catch (IOException e) {
      throw new MappingIOException(e);
    } catch (RDFParseException | RDFHandlerException e) {
      throw new InvalidMappingException(e.getMessage());
    }
  }

  @Override
  public SQLPPMapping parse(Graph mappingGraph) throws InvalidMappingException {
    logger.trace(Trace.ENTER_METHOD_1, mappingGraph);
    return parse(mappingGraph, ImmutableMap.of());
  }

  protected SQLPPMapping parse(Graph mappingGraph, ImmutableMap<String, String> prefixes)
      throws InvalidMappingException {
    logger.trace(Trace.ENTER_METHOD_2, mappingGraph, prefixes);
    try {
      mappingParserExtension.updateMappingGraphBeforeParse(mappingGraph, prefixes);

      Collection<TriplesMap> tripleMaps = manager.importMappings(mappingGraph);

      ImmutableList<SQLPPTriplesMap> sourceMappings = transformer.convert(tripleMaps);

      PrefixManager prefixManager = specificationFactory.createPrefixManager(prefixes);

      return mappingParserExtension.getExtendedMapping(mappingGraph, tripleMaps, sourceMappings,
          prefixManager);
    } catch (InvalidR2RMLMappingException e) {
      throw new InvalidMappingException(e.getMessage());
    }
  }

  private ImmutableMap<String, String> extractPrefixes(LinkedHashModel rdf4jGraph) {
    logger.trace(Trace.ENTER_METHOD_1, rdf4jGraph);
    return rdf4jGraph.getNamespaces().stream()
        .collect(ImmutableCollectors.toMap(
            namespace -> namespace.getPrefix() + ":",
            Namespace::getName));
  }
}

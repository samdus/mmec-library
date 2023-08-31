package it.unibz.inf.ontop.spec.mapping.parser.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import eu.optique.r2rml.api.binding.rdf4j.RDF4JR2RMLMappingManager;
import eu.optique.r2rml.api.model.TriplesMap;
import eu.optique.r2rml.api.model.impl.InvalidR2RMLMappingException;
import it.unibz.inf.ontop.exception.InvalidMappingException;
import it.unibz.inf.ontop.exception.MappingIOException;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.injection.SpecificationFactory;
import it.unibz.inf.ontop.spec.mapping.PrefixManager;
import it.unibz.inf.ontop.spec.mapping.parser.SQLMappingParser;
import it.unibz.inf.ontop.spec.mapping.parser.impl.R2RMLToSQLPPTriplesMapConverter;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMapping;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import it.unibz.inf.ontop.spec.mapping.pp.impl.SQLPPMMecTriplesMap;
import it.unibz.inf.ontop.utils.ImmutableCollectors;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.rdf.api.*;
import org.apache.commons.rdf.rdf4j.RDF4J;
import org.eclipse.rdf4j.model.Namespace;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.rio.*;
import org.eclipse.rdf4j.rio.helpers.StatementCollector;

import java.io.*;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// This class reuses code from it.unibz.inf.ontop.spec.mapping.parser.impl.R2RMLMappingParser
// It is needed since we need to fetch custom information in the TripleMap
public class R2RMLMMeclMappingParserImpl implements SQLMappingParser {

    private final SQLPPMappingFactory ppMappingFactory;
    private final SpecificationFactory specificationFactory;
    private final R2RMLToSQLPPTriplesMapConverter transformer;
    private final RDF4JR2RMLMappingManager manager;
    private final RDF rdf;

    @Inject
    private R2RMLMMeclMappingParserImpl(SQLPPMappingFactory ppMappingFactory, SpecificationFactory specificationFactory,
                                        R2RMLToSQLPPTriplesMapConverter transformer) {
        this.ppMappingFactory = ppMappingFactory;
        this.specificationFactory = specificationFactory;
        this.transformer = transformer;
        this.manager = RDF4JR2RMLMappingManager.getInstance();
        this.rdf = new RDF4J();
    }

    @Override
    public SQLPPMapping parse(File mappingFile) throws InvalidMappingException, MappingIOException {
        LinkedHashModel rdf4jGraph = new LinkedHashModel();
        RDFParser parser = Rio.createParser(RDFFormat.TURTLE);
        StatementCollector collector = new StatementCollector(rdf4jGraph);
        parser.setRDFHandler(collector);
        try (InputStream in = new FileInputStream(mappingFile)) {
            URL documentUrl = new URL("file://" + mappingFile);
            parser.parse(in, documentUrl.toString());
            return parse(new RDF4J().asGraph(rdf4jGraph), extractPrefixes(rdf4jGraph));
        }
        catch (IOException e) {
            throw new MappingIOException(e);
        }
        catch (RDFParseException | RDFHandlerException e) {
            throw new InvalidMappingException(e.getMessage());
        }
    }

    @Override
    public SQLPPMapping parse(Reader reader) throws InvalidMappingException, MappingIOException {
        LinkedHashModel rdf4jGraph = new LinkedHashModel();
        RDFParser parser = Rio.createParser(RDFFormat.TURTLE);
        StatementCollector collector = new StatementCollector(rdf4jGraph);
        parser.setRDFHandler(collector);
        try (Reader r = reader) {
            // TODO: get the base IRI in a proper way
            parser.parse(r, "http://example.org/baseIRI/");
            return parse(new RDF4J().asGraph(rdf4jGraph), extractPrefixes(rdf4jGraph));
        }
        catch (IOException e) {
            throw new MappingIOException(e);
        }
        catch (RDFParseException | RDFHandlerException e) {
            throw new InvalidMappingException(e.getMessage());
        }
    }

    @Override
    public SQLPPMapping parse(Graph mappingGraph) throws InvalidMappingException {
        return parse(mappingGraph, ImmutableMap.of());
    }

    private ImmutableMap<String, String> extractPrefixes(LinkedHashModel rdf4jGraph) {
        return rdf4jGraph.getNamespaces().stream()
                .collect(ImmutableCollectors.toMap(
                        namespace -> namespace.getPrefix() + ":",
                        Namespace::getName));
    }

    protected SQLPPMapping parse(Graph mappingGraph, ImmutableMap<String, String> prefixes) throws InvalidMappingException {
        try {
            // C'est ici qu'on pourrait faire notre poutine pour générer les templates en fonction des signatures
            Collection<TriplesMap> tripleMaps = manager.importMappings(mappingGraph);

            ImmutableList<SQLPPMMecTriplesMap> sourceMappings = transformer.convert(tripleMaps).stream().map(SQLPPMMecTriplesMap::new).collect(ImmutableCollectors.toList());

            PrefixManager prefixManager = specificationFactory.createPrefixManager(prefixes);

            // Voici un exemple de comment réassocier les triplets de fonctions custom au mapping généré :
            // TODO: Voir comment les faire remonter au SaturatedMapping, probablement que le plus simple serait de faire hériter une classe
            //       custom à SQLPPMapping, cette classe contiendrait juste le code pour les fonctions custom
            Map<TriplesMap, List<TriplesMap>> hasSubset = mappingGraph.stream((BlankNodeOrIRI) null, getRDF().createIRI("http://www.griis.ca/projects/relrel#subsets"), (RDFTerm) null)
                    .map(axiom -> new ImmutablePair<>(tripleMaps.stream().filter(triple -> triple.getNode().equals(axiom.getSubject())).findFirst().orElseThrow(),
                            tripleMaps.stream().filter(triple -> triple.getNode().equals(axiom.getObject())).findFirst().orElseThrow()))
                    .collect(Collectors.groupingBy(ImmutablePair::getRight, Collectors.mapping(ImmutablePair::getLeft, Collectors.toList())));

            hasSubset.forEach((supersetMapping, subsetMappingList) -> subsetMappingList.forEach(subsetMapping -> {
                SQLPPMMecTriplesMap superSetSourceMapping = sourceMappings.stream().filter(sourceMapping -> sourceMapping.getId().equals(String.format("mapping-%s", supersetMapping.hashCode()))).findFirst().orElseThrow();
                SQLPPTriplesMap subSetSourceMapping = sourceMappings.stream().filter(sourceMapping -> sourceMapping.getId().equals(String.format("mapping-%s", subsetMapping.hashCode()))).findFirst().orElseThrow();

                superSetSourceMapping.addSubset(subSetSourceMapping);
            }));

            ImmutableList<SQLPPTriplesMap> upcastedSourceMappings = sourceMappings.stream().map(SQLPPTriplesMap.class::cast).collect(ImmutableCollectors.toList());
            return ppMappingFactory.createSQLPreProcessedMapping(upcastedSourceMappings, prefixManager);
        }
        catch (InvalidR2RMLMappingException e) {
            throw new InvalidMappingException(e.getMessage());
        }
    }

    private RDF getRDF() {
        return rdf;
    }
}

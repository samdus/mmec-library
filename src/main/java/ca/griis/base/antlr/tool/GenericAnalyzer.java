/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe abstraite GenericAnalyzer.
 * @brief @~english GenericAnalyzer abstract class implementation.
 */

package ca.griis.base.antlr.tool;

import ca.griis.base.Descripteur;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details
 * «Detailed description of the component (optional)»
 * @par Model
 * «Model (Abstract, automation, etc.) (optional)»
 * @par Conception
 * «Conception description (criteria and constraints) (optional)»
 * @par Limits
 * «Limits description (optional)»
 * @brief @~french Analyseur générique de langage.
 * @par Détails
 * S.O.
 * @par Modèle
 * S.O.
 * @par Conception
 * S.O.
 * @par Limites
 * S.O.
 * @par Historique
 * 2022-07-19 [CB] - Traduction de la classe en anglais.<br>
 * 2021-02-10 [BF] - Paramètre pour la règle de départ afin d'avoir une meilleure souplesse
 * d'utilisation<br>
 * 2019-12-17 [LL] - Simplification de la présentation.<br>
 * 2019-12-16 [SD] - Générisation.<br>
 * 2017-08-09 [CK] - Générisation du processus d'analyse.<br>
 * 2017-08-09 [CK] - Adaptation selon MRU et analyse des types scalaire Defini.<br>
 * 2017-07-19 [CK] - Mise en oeuvre initiale.<br>
 * 2016-10-16 [LL] - Harmonisation des commentaires.<br>
 * 2016-10-13 [CK] - Création.<br>
 * @par Tâches
 * S.O.
 */
public abstract class GenericAnalyzer<
        ParserT extends Parser,
        ParseTreeListenerT extends ParseTreeListener> {

    protected Descripteur summary;
    protected Descripteur trace;
    protected ParserT syntacticAnalyzer;
    protected ErreurSyntaxique errors;
    protected ParseTree parseTree;
    protected ParseTreeListenerT treeListener;

    protected abstract Lexer newLexer(CharStream charStream);

    protected abstract ParserT newParser(CommonTokenStream input);

    protected abstract ParseTreeListenerT newListener();

    public abstract String getAnalyzerDesignation();

    public abstract List<String> getExtensions();

    /**
     * @param «parameter name» «Parameter description»
     * @param toAnalyse  Chaîne à analyser
     * @param rule       le nom de la règle à la racine de l'analyse
     * @return «Return description»
     * @return String La trace d'analyse, incluant l'arbre syntaxique analysée ou les erreurs
     * d'analyse
     * @throws «exception name» «Exception description»
     * @brief @~english «Description of the function»
     * @brief @~french Analyse le fichier à l'aide d'un analyseur syntaxique paramétrisé par la classe
     * spécifique
     */
    public String analyzeNewString(String toAnalyse, String rule) {
        trace = new Descripteur();
        summary = new Descripteur();
        errors = new ErreurSyntaxique(summary);

        summary.titre("String analysis report");
        summary.ajouter(String.format("String : \n%s\n", toAnalyse));
        return analyzeStream(CharStreams.fromString(toAnalyse), rule);
    }

    /**
     * @param «parameter name» «Parameter description»
     * @param file       Fichier à analyser
     * @param rule       le nom de la règle à la racine de l'analyse
     * @return «Return description»
     * @return String La trace d'analyse, incluant l'arbre syntaxique analysée ou les erreurs
     * d'analyse
     * @throws «exception name» «Exception description»
     * @brief @~english «Description of the function»
     * @brief @~french Analyse le fichier à l'aide d'un analyseur syntaxique paramétrisé par la classe
     * spécifique
     */
    public String analyzeNewFile(File file, String rule) {
        trace = new Descripteur();
        summary = new Descripteur();
        errors = new ErreurSyntaxique(summary);

        summary.titre(String.format("%s analysis report", file.getName()));
        summary.ajouter(String.format("Location : %s", file.getAbsolutePath()));
        summary.ajouter(String.format("Size : %d octets", file.length()));

        try {
            return analyzeStream(CharStreams.fromFileName(file.getAbsolutePath()), rule);
        } catch (IOException e) {
            summary.ajouterErreur("File not found !");
            trace.ajouterErreur("File not found !");
            return summary.toString();
        }
    }

    public Descripteur getSummary() {
        return summary;
    }

    public Descripteur getTrace() {
        return trace;
    }

    public ParserT getSyntacticAnalyzer() {
        return syntacticAnalyzer;
    }

    public ErreurSyntaxique getErrors() {
        return errors;
    }

    public ParseTree getParseTree() {
        return parseTree;
    }

    public ParseTreeListenerT getTreeListener() {
        return treeListener;
    }

    public String getInternalRepresentation() {
        return getTreeListener().toString();
    }

    protected abstract ParseTree startRule(ParserT analyseur) throws RecognitionException;

    /**
     * @param «parameter    name» «Parameter description»
     * @param analyzer      l'analyseur syntaxique utilisé
     * @param startVariable la chaîne de caractère décrivant la règle de départ de l'analyse
     * @return «Return description»
     * @return l'arbre syntaxique résultant de l'analyse à partir de la règle correspondant à la
     * variable de départ en paramètre
     * @throws «exception name» «Exception description»
     * @brief @~english «Description of the function»
     * @brief @~french construit l'arbre syntaxique à partir d'un analyseur et de sa règle de départ
     */
    public ParseTree startRule(ParserT analyzer, String startVariable)
            throws RecognitionException {
        ParseTree tree;
        try {
            tree = (ParseTree) analyzer.getClass().getMethod(startVariable).invoke(analyzer);
        } catch (IllegalAccessException e) {
            System.err.println(
                    "Illegal access for this rule method. Selecting default rule.");
            tree = startRule(analyzer);
        } catch (InvocationTargetException e) {
            System.err.println(
                    "Erroneous invocation for this rule method. "
                            + "Selecting default rule.");
            tree = startRule(analyzer);
        } catch (NoSuchMethodException e) {
            System.err.println("Rule method not found. Selecting default rule.");
            tree = startRule(analyzer);
        }
        return tree;
    }

    /**
     * @param «parameter name» «Parameter description»
     * @param toAnalyse  le flux de caractère à analyser
     * @param rule       le nom de la règle à la racine de l'analyse
     * @return «Return description»
     * @return String La trace d'analyse, incluant l'arbre syntaxique analysée ou les erreurs
     * d'analyse
     * @throws «exception name» «Exception description»
     * @brief @~english «Description of the function»
     * @brief @~french Analyse le fichier à l'aide d'un analyseur syntaxique paramétrisé par la classe
     * spécifique
     */
    private String analyzeStream(CharStream toAnalyse, String rule) {
        final LocalDateTime start = LocalDateTime.now();

        summary.ajouter(String.format("Analysis start time : %s", start));
        summary.ajouter(String.format("Analyzer : '%s'", getAnalyzerDesignation()));

        Lexer lexer = newLexer(toAnalyse);
        lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);

        CommonTokenStream symbols = new CommonTokenStream(lexer);

        syntacticAnalyzer = newParser(symbols);
        syntacticAnalyzer.removeErrorListeners();
        syntacticAnalyzer.addErrorListener(errors);

        parseTree = startRule(syntacticAnalyzer, rule);
        treeListener = newListener();

        new ParseTreeWalker().walk(treeListener, parseTree);
        trace.ajouter(summary.toString());
        trace.ajouter("Internal representation");
        trace.ajouter(getInternalRepresentation());

        final LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(start, end);

        summary.ajouter(String.format("Analysis end time : %s (duration %s).", end, duration));
        trace.ajouter(String.format("Analysis end time : %s (duration %s).", end, duration));

        return summary.toString();
    }
}

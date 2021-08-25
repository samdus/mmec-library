package ca.griis.base.outilantlr;

import ca.griis.base.Descripteur;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Analyseur générique de langage.
 * <p>
 * <b>Propriétés des objets</b>
 * <ul>
 * <li>Unicité : oui.</li>
 * <li>Clonabilité : non.</li>
 * <li>Modifiabilité : non.</li>
 * </ul>
 *
 * <b>Tâches projetées</b>
 * <p>
 * TODO 2017-08-08 [CK] <i>Analyse des expressions.</i> <br>
 * <p>
 *
 * <b>Tâches réalisées</b>
 * <p>
 * 2019-12-17 (0.4.1) [LL] <i>Simplification de la présentation.</i> <br>
 * 2019-12-16 (0.4.0) [SD] <i>Générisation.</i> <br>
 * 2017-08-09 (0.3.0) [CK] <i>Générisation du processus d'analyse.</i> <br>
 * 2017-08-09 (0.2.0) [CK] <i>Adaptation selon MRU et analyse des types scalaire Defini.</i> <br>
 * 2017-07-19 (0.1.0) [CK] <i>Mise en oeuvre initiale.</i> <br>
 * 2016-10-16 (0.1.1) [LL] <i>Harmonisation des commentaires.</i> <br>
 * 2016-10-13 (0.1.0) [CK] <i>Création.</i> <br>
 * <p>
 *
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @author [SD] Samuel.Dussault@USherbrooke.ca
 * @version 0.4.1
 * @copyright 2017-2020, GRIIS (http://griis.ca/) <br>
 * <p>
 * GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé) <br>
 * Faculté des sciences et Faculté de médecine et des sciences de la santé <br>
 * Université de Sherbrooke <br>
 * Sherbrooke (Québec) J1K 2R1 CANADA <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 * @since 2017-07-19
 */
public abstract class AnalyseurGenerique<ParserT
        extends Parser, ParseTreeListenerT
        extends ParseTreeListener> {

    protected Boolean initialized = false;
    protected Descripteur rapport;
    protected Descripteur trace;
    protected ParserT analyseurSyntaxique;
    protected ErreurSyntaxique erreurs;
    protected ParseTreeListenerT auditeur;

    protected abstract Lexer nouveauLexer(CharStream charStream);

    protected abstract ParserT nouveauParser(CommonTokenStream input);

    protected abstract ParseTreeListenerT nouvelAuditeur();

    protected abstract ParseTree regleDepart() throws RecognitionException;

    public abstract String getAnalyseurAppellation();

    public abstract String getRepresentationInterne();

    public AnalyseurGenerique(File fichier){
        trace = new Descripteur();
        rapport = new Descripteur();
        erreurs = new ErreurSyntaxique(rapport);

        try {
            Lexer lexer = nouveauLexer(CharStreams.fromFileName(fichier.getAbsolutePath()));
            lexer.removeErrorListener(ConsoleErrorListener.INSTANCE);

            CommonTokenStream symboles = new CommonTokenStream(lexer);

            analyseurSyntaxique = nouveauParser(symboles);
            analyseurSyntaxique.removeErrorListeners();
            analyseurSyntaxique.addErrorListener(erreurs);

            auditeur = nouvelAuditeur();
        } catch (IOException e) {
            String erreur = String.format("Le fichier '%s' est introuvable !", fichier.getName());
            rapport.ajouterErreur(erreur);
            trace.ajouterErreur(erreur);
        }
    }

    public String analyserNouveauFichier(File fichier) {
        return analyserNouveauFichier(fichier, regleDepart());
    }

    /**
     * @param «parameter name» «Parameter description»
     * @param fichier    Fichier à analyser
     * @return «Return description»
     * @return String La trace d'analyse, incluant l'arbre syntaxique analysée ou les erreurs
     * d'analyse
     * @throws «exception name» «Exception description»
     * @fn analyserNouveauFichier
     * @brief @~english «Description of the function»
     * @brief @~french Analyse le fichier à l'aide d'un analyseur syntaxique paramétrisé par la classe
     * spécifique
     * @par Tâches
     */
    public String analyserNouveauFichier(File fichier, ParseTree arbreSyntaxique) {
        final LocalDateTime debut = LocalDateTime.now();

        rapport.titre(String.format("Rapport d'analyse de %s", fichier.getName()));
        rapport.ajouter(String.format("Emplacement : %s", fichier.getAbsolutePath()));
        rapport.ajouter(String.format("Taille : %d octets", fichier.length()));
        rapport.ajouter(String.format("Début de l'analyse : %s", debut));

        rapport.ajouter(String.format("Analyseur : '%s'", getAnalyseurAppellation()));

        new ParseTreeWalker().walk(auditeur, arbreSyntaxique);
        trace.ajouter(rapport.toString());
        trace.ajouter("Représentation interne");
        trace.ajouter(getRepresentationInterne());

        final LocalDateTime fin = LocalDateTime.now();
        Duration duration = Duration.between(debut, fin);

        rapport.ajouter(String.format("Fin de l'analyse : %s (durée %s).", fin, duration));
        trace.ajouter(String.format("Fin de l'analyse : %s (durée %s).", fin, duration));

        return rapport.toString();
    }

    /**
     * @return the rapport
     */
    public Descripteur getRapport() {
        return rapport;
    }

    /**
     * @return the trace
     */
    public Descripteur getTrace() {
        return trace;
    }

    /**
     * @return the analyseurSyntaxique
     */
    public ParserT getAnalyseurSyntaxique() {
        return analyseurSyntaxique;
    }

    /**
     * @return the erreurs
     */
    public ErreurSyntaxique getErreurs() {
        return erreurs;
    }

    /**
     * @return the auditeur
     */
    public ParseTreeListenerT getAuditeur() {
        return auditeur;
    }
}

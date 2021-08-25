package ca.griis.mmec;

import ca.griis.base.outilantlr.AfficheurArbreSyntaxique;
import ca.griis.base.outilantlr.AnalyseurGenerique;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import ca.griis.mMec.mMecLexer;
import ca.griis.mMec.mMecParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @class AnalyseurSpecifique
 *
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
 * @brief @~french Classe permettant l'analyse d'un programme selon un analyseur
 *        syntaxique spécifique
 * @par Details
 *      Cette classe permet d'analyser un programme à l'aide d'un analyseur spécifique.
 * 
 *      La classe permet de paramétrer l'ensemble du projet de sorte qu'en modifiant
 *      cette classe et le build.gradle, on obtient un programme d'analyse et des tests
 *      utilisant le répertoire "jeux".
 * 
 *      Notes:
 *      ----------------------------------------------------------------------------------
 *      - L'appellation est utilisée pour l'affichage
 *      - Les extensions sont utilisées pour la détection des fichiers tests.
 *        C'est-à-dire que seuls les fichiers du répertoire "jeux" qui terminent par une
 *        des extensions spécifiées seront analyser via JUnit
 *      - La représentation interne est utilisée pour l'affichage. Notez qu'il serait
 *        possibled'obtenir une représentation plus spécifique en dérivant
 *        la classe "AfficheurArbreSyntaxique".
 *      - Le Lexer est la classe générée par Antlr pour l'analyse lexicale du langage désiré
 *      - Le Parser est la classe générée par Antlr pour l'analyse syntaxique du langage désiré
 *      - L'auditeur est la classe permettant de définir la structure interne du fichier
 *        analysé tout au long du parcours de l'arbre syntaxique
 *      - La règle de départ est la méthode qui débute l'analyse du langage. Il s'agit de 
 *        la catégorie syntaxique initiale de la grammaire du langage.
 * 
 * @par Modèle
 *      «Modèle (type abstrait, automate, etc.) (optionnel)»
 * @par Conception
 *      «Description de la conception (critères contraintes) (optionnel)»
 * @par Limites
 *      «Description des limites (optionnel)»
 *
 * @par Historique
 *      2021-08-24 [SD] Implémentation initiale<br>
 *        * Adaptation de la classe ODMv2
 *
 * @par Tâches
 *      «Liste des annotations»
 */
public class AnalyseurSpecifique
    extends AnalyseurGenerique<mMecParser, AfficheurArbreSyntaxique> {

  public AnalyseurSpecifique(File fichier) {
    super(fichier);
  }

  public static List<String> getExtensions() {
    return Collections.singletonList(".mec");
  }

  @Override
  public String getAnalyseurAppellation() {
    return "DadaGem Parser";
  }

  @Override
  public String getRepresentationInterne() {
    return auditeur.toString();
  }

  @Override
  protected Lexer nouveauLexer(CharStream input) {
    return new mMecLexer(input);
  }

  @Override
  protected mMecParser nouveauParser(CommonTokenStream input) {
    return new mMecParser(input);
  }

  @Override
  protected AfficheurArbreSyntaxique nouvelAuditeur() {
    return new AfficheurArbreSyntaxique(analyseurSyntaxique);
  }

  @Override
  protected ParseTree regleDepart() throws RecognitionException {
    return analyseurSyntaxique.base();
  }
}

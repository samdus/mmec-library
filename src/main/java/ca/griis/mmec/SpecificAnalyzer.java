/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe SpecificAnalyzer.
 * @brief @~english SpecificAnalyzer class implementation.
 */

package ca.griis.mmec;

import ca.griis.base.antlr.tool.GenericAnalyzer;
import ca.griis.base.antlr.tool.ParseTreeVisualizer;
import ca.griis.mmec.antlr.gen.mMecLexer;
import ca.griis.mmec.antlr.gen.mMecParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Arrays;
import java.util.List;

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
 * @brief @~french Permet l'analyse d'un programme selon un analyseur syntaxique spécifique.
 * @par Détails
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
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      - 2021-02-10 [BF] Correction mineures
 *      - 2019-12-18 [LL] Revue des commentires
 *        * Corrections mineures.
 *        * Respect de la limite de 100 car./ligne imposée par le standard de programmation.
 *      - 2019-12-16 [SD] Implémentation initiale
 *        * Généralisation de l'analyseur de ODMv2_HL développé par CK
 *
 * @par Tâches
 *      S.O.
 */
public class SpecificAnalyzer
    extends GenericAnalyzer<mMecParser, ParseTreeVisualizer> {

  @Override
  public String getAnalyzerDesignation() {
    return "MMec Parser";
  }

  @Override
  public List<String> getExtensions() {
    return Arrays.asList(".mec");
  }

  @Override
  protected Lexer newLexer(CharStream input) {
    return new mMecLexer(input);
  }

  @Override
  protected mMecParser newParser(CommonTokenStream input) {
    return new mMecParser(input);
  }

  @Override
  protected ParseTreeVisualizer newListener() {
    return new ParseTreeVisualizer(getSyntacticAnalyzer());
  }

  @Override
  protected ParseTree startRule(mMecParser analyzer) throws RecognitionException {
    return analyzer.mMec_document();
  }

}

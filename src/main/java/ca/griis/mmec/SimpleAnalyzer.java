/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe SimpleAnalyzer.
 * @brief @~english SimpleAnalyzer class implementation.
 */

package ca.griis.mmec;

import ca.griis.base.antlr.tool.GenericAnalyzer;
import ca.griis.mMec.antlr.gen.mMecLexer;
import ca.griis.mMec.antlr.gen.mMecParser;
import ca.griis.mmec.listener.SimpleMMecListener;
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
 * @brief @~french Analyseur utilisant un auditeur Dadagem simple.
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
 *      2022-08-26 [SD] - Implémentation initiale.<br>
 *
 * @par Tâches
 *      S.O.
 */
public class SimpleAnalyzer extends GenericAnalyzer<mMecParser, SimpleMMecListener> {

  private SimpleMMecListener simpleMMecListener;

  public SimpleAnalyzer() {
    this.simpleMMecListener = new SimpleMMecListener();
  }

  @Override public String getAnalyzerDesignation() {
    return "DadaGem Parser";
  }

  @Override public List<String> getExtensions() {
    return Arrays.asList(".mec");
  }

  @Override protected Lexer newLexer(CharStream input) {
    return new mMecLexer(input);
  }

  @Override protected mMecParser newParser(CommonTokenStream input) {
    return new mMecParser(input);
  }

  @Override protected SimpleMMecListener newListener() {
    return simpleMMecListener;
  }

  @Override protected ParseTree startRule(mMecParser analyzer) throws RecognitionException {
    return analyzer.mMec_document();
  }

//  public DadagemDocument getDadagemDocument() {
//    return simpleMMecListener.getDadagemDocument();
//  }
}

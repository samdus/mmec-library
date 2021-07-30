package ca.griis.base.outilantlr;

import java.util.Arrays;
import java.util.List;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.Trees;

/**
 * Affichage d'un arbre d dérivation syntaxique produit par ANTLR4.
 * <p>
 *
 * <b>Description</b>
 * <p>
 * ... à venir ...
 * <p>
 *
 * <b>Tâches projetées</b>
 * <p>
 * TODO 2019-12-17 [LL] <i>Améliorer la présentation de l'arbre syntaxique.</i> <br>
 *   * Utiliser une descente en profondeur avec anticipation.<br>
 * <p>
 *
 * <b>Tâches réalisées</b>
 * <p>
 * 2019-12-17 (0.1.2) [LL] <i>Modification sométique à la présentation de l'arbre.</i> <br>
 * 2019-12-17 (0.1.1) [LL] <i>Harmonisation des commentaires.</i> <br>
 * 2016-10-13 (0.1.0) [CK] <i>Création.</i> <br>
 * <p>
 *
 * <b>Copyright</b> 2014-2016, Μῆτις (http://info.usherbrooke.ca/llavoie/) <br>
 * <b>Copyright</b> 2016-2017, GRIIS (http://griis.ca/) <br>
 * <p>
 * GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé) <br>
 * Faculté des sciences et Faculté de médecine et des sciences de la santé <br>
 * Université de Sherbrooke (Québec) J1K 2R1 <br>
 * CANADA <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 *
 * <b>Références</b>
 * <p>
 * [1]
 * http://stackoverflow.com/questions/19350705/how-do-i-pretty-print-productions-and-line-numbers-using-antlr4
 * <p>
 *
 * @version 0.1.2
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @author [SD] Samuel.Dussault@USherbrooke.ca
 */

public class AfficheurArbreSyntaxique implements ParseTreeListener {
  private final List<String> ruleNames;

  private final StringBuilder builder = new StringBuilder();
  
  private int level = 0;
  private int pas = 2;

  public AfficheurArbreSyntaxique(Parser parser) {
    this.ruleNames = Arrays.asList(parser.getRuleNames());
  }

  public AfficheurArbreSyntaxique(List<String> ruleNames) {
    this.ruleNames = ruleNames;
  }

  @Override
  public void visitTerminal(TerminalNode node) {
    if (builder.length() > 0) {
      builder.append(' ');
    }
    builder.append(Utils.escapeWhitespace(Trees.getNodeText(node, ruleNames), false));
  }

  @Override
  public void visitErrorNode(ErrorNode node) {
    if (builder.length() > 0) {
      builder.append(' ');
    }
    builder.append(Utils.escapeWhitespace(Trees.getNodeText(node, ruleNames), false));
  }

  // TODO 2016-10-13 (for01) [CK] : Amélioration requise (format d'affichage).
  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    if (builder.length() > 0) {
      builder.append(' ');
    }
    int ruleIndex = ctx.getRuleIndex();
    String ruleName;
    if (ruleIndex >= 0 && ruleIndex < ruleNames.size()) {
      ruleName = ruleNames.get(ruleIndex);
    } else {
      ruleName = Integer.toString(ruleIndex);
    }
    builder.append(ruleName);
    if (ctx.getChildCount() > 0) {
      builder.append('(');
      builder.append('\n');
      // TODO 2019-12-17 [LL] Écrire pas*level espaces
      //   * quelque chose comme :  bulder.append(repeatString(pas*level,' '));
      for (int i = 0; i < level * pas; i++) {
        builder.append(' ');
      }
      level++;
    }
  }

  // TODO 2016-10-13 (for02) [CK] Amélioration requise (format d'affichage).
  @Override
  public void exitEveryRule(ParserRuleContext ctx) {
    // Simple
    if (ctx.getChildCount() > 0) {
      builder.append(')');
      level--;
    }
    /*
     * // Complexe ?
     * if (ctx.getChildCount() > 0)
     * {
     * Token positionToken = ctx.getStart();
     * if (positionToken != null) {
     * builder.append(" [line ");
     * builder.append(positionToken.getLine());
     * builder.append(", offset ");
     * builder.append(positionToken.getStartIndex());
     * builder.append(':');
     * builder.append(positionToken.getStopIndex());
     * builder.append("])");
     * }
     * else {
     * builder.append(')');
     * }
     * }
     */
  }

  @Override
  public String toString() {
    return builder.toString();
  }

  /**
   * @return pas
   */
  public int getPas() {
    return pas;
  }

  /**
   * @param pas --> pas
   */
  public void setPas(int pas) {
    this.pas = pas;
  }
}

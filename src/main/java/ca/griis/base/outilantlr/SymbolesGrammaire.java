package ca.griis.base.outilantlr;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Décrire la classe ici.
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
 * <i>...</i> <br>
 * <p>
 *
 * <b>Tâches réalisées</b>
 * <p>
 * <i>2017-XX-XX (0.2.0) [XX] ... </i> <br>
 * <i>(2017-07-21) (0.1.0) [CK] Mise en oeuvre initiale. </i> <br>
 * <p>
 * 
 * <b>Références</b>
 * <p>
 * <i>
 * https://stackoverflow.com/questions/22769343/antlr4-flattening-a-parserrulecontext-tree-into-an-array
 * </i> <br>
 * <p>
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
 * @since 2017-07-21
 * @version 0.1.0
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */
public class SymbolesGrammaire {
  // **************************************************************************
  // Attributs spécifiques
  //
  // **************************************************************************
  // Constructeurs
  //
  // **************************************************************************
  // Opérations propres
  //
  /**
   * Makes an in-order traversal over {@code parent} (recursively) collecting
   * all Tokens of the terminal nodes it encounters.
   *
   * @param tokens the list of tokens.
   * @param parent the current parent node to inspect for terminal nodes.
   */
  private static void inOrderTraversal(List<Token> tokens, ParseTree parent) {
    // Iterate over all child nodes of `parent`.
    for (int i = 0; i < parent.getChildCount(); i++) {
      // Get the i-th child node of `parent`.
      ParseTree child = parent.getChild(i);
      if (child instanceof TerminalNode) {
        // We found a leaf/terminal, add its Token to our list.
        TerminalNode node = (TerminalNode) child;
        tokens.add(node.getSymbol());
      } else {
        // No leaf/terminal node, recursively call this method.
        inOrderTraversal(tokens, child);
      }
    }
  }

  // **************************************************************************
  // Opérations publiques
  //
  /**
   * Retrieves all Tokens from the {@code tree} in an in-order sequence.
   * 
   * <pre>
   * {@code
   * List<Token> symbole = getFlatTokenList(ctx_type.t_nombre());
   * for (Token s : symbole) {//code ici};
   * </pre>
   * 
   * @param tree the parse tee to get all tokens from.
   * 
   * @return all Tokens from the {@code tree} in an in-order sequence.
   */
  public static List<Token> getFlatTokenList(ParseTree tree) {
    List<Token> tokens = new ArrayList<>();
    inOrderTraversal(tokens, tree);
    return tokens;
  }
}

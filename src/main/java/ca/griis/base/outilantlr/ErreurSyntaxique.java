package ca.griis.base.outilantlr;

import ca.griis.base.Descripteur;
import java.awt.Color;
import java.awt.Container;
import java.util.Collections;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Définition des messages d'erreurs.
 * <p>
 *
 * <b>Description</b>
 * <p>
 * ... à venir ...
 * <p>
 *
 * <b>Copyright</b>
 * <p>
 * 2016-2016, Μῆτις (http://info.usherbrooke.ca/llavoie/Metis) <br>
 * Μῆτις Ἀκαδήμεια <br>
 * Faculté des sciences<br>
 * Université de Sherbrooke (Québec) CANADA <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 *
 * <b>Références</b>
 * <p>
 * [1]
 * http://stackoverflow.com/questions/19350705/how-do-i-pretty-print-productions-and-line-numbers-using-antlr4
 * <p>
 *
 * <b>Tâches réalisées</b>
 * <ul>
 * <li>
 * 2016-10-16 (0.1.1) [LL] : Harmonisation des commentaires.
 * </li>
 * <li>
 * 2016-10-13 (0.1.0) [CK] : Création.
 * </li>
 * </ul>
 *
 * @version 0.1.1
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */
public class ErreurSyntaxique extends BaseErrorListener {
  public Descripteur traceErreur;

  public int nbErreur;

  /**
   * Constructeur
   */
  public ErreurSyntaxique(Descripteur trace) {
    this.traceErreur = trace;
  }

  @Override
  public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
      int charPositionInLine, String msg, RecognitionException e) {
    // Afficher les informations suivantes pour chacunes des erreurs
    // super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
    List<String> listeErreur = ((Parser) recognizer).getRuleInvocationStack();
    nbErreur = listeErreur.size();
    Collections.reverse(listeErreur);
    traceErreur.ajouterErreur(" Règle :" + listeErreur + " ");
    traceErreur.ajouterErreur(
        " Ligne " + line + " col " + charPositionInLine + " " + offendingSymbol + " : " + msg);
  }

  /**
   * Afficheur les erreurs de l'analyseur syntaxique à l'utilisateur sous forme d'une boîte de
   * dialogue.
   */
  public void afficherBoiteErreur() {
    JDialog dialog = new JDialog();
    Container contenant = dialog.getContentPane();
    contenant.add(new JLabel(traceErreur.toString()));
    contenant.setBackground(Color.white);
    dialog.setTitle("Liste des erreurs de syntaxe");
    dialog.pack();
    dialog.setLocationRelativeTo(null);
    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog.setVisible(true);
  }
}

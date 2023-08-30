package ca.griis.base;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;

/**
 * Mise en oeuvre de trois sémantiques de copie (référentielle, immédiate et déléguée).
 * <p>
 *
 * <b>Description</b>
 * <p>
 * <i>Objectif</i> :
 * faciliter la définition de structures générales (graphe pouvant comporter
 * des cycles) d'objets hétérogènes tout en permettant que chaque type d'objets utilise une
 * sémantique de copie qui lui soit propre. En pratique, trois modes sémantiques de copie sont
 * pris en compte : référentielle, immédiate et déléguée. Chaque sémantique de copie est définie par
 * trois opérations (copie, égalité, empreinte numérique). La sémantique immédiate et la sémantique
 * référentielle sont facilement mises en oeuvre. Par contre, la sémantique déléguée qui procède par
 * clonage intégral (copie «profonde», complète, etc.) nécessite une mise en oeuvre soignée
 * afin d'éviter les bouclages.
 * <p>
 * <i>Mise en contexte</i> :
 * Le clonage intégral d'une structure procède depuis un noeud appelé <i>racine</i>.
 * On suppose (et impose) que la structure soit construite à l'aide de
 * classes qui dérivent toutes, directement ou indirectement de la classe racine (Noeud).
 * Ces classes dérivées participant à la structure sont appelées classes <i>structurelles</i>.
 * Les services offerts sont la copie (nCopie analogue à <code>Object.clone</code>),
 * la comparaison pour l'égalité (nEgal analogue à <code>Object.equals</code>) et
 * l'empreinte numérique (nEmpreinte analogue à <code>Object.hashCode</code>).
 * <p>
 * <i>Note</i> :
 * Les bibliothèques de référence de Java (pour ne pas dire le langage Java lui-même) supposent que
 * la sémantique de copie est connue de l'utilisateur et que la responsabilité d'utiliser les bonnes
 * fonctions et les bons algorithmes lui incombe, brisant ainsi l'opacité des classes - il faut
 * connaitre la mise en oeuvre de la classe pour l’utiliser adéquatement et sans erreurs.
 * En outre, on remarque que le mode de copie est rarement documenté dans les spécifications
 * d'interface et de classe, ce qui induit donc fréquemment des erreurs, particulièrement lors de
 * l'utilisation de classes comportant des attributs de mode différents. Le paquetage Base et les
 * structures qui en découlent ont été développés pour pallier cette carence.
 * 
 * <p>
 * <b>Utilisation</b>
 * <p>
 * Les <i>fonctions publiques</i> communes
 * (rCopie, rEgal, rEmpreinte,
 * iCopie, iEgal, iEmpreinte,
 * dCopie, dEgal, dEmpreinte,
 * setXmode, getXMode, xCopie, xEgal et xEmpreinte)
 * doivent être mises en oeuvre par la classe racine (Noeud) et uniquement par elle
 * (elles sont donc déclarées finales).
 * <p>
 * Les <i>fonctions internes</i>
 * (iClone, iEquals, iHashCode,
 * dClone, dEquals et dHashCode)
 * encapsulent la connaissance interne de la classe (la structure de ses attributs propres
 * et le traitement qui doit leur être réservé dans le contexte de la fonction).
 * Elles doivent donc être mises en oeuvre par <b>toutes</b> les classes dérivées de la classe
 * racine (Noeud) et devraient donc être "protégées". Une restriction de java interdisant la
 * déclaration d'éléments <code>protected</code> dans les interfaces impose malheureusement
 * de les déclarer <code>public</code>.
 * <p>
 * Finalement, un constructeur spécialisé doit également être mis en oeuvre par toutes les classes
 * structurelles, y compris la classe racine. Ce constructeur crée un nouvel objet, de valeur
 * égale selon un mode donné à l'objt source.
 * <p>
 * La fonction iClone n'a pas d'utilité pratique, pour le moment, dans le mode immédiat (n=1),
 * la totalité du travail est fait dans le constructeur Noeud(sorte,source). Nous avons cependant
 * décidé de la maintenir pour deux raisons :
 * (1) maintenir la vision orthogonale des modes de copie;
 * (2) réserver un point d'ancrage à d'éventuelles actions auxiliaires locales telles
 * traces de mise-au-point, décompte, etc.
 * En l'absence d'actions auxiliaires, seule la fonction Noeud.iClone doit être mise en oeuvre,
 * alors que celles des descendants peuvent simplement être déclarées abstraites
 * (voir par exemple Composant et Attribut).
 * <p>
 * La classe Noeud est conceptuellement abstraite, toutefois elle ne l'est pas syntaxiquement,
 * car le constructeur Noeud(sorte,source) est la fin de la séquence d'appels des fonctions de
 * copie. À ce titre, le constructeur doit pouvoir poser des actions pour le mode copieDeleguee et
 * pour le mode copieImmediate (n>1, bien qu'il ne soit pas encore offert).
 * <p>
 * À reviser : <br>
 * 
 * <pre>
 * Chacune de ces fonctions DOIT commencer par une appel à la fonction analogue de son ancêtre
 * direct soit directement (nEquals et nHashCode) soit indirectement (nCode). On procède
 * directement par un appel à super (par exemple <code>nEquals(x)</code> fait immédiatement appel à
 * <code>super.nEquals(x))</code>). On procède indirectement (dans le cas de nClone) en faisant
 * appel à un constructeur spécialisé qui DOIT être défini par toute classe structurelle et dont
 * l'entête est le suivant (en supposant une classe structurelle Composant) :
 * <code>
 * public Bloc(CopieSorte mode, Bloc source)
 * {
 * super(mode, source);
 * ...
 * </code>
 * </pre>
 *
 * <b>Mise en oeuvre</b>
 * <p>
 * La présente mise en oeuvre est non ré-entrante, un seul processus de copie peut être
 * mené à la fois. Néanmoins, toutes les fonctions publiques peuvent s'appeler
 * récursivement.
 * <p>
 *
 * <b>Tâches projetées</b>
 * <p>
 * <i>TODO 2017-01-16 [LL] Réviser la documentation. </i> <br>
 * ... <br>
 * <i>TODO 2015-01-15 [LL] Rendre la classe ré-entrante. </i> <br>
 * ... <br>
 * <p>
 *
 * <b>Tâches réalisées</b>
 * <p>
 * <i>2015-05-01 (0.3.0) [LL] Mise en oeuvre de la suggestion 0.2.1. </i> <br>
 * Le changement induit un travail éditorial simple mais important au niveau de MRU et
 * il importe de le faire entre deux phases de développement intensif.
 * La semaine du 21 au 27 janvier 2017 s'est avérée propice à cela.
 * <br>
 * <i>2017-01-22 (0.2.1) [CK] Suggestion de l'introduction de iClone, iEquals et iHashCode. </i>
 * <br>
 * Au prix d'une indirection supplémentaire, ceci permet
 * (1) de faciliter la compréhension et l'expression du mode de fonctionnement du module
 * (mettre en oeuvre les fonctions internes (anglophones) pour
 * rendre disponibles les fonctions publiques (francophones) [sic]).
 * Ceci permettra aussi (éventuellement) d'ajouter des raffinements aux fonctions immédiates
 * en retouchant la seule classe Noeud (comme c'est déjà le cas pour les autres modes de copie);
 * (2) permettre d'utiliser le mode protected pour les fonctions internes
 * (il ne resterait qu'à trouver un moyen d'en forcer la redéfinition dans chaque classe dérivée).
 * <br>
 * <i>2015-05-01 (0.2.0) [LL] Introduction de dOK. </i> <br>
 * ... <br>
 * <i>2014-01-01 (0.1.0) [LL] Mise en oeuvre initiale. </i> <br>
 * ... <br>
 * <p>
 *
 * <b>Copyright</b> 2014-2016, Μῆτις (http://info.usherbrooke.ca/llavoie/) <br>
 * <b>Copyright</b> 2016-2017, GRIIS (http://griis.ca/) <br>
 * <p>
 * GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé) <br>
 * Faculté des sciences et Faculté de médecine et des sciences de la santé <br>
 * Université de Sherbrooke
 * Sherbrooke (Québec) J1K 2R1 CANADA <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 *
 * @since 2014-01-01
 * @version 0.3.0
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */
public class Noeud implements CopieReferentielle, CopieImmediate, CopieDeleguee, Cloneable {
  // ************************************************************************
  // Constructeur générique
  //
  protected /* interne */ Noeud() {
    super();
  }

  // ************************************************************************
  // Fonctions publiques et finales
  //
  /**
   * Copie par délégation de l'objet.
   * Chaque descendant DOIT redéfinir la méthode dClone en s'assurant que tous ses
   * ancêtres ont l'opportunité d'évaluer leur part. Un constructeur doit également
   * être associé et doté de deux paramètres (CopieSortie, Composant).
   *
   * @return la copie
   */
  @Override
  public final Noeud delCopie() {
    Noeud x;
    if (this.poursuivreCopie()) {
      x = this.chercherCopie(this);
      if (x == null) {
        x = this.delClone(); // creation d'un objet du descendant
      }
    } else {
      this.amorcerCopie();
      x = this.delClone(); // creation d'un objet du descendant
      this.cloreCopie();
    }
    return x;
  }

  /**
   * Égalité par délégation entre deux objets.
   * Chaque descendant DOIT redéfinir la méthode dEquals en s'assurant que tous ses
   * ancêtres ont l'opportunité d'évaluer leur part.
   *
   * @param autre : l'objet comparé
   * @return égalité entre this et x
   */
  @Override
  public final boolean delEgal(Object autre) {
    assert autre instanceof Noeud;
    Noeud n = (Noeud) autre;
    boolean b;
    if (this.poursuivreEquivalence()) {
      if (this.chercherEquivalence(n)) {
        Boolean bb = this.valeurEquivalence(n);
        if (bb == null) {
          b = true; // mais on enregistre pas (point fixe)
        } else {
          b = bb;
          this.enregistrerEquivalence(n, b);
        }
      } else {
        b = this.delEquals(n);
        this.enregistrerEquivalence(n, b);
      }
    } else {
      this.amorcerEquivalence();
      b = this.delEquals(n);
      assert this.getClass() == n.getClass() : "this : " + this.getClass().getName() + "; n : "
          + n.getClass().getName();
      this.enregistrerEquivalence(n, b); // pour la forme :-)
      this.cloreEquivalence();
    }
    return b;
  }

  /**
   * Empreinte d'un objet cohérente avec la copie et l'égalité.
   * Chaque descendant DOIT doit définir la méthode dHashCode en s'assurant que tous ses
   * ancêtres ont l'opportunité d'évaluer leur part.
   *
   * @return l'empreinte de l'objet
   */
  @Override
  public final int delEmpreinte() {
    Integer x;
    if (this.poursuivreParcours()) {
      x = (Integer) this.chercherParcours();
      if (x == null) {
        this.enregistrerParcours(1);
        x = this.delHashCode();
        this.enregistrerParcours(x);
      }
    } else {
      this.amorcerParcours();
      this.enregistrerParcours(1);
      x = this.delHashCode();
      this.enregistrerParcours(x);
      this.cloreParcours();
    }
    return x;
  }

  // **************************************************************************
  // Méthodes protégées et devant être redéfinies par chaque classe dérivée de Noeud
  //
  /**
   * Le constructeur suivant est imposé et réservé à la mise en oeuvre de la copie profonde.
   * Il DOIT être redéfini par toutes les classes structurelles qui DOIVENT faire appel à
   * super(mode,source) dès la première instruction.
   *
   * @param mode
   * @param source
   */
  protected /* interne */ Noeud(CopieSorte mode, Noeud source) {
    super(); // normalement : super (mode,source);
    //
    // Exceptionnellement, l'appel à un (autre) constructeur DEVANT être la première instruction
    // d'un constructeur, les tests d'assertions DOIVENT être placés après!
    assert mode != null;
    assert mode != CopieSorte.referentielle;
    //
    // Traitement des attributs locaux immuables
    // this.attributTypeBase = source.attributTypeBase;
    //
    // Traitement des pointeurs selon le mode de copie
    if (mode == CopieSorte.immediate) { //NOPMD
      // Exemple de sémantique immédiate de niveau 1 :
      //   this.attributPointeur = source.attributPointeur;
      // On pourra également utiliser des sémantiques immédiates de niveau 2, 3, ...
    } else {
      // Toute la magie est dans la ligne suivante, qui doit être la première de la partie
      // spécifique à la copie déléguée :
      if (copieEnCours) {
        this.enregistrerCopie(source);
        //
        // Exemple de sémantique déléguée :
        //   this.attributPointeur =
        //      (source.attributPointeur == null) ? null : source.attributPointeur.nCopie();
      }
    }
  }

  @Override
  public final Noeud refCopie() {
    return this;
  }

  @Override
  public final boolean refEgal(Object x) {
    assert x instanceof Noeud;
    return this == x;
  }

  @Override
  public final int refEmpreinte() {
    return System.identityHashCode(this);
  }

  /**
   * Clone véritable.
   * <br>
   * La routine crée une copie conforme intégrale de l'objet. Elle est réservée à ce seul usage,
   * sous peine de dysfonction du service (en particulier dans les cas d'un graphe comportant des
   * cycles). Cette obligation ne peut être vérifiée par le présent module.
   * <br>
   * Chaque descendant DOIT redéfinir la routine en s'assurant que tous ses
   * ancêtres ont l'opportunité d'initialiser leur part de l'objet. Pour ce faire,
   * le constructeur précédent Noeud(mode, source) doit être appelé.
   *
   * @return la copie intégrale d l'objet.
   */
  protected /* interne */ Noeud delClone() {
    Noeud x = new Noeud(CopieSorte.deleguee, this);
    // System.out.println("this> " + this + "; autre> " + x);
    assert this.delEgal(x) : "this> " + this + "; autre> " + x;
    return x;
  }

  /**
   * Égalité par délégation entre deux objets, fonction STRICTEMENT RÉSERVÉE
   * membres (descendants) de la structure racine mettant en oeuvre CopieNouvelle.
   *
   * @param autre : l'objet comparé
   * @return vrai ssi l'objet est identique à x
   */
  protected /* interne */ boolean delEquals(Object autre) {
    this.enregistrerEquivalence(autre, null);
    // System.out.println("this> " + this + "; autre> " + autre);
    return true;
  }

  /**
   * Empreinte d'un objet cohérente avec la copie et l'égalité, fonction STRICTEMENT RÉSERVÉE
   * membres (descendants) de la structure racine mettant en oeuvre CopieNouvelle.
   *
   * @return l'empreinte de l'objet
   */
  protected /* interne */ int delHashCode() {
    return 1;
  }

  @Override
  public final Noeud immCopie() {
    return this.immClone();
  }

  @Override
  public final boolean immEgal(Object x) {
    return this.immEquals(x);
  }

  @Override
  public final int immEmpreinte() {
    return this.immHashCode();
  }

  protected /* interne */ Noeud immClone() {
    Noeud x = new Noeud(CopieSorte.immediate, this);
    // System.out.println("this> " + this + "; autre> " + x);
    assert this.immEgal(x) : "this> " + this + "; autre> " + x;
    return x;
  }

  protected /* interne */ boolean immEquals(Object x) {
    assert x instanceof Noeud;
    return true;
  }

  protected /* interne */ int immHashCode() {
    return 1;
  }

  /**
   * Vérification interne du composant, fonction STRICTEMENT RÉSERVÉE aux
   * membres (descendants) de la structure racine.
   *
   * @return l'empreinte de l'objet
   */
  protected /* interne */ boolean delOk(Noeud proprio) {
    return true;
  }

  // ***************************************************************************
  // Opérations liées à xMode; pour fins de test UNIQUEMENT
  //
  private static CopieSorte xMode;

  public static final void setXMode(CopieSorte m) {
    xMode = m;
  }

  public static final CopieSorte getXMode() {
    return xMode;
  }

  public final Noeud croixCopie() {
    if (xMode == null) {
      try {
        return (Noeud) this.clone();
      } catch (CloneNotSupportedException e) {
        assert false;
      }
    }
    switch (xMode) {
      case deleguee:
        return this.delCopie();
      case immediate:
        return this.immCopie();
      case referentielle:
        return this.refCopie();
      default:
        assert false;
    }
    return null; // bidon
  }

  public final boolean croixEgal(Object x) {
    if (xMode == null) {
      return this.equals(x);
    }
    switch (xMode) {
      case deleguee:
        return this.delEgal(x);
      case immediate:
        return this.immEgal(x);
      case referentielle:
        return this.refEgal(x);
      default:
        assert false;
    }
    return false; // bidon
  }

  public final int croixEmpreinte() {
    if (xMode == null) {
      return this.hashCode();
    }
    switch (xMode) {
      case deleguee:
        return this.delEmpreinte();
      case immediate:
        return this.immEmpreinte();
      case referentielle:
        return this.refEmpreinte();
      default:
        assert false;
    }
    return 0; // bidon
  }

  // ***************************************************************************
  // Opérations propres de gestion de copie déléguée
  //
  private static HashMap<Object, Object> copies;
  private static boolean copieEnCours = false;

  private void amorcerCopie() {
    assert !copieEnCours;
    copieEnCours = true;
    copies = new HashMap<>();
  }

  private boolean poursuivreCopie() {
    return copieEnCours;
  }

  private Noeud chercherCopie(Object source) {
    return (Noeud) copies.get(source);
  }

  private void enregistrerCopie(Object source) {
    copies.put(source, this);
  }

  private void cloreCopie() {
    boolean ok = copieEnCours;
    assert ok;
    copies.clear();
    copieEnCours = false;
  }

  // ***************************************************************************
  // Opérations propres de gestion de comparaison déléguée
  //
  private static HashMap<SimpleEntry<Object, Object>, Boolean> equivalences;
  private static boolean equivalenceEnCours = false;

  private void amorcerEquivalence() {
    assert !equivalenceEnCours;
    equivalenceEnCours = true;
    equivalences = new HashMap<>();
  }

  private boolean poursuivreEquivalence() {
    return equivalenceEnCours;
  }

  private boolean chercherEquivalence(Noeud autre) {
    return equivalences.containsKey(new SimpleEntry<Object, Object>(autre, this));
  }

  private Boolean valeurEquivalence(Noeud autre) {
    return equivalences.get(new SimpleEntry<Object, Object>(autre, this));
  }

  private void enregistrerEquivalence(Object autre, Boolean b) {
    assert this.getClass() == autre.getClass() : "this : " + this.getClass().getName()
        + "; autre : " + autre.getClass().getName();
    equivalences.put(new SimpleEntry<Object, Object>(autre, this), b);
  }

  private void cloreEquivalence() {
    boolean ok = equivalenceEnCours;
    assert ok;
    equivalences.clear();
    equivalenceEnCours = false;
  }

  // ***************************************************************************
  // Opérations propres de gestion de parcours de traitement déléguée
  // (Empreinte, String, etc.)
  //
  private static HashMap<Object, Object> parcours;
  private static boolean parcoursEnCours = false;

  private void amorcerParcours() {
    assert !parcoursEnCours;
    parcoursEnCours = true;
    parcours = new HashMap<>();
  }

  private boolean poursuivreParcours() {
    return parcoursEnCours;
  }

  private Object chercherParcours() {
    return parcours.get(this);
  }

  private void enregistrerParcours(Object valeur) {
    parcours.put(this, valeur);
  }

  private void cloreParcours() {
    assert parcoursEnCours;
    parcours.clear();
    parcoursEnCours = false;
  }

  // ***************************************************************************
  // Opérations clone(), equals() et hashCode.
  //
  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}

package ca.griis.base.ensemble;

import ca.griis.base.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

import static ca.griis.base.ConstantesGenerales.EmpNum_facteur;

/**
 * <b>Description</b>
 * <p>
 * Mise en oeuvre commune aux ensembles de composants utilisés dans MDS.
 * <p>
 * Les opérations portant sur les éléments des ensembles sont réalisées selon la sémantique
 * référentielle (conformément au choix établi par LinkedHashList). Les ensembles (et leurs
 * éléments) peuvent cependant êtres copiés selon chacun des trois sémantiques (référentielle,
 * immédiate, déléguée).
 * <p>
 * <b>Copyright</b>
 * <p>
 * 2013-2014, Chantier Améthyste (http://info.usherbrooke.ca/llavoie/) <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 *
 * <b>Création</b>
 * <p>
 * 2013-11-15
 * <p>
 *
 * <b>Signature</b>
 * <p>
 * $Id: EnsembleH.java 1458 2015-09-15 19:36:11Z khnc2501 $
 * <p>
 *
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [CS] Cyril.Saintot@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @version 0.1 (2013-11-15) LL
 * @version 0.2 (2013-06-26) CS
 * @version 0.3 (2014-06-28) LL
 */
public class EnsembleH<T extends CopieDeleguee & CopieImmediate> extends LinkedHashSet<T> implements
    Ensemble<T>, CopieReferentielle, CopieImmediate, CopieDeleguee, DescriptionTextuelle {
  // ***************************************************************************
  // Constructeurs : la base!
  //
  public EnsembleH() {
    super();
  }

  public EnsembleH(Collection<? extends T> c) {
    super(c);
  }

  // ***************************************************************************
  // Opérations générales
  //
  @Override
  public void vider() { // this := {}
    this.clear();
  }

  @Override
  public void ajouter(T a) { // this := this U {a}
    assert a != null;
    this.add(a);
  }

  @Override
  public EnsembleH<T> ajout(T a) { // return (this U {a})
    assert a != null;
    EnsembleH<T> e = new EnsembleH<>();
    e.addAll(this);
    e.add(a);
    return e;
  }

  @Override
  public void retirer(T a) { // this := this - {a}
    assert a != null;
    this.remove(a);
  }

  @Override
  public EnsembleH<T> retrait(T a) { // return (this - {a})
    assert a != null;
    EnsembleH<T> e = new EnsembleH<>();
    e.addAll(this);
    e.remove(a);
    return e;
  }

  @Override
  public void unir(Ensemble<T> e) { // this := this U e
    assert e != null;
    if (this != e) {
      this.addAll(e);
    }
  }

  @Override
  public EnsembleH<T> union(Ensemble<T> e) { // return (this U e)
    assert e != null;
    EnsembleH<T> u = new EnsembleH<>();
    u.addAll(this);
    if (this != e) {
      u.addAll(e);
    }
    return u;
  }

  @Override
  public void soustraire(Ensemble<T> e) { // this := this - e
    assert e != null;
    if (this != e) {
      this.removeAll(e);
    } else {
      this.clear();
    }
  }

  @Override
  public EnsembleH<T> soustraction(Ensemble<T> e) { // return (this - e)
    assert e != null;
    EnsembleH<T> d = new EnsembleH<>();
    if (this != e) {
      d.addAll(this);
      d.removeAll(e);
    }
    return d;
  }

  @Override
  public void intersecter(Ensemble<T> e) { // this := this ∩ e
    assert e != null;
    if (this != e) {
      this.retainAll(e);
    }
  }

  @Override
  public EnsembleH<T> intersection(Ensemble<T> e) { // return (this ∩ e)
    assert e != null;
    EnsembleH<T> i = new EnsembleH<>();
    i.addAll(this);
    if (this != e) {
      i.retainAll(e);
    }
    return i;
  }

  // Observateurs
  @Override
  public boolean vide() { // this = {}
    return this.isEmpty();
  }

  @Override
  public int card() { // #this
    return this.size();
  }

  @Override
  public boolean contient(T e) { // a dans this
    assert e != null;
    return this.contains(e);
  }

  @Override
  public boolean egal(Ensemble<T> e) { // this = e
    assert e != null;
    boolean b = this.equals(e);
    // XXXX [LL] 2014-07-04 : test temporaire de cohérence égalité-sous-ensemble
    assert b == this.sousEnsemble(e) && e.sousEnsemble(this);
    return b;
  }

  @Override
  public boolean sousEnsemble(Ensemble<T> e) { // this <= e
    assert e != null;
    boolean r = true;
    for (Iterator<T> i = this.iterator(); i.hasNext() && r;) {
      T a = i.next();
      r = e.contains(a);
    }
    return r;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <S extends T> EnsembleH<S> filtrer(Class<S> idClass) {
    EnsembleH<T> ensC = new EnsembleH<>();
    for (T c : this) {
      if (idClass == c.getClass()) {
        ensC.add(c);
      }
    }
    return (EnsembleH<S>) ensC;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <S extends T> EnsembleH<S> filtrerD(Class<S> idClass) {
    EnsembleH<T> ensC = new EnsembleH<>();
    for (T c : this) {
      if (idClass.isAssignableFrom(c.getClass())) {
        ensC.add(c);
      }
    }
    return (EnsembleH<S>) ensC;
  }

  // ***************************************************************************
  // toString, toTexte, etc.
  //
  @Override
  public String toString() {
    return this.description(true, false);
  }

  /**
   * Affiche les informations d'un ensemble
   *
   * @return
   */
  @Override
  public void decrire(Texte s, boolean complet, boolean enProfondeur) {
    // pas de super.decrire!
    s.ajouter("{");
    s.niveauPlus();
    Iterator<T> c = this.iterator();
    while (c.hasNext()) {
      T x = c.next();
      if (x == null) {
        s.ajouter("?null?");
      } else if (x instanceof DescriptionTextuelle) {
        if (enProfondeur) {
          ((DescriptionTextuelle) x).decrire(s, true, true);
        } else {
          ((DescriptionTextuelle) x).decrire(s, false, false);
        }
      } else {
        s.ajouter(x.toString() + "\n");
      }
      if (c.hasNext()) {
        s.ajouter(", ");
      }
    }
    s.niveauMoins();
    s.ajouter("}");
  }

  // ***************************************************************************
  // Opérations particulières
  //
  /**
   * Recherche d'un élément portant le nom "id" - fonction offerte aux seuls ensembles dont le type
   * des éléments (T) met en oeuvre l'interface ca.usherbrooke.metis.mds.Nom (ou qui en dérive)
   */
  public T chercher(String id) {
    // TODO 2017-01-28 [LL] Comment tester ceci à la compilation ?
    // assert (this instanceof Nom);
    for (T x : this) {
      if (((Nom) x).getNom().equals(id)) {
        return x;
      }
    }
    return null;
  }

  // XXXX [DMD] 2015-04-12 : Fonction pour tests des attributs seulement (classe Variable_New)
  /**
   * Recherche d'un objet dans un ensemble
   */
  public T chercher(T source) {
    assert source != null;
    for (Iterator<T> i = this.iterator(); i.hasNext();) {
      T a = i.next();
      if (a.immEgal(source)) {
        return a;
      }
    }
    return null;
  }

  // ***************************************************************************
  // Opérations de copie référentielle, immédiate et déléguée.
  //
  @Override
  public EnsembleH<T> refCopie() {
    return this;
  }

  @Override
  public boolean refEgal(Object x) {
    return this == x;
  }

  @Override
  public int refEmpreinte() {
    return System.identityHashCode(this);
  }

  @Override
  public EnsembleH<T> immCopie() {
    EnsembleH<T> copie = new EnsembleH<>();
    copie.addAll(this);
    return copie;
  }

  @Override
  public boolean immEgal(Object x) {
    if (this == x) {
      return true;
    }
    if (x == null) {
      return false;
    }
    assert x instanceof EnsembleH<?>;
    return this.equals(x);
  }

  @Override
  public int immEmpreinte() {
    return this.hashCode();
  }

  @Override
  public EnsembleH<T> delCopie() {
    EnsembleH<T> copie = new EnsembleH<>();
    for (T e : this) {
      // XXXX [LL] 2014-07-20 : comment peut-il y avoir des nuls dans un ensemble ???
      if (e == null) { //NOPMD
        // FIXME [LL] 2014-08-04 : Pourquoi y a t-il des nuls et que faire dans ce cas ?
        // assert (false);
      } else {
        @SuppressWarnings("unchecked")
        T f = (T) e.delCopie();
        copie.add(f);
      }
    }
    // XXXX [LL] 2014-07-03 : Test interne temporaire de dCopie
    // assert (this.vide() || !this.iEgal(copie)) : "this " + this + "; copie " + copie;
    // assert (this.dEgal(copie)) : "this " + this + "; copie " + copie;
    return copie;
  }

  @Override
  public boolean delEgal(Object x) {
    if (this == x) {
      return true;
    }
    if (x == null) {
      return false;
    }
    assert x instanceof EnsembleH<?>;
    @SuppressWarnings("unchecked")
    EnsembleH<T> autre = (EnsembleH<T>) x;
    if (this.card() != autre.card()) {
      return false;
    }
    //
    // Nous sommes en présence de deux représentations d'ensemble distinctes de même cardinalité
    // Deux stratégies possibles : [a] réduction d'une copie ou [b] marqueurs.
    // [a] On retire les éléments de la copie au fur et à mesure;
    // à la fin on vérifie que la copie est vide. Remarque une iCopie est suffisante.
    // [b] On marque les éléments trouvés au fur et à mesure; à la fin, on vérifie qu'ils sont tous
    // marqués.
    // Les deux stratégies sont en O(n^2).
    // Les type Composant ne définit pas d'opérateur de marquage, donc [a].
    //
    // OPT [LL] 2014-07-09 : Optimiser EnsembleH.dEgal()
    //
    EnsembleH<T> copie = autre.immCopie();
    boolean result = true;
    for (T e : this) {
      result = false;
      for (T c : copie) {
        assert e != null && c != null;
        assert e.getClass() == c.getClass() : "e : " + e.getClass().getName() + "; c : "
            + e.getClass().getName();
        if (e.delEgal(c)) {
          copie.remove(c);
          result = true;
          break;
        }
      }
      if (!result) {
        break;
      }
    }
    assert Booleen.implies(result, copie.vide()); // puisque les cardinalités étaient égales au
    // départ
    return result;
  }

  @Override
  public int delEmpreinte() {
    int result = 0;
    for (T e : this) {
      result = result * EmpNum_facteur + e.delEmpreinte();
    }
    return result;
  }

  // **************************************************************************
  // Signature du composant logiciel.
  //
  private static final long serialVersionUID = -7986768398669298857L;

  private static final String Metis_svn =
      "$Id: EnsembleH.java 1458 2015-09-15 19:36:11Z khnc2501 $";

  public static final String Metis_id = Metis_svn.substring(5, Metis_svn.length() - 2);
}

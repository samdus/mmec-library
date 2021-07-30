package ca.griis.base.ensemble;

import ca.griis.base.CopieDeleguee;
import ca.griis.base.CopieImmediate;
import java.util.Set;

/**
 * <b>Description</b>
 * <p>
 * Interface communes aux ensembles utilisés dans MDS.
 * <p>
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
 * $Id: Ensemble.java 602 2014-08-01 15:02:48Z lavl1905 $
 * <p>
 *
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @version 0.1 (2013-11-15) LL
 * @version 0.2 (2014-06-28) LL
 */
public interface Ensemble<T extends CopieDeleguee & CopieImmediate> extends Set<T> {
  // ===
  // Tous les opérateurs de Set sont directement hérités et valides,
  // ce qui garantit l'utilisation d'Ensemble partout où Set peut être utilisé.
  // ===
  // Transformateurs
  public void vider(); // this := {}

  public void ajouter(T a); // this := this ∪ {a}

  public Ensemble<T> ajout(T a); // return (this ∪ {a})

  public void retirer(T a); // this := this - {a}

  public Ensemble<T> retrait(T a); // return (this - {a})

  public void unir(Ensemble<T> e); // this := this ∪ e

  public Ensemble<T> union(Ensemble<T> e); // return (this ∪ e)

  public void soustraire(Ensemble<T> e); // this := this - e

  public Ensemble<T> soustraction(Ensemble<T> e); // return (this - e)

  public void intersecter(Ensemble<T> e); // this := this ∩ e

  public Ensemble<T> intersection(Ensemble<T> e); // return (this ∩ e)

  public <S extends T> Ensemble<S> filtrer(Class<S> idClass);

  public <S extends T> Ensemble<S> filtrerD(Class<S> idClass);

  // Observateurs
  public boolean vide(); // return (this = {})

  public int card(); // return (#this)

  public boolean contient(T a); // return (a ∈ this)

  public boolean egal(Ensemble<T> e); // return (this = e)

  public boolean sousEnsemble(Ensemble<T> e); // return (this ⊆ e)
}

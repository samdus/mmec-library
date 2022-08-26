package ca.griis.base.ensemble;

import ca.griis.base.CopieDeleguee;
import ca.griis.base.CopieImmediate;
import ca.griis.base.Structurel;

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
 * $Id: EnsembleB.java 643 2014-08-05 14:39:33Z lavl1905 $
 * <p>
 *
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @version 0.1 (2013-11-15) LL
 * @version 0.2 (2014-06-28) LL
 * @version 0.3 (2014-07-30) LL
 */
public interface EnsembleB<T extends CopieDeleguee & CopieImmediate> extends Structurel<T> {
  // ===
  // Tous les opérateurs de Set sont directement hérités et valides,
  // ce qui garantit l'utilisation d'Ensemble partout où Set peut être utilisé.
  // ===
  // Transformateurs
  void vider(); // this := {}

  <B extends T> void ajouter(B a); // this := this ∪ {a}

  <B extends T, S extends EnsembleB<B>> S ajout(B a); // return (this ∪ {a})

  <B extends T> void retirer(B a); // this := this - {a}

  <B extends T, S extends EnsembleB<B>> S retrait(B a); // return (this - {a})

  <B extends T, S extends EnsembleB<B>> void unir(S e); // this := this ∪ e

  <B extends T, S extends EnsembleB<B>> S union(S e); // return (this ∪ e)

  <B extends T, S extends EnsembleB<B>> void soustraire(S e); // this := this - e

  <B extends T, S extends EnsembleB<B>> S soustraction(S e); // return (this - e)

  <B extends T, S extends EnsembleB<B>> void intersecter(S e); // this := this ∩ e

  <B extends T, S extends EnsembleB<B>> S intersection(S e); // return (this ∩ e)

  <B extends T, S extends EnsembleB<B>> S filtrer(Class<B> idClass);

  <B extends T, S extends EnsembleB<B>> S filtrerD(Class<B> idClass);

  // Observateurs
  boolean vide(); // return (this = {})

  int card(); // return (#this)

  <B extends T> boolean contient(B a); // return (a ∈ this)

  <B extends T, S extends EnsembleB<B>> boolean egal(S e); // return (this = e)

  <B extends T, S extends EnsembleB<B>> boolean sousEnsemble(S e); // return (this ⊆ e)
}

package ca.griis.base;

/**
 * Propriété d'une type dont les objets proposent une structure sur un type générique
 * qui est seul porteur de la sémantique d'égalité. En pratique, les fonctions copies devront
 * passer "au travers" de la structure sans en tenir compte. Voir la structure d'Ensemble
 * pour une application concrète de ce principe.
 */
public interface Structurel<T> extends CopieImmediate, CopieDeleguee, Iterable<T> {
  //
  // TODO 2016-05-06 [3:LL] Revoir la documentation de cette classe.
  // La compléter et la rendre conforme au standard.
  //
}

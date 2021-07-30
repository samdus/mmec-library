package ca.griis.base;

/**
 * Caractérisation des classes offrant la copie par délégation (copie "en profondeur"; deep copy).
 * <p>
 *
 * <b>Description</b>
 * <p>
 * Elle se caractérise par le fait qu'elle reproduit la même structure et les mêmes valeurs (mais en
 * général pas les mêmes emplacements).
 * <p>
 * 
 * <b>Invariants</b>
 * <ul>
 * <li>Réflexivité : <code> a.dEgal(a) </code></li>
 * <li>Symétrie : <code> a.dEgal(b) == b.dEgal(a) </code></li>
 * <li>Transitivité : <code> (a.dEgal(b) && b.dEgal(c)) implies a.dEgal(c) </code></li>
 * <li>Préservation (de la classe) : <code> x.dCopie().getClass() == x.getClass() </code></li>
 * <li>Cohérence egal-copie : <code> x.dEgal(x.dCopie()) </code></li>
 * <li>Cohérence egal-empreinte :
 * <code> a.dEgal(b) implies (a.dEmpreinte() == b.dEmpreinte()) </code></li>
 * <li>Non-identité : <code> x.copie() != x </code></li>
 * </ul>
 *
 * <b>Tâches projetées</b>
 * <p>
 * <i>NIL</i> <br>
 * <p>
 * 
 * <b>Tâches réalisées</b>
 * <p>
 * <i>2014-06-30 (0.1.0) [LL] Mise en oeuvre initiale. </i> <br>
 * <p>
 *
 * <b>Copyright</b> 2014-2016, Μῆτις (http://info.usherbrooke.ca/llavoie/) <br>
 * <b>Copyright</b> 2016-2017, GRIIS (http://griis.ca/)
 * <p>
 * GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé) <br>
 * Faculté des sciences et Faculté de médecine et des sciences de la santé <br>
 * Université de Sherbrooke (Québec) J1K 2R1 <br>
 * CANADA <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 *
 * @since 2014-06-30
 * @version 0.1.0
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */
public interface CopieDeleguee {
  /**
   * Copie par délégation de l'objet.
   * 
   * @return la copie
   */
  public Object dCopie();

  /**
   * Égalité par délégation entre deux objets
   * 
   * @param x : l'objet comparé
   * @return égalité entre this et x
   */
  public boolean dEgal(Object x);

  /**
   * Empreinte d'un objet cohérente avec la copie et l'égalité
   * 
   * @return l'empreinte de l'objet
   */
  public int dEmpreinte();
}

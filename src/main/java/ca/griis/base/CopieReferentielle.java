package ca.griis.base;

/**
 * Caractérisation des classes offrant la copie référentielle d'un objet (pointer copy).
 * <p>
 * <b>Invariants</b>
 * <ul>
 * <li>Réflexivité : <code> a.rEgal(a) </code></li>
 * <li>Symétrie : <code> a.rEgal(b) == b.rEgal(a) </code></li>
 * <li>Transitivité : <code> (a.rEgal(b) && b.rEgal(c)) implies a.rEgal(c) </code></li>
 * <li>Préservation (de la classe) : <code> x.rCopie().getClass() == x.getClass() </code></li>
 * <li>Cohérence egal-copie : <code> x.rEgal(x.rCopie()) </code></li>
 * <li>Cohérence egal-empreinte :
 * <code> a.rEgal(b) implies (a.rEmpreinte() == b.rEmpreinte()) </code></li>
 * <li>Identité : <code> x.copie() == x </code></li>
 * </ul>
 * <b>Mise en garde</b>
 * <p>
 * La sémantique référentielle exige (et garantit) l'Identité, contrairement
 * aux sémantiques immédiate et déléguée qui exigent (et garantissent) la Non-Identité.
 * <p>
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
public interface CopieReferentielle {
  /**
   * Copie reférentielle de l'objet.
   * 
   * @return la copie
   */
  public Object rCopie();

  /**
   * Égalité référentielle entre deux objets
   * 
   * @param x : l'objet comparé
   * @return égalité entre this et x
   */
  public boolean rEgal(Object x);

  /**
   * Empreinte d'un objet, cohérente avec la copie et l'égalité
   * 
   * @return l'empreinte de l'objet
   */
  public int rEmpreinte();
}

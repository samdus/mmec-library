package ca.griis.base;

/**
 * <b>Description</b>
 * <p>
 * Interface minimale de tout composant offrant un service de dénomination ayant la capacité
 * de traiter l'anonymat.
 * <p>
 *
 * <b>Copyright</b>
 * <p>
 * 2013-2014, Chantier Améthyste (http://info.usherbrooke.ca/llavoie/) <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 *
 * <b>Références</b>
 * <p>
 * [1] http://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html
 * <p>
 *
 * <b>Création</b>
 * <p>
 * 2014-07-21
 * <p>
 *
 * <b>Signature</b>
 * <p>
 * $Id: Nom.java 602 2014-08-01 15:02:48Z lavl1905 $
 * <p>
 *
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @version 0.1 (2014-07-21) [LL]
 */
public interface Nom {
  //
  // TODO 2016-05-06 [3:LL] Revoir la documentation de cette classe.
  // La compléter et la rendre conforme au standard.
  //
  public String getNom();

  public void setNom(String nouveauNom);

  public void setAnonyme();

  public boolean anonyme();
}

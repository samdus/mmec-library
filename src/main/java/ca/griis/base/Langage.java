package ca.griis.base;

/**
 * Référence à un identifiant de tuple.
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
 * <i>(2014-08-07) (0.1.0) [CK] Mise en oeuvre initiale. </i> <br>
 * <p>
 * 
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
 * @since 2014-08-07
 * @version 0.1.0
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */
public enum Langage {
  SSQL("SSQL"), Discipulus("Discpulus");

  private String id = "";

  private Langage(String id) {
    this.id = id;
  }

  public String getNom() {
    return id;
  }
}

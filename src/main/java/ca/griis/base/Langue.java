package ca.griis.base;

//@formatter:off
/*******************************************************************************
 * <p><b>Description</b></p>
 * <p>
 *   Énumérateur des acronymes ISO des langues.
 * </p>
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * 
 * @version 0.0 2016-04-22 (CK) : Création initiale
 * @version 1.0 2016-05-06 (CK) : Migration de GenFee à MOnto
 *******************************************************************************/
//@formatter:on

// TODO 2016-05-06 [3:LL] Revoir la documentation de cette classe.
// La compléter et la rendre conforme au standard,
// TODO 2016-05-06 [3:LL] Une classe contenant tous les codes ISO existe certainement déjà.
// la retracer et l'utiliser à la place, revoir ca.griis.base.Glossaire en conséquence.

public enum Langue {
  fr("fr"), en("en"), art("art"), vide("");

  public final String nom;

  Langue(String nom) {
    this.nom = nom;
  }
}
// @formatter:off
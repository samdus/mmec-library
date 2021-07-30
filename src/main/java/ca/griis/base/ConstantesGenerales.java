package ca.griis.base;

/**
 * Constantes paramétrant certaines fonctions globales (par exemple hashCode) réunies ici par souci
 * de cohérence et d'harmonisation.
 * <p>
 *
 * <b>Description</b>
 * <p>
 * Pour le calcul des empreintes numériques (hashCode), les valeurs sont reprises des bibliothèques
 * de la version 1.8 de Java SE. Pour les autres, elles ont été choisies par l'auteur.
 * <p>
 *
 * <b>Tâches projetées</b>
 * <p>
 * <i>TODO 2017-01-16 [LL] Identifier et intégrer les autres constantes semblables. </i> <br>
 * <p>
 * <i>TODO 2014-07-03 [LL] Identifier de meilleures valeurs. </i> <br>
 * De meilleurs valeurs sont certainement possibles, il faudrait voir dans quelle mesure
 * elles auraient un effet positif compte tenu de l'utilisation des valeurs 31, 1231 et 1237
 * dans les bibliothèques de la version 1.8 de Java SE.
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

public final class ConstantesGenerales {
  public static final int EmpNum_facteur = 31;

  public static final int EmpNum_valVrai = 1231;

  public static final int EmpNum_valFaux = 1237;

  public static final String alinea = ";\n    ";
}

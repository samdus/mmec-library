package ca.griis.base;

/**
 * Utilitaires complétant la définition du type boolean de Java.
 * <p>
 *
 * <b>Description</b>
 * <p>
 * Ajout d'opérateurs logiques afin de réduire la complexité des expressions logiques ou
 * en faciliter la lecture et la compréhension.
 * <p>
 *
 * <b>Tâches projetées</b>
 * <p>
 * <i>NIL</i> <br>
 * <p>
 *
 * <b>Tâches réalisées</b>
 * <p>
 * <i>2017-01-24 (0.1.1) [LL] Ajout des opérateurs ioi et xor. </i> <br>
 * <p>
 * <i>2014-06-30 (0.1.0) [LL] Mise en oeuvre initiale (implies). </i> <br>
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
 * @version 0.1.1
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */

public class Booleen {
  /**
   * implies - logical implication; implication logique.
   */
  public static boolean implies(boolean a, boolean b) {
    return (!a) || b;
  }

  /**
   * ioi - if and only if; si et seulement si.
   */
  public static boolean ioi(boolean a, boolean b) {
    return a == b;
  }

  /**
   * xor - exclusive or; ou exclusif.
   */
  public static boolean xor(boolean a, boolean b) {
    return (a && !b) || (b && !a);
  }

}

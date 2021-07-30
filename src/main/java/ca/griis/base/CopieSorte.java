package ca.griis.base;

/**
 * Inventaire des modes (sémantiques) de copie utilisable au sein de la logithèque GRIIS.
 * <p>
 * 
 * <b>Description</b>
 * <p>
 * Les trois sortes de copie correspondent à trois sémantiques de l'affectation (référence,
 * immédiate, déléguée).
 * Ce type est notamment permet de minimiser le risque de confusion entre les constructeurs
 * lorsque la solution 2 de la note de travail [2].
 * <p>
 *
 * <b>Tâches projetées</b>
 * <p>
 * <i>TODO 2014-07-05 [LL] Retracer la note de service. </i> <br>
 * De meilleurs valeurs sont certainement possibles, il faudrait voir dans quelle mesure
 * elles auraient un effet positif compte tenu de l'utilisation des valeurs 31, 1231 et 1237
 * dans les bibliothèques de la version 1.8 de Java SE.
 * <p>
 * 
 * <b>Tâches réalisées</b>
 * <p>
 * <i>2014-07-05 (0.1.0) [LL] Mise en oeuvre initiale. </i> <br>
 * <p>
 * 
 * <b>Références</b>
 * <p>
 * [1] http://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html
 * <p>
 * [2] Note de travail à retracer.
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
 * @since 2014-07-05
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @version 0.1.0
 */
public enum CopieSorte {
  referentielle, // (pointer copy)
  immediate, // (shallow copy)
  deleguee // (copie "en profondeur"; deep copy)
}

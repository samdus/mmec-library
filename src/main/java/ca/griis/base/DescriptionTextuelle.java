package ca.griis.base;

public interface DescriptionTextuelle {
  //
  // TODO 2017-01-24 [2:LL] Documenter l'intrface DescriptionTextuelle.
  //
  void decrire(Texte s, boolean complet, boolean enProfondeur);

  default String description(boolean complet, boolean enProfondeur) {
    Texte t = new Texte();
    this.decrire(t, complet, enProfondeur);
    return t.toString();
  }
}

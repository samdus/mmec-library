package ca.griis.base;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class Glossaire {
  //
  // TODO 2017-01-24 [2:LL] Documenter la classe Glossaire.
  //
  // FIXME [LL] 2014-07-21 Corriger de façon à faire disparaître le message suivant de Java.
  // "Cannot refer to the static enum field GlossaireMDS.Langue.nLangue within an initializer"
  // Pour cette raison, la variable nLangue est déclarée ici et non à sa place naturelle,
  // à savoir au sein de la classe enum. Ce qu'il en faut du travail quand même pour simuler
  // les types définis par énumération de Pascal! (nostalgie)
  //
  private static int nLangue = 0;

  public enum Langue {
    fr(), en() /*-- , es(), de(), pt(), ar(), ... --*/;

    private int val;

    @SuppressWarnings("synthetic-access")
    private Langue() {
      this.val = nLangue;
      nLangue++;
    }

    public int value() {
      return this.val;
    }
  }

  public static final Langue langueDeReference = Langue.fr;

  private static Langue langue = langueDeReference;

  public static Langue getLangue() {
    return Glossaire.langue;
  }

  public static void setLangue(Langue langue) {
    Glossaire.langue = langue;
  }

  private ResourceBundle[] mes;

  public Glossaire(String emplacement, String nomRessource) {
    super();
    if (this.mes == null) {
      this.recharger(emplacement, nomRessource);
    }
  }

  public Glossaire(String nomRessource) {
    this(null, nomRessource);
  }

  public void recharger(String emplacement, String nomRessource) {
    this.mes = new ResourceBundle[Langue.values().length];
    if (emplacement == null || emplacement.equals("")) {
      emplacement = "ressources/";
    }
    emplacement = emplacement + nomRessource;
    final Locale ref = new Locale(langueDeReference.toString());
    this.mes[langueDeReference.value()] = ResourceBundle.getBundle(emplacement, ref);
    for (Langue x : Langue.values()) {
      if (x != langueDeReference) {
        final Locale courant = new Locale(x.toString());
        this.mes[x.value()] = ResourceBundle.getBundle(emplacement, courant);
        // vérification
        boolean err = false;
        Enumeration<String> listeCles = this.mes[langueDeReference.value()].getKeys();
        while (listeCles.hasMoreElements()) {
          String cle = listeCles.nextElement();
          if (!this.mes[x.value()].containsKey(cle)) {
            err = true;
            System.out.println(cle + " absent de " + emplacement + "(" + x + ")");
          }
        }
        if (err) {
          this.mes[x.value()] = this.mes[langueDeReference.value()];
        }
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("Glossaire :\n");
    for (Langue x : Langue.values()) {
      s.append("  " + x + "\n");
      Enumeration<String> listeCles = this.mes[x.value()].getKeys();
      while (listeCles.hasMoreElements()) {
        String cle = listeCles.nextElement();
        s.append("  * " + cle + " = <" + this.mes[x.value()].getString(cle) + ">\n");
      }
    }
    return s.toString();
  }

  public String etiquette(String v) {
    return this.etiquette(v, Glossaire.langue);
  }

  public String etiquette(String v, Langue langue) {
    if (this.mes[langue.value()].containsKey(v)) {
      v = this.mes[langue.value()].getString(v);
    }
    return v;
  }

  public boolean etiquetteDefinie(String v, Langue langue) {
    return this.mes[langue.value()].containsKey(v);
  }

  public boolean etiquetteDefinie(String v) {
    return this.etiquetteDefinie(v, Glossaire.langue);
  }

  public ResourceBundle getBundle() {
    return this.mes[Glossaire.langue.value()];
  }
}

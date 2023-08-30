package ca.griis.base;

/**
 * <b>Description</b>
 * <p>
 * ... ... ...
 * <p>
 *
 * <b>Propriétés des objets</b>
 * <p>
 * <li>Unicité : oui | non (pourquoi).</li>
 * <li>Clonabilité : oui | non (pourquoi).</li>
 * <li>Modifiabilité : oui | non (pourquoi).</li>
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
 * 2014-08-03
 * <p>
 *
 * <b>Signature</b>
 * <p>
 * $Id: Texte.java 628 2014-08-04 13:55:33Z lavl1905 $
 * <p>
 *
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @version 0.1 (2014-08-03) [LL]
 */
public class Texte {
  //
  // TODO 2016-05-06 [3:LL] Revoir la documentation de cette classe.
  // La compléter et la rendre conforme au standard.
  //
  private StringBuilder stringBuilder;

  private int nbLignes;
  private int noCar;
  private int niveau;

  private int decalage = 2;

  private int marge = 100;

  public Texte(String s) {
    super();
    this.stringBuilder = new StringBuilder(s);
  }

  public Texte() {
    this("");
  }

  public Texte(Texte t) {
    this(t.stringBuilder.toString());
    this.nbLignes = t.nbLignes;
    this.noCar = t.noCar;
    this.niveau = t.niveau;
    this.decalage = t.decalage;
    this.marge = t.marge;
  }

  public void niveauPlus() {
    this.niveau++;
  }

  public void niveauMoins() {
    this.niveau--;
  }

  public void niveauNul() {
    this.niveau = 0;
  }

  public int getDecalage() {
    return this.decalage;
  }

  public void setDecalage(int decalage) {
    if (decalage < 0) {
      this.decalage = 0;
    } else if (decalage > 8) {
      this.decalage = 8;
    } else {
      this.decalage = decalage;
    }
  }

  public int getMarge() {
    return this.marge;
  }

  public void setMarge(int marge) {
    if (marge < 60) {
      this.marge = 60;
    } else {
      this.marge = marge;
    }
  }

  public int getNbLignes() {
    return this.nbLignes;
  }

  public void fdl() {
    this.stringBuilder.append("\n");
    this.nbLignes++;
    this.noCar = 0;
  }

  public void ajouter(String s) {
    if (this.noCar + s.length() > this.marge) {
      this.fdl();
    }
    if (this.noCar == 0) {
      this.noCar = Math.min(this.niveau * this.decalage, this.marge / 2);
      for (int i = 0; i < this.noCar; i++) {
        this.stringBuilder.append(" ");
      }
    }
    this.stringBuilder.append(s);
    this.noCar += s.length();
  }

  public void concat(Texte t) {
    if (t.getNbLignes() == 0) {
      this.ajouter(t.stringBuilder.toString());
    } else {
      if (this.noCar != 0) {
        this.fdl();
      }
      this.stringBuilder.append(t.stringBuilder);
      this.nbLignes += t.nbLignes;
      this.noCar = t.noCar;
    }
  }

  @Override
  public String toString() {
    return this.stringBuilder.toString();
  }
}

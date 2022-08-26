package ca.griis.base;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Gestionnaire des messages.
 * <p>
 *
 * <b>Description</b>
 * <p>
 * Classe utilitaire pour la génération de chaine de caractères uniformes décrivant les
 * composants de la logithèque GRIIS.
 * <p>
 *
 * <b>Tâches projetées</b>
 * <p>
 * <i>TODO 2019012017 [LL] Paraméter l'usage des codes de couleurs. </i> <br>
 * Les codes découlent sont le plus souvent ininterprétables.
 * Il faut pouvoir paramétrer la description afin de les inclure ou non selon le cas.
 * <p>
 * <i>TODO 2017-01-24 [LL] Changer le nom de la classe. </i> <br>
 * Le nom de la classe n'est pas assez spécifique. Prendre en considération d'autres
 * classes analogues, dont DescriptionTextuelle.
 * <p>
 * <i>TODO 2016-08-03 [CK] Traduire en anglais. </i> <br>
 * LL : que traduire exactement ?
 * <p>
 *
 * <b>Tâches réalisées</b>
 * <p>
 * <i>2020-09-18 (1.0.1) [CK] Migration de MOnto à Base. </i> <br>
 * <p>
 * <i>2017-01-24 (1.0.1) [CK] Migration de MOnto à Base. </i> <br>
 * <p>
 * <i>2016-05-06 (1.0.0) [CK] Migration de GenFee à MOnto. </i> <br>
 * <p>
 * <i>2016-04-08 (0.0.0) [CK] Mise en oeuvre initiale. </i> <br>
 * <p>
 *
 * <b>Références</b>
 * <p>
 * [1]
 * http://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 * <p>
 *
 * <b>Copyright</b> 2016-2017, GRIIS (http://griis.ca/)
 * <p>
 * GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé) <br>
 * Faculté des sciences et Faculté de médecine et des sciences de la santé <br>
 * Université de Sherbrooke (Québec) J1K 2R1 <br>
 * CANADA <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 *
 * @since 2016-04-08
 * @version 1.0.1
 * @author [BF] Benoit.Fraikin@USherbrooke.ca
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 */

public class Descripteur {
  // ***********************************************************************************************
  // Constantes publiques
  //
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  // ***********************************************************************************************
  // Attributs spécifiques
  //
  private StringWriter description;

  // ***********************************************************************************************
  // Constructeurs
  //
  public Descripteur() {
    description = new StringWriter();
    // int bufferSize = 8 * 1024;
    // description = new BufferedOutputStream(new FileOutputStream("classes_desc.txt"));
    // new OutputStreamWriter()
  }

  // ***********************************************************************************************
  // Fonctions
  //

  /**
   * Construit une chaîne à partir d'un seul caractères
   */
  public String repete(char c, int n) {
    return n < 1 ? "" : String.valueOf(c) + repete(c, n - 1);
  }

  /**
   * Enrobe une chaîne de caractère avec un caractère spécifique
   */
  public String enrobe(String s, char c) {
    final String d = String.valueOf(c);
    return d + s + d;
  }

  /**
   * Crée une entête à partir d'un texte et d'une chaîne qui enrobe le texte avant et après.
   */
  public String creeEntete(String texte, String enrobage) {
    return enrobage + texte + enrobage;
  }

  /**
   * Crée une ligne, précédée et suivie d'un retour à ligne,
   * à partir d'un caractère motif et de la longueur désirée de la chaîne.
   * Si la longueur est inférieur ou égale à 2, la chaîne produite se résume à "\n\n",
   * sinon la chaîne produite est "\n" suivi de longueur-2 caractères motif finie par "\n".
   */
  public String creeLigne(char motif, int longueur) {
    return enrobe(repete(motif, longueur - 2), '\n');
  }

  /**
   * Ajouter un titre
   *
   * @param titre
   */
  public void titre(String titre) {
    final int taille = 55;
    final char motif = '=';
    final String ligne = creeLigne(motif, taille);
    final String entete = creeEntete(titre, ligne);

    // TODO [3:LL] Utiliser un constructeur de chaine qui répète le caractère "=" autant de fois que
    // requis de part et d'autre du titre de façon à garantir une largeur constante convenue.
    // En conséquence, il serait opportun de prévoir un set+get pour ficher cette largeur.
    description.write(entete);
  }

  /**
   * Ajouter un sous titre
   *
   * @param soustitre
   */
  public void soustitre(String soustitre) {
    final int taille = 40;
    final char motif = '-';
    final String ligne = creeLigne(motif, taille);
    final String entete = creeEntete(soustitre, ligne);

    // TODO [3:LL] Factoriser avec la fonction titre.
    description.append(entete);
  }

  /**
   * Introduire un retour à la ligne.
   */
  public void sauterLigne() {
    description.append("\n");
  }

  /**
   * Ajouter une information.
   * Le texte se termine par un saut de ligne de ligne.
   *
   * @param info - chaine de caractère à ajouter.
   */
  public void ajouter(String info) {
    description.append(info);
    description.append("\n");
  }

  public void ajouterSsl(String info) {
    description.append(info + " ");
  }

  public void separateur() {
    description.append("-------------------- \n");
  }

  /**
   * Ajouter une information sur une erreur.
   * Le texte est affiché en rouge.
   *
   * @param info - chaine de caractère de l'erreur en rouge.
   */
  public void ajouterErreur(String info) {
    description.append(ANSI_RED + info + " " + ANSI_RESET);
    description.append("\n");
  }

  /**
   * Ajouter les informations des composants d'une liste.
   *
   * @param liste
   */
  public void ajouterListe(Stream<?> liste) {
    /*
    Iterator<?> i = liste.iterator();
    while (i.hasNext()) {
      ajouter("  " + i.next().toString());
    }
    */
    liste.forEach((i) -> {
      ajouter("  " + i.toString());
    });
  }

  /**
   * Ajouter les informations des composants d'une liste avec un titre.
   *
   * @param titre
   * @param liste
   */
  public void ajouterListe(String titre, Stream<?> liste) {
    ajouter(titre);
    ajouterListe(liste);
  }

  /**
   * Ajouter les informations des composants d'un "map".
   *
   * @param map
   */
  public void ajouterMap(Map<?, ?> map) {
    /*
    Iterator<? extends Map.Entry<?, ?>> i = map.entrySet().iterator();
    while (i.hasNext()) {
      Map.Entry<?, ?> e = i.next();
      ajouter("  " + e.getKey() + "=" + e.getValue());
    }
    */
    map.entrySet().forEach((e) -> {
      ajouter("  " + e.getKey() + "=" + e.getValue());
    });
  }

  /**
   * Ajouter les informations des composants d'un "map" avec un titre.
   *
   * @param titre
   * @param map
   */
  public void ajouterMap(String titre, Map<?, ?> map) {
    ajouter(titre);
    ajouterMap(map);
  }

  /**
   * Créer un fichier texte avec le contenu du descripteur.
   *
   * @param nomFichier - le nom du fichier, sans suffixe, mais pouvant être précédé d'un chemin
   */
  public void creerFichier(String nomFichier) {
    final String extension = ".txt";
    creerFichier(nomFichier, extension);
  }

  /**
   * Créer un fichier avec le contenu du descripteur.
   *
   * @param nomFichier - Idéalement le chemin où générer le fichier
   */
  public void creerFichier(String nomFichier, String extension) {
    File f = new File(nomFichier + extension);
    try (Writer out = new OutputStreamWriter(new FileOutputStream(f), Charset.forName("UTF-8"));) {
      out.write(description.toString());
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println(
          " La création du fichier " + nomFichier + extension + "a échouée : " + e.getMessage());
    }
  }

  @Override
  public String toString() {
    return description.toString();
  }
}

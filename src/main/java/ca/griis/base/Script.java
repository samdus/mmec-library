package ca.griis.base;

import java.io.*;
import java.nio.charset.Charset;

public class Script {
  public File fichier;

  /**
   * Créer un fichier pour contenir un script pour un langage de BD spécifique.
   * Pré-condition : LE dossier dans lequel le fichier va être créer doit exister.
   * 
   * @param nomFichier : fichier de sortie désiré avec son chemin absolu
   * @throws IOException
   */
  public Script(String nomFichier, Langage l) {
    // StringBuffer buffer = new StringBuffer(nomFichier + extension(l));
    this.fichier = new File(nomFichier + extension(l));
    viderFichier();
  }

  private String extension(Langage l) {
    if (l == Langage.Discipulus) {
      return ".dlus";
    } else if (l == Langage.SSQL) {
      return ".sql";
    } else {
      return ".txt";
    }
  }

  /**
   * Vider le fichier de script.
   */
  private void viderFichier() {
    try {
      PrintWriter p = new PrintWriter(fichier, "UTF-8");
      p.print("");
      p.close();
    } catch (IOException e) {
      String erreur = e.getMessage();
      System.err.println(erreur);
    }
  }

  /**
   * Méthode d'écriture du script dans un fichier
   * 
   * @param contenu : contenu à mettre dans le script.
   */
  public void ecrireScript(String contenu) {
    try (Writer writer = new OutputStreamWriter(new FileOutputStream(this.fichier.getPath(), true),
        Charset.forName("UTF-8"));) {
      writer.write(contenu);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

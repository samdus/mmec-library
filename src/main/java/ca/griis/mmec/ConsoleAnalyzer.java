/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe ConsoleAnalyzer.
 * @brief @~english ConsoleAnalyzer class implementation.
 */

package ca.griis.mmec;

//import ca.griis.odmv2.domain.document.DadagemDocument;

import java.io.File;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details
 *      «Detailed description of the component (optional)»
 * @par Model
 *      «Model (Abstract, automation, etc.) (optional)»
 * @par Conception
 *      «Conception description (criteria and constraints) (optional)»
 * @par Limits
 *      «Limits description (optional)»
 *
 * @brief @~french Interface personne-machine textuelle permettant l'analyse d'un programme
 *                 utilisant un analyseur syntaxique généré à l'aide de ANTLR.
 * @par Détails
 *      voir http://stackoverflow.com/questions/19350705
 *      /how-do-i-pretty-print-productions-and-line-numbers-using-antlr4
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2021-02-10 [BF] - Paramètre pour la règle de départ afin d'avoir une meilleure souplesse
 *                        d'utilisation<br>
 *      2019-12-16 [SD] - Lecture des arguments de programme.<br>
 *      2016-10-16 [LL] - Harmonisation des commentaires.<br>
 *      2016-10-13 [CK] - Création.<br>
 *
 * @par Tâches
 *      @toimprove 2016-10-13 [CK] - Permettre de choisir entre un dossier. Ce dossier contiendrait
 *                                   tous les fichiers à analyser ou un fichier.<br>
 *      @toimprove 2016-10-13 [CK] - Permettre de spécifier le langage désiré. On pourrait peut-être
 *                                   aussi le déduire par le suffixe.<br>
 */
public class ConsoleAnalyzer {

  public static void main(String[] args) {

    File file;
    String startingRule = "";

    switch (args.length) {
      case 0:
        file = getFile();
        startingRule = "dadagem_document";
        break;
      case 1:
        file = new File(args[0]);
        break;
      default:
        startingRule = args[0];
        file = new File(args[1]);
        break;
    }
    MMecAnalyzer simpleAnalyzer = new MMecAnalyzer();

    simpleAnalyzer.analyzeNewFile(file, startingRule);

//    DadagemDocument dadagemDocument = simpleAnalyzer.getDadagemDocument();

//    System.out.println(dadagemDocument);
  }

  private static File getFile() {
    /*try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
      System.out.println("Current directory : " + System.getProperty("user.dir"));
      System.out.print("Enter the file path: ");
      System.out.flush();
      return new File(scanner.nextLine());
    }*/
    return new File("src/test/resources/dataset/002-base_project.dad");
  }
}

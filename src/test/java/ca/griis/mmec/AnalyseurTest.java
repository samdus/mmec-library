package ca.griis.mmec;

import ca.griis.base.Descripteur;
import ca.griis.base.outilantlr.ErreurSyntaxique;
import org.antlr.v4.runtime.ParserRuleContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Décrire la classe ici.
 * <p>
 * <b>Propriétés des objets</b>
 * <ul>
 * <li>Unicité : oui | non (pourquoi).</li>
 * <li>Clonabilité : oui | non (pourquoi).</li>
 * <li>Modifiabilité : oui | non (pourquoi).</li>
 * </ul>
 *
 * <b>Tâches projetées</b>
 * <p>
 * <i>...</i> <br>
 * <p>
 *
 * <b>Tâches réalisées</b>
 * <p>
 * <i>2019-12-17 (0.2.1) [LL] Simplification et corrections mineures.</i> <br>
 * <i>2019-12-16 (0.2.0) [SD] Générisation du test.</i> <br>
 * <i>2017-07-31 (0.1.0) [CK] Mise en oeuvre initiale. </i> <br>
 * <p>
 *
 * <b>Copyright</b> 2014-2016, Μῆτις (http://info.usherbrooke.ca/llavoie/) <br>
 * <b>Copyright</b> 2016-2017, GRIIS (http://griis.ca/) <br>
 * <p>
 * GRIIS (Groupe de recherche interdisciplinaire en informatique de la santé) <br>
 * Faculté des sciences et Faculté de médecine et des sciences de la santé <br>
 * Université de Sherbrooke (Québec) J1K 2R1 <br>
 * CANADA <br>
 * [CC-BY-NC-3.0 (http://creativecommons.org/licenses/by-nc/3.0)]
 * <p>
 *
 * @author [CK] Christina.Khnaisser@USherbrooke.ca
 * @author [LL] Luc.Lavoie@USherbrooke.ca
 * @author [SD] Samuel.Dussault@USherbrooke.ca
 * @version 0.2.1
 * @since 2017-07-31
 */
public class AnalyseurTest {

    private static final String cheminJeux = "jeux";
    private static final String cheminTrace = "trace";

    /**
     * Paramétrisation du test selon les fichiers du répertoire "jeux".
     * Chaque fichier est exécuté indépendamment, pourvu que l'extension concorde avec les extensions
     * prévu par l'analyseur
     *
     * @throws IOException Erreur de lecture de fichiers
     */
    public static Stream<Arguments> creationDonneesTest() throws IOException {
        File jeux = new File(cheminJeux);
        return Arrays.stream(
                Objects.requireNonNull(
                        jeux.listFiles(fichier ->
                                !fichier.isHidden()
                                        && !fichier.isDirectory()
                                        && AnalyseurSpecifique.getExtensions().stream().anyMatch(extension -> fichier.getName().endsWith(extension)))))
                .map(Arguments::of);
    }

    @BeforeAll
    public static void creerRepertoireTrace() {
        File repertoire = new File(cheminTrace);
        if (!repertoire.exists()) {
            repertoire.mkdirs();
        }
    }

    @ParameterizedTest
    @MethodSource("creationDonneesTest")
    public void testGrammaire(File fichier) {
        String fichierTrace = Paths.get(cheminTrace, fichier.getName()).toAbsolutePath().toString();
        Descripteur descripteur = new Descripteur();

        AnalyseurSpecifique analyseur = new AnalyseurSpecifique(fichier);
        ParserRuleContext regleInitiale = getRegleInitiale(analyseur, fichier.getName());

        try {
            descripteur.ajouter(analyseur.analyserNouveauFichier(fichier, regleInitiale));
            ErreurSyntaxique erreurs = analyseur.getErreurs();

            if (fichier.getName().contains("_val.")) {
                Assertions.assertEquals(0, erreurs.nbErreur, String.format("Le fichier %s contient %d erreurs.", fichier.getName(),
                        erreurs.nbErreur));
            } else if (fichier.getName().contains("_inv.")) {
                Assertions.assertNotEquals(0, erreurs.nbErreur, String.format("Le fichier %s contient %d erreurs.", fichier.getName(),
                        erreurs.nbErreur));
            } else {
                throw new AssertionError(
                        String.format("Le fichier %s contient %d erreurs, mais n'est peut-être pas invalide.",
                                fichier.getName(), erreurs.nbErreur));
            }
        } finally {
            System.out.print(descripteur); // contient déjà une fin de ligne terminale
            analyseur.getTrace().creerFichier(fichierTrace, ".trace");
            System.out.printf("Trace générée dans %s%s%n", fichierTrace, ".trace");
        }
    }

    private ParserRuleContext getRegleInitiale(AnalyseurSpecifique analyseur, String fileName) {
        String[] fichierDivise = fileName.split("_");
        ParserRuleContext contexte;

        try {
            Method methode = analyseur.getAnalyseurSyntaxique().getClass().getMethod(fichierDivise[1]);
            contexte = (ParserRuleContext) methode.invoke(analyseur.getAnalyseurSyntaxique());
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | ArrayIndexOutOfBoundsException ignored) {
            System.err.println("Impossible de déterminer le contexte initial en fonction du nom du fichier. La règle de base sera utilisée.");
            contexte = analyseur.getAnalyseurSyntaxique().base();
        }

        return contexte;
    }
}

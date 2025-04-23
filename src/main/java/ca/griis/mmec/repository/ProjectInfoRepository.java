/**
 * @file
 *
 * @copyright Samuel Dussault ; GRIIS / Université de Sherbrooke
 *
 * @licence https://www.forge.gouv.qc.ca/licence/liliq-r/
 *
 * @version 1.2.0
 *
 * @brief @~french Implémentation de la classe LibraryVersionRepository.
 * @brief @~english LibraryVersionRepository class implementation.
 */

package ca.griis.mmec.repository;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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
 * @brief @~french Classe pour obtenir la version courante de la librairie.
 * @par Détails
 *      S.O.
 * @par Modèle
 *      S.O.
 * @par Conception
 *      S.O.
 * @par Limites
 *      S.O.
 *
 * @par Historique
 *      2024-08-13 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class ProjectInfoRepository {
  private static final GriisLogger logger = GriisLoggerFactory.getLogger(
      ProjectInfoRepository.class);
  private static final String defaultProjectInfoResourcePath = "/META-INF/project.txt";
  private final String projectInfoResourcePath;
  private final Map<String, String> properties = new HashMap<>();

  public ProjectInfoRepository() {
    this(defaultProjectInfoResourcePath);
  }

  protected ProjectInfoRepository(String projectInfoResourcePath) {
    logger.trace(Trace.ENTER_METHOD_1, projectInfoResourcePath);
    this.projectInfoResourcePath = projectInfoResourcePath;
  }

  public void loadInfoRepository() throws IOException {
    try (InputStream inputStream = ProjectInfoRepository.class.getResourceAsStream(
        projectInfoResourcePath)) {
      if (Objects.isNull(inputStream)) {
        throw new IOException("The project.txt file is not found.");
      }
      try (BufferedReader reader = new BufferedReader(
          new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
        String line;
        while ((line = reader.readLine()) != null) {
          String[] keyValue = line.split(" : ");
          if (keyValue.length == 2) {
            properties.put(keyValue[0].trim(), keyValue[1].trim());
          }
        }
      }
    }
  }

  public Optional<String> getApplicationMain() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Optional.ofNullable(properties.get("APPLICATION_MAIN"));
  }

  public Optional<String> getGroup() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Optional.ofNullable(properties.get("GROUP_PROJECT"));
  }

  public Optional<String> getName() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Optional.ofNullable(properties.get("NAME_PROJECT"));
  }

  public Optional<String> getProduct() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Optional.ofNullable(properties.get("PRODUCT"));
  }

  public Optional<String> getVersion() {
    logger.trace(Trace.ENTER_METHOD_0);
    return Optional.ofNullable(properties.get("VERSION_PROJECT"));
  }
}

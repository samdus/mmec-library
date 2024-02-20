/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe MMecSqlPpMappingFactory.
 * @brief @~english MMecSqlPpMappingFactory class implementation.
 */
package ca.griis.mmec.controller.ontop.injection;

import com.google.common.collect.ImmutableList;
import it.unibz.inf.ontop.injection.OntopMappingSettings;
import it.unibz.inf.ontop.injection.SQLPPMappingFactory;
import it.unibz.inf.ontop.spec.mapping.PrefixManager;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPMapping;
import it.unibz.inf.ontop.spec.mapping.pp.SQLPPTriplesMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import javax.inject.Inject;

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
 * @brief @~french «Brève description de la composante (classe, interface, ...)»
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
 *      2024-02-05 [SD] - Implémentation initiale<br>
 *
 * @par Tâches
 *      S.O.
 */
public class MMecSqlPpMappingFactory implements SQLPPMappingFactory {
  private final OntopMappingSettings settings;
  private final Class<?>[] paramTypes = {ImmutableList.class, PrefixManager.class};

  @Inject
  public MMecSqlPpMappingFactory(OntopMappingSettings settings) {
    this.settings = settings;
  }

  @Override
  public SQLPPMapping createSQLPreProcessedMapping(ImmutableList<SQLPPTriplesMap> newMappings,
      PrefixManager prefixManager) {
    return null;
  }

  /**
   * @brief @~english «Description of the method»
   * @param genericClass «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Extension de la méthode it.unibz.inf.ontop.injection.impl.
   *                 SQLPPMappingFactoryImpl#findConstructor servant à obtenir le
   *                 constructeur de la classe SQLPPMapping qui est configuré dans le fichier de
   *                 configuration de Ontop.
   * @param genericClass La classe générique pour laquelle on veut obtenir le constructeur.
   * @return Le constructeur de la classe SQLPPMapping configuré dans le fichier de configuration de
   *         Ontop.
   *
   * @par Tâches
   *    S.O.
   */
  private Constructor<? extends SQLPPMapping> findConstructor(Class<SQLPPMapping> genericClass) {
    String implementationName = settings.getProperty(genericClass.getCanonicalName())
        .orElseThrow(() -> new RuntimeException("No implementation declared for " +
            genericClass.getCanonicalName()));
    try {
      Class<? extends SQLPPMapping> implementationClass = Class.forName(implementationName)
          .asSubclass(genericClass);
      return implementationClass.getConstructor(ImmutableList.class, PrefixManager.class);
    } catch (ClassNotFoundException | NoSuchMethodException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  /**
   * @brief @~english «Description of the method»
   * @param params «Parameter description»
   * @return «Return description»
   *
   * @brief @~french Extension de la méthode it.unibz.inf.ontop.injection.impl.
   *                SQLPPMappingFactoryImpl#createSQLPreProcessedMapping servant à obtenir une
   *                instance de la classe SQLPPMapping configurée dans le fichier de configuration
   *                de Ontop.
   * @param params Les valeurs des paramètres du constructeur.
   * @return L'instance de la classe SQLPPMapping configurée dans le fichier de configuration de
   *         Ontop.
   *
   * @par Tâches
   *    S.O.
   */
  private SQLPPMapping createSQLPreProcessedMapping(Object... params) {
    try {
      Constructor<? extends SQLPPMapping> constructor = findConstructor(SQLPPMapping.class);
      return constructor.newInstance(params);
    } catch (InvocationTargetException e) {
      Throwable targetException = e.getTargetException();
      throw new RuntimeException(targetException.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }


}

/**
 * @file
 * @copyright @@GRIIS_COPYRIGHT@@
 * @licence @@GRIIS_LICENCE@@
 * @version @@GRIIS_VERSION@@
 * @brief @~french Implémentation de la classe PreBasicBound.
 * @brief @~english Implementation of the PreBasicBound class.
 */

package ca.griis.mmec.test.integration.util.dbtype;

import ca.griis.logger.GriisLogger;
import ca.griis.logger.GriisLoggerFactory;
import ca.griis.logger.statuscode.Trace;
import ca.griis.logger.statuscode.Warn;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import it.unibz.inf.ontop.dbschema.DBParameters;
import it.unibz.inf.ontop.dbschema.QuotedIDFactory;
import it.unibz.inf.ontop.dbschema.impl.SQLStandardQuotedIDFactory;
import it.unibz.inf.ontop.injection.CoreSingletons;
import it.unibz.inf.ontop.model.type.DBTypeFactory;
import java.io.Closeable;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.TimeZone;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.MountableFile;

/**
 * @brief @~english «Brief component description (class, interface, ...)»
 * @par Details «Detailed description of the component (optional)»
 * @par Model «Model (Abstract, automation, etc.) (optional)»
 * @par Conception «Conception description (criteria and constraints) (optional)»
 * @par Limits «Limits description (optional)»
 * @brief @~french Création d'une base de données PostgreSQL dans un conteneur de test
 * @par Details S.O.
 * @par Modèle S.O.
 * @par Conception S.O.
 * @par Limites S.O.
 * @par Historique 2023-09-01 [SD] - Implémentation initiale<br>
 * @par Tâches S.O.
 */
public class PostgresContainerWrapper implements Closeable {

  private static final GriisLogger logger = GriisLoggerFactory.getLogger(
      PostgresContainerWrapper.class);
  private static PostgresContainerWrapper instance;
  private final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:15.4");
  private final HikariConfig hikariConfig = new HikariConfig();
  private final HikariDataSource hikariDataSource;

  private PostgresContainerWrapper() {
    TimeZone.setDefault(TimeZone.getTimeZone("Z"));

    container.withCopyFileToContainer(MountableFile.forClasspathResource("testset/"),
        "/docker-entrypoint-initdb.d/");
    container.start();

    hikariConfig.setJdbcUrl(container.getJdbcUrl());
    hikariConfig.setUsername(container.getUsername());
    hikariConfig.setPassword(container.getPassword());
    hikariConfig.setDriverClassName(getDriverName());
    hikariDataSource = new HikariDataSource(hikariConfig);
  }

  /**
   * @return l'instance de PostgresContainerWrapper
   * @brief @~english «Description of the function»
   * @brief @~french Récupère l'instance de PostgresContainerWrapper
   */
  public static PostgresContainerWrapper getInstance() {
    if (instance == null) {
      instance = new PostgresContainerWrapper();
    }
    return instance;
  }

  /**
   * @throws SQLException «Exception description»
   * @throws SQLException exception SQL obtenue lors de la réinitialisation
   * @brief @~english «Description of the function»
   * @brief @~french Supprime toutes les tables de la base de données qui ne sont pas dans un schéma
   *        système
   */
  public void resetDB() throws SQLException {
    try (Connection connection = getConnection()) {
      try (Statement statement = connection.createStatement()) {
        statement.executeUpdate("do $$ declare\n" + "    r record;\n" + "begin\n"
            + "    for r in select table_name from information_schema.tables where table_schema ~ '(?!^information_schema|pg_.+|sys.+).*' loop\n"
            + "        execute 'drop table if exists \"' || r.table_name || '\" cascade;';\n"
            + "    end loop;\n" + "end $$;");
      }
    }
  }

  /**
   * @param sqlFile «Parameter description»
   * @param sqlFile le chemin du fichier sql à exécuter
   * @throws IOException «Exception description»
   * @throws SQLException «Exception description»
   * @throws IOException la lecture de fichier a échoué
   * @throws SQLException exception SQL obtenue lors de l'exécution
   * @brief @~english «Description of the function»
   * @brief @~french Exécute le fichier contenant des instructions SQL.
   */
  public void executeSQLFile(Path sqlFile) throws IOException, SQLException {
    logger.trace(Trace.ENTER_METHOD_1, "sqlFile", sqlFile);

    if (!Files.exists(sqlFile) || !Files.isRegularFile(sqlFile)) {
      logger.warn(Warn.FILE_NOT_FOUND, sqlFile.toString());
    } else {
      String query = Files.readString(sqlFile);
      try (Connection connection = getConnection();
          Statement statement = connection.createStatement()) {
        statement.execute(query);
      }
    }

    // try (Connection connection = getConnection();
    // BufferedReader reader = new BufferedReader(new FileReader(sqlFile))) {
    //
    // Statement statement = connection.createStatement();
    // String line;
    // StringBuilder sqlQuery = new StringBuilder();
    //
    // while ((line = reader.readLine()) != null) {
    // sqlQuery.append(line);
    //
    // if (line.trim().endsWith(";")) {
    // statement.execute(sqlQuery.toString());
    // sqlQuery.setLength(0);
    // }
    // }
    // }

    logger.trace(Trace.EXIT_METHOD_0);
  }


  public HikariDataSource getHikariDataSource() {
    return hikariDataSource;
  }

  public Connection getConnection() throws SQLException {
    return hikariDataSource.getConnection();
  }

  public String getName() {
    return "PostgreSQL";
  }

  public String getDriverName() {
    return "org.postgresql.Driver";
  }

  public Properties getPropertiesForOntop() {
    Properties properties = new Properties();
    properties.setProperty("jdbc.driver", getDriverName());
    properties.setProperty("jdbc.name", container.getDatabaseName());
    properties.setProperty("jdbc.url", container.getJdbcUrl());
    properties.setProperty("jdbc.user", container.getUsername());
    properties.setProperty("jdbc.password", container.getPassword());
    return properties;
  }

  public DBParameters getDBParameters(CoreSingletons coreSingletons) {
    return new DBParameters() {
      @Override
      public QuotedIDFactory getQuotedIDFactory() {
        return new SQLStandardQuotedIDFactory();
      }

      @Override
      public DBTypeFactory getDBTypeFactory() {
        return coreSingletons.getTypeFactory().getDBTypeFactory();
      }

      @Override
      public CoreSingletons getCoreSingletons() {
        return coreSingletons;
      }

      @Override
      public String getDriverName() {
        return PostgresContainerWrapper.this.getDriverName();
      }

      @Override
      public String getDriverVersion() {
        return null;
      }

      @Override
      public String getDbmsProductName() {
        return getName();
      }

      @Override
      public String getDbmsVersion() {
        return null;
      }
    };
  }

  @Override
  public void close() throws IOException {
    hikariDataSource.close();
    container.close();
  }
}

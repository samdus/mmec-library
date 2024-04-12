/**
 * @file
 *
 * @copyright @@GRIIS_COPYRIGHT@@
 *
 * @licence @@GRIIS_LICENCE@@
 *
 * @version @@GRIIS_VERSION@@
 *
 * @brief @~french Implémentation de la classe StMappedOntoRelTableViewTest.
 * @brief @~english StMappedOntoRelTableViewTest class implementation.
 */

package ca.griis.mmec.test.unit.view.st;

import ca.griis.mmec.model.MappedOntoRelTable;
import ca.griis.mmec.model.mapped.MappedClassTableRecord;
import ca.griis.mmec.model.mapped.MappedDataPropertyTableRecord;
import ca.griis.mmec.model.mapped.MappedObjectPropertyTableRecord;
import ca.griis.mmec.view.st.StMappedOntoRelTableView;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class StMappedOntoRelTableViewTest {

  private static Stream<Arguments> provideTestCase() {
    STGroup insertGroup = createGroupFromResource("templates", "postgres", "insert.stg");
    STGroup viewsGroup = createGroupFromResource("templates", "postgres", "views.stg");

    MappedClassTableRecord mappedClassTable = new MappedClassTableRecord(
        "tableName",
        "comment",
        "iri",
        "ontorelColumnId",
        "ontorelColumnType",
        "schema",
        Optional.of("mmecQuery"),
        "mmecQueryColumnId"
    );
    MappedObjectPropertyTableRecord mappedObjectPropertyTable = new MappedObjectPropertyTableRecord(
        "tableName",
        "comment",
        "iriSubject",
        "iriPredicate",
        "iriObject",
        "ontorelSubjectColumnId",
        "ontorelSubjectColumnType",
        "ontorelObjectColumnId",
        "ontorelObjectColumnType",
        "schema",
        Optional.of("mmecQuery"),
        "mmecQuerySubjectColumnId",
        "mmecQueryObjectColumnId"
    );
    MappedDataPropertyTableRecord mappedDataPropertyTable = new MappedDataPropertyTableRecord(
        "tableName",
        "comment",
        "iriSubject",
        "iriPredicate",
        "iriValue",
        "ontorelSubjectColumnId",
        "ontorelSubjectColumnType",
        "ontorelValueColumnId",
        "ontorelValueColumnType",
        "schema",
        Optional.of("mmecQuery"),
        "mmecQuerySubjectColumnId",
        "mmecQueryValueColumnId"
    );
    MappedClassTableRecord emptyMappedClassTable = new MappedClassTableRecord(
        "tableName",
        "comment",
        "iri",
        "ontorelColumnId",
        "ontorelColumnType",
        "schema",
        Optional.empty(),
        "mmecQueryColumnId"
    );
    MappedObjectPropertyTableRecord emptyMmappedObjectPropertyTable =
        new MappedObjectPropertyTableRecord(
            "tableName",
            "comment",
            "iriSubject",
            "iriPredicate",
            "iriObject",
            "ontorelSubjectColumnId",
            "ontorelSubjectColumnType",
            "ontorelObjectColumnId",
            "ontorelObjectColumnType",
            "schema",
            Optional.empty(),
            "mmecQuerySubjectColumnId",
            "mmecQueryObjectColumnId"
        );
    MappedDataPropertyTableRecord emptyMappedDataPropertyTable = new MappedDataPropertyTableRecord(
        "tableName",
        "comment",
        "iriSubject",
        "iriPredicate",
        "iriValue",
        "ontorelSubjectColumnId",
        "ontorelSubjectColumnType",
        "ontorelValueColumnId",
        "ontorelValueColumnType",
        "schema",
        Optional.empty(),
        "mmecQuerySubjectColumnId",
        "mmecQueryValueColumnId"
    );

    return Stream.of(
        Arguments.of(insertGroup, mappedClassTable,
            // spotless:off
            """
                /*
                comment
                */
                insert into "schema"."tableName"(
                  "ontorelColumnId"
                )
                with mmec_query as (
                  mmecQuery
                )
                select "mmecQueryColumnId"
                from mmec_query
                ;"""
            // spotless:on
        ),
        Arguments.of(insertGroup, mappedObjectPropertyTable,
            // spotless:off
            """
                /*
                comment
                */
                insert into "schema"."tableName"(
                  "ontorelSubjectColumnId",
                  "ontorelObjectColumnId"
                )
                with mmec_query as (
                  mmecQuery
                )
                select "mmecQuerySubjectColumnId", "mmecQueryObjectColumnId"
                from mmec_query
                ;"""
            // spotless:on
        ),
        Arguments.of(insertGroup, mappedDataPropertyTable,
            // spotless:off
            """
                /*
                comment
                */
                insert into "schema"."tableName"(
                  "ontorelSubjectColumnId",
                  "ontorelValueColumnId"
                )
                with mmec_query as (
                  mmecQuery
                )
                select "mmecQuerySubjectColumnId", "mmecQueryValueColumnId"
                from mmec_query
                ;"""
            // spotless:on
        ),
        Arguments.of(viewsGroup, mappedClassTable,
            // spotless:off
            """
                /*
                comment
                */
                create view "schema"."tableName"(
                  "ontorelColumnId"
                )
                  with (security_barrier=true, check_option=cascaded)
                as
                with mmec_query as (
                  mmecQuery
                )
                select "mmecQueryColumnId"
                from mmec_query
                ;"""
            // spotless:on
        ),
        Arguments.of(viewsGroup, mappedObjectPropertyTable,
            // spotless:off
            """
                /*
                comment
                */
                create view "schema"."tableName"(
                  "ontorelSubjectColumnId",
                  "ontorelObjectColumnId"
                )
                  with (security_barrier=true, check_option=cascaded)
                as
                with mmec_query as (
                  mmecQuery
                )
                select "mmecQuerySubjectColumnId", "mmecQueryObjectColumnId"
                from mmec_query
                ;"""
            // spotless:on
        ),
        Arguments.of(viewsGroup, mappedDataPropertyTable,
            // spotless:off
            """
                /*
                comment
                */
                create view "schema"."tableName"(
                  "ontorelSubjectColumnId",
                  "ontorelValueColumnId"
                )
                  with (security_barrier=true, check_option=cascaded)
                as
                with mmec_query as (
                  mmecQuery
                )
                select "mmecQuerySubjectColumnId", "mmecQueryValueColumnId"
                from mmec_query
                ;"""
            // spotless:on
        )
        ,
        Arguments.of(insertGroup, emptyMappedClassTable,
            // spotless:off
            """
                /*
                comment
                Empty mapping: insert not required
                */"""
            // spotless:on
        ),
        Arguments.of(insertGroup, emptyMmappedObjectPropertyTable,
            // spotless:off
            """
                /*
                comment
                Empty mapping: insert not required
                */"""
            // spotless:on
        ),
        Arguments.of(insertGroup, emptyMappedDataPropertyTable,
            // spotless:off
            """
                /*
                comment
                Empty mapping: insert not required
                */"""
            // spotless:on
        ),
        Arguments.of(viewsGroup, emptyMappedClassTable,
            // spotless:off
            """
                /*
                comment
                */
                create view "schema"."tableName"(
                  "ontorelColumnId"
                )
                  with (security_barrier=true, check_option=cascaded)
                as
                select null::ontorelColumnType
                where false
                ;"""
            // spotless:on
        ),
        Arguments.of(viewsGroup, emptyMmappedObjectPropertyTable,
            // spotless:off
            """
                /*
                comment
                */
                create view "schema"."tableName"(
                  "ontorelSubjectColumnId",
                  "ontorelObjectColumnId"
                )
                  with (security_barrier=true, check_option=cascaded)
                as
                select null::ontorelSubjectColumnType, null::ontorelObjectColumnType
                where false
                ;"""
            // spotless:on
        ),
        Arguments.of(viewsGroup, emptyMappedDataPropertyTable,
            // spotless:off
            """
                /*
                comment
                */
                create view "schema"."tableName"(
                  "ontorelSubjectColumnId",
                  "ontorelValueColumnId"
                )
                  with (security_barrier=true, check_option=cascaded)
                as
                select null::ontorelSubjectColumnType, null::ontorelValueColumnType
                where false
                ;"""
            // spotless:on
        )
    );
  }

  @ParameterizedTest
  @MethodSource("provideTestCase")
  void testClassTemplate(STGroup group, MappedOntoRelTable mappedOntoRelTable, String expected) {
    StMappedOntoRelTableView stMappedOntoRelTableView = new StMappedOntoRelTableView(group);

    String actual = null;

    if (mappedOntoRelTable instanceof MappedClassTableRecord) {
      actual = stMappedOntoRelTableView.getExpression((MappedClassTableRecord) mappedOntoRelTable);
    } else if (mappedOntoRelTable instanceof MappedObjectPropertyTableRecord) {
      actual = stMappedOntoRelTableView.getExpression(
          (MappedObjectPropertyTableRecord) mappedOntoRelTable);
    } else if (mappedOntoRelTable instanceof MappedDataPropertyTableRecord) {
      actual = stMappedOntoRelTableView.getExpression(
          (MappedDataPropertyTableRecord) mappedOntoRelTable);
    } else {
      Assertions.fail("Unknown MappedOntoRelTable type");
    }

    Assertions.assertEquals(expected, actual);
  }

  private static STGroup createGroupFromResource(String templatePathFirst,
      String... templatePathMore) {
    String templatePath = Stream.concat(Stream.of(templatePathFirst), Stream.of(templatePathMore))
        .collect(Collectors.joining(File.separator, File.separator, ""));
    URL url = StMappedOntoRelTableViewTest.class.getResource(templatePath);
    Assertions.assertNotNull(url, String.format("Template '%s' not found", templatePath));
    return new STGroupFile(url);
  }
}

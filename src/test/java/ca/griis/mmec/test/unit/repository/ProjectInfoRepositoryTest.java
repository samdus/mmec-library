package ca.griis.mmec.test.unit.repository;

import ca.griis.mmec.properties.MissingPropertyException;
import ca.griis.mmec.repository.ProjectInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProjectInfoRepositoryTest {
  @Test
  public void test() throws MissingPropertyException {
    ProjectInfoRepository projectInfoRepository = new ProjectInfoRepository();

    projectInfoRepository.loadInfoRepository();

    Assertions.assertEquals("ca.griis",
        projectInfoRepository.getApplicationMain().orElse("Undefined"));
    Assertions.assertEquals("ca.griis", projectInfoRepository.getGroup().orElse("Undefined"));
    Assertions.assertEquals("mMec-library", projectInfoRepository.getName().orElse("Undefined"));
    Assertions.assertEquals("LIBRARY", projectInfoRepository.getProduct().orElse("Undefined"));
    Assertions.assertEquals("1.0.2", projectInfoRepository.getVersion().orElse("Undefined"));
  }

  @Test
  public void invalidProjectInfoResourcePathTest() {
    InvalidProjectInfoRepository invalidProjectInfoRepository = new InvalidProjectInfoRepository();
    Assertions.assertThrows(MissingPropertyException.class,
        invalidProjectInfoRepository::loadInfoRepository);
  }

  private static class InvalidProjectInfoRepository extends ProjectInfoRepository {
    public InvalidProjectInfoRepository() {
      super("InvalidPath");
    }
  }
}

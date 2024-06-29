package ru.safronov.assumptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.safronov.assumptions.environment.JavaSpecification;
import ru.safronov.assumptions.environment.OperationSystem;
import ru.safronov.assumptions.environment.TestEnvironment;

public class AssumptionsTests {

  private static final String EXPECTED_JAVA_VERSION = "17";
  private final TestEnvironment environment = new TestEnvironment(
      new JavaSpecification(
          System.getProperty("java.vm.specification.version")),
      new OperationSystem(
          System.getProperty("os.name"),
          System.getProperty("os.arch"))
  );
  private final SUT systemUnderTest = new SUT();

  @BeforeEach
  void setUp() {
    Assumptions.assumeTrue(environment.isMac());
  }

  @Test
  void testNoJobToRun() {
    Assumptions.assumingThat(
        () -> environment.getJavaVersion().equals(EXPECTED_JAVA_VERSION),
        () -> Assertions.assertFalse(systemUnderTest.hasJobToRun())
    );
  }

  @Test
  void testJobToRun() {
    Assumptions.assumeTrue(environment.is86_64Architecture());
    systemUnderTest.run(new Job());
    Assertions.assertTrue(systemUnderTest.hasJobToRun());
  }
}

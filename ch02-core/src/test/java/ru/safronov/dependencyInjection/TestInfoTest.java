package ru.safronov.dependencyInjection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * Example how to use TestInfo parameter as an argument of a constructor and annotated methods
 */
public class TestInfoTest {

  TestInfoTest(TestInfo testInfo) {
    Assertions.assertEquals("TestInfoTest", testInfo.getDisplayName());
  }

  @BeforeEach
  void setUp(TestInfo testInfo) {
    String displayName = testInfo.getDisplayName();
    Assertions.assertTrue(
        displayName.equals("display name of the method")
            || displayName.equals("testGetNameOfTheMethod(TestInfo)")
    );
  }

  @Test
  void testGetNameOfTheMethod(TestInfo testInfo) {
    Assertions.assertEquals("testGetNameOfTheMethod(TestInfo)", testInfo.getDisplayName());
  }

  @Test
  @DisplayName("display name of the method")
  void testGetNameOfTheMethodWithDisplayNameAnnotation(TestInfo testInfo) {
    Assertions.assertEquals("display name of the method", testInfo.getDisplayName());
  }
}

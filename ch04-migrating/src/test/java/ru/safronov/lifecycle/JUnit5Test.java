package ru.safronov.lifecycle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class JUnit5Test {

  private static ResourceForTests resourceForTests;
  private SUT systemUnderTest;

  @BeforeAll
  static void setUpClass() {
    resourceForTests = new ResourceForTests("resource for all tests");
  }

  @AfterAll
  static void tearDownClass() {
    resourceForTests.close();
  }

  @BeforeEach
  void setUp() {
    systemUnderTest = new SUT("recourse for single test");
  }

  @AfterEach
  void tearDown() {
    systemUnderTest.close();
  }

  @Test
  void testRegularWork() {
    Assertions.assertTrue(systemUnderTest.canReceiveRegularWork());
  }

  @Test
  void testAdditionalWork() {
    Assertions.assertFalse(systemUnderTest.canReceiveAdditionalWork());
  }

  @Test
  @Disabled
  void thirdTest() {
    Assertions.assertEquals(2, 1, "There's not equal numbers");
  }
}

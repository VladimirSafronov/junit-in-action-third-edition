package ru.safronov.dynamic;

import java.util.Arrays;
import java.util.Iterator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import ru.safronov.predicate.PositiveNumberPredicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The factory-method generates three test methods.
 * BeforeEach, AfterEach methods are executed before and after @TestFactory method (not before each
 * method in this factory!)
 */
public class DynamicTestsTest {

  private final PositiveNumberPredicate predicate = new PositiveNumberPredicate();

  @BeforeAll
  static void setUpClass() {
    System.out.println("@BeforeAll method");
  }

  @AfterAll
  static void tearDownClass() {
    System.out.println("@AfterAll method");
  }

  @BeforeEach
  void setUp() {
    System.out.println("@BeforeEach method");
  }

  @AfterEach
  void tearDown() {
    System.out.println("@AfterEach method");
  }

  @TestFactory
  Iterator<DynamicTest> positiveNumberPredicateTestCases() {
    return Arrays.asList(
        DynamicTest.dynamicTest("negative number", () -> assertFalse(predicate.check(-1))),
        DynamicTest.dynamicTest("zero", () -> assertFalse(predicate.check(0))),
        DynamicTest.dynamicTest("positive number", () -> assertTrue(predicate.check(1)))
    ).iterator();
  }
}

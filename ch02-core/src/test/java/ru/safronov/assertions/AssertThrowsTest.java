package ru.safronov.assertions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertThrowsTest {
  private SUT systemUnderTest = new SUT("Our system under test");

  @Test
  @DisplayName("An exception is expected")
  void testExpectedException() {
    Assertions.assertThrows(NoJobException.class, () -> systemUnderTest.run());
  }

  @Test
  @DisplayName("An exception is caught")
  void testCatchException() {
    Throwable throwable = Assertions.assertThrows(NoJobException.class, () -> systemUnderTest.run());

    Assertions.assertEquals("No jobs on the execution list!", throwable.getMessage());
  }
}

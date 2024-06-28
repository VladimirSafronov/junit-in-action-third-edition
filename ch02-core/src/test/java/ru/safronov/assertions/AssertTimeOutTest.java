package ru.safronov.assertions;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertTimeOutTest {

  private SUT systemUnderTest = new SUT("Our system under test");

  @Test
  @DisplayName("A job is executed within a timeout")
  void testTimeout() {
    systemUnderTest.addJob(new Job("Grow up the son"));
    Assertions.assertTimeout(Duration.ofMillis(500), () -> systemUnderTest.run(200));
  }

  @Test
  @DisplayName("A job is executed preemptively within a timeout")
  void testTimeoutPreemptively() {
    systemUnderTest.addJob(new Job("Grow up the son"));
    Assertions.assertTimeoutPreemptively(Duration.ofMillis(500), () -> systemUnderTest.run(200));
  }
}

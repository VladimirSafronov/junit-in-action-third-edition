package ru.safronov.disabled;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.safronov.lifecycle.SUT;

public class DisabledMethodTest {

  private SUT systemUnderTest = new SUT("Our system under test");

  @Test
  @Disabled
  void testRegularWork() {
    boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
    Assertions.assertTrue(canReceiveRegularWork);
  }

  @Test
  @Disabled("It will be nice if the reason is provided")
  void testAdditionalWork() {
    boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
    Assertions.assertFalse(canReceiveAdditionalWork);
  }
}

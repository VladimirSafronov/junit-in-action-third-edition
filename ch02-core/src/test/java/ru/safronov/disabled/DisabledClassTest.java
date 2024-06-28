package ru.safronov.disabled;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.safronov.lifecycle.SUT;

@Disabled("It will be nice if the reason is provided")
public class DisabledClassTest {

  private SUT systemUnderTest = new SUT("Our system under test");

  @Test
  void testRegularWork() {
    boolean canReceiveRegularWork = systemUnderTest.canReceiveRegularWork();
    Assertions.assertTrue(canReceiveRegularWork);
  }

  @Test
  void testAdditionalWork() {
    boolean canReceiveAdditionalWork = systemUnderTest.canReceiveAdditionalWork();
    Assertions.assertFalse(canReceiveAdditionalWork);
  }
}

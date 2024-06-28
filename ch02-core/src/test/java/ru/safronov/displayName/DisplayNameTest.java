package ru.safronov.displayName;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("There is the test's theme - what is the test about")
public class DisplayNameTest {

  private SUT systemUnderTest = new SUT();

  @Test
  @DisplayName("We can use this annotation with methods")
  void testHello() {
    Assertions.assertEquals("Hello", systemUnderTest.hello());
  }

  @Test
  @DisplayName("also can put emodjy \uD83D\uDE31")
  void testTalk() {
    Assertions.assertEquals("How are you", systemUnderTest.talk());
  }

  @Test
  void testBye() {
    Assertions.assertEquals("Bye", systemUnderTest.bye());
  }
}

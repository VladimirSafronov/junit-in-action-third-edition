package ru.safronov.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedWithValueSourceTest {

  private final WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @ValueSource(strings = {"One two three", "JUnit in action"})
  void testCountWordsInSentence(String string) {
    Assertions.assertEquals(3, wordCounter.countWords(string));
  }
}

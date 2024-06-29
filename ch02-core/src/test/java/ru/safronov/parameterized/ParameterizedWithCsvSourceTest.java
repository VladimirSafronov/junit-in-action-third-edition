package ru.safronov.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParameterizedWithCsvSourceTest {

  private final WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @CsvSource({"2, Unit testing", "3, one two three", "4, Java programmers like coffee"})
  void testWordsInSentence(int expected, String sentence) {
    Assertions.assertEquals(expected, wordCounter.countWords(sentence));
  }
}

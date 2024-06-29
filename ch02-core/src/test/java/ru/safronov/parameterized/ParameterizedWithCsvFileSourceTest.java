package ru.safronov.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class ParameterizedWithCsvFileSourceTest {

  private final WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @CsvFileSource(resources = "/word_counter.csv")
  void testWordsInSentence(int expected, String sentence) {
    Assertions.assertEquals(expected, wordCounter.countWords(sentence));
  }
}

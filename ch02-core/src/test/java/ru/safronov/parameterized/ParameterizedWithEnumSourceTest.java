package ru.safronov.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

public class ParameterizedWithEnumSourceTest {

  private final WordCounter wordCounter = new WordCounter();

  @ParameterizedTest
  @EnumSource(Sentences.class)
  void testWordInSentence(Sentences sentence) {
    Assertions.assertEquals(3, wordCounter.countWords(sentence.value()));
  }

  @ParameterizedTest
  @EnumSource(value = Sentences.class, names = {"SOME_PARAMETERS", "JUNIT_IN_ACTION"})
  void testSelectedWords(Sentences sentence) {
    Assertions.assertEquals(3, wordCounter.countWords(sentence.value()));
  }

  @ParameterizedTest
  @EnumSource(value = Sentences.class, mode = Mode.EXCLUDE, names = {"JUNIT_IN_ACTION"})
  void testExcludedWords(Sentences sentence) {
    Assertions.assertEquals(3, wordCounter.countWords(sentence.value()));
  }

  enum Sentences {
    JUNIT_IN_ACTION("JUnit in action"),
    SOME_PARAMETERS("Check some parameters"),
    THREE_PARAMETERS("One two three");

    private final String sentence;

    Sentences(String sentence) {
      this.sentence = sentence;
    }

    public String value() {
      return sentence;
    }
  }
}

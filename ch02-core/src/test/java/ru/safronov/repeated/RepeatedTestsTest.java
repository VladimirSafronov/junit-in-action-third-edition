package ru.safronov.repeated;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestReporter;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatedTestsTest {
  private static final Set<Integer> INTEGER_SET = new HashSet<>();
  private static final List<Integer> INTEGER_LIST = new ArrayList<>();

  @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition}/{totalRepetitions}")
  @DisplayName("Test add operation")
  void addNumberTest() {
    Calculator calculator = new Calculator();
    Assertions.assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
  }

  @RepeatedTest(value = 5, name = "the list contains {currentRepetition} element(s), the set contains 1 element")
  void testAddingToCollections(TestReporter testReporter, RepetitionInfo repetitionInfo) {
    INTEGER_SET.add(1);
    INTEGER_LIST.add(repetitionInfo.getCurrentRepetition());

    testReporter.publishEntry("Repetition number", String.valueOf(repetitionInfo.getCurrentRepetition()));
    assertAll(() -> {
      assertEquals(1, INTEGER_SET.size());
      assertEquals(repetitionInfo.getCurrentRepetition(), INTEGER_LIST.size());
    });
  }
}

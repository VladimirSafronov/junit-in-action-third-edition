package ru.safronov.hamcrest;

import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

/**
 * The same tests show difference between Hamcrest and Assertions
 */
public class HamcrestListTest {

  private List<String> values;

  @BeforeEach
  public void setUp() {
    values = new ArrayList<>();
    values.add("Alena");
    values.add("Ann");
    values.add("Mary");
  }

  @Test
  @DisplayName("Test without Hamcrest")
  void testWithoutHamcrest() {
    Assertions.assertEquals(3, values.size());
    Assertions.assertTrue(
        values.contains("Amy")
            || values.contains("Na")
            || values.contains("Mary"));
  }

  @Test
  @DisplayName("Test with Hamcrest")
  void testWithHamcrest() {
    MatcherAssert.assertThat(values, hasSize(3));
    MatcherAssert.assertThat(values, hasItem(anyOf(
        equalTo("Amy"),
        equalTo("Na"),
        equalTo("Mary"))));
  }
}

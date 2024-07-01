package ru.safronov.rules;

import org.junit.Rule;
import org.junit.Test;

public class CustomRuleTest {

  /**
   * Custom rule field must be public
   */
  @Rule
  public CustomRule myRule = new CustomRule();

  @Test
  public void testMyCustomRule() {
    System.out.println("Call of a test method");
  }
}

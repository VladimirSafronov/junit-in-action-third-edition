package ru.safronov.rules;

import org.junit.Rule;
import org.junit.Test;

public class CustomRuleWithGetterTest {

  private final CustomRule myRule = new CustomRule();

  @Rule
  public CustomRule getMyRule() {
    return myRule;
  }

  @Test
  public void testMyCustomRule() {
    System.out.println("Call of a test method");
  }
}

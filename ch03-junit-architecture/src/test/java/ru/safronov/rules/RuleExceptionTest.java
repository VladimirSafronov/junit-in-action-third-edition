package ru.safronov.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.safronov.Calculator;

public class RuleExceptionTest {

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  private final Calculator calculator = new Calculator();

  @Test
  public void expectIllegalArgumentException() {
    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Cannot extract the square root of a negative value");
    calculator.sqrt(-1);
  }

  @Test
  public void expectArithmeticException() {
    expectedException.expect(ArithmeticException.class);
    expectedException.expectMessage("Cannot divide by zero!");
    calculator.divide(2, 0);
  }
}

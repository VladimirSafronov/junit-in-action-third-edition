package ru.safronov.rules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.safronov.Calculator;

public class JUnit5ExceptionTest {

  private final Calculator calculator = new Calculator();

  @Test
  void expectIllegalArgumentException() {
    Throwable throwable = Assertions.assertThrows(IllegalArgumentException.class,
        () -> calculator.sqrt(-1));
    Assertions.assertEquals("Cannot extract the square root of a negative value",
        throwable.getMessage());
  }

  @Test
  void expectArithmeticException() {
    Throwable throwable = Assertions.assertThrows(ArithmeticException.class,
        () -> calculator.divide(2, 0));
    Assertions.assertEquals("You can't divide by zero", throwable.getMessage());
  }
}

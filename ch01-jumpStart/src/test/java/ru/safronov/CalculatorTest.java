package ru.safronov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void addTest() {
    Calculator calculator = new Calculator();
    double result = calculator.add(50, 50);
    Assertions.assertEquals(100, result, 0);
  }
}

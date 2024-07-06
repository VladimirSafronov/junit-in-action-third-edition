package ru.safronov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

  private final Calculator calculator = new Calculator();

  @Test
  void testAdd() {
    double result = calculator.add(10, 15);
    assertEquals(25, result, 0);
  }

  @Test
  void testSqrt() {
    double result = calculator.sqrt(2);
    assertEquals(1.4142, result, 0.0001);
  }

  @Test
  void testDivide() {
    double result = calculator.divide(1, 3);
    assertEquals(0.333, result, 0.001);
  }

  @Test
  void testIllegalArgExc() {
    assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-1));
  }

  @Test
  void testArithmeticExc() {
    assertThrows(ArithmeticException.class, () -> calculator.divide(3, 0));
  }
}

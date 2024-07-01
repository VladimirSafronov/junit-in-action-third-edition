package ru.safronov.runners;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import ru.safronov.Calculator;

@RunWith(CustomTestRunner.class)
public class CalculatorTest {

  @Test
  public void testAdd() {
    Calculator calculator = new Calculator();
    double result = calculator.add(50, 50);
    assertEquals(100, result, 0);
  }
}

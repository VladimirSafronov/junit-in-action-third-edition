package ru.safronov;

public class Calculator {

  public double add(double number1, double number2) {
    return number1 + number2;
  }

  public double sqrt(double value) {
    if (value < 0) {
      throw new IllegalArgumentException("Cannot extract the square root of a negative value");
    }
    return Math.sqrt(value);
  }

  public double divide(double x, double y) {
    if (y == 0) {
      throw new ArithmeticException("Cannot divide by zero!");
    }
    return x / y;
  }
}

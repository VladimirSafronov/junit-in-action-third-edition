package ru.safronov;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PassengerTest {

  @Test
  void testPassenger() {
    Passenger passenger = new Passenger("123-456-789", "John Smith");
    Assertions.assertEquals("Passenger John Smith with identifier: 123-456-789",
        passenger.toString());
  }
}

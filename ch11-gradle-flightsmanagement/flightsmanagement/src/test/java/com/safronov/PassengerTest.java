package com.safronov;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PassengerTest {

  @Test
  void testPassenger() {
    Passenger passenger = new Passenger("123-456", "JohnSmith");
    assertEquals("com.safronov.Passenger{id='123-456', name='JohnSmith'}", passenger.toString());
  }
}

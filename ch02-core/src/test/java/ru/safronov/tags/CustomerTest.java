package ru.safronov.tags;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("individual")
public class CustomerTest {

  private String CUSTOMER_NAME = "John Smith";

  @Test
  void testCustomer() {
    Customer customer = new Customer(CUSTOMER_NAME);

    Assertions.assertEquals(CUSTOMER_NAME, customer.getName());
  }
}

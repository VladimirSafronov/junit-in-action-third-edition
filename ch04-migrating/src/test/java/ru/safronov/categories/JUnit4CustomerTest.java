package ru.safronov.categories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.safronov.tags.Customer;

public class JUnit4CustomerTest {

  private final String CUSTOMER_NAME = "John Smith";

  @Test
  @Category(IndividualTests.class)
  public void testCustomer() {
    Customer customer = new Customer(CUSTOMER_NAME);
    Assert.assertEquals("John Smith", customer.getName());
  }
}

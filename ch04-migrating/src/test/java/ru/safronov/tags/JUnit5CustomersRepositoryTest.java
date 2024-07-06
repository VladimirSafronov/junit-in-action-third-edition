package ru.safronov.tags;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("repository")
public class JUnit5CustomersRepositoryTest {

  private final String CUSTOMER_NAME = "John Smith";
  private final CustomerRepository repository = new CustomerRepository();

  @Test
  void testNonExistence() {
    Assertions.assertFalse(repository.contains(CUSTOMER_NAME));
  }

  @Test
  void testPersistence() {
    repository.persist(new Customer(CUSTOMER_NAME));
    Assertions.assertTrue(repository.contains(CUSTOMER_NAME));
  }
}

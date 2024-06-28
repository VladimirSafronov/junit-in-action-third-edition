package ru.safronov.tags;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("repository")
public class CustomerRepositoryTest {

  private String CUSTOMER_NAME = "John Smith";
  private CustomerRepository repository = new CustomerRepository();

  @Test
  void testNotExistence() {
    boolean exists = repository.contains(CUSTOMER_NAME);

    Assertions.assertFalse(exists);
  }

  @Test
  void testPersistence() {
    repository.persist(new Customer(CUSTOMER_NAME));

    Assertions.assertTrue(repository.contains(CUSTOMER_NAME));
  }
}

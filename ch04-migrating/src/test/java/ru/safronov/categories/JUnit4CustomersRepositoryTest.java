package ru.safronov.categories;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import ru.safronov.tags.Customer;
import ru.safronov.tags.CustomerRepository;

@Category({IndividualTests.class, RepositoryTests.class})
public class JUnit4CustomersRepositoryTest {

  private final String CUSTOMER_NAME = "John Smith";
  private final CustomerRepository repository = new CustomerRepository();

  @Test
  public void testNonExistence() {
    Assert.assertFalse(repository.contains(CUSTOMER_NAME));
  }

  @Test
  public void testPersistence() {
    repository.persist(new Customer(CUSTOMER_NAME));
    Assert.assertTrue(repository.contains(CUSTOMER_NAME));
  }
}

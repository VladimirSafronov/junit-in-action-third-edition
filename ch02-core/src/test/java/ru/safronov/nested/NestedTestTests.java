package ru.safronov.nested;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NestedTestTests {

  private static final String FIRST_NAME = "John";
  private static final String LAST_NAME = "Travolta";

  @Nested
  class BuilderTest {

    private static final String MIDDLE_NAME = "Micky";

    @Test
    void customBuilder() throws ParseException {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
      Date customerDate = simpleDateFormat.parse("20-10-2012");

      Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME)
          .withMiddleName(MIDDLE_NAME)
          .withBecomeCustomer(customerDate)
          .build();

      assertAll(() -> {
        assertEquals(Gender.MALE, customer.getGender());
        assertEquals(FIRST_NAME, customer.getFirstName());
        assertEquals(LAST_NAME, customer.getLastName());
        assertEquals(MIDDLE_NAME, customer.getMiddleName());
        assertEquals(customerDate, customer.getBecomeCustomer());
      });
    }
  }

  @Nested
  class CustomerEqualsTest {

    private String OTHER_FIRST_NAME = "John";
    private String OTHER_LAST_NAME = "Smith";

    @Test
    void testDifferentCustomers() {
      Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
      Customer otherCustomer = new Customer.Builder(Gender.MALE, OTHER_FIRST_NAME,
          OTHER_LAST_NAME).build();

      assertNotEquals(customer, otherCustomer);
    }

    @Test
    void testSameCustomer() {
      Customer customer = new Customer.Builder(Gender.FEMALE, FIRST_NAME, LAST_NAME).build();
      Customer sameCustomer = new Customer.Builder(Gender.FEMALE, FIRST_NAME, LAST_NAME).build();

      assertAll(() -> {
        assertEquals(customer, sameCustomer);
        assertNotSame(customer, sameCustomer);
      });
    }
  }

  @Nested
  class CustomerHashCodeTest {
    private String OTHER_FIRST_NAME = "John";
    private String OTHER_LAST_NAME = "Smith";

    @Test
    void testDifferentCustomers() {
      Customer customer = new Customer.Builder(Gender.MALE, FIRST_NAME, LAST_NAME).build();
      Customer otherCustomer = new Customer.Builder(Gender.FEMALE, OTHER_FIRST_NAME,
          OTHER_LAST_NAME).build();

      assertNotEquals(customer.hashCode(), otherCustomer.hashCode());
    }

    @Test
    void testSameCustomer() {
      Customer customer = new Customer.Builder(Gender.FEMALE, FIRST_NAME, LAST_NAME).build();
      Customer sameCustomer = new Customer.Builder(Gender.FEMALE, FIRST_NAME, LAST_NAME).build();

      assertEquals(customer.hashCode(), sameCustomer.hashCode());
    }
  }
}

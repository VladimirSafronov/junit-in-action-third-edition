package ru.safronov.hamcrest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

public class HamcrestMatchersTest {

  private final static String FIRST_NAME = "John";
  private final static String LAST_NAME = "Smith";
  private final static Customer CUSTOMER = new Customer(FIRST_NAME, LAST_NAME);

  @Test
  @DisplayName("Hamcrest is(), anyOf(), allOf()")
  void testHamcrestIs() {
    int price1 = 1;
    int price2 = 1;
    int price3 = 2;

    assertThat(1, is(price1));
    assertThat(1, anyOf(is(price2), is(price3)));
    assertThat(1, allOf(is(price1), is(price2)));
  }

  @Test
  @DisplayName("Null expected")
  void testNull() {
    assertThat(null, nullValue());
  }

  @Test
  @DisplayName("Object expected")
  void testNotNull() {
    assertThat(CUSTOMER, notNullValue());
  }

  @Test
  @DisplayName("Check correct customer properties")
  void testCorrectCustomerProperties() {
    assertThat(CUSTOMER, allOf(
        hasProperty("firstName", is(FIRST_NAME)),
        hasProperty("lastName", is(LAST_NAME))
    ));
  }
}

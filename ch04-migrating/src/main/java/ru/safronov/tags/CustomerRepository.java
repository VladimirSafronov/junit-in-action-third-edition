package ru.safronov.tags;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

  private final List<Customer> customers = new ArrayList<>();

  public boolean contains(String name) {
    return customers.stream()
        .anyMatch(n -> n.getName().equals(name));
  }

  public void persist(Customer customer) {
    customers.add(customer);
  }
}

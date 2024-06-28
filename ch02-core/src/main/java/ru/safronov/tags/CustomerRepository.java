package ru.safronov.tags;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

  private List<Customer> customers = new ArrayList<>();

  public boolean contains(String name) {
    return customers.stream()
        .anyMatch(c -> c.getName().equals(name));
  }

  public void persist(Customer customer) {
    customers.add(customer);
  }
}

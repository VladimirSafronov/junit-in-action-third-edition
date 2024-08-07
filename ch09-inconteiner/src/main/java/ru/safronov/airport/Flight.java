package ru.safronov.airport;

import java.util.HashSet;
import java.util.Set;

public class Flight {

  private final String flightNumber;
  private int seats;
  private final Set<Passenger> passengers = new HashSet<>();

  public Flight(String flightNumber, int seats) {
    this.flightNumber = flightNumber;
    this.seats = seats;
  }

  public String getFlightNumber() {
    return flightNumber;
  }

  public int getSeats() {
    return seats;
  }

  public int getNumberOfPassengers() {
    return passengers.size();
  }

  public void setSeats(int numberOfSeats) {
    if (passengers.size() > numberOfSeats) {
      throw new RuntimeException("Cannot reduce seats under the number of existing passengers");
    }
    this.seats = numberOfSeats;
  }

  public boolean addPassenger(Passenger passenger) {
    if (passengers.size() >= seats) {
      throw new RuntimeException("Cannot add more passengers than the capacity of the flight");
    }
    return passengers.add(passenger);
  }

  public boolean removePassenger(Passenger passenger) {
    return passengers.remove(passenger);
  }

  @Override
  public String toString() {
    return "Flight " + getFlightNumber();
  }
}

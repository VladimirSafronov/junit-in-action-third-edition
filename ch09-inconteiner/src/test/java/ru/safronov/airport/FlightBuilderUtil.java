package ru.safronov.airport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FlightBuilderUtil {

  public static Flight buildFlightFromCsv() throws IOException {
    Flight flight = new Flight("1234", 20);
    try (BufferedReader reader = new BufferedReader(
        new FileReader("src/test/resources/flights_information.csv"))) {

      String line = null;
      do {
        line = reader.readLine();
        if (line != null) {
          String[] passengerData = line.split(";");
          Passenger passenger = new Passenger(passengerData[0].trim(), passengerData[1].trim());
          flight.addPassenger(passenger);
        }
      } while (line != null);
    }
    return flight;
  }
}

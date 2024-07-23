package ru.safronov.airport.producers;

import java.io.IOException;
import javax.enterprise.inject.Produces;
import ru.safronov.airport.Flight;
import ru.safronov.airport.FlightBuilderUtil;

public class FlightProducer {

  @Produces
  public Flight createFlight() throws IOException {
    return FlightBuilderUtil.buildFlightFromCsv();
  }
}

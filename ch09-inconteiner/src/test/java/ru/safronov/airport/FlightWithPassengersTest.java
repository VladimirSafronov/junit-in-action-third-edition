package ru.safronov.airport;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.core.api.annotation.Inject;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.safronov.airport.producers.FlightProducer;

@RunWith(Arquillian.class)
public class FlightWithPassengersTest {

  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap.create(JavaArchive.class)
        .addClasses(Passenger.class, Flight.class, FlightProducer.class)
        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }

  @Inject
  Flight flight;

  @Test(expected = RuntimeException.class)
  public void testNumberOfSeatsCannotBeExceeded() {
    Assert.assertEquals(20, flight.getNumberOfPassengers());
    flight.addPassenger(new Passenger("123", "Bob Marley"));
  }

  @Test
  public void testAddRemovePassengers() {
    flight.setSeats(21);
    Passenger passenger = new Passenger("123", "Bob Marley");

    flight.addPassenger(passenger);
    Assert.assertEquals(21, flight.getNumberOfPassengers());
    flight.removePassenger(passenger);
    Assert.assertEquals(20, flight.getNumberOfPassengers());
    Assert.assertEquals(21, flight.getSeats());
  }
}

package ru.safronov.dependencyInjection;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

/**
 * Example how to add some useful data
 */
public class TestReporterTest {

  @Test
  void testReportSingleValue(TestReporter testReporter) {
    testReporter.publishEntry("Single value");
  }

  @Test
  void testReportPair(TestReporter testReporter) {
    testReporter.publishEntry("Key of pair", "Value of pair");
  }

  @Test
  void testReportMultiplePairs(TestReporter testReporter) {
    Map<String, String> values = new HashMap<>();
    values.put("First key", "First value");
    values.put("Second key", "Second value");

    testReporter.publishEntry(values);
  }
}

package ru.safronov.configurations;

/**
 * Mock implementation from Configuration interface
 */
public class MockConfiguration implements Configuration {

  /**
   * sets the sql query
   */
  public void setSql(String sqlString) {
  }

  /**
   * get the sql query
   */
  @Override
  public String getSQL(String sqlString) {
    return "";
  }
}

package ru.safronov.web;

import java.io.IOException;
import java.io.InputStream;

/**
 * Different connection factories must implement this interface
 */
public interface ConnectionFactory {

  InputStream getData() throws IOException;
}

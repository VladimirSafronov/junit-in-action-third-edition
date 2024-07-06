package ru.safronov.rules;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

public class JUnit5TempDirTest {

  @TempDir
  Path tempDir;

  private static Path createdFile;

  @Test
  void testTemporaryFolder() throws IOException {
    Assertions.assertTrue(Files.isDirectory(tempDir));
    createdFile = Files.createFile(tempDir.resolve("createdFile.txt"));

    Assertions.assertTrue(createdFile.toFile().exists());
  }

  @AfterAll
  static void afterAll() {
    Assertions.assertFalse(createdFile.toFile().exists());
  }
}

package ru.safronov.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RuleTest {

  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();
  private static File createdFolder;
  private static File createdFile;

  @Test
  public void testTemporaryFolder() throws IOException {
    createdFolder = temporaryFolder.newFolder("temporaryFolder");
    createdFile = temporaryFolder.newFile("createdFile.txt");
    assertTrue(createdFolder.exists());
    assertTrue(createdFile.exists());
  }

  @AfterClass
  public static void cleanUp() {
    assertFalse(createdFolder.exists());
    assertFalse(createdFile.exists());
  }
}

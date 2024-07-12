package ru.safronov.account;

import org.junit.jupiter.api.Test;
import ru.safronov.configurations.MockConfiguration;

/**
 * A test-case for the DefaultAccountManager class
 */
public class DefaultAccountManagerTest {

  @Test
  void testFindAccountByUser() {
    MockLog logger = new MockLog();
    MockConfiguration configuration = new MockConfiguration();
    configuration.setSql("SELECT * ...");
    DefaultAccountManagerRefactoring accountManager = new DefaultAccountManagerRefactoring(logger, configuration);

    //unused
    Account account = accountManager.findAccountForUser("12");

    //Perform asserts here
  }
}

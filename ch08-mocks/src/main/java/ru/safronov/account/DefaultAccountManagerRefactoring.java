package ru.safronov.account;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ru.safronov.configurations.Configuration;
import ru.safronov.configurations.DefaultConfiguration;

/**
 * Default account manager implementation after refactoring
 */
public class DefaultAccountManagerRefactoring implements AccountManager {

  private final Log logger;
  private final Configuration configuration;

  public DefaultAccountManagerRefactoring() {
    this(LogFactory.getLog(DefaultAccountManagerRefactoring.class),
        new DefaultConfiguration("technical"));
  }

  public DefaultAccountManagerRefactoring(Log logger, Configuration configuration) {
    this.logger = logger;
    this.configuration = configuration;
  }

  @Override
  public Account findAccountForUser(String userId) {
    this.logger.debug("Getting account for user [" + userId + "]");
    this.configuration.getSQL("FIND_ACCOUNT_FOR_USER");

    //some code logic to load a user account using JDBC
    return null;
  }

  @Override
  public void updateAccount(Account account) {
    // Perform database access here
  }
}

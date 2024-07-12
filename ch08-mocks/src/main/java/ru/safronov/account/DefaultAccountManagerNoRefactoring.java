package ru.safronov.account;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Default account manager implementation before refactoring
 */
public class DefaultAccountManagerNoRefactoring implements AccountManager {

  private final Log logger = LogFactory.getLog(DefaultAccountManagerNoRefactoring.class);

  @Override
  public Account findAccountForUser(String userId) {
    logger.debug("Getting account for user [" + userId + "]");
    ResourceBundle bundle = PropertyResourceBundle.getBundle("technical");
    String sql = bundle.getString("FIND_ACCOUNT_FOR_USER");

    //some code logic to load a user account using JDBC
    return null;
  }

  @Override
  public void updateAccount(Account account) {
    //Perform DB access here
  }
}

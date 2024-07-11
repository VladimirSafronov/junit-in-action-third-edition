package ru.safronov.account;

/**
 * Interface for all manager implementation
 */
public interface AccountManager {

  /**
   * Method finds account by the given userId
   */
  Account findAccountForUser(String userId);

  /**
   * Method updates the given account
   */
  void updateAccount(Account account);
}

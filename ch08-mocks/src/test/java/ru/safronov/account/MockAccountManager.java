package ru.safronov.account;

import java.util.HashMap;
import java.util.Map;

public class MockAccountManager implements AccountManager {

  private final Map<String, Account> accounts = new HashMap<>();

  public void addAccount(Account account) {
    this.accounts.put(account.getUserId(), account);
  }

  @Override
  public Account findAccountForUser(String userId) {
    return this.accounts.get(userId);
  }

  @Override
  public void updateAccount(Account account) {
    //do nothing
  }
}

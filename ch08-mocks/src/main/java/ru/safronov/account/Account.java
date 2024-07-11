package ru.safronov.account;

/**
 * Account POJO
 */
public class Account {

  private final String userId;
  private long balance;

  public Account(String userId, long balance) {
    this.userId = userId;
    this.balance = balance;
  }

  public long getBalance() {
    return balance;
  }

  public String getUserId() {
    return userId;
  }

  public void debit(long value) {
    this.balance -= value;
  }

  public void credit(long value) {
    this.balance += value;
  }
}

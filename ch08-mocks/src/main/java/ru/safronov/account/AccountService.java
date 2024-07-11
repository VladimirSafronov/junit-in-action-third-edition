package ru.safronov.account;

/**
 * A service that has different methods that we can use. Currently, it holds only the transfer
 * method, which transfers money from one account to the other
 */
public class AccountService {

  private AccountManager manager;

  public void setManager(AccountManager manager) {
    this.manager = manager;
  }

  public void transfer(String senderId, String beneficiaryId, long amount) {
    Account sender = manager.findAccountForUser(senderId);
    Account beneficiary = manager.findAccountForUser(beneficiaryId);

    sender.debit(amount);
    beneficiary.credit(amount);
    this.manager.updateAccount(sender);
    this.manager.updateAccount(beneficiary);
  }
}

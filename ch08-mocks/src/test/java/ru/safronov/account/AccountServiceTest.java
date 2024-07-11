package ru.safronov.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountServiceTest {

  @Test
  void testAccountService() {
    Account credit = new Account("1", 200);
    Account beneficiary = new Account("2", 100);

    MockAccountManager mockAccountManager = new MockAccountManager();
    mockAccountManager.addAccount(credit);
    mockAccountManager.addAccount(beneficiary);

    AccountService accountService = new AccountService();
    accountService.setManager(mockAccountManager);
    accountService.transfer("1", "2", 50);

    Assertions.assertEquals(150, credit.getBalance());
    Assertions.assertEquals(150, beneficiary.getBalance());
  }
}

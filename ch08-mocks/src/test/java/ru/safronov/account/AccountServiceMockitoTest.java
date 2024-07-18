package ru.safronov.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Test AccountService using Mockito
 */
@ExtendWith(MockitoExtension.class)
public class AccountServiceMockitoTest {

  @Mock
  private AccountManager mockAccountManager;

  @Test
  void testTransferOk() {
    Account sender = new Account("1", 150);
    Account beneficiary = new Account("2", 100);

    Mockito.lenient()
        .when(mockAccountManager.findAccountForUser("1"))
        .thenReturn(sender);
    Mockito.lenient()
        .when(mockAccountManager.findAccountForUser("2"))
        .thenReturn(beneficiary);

    AccountService accountService = new AccountService();
    accountService.setManager(mockAccountManager);
    accountService.transfer("1", "2", 25);

    Assertions.assertEquals(125, sender.getBalance());
    Assertions.assertEquals(125, beneficiary.getBalance());
  }
}

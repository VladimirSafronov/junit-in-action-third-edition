package ru.safronov.account;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.junit5.JUnit5Mockery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

/**
 * Test AccountService using JMock
 */
public class AccountServiceJMockTest {

  /**
   * The mockery context that we use to create our mocks.
   */
  @SuppressWarnings("JUnitMalformedDeclaration")
  @RegisterExtension
  Mockery context = new JUnit5Mockery();

  /**
   * The mock instance of the AccountManager to use.
   */
  private AccountManager mockAccountManager;

  @BeforeEach
  void setUp() {
    mockAccountManager = context.mock(AccountManager.class, "accountManager");
  }

  @Test
  void testTransferOk() {
    Account sender = new Account("1", 100);
    Account beneficiary = new Account("2", 200);

    context.checking(new Expectations() {
      {
        oneOf(mockAccountManager).findAccountForUser("1");
        will(returnValue(sender));

        oneOf(mockAccountManager).findAccountForUser("2");
        will(returnValue(beneficiary));

        oneOf(mockAccountManager).updateAccount(sender);
        oneOf(mockAccountManager).updateAccount(beneficiary);
      }
    });

    AccountService accountService = new AccountService();
    accountService.setManager(mockAccountManager);
    accountService.transfer("1", "2", 30);

    Assertions.assertEquals(70, sender.getBalance());
    Assertions.assertEquals(230, beneficiary.getBalance());
  }
}

package ru.safronov.account;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test AccountService using Easy Mock
 */
public class AccountServiceEasyMockTest {

  private AccountManager mockAccountManager;

  @BeforeEach
  void setUp() {
    mockAccountManager = createMock("mockAccountManager", AccountManager.class);
  }

  /**
   * Method verify that the method-call expectations we declared were triggered
   */
  @AfterEach
  void tearDown() {
    verify(mockAccountManager);
  }

  @Test
  void testTransferOk() {
    Account sender = new Account("1", 200);
    Account beneficiary = new Account("2", 100);

    //start defining the expectations
    mockAccountManager.updateAccount(sender);
    mockAccountManager.updateAccount(beneficiary);
    expect(mockAccountManager.findAccountForUser(sender.getUserId())).andReturn(sender);
    expect(mockAccountManager.findAccountForUser(beneficiary.getUserId())).andReturn(beneficiary);
    //we're done defining the expectations
    replay(mockAccountManager);

    AccountService accountService = new AccountService();
    accountService.setManager(mockAccountManager);
    accountService.transfer("1", "2", 50);

    Assertions.assertEquals(150, sender.getBalance());
    Assertions.assertEquals(150, beneficiary.getBalance());
  }
}

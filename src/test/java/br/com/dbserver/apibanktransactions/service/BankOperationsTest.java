package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.Status;
import br.com.dbserver.apibanktransactions.model.BankAccount;
import br.com.dbserver.apibanktransactions.repository.BankAccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class BankOperationsTest {

    @InjectMocks
    BankAccountService service;

    @Mock
    private BankAccountRepository repository;

    @Mock
    ExtractService extractService;

    @Before
    public void setUp() {
        BankAccount bankAccount = getAccount();
        Mockito.when(repository.findById(bankAccount.getId()))
                .thenReturn(Optional.of(bankAccount));
    }

    private BankAccount getAccount(){
        BankAccount account = new BankAccount();
        account.setId(Long.valueOf(2));
        account.setAccountNumber(Long.valueOf(741862));
        account.setBalance(Double.valueOf(7000));
        account.setStatus(Status.ACTIVE);
        return account;
    }

    public BankAccount getAccount2() {
        BankAccount account2 = new BankAccount();
        account2.setAccountNumber(Long.valueOf(123587));
        account2.setBalance(100d);
        account2.setStatus(Status.ACTIVE);
        return account2;
    }

    @Test
    public void accountNotNull() {
        BankAccount account = getAccount();
        Mockito.when(repository.findByAccountNumber(account.getAccountNumber())).thenReturn(Optional.of(account));
        service.consultBankAccountDetails(account.getAccountNumber());
        Assert.assertNotNull(account);
    }

    @Test
    public void blockAccount(){
        BankAccount account = getAccount();
        Mockito.when(repository.findByAccountNumber(account.getAccountNumber())).thenReturn(Optional.of(account));
        BankAccount updateStatus = service.disableBankAccount(account.getId());
        Assert.assertEquals(updateStatus.getStatus(), Status.BLOCKED );
    }

    @Test
    public void consultAccount(){
        BankAccount account = getAccount();
        Mockito.when(repository.findByAccountNumber(account.getAccountNumber())).thenReturn(Optional.of(account));
        service.consultBankAccountDetails(account.getAccountNumber());
        Assert.assertEquals(account.getBalance(), Double.valueOf(7000d));
    }

    @Test
    public void withdrawAccount(){
        BankAccount account = getAccount();
        Mockito.when(repository.findByAccountNumber(account.getAccountNumber())).thenReturn(Optional.of(account));
        BankAccount account1 = service.withdrawValueFromAnBankAccount( account.getAccountNumber(), 100d);
        Assert.assertEquals(account1.getBalance(), Double.valueOf(6900d));
    }

    @Test
    public void depositAccount(){
        BankAccount account = getAccount();
        Mockito.when(repository.findByAccountNumber(account.getAccountNumber())).thenReturn(Optional.of(account));
        BankAccount account1 = service.depositMoneyIntoAnBankAccount( account.getAccountNumber(), 100d);
        Assert.assertEquals(account1.getBalance(), Double.valueOf(7100d));
    }

    @Test
    public void transferOfValueBetweenAccounts(){
        BankAccount account = getAccount();
        BankAccount account2 = getAccount2();
        Mockito.when(repository.findByAccountNumber(account.getAccountNumber())).thenReturn(Optional.of(account));
        Mockito.when(repository.findByAccountNumber(account2.getAccountNumber())).thenReturn(Optional.of(account2));
        boolean account1 = service.transferOfValueBetweenAccounts( account.getAccountNumber(), 100d, account2.getAccountNumber());
        Assert.assertTrue(account1);
        Assert.assertEquals(account.getBalance(), Double.valueOf(6900d));
        Assert.assertEquals(account2.getBalance(), Double.valueOf(200d));
    }

}

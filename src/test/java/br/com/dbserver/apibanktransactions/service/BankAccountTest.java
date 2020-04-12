package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.Status;
import br.com.dbserver.apibanktransactions.exception.AccountNotFoundException;
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
public class BankAccountTest {

    @InjectMocks
    private BankAccountService service;

    @Mock
    private BankAccountRepository repository;

    @Mock
    private ExtractService extract;

    @Before
    public void setUp() {
        BankAccount account = getAccount();
        Mockito.when(repository.findById(account.getId()))
                .thenReturn(Optional.of(account));
    }

    private BankAccount getAccount(){
        BankAccount account = new BankAccount();
        account.setId(Long.valueOf(1));
        account.setAccountNumber(Long.valueOf(951753));
        account.setBalance(Double.valueOf(5000));
        account.setStatus(Status.ACTIVE);
        return account;
    }

    @Test
    public void newAccount(){
        BankAccount accountSave = new BankAccount();
        accountSave.setId(Long.valueOf(2));
        accountSave.setAccountNumber(Long.valueOf(852964));
        accountSave.setBalance(Double.valueOf(6500.00));
        accountSave.setStatus(Status.ACTIVE);
        service.createdBankAccount(accountSave);
        Assert.assertTrue(true);
    }

    @Test
    public void accountIsPresent(){
        BankAccount account = getAccount();
        Mockito.when(repository.findByAccountNumber(account.getAccountNumber())).thenReturn(Optional.of(account));
        service.consultBankAccountDetails(account.getAccountNumber());
        Assert.assertEquals(Long.valueOf(951753), account.getAccountNumber());
    }

    @Test(expected = AccountNotFoundException.class)
    public void accountNotEquals(){
        BankAccount account = getAccount();
        Mockito.when(repository.findById(account.getId())).thenReturn(Optional.of(account));
        service.consultBankAccountDetails(account.getAccountNumber());
        Assert.assertNotEquals(Long.valueOf(666666), account.getAccountNumber());
    }

}

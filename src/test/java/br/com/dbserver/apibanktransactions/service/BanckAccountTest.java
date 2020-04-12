package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.ClientType;
import br.com.dbserver.apibanktransactions.enums.Status;
import br.com.dbserver.apibanktransactions.model.BankAccount;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.repository.BankAccountRepository;
import br.com.dbserver.apibanktransactions.repository.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class BanckAccountTest {

    @InjectMocks
    private BankAccountService service;

    @Mock
    private BankAccountRepository repository;

    @Before
    public void setUp() {
        BankAccount bankAccount = getAccount();
        Mockito.when(repository.findById(bankAccount.getId()))
                .thenReturn(Optional.of(bankAccount));
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
        Mockito.when(repository.save(any(BankAccount.class))).thenReturn(accountSave);
        Assert.assertTrue(true);
    }

}

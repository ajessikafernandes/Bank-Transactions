package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.Status;
import br.com.dbserver.apibanktransactions.model.BankAccount;
import br.com.dbserver.apibanktransactions.model.Extract;
import br.com.dbserver.apibanktransactions.repository.ExtractRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class ExtractTest {

    @InjectMocks
    private ExtractService service;

    @Mock
    private ExtractRepository repository;

    @Before
    public void setUp() {

    }

    private BankAccount getAccount(){
        BankAccount account = new BankAccount();
        account.setId(Long.valueOf(1));
        account.setAccountNumber(Long.valueOf(951753));
        account.setBalance(Double.valueOf(5000));
        account.setStatus(Status.ACTIVE);
        service.extractCreateAccount(account);
        return account;
    }

    @Test
    public void ExtractAccount(){
        BankAccount account = getAccount();
        List<Extract> list = service.showAccountData(account.getAccountNumber());
        Assert.assertNotNull(list);
    }

}

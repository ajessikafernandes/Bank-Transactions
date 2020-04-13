package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.exception.ClientNotFoundException;
import br.com.dbserver.apibanktransactions.model.BankAccount;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.repository.BankAccountRepository;
import br.com.dbserver.apibanktransactions.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    public List<Client> listOfClientsAndTheirAccounts() {
        List<Client> client = clientRepository.findAll();
        if (client.isEmpty()) {
            throw new ClientNotFoundException("No clients enrolled");
        }
        return client;
    }

    public double sumOfAllBalancesOfAllExistingAccounts(){
        List<BankAccount> listBalance = bankAccountRepository.findAll();
        double amount = 0;
        for ( BankAccount account : listBalance) {
            amount += account.getBalance();
        }
        return amount;
    }

}

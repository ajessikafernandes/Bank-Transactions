package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.error.NoRegisteredCustomers;
//import br.com.dbserver.apibanktransactions.repository.AccountStatementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AdminService {

//    AccountStatementRepository repository;
//
//    public List<AccountStatement> clientList() {
//        List<AccountStatement> client = repository.findAll();
//        if (Objects.isNull(client)) {
//            throw new NoRegisteredCustomers("Nenhum cliente cadastrado no sistema.");
//        }
//        return client;
//    }

//    public BankAccount findByAccount(Integer numberAccount){
//        BankAccount bankAccount = repository.findByAccount(numberAccount);
//        return bankAccount;
//    }

}

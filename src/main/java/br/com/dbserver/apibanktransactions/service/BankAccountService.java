package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.Status;
import br.com.dbserver.apibanktransactions.error.AccountNotFound;
import br.com.dbserver.apibanktransactions.model.BankAccount;

import br.com.dbserver.apibanktransactions.model.Extract;
import br.com.dbserver.apibanktransactions.repository.BankAccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccountService {

    @Autowired
    BankAccountRepository repository;

    @Autowired
    ExtractService extractService;

    //ok
    public BankAccount newBankAccount(BankAccount bankAccount) {
        BankAccount accountIn = repository.save(bankAccount);
        extractService.extractCreateAccount(Optional.of(accountIn));
        return accountIn;
    }

    //ok
    public BankAccount disable(Long id) {
        Optional<BankAccount> accountIn = repository.findById(id);
        if (accountIn.isPresent()){
            BankAccount account1 = accountIn.get();
            if (account1.getStatus().equals(Status.ACTIVE)){
                account1.setStatus(Status.BLOCKED);
            }
            repository.save(account1);
            extractService.extractAccountBlock(accountIn);
            return account1;
        } else {
            throw new AccountNotFound("Account not found!");
        }
    }

    //ok
    public Optional<BankAccount> consultBalance(Long accountNumber) {
        Optional<BankAccount> account = repository.findByAccountNumber(accountNumber);
        extractService.extractConsult(account);
        return account;
    }

    //ok
    public BankAccount deposit (Long accountNumber, double value){
        Optional<BankAccount> account = repository.findByAccountNumber(accountNumber);
        if (account.isPresent()){
            BankAccount account1 = account.get();
            account1.deposit(value);
            repository.save(account1);
            extractService.extractDeposit(account, account1);
            return account1;
        } else {
            throw new AccountNotFound("Account not found!");
        }
    }

    //ok
    public BankAccount withdraw (Long accountNumber, double value){
        Optional<BankAccount> account = repository.findByAccountNumber(accountNumber);
        if (account.isPresent()){
            BankAccount account1 = account.get();
            if(account1.getBalance() >= value)
            account1.withdraw(value);
            repository.save(account1);
            extractService.extractWithdraw(account);
            return account1;
        } else {
            throw new AccountNotFound("Account not found!");
        }
    }

//    public boolean transfere(double valor, BankAccount destino) {
//        if (this.balance >= valor) {
//            this.balance -= valor;
//            destino.deposit(valor);
//            return true;
//        }
//        return false;
//    }

}

package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.Status;
import br.com.dbserver.apibanktransactions.exception.AccountNotFoundException;
import br.com.dbserver.apibanktransactions.model.BankAccount;

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

    public Boolean createdBankAccount(BankAccount bankAccount) {
        BankAccount accountIn = repository.save(bankAccount);
        extractService.extractCreateAccount(Optional.of(accountIn));
        return true;
    }

    public BankAccount disableBankAccount(Long id) {
        Optional<BankAccount> accountIn = repository.findById(id);
        if (accountIn.isPresent()) {
            BankAccount account1 = accountIn.get();
            if (account1.getStatus().equals(Status.ACTIVE)) {
                account1.setStatus(Status.BLOCKED);
            }
            repository.save(account1);
            extractService.extractAccountBlock(accountIn);
            return account1;
        } else {
            throw new AccountNotFoundException("Account not found!");
        }
    }

    public Optional<BankAccount> consultBankAccountDetails(Long accountNumber) {
        Optional<BankAccount> account = repository.findByAccountNumber(accountNumber);
        if (account.isPresent()) {
            extractService.extractConsult(account);
            return account;
        } else {
            throw new AccountNotFoundException("Account not found!");
        }
    }

    public BankAccount depositMoneyIntoAnBankAccount(Long accountNumber, double value) {
        Optional<BankAccount> account = repository.findByAccountNumber(accountNumber);
        if (account.isPresent()) {
            BankAccount account1 = account.get();
            account1.deposit(value);
            repository.save(account1);
            extractService.extractDeposit(account, Optional.of(account1));
            return account1;
        } else {
            throw new AccountNotFoundException("Account not found!");
        }
    }

    public BankAccount withdrawValueFromAnBankAccount(Long accountNumber, double value) {
        Optional<BankAccount> account = repository.findByAccountNumber(accountNumber);
        if (account.isPresent()) {
            BankAccount account1 = account.get();
            if (account1.getBalance() >= value)
                account1.withdraw(value);
            repository.save(account1);
            extractService.extractWithdraw(account);
            return account1;
        } else {
            throw new AccountNotFoundException("Account not found!");
        }
    }

    public boolean transferOfValueBetweenAccounts(Long account, double balance, Long accountDestination) {
        Optional<BankAccount> accountIn = repository.findByAccountNumber(account);
        Optional<BankAccount> otherAccount = repository.findByAccountNumber(accountDestination);
        if (accountIn.isPresent() && otherAccount.isPresent()) {
            BankAccount account1 = accountIn.get();
            BankAccount account2 = otherAccount.get();
            account1.transfer(account2, balance);
            extractService.extractTransfer(account1, account2, balance);
            repository.save(account1);
            repository.save(account2);
            return true;
        }
        throw new AccountNotFoundException("Account not found!");
    }

}

package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.TypeTransaction;
import br.com.dbserver.apibanktransactions.model.BankAccount;
import br.com.dbserver.apibanktransactions.model.Extract;
import br.com.dbserver.apibanktransactions.repository.ExtractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExtractService {

    @Autowired
    ExtractRepository repository;

    public List<Extract> showAccountData(Long accountNUmber) {
        List<Extract> extracts = repository.findAllByAccountNumber(accountNUmber);
        return extracts;
    }

    private void setAccount(Optional<BankAccount> account, Extract ex) {
        ex.setAccountNumber(account.get().getAccountNumber());
        ex.setBalance(account.get().getBalance());
        ex.setStatus(account.get().getStatus());
    }

    public void extractCreateAccount(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.CRIACAO);
        setAccount(account, ex);
        repository.save(ex);
    }

    public void extractAccountBlock(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.BLOQUEIO);
        setAccount(account, ex);
        repository.save(ex);
    }

    public void extractConsult(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.CONSULTA);
        setAccount(account, ex);
        repository.save(ex);
    }

    public void extractWithdraw(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.SAQUE);
        setAccount(account, ex);
        repository.save(ex);
    }

    public void extractDeposit(Optional<BankAccount> account, Optional<BankAccount> account1) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.DEPOSITO);
        setAccount(account, ex);
        ex.setAccountTransfer(account1.get().getAccountNumber());
        repository.save(ex);
    }

    public void extractTransfer(BankAccount account1, BankAccount account2, double valueTransfer) {
        Extract ex = new Extract();
        ex.setAccountNumber(account1.getAccountNumber());
        ex.setAccountTransfer(account2.getAccountNumber());
        ex.setBalance(account1.getBalance());
        ex.setDateTime(LocalDateTime.now());
        ex.setStatus(account1.getStatus());
        ex.setTypeTransaction(TypeTransaction.TRANSFERENCIA);
        ex.setValueTransfer(valueTransfer);
        System.out.println("Extract transfer : " + valueTransfer);
        repository.save(ex);
        extractDeposit(Optional.of(account2), Optional.of(account1));
    }

}

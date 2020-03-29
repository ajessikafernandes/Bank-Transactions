package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.TypeTransaction;
import br.com.dbserver.apibanktransactions.model.BankAccount;
import br.com.dbserver.apibanktransactions.model.Extract;
import br.com.dbserver.apibanktransactions.repository.ExtractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExtractService {

    @Autowired
    ExtractRepository repository;

    public List<Extract> showData(Long accountNUmber){
        List<Extract> extracts = repository.findAllByAccountNumber(accountNUmber);
        return extracts;
    }

    public void extractCreateAccount(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.CRIACAO);
        ex.setAccountNumber(account.get().getAccountNumber());
        ex.setBalance(account.get().getBalance());
        ex.setStatus(account.get().getStatus());
        repository.save(ex);
    }

    public void extractAccountBlock(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.BLOQUEIO);
        ex.setAccountNumber(account.get().getAccountNumber());
        ex.setBalance(account.get().getBalance());
        ex.setStatus(account.get().getStatus());
        repository.save(ex);
    }

    public void extractConsult(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.CONSULTA);
        ex.setAccountNumber(account.get().getAccountNumber());
        ex.setBalance(account.get().getBalance());
        ex.setStatus(account.get().getStatus());
        repository.save(ex);
    }

    public void extractWithdraw(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.SAQUE);
        ex.setAccountNumber(account.get().getAccountNumber());
        ex.setBalance(account.get().getBalance());
        ex.setStatus(account.get().getStatus());
        repository.save(ex);
    }

    public void extractDeposit(Optional<BankAccount> account, BankAccount account1) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.DEPOSITO);
        ex.setAccountNumber(account.get().getAccountNumber());
        ex.setBalance(account.get().getBalance());
        ex.setStatus(account.get().getStatus());
        ex.setAccountTransfer(account1.getAccountNumber());
        repository.save(ex);
    }

    public void extractTransfer(Optional<BankAccount> account) {
        Extract ex = new Extract();
        ex.setTypeTransaction(TypeTransaction.TRANSFERENCIA);
        ex.setAccountNumber(account.get().getAccountNumber());
        ex.setBalance(account.get().getBalance());
        ex.setStatus(account.get().getStatus());
        repository.save(ex);
    }

}

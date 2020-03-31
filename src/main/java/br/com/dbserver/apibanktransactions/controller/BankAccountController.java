package br.com.dbserver.apibanktransactions.controller;

import br.com.dbserver.apibanktransactions.model.BankAccount;

import br.com.dbserver.apibanktransactions.service.BankAccountService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "account/")
public class BankAccountController {

    @Autowired
    BankAccountService accountService;

    //confirmar json
    @PostMapping
    public ResponseEntity<Object> createdBankAccount(@RequestBody BankAccount bankAccount) {
        return new ResponseEntity<>(accountService.createdBankAccount(bankAccount), HttpStatus.CREATED);
    }

    @PutMapping("disable/{id}")
    public ResponseEntity<?> disableBankAccount(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.disableBankAccount(id), HttpStatus.OK);
    }

    @GetMapping(value = "consult/{accountNumber}")
    public ResponseEntity<Optional<BankAccount>> consultBankAccountDetails(@PathVariable Long accountNumber) {
        Optional<BankAccount> obj = accountService.consultBankAccountDetails(accountNumber);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("deposit/{accountNumber}/{value}")
    public ResponseEntity<?> depositMoneyIntoAnBankAccount(@PathVariable Long accountNumber, @PathVariable double value) {
        return new ResponseEntity<>(accountService.depositMoneyIntoAnBankAccount(accountNumber, value), HttpStatus.OK);
    }

    //confirmar json
    @PutMapping("withdraw/{accountNumber}/{value}")
    public ResponseEntity<?> withdrawValueFromAnBankAccount(@PathVariable Long accountNumber, @PathVariable double value) {
        return new ResponseEntity<>(accountService.withdrawValueFromAnBankAccount(accountNumber, value), HttpStatus.OK);
    }

    @PutMapping("transfer/{account}/{balance}/{accountDestination}")
    public ResponseEntity<?> transferOfValueBetweenAccounts(@PathVariable Long account, @PathVariable double balance, @PathVariable Long accountDestination) {
        return new ResponseEntity<>(accountService.transferOfValueBetweenAccounts( account, balance, accountDestination), HttpStatus.OK);
    }

}

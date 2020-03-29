package br.com.dbserver.apibanktransactions.controller;

import br.com.dbserver.apibanktransactions.model.BankAccount;

import br.com.dbserver.apibanktransactions.model.Extract;
import br.com.dbserver.apibanktransactions.service.BankAccountService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.events.Event;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "account/")
public class BankAccountController {

    @Autowired
    BankAccountService accountService;

    //+-
    @PostMapping
    public ResponseEntity<Object> created(@RequestBody BankAccount bankAccount) {
        return new ResponseEntity<>(accountService.newBankAccount(bankAccount), HttpStatus.CREATED);
    }

    //ok
    @PutMapping("disable/{id}")
    public ResponseEntity<?> disable(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.disable(id), HttpStatus.OK);
    }

    //ok
    @GetMapping(value = "consult/{accountNumber}")
    public ResponseEntity<Optional<BankAccount>> consult(@PathVariable Long accountNumber) {
        Optional<BankAccount> obj = accountService.consultBalance(accountNumber);
        return ResponseEntity.ok().body(obj);
    }

    //ok
    @PutMapping("deposit/{accountNumber}/{value}")
    public ResponseEntity<?> deposit(@PathVariable Long accountNumber, @PathVariable Double value) {
        return new ResponseEntity<>(accountService.deposit(accountNumber, value), HttpStatus.OK);
    }

    //+-
    @PutMapping("withdraw/{accountNumber}/{value}")
    public ResponseEntity<?> withdraw(@PathVariable Long accountNumber, @PathVariable Double value) {
        return new ResponseEntity<>(accountService.withdraw(accountNumber, value), HttpStatus.OK);
    }

}

package br.com.dbserver.apibanktransactions.controller;

import br.com.dbserver.apibanktransactions.exception.BalanceNonexistentException;
import br.com.dbserver.apibanktransactions.exception.ClientNotFoundException;

import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.service.AdminService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "admin/")
public class AdminController {

    AdminService adminService;

    @GetMapping("list")
    public ResponseEntity<?> listOfClientsAndTheirAccounts() {
        List<Client> clients = adminService.listOfClientsAndTheirAccounts();
        if (clients.size() > 0) {
            return ResponseEntity.ok(clients);
        } else {
            return ResponseEntity.badRequest()
                    .body(new ClientNotFoundException("Não há clientes cadastrados no sistema."));
        }
    }

    @GetMapping("accounts/balance")
    public ResponseEntity<?> sumOfAllBalancesOfAllExistingAccounts() {
        double amount = adminService.sumOfAllBalancesOfAllExistingAccounts();
        if (amount > 0) {
            return ResponseEntity.ok(amount);
        } else {
            return ResponseEntity.badRequest()
                    .body(new BalanceNonexistentException("Balance Nonexistent"));
        }
    }

}

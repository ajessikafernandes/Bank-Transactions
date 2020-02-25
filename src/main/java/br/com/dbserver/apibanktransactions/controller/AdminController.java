package br.com.dbserver.apibanktransactions.controller;

import br.com.dbserver.apibanktransactions.error.NoRegisteredCustomers;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.service.AdminService;
import br.com.dbserver.apibanktransactions.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping(path = "admin/")
public class AdminController {

    AdminService adminService;

    @GetMapping("clients/list")
    public ResponseEntity<?> clientsList() {
        List<Client> clients = adminService.clientList();

        if (clients.size() > 0) {
            return ResponseEntity.ok(clients);
        } else {
            return ResponseEntity.badRequest()
                    .body(new NoRegisteredCustomers("Não há pets cadastrados no sistema."));
        }
    }
}

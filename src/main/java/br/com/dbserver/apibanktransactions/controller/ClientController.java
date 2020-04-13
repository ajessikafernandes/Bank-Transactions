package br.com.dbserver.apibanktransactions.controller;

import br.com.dbserver.apibanktransactions.exception.ClientNotFoundException;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.service.ClientService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "client/")
public class ClientController {

    ClientService clientService;

    @GetMapping("{id}")
    public ResponseEntity<Client> findClientById(@PathVariable Long id) {
        return clientService.findClientById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("new")
    public ResponseEntity createdClient(@RequestBody Client client) {
        clientService.createdClient(client);
        return new ResponseEntity(client, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Object> updateClientData(@RequestBody @Valid Client client, @PathVariable(value = "id") Long id) {
        Optional<Client> clientIn = clientService.findClientById(id);
        if (clientIn.isPresent()) {
            Client client1 = clientService.updateClientData(client, id);
            return ResponseEntity.ok(clientService.updateClientData(client1, id));
        } else {
            return ResponseEntity.badRequest().body(new ClientNotFoundException("Client not found!"));
        }
    }

}

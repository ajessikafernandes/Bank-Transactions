package br.com.dbserver.apibanktransactions.controller;

import br.com.dbserver.apibanktransactions.error.ClientIdNotFound;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.service.ClientService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "client/")
public class ClientController {

    ClientService clientService;

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Client> client = clientService.clientFindById(id);
        if (client.isPresent()) {
            return ResponseEntity.ok().body(client);
        } else {
            return ResponseEntity.badRequest().body(new ClientIdNotFound("resolver depois"));
        }
    }

    @PostMapping("new")
    public ResponseEntity<Object> createNewClient(@RequestBody @Valid Client client) {
        Client newClient = clientService.newClient(client);
        return new ResponseEntity<>(clientService.newClient(newClient), HttpStatus.CREATED);
    }



}

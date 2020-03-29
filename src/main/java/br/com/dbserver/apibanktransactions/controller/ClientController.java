package br.com.dbserver.apibanktransactions.controller;

import br.com.dbserver.apibanktransactions.error.AccountNotFound;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.service.ClientService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ClientService clientService;

    //ok
    @GetMapping("{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return clientService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //ok
    @PostMapping("new")
    public ResponseEntity created(@RequestBody Client client) {
        clientService.newClient(client);
        return new ResponseEntity(client, HttpStatus.CREATED);
    }

    //ok
    @DeleteMapping(value= "{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        clientService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    //ok
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Object> updatePet(@RequestBody @Valid Client client, @PathVariable(value = "id") Long id) {
        Optional<Client> clientIn = clientService.findById(id);
        if (clientIn.isPresent()) {
            Client client1 = clientService.update(client, id);
            return ResponseEntity.ok(clientService.update(client1, id));
        } else {
            return ResponseEntity.badRequest().body(new AccountNotFound("client.id.not.found.message"));
        }
    }
}

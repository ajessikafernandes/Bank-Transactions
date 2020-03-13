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
    public ResponseEntity findById(@PathVariable Long id) {
        return clientService.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("new")
    public ResponseEntity<Object> createdNew(@RequestBody Client client) {
        Client newClient = clientService.newClient(client);
        return new ResponseEntity<>(clientService.newClient(newClient), HttpStatus.CREATED);
    }

//    @PutMapping("id")
//    public ResponseEntity update(@PathVariable("id") long id, @RequestBody Client client){
//        return clientService.
//    }


}

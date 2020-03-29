package br.com.dbserver.apibanktransactions.controller;

import br.com.dbserver.apibanktransactions.model.Extract;
import br.com.dbserver.apibanktransactions.service.ExtractService;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "extract/")
public class ExtractController {

    @Autowired
    ExtractService service;

    //ok
    @GetMapping(value = "consult/{accountNumber}")
    public ResponseEntity<List<Extract>> consult(@PathVariable Long accountNumber) {
        List<Extract> obj = service.showData(accountNumber);
        return ResponseEntity.ok().body(obj);
    }
}

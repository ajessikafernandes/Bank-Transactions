package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.error.NoRegisteredCustomers;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AdminService {

    ClientRepository repository;

    public List<Client> clientList() {
        List<Client> client = repository.findAll();
        if (Objects.isNull(client)) {
            throw new NoRegisteredCustomers("Nenhum cliente cadastrado no sistema.");
        }
        return client;
    }

}

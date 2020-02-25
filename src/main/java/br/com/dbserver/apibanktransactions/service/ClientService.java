package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.error.ClientIdNotFound;
import br.com.dbserver.apibanktransactions.model.Client;

import br.com.dbserver.apibanktransactions.repository.ClientRepository;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    ClientRepository repository;

    public Optional<Client> clientFindById(Long id) {
        Optional<Client> client = repository.findById(id);
        if (Objects.isNull(client)) {
            throw new ClientIdNotFound("Nenhum id de cliente encontrado.");
        }
        return client;
    }

    public Client newClient(Client client) {
        Client clientIn = repository.save(client);
        return clientIn;
    }

}

package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.exception.ClientNotFoundException;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    public Optional<Client> findClientById(Long id) {
        Optional<Client> client = repository.findById(id);
        if (!client.isPresent()){
            throw new ClientNotFoundException("Client not found!");
        }
        return client;
    }

    public void createdClient(Client client) {
        repository.save(client);
    }

    public Client updateClientData(Client client, Long id) {
        Optional<Client> clientIn = repository.findById(id);
        if (clientIn.isPresent()) {
            repository.save(client);
            return client;
        } else {
            throw new ClientNotFoundException("Client not found!");
        }
    }

    public boolean deleteClient(Long id) {
        repository.deleteById(id);
        return true;
    }

}

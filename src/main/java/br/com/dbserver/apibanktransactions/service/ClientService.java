package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.error.AccountNotFound;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    //get -> ok
    public Optional<Client> findById(Long id) {
        Optional<Client> client = repository.findById(id);
        return client;
    }

    //post -> ok
    public Client newClient(Client client) {
        return repository.save(client);
    }

    //put
    public Client update(Client client, Long id) {
        Optional<Client> clientIn = repository.findById(id);
        if (clientIn.isPresent()) {
            repository.save(client);
            return client;
        } else {
            throw new AccountNotFound("client.id.not.found.message");
        }
    }

    //delete -> ok
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

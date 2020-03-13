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

    public Client newClient(Client client) {
        Client clientIn = repository.save(client);
        return clientIn;
    }

    public Optional<Client> findById(Long id) {
        Optional<Client> client = repository.findById(id);
        return client;
    }

    public Client update(Client client, Long id){
        Optional<Client> clientIn = repository.findById(id);
        if (Objects.isNull(clientIn)) {
            throw new ClientIdNotFound("Nenhum id de cliente encontrado.");
        } else {
            repository.save(client);
            return client;
        }
    }

//    public Client disable(Client client, Long id){
//        Optional<Client> clientIn = repository.findById(id);
//        if (clientIn.isPresent()){
//            Client client1 = clientIn.get();
//        }
//    }

}

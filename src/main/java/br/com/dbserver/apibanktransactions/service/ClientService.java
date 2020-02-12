package br.com.dbserver.apibanktransactions.service;

//import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.repository.ClientRepository;
//import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

//    public Client clientFindById (String id){
//        Optional<Client> client = repository.findById(id);
//        if (client.isPresent()){
//            return client;
//        } else {
//            throw new ExceptionNoneExistentObject();
//        }
//    }
}

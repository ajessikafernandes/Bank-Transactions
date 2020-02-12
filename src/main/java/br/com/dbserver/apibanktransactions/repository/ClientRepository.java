package br.com.dbserver.apibanktransactions.repository;

import br.com.dbserver.apibanktransactions.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}

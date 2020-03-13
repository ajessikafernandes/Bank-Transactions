package br.com.dbserver.apibanktransactions.repository;

import br.com.dbserver.apibanktransactions.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}

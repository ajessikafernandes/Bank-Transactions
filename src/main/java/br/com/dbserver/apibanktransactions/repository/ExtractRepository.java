package br.com.dbserver.apibanktransactions.repository;

import br.com.dbserver.apibanktransactions.model.Extract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExtractRepository extends JpaRepository<Extract, Long> {

    List<Extract> findAllByAccountNumber(Long accountNumber);

}

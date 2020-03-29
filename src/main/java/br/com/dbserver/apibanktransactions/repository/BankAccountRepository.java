package br.com.dbserver.apibanktransactions.repository;

import br.com.dbserver.apibanktransactions.model.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Optional<BankAccount> findByAccountNumber(Long accountNumber);

}

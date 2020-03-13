package br.com.dbserver.apibanktransactions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BankAccount implements Extract {

    @Id @GeneratedValue
    private Long id;
    private Integer accountNumber;
    private Double balance;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public static void saque(double balance) {}

    public static void deposito(double balance) {}

    public void transferencia(double balance, BankAccount bankAccount) {}

}
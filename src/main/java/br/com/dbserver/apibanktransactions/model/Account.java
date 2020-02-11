package br.com.dbserver.apibanktransactions.model;

import br.com.dbserver.apibanktransactions.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
//import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

    @Id @GeneratedValue
    @Getter private Long id;
    @Getter @Setter private Integer agency;
    @Getter @Setter private Integer account;
    @Getter @Setter private Double balance;

    @Getter @Setter private AccountStatus accountStatus;

}
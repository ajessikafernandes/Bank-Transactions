package br.com.dbserver.apibanktransactions.model;

import br.com.dbserver.apibanktransactions.enums.ClientType;
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
public class Client {

    @Id
    @GeneratedValue
    @Getter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String mail;
    @Getter @Setter private ClientType clientType;

//    @OneToOne
//    @Getter @Setter private Account account;

}
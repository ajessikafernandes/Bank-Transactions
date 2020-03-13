package br.com.dbserver.apibanktransactions.model;

import br.com.dbserver.apibanktransactions.enums.ClientType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Client {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String mail;
    private ClientType clientType;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BankAccount> bankAccount;

}
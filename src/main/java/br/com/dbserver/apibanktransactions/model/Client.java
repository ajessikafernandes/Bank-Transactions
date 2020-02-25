package br.com.dbserver.apibanktransactions.model;

import br.com.dbserver.apibanktransactions.enums.ClientType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "client")
public class Client {

    @Id
    private Long id;
    private String name;
    private String mail;
    private ClientType clientType;

    private List<Account> account;

}
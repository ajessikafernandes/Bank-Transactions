package br.com.dbserver.apibanktransactions.model;

import br.com.dbserver.apibanktransactions.enums.ClientType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "client")
public class Client {

    private ObjectId id;
    private String name;
    private String mail;
    private ClientType clientType;

    private Account account;

}
package br.com.dbserver.apibanktransactions.model;

import br.com.dbserver.apibanktransactions.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Account {

    private ObjectId id;
    private Integer agency;
    private Integer numberAccount;
    private Double balance;

    private AccountStatus accountStatus;

}
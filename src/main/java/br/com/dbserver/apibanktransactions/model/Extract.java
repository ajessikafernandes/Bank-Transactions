package br.com.dbserver.apibanktransactions.model;

import br.com.dbserver.apibanktransactions.enums.Status;
import br.com.dbserver.apibanktransactions.enums.TypeTransaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Extract {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private LocalDateTime dateTime = LocalDateTime.now();
    private TypeTransaction typeTransaction;
    private Double balance;
    private Status status;
    private Long accountTransfer;
    private Double valueTransfer;

}

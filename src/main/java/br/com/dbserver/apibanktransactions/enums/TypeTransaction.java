package br.com.dbserver.apibanktransactions.enums;

public enum TypeTransaction {

    CRIACAO(0, "Criacao de conta"),
    BLOQUEIO(1, "Bloqueio"),
    CONSULTA(2, "Consulta"),
    SAQUE(3, "Saque"),
    DEPOSITO(4, "Deposito"),
    TRANSFERENCIA(5, "Transferencia");

    private int id;
    private String message;

    TypeTransaction(int i, String active) {
    }

    void Errors(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

}

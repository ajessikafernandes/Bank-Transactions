package br.com.dbserver.apibanktransactions.enums;

public enum ClientType {

    PESSOA_FISICA(0, "Pessoa Juridica"),
    PESSOA_JURIDICA(1, "Pessoa Juridica");
    private int id;
    private String message;

    ClientType(int i, String active) {
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

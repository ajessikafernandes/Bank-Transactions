package br.com.dbserver.apibanktransactions.enums;

public enum ClientType {

    PF(0, "Pessoa Juridica"),
    PJ(1, "Pessoa Juridica");
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

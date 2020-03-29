package br.com.dbserver.apibanktransactions.enums;

public enum Status {

    ACTIVE(0, "Active"),
    BLOCKED(1, "Blocked");

    private int id;
    private String message;

    Status(int i, String active) {
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

package br.com.dbserver.apibanktransactions.error;

public class AccountNotFound extends RuntimeException {

    public AccountNotFound(String message) {
        super(message);
    }

}

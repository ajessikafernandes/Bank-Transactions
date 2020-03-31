package br.com.dbserver.apibanktransactions.exception;

public class BalanceNonexistentException extends RuntimeException{

    public BalanceNonexistentException(String message) {
        super(message);
    }

}

package br.com.dbserver.apibanktransactions.error;

import lombok.Getter;

@Getter
public class GetMessageException extends RuntimeException {

    protected int code;
    protected String msgProperty;
    protected String message;

    public GetMessageException(int code, String msgProperty, String message) {
        this.code = code;
        this.msgProperty = msgProperty;
        this.message = message;
    }

    public GetMessageException(int code, String msgProperty, Throwable cause) {
        super(cause);
        this.code = code;
        this.msgProperty = msgProperty;
    }

    public GetMessageException(int code, String msgProperty) {
        this.code = code;
        this.msgProperty = msgProperty;
    }

}

package br.com.dbserver.apibanktransactions.error;

public class ClientIdNotFound extends GetMessageException {

    private static int code = 1;
    private static String msgProperty = "client.id.not.found.message";

    public ClientIdNotFound(String msgProperty) {
        super(code, msgProperty);
    }

}

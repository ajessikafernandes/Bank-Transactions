package br.com.dbserver.apibanktransactions.error;

public class NoRegisteredCustomers extends GetMessageException {

    private static int code = 2;
    private static String msgProperty = "no.registered.customers.message";

    public NoRegisteredCustomers(String msgProperty) {
        super(code, msgProperty);
    }

}

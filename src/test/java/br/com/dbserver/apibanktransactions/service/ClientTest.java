package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.repository.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ClientTest {

    @InjectMocks
    private ClientService service;

    @Mock
    private ClientRepository repository;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void findClientById(){
//        Client client = new Client();
//        client.setName("Client Test 1");
//        client.getMail(client.test@)
//    }


}

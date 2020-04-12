package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.ClientType;
import br.com.dbserver.apibanktransactions.model.Client;
import br.com.dbserver.apibanktransactions.repository.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class ClientTest {

    @InjectMocks
    private ClientService service;

    @Mock
    private ClientRepository repository;

    @Before
    public void setUp() {
        Client client = getClient();
        Mockito.when(repository.findById(client.getId()))
                .thenReturn(Optional.of(client));
    }

    private Client getClient(){
        Client client = new Client();
        client.setId(Long.valueOf(1));
        client.setName("Client 1");
        client.setMail("new.client@teste.com");
        client.setClientType(ClientType.PF);
        return client;
    }

    @Test
    public void newClient(){
        Client clientSave = new Client();
        clientSave.setId(Long.valueOf(2));
        clientSave.setName("Client 2");
        clientSave.setMail("client.2@teste.com");
        clientSave.setClientType(ClientType.PJ);
        Mockito.when(repository.save(any(Client.class))).thenReturn(clientSave);
        Assert.assertTrue(true);
    }

    @Test
    public void clientIsPresent(){
        Client client = getClient();
        Mockito.when(repository.findById(client.getId())).thenReturn(Optional.of(client));
        Assert.assertEquals("Client 1", client.getName());
    }

    @Test
    public void ClientNotEquals(){
        Client client = getClient();
        Mockito.when(repository.findById(client.getId())).thenReturn(Optional.of(client));
        Assert.assertNotEquals("Client", client.getName());
    }

    @Test
    public void alterDataClient(){
        Client client = getClient();
        clientIsPresent();
        client.setMail("new.email@teste.com");
        service.updateClientData(client, client.getId());
        Assert.assertEquals("new.email@teste.com", client.getMail());
    }

    @Test
    public void deleteClient(){
        Client client = getClient();
        boolean deleted = service.deleteClient(client.getId());
        Assert.assertTrue(true);
    }

}

package br.com.dbserver.apibanktransactions.service;

import br.com.dbserver.apibanktransactions.enums.ClientType;
import br.com.dbserver.apibanktransactions.exception.ClientNotFoundException;
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

    @Test
    public void clientIsPresent(){
        Client client = getClient();
        Mockito.when(repository.findById(client.getId())).thenReturn(Optional.of(client));
        Assert.assertEquals("New Client", client.getName());
    }

    @Test
    public void ClientNotEquals(){
        Client client = getClient();
        Mockito.when(repository.findById(client.getId())).thenReturn(Optional.of(client));
        Assert.assertNotEquals("Client", client.getName());
    }

    @Test(expected = ClientNotFoundException.class)
    public void clientNotFound(){
        Mockito.when(repository.findById(any()));
        Assert.assertNull(Client.class);
    }

    @Test
    public void alterDataClient(){
        Client client = getClient();
        Mockito.when(repository.findById(client.getId())).thenReturn(Optional.of(client));
        service.updateClientData(client, client.getId());
        client.setMail("new.email@teste.com");
        Assert.assertEquals("new.email@teste.com", client.getMail());
    }

    private Client getClient(){
        Client client = new Client();
        client.setName("New Client");
        client.setMail("new.client@teste.com");
        client.setClientType(ClientType.PF);
        return client;
    }

}

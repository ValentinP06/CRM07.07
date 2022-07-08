package org.example;

import org.example.dao.ClientDao;
import org.example.entity.Client;
import org.example.util.ClientState;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void createAndFindClientById() {

        Client client = new Client();
        client.setCompanyName("Sopra Steria");
        client.setFirstName("vert");
        client.setLastName("cahier");
        client.setPhone("123456789");
        client.setEmail("12345678@gmail.com");
        client.setAddress("12342345");
        client.setZipCode("12345");
        client.setCity("PARIS");
        client.setCountry("France");
        client.setClientState(ClientState.ACTIVE);
        ClientDao.createClient(client);
        assertTrue(true);

        Client client1 = ClientDao.findClientById(client.getId());
        assertEquals("vert", client1.getFirstName());

        ClientDao.deleteClient(client);
    }

    @Test
    public void DontFindClientById() {

        Client client2 = ClientDao.findClientById(0);
        assertNull(client2);
    }

    @Test
    public void findAllClients() {

        List<Client> clients = ClientDao.findAllClients();
        assertTrue(clients.size() > 0);
    }

    @Test
    public void deleteClient(){

        Client client = new Client();
        client.setCompanyName("Sopra Steria");
        client.setFirstName("erty");
        client.setLastName("uytrr");
        client.setPhone("123456789");
        client.setEmail("12345678@gmail.com");
        client.setAddress("14e");
        client.setZipCode("CITYVILLE");
        client.setCity("NICE");
        client.setCountry("France");
        client.setClientState(ClientState.ACTIVE);
        ClientDao.createClient(client);

        List<Client> clients = ClientDao.findAllClients();
        int listLenght = clients.size();

        ClientDao.deleteClient(client);

        clients = ClientDao.findAllClients();
        assertEquals(listLenght - 1, clients.size());
    }

    @Test
    public void deleteClientById() {

        Client client1 = new Client();
        client1.setCompanyName("Sopra Steria");
        client1.setFirstName("XAZ");
        client1.setLastName("REZ");
        client1.setPhone("09876543");
        client1.setEmail("456787654@gmail.com");
        client1.setAddress("12345678");
        client1.setZipCode("345678");
        client1.setCity("JUIL");
        client1.setCountry("France");
        client1.setClientState(ClientState.ACTIVE);
        ClientDao.createClient(client1);

        Client client2 = new Client();
        client2.setCompanyName("Sopra Steria");
        client2.setFirstName("XAC");
        client2.setLastName("PAC");
        client2.setPhone("12345678");
        client2.setEmail("1234567890@gmail.com");
        client2.setAddress("121234567890");
        client2.setZipCode("12345678");
        client2.setCity("LYON");
        client2.setCountry("France");
        client2.setClientState(ClientState.ACTIVE);
        ClientDao.createClient(client2);

        ClientDao.deleteClientById(client1.getId());

        assertNull(ClientDao.findClientById(client1.getId()));
        assertNotNull(ClientDao.findClientById(client2.getId()));

        ClientDao.deleteClientById(client2.getId());
    }

    @Test
    public void updateClient() {

        Client client = new Client();
        client.setCompanyName("azertyuja");
        client.setFirstName("TIBO");
        client.setLastName("LEBA");
        client.setPhone("234567890");
        client.setEmail("1234567890@gmail.com");
        client.setAddress("1234567890");
        client.setZipCode("1234567890");
        client.setCity("Blagnac");
        client.setCountry("France");
        client.setClientState(ClientState.ACTIVE);
        ClientDao.createClient(client);

        Client newClientData = new Client();
        newClientData.setEmail("1234567890@gmail.com");
        ClientDao.updateClient(client.getId(), newClientData);

        Client updatedCustomer = ClientDao.findClientById(client.getId());
        assertEquals("1234567890@gmail.com", updatedCustomer.getEmail());

        ClientDao.deleteClient(client);
    }


}
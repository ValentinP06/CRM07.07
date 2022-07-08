package org.example;

import org.example.dao.ClientDao;
import org.example.dao.OrderDao;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.ClientState;
import org.example.util.OrderState;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void createAndFindOrderById() {

        Client client = new Client();
        client.setCompanyName("Sopra Steria");
        client.setFirstName("PHILIP");
        client.setLastName("PUTOI");
        client.setPhone("034567890");
        client.setEmail("123456789@gmail.com");
        client.setAddress("12345T6");
        client.setZipCode("12345");
        client.setCity("BX");
        client.setCountry("France");
        client.setClientState(ClientState.ACTIVE);
        ClientDao.createClient(client);

        Order order = new Order();
        order.setTypePresta("Formation Test");
        order.setDesignation("AngularFRONT");
        order.setNbDays(13);
        order.setUnitPrice(93F);
        order.setClient(client);
        order.setOrderState(OrderState.CONFIRMED);
        OrderDao.createOrder(order);
        assertTrue(true);

        Order order1 = OrderDao.findOrderById(order.getId());
        assertEquals("Formation Test", order.getTypePresta());

        OrderDao.deleteOrder(order);
        ClientDao.deleteClient(client);
    }

    @Test
    public void DontFindOrderById() {

        Order order2 = OrderDao.findOrderById(0);
        assertNull(order2);
    }

    @Test
    public void findAllOrders() {

        List<Order> orders = OrderDao.findAllOrders();
        assertTrue(orders.size() > 0);
    }

    @Test
    public void updateOrder() {

        Client client = new Client();
        client.setCompanyName("apple");
        client.setFirstName("stevi");
        client.setLastName("paire");
        client.setPhone("0234567");
        client.setEmail("0234567@gmail.com");
        client.setAddress("12 rue de la joie");
        client.setZipCode("444444");
        client.setCity("BESANCON");
        client.setCountry("France");
        client.setClientState(ClientState.ACTIVE);
        ClientDao.createClient(client);

        Order order = new Order();
        order.setTypePresta("Formation");
        order.setDesignation("JAVAJPA");
        order.setNbDays(123);
        order.setUnitPrice(2350F);
        order.setOrderState(OrderState.CONFIRMED);
        order.setClient(client);
        OrderDao.createOrder(order);

        Order newOrderData = new Order();
        newOrderData.setUnitPrice(91F);
        OrderDao.updateOrder(order.getId(), newOrderData);

        Order updatedOrder = OrderDao.findOrderById(order.getId());
        assertEquals(new Float(91F), updatedOrder.getUnitPrice());

        ClientDao.deleteClient(client);
    }

}
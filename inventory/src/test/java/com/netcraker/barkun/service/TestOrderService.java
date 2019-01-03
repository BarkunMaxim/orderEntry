package com.netcraker.barkun.service;

import com.netcracker.barkun.dao.repository.OrderRepository;
import com.netcracker.barkun.entity.Order;
import com.netcracker.barkun.entity.OrderItem;
//import com.netcracker.barkun.service.config.OrderServiceConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
public class TestOrderService {

    @Autowired
    private OrderRepository orderRepository;

    private Order testOrder;

    @BeforeEach
    public void setUp() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem("Книга", "Фантастика", 1L, 1L, null));
        items.add(new OrderItem("Книга", "Историческая", 1L, 1L, null));
        testOrder = new Order(new Date(), true, "asd", items);
    }

    @Test
    public void testCreateOrder() {

        Order createOrder = orderRepository.save(testOrder);

        assertNotNull(createOrder);
    }

    @Test
    public void testFindAllOrder() {

        orderRepository.save(testOrder);


        Iterable<Order> orders = orderRepository.findAll();

        assertNotNull(orders);
    }

    @Test
    public void testFindOrderById() {

        Order createOrder = orderRepository.save(testOrder);
        Optional<Order> foundOrder = orderRepository.findById(createOrder.getId());

        assertEquals(createOrder.getId(), foundOrder.get().getId());
    }

    @Test
    public void testUpdateOrder() {
        Order createOrder = orderRepository.save(testOrder);
        createOrder.setPayStatus(false);
        Order updateOrder = orderRepository.save(createOrder);

        assertEquals(createOrder.isPayStatus(), updateOrder.isPayStatus());
    }

    @Test
    public void testDeleteOrder() {
        Order createOrder = orderRepository.save(testOrder);
        orderRepository.deleteById(createOrder.getId());
        Optional<Order> foundOrder = orderRepository.findById(createOrder.getId());

        assertNull(foundOrder);
    }
}

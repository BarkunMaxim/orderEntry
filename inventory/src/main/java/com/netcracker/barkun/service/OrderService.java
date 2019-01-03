package com.netcracker.barkun.service;

import com.netcracker.barkun.entity.Order;
import com.netcracker.barkun.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order saveOrder(Order order);

    Iterable<Order> getAllOrders();

    Optional<Order> getOrderById(Long id);

    Order updateOrder(Order newOrder);

    Order addItem(OrderItem orderItem, Long id);

    void removeOrder(Long id);
}

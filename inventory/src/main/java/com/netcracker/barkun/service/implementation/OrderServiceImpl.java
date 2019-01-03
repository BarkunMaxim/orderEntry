package com.netcracker.barkun.service.implementation;

import com.netcracker.barkun.dao.repository.OrderRepository;
import com.netcracker.barkun.entity.Order;
import com.netcracker.barkun.entity.OrderItem;
import com.netcracker.barkun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements Serializable ,OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return  orderRepository.save(order);
    }

    @Override
    public Iterable<Order> getAllOrders() {
        List<Order> resultList = new ArrayList<>();
        for (Order order:orderRepository.findAll()){
            resultList.add(order);
        }
        return resultList;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    @Override
    public Order addItem(OrderItem orderItem, Long id) {
        Optional<Order> foundOrder = orderRepository.findById(id);
        foundOrder.get().addOrderItem(orderItem);
        return orderRepository.save(foundOrder.get());
    }

    @Override
    public void removeOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

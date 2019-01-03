package com.netcracker.barkun.web.controller;

import com.netcracker.barkun.entity.OrderItem;
import com.netcracker.barkun.web.controller.dto.OrderDto;
import com.netcracker.barkun.entity.Order;
import com.netcracker.barkun.service.OrderService;
import com.netcracker.barkun.web.controller.dto.OrderItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping(path = "{id}")
    public Optional<OrderDto> get(@PathVariable("id") Long id) {
        Optional<Order> orderById = orderService.getOrderById(id);
        Optional<OrderDto> optionalOrderDto = Optional.of(OrderDto.convertFromOrder(orderById.get()));
        return optionalOrderDto;
    }

    @GetMapping
    public Iterable<OrderDto> getAll() {
        List<Order> orders = (List<Order>) orderService.getAllOrders();
        Iterable<OrderDto> dtos = orders.stream()
                .map(order -> OrderDto.convertFromOrder(order))
                .collect(Collectors.toCollection(ArrayList::new));
        return dtos;
    }

    @PostMapping
    public OrderDto save(@RequestBody OrderDto orderDto) {
        Order saveOrder = orderService.saveOrder(Order.convertFromDto(orderDto));
        return OrderDto.convertFromOrder(saveOrder);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public OrderDto addItem(@RequestBody OrderItemDto orderItemDto, @RequestParam(name = "id") Long id) {
        Order order = orderService.addItem(OrderItem.convertFromOrderItemDto(orderItemDto), id);
        return OrderDto.convertFromOrder(order);
    }


    @PutMapping
    public OrderDto update(@RequestBody OrderDto orderDto) {
        Order order = orderService.updateOrder(Order.convertFromDto(orderDto));
        return OrderDto.convertFromOrder(order);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        orderService.removeOrder(id);
    }
}

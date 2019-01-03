package com.netcracker.barkun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.barkun.web.controller.dto.OrderDto;
import com.netcracker.barkun.web.controller.dto.OrderStatusDto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class OrderStatus extends BaseEntity {

    private String title;

    @OneToMany(mappedBy = "orderStatus")
    @JsonIgnore
    private List<Order> orders;

    public OrderStatus() {
    }

    private OrderStatus(OrderStatusDto orderStatusDto) {
        this.setId(orderStatusDto.getId());
        this.title = orderStatusDto.getTitle();
    }


    public static OrderStatus convertFromOrderStatusDto(OrderStatusDto orderStatusDto) {
        return new OrderStatus(orderStatusDto);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orderList) {
        this.orders = orderList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        OrderStatus orderStatus = (OrderStatus) obj;
        return Objects.equals(title, orderStatus.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderStatusDto{");
        sb.append("tittle='").append(title).append('\'');
        sb.append(", orderList=").append(orders);
        sb.append('}');
        return sb.toString();
    }
}

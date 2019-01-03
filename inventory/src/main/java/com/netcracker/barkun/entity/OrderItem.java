package com.netcracker.barkun.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.netcracker.barkun.web.controller.dto.OrderDto;
import com.netcracker.barkun.web.controller.dto.OrderItemDto;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem extends BaseEntity {

    private String name;

    private String description;

    private Long idPrice;

    private Long idCategory;

    @ManyToOne
    @JsonIgnore
    private Order order;

    public OrderItem() {
    }

    public OrderItem(String name, String description, Long idPrice, Long idCategory, Order order) {
        this.name = name;
        this.description = description;
        this.idPrice = idPrice;
        this.idCategory = idCategory;
        this.order = order;
    }

    private OrderItem(OrderItemDto orderItemDto){
        this.setId(orderItemDto.getId());
        this.name = orderItemDto.getName();
        this.description = orderItemDto.getDescription();
        this.idPrice = orderItemDto.getIdPrice();
        this.idCategory = orderItemDto.getIdCategory();
    }

    public static OrderItem convertFromOrderItemDto(OrderItemDto orderItemDto){
        return new OrderItem(orderItemDto);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdPrice() {
        return idPrice;
    }

    public void setIdPrice(Long idPrice) {
        this.idPrice = idPrice;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        OrderItem orderItem = (OrderItem) obj;
        return Objects.equals(name, orderItem.name) &&
                Objects.equals(description, orderItem.description) &&
                Objects.equals(idPrice, orderItem.idPrice) &&
                Objects.equals(idCategory, orderItem.idCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, idCategory, idPrice);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderItem{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", idPrice=").append(idPrice);
        sb.append(", idCategory=").append(idCategory);
        sb.append(", order=").append(order);
        sb.append('}');
        return sb.toString();
    }
}

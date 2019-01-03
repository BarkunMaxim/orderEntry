package com.netcracker.barkun.web.controller.dto;


import com.netcracker.barkun.entity.OrderItem;

import java.util.Objects;
import java.util.StringJoiner;

public class OrderItemDto extends BaseDto {

    private String name;

    private String description;

    private Long idPrice;

    private Long idCategory;

    public OrderItemDto() {
    }

    private OrderItemDto(OrderItem orderItem){
        this.setId(orderItem.getId());
        this.name = orderItem.getName();
        this.description = orderItem.getDescription();
        this.idPrice = orderItem.getIdPrice();
        this.idCategory = orderItem.getIdCategory();
    }

    public static OrderItemDto covertFromOrderItem(OrderItem orderItem){
        return new OrderItemDto(orderItem);
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getIdPrice() {
        return idPrice;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDto that = (OrderItemDto) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(idPrice, that.idPrice) &&
                Objects.equals(idCategory, that.idCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, idPrice, idCategory);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderItemDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("idPrice=" + idPrice)
                .add("idCategory=" + idCategory)
                .toString();
    }
}

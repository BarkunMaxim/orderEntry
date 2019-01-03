package com.netcracker.barkun.web.controller.dto;

import com.netcracker.barkun.entity.OrderStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import com.netcracker.barkun.entity.Order;

public class OrderStatusDto extends BaseDto {

    private String title;


    public OrderStatusDto() {
    }

    private OrderStatusDto(OrderStatus orderStatus){
        this.setId(orderStatus.getId());
        this.title = orderStatus.getTitle();

    }

    public static OrderStatusDto convertFromOrderStatus(OrderStatus orderStatus){
        return new OrderStatusDto(orderStatus);
    }
    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatusDto that = (OrderStatusDto) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderStatusDto.class.getSimpleName() + "[", "]")
                .add("title='" + title + "'")
                .toString();
    }
}

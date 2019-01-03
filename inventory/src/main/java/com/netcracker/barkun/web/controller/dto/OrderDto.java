package com.netcracker.barkun.web.controller.dto;

import com.netcracker.barkun.entity.Order;
import com.netcracker.barkun.entity.OrderItem;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class OrderDto  extends BaseDto{

    private String emailCustomer;

    private BigDecimal sumPrice;

    private int itemCount;

    private Date date;

    private boolean payStatus;

    private String additionalInfo;

    private List<OrderItemDto> orderItemsDto;

    private OrderStatusDto orderStatusDto;

    public OrderDto() {
    }

    private OrderDto(Order order) {
        this.setId(order.getId());
        this.emailCustomer = order.getEmailCustomer();
        this.sumPrice = order.getSumPrice();
        this.itemCount = order.getItemCount();
        this.date = order.getDate();
        this.payStatus = order.isPayStatus();
        this.additionalInfo = order.getAdditionalInfo();
        this.orderItemsDto = convertOrderItemListFromOrderItem(order.getOrderItems());
        this.orderStatusDto = OrderStatusDto.convertFromOrderStatus(order.getOrderStatus());
    }

    private List<OrderItemDto> convertOrderItemListFromOrderItem(List<OrderItem> orderItems){
        if(orderItems != null){
           return orderItems.stream()
                    .map(orderItem -> OrderItemDto.covertFromOrderItem(orderItem))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return null;
    }
    public static OrderDto convertFromOrder(Order order){
        return new OrderDto(order);
    }


    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPayStatus() {
        return payStatus;
    }

    public void setPayStatus(boolean payStatus) {
        this.payStatus = payStatus;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<OrderItemDto> getOrderItemsDto() {
        return orderItemsDto;
    }

    public void setOrderItemsDto(List<OrderItemDto> orderItemsDto) {
        this.orderItemsDto = orderItemsDto;
    }

    public OrderStatusDto getOrderStatusDto() {
        return orderStatusDto;
    }

    public void setOrderStatusDto(OrderStatusDto orderStatusDto) {
        this.orderStatusDto = orderStatusDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return itemCount == orderDto.itemCount &&
                payStatus == orderDto.payStatus &&
                Objects.equals(emailCustomer, orderDto.emailCustomer) &&
                Objects.equals(sumPrice, orderDto.sumPrice) &&
                Objects.equals(date, orderDto.date) &&
                Objects.equals(additionalInfo, orderDto.additionalInfo) &&
                Objects.equals(orderItemsDto, orderDto.orderItemsDto) &&
                Objects.equals(orderStatusDto, orderDto.orderStatusDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailCustomer, sumPrice, itemCount, date, payStatus, additionalInfo, orderItemsDto, orderStatusDto);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderDto.class.getSimpleName() + "[", "]")
                .add("emailCustomer='" + emailCustomer + "'")
                .add("sumPrice=" + sumPrice)
                .add("itemCount=" + itemCount)
                .add("date=" + date)
                .add("payStatus=" + payStatus)
                .add("additionalInfo='" + additionalInfo + "'")
                .add("orderItemsDto=" + orderItemsDto)
                .add("orderStatusDto=" + orderStatusDto)
                .toString();
    }
}

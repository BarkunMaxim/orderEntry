package com.netcracker.barkun.entity;

import com.netcracker.barkun.web.controller.dto.OrderDto;
import com.netcracker.barkun.web.controller.dto.OrderItemDto;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@Table(name = "order_instance")
public class Order extends BaseEntity {

    private String emailCustomer;

    private BigDecimal sumPrice;

    private int itemCount;

    private Date date;

    private boolean payStatus;

    private String additionalInfo;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(Date date, boolean payStatus, String additionalInfo, List<OrderItem> orderItemsList) {
        this.date = date;
        this.payStatus = payStatus;
        this.additionalInfo = additionalInfo;
        this.orderItems = orderItemsList;
    }

    private Order(OrderDto orderDto) {
        this.setId(orderDto.getId());
        this.emailCustomer = orderDto.getEmailCustomer();
        this.sumPrice = orderDto.getSumPrice();
        this.itemCount = orderDto.getItemCount();
        this.date = orderDto.getDate();
        this.payStatus = orderDto.isPayStatus();
        this.additionalInfo = orderDto.getAdditionalInfo();
        this.orderItems = Order.convertFromOrderItemDto(orderDto.getOrderItemsDto());
        this.orderStatus = OrderStatus.convertFromOrderStatusDto(orderDto.getOrderStatusDto());
    }

    private static List<OrderItem> convertFromOrderItemDto(List<OrderItemDto> orderItemDtoList) {
        if(orderItemDtoList!=null){
            return orderItemDtoList.stream()
                    .map(orderItemDto -> OrderItem.convertFromOrderItemDto(orderItemDto))
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return null;
    }

    public static Order convertFromDto(OrderDto orderDto) {
        return new Order(orderDto);
    }


    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String idCustomer) {
        this.emailCustomer = idCustomer;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItemsList) {
        this.orderItems = orderItemsList;
    }

    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        if(orderItem.getOrder() != this){
            orderItem.setOrder(this);
        }
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Order order = (Order) obj;

        return Objects.equals(emailCustomer, order.emailCustomer) &&
                Objects.equals(sumPrice, order.sumPrice) &&
                Objects.equals(itemCount, order.itemCount) &&
                Objects.equals(date, order.date) &&
                Objects.equals(additionalInfo, order.additionalInfo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), emailCustomer, sumPrice, itemCount, date, additionalInfo);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("idCustomer=").append(emailCustomer);
        sb.append(", sumPrice=").append(sumPrice);
        sb.append(", itemCount=").append(itemCount);
        sb.append(", date=").append(date);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", dopInfo='").append(additionalInfo).append('\'');
        sb.append(", orderItemsList=").append(orderItems);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append('}');
        return sb.toString();
    }
}

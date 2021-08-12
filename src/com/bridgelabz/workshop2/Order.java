package com.bridgelabz.workshop2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    Map<FoodItem, Integer> map = new HashMap<FoodItem, Integer>();
    List<FoodItem> foodCart = new ArrayList<FoodItem>();

    enum OrderStatus {WAITING, PREPARED, DELIVERED, CANCELLED}
    enum PaymentMethod {Debit_Card, CREDIT_CARD, COD, UPI, NET_BANKING, WALLET}

    private int orderId;
    private String deliveryAddress;
    private String personName;
    private Integer quantity;
    private int totalPrice;

    private LocalTime orderTime;
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus = OrderStatus.WAITING;

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    @Override
    public String toString() {
        return "Order [foodList=" + foodCart     + ", deliveryAddress=" + deliveryAddress + ", personName=" + personName
                + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", orderTime=" + orderTime + ", map=" + map
                + ", paymentMethod=" + paymentMethod + ", orderStatus=" + orderStatus + " \n ]";
    }

}


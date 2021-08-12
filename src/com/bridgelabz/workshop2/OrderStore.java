package com.bridgelabz.workshop2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class OrderStore {
    private static OrderStore instance;
    static Set<Order> orderList = new HashSet<>();
    Scanner sc = new Scanner(System.in);

    private OrderStore() {
    }

    synchronized static OrderStore getInstance() {
        if (instance == null) {
            instance = new OrderStore();
        }
        return instance;
    }

    public void add(Order order) {
        orderList.add(order);
    }

    public void printAllOrders() {
        Stream.of(orderList).forEach(System.out::println);
    }

    public void printAllWaitingOrder() {

        orderList.stream().filter(x -> x.getOrderStatus() == Order.OrderStatus.WAITING).forEach(System.out::println);
    }

    public void printAllDeliveredOrder() {
        orderList.stream().filter(x -> x.getOrderStatus() == Order.OrderStatus.DELIVERED).forEach(System.out::println);
    }

    public void printAllPreparedOrder() {
        orderList.stream().filter(x -> x.getOrderStatus() == Order.OrderStatus.PREPARED).forEach(System.out::println);
    }

    public void printAllCancelledOrder() {
        orderList.stream().filter(x -> x.getOrderStatus() == Order.OrderStatus.CANCELLED).forEach(System.out::println);
    }

    public void cancelOrder() {
        System.out.println("Enter the order id ");
        int orderId = sc.nextInt();
        Order order = getOrder(orderId);
        if (order == null) {
            System.out.println("order not found");
        } else {
            order.setOrderStatus(Order.OrderStatus.CANCELLED);
            System.out.println("Order cancelled successful");
        }
    }

    public void updateOrderStatus() {
        System.out.println("Enter the order id ");
        int orderId = sc.nextInt();
        Order order = getOrder(orderId);
        System.out.println("1.Order Preapred 2.Order Deliverd");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> order.setOrderStatus(Order.OrderStatus.PREPARED);
            case 2 -> order.setOrderStatus(Order.OrderStatus.DELIVERED);
        }
        System.out.println("Status change successfully");
    }


    private Order getOrder(int orderId) {
        Order order = orderList.stream().filter(x -> x.getOrderId() == orderId).findFirst().orElse(null);
        if (order == null) {
            System.out.println("Order not found");
        }
        return order;
    }
}

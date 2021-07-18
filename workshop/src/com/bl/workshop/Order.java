package com.bl.workshop;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
    enum PaymentMethod {DEBIT_CARD, CREDIT_CARD, COD, UPI, NET_BANKING, WALLET}

    String deliveryAddress;
    String customerName;

    PaymentMethod paymentMethod;

    ArrayList<FoodItem> foodList = new ArrayList<>();

    Integer quantity;

    Map<FoodItem, Integer> map = new HashMap();

    int totalPrice;
    LocalTime orderTime;
}

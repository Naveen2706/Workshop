package com.bl.workshop;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    FoodManager foodManager = FoodManager.getInstance();
    OrderStore orderStore = OrderStore.getInstance();

    public static void main(String[] args) {

//        Biryani biryani = new Biryani();
//        biryani.price = 150;
//
//        AppleJuice appleJuice = new AppleJuice();
//        appleJuice.price = 25;
//
//        Dosa dosa = new Dosa();
//        dosa.price = 40;
//        PaniPuri paniPuri = new PaniPuri();
//        paniPuri.price = 30;
//
        Main main = new Main();
//        main.foodManager.add(dosa);
//        main.foodManager.add(dosa);
//        main.foodManager.add(appleJuice);
//        main.foodManager.add(biryani);
//        main.foodManager.add(paniPuri);
//
//        main.foodManager.print();

        main.sowMenu();
    }

    void sowMenu() {
        int choice = 0;
        while (choice != 10) {
            Scanner sc = new Scanner(System.in);
            System.out.print("1-show food item :: \n 2-update foodItem ::\n3-add food Item \n4-remove food item \n5-place order \n6- Print Veg Item \n7- Print All Orders \n8- print delivered Order \n9- print prepared Orders \n10 printAllWaitingOrder() \n:-> ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    foodManager.print();
                    break;
                case 2:
                    updateFoodItem();
                    break;
                case 3:
                    foodManager.addNewFooItem();
                    break;
                case 4:
                    foodManager.removeFoodItem();
                    break;
                case 5:
                    placeTheOrder();
                    break;
                case 6:
                    foodManager.printAllVegItem();
                case 7:
                    orderStore.viewAllOrder();
                    break;
                case 8:
                    orderStore.printAllDeliveredOrders();
                    break;
                case 9:
                    orderStore.printAllPreparedOrders();
                    break;
                case 10:
                    orderStore.printAllWaitingOrders();
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }
        }
    }


    void updateFoodItem() {
        boolean run = true;
        int parameter = 0;
        while (run) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter food item : ");
            String item = sc.next();
            FoodItem foodItem = foodManager.getFoodItem(item);
            System.out.println(foodItem);
            while (parameter != 5) {
                System.out.println("Enter 1-Taste 2-Prep Time, 3-name, 4-category 5-main menu");
                parameter = sc.nextInt();
                switch (parameter) {
                    case 1:
                        updateTaste(foodItem);
                        run = true;
                        break;
                    case 2:
                        updatePreparationTime(foodItem);
                        run = true;
                        break;
                    case 3:
                        updateName(foodItem);
                        run = true;
                        break;
                    case 4:
                        updateCategory(foodItem);
                        run = true;
                        break;
                    case 5:
                        run = false;
                        break;
                    default:
                        System.out.println("invalid choice");
                }
                System.out.println(foodItem);
            }
        }
    }

    private void updateCategory(FoodItem foodItem) {
        Scanner sc = new Scanner(System.in);
        System.out.println("chose from below : ");
        System.out.println("1-MAIN_COURSE 2-STARTER 3-JUICES 4-DESERT");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                foodItem.category = FoodItem.Category.MAIN_COURSE;
                break;
            case 2:
                foodItem.category = FoodItem.Category.STARTER;
                break;
            case 3:
                foodItem.category = FoodItem.Category.JUICES;
                break;
            case 4:
                foodItem.category = FoodItem.Category.DESERT;
                break;
            default:
                System.out.println("invalid choice");
        }
        System.out.println(foodItem);
    }

    private void updateName(FoodItem foodItem) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter new name : ");
        String name = sc.nextLine();
        foodItem.name = name;
        System.out.println(foodItem);
    }

    private void updateTaste(FoodItem foodItem) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose from below ");
        System.out.println("1-SPICY 2-SWEET 3-SALTY 4-SPICY_SALTY");
        System.out.print("Enter your choice : ");
        int taste = sc.nextInt();
        switch (taste) {
            case 1:
                foodItem.taste = FoodItem.Taste.SPICY;
                break;
            case 2:
                foodItem.taste = FoodItem.Taste.SWEET;
                break;
            case 3:
                foodItem.taste = FoodItem.Taste.SALTY;
                break;
            case 4:
                foodItem.taste = FoodItem.Taste.SPICY_SALTY;
            default:
                System.out.println("Enter right taste.");
        }
    }

    public void updatePreparationTime(FoodItem foodItem) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter new time : ");
        byte newTime = sc.nextByte();
        foodItem.preparationTime = newTime;

    }

    public void placeTheOrder() {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();

        System.out.println("Please enter order ID");
        order.setOrderID(scanner.nextInt());

        String name = "";
        while (!name.equalsIgnoreCase("quit")) {
            System.out.println("Please enter food name :");
            name = scanner.next().concat(scanner.nextLine());
            FoodItem foodItem = foodManager.getFoodItem(name);

            if (foodItem != null) {
                System.out.println("Please enter food quantity :");
                int quantity = scanner.nextInt();
                order.map.put(foodItem, quantity);
                System.out.println("Total amount payable : " + order.setTotalPrice());
            } else if (!name.equalsIgnoreCase("quit")) {
                System.out.println("food item not present");
            }
        }

        System.out.println("\nPlease enter customer name :");
        String customerName = scanner.next().concat(scanner.nextLine());
        order.setCustomerName(customerName);

        System.out.println("Please enter address :");
        order.setDeliveryAddress(scanner.next().concat(scanner.nextLine()));

        System.out.println("Select payment method :");
        System.out.println("1.COD, 2.CREDIT_CARD, 3.DEBIT_CARD, 4.NET_BANKING, 5.UPI, 6.WALLET");
        switch (scanner.nextInt()) {
            case 1:
                order.setPaymentMethods(Order.PaymentMethods.COD);
                break;
            case 2:
                order.setPaymentMethods(Order.PaymentMethods.CREDIT_CARD);
                break;
            case 3:
                order.setPaymentMethods(Order.PaymentMethods.DEBIT_CARD);
                break;
            case 4:
                order.setPaymentMethods(Order.PaymentMethods.NET_BANKING);
                break;
            case 5:
                order.setPaymentMethods(Order.PaymentMethods.UPI);
                break;
            case 6:
                order.setPaymentMethods(Order.PaymentMethods.WALLET);
                break;
        }

        order.setDateAndTime(new java.util.Date(System.currentTimeMillis()));
        orderStore.add(order);
        System.out.println(order);
    }

//    public void calculateTotalPrice(Order order) {
////        int totalPrice = 0;
////        Iterator iterator = order.map.entrySet().iterator();
////        while (iterator.hasNext()) {
////            Map.Entry me = (Map.Entry) iterator.next();
////            FoodItem foodItem = (FoodItem) me.getKey();
////            int quantity = (int) me.getValue( );
////            int price = (int) foodItem.price;
////            totalPrice += quantity * price;
////        }
////        order.totalPrice = totalPrice;
////        System.out.println(" Bill " + order.totalPrice);
//        order.map.entrySet().stream().map(foodItem -> (foodItem.getValue() * foodItem.getKey().price)).forEach(System.out::println);
//    }
}

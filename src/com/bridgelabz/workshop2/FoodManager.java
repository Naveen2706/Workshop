package com.bridgelabz.workshop2;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class FoodManager {
    static FoodManager instance;
    Scanner sc = new Scanner(System.in);
    Set<FoodItem> foodList = new HashSet<FoodItem>();

    FoodManager() {

    }

    public static synchronized FoodManager getInstance() {
        if (instance == null) {
            instance = new FoodManager();
        }
        return instance;
    }

    public void add(FoodItem fooditem) {
        foodList.add(fooditem);
    }

    void printMenu() {

    }

    void addFoodItem() {
        FoodItem foodItems = new FoodItem();
        System.out.println("Enter food name  ");
        foodItems.name = sc.next().concat(sc.nextLine());

        System.out.println("Enter food type");
        System.out.println("1.Veg 2.NoNVeg");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                foodItems.type = FoodItem.Type.VEG;
                break;
            case 2:
                foodItems.type = FoodItem.Type.NON_VEG;
                break;
        }
        System.out.println("enter food categoery:: 1- MAINCOURSE 2-STARTERS 3-JUICES 4-DESSERT");
        int catType = sc.nextInt();
        switch (catType) {
            case 1:
                foodItems.category = FoodItem.Category.MainCourse;
                break;
            case 2:
                foodItems.category = FoodItem.Category.Starters;
                break;
            case 3:
                foodItems.category = FoodItem.Category.Juices;
                break;
            case 4:
                foodItems.category = FoodItem.Category.Dessert;
                break;

            default:
                System.out.println("Enter right Category.");
        }
        System.out.println("Enter taste :: 1. spicy 2.salty 3.lightsugary 4.crunchy");
        int tasteChoice = sc.nextInt();
        switch (tasteChoice) {

            case 1:
                foodItems.taste = FoodItem.Taste.spicy;
                break;
            case 2:
                foodItems.taste = FoodItem.Taste.crunchy;
                break;
            case 3:
                foodItems.taste = FoodItem.Taste.salty;
                break;
            case 4:
                foodItems.taste = FoodItem.Taste.lightsugary;
                break;
        }
        System.out.println("enter preparation Time :: ");
        byte prepTime = sc.nextByte();
        foodItems.preparationTime = prepTime;

        System.out.print("Enter price :: ");
        int price = sc.nextInt();
        foodItems.price = price;
        foodList.add(foodItems);
    }

    void removeFoodItem() {
        System.out.println("Enter the food name to remove");
        String name = sc.next();
        FoodItem foodItem = getFoodItem(name);
        if (foodItem == null) {
            System.out.println(" No such item to be remove");
        } else {
            foodList.remove(foodItem);
        }
    }

    void delete(FoodItem fooditems) {
        foodList.remove(fooditems);
    }

    int getFoodCount() {
        return foodList.size();
    }

    void printAllVegItems() {

        foodList.stream().filter(foodItems -> foodItems.type.equals(FoodItem.Type.VEG))
                .forEach(System.out::println);
    }

    void printAllNonVegitems() {

        foodList.stream().filter(foodItems -> foodItems.type.equals(FoodItem.Type.NON_VEG))
                .forEach(System.out::println);
    }

    FoodItem getFoodItem(String name) {

        List<FoodItem> list = foodList.stream().filter(foodItem -> foodItem.name.equalsIgnoreCase(name)).collect(Collectors.toList());
        return list.get(0);
    }
}

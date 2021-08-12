package com.bridgelabz.workshop2;

import java.util.Objects;

public class FoodItem {

    enum Taste {spicy, salty, crunchy, lightsugary}

    enum Category {MainCourse, Starters, Juices, Dessert}

    enum Type {VEG, NON_VEG}

    Type type;
    Category category;
    Taste taste;
    float price;
    byte preparationTime;
    String name;


    @Override
    public String toString() {
        return "FoodItems [ category=" + category + ", taste=" + taste + ", price=" + price
                + ", preparationTime=" + preparationTime + ", name=" + name + "]";
    }


    @Override
    public int hashCode() {
        return Objects.hash(category, name, preparationTime, price, taste);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FoodItem other = (FoodItem) obj;
        return category == other.category && Objects.equals(name, other.name)
                && preparationTime == other.preparationTime
                && Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && taste == other.taste;
    }


}


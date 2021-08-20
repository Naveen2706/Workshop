package com.bl.workshop;

import java.util.ArrayList;
import java.util.List;

//its known as observable class
public class Subject {

    List<Observer> observerlist = new ArrayList<>();

    void register(Observer observer) {
        observerlist.add(observer);
    }

    void update(String data) {
        observerlist.stream().forEach(i -> i.onUpdate(data));
    }

    void unRegister (Observer observer){
        observerlist.remove(observer);
    }
}
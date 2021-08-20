package com.bl.workshop;

public class Observer2 implements Observer {

    @Override
    public void onUpdate(String data) {
        System.out.println(data);
    }
}
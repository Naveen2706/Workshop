package com.bl.workshop;


public class Observer1 implements Observer{

    @Override
    public void onUpdate(String data) {
        System.out.println(data);
    }
}
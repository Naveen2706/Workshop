package com.bl.workshop;

public class Main {

    public static void main(String[] args) {
        Subject sub = new Subject();
        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();

        sub.register(observer1);
        sub.register(observer2);
        sub.unRegister(observer1);
        sub.unRegister(observer2);
        sub.update("register");
    }
}
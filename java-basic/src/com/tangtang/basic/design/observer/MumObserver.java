package com.tangtang.basic.design.observer;

public class MumObserver implements Observer<Child> {

    @Override
    public void onEvent(Child child) {
        System.out.println("Mum !!! " + child.getName());
    }
}

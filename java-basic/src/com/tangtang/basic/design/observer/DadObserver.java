package com.tangtang.basic.design.observer;

public class DadObserver implements Observer<Child> {

    Dad dad;

    @Override
    public void onEvent(Child child) {
        System.out.println("Dad !!! " + child.getName());
    }
}

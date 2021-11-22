package com.tangtang.basic.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Child {

    private String name;

    public Child(String name) {
        this.name = name;
    }

    List<Observer> observers = new ArrayList<>();

    {
        observers.add(new MumObserver());
        observers.add(new DadObserver());
    }

    public void cry() {
        for (Observer observer : observers) {
            observer.onEvent(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

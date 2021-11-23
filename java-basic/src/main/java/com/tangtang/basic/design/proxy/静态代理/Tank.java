package com.tangtang.basic.design.proxy.静态代理;

import java.util.Random;

public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("Tank move");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

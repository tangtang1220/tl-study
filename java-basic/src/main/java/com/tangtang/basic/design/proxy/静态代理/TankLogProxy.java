package com.tangtang.basic.design.proxy.静态代理;

public class TankLogProxy implements Movable {

    Movable tank;

    public TankLogProxy(Movable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("Tank start moving...");
        tank.move();
        System.out.println("Tank end moving...");
    }
}

package com.tangtang.basic.design.proxy.้ๆไปฃ็;

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

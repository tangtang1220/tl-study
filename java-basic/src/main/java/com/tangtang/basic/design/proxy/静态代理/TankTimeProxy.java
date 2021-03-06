package com.tangtang.basic.design.proxy.้ๆไปฃ็;

public class TankTimeProxy implements Movable {

    Movable tank;

    public TankTimeProxy(Movable tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println("Tank moving time:" + (end - start));
    }
}

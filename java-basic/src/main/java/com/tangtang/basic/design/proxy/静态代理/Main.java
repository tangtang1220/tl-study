package com.tangtang.basic.design.proxy.้ๆไปฃ็;

public class Main {

    public static void main(String[] args) {
        Movable tank = new Tank();
        tank.move();
        System.out.println("=================================");
        TankTimeProxy timeProxy = new TankTimeProxy(new Tank());
        timeProxy.move();
        System.out.println("=================================");
        TankLogProxy logProxy = new TankLogProxy(new Tank());
        logProxy.move();
        System.out.println("=================================");
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }

}

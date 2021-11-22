package com.tangtang.basic.design.proxy.静态代理;

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

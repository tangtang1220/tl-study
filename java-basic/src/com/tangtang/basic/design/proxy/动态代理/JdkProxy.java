package com.tangtang.basic.design.proxy.动态代理;

import com.tangtang.basic.design.proxy.静态代理.Movable;
import com.tangtang.basic.design.proxy.静态代理.Tank;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy {

    public static void main(String[] args) {
        Movable tank = new Tank();
        Movable proxy = (Movable) Proxy.newProxyInstance(Movable.class.getClassLoader(), Tank.class.getInterfaces(), new TankHandler(tank));
        proxy.move();
    }
}

class TankHandler implements InvocationHandler {
    Movable movable;

    public TankHandler() {
    }

    public TankHandler(Movable movable) {
        this.movable = movable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(movable, args);
    }
}

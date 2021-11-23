package com.tangtang.basic.design.proxy.动态代理;

import com.tangtang.basic.design.proxy.静态代理.Tank;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return null;
    }

    public static void main(final String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            Object invoke = methodProxy.invokeSuper(o, objects);
            return invoke;
        });
        Tank movable = (Tank) enhancer.create();
        movable.move();
    }


}

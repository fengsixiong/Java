package com.design.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *  动态代理，实现invocationHandler
 *  重写invoke方法
 *  Proxy生成代理对象
 */
public class DynamicProxy implements InvocationHandler {

    private IProxy iProxy;
    // 不推荐使用构造方法
    public void setProxy(IProxy iProxy) {
        this.iProxy = iProxy;
    }

    // 生成代理对象
    public Object getProxy () {
        Object proxyInstance = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                this.iProxy.getClass().getInterfaces(), this);
        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(iProxy, args);
        return invoke;
    }
}

class TestMi {
    public static void main(String[] args) {
        House house = new House();
        DynamicProxy dynamicProxy = new DynamicProxy();
        dynamicProxy.setProxy(house); // 设置代理类
        IProxy proxy = (IProxy) dynamicProxy.getProxy(); // 生成动态代理类
        proxy.lease(); // 调用方法
    }
}
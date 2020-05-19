package com.design.demo.proxy;

/**
 *  代理模式：横向扩展接口，增加更多的行为，如日志
 *  1.jdk代理，实现同一个接口实现代理
 *  2.cglib,继承类来实现代理
 */
public interface IProxy {

    public void lease();    //租房

}

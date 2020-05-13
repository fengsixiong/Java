package com.design.demo.factory;

public class Iphone implements Produce, Mobile {

    @Override
    public void use() {
        System.out.println("我是爱疯手机");
    }
}

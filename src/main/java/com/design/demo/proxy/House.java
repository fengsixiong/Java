package com.design.demo.proxy;

/**
 *  房东
 */
public class House implements IProxy {


    @Override
    public void lease() {
        System.out.println("收房租");
    }
}

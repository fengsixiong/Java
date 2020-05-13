package com.design.demo.factory;

/**
 *  华为手机
 */
public class Honor implements Produce, Mobile {

    @Override
    public void use() {
        System.out.println("我是华为手机");
    }
}

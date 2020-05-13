package com.design.demo.factory;

/**
 *  类比为苹果这家公司，可以生产苹果手机、苹果电脑 ...
 */
public class AbstractAppleFactory implements AbstractFactory{
    @Override
    public Mobile getMobile() {
        return new Iphone();
    }

    @Override
    public Computer getComputer() {
        return new MacComputer();
    }
}

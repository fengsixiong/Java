package com.design.demo.factory;

/**
 * 爱疯手机工厂
 */
public class IphoneFactory implements CommonlyFactory {
    @Override
    public Produce make() {
        return new Iphone();
    }
}

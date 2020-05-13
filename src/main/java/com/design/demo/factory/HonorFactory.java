package com.design.demo.factory;

/**
 * 生产honor手机的工厂
 */
public class HonorFactory implements CommonlyFactory {
    @Override
    public Produce make() {
       return new Honor();
    }
}

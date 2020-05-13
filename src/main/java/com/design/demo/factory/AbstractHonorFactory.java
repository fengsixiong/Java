package com.design.demo.factory;

/**
 *  类比为华为这家公司，可以生产华为手机、华为电脑 ...
 */
public class AbstractHonorFactory implements AbstractFactory {
    @Override
    public Mobile getMobile() {
        return new Honor();
    }

    @Override
    public Computer getComputer() {
        return new HonorComputer();
    }
}

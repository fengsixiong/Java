package com.design.demo.builder;

public class BwmBuilder extends AbstractBuilder{

    private Car car;

    public BwmBuilder () {
        car = new Car();
    }

    @Override
    public void setSize() {
        car.setSize("100");
    }

    @Override
    public void setBrand() {
        car.setBrand("宝马");
    }

    @Override
    public void setColor() {
        car.setColor("红色");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

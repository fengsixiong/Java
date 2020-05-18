package com.design.demo.builder;

public class BenzBuilder  extends  AbstractBuilder{
    private Car car;

    public BenzBuilder () {
        car = new Car();
    }
    @Override
    public void setSize() {
        car.setSize("90");
    }

    @Override
    public void setBrand() {
        car.setBrand("奔驰");
    }

    @Override
    public void setColor() {
        car.setColor("灰色");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

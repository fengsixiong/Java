package com.design.demo.builder;

/**
 *  指挥者创建对象
 */
public class Director {

    public Car getBuilder(AbstractBuilder builder) {
        builder.setBrand();
        builder.setColor();
        builder.setSize();
        return builder.getCar();
    }

}

class TestM {
    public static void main(String[] args) {
        BenzBuilder benzBuilder = new BenzBuilder();
        Director director = new Director();
        Car car = director.getBuilder(benzBuilder);
        System.out.println(car.toString());
    }
}

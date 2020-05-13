package com.design.demo.factory;

/**
 *  抽象工厂类
 *  1.应用于一家公司生产多种不同的产品，我们将工厂类比成苹果公司，华为公司
 *  2.每个公司可以生产多个产品簇
 */
public interface AbstractFactory {
    // 生产手机这个产品簇
    public Mobile getMobile();
    // 生产电脑这个产品簇
    public Computer getComputer();

}

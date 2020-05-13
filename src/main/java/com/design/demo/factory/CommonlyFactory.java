package com.design.demo.factory;

/**
 * 一般工厂方式
 * 1.定义一个抽象工厂
 * 2.每个具体东西由自己对应的工厂创建
 *
 * 增加产品后，通过增加工厂类来实现
 */
public interface CommonlyFactory {

    Produce make();
}

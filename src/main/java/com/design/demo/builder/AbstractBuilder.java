package com.design.demo.builder;

/**
 *  建造者模式
 *  适用场景：1.相同方法，因调用顺序不同，返回不同结果
 *          2.初始化对象时参数繁多复杂
 *  实现：抽象建造者定义组装方法
 *      具体建造者实现方法
 *      指挥者调用不同建造者
 */
public abstract class AbstractBuilder {
    /**
     *  建造汽车，我们设置大小，品牌，颜色
     */
    public abstract void setSize();
    public abstract void setBrand();
    public abstract void setColor();

    public abstract Car getCar();
}

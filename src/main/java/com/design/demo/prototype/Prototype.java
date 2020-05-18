package com.design.demo.prototype;

import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  原型模式：从内存中拷贝多份数据
 *  适用场景：类初始化耗费大量资源的时候，原型模式直接从内存克隆，不会执行构造函数从而节约时间
 *
 *  拓展：HashMap的clone()会声明一个新的数组指向不同对象，但是map存储的值为对象的话，是同一个对象
 */
@Setter
@Getter
@ToString
// Data使用此注解会重写hashCode()
public class Prototype implements Cloneable {

    private String name;
    private Date date;

    public Prototype() {
        System.out.println("---我是构造方法---");
    }

    /**
     * 如果调用clone()方法不实现Cloneable会抛出CloneNotSupportedException异常
     * Object类中clone方法有说明
     * @return
     */
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        System.out.println("调用clone");
//        return super.clone();
//    }

    /**
     * 实现深拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("调用clone");
        Object clone = super.clone();
        Prototype prototype = (Prototype) clone;
        prototype.date = (Date) this.date.clone();
        return prototype;
    }
}

class TestM {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        String name = "张三";
        Date date = new Date();
        prototype.setName(name);
        prototype.setDate(date);
        System.out.println(prototype.toString() + " hashCode:" + prototype.hashCode());
        // clone 浅拷贝，不同对象指向同一块内存
        Prototype clone = (Prototype) prototype.clone();
        System.out.println(clone.toString() + " hashCode:" + clone.hashCode());
        System.out.println("===========");
        // 改变值,浅拷贝时间一致，深拷贝时间值不同
        date.setTime(999999999);
        System.out.println(prototype.toString() + " hashCode:" + prototype.hashCode());
        System.out.println(clone.toString() + " hashCode:" + clone.hashCode());
    }
}

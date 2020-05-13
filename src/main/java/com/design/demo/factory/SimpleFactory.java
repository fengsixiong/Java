package com.design.demo.factory;

/**
 *  简单工厂模式
 *  1.具体东西实现产品抽象类
 *  2.工厂返回需要的东西
 */
public class SimpleFactory {

    public Produce getInstance(String str) {
        if (str.equals("1")) {
            return new Honor();
        } else if (str.equals("2")) {
            return new Iphone();
        }
        return null;
    }
}

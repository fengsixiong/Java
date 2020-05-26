package com.design.demo.facade;

/**
 *  外观模式，客户端统一调用外观类，不需要与具体方法打交道
 */
public class Facade {

    private Subone subone;
    private Subtwo subtwo;

    public Facade() {
        this.subone = new Subone();
        this.subtwo = new Subtwo();
    }

    public void bulk() {
        subone.start();
        subtwo.stop();
    }

}

class Subone {

    public void start() {
        System.out.println(" 开始.");
    }

}

class Subtwo {
    public void stop() {
        System.out.println(" 结束.");
    }
}

class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.bulk();
    }
}

package com.design.demo.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 策略模式：消除大量的if-else
 * afterPropertiesSet()会在spring读取bean配置后init-method之前执行
 */
//
//interface Strategy1 extends InitializingBean {
//
//    void doPlay();
//
//}

// 当我们没中策略执行方法不同时,我们可以将interface改成abstract,
// 增加模版方法设计模式,方法中抛出方法不支持异常
public abstract class Strategy implements InitializingBean {

    public void doPlay() {
        throw new UnsupportedOperationException();
    }

    public void doDrow() {
        throw new UnsupportedOperationException();
    }
}

class test {
    public static void main(String[] args) {
        String name = "张三";
        if (name.equals("张三")) {
            System.out.println("张三打酱油");
        } else if (name.equals("李四")) {
            System.out.println("李四去打醋");
        }
        // ...
        // 简化后,后续策略增加只需要增加实现类
        // 交给Spring管理的类不能直接测试
//        StrateFactory.getStrate(name).doPlay();
//        StrateFactory.getStrate(name).doDrow();

    }
}
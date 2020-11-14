package com.design.demo.example;

import org.springframework.stereotype.Component;

// 李四策略
@Component
class Vinegar extends Strategy {

    //    @Override
    public void doPlay() {
        System.out.println("李四去打醋");
    }

    public void doDrow() {
        System.out.println("画画的baby");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StrateFactory.setStrate("李四", this);
    }
}

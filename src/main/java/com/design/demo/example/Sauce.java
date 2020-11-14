package com.design.demo.example;

import org.springframework.stereotype.Component;

// 张三策略,将bean交给spring管理
@Component
class Sauce extends Strategy {

    //    @Override
    public void doPlay() {
        System.out.println("张三打酱油");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        StrateFactory.setStrate("张三", this);
    }
}

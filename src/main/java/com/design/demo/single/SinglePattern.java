package com.design.demo.single;

/**
 *  单例模式
 *  1.静态实例私有化
 *  2.构造方法私有化
 *  3.公共静态方法返回实例化对象
 */
public class SinglePattern {

    /**
     *  饿汉式
     */
    static class Hangry {

        private static Hangry instance = new Hangry();

        private Hangry() {}

        public static Hangry getInstance() {
            return instance;
        }
    }

    /**
     *  懒汉式
     */
    static class Lazy {

        private volatile static Lazy instance = null;

        private Lazy() {}

        public static Lazy getInstance() {
            if (instance == null) {
                synchronized (Lazy.class) {
                    if (instance == null) {
                        instance = new Lazy();
                    }
                }
            }
            return instance;
        }
    }
}

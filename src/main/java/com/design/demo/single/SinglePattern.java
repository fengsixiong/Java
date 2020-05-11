package com.design.demo.single;

import java.io.*;
import java.lang.reflect.Constructor;

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
        /**
         *  use volatile cause
         *  new Lazy() 实例过程
         *  1.分配内存空间
         *  2.执行构造方法,初始化对象
         *  3.对象指向内存空间
         *  如果执行132,实例返回null
         */
        private volatile static Lazy instance;

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

    /**
     *  静态内部类
     */
    static class innerClass {

        private innerClass () {}

        public static innerClass getInstance() {
            return innerStaticClass.instance;
        }

        static class innerStaticClass {
            private static final innerClass instance = new innerClass();
        }
    }

    /**
     * 1.反射可以破解类
     * 2.序列化和反序列化
     * 3.clone
     */
    public static void main(String[] args) throws Exception {

        Constructor<Lazy> lazyConstructor = Lazy.class.getDeclaredConstructor();
        lazyConstructor.setAccessible(true);
        Lazy lazy = lazyConstructor.newInstance();
        System.out.println(lazy + " --- " + Lazy.getInstance());

        Lazy instance = Lazy.getInstance();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:\\test.txt"));
        out.writeObject(instance);
        out.flush();
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:\\test.txt"));
        Lazy inLazy = (Lazy) in.readObject();
        System.out.println(inLazy + " --- " + Lazy.getInstance());

    }

    /**
     *  避免反射和序列化
     *  1.在构造方法中抛出运行时异常
     *  2.实现Serializable,readResolve()方法
     */
    static class SingleSecy implements Serializable{

        private static boolean SINGLE_PARAMER = false;

        private volatile static SingleSecy instance;

        private SingleSecy() {
            synchronized (SingleSecy.class) {
                if (SINGLE_PARAMER == false) {
                    SINGLE_PARAMER = true;
                } else {
                    throw new RuntimeException("拒绝反射");
                }
            }
        }

        public static SingleSecy getInstance() {
            if (instance == null) {
                synchronized (SingleSecy.class) {
                    if (instance == null) {
                        instance = new SingleSecy();
                    }
                }
            }
            return instance;
        }
        // 在反序列化时,如果有readResolve()方法,则直接返回此方法对象
        private Object readResolve() {
            return instance;
        }
    }

}

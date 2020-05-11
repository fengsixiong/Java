package com.design.demo.single;

import java.lang.reflect.Constructor;

/**
 * 枚举实现单例,枚举本身也是一个class
 */
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}

/**
 * 为什么枚举实现单例是安全的，我们试试反射的结果
 */
class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(EnumSingle.INSTANCE + " --- " + EnumSingle.INSTANCE); // true
        // 在target下可以看到无参构造方法
        // Exception in thread "main" java.lang.NoSuchMethodException: com.design.demo.single.EnumSingle.<init>()
//        Constructor<EnumSingle> enumSingleConstructor = EnumSingle.class.getDeclaredConstructor();
//        enumSingleConstructor.setAccessible(true);
//        EnumSingle enumSingle = enumSingleConstructor.newInstance();
//        System.out.println(enumSingle.equals(EnumSingle.INSTANCE));
        // 查看反射newInstance()方法看到if ((clazz.getModifiers() & Modifier.ENUM) != 0)
        //            throw new IllegalArgumentException("Cannot reflectively create enum objects");
        // 和此处异常不同！！！ 通过反编译EnumSingle.class可以看到构造方法为EnumSingle(String s, Int i) {}
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle enumSingle = declaredConstructor.newInstance();
        // Exception in thread "main" java.lang.IllegalArgumentException: Cannot reflectively create enum objects
        // 和预期一致
        System.out.println(enumSingle.equals(EnumSingle.INSTANCE));

    }
}

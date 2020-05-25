package com.design.demo.decorate;

/**
 *  抽象类，定义拍照功能
 */
public abstract class AbstractDecorate {

    abstract void look();
}

// 被装饰者实现具体功能
class Camera extends AbstractDecorate {

    @Override
    void look() {
        System.out.println(" 调用拍照.");
    }
}

// 抽象一个装饰者
abstract class Decorate extends AbstractDecorate {

    AbstractDecorate decorate;
    public Decorate(AbstractDecorate decorate) {
        this.decorate = decorate;
    }
    //  ... 可实现别的功能
}

// 美颜装饰者
class Beauty extends Decorate {
    public Beauty(Camera decorate) {
        super(decorate);
    }

    @Override
    void look() {
        System.out.println(" 添加美颜");
        decorate.look();
    }
}

// 滤镜装饰者
class Filter extends Decorate {
    public Filter(AbstractDecorate decorate) {
        super(decorate);
    }

    @Override
    void look() {
        System.out.println(" 添加滤镜.");
        decorate.look();
    }
}

class TestM {
    public static void main(String[] args) {
        Camera camera = new Camera();
        camera.look();
        System.out.println(" ---");
        Beauty beauty = new Beauty(camera);
        beauty.look();
        System.out.println(" ---");
        Filter filter = new Filter(beauty);
        filter.look();
    }
}
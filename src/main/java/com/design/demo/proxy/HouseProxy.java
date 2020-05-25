package com.design.demo.proxy;

/**
 *  房东委托中介找人租房
 */
public class HouseProxy implements IProxy {

    private House house;

    public HouseProxy() {
        this.house = new House();
    }

    public void search() {
        System.out.println("找房源");
    }

    public void see() {
        System.out.println("看房子");
    }

    @Override
    public void lease() {
        this.search();
        this.see();
        house.lease();
        System.out.println("租房子收手续费");
    }
}

class TestM{
    public static void main(String[] args) {
        HouseProxy houseProxy = new HouseProxy();
        houseProxy.lease();
    }
}

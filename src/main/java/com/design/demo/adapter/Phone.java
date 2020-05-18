package com.design.demo.adapter;

public class Phone {

    public void charge(IAdapter adapter) {
        adapter.tranToTpc();
        System.out.println("手机正在充电");
    }
}

class TestM {
    /**
     *  手机需要充电，连接不上usb
     *  我们就去找一个转接头
     *  手机接转接头，转接头接usb
     * @param args
     */
    public static void main(String[] args) {
        Phone phone = new Phone();
        Usb usb = new Usb();
        IAdapter adapter = new TpcAdapter(usb);

        phone.charge(adapter);
    }
}
package com.design.demo.adapter;

/**
 *  适配器连接usb
 */
public class TpcAdapter implements IAdapter {

    private Usb usb;

    public TpcAdapter(Usb usb) {
        this.usb = usb;
    }

    @Override
    public void tranToTpc() {
        usb.use();
        System.out.println("使用转接头");
    }
}

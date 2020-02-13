package org.thor.javademo.concurrent.cap4.template;

import java.util.Date;

/**
 * 模板方法的父类
 */
public abstract class SendCustom {

    public abstract void to();

    public abstract void from();

    public abstract void content();

    public void date() {
        System.out.println(new Date());
    }

    public abstract void send();

    /**
     * 框架方法-模板方法
     */
    public void sendMessage() {
        to();
        from();
        content();
        date();
        send();
    }

}

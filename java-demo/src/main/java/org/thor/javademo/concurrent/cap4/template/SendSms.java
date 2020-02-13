package org.thor.javademo.concurrent.cap4.template;

/**
 * 模板方法的派生类
 */
public class SendSms extends SendCustom {

    @Override
    public void to() {
        System.out.println("Mark");

    }

    @Override
    public void from() {
        System.out.println("Bill");

    }

    @Override
    public void content() {
        System.out.println("Hello world");

    }

    @Override
    public void send() {
        System.out.println("Send sms");

    }

    public static void main(String[] args) {
        SendCustom sendC = new SendSms();
        sendC.sendMessage();
    }

}

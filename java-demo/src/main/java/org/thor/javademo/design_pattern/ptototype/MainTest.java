package org.thor.javademo.design_pattern.ptototype;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.ptototype
 * 功能说明：<br>
 * 开发人员：Wangyq
 * 创建时间： 2019-02-18 10:17
 * 系统版本：1.0.0
 **/

public class MainTest {
    public static void main(String[] args) {
        Manager manager = new Manager();

        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox mbox=new MessageBox('*');
        MessageBox sbox=new MessageBox('/');

        manager.register("Strong message", underlinePen);
        manager.register("Waring Box", mbox);
        manager.register("Slash Box", sbox);

        Product p1=manager.create("Strong message");
        p1.use("hello world");
        Product p2=manager.create("Waring Box");
        p2.use("hello world");
        Product p3=manager.create("Slash Box");
        p3.use("hello world");

    }
}
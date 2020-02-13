package org.thor.javademo.thread.notyfy_wait;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.notyfy_wait
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-08-19 上午8:29
 * 系统版本：1.0.0
 **/

public class MainTest {
    public static void main(String[] args) {

        try {
            Object lock = new Object();

            Thread a = new ThreadA(lock);
            a.start();

            Thread.sleep(50);


            Thread b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

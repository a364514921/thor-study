package org.thor.javademo.thread.lesson_2_3;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_2_3
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-18 上午9:40
 * 系统版本：1.0.0
 **/

public class ThreadMain {
    public static void main(String[] args) {
        ThreadB task = new ThreadB();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandlerThreadB());
        thread.start();
    }
}

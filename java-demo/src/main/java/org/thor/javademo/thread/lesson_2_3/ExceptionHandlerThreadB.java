package org.thor.javademo.thread.lesson_2_3;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_2_3
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-18 上午9:33
 * 系统版本：1.0.0
 **/

public class ExceptionHandlerThreadB implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has benn capture\n");
        System.out.printf("Thread: %s\n", t.getId());
        System.out.printf("Exception: %s: %s\n", e.getClass().getName(), e.getMessage());
        System.out.println("Stack Trace:\n");

        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s ", t.getState());
    }
}

package org.thor.javademo.thread.lesson_2_2;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-17 上午6:43
 * 系统版本：1.0.0
 **/

public class ThreadMain {
    public static void main(String[] args) {
        ThreadB threadB = new ThreadB();

        for (int i = 0; i < 5; i++) {
            new Thread(threadB, "线程名称：（" + i + "）").start();
        }

        //返回对当前正在执行的线程对象的引用。此处获得我们主线程
        Thread threadMain = Thread.currentThread();
        System.out.println("这是主线程：");

        System.out.println("这是线程名称：" + threadMain);
        System.out.println("返回当前线程" + threadMain + "的线程中活动线程的数目" + Thread.activeCount());
        System.out.println("返回当前线程" + threadMain + "的标识符" + threadMain.getId());
        System.out.println("返回当前线程" + threadMain + "的优先级" + threadMain.getPriority());
        System.out.println("返回当前线程" + threadMain + "的状态" + threadMain.getState());
        System.out.println("返回当前线程" + threadMain + "的所属线程" + threadMain.getThreadGroup());
        System.out.println("返回当前线程" + threadMain + "的是否处于活动状态" + threadMain.isAlive());
        System.out.println("返回当前线程" + threadMain + "测试该线程是否为守护线程" + threadMain.isDaemon());

        try {
            Thread.sleep(10 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

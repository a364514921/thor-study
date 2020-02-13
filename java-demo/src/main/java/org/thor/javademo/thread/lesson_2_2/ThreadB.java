package org.thor.javademo.thread.lesson_2_2;

/**
 * 实现Runnable来创建线程
 * 模块名称：StudyJava com.wyq.studyjava.thread
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-17 上午6:23
 * 系统版本：1.0.0
 **/

public class ThreadB implements Runnable {

    @Override
    public void run() {
        try {
            //模拟做事情执行了100s,以便一会我们的监控工具监控到
            Thread.sleep(100 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread curThread = Thread.currentThread();
        String curThreadName = curThread.getName();
        System.out.println("这是线程名称：" + curThreadName);
        System.out.println("返回当前线程"+curThreadName+"的线程中活动线程的数目"+Thread.activeCount());
        System.out.println("返回当前线程"+curThreadName+"的标识符"+curThread.getId());
        System.out.println("返回当前线程"+curThreadName+"的优先级"+curThread.getPriority());
        System.out.println("返回当前线程"+curThreadName+"的状态"+curThread.getState());
        System.out.println("返回当前线程"+curThreadName+"的所属线程"+curThread.getThreadGroup());
        System.out.println("返回当前线程"+curThreadName+"的是否处于活动状态"+curThread.isAlive());
        System.out.println("返回当前线程"+curThreadName+"测试该线程是否为守护线程"+curThread.isDaemon());


    }
}

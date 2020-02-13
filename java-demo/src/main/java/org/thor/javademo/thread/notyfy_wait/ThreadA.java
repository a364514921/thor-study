package org.thor.javademo.thread.notyfy_wait;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.notyfy_wait
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-08-19 上午8:18
 * 系统版本：1.0.0
 **/

public class ThreadA extends Thread {
    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();

        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin" + System.currentTimeMillis());

                    lock.wait();

                    System.out.println("wait end" + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

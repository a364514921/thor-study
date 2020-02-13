package org.thor.javademo.thread.notyfy_wait;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.notyfy_wait
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-08-19 上午8:23
 * 系统版本：1.0.0
 **/

public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        super.run();
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        lock.notify();
                        System.out.println("已发出通知");
                    }

                    System.out.println("添加了" + (i + 1) + "个元素");

                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

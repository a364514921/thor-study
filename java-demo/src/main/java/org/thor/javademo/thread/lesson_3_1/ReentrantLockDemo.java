package org.thor.javademo.thread.lesson_3_1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_3_1
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-18 上午11:19
 * 系统版本：1.0.0
 **/

public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Count count = new Count();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    count.put();
                }
            }.start();
        }
    }

    static class Count {
        final ReentrantLock lock = new ReentrantLock();


        public void get() {

            try {
                //加锁
                lock.lock();

                System.out.println(Thread.currentThread().getName() + " read begin");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " read end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //解锁
                lock.unlock();
            }


        }

        public void put() {

            try {
                //加锁
                lock.lock();

                System.out.println(Thread.currentThread().getName() + " write begin");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " write end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //解锁
                lock.unlock();
            }
        }
    }

}

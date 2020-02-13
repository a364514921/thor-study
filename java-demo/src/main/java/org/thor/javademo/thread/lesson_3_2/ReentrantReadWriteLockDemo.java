package org.thor.javademo.thread.lesson_3_2;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_3_2
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-18 下午1:31
 * 系统版本：1.0.0
 **/

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        final Count count = new Count();

        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    count.read();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    count.write();
                }
            }.start();
        }
    }

    static class Count {
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


        public void read() {

            try {
                //加读锁
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " read begin");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " read end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //解锁
                readWriteLock.readLock().unlock();
            }


        }

        public void write() {

            try {
                //加锁
                readWriteLock.writeLock().lock();

                System.out.println(Thread.currentThread().getName() + " write begin");
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " write end");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //解锁
                readWriteLock.writeLock().unlock();
            }
        }
    }

}

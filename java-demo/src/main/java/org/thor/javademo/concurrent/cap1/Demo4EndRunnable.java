package org.thor.javademo.concurrent.cap1;

/**
 * @Description: 安全终止线程Demo
 * @Author: wangyiqiang
 * @Date: 2020-02-07 下午1:02
 * @Version: V1.0
 */
public class Demo4EndRunnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable endRunnable = new UseRunnable();
        Thread endThread = new Thread(endRunnable);
        endThread.start();

        Thread.sleep(20);

        // 中断线程
        endThread.interrupt();
    }

    /**
     * 终止线程
     */
    public static class UseRunnable implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(threadName + " is run!");
            }

            System.out.println(threadName + "interrupt flag is " + Thread.currentThread().isInterrupted());
        }
    }
}

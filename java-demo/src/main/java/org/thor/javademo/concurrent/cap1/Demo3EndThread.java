package org.thor.javademo.concurrent.cap1;

/**
 * @Description: 安全终止线程Demo
 * @Author: wangyiqiang
 * @Date: 2020-02-07 下午1:02
 * @Version: V1.0
 */
public class Demo3EndThread {
    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();

        Thread.sleep(20);

        // 中断线程
        endThread.interrupt();
    }

    /**
     * 终止线程
     */
    public static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            while (!isInterrupted()) {
                System.out.println(threadName + " is run!");
            }

            System.out.println(threadName + "interrupt flag is " + isInterrupted());
        }
    }
}

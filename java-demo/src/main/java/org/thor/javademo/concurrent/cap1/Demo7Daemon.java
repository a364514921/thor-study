package org.thor.javademo.concurrent.cap1;

import java.util.concurrent.ExecutionException;

/**
 * @Description: 类说明：守护线程的使用和守护线程中的finally语句块
 * @Author: wangyiqiang
 * @Date: 2020-02-07 下午3:42
 * @Version: V1.0
 */
public class Demo7Daemon {
    private static class UseThread extends Thread {
        @Override
        public void run() {
            try {
                while (!isInterrupted()) {
                    System.out.println(Thread.currentThread().getName()
                            + " I am extends Thread.");
                }
                System.out.println(Thread.currentThread().getName()
                        + " interrupt flag is " + isInterrupted());
            } finally {
                System.out.println("...........finally");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UseThread useThread = new UseThread();
        useThread.setDaemon(true);
        useThread.start();
        Thread.sleep(5);
//        useThread.interrupt();
    }
}

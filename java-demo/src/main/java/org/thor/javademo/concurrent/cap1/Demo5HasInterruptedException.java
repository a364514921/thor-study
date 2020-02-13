package org.thor.javademo.concurrent.cap1;

/**
 * @Description: 安全终止线程Demo
 * @Author: wangyiqiang
 * @Date: 2020-02-07 下午1:02
 * @Version: V1.0
 */
public class Demo5HasInterruptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread endThread = new UseThread("endThread");
        endThread.start();

        Thread.sleep(2000);

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
                System.out.println(threadName + " is run! isInterrupted: "+isInterrupted());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {

                    /*
                    方法里如果抛出InterruptedException，线程的中断标志位会被复位成false，
                    如果确实是需要中断线程，要求我们自己在catch语句块里再次调用interrupt()
                     */
                    interrupt();
                    e.printStackTrace();
                }
            }

            System.out.println(threadName + "interrupt flag is " + isInterrupted());
        }
    }
}

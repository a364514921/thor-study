package org.thor.javademo.concurrent.cap1;


import org.thor.javademo.concurrent.tools.SleepTools;

/**
 * 类说明：演示violate无法提供操作的原子性
 */
public class Demo10VolatileUnsafe {

    private static class VolatileVar implements Runnable {

        private volatile int a = 0;

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            a = a++;
            System.out.println(threadName + ":======" + a);
            SleepTools.ms(100);
            a = a + 1;
            System.out.println(threadName + ":======" + a);
        }
    }

    public static void main(String[] args) {

        VolatileVar v = new VolatileVar();

        Thread t1 = new Thread(v);
        Thread t2 = new Thread(v);
        Thread t3 = new Thread(v);
        Thread t4 = new Thread(v);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

package org.thor.javademo.concurrent.cap1;

/**
 * @Description: 同步锁
 * @Author: wangyiqiang
 * @Date: 2020-02-07 下午3:48
 * @Version: V1.0
 */
public class Demo8Sync {
    /**
     * 初始值
     */
    private int age = 100000;

    public static class TestThread extends Thread {
        private Demo8Sync demo8Sync;

        public TestThread(Demo8Sync demo8Sync, String name) {
            super(name);
            this.demo8Sync = demo8Sync;
        }

        @Override
        public void run() {
            // 递增 100000
            for (int i = 0; i < 100000; i++) {
                demo8Sync.test();
            }

            System.out.println(Thread.currentThread().getName() + "age = " + demo8Sync.getAge());
        }
    }

    public synchronized void test() {
        age++;
        test2();
    }

    public synchronized void test2() {
        {
            age--;
        }
    }


    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Demo8Sync demo8Sync = new Demo8Sync();
        Thread testThread = new TestThread(demo8Sync, "testThread");
        testThread.start();

        for (int i = 0; i < 100000; i++) {
            //递减100000
            demo8Sync.test2();
        }
        System.out.println(Thread.currentThread().getName() + " age =  " + demo8Sync.getAge());
    }
}

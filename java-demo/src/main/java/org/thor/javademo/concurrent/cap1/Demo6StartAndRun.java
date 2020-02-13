package org.thor.javademo.concurrent.cap1;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-07 下午3:16
 * @Version: V1.0
 */
public class Demo6StartAndRun {
    public static void main(String[] args) {
        ThreadRun beCalled = new ThreadRun();
        beCalled.setName("BeCalled");
        //beCalled.setPriority(newPriority);
//        beCalled.run();

        beCalled.start();
    }

    private static class ThreadRun extends Thread {
        @Override
        public void run() {
            int i = 90;
            while (i > 0) {
                System.out.println("I am " + Thread.currentThread().getName()
                        + " and now the i=" + i--);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

package org.thor.javademo.thread.lesson_2_1;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_2_1
 * 功能说明：ThreadLocal<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-18 上午7:00
 * 系统版本：1.0.0
 **/

public class ThreadMain {

    //1.通过匿名内部类覆盖ThreadLocal的initialValue方法，制定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    public ThreadLocal<Integer> getThreadLocal() {
        return seqNum;
    }

    //2.获取下个序列值
    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        ThreadMain sn = new ThreadMain();
        TestClient tc1 = new TestClient(sn);
        TestClient tc2 = new TestClient(sn);
        TestClient tc3 = new TestClient(sn);
        tc1.start();
        tc2.start();
        tc3.start();
    }

    private static class TestClient extends Thread {
        private ThreadMain sn;

        public TestClient(ThreadMain sn) {
            this.sn = sn;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                // 4.每个线程打印出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn{" + sn.getNextNum() + "]");
            }
            //每个线程用完的时候要记得删除
            sn.getThreadLocal().remove();
        }
    }


}

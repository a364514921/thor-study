package org.thor.javademo.thread.lesson_5_1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.lesson_5_1
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-07-19 下午8:11
 * 系统版本：1.0.0
 **/

public class BlockingQueueTest {
    public static void main(String[] args) {
        final BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(16);

        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String log = blockingQueue.take();
                            parseLog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        for (int i = 0; i < 16; i++) {
            try {
                String log = (i + 1) + "-->";
                blockingQueue.put(log);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void parseLog(String log) {
        System.out.println(log + System.currentTimeMillis());

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {

            e.printStackTrace();

        }
    }
}

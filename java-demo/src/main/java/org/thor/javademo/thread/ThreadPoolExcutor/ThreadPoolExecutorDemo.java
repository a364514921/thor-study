package org.thor.javademo.thread.ThreadPoolExcutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 模块名称：StudyJava com.wyq.studyjava.thread.ThreadPoolExcutor
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2018-09-05 下午3:24
 * 系统版本：1.0.0
 **/

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        //创建一个FixedThreadPool对象
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new WorkerThread("" + i);
            //执行Runnable
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        //isShutdown（）表示执行程序正在关闭，但并非所有任务都已完成执行。
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");


    }
}

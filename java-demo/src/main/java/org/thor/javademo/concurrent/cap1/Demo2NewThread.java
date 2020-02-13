package org.thor.javademo.concurrent.cap1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description: 新建线程的三种方式
 * @Author: wangyiqiang
 * @Date: 2020-02-07 上午11:20
 * @Version: V1.0
 */
public class Demo2NewThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 继承Thread
        UseThread useThread = new UseThread();
        useThread.start();

        // 实现Runnable
        UseRun useRun = new UseRun();
        new Thread(useRun).start();

        // 实现Callable
        UseCallable useCallable = new UseCallable();
        // 封装callable成FutureTask
        FutureTask<String> futureTask = new FutureTask<>(useCallable);
        new Thread(futureTask).start();
        String callResult = futureTask.get();
        System.out.println("callResult: " + callResult);
    }

    /**
     * 继承Thread类
     */
    private static class UseThread extends Thread {
        // 重写run方法
        @Override
        public void run() {
            System.out.println("I am extends Thread");
        }
    }


    /**
     * 实现Runable接口
     */
    private static class UseRun implements Runnable {

        @Override
        public void run() {
            System.out.println("I am implements Runnable");
        }
    }

    /**
     * 实现Callable接口，允许有返回值
     */
    private static class UseCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("I am implements Callable");
            return "I am callResult";
        }
    }
}

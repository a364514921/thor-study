package org.thor.javademo.functioninterface.demo03.lambdaTest;

/**
 * @Description: 例如java.lang.Runnable接口就是一个函数式接口，
 * 假设有一个startThread方法使用该接口作为参数，那么就可以使用Lambda进行传参。
 * 这种情况其实和Thread类的构造方法番薯为Runnable没有本质区别
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午12:37
 * @Version: V1.0
 */
public class Demo01LambdaTest {
    public static void main(String[] args) {
        // 调用startThread方法，方法的参数是一个接口，那么我们可以传递这个接口的匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-->" + "线程启动了");
            }
        });

        // 调用startThread方法，方法的参数是一个函数式接口，所以可以传递Lambda表达式
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "-->" + "线程启动了");
        });

        // 优化Lambda表达式
        startThread(() -> System.out.println(Thread.currentThread().getName() + "-->" + "线程启动了"));
    }

    /**
     * 开启县城，方法参数使用函数式接口Runnable
     *
     * @param run
     */
    public static void startThread(Runnable run) {
        // 开启多线程
        new Thread(run).start();
    }
}

package org.thor.javademo.concurrent.cap2.tools;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

/**
 * 类说明：Exchange的使用
 */
public class UseExchange {
    private static final Exchanger<Set<String>> exchange = new Exchanger<Set<String>>();

    public static void main(String[] args) {

        // 第一个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> setA = new HashSet<String>();//存放数据的容器
                try {
                    /*添加数据
                     * set.add(.....)
                     * */
                    setA = exchange.exchange(setA);//交换set
                    /*处理交换后的数据*/
                } catch (InterruptedException e) {
                }
            }
        }).start();

        // 第二个线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                Set<String> setB = new HashSet<String>();//存放数据的容器
                try {
                    /*添加数据
                     * set.add(.....)
                     * set.add(.....)
                     * */
                    setB = exchange.exchange(setB);//交换set
                    /*处理交换后的数据*/
                } catch (InterruptedException e) {
                }
            }
        }).start();

    }
}

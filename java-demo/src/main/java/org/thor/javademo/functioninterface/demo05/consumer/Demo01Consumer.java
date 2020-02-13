package org.thor.javademo.functioninterface.demo05.consumer;

import cn.hutool.core.util.StrUtil;

import java.util.function.Consumer;

/**
 * @Description: java.util.function.Consumer<T> 接口则正好与Supplier接口相反，它不是生产一个数据，而是消费一个数据， 其数据类型由泛型决定。
 * Consumer 接口中包含抽象方法 void accept(T t) ，意为消费一个指定泛型的数据。
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午1:57
 * @Version: V1.0
 */
public class Demo01Consumer {
    public static void main(String[] args) {
        String name = "刘德华";
        consumeString(name, str -> {
            // 消费方式直接输出字符串
            System.out.println(name);

            // 字符串进行反转输出
            System.out.println(StrUtil.reverse(name));
        });
    }

    /**
     * 可以使用Consumer接口消费字符串的姓名
     *
     * @param name     姓名
     * @param consumer Consumer函数式接口
     */
    public static void consumeString(String name, Consumer<String> consumer) {
        consumer.accept(name);
    }
}

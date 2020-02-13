package org.thor.javademo.functioninterface.demo05.consumer;

import java.util.function.Consumer;

/**
 * @Description:Consumer接口默认方法andThen 作用：需要两个Consumer接口，可以把两个Consumer接口组合到一起，再对数据进行消费
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午2:13
 * @Version: V1.0
 */
public class Demo02AndThen {
    public static void main(String[] args) {
        method("Liu Dehua",
                (str) -> System.out.println(str.toUpperCase()),
                (str) -> System.out.println(str.toLowerCase())
        );
    }

    /**
     * 消费方法
     * @param str 字符串
     * @param con1 Consumer接口1
     * @param con2 Consumer接口2
     */
    public static void method(String str, Consumer<String> con1, Consumer<String> con2) {
        // 分开消费
//        con1.accept(str);
//        con2.accept(str);

        // 使用andThen，把两个Consumer接口连接到一起，再消费数据 注：谁写前面谁先消费
        con1.andThen(con2).accept(str);
//        con2.andThen(con1).accept(str);
    }
}

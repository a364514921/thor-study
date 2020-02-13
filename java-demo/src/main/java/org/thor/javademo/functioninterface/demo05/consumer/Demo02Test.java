package org.thor.javademo.functioninterface.demo05.consumer;

import java.util.function.Consumer;

/**
 * @Description:下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来。
 * 要求将打印姓 名的动作作为第一个 Consumer 接口的Lambda实例，将打印性别的动作作为第二个 Consumer 接口的Lambda实 例，
 * 将两个 Consumer 接口按照顺序“拼接”到一起。
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午2:35
 * @Version: V1.0
 */
public class Demo02Test {
    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        for (String str : array) {
            String[] arr = str.split(",");
            method(str,
                    (msg) -> {
                        String name = arr[0];
                        System.out.print("姓名：" + name + "。");
                    },
                    (msg) -> {
                        String sex = arr[1];
                        System.out.println("性别：" + sex + "。");
                    });
        }
    }

    /**
     * 消费方法
     *
     * @param str  字符串
     * @param con1 Consumer接口1
     * @param con2 Consumer接口2
     */
    public static void method(String str, Consumer<String> con1, Consumer<String> con2) {
        con1.andThen(con2).accept(str);
    }
}

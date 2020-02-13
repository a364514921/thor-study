package org.thor.javademo.functioninterface.demo04.supplier;

import java.util.function.Supplier;

/**
 * @Description:常用的函数式接口 java.util.function.Supplier<T>接口仅包含一个无参方法：T get()。用来获取一个范性参数制定类型的对象数据
 * Supplier<T> 接口被称之为生产型接口，制定接口的范性是什么，那么接口中的get方法就会产生什么数据类型
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午1:31
 * @Version: V1.0
 */
public class Demo01Supplier {
    public static void main(String[] args) {
        // 生产一个字符串并返回
        String str = getString(() -> "王小强");
        System.out.println(str);
    }

    public static String getString(Supplier<String> sup) {
        return sup.get();
    }
}

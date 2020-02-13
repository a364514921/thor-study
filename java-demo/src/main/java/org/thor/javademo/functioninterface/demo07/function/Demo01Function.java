package org.thor.javademo.functioninterface.demo07.function;

import java.util.function.Function;

/**
 * @Description: java.util.function.Function<T, R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件， 后者称为后置条件。
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午4:05
 * @Version: V1.0
 */
public class Demo01Function {
    public static void main(String[] args) {
        String num = "28";
        Integer result = method(num, str -> Integer.parseInt(num));
        System.out.println("result：" + result);
    }

    /**
     * 使用Function接口中的方法apply，把字符串类型的整数转换为Integer整数
     *
     * @param str
     * @param fun
     * @return
     */
    public static Integer method(String str, Function<String, Integer> fun) {
        return fun.apply(str);
    }
}

package org.thor.javademo.functioninterface.demo07.function;

import java.util.function.Function;

/**
 * @Description:Function接口中的默认方法andThen：用来进行组合操作 需求：
 * 1.String类型转为Integer类型，把转换后结果加10
 * 2.Integer类型的数据，转换为String类型
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午4:22
 * @Version: V1.0
 */
public class Demo02FunctionAndThen {
    public static void main(String[] args) {
        String numStr = "123";
        String result = method(numStr,
                val -> Integer.parseInt(val) + 10,
                val -> String.valueOf(val));
        System.out.println("返回结果：" + result);
    }

    /**
     * 转换方法
     *
     * @param str  字符串类型的证书上
     * @param fun1 Function<String,Integer>
     * @param fun2 Function<Integer,String>
     * @return
     */
    public static String method(String str, Function<String, Integer> fun1, Function<Integer, String> fun2) {
        return fun1.andThen(fun2).apply(str);
    }
}

package org.thor.javademo.functioninterface.demo07.function;

import java.util.function.Function;

/**
 * @Description: 使用 Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
 * 1. 将字符串截取数字年龄部分，得到字符串；
 * 2. 将上一步的字符串转换成为int类型的数字；
 * 3. 将上一步的int数字累加100，得到结果int数字。
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午4:31
 * @Version: V1.0
 */
public class Demo03FunctionTest {
    public static void main(String[] args) {
        String str = "赵丽颖,20";
        int result = method(str,
                val -> val.split(",")[1],
                val -> Integer.valueOf(val),
                val -> val + 100);
        System.out.println("result: " + result);
    }

    /**
     * 执行方法
     *
     * @param str
     * @param fun1
     * @param fun2
     * @param fun3
     * @return
     */
    public static int method(String str, Function<String, String> fun1, Function<String, Integer> fun2, Function<Integer,
            Integer> fun3) {
        return fun1.andThen(fun2).andThen(fun3).apply(str);
    }
}

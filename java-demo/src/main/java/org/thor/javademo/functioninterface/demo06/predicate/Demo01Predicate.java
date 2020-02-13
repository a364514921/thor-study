package org.thor.javademo.functioninterface.demo06.predicate;

import java.util.function.Predicate;

/**
 * @Description:对某种数据类型的数据进行判断，结果返回一个boolean
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午2:57
 * @Version: V1.0
 */
public class Demo01Predicate {
    public static void main(String[] args) {
        String str = "abcde";
        boolean result = method(str, s -> s.length() > 5);
        System.out.println("result: " + result);
    }

    /**
     * 参数传递一个String类型字符串
     *
     * @param str 字符串
     * @param pre Predicate函数式皆苦
     * @return 判断结果
     */
    public static boolean method(String str, Predicate<String> pre) {
        return pre.test(str);
    }
}

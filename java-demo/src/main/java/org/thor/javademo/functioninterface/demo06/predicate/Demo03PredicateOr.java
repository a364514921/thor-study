package org.thor.javademo.functioninterface.demo06.predicate;

import java.util.function.Predicate;

/**
 * @Description:可以连接多个判断条件：或or -> ||
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午3:27
 * @Version: V1.0
 */
public class Demo03PredicateOr {
    public static void main(String[] args) {
        String val = "abcdee";
        boolean result = method(val,
                str -> str.length() > 5,
                str -> str.contains("g"));
        System.out.println("predicate判断结果：" + result);
    }

    public static boolean method(String str, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.or(pre2).test(str);
    }
}

package org.thor.javademo.functioninterface.demo06.predicate;

import java.util.function.Predicate;

/**
 * @Description:可以连接多个判断条件：取反 -> ！
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午3:27
 * @Version: V1.0
 */
public class Demo04PredicateNegate {
    public static void main(String[] args) {
        String val = "abcdee";
        boolean result = method(val,
                (str) -> str.length() > 5);

        System.out.println("predicate判断结果：" + result);
    }

    public static boolean method(String str, Predicate<String> pre) {
        return pre.negate().test(str);
    }
}

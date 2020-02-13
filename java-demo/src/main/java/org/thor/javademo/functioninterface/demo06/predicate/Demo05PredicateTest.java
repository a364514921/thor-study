package org.thor.javademo.functioninterface.demo06.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description: 数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到集合 ArrayList 中，
 * 需要同时满足两个条件： 1. 必须为女生； 2. 姓名为4个字。
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午3:45
 * @Version: V1.0
 */
public class Demo05PredicateTest {
    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男", "赵丽颖,女"};
        List<String> arrList = new ArrayList<>();

        for (String s : array) {
            String[] strArr = s.split(",");
            boolean result = method(s,
                    str -> "女".equals(strArr[1]),
                    str -> strArr[0].length() == 4
            );

            if (result) {
                arrList.add(s);
            }
        }

        System.out.println(arrList);
    }

    public static boolean method(String str, Predicate<String> pre1, Predicate<String> pre2) {
        return pre1.and(pre2).test(str);
    }
}

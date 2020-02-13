package org.thor.javademo.functioninterface.demo03.lambdaTest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description: 如果一个方法的返回值类型是一个函数式接口，那么就可以直接返回一个Lambda表达式。
 * 当需要通过一 个方法来获取一个 java.util.Comparator 接口类型的对象作为排序器时,就可以调该方法获取。
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午12:50
 * @Version: V1.0
 */
public class Demo02LambdaSort {
    public static void main(String[] args) {
        // 创建字符串数组
        String[] arr = new String[]{"aaa", "b", "cccc", "ddddddd"};
        // 输出排序前数组
        System.out.println(Arrays.toString(arr));
        // 调用Arrays中sort方法，对字符串进行排序
        Arrays.sort(arr, getComparator());
        // 输出排序后的数组
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 方法的返回值类型使用函数式接口Comparator
     *
     * @return
     */
    public static Comparator<String> getComparator() {
        // 方法的返回类型是一个接口，那么我们可以返回这个接口的匿名内部类
//        return new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                // 按字符串的降序排序
//                return o2.length() - o1.length();
//            }
//        };

        // 方法的返回类型是一个函数式接口，那么我们可以返回Lambda表达式
//        return (String o1,String o2) -> {
//            // 按字符串的降序排序
//           return   o2.length() - o1.length();
//        };

        // 优化Lambda表达式
        return (o1, o2) -> o2.length() - o1.length();
    }
}

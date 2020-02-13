package org.thor.javademo.functioninterface.demo04.supplier;

import cn.hutool.core.util.NumberUtil;

import java.util.function.Supplier;

/**
 * @Description:练习：求数组元素最大值 使用Supplier接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午1:42
 * @Version: V1.0
 */
public class Demo02Supplier {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 3, 8};

        int max = getMax(() -> NumberUtil.max(arr));

        System.out.println("max:[" + max + "]");
    }

    /**
     * 求数组中最大值
     *
     * @param sup
     */
    public static int getMax(Supplier<Integer> sup) {
       return sup.get();
    }
}

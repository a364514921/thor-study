package org.thor.javademo.stream.demo09.ArrayMethodReference;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午9:24
 * @Version: V1.0
 */
public class Demo09ArrayMethodReference {
    public static void main(String[] args) {
        int[] arr1 = method(3, (len) -> {
            return new int[len];
        });
        System.out.println(arr1.length);

        int[] arr2 = method(3, int[]::new);
        System.out.println(arr2.length);
    }

    public static int[] method(int len, ArrayBuilder arrayBuilder) {
        return arrayBuilder.buildArr(len);
    }
}

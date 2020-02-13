package org.thor.javademo.stream.demo05.StaticMethodReference;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午8:38
 * @Version: V1.0
 */
public class Demo01StaticMethodReference {
    public static void main(String[] args) {
        int abs = method(-10, num -> {
            return Math.abs(num);
        });
        System.out.println(abs);

        int abs1 = method(-10, Math::abs);
        System.out.println(abs1);
    }

    public static int method(int num, Calcable cal) {
        return cal.calcAbs(num);
    }
}

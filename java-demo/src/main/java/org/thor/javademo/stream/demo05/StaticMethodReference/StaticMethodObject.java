package org.thor.javademo.stream.demo05.StaticMethodReference;

/**
 * @Description: 通过类名引用静态成员方法
 * 类已经存在，静态成员方法也已经存在
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午8:28
 * @Version: V1.0
 */
public class StaticMethodObject {

    public static int method(int num, Calcable calc) {
        return calc.calcAbs(num);
    }
}

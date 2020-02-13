package org.thor.javademo.stream.demo04.ObjectMethodReference;

/**
 * @Description:打印函数式接口
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午7:52
 * @Version: V1.0
 */
@FunctionalInterface
public interface Printable {
    /**
     * 打印字符串的抽象方法
     * @param str 字符串
     */
    public abstract void print(String str);
}

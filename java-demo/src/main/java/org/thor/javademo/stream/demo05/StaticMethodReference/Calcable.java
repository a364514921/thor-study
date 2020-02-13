package org.thor.javademo.stream.demo05.StaticMethodReference;

/**
 * @Description:
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午8:27
 * @Version: V1.0
 */
@FunctionalInterface
public interface Calcable {
    /**
     * 抽象计算方法，对整数进行绝对值计算
     * @param num
     * @return
     */
    public abstract int calcAbs(int num);
}

package org.thor.javademo.stream.demo09.ArrayMethodReference;

/**
 * @Description:数组的函数式接口
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午9:22
 * @Version: V1.0
 */
@FunctionalInterface
public interface ArrayBuilder {

    /**
     * 创建int类型数组的方法，参数传递数组的长度
     */
    int[] buildArr(int length);
}

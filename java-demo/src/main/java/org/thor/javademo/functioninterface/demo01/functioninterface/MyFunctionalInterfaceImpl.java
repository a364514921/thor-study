package org.thor.javademo.functioninterface.demo01.functioninterface;

/**
 * @Description:自定义函数式接口实现类
 * @Author: wangyiqiang
 * @Date: 2020-02-04 上午11:35
 * @Version: V1.0
 */
public class MyFunctionalInterfaceImpl implements MyFunctionalInterface {
    @Override
    public void method() {
        System.out.println("自定义函数式接口实现类:MyFunctionalInterfaceImpl...");
    }
}

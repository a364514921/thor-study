package org.thor.javademo.functioninterface.demo01.functioninterface;

/**
 * @Description:函数式接口：有且只有一个抽象方法的借口，称之为函数式接口
 * 接口中可以包含其他的方法（默认静态、私有）
 * @FunctionalInterface作用：检测接口是否是一个函数式接口 是->编译成功 否->编译失败（接口中没有抽象方法或个数多余1个）
 * @Author: wangyiqiang
 * @Date: 2020-02-04 上午11:18
 * @Version: V1.0
 */
@FunctionalInterface
public interface MyFunctionalInterface {

    /**
     * 默认抽象方法
     */
    public abstract void method();

    /**
     * 其他方法
     */
//    public void method2();

}

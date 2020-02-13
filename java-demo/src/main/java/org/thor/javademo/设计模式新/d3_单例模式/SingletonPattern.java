package org.thor.javademo.设计模式新.d3_单例模式;

/**
 * @Description:通用单例模式
 * @Author: wangyiqiang
 * @Date: 2019-11-17 13:49
 * @Version: V1.0
 */
public class SingletonPattern {
    private static final SingletonPattern singletonPattern = new SingletonPattern();

    //限制住不能直接产生一个实例
    private SingletonPattern() {
    }

    public synchronized static SingletonPattern getInstance() {
        return singletonPattern;
    }

}

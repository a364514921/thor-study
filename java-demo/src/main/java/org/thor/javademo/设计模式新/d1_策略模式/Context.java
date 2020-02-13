package org.thor.javademo.设计模式新.d1_策略模式;

/**
 * @Description:三个妙计是有了，那需要有个地方放这些妙计呀，放锦囊
 * @Author: wangyiqiang
 * @Date: 2019-11-17 12:23
 * @Version: V1.0
 */
public class Context {

    private IStrategy strategy;

    /**
     * 构造函数，你要使用那个妙计
     */
    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 使用计谋，看我出招了
     */
    public void operate() {
        this.strategy.operate();
    }
}

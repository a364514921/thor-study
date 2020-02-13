package org.thor.javademo.设计模式新.d1_策略模式;

/**
 * @Description:孙 人断后，挡住追兵
 * @Author: wangyiqiang
 * @Date: 2019-11-17 12:23
 * @Version: V1.0
 */
public class BlockEnemy implements IStrategy {
    @Override
    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}

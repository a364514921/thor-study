package org.thor.javademo.设计模式新.d1_策略模式;

/**
 * @Description:首先定一个策略接口，这是诸葛亮老人家给赵云的三个锦囊妙计的接口
 * @Author: wangyiqiang
 * @Date: 2019-11-17 12:19
 * @Version: V1.0
 */
public interface IStrategy {

    /**
     * 每个锦囊妙计都是一个可执行的算法
     */
    public void operate();

}

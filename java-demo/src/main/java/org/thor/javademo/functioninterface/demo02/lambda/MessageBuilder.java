package org.thor.javademo.functioninterface.demo02.lambda;

/**
 * @Description:拼接消息的抽象方法
 * @Author: wangyiqiang
 * @Date: 2020-02-04 下午12:17
 * @Version: V1.0
 */
@FunctionalInterface
public interface MessageBuilder {

    /**
     * 拼接消息方法
     * @return msg 拼接口的消息
     */
    public abstract String buildMsg();

}

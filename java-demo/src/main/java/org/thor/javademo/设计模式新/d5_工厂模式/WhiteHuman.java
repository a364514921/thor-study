package org.thor.javademo.设计模式新.d5_工厂模式;

/**
 * @Description:白种人
 * @Author: wangyiqiang
 * @Date: 2019-11-17 14:55
 * @Version: V1.0
 */
public class WhiteHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("白种人会笑！");
    }

    @Override
    public void cry() {
        System.out.println("白种人会哭！");
    }

    @Override
    public void talk() {
        System.out.println("白种人会说话！");
    }
}

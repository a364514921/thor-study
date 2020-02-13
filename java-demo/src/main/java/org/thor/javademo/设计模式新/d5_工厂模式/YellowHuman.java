package org.thor.javademo.设计模式新.d5_工厂模式;

/**
 * @Description:黄种人
 * @Author: wangyiqiang
 * @Date: 2019-11-17 14:53
 * @Version: V1.0
 */
public class YellowHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黄种人会笑！");
    }

    @Override
    public void cry() {
        System.out.println("黄种人会哭！");
    }

    @Override
    public void talk() {
        System.out.println("黄种人会说话！");
    }
}

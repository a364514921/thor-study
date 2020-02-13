package org.thor.javademo.设计模式新.d5_工厂模式;

/**
 * @Description:黑种人
 * @Author: wangyiqiang
 * @Date: 2019-11-17 14:57
 * @Version: V1.0
 */
public class BlackHuman implements Human {
    @Override
    public void laugh() {
        System.out.println("黑人会笑！");
    }

    @Override
    public void cry() {
        System.out.println("黑人会哭！");
    }

    @Override
    public void talk() {
        System.out.println("黑人会说话！");
    }
}

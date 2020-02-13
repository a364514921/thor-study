package org.thor.javademo.设计模式新.d1_策略模式;

/**
 * @Description:找乔国老帮忙，使孙权不能杀刘备
 * @Author: wangyiqiang
 * @Date: 2019-11-17 12:21
 * @Version: V1.0
 */
public class BackDoor implements IStrategy {

    @Override
    public void operate() {
        System.out.println("找乔国老帮忙，让吴国 给孙权施加压力");
    }

}

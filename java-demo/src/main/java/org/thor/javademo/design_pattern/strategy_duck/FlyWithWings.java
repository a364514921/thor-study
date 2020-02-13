package org.thor.javademo.design_pattern.strategy_duck;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.strategy_duck
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2019-03-29 下午8:38
 * 系统版本：1.0.0
 **/

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我要飞拉。。。");
    }
}

package org.thor.javademo.design_pattern.strategy_duck;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.strategy_duck
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2019-03-29 下午9:02
 * 系统版本：1.0.0
 **/

public class MuteDuck extends Duck {
    @Override
    public void display() {
        System.out.println("我是一只不会叫的鸭子");
    }
}

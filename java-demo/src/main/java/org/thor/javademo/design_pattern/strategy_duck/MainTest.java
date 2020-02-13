package org.thor.javademo.design_pattern.strategy_duck;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.strategy_duck
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2019-03-29 下午8:45
 * 系统版本：1.0.0
 **/

public class MainTest {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
        duck.display();
        duck.swim();

        System.out.println("---------------------");

        Duck muteDuck = new MuteDuck();
        muteDuck.setFlyBehavior(new FlyNoWay());
        muteDuck.setQuackBehavior(new MuteQuack());

        muteDuck.performFly();
        muteDuck.performQuack();
        muteDuck.display();
        muteDuck.swim();

        System.out.println("---------------------");

        Duck duck2 = new MuteDuck();
        duck2.setFlyBehavior(new FlyNoWay());
        duck2.setQuackBehavior(new Squeak());
        duck2.performFly();
        duck2.performQuack();
        duck2.display();
        duck2.swim();
    }
}

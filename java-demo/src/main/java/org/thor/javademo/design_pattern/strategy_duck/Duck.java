package org.thor.javademo.design_pattern.strategy_duck;

/**
 * 模块名称：StudyJava com.wyq.studyjava.design_pattern.strategy_duck
 * 功能说明：<br>
 * 开发人员：wangyiqiang
 * 创建时间： 2019-03-29 下午8:34
 * 系统版本：1.0.0
 **/

public abstract class Duck {
    FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim() {
        System.out.println("所有鸭子都会游泳。。。");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}

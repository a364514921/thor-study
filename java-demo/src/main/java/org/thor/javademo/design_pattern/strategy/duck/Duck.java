package org.thor.javademo.design_pattern.strategy.duck;


import org.thor.javademo.design_pattern.strategy.flybehavior.FlyBehavior;
import org.thor.javademo.design_pattern.strategy.quackbehavior.QuackBehavior;

public abstract class Duck {

    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;

    public Duck() {

    }

    public void fly() {
        mFlyBehavior.fly();
    }

    public void quack() {
        mQuackBehavior.quack();
    }

    public abstract void display();


    public void swim() {
        System.out.println("~~im swim~~");
    }

    public void SetQuackBehavoir(QuackBehavior qb) {
        mQuackBehavior = qb;
    }

    public void SetFlyBehavoir(FlyBehavior fb) {
        mFlyBehavior = fb;
    }
}

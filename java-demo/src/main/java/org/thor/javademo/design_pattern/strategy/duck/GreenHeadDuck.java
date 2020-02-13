package org.thor.javademo.design_pattern.strategy.duck;


import org.thor.javademo.design_pattern.strategy.flybehavior.GoodFlyBehavior;
import org.thor.javademo.design_pattern.strategy.quackbehavior.GaGaQuackBehavior;

public class GreenHeadDuck extends Duck {

    public GreenHeadDuck() {
        mFlyBehavior = new GoodFlyBehavior();
        mQuackBehavior = new GaGaQuackBehavior();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        System.out.println("**GreenHead**");
    }

}
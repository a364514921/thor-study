package org.thor.javademo.design_pattern.strategy.oo;

public class GreenHeadDuck extends Duck {

    @Override
    public void display() {
        System.out.println("**GreenHead**");
    }


    @Override
    public void fly() {
        System.out.println("~~no fly~~");
    }


}

package org.thor.javademo.design_pattern.strategy.oo;

public class StoneDuck extends Duck {

    @Override
    public void display() {
        System.out.println("**StoneDuck**");
    }

    @Override
    public void quack() {
        System.out.println("~~no gaga~~");
    }

    @Override
    public void swim() {
        System.out.println("~~no swim~~");
    }

    @Override
    public void fly() {
        System.out.println("~~no fly~~");
    }
}

package org.thor.javademo.design_pattern.strategy.duck;


import org.thor.javademo.design_pattern.strategy.flybehavior.BadFlyBehavior;
import org.thor.javademo.design_pattern.strategy.quackbehavior.GeGeQuackBehavior;

public class RedHeadDuck extends Duck {

	public RedHeadDuck() {
		mFlyBehavior = new BadFlyBehavior();
		mQuackBehavior = new GeGeQuackBehavior();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("**RedHead**");
	}

}

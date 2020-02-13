package org.thor.javademo.design_pattern.strategy;


import org.thor.javademo.design_pattern.strategy.duck.Duck;
import org.thor.javademo.design_pattern.strategy.duck.GreenHeadDuck;
import org.thor.javademo.design_pattern.strategy.duck.RedHeadDuck;
import org.thor.javademo.design_pattern.strategy.flybehavior.NoFlyBehavior;
import org.thor.javademo.design_pattern.strategy.quackbehavior.NoQuackBehavior;

public class StimulateDuck {

	public static void main(String[] args) {

		Duck mGreenHeadDuck = new GreenHeadDuck();
		Duck mRedHeadDuck = new RedHeadDuck();

		mGreenHeadDuck.display();
		mGreenHeadDuck.fly();
		mGreenHeadDuck.quack();
		mGreenHeadDuck.swim();

		mRedHeadDuck.display();
		mRedHeadDuck.fly();
		mRedHeadDuck.quack();
		mRedHeadDuck.swim();
		mRedHeadDuck.display();
		mRedHeadDuck.SetFlyBehavoir(new NoFlyBehavior());
		mRedHeadDuck.fly();
		mRedHeadDuck.SetQuackBehavoir(new NoQuackBehavior());
		mRedHeadDuck.quack();
	}

}

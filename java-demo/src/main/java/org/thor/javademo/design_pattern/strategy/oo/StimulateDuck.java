package org.thor.javademo.design_pattern.strategy.oo;



public class StimulateDuck {

	public static void main(String[] args) {

		GreenHeadDuck mGreenHeadDuck = new GreenHeadDuck();
		RedHeadDuck mRedHeadDuck = new RedHeadDuck();

		mGreenHeadDuck.display();
		mGreenHeadDuck.fly();
		mGreenHeadDuck.quack();
		mGreenHeadDuck.swim();

		mRedHeadDuck.display();
		
		mRedHeadDuck.quack();
		mRedHeadDuck.swim();
		mRedHeadDuck.fly();
		
		
	
	//	mGreenHeadDuck.Fly();
		//mRedHeadDuck.Fly();
	}

}

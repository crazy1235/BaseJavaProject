package com.jacksen.java.designpattern.builder;

/**
 * 
 * @author Admin
 *
 */
public class Woman extends Person {

	@Override
	protected void buildHead() {
		System.out.println("女人-->头");
	}

	@Override
	protected void buildBody() {
		System.out.println("女人-->身体");
	}

	@Override
	protected void buildLeftArm() {
		System.out.println("女人-->左胳膊");
	}

	@Override
	protected void buildRightArm() {
		System.out.println("女人-->右胳膊");
	}

	@Override
	protected void buildLeftLeg() {
		System.out.println("女人-->左腿");
	}

	@Override
	protected void buildRightLeg() {
		System.out.println("女人-->右腿");
	}
}

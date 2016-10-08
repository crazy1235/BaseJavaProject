package com.jacksen.java.designpattern.builder;

import java.util.ArrayList;

/**
 * 人的抽象类
 * 
 * @author Admin
 * 
 */
public abstract class Person {

	// Person包含的部位
	private ArrayList<String> sequence = new ArrayList<>();

	public void setSequence(ArrayList<String> sequence) {
		this.sequence = sequence;
	}

	protected abstract void buildHead();

	protected abstract void buildBody();

	protected abstract void buildLeftArm();

	protected abstract void buildRightArm();

	protected abstract void buildLeftLeg();

	protected abstract void buildRightLeg();

	//
	public void buildOk() {
		for (int i = 0; i < sequence.size(); i++) {
			String action = this.sequence.get(i);
			if (action.equalsIgnoreCase("head")) {
				this.buildHead();
			} else if (action.equalsIgnoreCase("body")) {
				this.buildBody();
			} else if (action.equalsIgnoreCase("leftArm")) {
				this.buildLeftArm();
			} else if (action.equalsIgnoreCase("rightArm")) {
				this.buildRightArm();
			} else if (action.equalsIgnoreCase("leftLeg")) {
				this.buildLeftLeg();
			} else if (action.equalsIgnoreCase("rightLeg")) {
				this.buildRightLeg();
			}
		}
	}

}

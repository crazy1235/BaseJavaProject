package com.jacksen.java.designpattern.builder;

import java.util.ArrayList;

public class WomanBuilder extends PersonBuilder{

	private Woman woman = new Woman();
	
	@Override
	public Person buildPerson() {
		return this.woman;
	}

	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.woman.setSequence(sequence);
	}

}

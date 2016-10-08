package com.jacksen.java.designpattern.builder;

import java.util.ArrayList;

public class ManBuilder extends PersonBuilder {

	private Man man = new Man();

	@Override
	public Person buildPerson() {
		return this.man;
	}

	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.man.setSequence(sequence);
	}

}

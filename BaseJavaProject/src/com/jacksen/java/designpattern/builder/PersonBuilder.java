package com.jacksen.java.designpattern.builder;

import java.util.ArrayList;

/**
 * 
 * @author Admin
 * 
 */
public abstract class PersonBuilder {

	public abstract void setSequence(ArrayList<String> sequence);
	
	public abstract Person buildPerson();
}

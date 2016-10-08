package com.jacksen.java.designpattern.builder;

import java.util.ArrayList;

/**
 * Director类，负责构造Person
 * 
 * @author Admin
 * 
 */
public class Nuwa {

	private ArrayList<String> sequence = new ArrayList<>();

	private PersonBuilder builder;

	public Nuwa(PersonBuilder builder) {
		this.builder = builder;
	}

	/**
	 * 设置人的组成部分
	 * 
	 * @param part
	 */
	public void setParts(String... part) {
		sequence.clear();
		for (int i = 0; i < part.length; i++) {
			sequence.add(part[i]);
		}
		builder.setSequence(sequence);
	}

	/**
	 * 创造一个人类
	 */
	public void createPerson() {
		builder.buildPerson().buildOk();
	}

}

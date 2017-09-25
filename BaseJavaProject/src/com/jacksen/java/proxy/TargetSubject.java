package com.jacksen.java.proxy;

public class TargetSubject implements ISubject{

	@Override
	public void saySth() {
		System.out.println("hello world!");
	}

}

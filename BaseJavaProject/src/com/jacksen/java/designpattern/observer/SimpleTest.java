package com.jacksen.java.designpattern.observer;

public class SimpleTest {
	public static void main(String[] args) {
		SimpleObservable observable = new SimpleObservable();
		
		new OtherObserver(observable);
		new SimpleObserver(observable);
		
		observable.setData(1);
		observable.setData(2);
		observable.setData(2);
		observable.setData(4);
	}
}

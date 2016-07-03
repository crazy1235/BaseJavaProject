package com.jacksen.java.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者2号
 * @author Admin
 *
 */
public class OtherObserver implements Observer{
	
	public OtherObserver(SimpleObservable observable){
		observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("OtherObserver: " + ((SimpleObservable)o).getData() + " -- " + (String)arg);
	}
}

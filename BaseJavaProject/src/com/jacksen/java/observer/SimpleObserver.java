package com.jacksen.java.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * π€≤Ï’ﬂ1∫≈
 * 
 * @author Admin
 * 
 */
public class SimpleObserver implements Observer {

	public SimpleObserver(SimpleObservable simpleObservable) {
		simpleObservable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("SimpleObserver: " + ((SimpleObservable) o).getData() + " -- " + (String)arg);
	}
}

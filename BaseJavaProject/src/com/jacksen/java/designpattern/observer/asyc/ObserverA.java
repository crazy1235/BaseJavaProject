package com.jacksen.java.designpattern.observer.asyc;

/**
 * 观察者A
 * 
 * @author Admin
 * 
 */
public class ObserverA implements AsyncObserver {

	@Override
	public void update(AsyncObservable o, Object arg) {
		System.out.println("ObserverA -- " + ((AObservable) o).getMyWord()
				+ " -- " + (String) arg);
	}

}

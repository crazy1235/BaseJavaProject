package com.jacksen.java.designpattern.observer.asyc;

public class ObserverC implements AsyncObserver{

	@Override
	public void update(AsyncObservable o, Object arg) {
		System.out.println("ObserverC -- " + ((AObservable) o).getMyWord()
				+ " -- " + (String) arg);
	}

}

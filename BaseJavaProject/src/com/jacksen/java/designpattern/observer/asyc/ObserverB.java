package com.jacksen.java.designpattern.observer.asyc;

public class ObserverB implements AsyncObserver{

	@Override
	public void update(AsyncObservable o, Object arg) {
		System.out.println("ObserverB -- " + ((AObservable) o).getMyWord()
				+ " -- " + (String) arg);
	}

}

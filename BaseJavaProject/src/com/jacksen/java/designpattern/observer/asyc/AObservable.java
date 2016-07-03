package com.jacksen.java.designpattern.observer.asyc;

public class AObservable extends AsyncObservable {

	private String str = "i think ";

	private String target;

	public void setTarget(String target) {
		this.target = target;

		setChanged();

		notifyObservers(target);
	}

	public String getMyWord() {
		return str + target;
	}

}

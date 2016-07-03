package com.jacksen.java.designpattern.observer.asyc;

public class Test {
	public static void main(String[] args) {

		AObservable observable = new AObservable();

		ObserverA observerA = new ObserverA();

		ObserverB observerB = new ObserverB();

		ObserverC observerC = new ObserverC();

		observable.addObserver(observerA);
		observable.addObserver(observerB);
		observable.addObserver(observerC);
		for (int i = 0; i < 10; i++) {
			observable.addObserver(new AsyncObserver() {

				@Override
				public void update(AsyncObservable o, Object arg) {
					System.out.println("hahahaha");
				}
			});
		}

		observable.setTarget("jingjing");
	}
}

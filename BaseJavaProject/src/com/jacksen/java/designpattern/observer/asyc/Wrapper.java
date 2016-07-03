package com.jacksen.java.designpattern.observer.asyc;

/**
 * 观察者的包装类
 * 
 * @author Admin
 * 
 */
public class Wrapper {

	private AsyncObserver observer;

	public Wrapper(AsyncObserver o) {
		this.observer = o;
	}

	public AsyncObserver getAsyncObserver() {
		return observer;
	}

	/**
	 * 
	 * @param observable
	 * @param o
	 */
	public void update(AsyncObservable observable, Object o) {
		new Handler(observable, o).start();
	}

	class Handler extends Thread {

		AsyncObservable observable;
		Object object;

		public Handler(AsyncObservable observable, Object o) {
			this.observable = observable;
			this.object = o;
		}

		@Override
		public void run() {
			observer.update(observable, object);
		}
	}
}
